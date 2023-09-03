import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        // Convert the input string to a list of characters
        List<Character> charList = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        System.out.println("Reversed and repeated Characters: " + processList(charList));
    }

    public static <T extends Comparable<T>> Map<String, List<T>> processList(List<T> list) {
        Map<String, List<T>> result = new HashMap<>();

        // Reversing the list
        List<T> reversed = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // Finding repeated values
        List<T> repeated = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        result.put("Reversed", reversed);
        result.put("Repeated", repeated);

        return result;
    }
}
