package univali.lfa.core;

import lombok.Getter;
import univali.lfa.enums.Alphabet;

import java.util.List;

@Getter()
public class Transition {
    List<Character> validCharacters;
    Node to;

    public Transition(Alphabet alphabet, Node to) {
        this.validCharacters = alphabet.getCharacters();
        this.to = to;
    }
}
