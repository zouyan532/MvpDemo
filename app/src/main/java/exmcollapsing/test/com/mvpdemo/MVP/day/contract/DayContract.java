package exmcollapsing.test.com.mvpdemo.MVP.day.contract;

import exmcollapsing.test.com.mvpdemo.interf.MvpModel;
import exmcollapsing.test.com.mvpdemo.interf.MvpView;
import exmcollapsing.test.com.mvpdemo.net.entity.responsebody.DayResponse;
import exmcollapsing.test.com.mvpdemo.net.subscriber.RestAPIObserver;

/**
 * Created by Boosal on 2017/8/10.
 */

public class DayContract {
    public interface View extends MvpView {
        void setDayInfo(DayResponse.ResultBean.DataBean dayInfo);
    }

    public interface Model extends MvpModel {
        void getDayInfo(String date, RestAPIObserver<DayResponse> restAPIObserver);
    }
}
