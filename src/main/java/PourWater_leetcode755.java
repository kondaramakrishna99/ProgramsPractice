public class PourWater_leetcode755 {

    public static void main(String[] args) {
        int[] heights = {2,1,1,2,1,2,2};
        pourWater(heights, 4, 3);
    }

    public static int[] pourWater(int[] heights, int V, int K) {

        if (heights == null || heights.length == 0 || V == 0) {
            return heights;
        }
        for(int i=0; i< V; i++) {

            int index = K;

            for(int j = K-1; j>=0; j--) {
                if (heights[j] > heights[j+1]) {
                    break;
                } else if (heights[j] < heights[j+1]) {
                    index = j;
                }
            }
            if (index != K) {
                heights[index]++;
                continue;
            }

            for(int j = K+1; j< heights.length ; j++) {
                if (heights[j] > heights[j-1]) {
                    break;
                } else if (heights[j] < heights[j-1]) {
                    index = j;
                }
            }

            heights[index]++;
        }
        return heights;
    }
}
