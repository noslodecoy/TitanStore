package titanstore

class Album extends StoreItem {

    String artist
		static hasMany = [ songs: Song ]
    Genre genre
  
    static constraints = {
    }

}