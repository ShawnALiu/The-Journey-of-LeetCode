package designPattern.工厂.抽象工厂;

/**
 * 抽象工厂接口
 *
 * @author lz
 * @date 2023/07/08 23:45
 **/
public abstract class AbstractAnimalFactory {

    public abstract Cat createCat(String color);

    public abstract Dog createDog(String color);
}
