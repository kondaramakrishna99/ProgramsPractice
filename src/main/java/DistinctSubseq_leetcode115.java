public class DistinctSubseq_leetcode115 {
    static int count = 0;

    public static void main(String[] args) {

        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        numDistinct(s, t, 0,0);
        return  count;
    }

    public static void numDistinct(String s, String t, int i, int j) {

        if(i == s.length() || j==t.length())
            return;

        if(s.substring(i).equals(t.substring(j))) {
            count++;
            return;
        }

        if(s.charAt(i) == t.charAt(j)) {
            numDistinct(s,t, i+1, j+1);
        }

        numDistinct(s,t,i+1, j);

    }
}
