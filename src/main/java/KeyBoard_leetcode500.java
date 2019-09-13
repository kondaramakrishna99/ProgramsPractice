import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class KeyBoard_leetcode500 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    public static String[] findWords(String[] words) {

        String[] keyboard = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<keyboard.length; i++) {
            for(char c: keyboard[i].toCharArray()) {
                map.put(c, i);
            }
        }
        System.out.println(map.toString());
        List<String> result = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            if (words[i] == null || words[i].isEmpty())
                continue;
            int row = map.get(words[i].charAt(0));
            int j=1;
            for(j=1; j < words[i].length(); j++) {
                char c= Character.toUpperCase(words[i].charAt(j));
                if(map.get(c) != row)
                    break;
            }
            if(j == words[i].length()) {
                result.add(words[i]);
            }
        }

        return result.stream().toArray(String[]::new);
    }
}
