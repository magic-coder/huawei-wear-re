package com.huawei.wallet.utils;

import android.content.Context;
import com.huawei.wallet.utils.log.LogC;

public class DisplayUtils {
    public static int m28450a(Context context) {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            if (cls != null) {
                i = Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString());
            }
        } catch (ClassNotFoundException e) {
            LogC.m28534d("DisplayUtils getStatusBarHeight-ClassNotFoundException", false);
        } catch (IllegalAccessException e2) {
            LogC.m28534d("DisplayUtils getStatusBarHeight-IllegalAccessException", false);
        } catch (InstantiationException e3) {
            LogC.m28534d("DisplayUtils getStatusBarHeight-InstantiationException ", false);
        } catch (NoSuchFieldException e4) {
            LogC.m28534d("DisplayUtils getStatusBarHeight-NoSuchFieldException", false);
        }
        return context.getResources().getDimensionPixelSize(i);
    }
}
