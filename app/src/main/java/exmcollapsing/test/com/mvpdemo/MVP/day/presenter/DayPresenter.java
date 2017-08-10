package exmcollapsing.test.com.mvpdemo.MVP.day.presenter;

import android.content.Context;

import exmcollapsing.test.com.mvpdemo.MVP.day.contract.DayContract;
import exmcollapsing.test.com.mvpdemo.MVP.day.model.DayModelImpl;
import exmcollapsing.test.com.mvpdemo.base.BasePresenter;
import exmcollapsing.test.com.mvpdemo.net.entity.responsebody.DayResponse;
import exmcollapsing.test.com.mvpdemo.net.exception.ApiException;
import exmcollapsing.test.com.mvpdemo.net.subscriber.RestAPIObserver;

/**
 * Created by Boosal on 2017/8/10.
 */

public class DayPresenter extends BasePresenter<DayContract.View,DayContract.Model> {
    public DayPresenter(Context context) {
        super(context);
        mMvpModel = new DayModelImpl();
    }

    public void getDayInfo(String date){
        mMvpModel.getDayInfo(date, new RestAPIObserver<DayResponse>(context,true) {
            @Override
            protected void onSuccess(DayResponse dayResponse) {
                mMvpView.setDayInfo(dayResponse.getResult().getData());
            }

            @Override
            protected void onApiError(ApiException e) {
                mMvpView.showError(e.getResponseError().getError_code());
            }
        });
    }

}
