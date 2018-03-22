package com.aps;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.location.core.C3190b;
import com.amap.api.location.core.C3191c;
import com.amap.api.location.core.C3193e;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import org.json.JSONObject;

/* compiled from: ConnectionServiceManager */
public class at {
    aw f12955a = null;
    private String f12956b = null;
    private Context f12957c = null;
    private boolean f12958d = true;
    private C3491a f12959e = null;
    private ServiceConnection f12960f = null;
    private Intent f12961g = new Intent();
    private String f12962h = "com.autonavi.minimap";
    private String f12963i = "com.amap.api.service.AMapService";
    private String f12964j = "invaid type";
    private String f12965k = "empty appkey";
    private String f12966l = "refused";
    private String f12967m = "failed";

    at(Context context) {
        this.f12957c = context;
        try {
            this.f12956b = C3190b.m14117a(C3193e.m14156b(C3191c.f10685a.getBytes(GameManager.DEFAULT_CHARSET), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void m17347a() {
        m17350c();
        this.f12957c = null;
        this.f12959e = null;
        this.f12960f = null;
        if (this.f12955a != null) {
            this.f12955a.mo4150a(-1);
        }
        this.f12958d = true;
    }

    public void m17348a(aw awVar) {
        try {
            this.f12955a = awVar;
            if (this.f12960f == null) {
                this.f12960f = new av(this, awVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    boolean m17349b() {
        try {
            this.f12961g.setComponent(new ComponentName(this.f12962h, this.f12963i));
            this.f12961g.putExtra(LogBuilder.KEY_APPKEY, this.f12956b);
            return this.f12957c.bindService(this.f12961g, this.f12960f, 1);
        } catch (Exception e) {
            return false;
        }
    }

    void m17350c() {
        try {
            this.f12957c.unbindService(this.f12960f);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Throwable th) {
        }
        this.f12959e = null;
    }

    ap m17351d() {
        ap apVar = null;
        try {
            if (this.f12958d) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "corse");
                bundle.putString(LogBuilder.KEY_APPKEY, this.f12956b);
                this.f12959e.mo4151a(bundle);
                if (bundle.size() >= 1) {
                    apVar = m17346a(bundle);
                }
            }
        } catch (RemoteException e) {
        } catch (Throwable th) {
        }
        return apVar;
    }

    private ap m17346a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        byte[] c;
        String str;
        JSONObject jSONObject;
        ap apVar;
        double d;
        double d2;
        Object obj;
        String str2;
        String string;
        if (bundle.containsKey(SMSKeyInfo.TAG_KEY)) {
            try {
                c = C3193e.m14159c(C3190b.m14118a(bundle.getString(SMSKeyInfo.TAG_KEY)), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bundle.containsKey("result")) {
                return null;
            }
            try {
                str = new String(C3193e.m14157b(c, C3190b.m14118a(bundle.getString("result"))), "utf-8");
                if (str != null) {
                    return null;
                }
                jSONObject = new JSONObject(str);
                if (jSONObject.has(HwAccountConstants.EXTRA_OPLOG_ERROR)) {
                    apVar = new ap();
                    if (jSONObject.has(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)) {
                        apVar.m17287a(jSONObject.getLong(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                    }
                    if (jSONObject.has("acc")) {
                        apVar.m17286a((float) jSONObject.getInt("acc"));
                    }
                    if (jSONObject.has("dir")) {
                        apVar.m17293b(Float.parseFloat(jSONObject.getString("dir")));
                    }
                    apVar.m17302f(LocationProviderProxy.AMapNetwork);
                    if (jSONObject.has("lat")) {
                        d = 0.0d;
                    } else {
                        d = jSONObject.getDouble("lat");
                    }
                    if (jSONObject.has("lon")) {
                        d2 = 0.0d;
                    } else {
                        d2 = jSONObject.getDouble("lon");
                    }
                    if (jSONObject.has("type")) {
                        obj = null;
                    } else {
                        obj = jSONObject.getString("type");
                    }
                    if (jSONObject.has(ParamKey.POINAME)) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString(ParamKey.POINAME);
                    }
                    apVar.m17324q(str2);
                    if (jSONObject.has("desc")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("desc");
                    }
                    apVar.m17310j(str2);
                    if (jSONObject.has("street")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("street");
                    }
                    apVar.m17322p(str2);
                    if (jSONObject.has("pid")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("pid");
                    }
                    apVar.m17289a(str2);
                    if (jSONObject.has("flr")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("flr");
                    }
                    apVar.m17294b(str2);
                    if (jSONObject.has("road")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("road");
                    }
                    apVar.m17320o(str2);
                    if (jSONObject.has("city")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("city");
                    }
                    apVar.m17318n(str2);
                    if (jSONObject.has("country")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("country");
                    }
                    apVar.m17314l(str2);
                    if (jSONObject.has("citycode")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("citycode");
                    }
                    apVar.m17308i(str2);
                    if (jSONObject.has("province")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("province");
                    }
                    apVar.m17316m(str2);
                    if (jSONObject.has("adcode")) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString("adcode");
                    }
                    apVar.m17312k(str2);
                    if (jSONObject.has(DistrictSearchQuery.KEYWORDS_DISTRICT)) {
                        str2 = null;
                    } else {
                        str2 = jSONObject.getString(DistrictSearchQuery.KEYWORDS_DISTRICT);
                    }
                    apVar.m17296c(str2);
                    if ("WGS84".equals(obj) || !C3191c.m14121a(d, d2)) {
                        apVar.m17292b(d);
                        apVar.m17285a(d2);
                    } else {
                        double[] a = bv.m17465a(d2, d);
                        apVar.m17292b(a[1]);
                        apVar.m17285a(a[0]);
                    }
                    return apVar;
                }
                string = jSONObject.getString(HwAccountConstants.EXTRA_OPLOG_ERROR);
                if (this.f12964j.equals(string)) {
                    this.f12958d = false;
                }
                if (this.f12965k.equals(string)) {
                    this.f12958d = false;
                }
                if (this.f12966l.equals(string)) {
                    this.f12958d = false;
                }
                return this.f12967m.equals(string) ? null : null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        c = null;
        if (bundle.containsKey("result")) {
            return null;
        }
        str = new String(C3193e.m14157b(c, C3190b.m14118a(bundle.getString("result"))), "utf-8");
        if (str != null) {
            return null;
        }
        jSONObject = new JSONObject(str);
        if (jSONObject.has(HwAccountConstants.EXTRA_OPLOG_ERROR)) {
            apVar = new ap();
            if (jSONObject.has(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME)) {
                apVar.m17287a(jSONObject.getLong(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
            }
            if (jSONObject.has("acc")) {
                apVar.m17286a((float) jSONObject.getInt("acc"));
            }
            if (jSONObject.has("dir")) {
                apVar.m17293b(Float.parseFloat(jSONObject.getString("dir")));
            }
            apVar.m17302f(LocationProviderProxy.AMapNetwork);
            if (jSONObject.has("lat")) {
                d = 0.0d;
            } else {
                d = jSONObject.getDouble("lat");
            }
            if (jSONObject.has("lon")) {
                d2 = 0.0d;
            } else {
                d2 = jSONObject.getDouble("lon");
            }
            if (jSONObject.has("type")) {
                obj = null;
            } else {
                obj = jSONObject.getString("type");
            }
            if (jSONObject.has(ParamKey.POINAME)) {
                str2 = null;
            } else {
                str2 = jSONObject.getString(ParamKey.POINAME);
            }
            apVar.m17324q(str2);
            if (jSONObject.has("desc")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("desc");
            }
            apVar.m17310j(str2);
            if (jSONObject.has("street")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("street");
            }
            apVar.m17322p(str2);
            if (jSONObject.has("pid")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("pid");
            }
            apVar.m17289a(str2);
            if (jSONObject.has("flr")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("flr");
            }
            apVar.m17294b(str2);
            if (jSONObject.has("road")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("road");
            }
            apVar.m17320o(str2);
            if (jSONObject.has("city")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("city");
            }
            apVar.m17318n(str2);
            if (jSONObject.has("country")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("country");
            }
            apVar.m17314l(str2);
            if (jSONObject.has("citycode")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("citycode");
            }
            apVar.m17308i(str2);
            if (jSONObject.has("province")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("province");
            }
            apVar.m17316m(str2);
            if (jSONObject.has("adcode")) {
                str2 = null;
            } else {
                str2 = jSONObject.getString("adcode");
            }
            apVar.m17312k(str2);
            if (jSONObject.has(DistrictSearchQuery.KEYWORDS_DISTRICT)) {
                str2 = null;
            } else {
                str2 = jSONObject.getString(DistrictSearchQuery.KEYWORDS_DISTRICT);
            }
            apVar.m17296c(str2);
            if ("WGS84".equals(obj)) {
            }
            apVar.m17292b(d);
            apVar.m17285a(d2);
            return apVar;
        }
        string = jSONObject.getString(HwAccountConstants.EXTRA_OPLOG_ERROR);
        if (this.f12964j.equals(string)) {
            this.f12958d = false;
        }
        if (this.f12965k.equals(string)) {
            this.f12958d = false;
        }
        if (this.f12966l.equals(string)) {
            this.f12958d = false;
        }
        if (this.f12967m.equals(string)) {
        }
    }
}
