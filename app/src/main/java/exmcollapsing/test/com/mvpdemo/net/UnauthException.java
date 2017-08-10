package exmcollapsing.test.com.mvpdemo.net;


import exmcollapsing.test.com.mvpdemo.net.exception.base.BaseException;

public class UnauthException extends BaseException {

    private int httpCode;

    public UnauthException(Throwable throwable, int httpCode) {
        super(throwable);
        this.httpCode=httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

}
