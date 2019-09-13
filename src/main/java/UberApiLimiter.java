import java.util.Queue;
import java.util.concurrent.TimeUnit;

import java.util.LinkedList;

public class UberApiLimiter {

    public static void main(String[] args) {
        long time1  = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();

        long diff = time2 - time1;
        if(Math.abs(diff) > 1000) {
            System.out.println("diff greater than ");
        }
        System.out.println(time1+"  "+time2+"  "+diff);

        Queue<Long> queue = new LinkedList<>();

        synchronized(queue) {
            queue.poll();
            queue.offer(1L);
        }
    }

    public void multiThreads() {

        
    }


}
