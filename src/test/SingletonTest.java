package test;

/**
 * @author lz
 * @date 2023/07/17 21:45
 **/
public class SingletonTest {

    private static volatile SingletonTest ins;

    private SingletonTest() {

    }

    public static SingletonTest getIns() {
        if (ins == null) {
            synchronized (SingletonTest.class) {
                if (ins == null) {
                    ins = new SingletonTest();
                }
            }
        }
        return ins;
    }

    public void sayHello() {
        System.out.println("hello!");
    }

    
}
