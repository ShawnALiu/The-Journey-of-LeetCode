package designPattern.模板;

/**
 * @author lz
 * @date 2023/07/09 18:20
 **/
public abstract class AbstractWriteArticle {

    protected abstract void introduction();

    protected abstract void content();

    protected abstract void tai();

    public void write() {
        introduction();
        content();
        tai();
    }

}
