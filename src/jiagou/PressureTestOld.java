package jiagou;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 压测代码参考
 *
 * @author xing_seng
 * @date 2020/7/24
 */
public class PressureTestOld {
    private static final String USER_AGENT = "HttpClient/3.1/PP";
    private static final String CHARSET_UTF = "UTF-8";
    /** 多线程中安全的使用httpClient */
    private MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
    private HttpClient httpClient = new HttpClient(httpConnectionManager);
    private ExecutorService executor;
    /** 测试url */
    private String testUrl;
    /** 请求总次数 */
    private Integer testLength;
    /** 并发数 */
    private Integer currentCount;

    private SortedMap<Long, Integer> testResult = new TreeMap<>();

    public PressureTestOld(String testUrl, Integer testLength, Integer currentCount) {
        this.testUrl = testUrl;
        this.currentCount = currentCount;
        this.testLength = testLength;
        this.executor = Executors.newFixedThreadPool(currentCount);
    }

    public void testing(Integer percentTime) {
        for (int i = 0; i < testLength; i++) {
            executor.execute(() -> {
                long startTime = System.currentTimeMillis();
                try {
                    httpGet(testUrl);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                long time = System.currentTimeMillis() - startTime;
                synchronized (testResult.getClass()) {
                    Integer getVal = testResult.get(time);
                    if (getVal == null) {
                        getVal = 0;
                    }
                    testResult.put(time, ++getVal);
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 计算响应时长
        testResultTime(percentTime);
    }

    public void testResultTime(Integer percentTime) {
        // 总时长
        long timeCount = 0L;
        // 95总时长
        long timeCunt95 = 0L;
        // 统计95的数量
        double count95 = 0.0;
        // 用百分比转化为需要查看的请求数的平均响应时长
        double countTime = testLength * percentTime * 0.01;
        for(Map.Entry<Long, Integer> entry : testResult.entrySet()) {
            timeCount += entry.getKey() * entry.getValue();
            if (count95 < countTime) {
                if ((count95 = count95 + entry.getValue() * 1.0) >= countTime) {
                    timeCunt95 = timeCount;
                }
            }
        }
        System.out.println("平均响应时间：" + (timeCount / testLength));
        System.out.println("95平均响应时间：" + (timeCunt95 / countTime));
    }

    public Integer httpGet(String fullUrl) {
        GetMethod method = new GetMethod(fullUrl);
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, CHARSET_UTF);
        method.addRequestHeader("User-Agent", USER_AGENT);
        try {
            return httpClient.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放连接
            method.releaseConnection();
        }
        return 0;
    }

    public static void main(String[] args) {
        PressureTestOld pressureTestOld = new PressureTestOld("https://www.baidu.com/", 100, 10);
        pressureTestOld.testing(95);
    }
}
