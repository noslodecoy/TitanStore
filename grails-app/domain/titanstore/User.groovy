package titanstore

class User {

  	String login;
		String password;
		String firstName;
    String lastName;
    boolean admin;
    
    static hasOne = [ cart: Cart ]
		static hasMany = [ purchasedSongs: Song ];
    
    def User = {
      admin = false;
    }
  

    static constraints = {
 			login( blank: false, size: 5..15, unique: true )
			password( blank: false, size: 5..15 )
      firstName( blank: false )
      lastName( blank: false )
    }
    
    def isAmin = {
      return admin;
    }

    def makeAdmin = {
      admin = true;
    }
  
}
