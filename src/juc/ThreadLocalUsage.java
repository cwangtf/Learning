package juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangtf
 * @date 2021/4/10
 */
public class ThreadLocalUsage {

    public static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            THREAD_POOL.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalUsage().date(finalI);
                    System.out.println(date);
                }
            });
        }
        THREAD_POOL.shutdown();
    }

    private String date(int seconds) {
        // 参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000L * seconds);
        SimpleDateFormat simpleDateFormat = ThreadSafeDateFormatter.dateFormatThreadLocal.get();
        return simpleDateFormat.format(date);
    }

}

class ThreadSafeDateFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

}
