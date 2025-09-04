package univali.lfa.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum Alphabet {
    UPPERCASE(createRange('A', 'Z')),
    LOWERCASE(createRange('a', 'z')),
    DIGITS(createRange('0', '9')),
    SYMBOLS(Arrays.asList('#', '!', '?', '.', ',', ';', ':'));

    private final List<Character> characters;

    Alphabet(List<Character> chars) {
        this.characters = new ArrayList<>(chars);
    }

    private static List<Character> createRange(char start, char end) {
        List<Character> list = new ArrayList<>();

        for (char c = start; c <= end; c++) {
            list.add(c);
        }

        return list;
    }
}
