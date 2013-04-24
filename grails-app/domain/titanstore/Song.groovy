package titanstore

class Song extends StoreItem { 

		String artist
		int duration
    float price
    String title
		
		static belongsTo = [ album: Album ]

    static constraints = {
			title( blank: false )
			artist( blank: false )
			duration( min : 1 )
    }
}
