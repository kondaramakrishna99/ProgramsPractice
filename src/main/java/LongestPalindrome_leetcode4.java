public class LongestPalindrome_leetcode4 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("bbbbbb"));
        printAllSubstrings("abcde");
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static boolean isPalindrome(String str) {
        if(str == null || str.length()==1) {
            return true;
        }
        int i,j;
        if(str.length()%2==0) {
            i=str.length()/2-1;
        } else {
            i = str.length()/2;
        }
        j=str.length()/2;
        while(i>=0 && j<str.length()) {
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void printAllSubstrings(String str) {
        for(int i=0;i<str.length();i++) {
            for(int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }
}
