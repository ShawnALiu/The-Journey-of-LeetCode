package designPattern.模板;

/**
 * @author lz
 * @date 2023/07/09 18:22
 **/
public class PrimaryWriter extends AbstractWriteArticle {
    
    @Override
    protected void introduction() {
        System.out.println("Primary introduction!");
    }

    @Override
    protected void content() {
        System.out.println("Primary content!");
    }

    @Override
    protected void tai() {
        System.out.println("Primary tail!");
    }
}
