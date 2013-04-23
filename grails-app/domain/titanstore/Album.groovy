package titanstore

class Album {

		String title
    String artist
		static hasMany = [ songs: Song ]

    static constraints = {
    }
}