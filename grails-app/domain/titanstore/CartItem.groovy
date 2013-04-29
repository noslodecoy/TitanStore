package titanstore

class CartItem extends StoreItem {

    static belongsTo = [ cart: Cart ]
  
    static constraints = {
    }
    
    CartItem( StoreItem itm ) {
      title = itm.title;
      price = itm.price;
    }

}
