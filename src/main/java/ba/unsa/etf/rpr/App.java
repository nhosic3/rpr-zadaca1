package ba.unsa.etf.rpr;

public class App {
    public static void main(String[] args) {
        try{
            ExpressionEvaluator e = new ExpressionEvaluator();
            Double rez = e.evaluate(args[0]);
            System.out.println(rez);
        }
        catch(RuntimeException e){
            System.out.println("Neispravan izraz");
        }

    }
}