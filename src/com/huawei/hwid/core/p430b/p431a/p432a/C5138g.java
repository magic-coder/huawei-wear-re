package com.huawei.hwid.core.p430b.p431a.p432a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.C5125a.C5122d;
import com.huawei.hwid.core.p430b.p431a.C5141d;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VerifyPasswordRequest */
public class C5138g extends C5125a {
    private String f18561h = "7";
    private String f18562i;
    private String f18563j;
    private String f18564k;
    private String f18565l = "/IUserPwdMng/verifyPassword";
    private String f18566m = (m24692d() + this.f18565l);

    /* compiled from: VerifyPasswordRequest */
    class C5137a extends C5107a {
        private CloudRequestHandler f18560a;

        public C5137a(Context context, CloudRequestHandler cloudRequestHandler) {
            super(context);
            this.f18560a = cloudRequestHandler;
        }

        public void mo4615a(Bundle bundle) {
            super.mo4615a(bundle);
            this.f18560a.onFinish(bundle);
        }

        public void mo4616b(Bundle bundle) {
            super.mo4616b(bundle);
            ErrorStatus errorStatus = (ErrorStatus) bundle.getParcelable("requestError");
            if (errorStatus != null) {
                this.f18560a.onError(errorStatus);
            } else {
                this.f18560a.onError(new ErrorStatus(32, "ErrorStatus is null"));
            }
        }
    }

    public C5138g() {
        m24683a(C5122d.URLType);
    }

    public C5138g(Context context, String str, String str2, String str3, String str4) {
        m24683a(C5122d.URLType);
        m24796g(str2);
        m24797h(str);
        m24798i(str3);
        m24799j(str4);
        m24687b(70002003);
    }

    protected String mo4633f() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ver=").append("12000").append(SNBConstant.FILTER).append("acT=").append(this.f18564k).append(SNBConstant.FILTER).append("ac=").append(this.f18562i).append(SNBConstant.FILTER).append("pw=").append(this.f18563j).append(SNBConstant.FILTER).append("clT=").append(this.f18561h);
        Bundle bundle = new Bundle();
        bundle.putString("acT", this.f18564k);
        bundle.putString("ac", C5203g.m25322d(this.f18562i));
        bundle.putString("pw", this.f18563j);
        bundle.putString("clT", this.f18561h);
        C5165e.m24906b("VerifyPasswordRequest", "postString:" + C5203g.m25314a(bundle));
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
            if (this.b != 0) {
                this.c = this.b;
                this.d = (String) hashMap.get(obj);
                C5165e.m24912e("VerifyPasswordRequest", "mErrorCode:" + this.c + ",mErrorDesc:" + C5203g.m25316a(this.d));
            }
        }
    }

    private void m24796g(String str) {
        this.f18563j = str;
    }

    private void m24797h(String str) {
        this.f18562i = str;
    }

    private void m24798i(String str) {
        this.f18564k = str;
    }

    private void m24799j(String str) {
        this.f18561h = str;
    }

    protected String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException {
        return null;
    }

    protected void mo4628a(String str) throws XmlPullParserException, IOException {
    }

    public String mo4630g() {
        return this.f18566m;
    }

    public void mo4627a(Context context, C5125a c5125a, String str, CloudRequestHandler cloudRequestHandler) {
        C5141d.m24813a(context, c5125a, str, m24677a(context, c5125a, new C5137a(context, cloudRequestHandler)));
    }
}
