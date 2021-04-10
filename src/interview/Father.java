package interview;

/**
 * @author wangtf
 * @date 2021/4/6
 */
public class Father {
    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类非静态代码块");
    }

    public Father() {
        System.out.println("父类构造函数");
    }
}
