import java.util.Arrays;
import java.util.List;

public class StringMultiply_leetcode43 {

    public static void main(String[] args) {
        System.out.println( multiply("123","456"));
    }

    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()];

        for(int i=num1.length()-1;i>=0;i--) {
            for (int j=num2.length()-1;j>=0;j--) {
                int prod = Character.getNumericValue(num1.charAt(i))*Character.getNumericValue(num2.charAt(j));
                int sum = result[i+j+1]+prod;
                result[i+j+1] = sum%10;
                result[i+j]= result[i+j]+sum/10;
            }
        }
        System.out.println(Arrays.toString(result));
        return "";
    }
}
