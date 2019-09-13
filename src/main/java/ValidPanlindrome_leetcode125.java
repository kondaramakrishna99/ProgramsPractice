public class ValidPanlindrome_leetcode125 {

    public static void main(String[] args) {
        String str = "race a car";
        str = str.toLowerCase();
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {

        int i= 0;
        int j = s.length()-1;

        while (i<=j) {
            while (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            if(i>j)
                return false;
            while (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(i>j || Character.toLowerCase(s.charAt(i)) !=Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
