package titanstore

class CartController {

  def index() { }
  
  def add() {
    Album a = Album.findById( params.album )
    if ( !session.user.cart ) {
      session.user.cart = new Cart();
    }
    session.user.cart.addAlbum( a );
    session.user.cart.save()
  }

}
