import java.util.ArrayList;
import java.util.List;

public class GenerateAbbrev_leetcode320 {

    public static void main(String[] args) {
        System.out.println(generateAbbreviations("wo").toString());
    }

    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        int len = word.length();
        res.add(len==0 ? "" : String.valueOf(len));
        for(int i = 0 ; i < len ; i++)
            for(String right : generateAbbreviations(word.substring(i+1))){
                String leftNum = i > 0 ? String.valueOf(i) : "";
                res.add( leftNum + word.substring(i,i + 1) + right );
            }
        return res;
    }

    /*
    public List<String> generateAbbreviations(String word) {
            List<String> res = new ArrayList<String>();
            helper(word, 0, "", res, false);
            return res;
        }
        // isAbbrPrev: false, we can add alphabet or abbreviation(number) next round
        // isAbbrPrev: true,  we can add alphabet ONLY next round
        public void helper(String word, int start, String cur, List<String> res, boolean isAbbrPrev) {
            if (start == word.length()) {
                res.add(cur);
                return;
            }
            if (isAbbrPrev == false) { // we can add abbreviation (num)
                for(int end=start+1; end<=word.length(); end++) { // iterate all abbreviations from 'start'
                    helper(word, end, cur + Integer.toString(end-start), res, true);
                }
            }
            helper(word, start+1, cur + word.charAt(start), res, false); // adding one word each time
        }
     */
}
