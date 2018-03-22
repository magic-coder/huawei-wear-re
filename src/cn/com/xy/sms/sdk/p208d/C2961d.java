package cn.com.xy.sms.sdk.p208d;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p226k.p227a.p228a.C3035a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.LineNumberReader;

public class C2961d {
    public static void m13321a(Context context) {
        SQLiteDatabase a;
        Throwable th;
        String str = C2917a.m13113f() + "train_data.txt";
        LineNumberReader a2;
        try {
            int a3 = C3035a.m13581a();
            a2 = C3050o.m13665a(str);
            try {
                a = C2922b.m13136a();
                try {
                    a.beginTransaction();
                    String readLine = a2.readLine();
                    ContentValues contentValues = new ContentValues();
                    String[] split;
                    if (a3 != 6 && a3 != 7) {
                        split = readLine.split("=");
                        while (true) {
                            readLine = a2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split2 = readLine.split(HwAccountConstants.BLANK);
                            contentValues.put("train_num", split2[0]);
                            if (split2.length >= 2) {
                                contentValues.put("end_city", split[Integer.valueOf(split2[1]).intValue()]);
                            }
                            if (((long) a.update("tb_train6", contentValues, "train_num=?", new String[]{split2[0]})) < 1) {
                                a.insert("tb_train6", null, contentValues);
                            }
                        }
                    } else {
                        while (true) {
                            String readLine2 = a2.readLine();
                            if (readLine2 == null) {
                                break;
                            }
                            split = readLine2.split("\t");
                            if (split.length >= 5) {
                                contentValues.put("train_num", split[0]);
                                contentValues.put("end_city", split[1]);
                                contentValues.put("start_time", split[2]);
                                contentValues.put("end_time", split[3]);
                                if (!C3049n.m13653e(split[4])) {
                                    contentValues.put("station_list", split[4]);
                                }
                                if (((long) a.update("tb_train6", contentValues, "train_num=?", new String[]{split[0]})) < 1) {
                                    a.insert("tb_train6", null, contentValues);
                                }
                            }
                        }
                    }
                    C2922b.m13147a(str, true, a2, null, a);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                a = null;
                C2922b.m13147a(str, true, a2, null, a);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            a2 = null;
            a = null;
            C2922b.m13147a(str, true, a2, null, a);
            throw th;
        }
    }
}
