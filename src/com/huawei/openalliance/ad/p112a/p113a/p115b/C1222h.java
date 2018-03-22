package com.huawei.openalliance.ad.p112a.p113a.p115b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;
import com.huawei.openalliance.ad.p112a.p122h.C1283a;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.Locale;

public class C1222h extends C1211a {
    private static final String TAG = "Device";
    private String androidid__;
    private String buildVersion__;
    private int height__;
    private String imei__;
    private String language__;
    private String mac__;
    private String maker__;
    private String model__;
    private String os__ = "android";
    private String tvModel__;
    private int type__ = 4;
    private String userAccount__;
    private String version__;
    private int width__;

    public C1222h(Context context, int i, int i2, int i3) {
        try {
            this.version__ = VERSION.RELEASE;
            this.maker__ = Build.MANUFACTURER.toUpperCase(Locale.US);
            this.model__ = Build.MODEL.toUpperCase(Locale.US);
            this.buildVersion__ = Build.DISPLAY;
            this.width__ = i;
            this.height__ = i2;
            this.language__ = C1283a.m5645a(context).m5654c();
            this.type__ = i3;
            if (C1289h.m5695a(context).m5731p()) {
                this.imei__ = C1283a.m5645a(context).m5656e();
                this.androidid__ = C1283a.m5645a(context).m5655d();
                this.mac__ = C1283a.m5645a(context).m5657f();
            }
        } catch (Exception e) {
            C1336d.m5888c(TAG, "get device info fail");
        }
    }

    public String getAndroidid__() {
        return this.androidid__;
    }

    public String getBuildVersion__() {
        return this.buildVersion__;
    }

    public int getHeight__() {
        return this.height__;
    }

    public String getImei__() {
        return this.imei__;
    }

    public String getLanguage__() {
        return this.language__;
    }

    public String getMac__() {
        return this.mac__;
    }

    public String getMaker__() {
        return this.maker__;
    }

    public String getModel__() {
        return this.model__;
    }

    public String getOs__() {
        return this.os__;
    }

    public String getTvModel__() {
        return this.tvModel__;
    }

    public int getType__() {
        return this.type__;
    }

    public String getUserAccount__() {
        return this.userAccount__;
    }

    public String getVersion__() {
        return this.version__;
    }

    public int getWidth__() {
        return this.width__;
    }

    public void setAndroidid__(String str) {
        this.androidid__ = str;
    }

    public void setBuildVersion__(String str) {
        this.buildVersion__ = str;
    }

    public void setHeight__(int i) {
        this.height__ = i;
    }

    public void setImei__(String str) {
        this.imei__ = str;
    }

    public void setLanguage__(String str) {
        this.language__ = str;
    }

    public void setMac__(String str) {
        this.mac__ = str;
    }

    public void setMaker__(String str) {
        this.maker__ = str;
    }

    public void setModel__(String str) {
        this.model__ = str;
    }

    public void setOs__(String str) {
        this.os__ = str;
    }

    public void setTvModel__(String str) {
        this.tvModel__ = str;
    }

    public void setType__(int i) {
        this.type__ = i;
    }

    public void setUserAccount__(String str) {
        this.userAccount__ = str;
    }

    public void setVersion__(String str) {
        this.version__ = str;
    }

    public void setWidth__(int i) {
        this.width__ = i;
    }
}
