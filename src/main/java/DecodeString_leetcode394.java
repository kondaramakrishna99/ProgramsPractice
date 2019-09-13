public class DecodeString_leetcode394 {

    int pos = 0;

    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
    public static String decodeString(String s) {

        String result = "";
        for (int i= 0;i<s.length();i++) {
            char c = s.charAt(i);
            int num = 0;
            if (Character.isLetter(c)) {
                result+=c;
            }
            if(Character.isDigit(c)) {
                String temp = "";
                while (Character.isDigit(s.charAt(i))) {
                    temp+=s.charAt(i);
                    i++;
                }
                num = Integer.parseInt(temp);
                System.out.println(s.charAt(i));
            }
            if(s.charAt(i)=='[') {
                int matchingIndex = matchingIndex(s, i+1);
                String dfs = decodeString(s.substring(i+1,matchingIndex));
                for(int j=0;j<num;j++) {
                    result+=dfs;
                }
                i = matchingIndex;
            }
        }
        return result;
    }

    public static int matchingIndex(String str, int i) {
        int count=1;
        while(count!=0) {
            char c = str.charAt(i);
            if (c=='[') {
                count++;
            } else if(c==']') {
                count--;
            }
            i++;
        }
        return i-1;
    }

}
