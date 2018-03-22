package com.p004c.p005a.p010c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.p004c.p005a.p008b.p009a.C0313a;
import com.p004c.p005a.p008b.p009a.C0315c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class C0317b implements Runnable {
    private Context f161a;
    private String f162b;
    private String f163c;
    private long f164d;

    public C0317b(Context context, String str, String str2, long j) {
        this.f161a = context;
        this.f162b = str.replace(",", "^");
        this.f163c = str2.replace(",", "^");
        this.f164d = j;
    }

    public final void run() {
        try {
            SharedPreferences a = C0315c.m149a(this.f161a, "state");
            if (a == null) {
                C0313a.m146h();
                return;
            }
            Object string = a.getString("events", "");
            if (!"".equals(string)) {
                string = new StringBuilder(String.valueOf(string)).append(";").toString();
            }
            String stringBuilder = new StringBuilder(String.valueOf(string)).append(this.f162b).append(",").append(this.f163c).append(",").append(new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date(this.f164d))).toString();
            if (stringBuilder.split(";").length <= C0313a.m139d()) {
                Editor edit = a.edit();
                edit.remove("events");
                edit.putString("events", stringBuilder);
                edit.commit();
                C0313a.m146h();
            }
            if (!C0313a.m140d(this.f161a)) {
                return;
            }
            if (C0313a.m142e()) {
                C0313a.m146h();
                C0316a.m158c(this.f161a);
                return;
            }
            a.edit().remove("events").commit();
        } catch (Exception e) {
            e.getMessage();
            C0313a.m146h();
            e.printStackTrace();
        }
    }
}
