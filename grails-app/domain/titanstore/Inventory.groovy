package titanstore

class Inventory {
  
    static hasMany = [ albums : Album ]

    Inventory() {
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