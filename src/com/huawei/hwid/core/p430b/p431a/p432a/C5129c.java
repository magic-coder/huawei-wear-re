package com.huawei.hwid.core.p430b.p431a.p432a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.C5141d;
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

/* compiled from: ServiceLogoutRequest */
public class C5129c extends C5125a {
    private String f18515h;
    private String f18516i;
    private String f18517j;
    private String f18518k;
    private String f18519l = (m24692d() + "/IUserInfoMng/serviceLogout");

    public C5129c(String str, String str2, String str3) {
        this.f18515h = str;
        this.f18516i = str2;
        this.f18517j = str3;
    }

    protected String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XmlSerializer a = C5184o.m25071a(byteArrayOutputStream);
        a.startDocument(GameManager.DEFAULT_CHARSET, Boolean.valueOf(true));
        a.startTag(null, "ServiceLogoutReq");
        C5184o.m25072a(a, "version", "12000");
        C5184o.m25072a(a, "userID", this.f18515h);
        C5184o.m25072a(a, "appID", this.f18516i);
        C5184o.m25072a(a, "tokenOrST", this.f18517j);
        a.endTag(null, "ServiceLogoutReq");
        a.endDocument();
        String byteArrayOutputStream2 = byteArrayOutputStream.toString(GameManager.DEFAULT_CHARSET);
        Bundle bundle = new Bundle();
        bundle.putString("version", "12000");
        bundle.putString("userID", this.f18515h);
        bundle.putString("appID", this.f18516i);
        bundle.putString("tokenOrST", this.f18517j);
        C5165e.m24906b("ServiceLogoutRequest", "packedString: " + C5203g.m25314a(bundle));
        return byteArrayOutputStream2;
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
                    } else if (!"delTGCCount".equals(name)) {
                        break;
                    } else {
                        this.f18518k = a.nextText();
                        break;
                    }
                default:
                    break;
            }
        }
    }

    public String mo4630g() {
        return this.f18519l;
    }

    public void m24743a(Context context, C5125a c5125a, String str, C5107a c5107a) {
        C5141d.m24813a(context, c5125a, str, m24677a(context, c5125a, c5107a));
    }

    public Bundle mo4631h() {
        Bundle h = super.mo4631h();
        h.putString("delCount", this.f18518k);
        return h;
    }
}
