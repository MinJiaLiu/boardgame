public class Sorcerer{
    protected double str_ratio;
    protected double dex_ratio;
    protected double agi_ratio;

    public Sorcerer(String n, int ma, int str, int agi, int dex, int sm, int sexp){
        super(n,ma,str,agi,dex,sm,sexp);
        str_ratio= 0.1;
        dex_ratio=0.3;
        agi_ratio=0.3;
    }

}