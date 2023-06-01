package org.example.expendedor;

import org.example.Expendedor;
import org.example.PagoIncorrectoException;
import org.example.PagoInsuficienteException;
import org.example.NoHayProductoException;
import org.example.NohayMonedaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpendedorTest {
    private Expendedor expendedor;
    @BeforeEach
    void setUp(){
        expendedor = new Expendedor(4);
    }
    @AfterEach
    void tearDown(){
    }

    @Test
    @DisplayName("Test Un Producto")
    public void testcomprarProducto() throws Exception {
        int pago = 1500;
        System.out.println("ComprarUnProducto");
        expendedor.comprarProducto(pago);
    }

    @Test
    @DisplayName("Test No hay Moneda")
    public void testNohayMonedaException() throws Exception{
        int pago = 0;
        Exception exception = assertThrows(NohayMonedaException.class()->){
            expendedor.comprarProducto(pago);
            expendedor.comprarProducto(pago);
        }
    }

    @Test
    @DisplayName("test No hay Producto")
    public void testNohayProductoException() throws Exception {
        int pago = 1500;
        Exception exception = assertThrows(NoHayProductoException.class,()->){
            expendedor.comprarProducto(pago);
        }
    }

    @Test
    @DisplayName("test Pago Incorrecto")
    public void testPagoIncorrectoException() throws Exception{
        int pago = 1;
        Exception exception = assertThrows(PagoIncorrectoException.class,()->){
            expendedor.comprarProducto(pago);
        }
    }

    @Test
    @DisplayName("test Pago Insuficiente")
    public void testPagoInsuficienteException() throws Exception{
        int pago = 50;
        Exception exception = assertThrows(PagoInsuficienteException.class,()->){
            expendedor.comprarProducto(pago);
        }
    }

}
