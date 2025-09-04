package univali.lfa.core;

import lombok.Getter;
import univali.lfa.enums.Alphabet;

import java.util.ArrayList;
import java.util.List;

@Getter()
public class Node {
    int id;
    List<Transition> transitions = new ArrayList<>();

    public Node(int id, DeterministicFiniteAutomaton dfa) {
        this.id = id;
        dfa.appendNode(this);
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    protected Node nextState(Character input) {
        for (Transition t : transitions) {
            if (t.validCharacters.contains(input)) {
                return t.to;
            }
        }

        return null;
    }

    public void buildTransitions(Node upperCase, Node lowerCase, Node digits, Node symbols) {
        this.addTransition(new Transition(Alphabet.UPPERCASE, upperCase));
        this.addTransition(new Transition(Alphabet.LOWERCASE, lowerCase));
        this.addTransition(new Transition(Alphabet.DIGITS, digits));
        this.addTransition(new Transition(Alphabet.SYMBOLS, symbols));
    }
}
