package jiagou;

import static sun.net.InetAddressCachePolicy.get;

/**
 * @author xing_seng
 * @date 2020/8/27
 */
public class CAS {
    public final int getAndIncrement() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next)) {
                return current;
            }
        }
    }

    private boolean compareAndSet(int current, int next) {
        return false;
    }
}
