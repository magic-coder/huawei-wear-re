package com.huawei.ui.main.stories.lightcloud;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.ui.main.stories.lightcloud.data.LightCloudObject;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudCallBack;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudHttpCallBack;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudParse;
import com.huawei.ui.main.stories.lightcloud.util.FileUtil;
import com.huawei.ui.main.stories.lightcloud.util.HttpUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LightCloud {
    private static final String TAG = "UIDV_LightCloud";
    private static volatile LightCloud instance = null;
    private Context mContext;

    public static LightCloud getInstance(Context context) {
        C2538c.m12677c(TAG, "getInstance");
        if (instance == null) {
            synchronized (LightCloud.class) {
                if (instance == null) {
                    instance = new LightCloud(context);
                }
            }
        }
        return instance;
    }

    private LightCloud(Context context) {
        C2538c.m12677c(TAG, "LightCloud");
        this.mContext = context.getApplicationContext();
    }

    private void doRefresh(String str, final LightCloudCallBack lightCloudCallBack) {
        C2538c.m12674b(TAG, "doRefresh param = ", str);
        if (C0970w.m3489b()) {
            C2538c.m12677c(TAG, "isNoCloudVersion");
            lightCloudCallBack.onResponce("", -1);
        }
        if (TextUtils.isEmpty(str)) {
            C2538c.m12677c(TAG, "param is null");
            lightCloudCallBack.onResponce("", -2);
            return;
        }
        HttpUtil.doRefresh(LightCloudConstants.GET_LATEST_VERSION_URL, str, new LightCloudHttpCallBack() {
            public void onResponce(int i, String str) {
                C2538c.m12677c(LightCloud.TAG, "pullRefresh resCode = ", Integer.valueOf(i));
                if (200 == i) {
                    LightCloud.this.downloadBatch(LightCloudParse.parseResult(str), lightCloudCallBack);
                    return;
                }
                lightCloudCallBack.onResponce("", -1);
            }
        });
    }

    public void doRefreshBatch(final LightCloudCallBack lightCloudCallBack) {
        C2538c.m12677c(TAG, "doRefreshBatch");
        if (C0970w.m3489b()) {
            C2538c.m12677c(TAG, "isNoCloudVersion");
            lightCloudCallBack.onResponce("", LightCloudConstants.RESPONSE_CODE_NO_ENOUGH);
            return;
        }
        long j = LightCloudConstants.LightCloud_INTERVAL_TIME;
        if (LightCloudConstants.RESPONSE_RESULT_FAIL.equals(C0996a.m3612a(this.mContext, Integer.toString(10000), LightCloudConstants.LightCloud_RESULT))) {
            j = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
        }
        long d = C0977d.m3551d(this.mContext, C0996a.m3612a(this.mContext, Integer.toString(10000), LightCloudConstants.LightCloud_BATCH_TIME));
        long currentTimeMillis = System.currentTimeMillis();
        if (0 == d || Math.abs(currentTimeMillis - d) >= r0) {
            C2538c.m12677c(TAG, "can doRefresh");
            HttpUtil.doRefresh(LightCloudConstants.GET_LATEST_VERSION_URL, getBody(), new LightCloudHttpCallBack() {
                public void onResponce(int i, String str) {
                    C2538c.m12677c(LightCloud.TAG, "pullRefresh resCode = ", Integer.valueOf(i));
                    C0993c c0993c = new C0993c();
                    C0996a.m3611a(LightCloud.this.mContext, String.valueOf(10000), LightCloudConstants.LightCloud_BATCH_TIME, String.valueOf(System.currentTimeMillis()), c0993c);
                    C0996a.m3611a(LightCloud.this.mContext, String.valueOf(10000), LightCloudConstants.LightCloud_RESULT, LightCloudConstants.RESPONSE_RESULT_SUCCESS, c0993c);
                    if (200 == i) {
                        LightCloud.this.downloadBatch(LightCloudParse.parseResult(str), lightCloudCallBack);
                        return;
                    }
                    lightCloudCallBack.onResponce("", -1);
                }
            });
            return;
        }
        C2538c.m12677c(TAG, "doRefresh less than interval time");
        lightCloudCallBack.onResponce("", LightCloudConstants.RESPONSE_CODE_NO_ENOUGH);
    }

    private String getBody() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put(LightCloudConstants.FILE_ID, LightCloudConstants.JOIN_CONFIG);
            Object a = C0996a.m3612a(this.mContext, Integer.toString(10000), LightCloudConstants.JOIN_CONFIG);
            C2538c.m12677c(TAG, "aiId = wearconfig ver1 = " + a);
            if (TextUtils.isEmpty(a)) {
                C2538c.m12677c(TAG, "set ver1 0");
                a = "0";
            }
            jSONObject.put("ver", a);
            jSONArray.put(jSONObject);
            jSONObject2.put(LightCloudConstants.FILE_ID, jSONArray);
            jSONObject2.put(LightCloudConstants.IS_BATCH, "1");
        } catch (JSONException e) {
            C2538c.m12677c(TAG, "JSONException :" + e.getMessage());
        }
        C2538c.m12677c(TAG, "jsonObject.toString():" + jSONObject2.toString());
        return jSONObject2.toString();
    }

    private void downloadBatch(List<LightCloudObject> list, final LightCloudCallBack lightCloudCallBack) {
        C2538c.m12677c(TAG, "downloadBatch");
        if (list != null) {
            C2538c.m12677c(TAG, "pullRefresh list.size =", Integer.valueOf(list.size()));
            if (list.size() == 0) {
                lightCloudCallBack.onResponce("", 20000);
            }
            for (final LightCloudObject lightCloudObject : list) {
                FileUtil.getInstance(this.mContext).doDownload(lightCloudObject, new LightCloudHttpCallBack() {
                    public void onResponce(int i, String str) {
                        C2538c.m12677c(LightCloud.TAG, "doDownload:", "resCode = ", Integer.valueOf(i), " result = ", str);
                        if (i == 0 && LightCloudConstants.RESPONSE_RESULT_SUCCESS.equals(str)) {
                            FileUtil.getInstance(LightCloud.this.mContext).doUnZip(lightCloudObject, lightCloudCallBack);
                        } else if (lightCloudObject != null) {
                            lightCloudCallBack.onResponce(lightCloudObject.getFileId(), -4);
                        } else {
                            lightCloudCallBack.onResponce("", -4);
                        }
                    }
                });
            }
            return;
        }
        C2538c.m12677c(TAG, "download list is null");
    }
}
