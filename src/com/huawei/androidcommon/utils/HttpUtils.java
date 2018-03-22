package com.huawei.androidcommon.utils;

import android.util.Log;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.androidcommon.constants.AC;
import com.huawei.androidcommon.dependence.MonitorableMultipartEntity;
import com.huawei.androidcommon.dependence.MonitorableOutputStream.OutputStreamListener;
import com.huawei.androidcommon.dependence.TrustAllSSLSocketFactory;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.spi.LocationInfo;

public class HttpUtils {
    private static final String CHARSET = "UTF-8";
    private static HttpUtils instance;
    private HttpClientHook hooker = null;
    private DefaultHttpClient httpClient = null;

    public interface HttpClientHook {
        String hookReturnValue(String str, String str2, String str3, Map<String, String> map);
    }

    public class Result {
        public String content = "";
        public int statusCode;

        public boolean isResponseOK() {
            return this.statusCode == 200;
        }

        public boolean isInternalError() {
            return this.statusCode >= 500;
        }

        public boolean isForbit() {
            return this.statusCode == HttpStatus.SC_FORBIDDEN;
        }

        public boolean isRedirect() {
            return this.statusCode == HttpStatus.SC_MOVED_TEMPORARILY || this.statusCode == 301 || this.statusCode == HttpStatus.SC_SEE_OTHER || this.statusCode == 307;
        }

        public String toString() {
            return this.statusCode + "\t" + this.content;
        }
    }

    private HttpUtils() {
        if (this.httpClient == null) {
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            HttpProtocolParams.setUseExpectContinue(basicHttpParams, true);
            HttpProtocolParams.setUserAgent(basicHttpParams, "Mozilla/5.0(Linux;U;Android 5.0;en-us;Nexus One Build.FRG83) AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1");
            ConnManagerParams.setTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", getSSLSocketFactory(), 443));
            this.httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        }
    }

    public static HttpUtils getInstance() {
        if (instance == null) {
            instance = new HttpUtils();
        }
        return instance;
    }

    private static SSLSocketFactory getSSLSocketFactory() {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            SSLSocketFactory trustAllSSLSocketFactory = new TrustAllSSLSocketFactory(instance);
            trustAllSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return trustAllSSLSocketFactory;
        } catch (Throwable e) {
            Log.w(AC.TAG, "[HttpUtils.getSSLSocketFactory]Error:", e);
            return null;
        }
    }

    public Result postData(String str, Map<String, String> map) {
        return postData(str, "", (Map) map);
    }

    public Result postData(String str, String str2, Map<String, String> map) {
        return postData(str, str2, map, null, null, null);
    }

    public Result postData(String str, String str2, String str3) {
        return postData(str, str2, str3, null, null, null);
    }

    public Result postData(String str, String str2, String str3, Map<String, String> map) {
        return postData(str, str2, str3, null, null, map);
    }

    public Result postData(String str, String str2, Object obj, Map<String, String> map, OutputStreamListener outputStreamListener, Map<String, String> map2) {
        Throwable e;
        HttpRequestBase httpRequestBase = null;
        Result result = new Result();
        HttpRequestBase httpPost;
        try {
            Log.d(AC.TAG, "[HttpUtils.postData] >>>>>>>>Start requestURL:" + str);
            httpPost = new HttpPost(str);
            try {
                String obj2;
                fillHeader(httpPost, str2, map2);
                if (map == null || map.isEmpty()) {
                    List arrayList = new ArrayList();
                    if (obj instanceof Map) {
                        for (Entry entry : ((Map) obj).entrySet()) {
                            arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
                        }
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                    } else if (obj instanceof String) {
                        obj2 = obj.toString();
                        HttpEntity stringEntity = new StringEntity(obj2, "UTF-8");
                        if ((obj2.startsWith("{") && obj2.endsWith("}")) || (obj2.startsWith("[{") && obj2.endsWith("}]"))) {
                            stringEntity.setContentType("application/json");
                        }
                        httpPost.setEntity(stringEntity);
                    }
                } else {
                    HttpEntity monitorableMultipartEntity = new MonitorableMultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, outputStreamListener);
                    if (obj instanceof Map) {
                        for (Entry entry2 : ((Map) obj).entrySet()) {
                            monitorableMultipartEntity.addPart((String) entry2.getKey(), new StringBody((String) entry2.getValue()));
                        }
                    }
                    for (Entry entry22 : map.entrySet()) {
                        monitorableMultipartEntity.addPart((String) entry22.getKey(), new FileBody(new File((String) entry22.getValue())));
                    }
                    httpPost.setEntity(monitorableMultipartEntity);
                }
                HttpResponse execute = this.httpClient.execute(httpPost);
                result.statusCode = execute.getStatusLine().getStatusCode();
                if (result.isRedirect()) {
                    Header firstHeader = execute.getFirstHeader(LocationManagerProxy.KEY_LOCATION_CHANGED);
                    if (firstHeader != null) {
                        obj2 = firstHeader.getValue();
                        if (obj2 == null || obj2.equals("")) {
                            obj2 = "/";
                        }
                        releaseConnection(httpPost);
                        Result data = getData(obj2, null);
                        if (httpPost == null) {
                            return data;
                        }
                        releaseConnection(httpPost);
                        return data;
                    }
                    Log.i(AC.TAG, "Invalid redirect");
                }
                if (result.isResponseOK()) {
                    result.content = EntityUtils.toString(execute.getEntity(), "UTF-8");
                    releaseConnection(httpPost);
                    if (httpPost != null) {
                        releaseConnection(httpPost);
                    }
                    return result;
                }
                Log.e(AC.TAG, "server internal error, errorCode=" + result.statusCode);
                if (httpPost != null) {
                    releaseConnection(httpPost);
                }
                return result;
            } catch (Exception e2) {
                e = e2;
                httpRequestBase = httpPost;
            } catch (Throwable th) {
                e = th;
            }
        } catch (Exception e3) {
            e = e3;
            try {
                Log.e(AC.TAG, "Error", e);
                if (httpRequestBase != null) {
                    releaseConnection(httpRequestBase);
                }
                return result;
            } catch (Throwable th2) {
                e = th2;
                httpPost = httpRequestBase;
                if (httpPost != null) {
                    releaseConnection(httpPost);
                }
                throw e;
            }
        } catch (Throwable th3) {
            e = th3;
            httpPost = null;
            if (httpPost != null) {
                releaseConnection(httpPost);
            }
            throw e;
        }
    }

    public Result getFile(String str, String str2) {
        Throwable e;
        HttpRequestBase httpRequestBase;
        Throwable th;
        Closeable closeable = null;
        Result result = new Result();
        HttpRequestBase httpGet;
        try {
            httpGet = new HttpGet(str);
            try {
                fillHeader(httpGet, "", null);
                HttpResponse execute = this.httpClient.execute(httpGet);
                result.statusCode = execute.getStatusLine().getStatusCode();
                if (result.isResponseOK()) {
                    InputStream content = execute.getEntity().getContent();
                    Closeable randomAccessFile = new RandomAccessFile(str2, "rw");
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = content.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            randomAccessFile.write(bArr, 0, read);
                        }
                        releaseConnection(httpGet);
                        IOUtils.close(randomAccessFile);
                        if (httpGet != null) {
                            releaseConnection(httpGet);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        closeable = randomAccessFile;
                        httpRequestBase = httpGet;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = randomAccessFile;
                    }
                } else {
                    Log.e(AC.TAG, "server internal error, errorCode=" + result.statusCode);
                    IOUtils.close(null);
                    if (httpGet != null) {
                        releaseConnection(httpGet);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                httpRequestBase = httpGet;
                try {
                    Log.e(AC.TAG, "Error", e);
                    IOUtils.close(closeable);
                    if (httpRequestBase != null) {
                        releaseConnection(httpRequestBase);
                    }
                    return result;
                } catch (Throwable th3) {
                    th = th3;
                    httpGet = httpRequestBase;
                    IOUtils.close(closeable);
                    if (httpGet != null) {
                        releaseConnection(httpGet);
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                IOUtils.close(closeable);
                if (httpGet != null) {
                    releaseConnection(httpGet);
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            httpRequestBase = null;
            Log.e(AC.TAG, "Error", e);
            IOUtils.close(closeable);
            if (httpRequestBase != null) {
                releaseConnection(httpRequestBase);
            }
            return result;
        } catch (Throwable th5) {
            th = th5;
            httpGet = null;
            IOUtils.close(closeable);
            if (httpGet != null) {
                releaseConnection(httpGet);
            }
            throw th;
        }
        return result;
    }

    public Result getData(String str, String str2, String str3, Map<String, String> map) {
        Result result = new Result();
        return getData(str2, str3, map);
    }

    public Result getData(String str, Map<String, String> map) {
        return getData(str, "", map);
    }

    public Result getData(String str, String str2, Map<String, String> map) {
        HttpRequestBase httpGet;
        Throwable e;
        HttpRequestBase httpRequestBase = null;
        Log.d(AC.TAG, "[HttpUtils.getData] >>>>>>>>Start requestURL:" + str);
        long currentTimeMillis = System.currentTimeMillis();
        Result result = new Result();
        try {
            StringBuilder stringBuilder = new StringBuilder(str);
            if (map != null) {
                if (!str.contains(LocationInfo.NA)) {
                    stringBuilder.append(LocationInfo.NA);
                } else if (!str.endsWith(SNBConstant.FILTER)) {
                    stringBuilder.append(SNBConstant.FILTER);
                }
                for (Entry entry : map.entrySet()) {
                    String encode = URLEncoder.encode((String) entry.getValue(), "UTF-8");
                    Log.d(AC.TAG, "val : " + encode);
                    stringBuilder.append((String) entry.getKey()).append("=").append(encode).append(SNBConstant.FILTER);
                }
            }
            String stringBuilder2 = stringBuilder.toString();
            httpGet = new HttpGet(stringBuilder2.replace(HwAccountConstants.BLANK, "%20"));
            try {
                fillHeader(httpGet, str2, null);
                HttpResponse execute = this.httpClient.execute(httpGet);
                result.statusCode = execute.getStatusLine().getStatusCode();
                if (result.isResponseOK()) {
                    result.content = EntityUtils.toString(execute.getEntity(), "UTF-8");
                    result.content = hookReturnValue(stringBuilder2, str2, result.content, map);
                    if (httpGet != null) {
                        releaseConnection(httpGet);
                    }
                    Log.d(AC.TAG, "[HttpUtils.getData] >>>>>>>>The request time is(ms):" + (System.currentTimeMillis() - currentTimeMillis));
                    return result;
                }
                Log.e(AC.TAG, "[HttpUtils.getData] server internal error, errorCode=" + result.statusCode);
                if (httpGet != null) {
                    releaseConnection(httpGet);
                }
                return result;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.e(AC.TAG, "[HttpUtils.getData] Error", e);
                    if (httpGet != null) {
                        releaseConnection(httpGet);
                    }
                    Log.d(AC.TAG, "[HttpUtils.getData] >>>>>>>>The request time is(ms):" + (System.currentTimeMillis() - currentTimeMillis));
                    return result;
                } catch (Throwable th) {
                    e = th;
                    httpRequestBase = httpGet;
                    if (httpRequestBase != null) {
                        releaseConnection(httpRequestBase);
                    }
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            httpGet = null;
        } catch (Throwable th2) {
            e = th2;
        }
    }

    private void fillHeader(HttpRequestBase httpRequestBase, String str, Map<String, String> map) {
        httpRequestBase.getParams().setParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, Boolean.valueOf(true));
        if (map != null) {
            try {
                for (Entry entry : map.entrySet()) {
                    httpRequestBase.setHeader((String) entry.getKey(), URLEncoder.encode((String) entry.getValue(), "utf-8"));
                }
            } catch (Throwable e) {
                Log.e(AC.TAG, "[HttpUtils.fillHeader] Error", e);
            }
        }
        httpRequestBase.setHeader("Accept", "image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, application/x-shockwave-flash, */*");
        httpRequestBase.setHeader("Referer", str);
        httpRequestBase.setHeader("Accept-Language", "zh-cn");
        httpRequestBase.setHeader("UA-CPU", "x86");
        httpRequestBase.setHeader("Connection", "Keep-Alive");
        httpRequestBase.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; MAXTHON 2.0)");
    }

    public Result login(String str, String str2, Map<String, String> map) {
        Log.d(AC.TAG, "[HttpUtils.login].formContent is " + str2);
        Pattern compile = Pattern.compile("<form\\s+.+</form>", 40);
        if (Pattern.compile("name=\"verifyCode\"").matcher(str2).find()) {
            Log.d(AC.TAG, "login many times, need input verifyCode???");
            return null;
        }
        CharSequence group;
        Matcher matcher = compile.matcher(str2);
        String str3 = "";
        if (matcher.find()) {
            group = matcher.group();
        } else {
            Object obj = str3;
        }
        Log.d(AC.TAG, "[HttpUtils.login].form is " + group);
        Map hashMap = new HashMap();
        if (!group.isEmpty()) {
            Matcher matcher2 = Pattern.compile("<input.+?name=\"([^\"]+)\".+?value=\"([^\"]*)\"", 2).matcher(group);
            while (matcher2.find()) {
                hashMap.put(matcher2.group(1), matcher2.group(2));
            }
            for (Entry entry : map.entrySet()) {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
            matcher2 = Pattern.compile("action=\"([^\"]+)\"", 2).matcher(group);
            if (matcher2.find()) {
                str3 = matcher2.group(1);
                Log.d(AC.TAG, "[HttpUtils.login].matcher.find() is true and url is " + str3);
                return postData(new StringBuilder(String.valueOf(str)).append(str3).toString(), hashMap);
            }
        }
        return new Result();
    }

    public void clearCookies() {
        this.httpClient.getCookieStore().clear();
    }

    private void releaseConnection(HttpRequestBase httpRequestBase) {
        if (httpRequestBase != null) {
            httpRequestBase.abort();
        }
    }

    private String hookReturnValue(String str, String str2, String str3, Map<String, String> map) {
        if (this.hooker != null) {
            return this.hooker.hookReturnValue(str, str2, str3, map);
        }
        return str3;
    }
}
