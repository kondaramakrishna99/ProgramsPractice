public class SentenceScreen_leetcode418 {

    public static void main(String[] args) {
        String[] sentence = {"a"};
        System.out.println(wordsTyping(sentence, 20000, 20000));
    }

    //nice code from leetcode
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        int[] nextIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for(int i=0;i<sentence.length;i++) {
            int curLen = 0;
            int cur = i;
            int time = 0;
            while(curLen + sentence[cur].length() <= cols) {
                curLen += sentence[cur++].length()+1;
                if(cur==sentence.length) {
                    cur = 0;
                    time ++;
                }
            }
            nextIndex[i] = cur;
            times[i] = time;
        }
        int ans = 0;
        int cur = 0;
        for(int i=0; i<rows; i++) {
            ans += times[cur];
            cur = nextIndex[cur];
        }
        return ans;
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {

        int count = 0;
        int iter = 0 ;
        int size = sentence.length;
        int i = 0;
        for(i=0;i<rows;i++) {
            int j =0;
            while(j+sentence[iter].length()-1 <= cols-1) {
                 j = j+sentence[iter].length()+1;
                if(iter == size - 1)
                    count++;
                iter = (iter+1)%size;
            }
        }

        return count;
    }

}
