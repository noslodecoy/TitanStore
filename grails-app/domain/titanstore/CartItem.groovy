package titanstore

class CartItem extends StoreItem {

  StoreItem storeItem;
  
  static belongsTo = [ cart: Cart ]

  static constraints = {
  }

  CartItem( StoreItem itm ) {
    storeItem = itm;
    title = itm.title;
    price = itm.price;
  }

}
