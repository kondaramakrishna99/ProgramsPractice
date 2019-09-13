public class IntToEngWords_leetcode273 {

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num) {
        if(num == 0)
            return "zero";

        String result = "";

        int billion = (int)Math.pow(10,9);
        if(num >= billion) {
            result+=helper(num/billion)+" Billion ";
            num = num % billion;
        }

        int million = (int)Math.pow(10,6);
        if(num >= million) {
            result+=helper(num/million)+" Million ";
            num = num % million;
        }

        int thousand = (int) Math.pow(10,3);
        if(num >= thousand) {
            result+=helper(num/thousand)+" Thousand ";
            num = num % thousand;
        }

        result+=helper(num);

        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(1234567891));
    }

    public static String helper(int num) {
        if(num == 0)
            return "";
        String result="";
        if(num >= 100) {
            result += LESS_THAN_20[num/100]+ " Hundred";
            num=num%100;
        }
        if(num>=20) {
            result+=" "+TENS[num/10];
            num = num% 10;
        }
        if(num!=0) {
            result+=" "+LESS_THAN_20[num];
        }
        return result.trim();

    }
}
