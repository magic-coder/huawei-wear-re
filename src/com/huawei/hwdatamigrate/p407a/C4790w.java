package com.huawei.hwdatamigrate.p407a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.p190v.C2538c;

/* compiled from: InternalStorageDB */
public class C4790w {
    public static final String f17710a;
    private static final String[] f17711d = new String[]{"_id", SMSKeyInfo.TAG_KEY, "value"};
    private SQLiteDatabase f17712b;
    private C4780m f17713c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS internalstorage(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("key NVARCHAR(300) not null,");
        stringBuilder.append("value NVARCHAR(300) not null");
        stringBuilder.append(")");
        f17710a = stringBuilder.toString();
    }

    public C4790w(Context context) {
        this.f17713c = C4780m.m22870a(context);
    }

    public void m22915a() {
        if (this.f17712b == null) {
            this.f17712b = this.f17713c.m22886a();
        }
    }

    public void m22918b() {
        this.f17713c.m22888b();
        this.f17712b = null;
    }

    public long m22913a(C4791x c4791x) {
        try {
            m22915a();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SMSKeyInfo.TAG_KEY, c4791x.f17715b);
            contentValues.put("value", c4791x.f17716c);
            long insert = this.f17712b.insert("internalstorage", null, contentValues);
            if (-1 == insert) {
                C2538c.e("InternalStorageDB", new Object[]{"insert() failed"});
            }
            m22918b();
            return insert;
        } catch (Exception e) {
            C2538c.e("InternalStorageDB", new Object[]{"insert() Exception=" + e.getMessage()});
            return -1;
        }
    }

    public int m22916b(C4791x c4791x) {
        try {
            m22915a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", c4791x.f17716c);
            String[] strArr = new String[]{c4791x.f17715b};
            int update = this.f17712b.update("internalstorage", contentValues, "key= ?", strArr);
            if (update == 0) {
                C2538c.e("InternalStorageDB", new Object[]{"update() failed"});
            }
            m22918b();
            return update;
        } catch (Exception e) {
            C2538c.e("InternalStorageDB", new Object[]{"update() Exception=" + e.getMessage()});
            return -1;
        }
    }

    public C4791x m22914a(String str) {
        try {
            m22915a();
            String[] strArr = new String[]{str};
            Cursor query = this.f17712b.query("internalstorage", f17711d, "key= ?", strArr, null, null, null);
            if (query == null) {
                m22918b();
                return null;
            }
            C4791x c4791x;
            if (query.moveToFirst()) {
                c4791x = new C4791x();
                c4791x.f17714a = query.getInt(query.getColumnIndex("_id"));
                c4791x.f17715b = query.getString(query.getColumnIndex(SMSKeyInfo.TAG_KEY));
                c4791x.f17716c = query.getString(query.getColumnIndex("value"));
            } else {
                c4791x = null;
            }
            query.close();
            m22918b();
            return c4791x;
        } catch (Exception e) {
            C2538c.e("InternalStorageDB", new Object[]{"get() Exception=" + e.getMessage()});
            return null;
        }
    }

    public Boolean m22917b(String str) {
        try {
            m22915a();
            String[] strArr = new String[]{str};
            Cursor query = this.f17712b.query("internalstorage", f17711d, "key= ?", strArr, null, null, null);
            if (query == null) {
                m22918b();
                return Boolean.valueOf(false);
            } else if (query.getCount() == 0) {
                query.close();
                m22918b();
                return Boolean.valueOf(false);
            } else {
                query.close();
                m22918b();
                return Boolean.valueOf(true);
            }
        } catch (Exception e) {
            C2538c.e("InternalStorageDB", new Object[]{"getOne() Exception=" + e.getMessage()});
            return Boolean.valueOf(false);
        }
    }
}
