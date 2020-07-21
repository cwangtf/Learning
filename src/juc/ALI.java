package juc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有 3 个独立的线程，一个只会输出 A，一个只会输出 L，一个只会输出 I。
 * 在三个线程同时启动的情况下，请用合理的方式让他们按顺序打印 ALIALI。
 * 三个线程开始正常输出后，主线程若检测到用户任意的输入则停止三个打印线程的工 作，整体退出。
 *
 * @author xing_seng
 * @date 2020/7/21
 */
public class ALI {

    private static int state = 0;

    private static boolean flag = true;

    public static void main(String[] args) throws IOException {
        final Lock l = new ReentrantLock();

        Thread A = new Thread(() -> {
            while (flag) {
                l.lock();
                if (state % 3 == 0) {
                    System.out.println("A");
                    ++state;
                }
                l.unlock();
            }
        });

        Thread B = new Thread(() -> {
            while (flag) {
                l.lock();
                if (state % 3 == 1) {
                    System.out.println("L");
                    ++state;
                }
                l.unlock();
            }
        });

        Thread C = new Thread(() -> {
            while (flag) {
                l.lock();
                if (state % 3 == 2) {
                    System.out.println("I");
                    ++state;
                }
                l.unlock();
            }
        });

        A.start();
        B.start();
        C.start();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        if (Objects.nonNull(bufferedReader.readLine())) {
            flag = false;
            A.interrupt();
            B.interrupt();
            C.interrupt();
        }
    }
}
