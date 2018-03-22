package cn.com.xy.sms.sdk.p220j.p224d;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f;
import cn.com.xy.sms.sdk.p229l.C3038c;
import cn.com.xy.sms.sdk.p229l.C3045j;
import org.json.JSONObject;

final class C3027c implements C2904g {
    private final /* synthetic */ String f10218a;
    private final /* synthetic */ boolean f10219b;
    private final /* synthetic */ String f10220c;
    private final /* synthetic */ String f10221d;
    private final /* synthetic */ String f10222e;
    private final /* synthetic */ String f10223f;
    private final /* synthetic */ String f10224g;
    private final /* synthetic */ C2904g f10225h;
    private final /* synthetic */ int f10226i;
    private final /* synthetic */ boolean f10227j;
    private final /* synthetic */ boolean f10228k;
    private final /* synthetic */ boolean f10229l;

    C3027c(String str, boolean z, String str2, String str3, String str4, String str5, String str6, C2904g c2904g, int i, boolean z2, boolean z3, boolean z4) {
        this.f10218a = str;
        this.f10219b = z;
        this.f10220c = str2;
        this.f10221d = str3;
        this.f10222e = str4;
        this.f10223f = str5;
        this.f10224g = str6;
        this.f10225h = c2904g;
        this.f10226i = i;
        this.f10227j = z2;
        this.f10228k = z3;
        this.f10229l = z4;
    }

    public final void execute(Object... objArr) {
        C3038c.m13592a(this.f10218a, "cn.com.xy.sms.sdk.service.pubInfo.PubInfoNetService", "queryPubInfoRequest", Boolean.valueOf(this.f10219b), this.f10220c, this.f10221d, this.f10222e, this.f10223f, this.f10224g, this.f10225h, Integer.valueOf(this.f10226i), Boolean.valueOf(this.f10227j), Boolean.valueOf(this.f10228k), Boolean.valueOf(this.f10229l), objArr);
        boolean z = this.f10219b;
        String str = this.f10220c;
        String str2 = this.f10221d;
        str2 = this.f10222e;
        if (C3026b.m13561a(null, z, str, this.f10223f, this.f10225h, this.f10226i, objArr) != null && this.f10226i == 0) {
            JSONObject a = C2928f.m13179a(this.f10220c, this.f10222e, Integer.valueOf(this.f10224g).intValue());
            if (this.f10225h != null) {
                String a2 = C3045j.m13622a(a, this.f10220c, this.f10222e);
                this.f10225h.execute(a2);
            }
        }
    }
}
