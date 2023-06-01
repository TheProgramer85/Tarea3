import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    @Test
    void testGetValorMoneda1500() {
        Moneda moneda = new Moneda1500();
        assertEquals(1500, moneda.getValor());
    }

    @Test
    void testGetValorMoneda1000() {
        Moneda moneda = new Moneda1000();
        assertEquals(1000, moneda.getValor());
    }

    @Test
    void testGetValorMoneda500() {
        Moneda moneda = new Moneda500();
        assertEquals(500, moneda.getValor());
    }

    @Test
    void testGetValorMoneda100() {
        Moneda moneda = new Moneda100();
        assertEquals(100, moneda.getValor());
    }
}
