package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://zhuanlan.zhihu.com/p/97292945
 *
 * @author xing_seng
 * @date 2020/7/8
 */
public class MyQueue {

    /** 锁 */
    private Lock lock = new ReentrantLock();
    /** 存储消息集合 */
    private List listQueue = new ArrayList();
    /** 队列不为空 */
    private Condition notNull = lock.newCondition();
    /** 队列不为满 */
    private Condition notFull = lock.newCondition();

    public void add(String message) {
        /** */
//        lock.lock();
    }
}
