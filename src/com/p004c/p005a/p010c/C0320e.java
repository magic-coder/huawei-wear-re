package com.p004c.p005a.p010c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.p004c.p005a.p008b.p009a.C0313a;
import com.p004c.p005a.p008b.p009a.C0315c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C0320e implements Runnable {
    private Context f168a;
    private int f169b;
    private long f170c;

    public C0320e(Context context, int i, long j) {
        this.f168a = context;
        this.f169b = i;
        this.f170c = j;
    }

    private void m162a(SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        edit.putLong("last_millis", this.f170c);
        edit.commit();
    }

    private static void m163a(SharedPreferences sharedPreferences, long j) {
        Editor edit = sharedPreferences.edit();
        String valueOf = String.valueOf(j);
        edit.remove("session_id");
        edit.remove("refer_id");
        edit.putString("session_id", valueOf);
        edit.putString("refer_id", "");
        edit.putLong("end_millis", j);
        edit.commit();
    }

    private void m164b(SharedPreferences sharedPreferences) {
        JSONObject jSONObject = new JSONObject();
        Context context = this.f168a;
        StringBuffer stringBuffer = new StringBuffer("");
        SharedPreferences a = C0315c.m149a(context, "sessioncontext");
        String string = a.getString("session_id", "");
        if ("".equals(string)) {
            long currentTimeMillis = System.currentTimeMillis();
            string = String.valueOf(currentTimeMillis);
            Editor edit = a.edit();
            edit.putString("session_id", string);
            edit.putLong("end_millis", currentTimeMillis);
            edit.commit();
        }
        String str = string;
        String string2 = a.getString("refer_id", "");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            C0313a.m146h();
            Object obj = null;
        } else {
            stringBuffer.append(C0313a.m138c(context)[0]).append(",").append(telephonyManager.getNetworkOperatorName().replace(',', '&')).append(",").append(str).append(",").append(string2);
            str = stringBuffer.toString();
        }
        if (obj != null) {
            try {
                String[] split;
                JSONArray jSONArray;
                boolean z;
                if (sharedPreferences.getString("activities", "").trim().length() > 0) {
                    split = sharedPreferences.getString("activities", "").split(";");
                    jSONArray = new JSONArray();
                    for (Object put : split) {
                        jSONArray.put(put);
                    }
                    jSONObject.put("b", jSONArray);
                    z = false;
                } else {
                    z = true;
                }
                if (sharedPreferences.getString("events", "").trim().length() > 0) {
                    split = sharedPreferences.getString("events", "").split(";");
                    jSONArray = new JSONArray();
                    for (Object put2 : split) {
                        jSONArray.put(put2);
                    }
                    jSONObject.put("e", jSONArray);
                    z = false;
                }
                jSONObject.put("h", obj);
                jSONObject.put("type", "termination");
                Handler f = C0313a.m143f();
                if (f != null) {
                    f.post(new C0319d(this.f168a, jSONObject, z));
                }
                C0313a.m146h();
            } catch (Throwable e) {
                Log.e("HiAnalytics", "onTerminate: JSONException.", e);
                e.printStackTrace();
            }
        }
        Editor edit2 = sharedPreferences.edit();
        edit2.putString("activities", "");
        edit2.remove("events");
        edit2.commit();
    }

    private boolean m165c(SharedPreferences sharedPreferences) {
        return this.f170c - sharedPreferences.getLong("last_millis", -1) > C0313a.m129a().longValue() * 1000;
    }

    public final void run() {
        try {
            Context context = this.f168a;
            long j = this.f170c;
            SharedPreferences a = C0315c.m149a(context, "sessioncontext");
            if ("".equals(a.getString("session_id", ""))) {
                C0320e.m163a(a, j);
            } else if (j - a.getLong("end_millis", 0) > C0313a.m137c().longValue() * 1000) {
                C0320e.m163a(a, j);
            } else {
                Editor edit = a.edit();
                edit.putLong("end_millis", j);
                edit.commit();
            }
            if (this.f169b == 0) {
                Context context2 = this.f168a;
                if (this.f168a != context2) {
                    C0313a.m146h();
                    return;
                }
                this.f168a = context2;
                SharedPreferences a2 = C0315c.m149a(context2, "state");
                if (a2 != null) {
                    long j2 = a2.getLong("last_millis", -1);
                    if (j2 == -1) {
                        C0313a.m146h();
                    } else {
                        long j3 = this.f170c - j2;
                        long j4 = a2.getLong("duration", 0);
                        Editor edit2 = a2.edit();
                        Object string = a2.getString("activities", "");
                        String name = context2.getClass().getName();
                        if (!"".equals(string)) {
                            string = new StringBuilder(String.valueOf(string)).append(";").toString();
                        }
                        String stringBuilder = new StringBuilder(String.valueOf(string)).append(name).append(",").append(new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date(j2))).append(",").append(j3 / 1000).toString();
                        edit2.remove("activities");
                        edit2.putString("activities", stringBuilder);
                        edit2.putLong("duration", j4 + j3);
                        edit2.commit();
                    }
                    if (m165c(a2)) {
                        m164b(a2);
                        m162a(a2);
                    } else if (C0313a.m140d(context2)) {
                        m164b(a2);
                        m162a(a2);
                    }
                }
            } else if (this.f169b == 1) {
                context = this.f168a;
                this.f168a = context;
                a = C0315c.m149a(context, "state");
                if (a != null && m165c(a)) {
                    m164b(a);
                    m162a(a);
                }
            } else if (this.f169b == 2) {
                a = C0315c.m149a(this.f168a, "state");
                if (a != null) {
                    m164b(a);
                }
            }
        } catch (Exception e) {
            e.getMessage();
            C0313a.m146h();
            e.printStackTrace();
        }
    }
}
