package org.example;

public class Expendedor{
    private Deposito coca, sprite, super8, rayita;
    private DepositoM DVuelto, DIngreso;
    private Producto ProductoComprado, Pcomparacion;
    private boolean calcVuelto;
    private int precioB, precioD;
    private int serie;
    private int countm100, countm500, countb1000, Dinero;

    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int SUPER8 = 3;
    public static final int RAYITA = 4;

    public Expendedor(int numProductos, int precio) {
        super();
        serie = numProductos * 2;
        countm100 = 0;
        countm500 = 0;
        countb1000 = 0;
        Dinero = 0;
        ProductoComprado = new NoProducto(0, 0, 0, 0);
        Pcomparacion = new NoProducto(0, 0, 0, 0);

        calcVuelto = false;

        coca = new Deposito();
        sprite = new Deposito();
        super8 = new Deposito();
        rayita = new Deposito();

        DVuelto = new DepositoM();
        DIngreso = new DepositoM();

        this.precioB = precio;
        this.precioD = precio + 400;

        for (int i = 0; i < numProductos; i++) {
            CocaCola cc = new CocaCola(i, 0, 0, escala);
            coca.addProducto(cc);
            Sprite sp = new Sprite(numProductos + i, 0, 0, escala);
            sprite.addProducto(sp);
            Super8 s8 = new Super8((numProductos * 2) + i, 0, 0, escala);
            super8.addProducto(s8);
            Rayita rt = new Rayita((numProductos * 2) + i, 0, 0, escala);
            rayita.addProducto(rt);
        }
    }

    public int getcountm100() {
        return countm100;
    }

    public int getcountm500() {
        return countm500;
    }

    public int getcountb1000() {
        return countb1000;
    }

    public void setcountm100(int c) {
        countm100 = c;
    }

    public void setcountm500(int c) {
        countm500 = c;
    }

    public void setcountb1000(int c) {
        countb1000 = c;
    }

    public void comprarProducto(int n) throws ProductoNoDisponibleExcepcion, PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException, YaComproException {
        if (Dinero < precioB || Dinero < precioD)
            throw new PagoInsuficienteException("El Monto de Pago no es suficiente para realizar la transaccion");
        if (ProductoComprado.getClass().getName() != Pcomparacion.getClass().getName())
            throw new YaComproException("Ya hay una producto almacenada, Extraigala para proceder con otra compra");

        switch (n) {
            case 1:
                ProductoComprado = coca.getProducto();
                if (ProductoComprado.getClass().getName() == Pcomparacion.getClass().getName())
                    throw new NoHayProductoException("Actualmente no hay mas Cocacola, lo sentimos");

                Dinero = Dinero - precioB;
                break;
            case 2:
                ProductoComprado = sprite.getProducto();
                if (ProductoComprado.getClass().getName() == Pcomparacion.getClass().getName())
                    throw new NoHayProductoException("Actualmente no hay mas Sprite, lo sentimos");

                Dinero = Dinero - precioB;
                break;
            case 3:
                ProductoComprado = super8.getProducto();
                if (ProductoComprado.getClass().getName() == Pcomparacion.getClass().getName())
                    throw new NoHayProductoException("Actualmente no hay mas Super8, lo sentimos");

                Dinero = Dinero - precioD;
                break;
            case 4:
                ProductoComprado = rayita.getProducto();
                if (ProductoComprado.getClass().getName() == Pcomparacion.getClass().getName())
                    throw new NoHayProductoException("Actualmente no hay mas Rayita, lo sentimos");

                Dinero = Dinero - precioD;
                break;
            default:
                throw new NoHayProductoException("No se a ingresado una seleccion de Producto");
        }
    }

    public Moneda getVuelto() {
        if (!calcVuelto) {
            while (Dinero > 0) {
                if (Dinero - 1000 >= 0) {
                    DVuelto.addMoneda(new Billete1000());
                    Dinero = Dinero - 1000;
                } else {
                    if (Dinero - 500 >= 0) {
                        DVuelto.addMoneda(new Moneda500());
                        Dinero = Dinero - 500;
                    } else {
                        if (Dinero - 100 >= 0) {
                            DVuelto.addMoneda(new Moneda100());
                            Dinero = Dinero - 100;
                        }
                    }
                }
            }
            calcVuelto = true;
        }
        if (DVuelto.check() > 0) {
            if (DVuelto.getMonedain(0).getValor() == 100) {
                countm100 = countm100 + 1;
            } else if (DVuelto.getMonedain(0).getValor() == 500) {
                countm500 = countm500 + 1;
            } else if (DVuelto.getMonedain(0).getValor() == 1000) {
                countb1000 = countb1000 + 1;
            }
            return DVuelto.getMoneda();

        } else {
            calcVuelto = false;
            return null;
        }
    }

    public Producto getProducto() throws NoHayProductoException {
        if (ProductoComprado.getClass().getName() == Pcomparacion.getClass().getName())
            throw new NoHayProductoException("No hay Producto Para Extraer de la maquina");

        else {
            Producto aux = ProductoComprado;
            ProductoComprado = new NoProducto(0, 0, 0, 0);
            return aux;
        }
    }

    public void IngresaMoneda(Moneda m) throws PagoIncorrectoException {
        if (m == null) throw new PagoIncorrectoException("Pago no valido");
        if (m.getValor() == 100) {
            Dinero = Dinero + 100;
            DIngreso.addMoneda(m);
        } else if (m.getValor() == 500) {
            Dinero = Dinero + 500;
            DIngreso.addMoneda(m);
        } else if (m.getValor() == 1000) {
            Dinero = Dinero + 1000;
            DIngreso.addMoneda(m);
        }
    }
}