package com.huawei.hwid.core.p430b.p431a.p432a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.ChildrenInfo;
import com.huawei.hwid.core.datatype.DeviceInfo;
import com.huawei.hwid.core.datatype.TmemberRight;
import com.huawei.hwid.core.datatype.UserAccountInfo;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.hwid.core.datatype.UserLoginInfo;
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
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetUserInfoRequest */
public class C5126a extends C5125a {
    private String f18488A = (m24692d() + "/IUserInfoMng/getUserInfo");
    private String f18489B;
    private String f18490C;
    private String f18491D;
    private String f18492E;
    int f18493h;
    boolean f18494i;
    boolean f18495j;
    boolean f18496k;
    boolean f18497l;
    boolean f18498m;
    boolean f18499n;
    DeviceInfo f18500o;
    UserAccountInfo f18501p;
    TmemberRight f18502q;
    ChildrenInfo f18503r;
    private String f18504s;
    private String f18505t;
    private UserInfo f18506u;
    private UserLoginInfo f18507v;
    private ArrayList<DeviceInfo> f18508w;
    private ArrayList<UserAccountInfo> f18509x;
    private ArrayList<TmemberRight> f18510y;
    private ArrayList<ChildrenInfo> f18511z;

    /* compiled from: GetUserInfoRequest */
    class C5124a extends C5107a {
        private CloudRequestHandler f18466a;
        private Context f18467c;

        public C5124a(Context context, CloudRequestHandler cloudRequestHandler) {
            super(context);
            this.f18466a = cloudRequestHandler;
            this.f18467c = context;
        }

        public void mo4615a(Bundle bundle) {
            super.mo4615a(bundle);
            if (!"com.huawei.hwid".equals(this.f18467c.getPackageName())) {
                C5166b.m24949f("getUserInfo");
            }
            UserInfo userInfo = (UserInfo) bundle.getParcelable("userInfo");
            UserLoginInfo userLoginInfo = (UserLoginInfo) bundle.getParcelable("userLoginInfo");
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("devicesInfo");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("accountsInfo");
            ArrayList parcelableArrayList3 = bundle.getParcelableArrayList(HwAccountConstants.EXTRA_MEMBERRIGHTS);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList("userAccountInfo", parcelableArrayList2);
            bundle2.putParcelableArrayList("deviceInfo", parcelableArrayList);
            bundle2.putParcelable("userInfo", userInfo);
            bundle2.putParcelable("userLoginInfo", userLoginInfo);
            bundle2.putParcelableArrayList(HwAccountConstants.EXTRA_MEMBERRIGHTS, parcelableArrayList3);
            this.f18466a.onFinish(bundle2);
        }

        public void mo4616b(Bundle bundle) {
            super.mo4616b(bundle);
            if (!"com.huawei.hwid".equals(this.f18467c.getPackageName())) {
                C5166b.m24949f("getUserInfo");
            }
            ErrorStatus errorStatus = (ErrorStatus) bundle.getParcelable("requestError");
            if (errorStatus != null) {
                this.f18466a.onError(errorStatus);
            } else {
                this.f18466a.onError(new ErrorStatus(32, "ErrorStatus is null"));
            }
        }
    }

    public C5126a() {
        m24689b(true);
    }

    protected String mo4629e() throws IllegalArgumentException, IllegalStateException, IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer a = C5184o.m25071a(byteArrayOutputStream);
            a.startDocument(GameManager.DEFAULT_CHARSET, Boolean.valueOf(true));
            a.startTag(null, "GetUserInfoReq");
            C5184o.m25072a(a, "version", "12000");
            C5184o.m25072a(a, "userID", this.f18504s);
            C5184o.m25072a(a, "queryRangeFlag", this.f18505t);
            a.endTag(null, "GetUserInfoReq");
            a.endDocument();
            String byteArrayOutputStream2 = byteArrayOutputStream.toString(GameManager.DEFAULT_CHARSET);
            Bundle bundle = new Bundle();
            bundle.putString("version", "12000");
            bundle.putString("userID", this.f18504s);
            bundle.putString("queryRangeFlag", this.f18505t);
            C5165e.m24906b("GetUserInfoRequest", "packedString:" + C5203g.m25314a(bundle));
            return byteArrayOutputStream2;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                C5165e.m24910d("GetUserInfoRequest", e.getMessage());
            }
        }
    }

    private void m24720a(String str, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if ("userID".equals(str) && !this.f18498m) {
            this.f18504s = xmlPullParser.nextText();
        } else if ("userInfo".equals(str)) {
            this.f18506u = new UserInfo();
            this.f18494i = true;
        } else if (this.f18494i) {
            UserInfo.getUserInfoIntag(xmlPullParser, this.f18506u, str);
        } else if ("userLoginInfo".equals(str)) {
            this.f18507v = new UserLoginInfo();
            this.f18495j = true;
        } else if (this.f18495j) {
            UserLoginInfo.getUserLoginInfoInTag(xmlPullParser, this.f18507v, str);
        } else if (DeviceInfo.TAG_DEVICE_INFO_LIST.equals(str)) {
            this.f18508w = new ArrayList();
            this.f18496k = true;
        } else if ("DeviceInfo".equals(str)) {
            this.f18500o = new DeviceInfo();
        } else if (this.f18496k) {
            DeviceInfo.getDeviceInfoInTag(xmlPullParser, this.f18500o, str);
        } else if (UserAccountInfo.TAG_USERACCTINFO_LIST.equals(str)) {
            this.f18509x = new ArrayList();
            this.f18497l = true;
        } else {
            m24721b(str, xmlPullParser);
        }
    }

    private void m24721b(String str, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (UserAccountInfo.TAG_USERACCINFO.equals(str)) {
            this.f18501p = new UserAccountInfo();
        } else if (this.f18497l) {
            UserAccountInfo.getUserAccInfoInTag(xmlPullParser, this.f18501p, str);
        } else if (UserAccountInfo.TAG_MEMBERRIGHTLIST.equals(str)) {
            this.f18510y = new ArrayList();
            this.f18498m = true;
        } else if (UserAccountInfo.TAG_MEMBERRIGHT.equals(str)) {
            this.f18502q = new TmemberRight();
        } else if (this.f18498m) {
            TmemberRight.m25187a(xmlPullParser, this.f18502q, str);
        } else if (ChildrenInfo.TAG_CHILDREN_INFO_LIST.equals(str)) {
            this.f18511z = new ArrayList();
            this.f18499n = true;
        } else {
            ChildrenInfo childrenInfo = this.f18503r;
            if (ChildrenInfo.TAG_CHILDREN_INFO.equals(str)) {
                this.f18503r = new ChildrenInfo();
            } else if (this.f18499n) {
                ChildrenInfo.m25078a(xmlPullParser, this.f18503r, str);
            }
        }
    }

    private void m24722c(String str, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if ("userInfo".equals(str)) {
            this.f18494i = false;
        } else if ("userLoginInfo".equals(str)) {
            this.f18495j = false;
        } else if (DeviceInfo.TAG_DEVICE_INFO_LIST.equals(str)) {
            this.f18496k = false;
        } else if ("DeviceInfo".equals(str)) {
            this.f18508w.add(this.f18500o);
        } else if (UserAccountInfo.TAG_USERACCINFO.equals(str)) {
            this.f18509x.add(this.f18501p);
        } else if (UserAccountInfo.TAG_USERACCTINFO_LIST.equals(str)) {
            this.f18497l = false;
        } else if (UserAccountInfo.TAG_MEMBERRIGHT.equals(str)) {
            this.f18510y.add(this.f18502q);
        } else if (UserAccountInfo.TAG_MEMBERRIGHTLIST.equals(str)) {
            this.f18498m = false;
        } else if (ChildrenInfo.TAG_CHILDREN_INFO.equals(str)) {
            this.f18511z.add(this.f18503r);
        } else if ("result".equals(str)) {
            m24719G();
        }
    }

    private void m24719G() {
        if (this.f18509x != null) {
            for (int i = 0; i < this.f18509x.size(); i++) {
                UserAccountInfo userAccountInfo = (UserAccountInfo) this.f18509x.get(i);
                if (userAccountInfo != null && "5".equals(userAccountInfo.getAccountType())) {
                    this.f18489B = userAccountInfo.getAccountState();
                    this.f18490C = userAccountInfo.getUserAccount();
                } else if (userAccountInfo != null && "6".equals(userAccountInfo.getAccountType())) {
                    this.f18492E = userAccountInfo.getAccountState();
                    this.f18491D = userAccountInfo.getUserAccount();
                }
            }
        }
    }

    protected void mo4628a(String str) throws XmlPullParserException, IOException {
        XmlPullParser a = C5184o.m25070a(str.getBytes(GameManager.DEFAULT_CHARSET));
        this.f18493h = a.getEventType();
        this.f18494i = false;
        this.f18495j = false;
        this.f18496k = false;
        this.f18497l = false;
        this.f18498m = false;
        this.f18499n = false;
        this.f18500o = null;
        this.f18501p = null;
        this.f18502q = null;
        this.f18503r = null;
        while (1 != this.f18493h) {
            String name = a.getName();
            switch (this.f18493h) {
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
                    m24720a(name, a);
                    break;
                case 3:
                    m24722c(name, a);
                    break;
                default:
                    break;
            }
            this.f18493h = a.next();
        }
    }

    public String mo4630g() {
        return this.f18488A;
    }

    public void m24733g(String str) {
        this.f18504s = str;
    }

    public void m24735h(String str) {
        this.f18505t = str;
    }

    public UserInfo m24723A() {
        return this.f18506u;
    }

    public UserLoginInfo m24724B() {
        return this.f18507v;
    }

    public ArrayList<DeviceInfo> m24725C() {
        return this.f18508w;
    }

    public ArrayList<UserAccountInfo> m24726D() {
        return this.f18509x;
    }

    public ArrayList<TmemberRight> m24727E() {
        return this.f18510y;
    }

    public ArrayList<ChildrenInfo> m24728F() {
        return this.f18511z;
    }

    public Bundle mo4631h() {
        Bundle h = super.mo4631h();
        h.putParcelableArrayList("accountsInfo", m24726D());
        h.putParcelableArrayList("devicesInfo", m24725C());
        h.putParcelableArrayList(HwAccountConstants.EXTRA_MEMBERRIGHTS, m24727E());
        h.putParcelableArrayList("childrenInfo", m24728F());
        h.putParcelable("userInfo", m24723A());
        h.putParcelable("userLoginInfo", m24724B());
        return h;
    }

    public C5126a(Context context, String str, String str2, Bundle bundle) {
        m24689b(true);
        m24733g(str);
        m24735h(str2);
        m24685a(true);
    }

    public void mo4627a(Context context, C5125a c5125a, String str, CloudRequestHandler cloudRequestHandler) {
        C5141d.m24813a(context, c5125a, str, m24677a(context, c5125a, new C5124a(context, cloudRequestHandler)));
    }
}
