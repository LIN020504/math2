import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static jdk.nashorn.internal.objects.NativeMath.sqrt;

public class SimpleIterate {
    DataReceiver receiver = new DataReceiver();
    double[] coefficients = receiver.receiveCoefficients();
    double a = coefficients[0];
    double b = coefficients[1];
    double e = coefficients[2];
    int times = 0;
    float ans;
    double caculateaccuracy = 10;
    int model = 0;

    public class InputError extends Exception {
        public InputError(String message) {
            super(message);
        }
    }

    public double getpossibilityder1(double a) {
        //double y = sqrt(((-3.48 * x * x + 10.23 * x + 9.35) / 2.8),3);
        double y = 3 * a * a;
        return y;
    }

    public double getpossibilityder2(double a) {
        double x = a;
        double y = pow(x - 4, -2/3);
        return y;
    }

    public double getpossibilityder3(double a) {
        double x = a;
        double y = 3 * x * x - 1;
        return y;
    }


    public double Condition1(double x) {
        return x + -1 * (1 / getpossibilityder3(a)) * DataReceiver.getvalue(x);
    }

    public double Condition2(double x) {
        return x + -1 * (1 / getpossibilityder3(b)) * DataReceiver.getvalue(x);
    }

    public void judgement() throws RuntimeException {

            if (abs(getpossibilityder2(a))*1/3 > 1 && abs(getpossibilityder2(a))*1/3 > 1) {
                System.out.println("f("+a+")= " + abs(getpossibilityder2(a))*1/3 + " or "+"f("+b+")= " +abs(getpossibilityder2(b))*1/3);
                throw new RuntimeException("Условие сходимости HE ВЫПОЛНЯЕТСЯ");
        } else {
                System.out.println("f("+a+")= " + abs(Condition1(a))*1/3 + " <1");
                System.out.println("f("+b+")= " +abs(Condition1(b))*1/3 + " <1");
                System.out.println("Условие сходимости ВЫПОЛНЯЕТСЯ");
                System.out.println("");
            }
    }

    public void SimpleIterate() {
            try {
                judgement();
            } catch (Exception ex) {
                //System.out.println("f("+a+")= " + getpossibilityder1(a) + " or "+"f("+b+")= " +getpossibilityder1(b)+ " > 1");
                throw new RuntimeException("Условие сходимости HE ВЫПОЛНЯЕТСЯ");
            }

            System.out.println("x(k)" + "  " + "f(x(k))" + "  " + "x(k+1)" + "  " + "φ" + "(x(k))" + "  " + "|x(k)-x(k+1)|");
            double printa = 0;
            double a1 = a;
            while (caculateaccuracy > e) {
                times = times + 1;
                if (getpossibilityder3(a) < getpossibilityder3(b)) {
                    printa = Condition2(a1);
                    caculateaccuracy = printa - a1;
                    System.out.printf("%.3f  %.3f  %.3f  %.3f  %.3f  ", a1, printa, Condition2(a1), DataReceiver.getvalue(a1), caculateaccuracy);
                    System.out.println("");
                    a1 = printa;
                }

                if (getpossibilityder3(a) > getpossibilityder3(b)) {
                    printa = Condition1(a1);
                    caculateaccuracy = abs(printa - a1);
                    System.out.printf("%.3f  %.3f  %.3f  %.3f  %.3f  ", a1, printa, Condition1(a1), DataReceiver.getvalue(a1), caculateaccuracy);
                    System.out.println("");
                    a1 = printa;
                }
            }

            System.out.println("--------------------------------------------");
            System.out.println("Iterate times: " + times);
            System.out.println("Answer is: " + printa);
            System.out.println("Accuracy is: " + caculateaccuracy);
            System.out.println("F(x) of answer is: " + DataReceiver.getvalue(printa));
        }
    }



