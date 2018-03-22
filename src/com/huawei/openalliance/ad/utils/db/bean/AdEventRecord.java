package com.huawei.openalliance.ad.utils.db.bean;

import android.text.TextUtils;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1229o;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import org.json.JSONObject;

public class AdEventRecord extends C1359a {
    private static final String TAG = "AdEventRecord";
    private String _id;
    private int adType_;
    private long lockTime_ = 0;
    private int opTimesInLandingPage_;
    private String paramFromServer_;
    private int rawX_;
    private int rawY_;
    private String showid_;
    private long time_;
    private String type_;

    public AdEventRecord(C1216b c1216b) {
        this.type_ = c1216b.getType__();
        this.time_ = c1216b.getTime__();
        this.rawX_ = c1216b.getRawX__();
        this.rawY_ = c1216b.getRawY__();
        this.opTimesInLandingPage_ = c1216b.getOpTimesInLandingPage__();
        this.showid_ = c1216b.getShowid__();
        try {
            if (c1216b.getParamfromserver__() != null) {
                this.paramFromServer_ = c1216b.getParamfromserver__().toJson();
            }
        } catch (Throwable e) {
            C1336d.m5883a(TAG, "convert param error", e);
            this.paramFromServer_ = "";
        }
    }

    public C1216b m6007a() {
        C1216b c1216b = new C1216b();
        c1216b.setType__(this.type_);
        c1216b.setTime__(this.time_);
        c1216b.setRawX__(this.rawX_);
        c1216b.setRawY__(this.rawY_);
        c1216b.setOpTimesInLandingPage__(this.opTimesInLandingPage_);
        c1216b.setSeq__(this._id);
        c1216b.setShowid__(this.showid_);
        if (!TextUtils.isEmpty(this.paramFromServer_)) {
            C1229o c1229o = new C1229o();
            try {
                c1229o.fromJson(new JSONObject(this.paramFromServer_));
            } catch (Throwable e) {
                C1336d.m5883a(TAG, "convert param error", e);
            }
            c1216b.setParamfromserver__(c1229o);
        }
        return c1216b;
    }

    public void m6008a(int i) {
        this.adType_ = i;
    }

    public String m6009b() {
        return this._id;
    }
}
