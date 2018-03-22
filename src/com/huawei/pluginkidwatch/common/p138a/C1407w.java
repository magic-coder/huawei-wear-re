package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.Gson;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.ArrayList;

/* compiled from: TrackInfoDB */
public class C1407w {
    public static final String f3181a;
    private static final String[] f3182f = new String[]{"deviceCode", "date", HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, "lon", "lat", "name", "radius", "buildingname", "streetname", LogBuilder.KEY_END_TIME, "elev", "hacc", "type", "data1", "data2", "data3", "data4", "data5"};
    private SQLiteDatabase f3183b;
    private C1393i f3184c;
    private Gson f3185d = new Gson();
    private Context f3186e;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table IF NOT EXISTS trackinfo(");
        stringBuilder.append("deviceCode NVARCHAR(300) not null,");
        stringBuilder.append("date NVARCHAR(300) not null,");
        stringBuilder.append("time NVARCHAR(300) not null,");
        stringBuilder.append("lon NVARCHAR(300),");
        stringBuilder.append("lat NVARCHAR(300),");
        stringBuilder.append("name NVARCHAR(300),");
        stringBuilder.append("radius NVARCHAR(300),");
        stringBuilder.append("buildingname NVARCHAR(300),");
        stringBuilder.append("streetname NVARCHAR(300),");
        stringBuilder.append("endtime NVARCHAR(300),");
        stringBuilder.append("elev NVARCHAR(300),");
        stringBuilder.append("hacc NVARCHAR(300),");
        stringBuilder.append("type NVARCHAR(300),");
        stringBuilder.append("data1 NVARCHAR(300),");
        stringBuilder.append("data2 NVARCHAR(300),");
        stringBuilder.append("data3 NVARCHAR(300),");
        stringBuilder.append("data4 NVARCHAR(300),");
        stringBuilder.append("data5 NVARCHAR(300),");
        stringBuilder.append(" primary key(deviceCode,time)");
        stringBuilder.append(")");
        C2538c.m12674b("TrackInfoDB", "===createTableSQL", stringBuilder.toString());
        f3181a = stringBuilder.toString();
    }

    public C1407w(Context context) {
        this.f3184c = C1393i.m6319a(context);
        this.f3186e = context;
    }

    public void m6435a() {
        if (this.f3183b == null) {
            this.f3183b = this.f3184c.m6327a();
        }
    }

    public void m6437b() {
        this.f3184c.m6328b();
        this.f3183b = null;
    }

    public long m6433a(C1408x c1408x) {
        try {
            m6435a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("deviceCode", Integer.valueOf(c1408x.f3190d));
            contentValues.put("date", c1408x.f3187a);
            contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, c1408x.f3188b);
            contentValues.put("lon", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3189c))));
            contentValues.put("lat", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3191e))));
            contentValues.put("name", C1392h.m6317j(this.f3186e, c1408x.f3194h));
            contentValues.put("radius", C1392h.m6317j(this.f3186e, c1408x.f3195i));
            contentValues.put("buildingname", C1392h.m6317j(this.f3186e, c1408x.f3197k));
            contentValues.put("streetname", C1392h.m6317j(this.f3186e, c1408x.f3198l));
            contentValues.put(LogBuilder.KEY_END_TIME, C1392h.m6317j(this.f3186e, c1408x.f3199m));
            contentValues.put("elev", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3192f))));
            contentValues.put("hacc", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3193g))));
            contentValues.put("type", C1392h.m6317j(this.f3186e, c1408x.f3196j));
            contentValues.put("data1", C1392h.m6317j(this.f3186e, c1408x.f3200n));
            contentValues.put("data2", C1392h.m6317j(this.f3186e, c1408x.f3201o));
            contentValues.put("data3", C1392h.m6317j(this.f3186e, c1408x.f3202p));
            contentValues.put("data4", C1392h.m6317j(this.f3186e, c1408x.f3203q));
            contentValues.put("data5", C1392h.m6317j(this.f3186e, c1408x.f3204r));
            long insert = this.f3183b.insert("trackinfo", null, contentValues);
            if (-1 == insert) {
                m6432d(c1408x);
                C2538c.m12680e("TrackInfoDB", "insert() failed");
            }
            String str = "TrackInfoDB";
            Object[] objArr = new Object[1];
            objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + c1408x + ", values=" + contentValues.toString();
            C2538c.m12674b(str, objArr);
            m6437b();
            return insert;
        } catch (Exception e) {
            C2538c.m12680e("TrackInfoDB", "insert() Exception=" + e.getMessage());
            return -1;
        }
    }

    public void m6438b(C1408x c1408x) {
        Exception e;
        Cursor query;
        try {
            m6435a();
            String[] strArr = new String[]{String.valueOf(c1408x.f3190d), c1408x.f3188b};
            C2538c.m12674b("TrackInfoDB", "================selection:", "deviceCode= ? and time like ?");
            query = this.f3183b.query("trackinfo", f3182f, "deviceCode= ? and time like ?", strArr, null, null, null);
            if (query == null) {
                try {
                    m6437b();
                    return;
                } catch (Exception e2) {
                    e = e2;
                    C2538c.m12680e("TrackInfoDB", "select() Exception=" + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    m6437b();
                }
            }
            Object obj;
            if (query.moveToFirst()) {
                c1408x.f3190d = query.getInt(query.getColumnIndex("deviceCode"));
                c1408x.f3187a = query.getString(query.getColumnIndex("date"));
                c1408x.f3188b = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                c1408x.f3189c = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("lon"))), Double.class)).doubleValue();
                c1408x.f3191e = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("lat"))), Double.class)).doubleValue();
                c1408x.f3194h = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("name")));
                c1408x.f3195i = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("radius")));
                c1408x.f3197k = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("buildingname")));
                c1408x.f3198l = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("streetname")));
                c1408x.f3199m = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex(LogBuilder.KEY_END_TIME)));
                c1408x.f3192f = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("elev"))), Double.class)).doubleValue();
                c1408x.f3193g = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("hacc"))), Double.class)).doubleValue();
                c1408x.f3196j = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("type")));
                c1408x.f3200n = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data1")));
                c1408x.f3201o = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data2")));
                c1408x.f3202p = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data3")));
                c1408x.f3203q = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data4")));
                c1408x.f3204r = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data5")));
                obj = c1408x;
            } else {
                obj = null;
            }
            String str = "TrackInfoDB";
            Object[] objArr = new Object[1];
            StringBuilder append = new StringBuilder().append("select() result=");
            if (obj == null) {
                obj = "null";
            }
            objArr[0] = append.append(obj).toString();
            C2538c.m12674b(str, objArr);
            query.close();
            m6437b();
        } catch (Exception e3) {
            e = e3;
            query = null;
            C2538c.m12680e("TrackInfoDB", "select() Exception=" + e.getMessage());
            if (query != null) {
                query.close();
            }
            m6437b();
        }
    }

    private int m6432d(C1408x c1408x) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("deviceCode", Integer.valueOf(c1408x.f3190d));
            contentValues.put("date", c1408x.f3187a);
            contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, c1408x.f3188b);
            contentValues.put("lon", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3189c))));
            contentValues.put("lat", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3191e))));
            contentValues.put("name", C1392h.m6317j(this.f3186e, c1408x.f3194h));
            contentValues.put("radius", C1392h.m6317j(this.f3186e, c1408x.f3195i));
            contentValues.put("buildingname", C1392h.m6317j(this.f3186e, c1408x.f3197k));
            contentValues.put("streetname", C1392h.m6317j(this.f3186e, c1408x.f3198l));
            contentValues.put(LogBuilder.KEY_END_TIME, C1392h.m6317j(this.f3186e, c1408x.f3199m));
            contentValues.put("elev", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3192f))));
            contentValues.put("hacc", C1392h.m6317j(this.f3186e, this.f3185d.toJson(Double.valueOf(c1408x.f3193g))));
            contentValues.put("type", C1392h.m6317j(this.f3186e, c1408x.f3196j));
            contentValues.put("data1", C1392h.m6317j(this.f3186e, c1408x.f3200n));
            contentValues.put("data2", C1392h.m6317j(this.f3186e, c1408x.f3201o));
            contentValues.put("data3", C1392h.m6317j(this.f3186e, c1408x.f3202p));
            contentValues.put("data4", C1392h.m6317j(this.f3186e, c1408x.f3203q));
            contentValues.put("data5", C1392h.m6317j(this.f3186e, c1408x.f3204r));
            int update = this.f3183b.update("trackinfo", contentValues, "deviceCode= ? and time like ?", new String[]{String.valueOf(c1408x.f3190d), c1408x.f3188b});
            String str = "TrackInfoDB";
            Object[] objArr = new Object[1];
            objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + c1408x + ", values=" + c1408x.toString();
            C2538c.m12674b(str, objArr);
            return update;
        } catch (Exception e) {
            C2538c.m12680e("TrackInfoDB", "update() Exception=" + e.getMessage());
            return -1;
        }
    }

    public C1408x m6434a(int i) {
        Cursor query;
        Exception e;
        try {
            m6435a();
            String[] strArr = new String[]{String.valueOf(i)};
            C2538c.m12674b("TrackInfoDB", "================selection:", "deviceCode= ?");
            SQLiteDatabase sQLiteDatabase = this.f3183b;
            String str = "trackinfo";
            String[] strArr2 = f3182f;
            query = sQLiteDatabase.query(str, strArr2, "deviceCode= ?", strArr, null, null, "time asc");
            if (query == null) {
                try {
                    m6437b();
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    C2538c.m12680e("TrackInfoDB", "getLast() JsonSyntaxException=" + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    m6437b();
                    return null;
                }
            }
            C1408x c1408x;
            if (query.moveToLast()) {
                C1408x c1408x2 = new C1408x();
                c1408x2.f3190d = query.getInt(query.getColumnIndex("deviceCode"));
                c1408x2.f3187a = query.getString(query.getColumnIndex("date"));
                c1408x2.f3188b = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                c1408x2.f3189c = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("lon"))), Double.class)).doubleValue();
                c1408x2.f3191e = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("lat"))), Double.class)).doubleValue();
                c1408x2.f3194h = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("name")));
                c1408x2.f3195i = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("radius")));
                c1408x2.f3197k = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("buildingname")));
                c1408x2.f3198l = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("streetname")));
                c1408x2.f3199m = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex(LogBuilder.KEY_END_TIME)));
                c1408x2.f3192f = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("elev"))), Double.class)).doubleValue();
                c1408x2.f3193g = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("hacc"))), Double.class)).doubleValue();
                c1408x2.f3196j = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("type")));
                c1408x2.f3200n = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data1")));
                c1408x2.f3201o = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data2")));
                c1408x2.f3202p = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data3")));
                c1408x2.f3203q = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data4")));
                c1408x2.f3204r = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data5")));
                C2538c.m12674b("TrackInfoDB", "mod=" + c1408x2);
                c1408x = c1408x2;
            } else {
                c1408x = null;
            }
            query.close();
            m6437b();
            return c1408x;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C2538c.m12680e("TrackInfoDB", "getLast() JsonSyntaxException=" + e.getMessage());
            if (query != null) {
                query.close();
            }
            m6437b();
            return null;
        }
    }

    public ArrayList<C1408x> m6439c(C1408x c1408x) {
        Exception e;
        Cursor cursor;
        try {
            m6435a();
            String[] strArr = new String[]{String.valueOf(c1408x.f3190d), c1408x.f3187a};
            C2538c.m12674b("TrackInfoDB", "================selection:", "deviceCode= ? and date like ?");
            SQLiteDatabase sQLiteDatabase = this.f3183b;
            String str = "trackinfo";
            String[] strArr2 = f3182f;
            Cursor query = sQLiteDatabase.query(str, strArr2, "deviceCode= ? and date like ?", strArr, null, null, "time asc");
            if (query == null) {
                try {
                    m6437b();
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    C2538c.m12680e("TrackInfoDB", "getByDate() JsonSyntaxException e = " + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    m6437b();
                    return null;
                }
            }
            ArrayList<C1408x> arrayList = new ArrayList();
            while (query.moveToNext()) {
                C1408x c1408x2 = new C1408x();
                c1408x2.f3190d = query.getInt(query.getColumnIndex("deviceCode"));
                c1408x2.f3187a = query.getString(query.getColumnIndex("date"));
                c1408x2.f3188b = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                c1408x2.f3189c = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("lon"))), Double.class)).doubleValue();
                c1408x2.f3191e = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("lat"))), Double.class)).doubleValue();
                c1408x2.f3194h = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("name")));
                c1408x2.f3195i = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("radius")));
                c1408x2.f3197k = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("buildingname")));
                c1408x2.f3198l = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("streetname")));
                c1408x2.f3199m = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex(LogBuilder.KEY_END_TIME)));
                c1408x2.f3192f = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("elev"))), Double.class)).doubleValue();
                c1408x2.f3193g = ((Double) this.f3185d.fromJson(C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("hacc"))), Double.class)).doubleValue();
                c1408x2.f3196j = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("type")));
                c1408x2.f3200n = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data1")));
                c1408x2.f3201o = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data2")));
                c1408x2.f3202p = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data3")));
                c1408x2.f3203q = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data4")));
                c1408x2.f3204r = C1392h.m6318k(this.f3186e, query.getString(query.getColumnIndex("data5")));
                C2538c.m12674b("TrackInfoDB", "infoMod=" + c1408x2);
                arrayList.add(c1408x2);
            }
            query.close();
            m6437b();
            C2538c.m12674b("TrackInfoDB", "modList=" + arrayList);
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            C2538c.m12680e("TrackInfoDB", "getByDate() JsonSyntaxException e = " + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            m6437b();
            return null;
        }
    }

    public boolean m6436a(int i, String str) {
        try {
            m6435a();
            String[] strArr = new String[]{String.valueOf(i), str};
            C2538c.m12674b("TrackInfoDB", "================ deleteByDate sql:", "DELETE FROM trackinfo Where deviceCode = ? and date like ?");
            this.f3183b.execSQL("DELETE FROM trackinfo Where deviceCode = ? and date like ?", strArr);
            m6437b();
            return true;
        } catch (SQLException e) {
            C2538c.m12680e("TrackInfoDB", "deleteByDate SQLException e = " + e.getMessage());
            m6437b();
            return false;
        } catch (Exception e2) {
            C2538c.m12680e("TrackInfoDB", "deleteByDate Exception e = " + e2.getMessage());
            m6437b();
            return false;
        }
    }
}
