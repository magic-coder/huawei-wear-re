package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class C2955v {
    public static long m13298a(String str, String str2, int i) {
        try {
            ContentValues a = C2921a.m13130a(null, "area_code", str2, Oauth2AccessToken.KEY_PHONE_NUM, str, "request_time", String.valueOf(System.currentTimeMillis()), "status", String.valueOf(i));
            return C2922b.m13133a("tb_netquery_time", a, "phone_num = ? and area_code = ?", new String[]{str, str2}) <= 0 ? C2922b.m13135a("tb_netquery_time", a) : 0;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "insertOrUpdateNetQueryTime: " + th.getMessage(), th);
            return -1;
        }
    }

    public static List<String> m13299a(String str, long j, int i) {
        C2962e a;
        Throwable th;
        try {
            List arrayList = new ArrayList();
            arrayList.add(String.valueOf(j));
            String str2 = "SELECT DISTINCT tbA.phone_num,tbB.name,tbB.cmd,tbB.ec,tbB.mark_time,tbB.mark_cmd,tbB.mark_ec FROM tb_netquery_time tbA LEFT JOIN tb_num_name tbB ON tbB.num=tbA.phone_num WHERE tbA.request_time<? AND tbA.request_time>0" + " AND tbA.status=?";
            arrayList.add("0");
            if (!C3049n.m13653e(str)) {
                str2 = new StringBuilder(String.valueOf(str2)).append(" AND tbA.area_code=?").toString();
                arrayList.add(str);
            }
            a = C2922b.m13138a(str2, (String[]) arrayList.toArray(new String[arrayList.size()]));
            if (a == null) {
                C2962e.m13322a(a, true);
                return null;
            }
            try {
                List<String> arrayList2 = new ArrayList();
                while (a.m13327b()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Constants.FIELD_APPLET_CONFIG_NUM, a.m13328c(0));
                    jSONObject.put("version", "-1");
                    jSONObject.put("name", a.m13328c(a.m13325a("name")));
                    jSONObject.put("cmd", a.m13328c(a.m13325a("cmd")));
                    jSONObject.put("ec", a.m13328c(a.m13325a("ec")));
                    jSONObject.put("markTime", a.m13324a(a.m13325a("mark_time")));
                    jSONObject.put("markCmd", a.m13324a(a.m13325a("mark_cmd")));
                    jSONObject.put("markEC", a.m13324a(a.m13325a("mark_ec")));
                    arrayList2.add(jSONObject.toString());
                }
                C2962e.m13322a(a, true);
                return arrayList2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
    }

    public static boolean m13300a(String str, String str2) {
        try {
            if (C3050o.m13664a(C2917a.m13105a(), 2) == -1) {
                return false;
            }
            JSONObject b = C2955v.m13301b(str, str2);
            if (b != null) {
                if (System.currentTimeMillis() <= Long.parseLong(b.getString("request_time")) + C2973a.m13350a(1, 2592000000L)) {
                    return false;
                }
                C2955v.m13298a(str, str2, 0);
                return true;
            }
            C2955v.m13298a(str, str2, 0);
            return true;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "isAllowQuery: " + th.getMessage(), th);
            return true;
        }
    }

    private static JSONObject m13301b(String str, String str2) {
        Throwable th;
        C2962e c2962e;
        C2962e c2962e2 = null;
        try {
            String[] strArr = new String[]{"id", Oauth2AccessToken.KEY_PHONE_NUM, "request_time"};
            C2962e a = C2922b.m13140a("tb_netquery_time", strArr, "phone_num = ? and area_code = ?", new String[]{str, str2}, null, null, null, "1");
            try {
                JSONObject b = C2921a.m13132b(strArr, a);
                C2962e.m13322a(a, true);
                return b;
            } catch (Throwable th2) {
                th = th2;
                c2962e2 = a;
                C2962e.m13322a(c2962e2, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C2962e.m13322a(c2962e2, true);
            throw th;
        }
    }
}
