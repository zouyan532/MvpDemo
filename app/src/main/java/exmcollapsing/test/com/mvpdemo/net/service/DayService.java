package exmcollapsing.test.com.mvpdemo.net.service;

import exmcollapsing.test.com.mvpdemo.net.UrlStore;
import exmcollapsing.test.com.mvpdemo.net.entity.responsebody.DayResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Boosal on 2017/8/10.
 */

public interface DayService {
    @GET(UrlStore.DAY)
    Observable<DayResponse> getDayInfo(@Query("date")String date,@Query("key")String key);
}
