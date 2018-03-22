package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import java.util.ArrayList;

/* compiled from: NotificationHistoryDB */
public class C1400p {
    public static final String f3140a;
    private static final String[] f3141e = new String[]{"_id", "huid", "deviceCode", "kidName", "type", HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, "operation", "data1", "data2", "data3", "data4", "data5"};
    private SQLiteDatabase f3142b;
    private C1393i f3143c;
    private Context f3144d;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table IF NOT EXISTS notificationhistory(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("huid NVARCHAR(300) not null,");
        stringBuilder.append("deviceCode NVARCHAR(300) not null,");
        stringBuilder.append("kidName NVARCHAR(300) not null,");
        stringBuilder.append("type integer not null,");
        stringBuilder.append("time NVARCHAR(300) not null,");
        stringBuilder.append("operation integer not null,");
        stringBuilder.append("data1 NVARCHAR(300),");
        stringBuilder.append("data2 NVARCHAR(300),");
        stringBuilder.append("data3 NVARCHAR(300),");
        stringBuilder.append("data4 NVARCHAR(300),");
        stringBuilder.append("data5 NVARCHAR(300)");
        stringBuilder.append(")");
        C2538c.m12674b("NotificationHistoryDB", "===createTableSQL", stringBuilder.toString());
        f3140a = stringBuilder.toString();
    }

    public C1400p(Context context) {
        this.f3143c = C1393i.m6319a(context);
        this.f3144d = context;
    }

    public void m6389a() {
        if (this.f3142b == null) {
            this.f3142b = this.f3143c.m6327a();
        }
    }

    public void m6390b() {
        this.f3143c.m6328b();
        this.f3142b = null;
    }

    public long m6387a(C1401q c1401q) {
        Object[] objArr;
        long insert;
        try {
            String j = C1392h.m6317j(this.f3144d, c1401q.f3148d);
            String j2 = C1392h.m6317j(this.f3144d, c1401q.f3152h);
            String j3 = C1392h.m6317j(this.f3144d, c1401q.f3153i);
            String j4 = C1392h.m6317j(this.f3144d, c1401q.f3154j);
            String j5 = C1392h.m6317j(this.f3144d, c1401q.f3155k);
            String j6 = C1392h.m6317j(this.f3144d, c1401q.f3156l);
            if (!C1392h.m6318k(this.f3144d, j).equals(c1401q.f3148d)) {
                C2538c.m12674b("NotificationHistoryDB", "======before encrypt--NotificationHistoryTable" + c1401q.f3148d);
                j = C1392h.m6317j(this.f3144d, c1401q.f3148d);
                j2 = C1392h.m6317j(this.f3144d, c1401q.f3152h);
                j3 = C1392h.m6317j(this.f3144d, c1401q.f3153i);
                j4 = C1392h.m6317j(this.f3144d, c1401q.f3154j);
                j5 = C1392h.m6317j(this.f3144d, c1401q.f3155k);
                j6 = C1392h.m6317j(this.f3144d, c1401q.f3156l);
            }
            m6389a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("huid", C1462f.m6744i());
            contentValues.put("deviceCode", c1401q.f3147c);
            contentValues.put("type", Integer.valueOf(c1401q.f3149e));
            contentValues.put("kidName", j);
            contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, c1401q.f3150f);
            contentValues.put("operation", Integer.valueOf(c1401q.f3151g));
            contentValues.put("data1", j2);
            contentValues.put("data2", j3);
            contentValues.put("data3", j4);
            contentValues.put("data4", j5);
            contentValues.put("data5", j6);
            insert = this.f3142b.insert("notificationhistory", null, contentValues);
            j3 = "NotificationHistoryDB";
            Object[] objArr2 = new Object[1];
            objArr2[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1401q + ", values=" + contentValues.toString();
            C2538c.m12674b(j3, objArr2);
            return insert;
        } catch (SQLiteException e) {
            objArr = new Object[1];
            insert = "insert() SQLiteException=" + e.getMessage();
            objArr[0] = insert;
            C2538c.m12680e("NotificationHistoryDB", objArr);
            return -1;
        } catch (Exception e2) {
            objArr = new Object[1];
            insert = "insert() Exception=" + e2.getMessage();
            objArr[0] = insert;
            C2538c.m12680e("NotificationHistoryDB", objArr);
            return -1;
        } finally {
            m6390b();
        }
    }

    public void m6391b(C1401q c1401q) {
        try {
            m6389a();
            String[] strArr = new String[]{String.valueOf(c1401q.f3145a)};
            C2538c.m12674b("NotificationHistoryDB", "================selection:", "_id= ?");
            Cursor query = this.f3142b.query("notificationhistory", f3141e, "_id= ?", strArr, null, null, null);
            if (query == null) {
                m6390b();
                return;
            }
            if (query.moveToFirst()) {
                c1401q.f3145a = query.getInt(query.getColumnIndex("_id"));
                c1401q.f3147c = query.getString(query.getColumnIndex("deviceCode"));
                c1401q.f3150f = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                c1401q.f3149e = query.getInt(query.getColumnIndex("type"));
                c1401q.f3151g = query.getInt(query.getColumnIndex("operation"));
                c1401q.f3148d = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("kidName")));
                c1401q.f3152h = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data1")));
                c1401q.f3153i = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data2")));
                c1401q.f3154j = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data3")));
                c1401q.f3155k = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data4")));
                c1401q.f3156l = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data5")));
            } else {
                c1401q = null;
            }
            if (c1401q != null) {
                C2538c.m12674b("NotificationHistoryDB", "selectByID db.query result=" + c1401q);
            }
            query.close();
            m6390b();
        } catch (Exception e) {
            C2538c.m12680e("NotificationHistoryDB", "select() Exception=" + e.getMessage());
        }
    }

    public void m6394c(C1401q c1401q) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        Exception e2;
        try {
            m6389a();
            String[] strArr = new String[]{c1401q.f3147c, String.valueOf(c1401q.f3149e), c1401q.f3150f};
            C2538c.m12674b("NotificationHistoryDB", "================selection:", "deviceCode like ? and type= ? and time like ?");
            query = this.f3142b.query("notificationhistory", f3141e, "deviceCode like ? and type= ? and time like ?", strArr, null, null, null);
            if (query == null) {
                try {
                    m6390b();
                    if (query != null) {
                        query.close();
                    }
                    m6390b();
                    return;
                } catch (SQLiteException e3) {
                    e = e3;
                    try {
                        C2538c.m12680e("NotificationHistoryDB", "select() SQLiteException=" + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        m6390b();
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        m6390b();
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    C2538c.m12680e("NotificationHistoryDB", "select() Exception=" + e2.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    m6390b();
                }
            }
            if (query.moveToFirst()) {
                c1401q.f3145a = query.getInt(query.getColumnIndex("_id"));
                c1401q.f3147c = query.getString(query.getColumnIndex("deviceCode"));
                c1401q.f3148d = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("kidName")));
                c1401q.f3150f = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                c1401q.f3149e = query.getInt(query.getColumnIndex("type"));
                c1401q.f3151g = query.getInt(query.getColumnIndex("operation"));
                c1401q.f3152h = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data1")));
                c1401q.f3153i = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data2")));
                c1401q.f3154j = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data3")));
                c1401q.f3155k = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data4")));
                c1401q.f3156l = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data5")));
            } else {
                c1401q = null;
            }
            if (c1401q != null) {
                C2538c.m12674b("NotificationHistoryDB", "select() result=" + c1401q);
            }
            if (query != null) {
                query.close();
            }
            m6390b();
        } catch (SQLiteException e5) {
            e = e5;
            query = null;
            C2538c.m12680e("NotificationHistoryDB", "select() SQLiteException=" + e.getMessage());
            if (query != null) {
                query.close();
            }
            m6390b();
        } catch (Exception e6) {
            e2 = e6;
            query = null;
            C2538c.m12680e("NotificationHistoryDB", "select() Exception=" + e2.getMessage());
            if (query != null) {
                query.close();
            }
            m6390b();
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            m6390b();
            throw th;
        }
    }

    public int m6395d(C1401q c1401q) {
        try {
            m6389a();
            ContentValues contentValues = new ContentValues();
            if (!"".equals(c1401q.f3146b)) {
                contentValues.put("huid", c1401q.f3146b);
            }
            if (!"".equals(c1401q.f3147c)) {
                contentValues.put("deviceCode", c1401q.f3147c);
            }
            if (!"".equals(c1401q.f3148d)) {
                contentValues.put("kidName", C1392h.m6317j(this.f3144d, c1401q.f3148d));
            }
            if (-1 != c1401q.f3149e) {
                contentValues.put("type", Integer.valueOf(c1401q.f3149e));
            }
            if (!"".equals(c1401q.f3150f)) {
                contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, c1401q.f3150f);
            }
            if (-1 != c1401q.f3151g) {
                contentValues.put("operation", Integer.valueOf(c1401q.f3151g));
            }
            if (!"".equals(c1401q.f3152h)) {
                contentValues.put("data1", C1392h.m6317j(this.f3144d, c1401q.f3152h));
            }
            if (!"".equals(c1401q.f3153i)) {
                contentValues.put("data2", C1392h.m6317j(this.f3144d, c1401q.f3153i));
            }
            if (!"".equals(c1401q.f3154j)) {
                contentValues.put("data3", C1392h.m6317j(this.f3144d, c1401q.f3154j));
            }
            if (!"".equals(c1401q.f3155k)) {
                contentValues.put("data4", C1392h.m6317j(this.f3144d, c1401q.f3155k));
            }
            if (!"".equals(c1401q.f3156l)) {
                contentValues.put("data5", C1392h.m6317j(this.f3144d, c1401q.f3156l));
            }
            int update = this.f3142b.update("notificationhistory", contentValues, "_id= ?", new String[]{String.valueOf(c1401q.f3145a)});
            String str = "NotificationHistoryDB";
            Object[] objArr = new Object[1];
            objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + c1401q + ", values=" + c1401q.toString();
            C2538c.m12674b(str, objArr);
            m6390b();
            return update;
        } catch (Exception e) {
            C2538c.m12680e("NotificationHistoryDB", "update() Exception=" + e.getMessage());
            return -1;
        }
    }

    public ArrayList<C1401q> m6388a(String str) {
        try {
            m6389a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("NotificationHistoryDB", "================selection:", "huid= ?");
            SQLiteDatabase sQLiteDatabase = this.f3142b;
            String str2 = "notificationhistory";
            String[] strArr2 = f3141e;
            Cursor query = sQLiteDatabase.query(str2, strArr2, "huid= ?", strArr, null, null, "time desc");
            if (query == null) {
                m6390b();
                return null;
            }
            ArrayList<C1401q> arrayList = new ArrayList();
            while (query.moveToNext()) {
                C1401q c1401q = new C1401q();
                c1401q.f3145a = query.getInt(query.getColumnIndex("_id"));
                c1401q.f3146b = query.getString(query.getColumnIndex("huid"));
                c1401q.f3147c = query.getString(query.getColumnIndex("deviceCode"));
                c1401q.f3149e = query.getInt(query.getColumnIndex("type"));
                c1401q.f3148d = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("kidName")));
                c1401q.f3150f = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                c1401q.f3151g = query.getInt(query.getColumnIndex("operation"));
                c1401q.f3152h = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data1")));
                c1401q.f3153i = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data2")));
                c1401q.f3154j = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data3")));
                c1401q.f3155k = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data4")));
                c1401q.f3156l = C1392h.m6318k(this.f3144d, query.getString(query.getColumnIndex("data5")));
                C2538c.m12674b("NotificationHistoryDB", "mod=" + c1401q);
                if (c1401q.f3148d == null || "".equals(c1401q.f3148d)) {
                    m6386a(c1401q.f3145a);
                } else {
                    arrayList.add(c1401q);
                    if (arrayList.size() > 1) {
                        c1401q = (C1401q) arrayList.get(arrayList.size() - 2);
                        C1401q c1401q2 = (C1401q) arrayList.get(arrayList.size() - 1);
                        if (c1401q2.f3150f.equals(c1401q.f3150f) && 1 == c1401q.f3149e && 2 == c1401q2.f3149e) {
                            arrayList.remove(arrayList.size() - 1);
                            arrayList.remove(arrayList.size() - 1);
                            arrayList.add(c1401q2);
                            arrayList.add(c1401q);
                        }
                    }
                }
            }
            query.close();
            m6390b();
            return arrayList;
        } catch (Exception e) {
            C2538c.m12680e("NotificationHistoryDB", "getAll() Exception=" + e.getMessage());
            return null;
        }
    }

    public boolean m6392b(String str) {
        try {
            m6389a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("NotificationHistoryDB", "================ delete all deviceinfo   sql:", "DELETE FROM notificationhistory Where deviceCode like ?");
            this.f3142b.execSQL("DELETE FROM notificationhistory Where deviceCode like ?", strArr);
            m6390b();
            return true;
        } catch (SQLException e) {
            C2538c.m12680e("NotificationHistoryDB", "deleteAll SQLException e = " + e.getMessage());
            return false;
        } catch (Exception e2) {
            C2538c.m12680e("NotificationHistoryDB", "deleteAll Exception e = " + e2.getMessage());
            return false;
        }
    }

    public void m6393c() {
        try {
            m6389a();
            C2538c.m12674b("NotificationHistoryDB", "================ delete all deviceinfo   sql:", "DELETE FROM notificationhistory");
            this.f3142b.execSQL("DELETE FROM notificationhistory");
            m6390b();
        } catch (SQLException e) {
            C2538c.m12680e("NotificationHistoryDB", "truncateDatabaseTable SQLException e = " + e.getMessage());
            m6390b();
        } catch (Exception e2) {
            C2538c.m12680e("NotificationHistoryDB", "truncateDatabaseTable Exception e = " + e2.getMessage());
            m6390b();
        }
    }

    private boolean m6386a(int i) {
        try {
            String[] strArr = new String[]{String.valueOf(i)};
            C2538c.m12674b("NotificationHistoryDB", "================ delete notificationhistory   sql:", "DELETE FROM notificationhistory Where _id = ?");
            this.f3142b.execSQL("DELETE FROM notificationhistory Where _id = ?", strArr);
            return true;
        } catch (SQLException e) {
            C2538c.m12680e("NotificationHistoryDB", "delete Exception e = " + e.getMessage());
            return false;
        } catch (Exception e2) {
            C2538c.m12680e("NotificationHistoryDB", "delete Exception e = " + e2.getMessage());
            return false;
        }
    }
}
