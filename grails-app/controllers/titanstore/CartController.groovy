package titanstore

class CartController {

  def index() {
    def cart = session.user.getUserCart()
    [ cartItemList : cart.getItems().sort() ]
  }

  def add() {
    //Cart cart = new Cart();
    def a = Album.findById( params.album )
    def cart = session.user.getUserCart();
    cart.addAlbum( a );
    cart.save()
    redirect view: "index"
  }

}
