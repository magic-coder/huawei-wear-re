package com.huawei.hwid.api.common.p424a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.vermanager.C5313c;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: OpenGWHttpUtils */
public class C5070b {
    public static HttpResponse m24394a(Context context, HttpUriRequest httpUriRequest) throws UnsupportedEncodingException, IllegalArgumentException, IllegalStateException, IOException {
        try {
            return C5313c.m25694a().mo4682a(context, 8000, 443).execute(httpUriRequest);
        } catch (Exception e) {
            if (e instanceof UnsupportedEncodingException) {
                throw new UnsupportedEncodingException("UnsupportedEncodingException[don't set proxy]:" + e.getMessage());
            } else if (e instanceof IllegalArgumentException) {
                throw new IllegalArgumentException("IllegalArgumentException[don't set proxy]:" + e.getMessage());
            } else if (e instanceof IllegalStateException) {
                throw new IllegalStateException("IllegalStateException[don't set proxy]:" + e.getMessage());
            } else if (e instanceof IOException) {
                throw new IOException("IOException[don't set proxy]:" + e.getMessage());
            } else {
                throw new UnknownHostException("don't set proxy");
            }
        }
    }

    public static String m24393a(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            Object obj2 = bundle.get(str);
            if (obj2 != null) {
                obj2 = String.valueOf(obj2);
                if (!TextUtils.isEmpty(obj2)) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(SNBConstant.FILTER);
                    }
                    stringBuilder.append(URLEncoder.encode(str)).append("=").append(URLEncoder.encode(obj2));
                }
            }
        }
        C5165e.m24904a("OpenGWHttpUtils", "encode url = ");
        return stringBuilder.toString();
    }

    public static boolean m24395a(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static Bundle m24396b(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split(SNBConstant.FILTER)) {
                String split2;
                String[] split3 = split2.split("=");
                if (2 == split3.length) {
                    String str2 = split3[0];
                    split2 = split3[1];
                    if (!(C5070b.m24395a(str2) || C5070b.m24395a(split2))) {
                        bundle.putString(URLDecoder.decode(str2), URLDecoder.decode(split2));
                    }
                }
            }
        }
        return bundle;
    }
}
