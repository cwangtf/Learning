package jiagou;

/**
 * @author xing_seng
 * @date 2020/8/25
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(val());
    }

    public static int val() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }
}
