import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestFilePath_leetcode388 {

    public static void main(String[] args) {
        System.out.println(lengthLongestPath1("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public static int lengthLongestPath(String input) {
        String[] levels = input.split("\n");
        List<String> list = new ArrayList<>();
        int length = 0;
        int max = 0;
        for (int i = 0; i < levels.length; i++) {
            int currLevel = getLevels(levels[i]);
            String curr = levels[i];
            while (list.size() > currLevel) {
                String temp = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                length = length - temp.length();
            }
            if (list.size() <= currLevel) {
                list.add(curr.substring(currLevel));
                length += curr.substring(currLevel).length();
                if (curr.contains(".")) {
                    max = Math.max(max, length + currLevel);
                }
            }
        }

        return max;
    }

    public static int getLevels(String str) {
        int count = 0;
        int i = 0;
        while (str.charAt(i) == '\t') {
            count++;
            i++;
        }
        return count;
    }

    public static int lengthLongestPath1(String input) {
        Map<Integer, String> map = new HashMap<>();
        int maxLength = 0;
        String[] levels = input.split("\n");
        for (int i=0;i<levels.length;i++) {
            String str = levels[i];
            int level = findLevel(str);
            map.put(level, str.substring(level));
            if (str.contains(".")) {
                maxLength = Math.max(maxLength, getLengthOfFile(level, map));
            }
        }
        return maxLength;
    }

    public static int getLengthOfFile(int level, Map<Integer, String> map) {
        int length = 0;
        for(int i = 0; i<=level;i++) {
            length+=map.get(i).length();
        }
        return length+level;
    }

    public static int findLevel(String levelString) {
        int level = 0;

        for(int i=0;i<levelString.length();i++) {
            char c = levelString.charAt(i);
            if(c != '\t') {
                return level;
            }
            level++;
        }
        return level;
    }
}
