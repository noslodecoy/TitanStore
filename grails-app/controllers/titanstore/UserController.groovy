package titanstore


class UserController {
 
    def index() { }
    
    def login( LoginCommand cmd ) {
      if ( cmd.validate() ) {
        session.user = cmd.getUser()
        redirect controller: "store"
        return [ cmd ]
      } else {
        render view: "/store/index"
        return [ cmd ]
      }
    }
    
    def register() {
      if ( request.method == 'POST' ) {
        def user = new User( params )
        if ( user.password != params.confirm ) {
          //user.errors.reject( 'user.password.doesnotmatch', ['password', 'class User'] as Object[], '[Property [{0}] of class [{1}] does not match confirmation]')
          user.errors.rejectValue( 'password', 'user.password.doesnotmatch' )
          return [ user: user ]
        } else {
          if ( user.save() ) {
            session.user = user;
            redirect controller: "store"
          } else {
            return [ user: user ]
          }
        }
      }
    }
}

public class LoginCommand {
  String login
  String password
  private user

  
  User getUser() {
    if ( !user && login ) {
      user = User.findByLogin( login, [ fetch: [purchasedSongs: 'join' ] ] )
    }
    return user
  }
  static constraints = {
    login blank: false, validator: { val, obj ->
      if ( !obj.getUser() )
        return "user.not.found"
    }
    password blank: false, validator: { val, obj ->
      if ( obj.user && obj.user.password != val )
        return "user.password.invalid"
    }
  }
  
}