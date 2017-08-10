package exmcollapsing.test.com.mvpdemo.net.subscriber;

import android.content.Context;
import android.widget.Toast;

import exmcollapsing.test.com.mvpdemo.net.UnauthException;
import exmcollapsing.test.com.mvpdemo.net.exception.ApiException;
import exmcollapsing.test.com.mvpdemo.net.exception.OtherException;
import exmcollapsing.test.com.mvpdemo.net.exception.base.BaseException;
import exmcollapsing.test.com.mvpdemo.net.exception.exceptionPreHandle.ExceptionHandle;
import exmcollapsing.test.com.mvpdemo.utils.KprogresshudUtils;
import exmcollapsing.test.com.mvpdemo.utils.NetWorkUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public abstract class RestAPIObserver<T> implements Observer<T> {

    private Context context;
    private boolean isShowProgress;

    public RestAPIObserver(Context context) {
        this(context, false);
    }

    public RestAPIObserver(Context context, boolean isShowProgress) {
        super();
        this.context = context;
        this.isShowProgress = isShowProgress;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Disposable d1 = d;
        if (isShowProgress) {
            KprogresshudUtils.show(context);
        }
        if(!NetWorkUtils.isNetConnected(context)){
            d.dispose();
            KprogresshudUtils.dismiss();
        }
    }


    @Override
    public void onNext(T t) {
        KprogresshudUtils.dismiss();
        _onSuccess(t);
    }

    @Override
    public void onComplete(){

    }

    @Override
    public void onError(Throwable e) {
        KprogresshudUtils.dismiss();
        BaseException baseException = ExceptionHandle.handleException(e);
        if (baseException instanceof ApiException) {
            switch (((ApiException) baseException).getHttpCode()) {
                case 400:
                    _onApiError((ApiException) baseException);
                    break;
                case 401:
                    break;
            }
        } else if (baseException instanceof UnauthException) {
            _onUnAuth((UnauthException) baseException);
        } else if (e instanceof OtherException) {
            _onOtherException((OtherException) baseException);
        }
    }


    public void _onSuccess(T t) {
        onSuccess(t);
    }

    public void _onApiError(ApiException e) {
        onApiError(e);
    }

    public void _onUnAuth(UnauthException e) {
        onUnAuth(e);
    }

    public void _onOtherException(OtherException e) {
        onOtherError(e);
    }

    public void onUnAuth(UnauthException e) {

    }

    protected void unlogin(){

    }

    protected abstract void onSuccess(T t);

    protected abstract void onApiError(ApiException e);

    protected void onOtherError(OtherException e){
        Toast.makeText(context,"其他错误", Toast.LENGTH_SHORT).show();
    }
}
