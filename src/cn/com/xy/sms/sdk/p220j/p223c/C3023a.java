package cn.com.xy.sms.sdk.p220j.p223c;

import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2972o;
import cn.com.xy.sms.sdk.p208d.p211c.C2942i;
import cn.com.xy.sms.sdk.p208d.p211c.C2943j;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C3023a {
    private static String f10211a = WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD;

    private static long m13555a(int i, long j) {
        return System.currentTimeMillis() - C2973a.m13350a(i, (long) LightCloudConstants.LightCloud_INTERVAL_TIME);
    }

    private static String m13556a(int i) {
        JSONObject a = C3041f.m13609b().m13095a(i);
        if (a == null) {
            try {
                C2942i a2 = C2943j.m13258a(C2917a.m13105a());
                if (a2 != null) {
                    return a2.f9987i;
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "getCardAreaCode: " + th.getMessage(), th);
            }
        } else {
            String a3 = C2943j.m13261a((String) C3045j.m13620a(a, "provice"));
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    private static void m13557a() {
        int i = 0;
        try {
            long a = C3023a.m13555a(31, (long) LightCloudConstants.LightCloud_INTERVAL_TIME);
            JSONArray a2 = C2972o.m13346a(a, f10211a, true);
            int i2 = 0;
            while (!C3049n.m13653e(a2.toString()) && a2.length() != 0) {
                C3023a.m13559a(a2);
                a2 = C2972o.m13346a(a, f10211a, true);
                i2++;
                if (i2 > 1000) {
                    break;
                }
                Thread.sleep(1);
            }
            C2972o.m13347a(true);
            long a3 = C3023a.m13555a(30, (long) LightCloudConstants.LightCloud_INTERVAL_TIME);
            JSONArray a4 = C2972o.m13346a(a3, f10211a, false);
            while (!C3049n.m13653e(a4.toString()) && a4.length() != 0) {
                C3023a.m13559a(a4);
                a4 = C2972o.m13346a(a3, f10211a, false);
                i++;
                if (i > 1000) {
                    break;
                }
                Thread.sleep(1);
            }
            C2972o.m13347a(true);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "batchUpdatePubId: " + th.getMessage(), th);
        }
    }

    public static void m13558a(String str, String str2) {
        C2982a.m13414a("xiaoyuan", "phoneNum: " + str + " dbresoult: " + str2);
        if ("true".equalsIgnoreCase(str2)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("pubId", "");
                hashMap.put("phone", str);
                hashMap.put("querytime", "0");
                hashMap.put("queryflag", "0");
                C2972o.m13348a(hashMap);
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", "queryPubIdFromNet: " + e.getMessage(), e);
            }
        }
        if (C2996a.m13491a() && C2996a.m13492a(1)) {
            C2978a.m13408b(true);
            C3023a.m13557a();
        }
    }

    private static void m13559a(JSONArray jSONArray) {
        if (jSONArray.length() != 0) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer2 = stringBuffer2.append(C3023a.m13556a(0));
                stringBuffer3 = stringBuffer3.append(C3023a.m13556a(1));
                if (C3049n.m13653e(stringBuffer2.toString()) && C3049n.m13653e(stringBuffer3.toString())) {
                    stringBuffer.append(PayManagerSettingSwitchDialog.COUNTRY_CODE_CN);
                } else if (C3049n.m13653e(stringBuffer2.toString()) && !C3049n.m13653e(stringBuffer3.toString())) {
                    stringBuffer.append(stringBuffer3.toString());
                } else if (!C3049n.m13653e(stringBuffer3.toString()) || C3049n.m13653e(stringBuffer2.toString())) {
                    stringBuffer.append(stringBuffer2.toString()).append(",").append(stringBuffer3.toString());
                } else {
                    stringBuffer.append(stringBuffer2.toString());
                }
                if (C2996a.m13500c(null)) {
                    String a = C2991i.m13447a(stringBuffer.toString(), (Object) jSONArray);
                    if (!C3049n.m13653e(a)) {
                        C2996a.m13490a("pubnumber", a, new C3024b(), false, false, true, null);
                        return;
                    }
                    return;
                }
                C2982a.m13414a("xiaoyuan", "queryPubIdByNet not hasNewToken");
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", "checkValidUrlNet: " + e.getMessage(), e);
            }
        }
    }
}
