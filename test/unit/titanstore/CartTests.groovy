package titanstore



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Cart)
class CartTests {
    void testAddAlbumToCart() {
      Cart cart = new Cart();
      cart.addAlbum( new Album( title: 'Me Against The World' ) );
      int count = cart.items.size();
      assert( count == 1 );
    }
    
    void testRemoveAlbumFromCart() {
      Cart cart = new Cart();
      Album album = new Album( title: 'Me Against The World' );
      cart.addAlbum( album );
      cart.removeAlbum( album );
      int count = cart.items.size();
      assert( count == 0 );
    }

}
