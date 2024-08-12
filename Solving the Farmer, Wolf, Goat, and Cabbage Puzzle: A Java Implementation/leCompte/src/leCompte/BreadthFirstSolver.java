package leCompte;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Implements a Breadth-First Search (BFS) algorithm to solve a problem represented by
 * the State interface.
 */
public class BreadthFirstSolver implements Solver {

    /**
     * Queue to hold states to be explored.
     */
    private Queue<State> queue = new LinkedList<State>();

    /**
     * Set to keep track of visited states.
     */
    private Set<State> closed = new HashSet<State>();

    /**
     * Solves the given problem using BFS.
     *
     * @param initialState the initial state of the problem
     * @return a list of states representing the solution path, or null if no solution found
     */
    public List<State> solve(State initialState) {
        // Clear visited and open states for a new search
        closed.clear();
        clearOpen();

        // Add the initial state to the queue
        addState(initialState);

        while (!queue.isEmpty()) { // While there are states to explore
            State currentState = nextState(); // Get the next state to explore

            if (currentState.isSolution()) { // If the current state is a solution
                return findPath(currentState); // Reconstruct and return the solution path
            }

            closed.add(currentState); // Mark the current state as visited

            Iterable<State> possibleMoves = currentState.getPossibleMoves();
            if (possibleMoves != null) {
                for (State move : possibleMoves) {
                    if (!closed.contains(move)) { // If the move hasn't been visited
                        addState(move); // Add the move to the queue for exploration
                    }
                }
            } else {
                // No possible moves, return null indicating no solution
                return null;
            }
        }
        // No solution found after exploring all states
        return null;
    }

    /**
     * Returns the number of visited states during the search.
     *
     * @return the number of visited states
     */
    public int getVisitedStateCount() {
        return closed.size();
    }

    /**
     * Reconstructs the solution path from the given solution state.
     *
     * @param solution the final solution state
     * @return a list of states representing the solution path
     */
    private List<State> findPath(State solution) {
        LinkedList<State> path = new LinkedList<State>();
        while (solution != null) {
            path.addFirst(solution);
            solution = solution.getParent();
        }
        return path;
    }

    /**
     * Adds a state to the open list (queue) if it's not already there.
     *
     * @param s the state to add
     */
    protected void addState(State s) {
        if (!queue.contains(s)) {
            queue.offer(s);
        }
    }

    /**
     * Checks if there are still states to be explored.
     *
     * @return true if the queue is not empty, false otherwise
     */
    protected boolean hasElements() {
        return !queue.isEmpty();
    }

    /**
     * Removes and returns the next state from the queue.
     *
     * @return the next state to explore
     */
    protected State nextState() {
        return queue.remove();
    }

    /**
     * Clears the open list (queue).
     */
    protected void clearOpen() {
        queue.clear();
    }
}

