package designPattern.工厂.抽象工厂.impl;

import designPattern.工厂.抽象工厂.AbstractAnimalFactory;
import designPattern.工厂.抽象工厂.Cat;
import designPattern.工厂.抽象工厂.Dog;

/**
 * @author lz
 * @date 2023/07/08 23:52
 **/
public class AbstractFactoryImpl extends AbstractAnimalFactory {

    @Override
    public Cat createCat(String color) {
        if ("Black".equals(color)) {
            return new BlackCat();
        } else if ("White".equals(color)) {
            return new WhiteCat();
        }
        return null;
    }

    @Override
    public Dog createDog(String color) {
        if ("Black".equals(color)) {
            return new BlackDog();
        } else if ("White".equals(color)) {
            return new BlackDog();
        }
        return null;
    }
}
