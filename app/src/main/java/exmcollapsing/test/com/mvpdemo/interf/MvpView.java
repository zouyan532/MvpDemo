package exmcollapsing.test.com.mvpdemo.interf;

/**
 * Created by Boosal on 2017/3/3.
 */

public interface MvpView {

    void showError(int errorCode);

    void showEmpty(String msg);
}
