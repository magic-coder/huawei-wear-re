package com.leisen.wallet.sdk;

import android.content.Context;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;

public class AppConfig {
    public static final String APDU_GETCIN = "80CA004500";
    public static final String APDU_GETCPLC = "80CA9f7f00";
    public static final String APDU_GETIIN = "80CA004200";
    public static final String CLIENTVERSION = "2.0.6";
    public static final String VERSION = "1.0";
    private static String imei;
    private static String mobileType;
    private static String streamUrl = ServiceConfig.HUAWEI_TSM_REMOTE_URL;

    public static String getStreamUrl() {
        return streamUrl;
    }

    public static void setStreamUrl(String str) {
        streamUrl = str;
    }

    public static final void init(Context context) {
        imei = getImei(context);
        setMobileType(getModel(context));
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static void setMobileType(String str) {
        mobileType = str;
    }

    public static String getImei() {
        return imei;
    }

    public static String getMobileType() {
        return mobileType;
    }

    private static String getModel(Context context) {
        return ESEApiFactory.createESEInfoManagerApi(context).getDeviceModel();
    }

    private static String getImei(Context context) {
        return ESEApiFactory.createESEInfoManagerApi(context).getDeviceSN();
    }
}
