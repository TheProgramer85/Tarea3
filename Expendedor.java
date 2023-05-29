class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito super8;
    private Deposito rallita;
    private DepositoM monVu;
    private int codigo;
    private int precioB;
    private int precioD;
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int SUPER8 = 3;
    public static final int RALLITA = 4;
    public Expendedor(int numProductos, int precioBebidas, int precioDulces) {
        coca = new Deposito();
        sprite = new Deposito();
        super8 = new Deposito();
        rallita = new Deposito();
        monVu = new DepositoM();

        this.precioB = precioBebidas;
        this.precioD = precioDulces;

        for (int i = 0; i < numProductos; i++) {
            Producto cc = new CocaCola(100 + i);
            coca.addProducto(cc);
            Producto sp = new Sprite(200 + i);
            sprite.addProducto(sp);
            Producto s8 = new Super8( 300 + i);
            super8.addProducto(s8);
            Producto rt = new Rallita( 400 + i);
            rallita.addProducto(rt);
        }
    }
    public Producto comprarBebida(Moneda m, int n) {
        this.codigo = n;
        if (m != null && m.getValor() >= precioB) {
            switch(n){

                case 1: Producto cc = coca.getProducto();
                if (cc != null) {
                    for (int i = 0; i < (m.getValor() - precioB) / 100; i++) {
                        Moneda a = new Moneda100();
                        monVu.addMoneda(a);
                    }
                    return cc;
                }
                case 2: Producto sp = sprite.getProducto();

                if (sp != null) {

                    for (int i = 0; i < (m.getValor() - precioB) / 100; i++) {
                        Moneda a = new Moneda100();
                        monVu.addMoneda(a);
                    }
                    return sp;
                }
                case 3: Producto s8 = super8.getProducto();

                if (s8 != null) {

                    for (int i = 0; i < (m.getValor() - precioD) / 100; i++) {
                        Moneda a = new Moneda100();
                        monVu.addMoneda(a);
                    }
                    return s8;
                }
                case 4: Producto rt = rallita.getProducto();

                if (rt != null) {

                    for (int i = 0; i < (m.getValor() - precioD) / 100; i++) {
                        Moneda a = new Moneda100();
                        monVu.addMoneda(a);
                    }
                    return rt;
                }
            }else{
                monVu.addMoneda(m);
                return null;
            }
        }else{
            monVu.addMoneda(m);
            return null;
        }
        monVu.addMoneda(m);
        return null;
    }
    public int getPrecio(){
        if (codigo == 1 || codigo == 2) return precioB;
        else return precioD;
    }
    public Moneda getVuelto(){ return monVu.getMoneda(); }
}