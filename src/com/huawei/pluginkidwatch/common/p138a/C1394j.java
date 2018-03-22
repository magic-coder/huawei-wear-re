package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.DeviceProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DeviceInfoDB */
public class C1394j {
    public static final String f3075a;
    private static final String[] f3076f = new String[]{"huid", "deviceCode", "name", "localUrl", "smallPortraitUrl", "middlePortraitUrl", "largePortraitUrl", "birthday", "height", "weight", "sex", "grade", "simCardNum", "btMac", "portraitImg", "portraitImgName", "primaryhuid", "portraitUrl", "data1", "data2", "data3", "data4", "data5"};
    private SQLiteDatabase f3077b;
    private C1393i f3078c;
    private Gson f3079d = new Gson();
    private Context f3080e;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS deviceinfo(");
        stringBuilder.append("huid NVARCHAR(300) not null,");
        stringBuilder.append("deviceCode NVARCHAR(100),");
        stringBuilder.append("name NVARCHAR(300) not null,");
        stringBuilder.append("localUrl NVARCHAR(300) not null ,");
        stringBuilder.append("smallPortraitUrl NVARCHAR(300) not null,");
        stringBuilder.append("middlePortraitUrl NVARCHAR(300) not null,");
        stringBuilder.append("largePortraitUrl NVARCHAR(300) not null,");
        stringBuilder.append("birthday NVARCHAR(100) not null,");
        stringBuilder.append("height NVARCHAR(100),");
        stringBuilder.append("weight NVARCHAR(100),");
        stringBuilder.append("sex NVARCHAR(100),");
        stringBuilder.append("grade NVARCHAR(100),");
        stringBuilder.append("simCardNum NVARCHAR(100),");
        stringBuilder.append("btMac NVARCHAR(100),");
        stringBuilder.append("portraitImg NVARCHAR(100),");
        stringBuilder.append("portraitImgName NVARCHAR(200),");
        stringBuilder.append("primaryhuid NVARCHAR(200),");
        stringBuilder.append("portraitUrl NVARCHAR(100),");
        stringBuilder.append("data1 NVARCHAR(100),");
        stringBuilder.append("data2 NVARCHAR(100),");
        stringBuilder.append("data3 NVARCHAR(100),");
        stringBuilder.append("data4 NVARCHAR(100),");
        stringBuilder.append("data5 NVARCHAR(100),");
        stringBuilder.append("primary key(huid,deviceCode)");
        stringBuilder.append(")");
        C2538c.m12674b("DeviceInfoDB", "===createTableSQL", stringBuilder.toString());
        f3075a = stringBuilder.toString();
    }

    public C1394j(Context context) {
        this.f3078c = C1393i.m6319a(context);
        this.f3080e = context;
    }

    public void m6333a() {
        if (this.f3077b == null) {
            this.f3077b = this.f3078c.m6327a();
        }
    }

    public void m6336b() {
        this.f3078c.m6328b();
        this.f3077b = null;
    }

    public long m6330a(C1395k c1395k) {
        long insert;
        Exception e;
        try {
            m6333a();
            ContentValues contentValues = new ContentValues();
            C2538c.m12674b("DeviceInfoDB", "============###", c1395k.f3081a);
            m6329a(c1395k, contentValues);
            insert = this.f3077b.insert("deviceinfo", null, contentValues);
            if (-1 == insert) {
                try {
                    C2538c.m12680e("DeviceInfoDB", "insert() failed");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C2538c.m12680e("DeviceInfoDB", "insert() Exception=" + e.getMessage());
                        return insert;
                    } finally {
                        m6336b();
                    }
                }
            }
            String str = "DeviceInfoDB";
            Object[] objArr = new Object[1];
            objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1395k + ", values=" + contentValues.toString();
            C2538c.m12674b(str, objArr);
            m6336b();
        } catch (Exception e3) {
            Exception exception = e3;
            insert = -1;
            e = exception;
            C2538c.m12680e("DeviceInfoDB", "insert() Exception=" + e.getMessage());
            return insert;
        }
        return insert;
    }

    private void m6329a(C1395k c1395k, ContentValues contentValues) {
        contentValues.put("huid", c1395k.f3081a);
        contentValues.put("deviceCode", this.f3079d.toJson(Integer.valueOf(c1395k.f3082b)));
        contentValues.put("name", C1392h.m6317j(this.f3080e, c1395k.f3083c));
        contentValues.put("localUrl", C1392h.m6317j(this.f3080e, c1395k.f3084d));
        contentValues.put("smallPortraitUrl", C1392h.m6317j(this.f3080e, c1395k.f3085e));
        contentValues.put("middlePortraitUrl", C1392h.m6317j(this.f3080e, c1395k.f3086f));
        contentValues.put("largePortraitUrl", C1392h.m6317j(this.f3080e, c1395k.f3087g));
        contentValues.put("birthday", C1392h.m6317j(this.f3080e, c1395k.f3088h));
        contentValues.put("height", C1392h.m6317j(this.f3080e, this.f3079d.toJson(Integer.valueOf(c1395k.f3089i))));
        contentValues.put("weight", C1392h.m6317j(this.f3080e, this.f3079d.toJson(Integer.valueOf(c1395k.f3090j))));
        contentValues.put("sex", C1392h.m6317j(this.f3080e, this.f3079d.toJson(Integer.valueOf(c1395k.f3091k))));
        contentValues.put("grade", C1392h.m6317j(this.f3080e, this.f3079d.toJson(Integer.valueOf(c1395k.f3092l))));
        contentValues.put("simCardNum", C1392h.m6317j(this.f3080e, c1395k.f3093m));
        contentValues.put("btMac", C1392h.m6317j(this.f3080e, c1395k.f3096p));
        contentValues.put("portraitImg", C1392h.m6317j(this.f3080e, c1395k.f3094n));
        contentValues.put("portraitImgName", C1392h.m6317j(this.f3080e, c1395k.f3095o));
        contentValues.put("primaryhuid", C1392h.m6317j(this.f3080e, c1395k.f3097q));
        contentValues.put("portraitUrl", C1392h.m6317j(this.f3080e, c1395k.f3098r));
        contentValues.put("data1", C1392h.m6317j(this.f3080e, c1395k.f3099s));
        contentValues.put("data2", C1392h.m6317j(this.f3080e, c1395k.f3100t));
        contentValues.put("data3", C1392h.m6317j(this.f3080e, c1395k.f3101u));
        contentValues.put("data4", C1392h.m6317j(this.f3080e, c1395k.f3102v));
        contentValues.put("data5", C1392h.m6317j(this.f3080e, c1395k.f3103w));
    }

    public int m6335b(C1395k c1395k) {
        try {
            m6333a();
            ContentValues contentValues = new ContentValues();
            m6329a(c1395k, contentValues);
            int update = this.f3077b.update("deviceinfo", contentValues, "deviceCode= ? and huid= ?", new String[]{this.f3079d.toJson(Integer.valueOf(c1395k.f3082b)), c1395k.f3081a});
            if (update == 0) {
                C2538c.m12680e("DeviceInfoDB", "update() failed");
            }
            String str = "DeviceInfoDB";
            Object[] objArr = new Object[1];
            objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + c1395k + ", values=" + c1395k.toString();
            C2538c.m12674b(str, objArr);
            m6336b();
            return update;
        } catch (JsonIOException e) {
            C2538c.m12680e("DeviceInfoDB", "update() Exception=" + e.getMessage());
            return -1;
        }
    }

    public C1395k m6331a(String str, int i) {
        Cursor query;
        Exception e;
        Throwable th;
        try {
            m6333a();
            String[] strArr = new String[]{this.f3079d.toJson(Integer.valueOf(i)), str};
            query = this.f3077b.query("deviceinfo", f3076f, "deviceCode= ? and huid like ?", strArr, null, null, null);
            if (query == null) {
                try {
                    m6336b();
                    if (query != null) {
                        query.close();
                    }
                    m6336b();
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C2538c.m12680e("DeviceInfoDB", "get() Exception=" + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        m6336b();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        m6336b();
                        throw th;
                    }
                }
            }
            C1395k c1395k;
            if (query.moveToFirst()) {
                C1395k c1395k2 = new C1395k();
                C2538c.m12674b("DeviceInfoDB", "================Column_DeviceCode：" + query.getString(query.getColumnIndex("deviceCode")));
                c1395k2.f3082b = ((Integer) this.f3079d.fromJson(query.getString(query.getColumnIndex("deviceCode")), Integer.class)).intValue();
                c1395k2.f3081a = query.getString(query.getColumnIndex("huid"));
                c1395k2.f3083c = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("name")));
                c1395k2.f3084d = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("localUrl")));
                c1395k2.f3085e = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("smallPortraitUrl")));
                c1395k2.f3086f = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("middlePortraitUrl")));
                c1395k2.f3087g = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("largePortraitUrl")));
                c1395k2.f3088h = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("birthday")));
                c1395k2.f3089i = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("height"))), Integer.class)).intValue();
                c1395k2.f3090j = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("weight"))), Integer.class)).intValue();
                c1395k2.f3091k = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("sex"))), Integer.class)).intValue();
                c1395k2.f3092l = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("grade"))), Integer.class)).intValue();
                c1395k2.f3093m = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("simCardNum")));
                c1395k2.f3096p = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("btMac")));
                c1395k2.f3094n = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("portraitImg")));
                c1395k2.f3095o = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("portraitImgName")));
                c1395k2.f3097q = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("primaryhuid")));
                c1395k2.f3098r = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("portraitUrl")));
                c1395k2.f3099s = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data1")));
                c1395k2.f3100t = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data2")));
                c1395k2.f3101u = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data3")));
                c1395k2.f3102v = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data4")));
                c1395k2.f3103w = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data5")));
                c1395k = c1395k2;
            } else {
                c1395k = null;
            }
            if (c1395k != null) {
                C2538c.m12674b("DeviceInfoDB", "result=" + c1395k);
            }
            if (query != null) {
                query.close();
            }
            m6336b();
            return c1395k;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C2538c.m12680e("DeviceInfoDB", "get() Exception=" + e.getMessage());
            if (query != null) {
                query.close();
            }
            m6336b();
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            m6336b();
            throw th;
        }
    }

    public ArrayList<C1395k> m6332a(String str) {
        Exception e;
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            m6333a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("DeviceInfoDB", "================selection:", "huid like ?");
            query = this.f3077b.query("deviceinfo", f3076f, "huid like ?", strArr, null, null, null);
            if (query == null) {
                try {
                    m6336b();
                    if (query != null) {
                        query.close();
                    }
                    m6336b();
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        m6337b(str);
                        if (this.f3080e == null) {
                            C2538c.m12680e("DeviceInfoDB", "mContext is null");
                        } else {
                            LocalBroadcastManager.getInstance(this.f3080e).sendBroadcast(new Intent("com.huawei.kone.broadcast.get.bind.device"));
                        }
                    } catch (Exception e3) {
                        C2538c.m12680e("DeviceInfoDB", "Exception e1 = " + e3.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        m6336b();
                        throw th;
                    }
                    C2538c.m12680e("DeviceInfoDB", "error happened ,so return null。 getAll() Exception=" + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    m6336b();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    m6336b();
                    throw th;
                }
            }
            ArrayList<C1395k> arrayList = new ArrayList();
            C2538c.m12674b("DeviceInfoDB", "================cursor.getCount():", query.getCount() + "");
            while (query.moveToNext()) {
                C1395k c1395k = new C1395k();
                c1395k.f3082b = ((Integer) this.f3079d.fromJson(query.getString(query.getColumnIndex("deviceCode")), Integer.class)).intValue();
                c1395k.f3081a = query.getString(query.getColumnIndex("huid"));
                c1395k.f3083c = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("name")));
                c1395k.f3084d = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("localUrl")));
                c1395k.f3085e = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("smallPortraitUrl")));
                c1395k.f3086f = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("middlePortraitUrl")));
                c1395k.f3087g = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("largePortraitUrl")));
                c1395k.f3088h = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("birthday")));
                c1395k.f3089i = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("height"))), Integer.class)).intValue();
                c1395k.f3090j = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("weight"))), Integer.class)).intValue();
                c1395k.f3091k = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("sex"))), Integer.class)).intValue();
                c1395k.f3092l = ((Integer) this.f3079d.fromJson(C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("grade"))), Integer.class)).intValue();
                c1395k.f3093m = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("simCardNum")));
                c1395k.f3096p = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("btMac")));
                c1395k.f3094n = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("portraitImg")));
                c1395k.f3095o = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("portraitImgName")));
                c1395k.f3097q = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("primaryhuid")));
                c1395k.f3098r = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("portraitUrl")));
                c1395k.f3099s = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data1")));
                c1395k.f3100t = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data2")));
                c1395k.f3101u = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data3")));
                c1395k.f3102v = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data4")));
                c1395k.f3103w = C1392h.m6318k(this.f3080e, query.getString(query.getColumnIndex("data5")));
                arrayList.add(c1395k);
            }
            if (query != null) {
                query.close();
            }
            m6336b();
            return arrayList;
        } catch (Exception e4) {
            e = e4;
            cursor = null;
            m6337b(str);
            if (this.f3080e == null) {
                LocalBroadcastManager.getInstance(this.f3080e).sendBroadcast(new Intent("com.huawei.kone.broadcast.get.bind.device"));
            } else {
                C2538c.m12680e("DeviceInfoDB", "mContext is null");
            }
            C2538c.m12680e("DeviceInfoDB", "error happened ,so return null。 getAll() Exception=" + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            m6336b();
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            m6336b();
            throw th;
        }
    }

    public boolean m6337b(String str) {
        boolean z = true;
        try {
            m6333a();
            String[] strArr = new String[]{str};
            C2538c.m12674b("DeviceInfoDB", "================ delete all deviceinfo   sql:", "DELETE FROM deviceinfo Where huid like ?");
            this.f3077b.execSQL("DELETE FROM deviceinfo Where huid like ?", strArr);
            return z;
        } catch (Exception e) {
            Object[] objArr = new Object[1];
            z = "Exception e = " + e.getMessage();
            objArr[0] = z;
            C2538c.m12680e("DeviceInfoDB", objArr);
            return false;
        } finally {
            m6336b();
        }
    }

    public boolean m6338b(String str, int i) {
        Object[] objArr;
        boolean z = true;
        try {
            m6333a();
            String[] strArr = new String[]{String.valueOf(i), str};
            C2538c.m12674b("DeviceInfoDB", "================ delete all deviceinfo   sql:", "DELETE FROM deviceinfo Where deviceCode = ? and huid like ?");
            this.f3077b.execSQL("DELETE FROM deviceinfo Where deviceCode = ? and huid like ?", strArr);
            return z;
        } catch (SQLException e) {
            objArr = new Object[1];
            z = "deleteById SQLException e = " + e.getMessage();
            objArr[0] = z;
            C2538c.m12680e("DeviceInfoDB", objArr);
            return false;
        } catch (Exception e2) {
            objArr = new Object[1];
            z = "Exception e = " + e2.getMessage();
            objArr[0] = z;
            C2538c.m12680e("DeviceInfoDB", objArr);
            return false;
        } finally {
            m6336b();
        }
    }

    public void m6334a(String str, List<DeviceProfile> list) {
        if (list == null || list.size() < 1) {
            C2538c.m12674b("DeviceInfoDB", "null == list");
            return;
        }
        try {
            ArrayList a = m6332a(str);
            if (a != null && a.size() > 1) {
                C2538c.m12674b("DeviceInfoDB", "============数据库中原有该用户绑定的设备个数：" + a.size());
                C2538c.m12674b("DeviceInfoDB", "============本次从云端获取的数据个数：" + list.size());
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    int i;
                    C1395k c1395k = (C1395k) it.next();
                    for (DeviceProfile deviceProfile : list) {
                        if (deviceProfile.deviceCode == c1395k.f3082b) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        m6338b(str, c1395k.f3082b);
                        C2538c.m12674b("DeviceInfoDB", "============delete useless device info from db,devicecode:", str, c1395k.f3082b + "");
                    }
                }
            }
        } catch (SQLException e) {
            C2538c.m12680e("DeviceInfoDB", "Exception e = " + e.getMessage());
        }
    }
}
