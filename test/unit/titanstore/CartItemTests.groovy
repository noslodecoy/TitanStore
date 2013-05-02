package titanstore



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CartItem)
class CartItemTests {

    void testCartItemFromAlbum() {
      Album album = new Album( title: 'Me Against The World' );
      CartItem item = new CartItem( album );
      assertEquals 'Me Against The World', item.title
    }

}
