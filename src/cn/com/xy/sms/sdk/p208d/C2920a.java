package cn.com.xy.sms.sdk.p208d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.LineNumberReader;

public class C2920a {
    public static void m13127a(Context context) {
        LineNumberReader a;
        SQLiteDatabase a2;
        Throwable th;
        String str = C2917a.m13113f() + "air_data.txt";
        try {
            a = C3050o.m13665a(str);
            try {
                a2 = C2922b.m13136a();
                try {
                    a2.beginTransaction();
                    String readLine = a.readLine();
                    if (readLine == null) {
                        C2922b.m13147a(str, true, a, null, a2);
                        return;
                    }
                    String[] split = readLine.split("=");
                    while (true) {
                        String readLine2 = a.readLine();
                        if (readLine2 == null) {
                            C2922b.m13147a(str, true, a, null, a2);
                            return;
                        }
                        String[] split2 = readLine2.split(HwAccountConstants.BLANK);
                        if (split2.length >= 3) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("air_num", split2[0]);
                            contentValues.put("start_place", split[Integer.valueOf(split2[1]).intValue()]);
                            contentValues.put("end_place", split[Integer.valueOf(split2[2]).intValue()]);
                            if (((long) a2.update("tb_air", contentValues, "air_num=?", new String[]{split2[0]})) < 1) {
                                a2.insert("tb_air", null, contentValues);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                a2 = null;
                C2922b.m13147a(str, true, a, null, a2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            a = null;
            a2 = null;
            C2922b.m13147a(str, true, a, null, a2);
            throw th;
        }
    }
}
