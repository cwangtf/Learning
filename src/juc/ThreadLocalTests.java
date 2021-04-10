package juc;

/**
 * @author wangtf
 * @date 2021/4/5
 */
public class ThreadLocalTests {
    static ThreadLocal<String> value = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        value.set("hello world");
        System.out.println(Thread.currentThread() + "- (1)获取到value的值为：" + value.get());
        // 开启一个线程
        new Thread(() -> System.out.println(Thread.currentThread() + "- (2)获取到value的值为：" + value.get())).start();
        Thread.sleep(2000L);
    }
}
