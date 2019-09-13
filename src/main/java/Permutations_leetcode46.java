import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations_leetcode46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,1,3,3}));
//        permute_iterative(new int[]{1,2,3});

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList =Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numsList);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute_dfs(numsList, new ArrayList<Integer>(), result);
        return result;
    }

    public static void permute_dfs(List<Integer> nums,  List<Integer> curr, List<List<Integer>> result) {

        if(nums.size() == 0) {
            result.add(new ArrayList<>(curr));
            System.out.println(curr);
        }

        for (int i=0;i<nums.size();i++) {
            if(i!=0 && nums.get(i)==nums.get(i-1))
                continue;
            int temp = nums.get(i);
            curr.add(temp);
            nums.remove(i);
            permute_dfs(nums, curr, result);
            nums.add(i, temp);
            curr.remove(curr.size()-1);
        }
    }

    public static void permute_iterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        result.add(temp);

        for(int i=1;i<nums.length;i++) {
            int size = result.size();
            for(int j=0;j<size;j++) {
                List<Integer> list = result.remove(0);
                for(int k=0;k<=list.size();k++) {
                    List<Integer> tempList = new ArrayList<>(list);
                    tempList.add(k, nums[i]);
                    result.add(tempList);
                }
            }
            System.out.println(result.toString());
        }
    }

}
