package com.huawei.crowdtestsdk.utils;

import android.content.Context;
import com.huawei.crowdtestsdk.constants.TbdtsConstants;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.uploadlog.p188c.C2511g;

public class AppManagerUtils {
    private static AppManagerUtils sInstance;
    private Context mContext;

    private AppManagerUtils(Context context) {
        this.mContext = context;
    }

    public static AppManagerUtils getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppManagerUtils(context);
        }
        return sInstance;
    }

    public void logout() {
        try {
            HttpBetaAccess.getInstance().logout();
            TbdtsConstants.cleanSdkData(this.mContext);
            TbdtsConstants.clearUserData();
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[AppManagerUtils.logout]Exception:", e);
        }
    }
}
