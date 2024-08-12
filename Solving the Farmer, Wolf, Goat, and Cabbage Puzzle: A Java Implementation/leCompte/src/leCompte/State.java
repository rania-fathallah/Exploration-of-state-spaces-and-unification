package leCompte;
import java.util.*;

public interface State {
    //Generates all states reachable from the current state; ideally
    //the new state do not contain already visited states.
    public Iterable<State> getPossibleMoves();

    // true if this state is solution 
    public boolean isSolution();

    // return the parent of the state 
    public State getParent();

    // for advanced search . 
    // public double getHeuristic();
    // public double getDistance();
}
