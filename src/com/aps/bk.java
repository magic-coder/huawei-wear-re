package com.aps;

import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: Parser */
class bk extends DefaultHandler {
    public ap f13024a;
    private String f13025b;

    private bk() {
        this.f13024a = new ap();
        this.f13025b = "";
    }

    public void characters(char[] cArr, int i, int i2) {
        this.f13025b = String.valueOf(cArr, i, i2);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f13025b = "";
    }

    public void endElement(String str, String str2, String str3) {
        if (str2.equals("retype")) {
            this.f13024a.m17306h(this.f13025b);
        } else if (str2.equals("adcode")) {
            this.f13024a.m17312k(this.f13025b);
        } else if (str2.equals("citycode")) {
            this.f13024a.m17308i(this.f13025b);
        } else if (str2.equals("radius")) {
            try {
                this.f13024a.m17286a(Float.valueOf(this.f13025b).floatValue());
            } catch (Throwable th) {
                th.printStackTrace();
                this.f13024a.m17286a(3891.0f);
            }
        } else if (str2.equals("cenx")) {
            try {
                this.f13025b = bq.m17436a(Double.valueOf(this.f13025b), "#.000000");
                this.f13024a.m17285a(Double.valueOf(this.f13025b).doubleValue());
            } catch (Throwable th2) {
                th2.printStackTrace();
                this.f13024a.m17285a(0.0d);
            }
        } else if (str2.equals("ceny")) {
            try {
                this.f13025b = bq.m17436a(Double.valueOf(this.f13025b), "#.000000");
                this.f13024a.m17292b(Double.valueOf(this.f13025b).doubleValue());
            } catch (Throwable th22) {
                th22.printStackTrace();
                this.f13024a.m17292b(0.0d);
            }
        } else if (str2.equals("desc")) {
            this.f13024a.m17310j(this.f13025b);
        } else if (str2.equals("country")) {
            this.f13024a.m17314l(this.f13025b);
        } else if (str2.equals("province")) {
            this.f13024a.m17316m(this.f13025b);
        } else if (str2.equals("city")) {
            this.f13024a.m17318n(this.f13025b);
        } else if (str2.equals("road")) {
            this.f13024a.m17320o(this.f13025b);
        } else if (str2.equals("street")) {
            this.f13024a.m17322p(this.f13025b);
        } else if (str2.equals(ParamKey.POINAME)) {
            this.f13024a.m17324q(this.f13025b);
        } else if (str2.equals("BIZ")) {
            if (this.f13024a.m17327t() == null) {
                this.f13024a.m17290a(new JSONObject());
            }
            try {
                this.f13024a.m17327t().put("BIZ", this.f13025b);
            } catch (Throwable th222) {
                th222.printStackTrace();
            }
        } else if (str2.equals("flr")) {
            this.f13024a.m17294b(this.f13025b);
        } else if (str2.equals("pid")) {
            this.f13024a.m17289a(this.f13025b);
        } else if (str2.equals("apiTime")) {
            try {
                if (!"".equals(this.f13025b)) {
                    this.f13024a.m17287a(Long.parseLong(this.f13025b));
                }
            } catch (Throwable th2222) {
                th2222.printStackTrace();
                this.f13024a.m17287a(bu.m17450a());
            }
        } else if (str2.equals("coord")) {
            try {
                this.f13024a.m17298d(this.f13025b);
            } catch (Throwable th22222) {
                th22222.printStackTrace();
            }
        } else if (str2.equals("mcell")) {
            try {
                this.f13024a.m17300e(this.f13025b);
            } catch (Throwable th222222) {
                th222222.printStackTrace();
            }
        } else if (str2.equals(DistrictSearchQuery.KEYWORDS_DISTRICT)) {
            try {
                this.f13024a.m17296c(this.f13025b);
            } catch (Throwable th2222222) {
                th2222222.printStackTrace();
            }
        }
        if (this.f13024a.m17327t() == null) {
            this.f13024a.m17290a(new JSONObject());
        }
        try {
            if (str2.equals("eab")) {
                this.f13024a.m17327t().put(str2, this.f13025b);
            } else if (str2.equals("ctl")) {
                this.f13024a.m17327t().put(str2, this.f13025b);
            } else if (str2.equals("suc")) {
                this.f13024a.m17327t().put(str2, this.f13025b);
            } else if (str2.equals("spa")) {
                this.f13024a.m17327t().put(str2, this.f13025b);
            }
        } catch (Throwable th22222222) {
            th22222222.printStackTrace();
        }
    }
}
