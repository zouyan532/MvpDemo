package exmcollapsing.test.com.mvpdemo.utils;

import android.content.Context;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.kaopiz.kprogresshud.KProgressHUD;


/**
 * Created by Boosal on 2016/11/2.
 */
public class KprogresshudOptition {
    public static KProgressHUD getKProgressHUD(Context context) {
        KProgressHUD kProgressHUD = new KProgressHUD(context);
        kProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
//                .setDetailsLabel("loading")
                .setDimAmount(0.5f);
        return kProgressHUD;
    }
    public static SVProgressHUD getProgressHUD(Context context){
        SVProgressHUD progressHUD=new SVProgressHUD(context);
        return  progressHUD;
    }
}
