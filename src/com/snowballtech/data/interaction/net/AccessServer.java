package com.snowballtech.data.interaction.net;

import android.text.TextUtils;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AccessServer {
    public static final int GET = 0;
    public static final int POST_BODY = 2;
    public static final int POST_KEY_VALUE = 1;
    private String TAG = "access_server";
    private HttpConfig hc = new HttpConfig();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String changeInputStream(okhttp3.Response r10) {
        /*
        r9 = this;
        r4 = new java.lang.StringBuffer;
        r4.<init>();
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r0];
        r0 = 0;
        if (r10 == 0) goto L_0x0030;
    L_0x000d:
        r2 = r10.body();	 Catch:{ Exception -> 0x0056 }
        r6 = r2.byteStream();	 Catch:{ Exception -> 0x0056 }
    L_0x0015:
        r7 = r6.read(r5);	 Catch:{ Exception -> 0x0056 }
        r2 = -1;
        if (r7 == r2) goto L_0x0029;
    L_0x001c:
        r2 = (long) r7;
        r2 = r2 + r0;
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0075 }
        r1 = 0;
        r0.<init>(r5, r1, r7);	 Catch:{ Exception -> 0x0075 }
        r4.append(r0);	 Catch:{ Exception -> 0x0075 }
        r0 = r2;
        goto L_0x0015;
    L_0x0029:
        r2 = r10.body();	 Catch:{ Exception -> 0x0051 }
        r2.close();	 Catch:{ Exception -> 0x0051 }
    L_0x0030:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " costtime total content-length:";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r1 = " bytes ";
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.snowballtech.common.log.LogUtil.log(r0);
        r0 = r4.toString();
        return r0;
    L_0x0051:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0030;
    L_0x0056:
        r2 = move-exception;
    L_0x0057:
        r2.printStackTrace();	 Catch:{ all -> 0x0067 }
        r2 = r10.body();	 Catch:{ Exception -> 0x0062 }
        r2.close();	 Catch:{ Exception -> 0x0062 }
        goto L_0x0030;
    L_0x0062:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0030;
    L_0x0067:
        r0 = move-exception;
        r1 = r10.body();	 Catch:{ Exception -> 0x0070 }
        r1.close();	 Catch:{ Exception -> 0x0070 }
    L_0x006f:
        throw r0;
    L_0x0070:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x006f;
    L_0x0075:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r8;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snowballtech.data.interaction.net.AccessServer.changeInputStream(okhttp3.Response):java.lang.String");
    }

    public String request(String str, Map<String, String> map, String str2, Map<String, String> map2, int i, String str3) {
        String str4 = " request ";
        LogUtil.log(this.TAG, str4 + LogUtil.ACCESS_SERVER + " start url:" + str + ",body=" + str2 + ",param:" + JsonUtil.getInstance().serializeObject(map, new boolean[0]));
        long currentTimeMillis = System.currentTimeMillis();
        String str5 = null;
        switch (i) {
            case 0:
                str5 = changeInputStream(doGet(str, map2));
                break;
            case 1:
                str5 = changeInputStream(doPostForKeyValue(str, map, map2));
                break;
            case 2:
                str5 = changeInputStream(doPostForBody(str, str2, map2, str3));
                break;
            default:
                LogUtil.loge(this.TAG, str4 + LogUtil.ACCESS_SERVER + "method:" + i + " is unknown");
                break;
        }
        LogUtil.log(this.TAG, " costtime: " + (System.currentTimeMillis() - currentTimeMillis) + " ms " + str4 + LogUtil.ACCESS_SERVER + " end , result:" + str5);
        return str5;
    }

    private InputStream fetchInputStream(Response response) {
        InputStream inputStream = null;
        if (response != null) {
            try {
                inputStream = response.body().byteStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return inputStream;
    }

    public InputStream requestInputStream(String str, Map<String, String> map, String str2, Map<String, String> map2, int i, String str3) {
        String str4 = " requestInputStream ";
        LogUtil.log(this.TAG, str4 + LogUtil.ACCESS_SERVER + " start url:" + str + ",body=" + str2 + ",param:" + JsonUtil.getInstance().serializeObject(map, new boolean[0]));
        long currentTimeMillis = System.currentTimeMillis();
        InputStream inputStream = null;
        switch (i) {
            case 0:
                inputStream = fetchInputStream(doGet(str, map2));
                break;
            case 1:
                inputStream = fetchInputStream(doPostForKeyValue(str, map, map2));
                break;
            case 2:
                inputStream = fetchInputStream(doPostForBody(str, str2, map2, str3));
                break;
            default:
                LogUtil.loge(this.TAG, str4 + LogUtil.ACCESS_SERVER + "method:" + i + " is unknown");
                break;
        }
        LogUtil.log(this.TAG, " costtime: " + (System.currentTimeMillis() - currentTimeMillis) + " ms " + str4 + LogUtil.ACCESS_SERVER + " end , result:" + inputStream);
        return inputStream;
    }

    private Response doPostForKeyValue(String str, Map<String, String> map, Map<String, String> map2) {
        Response execute;
        Exception e;
        String str2 = " doPostForKeyValue ";
        try {
            Builder builder = new Builder();
            FormBody.Builder builder2 = new FormBody.Builder();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                        builder2.add((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            builder.url(str).post(builder2.build());
            Request build = builder.build();
            if (map2 != null && map2.size() > 0) {
                builder.headers(this.hc.buildHeadersForOk(map2));
            }
            execute = this.hc.getOkHttpClient().newCall(build).execute();
            try {
                if (execute.isSuccessful()) {
                    LogUtil.log(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access successfully " + execute.code() + "," + execute.message());
                } else {
                    LogUtil.loge(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access failure ");
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                LogUtil.loge(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access exception " + e.getMessage());
                return execute;
            }
        } catch (Exception e3) {
            e = e3;
            execute = null;
            e.printStackTrace();
            LogUtil.loge(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access exception " + e.getMessage());
            return execute;
        }
        return execute;
    }

    private Response doPostForBody(String str, String str2, Map<String, String> map, String str3) {
        Response execute;
        Exception e;
        String str4 = " doPostForBody ";
        LogUtil.log(this.TAG, str4 + LogUtil.ACCESS_SERVER + " request_headers=" + JsonUtil.getInstance().serializeObject(map, new boolean[0]));
        LogUtil.log(this.TAG, str4 + LogUtil.ACCESS_SERVER + " start url:" + str + ",request_param=" + str2);
        try {
            Builder builder = new Builder();
            builder.url(str);
            if (ValueUtil.isEmpty(str3)) {
                str3 = "application/json;charset=utf-8";
            }
            RequestBody create = RequestBody.create(MediaType.parse(str3), str2);
            if (map != null && map.size() > 0) {
                builder.headers(this.hc.buildHeadersForOk(map));
            }
            execute = this.hc.getOkHttpClient().newCall(builder.post(create).build()).execute();
            try {
                if (execute.isSuccessful()) {
                    LogUtil.log(this.TAG, str4 + LogUtil.ACCESS_SERVER + " access successfully " + execute.code() + "," + execute.message());
                } else {
                    LogUtil.loge(this.TAG, str4 + LogUtil.ACCESS_SERVER + " access failure " + execute.code() + "," + execute.message());
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                LogUtil.loge(this.TAG, str4 + LogUtil.ACCESS_SERVER + " access exception " + e.getMessage());
                return execute;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            execute = null;
            e = exception;
            e.printStackTrace();
            LogUtil.loge(this.TAG, str4 + LogUtil.ACCESS_SERVER + " access exception " + e.getMessage());
            return execute;
        }
        return execute;
    }

    private Response doGet(String str, Map<String, String> map) {
        Response execute;
        Exception e;
        String str2 = " doGet ";
        LogUtil.log(this.TAG, str2 + LogUtil.ACCESS_SERVER + " start url:" + str);
        System.currentTimeMillis();
        try {
            Builder builder = new Builder();
            builder.url(str);
            if (map != null && map.size() > 0) {
                builder.headers(this.hc.buildHeadersForOk(map));
            }
            execute = this.hc.getOkHttpClient().newCall(builder.build()).execute();
            try {
                if (execute.isSuccessful()) {
                    LogUtil.log(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access successfully " + execute.code() + "," + execute.message());
                } else {
                    LogUtil.loge(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access failure ");
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                LogUtil.loge(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access exception " + e.getMessage());
                return execute;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            execute = null;
            e = exception;
            e.printStackTrace();
            LogUtil.loge(this.TAG, str2 + LogUtil.ACCESS_SERVER + " access exception " + e.getMessage());
            return execute;
        }
        return execute;
    }

    public void release() {
        this.hc.release();
        this.hc = null;
    }
}
