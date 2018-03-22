package com.snowballtech.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.telephony.TelephonyManager;

public class DeviceUtil {
    private static DeviceUtil instance;

    private DeviceUtil() {
    }

    public static DeviceUtil getInstance() {
        if (instance == null) {
            instance = new DeviceUtil();
        }
        return instance;
    }

    public String getDeviceId(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public String getDeviceVendor() {
        return Build.MANUFACTURER;
    }

    public String getVersionName(Context context) {
        String str = null;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public int getVersionCode(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public String getCurrentPackageName(Context context) {
        return context.getPackageName();
    }

    @SuppressLint({"NewApi"})
    public boolean checkNFCDisable(Context context) {
        NfcAdapter nfcAdapter = null;
        try {
            nfcAdapter = NfcAdapter.getDefaultAdapter(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (nfcAdapter == null || !nfcAdapter.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean checkNetWorkDisable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            State state = networkInfo.getState();
            if (state == State.CONNECTED || state == State.CONNECTING) {
                return false;
            }
        }
        if (networkInfo2 != null) {
            State state2 = networkInfo2.getState();
            if (state2 == State.CONNECTED || state2 == State.CONNECTING) {
                return false;
            }
        }
        return true;
    }

    public String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
