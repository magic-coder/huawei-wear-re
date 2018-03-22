package com.huawei.hwdatamigrate.p407a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserInfoDB */
public class bf {
    public static final String f17580a;
    private static final String[] f17581f = new String[]{"_id", "userid", "data"};
    private boolean f17582b = false;
    private SQLiteDatabase f17583c;
    private C4780m f17584d;
    private Context f17585e;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table  IF NOT EXISTS userinfo(");
        stringBuilder.append("_id integer primary key autoincrement,");
        stringBuilder.append("userid NVARCHAR(300) not null,");
        stringBuilder.append("data varchar(3000)");
        stringBuilder.append(")");
        f17580a = stringBuilder.toString();
    }

    public bf(Context context) {
        this.f17585e = context;
        this.f17584d = C4780m.m22870a(context);
    }

    public void m22843a() {
        if (this.f17583c == null) {
            this.f17583c = this.f17584d.m22886a();
        }
    }

    public void m22844b() {
        this.f17584d.m22888b();
        this.f17583c = null;
    }

    public bg m22841a(String str) {
        try {
            m22843a();
            String[] strArr = new String[]{str};
            Cursor query = this.f17583c.query("userinfo", f17581f, "userid= ?", strArr, null, null, null);
            if (query == null) {
                m22844b();
                return null;
            }
            bg b;
            if (query.moveToFirst()) {
                b = m22839b(C4775h.m22868e(this.f17585e, query.getString(query.getColumnIndex("data"))));
                b.f17586w = query.getInt(query.getColumnIndex("_id"));
                b.f17587x = query.getString(query.getColumnIndex("userid"));
            } else {
                b = null;
            }
            query.close();
            m22844b();
            return b;
        } catch (Exception e) {
            C2538c.e("UserInfoDB", new Object[]{"get() Exception=" + e.getMessage()});
            return null;
        }
    }

    public String m22842a(bg bgVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HwPayConstant.KEY_USER_NAME, bgVar.a);
            jSONObject.put(UserInfo.GENDER, bgVar.b);
            jSONObject.put("age", bgVar.c);
            jSONObject.put("partriait", bgVar.d);
            jSONObject.put("tokenID", bgVar.e);
            jSONObject.put("height", bgVar.f);
            jSONObject.put("height_ft", bgVar.g);
            jSONObject.put("height_type", bgVar.h);
            jSONObject.put("weight", bgVar.i);
            jSONObject.put("weight_lb", bgVar.j);
            jSONObject.put("weight_type", bgVar.k);
            jSONObject.put("walkLength", bgVar.l);
            jSONObject.put("runLength", bgVar.m);
            jSONObject.put("portrait", bgVar.n);
            jSONObject.put(ParamKey.NICK, bgVar.o);
            jSONObject.put("email", bgVar.p);
            jSONObject.put("mobile", bgVar.q);
            jSONObject.put("birthday", bgVar.r);
            jSONObject.put("unit_type", bgVar.s);
            jSONObject.put(LocationManagerProxy.KEY_LOCATION_CHANGED, bgVar.t);
            jSONObject.put("hobby", bgVar.u);
            jSONObject.put("description", bgVar.v);
            return jSONObject.toString();
        } catch (Exception e) {
            C2538c.b("UserInfoDB", new Object[]{"dataToJson Exception=" + e.getMessage()});
            return null;
        }
    }

    private bg m22839b(String str) {
        bg bgVar = new bg();
        try {
            JSONObject jSONObject = new JSONObject(str);
            m22840b(bgVar, jSONObject);
            m22838a(bgVar, jSONObject);
        } catch (Exception e) {
            C2538c.e("UserInfoDB", new Object[]{"JsonToData error message:" + e.getMessage()});
        }
        return bgVar;
    }

    private void m22838a(bg bgVar, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("weight")) {
            bgVar.i = jSONObject.getInt("weight");
        }
        if (!jSONObject.isNull("weight_lb")) {
            bgVar.j = jSONObject.getInt("weight_lb");
        }
        if (!jSONObject.isNull("weight_type")) {
            bgVar.k = jSONObject.getInt("weight_type");
        }
        if (!jSONObject.isNull("walkLength")) {
            bgVar.l = jSONObject.getInt("walkLength");
        }
        if (!jSONObject.isNull("runLength")) {
            bgVar.m = jSONObject.getInt("runLength");
        }
        if (!jSONObject.isNull("portrait")) {
            bgVar.n = jSONObject.getString("portrait");
        }
        if (!jSONObject.isNull(ParamKey.NICK)) {
            bgVar.o = jSONObject.getString(ParamKey.NICK);
        }
        if (!jSONObject.isNull("email")) {
            bgVar.p = jSONObject.getString("email");
        }
        if (!jSONObject.isNull("mobile")) {
            bgVar.q = jSONObject.getString("mobile");
        }
        if (!jSONObject.isNull("birthday")) {
            bgVar.r = jSONObject.getInt("birthday");
        }
        if (!jSONObject.isNull("unit_type")) {
            bgVar.s = jSONObject.getInt("unit_type");
        }
        if (!jSONObject.isNull(LocationManagerProxy.KEY_LOCATION_CHANGED)) {
            bgVar.t = jSONObject.getString(LocationManagerProxy.KEY_LOCATION_CHANGED);
        }
        if (!jSONObject.isNull("hobby")) {
            bgVar.u = jSONObject.getString("hobby");
        }
        if (!jSONObject.isNull("description")) {
            bgVar.v = jSONObject.getString("description");
        }
    }

    private void m22840b(bg bgVar, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull(HwPayConstant.KEY_USER_NAME)) {
            bgVar.a = jSONObject.getString(HwPayConstant.KEY_USER_NAME);
        }
        if (!jSONObject.isNull(UserInfo.GENDER)) {
            bgVar.b = jSONObject.getInt(UserInfo.GENDER);
        }
        if (!jSONObject.isNull("age")) {
            bgVar.c = jSONObject.getInt("age");
        }
        if (!jSONObject.isNull("partriait")) {
            bgVar.d = jSONObject.getString("partriait");
        }
        if (!jSONObject.isNull("tokenID")) {
            bgVar.e = jSONObject.getString("tokenID");
        }
        if (!jSONObject.isNull("height")) {
            bgVar.f = jSONObject.getInt("height");
        }
        if (!jSONObject.isNull("height_ft")) {
            bgVar.g = jSONObject.getInt("height_ft");
        }
        if (!jSONObject.isNull("height_type")) {
            bgVar.h = jSONObject.getInt("height_type");
        }
    }
}
