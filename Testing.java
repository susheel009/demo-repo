import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        // Convert the input string to a list of characters for processing
        List<Character> charList = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        System.out.println("Processed Characters: " + processList(charList));
    }

    public static <T extends Comparable<T>> Map<String, Object> processList(List<T> list) {
        Map<String, Object> result = new HashMap<>();

        // Reverse the list, including spaces
        List<T> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        String reversedStr = reversed.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        result.put("Reversed", reversedStr);

        // Finding repeated values and their counts, ignoring spaces
        Map<T, Long> counts = list.stream()
                .filter(c -> !c.equals(' '))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<T, Long> repeated = counts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        result.put("Repeated", repeated);

        return result;
    }
}
