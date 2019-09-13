import java.util.HashMap;
import java.util.Map;

public class IntToRoman_leetcode12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static String intToRoman2(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String result="";
        for(int i=0;i<values.length;i++) {
            while(num > values[i]) {
                result+=strs[i];
                num-=values[i];
            }
        }
        return result;
    }

    public static String intToRoman(int num) {

        String[] ones = new String[]{"-", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[]{"-", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = new String[]{"-", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = new String[]{"-", "M", "MM", "MMM", "MMMM"};


        return thousands[(num%10000)/1000]+hundreds[(num%1000)/100]+tens[(num%100)/10]+ones[num%10];
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer> (){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int result = map.get(s.charAt(s.length()-1));
        for(int i = s.length()-2; i>=0; i--) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                result-=map.get(s.charAt(i));
            } else {
                result+=map.get(s.charAt(i));
            }
        }

        return result;

    }

}
