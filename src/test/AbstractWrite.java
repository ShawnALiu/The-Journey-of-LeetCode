package test;

/**
 * @author lz
 * @date 2023/07/17 22:02
 **/
public abstract class AbstractWrite {

    protected abstract void introduction();

    protected abstract void body();

    protected abstract void ending();

    public void write() {
        introduction();
        body();
        ending();
    }
}
