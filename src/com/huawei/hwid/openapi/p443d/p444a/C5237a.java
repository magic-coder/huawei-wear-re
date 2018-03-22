package com.huawei.hwid.openapi.p443d.p444a;

import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwid.openapi.p443d.C5236a;
import com.huawei.hwid.openapi.p443d.C5238b;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;
import com.huawei.hwid.openapi.p445e.p447b.C5245a;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

public class C5237a extends C5236a {
    private String f18868b = "https://api.vmall.com/rest.php";
    private String f18869c = "001110";
    private String f18870d = "OpenUP.User.getInfo";
    private String f18871e;
    private int f18872f = -1;

    public C5237a(String str) {
        this.f18871e = str;
    }

    public C5237a(String str, int i) {
        this.f18871e = str;
        this.f18872f = i;
    }

    public HttpEntity mo4648a() {
        HashMap hashMap = new HashMap();
        hashMap.put("queryRangeFlag", this.f18869c);
        hashMap.put("nsp_svc", this.f18870d);
        hashMap.put("nsp_ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put("access_token", this.f18871e);
        if (-1 != this.f18872f) {
            hashMap.put(CloudAccount.KEY_REQCLIENTTYPE, String.valueOf(this.f18872f));
        }
        C5248c.m25445a(a, "GetUserInfoReq params " + C5243e.m25425a((Map) hashMap));
        return C5245a.m25431a(hashMap);
    }

    public String mo4649b() {
        return this.f18868b;
    }

    public C5238b mo4650c() {
        return C5238b.JSONType;
    }
}
