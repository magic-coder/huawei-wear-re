package com.huawei.hwid.core.p430b.p431a.p432a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.helper.handler.C5107a;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p429a.C5116a;
import com.huawei.hwid.core.p429a.C5118c;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p430b.p431a.C5141d;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5178i;
import com.huawei.hwid.core.p435d.C5184o;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.sina.weibo.sdk.component.GameManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: OpLogRequest */
public class C5128b extends C5125a {
    private String f18513h = (m24692d() + "/IUserInfoMng/opLog");
    private String f18514i;

    /* compiled from: OpLogRequest */
    public class C5127a extends C5107a {
        private Context f18512a;

        public C5127a(Context context) {
            super(context);
            this.f18512a = context;
        }

        public void mo4615a(Bundle bundle) {
            super.mo4615a(bundle);
            C5165e.m24912e("OpLogRequest", "upload log success");
            C5116a.m24648a(this.f18512a).m24651a();
            C5118c.m24663a(0);
            C5118c.m24664a(this.f18512a);
        }

        public void mo4616b(Bundle bundle) {
            super.mo4616b(bundle);
            ErrorStatus errorStatus = (ErrorStatus) bundle.getParcelable("requestError");
            if (errorStatus != null) {
                C5165e.m24910d("OpLogRequest", "OpLogUploadHelper execute error:" + C5203g.m25316a(errorStatus.getErrorReason()));
            }
            C5118c.m24663a(0);
            C5118c.m24664a(this.f18512a);
        }
    }

    protected String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException {
        return this.f18514i;
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
        return this.f18513h;
    }

    public Bundle mo4631h() {
        return super.mo4631h();
    }

    public C5128b(String str) {
        m24693d(1);
        this.f18514i = str;
    }

    public void mo4627a(Context context, C5125a c5125a, String str, CloudRequestHandler cloudRequestHandler) {
        if (c5125a.m24711s() <= 0) {
            str = C5166b.m24961m(context);
            C5165e.m24904a("OpLogRequest", "OpLogRequest currName" + C5203g.m25316a(str));
            if (TextUtils.isEmpty(str)) {
                c5125a.m24690c(C5178i.m25024a(context));
            } else {
                C5165e.m24904a("OpLogRequest", "has alreacdy accountName logined in");
            }
        }
        C5141d.m24813a(context.getApplicationContext(), c5125a, str, m24677a(context, c5125a, new C5127a(context)));
    }
}
