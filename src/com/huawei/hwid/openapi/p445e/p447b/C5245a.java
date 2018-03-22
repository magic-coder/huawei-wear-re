package com.huawei.hwid.openapi.p445e.p447b;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.C5250e;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class C5245a {
    private static final String f18878a = C5213b.f18818a;

    public static String m25428a(Bundle bundle) {
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
        return stringBuilder.toString();
    }

    private static String m25429a(HttpUriRequest httpUriRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(httpUriRequest.getMethod()).append(HwAccountConstants.BLANK).append(httpUriRequest.getProtocolVersion());
        stringBuffer.append(" head:");
        for (Header header : httpUriRequest.getAllHeaders()) {
            stringBuffer.append(header.getName()).append("=").append(header.getValue());
        }
        stringBuffer.append(" reqLine:" + httpUriRequest.getRequestLine());
        return stringBuffer.toString();
    }

    public static HttpResponse m25430a(Context context, HttpUriRequest httpUriRequest) {
        HttpResponse execute;
        Throwable th;
        HttpClient httpClient;
        String property;
        String property2;
        int parseInt;
        try {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            try {
                C5248c.m25445a(f18878a, "direct connect start! req:" + C5245a.m25429a(httpUriRequest));
                execute = defaultHttpClient.execute(httpUriRequest);
            } catch (Throwable e) {
                th = e;
                httpClient = defaultHttpClient;
                if ((VERSION.SDK_INT < 14 ? 1 : null) == null) {
                    property = System.getProperty("http.proxyHost");
                    property2 = System.getProperty("http.proxyPort");
                    if (property2 == null) {
                        property2 = "-1";
                    }
                    parseInt = Integer.parseInt(property2);
                } else {
                    property = Proxy.getHost(context);
                    parseInt = Proxy.getPort(context);
                }
                C5248c.m25447b(f18878a, "proxyHost:" + property + " proxyPort:" + parseInt);
                if (property == null && property.length() > 0 && parseInt != -1 && !C5250e.m25454a(context)) {
                    httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(property, parseInt));
                    try {
                        C5248c.m25447b(f18878a, "have set the proxy, connect with the proxy");
                        execute = httpClient.execute(httpUriRequest);
                        return execute;
                    } catch (NullPointerException e2) {
                        C5248c.m25448b(f18878a, "ERR=" + th.getMessage(), th);
                        throw new UnknownHostException("set proxy");
                    }
                } else if (th instanceof UnsupportedEncodingException) {
                    throw new UnsupportedEncodingException("UnsupportedEncodingException[don't set proxy]:" + th.getMessage());
                } else if (th instanceof IllegalArgumentException) {
                    throw new IllegalArgumentException("IllegalArgumentException[don't set proxy]:" + th.getMessage());
                } else if (th instanceof IllegalStateException) {
                    throw new IllegalStateException("IllegalStateException[don't set proxy]:" + th.getMessage());
                } else if (th instanceof IOException) {
                    throw new UnknownHostException("don't set proxy");
                } else {
                    throw new IOException("IOException[don't set proxy]:" + th.getMessage());
                }
            }
        } catch (Throwable e3) {
            httpClient = null;
            th = e3;
            if (VERSION.SDK_INT < 14) {
            }
            if ((VERSION.SDK_INT < 14 ? 1 : null) == null) {
                property = Proxy.getHost(context);
                parseInt = Proxy.getPort(context);
            } else {
                property = System.getProperty("http.proxyHost");
                property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = "-1";
                }
                parseInt = Integer.parseInt(property2);
            }
            C5248c.m25447b(f18878a, "proxyHost:" + property + " proxyPort:" + parseInt);
            if (property == null) {
            }
            if (th instanceof UnsupportedEncodingException) {
                throw new UnsupportedEncodingException("UnsupportedEncodingException[don't set proxy]:" + th.getMessage());
            } else if (th instanceof IllegalArgumentException) {
                throw new IllegalArgumentException("IllegalArgumentException[don't set proxy]:" + th.getMessage());
            } else if (th instanceof IllegalStateException) {
                throw new IllegalStateException("IllegalStateException[don't set proxy]:" + th.getMessage());
            } else if (th instanceof IOException) {
                throw new UnknownHostException("don't set proxy");
            } else {
                throw new IOException("IOException[don't set proxy]:" + th.getMessage());
            }
        }
        return execute;
    }

    public static UrlEncodedFormEntity m25431a(HashMap hashMap) {
        if (hashMap != null) {
            try {
                if (hashMap.size() != 0) {
                    List arrayList = new ArrayList();
                    for (Entry entry : hashMap.entrySet()) {
                        arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
                    }
                    return new UrlEncodedFormEntity(arrayList, GameManager.DEFAULT_CHARSET);
                }
            } catch (Throwable e) {
                C5248c.m25448b(f18878a, e.toString(), e);
                return null;
            }
        }
        return null;
    }

    public static boolean m25432a(String str) {
        return str == null || str.trim().equals("");
    }

    public static Bundle m25433b(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split(SNBConstant.FILTER)) {
                String split2;
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    String str2 = split3[0];
                    split2 = split3[1];
                    if (!(C5245a.m25432a(str2) || C5245a.m25432a(split2))) {
                        bundle.putString(URLDecoder.decode(str2), URLDecoder.decode(split2));
                    }
                }
            }
        }
        return bundle;
    }

    public static Bundle m25434c(String str) {
        try {
            URL url = new URL(str.replace("bdconnect", "http"));
            Bundle b = C5245a.m25433b(url.getQuery());
            b.putAll(C5245a.m25433b(url.getRef()));
            return b;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }
}
