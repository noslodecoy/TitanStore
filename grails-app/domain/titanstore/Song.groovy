package titanstore

class Song { 

		String title
		String artist
		int duration
		
		static belongsTo = [ album: Album ]

    static constraints = {
			title( blank: false )
			artist( blank: false )
			duration( min : 1 )
    }
}
