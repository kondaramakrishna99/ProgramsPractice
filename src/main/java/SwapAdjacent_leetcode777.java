import java.util.Arrays;
import java.util.PriorityQueue;

public class SwapAdjacent_leetcode777 {

    public static void main(String[] args) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> a.key - b.key);
        queue.offer(new Pair(1,2));
        System.out.println(queue.contains(new Pair(1,2)));
        queue.remove(new Pair(1,2));
        System.out.println(queue.toString());
        String email = "abc@bdg.com";
        System.out.println(email.indexOf('+')+"  "+email.contains("+"));
        System.out.println(Arrays.toString(email.split("@")));
    }

    static class Pair{
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            Pair b = (Pair)obj;
            return this.key == b.key && this.value == b.value;

        }


    }

    //wrong solution
    public boolean canTransform(String start, String end) {
        if (start.equals(end))
            return true;

        if(start.length() != end.length()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(start);

        for(int i=0; i<start.length(); i++) {
            if(start.charAt(i) == end.charAt(i)) {
                continue;
            }

            if (start.charAt(i) == 'R' && (i+1) < start.length() && start.charAt(i+1) == 'X') {
                if (end.charAt(i) == 'X' && (i+1) < end.length() && end.charAt(i+1) == 'R') {
                    i = i+1;
                    continue;
                } else {
                    return false;
                }
            } else if (start.charAt(i) == 'X' && (i+1) < start.length() && start.charAt(i+1) == 'L') {
                if (end.charAt(i) == 'L' && (i+1) < end.length() && end.charAt(i+1) == 'X') {
                    i = i+1;
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
