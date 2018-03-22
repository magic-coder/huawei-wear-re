package com.huawei.p190v;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.LinkedHashMap;

/* compiled from: LogUtil */
class C2543h {
    private LinkedHashMap f9062a = new LinkedHashMap();

    public C2543h(String str, String str2, String str3) {
        try {
            this.f9062a.put("V", str2);
            this.f9062a.put("T", str3);
        } catch (Exception e) {
            Log.e("AppLogStandardApi/StandardMetadataBundle", "StandardMetadataBundle JSONException!");
        }
    }

    public void m12693a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f9062a.put(str, str2.replaceAll("(\r\n|\r|\n|\n\r)", HwAccountConstants.BLANK));
            }
        } catch (Exception e) {
            Log.e("AppLogStandardApi/StandardMetadataBundle", "putData JSONException!");
        }
    }

    public String toString() {
        return this.f9062a.toString();
    }
}
