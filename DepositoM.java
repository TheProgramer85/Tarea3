import java.util.ArrayList;

class DepositoM{
    private ArrayList<Moneda> mon;
    public DepositoM(){ mon = new ArrayList(); }
    public void addMoneda(Moneda b){ mon.add(b); }
    public Moneda getMoneda() {
        if (mon.isEmpty()) return null;
        else{
            Moneda aux = null;
            aux = mon.remove(0);
            return (aux);
        }
    }
    public Moneda takeMonedain(int n){
        if(mon.isEmpty()) return null;

        else{
            Moneda aux = null;
            aux = mon.remove(n);
            return(aux);
        }
    }
    public Moneda getMonedain(int n){
        if (n>=mon.size()) return null;

        else return mon.get(n);
    }
    public int check(){
        return(mon.size());
    }
}