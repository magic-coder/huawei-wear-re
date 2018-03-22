package com.huawei.hwdatamigrate.p407a;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.common.C4799a;
import com.huawei.hwdatamigrate.common.C4800b;
import com.huawei.hwdatamigrate.common.C4803g;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4977l;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.p190v.C2538c;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* compiled from: DataBaseUtil */
public class C4781n {
    private static C4781n f17639a;
    private Context f17640b = BaseApplication.b();

    public static C4781n m22889a() {
        C4781n c4781n;
        synchronized (C4781n.class) {
            if (f17639a == null) {
                f17639a = new C4781n();
            }
            c4781n = f17639a;
        }
        return c4781n;
    }

    private C4781n() {
    }

    private int[] m22892a(String str) {
        int[] iArr = new int[4];
        int[] a = C4800b.m22986a(str);
        if (a == null) {
            return iArr;
        }
        int i = 0;
        while (i < a.length) {
            if (a[i] > 0 && a[i] < 10) {
                iArr[0] = iArr[0] + 1;
            } else if (a[i] >= 10 && a[i] < 50) {
                iArr[1] = iArr[1] + 1;
            } else if (a[i] >= 50) {
                iArr[2] = iArr[2] + 1;
            }
            i++;
        }
        iArr[3] = iArr[0] + iArr[1];
        return iArr;
    }

    public void m22893a(SQLiteDatabase sQLiteDatabase) {
        C2538c.b("DataBaseHelper_m", new Object[]{"===www===onCreate() DATABASE_VERSION=29"});
        C4977l.m23909a(sQLiteDatabase, am.f17457b);
        C4977l.m23909a(sQLiteDatabase, ai.f17404c);
        C4977l.m23909a(sQLiteDatabase, C4768a.f17371a);
        C4977l.m23909a(sQLiteDatabase, C4770c.f17600a);
        C4977l.m23909a(sQLiteDatabase, C4776i.f17624a);
        C4977l.m23909a(sQLiteDatabase, ao.f17470a);
        C4977l.m23909a(sQLiteDatabase, bf.f17580a);
        C4977l.m23909a(sQLiteDatabase, az.f17525b);
        C4977l.m23909a(sQLiteDatabase, bc.f17551a);
        C4977l.m23909a(sQLiteDatabase, ak.f17418b);
        C4977l.m23909a(sQLiteDatabase, ar.f17487b);
        C4977l.m23909a(sQLiteDatabase, C4777j.f17627b);
        C4977l.m23909a(sQLiteDatabase, ac.f17379a);
        C4977l.m23909a(sQLiteDatabase, C4783p.f17647b);
        C4977l.m23909a(sQLiteDatabase, C4789v.f17706a);
        C4977l.m23909a(sQLiteDatabase, C4773f.f17614a);
        C4977l.m23909a(sQLiteDatabase, aw.f17511a);
        C4977l.m23909a(sQLiteDatabase, as.f17491a);
        C4977l.m23909a(sQLiteDatabase, C4790w.f17710a);
        C4977l.m23909a(sQLiteDatabase, bh.f17588a);
        C4977l.m23909a(sQLiteDatabase, aa.f17376b);
        C4977l.m23909a(sQLiteDatabase, ag.f17393a);
        C4977l.m23909a(sQLiteDatabase, C4785r.f17689a);
        C4977l.m23909a(sQLiteDatabase, ab.f17377a);
        C4977l.m23909a(sQLiteDatabase, af.f17391a);
    }

    public void m22894b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            int i;
            String string;
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN RunStepTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN RunDistanceTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN RunCalorieTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN RunTimeTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN ClimbStepTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN ClimbCalorieTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN ClimbTimeTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN RidingDistanceTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN RidingCalorieTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN RidingTimeTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN WalkStepTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN WalkDistanceTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN WalkCalorieTotal integer;");
            C4977l.m23909a(sQLiteDatabase, "ALTER TABLE sportdatas ADD COLUMN WalkTimeTotal integer;");
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sportdatas", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    string = rawQuery.getString(rawQuery.getColumnIndex("totalSteps"));
                    String string2 = rawQuery.getString(rawQuery.getColumnIndex("totalDistance"));
                    String string3 = rawQuery.getString(rawQuery.getColumnIndex("totalCalories"));
                    String string4 = rawQuery.getString(rawQuery.getColumnIndex("sportduration"));
                    C4977l.m23910a(sQLiteDatabase, "update sportdatas set WalkStepTotal=? , WalkDistanceTotal=? , WalkCalorieTotal=? , WalkTimeTotal=?  where _id=?", new Object[]{string, string2, string3, string4, Integer.valueOf(i)});
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            rawQuery = sQLiteDatabase.rawQuery("select * from sleepdatas", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    string = C4800b.m22985a(this.f17640b, rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetail")));
                    C4977l.m23910a(sQLiteDatabase, "update sleepdatas set sleepsDataDetailInMin=?  where _id=?", new Object[]{string, Integer.valueOf(i)});
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{"upgradeDB2Version12 Exception=" + e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22895c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        String str = "";
        str = "";
        str = "";
        Object obj = 1;
        try {
            String str2 = "sleepdatas_backup";
            C4977l.m23909a(sQLiteDatabase, "alter table sleepdatas rename to " + str2);
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str2 + " order by " + "sleepCurTime" + " ASC ", null);
            C4977l.m23909a(sQLiteDatabase, ai.f17403b);
            C4977l.m23909a(sQLiteDatabase, "INSERT INTO sleepdatas SELECT * FROM " + str2);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    String string;
                    String a;
                    int i;
                    int i2;
                    int i3;
                    if (obj != null) {
                        string = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetailInMin"));
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetail"));
                        a = C4803g.m23002a(C4803g.m23006c(C4803g.m23003a(rawQuery.getString(rawQuery.getColumnIndex("sleepCurTime")))));
                        str = m22891a(null, string, 1);
                        string = m22891a(null, string2, 2);
                        int[] a2 = m22892a(str);
                        i = a2[0];
                        i2 = a2[1];
                        i3 = a2[2];
                        int i4 = a2[3];
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                        contentValues.put("sleeps", "");
                        contentValues.put("totalMinutes", Integer.valueOf(i4));
                        contentValues.put("deepMinutes", Integer.valueOf(i));
                        contentValues.put("lightMinutes", Integer.valueOf(i2));
                        contentValues.put("awakeMinutes", Integer.valueOf(i3));
                        contentValues.put("isUpload", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("isUpload"))));
                        contentValues.put("sleepCurTime", a);
                        contentValues.put("sleepsDataDetail", string);
                        contentValues.put("mac", rawQuery.getString(rawQuery.getColumnIndex("mac")));
                        contentValues.put("sleepsDataDetailInMin", str);
                        sQLiteDatabase.insert("sleepdatas", null, contentValues);
                        rawQuery.moveToPrevious();
                        obj = null;
                    } else {
                        String str3;
                        i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                        a = rawQuery.getString(rawQuery.getColumnIndex("sleepCurTime"));
                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetailInMin"));
                        String string4 = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetail"));
                        if (!rawQuery.moveToNext()) {
                            str3 = null;
                            string = null;
                        } else if (C4803g.m23004a(C4803g.m23003a(rawQuery.getString(rawQuery.getColumnIndex("sleepCurTime"))), C4803g.m23005b(C4803g.m23003a(a)))) {
                            str3 = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetailInMin"));
                            string = rawQuery.getString(rawQuery.getColumnIndex("sleepsDataDetail"));
                        } else {
                            str3 = null;
                            string = null;
                            obj = 1;
                        }
                        rawQuery.moveToPrevious();
                        str3 = m22891a(string3, str3, 1);
                        string = m22891a(string4, string, 2);
                        int[] a3 = m22892a(str3);
                        i3 = a3[0];
                        int i5 = a3[1];
                        int i6 = a3[2];
                        i2 = a3[3];
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                        contentValues2.put("sleeps", "");
                        contentValues2.put("totalMinutes", Integer.valueOf(i2));
                        contentValues2.put("deepMinutes", Integer.valueOf(i3));
                        contentValues2.put("lightMinutes", Integer.valueOf(i5));
                        contentValues2.put("awakeMinutes", Integer.valueOf(i6));
                        contentValues2.put("isUpload", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("isUpload"))));
                        contentValues2.put("sleepCurTime", a);
                        contentValues2.put("sleepsDataDetail", string);
                        contentValues2.put("mac", rawQuery.getString(rawQuery.getColumnIndex("mac")));
                        contentValues2.put("sleepsDataDetailInMin", str3);
                        String[] strArr = new String[]{String.valueOf(i)};
                        sQLiteDatabase.update("sleepdatas", contentValues2, "_id= ?", strArr);
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str2);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void m22896d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, C4790w.f17710a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C2538c.e("DataBaseHelper_m", new Object[]{e.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from altitudedatas", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                int i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                String a = C4799a.m22980a(this.f17640b, rawQuery.getString(rawQuery.getColumnIndex("mac")));
                C4977l.m23910a(sQLiteDatabase, "update altitudedatas set mac=? where _id=?", new Object[]{a, Integer.valueOf(i)});
            }
            rawQuery.close();
        }
        rawQuery = sQLiteDatabase.rawQuery("select * from devicedatas", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                a = C4799a.m22980a(this.f17640b, rawQuery.getString(rawQuery.getColumnIndex("mac")));
                C4977l.m23910a(sQLiteDatabase, "update devicedatas set mac=? where _id=?", new Object[]{a, Integer.valueOf(i)});
            }
            rawQuery.close();
        }
        rawQuery = sQLiteDatabase.rawQuery("select * from heartdatas", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                a = C4799a.m22980a(this.f17640b, rawQuery.getString(rawQuery.getColumnIndex("mac")));
                C4977l.m23910a(sQLiteDatabase, "update heartdatas set mac=? where _id=?", new Object[]{a, Integer.valueOf(i)});
            }
            rawQuery.close();
        }
        rawQuery = sQLiteDatabase.rawQuery("select * from sleepdatas", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                a = C4799a.m22980a(this.f17640b, rawQuery.getString(rawQuery.getColumnIndex("mac")));
                C4977l.m23910a(sQLiteDatabase, "update sleepdatas set mac=? where _id=?", new Object[]{a, Integer.valueOf(i)});
            }
            rawQuery.close();
        }
        rawQuery = sQLiteDatabase.rawQuery("select * from sportdatas", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                a = C4799a.m22980a(this.f17640b, rawQuery.getString(rawQuery.getColumnIndex("mac")));
                C4977l.m23910a(sQLiteDatabase, "update sportdatas set mac=? where _id=?", new Object[]{a, Integer.valueOf(i)});
            }
            rawQuery.close();
        }
    }

    private String m22891a(String str, String str2, int i) {
        int i2;
        int i3;
        int i4;
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 1) {
            i2 = 960;
            i3 = 1440;
        } else {
            i2 = 288;
            i3 = 432;
        }
        String[] e = C4800b.m22990e(m22890a(str, i));
        int length = e.length;
        String[] e2 = C4800b.m22990e(m22890a(str2, i));
        int length2 = e2.length;
        for (i4 = 0; i4 < i2; i4++) {
            if (i4 + 480 >= length) {
                stringBuilder.append(",0");
            } else {
                stringBuilder.append("," + e[(i4 + i3) - i2]);
            }
        }
        for (i4 = i2; i4 < i3; i4++) {
            if (i4 >= length2) {
                stringBuilder.append(",0");
            } else {
                stringBuilder.append("," + e2[i4 - i2]);
            }
        }
        return stringBuilder.toString().substring(1);
    }

    private String m22890a(String str, int i) {
        if (str != null && !str.isEmpty()) {
            return str;
        }
        if (i == 1) {
            return C4800b.f17742a;
        }
        return C4800b.f17744c;
    }

    public void m22897e(SQLiteDatabase sQLiteDatabase) {
        FileInputStream openFileInput;
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        sQLiteDatabase.beginTransaction();
        try {
            C4977l.m23909a(sQLiteDatabase, bh.f17588a);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e3) {
            C2538c.e("DataBaseHelper_m", new Object[]{e3.getMessage()});
        } finally {
            sQLiteDatabase.endTransaction();
        }
        String[] strArr = new String[]{"bone_settings", "user_agreement", "set_goal_time", "jawboneup_login", "JawboneUP_CompletedTime", "JawboneUP_LastSyncTime", "map_tracking_sp", "om_huawei_bone_hi_analytics_MyHiAnalyticsUtil_MY_HI_ANALYTICS_FILE_NAME", "sMyftDataObject"};
        for (String str : strArr) {
            String str2;
            HashMap hashMap = new HashMap();
            Context context = this.f17640b;
            Context context2 = this.f17640b;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
            if (sharedPreferences != null) {
                Map all = sharedPreferences.getAll();
                if (all != null) {
                    for (int i = 0; i < all.size(); i++) {
                        Set<Object> keySet = all.keySet();
                        if (keySet != null) {
                            for (Object valueOf : keySet) {
                                String valueOf2 = String.valueOf(valueOf);
                                String valueOf3 = String.valueOf(all.get(valueOf2));
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(SMSKeyInfo.TAG_KEY, valueOf2);
                                contentValues.put("value", valueOf3);
                                sQLiteDatabase.insert("internalstorage", null, contentValues);
                            }
                        }
                    }
                }
            }
        }
        Properties properties = new Properties();
        try {
            openFileInput = this.f17640b.openFileInput("config.properties");
            if (openFileInput != null) {
                try {
                    properties.load(openFileInput);
                    openFileInput.close();
                    Enumeration propertyNames = properties.propertyNames();
                    while (propertyNames.hasMoreElements()) {
                        String str3 = (String) propertyNames.nextElement();
                        str2 = properties.getProperty(str3);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put(SMSKeyInfo.TAG_KEY, str3);
                        contentValues2.put("value", str2);
                        sQLiteDatabase.insert("internalstorage", null, contentValues2);
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    try {
                        C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: FileNotFoundException1 = " + e.getMessage()});
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException e22) {
                                C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: e = " + e22.getMessage()});
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException e5) {
                                C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: e = " + e5.getMessage()});
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e22 = e6;
                    C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: IOException2 = " + e22.getMessage()});
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e222) {
                            C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: e = " + e222.getMessage()});
                            return;
                        }
                    }
                }
            }
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                } catch (IOException e2222) {
                    C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: e = " + e2222.getMessage()});
                }
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            openFileInput = null;
            C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: FileNotFoundException1 = " + e.getMessage()});
            if (openFileInput != null) {
                openFileInput.close();
            }
        } catch (IOException e8) {
            e2222 = e8;
            openFileInput = null;
            C2538c.e("DataBaseHelper_m", new Object[]{"DataBaseHeler: IOException2 = " + e2222.getMessage()});
            if (openFileInput != null) {
                openFileInput.close();
            }
        } catch (Throwable th3) {
            th = th3;
            openFileInput = null;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }
}
