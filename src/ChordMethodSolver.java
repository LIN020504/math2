import static java.lang.Math.abs;

public class ChordMethodSolver {
    DataReceiver receiver = new DataReceiver();

    double[] coefficients = receiver.receiveCoefficients();
    double a = coefficients[0];
    double b = coefficients[1];
    double e = coefficients[2];

    public double getnextpoint(double a ,double b){
        return ((a*DataReceiver.getvalue(b)-b*DataReceiver.getvalue(a))/(DataReceiver.getvalue(b)-DataReceiver.getvalue(a)));
    }
    public void solveEquation() {
        System.out.println("a    b    x    F(a)    F(b)    F(x)    |xn+1 - xn|");
        int times = 0;
        double nextpoint = 0 ;
        double caculateaccuracy = 10;
        while (caculateaccuracy >= e) {
            times += 1;
            double printa = a;
            double printb = b;
            nextpoint = getnextpoint(printa, printb);
            DataReceiver.getvalue(nextpoint);
            caculateaccuracy = abs(nextpoint - b);
            System.out.printf("%.3f  %.3f  %.3f  %.3f  %.3f  %.3f  %.3f  ",a , b , nextpoint , DataReceiver.getvalue(a) , DataReceiver.getvalue(b) , DataReceiver.getvalue(nextpoint), caculateaccuracy);
            //System.out.println(a , b , nextpoint , DataReceiver.getvalue(a) , DataReceiver.getvalue(b) , DataReceiver.getvalue(nextpoint), caculateaccuracy);
            System.out.println("");
            b = nextpoint;
        }
        System.out.println("------------------------------------------");
        System.out.println("The error is: " + caculateaccuracy);
        System.out.println("Iterated: " + times);
        System.out.println("F(x):"+ DataReceiver.getvalue(nextpoint));
    }
}


