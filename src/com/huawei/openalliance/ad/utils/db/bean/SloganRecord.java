package com.huawei.openalliance.ad.utils.db.bean;

import com.huawei.openalliance.ad.p112a.p113a.p115b.C1233s;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

public class SloganRecord extends C1359a {
    private static final String TAG = "SloganRecord";
    private String _id;
    private String contentId_;
    private int creativeType_;
    private long endTime_;
    private int height_;
    private String paramFromServer_ = "";
    private String sha256_;
    private long startTime_;
    private String url_;
    private int width_;

    public SloganRecord(C1233s c1233s) {
        if (c1233s != null) {
            this.contentId_ = c1233s.getContentid__();
            this.startTime_ = c1233s.getStarttime__();
            this.endTime_ = c1233s.getEndtime__();
            this.creativeType_ = c1233s.getCreativetype__();
            this.url_ = c1233s.getUrl__();
            this.width_ = c1233s.getWidth__();
            this.height_ = c1233s.getHeight__();
            this.sha256_ = c1233s.getSha256__();
            if (c1233s.getParamfromserver__() != null) {
                try {
                    this.paramFromServer_ = c1233s.getParamfromserver__().toJson();
                } catch (IllegalAccessException e) {
                    C1336d.m5888c(TAG, "parse paramFromServer IllegalAccessException");
                } catch (IllegalArgumentException e2) {
                    C1336d.m5888c(TAG, "parse paramFromServer IllegalArgumentException");
                }
            }
        }
    }

    public String m6056a() {
        return this.contentId_;
    }

    public void mo2463a(String str) {
        this.url_ = str;
    }

    public int m6058b() {
        return this.creativeType_;
    }

    public String m6059c() {
        return this.url_;
    }

    public String m6060d() {
        return this.paramFromServer_;
    }
}
