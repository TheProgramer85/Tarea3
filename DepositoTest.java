import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    @Test
    void testAddProducto() {
        Deposito deposito = new Deposito();
        Producto producto = new CocaCola(1);
        deposito.addProducto(producto);

        assertEquals(1, deposito.getStorage());
    }

    @Test
    void testGetProducto() {
        Deposito deposito = new Deposito();
        Producto producto = new Sprite(1);
        deposito.addProducto(producto);

        Producto productoRecibido = deposito.getProducto();

        assertEquals(producto, productoRecibido);
        assertEquals(0, deposito.getStorage());
    }

    @Test
    void testGetProductoEn() {
        Deposito deposito = new Deposito();
        Producto producto1 = new CocaCola(1);
        Producto producto2 = new Sprite(2);
        deposito.addProducto(producto1);
        deposito.addProducto(producto2);

        Producto productoRecibido = deposito.getProductoEn(1);

        assertEquals(producto2, productoRecibido);
        assertEquals(2, deposito.getStorage());
    }

    @Test
    void testGetStorage() {
        Deposito deposito = new Deposito();

        assertEquals(0, deposito.getStorage());

        Producto producto = new Super8(1);
        deposito.addProducto(producto);

        assertEquals(1, deposito.getStorage());
    }
}
