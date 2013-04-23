package titanstore

class Cart {

    static hasMany = [ albums : Album ]

    Cart() {
      albums = [ ]
    }
    
    static constraints = {
    }
    
    def addAlbum( Album album ) {          
      albums.add( album )
    }

    def removeAlbum( Album album ) {          
      albums.remove( album )
    }

}