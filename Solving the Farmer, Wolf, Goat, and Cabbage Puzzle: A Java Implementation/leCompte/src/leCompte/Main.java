package leCompte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Main class for running the "compte bon" problem solver.
 */
public class Main {

    public static void main(String[] args) {
        // Print introductory messages (in French)
        System.out.println("Ce programme résout un problème d'intelligence artificielle");
        System.out.println("Il s'agit du problème du compte bon...");
        System.out.println("Ci dessous, une solution possible (If a solution exists)");

        // Create an initial state with starting values
        ArrayList<Integer> initialValues = new ArrayList<Integer>();
        initialValues.add(30);
        initialValues.add(3);
        initialValues.add(10);
        StatesCompte initialState = new StatesCompte(33, initialValues);

        // Create a Breadth-First Search solver
        BreadthFirstSolver bfsSolver = new BreadthFirstSolver();

        // Solve the problem using BFS
        List<State> solutions = bfsSolver.solve(initialState);

        // Print a solution if found, otherwise inform user
        if (solutions != null) {
            Iterator<State> iterator = solutions.iterator();
            while (iterator.hasNext()) {
                ((StatesCompte) (iterator.next())).print(); // Print each state in the solution
            }
        } else {
            System.out.println("There is no solution for the given initial state.");
        }
    }
}
