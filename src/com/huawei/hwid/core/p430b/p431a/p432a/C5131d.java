package com.huawei.hwid.core.p430b.p431a.p432a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.C5125a.C5122d;
import com.huawei.hwid.core.p430b.p431a.C5141d;
import com.huawei.hwid.core.p435d.C5154a;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.C5184o;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.log4j.helpers.DateLayout;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ServiceTokenAuthRequest */
public class C5131d extends C5125a {
    private String f18521h;
    private String f18522i = "0";
    private String f18523j;
    private String f18524k = "";
    private String f18525l = "7";
    private String f18526m;
    private String f18527n;
    private String f18528o;
    private String f18529p;
    private String f18530q;
    private String f18531r;
    private String f18532s;
    private int f18533t;

    /* compiled from: ServiceTokenAuthRequest */
    class C5130a extends C5107a {
        private CloudRequestHandler f18520a;

        public C5130a(Context context, CloudRequestHandler cloudRequestHandler) {
            super(context);
            this.f18520a = cloudRequestHandler;
        }

        public void mo4615a(Bundle bundle) {
            super.mo4615a(bundle);
            bundle.putBoolean(HwAccountConstants.SERVICETOKENAUTH_IS_SECCUSS, true);
            this.f18520a.onFinish(bundle);
        }

        public void mo4616b(Bundle bundle) {
            super.mo4616b(bundle);
            ErrorStatus errorStatus = (ErrorStatus) bundle.getParcelable("requestError");
            if (errorStatus != null) {
                this.f18520a.onError(errorStatus);
            } else {
                this.f18520a.onError(new ErrorStatus(32, "ErrorStatus is null"));
            }
        }
    }

    public C5131d() {
        this.f18531r = m24712t() ? "/IUserInfoMng/stAuth" : "/IUserInfoMng/serviceTokenAuth";
        this.f18532s = m24692d() + this.f18531r;
        this.f18533t = 1;
        this.g = 0;
        m24683a(C5122d.URLType);
    }

    protected String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String a;
        try {
            a = C5184o.m25071a(byteArrayOutputStream);
            a.startDocument(GameManager.DEFAULT_CHARSET, Boolean.valueOf(true));
            a.startTag(null, "ServiceTokenAuthReq");
            C5184o.m25072a(a, "version", "12000");
            C5184o.m25072a(a, "serviceToken", this.f18523j);
            C5184o.m25072a(a, "appID", TextUtils.isEmpty(this.f18524k) ? "com.huawei.hwid" : this.f18524k);
            a.startTag(null, "deviceInfo");
            C5184o.m25072a(a, "deviceID", this.f18527n);
            C5184o.m25072a(a, "deviceType", this.f18526m);
            C5184o.m25072a(a, "terminalType", C5182m.m25053b());
            a.endTag(null, "deviceInfo");
            C5184o.m25072a(a, CloudAccount.KEY_REQCLIENTTYPE, this.f18525l);
            C5184o.m25072a(a, "clientIP", "");
            C5184o.m25072a(a, CloudAccount.KEY_LOGIN_CHANNEL, this.f18529p);
            C5184o.m25072a(a, "uuid", this.f18528o);
            C5184o.m25072a(a, "chkAcctChange", "0");
            C5184o.m25072a(a, "isGetAccount", "0");
            C5184o.m25072a(a, "isGetAgrVers", this.f18522i);
            a.endTag(null, "ServiceTokenAuthReq");
            a.endDocument();
            a = byteArrayOutputStream.toString(GameManager.DEFAULT_CHARSET);
            Bundle bundle = new Bundle();
            bundle.putString("version", "12000");
            bundle.putString("serviceToken", this.f18523j);
            bundle.putString("appID", TextUtils.isEmpty(this.f18524k) ? "com.huawei.hwid" : this.f18524k);
            bundle.putString("deviceID", this.f18527n);
            bundle.putString("deviceType", this.f18526m);
            bundle.putString("terminalType", C5182m.m25053b());
            bundle.putString(CloudAccount.KEY_REQCLIENTTYPE, this.f18525l);
            bundle.putString("clientIP", "");
            bundle.putString(CloudAccount.KEY_LOGIN_CHANNEL, this.f18529p);
            bundle.putString("uuid", this.f18528o);
            bundle.putString("chkAcctChange", "0");
            bundle.putString("isGetAccount", "0");
            C5165e.m24906b("ServiceTokenAuthRequest", "packedString:" + C5203g.m25314a(bundle));
            return a;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                a = "ServiceTokenAuthRequest";
                C5165e.m24910d(a, e.getMessage());
            }
        }
    }

    protected void mo4628a(String str) throws XmlPullParserException, IOException {
        XmlPullParser a = C5184o.m25070a(str.getBytes(GameManager.DEFAULT_CHARSET));
        for (int eventType = a.getEventType(); 1 != eventType; eventType = a.next()) {
            String name = a.getName();
            switch (eventType) {
                case 2:
                    if ("result".equals(name)) {
                        this.b = Integer.valueOf(a.getAttributeValue(null, "resultCode")).intValue();
                    }
                    if (this.b != 0) {
                        if (!Constant.KEY_ERROR_CODE.equals(name)) {
                            if (!Constant.KEY_ERROR_DESC.equals(name)) {
                                break;
                            }
                            this.d = a.nextText();
                            break;
                        }
                        this.c = Integer.valueOf(a.nextText()).intValue();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    protected String mo4633f() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ver=").append("12000").append(SNBConstant.FILTER).append("st=").append(this.f18523j).append(SNBConstant.FILTER).append("app=").append(TextUtils.isEmpty(this.f18524k) ? "com.huawei.hwid" : this.f18524k).append(SNBConstant.FILTER).append("dvT=").append(this.f18526m).append(SNBConstant.FILTER).append("dvID=").append(m24750B()).append(SNBConstant.FILTER).append("tmT=").append(C5182m.m25046a()).append(SNBConstant.FILTER).append("clT=").append(this.f18525l).append(SNBConstant.FILTER).append("cn=").append(this.f18529p).append(SNBConstant.FILTER).append("chg=").append("0").append(SNBConstant.FILTER).append("gAc=").append("0").append(SNBConstant.FILTER).append("uuid=").append(this.f18528o).append(SNBConstant.FILTER).append("agr=").append(this.f18522i);
        Bundle bundle = new Bundle();
        bundle.putString(BundleKey.KEY_ST, this.f18523j);
        bundle.putString("app", TextUtils.isEmpty(this.f18524k) ? "com.huawei.hwid" : this.f18524k);
        bundle.putString("dvT", this.f18526m);
        bundle.putString("dvID", m24750B());
        bundle.putString("tmT", C5182m.m25046a());
        bundle.putString("clT", this.f18525l);
        bundle.putString(HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE, this.f18529p);
        bundle.putString("chg", "0");
        bundle.putString("gAc", "0");
        bundle.putString("uuid", this.f18528o);
        bundle.putString("agr", this.f18522i);
        C5165e.m24906b("ServiceTokenAuthRequest", "postString:" + C5203g.m25314a(bundle));
        return stringBuffer.toString();
    }

    protected void mo4632b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(SNBConstant.FILTER);
            HashMap hashMap = new HashMap();
            Object obj = "";
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                hashMap.put(split3[0], split3[1]);
                obj = split3[0];
            }
            if (hashMap.containsKey("resultCode")) {
                this.b = Integer.valueOf((String) hashMap.get("resultCode")).intValue();
            }
            if (this.b == 0) {
                this.f18530q = (String) hashMap.get("userID");
                this.f18521h = (String) hashMap.get("agrFlags");
                return;
            }
            this.c = this.b;
            this.d = (String) hashMap.get(obj);
            C5165e.m24912e("ServiceTokenAuthRequest", "mErrorCode:" + this.c + ",mErrorDesc:" + C5203g.m25316a(this.d));
        }
    }

    public String mo4630g() {
        return this.f18532s;
    }

    private void m24751g(String str) {
        this.f18524k = str;
    }

    private void m24752h(String str) {
        this.f18526m = str;
    }

    private void m24753i(String str) {
        this.f18523j = str;
    }

    private void m24754j(String str) {
        this.f18527n = str;
    }

    private void m24755k(String str) {
        this.f18528o = C5201e.m25305a(str);
    }

    private void m24756l(String str) {
        this.f18529p = str;
    }

    public String m24757A() {
        return this.f18530q;
    }

    public Bundle mo4631h() {
        Bundle h = super.mo4631h();
        h.putString("agrFlags", this.f18521h);
        return h;
    }

    private String m24750B() {
        String str = "";
        if (!DateLayout.NULL_DATE_FORMAT.equals(this.f18527n) && !TextUtils.isEmpty(this.f18527n)) {
            return this.f18527n;
        }
        if (DateLayout.NULL_DATE_FORMAT.equals(this.f18528o) || TextUtils.isEmpty(this.f18528o)) {
            return str;
        }
        return this.f18528o;
    }

    public C5131d(Context context, String str, String str2, int i, String str3) {
        this.f18531r = m24712t() ? "/IUserInfoMng/stAuth" : "/IUserInfoMng/serviceTokenAuth";
        this.f18532s = m24692d() + this.f18531r;
        this.f18533t = 1;
        if ("com.huawei.hwid".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
            str = "com.huawei.hwid";
        }
        this.g = 0;
        m24683a(C5122d.URLType);
        m24753i(C5201e.m25305a(str2));
        m24751g(context.getPackageName());
        m24754j(str3);
        m24755k(C5182m.m25048a(context, 0));
        m24752h(C5182m.m25047a(context));
        m24690c(i);
        m24693d(this.f18533t);
        m24756l(C5154a.m24846a(context, str));
        m24685a(true);
    }

    public void mo4627a(Context context, C5125a c5125a, String str, CloudRequestHandler cloudRequestHandler) {
        C5141d.m24813a(context, c5125a, str, m24677a(context, c5125a, new C5130a(context, cloudRequestHandler)));
    }
}
