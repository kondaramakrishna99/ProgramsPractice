import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OptimalAccountBalance_leetcode465 {
    //https://leetcode.com/problems/optimal-account-balancing/discuss/130895/Recursion-Logical-Thinking
    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(15));
        System.out.println(Math.random());
        Random random = new Random();
        int[][] input = {{0,1,10}, {1,0,1}, {1,2,5}, {2,0,4}};
        System.out.println(minTransfers(input));
    }

    public static int minTransfers(int[][] transactions) {

        int giver, taker, debtAmount;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] transaction : transactions) {
            giver = transaction[0];
            taker = transaction[1];
            debtAmount = transaction[2];
            map.put(giver, map.getOrDefault(giver, 0) - debtAmount);
            map.put(taker, map.getOrDefault(taker, 0) + debtAmount);
        }
        int[] debts = new int[map.size()];
        int di = 0;
        for (int person : map.keySet()) {
            debts[di++] = map.get(person);
        }

        return minTransfersFrom(debts, 0);
    }

    private static int minTransfersFrom(int[] debts, int curId) {

        while (curId < debts.length && debts[curId] == 0) {
            curId++;
        }

        if (curId == debts.length) {
            return 0;
        }

        int minimumTransfers = Integer.MAX_VALUE;

        for (int i = curId + 1; i < debts.length; i++) {
            if (debts[i] * debts[curId] < 0) {
                debts[i] += debts[curId];
                minimumTransfers = Math.min(minimumTransfers, 1 + minTransfersFrom(debts, curId + 1));
                debts[i] -= debts[curId];
            }
        }

        return minimumTransfers;
    }

}
