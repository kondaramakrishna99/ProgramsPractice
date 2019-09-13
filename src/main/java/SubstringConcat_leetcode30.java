import java.util.*;

public class SubstringConcat_leetcode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            map.put(words[i], map.getOrDefault(map.get(words[i]),0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int len = words[0].length();
        String[] sDic = new String[s.length()-len+1];
        for(int i=0;i<sDic.length;i++) {
            String str = s.substring(i,i+len);
            if(map.containsKey(str)) {
                sDic[i] = str;
            } else {
                sDic[i] = "";
            }
        }

        for(int i=0;i<len;i++) {
            int start = i;
            int found = 0;
            HashMap<String,Integer> tempMap = new HashMap<>();
            for(int j=i;j<=s.length()-len;j+=len) {
                String word = sDic[j];
                if(word.equals("")) {
                    found = 0;
                    start = j+len;
                    tempMap.clear();;
                    continue;
                } else  {
                    tempMap.put(word, tempMap.getOrDefault(tempMap.get(word),0)+1);
                    found++;
                }

                if(tempMap.get(word)>map.get(word)) {
                    while(!sDic[start].equals(word)) {
                        tempMap.put(sDic[start], tempMap.get(sDic[start])-1);
                        start+=len;
                        found--;
                    }
                    tempMap.put(word, tempMap.get(word)-1);
                    found--;
                    start+=len;
                }

                if(found == words.length)
                    res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findSubstring_goodsolution(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
