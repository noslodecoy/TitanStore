package titanstore

class CartController {

  def index() { }
  
  def add() {
    session.user.cart.addAlbum( params.album );
  }

}
