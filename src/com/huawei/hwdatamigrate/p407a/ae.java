package com.huawei.hwdatamigrate.p407a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4977l;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;

/* compiled from: NDataBaseUtil */
public class ae {
    private static ae f17389a;
    private Context f17390b;

    public static ae m22789a() {
        ae aeVar;
        synchronized (ae.class) {
            if (f17389a == null) {
                f17389a = new ae(BaseApplication.b());
            }
            aeVar = f17389a;
        }
        return aeVar;
    }

    private ae(Context context) {
        this.f17390b = context;
    }

    public void m22790a(SQLiteDatabase sQLiteDatabase) {
        String str = "userinfo_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table userinfo rename to " + str);
        C4977l.m23909a(sQLiteDatabase, bf.f17580a);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                bg bgVar = new bg();
                bgVar.a = rawQuery.getString(rawQuery.getColumnIndex("username"));
                bgVar.b = rawQuery.getInt(rawQuery.getColumnIndex(UserInfo.GENDER));
                bgVar.c = rawQuery.getInt(rawQuery.getColumnIndex("age"));
                bgVar.d = rawQuery.getString(rawQuery.getColumnIndex("partriait"));
                bgVar.e = rawQuery.getString(rawQuery.getColumnIndex("tokenID"));
                bgVar.f = rawQuery.getInt(rawQuery.getColumnIndex("height"));
                bgVar.g = rawQuery.getInt(rawQuery.getColumnIndex("height_ft"));
                bgVar.h = rawQuery.getInt(rawQuery.getColumnIndex("height_type"));
                bgVar.i = rawQuery.getInt(rawQuery.getColumnIndex("weight"));
                bgVar.j = rawQuery.getInt(rawQuery.getColumnIndex("weight_lb"));
                bgVar.k = rawQuery.getInt(rawQuery.getColumnIndex("weight_type"));
                bgVar.l = rawQuery.getInt(rawQuery.getColumnIndex("stepLength"));
                bgVar.m = rawQuery.getInt(rawQuery.getColumnIndex("runLength"));
                bgVar.n = rawQuery.getString(rawQuery.getColumnIndex("portrait"));
                bgVar.o = rawQuery.getString(rawQuery.getColumnIndex(ParamKey.NICK));
                bgVar.p = rawQuery.getString(rawQuery.getColumnIndex("email"));
                bgVar.q = rawQuery.getString(rawQuery.getColumnIndex("mobile"));
                bgVar.r = rawQuery.getInt(rawQuery.getColumnIndex("birthday"));
                bgVar.s = rawQuery.getInt(rawQuery.getColumnIndex("unit_type"));
                bgVar.t = rawQuery.getString(rawQuery.getColumnIndex(LocationManagerProxy.KEY_LOCATION_CHANGED));
                bgVar.u = rawQuery.getString(rawQuery.getColumnIndex("hobby"));
                bgVar.v = rawQuery.getString(rawQuery.getColumnIndex("description"));
                contentValues.put("data", C4775h.m22867d(this.f17390b, new bf(this.f17390b).m22842a(bgVar)));
                sQLiteDatabase.insert("userinfo", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22791b(SQLiteDatabase sQLiteDatabase) {
        String str = "heartdatas_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table heartdatas rename to " + str);
        C4977l.m23909a(sQLiteDatabase, C4789v.f17706a);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                contentValues.put("mac", rawQuery.getString(rawQuery.getColumnIndex("mac")));
                contentValues.put("HeartCurTime", rawQuery.getString(rawQuery.getColumnIndex("HeartCurTime")));
                C4788t c4788t = new C4788t();
                c4788t.e = rawQuery.getInt(rawQuery.getColumnIndex("HeartTime"));
                c4788t.f = rawQuery.getInt(rawQuery.getColumnIndex("heartRates"));
                c4788t.g = rawQuery.getInt(rawQuery.getColumnIndex("heartRateMode"));
                contentValues.put("data", C4775h.m22867d(this.f17390b, new C4789v(this.f17390b).m22912a(c4788t)));
                contentValues.put("isUpload", rawQuery.getString(rawQuery.getColumnIndex("isUpload")));
                sQLiteDatabase.insert("heartdatas", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22792c(SQLiteDatabase sQLiteDatabase) {
        String str = "altitudedatas_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table altitudedatas rename to " + str);
        C4977l.m23909a(sQLiteDatabase, C4773f.f17614a);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userid", rawQuery.getString(rawQuery.getColumnIndex("userid")));
                contentValues.put("mac", rawQuery.getString(rawQuery.getColumnIndex("mac")));
                C4774g c4774g = new C4774g();
                c4774g.a = rawQuery.getString(rawQuery.getColumnIndex("AltitudeTime"));
                c4774g.b = rawQuery.getInt(rawQuery.getColumnIndex("Altitude"));
                contentValues.put("data", C4775h.m22867d(this.f17390b, new C4773f(this.f17390b).m22856a(c4774g)));
                contentValues.put("isUpload", rawQuery.getString(rawQuery.getColumnIndex("isUpload")));
                contentValues.put("HeartCurTime", rawQuery.getString(rawQuery.getColumnIndex("HeartCurTime")));
                sQLiteDatabase.insert("altitudedatas", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22793d(SQLiteDatabase sQLiteDatabase) {
        String str = "timelinetable_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table timelinetable rename to " + str);
        C4977l.m23909a(sQLiteDatabase, aw.f17511a);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("eventType", rawQuery.getString(rawQuery.getColumnIndex("eventType")));
                contentValues.put("eventStrDay", rawQuery.getString(rawQuery.getColumnIndex("eventStrDay")));
                ax axVar = new ax();
                axVar.a = rawQuery.getInt(rawQuery.getColumnIndex("eventTypeIconResid"));
                axVar.b = rawQuery.getString(rawQuery.getColumnIndex("eventContent"));
                axVar.c = rawQuery.getString(rawQuery.getColumnIndex("eventGpsLoc"));
                axVar.d = rawQuery.getInt(rawQuery.getColumnIndex("eventContentIconResId"));
                axVar.e = rawQuery.getString(rawQuery.getColumnIndex("eventContentPicPath"));
                axVar.f = rawQuery.getString(rawQuery.getColumnIndex("eventSummary"));
                axVar.g = rawQuery.getString(rawQuery.getColumnIndex("eventStartStrTime"));
                axVar.h = rawQuery.getString(rawQuery.getColumnIndex("eventEndStrTime"));
                contentValues.put("data", C4775h.m22867d(this.f17390b, new aw(this.f17390b).m22824a(axVar)));
                sQLiteDatabase.insert("timelinetable", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }

    public void m22794e(SQLiteDatabase sQLiteDatabase) {
        String str = "clearcommandfailed_bk";
        C4977l.m23909a(sQLiteDatabase, "alter table clearcommandfailed rename to " + str);
        C4977l.m23909a(sQLiteDatabase, C4777j.f17627b);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                C4779l c4779l = new C4779l();
                c4779l.a = rawQuery.getString(rawQuery.getColumnIndex(SNBConstant.FIELD_DEVICE_ID));
                c4779l.b = rawQuery.getInt(rawQuery.getColumnIndex("frame_count"));
                c4779l.c = rawQuery.getString(rawQuery.getColumnIndex("first_data"));
                c4779l.d = rawQuery.getString(rawQuery.getColumnIndex("remark"));
                contentValues.put("data", C4775h.m22867d(this.f17390b, new C4777j(this.f17390b).m22869a(c4779l)));
                sQLiteDatabase.insert("clearcommandfailed", null, contentValues);
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        C4977l.m23909a(sQLiteDatabase, "DROP TABLE IF EXISTS " + str);
    }
}
