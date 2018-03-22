package com.amap.api.services.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DBOperation */
public class ai {
    private ah f12345a;
    private SQLiteDatabase f12346b;

    public ai(Context context) {
        this.f12345a = new ah(context, "logdb.db", null, 1);
    }

    private SQLiteDatabase m16640a() {
        this.f12346b = this.f12345a.getReadableDatabase();
        return this.f12346b;
    }

    private SQLiteDatabase m16641b() {
        this.f12346b = this.f12345a.getWritableDatabase();
        return this.f12346b;
    }

    public <T> void m16643a(String str, ap<T> apVar) {
        if (apVar.mo4107a() != null && str != null) {
            if (this.f12346b == null || this.f12346b.isReadOnly()) {
                this.f12346b = m16641b();
            }
            if (this.f12346b != null) {
                try {
                    this.f12346b.delete(apVar.mo4107a(), str, null);
                    if (this.f12346b != null) {
                        this.f12346b.close();
                        this.f12346b = null;
                    }
                } catch (Throwable th) {
                    if (this.f12346b != null) {
                        this.f12346b.close();
                        this.f12346b = null;
                    }
                }
            }
        }
    }

    public <T> void m16644b(String str, ap<T> apVar) {
        if (apVar != null && str != null && apVar.mo4107a() != null) {
            ContentValues b = apVar.mo4105b();
            if (b != null) {
                if (this.f12346b == null || this.f12346b.isReadOnly()) {
                    this.f12346b = m16641b();
                }
                if (this.f12346b != null) {
                    try {
                        this.f12346b.update(apVar.mo4107a(), b, str, null);
                        if (this.f12346b != null) {
                            this.f12346b.close();
                            this.f12346b = null;
                        }
                    } catch (Throwable th) {
                        if (this.f12346b != null) {
                            this.f12346b.close();
                            this.f12346b = null;
                        }
                    }
                }
            }
        }
    }

    public <T> void m16642a(ap<T> apVar) {
        if (apVar != null) {
            ContentValues b = apVar.mo4105b();
            if (b != null && apVar.mo4107a() != null) {
                if (this.f12346b == null || this.f12346b.isReadOnly()) {
                    this.f12346b = m16641b();
                }
                if (this.f12346b != null) {
                    try {
                        this.f12346b.insert(apVar.mo4107a(), null, b);
                        if (this.f12346b != null) {
                            this.f12346b.close();
                            this.f12346b = null;
                        }
                    } catch (Throwable th) {
                        if (this.f12346b != null) {
                            this.f12346b.close();
                            this.f12346b = null;
                        }
                    }
                }
            }
        }
    }

    public <T> List<T> m16645c(String str, ap<T> apVar) {
        Throwable th;
        List<T> arrayList = new ArrayList();
        if (this.f12346b == null) {
            this.f12346b = m16640a();
        }
        if (this.f12346b == null || apVar.mo4107a() == null || str == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = this.f12346b.query(apVar.mo4107a(), null, str, null, null, null, null);
            if (query == null) {
                try {
                    this.f12346b.close();
                    this.f12346b = null;
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            ay.m16709a(th2, "DataBase", "searchListData");
                            th2.printStackTrace();
                        }
                    }
                    try {
                        if (this.f12346b != null) {
                            this.f12346b.close();
                            this.f12346b = null;
                        }
                    } catch (Throwable th22) {
                        ay.m16709a(th22, "DataBase", "searchListData");
                        th22.printStackTrace();
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    th22 = th3;
                }
            } else {
                while (query.moveToNext()) {
                    arrayList.add(apVar.mo4106b(query));
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th222) {
                        ay.m16709a(th222, "DataBase", "searchListData");
                        th222.printStackTrace();
                    }
                }
                try {
                    if (this.f12346b != null) {
                        this.f12346b.close();
                        this.f12346b = null;
                    }
                } catch (Throwable th4) {
                    th222 = th4;
                    ay.m16709a(th222, "DataBase", "searchListData");
                    th222.printStackTrace();
                    return arrayList;
                }
                return arrayList;
            }
        } catch (Throwable th5) {
            th222 = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            if (this.f12346b != null) {
                this.f12346b.close();
                this.f12346b = null;
            }
            throw th222;
        }
    }
}
