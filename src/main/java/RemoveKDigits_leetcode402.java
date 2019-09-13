public class RemoveKDigits_leetcode402 {



    public static String removeKdigits(String num, int k) {
        boolean[] remove = new boolean[num.length()];

        for( int i= 0;i<num.length()-1;i++) {
            char curr = num.charAt(i);
            char next = num.charAt(i+1);
            if(Character.getNumericValue(curr) > Character.getNumericValue(next)) {
                remove[curr] = true;
                k--;
            }
            if(k == 0)
                break;
        }
        if(k>0) {
            for(int i=num.length()-1;i>=0 && k>0;i--) {
                remove[i] = true;
                k--;
            }
        }
        String result ="";
        for(int i=0;i<num.length();i++) {
            if(remove[i]==false) {
                result+=num.charAt(i);
            }
        }
        return Integer.parseInt(result)+"";
    }
}
