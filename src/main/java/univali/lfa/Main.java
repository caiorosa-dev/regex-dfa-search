package univali.lfa;

import br.univali.santiago.WebSearch;
import univali.lfa.core.DeterministicFiniteAutomaton;
import univali.lfa.core.Node;
import univali.lfa.core.Transition;
import univali.lfa.enums.Alphabet;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        WebSearch webSearch = new WebSearch();
        webSearch.getListaRecursos().add("https://raw.githubusercontent.com/rndinfosecguy/pastePasswordLists/refs/heads/main/pastebin.com/top1000000.lst");
        ArrayList<String> codeList = webSearch.carregarRecursos();

        String pageText = codeList.getFirst();

        DeterministicFiniteAutomaton dfa = new DeterministicFiniteAutomaton();

        Node q0 = new Node(0, dfa);
        Node q1 = new Node(1, dfa);
        Node q2 = new Node(2, dfa);
        Node q3 = new Node(3, dfa);
        Node q4 = new Node(4, dfa);
        Node q5 = new Node(5, dfa);
        Node q6 = new Node(6, dfa);
        Node q7 = new Node(7, dfa);
        Node q8 = new Node(8, dfa);
        Node q9 = new Node(9, dfa);
        Node q10 = new Node(10, dfa);
        Node q11 = new Node(11, dfa);
        Node q12 = new Node(12, dfa);
        Node q13 = new Node(13, dfa);
        Node q14 = new Node(14, dfa);
        Node q15 = new Node(15, dfa);

        dfa.setInitialNode(q0);
        dfa.addFinalNode(q15);

        q0.buildTransitions(q1, q2, q3, q4);
        q1.buildTransitions(q1, q5, q6, q7);
        q2.buildTransitions(q5, q2, q8, q9);
        q3.buildTransitions(q6, q8, q3, q10);
        q4.buildTransitions(q7, q9, q10, q4);
        q5.buildTransitions(q5, q5, q11, q12);
        q6.buildTransitions(q6, q11, q6, q13);
        q7.buildTransitions(q7, q12, q13, q7);
        q8.buildTransitions(q11, q8, q8, q14);
        q9.buildTransitions(q12, q9, q14, q9);
        q10.buildTransitions(q13, q14, q10, q10);
        q11.buildTransitions(q11, q11, q11, q15);
        q12.buildTransitions(q12, q12, q15, q12);
        q13.buildTransitions(q13, q15, q13, q13);
        q14.buildTransitions(q15, q14, q14, q14);
        q15.buildTransitions(q15, q15, q15, q15);

        List<String> result = dfa.searchForWords(pageText);

        for (String s : result) {
            System.out.println(s);
        }
    }
}