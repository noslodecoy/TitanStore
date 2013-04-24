package titanstore

class Cart {

    static hasMany = [ items : StoreItem ]

    Cart() {
      items = [ ]
    }
    
    static constraints = {
    }
    
    def addItem( StoreItem item ) {
      items.add( item )
    }
    
    def addAlbum( Album album ) {          
      items.add( album )
    }

    def removeAlbum( Album album ) {          
      items.remove( album )
    }
    
    def addSong( Song song ) {
      items.add( song )
    }

}