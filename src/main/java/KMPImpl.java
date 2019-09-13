import java.util.Arrays;

public class KMPImpl {

    public static void main(String[] args) {
        System.out.println(isPattern("ABABDABACDABABCABAB", "ABABCABAB"));
    }

    public static boolean isPattern(String string, String pattern) {
        int i = 0;
        int j= 0;
        int[] lcp = lcp(pattern);
        while(i < string.length() && j<pattern.length()) {
            char s = string.charAt(i);
            char p = pattern.charAt(j);

            if(s == p) {
                i++;
                j++;
                if(j == pattern.length()) {
                    return true;
                }
                continue;
            }

            if(j!=0) {
                j = lcp[j-1];
            } else {
                i++;
            }
        }
        return false;
    }

    public static int[] lcp(String pattern) {
        int j = 0;
        int[] lcp = new int[pattern.length()];
        char[] pat  = pattern.toCharArray();
        lcp[0] = 0;

        for(int i=1;i<lcp.length; i++) {

            if(pat[i] == pat[j]) {
                j+=1;
                lcp[i] = j;
                continue;
            }

            while(j > 0 && pat[j]!=pat[i]) {
                j = lcp[j-1];
            }
            if(pat[j] == pat[i]) {
                j+=1;
                lcp[i] = j;
            }
        }
        System.out.println(Arrays.toString(lcp));
        return lcp;
    }
}
