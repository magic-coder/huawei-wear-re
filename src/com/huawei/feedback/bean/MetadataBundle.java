package com.huawei.feedback.bean;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class MetadataBundle {
    private static final String TAG = "AppLogApi/MetadataBundle";
    private JSONObject json = new JSONObject();

    public MetadataBundle(int i, String str, String str2) {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            this.json.putOpt("Eventid", Integer.valueOf(i));
            this.json.putOpt("HappenTime", format);
            this.json.putOpt("Package", str);
            this.json.putOpt("Version", str2);
        } catch (JSONException e) {
            Log.e(TAG, "MetadataBundle JSONException!");
        }
    }

    public void putData(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.json.putOpt(str, str2.replaceAll("(\r\n|\r|\n|\n\r)", HwAccountConstants.BLANK));
            }
        } catch (JSONException e) {
            Log.e(TAG, "putData JSONException!");
        }
    }

    public String toString() {
        return this.json.toString();
    }
}
