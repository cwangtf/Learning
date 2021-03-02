package proxy.test;

/**
 * @author wangtf
 * @date 2020/8/26
 */
public class TargetImpl implements Target {

    @Override
    public int test(int i) {
        return i + 1;
    }
}
