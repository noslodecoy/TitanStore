package titanstore

class User {

  	String login;
		String password;
		String firstName;
    String lastName;
    boolean admin;
    
    Cart cart;
		static hasMany = [ purchasedSongs: Song ];
    
    def User = {
      admin = false;
    }
  
    static constraints = {
 			login( blank: false, size: 5..15, unique: true )
			password( blank: false, size: 5..15 )
      firstName( blank: false )
      lastName( blank: false )
      cart( nullable: true )
    }
    
    def isAmin = {
      return admin;
    }

    def makeAdmin = {
      admin = true;
      merge()
    }
    
    
    def getUserCart() {
      if ( !cart ) {
        cart = new Cart();
        cart.save();
      }
      return cart;
    }
  
}
