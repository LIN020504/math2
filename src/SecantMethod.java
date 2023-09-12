import static java.lang.Math.abs;
import static jdk.nashorn.internal.objects.NativeMath.sqrt;

public class SecantMethod {
    DataReceiver receiver = new DataReceiver();
    double[] coefficients = receiver.receiveCoefficients();
    double a = coefficients[0];
    double b = coefficients[1];
    double e = coefficients[2];

    public void judgement() {
        if (DataReceiver.getvalue(a) * DataReceiver.getvalue(b) >= 0) {
            throw new RuntimeException();
        }
    }

    public double getnextpoint(double a, double b) {
        double fraction = DataReceiver.getvalue(a) - DataReceiver.getvalue(b) / (a - b);
        return b - ((b - a) / (DataReceiver.getvalue(b) - DataReceiver.getvalue(a))) * DataReceiver.getvalue(b);
    }

    public void SecantMethod() {
        //judgement();
        int times = 0;
        double printc = 0;
        double caculateaccuracy;
        System.out.println("x(k-1)  " + "f(x(k-1))  " + " x(k)  " + "f(x(k))  " + "x(k+1)  " + "f(x(k+1))  " + "|x(k)-x(k+1)|");
        double answer = 0;
        //while (caculateaccuracy >= e) {
        for (caculateaccuracy = 10; caculateaccuracy > e; times++) {

            double printa = a;
            double printb = b;
            // double f1 = DataReceiver.getvalue(a);
            //double f2 = DataReceiver.getvalue(b);
            double nextpoint = getnextpoint((printa), printb);
            double f1 = DataReceiver.getvalue(nextpoint);
            double temp = b;
            b = nextpoint;
            a = temp;
            caculateaccuracy = abs(a - b);
            printc = b;
            double f3 = DataReceiver.getvalue(b);
            answer = printc;
            System.out.printf("%.3f  %.3f  %.3f  %.3f  %.3f  %.3f   %.3f", printa, DataReceiver.getvalue(printa), printb,
                    DataReceiver.getvalue(printb), printc,
                    answer, caculateaccuracy);
            System.out.println("");

        }
        System.out.println("------------------------------------------");
        System.out.println("The answer is: " + answer);
        System.out.println("The error is: " + caculateaccuracy);
        System.out.println("Iterated: " + times);
        System.out.println("F(x) of answer: " + DataReceiver.getvalue(printc));
    }
}
