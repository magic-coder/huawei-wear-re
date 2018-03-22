package com.snowballtech.business.common;

import android.content.Context;
import android.util.Log;
import com.snowballtech.business.config.ParseConfig;
import com.snowballtech.business.util.ConfigUtil;

public class SnowballService {
    private static volatile SnowballService singleton;
    private Context contex;
    private IWalletServiceProvider walletServiceProvider = new IWalletServiceProvider();

    public static SnowballService getInstance(Context context) {
        if (singleton == null) {
            synchronized (SnowballService.class) {
                if (singleton == null) {
                    singleton = new SnowballService(context);
                }
            }
        }
        return singleton;
    }

    private SnowballService(Context context) {
        Log.i("snowballtech_", "SnowballService constructor");
        this.contex = context;
        ConfigUtil.getInstance().initRequest(context);
        this.walletServiceProvider.setContext(context);
    }

    public IWalletServiceProvider getWalletServiceProvider() {
        return this.walletServiceProvider;
    }

    public void destroy() {
        try {
            Log.i("snowballtech_", "destroy all recource");
            ParseConfig.getInstance().release();
            ConfigUtil.getInstance().releaseApdu();
            ConfigUtil.getInstance().releaseRequest();
            singleton = null;
            this.contex = null;
        } catch (Exception e) {
            Log.e("snowballtech_", "destroy exception:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
