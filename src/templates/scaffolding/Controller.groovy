<%=packageName ? "package ${packageName}\n\n" : ''%>import org.springframework.dao.DataIntegrityViolationException

class ${className}Controller {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
	    if ( session.user?.isAdmin() ) {
        redirect(action: "list", params: params)
			} else {
      redirect controller: "store"
    }
    }

    def list(Integer max) {
	    if ( session.user?.isAdmin() ) {
        params.max = Math.min(max ?: 10, 100)
        [${propertyName}List: ${className}.list(params), ${propertyName}Total: ${className}.count()]
			} else {
				redirect controller: "store"
			}
    }

    def create() {
	    if ( session.user?.isAdmin() ) {
        [${propertyName}: new ${className}(params)]
			} else {
      redirect controller: "store"
    }
    }

    def save() {
	    if ( session.user?.isAdmin() ) {
        def ${propertyName} = new ${className}(params)
        if (!${propertyName}.save(flush: true)) {
            render(view: "create", model: [${propertyName}: ${propertyName}])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
        redirect(action: "show", id: ${propertyName}.id)
			} else {
      redirect controller: "store"
    }
    }

    def show(Long id) {
	    if ( session.user?.isAdmin() ) {
        def ${propertyName} = ${className}.get(id)
        if (!${propertyName}) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), id])
            redirect(action: "list")
            return
        }

        [${propertyName}: ${propertyName}]
			} else {
      redirect controller: "store"
    }
    }

    def edit(Long id) {
			    if ( session.user?.isAdmin() ) {

        def ${propertyName} = ${className}.get(id)
        if (!${propertyName}) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), id])
            redirect(action: "list")
            return
        }

        [${propertyName}: ${propertyName}]
			} else {
      redirect controller: "store"
    }
    }

    def update(Long id, Long version) {
			    if ( session.user?.isAdmin() ) {

        def ${propertyName} = ${className}.get(id)
        if (!${propertyName}) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (${propertyName}.version > version) {<% def lowerCaseName = grails.util.GrailsNameUtils.getPropertyName(className) %>
                ${propertyName}.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: '${domainClass.propertyName}.label', default: '${className}')] as Object[],
                          "Another user has updated this ${className} while you were editing")
                render(view: "edit", model: [${propertyName}: ${propertyName}])
                return
            }
        }

        ${propertyName}.properties = params

        if (!${propertyName}.save(flush: true)) {
            render(view: "edit", model: [${propertyName}: ${propertyName}])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
        redirect(action: "show", id: ${propertyName}.id)
			} else {
      redirect controller: "store"
    }
    }

    def delete(Long id) {
	    if ( session.user?.isAdmin() ) {
        def ${propertyName} = ${className}.get(id)
        if (!${propertyName}) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), id])
            redirect(action: "list")
            return
        }

        try {
            ${propertyName}.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), id])
            redirect(action: "show", id: id)
        }
			} else {
      redirect controller: "store"
    }
    }
}
