package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C，要求, 同时启动三个线程, 按顺序输出ABC, 循环10次。
 *
 * @author xing_seng
 * @date 2020/7/21
 */
public class ABC {
    private static int state = 0;

    private static int end = 30;

    public static void main(String[] args) {
        final Lock l = new ReentrantLock();

        Thread A = new Thread(() -> {
            while (state <= end) {
                l.lock();
                if (state % 3 == 0) {
                    System.out.println("A");
                    ++state;
                }
                l.unlock();
            }
        });

        Thread B = new Thread(() -> {
            while (state <= end) {
                l.lock();
                if (state % 3 == 1) {
                    System.out.println("B");
                    ++state;
                }
                l.unlock();
            }
        });

        Thread C = new Thread(() -> {
            while (state <= end) {
                l.lock();
                if (state % 3 == 2) {
                    System.out.println("C");
                    ++state;
                }
                l.unlock();
            }
        });

        A.start();
        B.start();
        C.start();
    }
}
