package com.huawei.openalliance.ad.p112a.p113a.p115b;

import android.net.wifi.WifiInfo;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;
import com.huawei.openalliance.ad.utils.C1328a;
import com.sina.weibo.sdk.component.GameManager;
import java.nio.charset.Charset;

public class C1234t extends C1211a {
    private String bssid__;
    private int signalStrength__ = -1000;
    private String ssid__;

    public String getBssid__() {
        return this.bssid__;
    }

    public int getSignalStrength__() {
        return this.signalStrength__;
    }

    public String getSsid__() {
        return this.ssid__;
    }

    public void loadWifiInfo(WifiInfo wifiInfo) {
        if (wifiInfo != null) {
            String bssid = wifiInfo.getBSSID();
            if (bssid != null && !"null".equalsIgnoreCase(bssid)) {
                this.ssid__ = C1328a.m5849a(wifiInfo.getSSID().getBytes(Charset.forName(GameManager.DEFAULT_CHARSET)));
                this.bssid__ = bssid;
                this.signalStrength__ = wifiInfo.getRssi();
            }
        }
    }

    public void setBssid__(String str) {
        this.bssid__ = str;
    }

    public void setSignalStrength__(int i) {
        this.signalStrength__ = i;
    }

    public void setSsid__(String str) {
        this.ssid__ = str;
    }
}
