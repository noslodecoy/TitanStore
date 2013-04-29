package titanstore

class AlbumController {
	static scaffold = true

  //def index() {
  //}
  
  def list() {
    def albumList = Album.list()
    [album:albumList.sort()]
  }

  def save() {
    if ( session.user.isAdmin() ) {
    
      def album = new Album( params["album"] )
      album.properties = params
      if ( album.save() ) {
        redirect action: "show", id:album.id
      } else {
        render view: "edit", model: [album:album]
      }
    } else {
      redirect controller: "store"
    }
  }

}