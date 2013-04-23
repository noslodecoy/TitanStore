package titanstore

class User {

  	String login;
		String password;
		String firstName;
    String lastName;
    
		static hasMany = [ purchasedSongs: Song ];

    static constraints = {
 			login( blank: false, size: 5..15, unique: true )
			password( blank: false, size: 5..15 )
      firstName( blank: false )
      lastName( blank: false )
    }
}
