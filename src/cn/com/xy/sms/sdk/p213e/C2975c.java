package cn.com.xy.sms.sdk.p213e;

import android.content.Context;
import android.os.Process;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.Map;
import org.json.JSONObject;

final class C2975c implements Runnable {
    private final /* synthetic */ Context f10074a;
    private final /* synthetic */ String f10075b;
    private final /* synthetic */ String f10076c;
    private final /* synthetic */ String f10077d;
    private final /* synthetic */ String f10078e;
    private final /* synthetic */ long f10079f;
    private final /* synthetic */ Map f10080g;
    private final /* synthetic */ JSONObject f10081h;

    C2975c(Context context, String str, String str2, String str3, String str4, long j, Map map, JSONObject jSONObject) {
        this.f10074a = context;
        this.f10075b = str;
        this.f10076c = str2;
        this.f10077d = str3;
        this.f10078e = str4;
        this.f10079f = j;
        this.f10080g = map;
        this.f10081h = jSONObject;
    }

    public final void run() {
        try {
            Process.setThreadPriority(19);
            Class b = C2973a.m13370b(null, "cn.com.xy.sms.sdk.Iservice.ParseUtilConversation");
            if (b != null) {
                b.getMethod("handleParseMsg", new Class[]{Context.class, String.class, String.class, String.class, String.class, Long.TYPE, Map.class, JSONObject.class}).invoke(b, new Object[]{this.f10074a, this.f10075b, this.f10076c, this.f10077d, this.f10078e, Long.valueOf(this.f10079f), this.f10080g, this.f10081h});
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "handleParseMsg: " + th.getMessage(), th);
        }
    }
}
