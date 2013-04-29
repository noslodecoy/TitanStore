package titanstore

class StoreController {
  def index() { }
  
  def albums() {
    def albumList = Album.list()
    [ albumList : albumList.sort() ]
  }
}
