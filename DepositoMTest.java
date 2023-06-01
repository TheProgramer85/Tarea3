import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepositoMTest {
    @Test
    void testAddMoneda() {
        DepositoM deposito = new DepositoM();
        Moneda moneda = new Moneda100();
        deposito.addMoneda(moneda);

        assertEquals(1, deposito.check());
    }

    @Test
    void testGetMoneda() {
        DepositoM deposito = new DepositoM();
        Moneda moneda = new Moneda500();
        deposito.addMoneda(moneda);

        Moneda monedaRecibida = deposito.getMoneda();

        assertEquals(moneda, monedaRecibida);
        assertEquals(0, deposito.check());
    }

    @Test
    void testTakeMonedain() {
        DepositoM deposito = new DepositoM();
        Moneda moneda1 = new Moneda100();
        Moneda moneda2 = new Moneda1000();
        Moneda moneda3 = new Moneda500();
        deposito.addMoneda(moneda1);
        deposito.addMoneda(moneda2);
        deposito.addMoneda(moneda3);

        Moneda monedaRecibida = deposito.takeMonedain(1);

        assertEquals(moneda2, monedaRecibida);
        assertEquals(2, deposito.check());
    }

    @Test
    void testGetMonedain() {
        DepositoM deposito = new DepositoM();
        Moneda moneda1 = new Moneda100();
        Moneda moneda2 = new Moneda1000();
        deposito.addMoneda(moneda1);
        deposito.addMoneda(moneda2);

        Moneda monedaRecibida = deposito.getMonedain(0);

        assertEquals(moneda1, monedaRecibida);
        assertEquals(2, deposito.check());
    }

    @Test
    void testCheck() {
        DepositoM deposito = new DepositoM();

        assertEquals(0, deposito.check());

        Moneda moneda = new Moneda100();
        deposito.addMoneda(moneda);

        assertEquals(1, deposito.check());
    }
}
