package cn.com.xy.sms.sdk.p218i;

import android.os.Process;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.p211c.ad;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p218i.p219a.C3007a;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import cn.com.xy.sms.sdk.p229l.C3055t;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C3011d extends Thread {
    private static boolean f10171a = false;

    public static synchronized void m13535a() {
        synchronized (C3011d.class) {
            if (!f10171a && C2996a.m13492a(2)) {
                new C3011d().start();
            }
        }
    }

    private static void m13536a(int i) {
        String name;
        try {
            List a = C3007a.m13528a(new StringBuilder("1").toString());
            if (a != null && !a.isEmpty()) {
                Iterator it = a.iterator();
                while (it != null && it.hasNext()) {
                    File file = (File) it.next();
                    name = file.getName();
                    C3050o.m13671a(file, C2917a.m13107a("duoqu_publiclogo"));
                    file.delete();
                    ad.m13230a(true, name);
                }
            }
        } catch (Exception e) {
            ad.m13230a(false, name);
        } catch (Throwable th) {
        }
    }

    private static void m13537a(String str, int i) {
        try {
            C2904g c3012e = new C3012e(i);
            if (!C3049n.m13653e(str) && C2996a.m13492a(2)) {
                String a = C2991i.m13445a(str, i);
                if (!C3049n.m13653e(a)) {
                    C2996a.m13488a(a, "990005", c3012e, "", true, false, "checkResourseRequest", true);
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "requestResourseQueue: " + th.getMessage(), th);
        }
    }

    public final void run() {
        try {
            setName("xiaoyuan_resoursequeue");
            Process.setThreadPriority(C3013f.f10174b);
            if (!f10171a) {
                f10171a = true;
                try {
                    Thread.sleep(1000);
                    if (C2996a.m13492a(2) && C3007a.m13530a(1)) {
                        String b = ad.m13231b(1);
                        if (C3049n.m13653e(b)) {
                            b = "-1";
                        }
                        C3011d.m13537a(b, 1);
                    }
                    Thread.sleep(1000);
                    if (C2996a.m13492a(2)) {
                        JSONArray a = ad.m13227a(1);
                        new StringBuilder("JsonArray=").append(a);
                        if (a != null && a.length() > 0) {
                            int length = a.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject = a.getJSONObject(i);
                                String str = (String) C3045j.m13620a(jSONObject, "res_url");
                                Integer num = (Integer) C3045j.m13620a(jSONObject, "res_version");
                                Long l = (Long) C3045j.m13620a(jSONObject, "down_failed_time");
                                Integer num2 = (Integer) C3045j.m13620a(jSONObject, "id");
                                new StringBuilder(" res_url=").append(str).append(" res_version=").append(num).append(" down_failed_time=").append(l).append("id = ").append(num2);
                                if (!C3049n.m13653e(str)) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    String str2 = "1" + HwAccountConstants.SPLIIT_UNDERLINE + num + HwAccountConstants.SPLIIT_UNDERLINE + currentTimeMillis + LightCloudConstants.ZIP_POSTFIX;
                                    if (currentTimeMillis <= l.longValue() + C2973a.m13350a(17, 3600000)) {
                                        break;
                                    }
                                    int f;
                                    try {
                                        f = C3055t.m13715f(str, C2917a.m13107a("duoqu_temp"), str2);
                                    } catch (Throwable th) {
                                        C2982a.m13415a("XIAOYUAN", "downloadResourse: " + th.getMessage(), th);
                                    }
                                    if (f != 0) {
                                        ad.m13228a(num2, false, str2);
                                        break;
                                    }
                                    ad.m13228a(num2, true, str2);
                                }
                            }
                        }
                    }
                    Thread.sleep(1000);
                    C3011d.m13536a(1);
                } catch (Throwable th2) {
                }
                f10171a = false;
            }
        } catch (Throwable th3) {
            C2982a.m13415a("XIAOYUAN", "run: " + th3.getMessage(), th3);
        }
    }
}
