package com.huawei.hwid.core.p430b.p431a.p432a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.C5141d;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5184o;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.sina.weibo.sdk.component.GameManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: UpdateUserInfoRequest */
public class C5136f extends C5125a {
    private String f18554h = "7";
    private String f18555i;
    private UserInfo f18556j;
    private String f18557k;
    private String f18558l;
    private String f18559m = (m24692d() + "/IUserInfoMng/updateUserInfo");

    /* compiled from: UpdateUserInfoRequest */
    class C5135a extends C5107a {
        private CloudRequestHandler f18553a;

        public C5135a(Context context, CloudRequestHandler cloudRequestHandler) {
            super(context);
            this.f18553a = cloudRequestHandler;
        }

        public void mo4615a(Bundle bundle) {
            super.mo4615a(bundle);
            this.f18553a.onFinish(bundle);
        }

        public void mo4616b(Bundle bundle) {
            super.mo4616b(bundle);
            ErrorStatus errorStatus = (ErrorStatus) bundle.getParcelable("requestError");
            if (errorStatus != null) {
                this.f18553a.onError(errorStatus);
            } else {
                this.f18553a.onError(new ErrorStatus(32, "ErrorStatus is null"));
            }
        }
    }

    public C5136f() {
        m24689b(true);
    }

    private void m24786g(String str) {
        this.f18558l = str;
    }

    protected String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer b = C5184o.m25073b(byteArrayOutputStream);
            b.startDocument(GameManager.DEFAULT_CHARSET, Boolean.valueOf(true));
            b.startTag(null, "UpdateUserInfoReq");
            C5184o.m25072a(b, "version", "12000");
            C5184o.m25072a(b, "userID", this.f18555i);
            C5184o.m25072a(b, CloudAccount.KEY_REQCLIENTTYPE, this.f18554h);
            C5184o.m25072a(b, "password", this.f18557k);
            if (this.f18556j != null) {
                b.startTag(null, "userInfo");
                if (!(this.f18558l == null || this.f18558l.isEmpty())) {
                    this.f18556j.setLanguageCode(this.f18558l);
                }
                UserInfo.setUserInfoIntag(b, this.f18556j);
                b.endTag(null, "userInfo");
            }
            b.endTag(null, "UpdateUserInfoReq");
            b.endDocument();
            String byteArrayOutputStream2 = byteArrayOutputStream.toString(GameManager.DEFAULT_CHARSET);
            Bundle bundle = new Bundle();
            bundle.putString("version", "12000");
            bundle.putString("userID", this.f18555i);
            bundle.putString(CloudAccount.KEY_REQCLIENTTYPE, this.f18554h);
            bundle.putString("password", this.f18557k);
            C5165e.m24906b("UpdateUserInfoRequest", "packedString:" + C5203g.m25314a(bundle));
            return byteArrayOutputStream2;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                C5165e.m24910d("UpdateUserInfoRequest", e.getMessage());
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

    public String mo4630g() {
        return this.f18559m;
    }

    private void m24787h(String str) {
        this.f18555i = str;
    }

    private void m24785a(UserInfo userInfo) {
        this.f18556j = userInfo;
    }

    private void m24788i(String str) {
        this.f18557k = str;
    }

    public Bundle mo4631h() {
        return super.mo4631h();
    }

    public C5136f(String str, String str2, String str3, UserInfo userInfo, String str4, Bundle bundle) {
        m24689b(true);
        m24787h(str);
        if (!TextUtils.isEmpty(str4)) {
            m24788i(str4);
        }
        m24785a(userInfo);
        m24687b(70005002);
        m24687b(70006007);
        m24687b(70005003);
        m24687b(70005005);
        m24687b(70001201);
    }

    public void mo4627a(Context context, C5125a c5125a, String str, CloudRequestHandler cloudRequestHandler) {
        m24786g(C5166b.m24948f(context));
        C5141d.m24813a(context, c5125a, str, m24677a(context, c5125a, new C5135a(context, cloudRequestHandler)));
    }
}
