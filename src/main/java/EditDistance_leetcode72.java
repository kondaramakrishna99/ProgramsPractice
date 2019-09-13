public class EditDistance_leetcode72 {

    public static void main(String[] args) {
//        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("horse", "ros"));

    }

    public static int minDistance(String word1, String word2) {
        int[][] matrix = new int[word1.length()+1][word2.length()+1];
        return minDist(word1,0, word2, 0, matrix);
    }

    public static int minDist(String word1, int index1, String word2, int index2, int[][] matrix) {

        if(matrix[index1][index2]!=0)
            return matrix[index1][index2];

        if(index1 == word1.length() && index2 == word2.length()) {
            matrix[index1][index2] = 0;
            return 0;
        }


        if(index1 == word1.length()) {
            matrix[index1][index2] = word2.length()-index2;
            return word2.length()-index2;
        }

        if(index2 == word2.length()) {
            matrix[index1][index2] = word1.length() - index1;
            return word1.length() - index1;
        }

        if(word1.equals(word2)) {
            matrix[index1][index2] = 0;
            return 0;
        }

        if(word1.charAt(index1) == word2.charAt(index2)) {
            matrix[index1][index2] = minDist(word1, index1+1, word2, index2+1, matrix);
            return matrix[index1][index2];
        }

        matrix[index1+1][index2] = minDist(word1, index1+1, word2, index2, matrix);
        matrix[index1][index2+1] = minDist(word1, index1, word2, index2+1, matrix);
        matrix[index1+1][index2+1] = minDist(word1, index1+1, word2, index2+1, matrix);

        return 1+Math.min(Math.min(matrix[index1+1][index2], matrix[index1][index2+1]),
                matrix[index1+1][index2+1]);
    }

    //copied from leetcode
    public int minDistance_concise(String word1, String word2) {
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        for(int i = 0; i <= word2.length(); i++) {
            for(int j = 0; j <= word1.length(); j++) {
                if(i == 0 && j == 0) dp[i][j] = 0; // no strings given
                else if(i == 0 && j != 0) {
                    dp[i][j] = j; // word2 is empty
                } else if(i != 0 && j == 0) {
                    dp[i][j] = i; // word1 is empty
                } else if(word2.charAt(i-1) != word1.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }else {
                    dp[i][j] = dp[i-1][j-1]; // same characters just carry over previous chars from both
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }

}
