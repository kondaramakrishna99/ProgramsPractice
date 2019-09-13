public class MaxProduct_leetcode318 {

    public static void main(String[] args) {
        String str = "ade";
        int i =0;
        for(char c:str.toCharArray()) {
            i = i | 1<<(c-'a');
            System.out.println(Integer.toBinaryString(i));
        }

        str = "def";
        int j=0;
        for(char c:str.toCharArray()) {
            j = j | 1<<(c-'a');
            System.out.println(Integer.toBinaryString(j));
        }

        int k = i&j;
        System.out.println(k+ " "+ (k==0));
    }
}
