public class ReplaceString {

    public static void main(String[] args) {
        String str = "abcdefabc def";

        String find = "abc";
        String replace = "klm";

        String result = "";
        for(int i=0; i<str.length();i++) {

            if(str.startsWith(find, i)) {
                result+=replace;
                i+=find.length()-1;
                continue;
            }

            result+=str.charAt(i);
        }

        System.out.println(result);
    }


}
