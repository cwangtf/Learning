package jiagou;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author wangtf
 * @date 2020/7/19
 */
public class BenchMark {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws InterruptedException {
        BenchMark benchMark = new BenchMark();
        benchMark.bench("https://www.baidu.com/", 100, 10);
    }

    public void bench(String url, Integer requestTotal, Integer threadNum) throws InterruptedException {
        Queue<Long> timeQueue = new ConcurrentLinkedQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        Semaphore semaphore = new Semaphore(threadNum);
        for (int i = 0; i < requestTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    long startTime = System.nanoTime();
                    sendGet(url);
                    timeQueue.add(System.nanoTime() - startTime);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        printTime(timeQueue);
    }

    public void printTime(Queue<Long> timeQueue) {
        List<Long> times = new ArrayList<>(timeQueue);
        double average = times.stream().mapToLong(Long::longValue).average().getAsDouble();
        System.out.println("平均响应时间：" + (average / 1000000000.0));
        Collections.sort(times);
        int index = (int) Math.ceil(95 / 100.0 * times.size());
        double percent = times.get(index);
        System.out.println("95%响应时间：" + (percent / 1000000000.0));
    }

    // HTTP GET请求
    private void sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //默认值GET
        con.setRequestMethod("GET");

        //添加请求头
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //打印结果
//        System.out.println(response.toString());

    }
}
