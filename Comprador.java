class Comprador{
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualProducto, Expendedor exp) {
        Producto a = exp.comprarProducto(m, cualProducto);

        if (a == null) sonido = null;
        else sonido = a.beber();
        boolean b = true;

        while (b){
            Moneda s = exp.getVuelto();
            if (s != null) vuelto += s.getValor();
            else b = false;
        }
    }
}