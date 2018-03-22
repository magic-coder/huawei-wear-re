package com.tencent.stat;

import android.database.Cursor;
import org.json.JSONObject;

class aa implements Runnable {
    final /* synthetic */ C6487u f22373a;

    aa(C6487u c6487u) {
        this.f22373a = c6487u;
    }

    public void run() {
        Object th;
        Throwable th2;
        Cursor query;
        try {
            query = this.f22373a.f22541d.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    C6476i c6476i = new C6476i(i);
                    c6476i.f22512a = i;
                    c6476i.f22513b = new JSONObject(string);
                    c6476i.f22514c = string2;
                    c6476i.f22515d = i2;
                    C6470c.m29508a(c6476i);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th2 = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }
}
