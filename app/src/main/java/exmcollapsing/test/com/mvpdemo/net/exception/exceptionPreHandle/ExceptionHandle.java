package exmcollapsing.test.com.mvpdemo.net.exception.exceptionPreHandle;

import com.google.gson.Gson;

import java.io.IOException;

import exmcollapsing.test.com.mvpdemo.net.UnauthException;
import exmcollapsing.test.com.mvpdemo.net.exception.ApiException;
import exmcollapsing.test.com.mvpdemo.net.exception.OtherException;
import exmcollapsing.test.com.mvpdemo.net.exception.ResponseError;
import exmcollapsing.test.com.mvpdemo.net.exception.base.BaseException;
import retrofit2.HttpException;

public class ExceptionHandle {

    public static BaseException handleException(Throwable e) {

        BaseException baseException = null;
        if (e instanceof HttpException) {             //HTTP错误
            HttpException httpException = (HttpException) e;

            if (httpException.code() == 400) {
                try {
                    String errorStr = httpException.response().errorBody().string();
                    ResponseError error = new Gson().fromJson(errorStr, ResponseError.class);
                    baseException = new ApiException(e, httpException.code());
                    ((ApiException) baseException).setResponseError(error);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else if (httpException.code() == 401) {
                baseException = new UnauthException(e, httpException.code());
            } else {
                baseException = new ApiException(e, httpException.code());
            }
        } else {
            baseException = new OtherException(e);
        }

        return baseException;

    }
}
