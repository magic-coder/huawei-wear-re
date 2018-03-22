package com.huawei.nfc.carrera.logic.ta;

import android.util.Log;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONObject;

public class TATrustedStorageInfo {
    private static final String TA_JSON_KEY_ESE_UNLOCK_TIMES = "ese_unlock_times";
    public int eSEUnlockTimes;

    public interface TATrustedStorageInfoSai1 {
    }

    public interface TATrustedStorageInfoSai2 {
    }

    public interface TATrustedStorageInfoSai3 {
    }

    public interface TATrustedStorageInfoSai4 {
    }

    public interface TATrustedStorageInfoSai5 {
    }

    public interface TATrustedStorageInfoSai6 {
    }

    public interface TATrustedStorageInfoSai7 {
    }

    public interface TATrustedStorageInfoSai8 {
    }

    TATrustedStorageInfo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(TA_JSON_KEY_ESE_UNLOCK_TIMES)) {
                this.eSEUnlockTimes = jSONObject.getInt(TA_JSON_KEY_ESE_UNLOCK_TIMES);
            }
        } catch (Throwable e) {
            LogX.e("create trusted storage info failed: " + Log.getStackTraceString(e));
        }
    }

    String getTaTsInfoJsonStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TA_JSON_KEY_ESE_UNLOCK_TIMES, this.eSEUnlockTimes);
        } catch (Throwable e) {
            LogX.e("getTaTsInfoJsonStr, json exception: " + Log.getStackTraceString(e));
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public String toString() {
        new StringBuffer().append("eSEUnlockTimes=").append(this.eSEUnlockTimes).append("\n");
        return super.toString();
    }
}
