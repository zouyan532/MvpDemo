package exmcollapsing.test.com.mvpdemo.net.serviceapi;

import exmcollapsing.test.com.mvpdemo.interf.Contanst;
import exmcollapsing.test.com.mvpdemo.net.ServiceGenerator;
import exmcollapsing.test.com.mvpdemo.net.UrlStore;
import exmcollapsing.test.com.mvpdemo.net.entity.responsebody.DayResponse;
import exmcollapsing.test.com.mvpdemo.net.service.DayService;
import exmcollapsing.test.com.mvpdemo.net.subscriber.RestAPIObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Boosal on 2017/8/10.
 */

public class DayApi {
    private DayService dayService;
    public DayApi() {
        this(UrlStore.BASEURL);
    }

    public DayApi(String baseUrl){
        this.dayService= ServiceGenerator.createServiceFrom(DayService.class,baseUrl);
    }


    public void getDayInfo(String date, RestAPIObserver<DayResponse> restAPIObserver){
        dayService.getDayInfo(date, Contanst.KEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(restAPIObserver);
    }
}
