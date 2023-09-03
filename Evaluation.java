import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Evaluation {
    public static void main(String[] args)
    {
     String str = "Hello world";
     //String reverse = Arrays.stream(str.split("\\s+")).reduce((str1, str2) -> str2+" "+str1).get();
     //System.out.println(reverse);
        System.out.println(IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(Object::toString)
                .collect(Collectors.joining()));

        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 4,4 , 5, 3, 3);


        List<String> stringList = Arrays.asList("Hello", "Hello", "World");
        evictDuplicates(list, () -> 2).forEach(System.out::println);
        evictDuplicates(stringList, () -> "Hello").forEach(System.out::println);
    }

    private static <T> List<T> evictDuplicates(List<T> list, Supplier<T> valueSupplier)
    {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .filter(entry -> !entry.getKey().equals(valueSupplier.get()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
