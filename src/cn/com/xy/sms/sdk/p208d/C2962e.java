package cn.com.xy.sms.sdk.p208d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.com.xy.sms.sdk.p208d.p209a.C2918a;
import cn.com.xy.sms.sdk.p215g.C2982a;

public class C2962e {
    private SQLiteDatabase f10044a = null;
    private Cursor f10045b = null;
    private int f10046c = 0;

    public C2962e(SQLiteDatabase sQLiteDatabase, Cursor cursor, int i) {
        this.f10044a = sQLiteDatabase;
        this.f10045b = cursor;
        this.f10046c = i;
    }

    public static void m13322a(C2962e c2962e, boolean z) {
        if (c2962e != null) {
            try {
                if (c2962e.f10045b != null) {
                    c2962e.f10045b.close();
                }
            } catch (Throwable th) {
            }
            if (z) {
                try {
                    if (c2962e.f10044a != null) {
                        if (c2962e.f10046c == 0) {
                            C2922b.m13143a(c2962e.f10044a);
                        } else if (c2962e.f10046c == 1) {
                            C2918a.m13122a(c2962e.f10044a);
                        } else if (c2962e.f10046c == 2) {
                            C2964g.m13332a(c2962e.f10044a);
                        } else if (c2962e.f10046c == 3) {
                            C2966i.m13336a(c2962e.f10044a);
                        } else {
                            throw new Exception("unknown type:" + c2962e.f10046c);
                        }
                        c2962e.f10044a = null;
                    }
                } catch (Throwable th2) {
                    C2982a.m13415a("XIAOYUAN", "XyCursor close error:" + th2.getMessage(), th2);
                }
            }
        }
    }

    public int m13323a() {
        return this.f10045b != null ? this.f10045b.getCount() : 0;
    }

    public int m13324a(int i) {
        return this.f10045b != null ? this.f10045b.getInt(i) : 0;
    }

    public int m13325a(String str) {
        return this.f10045b != null ? this.f10045b.getColumnIndex(str) : -1;
    }

    public long m13326b(int i) {
        return this.f10045b != null ? this.f10045b.getLong(i) : 0;
    }

    public boolean m13327b() {
        return this.f10045b != null ? this.f10045b.moveToNext() : false;
    }

    public String m13328c(int i) {
        return this.f10045b != null ? this.f10045b.getString(i) : null;
    }
}
