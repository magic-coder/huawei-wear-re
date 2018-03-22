package cn.com.xy.sms.sdk.p220j.p224d;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p229l.C3038c;
import java.util.List;

final class C3028d implements C2904g {
    private final /* synthetic */ String f10230a;
    private final /* synthetic */ List f10231b;
    private final /* synthetic */ String f10232c;
    private final /* synthetic */ String f10233d;
    private final /* synthetic */ String f10234e;
    private final /* synthetic */ C2904g f10235f;
    private final /* synthetic */ boolean f10236g;

    C3028d(String str, List list, String str2, String str3, String str4, C2904g c2904g, boolean z) {
        this.f10230a = str;
        this.f10231b = list;
        this.f10232c = str2;
        this.f10233d = str3;
        this.f10234e = str4;
        this.f10235f = c2904g;
        this.f10236g = z;
    }

    public final void execute(Object... objArr) {
        C3038c.m13593b(this.f10230a, "cn.com.xy.sms.sdk.service.pubInfo.PubInfoNetService", "queryPubInfoByList", this.f10231b, this.f10232c, this.f10233d, this.f10234e, this.f10235f, Boolean.valueOf(this.f10236g), objArr);
        List list = this.f10231b;
        String str = this.f10232c;
        C3026b.m13561a(list, false, null, this.f10233d, this.f10235f, 2, objArr);
    }
}
