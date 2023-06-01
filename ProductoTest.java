import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTest {

    @Test
    public void testConsumir() {
        Producto sprite = new Sprite(123);
        assertEquals("sprite", sprite.consumir());

        Producto cocaCola = new CocaCola(456);
        assertEquals("cocacola", cocaCola.consumir());

        Producto super8 = new Super8(789);
        assertEquals("super8", super8.consumir());

        Producto rayita = new Rayita(999);
        assertEquals("rayita", rayita.consumir());
    }

    @Test
    public void testGetSerie() {
        Producto sprite = new Sprite(123);
        assertEquals(123, sprite.getSerie());

        Producto cocaCola = new CocaCola(456);
        assertEquals(456, cocaCola.getSerie());

        Producto super8 = new Super8(789);
        assertEquals(789, super8.getSerie());

        Producto rayita = new Rayita(999);
        assertEquals(999, rayita.getSerie());
    }
}
