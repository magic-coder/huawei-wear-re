package com.huawei.hwdatamigrate.hihealth.p409b.p410a;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hihealth.data.p396c.C4554a;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4811a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4814d;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4817g;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4818i;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4821l;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4822m;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4825p;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4829t;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4830u;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4831v;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4834y;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ab;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ae;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ah;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ak;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ao;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ap;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.as;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.av;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ay;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.az;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ba;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.bb;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.be;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4977l;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.o.c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;
import net.sqlcipher.database.SQLiteOpenHelper;

/* compiled from: HiHealthDBHelper */
public class C4805a extends SQLiteOpenHelper {
    private static Context f17758a;
    private static ReentrantLock f17759b;
    private static C4805a f17760c;
    private static String f17761d;

    private C4805a(Context context, SQLiteDatabaseHook sQLiteDatabaseHook) {
        super(context, "hihealth_003.db", null, 2, sQLiteDatabaseHook);
    }

    public static C4805a m23018a(Context context) {
        C4805a c4805a;
        synchronized (C4805a.class) {
            if (TextUtils.isEmpty(f17761d)) {
                try {
                    byte[] a = c.a(13);
                    if (a != null) {
                        C2538c.b("Debug_HiHealthDBHelper", new Object[]{"getInstance kk != null"});
                        f17761d = new String(a, GameManager.DEFAULT_CHARSET);
                    } else {
                        C2538c.b("Debug_HiHealthDBHelper", new Object[]{"getInstance kk = null"});
                        f17761d = "";
                    }
                } catch (UnsupportedEncodingException e) {
                    C2538c.e("Debug_HiHealthDBHelper", new Object[]{"getInstance UnsupportedEncodingException "});
                    f17761d = "";
                }
            }
            if (f17760c == null) {
                f17758a = context;
                SQLiteDatabase.loadLibs(f17758a);
                f17759b = new ReentrantLock();
                f17760c = new C4805a(f17758a, new C4806b());
            }
            c4805a = f17760c;
        }
        return c4805a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C2538c.c("Debug_HiHealthDBHelper", new Object[]{"onCreate VERSION = ", Integer.valueOf(2)});
        C4977l.m23911a(sQLiteDatabase, C4811a.m23074a());
        C4977l.m23911a(sQLiteDatabase, bb.m23186a());
        C4977l.m23911a(sQLiteDatabase, C4814d.m23207a());
        C4977l.m23911a(sQLiteDatabase, C4822m.m23246a());
        C4977l.m23911a(sQLiteDatabase, C4818i.m23226a());
        C4977l.m23911a(sQLiteDatabase, C4818i.m23227d());
        C4977l.m23911a(sQLiteDatabase, C4825p.m23256a());
        C4977l.m23911a(sQLiteDatabase, C4821l.m23236a());
        C4977l.m23911a(sQLiteDatabase, C4831v.m23293a());
        C4977l.m23911a(sQLiteDatabase, C4831v.m23294d());
        C4977l.m23911a(sQLiteDatabase, C4834y.m23298a());
        C4977l.m23911a(sQLiteDatabase, C4834y.m23299d());
        C4977l.m23911a(sQLiteDatabase, ae.m23106a());
        C4977l.m23911a(sQLiteDatabase, ae.m23107d());
        C4977l.m23911a(sQLiteDatabase, ak.m23114a());
        C4977l.m23911a(sQLiteDatabase, ak.m23115d());
        C4977l.m23911a(sQLiteDatabase, ah.m23110a());
        C4977l.m23911a(sQLiteDatabase, ah.m23111d());
        C4977l.m23911a(sQLiteDatabase, ab.m23084a());
        C4977l.m23911a(sQLiteDatabase, ab.m23085d());
        C4977l.m23911a(sQLiteDatabase, C4830u.m23283a());
        C4977l.m23911a(sQLiteDatabase, ap.m23127a());
        C4977l.m23911a(sQLiteDatabase, ap.m23128d());
        C4977l.m23911a(sQLiteDatabase, be.m23196a());
        C4977l.m23911a(sQLiteDatabase, be.m23197d());
        C4977l.m23911a(sQLiteDatabase, ao.m23117a());
        C4977l.m23911a(sQLiteDatabase, az.m23167a());
        C4977l.m23911a(sQLiteDatabase, C4817g.m23216a());
        C4977l.m23911a(sQLiteDatabase, ba.m23176a());
        C4977l.m23911a(sQLiteDatabase, C4829t.m23274a());
        C4977l.m23911a(sQLiteDatabase, as.m23138a());
        C4977l.m23911a(sQLiteDatabase, as.m23139d());
        C4977l.m23911a(sQLiteDatabase, av.m23149a());
        C4977l.m23911a(sQLiteDatabase, ay.m23158a());
        m23019a(sQLiteDatabase);
        m23020b(sQLiteDatabase);
        C2538c.c("Debug_HiHealthDBHelper", new Object[]{"onCreate end"});
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3;
        C2538c.c("Debug_HiHealthDBHelper", new Object[]{"onUpgrade oldVersion = ", Integer.valueOf(i), ",newVersion =  ", Integer.valueOf(i2)});
        for (i3 = i; i3 < i2; i3++) {
            switch (i3) {
                case 1:
                    m23021c(sQLiteDatabase);
                    break;
                default:
                    break;
            }
        }
        C2538c.c("Debug_HiHealthDBHelper", new Object[]{"onUpgrade end oldVersion = ", Integer.valueOf(i), ",newVersion =  ", Integer.valueOf(i2), ",upgradeTo = ", Integer.valueOf(i3)});
    }

    private void m23019a(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("device_unique_code", "-1");
        contentValues.put("deviceName", C4554a.m21803a(1));
        contentValues.put("device_type", Integer.valueOf(1));
        contentValues.put("firmwareVersion", VERSION.RELEASE);
        contentValues.put("manufacturer", Build.PRODUCT);
        contentValues.put("model", Build.MODEL);
        contentValues.put("createTime", Long.valueOf(System.currentTimeMillis()));
        if (sQLiteDatabase.insert("hihealth_device", null, contentValues) <= 0) {
            C2538c.e("Debug_HiHealthDBHelper", new Object[]{"initManualInputDeviceInfo insert fail"});
        }
    }

    private void m23020b(SQLiteDatabase sQLiteDatabase) {
        String a;
        synchronized (C4805a.class) {
            a = C4539a.m21747a(f17758a);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("device_unique_code", a);
        contentValues.put("deviceName", Build.MANUFACTURER);
        contentValues.put("device_type", Integer.valueOf(32));
        contentValues.put("firmwareVersion", VERSION.RELEASE);
        contentValues.put("hardwareVersion", VERSION.RELEASE);
        contentValues.put("softwareVersion", VERSION.RELEASE);
        contentValues.put("manufacturer", Build.PRODUCT);
        contentValues.put("model", Build.MODEL);
        contentValues.put(PluginPayAdapter.KEY_DEVICE_INFO_SN, Build.SERIAL);
        contentValues.put("device_mac", Build.USER);
        contentValues.put("createTime", Long.valueOf(System.currentTimeMillis()));
        C2538c.b("Debug_HiHealthDBHelper", new Object[]{"initPhoneDeviceInfo values = ", contentValues});
        if (sQLiteDatabase.insert("hihealth_device", null, contentValues) <= 0) {
            C2538c.e("Debug_HiHealthDBHelper", new Object[]{"initPhoneDeviceInfo insert fail"});
        }
    }

    public void m23022a() {
        f17759b.lock();
        C4977l.m23911a(m23024c(), "BEGIN IMMEDIATE;");
    }

    public void m23023b() {
        C4977l.m23911a(m23024c(), "COMMIT;");
        f17759b.unlock();
    }

    public SQLiteDatabase m23024c() {
        SQLiteDatabase writableDatabase;
        synchronized (C4805a.class) {
            writableDatabase = super.getWritableDatabase(f17761d);
        }
        return writableDatabase;
    }

    private void m23021c(SQLiteDatabase sQLiteDatabase) {
        C2538c.c("Debug_HiHealthDBHelper", new Object[]{"upgradeVersionOne create table sample_session_core and user_preference"});
        C4977l.m23911a(sQLiteDatabase, ah.m23110a());
        C4977l.m23911a(sQLiteDatabase, ah.m23111d());
        C4977l.m23911a(sQLiteDatabase, "DROP TABLE  IF EXISTS user_preference");
        C4977l.m23911a(sQLiteDatabase, be.m23196a());
        C4977l.m23911a(sQLiteDatabase, be.m23197d());
        C2538c.c("Debug_HiHealthDBHelper", new Object[]{"upgradeVersionOne end"});
    }
}
