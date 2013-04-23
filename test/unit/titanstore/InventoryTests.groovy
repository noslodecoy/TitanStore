package titanstore



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Inventory)
class InventoryTests {
    void testAddAlbumToInventory() {
      Inventory inventory = new Inventory();
      inventory.addAlbum( new Album( title: 'Me Against The World' ) );
      int count = inventory.albums.size();
      assert( count == 1 );
    }
    
    void testRemoveAlbumToInventory() {
      Inventory inventory = new Inventory();
      Album album = new Album( title: 'Me Against The World' );
      inventory.addAlbum( album );
      inventory.removeAlbum( album );
      int count = inventory.albums.size();
      assert( count == 0 );
    }
}
