package exmcollapsing.test.com.mvpdemo.MVP.day.model;

import exmcollapsing.test.com.mvpdemo.MVP.day.contract.DayContract;
import exmcollapsing.test.com.mvpdemo.net.entity.responsebody.DayResponse;
import exmcollapsing.test.com.mvpdemo.net.serviceapi.DayApi;
import exmcollapsing.test.com.mvpdemo.net.subscriber.RestAPIObserver;

/**
 * Created by Boosal on 2017/8/10.
 */

public class DayModelImpl implements DayContract.Model {
    @Override
    public void getDayInfo(String date, RestAPIObserver<DayResponse> restAPIObserver) {
        new DayApi().getDayInfo(date,restAPIObserver);
    }
}
