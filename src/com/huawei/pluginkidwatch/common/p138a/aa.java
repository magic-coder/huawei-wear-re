package com.huawei.pluginkidwatch.common.p138a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

/* compiled from: VoiceDB */
public class aa {
    public static final String f2984a;
    private static boolean f2985e = false;
    private static final String[] f2986f = new String[]{"cloud_url", "deviceCode", HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, "fromName", "type", "local_url", "head_url", "column_id", "column_status", "column_isreaded", "column_groupid", "textContent", "fromhuid", "huid", "column_key", "column_iv", "column_createTime", "column_serverTime", "column_relationtype", "data1", "data2", "data3", "data4"};
    private SQLiteDatabase f2987b;
    private C1393i f2988c;
    private Context f2989d = null;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS voice_table_1(");
        stringBuilder.append("cloud_url NVARCHAR(1500)  not null,");
        stringBuilder.append("deviceCode integer  not null,");
        stringBuilder.append("column_id integer ,");
        stringBuilder.append("column_status integer ,");
        stringBuilder.append("time integer ,");
        stringBuilder.append("fromName NVARCHAR(1500) ,");
        stringBuilder.append("column_isreaded integer ,");
        stringBuilder.append("column_groupid integer ,");
        stringBuilder.append("huid NVARCHAR(1500) ,");
        stringBuilder.append("type NVARCHAR(1500) ,");
        stringBuilder.append("local_url NVARCHAR(1500) ,");
        stringBuilder.append("head_url NVARCHAR(1500) ,");
        stringBuilder.append("column_key NVARCHAR(1500) ,");
        stringBuilder.append("column_iv NVARCHAR(1500) ,");
        stringBuilder.append("column_createTime NVARCHAR(1500) ,");
        stringBuilder.append("column_serverTime NVARCHAR(1500) ,");
        stringBuilder.append("column_relationtype NVARCHAR(300) ,");
        stringBuilder.append("textContent NVARCHAR(1500) ,");
        stringBuilder.append("fromhuid NVARCHAR(1500) ,");
        stringBuilder.append("data1 NVARCHAR(300) ,");
        stringBuilder.append("data2 NVARCHAR(300) ,");
        stringBuilder.append("data3 NVARCHAR(300) ,");
        stringBuilder.append("data4 NVARCHAR(300) ,");
        stringBuilder.append(" primary key(deviceCode,huid,time)");
        stringBuilder.append(")");
        C2538c.m12674b("VoiceDB", "===createTableSQL", stringBuilder.toString());
        f2984a = stringBuilder.toString();
    }

    public aa(Context context) {
        this.f2988c = C1393i.m6319a(context);
        this.f2989d = context;
    }

    public void m6210a() {
        if (this.f2987b == null) {
            this.f2987b = this.f2988c.m6327a();
        }
    }

    public void m6215b() {
        this.f2988c.m6328b();
        this.f2987b = null;
    }

    public long m6206a(ab abVar) {
        long insert;
        m6210a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cloud_url", C1392h.m6317j(this.f2989d, abVar.f2991b));
        contentValues.put("deviceCode", abVar.f2990a);
        contentValues.put("fromName", C1392h.m6317j(this.f2989d, abVar.f2992c));
        contentValues.put("column_isreaded", Integer.valueOf(abVar.f3003n ? 1 : 0));
        contentValues.put("column_groupid", Integer.valueOf(abVar.f2999j));
        contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, abVar.f2996g);
        contentValues.put("type", abVar.f2994e);
        contentValues.put("local_url", abVar.f2997h);
        contentValues.put("head_url", C1392h.m6317j(this.f2989d, abVar.f2998i));
        contentValues.put("column_key", C1392h.m6317j(this.f2989d, abVar.f3004o));
        contentValues.put("column_iv", C1392h.m6317j(this.f2989d, abVar.f3005p));
        contentValues.put("column_createTime", C1392h.m6317j(this.f2989d, abVar.f3007r));
        contentValues.put("column_serverTime", C1392h.m6317j(this.f2989d, abVar.f3008s));
        contentValues.put("column_relationtype", abVar.f3006q);
        contentValues.put("column_id", Integer.valueOf(abVar.f3001l));
        contentValues.put("column_status", Integer.valueOf(abVar.f3002m));
        contentValues.put("textContent", C1392h.m6317j(this.f2989d, abVar.f2995f));
        contentValues.put("fromhuid", C1392h.m6317j(this.f2989d, abVar.f2993d));
        contentValues.put("huid", abVar.f3000k);
        contentValues.put("data1", abVar.f3009t);
        contentValues.put("data2", abVar.f3010u);
        contentValues.put("data3", abVar.f3011v);
        contentValues.put("data4", abVar.f3012w);
        if (this.f2987b != null) {
            insert = this.f2987b.insert("voice_table_1", null, contentValues);
        } else {
            insert = -1;
        }
        String str = "VoiceDB";
        Object[] objArr = new Object[1];
        objArr[0] = "insert() result=" + (-1 == insert ? "failed" : "succeed") + ", table=" + abVar + ", values=" + contentValues.toString();
        C2538c.m12674b(str, objArr);
        m6215b();
        return insert;
    }

    public int m6213b(ab abVar) {
        int update;
        m6210a();
        C2538c.m12674b("VoiceDB", "======================================update=mod.status:" + abVar.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("cloud_url", C1392h.m6317j(this.f2989d, abVar.f2991b));
        contentValues.put("deviceCode", abVar.f2990a);
        contentValues.put("fromName", C1392h.m6317j(this.f2989d, abVar.f2992c));
        contentValues.put("column_isreaded", Integer.valueOf(abVar.f3003n ? 1 : 0));
        contentValues.put("column_groupid", Integer.valueOf(abVar.f2999j));
        contentValues.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, abVar.f2996g);
        contentValues.put("type", abVar.f2994e);
        contentValues.put("local_url", abVar.f2997h);
        contentValues.put("head_url", C1392h.m6317j(this.f2989d, abVar.f2998i));
        contentValues.put("column_key", C1392h.m6317j(this.f2989d, abVar.f3004o));
        contentValues.put("column_iv", C1392h.m6317j(this.f2989d, abVar.f3005p));
        contentValues.put("column_createTime", C1392h.m6317j(this.f2989d, abVar.f3007r));
        contentValues.put("column_serverTime", C1392h.m6317j(this.f2989d, abVar.f3008s));
        contentValues.put("column_relationtype", abVar.f3006q);
        contentValues.put("column_id", Integer.valueOf(abVar.f3001l));
        contentValues.put("column_status", Integer.valueOf(abVar.f3002m));
        contentValues.put("textContent", C1392h.m6317j(this.f2989d, abVar.f2995f));
        contentValues.put("fromhuid", C1392h.m6317j(this.f2989d, abVar.f2993d));
        contentValues.put("huid", abVar.f3000k);
        contentValues.put("data1", abVar.f3009t);
        contentValues.put("data2", abVar.f3010u);
        contentValues.put("data3", abVar.f3011v);
        contentValues.put("data4", abVar.f3012w);
        C2538c.m12674b("VoiceDB", "whereClause:" + "deviceCode = ? and local_url like ?");
        String[] strArr = new String[]{abVar.f2990a, abVar.f2997h};
        if (this.f2987b != null) {
            update = this.f2987b.update("voice_table_1", contentValues, r0, strArr);
        } else {
            update = 0;
        }
        String str = "VoiceDB";
        Object[] objArr = new Object[1];
        objArr[0] = "update() result=" + (update == 0 ? "failed" : "succeed") + ", table=" + abVar + ", values=" + abVar.toString();
        C2538c.m12674b(str, objArr);
        m6215b();
        return update;
    }

    public void m6217c(ab abVar) {
        C2538c.m12674b("VoiceDB", "=====Enter saveVoice");
        if (abVar != null && abVar.f2990a.length() > 1) {
            C2538c.m12674b("VoiceDB", "=====Enter saveVoice  " + abVar.toString());
            if (m6207a(abVar.f3000k, abVar.f2990a, abVar.f2996g, abVar.f2997h) == null) {
                C2538c.m12674b("VoiceDB", "===== res is null,insert");
                m6206a(abVar);
                return;
            }
            C2538c.m12674b("VoiceDB", "===== res is not null,update");
            m6213b(abVar);
        }
    }

    public void m6211a(String str, String str2, String str3) {
        try {
            m6210a();
            String[] strArr = new String[]{str, str2, str3};
            C2538c.m12674b("VoiceDB", "================ delete single voice sql:", "DELETE FROM voice_table_1 Where huid like ? and deviceCode = ? and local_url like ?");
            if (this.f2987b != null) {
                this.f2987b.execSQL(r0, strArr);
            }
            m6215b();
        } catch (SQLException e) {
            C2538c.m12674b("VoiceDB", "===========ERROR:" + e.getMessage());
            m6215b();
        }
    }

    public ab m6207a(String str, String str2, String str3, String str4) {
        C2538c.m12674b("VoiceDB", "================get time:", str3);
        C2538c.m12674b("VoiceDB", "================get url:", str4);
        C2538c.m12674b("VoiceDB", "================get deviceCode:", str2);
        C2538c.m12674b("VoiceDB", "================get huid:", str);
        try {
            String str5;
            String[] strArr;
            Cursor query;
            m6210a();
            String str6 = "";
            if (str4 == null || str4.length() <= 0) {
                str5 = "deviceCode= ?" + str2 + " and " + "huid" + " like ? and " + HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME + " like ?";
                strArr = new String[]{str2, str, str3};
            } else {
                str5 = "deviceCode= ? and huid like ? and local_url like ?";
                strArr = new String[]{str2, str, str4};
            }
            C2538c.m12674b("VoiceDB", "================get selection:", str5);
            if (this.f2987b != null) {
                query = this.f2987b.query("voice_table_1", f2986f, str5, strArr, null, null, null);
            } else {
                query = null;
            }
            if (query == null) {
                m6215b();
                C2538c.m12674b("VoiceDB", "===============null == cursor:", str5);
                return null;
            }
            ab abVar;
            if (query.moveToFirst()) {
                abVar = new ab();
                abVar.f2990a = query.getString(query.getColumnIndex("deviceCode"));
                abVar.f2991b = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("cloud_url")));
                abVar.f2992c = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromName")));
                if (1 == query.getInt(query.getColumnIndex("column_isreaded"))) {
                    abVar.f3003n = true;
                } else {
                    abVar.f3003n = false;
                }
                abVar.f2999j = query.getInt(query.getColumnIndex("column_groupid"));
                abVar.f2994e = query.getString(query.getColumnIndex("type"));
                abVar.f2997h = query.getString(query.getColumnIndex("local_url"));
                abVar.f2998i = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("head_url")));
                abVar.f3004o = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_key")));
                abVar.f3005p = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_iv")));
                abVar.f3007r = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_createTime")));
                abVar.f3008s = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_serverTime")));
                abVar.f3006q = query.getString(query.getColumnIndex("column_relationtype"));
                abVar.f3001l = query.getInt(query.getColumnIndex("column_id"));
                abVar.f3002m = query.getInt(query.getColumnIndex("column_status"));
                C2538c.m12674b("VoiceDB", "======================================get=mod.status:" + abVar.f3002m);
                abVar.f2995f = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("textContent")));
                abVar.f2993d = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromhuid")));
                abVar.f3000k = query.getString(query.getColumnIndex("huid"));
                abVar.f2996g = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                abVar.f3009t = query.getString(query.getColumnIndex("data1"));
                abVar.f3010u = query.getString(query.getColumnIndex("data2"));
                abVar.f3011v = query.getString(query.getColumnIndex("data3"));
                abVar.f3012w = query.getString(query.getColumnIndex("data4"));
            } else {
                abVar = null;
            }
            if (abVar != null) {
                C2538c.m12674b("VoiceDB", "result = " + abVar);
            }
            query.close();
            m6215b();
            C2538c.m12674b("VoiceDB", "=========查到结果");
            return abVar;
        } catch (Exception e) {
            C2538c.m12680e("VoiceDB", "===========ERROR:" + e.getMessage());
            m6215b();
            return null;
        }
    }

    public ArrayList<ab> m6208a(String str, String str2) {
        Cursor query;
        Object obj = null;
        m6210a();
        String[] strArr = new String[]{str2, str};
        C2538c.m12674b("VoiceDB", "================getAll selection:", "deviceCode= ? and huid like ?");
        if (this.f2987b != null) {
            query = this.f2987b.query("voice_table_1", f2986f, r3, strArr, null, null, null);
        } else {
            query = null;
        }
        if (query == null) {
            m6215b();
            return null;
        }
        ArrayList<ab> arrayList = new ArrayList();
        while (query.moveToNext()) {
            obj = new ab();
            obj.f2990a = query.getString(query.getColumnIndex("deviceCode"));
            obj.f2991b = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("cloud_url")));
            obj.f2992c = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromName")));
            if (1 == query.getInt(query.getColumnIndex("column_isreaded"))) {
                obj.f3003n = true;
            } else {
                obj.f3003n = false;
            }
            obj.f2999j = query.getInt(query.getColumnIndex("column_groupid"));
            obj.f2994e = query.getString(query.getColumnIndex("type"));
            obj.f2997h = query.getString(query.getColumnIndex("local_url"));
            obj.f2998i = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("head_url")));
            obj.f3004o = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_key")));
            obj.f3005p = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_iv")));
            obj.f3007r = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_createTime")));
            obj.f3008s = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_serverTime")));
            obj.f3006q = query.getString(query.getColumnIndex("column_relationtype"));
            obj.f3001l = query.getInt(query.getColumnIndex("column_id"));
            obj.f3002m = query.getInt(query.getColumnIndex("column_status"));
            C2538c.m12674b("VoiceDB", "======================================get=mod.status:" + obj.f3002m);
            obj.f2995f = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("textContent")));
            obj.f2993d = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromhuid")));
            obj.f3000k = query.getString(query.getColumnIndex("huid"));
            obj.f2996g = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
            obj.f3009t = query.getString(query.getColumnIndex("data1"));
            obj.f3010u = query.getString(query.getColumnIndex("data2"));
            obj.f3011v = query.getString(query.getColumnIndex("data3"));
            obj.f3012w = query.getString(query.getColumnIndex("data4"));
            arrayList.add(obj);
        }
        if (obj != null) {
            C2538c.m12674b("VoiceDB", "result = " + obj);
        }
        query.close();
        m6215b();
        C2538c.m12674b("VoiceDB", "=========查到结果");
        return arrayList;
    }

    public ArrayList<ab> m6209a(String str, String str2, int i) {
        ArrayList<ab> arrayList = null;
        if (i > 0) {
            Cursor query;
            m6210a();
            String[] strArr = new String[]{str2, str};
            C2538c.m12674b("VoiceDB", "================getNewest selection:", "deviceCode= ? and huid like ?");
            if (this.f2987b != null) {
                String str3 = "0," + i;
                query = this.f2987b.query("voice_table_1", f2986f, r3, strArr, null, null, "time desc", str3);
            } else {
                query = null;
            }
            if (query == null) {
                m6215b();
            } else {
                arrayList = new ArrayList();
                while (query.moveToNext()) {
                    ab abVar = new ab();
                    abVar.f2990a = query.getString(query.getColumnIndex("deviceCode"));
                    abVar.f2991b = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("cloud_url")));
                    abVar.f2992c = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromName")));
                    if (1 == query.getInt(query.getColumnIndex("column_isreaded"))) {
                        abVar.f3003n = true;
                    } else {
                        abVar.f3003n = false;
                    }
                    abVar.f2999j = query.getInt(query.getColumnIndex("column_groupid"));
                    abVar.f2994e = query.getString(query.getColumnIndex("type"));
                    abVar.f2997h = query.getString(query.getColumnIndex("local_url"));
                    abVar.f2998i = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("head_url")));
                    abVar.f3004o = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_key")));
                    abVar.f3005p = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_iv")));
                    abVar.f3007r = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_createTime")));
                    abVar.f3008s = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_serverTime")));
                    abVar.f3006q = query.getString(query.getColumnIndex("column_relationtype"));
                    abVar.f3001l = query.getInt(query.getColumnIndex("column_id"));
                    abVar.f3002m = query.getInt(query.getColumnIndex("column_status"));
                    C2538c.m12674b("VoiceDB", "======================================get=mod.status:" + abVar.f3002m);
                    abVar.f2995f = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("textContent")));
                    abVar.f2993d = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromhuid")));
                    abVar.f3000k = query.getString(query.getColumnIndex("huid"));
                    abVar.f2996g = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                    abVar.f3009t = query.getString(query.getColumnIndex("data1"));
                    abVar.f3010u = query.getString(query.getColumnIndex("data2"));
                    abVar.f3011v = query.getString(query.getColumnIndex("data3"));
                    abVar.f3012w = query.getString(query.getColumnIndex("data4"));
                    arrayList.add(abVar);
                }
                C2538c.m12674b("VoiceDB", "getNewest() DeviceCode=" + str2 + ",  modList.size()=" + arrayList.size());
                query.close();
                m6215b();
                C2538c.m12674b("VoiceDB", "=========查到结果");
            }
        }
        return arrayList;
    }

    public void m6216c() {
        try {
            m6210a();
            C2538c.m12674b("VoiceDB", "================ delete all deviceinfo   sql:", "DELETE FROM voice_table_1");
            if (this.f2987b != null) {
                this.f2987b.execSQL(r0);
            }
            m6215b();
        } catch (SQLException e) {
            C2538c.m12680e("VoiceDB", "SQLException e = " + e.getMessage());
            m6215b();
        }
    }

    public boolean m6212a(String str, int i) {
        C2538c.m12674b("VoiceDB", "===========huid:" + str + " days:" + i);
        try {
            m6210a();
            long j = ((long) i) * 86400000;
            long currentTimeMillis = System.currentTimeMillis() - j;
            C2538c.m12674b("VoiceDB", "===========deleteOutTimeDatas... time:" + j);
            C2538c.m12674b("VoiceDB", "===========deleteOutTimeDatas... curTime:" + r4);
            C2538c.m12674b("VoiceDB", "===========deleteOutTimeDatas... subTime:" + currentTimeMillis);
            String[] strArr = new String[]{str, String.valueOf(currentTimeMillis)};
            C2538c.m12674b("VoiceDB", "======== deleteOutTimeDatas   sql:", "DELETE FROM voice_table_1 Where huid like ? and time < ?");
            if (this.f2987b != null) {
                this.f2987b.execSQL(r2, strArr);
            }
            m6215b();
            return true;
        } catch (SQLException e) {
            C2538c.m12674b("VoiceDB", "===========ERROR:" + e.getMessage());
            m6215b();
            return false;
        }
    }

    public ArrayList<ab> m6214b(String str, int i) {
        Exception e;
        C2538c.m12674b("VoiceDB", "===========Enter getOutTimeDatas huid:" + str + " days:" + i);
        ArrayList<ab> arrayList;
        try {
            Cursor query;
            m6210a();
            long j = ((long) i) * 86400000;
            long currentTimeMillis = System.currentTimeMillis() - j;
            C2538c.m12674b("VoiceDB", "===========getOutTimeDatas time:" + j);
            C2538c.m12674b("VoiceDB", "===========getOutTimeDatas curTime:" + r2);
            C2538c.m12674b("VoiceDB", "===========getOutTimeDatas subTime:" + currentTimeMillis);
            String[] strArr = new String[]{String.valueOf(currentTimeMillis), str};
            C2538c.m12674b("VoiceDB", "===========getOutTimeDatas selection:" + "time < ? and huid like ?");
            if (this.f2987b != null) {
                query = this.f2987b.query("voice_table_1", f2986f, r3, strArr, null, null, null);
            } else {
                query = null;
            }
            if (query == null) {
                m6215b();
                return null;
            }
            arrayList = new ArrayList();
            while (query.moveToNext()) {
                ab abVar = new ab();
                abVar.f2990a = query.getString(query.getColumnIndex("deviceCode"));
                abVar.f2991b = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("cloud_url")));
                abVar.f2992c = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromName")));
                if (1 == query.getInt(query.getColumnIndex("column_isreaded"))) {
                    abVar.f3003n = true;
                } else {
                    try {
                        abVar.f3003n = false;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                abVar.f2999j = query.getInt(query.getColumnIndex("column_groupid"));
                abVar.f2994e = query.getString(query.getColumnIndex("type"));
                abVar.f2997h = query.getString(query.getColumnIndex("local_url"));
                abVar.f2998i = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("head_url")));
                abVar.f3004o = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_key")));
                abVar.f3005p = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_iv")));
                abVar.f3007r = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_createTime")));
                abVar.f3008s = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("column_serverTime")));
                abVar.f3006q = query.getString(query.getColumnIndex("column_relationtype"));
                abVar.f3001l = query.getInt(query.getColumnIndex("column_id"));
                abVar.f3002m = query.getInt(query.getColumnIndex("column_status"));
                C2538c.m12674b("VoiceDB", "======================================get=mod.status:" + abVar.f3002m);
                abVar.f2995f = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("textContent")));
                abVar.f2993d = C1392h.m6318k(this.f2989d, query.getString(query.getColumnIndex("fromhuid")));
                abVar.f3000k = query.getString(query.getColumnIndex("huid"));
                abVar.f2996g = query.getString(query.getColumnIndex(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                abVar.f3009t = query.getString(query.getColumnIndex("data1"));
                abVar.f3010u = query.getString(query.getColumnIndex("data2"));
                abVar.f3011v = query.getString(query.getColumnIndex("data3"));
                abVar.f3012w = query.getString(query.getColumnIndex("data4"));
                arrayList.add(abVar);
            }
            query.close();
            m6215b();
            C2538c.m12674b("VoiceDB", "===========getOutTimeDatas modList.size:" + arrayList.size());
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
            m6215b();
            C2538c.m12680e("VoiceDB", "===========ERROR:" + e.getMessage());
            return arrayList;
        }
    }

    public static void m6203d() {
        C2538c.m12674b("VoiceDB", "=stopWork ");
        f2985e = true;
    }

    public static void m6204e() {
        C2538c.m12674b("VoiceDB", "=startWork ");
        f2985e = false;
    }

    public static boolean m6205f() {
        return f2985e;
    }
}
