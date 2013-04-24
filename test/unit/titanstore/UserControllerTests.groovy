package titanstore

import grails.test.mixin.*
import grails.test.mixin.web.ControllerUnitTestMixin

@TestMixin(ControllerUnitTestMixin)
@TestFor( UserController )
@Mock( User )
class UserControllerTests {
  
    void testPasswordsMatch() {
      request.method = 'POST'
      
      params.login = 'joeblogs'
      params.password = 'password'
      params.confirm = 'different'
      params.firstName = 'Joe'
      params.lastName = 'Blogs'
      
      def model = controller.register( )

      assert model
      def user = model.user
      assert user.hasErrors()
      assertEquals "user.password.doesnotmatch", user.errors.getFieldError("password").code
    }
    
    void testRegistrationFailed() {
      request.method = 'POST'
      
      params.login = ''
      def model = controller.register()
      
      assertNull session.user
      assert model
      def user = model.user
      assert user.hasErrors()
      assertEquals 'blank', user.errors.getFieldError("login").code
      assertEquals 'nullable', user.errors.getFieldError("password").code
      assertEquals 'nullable', user.errors.getFieldError("firstName").code
      assertEquals 'nullable', user.errors.getFieldError("lastName").code
    }
    
    void testRegistrationSuccess() {
      request.method = 'POST'
      
      params.login = 'joeblogs'
      params.password = 'password'
      params.confirm = 'password'
      params.firstName = 'Joe'
      params.lastName = 'Blogs'
      
      def model = controller.register()
      assertEquals '/store', response.redirectedUrl
      assertNotNull session.user
    }
    
    void testLoginUserNotFound() {
      mockForConstraintsTests( LoginCommand  )
      LoginCommand cmd = new LoginCommand( )
      cmd.login = "fred"
      cmd.password = "letmein"
      cmd.validate()
      def errors = cmd.errors
      controller.login( cmd )

      assertTrue cmd.hasErrors()
      assertEquals "user.not.found", errors.login
      assertEquals "/store/index", view
    }

    void testLoginPasswordInvalid() {
      request.method = 'POST'
      def newUser = new User( login: "fredd", password: "realpassword", firstName: "Fred", lastName: "Person" )
      newUser.save( flush: true, failOnError: true )
      
      mockForConstraintsTests( LoginCommand  )
      def cmd = new LoginCommand( login: "fredd", password: "letmein" )
      cmd.validate()
      controller.login( cmd )
      def errors = cmd.errors
      assertTrue cmd.hasErrors()
      
      assertEquals "user.password.invalid", errors.getFieldError("password").code
      assertEquals "/store/index", view
    }
   
    void testLoginSuccess() {
      request.method = 'POST'
      def newUser = new User( login: "fredd", password: "letmein", firstName: "Fred", lastName: "Person" )
      newUser.save( flush: true, failOnError: true )

      mockForConstraintsTests( LoginCommand  )
      def cmd = new LoginCommand( login: "fredd", password: "letmein" )
      cmd.validate()
      controller.login( cmd )
      def errors = cmd.errors
      assertFalse cmd.hasErrors()

      assertNotNull session.user
      assertEquals "/store", response.redirectedUrl
    }
  
}


