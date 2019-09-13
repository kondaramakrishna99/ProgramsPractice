import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class LambdaPractice {

    public static void main(String[] args) {
        List<Integer> list =  new ArrayList<Integer>() {{
            add(3);
            add(44);
        }};
        System.out.println(getString(list));
    }

    public Double average(List<Integer> list) {
        return list.stream()
                .mapToInt(x -> x)
                .average()
                .getAsDouble();
    }

    public List<String> upperCase(List<String> list) {
        return list.stream().map(x -> x.toUpperCase())
                .collect(Collectors.toList());
    }

    public static String getString(List<Integer> list) {
        return list.stream()
                .map(i -> {
                    if(i%2 == 0)
                        return "e"+i;
                    else
                        return "o"+i;
                })
                .collect(joining(","));

    }
}
