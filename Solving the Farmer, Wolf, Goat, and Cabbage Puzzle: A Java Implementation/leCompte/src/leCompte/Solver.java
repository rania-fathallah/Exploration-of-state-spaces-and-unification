package leCompte;
import java.util.*;
public interface Solver {
    // given an initial state, return the list of visited states  
    public List<State> solve(State initialState);

}
