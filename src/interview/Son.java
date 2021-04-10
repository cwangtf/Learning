package interview;

/**
 * @author wangtf
 * @date 2021/4/6
 */
public class Son extends Father {
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类非静态代码块");
    }

    public Son() {
        System.out.println("子类构造函数");
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
