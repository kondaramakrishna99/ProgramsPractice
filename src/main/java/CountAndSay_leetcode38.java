public class CountAndSay_leetcode38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String result = "1";

        for(int i=2;i<=n;i++) {

            String temp = "";
            int count=0;
            String pres = "";
            for(int j=0;j<result.length();j++) {
                if(j==0) {
                    pres = result.charAt(0)+"";
                    count=1;
                    continue;
                }

                if(result.charAt(j)!=result.charAt(j-1)) {
                    temp+=count+""+pres;
                    pres = result.charAt(j)+"";
                    count=1;
                    continue;
                } else  {
                    count++;
                }
            }
            temp=temp+ count+""+pres;
            result = temp;
            System.out.println(result);
        }
        return result;
    }
}
