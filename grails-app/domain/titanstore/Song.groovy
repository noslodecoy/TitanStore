package titanstore

class Song extends StoreItem { 
    
    String title
    String artist
    float duration
    float price
		
    static belongsTo = [ X: X ]

    static constraints = {title( blank: false )
			  artist( blank: false )
			  duration( min : 1 )
    }
}
