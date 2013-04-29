package titanstore

class SongController {
  static scaffold = true
  
  SongController() {
  }
  
  def index = {
  }
  
  def create = {
    if ( session.user?.isAdmin() ) {
      def song = new Song()
      song.properties = params
      return [songInstance: song]
    } else {
      redirect: "/store/index"
    }
  }
  
}