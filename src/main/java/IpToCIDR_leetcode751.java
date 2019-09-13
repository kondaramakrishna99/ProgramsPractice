import java.util.ArrayList;
import java.util.List;

public class IpToCIDR_leetcode751 {


    public static void main(String[] args) {
        int i =24;

        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.highestOneBit(i));
        System.out.println(Integer.lowestOneBit(i));
        System.out.println(ipToCIDR("255.0.0.7", 10).toString());
    }

    public static List<String> ipToCIDR(String ip, int n) {

        String[] ips = ip.split("\\.");
        long num = 0;
        for(int i=0;i<ips.length;i++) {
            num = num*256 + Integer.parseInt(ips[i]);
        }
        System.out.println(num);
        List<String> ans = new ArrayList<>();

        while (n > 0) {
            int trailingZeroes = Long.numberOfTrailingZeros(num);
            int count = (int) Math.pow(2, trailingZeroes);
            int len = 32 - trailingZeroes;
            while(count > n) {
                count = count/2;
                len++;
            }
            ans.add(longToIp(num, len));
            num+=count;
            n-=count;
        }
        return ans;
    }

    public static String longToIp(long num, int len) {
        int[] nums = new int[4];

        nums[0] = (int)(num & 255);
        num = num >> 8;

        nums[1] = (int)(num & 255);
        num = num >> 8;

        nums[2] = (int)(num & 255);
        num = num >> 8;

        nums[3] = (int)(num & 255);

        String ip = nums[3]+"."+nums[2]+"."+nums[1]+"."+nums[0]+"/"+len;
        return ip;
    }

}
