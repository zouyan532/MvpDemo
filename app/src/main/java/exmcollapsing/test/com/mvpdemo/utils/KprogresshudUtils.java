package exmcollapsing.test.com.mvpdemo.utils;

import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;


/**
 * Created by LeXunSW on 2017-02-22.
 */

public class KprogresshudUtils {
    private static KProgressHUD kProgressHUD;

    public static void show(Context context) {
        if (kProgressHUD != null) {
            kProgressHUD.dismiss();
            kProgressHUD = null;
        }
        kProgressHUD = new KprogresshudOptition().getKProgressHUD(context);
        kProgressHUD.show();
    }

    public static void dismiss() {
        if (kProgressHUD != null) {
            kProgressHUD.dismiss();
            kProgressHUD=null;
        }
    }
}
