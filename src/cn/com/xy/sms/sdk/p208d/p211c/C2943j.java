package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import android.content.Context;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.snowballtech.apdu.constant.Constant;
import com.unionpay.tsmservice.data.ResultCode;

public class C2943j {
    public static long m13257a(String str, boolean z, String str2, String str3, String str4, String str5, Context context) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("iccid", str);
            if (!C3049n.m13653e(str2) && str2.indexOf(";") == -1) {
                if (!C3049n.m13653e(str2)) {
                    contentValues.put("provinces", str2.trim());
                    contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
                }
                if (C3049n.m13653e(str3)) {
                    contentValues.put("areacode", C2943j.m13261a(str2));
                } else {
                    contentValues.put("areacode", str3.trim());
                }
                if (!C3049n.m13653e(str4)) {
                    contentValues.put("city", str4.trim());
                }
                if (!C3049n.m13653e(str5)) {
                    contentValues.put("operator", str5);
                }
            } else if (!C3049n.m13653e(str2)) {
                String[] split = str2.split(";");
                if (split.length > 0) {
                    contentValues.put("provinces", split[0]);
                    contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("areacode", C2943j.m13261a(split[0]));
                }
                if (split.length >= 2) {
                    contentValues.put("city", split[1]);
                }
            }
            if (z) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("deft", Integer.valueOf(0));
                C2922b.m13133a("tb_phone_info", contentValues2, null, null);
            }
            contentValues.put("deft", Integer.valueOf(z ? 1 : 0));
            long a = (long) C2922b.m13133a("tb_phone_info", contentValues, "iccid = ?", new String[]{str});
            if (a < 1) {
                contentValues.put("sim_index", Integer.valueOf(-1));
                a = C2922b.m13135a("tb_phone_info", contentValues);
                C2978a.m13398a(str, contentValues.getAsString("areacode"), str5, null, null, -1, 0);
                return a;
            }
            C2942i a2 = C2943j.m13260a(str, C2917a.m13105a());
            if (a2 == null) {
                return a;
            }
            C2978a.m13398a(str, a2.f9987i, a2.f9988j, a2.f9992n, a2.f9993o, a2.f9994p, a2.f9990l);
            return a;
        } catch (Throwable th) {
            Throwable th2 = th;
            long j = -1;
            C2982a.m13415a("XIAOYUAN", "insertIccid: " + th2.getMessage(), th2);
            return j;
        }
    }

    public static C2942i m13258a(Context context) {
        return C2943j.m13260a(null, context);
    }

    public static C2942i m13259a(String str, int i) {
        C2962e a;
        C2942i c2942i;
        Throwable th;
        Throwable th2;
        try {
            r0 = !C3049n.m13653e(str) ? "iccid='" + str + "'" : i >= 0 ? "(iccid IS NULL OR iccid='' ) AND sim_index='" + i + "'" : "deft=1";
            a = C2922b.m13139a("tb_phone_info", new String[]{"id", "city", "provinces", "updateTime", "operator", "ispost", Constants.FIELD_APPLET_CONFIG_NUM, "cnum", "net_updateTime", "areacode", "iccid", "deft", "user_provinces", "user_areacode", "user_operator", "sim_index"}, r0, null);
            if (a != null) {
                try {
                    if (a.m13327b()) {
                        c2942i = new C2942i();
                        try {
                            c2942i.f9979a = a.m13324a(a.m13325a("id"));
                            c2942i.f9981c = a.m13328c(a.m13325a("city"));
                            c2942i.f9988j = a.m13328c(a.m13325a("operator"));
                            c2942i.f9987i = a.m13328c(a.m13325a("areacode"));
                            c2942i.f9982d = a.m13328c(a.m13325a("provinces"));
                            c2942i.f9989k = a.m13326b(a.m13325a("updateTime"));
                            c2942i.f9980b = a.m13328c(a.m13325a("iccid"));
                            c2942i.f9985g = a.m13324a(a.m13325a("ispost"));
                            c2942i.f9984f = a.m13328c(a.m13325a(Constants.FIELD_APPLET_CONFIG_NUM));
                            c2942i.f9983e = a.m13328c(a.m13325a("cnum"));
                            c2942i.f9986h = a.m13326b(a.m13325a("net_updateTime"));
                            c2942i.f9990l = a.m13324a(a.m13325a("deft"));
                            c2942i.f9991m = a.m13328c(a.m13325a("user_provinces"));
                            c2942i.f9992n = a.m13328c(a.m13325a("user_areacode"));
                            c2942i.f9993o = a.m13328c(a.m13325a("user_operator"));
                            c2942i.f9994p = a.m13324a(a.m13325a("sim_index"));
                            C2962e.m13322a(a, true);
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                C2982a.m13415a("XIAOYUAN", "queryIccidInfo: " + th.getMessage(), th);
                                C2962e.m13322a(a, true);
                                return c2942i;
                            } catch (Throwable th4) {
                                th2 = th4;
                                C2962e.m13322a(a, true);
                                throw th2;
                            }
                        }
                        return c2942i;
                    }
                } catch (Throwable th22) {
                    Throwable th5 = th22;
                    c2942i = null;
                    th = th5;
                    C2982a.m13415a("XIAOYUAN", "queryIccidInfo: " + th.getMessage(), th);
                    C2962e.m13322a(a, true);
                    return c2942i;
                }
            }
            c2942i = null;
            C2962e.m13322a(a, true);
        } catch (Throwable th6) {
            th22 = th6;
            a = null;
            C2962e.m13322a(a, true);
            throw th22;
        }
        return c2942i;
    }

    public static C2942i m13260a(String str, Context context) {
        return C2943j.m13259a(str, -1);
    }

    public static String m13261a(String str) {
        r4 = new String[34][];
        r4[0] = new String[]{"北京", "BJ"};
        r4[1] = new String[]{"上海", "SH"};
        r4[2] = new String[]{"天津", "TJ"};
        r4[3] = new String[]{"重庆", "CQ"};
        r4[4] = new String[]{"黑龙江", "HL"};
        r4[5] = new String[]{"吉林", "JL"};
        r4[6] = new String[]{"辽宁", "LN"};
        r4[7] = new String[]{"新疆", "XJ"};
        r4[8] = new String[]{"西藏", "XZ"};
        r4[9] = new String[]{"内蒙古", "NM"};
        r4[10] = new String[]{"甘肃", "GS"};
        r4[11] = new String[]{"青海", "QH"};
        r4[12] = new String[]{"陕西", "XA"};
        r4[13] = new String[]{"宁夏", "NX"};
        r4[14] = new String[]{"山西", "SX"};
        r4[15] = new String[]{"山东", Constant._SD_TERMINAL};
        r4[16] = new String[]{"安徽", "AW"};
        r4[17] = new String[]{"河南", "HN"};
        r4[18] = new String[]{"河北", "HB"};
        r4[19] = new String[]{"浙江", "ZJ"};
        r4[20] = new String[]{"江苏", "JS"};
        r4[21] = new String[]{"湖南", "CS"};
        r4[22] = new String[]{"湖北", "WH"};
        r4[23] = new String[]{"贵州", "GZ"};
        r4[24] = new String[]{"四川", "SC"};
        r4[25] = new String[]{"江西", "JX"};
        r4[26] = new String[]{"云南", "YN"};
        r4[27] = new String[]{"广东", "GD"};
        r4[28] = new String[]{"广西", "GX"};
        r4[29] = new String[]{"福建", "FJ"};
        r4[30] = new String[]{"海南", "HK"};
        r4[31] = new String[]{"香港", "XG"};
        r4[32] = new String[]{"澳门", "OM"};
        r4[33] = new String[]{"台湾", "TW"};
        for (int i = 0; i < 34; i++) {
            String str2 = r4[i][0];
            int i2 = (str == null || str2 == null || str.indexOf(str2) == -1) ? 0 : 1;
            if (i2 != 0) {
                return r4[i][1];
            }
        }
        return null;
    }

    public static void m13262a(String str, String str2, String str3, Context context) {
        try {
            if (!C3049n.m13653e(str) && !C3049n.m13653e(str2) && !C3049n.m13653e(str3)) {
                if (str3.equals("10086") || str3.equals(ResultCode.ERROR_INTERFACE_GET_APP_DETAIL) || str3.equals("10000")) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.FIELD_APPLET_CONFIG_NUM, str3);
                    contentValues.put("cnum", str2);
                    C2922b.m13133a("tb_phone_info", contentValues, "iccid = ? and ispost = 0", new String[]{str});
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "updateIccidCnum: " + th.getMessage(), th);
        }
    }
}
