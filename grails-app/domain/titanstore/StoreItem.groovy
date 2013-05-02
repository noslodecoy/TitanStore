package titanstore

abstract class StoreItem {

  String title
  float price

  @Override
  boolean is( StoreItem obj ) {
    println "\n\nTESTING\n\n";
    return ( obj.id.is( id ) );
  }
  
}
