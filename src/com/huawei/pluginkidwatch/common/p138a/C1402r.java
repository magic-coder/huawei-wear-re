package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBConstants;

/* compiled from: PushAbilityDB */
public class C1402r {
    public static final String f3157a;
    private static final String[] f3158d = new String[]{"_id", "kitwatch", WBConstants.ACTION_LOG_TYPE_MESSAGE};
    private SQLiteDatabase f3159b;
    private C1393i f3160c;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS pushAbility(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("kitwatch INT,");
        stringBuilder.append("message INT");
        stringBuilder.append(")");
        f3157a = stringBuilder.toString();
    }

    public C1402r(Context context) {
        this.f3160c = C1393i.m6319a(context);
    }

    public void m6397a() {
        if (this.f3159b == null) {
            this.f3159b = this.f3160c.m6327a();
        }
    }

    public void m6398b() {
        this.f3160c.m6328b();
        this.f3159b = null;
    }

    public long m6396a(C1403s c1403s) {
        long insert;
        Object[] objArr;
        try {
            m6397a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("kitwatch", Integer.valueOf(c1403s.m6400a()));
            contentValues.put(WBConstants.ACTION_LOG_TYPE_MESSAGE, Integer.valueOf(c1403s.m6402b()));
            insert = this.f3159b.insert("pushAbility", null, contentValues);
            if (-1 == insert) {
                C2538c.m12680e("PushAbilityDB", "insert() failed");
            }
            String str = "PushAbilityDB";
            Object[] objArr2 = new Object[1];
            objArr2[0] = "insert() result = " + (-1 == insert ? "failed" : "succeed") + ", table = " + c1403s + ", values = " + contentValues.toString();
            C2538c.m12674b(str, objArr2);
            return insert;
        } catch (SQLiteException e) {
            objArr = new Object[1];
            insert = "insert() SQLiteException=" + e.getMessage();
            objArr[0] = insert;
            C2538c.m12680e("PushAbilityDB", objArr);
            return -1;
        } catch (Exception e2) {
            objArr = new Object[1];
            insert = "insert() Exception=" + e2.getMessage();
            objArr[0] = insert;
            C2538c.m12680e("PushAbilityDB", objArr);
            return -1;
        } finally {
            m6398b();
        }
    }

    public C1403s m6399c() {
        Cursor query;
        SQLiteException e;
        Throwable th;
        Exception e2;
        C1403s c1403s = new C1403s();
        try {
            m6397a();
            query = this.f3159b.query("pushAbility", f3158d, null, null, null, null, null);
            if (query == null) {
                try {
                    m6398b();
                    if (query != null) {
                        query.close();
                    }
                    m6398b();
                    return c1403s;
                } catch (SQLiteException e3) {
                    e = e3;
                    try {
                        C2538c.m12680e("PushAbilityDB", "get() SQLiteException = " + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        m6398b();
                        return c1403s;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        m6398b();
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    C2538c.m12680e("PushAbilityDB", "get() Exception = " + e2.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    m6398b();
                    return c1403s;
                }
            }
            C1403s c1403s2 = new C1403s();
            if (query.moveToFirst()) {
                c1403s2.m6401a(query.getInt(query.getColumnIndex("kitwatch")));
                c1403s2.m6403b(query.getInt(query.getColumnIndex(WBConstants.ACTION_LOG_TYPE_MESSAGE)));
            }
            if (query != null) {
                query.close();
            }
            m6398b();
            return c1403s2;
        } catch (SQLiteException e5) {
            e = e5;
            query = null;
            C2538c.m12680e("PushAbilityDB", "get() SQLiteException = " + e.getMessage());
            if (query != null) {
                query.close();
            }
            m6398b();
            return c1403s;
        } catch (Exception e6) {
            e2 = e6;
            query = null;
            C2538c.m12680e("PushAbilityDB", "get() Exception = " + e2.getMessage());
            if (query != null) {
                query.close();
            }
            m6398b();
            return c1403s;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            m6398b();
            throw th;
        }
    }
}
