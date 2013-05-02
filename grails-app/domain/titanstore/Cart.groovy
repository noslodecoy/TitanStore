package titanstore

class Cart {

    static hasMany = [ items : CartItem ]
    float total;

    static belongsTo = [ user: User ]

    Cart() {
      items = [ ]
    }

    static constraints = {
      total(blank:false, scale:2)
      items(blank:false)
    }
    
    /*def addItem( StoreItem item ) {
      items.add( item )
    }*/
    
    def addAlbum( Album album ) {
      CartItem crtItm = new CartItem( album )
      items.add( crtItm )
    }

    def removeAlbum( Album album ) {
      def cartItem = items.find { it.title == 'Me Against The World' }
      items.remove( cartItem )
    }
    
    def getAllItems() {
      return items;
    }
    
    /*def addSong( Song song ) {
      items.add( song )
    }*/

}