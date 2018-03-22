package com.huawei.ui.main.stories.lightcloud.constants;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.data.JoinInfo;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class JoinRuleParse {
    private static final String TAG = "UIDV_JoinRuleParse";

    public static int parseResult(Context context) {
        C2538c.m12677c(TAG, "parseResult");
        int i = -1;
        String str = "";
        str = BaseApplication.m2632b().getFilesDir().getAbsolutePath() + File.separator + LightCloudConstants.DOWNLOAD_DIR + File.separator + LightCloudConstants.JOIN_CONFIG + File.separator + JoinConstants.JOIN_ZIP;
        C2538c.m12677c(TAG, "parseResult filePath:" + str);
        Object stringFile = getStringFile(str);
        C2538c.m12677c(TAG, "parseResult resp: " + stringFile);
        if (TextUtils.isEmpty(stringFile)) {
            C2538c.m12677c(TAG, "resp is null ");
        } else {
            i = saveParse(context, stringFile);
        }
        C2538c.m12677c(TAG, "AIRuleParse finish ");
        return i;
    }

    private static String getStringFile(String str) {
        InputStream fileInputStream;
        IOException e;
        Throwable th;
        String str2 = "";
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                if (fileInputStream.read(bArr) > 0) {
                    str2 = new String(bArr, GameManager.DEFAULT_CHARSET);
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        C2538c.m12680e(TAG, "inputStream.close IOException", e2.getMessage());
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    C2538c.m12680e(TAG, "getStringFile IOException :", e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            C2538c.m12680e(TAG, "inputStream.close IOException", e22.getMessage());
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e222) {
                            C2538c.m12680e(TAG, "inputStream.close IOException", e222.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e222 = e4;
            fileInputStream = null;
            C2538c.m12680e(TAG, "getStringFile IOException :", e222.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str2;
    }

    public static int saveParse(Context context, String str) {
        C2538c.m12677c(TAG, "saveParse resp:" + str);
        if (TextUtils.isEmpty(str)) {
            C2538c.m12677c(TAG, "saveParse empty return");
            return -1;
        }
        Gson gson = new Gson();
        Object joinInfo = new JoinInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("isNeedMigrate")) {
                joinInfo.isNeedMigrate = jSONObject.getBoolean("isNeedMigrate");
            }
            if (!jSONObject.isNull("isForceMigrate")) {
                joinInfo.isForceMigrate = jSONObject.getBoolean("isForceMigrate");
            }
            if (!jSONObject.isNull("lowVersion")) {
                joinInfo.lowVersion = jSONObject.getString("lowVersion");
            }
        } catch (JSONException e) {
            C2538c.m12680e(TAG, "JSONException: ", e.getMessage());
        }
        C2538c.m12677c(TAG, "saveParse resp:" + joinInfo.toString());
        C2538c.m12677c(TAG, "saveParse gson:" + gson.toJson(joinInfo));
        C0993c c0993c = new C0993c();
        C0996a.m3611a(context, String.valueOf(10000), "health_support_note_migrate_", joinInfo.isNeedMigrate + "", c0993c);
        C0996a.m3611a(context, String.valueOf(10000), "health_support_force_migrate_", joinInfo.isForceMigrate + "", c0993c);
        C0996a.m3611a(context, String.valueOf(10000), "health_support_current_type_version", joinInfo.lowVersion, c0993c);
        return 0;
    }
}
