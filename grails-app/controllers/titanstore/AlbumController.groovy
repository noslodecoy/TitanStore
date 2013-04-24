package titanstore

class AlbumController {
	static scaffold = true

  def index() {
  }

  def save() {
    def album = new Album( params["album"] )
    album.properties = params
    if ( album.save() ) {
      redirect action: "show", id:album.id
    } else {
      render view: "edit", model: [album:album]
    }
  }

}