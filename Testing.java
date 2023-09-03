import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What type of list do you want to input? (integer/string): ");
        String type = scanner.next();

        scanner.nextLine();  // Consume the leftover newline character

        System.out.println("Enter the list elements separated by spaces: ");
        String[] elements = scanner.nextLine().split(" ");

        if ("integer".equalsIgnoreCase(type)) {
            List<Integer> integerList = Arrays.stream(elements)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println("Reversed and repeated Integers: " + processList(integerList));
        } else if ("string".equalsIgnoreCase(type)) {
            List<String> stringList = Arrays.asList(elements);
            System.out.println("Reversed and repeated Strings: " + processList(stringList));
        } else {
            System.out.println("Invalid type!");
        }
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
