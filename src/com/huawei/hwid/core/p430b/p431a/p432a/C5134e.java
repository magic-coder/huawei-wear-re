package com.huawei.hwid.core.p430b.p431a.p432a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5201e;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.C5125a.C5122d;
import com.huawei.hwid.core.p430b.p431a.C5141d;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p428c.C5115a;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p306a.p307a.C3939a;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: UIDVerifyPasswordRequest */
public class C5134e extends C5125a {
    private String f18538h;
    private String f18539i;
    private String f18540j = "com.huawei.hwid";
    private String f18541k;
    private int f18542l = 7;
    private String f18543m;
    private String f18544n;
    private String f18545o;
    private String f18546p;
    private int f18547q;
    private String f18548r;
    private String f18549s = "/IUserPwdMng/uidVerifyPassword";
    private String f18550t = (m24692d() + this.f18549s);
    private String f18551u;
    private Context f18552v;

    /* compiled from: UIDVerifyPasswordRequest */
    public class C5132a {
        public String f18534a = "";
        public String f18535b = "";
        private boolean f18536c = false;

        public C5132a(String str) {
            if (!TextUtils.isEmpty(str)) {
                int lastIndexOf = str.lastIndexOf("&resultDigest=");
                if (lastIndexOf != -1) {
                    this.f18534a = str.substring(0, lastIndexOf);
                    this.f18535b = str.substring(lastIndexOf + "&resultDigest=".length());
                    this.f18536c = true;
                }
            }
        }

        public boolean m24765a() {
            return this.f18536c;
        }
    }

    /* compiled from: UIDVerifyPasswordRequest */
    class C5133b extends C5107a {
        private CloudRequestHandler f18537a;

        public C5133b(Context context, CloudRequestHandler cloudRequestHandler) {
            super(context);
            this.f18537a = cloudRequestHandler;
        }

        public void mo4615a(Bundle bundle) {
            super.mo4615a(bundle);
            this.f18537a.onFinish(bundle);
        }

        public void mo4616b(Bundle bundle) {
            super.mo4616b(bundle);
            ErrorStatus errorStatus = (ErrorStatus) bundle.getParcelable("requestError");
            if (errorStatus != null) {
                this.f18537a.onError(errorStatus);
            } else {
                this.f18537a.onError(new ErrorStatus(32, "ErrorStatus is null"));
            }
        }
    }

    public C5134e(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        C5165e.m24906b("UidVerifyPasswordRequest", "userId = " + C5203g.m25318a("userId", (Object) str) + "appId = " + str2);
        this.f18552v = context;
        m24683a(C5122d.URLType);
        m24770h(str3);
        if (!TextUtils.isEmpty(str2)) {
            m24769g(str2);
        }
        m24771i(str);
        HwAccount b = C5115a.m24641a(context).m24646b();
        if (b == null) {
            b = C5115a.m24641a(context).m24647c();
        }
        if (b != null) {
            m24690c(C5166b.m24914a(context, b.m25120b()));
        }
        m24772j(str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = C5182m.m25054b(context);
        }
        m24773k(str5);
        m24774l(C5182m.m25061e(context));
        if (TextUtils.isEmpty(str6)) {
            str6 = C5182m.m25049a(context, str5);
        }
        m24775m(str6);
        m24687b(70002003);
        m24687b(70002058);
    }

    private void m24769g(String str) {
        this.f18540j = str;
    }

    protected String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException {
        return null;
    }

    protected void mo4628a(String str) throws XmlPullParserException, IOException {
    }

    protected String mo4633f() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ver=").append("12000").append(SNBConstant.FILTER).append("uid=").append(this.f18538h).append(SNBConstant.FILTER).append("pw=").append(this.f18539i).append(SNBConstant.FILTER).append("clT=").append(this.f18542l).append(SNBConstant.FILTER).append("app=").append(this.f18540j).append(SNBConstant.FILTER).append("dvT=").append(this.f18546p).append(SNBConstant.FILTER).append("dvID=").append(this.f18544n).append(SNBConstant.FILTER).append("dvID2=").append(this.f18545o).append(SNBConstant.FILTER).append("fg=").append(this.f18541k);
        this.f18551u = C3939a.m19590a();
        stringBuffer.append("&salt=").append(this.f18551u);
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.f18538h);
        bundle.putString("pw", this.f18539i);
        bundle.putString("clT", String.valueOf(this.f18542l));
        bundle.putString("app", this.f18540j);
        bundle.putString("dvT", this.f18546p);
        bundle.putString("dvID", this.f18544n);
        bundle.putString("fg", this.f18541k);
        C5165e.m24906b("UidVerifyPasswordRequest", "postString:" + C5203g.m25314a(bundle));
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
                this.f18548r = (String) hashMap.get("userID");
                this.f18543m = (String) hashMap.get(BundleKey.KEY_ST);
                String str2 = (String) hashMap.get("siteID");
                try {
                    this.f18547q = Integer.parseInt(str2);
                } catch (Throwable e) {
                    C5165e.m24911d("TGC", "pares siteId:" + str2 + ", err:" + e.getMessage(), e);
                }
                C5165e.m24904a("UidVerifyPasswordRequest", "mRtnUserId:" + C5203g.m25318a("userId", this.f18548r) + ",mSiteId:" + C5203g.m25315a(Integer.valueOf(this.f18547q)));
                if (!m24768a(str, hashMap)) {
                    this.b = 70002003;
                    this.c = this.b;
                    this.d = "Failed to verify signature.";
                    C5165e.m24910d("UidVerifyPasswordRequest", "Failed to verify the digital signature of VerifyPassword response.");
                    return;
                }
                return;
            }
            this.c = this.b;
            this.d = (String) hashMap.get(obj);
            C5165e.m24912e("UidVerifyPasswordRequest", "mErrorCode:" + this.c + ",mErrorDesc:" + C5203g.m25316a(this.d));
        }
    }

    private boolean m24768a(String str, HashMap<String, String> hashMap) {
        if (hashMap.containsKey("salt")) {
            String str2 = (String) hashMap.get("salt");
            if (this.f18551u != null && this.f18551u.equals(str2)) {
                C5132a c5132a = new C5132a(str);
                if (c5132a.m24765a() && C3939a.m19591a(c5132a.f18534a, c5132a.f18535b, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp/+96hx/XKdWBKS6yh14vERYLhg84G52FNXS1YKEll0VFdMHAVWRZlOLguYptqd+1LZePWvgXUEXws+/ibetjhBWG0n85UyhSC8r0g4/gRTQcNna0HbPRx9WMS2XkMWD33T24BZSuEnPOBjOwJrHCVnJDqZVrw3g+gfYygXo1KVJOM0VRA97zbQxsLQIZhTj7DUG5ySj5ltrPVmpLydppYQxp+JUG2vwo2ifqYvcPzVjRcw44rK1gT6d+DHeziw7ZmnOwog2uUyDULNbMWc1e4RFYssRS8yV2vSJNyTKwZw5IdfPBBCpoX9M7Fp6ivUkZVEtVJQHXcompv37KxoUVwIDAQAB")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void m24770h(String str) {
        this.f18539i = str;
    }

    private void m24771i(String str) {
        this.f18538h = str;
    }

    private void m24772j(String str) {
        this.f18541k = str;
    }

    private void m24773k(String str) {
        this.f18544n = str;
    }

    private void m24774l(String str) {
        this.f18545o = str;
    }

    private void m24775m(String str) {
        this.f18546p = str;
    }

    public String mo4630g() {
        return this.f18550t;
    }

    public Bundle mo4631h() {
        this.f18543m = C5201e.m25309d(this.f18552v, this.f18543m);
        Bundle h = super.mo4631h();
        h.putString("serviceToken", this.f18543m);
        h.putString("userID", this.f18548r);
        h.putInt("siteID", this.f18547q);
        return h;
    }

    public void mo4627a(Context context, C5125a c5125a, String str, CloudRequestHandler cloudRequestHandler) {
        C5141d.m24813a(context, c5125a, str, m24677a(context, c5125a, new C5133b(context, cloudRequestHandler)));
    }
}
