package test;

/**
 * @author lz
 * @date 2023/07/17 21:57
 **/
public class AnimalFactory {

    public static Animal getAnimal(String name) {
        if ("Cat".equalsIgnoreCase(name)) {
            return new Cat();
        } else if ("Dog".equalsIgnoreCase(name)) {
            return new Dog();
        }
        return null;
    }

}
