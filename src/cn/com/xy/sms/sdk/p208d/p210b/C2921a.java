package cn.com.xy.sms.sdk.p208d.p210b;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3049n;
import org.json.JSONArray;
import org.json.JSONObject;

public class C2921a {
    public static ContentValues m13128a(ContentValues contentValues, boolean z, JSONObject jSONObject, String... strArr) {
        if (jSONObject == null || strArr.length == 0) {
            return null;
        }
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = (String) C3045j.m13620a(jSONObject, strArr[i]);
            if (!z || !C3049n.m13653e(str)) {
                contentValues.put(strArr[i], C3045j.m13620a(jSONObject, strArr[i]).toString());
            }
        }
        return contentValues;
    }

    public static ContentValues m13129a(ContentValues contentValues, boolean z, String... strArr) {
        if (strArr == null || strArr.length % 2 != 0) {
            return null;
        }
        if (contentValues == null) {
            contentValues = new ContentValues();
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            if (!(z && (C3049n.m13653e(strArr[i]) || C3049n.m13653e(strArr[i + 1])))) {
                contentValues.put(strArr[i], C3049n.m13660k(strArr[i + 1]));
            }
            i += 2;
        }
        return contentValues;
    }

    public static ContentValues m13130a(ContentValues contentValues, String... strArr) {
        return C2921a.m13129a(contentValues, false, strArr);
    }

    public static JSONArray m13131a(String[] strArr, C2962e c2962e) {
        if (c2962e != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                while (c2962e.m13327b()) {
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < strArr.length; i++) {
                        jSONObject.put(strArr[i], C3049n.m13660k(c2962e.m13328c(i)));
                    }
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (Throwable th) {
                new StringBuilder("loadArrDataFromCursor Throwable=").append(th.getLocalizedMessage());
            }
        }
        return null;
    }

    public static JSONObject m13132b(String[] strArr, C2962e c2962e) {
        if (c2962e != null) {
            try {
                if (!c2962e.m13327b()) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < strArr.length; i++) {
                    jSONObject.put(strArr[i], C3049n.m13660k(c2962e.m13328c(i)));
                }
                return jSONObject;
            } catch (Throwable th) {
                new StringBuilder("loadSingleDataFromCursor Throwable=").append(th.getLocalizedMessage());
            }
        }
        return null;
    }
}
