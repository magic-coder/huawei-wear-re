package cn.com.xy.sms.sdk.p220j.p222b;

import cn.com.xy.sms.p204a.C2905f;
import cn.com.xy.sms.sdk.p208d.p211c.C2957x;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.HashMap;
import org.json.JSONObject;

final class C3022c implements C2905f {
    private final /* synthetic */ String f10205a;
    private final /* synthetic */ HashMap f10206b;
    private final /* synthetic */ String f10207c;
    private final /* synthetic */ C2905f f10208d;
    private final /* synthetic */ String f10209e;
    private final /* synthetic */ String f10210f;

    C3022c(String str, HashMap hashMap, String str2, C2905f c2905f, String str3, String str4) {
        this.f10205a = str;
        this.f10206b = hashMap;
        this.f10207c = str2;
        this.f10208d = c2905f;
        this.f10209e = str3;
        this.f10210f = str4;
    }

    public final void execute(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            C3050o.m13670a(this.f10208d, Integer.valueOf(-10), "no result");
            return;
        }
        String obj = objArr[0].toString();
        if (obj.equals("1")) {
            C2996a.m13485a("opanalysis", this.f10205a, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME, C3020a.m13552b(this.f10206b), false, true, this.f10206b, this.f10207c, this, this.f10208d);
        } else if (obj.equals("2") || obj.equals("3")) {
            C3050o.m13670a(this.f10208d, Integer.valueOf(-10), "server error");
        } else if (obj.equals("0") && objArr.length == 2) {
            obj = objArr[1].toString();
            C2957x.m13305a(this.f10209e, this.f10210f, obj);
            try {
                JSONObject jSONObject = new JSONObject(obj);
                C3050o.m13670a(this.f10208d, "0", jSONObject);
            } catch (Throwable th) {
                C3050o.m13670a(this.f10208d, Integer.valueOf(-10), "response content error");
            }
        } else {
            C3050o.m13670a(this.f10208d, Integer.valueOf(-10), "response code wrong, code=" + obj);
        }
    }
}
