package exmcollapsing.test.com.mvpdemo.base;

import android.content.Context;

import exmcollapsing.test.com.mvpdemo.interf.MvpModel;
import exmcollapsing.test.com.mvpdemo.interf.MvpView;
import exmcollapsing.test.com.mvpdemo.interf.Presenter;


/**
 * Created by Boosal on 2017/3/3.
 */

public class BasePresenter<T extends MvpView,M extends MvpModel>  implements Presenter<T> {
    protected T mMvpView;
    protected M mMvpModel;
    protected Context context;

    public BasePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }
}
