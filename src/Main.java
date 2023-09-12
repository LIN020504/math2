public class Main {
    public static void main(String[] args) {
        System.out.println("Lab work #2 demonstrating system is started!");
        System.out.println("\n\n\n");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Task #1.1. Usage of Secant method for nonlinear equations solving:");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        //SecantMethod secantMethod = new SecantMethod();
        //secantMethod.SecantMethod();
        System.out.println("\n\n\n");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Task #1.2. Usage of Chord method for nonlinear equations solving:");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
      //  ChordMethodSolver chordMethodSolver = new ChordMethodSolver();
       // chordMethodSolver.solveEquation();
        System.out.println("\n\n\n");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Task #1.3. Usage of Simple Iterate method for nonlinear equations solving:");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        //SimpleIterate simpleIterate = new SimpleIterate();
        //simpleIterate.SimpleIterate();
        System.out.println("\n\n\n");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Task #2. Usage of Fixed Point Iteration method for nonlinear equations system solvings:");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        SolverForSystem solverForSystem = new SolverForSystem();
        solverForSystem.Solver();
        System.out.println("\n\n\n");
        System.out.println("Lab work #2 demonstrating system is finished!");
    }
}
