package test;

/**
 * @author lz
 * @date 2023/07/17 21:45
 **/
public class DesignPatternTest {

    public static void main(String[] args) {
        SingletonTest ins = SingletonTest.getIns();
        ins.sayHello();

        Animal cat = AnimalFactory.getAnimal("Cat");
        cat.eat();
    }
}
