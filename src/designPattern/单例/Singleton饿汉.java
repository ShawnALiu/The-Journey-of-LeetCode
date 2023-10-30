package designPattern.单例;

/**
 * 饿汉 - 太饿了，饥不择食，直接拿来用
 * 线程安全：类加载时直接创建示例
 *
 * @author lz
 * @date 2023/07/08 22:55
 **/
public class Singleton饿汉 {

    private static volatile Singleton饿汉 ins = new Singleton饿汉();

    private Singleton饿汉() {
    }

    public static Singleton饿汉 getIns() {
        return ins;
    }

}
