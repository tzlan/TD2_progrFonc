public class Paire<T,U> {


    private T fst; //fst peut correspondre à la taille
    private U snd;//snd peut correspondre au poids


    public Paire(T fst, U snd) {
        this.setFst(fst);
        this.setSnd(snd);
    }

    @Override public String toString() {
        return String.format("(%s,%s)", getFst().toString(), getSnd().toString());
    }





    //Trop petit
    public static Boolean petitefst(Paire<Integer, Double> visiteur){
        return visiteur.getFst() < 100;
    }

    //Trop grand
    public static Boolean grandefst(Paire<Integer, Double> visiteur){
        return visiteur.getFst() > 200;
    }

    //Trop lourd
    public static Boolean  surpoids(Paire<Integer, Double> visiteur){
        return visiteur.getSnd() > 150.00;
    }

    //Taille
    public T getFst() {
        return fst;
    }
    public void setFst(T fst) {
        this.fst = fst;
    }

    //Poids
    public U getSnd() {
        return snd;
    }
    public void setSnd(U snd) {
        this.snd = snd;
    }




}