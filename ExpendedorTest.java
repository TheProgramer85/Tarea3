package org.example.expendedor;

import org.example.Expendedor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println("ComprarUnProducto");
        assertNotNull(expendedor.comprarProducto(pago));
    }

    @Test
    void getPrecio() {
    }

    @Test
    void getVuelto() {
    }
}
