import java.util.ArrayList;

/*
 *@Deposito es una clase que interactua con Expendedor
 *@return:
 */

class Deposito{
    private ArrayList<Producto> al;
    public Deposito(){ al = new ArrayList<>(); }
    public void addProducto(Producto b){ al.add(b); }
    public Producto getProducto(){
        if (al.size()) return null;

        Producto b = al.remove(0);
        return b;
    }
    public Producto getProductoEn(int n){
        if (n>=al.size()) return new NoProducto(0,0,0,0);

        else return al.get(n);
    }
    public int getStorage(){
        return al.size();
    }
}