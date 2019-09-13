public class InterleaveString_leetcode97 {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static  boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1,s2,s3,0,0,0);
    }

    public static boolean isInterleave(String s1, String s2, String s3, int i, int j, int k) {

        if(i==s1.length() && j==s2.length() && k==s3.length()) {
            return true;
        } else if(k==s3.length()) {
            return false;
        }


        boolean result = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = isInterleave(s1,s2,s3, i+1, j,k+1);
        }

        if(j<s2.length() &&  s2.charAt(j) == s3.charAt(k)) {
            result = result || isInterleave(s1,s2,s3, i, j+1,k+1);
        }

        return result;
    }

}
