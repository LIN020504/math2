import static java.lang.Math.*;
import static jdk.nashorn.internal.objects.NativeMath.sqrt;

public class SolverForSystem {
    public double getvalue1(){
        return 0.1*a*a+a+0.2*b*b-0.3;
    }

    public double getvalue2(){
        return 0.2*a*a+b+0.1*a*b-0.7;
    }

    public double firstiterator(double x1, double x2){
        return 0.3-0.1*x1*x1-0.2*x2*x2;
    }

    public double firstderonx(double x1){
        return -0.2*x1;
    }

    public double firstderony(double x2){
        return -0.4*x2;
    }

    public double secongiterator(double x1, double x2){
        return 0.7-0.2*x1*x1-0.1*x1*x2;
    }

    public double secondderonx(double x1, double x2){
        return -0.4*x1-0.1*x2;
    }

    public double secondderony(double x1){
        return -0.1*x1;
    }

    DataReceiver receiver = new DataReceiver();
    double[] coefficients = receiver.receiveCoefficients();
    double a = coefficients[0];
    double b = coefficients[1];
    double e = coefficients[2];

    double sumder1 = abs(firstderonx(a))+abs(firstderony(b));
    double sumder2 = abs(secondderonx(a,b)+abs(secondderony(a)));
    double tempa;
    double tempb;

    public void Solver(){
        if (sumder1 < 1 || sumder2 < 1){
            double input = coefficients[2];
            double accuracy = input;
            double caculateaccuracy = 10;
            double times=0;
            System.out.println("-------------------Method Simple iterate(for system)-------------------");
            System.out.println(("x1" +"     "+ "x2" +"     "+ "φ(x1)" +"     "+ "φ(x2)" +"     "+ "max(|xi(k+1)-xi(k)|)"));
            while (caculateaccuracy >= accuracy){
                times = times + 1;
                 tempa = a;
                 tempb = b;
                a = (float) firstiterator(tempa,tempb);
                b = (float) secongiterator(tempa,tempa);
                caculateaccuracy = max(abs(tempb-b),abs(tempa-a));
                System.out.printf("%.3f  %.3f  %.3f     %.3f     %.3f  ",tempa,tempb,a,b,caculateaccuracy);
                System.out.println("");
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Iterated  times: " + times);
            System.out.println("f1(x1,x2)=0.1*x1^2 + x1 + 0.2*x2^2 -0.3 = " +getvalue1());
            //System.out.printf("%.1f",getvalue1());
            System.out.println("");
            System.out.println("f1(x1,x2)=0.2*x1^2 + x2 + 0.1*x1*x2 -0.7 = " + getvalue2());
            //System.out.printf("%.1f",getvalue2());
            //System.out.println("f1(x1,x2)=0.1*x1*x1 + x1 + 0.2 *x2*x2-0.3= " + getvalue1());
            //System.out.println("f1(x1,x2)=0.2*x1*x1 + x2 + 0.1 *x1*x2-0.7= " + getvalue2());

            //System.out.println("The x1 = " +  tempa);
            //System.out.println("The x2 is =" + tempb);
        }else {
            throw new RuntimeException("Near this point no solution");
        }
    }
}
