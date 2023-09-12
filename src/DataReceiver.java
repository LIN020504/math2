import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataReceiver {

    public int receiveEquation() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You need to choose some equation from list for equation solver working demonstration.");
                System.out.println("Variants:");
                System.out.println("1.\tx^2 + 5x + 7 = 0;");
                System.out.println("2.\tx^3 + sqrt(x) = 0;");
                System.out.print("Enter equation number: ");
                int number = scanner.nextInt();
                if (!(number == 1 || number == 2)) throw new InputMismatchException();
                return number;
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Value must be a number! Try again!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect input.");
                System.exit(1);
            }
        }
    }

    public double[] receiveCoefficients() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You need to enter a segment [a;b].");
                System.out.print("Enter \"a\" value: ");
                double a = scanner.nextDouble();
                System.out.print("Enter \"b\" value: ");
                double b = scanner.nextDouble();
                if (b < a) throw new ArithmeticException();
                System.out.print("Enter \"ε\" value is the accuracy with which it is necessary to find a solution to the equation: ");
                double e = scanner.nextDouble();
                System.out.println("");
                return new double[]{a, b, e};
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Value must be a number! Try again!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect input.");
                System.exit(1);
            } catch (ArithmeticException arithmeticException) {
                System.err.println("\"a\" value must be lower than \"b\" value. Try again.");
            }
        }
    }
    public static double getvalue(double input1){
        double x = input1;
        //double y = -2.8*x*x*x-3.48*x*x+10.23*x+9.35;
        double y = x*x*x - 1*x + 4;
        return y;
    }


    public final double solveFirstEquation(double x) {
        return 3*4.45*x*x+2*7.81*x;
    }

    public final double solveSecondEquation(double x) {
        return 6*4.45*x+2*7.81;
    }
}
