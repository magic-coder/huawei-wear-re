package com.huawei.ui.main.stories.lightcloud.service;

import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.ui.main.stories.lightcloud.data.LightCloudObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LightCloudParse {
    private static final String TAG = "UIDV_LightCloudParse";

    public static List<LightCloudObject> parseResult(String str) {
        C2538c.m12677c(TAG, "parseResult");
        List<LightCloudObject> arrayList = new ArrayList();
        int i = -1;
        if (str == null || str.equals("")) {
            C2538c.m12677c(TAG, "result is null");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("resultCode")) {
                    i = jSONObject.getInt("resultCode");
                }
                C2538c.m12677c(TAG, "resultCode = ", Integer.valueOf(i));
                if (i == 0 && !jSONObject.isNull(LightCloudConstants.FILE_INFOS)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(LightCloudConstants.FILE_INFOS);
                    if (jSONArray != null) {
                        C2538c.m12677c(TAG, "jsonArray.length = ", Integer.valueOf(jSONArray.length()));
                        arrayList = parseJsonArray(jSONArray);
                    }
                }
            } catch (JSONException e) {
                C2538c.m12677c(TAG, "JSONException : " + e.getMessage());
            }
        }
        return arrayList;
    }

    private static List<LightCloudObject> parseJsonArray(JSONArray jSONArray) {
        C2538c.m12677c(TAG, "parseJsonArray");
        List<LightCloudObject> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            C2538c.m12677c(TAG, "jsonArray is null or no data");
            return arrayList;
        }
        C2538c.m12677c(TAG, "jsonArray.length() = " + jSONArray.length());
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject == null || jSONObject.isNull("resultCode")) {
                    C2538c.m12680e(TAG, "jsonObject is null or no resultCode ");
                    i++;
                } else {
                    int i2 = jSONObject.getInt("resultCode");
                    C2538c.m12677c(TAG, "fileInfos resultCode = ", Integer.valueOf(i2));
                    if (i2 == 0) {
                        LightCloudObject lightCloudObject = new LightCloudObject();
                        if (!jSONObject.isNull(LightCloudConstants.FILE_ID)) {
                            lightCloudObject.setFileId(jSONObject.getString(LightCloudConstants.FILE_ID));
                        }
                        if (!jSONObject.isNull("ver")) {
                            lightCloudObject.setVer(jSONObject.getString("ver"));
                        }
                        if (!jSONObject.isNull(LightCloudConstants.DOWNLOAD_URL)) {
                            lightCloudObject.setDownloadUrl(jSONObject.getString(LightCloudConstants.DOWNLOAD_URL));
                        }
                        arrayList.add(lightCloudObject);
                    }
                    i++;
                }
            } catch (JSONException e) {
                C2538c.m12680e(TAG, "JSONException : " + e.getMessage());
            }
        }
        return arrayList;
    }
}
