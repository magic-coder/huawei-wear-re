package com.snowballtech.business.util;

import android.content.Context;
import android.util.Log;
import com.snowballtech.apdu.IApdu;
import com.snowballtech.business.BuildConfig;
import com.snowballtech.business.config.ParseConfig;
import com.snowballtech.common.env.IEnv;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ValueUtil;
import com.snowballtech.data.interaction.IRequester;

public class ConfigUtil {
    private static volatile ConfigUtil singleton;
    String TAG = "ConfigUtil";
    private IApdu apdu;
    private IEnv envParam;
    private IRequester requester;

    public static ConfigUtil getInstance() {
        if (singleton == null) {
            synchronized (ConfigUtil.class) {
                if (singleton == null) {
                    singleton = new ConfigUtil();
                }
            }
        }
        return singleton;
    }

    private ConfigUtil() {
    }

    public IApdu instanceOma() throws SnowballException {
        String fetchConfig = ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_OMA_MODULE);
        LogUtil.log("config oma_module:" + fetchConfig);
        if (this.apdu != null) {
            return this.apdu;
        }
        if (!ValueUtil.isEmpty(fetchConfig)) {
            try {
                String str = "";
                if (fetchConfig.equals("mcu_oma")) {
                    this.apdu = (IApdu) Class.forName("com.snowballtech.apdu.mcu_oma.McuApdu").newInstance();
                } else if (fetchConfig.equals("nfceeservice")) {
                    this.apdu = (IApdu) Class.forName("com.snowballtech.apdu.nfceeservice.NfceeServiceApdu").newInstance();
                } else if (fetchConfig.equals(BuildConfig.oma_module)) {
                    this.apdu = (IApdu) Class.forName("com.snowballtech.apdu.smartdevice_oma.SmartDeviceApdu").newInstance();
                } else if (fetchConfig.equals("standard_oma")) {
                    this.apdu = (IApdu) Class.forName("com.snowballtech.apdu.oma.OmaApdu").newInstance();
                } else {
                    LogUtil.loge(this.TAG, "instanceOma oma_module:" + fetchConfig + " NOT handled");
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw new SnowballException(e);
            }
        }
        return this.apdu;
    }

    public IRequester instanceRequester() throws SnowballException {
        String fetchConfig = ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_DATA_INTERACTION_MODULE);
        LogUtil.log("config data_interaction_module:" + fetchConfig);
        if (this.requester != null) {
            return this.requester;
        }
        if (!ValueUtil.isEmpty(fetchConfig)) {
            try {
                String str = "";
                if (fetchConfig.equals(BuildConfig.data_interaction_module)) {
                    this.requester = (IRequester) Class.forName("com.snowballtech.data.interaction.net.RequesterNet").newInstance();
                } else if (fetchConfig.equals("net_dm")) {
                    this.requester = (IRequester) Class.forName("com.snowballtech.data.interaction.dm.RequesterNet").newInstance();
                } else {
                    LogUtil.loge(this.TAG, "data_interaction:" + fetchConfig + " NOT handled");
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw new SnowballException(e);
            }
        }
        return this.requester;
    }

    public IEnv instanceEnv() throws SnowballException {
        String fetchConfig = ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_OMA_MODULE);
        if (this.envParam != null) {
            return this.envParam;
        }
        if (!ValueUtil.isEmpty(fetchConfig)) {
            try {
                String str = "";
                if (fetchConfig.equals("mcu_oma")) {
                    this.envParam = (IEnv) Class.forName("com.snowballtech.apdu.mcu_oma.env.McuEnv").newInstance();
                } else if (fetchConfig.equals(BuildConfig.oma_module)) {
                    this.envParam = (IEnv) Class.forName("com.snowballtech.apdu.smartdevice_oma.env.SmartDeviceEnv").newInstance();
                } else {
                    LogUtil.loge(this.TAG, "instanceEnv oma_module:" + fetchConfig + " NOT handled");
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw new SnowballException(e);
            }
        }
        return this.envParam;
    }

    public boolean isCheckNfc() {
        String fetchConfig = ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_OMA_MODULE);
        if (!ValueUtil.isEmpty(fetchConfig) && fetchConfig.equals("mcu_oma")) {
            return false;
        }
        if (ValueUtil.isEmpty(fetchConfig) || !fetchConfig.equals(BuildConfig.oma_module)) {
            return true;
        }
        return false;
    }

    public boolean isNeedCheckNfc() {
        String fetchConfig = ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_OMA_MODULE);
        if (!ValueUtil.isEmpty(fetchConfig) && fetchConfig.equals("mcu_oma")) {
            return false;
        }
        if (ValueUtil.isEmpty(fetchConfig) || !fetchConfig.equals(BuildConfig.oma_module)) {
            return true;
        }
        return false;
    }

    public void releaseApdu() {
        if (this.apdu != null) {
            this.apdu.release();
        }
        this.apdu = null;
    }

    public void initRequest(Context context) {
        Log.e("snowballtech_", "initRequest");
        try {
            if (this.requester == null) {
                this.requester = instanceRequester();
            }
            if (this.requester != null) {
                this.requester.init(context);
            }
        } catch (SnowballException e) {
            e.printStackTrace();
        }
    }

    public void releaseRequest() {
        if (this.requester != null) {
            this.requester.release();
        }
        this.requester = null;
    }

    public boolean isCanSetDevice() {
        String fetchConfig = ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_OMA_MODULE);
        if (ValueUtil.isEmpty(fetchConfig) || !fetchConfig.equals(BuildConfig.oma_module)) {
            return false;
        }
        return true;
    }

    public boolean isNeedCheckNetwork() {
        String fetchConfig = ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_DATA_INTERACTION_MODULE);
        if (ValueUtil.isEmpty(fetchConfig) || !fetchConfig.equals("net_dm")) {
            LogUtil.log("this project is onther need check network");
            return true;
        }
        LogUtil.log("this project is net_dm no need check network");
        return false;
    }
}
