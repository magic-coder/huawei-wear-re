package com.huawei.common.applog.bean;

import android.text.TextUtils;
import com.huawei.feedback.c;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtraBundle {
    private static final String TAG = "ReportApi/ExtraBundle";
    private JSONObject json = new JSONObject();

    public void putData(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.json.putOpt(c.f(str), c.f(str2));
                com.huawei.phoneserviceuni.common.d.c.c(TAG, "putData data!");
            }
        } catch (JSONException e) {
            com.huawei.phoneserviceuni.common.d.c.d(TAG, "putData JSONException!");
        }
    }

    public String toString() {
        return this.json.toString();
    }
}
