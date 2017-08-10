package exmcollapsing.test.com.mvpdemo.utils;

/**
 * Created by Boosal on 2016/6/30.
 */

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

public class NetWorkUtils {
    private Context mContext;
    public NetworkInfo.State wifiState = null;
    public NetworkInfo.State mobileState = null;
    private static boolean isNetConnected;
    public NetWorkUtils(Context context) {
        mContext = context;
    }

    public enum NetWorkState {
        WIFI, MOBILE, NONE
    }
    /**
     * 获取当前的网络状态
     * @return
     */
    public NetWorkState getConnectState( ) {
        ConnectivityManager manager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        manager.getActiveNetworkInfo();
        wifiState = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        mobileState = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        if (wifiState != null && mobileState != null
                && NetworkInfo.State.CONNECTED != wifiState
                && NetworkInfo.State.CONNECTED == mobileState) {
            return NetWorkState.MOBILE;
        } else if (wifiState != null && mobileState != null
                && NetworkInfo.State.CONNECTED != wifiState
                && NetworkInfo.State.CONNECTED != mobileState) {
            return NetWorkState.NONE;
        } else if (wifiState != null && NetworkInfo.State.CONNECTED == wifiState) {
            return NetWorkState.WIFI;
        }
        return NetWorkState.NONE;
    }
    /**
     * 是否是wifi连接
     */
    public static boolean getConnectWifi(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = manager.getActiveNetworkInfo();//获取网络的连接情况
        if(activeNetInfo.getType()== ConnectivityManager.TYPE_WIFI){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 检查网络设置
     * @param context
     * @return
     */
    public static boolean isNetConnected(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            isNetConnected = true;
        } else {
            isNetConnected = false;
        }
        return isNetConnected;
    }


    public static  boolean isServiceWork(Context mContext) {
        boolean isWork = false;
        String serviceName="com.lcit.lecai.service.CityService";
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(40);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }
}
