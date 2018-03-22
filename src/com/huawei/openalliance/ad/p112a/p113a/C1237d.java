package com.huawei.openalliance.ad.p112a.p113a;

import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1226l;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1231q;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.List;

public class C1237d extends C1213c {
    private static final String TAG = "AppConfigRsp";
    private int gif_show_time_lower_limit_each_frame__ = 100;
    private int gif_show_time_upper_limit__ = 8000;
    private int gif_size_upper_limit__ = 2048;
    private int img_size_upper_limit__ = 500;
    private C1226l magazinelockBoxPara__;
    private String reason__;
    private C1231q reduceDisturbRule__;
    private int retcode__ = -1;
    private long sloganShowMinTimeRealMode__ = 300;
    private int sloganShowTime__ = 2000;
    private long splashShowTimeInterval__ = 0;
    private int splashSkipArea__ = 0;
    private int splashUserAppDayImpFc__ = 0;
    private int splashcachenum__ = 10;
    private int splashmode__ = 1;
    private int splashshow__ = 3000;

    public int getGifSizeUpperLimit__(int i) {
        return this.gif_size_upper_limit__ > 0 ? this.gif_size_upper_limit__ : i;
    }

    public int getGifTimeLowerLimitFrame__(int i) {
        return this.gif_show_time_lower_limit_each_frame__ > 0 ? this.gif_show_time_lower_limit_each_frame__ : i;
    }

    public int getGifTimeUpperLimit__(int i) {
        return this.gif_show_time_upper_limit__ >= 2000 ? this.gif_show_time_upper_limit__ : i;
    }

    public int getImgSizeUpperLimit__(int i) {
        return this.img_size_upper_limit__ > 0 ? this.img_size_upper_limit__ : i;
    }

    public C1226l getMagazinelockBoxPara__() {
        return this.magazinelockBoxPara__;
    }

    public String getReason_() {
        return this.reason__;
    }

    public String getReduceDisturbRule__(String str) {
        if (this.reduceDisturbRule__ == null) {
            return null;
        }
        List ruleList__ = this.reduceDisturbRule__.getRuleList__();
        if (ruleList__ == null || ruleList__.size() > 30) {
            return str;
        }
        try {
            return this.reduceDisturbRule__.toJson();
        } catch (Exception e) {
            C1336d.m5888c(TAG, "convert reduceDisturbRule__ fail");
            return str;
        }
    }

    public int getRetcode_() {
        return this.retcode__;
    }

    public long getSloganShowMinTimeRealMode__() {
        return (this.sloganShowMinTimeRealMode__ < 0 || this.sloganShowMinTimeRealMode__ > 5000) ? 300 : this.sloganShowMinTimeRealMode__;
    }

    public int getSloganShowTime__() {
        return 1 == this.splashmode__ ? (this.sloganShowTime__ < 0 || this.sloganShowTime__ > 5000) ? 0 : this.sloganShowTime__ : 2 == this.splashmode__ ? (this.sloganShowTime__ < 500 || this.sloganShowTime__ > 5000) ? 2000 : this.sloganShowTime__ : 0;
    }

    public long getSplashShowTimeInterval__() {
        return this.splashShowTimeInterval__ > 0 ? this.splashShowTimeInterval__ : 0;
    }

    public int getSplashSkipArea__() {
        return (this.splashSkipArea__ < 0 || this.splashSkipArea__ > 200) ? 0 : this.splashSkipArea__;
    }

    public int getSplashUserAppDayImpFc__() {
        return this.splashUserAppDayImpFc__ > 0 ? this.splashUserAppDayImpFc__ : 0;
    }

    public int getSplashcachenum_() {
        return this.splashcachenum__ > 0 ? this.splashcachenum__ : 10;
    }

    public int getSplashmode_() {
        return (1 == this.splashmode__ || 2 == this.splashmode__) ? this.splashmode__ : 1;
    }

    public int getSplashshow_() {
        return this.splashshow__ >= 2000 ? this.splashshow__ : 3000;
    }

    public void setMagazinelockBoxPara__(C1226l c1226l) {
        this.magazinelockBoxPara__ = c1226l;
    }

    public void setSplashSkipArea__(int i) {
        this.splashSkipArea__ = i;
    }
}
