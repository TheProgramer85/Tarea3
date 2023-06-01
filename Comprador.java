
/**
 * @Comprador interactua con el expendedor
 * @sonido recibe lo que se esta consumiendo
 * @vuelto hace el pago
 **/
// Enum para representar los sabores de los productos
public enum Sabor {
    COCACOLA,
    SPRITE,
    SUPER8,
    RAYITA
}

public class Comprador{
    private Producto producto, Pcomparacion;
    private Expendedor exp;
    private DepositoM vuelto;
    private String sonido;
    private int valorvuelto = 0;
    private int countm100, countm500, countb1000;
    public Comprador(Expendedor exp){
        countm100 = 0;countm500 = 0;countb1000 = 0;
        vuelto = new DepositoM();
        producto = new NoProducto(0,0,0,0); Pcomparacion = new NoProducto(0,0,0,0);

        this.exp = exp;
    }
    public void getVuelto(){
        while (true) {
            Moneda m = exp.getVuelto();
            if (m == null) break;
            vuelto.addMoneda(m);
        }
        for (int i = 0; i < vuelto.check(); i++) {
            Moneda m = vuelto.getMoneda();
            valorvuelto = valorvuelto + m.getValor();
            vuelto.addMoneda(m);
        }
        countm100 = countm100 + exp.getcountm100();
        exp.setcountm100(0);
        countm500 = countm500 + exp.getcountm500();
        exp.setcountm500(0);
        countb1000 = countb1000 + exp.getcountb1000();
        exp.setcountb1000(0);
    }
    public Producto getProducto(){ return producto; }
    public Moneda getMonedabyValor(Moneda m) throws NohayMonedaException{

        if (m.getValor() == 1000) {
            if (countb1000 == 0) throw new NohayMonedaException("No Posee Billetes de 1000");

            else countb1000 = countb1000 - 1;
        }else{
            if (m.getValor() == 500) {
                if (countm500==0) throw new NohayMonedaException("No Posee monedas de 500");

                else countm500 = countm500-1;
            }else{
                if (m.getValor()==100) {
                    if (countm100==0) throw new NohayMonedaException("No Posee monedas de 100");
                    else countm100 = countm100-1;

                }
            }
        }
        for (int i = 0; i < vuelto.check(); i++) {
            if (vuelto.getMonedain(i).getClass().getName().equals(m.getClass().getName())) {
                return vuelto.takeMonedain(i);
            }
        }
        throw new NohayMonedaException("No encontro monedas");
    }
    public int getcountm100(){return countm100;}
    public int getcountm500(){return countm500;}
    public int getcountb1000(){return countb1000;}
    public void comprarProducto(Sabor sabor) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException, YaComproException, ProductoNoDisponibleExcepcion {
        // Utilizar el enum Sabor en la lógica de compra del producto
        exp.comprarProducto(Sabor);
    }
    public Moneda getMonedaby(Moneda m){
        for (int i = 0; i < vuelto.check(); i++) {
            if (vuelto.getMonedain(i).getClass().getName().equals(m.getClass().getName())) {
                return vuelto.getMonedain(i);
            }
        }
        return m;
    }
    public void recojeProducto() throws NoHayProductoException{
        producto = exp.getProducto();
        sonido = producto.consumir();
    }
    public String queProducto(){
        producto = new NoProducto(0,0,0,0);
        return(sonido);
    }
    public boolean ProductoEnCom(){
        if (!producto.getClass().getName().equals(Pcomparacion.getClass().getName())) return true;
        else return false;
    }