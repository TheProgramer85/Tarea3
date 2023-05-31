
public abstract class Producto{
    private int numSerie;
    public Producto(int numSerie){
        this.numSerie = numSerie;
    }
    public int getSerie(){
        return numSerie;
    }
    public abstract String consumir();
}
class Sprite extends Producto{
    public Sprite(int s){ super(s); }
    public String consumir(){ return "sprite"; }
}
class CocaCola extends Producto{
    public CocaCola(int s){ super(s); }
    public String consumir(){ return "cocacola"; }
}
class Super8 extends Producto{
    public Super8(int s){ super(s); }
    public String consumir(){ return "super8"; }
}
class Rayita extends Producto{
    public Rayita(int s){ super(s); }
    public String consumir(){ return "rayita"; }
}