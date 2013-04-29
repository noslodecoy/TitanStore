package titanstore

class Cart {

    static hasMany = [ items : StoreItem ]
    float total;
    
    User user;


    Cart() {
      def items = [ ]
    }
    
    static constraints = {
      total(blank:false, scale:2)
      items(blank:false)
    }
    
    /*def addItem( StoreItem item ) {
      items.add( item )
    }*/
    
    def addAlbum( Album album ) {          
      items.add( album )
    }

    def removeAlbum( Album album ) {          
      items.remove( album )
    }
    
    /*def addSong( Song song ) {
      items.add( song )
    }*/

}