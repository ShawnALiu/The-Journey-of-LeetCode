package designPattern.模板;

/**
 * @author lz
 * @date 2023/07/09 18:22
 **/
public class SeniorWriter extends AbstractWriteArticle {


    @Override
    protected void introduction() {
        System.out.println("Senior introduction!");
    }

    @Override
    protected void content() {
        System.out.println("Senior content!");
    }

    @Override
    protected void tai() {
        System.out.println("Senior tail!");
    }
}
