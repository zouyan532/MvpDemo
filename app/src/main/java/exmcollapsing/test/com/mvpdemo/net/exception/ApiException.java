package exmcollapsing.test.com.mvpdemo.net.exception;


import exmcollapsing.test.com.mvpdemo.net.exception.base.BaseException;

public class ApiException extends BaseException {

    private int httpCode;

    private ResponseError responseError;

    public ApiException(Throwable throwable, int httpCode) {
        super(throwable);
        this.httpCode=httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public ResponseError getResponseError() {
        return responseError;
    }

    public void setResponseError(ResponseError responseError) {
        this.responseError = responseError;
    }
}
