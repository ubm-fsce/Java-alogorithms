package practise.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurrences {
    public static void printCharacterOccurrences() {
        String input = "abracadabra";
          Map<Character, Long> occurrenceMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        occurrenceMap.forEach((character, occurrence) ->
                System.out.println("Character: " + character + ", Occurrence: " + occurrence));
    }
    public static void main(String[] args) {
        String input = "abracadabra";

        printCharacterOccurrences();
        printCharacterOccurrences();
        printCharacterOccurrences();
    }
}
