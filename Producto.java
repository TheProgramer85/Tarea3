abstract class Producto{
    private int serie;
    public Producto(int serie){ this.serie = serie; }
    public int getSerie() { return serie; }
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
class Rallita extends Producto{
    public Rallita(int s){ super(s); }
    public String consumir(){ return "rallita"; }
}