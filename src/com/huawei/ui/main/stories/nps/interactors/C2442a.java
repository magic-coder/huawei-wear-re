package com.huawei.ui.main.stories.nps.interactors;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.m;
import com.huawei.hwcommonmodel.datatypes.j;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.db.b;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.ui.main.stories.nps.activity.C2426a;
import com.huawei.ui.main.stories.nps.activity.NPSDialogActivity;
import com.huawei.ui.main.stories.nps.interactors.db.C2448a;
import com.huawei.ui.main.stories.nps.interactors.db.QstnSurveyTable;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnDestSiteResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSureyResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyCommitParam;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyDetailResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyRequestParam;
import com.huawei.ui.main.stories.nps.interactors.mode.Url;
import com.huawei.ui.main.stories.nps.interactors.p183a.C2441a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: HWNPSManager */
public class C2442a extends C0628a {
    private static boolean f8783n = false;
    private static C2442a f8784x = null;
    private String f8785a = "HWNPSManager";
    private Context f8786b = BaseApplication.m2632b();
    private C2448a f8787c;
    private QstnSurveyTable f8788d = null;
    private String f8789e;
    private String f8790f;
    private String f8791g;
    private String f8792h;
    private String f8793i;
    private QstnSurveyDetailResponse f8794j;
    private List<QstnSureyResponse> f8795k;
    private Type f8796l = new C2445b(this).getType();
    private Type f8797m = new C2446c(this).getType();
    private String f8798o = "";
    private String f8799p = "0";
    private int f8800q = -1;
    private int f8801r = -1;
    private boolean f8802s = false;
    private Listener<String> f8803t = null;
    private ErrorListener f8804u = null;
    private String f8805v = "";
    private a f8806w = null;
    private C1971j f8807y = null;

    public static C2442a m12225a(Context context) {
        if (f8784x == null) {
            f8784x = new C2442a(context);
        }
        return f8784x;
    }

    public C2442a(Context context) {
        super(context);
        C2538c.m12677c(this.f8785a, "========HWNPSManager nps 0");
        this.f8806w = a.a(this.f8786b);
        this.f8807y = C1971j.m10236a(this.f8786b);
        this.f8802s = false;
        this.f8801r = -1;
        this.f8799p = "-1";
        m12250g();
    }

    protected Integer getModuleId() {
        return Integer.valueOf(10004);
    }

    private void m12250g() {
        this.f8787c = new C2448a(this.f8786b);
        b.a(this.f8786b, String.valueOf(getModuleId()));
        int a = b.a();
        C2538c.m12677c(this.f8785a, "nps initQstnSurveyDB newDBVersion =" + 103 + ", oldDBVersion=" + a);
        if (103 <= a || a <= 0 || a > 102) {
            C2538c.m12677c(this.f8785a, "nps initQstnSurveyDB createDBTable");
            this.f8787c.m12278a(this);
            return;
        }
        C2538c.m12677c(this.f8785a, "nps initQstnSurveyDB upgradeQstnSurveyDB");
        this.f8787c.m12279a(this, Integer.valueOf(10004), this.f8786b);
    }

    public void m12263a() {
        C2538c.m12677c(this.f8785a, "nps Enter upgradeSurveyDB");
        b.a(this.f8786b, String.valueOf(getModuleId()));
        int a = b.a();
        C2538c.m12677c(this.f8785a, "nps upgradeSurveyDB newDBVersion =" + 103 + ", oldDBVersion=" + a);
        if (103 > a && a <= 102 && this.f8787c.m12281a()) {
            C2538c.m12677c(this.f8785a, "nps upgradeSurveyDB upgradeQstnSurveyDB");
            this.f8787c.m12279a(this, Integer.valueOf(10004), this.f8786b);
        }
    }

    public void m12268a(List<QstnSurveyTable> list) {
        C2538c.m12677c(this.f8785a, "nps Enter getAllData");
        this.f8787c.m12280a(this, (List) list);
    }

    public void m12270b() {
        C2538c.m12677c(this.f8785a, "========nps Enter activatedQstnSurvey");
        if (C2442a.m12248f()) {
            C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey sIsBusy is true return!");
        } else if (this.f8802s) {
            C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey now submitSurvey return!");
        } else if ("".equals(j.b()) || "W1".equals(j.b())) {
            C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey DeviceNPSInfoCache.getHuaweiWearName is not support return!");
        } else if ("".equals(j.c())) {
            C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey fiemware (sysVersion) is null return!");
        } else {
            C2538c.m12677c(this.f8785a, "========nps isBusy:" + f8783n + "  mac:" + j.a());
            if ("".equals(j.a())) {
                C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey mac is null return!");
                return;
            }
            C2442a.m12231a(true);
            C2538c.m12677c(this.f8785a, "nps setIsBusy(true) ========isBusy:" + f8783n);
            this.f8798o = m12247f(j.a());
            this.f8800q = -1;
            this.f8799p = "-1";
            if (m12238b(this.f8798o)) {
                C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey 0000");
                this.f8788d = m12239c(this.f8798o);
                if (this.f8788d == null) {
                    C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey -->mQuestionSurveyTable is null");
                    return;
                }
                C2538c.m12677c(this.f8785a, "=========nps mQuestionSurveyTable.times:" + this.f8788d.toString());
                this.f8801r = this.f8788d.times.intValue();
                if (this.f8801r < 2 && m12232a(this.f8801r, this.f8788d)) {
                    C2538c.m12677c(this.f8785a, "nps open Select Qstn");
                    m12252h();
                }
            } else {
                C2538c.m12677c(this.f8785a, "nps activatedQstnSurvey aaaa");
                this.f8801r = -1;
                m12252h();
            }
            C2538c.m12677c(this.f8785a, "========nps Leave activatedQstnSurvey");
        }
    }

    private boolean m12238b(String str) {
        return new C2448a(this.f8786b).m12282a(this, str);
    }

    private QstnSurveyTable m12239c(String str) {
        C2538c.m12677c(this.f8785a, "=====nps Enter getSurveyTableByDevice");
        QstnSurveyTable qstnSurveyTable = null;
        if (this.f8787c != null) {
            qstnSurveyTable = this.f8787c.m12284b(this, str);
        } else {
            C2538c.m12677c(this.f8785a, "nps getSurveyTableByDevice  enter else null");
        }
        C2538c.m12677c(this.f8785a, "=====nps Leave getSurveyTableByDevice");
        return qstnSurveyTable;
    }

    private boolean m12232a(int i, QstnSurveyTable qstnSurveyTable) {
        C2538c.m12677c(this.f8785a, "=====nps Enter judgeGetSurveyTimeArrive");
        int i2 = i + 1;
        if (i2 < 1 || i2 > 2) {
            C2538c.m12677c(this.f8785a, "=====nps judgeGetSurveyTimeArrive GetSurvey times is off limits!");
            return false;
        } else if (qstnSurveyTable == null) {
            return false;
        } else {
            boolean a;
            C2538c.m12677c(this.f8785a, "=====nps judgeGetSurveyTimeArrive GetSurvey times = " + i2);
            if (1 == i2) {
                a = m12233a(qstnSurveyTable.lastSurveyTime);
            } else {
                a = m12237b(qstnSurveyTable.lastSurveyTime);
            }
            C2538c.m12677c(this.f8785a, "=====nps Leave judgeGetSurveyTimeArrive");
            return a;
        }
    }

    private boolean m12233a(long j) {
        boolean z;
        C2538c.m12677c(this.f8785a, "========nps Enter timeDayThen15");
        long currentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        C2538c.m12677c(this.f8785a, "========nps timeDayThen15 spanTimeSec: " + currentTimeMillis + "  span15DaySec = " + 1296000);
        if (currentTimeMillis > 1296000) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12677c(this.f8785a, "========nps Leave timeDayThen15 res:" + z);
        return z;
    }

    private boolean m12237b(long j) {
        boolean z;
        C2538c.m12677c(this.f8785a, "========nps Enter timeDayThen90 currTimemil = " + System.currentTimeMillis() + "  lastSurveyTime = " + j);
        long currentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        C2538c.m12677c(this.f8785a, "========nps timeDayThen90 spanTimeSec:" + currentTimeMillis + "   span90DaySec: " + 7776000);
        if (currentTimeMillis > 7776000) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12677c(this.f8785a, "========nps Leave timeDayThen90 res:" + z);
        return z;
    }

    private void m12252h() {
        C2538c.m12677c(this.f8785a, "========nps Enter requestGetDestSite ");
        String b = m12269b(this.f8786b);
        String country = Locale.getDefault().getCountry();
        Map hashMap = new HashMap();
        hashMap.put("countryCode", b);
        hashMap.put("deviceType", j.b());
        hashMap.put(QstnSurveyRequestParam.dstRegionCode, country);
        C2538c.m12677c(this.f8785a, "requestGetDestSite getDestSite map = " + hashMap.toString());
        C2538c.m12677c(this.f8785a, "requestGetDestSite NPS_HOST_HTTPS_URL = https://phoneservice.vmall.com/");
        if (C0977d.m3555e(this.f8786b)) {
            m12264a(1, "https://phoneservice.vmall.com/osg/getDestSite.htm", m12255j(), m12271c(), hashMap);
        }
        C2538c.m12677c(this.f8785a, "========nps Leave requestGetDestSite ");
    }

    private void m12254i() {
        C2538c.m12677c(this.f8785a, "==========nps Enter insertDeviceToDB");
        QstnSurveyTable qstnSurveyTable = new QstnSurveyTable();
        qstnSurveyTable.deviceID = this.f8798o;
        qstnSurveyTable.lastSurveyTime = new Date().getTime();
        qstnSurveyTable.deviceType = j.b();
        qstnSurveyTable.times = Integer.valueOf(0);
        qstnSurveyTable.id = 0;
        qstnSurveyTable.surveyID = "0";
        C2538c.m12677c(this.f8785a, "====nps insertDeviceToDB-->questionSurveyTable:" + qstnSurveyTable.toString());
        this.f8787c.m12277a(this, qstnSurveyTable);
        C2538c.m12677c(this.f8785a, "==========nps Leave insertDeviceToDB");
    }

    private Listener<String> m12255j() {
        return new C2447d(this);
    }

    private void m12230a(QstnDestSiteResponse qstnDestSiteResponse) {
        C2538c.m12677c(this.f8785a, "nps Enter processGetDestSiteResponse! requsetTime = " + this.f8801r);
        if (qstnDestSiteResponse != null && qstnDestSiteResponse.getResCode() == 0) {
            if (this.f8801r >= 0) {
                C2538c.m12677c(this.f8785a, "nps processGetDestSiteResponse ======去获取问卷");
                m12245e(qstnDestSiteResponse.getPhoneServiceUrl());
            } else {
                C2538c.m12677c(this.f8785a, "nps processGetDestSiteResponse ======激活成功");
                m12254i();
            }
        }
        C2538c.m12677c(this.f8785a, "nps Leave processGetDestSiteResponse!");
    }

    private void m12236b(QstnDestSiteResponse qstnDestSiteResponse) {
        C2538c.m12677c(this.f8785a, "nps getDestSiteSubmitSurvey!");
        if (qstnDestSiteResponse != null && qstnDestSiteResponse.getResCode() == 0) {
            C2538c.m12677c(this.f8785a, "nps getDestSiteSubmitSurvey ======去提交问卷");
            String phoneServiceUrl = qstnDestSiteResponse.getPhoneServiceUrl();
            m12272d();
            m12243d(phoneServiceUrl);
        }
    }

    private void m12243d(String str) {
        C2538c.m12677c(this.f8785a, "========nps Enter submitSurvey");
        m12259m();
        Map hashMap = new HashMap();
        if (this.f8788d != null) {
            hashMap.put(QstnSurveyCommitParam.surveyID, this.f8788d.getSurveyID());
            hashMap.put("times", "" + this.f8788d.getTimes());
        } else {
            hashMap.put(QstnSurveyCommitParam.surveyID, "0");
            hashMap.put("times", "1");
        }
        hashMap.put("model", this.f8789e == null ? "deviceName" : this.f8789e);
        hashMap.put("firmware", this.f8790f == null ? "firmware" : this.f8790f);
        hashMap.put("language", this.f8792h);
        hashMap.put("os", this.f8793i == null ? "os" : this.f8793i);
        hashMap.put("appID", "3");
        hashMap.put("sn", this.f8791g);
        hashMap.put(QstnSurveyCommitParam.answers, this.f8805v);
        C2538c.m12677c(this.f8785a, "========nps submitSurvey map: " + hashMap.toString());
        String str2 = "";
        str2 = "?cVer=21319";
        String str3 = "&channel=100001";
        if (str.endsWith("/")) {
            str3 = str + Url.QstnSurveyAnswer + str2 + str3;
        } else {
            str3 = str + "/" + Url.QstnSurveyAnswer + str2 + str3;
        }
        C2538c.m12677c(this.f8785a, "========nps submitSurvey requestNpsUrl: " + str3);
        if (C0977d.m3555e(this.f8786b)) {
            m12264a(1, str3, this.f8803t, this.f8804u, hashMap);
        }
        C2538c.m12677c(this.f8785a, "========nps Leave submitSurvey");
    }

    protected ErrorListener m12271c() {
        return new C2450f(this);
    }

    private void m12257k() {
        C2538c.m12677c(this.f8785a, "nps Enter generateNpsMessage !!!");
        this.f8807y.m10247a("nps", "nps_type_message", new C2451g(this));
    }

    private void m12258l() {
        C2538c.m12677c(this.f8785a, "nps Enter showSelectQstnDialog");
        C2426a a = C2426a.m12202a();
        a.m12203a(this.f8786b.getString(com.huawei.ui.main.j.IDS_messagecenter_nps_title));
        a.m12206b(this.f8786b.getString(com.huawei.ui.main.j.IDS_nps_success_message_2));
        a.m12204a(this.f8786b.getString(com.huawei.ui.main.j.IDS_nps_participate_sure), new C2452h(this));
        a.m12207b(this.f8786b.getString(com.huawei.ui.main.j.IDS_nps_participate_cancel), new C2453i(this));
        Intent intent = new Intent();
        intent.setClassName(this.f8786b, NPSDialogActivity.class.getName());
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f8786b.startActivity(intent);
        C2538c.m12677c(this.f8785a, "nps Leave showSelectQstnDialog");
    }

    public QstnSurveyTable m12272d() {
        this.f8788d = m12239c(m12247f(j.a()));
        return this.f8788d;
    }

    private void m12240c(long j) {
        C2538c.m12677c(this.f8785a, "Enter setQstnSurveyTable");
        this.f8788d = m12239c(m12247f(j.a()));
        if (this.f8788d != null) {
            if (-1 != this.f8800q) {
                this.f8788d.id = this.f8800q;
            }
            this.f8788d.setSurveyID(this.f8799p);
            this.f8788d.setTimes(Integer.valueOf(this.f8788d.times.intValue() + 1));
            long time = new Date().getTime();
            if (j <= 0) {
                j = time;
            }
            this.f8788d.setLastSurveyTime(j);
            m12265a(this.f8788d);
            C2538c.m12677c(this.f8785a, "Leave setQstnSurveyTable");
        }
    }

    public void m12265a(QstnSurveyTable qstnSurveyTable) {
        C2538c.m12677c(this.f8785a, "========nps Enter updateQstnSurveyTable ");
        if (qstnSurveyTable == null) {
            C2538c.m12677c(this.f8785a, "========nps mQuestionSurveyTable is null return ");
            return;
        }
        C2448a c2448a = new C2448a(this.f8786b);
        C2538c.m12677c(this.f8785a, "========nps mQuestionSurveyTable:" + qstnSurveyTable.toString());
        c2448a.m12283b(this, qstnSurveyTable);
        C2538c.m12677c(this.f8785a, "========nps Leave updateQstnSurveyTable ");
    }

    private void m12245e(String str) {
        C2538c.m12677c(this.f8785a, "========nps Enter loadInitialData paraNpsUrl = " + str);
        int i = this.f8801r + 1;
        C2538c.m12677c(this.f8785a, "========nps loadInitialData times = " + i);
        if (i < 1 || i > 2) {
            C2538c.m12677c(this.f8785a, "========nps loadInitialData (times < 1 || times > 2) return!");
            return;
        }
        String str2 = "" + i;
        m12259m();
        Map hashMap = new HashMap();
        hashMap.put("model", this.f8789e);
        hashMap.put("firmware", this.f8790f);
        hashMap.put("sn", this.f8791g == null ? "sn" : this.f8791g);
        hashMap.put("language", this.f8792h);
        hashMap.put("os", this.f8793i);
        hashMap.put("appID", "3");
        hashMap.put("times", str2);
        C2538c.m12677c(this.f8785a, "========nps loadInitialData map:" + hashMap.toString());
        String str3 = "";
        str3 = "?cVer=21319";
        str2 = "&channel=100001";
        if (str.endsWith("/")) {
            str2 = str + Url.QstnSurveyRequest + str3 + str2;
        } else {
            str2 = str + "/" + Url.QstnSurveyRequest + str3 + str2;
        }
        C2538c.m12677c(this.f8785a, "========nps loadInitialData requestNpsUrl: " + str2);
        if (C0977d.m3555e(this.f8786b)) {
            m12264a(1, str2, m12260n(), m12262p(), hashMap);
        } else {
            f8783n = false;
        }
        C2538c.m12677c(this.f8785a, "========nps Leave loadInitialData ");
    }

    private void m12259m() {
        this.f8792h = Locale.getDefault().getLanguage();
        this.f8789e = j.b();
        if ((this.f8789e == null || "".equals(this.f8789e)) && this.f8788d != null) {
            this.f8789e = this.f8788d.getDeviceType();
        }
        this.f8790f = j.c();
        if (this.f8790f == null || "".equals(this.f8790f)) {
            this.f8790f = "firmware";
        }
        this.f8793i = "" + VERSION.SDK_INT;
        this.f8791g = m12247f(j.a());
        if ((this.f8791g == null || this.f8791g.isEmpty()) && this.f8788d != null) {
            this.f8791g = this.f8788d.getDeviceID();
        }
    }

    private Listener<String> m12260n() {
        return new C2454j(this);
    }

    private void m12261o() {
        long j = 0;
        if (this.f8794j != null) {
            C2538c.m12674b(this.f8785a, "=====nps processGetSurveyResponse resCode: ", Integer.valueOf(this.f8794j.getResCode()));
            Date b;
            if (this.f8794j.getResCode() == 0) {
                C2538c.m12674b(this.f8785a, "=====nps processGetSurveyResponse 获取新的问卷");
                this.f8795k = C2441a.m12223a();
                if (this.f8795k == null) {
                    this.f8795k = new ArrayList();
                }
                this.f8795k.clear();
                List<QstnSureyResponse> questions = this.f8794j.getSurveyContent().getQuestions();
                if (questions == null) {
                    C2538c.m12674b(this.f8785a, "=========nps processGetSurveyResponse null == questionList");
                    return;
                }
                for (QstnSureyResponse add : questions) {
                    this.f8795k.add(add);
                }
                if (this.f8795k.size() < 1) {
                    C2538c.m12674b(this.f8785a, "=========nps processGetSurveyResponse questions.size()<1");
                    return;
                }
                long time;
                C2441a.m12224a(this.f8795k);
                if ("K1".equals(this.f8789e) || "K2".equals(this.f8789e)) {
                    m12258l();
                } else {
                    m12257k();
                }
                this.f8799p = this.f8794j.getSurveyID();
                if (this.f8799p != null) {
                    this.f8800q = C0977d.m3524a(this.f8799p, -1);
                }
                C2538c.m12674b(this.f8785a, "=========nps processGetSurveyResponse questionId:" + this.f8800q + "   questionSurveyID = " + this.f8799p);
                b = m.b(this.f8794j.getFirstTime());
                if (b != null) {
                    C2538c.m12674b(this.f8785a, "=========nps processGetSurveyResponse firstDate: " + b + " firstTime = " + b.getTime());
                    time = b.getTime();
                } else {
                    time = 0;
                }
                m12240c(time);
            } else if (305003 == this.f8794j.getResCode()) {
                C2538c.m12674b(this.f8785a, "=========nps processGetSurveyResponse errorCode 305003 getFirstTime :" + this.f8794j.getFirstTime());
                this.f8799p = "0";
                b = m.b(this.f8794j.getFirstTime());
                if (b != null) {
                    C2538c.m12674b(this.f8785a, "=========nps processGetSurveyResponse errorCode 305003, update table firstDate: " + b + " firstTime = " + b.getTime());
                    j = b.getTime();
                }
                m12240c(j);
            }
        }
    }

    private ErrorListener m12262p() {
        return new C2456l(this);
    }

    public void m12264a(int i, String str, Listener<String> listener, ErrorListener errorListener, Map<String, String> map) {
        if (this.f8806w != null) {
            C2538c.m12677c(this.f8785a, "nps executeRequest mClondMgr.executeStringRequest !");
            this.f8806w.a(i, str, listener, errorListener, map);
        }
    }

    public void m12266a(String str) {
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(this.f8786b, String.valueOf(10004), "nps_question_content_info", str, c0993c);
        C2538c.m12677c(this.f8785a, "nps setQuestionDetail question = " + str);
    }

    public String m12273e() {
        String str = "";
        str = C0996a.m3612a(this.f8786b, String.valueOf(10004), "nps_question_content_info");
        C2538c.m12677c(this.f8785a, "nps getQuestionDetail question = " + str);
        return str;
    }

    public void m12267a(String str, Listener<String> listener, ErrorListener errorListener) {
        C2538c.m12677c(this.f8785a, "nps Enter submitSurveyQuestion!");
        if (!(str == null || str.isEmpty())) {
            this.f8802s = true;
            this.f8803t = listener;
            this.f8804u = errorListener;
            this.f8805v = str;
            m12252h();
        }
        C2538c.m12677c(this.f8785a, "nps Leave submitSurveyQuestion!");
    }

    public static boolean m12248f() {
        return f8783n;
    }

    public static void m12231a(boolean z) {
        f8783n = z;
    }

    public String m12269b(Context context) {
        String str = "";
        String str2 = "";
        String country = Locale.getDefault().getCountry();
        String[] stringArray = context.getResources().getStringArray(com.huawei.ui.main.b.CountryCodes);
        C2538c.m12677c(this.f8785a, "getMobileCountryCode strCountryID = " + country);
        if (stringArray == null) {
            return str2;
        }
        for (String split : stringArray) {
            String[] split2 = split.split(",");
            if (split2 != null && split2[1].trim().equals(country.toUpperCase().trim())) {
                str = split2[0];
                break;
            }
        }
        str = str2;
        C2538c.m12677c(this.f8785a, "getMobileCountryCode resCountryCode = " + str);
        return str;
    }

    private String m12247f(String str) {
        String str2 = "";
        if (str == null || "".equals(str)) {
            C2538c.m12677c(this.f8785a, "getDeviceID npsDeviceId is null return!");
            return str2;
        }
        if (HwAccountConstants.DEFAULT_COUNTRY_MNC.equals(m12269b(this.f8786b))) {
            C2538c.m12677c(this.f8785a, "getDeviceID in China!!!");
        } else {
            C2538c.m12677c(this.f8785a, "getDeviceID in Overseas!!!");
            String str3 = "";
            com.huawei.o.b a = com.huawei.o.b.a(this.f8786b);
            if (a != null) {
                str3 = a.a("09F98935DF23B3E011F5638614670662IrzLoccccR72B/H4EI3GKB6ny7lTZGH7IB4hQWa2qra9LliDA6e9/qgL/9yUjVL0");
            }
            str = (TextUtils.isEmpty(str3) || str3.length() <= 0) ? str2 : m12228a(str, str3);
        }
        C2538c.m12677c(this.f8785a, "getDeviceID npsDeviceId = " + str);
        return str;
    }

    private String m12228a(String str, String str2) {
        C2538c.m12674b(this.f8785a, "=======nps Enter hmacsha256  macData:" + str + "  macKey:" + str2);
        try {
            byte[] bytes = str2.getBytes(GameManager.DEFAULT_CHARSET);
            byte[] bytes2 = str.getBytes(GameManager.DEFAULT_CHARSET);
            Key secretKeySpec = new SecretKeySpec(bytes, "HMACSHA256");
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return URLEncoder.encode(Base64.encodeToString(instance.doFinal(bytes2), 2), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b(this.f8785a, "UnsupportedEncodingException e" + e.getMessage());
            return "";
        } catch (NoSuchAlgorithmException e2) {
            C2538c.m12674b(this.f8785a, "NoSuchAlgorithmException e" + e2.getMessage());
            return "";
        } catch (InvalidKeyException e3) {
            C2538c.m12674b(this.f8785a, "InvalidKeyException e" + e3.getMessage());
            return "";
        }
    }
}
