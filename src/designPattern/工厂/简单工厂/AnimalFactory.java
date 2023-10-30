package designPattern.工厂.简单工厂;

/**
 * @author lz
 * @date 2023/07/08 23:35
 **/
public class AnimalFactory {

    /**
     * 工厂一般为单例，方法为静态方法
     */
    public static Animal createAnimal(String name) {
        if ("Cat".equals(name)) {
            return new Cat();
        } else if ("Dog".equals(name)) {
            return new Dog();
        }
        return null;
    }

}
