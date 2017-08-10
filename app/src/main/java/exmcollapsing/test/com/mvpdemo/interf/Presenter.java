package exmcollapsing.test.com.mvpdemo.interf;

/**
 * Created by Boosal on 2017/3/3.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
