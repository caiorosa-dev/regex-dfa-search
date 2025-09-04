package univali.lfa.core;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class DeterministicFiniteAutomaton {
    Set<Node> nodes = new HashSet<>();

    @Setter
    Node initialNode;
    Set<Node> finalNodes = new HashSet<>();

    public void appendNode(Node node) {
        this.nodes.add(node);
    }

    public void addFinalNode(Node node) {
        finalNodes.add(node);
    }

    public List<String> searchForWords(String text) {
        List<String> validWords = new ArrayList<>();

        Node currentNode = initialNode;
        Node lastNode;

        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            lastNode = currentNode;
            currentNode = currentNode.nextState(currentChar);

            // There is no transition
            if (currentNode == null) {
                // Last node was a final node, and the current word is not empty
                if (finalNodes.contains(lastNode) && !currentWord.isEmpty()) {
                    validWords.add(currentWord.toString());
                }

                currentNode = initialNode;
                currentWord = new StringBuilder();
                continue;
            }

            currentWord.append(currentChar);
        }

        return validWords;
    }
}
