package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p208d.p211c.C2955v;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p229l.C3040e;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C2928f {
    public static int m13174a(String str, String str2) {
        try {
            if (C3049n.m13653e(str2)) {
                str2 = PayManagerSettingSwitchDialog.COUNTRY_CODE_CN;
            }
            int b = C2928f.m13184b(str, str2);
            return (b != -1 || PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equalsIgnoreCase(str2)) ? b : C2928f.m13184b(str, PayManagerSettingSwitchDialog.COUNTRY_CODE_CN);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoManager getNameType: " + th.getMessage(), th);
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashMap<java.lang.String, java.lang.String> m13175a(android.database.sqlite.SQLiteDatabase r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22) {
        /*
        r5 = 0;
        r4 = -1;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r3 = 0;
        r9 = 0;
        r2 = 0;
        r0 = r18;
        r1 = r20;
        r11 = r0.rawQuery(r1, r2);	 Catch:{ Throwable -> 0x01bd, all -> 0x01e6 }
        if (r11 == 0) goto L_0x021f;
    L_0x0012:
        r2 = r11.getCount();	 Catch:{ Throwable -> 0x01f7, all -> 0x01f2 }
        if (r2 <= 0) goto L_0x021f;
    L_0x0018:
        r2 = r11.moveToNext();	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        if (r2 != 0) goto L_0x006c;
    L_0x001e:
        r10 = r3;
        r2 = r4;
    L_0x0020:
        if (r2 <= 0) goto L_0x002b;
    L_0x0022:
        r3 = "CN;";
        r4 = r19;
        r5 = r22;
        cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f.m13180a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
    L_0x002b:
        cn.com.xy.sms.sdk.p208d.C2922b.m13142a(r11);
        r4 = r9;
        r3 = r7;
        r5 = r2;
        r2 = r6;
    L_0x0032:
        r6 = -1;
        if (r5 == r6) goto L_0x01ef;
    L_0x0035:
        r4 = new java.util.HashMap;
        r4.<init>();
        r6 = "pubId";
        r5 = java.lang.String.valueOf(r5);
        r4.put(r6, r5);
        r5 = "purpose";
        if (r2 != 0) goto L_0x0049;
    L_0x0047:
        r2 = "";
    L_0x0049:
        r4.put(r5, r2);
        r2 = "areaCode";
        r5 = "CN";
        r4.put(r2, r5);
        r5 = "extend";
        if (r3 != 0) goto L_0x01ec;
    L_0x0057:
        r2 = "";
    L_0x0059:
        r4.put(r5, r2);
        r2 = "nameType";
        r3 = java.lang.String.valueOf(r8);
        r4.put(r2, r3);
        r2 = "num";
        r4.put(r2, r10);
        r2 = r4;
    L_0x006b:
        return r2;
    L_0x006c:
        r2 = "minLen";
        r2 = r11.getColumnIndex(r2);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r2 = r11.getInt(r2);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r5 = "maxLen";
        r5 = r11.getColumnIndex(r5);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r5 = r11.getInt(r5);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r10 = "len";
        r10 = r11.getColumnIndex(r10);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r12 = r11.getInt(r10);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r10 = "ntype";
        r10 = r11.getColumnIndex(r10);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r13 = r11.getString(r10);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r10 = "num";
        r10 = r11.getColumnIndex(r10);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r10 = r11.getString(r10);	 Catch:{ Throwable -> 0x0210, all -> 0x01f2 }
        r3 = "areaCode";
        r3 = r11.getColumnIndex(r3);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r14 = r11.getString(r3);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = "*";
        r3 = r10.indexOf(r3);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        if (r3 < 0) goto L_0x0182;
    L_0x00b0:
        r15 = 0;
        r15 = r10.substring(r15, r3);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = r3 + 1;
        r3 = r10.substring(r3);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r0 = r19;
        r16 = r0.startsWith(r15);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        if (r16 == 0) goto L_0x00cb;
    L_0x00c3:
        r0 = r19;
        r16 = r0.endsWith(r3);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        if (r16 != 0) goto L_0x014a;
    L_0x00cb:
        r2 = 0;
    L_0x00cc:
        if (r2 == 0) goto L_0x021c;
    L_0x00ce:
        r0 = r21;
        r2 = r14.indexOf(r0);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = -1;
        if (r2 == r3) goto L_0x0188;
    L_0x00d7:
        r2 = "pubId";
        r2 = r11.getColumnIndex(r2);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r2 = r11.getInt(r2);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = "purpose";
        r3 = r11.getColumnIndex(r3);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r6 = r11.getString(r3);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r3 = "extend";
        r3 = r11.getColumnIndex(r3);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r7 = r11.getString(r3);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r3 = "nameType";
        r3 = r11.getColumnIndex(r3);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r8 = r11.getInt(r3);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r4 = java.lang.String.valueOf(r21);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r4 = ";";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r4 = r19;
        r5 = r22;
        cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f.m13180a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r3 = new java.util.HashMap;	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r3.<init>();	 Catch:{ Throwable -> 0x01fd, all -> 0x01f2 }
        r4 = "pubId";
        r5 = java.lang.String.valueOf(r2);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        r3.put(r4, r5);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        r4 = "purpose";
        r3.put(r4, r6);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        r4 = "areaCode";
        r3.put(r4, r14);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        r4 = "extend";
        r3.put(r4, r7);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        r4 = "nameType";
        r5 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        r3.put(r4, r5);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        r4 = "num";
        r3.put(r4, r10);	 Catch:{ Throwable -> 0x0204, all -> 0x01f2 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13142a(r11);
        r2 = r3;
        goto L_0x006b;
    L_0x014a:
        r15 = r15.length();	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = r3.length();	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = r3 + r15;
        r15 = r19.length();	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        if (r12 <= 0) goto L_0x0160;
    L_0x0159:
        r2 = r3 + r12;
        if (r2 == r15) goto L_0x0170;
    L_0x015d:
        r2 = 0;
        goto L_0x00cc;
    L_0x0160:
        if (r5 <= 0) goto L_0x0168;
    L_0x0162:
        r5 = r5 + r3;
        if (r15 <= r5) goto L_0x0168;
    L_0x0165:
        r2 = 0;
        goto L_0x00cc;
    L_0x0168:
        if (r2 <= 0) goto L_0x0170;
    L_0x016a:
        r2 = r2 + r3;
        if (r15 >= r2) goto L_0x0170;
    L_0x016d:
        r2 = 0;
        goto L_0x00cc;
    L_0x0170:
        r2 = "sj";
        r2 = r2.equals(r13);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        if (r2 == 0) goto L_0x0185;
    L_0x0179:
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13650d(r19);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        if (r2 != 0) goto L_0x0185;
    L_0x017f:
        r2 = 0;
        goto L_0x00cc;
    L_0x0182:
        r2 = 0;
        goto L_0x00cc;
    L_0x0185:
        r2 = 1;
        goto L_0x00cc;
    L_0x0188:
        r2 = "CN";
        r2 = r14.indexOf(r2);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = -1;
        if (r2 == r3) goto L_0x021c;
    L_0x0191:
        r2 = "pubId";
        r2 = r11.getColumnIndex(r2);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r3 = r11.getInt(r2);	 Catch:{ Throwable -> 0x0216, all -> 0x01f2 }
        r2 = "purpose";
        r2 = r11.getColumnIndex(r2);	 Catch:{ Throwable -> 0x020a, all -> 0x01f2 }
        r6 = r11.getString(r2);	 Catch:{ Throwable -> 0x020a, all -> 0x01f2 }
        r2 = "extend";
        r2 = r11.getColumnIndex(r2);	 Catch:{ Throwable -> 0x020a, all -> 0x01f2 }
        r7 = r11.getString(r2);	 Catch:{ Throwable -> 0x020a, all -> 0x01f2 }
        r2 = "nameType";
        r2 = r11.getColumnIndex(r2);	 Catch:{ Throwable -> 0x020a, all -> 0x01f2 }
        r8 = r11.getInt(r2);	 Catch:{ Throwable -> 0x020a, all -> 0x01f2 }
        r4 = r3;
        r3 = r10;
        goto L_0x0018;
    L_0x01bd:
        r2 = move-exception;
        r17 = r9;
        r9 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r17;
    L_0x01c5:
        r10 = "XIAOYUAN";
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01f4 }
        r12 = "PubInfoManager queryPubIdHasRuleNum: ";
        r11.<init>(r12);	 Catch:{ all -> 0x01f4 }
        r12 = r2.getMessage();	 Catch:{ all -> 0x01f4 }
        r11 = r11.append(r12);	 Catch:{ all -> 0x01f4 }
        r11 = r11.toString();	 Catch:{ all -> 0x01f4 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r10, r11, r2);	 Catch:{ all -> 0x01f4 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13142a(r9);
        r10 = r4;
        r2 = r6;
        r4 = r3;
        r3 = r7;
        goto L_0x0032;
    L_0x01e6:
        r2 = move-exception;
        r11 = r5;
    L_0x01e8:
        cn.com.xy.sms.sdk.p208d.C2922b.m13142a(r11);
        throw r2;
    L_0x01ec:
        r2 = r3;
        goto L_0x0059;
    L_0x01ef:
        r2 = r4;
        goto L_0x006b;
    L_0x01f2:
        r2 = move-exception;
        goto L_0x01e8;
    L_0x01f4:
        r2 = move-exception;
        r11 = r9;
        goto L_0x01e8;
    L_0x01f7:
        r2 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r9;
        r9 = r11;
        goto L_0x01c5;
    L_0x01fd:
        r3 = move-exception;
        r4 = r10;
        r5 = r2;
        r2 = r3;
        r3 = r9;
        r9 = r11;
        goto L_0x01c5;
    L_0x0204:
        r4 = move-exception;
        r5 = r2;
        r9 = r11;
        r2 = r4;
        r4 = r10;
        goto L_0x01c5;
    L_0x020a:
        r2 = move-exception;
        r4 = r10;
        r5 = r3;
        r3 = r9;
        r9 = r11;
        goto L_0x01c5;
    L_0x0210:
        r2 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r9;
        r9 = r11;
        goto L_0x01c5;
    L_0x0216:
        r2 = move-exception;
        r3 = r9;
        r5 = r4;
        r4 = r10;
        r9 = r11;
        goto L_0x01c5;
    L_0x021c:
        r3 = r10;
        goto L_0x0018;
    L_0x021f:
        r10 = r3;
        r2 = r4;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.a.f.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, int):java.util.HashMap<java.lang.String, java.lang.String>");
    }

    public static List<String> m13176a() {
        C2962e a;
        Throwable th;
        List<String> list = null;
        new StringBuilder("PubInfoManager getNumsAppearInMonth 更新=").append(C3040e.m13604a("yyyyMMdd hh:MM:ss", System.currentTimeMillis() - C2973a.m13350a(1, 2592000000L))).append("之前的数据");
        try {
            a = C2922b.m13138a("SELECT DISTINCT pni.num, pi.pubId, pi.versionCode, pni.nameType, nn.name, nn.cmd, nn.ec, nn.mark_time, nn.mark_cmd, nn.mark_ec FROM tb_public_num_info pni JOIN tb_public_info pi ON pi.pubId = pni.pubId LEFT JOIN tb_num_name nn ON nn.num = pni.num WHERE pni.isuse = 1 AND pni.pubId IN (SELECT pi.pubId FROM tb_public_num_info pni JOIN tb_public_info pi ON pi.pubId = pni.pubId AND pi.updateInfoTime < ? AND pni.isuse = 1 GROUP BY pi.pubId LIMIT 10)", new String[]{String.valueOf(System.currentTimeMillis() - C2973a.m13350a(1, 2592000000L))});
            try {
                list = C2928f.m13177a(a);
            } catch (Throwable th2) {
                th = th2;
                C2982a.m13415a("XIAOYUAN", "PubInfoManager getNumsAppearInMonth: " + th.getMessage(), th);
                C2962e.m13322a(a, true);
                return list;
            }
        } catch (Throwable th3) {
            th = th3;
            a = list;
            C2982a.m13415a("XIAOYUAN", "PubInfoManager getNumsAppearInMonth: " + th.getMessage(), th);
            C2962e.m13322a(a, true);
            return list;
        }
        C2962e.m13322a(a, true);
        return list;
    }

    private static List<String> m13177a(C2962e c2962e) {
        if (c2962e == null || c2962e.m13323a() == 0) {
            C2982a.m13414a("XIAOYUAN", "PubInfoManager needUpdateNumList: curResult is 0");
            return null;
        }
        try {
            List<String> arrayList = new ArrayList();
            while (c2962e.m13327b()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.FIELD_APPLET_CONFIG_NUM, c2962e.m13328c(c2962e.m13325a(Constants.FIELD_APPLET_CONFIG_NUM)));
                jSONObject.put("version", c2962e.m13328c(c2962e.m13325a("versionCode")));
                jSONObject.put("pubId", c2962e.m13328c(c2962e.m13325a("pubId")));
                jSONObject.put("name", c2962e.m13328c(c2962e.m13325a("name")));
                jSONObject.put("cmd", c2962e.m13328c(c2962e.m13325a("cmd")));
                jSONObject.put("ec", c2962e.m13328c(c2962e.m13325a("ec")));
                jSONObject.put("nameType", c2962e.m13324a(c2962e.m13325a("nameType")));
                jSONObject.put("markTime", c2962e.m13324a(c2962e.m13325a("mark_time")));
                jSONObject.put("markCmd", c2962e.m13324a(c2962e.m13325a("mark_cmd")));
                jSONObject.put("markEC", c2962e.m13324a(c2962e.m13325a("mark_ec")));
                arrayList.add(jSONObject.toString());
            }
            return arrayList;
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "PubInfoManager needUpdateNumList: " + e.getMessage(), e);
            return null;
        }
    }

    private static JSONObject m13178a(int i) {
        C2962e a;
        Throwable th;
        Throwable th2;
        JSONObject jSONObject = null;
        try {
            String[] strArr = new String[]{"id", "pubId", "pubName", "pubType", "classifyCode", "weiXin", "weiBoName", "weiBoUrl", "introduce", UserInfo.ADDRESS, "faxNum", "webSite", "versionCode", "email", "parentPubId", "slogan", "rectLogoName", "circleLogoName", "extend", "hasmenu", "loadMenuTime", "updateInfoTime", "moveWebSite", "corpLevel", "rid", "logoType"};
            a = C2922b.m13139a("tb_public_info", strArr, "pubId = ? ", new String[]{new StringBuilder(String.valueOf(i)).toString()});
            try {
                jSONObject = C2921a.m13132b(strArr, a);
                C2962e.m13322a(a, true);
            } catch (Throwable th3) {
                th = th3;
                try {
                    C2982a.m13415a("XIAOYUAN", "PubInfoManager queryPubInfoByPubId: " + th.getMessage(), th);
                    C2962e.m13322a(a, true);
                    return jSONObject;
                } catch (Throwable th4) {
                    th2 = th4;
                    C2962e.m13322a(a, true);
                    throw th2;
                }
            }
        } catch (Throwable th5) {
            a = jSONObject;
            th2 = th5;
            C2962e.m13322a(a, true);
            throw th2;
        }
        return jSONObject;
    }

    public static JSONObject m13179a(String str, String str2, int i) {
        Throwable th;
        JSONObject a;
        try {
            HashMap c = C2928f.m13191c(str, str2, i);
            if (c == null) {
                return null;
            }
            int intValue = Integer.valueOf((String) c.get("pubId")).intValue();
            if (intValue != -1) {
                a = C2928f.m13178a(intValue);
                if (a == null) {
                    return null;
                }
                try {
                    a.put("purpose", c.get("purpose"));
                    a.put("rid", c.get("rid"));
                    a.put("logoType", c.get("logoType"));
                    a.put("extend", c.get("extend"));
                    a.put("nameType", c.get("nameType"));
                    a.put(Constants.FIELD_APPLET_CONFIG_NUM, str);
                    if (!(C3049n.m13653e(a.optString("pubName")) || a == null)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("loadMenuTime", Long.valueOf(System.currentTimeMillis()));
                        C2922b.m13133a("tb_public_info", contentValues, "pubId = ?", new String[]{a.optString("pubId")});
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C2982a.m13415a("XIAOYUAN", "PubInfoManager queryPubInfoByNum: " + th.getMessage(), th);
                }
            } else {
                a = null;
            }
            return a;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            a = null;
            th = th4;
            C2982a.m13415a("XIAOYUAN", "PubInfoManager queryPubInfoByNum: " + th.getMessage(), th);
            return a;
        }
    }

    private static void m13180a(int i, String str, String str2, int i2, String str3, String str4, int i3) {
        C2996a.m13484a(new C2929g(i, str, str2, i2, str3, str4, i3));
    }

    public static void m13181a(String str) {
        try {
            if (!C3049n.m13653e(str)) {
                List arrayList = new ArrayList();
                arrayList.add(str);
                C2928f.m13182a(arrayList);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoManager sendRemovePubInfoCacheNotification(String num): " + th.getMessage(), th);
        }
    }

    public static void m13182a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Map hashMap = new HashMap();
                    hashMap.put("nums", list);
                    C3041f.m13609b().m13096a(10, hashMap);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "PubInfoManager sendRemovePubInfoCacheNotification(List<String> list): " + th.getMessage(), th);
            }
        }
    }

    public static void m13183a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("corpLevel");
            String[] strArr = new String[50];
            strArr[0] = "pubId";
            strArr[1] = jSONObject.optString("pubId");
            strArr[2] = "pubName";
            strArr[3] = jSONObject.optString("pubName");
            strArr[4] = "pubType";
            strArr[5] = jSONObject.optString("pubType");
            strArr[6] = "classifyCode";
            strArr[7] = jSONObject.optString("classifyCode");
            strArr[8] = "weiXin";
            strArr[9] = jSONObject.optString("weiXin");
            strArr[10] = "weiBoName";
            strArr[11] = jSONObject.optString("weiBoName");
            strArr[12] = "weiBoUrl";
            strArr[13] = jSONObject.optString("weiBoUrl");
            strArr[14] = "introduce";
            strArr[15] = jSONObject.optString("introduce");
            strArr[16] = UserInfo.ADDRESS;
            strArr[17] = jSONObject.optString(UserInfo.ADDRESS);
            strArr[18] = "faxNum";
            strArr[19] = jSONObject.optString("faxNum");
            strArr[20] = "webSite";
            strArr[21] = jSONObject.optString("webSite");
            strArr[22] = "versionCode";
            strArr[23] = jSONObject.optString("versionCode");
            strArr[24] = "email";
            strArr[25] = jSONObject.optString("email");
            strArr[26] = "parentPubId";
            strArr[27] = jSONObject.optString("parentPubId");
            strArr[28] = "slogan";
            strArr[29] = jSONObject.optString("slogan");
            strArr[30] = "rectLogoName";
            strArr[31] = jSONObject.optString("rectLogoName");
            strArr[32] = "circleLogoName";
            strArr[33] = jSONObject.optString("circleLogoName");
            strArr[34] = "extend";
            strArr[35] = jSONObject.optString("extend");
            strArr[36] = "hasMenu";
            strArr[37] = jSONObject.optString("hasMenu");
            strArr[38] = "loadMenuTime";
            strArr[39] = jSONObject.optString("loadMenuTime");
            strArr[40] = "moveWebSite";
            strArr[41] = jSONObject.optString("moveWebSite");
            strArr[42] = "corpLevel";
            if (C3049n.m13653e(optString)) {
                optString = "0";
            }
            strArr[43] = optString;
            strArr[44] = "updateInfoTime";
            strArr[45] = String.valueOf(System.currentTimeMillis());
            strArr[46] = "rid";
            strArr[47] = jSONObject.optString("rid");
            strArr[48] = "logoType";
            strArr[49] = jSONObject.optString("logoType");
            ContentValues a = C2921a.m13130a(null, strArr);
            if (((long) C2922b.m13133a("tb_public_info", a, "pubId = ?", new String[]{jSONObject.optString("pubId")})) < 1) {
                C2922b.m13135a("tb_public_info", a);
            }
            try {
                C2922b.m13134a("tb_public_num_info", " pubId =? ", new String[]{jSONObject.optString("pubId")});
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "PubInfoManager savaPubInfo: " + th.getMessage(), th);
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pubNumInfolist");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        try {
                            C2928f.m13195f(optJSONObject);
                            String optString2 = optJSONObject.optString(Constants.FIELD_APPLET_CONFIG_NUM);
                            String optString3 = optJSONObject.optString("nameType", "0");
                            if (C2922b.m13135a("tb_public_num_info", C2921a.m13130a(null, "pubId", optJSONObject.optString("pubId"), Constants.FIELD_APPLET_CONFIG_NUM, optString2, "main", optJSONObject.optString("main"), "communication", optJSONObject.optString("communication"), "purpose", optJSONObject.optString("purpose"), "areaCode", optJSONObject.optString("areaCode"), "extend", optJSONObject.optString("extend"), "ptype", optJSONObject.optString("type"), "isfull", optJSONObject.optString("isfull"), "minLen", optJSONObject.optString("minLen"), "maxLen", optJSONObject.optString("maxLen"), "len", optJSONObject.optString("len"), "ntype", optJSONObject.optString("ntype"), "nameType", optJSONObject.optString("nameType", "0"), "lastloadtime", String.valueOf(System.currentTimeMillis()))) > 0 && "1".equals(optString3)) {
                                C2925c.m13163a(optString2, optJSONObject.optInt("pubId"));
                            }
                            optString = optJSONObject.optString("areaCode");
                            C2955v.m13298a(optString2, C3049n.m13653e(optString) ? "" : optString.split(";")[0], 1);
                        } catch (Throwable th2) {
                            C2982a.m13415a("XIAOYUAN", "PubInfoManager savePubNumInfo: " + th2.getMessage(), th2);
                        }
                    }
                }
            }
            try {
                C2922b.m13134a("tb_public_menu_info", "pubId = ?", new String[]{jSONObject.optString("pubId")});
            } catch (Throwable th22) {
                C2982a.m13415a("XIAOYUAN", "PubInfoManager deletePubMenuInfo: " + th22.getMessage(), th22);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("pubMenuInfolist");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    C2928f.m13193d(optJSONArray2.optJSONObject(i2));
                }
            }
        }
    }

    private static int m13184b(String str, String str2) {
        C2962e c2962e = null;
        int a;
        try {
            c2962e = C2922b.m13138a("SELECT DISTINCT nameType FROM tb_public_num_info WHERE num =? AND areaCode LIKE ?", new String[]{str, "%" + str2 + "%"});
            if (c2962e == null || c2962e.m13323a() <= 0 || !c2962e.m13327b()) {
                C2962e.m13322a(c2962e, true);
                return -1;
            }
            a = c2962e.m13324a(0);
            return a;
        } catch (Throwable th) {
            a = th;
            C2982a.m13415a("XIAOYUAN", "PubInfoManager queryNameTypeByNumAndAreaCode: " + a.getMessage(), a);
        } finally {
            C2962e.m13322a(c2962e, true);
        }
    }

    public static ArrayList<String> m13185b(String str) {
        Throwable th;
        C2962e a;
        try {
            ArrayList<String> arrayList = new ArrayList();
            a = C2922b.m13138a("select DISTINCT versionCode, pubId from tb_public_info where  pubId  in ( " + str + " )", null);
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        while (a.m13327b()) {
                            String c = a.m13328c(a.m13325a("pubId"));
                            String c2 = a.m13328c(a.m13325a("versionCode"));
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(Constants.FIELD_APPLET_CONFIG_NUM, c);
                            jSONObject.put("version", c2);
                            arrayList.add(jSONObject.toString());
                        }
                        C2962e.m13322a(a, true);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C2962e.m13322a(a, true);
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
        return null;
    }

    private static HashMap<String, String> m13186b(String str, String str2, int i) {
        SQLiteDatabase a;
        Throwable th;
        Throwable th2;
        HashMap<String, String> hashMap = null;
        try {
            a = C2922b.m13136a();
            try {
                Object obj = "SELECT pubId,minLen,maxLen,len,ntype,num,areaCode,purpose,extend,nameType from tb_public_num_info where num like '%*' and '" + str + "' like  substr(num,1,length(num)-1) || '%'  and ptype = '" + i + "'";
                if (PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(str2)) {
                    obj = new StringBuilder(String.valueOf(obj)).append(" and areaCode = 'CN;'").toString();
                }
                hashMap = C2928f.m13175a(a, str, new StringBuilder(String.valueOf(obj)).append(" order by lastloadtime desc, length(num) desc ").toString(), str2, i);
                C2922b.m13143a(a);
            } catch (Throwable th3) {
                th = th3;
                try {
                    C2982a.m13415a("XIAOYUAN", "PubInfoManager queryPubIdHasRuleNum: " + th.getMessage(), th);
                    C2922b.m13143a(a);
                    return hashMap;
                } catch (Throwable th4) {
                    th2 = th4;
                    C2922b.m13143a(a);
                    throw th2;
                }
            }
        } catch (Throwable th5) {
            a = null;
            th2 = th5;
            C2922b.m13143a(a);
            throw th2;
        }
        return hashMap;
    }

    public static void m13187b() {
        try {
            C2922b.m13134a("tb_public_num_info", "isrulenum = 1", null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoManager deleteRuleNumData: " + th.getMessage(), th);
        }
    }

    private static boolean m13188b(int i) {
        return i == 1;
    }

    public static boolean m13189b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        if (!C2928f.m13188b(jSONObject.optInt("nameType"))) {
            return true;
        }
        String b = C3049n.m13646b(jSONObject.optString(Constants.FIELD_APPLET_CONFIG_NUM));
        int optInt = jSONObject.optInt("pubId");
        C2924b a = C2925c.m13160a(b, false);
        boolean z = (a == null || a.f9921g == 0) ? false : optInt != a.f9921g;
        return !z;
    }

    public static int m13190c(String str) {
        int i = -1;
        if (!C3049n.m13653e(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "PubInfoManager parseSimIndex 无效的卡位,simIndexStr=" + str, th);
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.HashMap<java.lang.String, java.lang.String> m13191c(java.lang.String r12, java.lang.String r13, int r14) {
        /*
        r2 = 0;
        r9 = 1;
        r1 = 0;
        r3 = -1;
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r4 = "SELECT pubId,purpose,extend,nameType from tb_public_num_info where num = '";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r0 = r0.append(r12);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r4 = "' and ptype = '";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r0 = r0.append(r14);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r4 = "' and areaCode LIKE '%";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r0 = r0.append(r13);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r4 = "%'";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        r4 = 0;
        r6 = cn.com.xy.sms.sdk.p208d.C2922b.m13138a(r0, r4);	 Catch:{ Throwable -> 0x0111, all -> 0x0173 }
        if (r6 == 0) goto L_0x008b;
    L_0x0034:
        r0 = r6.m13323a();	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        if (r0 <= 0) goto L_0x008b;
    L_0x003a:
        r0 = r6.m13327b();	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        if (r0 == 0) goto L_0x01ca;
    L_0x0040:
        r0 = "pubId";
        r0 = r6.m13325a(r0);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r5 = r6.m13324a(r0);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r0 = "purpose";
        r0 = r6.m13325a(r0);	 Catch:{ Throwable -> 0x018c, all -> 0x0180 }
        r4 = r6.m13328c(r0);	 Catch:{ Throwable -> 0x018c, all -> 0x0180 }
        r0 = "extend";
        r0 = r6.m13325a(r0);	 Catch:{ Throwable -> 0x0193, all -> 0x0180 }
        r3 = r6.m13328c(r0);	 Catch:{ Throwable -> 0x0193, all -> 0x0180 }
        r0 = "nameType";
        r0 = r6.m13325a(r0);	 Catch:{ Throwable -> 0x019b, all -> 0x0180 }
        r0 = r6.m13324a(r0);	 Catch:{ Throwable -> 0x019b, all -> 0x0180 }
        r8 = r2;
        r7 = r6;
        r2 = r0;
        r6 = r5;
        r5 = r4;
        r0 = r1;
        r4 = r13;
    L_0x006f:
        if (r6 <= 0) goto L_0x007b;
    L_0x0071:
        if (r8 != 0) goto L_0x007b;
    L_0x0073:
        r10 = new cn.com.xy.sms.sdk.d.c.a.h;	 Catch:{ Throwable -> 0x01bf }
        r10.<init>(r4, r12);	 Catch:{ Throwable -> 0x01bf }
        cn.com.xy.sms.sdk.p216h.C2996a.m13484a(r10);	 Catch:{ Throwable -> 0x01bf }
    L_0x007b:
        if (r0 == 0) goto L_0x0179;
    L_0x007d:
        if (r8 == 0) goto L_0x0179;
    L_0x007f:
        r8 = "ruleMatch";
        r10 = "";
        r0.put(r8, r10);	 Catch:{ Throwable -> 0x01bf }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r7, r9);
    L_0x008a:
        return r0;
    L_0x008b:
        r0 = 1;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r6, r0);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r0 = "CN";
        r0 = r0.equalsIgnoreCase(r13);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        if (r0 != 0) goto L_0x0105;
    L_0x0097:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r4 = "SELECT pubId,purpose,extend,nameType from tb_public_num_info where num = '";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r0 = r0.append(r12);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r4 = "' and ptype = '";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r0 = r0.append(r14);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r4 = "' and areaCode LIKE '%CN%'";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r4 = 0;
        r7 = cn.com.xy.sms.sdk.p208d.C2922b.m13138a(r0, r4);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        if (r7 == 0) goto L_0x00fa;
    L_0x00bd:
        r0 = r7.m13323a();	 Catch:{ Throwable -> 0x01a2 }
        if (r0 <= 0) goto L_0x00fa;
    L_0x00c3:
        r0 = r7.m13327b();	 Catch:{ Throwable -> 0x01a2 }
        if (r0 == 0) goto L_0x01c2;
    L_0x00c9:
        r0 = "pubId";
        r0 = r7.m13325a(r0);	 Catch:{ Throwable -> 0x01a2 }
        r6 = r7.m13324a(r0);	 Catch:{ Throwable -> 0x01a2 }
        r0 = "purpose";
        r0 = r7.m13325a(r0);	 Catch:{ Throwable -> 0x01a9 }
        r5 = r7.m13328c(r0);	 Catch:{ Throwable -> 0x01a9 }
        r0 = "extend";
        r0 = r7.m13325a(r0);	 Catch:{ Throwable -> 0x01af }
        r4 = r7.m13328c(r0);	 Catch:{ Throwable -> 0x01af }
        r0 = "nameType";
        r0 = r7.m13325a(r0);	 Catch:{ Throwable -> 0x01b4 }
        r3 = r7.m13324a(r0);	 Catch:{ Throwable -> 0x01b4 }
        r13 = "CN";
        r8 = r2;
        r0 = r1;
        r2 = r3;
        r3 = r4;
        r4 = r13;
        goto L_0x006f;
    L_0x00fa:
        r0 = cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f.m13186b(r12, r13, r14);	 Catch:{ Throwable -> 0x01a2 }
        r8 = r9;
        r4 = r1;
        r5 = r1;
        r6 = r3;
        r3 = r1;
        goto L_0x006f;
    L_0x0105:
        r0 = cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f.m13186b(r12, r13, r14);	 Catch:{ Throwable -> 0x0185, all -> 0x0180 }
        r8 = r9;
        r4 = r1;
        r5 = r1;
        r7 = r6;
        r6 = r3;
        r3 = r1;
        goto L_0x006f;
    L_0x0111:
        r0 = move-exception;
        r4 = r1;
        r5 = r1;
        r6 = r3;
        r7 = r1;
        r3 = r1;
    L_0x0117:
        r8 = "XIAOYUAN";
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0183 }
        r11 = "PubInfoManager queryPubIdByNum: ";
        r10.<init>(r11);	 Catch:{ all -> 0x0183 }
        r11 = r0.getMessage();	 Catch:{ all -> 0x0183 }
        r10 = r10.append(r11);	 Catch:{ all -> 0x0183 }
        r10 = r10.toString();	 Catch:{ all -> 0x0183 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r8, r10, r0);	 Catch:{ all -> 0x0183 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r7, r9);
    L_0x0132:
        if (r6 < 0) goto L_0x017d;
    L_0x0134:
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "pubId";
        r6 = java.lang.String.valueOf(r6);
        r0.put(r1, r6);
        r1 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r5);
        if (r1 != 0) goto L_0x014d;
    L_0x0148:
        r1 = "purpose";
        r0.put(r1, r5);
    L_0x014d:
        r1 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r4);
        if (r1 != 0) goto L_0x0158;
    L_0x0153:
        r1 = "areaCode";
        r0.put(r1, r4);
    L_0x0158:
        r1 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r3);
        if (r1 != 0) goto L_0x0163;
    L_0x015e:
        r1 = "extend";
        r0.put(r1, r3);
    L_0x0163:
        r1 = "nameType";
        r2 = java.lang.String.valueOf(r2);
        r0.put(r1, r2);
        r1 = "num";
        r0.put(r1, r12);
        goto L_0x008a;
    L_0x0173:
        r0 = move-exception;
        r7 = r1;
    L_0x0175:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r7, r9);
        throw r0;
    L_0x0179:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r7, r9);
        goto L_0x0132;
    L_0x017d:
        r0 = r1;
        goto L_0x008a;
    L_0x0180:
        r0 = move-exception;
        r7 = r6;
        goto L_0x0175;
    L_0x0183:
        r0 = move-exception;
        goto L_0x0175;
    L_0x0185:
        r0 = move-exception;
        r4 = r1;
        r5 = r1;
        r7 = r6;
        r6 = r3;
        r3 = r1;
        goto L_0x0117;
    L_0x018c:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r7 = r6;
        r6 = r5;
        r5 = r1;
        goto L_0x0117;
    L_0x0193:
        r0 = move-exception;
        r3 = r1;
        r7 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r1;
        goto L_0x0117;
    L_0x019b:
        r0 = move-exception;
        r7 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r1;
        goto L_0x0117;
    L_0x01a2:
        r0 = move-exception;
        r4 = r1;
        r5 = r1;
        r6 = r3;
        r3 = r1;
        goto L_0x0117;
    L_0x01a9:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        r5 = r1;
        goto L_0x0117;
    L_0x01af:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
        goto L_0x0117;
    L_0x01b4:
        r0 = move-exception;
        r3 = r4;
        r4 = r1;
        goto L_0x0117;
    L_0x01b9:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        r4 = r1;
        goto L_0x0117;
    L_0x01bf:
        r0 = move-exception;
        goto L_0x0117;
    L_0x01c2:
        r8 = r2;
        r0 = r1;
        r4 = r1;
        r5 = r1;
        r6 = r3;
        r3 = r1;
        goto L_0x006f;
    L_0x01ca:
        r8 = r2;
        r0 = r1;
        r4 = r1;
        r5 = r1;
        r7 = r6;
        r6 = r3;
        r3 = r1;
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.a.f.c(java.lang.String, java.lang.String, int):java.util.HashMap<java.lang.String, java.lang.String>");
    }

    public static boolean m13192c(JSONObject jSONObject) {
        if (jSONObject == null || !C2928f.m13188b(jSONObject.optInt("nameType"))) {
            return false;
        }
        C2924b a = C2925c.m13160a(C3049n.m13646b(jSONObject.optString(Constants.FIELD_APPLET_CONFIG_NUM)), false);
        if (a == null || a.f9921g == 0) {
            return false;
        }
        if (System.currentTimeMillis() - a.f9924j > C2973a.m13350a(34, 86400000)) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0 || a.f9921g == jSONObject.optInt("pubId")) {
            return false;
        }
        C2925c.m13165a(jSONObject.optString(Constants.FIELD_APPLET_CONFIG_NUM), System.currentTimeMillis(), 1);
        return true;
    }

    private static void m13193d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("secondmenu");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    C2928f.m13194e(jSONObject);
                    return;
                }
                C2928f.m13194e(jSONObject);
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    C2928f.m13194e(optJSONArray.getJSONObject(i));
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "PubInfoManager savePubMenuInfo: " + th.getMessage(), th);
            }
        }
    }

    private static void m13194e(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                ContentValues a = C2921a.m13130a(null, "menuCode", jSONObject.optString("menuCode"), "pubId", jSONObject.optString("pubId"), "menuName", jSONObject.optString("name"), "menuType", jSONObject.optString("type"), "extend", jSONObject.optString("extend"), "actionData", jSONObject.optString("action_data"));
                if (((long) C2922b.m13133a("tb_public_menu_info", a, "pubId = ? and menuCode = ?", new String[]{jSONObject.optString("pubId"), jSONObject.optString("menuCode")})) < 1) {
                    C2922b.m13135a("tb_public_menu_info", a);
                    new StringBuilder("PubInfoManager saveSinglePubMenuInfo insert=").append(jSONObject.toString());
                    return;
                }
                new StringBuilder("PubInfoManager saveSinglePubMenuInfo update=").append(jSONObject.toString());
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "PubInfoManager saveSinglePubMenuInfo: " + th.getMessage(), th);
            }
        }
    }

    private static void m13195f(JSONObject jSONObject) {
        try {
            for (String str : jSONObject.optString("areaCode").split(";")) {
                if (!C3049n.m13653e(str)) {
                    C2922b.m13134a("tb_public_num_info", "  ptype = ? and num = ? and areaCode like '%" + str + "%'  and pubId !=? ", new String[]{String.valueOf(jSONObject.optString("type")), jSONObject.optString(Constants.FIELD_APPLET_CONFIG_NUM), jSONObject.optString("pubId")});
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoManager deletePubNumInfoByNum: " + th.getMessage(), th);
        }
    }
}
