package designPattern.单例;

/**
 * 懒汉:只是懒而已，但是没有饥不择食，用的时候再去创建
 * 线程安全：双重校验+锁
 *
 * @author lz
 * @date 2023/07/08 23:02
 **/
public class Singleton懒汉 {

    private static volatile Singleton懒汉 ins;

    private Singleton懒汉() {
    }

    private static Singleton懒汉 getIns() {
        if (ins == null) {
            synchronized (Singleton懒汉.class) {
                if (ins == null) {
                    ins = new Singleton懒汉();
                }
            }
        }
        return ins;
    }

}
