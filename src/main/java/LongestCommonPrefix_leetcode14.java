public class LongestCommonPrefix_leetcode14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a", "a", "b"}));
        System.out.printf("abc".substring(0,0));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length ==0)
            return null;

        String lcp = strs[0];

        for(int i = 0; i < lcp.length(); i++) {
            for(int j=1;j<strs.length;j++) {
                if(i==strs[j].length() || strs[j].charAt(i) != lcp.charAt(i)) {
                    return lcp.substring(0, i) == null ? "" : lcp.substring(0,i);
                }
            }
        }
        return lcp;
    }

}
