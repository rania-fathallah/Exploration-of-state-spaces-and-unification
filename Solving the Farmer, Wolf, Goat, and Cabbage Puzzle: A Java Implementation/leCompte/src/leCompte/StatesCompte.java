import java.util.*;

public class StatesCompte implements State {
    private final State parent;
    private final String usedOperator;
    private final Integer result;
    private final List<Integer> list;

    public StatesCompte(Integer result, List<Integer> list) {
        this(null, "nothing", result, list);
    }

    public StatesCompte(State parent, String usedOperator, Integer result, List<Integer> list) {
        this.parent = parent;
        this.usedOperator = usedOperator;
        this.result = result;
        this.list = new ArrayList<>(list); // Defensive copy
    }

    @Override
    public State getParent() {
        return parent;
    }

    @Override
    public boolean isSolution() {
        return result == 0;
    }

    @Override
    public Iterable<State> getPossibleMoves() {
        if (!list.isEmpty()) {
            Set<State> moves = new HashSet<>();
            Integer g = list.get(0);
            List<Integer> newList = new ArrayList<>(list.subList(1, list.size()));

            moves.add(new StatesCompte(this, "nothing", result, newList));
            moves.add(new StatesCompte(this, "+", result - g, newList));
            moves.add(new StatesCompte(this, "-", result + g, newList));
            if (result % g == 0) {
                moves.add(new StatesCompte(this, "*", result / g, newList));
            }
            moves.add(new StatesCompte(this, "/", result * g, newList));

            return moves;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatesCompte that = (StatesCompte) o;
        return Objects.equals(result, that.result) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, list);
    }

    public void print() {
        System.out.println(usedOperator + " : " + result);
        System.out.println(list);
        System.out.println("------------");
    }
}
