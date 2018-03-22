package com.huawei.hwid.vermanager;

import android.content.Context;
import com.huawei.hwid.core.p430b.p433b.C5145b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public final class VersionManager extends C5310d {
    private static VersionManager f19020B;
    private HttpClient f19021C;

    public static synchronized VersionManager m25682e() {
        VersionManager versionManager;
        synchronized (VersionManager.class) {
            if (f19020B == null) {
                f19020B = new VersionManager();
            }
            versionManager = f19020B;
        }
        return versionManager;
    }

    private VersionManager() {
        m25683f();
    }

    private void m25683f() {
        this.a = "http://setting{0}.hicloud.com:8080/AccountServer";
        this.b = "https://setting{0}.hicloud.com:443/AccountServer";
        this.c = this.b + "/IUserInfoMng/updateHeadPic?Version=" + "12000";
        this.d = "https://setting.hicloud.com/AccountServer/globalSiteCountryList.xml?Version=12000";
        this.j = "https://hwid{0}.vmall.com:443/CAS/mobile/delUser.html?";
        this.k = "https://login.vmall.com/oauth2/authorize";
        this.l = "https://api.vmall.com/rest.php";
        this.m = "https://login.vmall.com/oauth2/oob#";
        this.o = "https://login.vmall.com/oauth2/v2/";
        this.n = "https://login.vmall.com/oauth2/v2/authorize";
        this.p = "https://login.vmall.com/connect/v2/logout";
        this.q = "http://oobe.vmall.com/";
        this.r = "https://hwid1.vmall.com/oauth2/portal/stHideLogin.jsp";
        this.s = "https://hwid1.vmall.com/oauth2/web/wapBindPhoneNumber.jsp";
        this.t = "https://hwid1.vmall.com/oauth2/mobile/login.jsp";
        this.u = "wapBindPhoneNumberTip.jsp?";
        this.w = "https://query.hicloud.com/hwid/v2/";
        this.v = "209207";
        this.A = "https://hwid{0}.vmall.com";
        this.y = "/CAS/mobile/standard/wapLogin.html";
        this.z = "/CAS/portal/userCenter/index.html";
        this.x = "/CAS/mobile/stLogin.html";
    }

    public String mo4680a() {
        return this.a;
    }

    public String mo4683b() {
        return this.b;
    }

    public String mo4685c() {
        return this.c;
    }

    public String mo4687d() {
        return this.k;
    }

    public HttpClient mo4682a(Context context, int i, int i2) {
        C5165e.m24906b("ReleaseVersionManager", "getSafeHttpClient");
        this.f19021C = new DefaultHttpClient(C5145b.m24820a(context), null);
        return this.f19021C;
    }

    public String mo4681a(int i) {
        return m25675a(i, this.A) + this.x;
    }

    public String mo4684b(int i) {
        return m25675a(i, this.A) + this.y;
    }

    public String mo4686c(int i) {
        return m25675a(i, this.A) + this.z;
    }
}
