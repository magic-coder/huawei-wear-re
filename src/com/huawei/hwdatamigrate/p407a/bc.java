package com.huawei.hwdatamigrate.p407a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: UserIDDB */
public class bc {
    public static final String f17551a;
    private static final String[] f17552d = new String[]{"_id", "userid"};
    private SQLiteDatabase f17553b;
    private C4780m f17554c;
    private final Object f17555e = new Object();

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS userid(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null");
        stringBuilder.append(")");
        f17551a = stringBuilder.toString();
    }

    public bc(Context context) {
        this.f17554c = C4780m.m22870a(context);
    }

    private void m22831d() {
        if (this.f17553b == null) {
            C2538c.c("UserIDDB", new Object[]{"Enter open db is null"});
            this.f17553b = this.f17554c.m22886a();
            if (this.f17553b == null) {
                C2538c.c("UserIDDB", new Object[]{"Enter open db is still null"});
                return;
            }
            C2538c.c("UserIDDB", new Object[]{"Enter open db is not still null"});
            return;
        }
        C2538c.c("UserIDDB", new Object[]{"Enter open db is not null"});
    }

    private void m22832e() {
        C2538c.c("UserIDDB", new Object[]{"Enter close"});
        if (this.f17554c != null) {
            this.f17554c.m22888b();
        }
        this.f17553b = null;
    }

    public long m22833a(bd bdVar) {
        long insert;
        Exception e;
        synchronized (this.f17555e) {
            C4775h.m22860a(null);
            m22831d();
            ContentValues contentValues = new ContentValues();
            contentValues.put("userid", bdVar.f17557b);
            try {
                this.f17553b.beginTransaction();
                insert = this.f17553b.insert("userid", null, contentValues);
                if (-1 == insert) {
                    try {
                        C2538c.e("UserIDDB", new Object[]{"insert() failed"});
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C2538c.e("UserIDDB", new Object[]{"insert() Exception=" + e.getMessage()});
                            if (this.f17553b != null) {
                                this.f17553b.endTransaction();
                            }
                            m22832e();
                            return insert;
                        } catch (Throwable th) {
                            if (this.f17553b != null) {
                                this.f17553b.endTransaction();
                            }
                            m22832e();
                        }
                    }
                }
                C2538c.b("UserIDDB", new Object[]{"insert() success count=" + insert});
                this.f17553b.setTransactionSuccessful();
                if (this.f17553b != null) {
                    this.f17553b.endTransaction();
                }
                m22832e();
            } catch (Exception e3) {
                e = e3;
                insert = -1;
                C2538c.e("UserIDDB", new Object[]{"insert() Exception=" + e.getMessage()});
                if (this.f17553b != null) {
                    this.f17553b.endTransaction();
                }
                m22832e();
                return insert;
            }
        }
        return insert;
    }

    public int m22835b(bd bdVar) {
        C4775h.m22860a(null);
        try {
            m22831d();
            ContentValues contentValues = new ContentValues();
            contentValues.put("userid", bdVar.f17557b);
            String[] strArr = new String[]{String.valueOf(bdVar.f17556a)};
            int update = this.f17553b.update("userid", contentValues, "_id= ?", strArr);
            if (update == 0) {
                C2538c.e("UserIDDB", new Object[]{"UserIDDB update() failed"});
            }
            m22832e();
            return update;
        } catch (Exception e) {
            C2538c.e("UserIDDB", new Object[]{"UserIDDB update() Exception=" + e.getMessage()});
            return -1;
        }
    }

    public bd m22834a() {
        try {
            m22831d();
            this.f17553b.beginTransaction();
            Cursor query = this.f17553b.query("userid", f17552d, null, null, null, null, null);
            this.f17553b.setTransactionSuccessful();
            if (query == null) {
                C2538c.b("UserIDDB", new Object[]{"log getFirst()= finally close db"});
                if (this.f17553b != null) {
                    this.f17553b.endTransaction();
                }
                m22832e();
                return null;
            }
            bd bdVar;
            if (query.moveToNext()) {
                bdVar = new bd();
                bdVar.f17556a = query.getInt(query.getColumnIndex("_id"));
                bdVar.f17557b = query.getString(query.getColumnIndex("userid"));
            } else {
                bdVar = null;
            }
            query.close();
            C2538c.b("UserIDDB", new Object[]{"log getFirst()= finally close db"});
            if (this.f17553b != null) {
                this.f17553b.endTransaction();
            }
            m22832e();
            return bdVar;
        } catch (Exception e) {
            C2538c.e("UserIDDB", new Object[]{"getFirst() Exception=" + e.getMessage()});
            C2538c.b("UserIDDB", new Object[]{"log getFirst()= finally close db"});
            if (this.f17553b != null) {
                this.f17553b.endTransaction();
            }
            m22832e();
            return null;
        } catch (Throwable th) {
            C2538c.b("UserIDDB", new Object[]{"log getFirst()= finally close db"});
            if (this.f17553b != null) {
                this.f17553b.endTransaction();
            }
            m22832e();
        }
    }

    public ArrayList<String> m22836b() {
        ArrayList<String> arrayList = new ArrayList();
        try {
            m22831d();
            this.f17553b.beginTransaction();
            Cursor query = this.f17553b.query("userid", f17552d, null, null, null, null, null);
            this.f17553b.setTransactionSuccessful();
            if (query == null) {
                C2538c.b("UserIDDB", new Object[]{"UserIDDB get15HuidList()= finally close db"});
                if (this.f17553b != null) {
                    this.f17553b.endTransaction();
                }
                m22832e();
                return null;
            }
            while (query.moveToNext()) {
                arrayList.add(query.getString(query.getColumnIndex("userid")));
            }
            query.close();
            C2538c.b("UserIDDB", new Object[]{"UserIDDB get15HuidList()= finally close db"});
            if (this.f17553b != null) {
                this.f17553b.endTransaction();
            }
            m22832e();
            return arrayList;
        } catch (Exception e) {
            C2538c.e("UserIDDB", new Object[]{"UserIDDB get15HuidList() Exception=" + e.getMessage()});
            C2538c.b("UserIDDB", new Object[]{"UserIDDB get15HuidList()= finally close db"});
            if (this.f17553b != null) {
                this.f17553b.endTransaction();
            }
            m22832e();
        } catch (Throwable th) {
            C2538c.b("UserIDDB", new Object[]{"UserIDDB get15HuidList()= finally close db"});
            if (this.f17553b != null) {
                this.f17553b.endTransaction();
            }
            m22832e();
        }
    }

    public void m22837c() {
        C4775h.m22860a(null);
        bd bdVar = new bd();
        bdVar.f17556a = -1;
        bdVar.f17557b = "default_userid";
        if (-1 == m22833a(bdVar)) {
            C2538c.e("UserIDDB", new Object[]{"init() error"});
            return;
        }
        C2538c.b("UserIDDB", new Object[]{"init() ok"});
    }
}
