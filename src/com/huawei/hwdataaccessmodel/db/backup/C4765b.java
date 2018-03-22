package com.huawei.hwdataaccessmodel.db.backup;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.o.c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/* compiled from: SubstituteDataBaseHelper */
public class C4765b extends SQLiteOpenHelper {
    private static String f17358a = "";
    private static Map<String, C4765b> f17359c = new HashMap();
    private static String f17360d;
    private static byte[] f17361e = new byte[1];
    private SQLiteDatabase f17362b;

    public static C4765b m22777a(Context context, String str) {
        C4765b c4765b;
        synchronized (f17361e) {
            if (TextUtils.isEmpty(f17360d)) {
                try {
                    byte[] a = c.a(14);
                    if (a != null) {
                        f17360d = new String(a, GameManager.DEFAULT_CHARSET);
                    }
                } catch (UnsupportedEncodingException e) {
                    C2538c.e("SubstituteDataBaseHelper", new Object[]{"UnsupportedEncodingException "});
                    throw new RuntimeException("UnsupportedEncodingException");
                } catch (Exception e2) {
                    C2538c.e("SubstituteDataBaseHelper", new Object[]{"get Key Exception: " + e2.getMessage()});
                }
            }
            if (f17359c.get(str) == null) {
                SQLiteDatabase.loadLibs(BaseApplication.b());
                f17358a = BaseApplication.b().getPackageName();
                if (TextUtils.isEmpty(f17358a)) {
                    f17358a = "SubstituteSportDatas.db";
                } else {
                    f17358a = f17358a.replaceAll("\\.", HwAccountConstants.SPLIIT_UNDERLINE) + "Sub" + str + ".db";
                }
                f17359c.put(str, new C4765b(BaseApplication.b(), f17358a));
            }
            c4765b = (C4765b) f17359c.get(str);
        }
        return c4765b;
    }

    private C4765b(Context context, String str) {
        super(context, str, null, 102);
    }

    public SQLiteDatabase m22778a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f17361e) {
            if (this.f17362b != null) {
                sQLiteDatabase = this.f17362b;
            } else if (TextUtils.isEmpty(f17360d)) {
                C2538c.b("SubstituteDataBaseHelper", new Object[]{"xxxxyyy null"});
                sQLiteDatabase = null;
            } else {
                C2538c.b("SubstituteDataBaseHelper", new Object[]{"xxxxyyy maha:", f17360d});
                this.f17362b = getWritableDatabase(f17360d);
                sQLiteDatabase = this.f17362b;
            }
        }
        return sQLiteDatabase;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
