package com.leisen.wallet.sdk.http;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
import org.apache.log4j.spi.LocationInfo;

public class AsyncHttpClient {
    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_RETRIES = 5;
    public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final int DEFAULT_SOCKET_TIMEOUT = 30000;
    private static final String TAG = "AsyncHttpClient";
    private final Map<String, String> clientHeaderMap;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private boolean isEncodeUrl;
    private int maxConnections;
    private final Map<Context, List<RequestHandle>> requestMap;
    private ExecutorService threadPool;
    private int timeout;
    private boolean useSynchronousMode;

    public AsyncHttpClient(boolean z) {
        this(false, 80, 443);
        this.useSynchronousMode = z;
    }

    public AsyncHttpClient(int i) {
        this(false, i, 443);
    }

    public AsyncHttpClient(int i, int i2) {
        this(false, i, i2);
    }

    public AsyncHttpClient(boolean z, int i, int i2) {
        this(getDefaultSchemeRegistry(z, i, i2));
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean z, int i, int i2) {
        if (i < 1) {
            i = 80;
        }
        if (i2 < 1) {
            i2 = 443;
        }
        SocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i));
        schemeRegistry.register(new Scheme("https", socketFactory, i2));
        return schemeRegistry;
    }

    public AsyncHttpClient(SchemeRegistry schemeRegistry) {
        this.timeout = 30000;
        this.maxConnections = 10;
        this.isEncodeUrl = false;
        this.useSynchronousMode = false;
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) this.timeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.maxConnections));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.timeout);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.timeout);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ClientConnectionManager connectionManager = getConnectionManager(schemeRegistry, basicHttpParams);
        this.threadPool = getDefaultThreadPool();
        this.requestMap = new WeakHashMap();
        this.clientHeaderMap = new HashMap();
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.httpClient = new DefaultHttpClient(connectionManager, basicHttpParams);
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
    }

    private ClientConnectionManager getConnectionManager(SchemeRegistry schemeRegistry, BasicHttpParams basicHttpParams) {
        return createConnectionManager(schemeRegistry, basicHttpParams);
    }

    private ExecutorService getDefaultThreadPool() {
        return Executors.newCachedThreadPool();
    }

    protected ClientConnectionManager createConnectionManager(SchemeRegistry schemeRegistry, BasicHttpParams basicHttpParams) {
        return new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
    }

    public RequestHandle get(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isEncodeUrl, str, requestParams)), null, responseHandlerInterface, context);
    }

    public RequestHandle post(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return post(context, str, paramsToEntity(requestParams, responseHandlerInterface), null, responseHandlerInterface);
    }

    public RequestHandle post(Context context, String str, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPost(URI.create(str).normalize()), httpEntity), str2, responseHandlerInterface, context);
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    private HttpEntity paramsToEntity(RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        HttpEntity httpEntity = null;
        if (requestParams != null) {
            try {
                httpEntity = requestParams.getEntity(responseHandlerInterface);
            } catch (Throwable e) {
                if (responseHandlerInterface != null) {
                    C2538c.e(TAG, new Object[]{"responseHandler != null ==>"});
                    responseHandlerInterface.sendFailureMessage(0, httpEntity, httpEntity, e);
                } else {
                    C2538c.e(TAG, new Object[]{"==>" + e.getMessage()});
                }
            }
        }
        return httpEntity;
    }

    protected RequestHandle sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (responseHandlerInterface == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else {
            if (str != null) {
                httpUriRequest.setHeader("Content-Type", str);
            }
            responseHandlerInterface.setUseSynchronousMode(this.useSynchronousMode);
            responseHandlerInterface.setRequestHeaders(httpUriRequest.getAllHeaders());
            responseHandlerInterface.setRequestURI(httpUriRequest.getURI());
            Runnable newAysncHttpRequest = newAysncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, responseHandlerInterface);
            if (this.useSynchronousMode) {
                newAysncHttpRequest.run();
            } else {
                this.threadPool.submit(newAysncHttpRequest);
            }
            RequestHandle requestHandle = new RequestHandle(newAysncHttpRequest);
            if (context != null) {
                List list = (List) this.requestMap.get(context);
                if (list == null) {
                    list = new LinkedList();
                    this.requestMap.put(context, list);
                }
                list.add(requestHandle);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((RequestHandle) it.next()).shouldBeGarbageCollected()) {
                        it.remove();
                    }
                }
            }
            return requestHandle;
        }
    }

    private AsyncHttpRequest newAysncHttpRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        return new AsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, responseHandlerInterface);
    }

    private String getUrlWithQueryString(boolean z, String str, RequestParams requestParams) {
        String replace;
        if (z) {
            replace = str.replace(HwAccountConstants.BLANK, "%20");
        } else {
            replace = str;
        }
        if (requestParams == null) {
            return replace;
        }
        String paramString = requestParams.getParamString();
        if (paramString == null || LocationInfo.NA.equals(paramString)) {
            return replace;
        }
        return (replace + (replace.contains(LocationInfo.NA) ? SNBConstant.FILTER : LocationInfo.NA)) + paramString;
    }

    public static void silentCloseInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                Log.w(TAG, "Cannot close input stream", e);
            }
        }
    }

    public static void silentCloseOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable e) {
                Log.w(TAG, "Cannot close output stream", e);
            }
        }
    }

    public void cancelRequests(final Context context, final boolean z) {
        if (context != null) {
            Runnable c61891 = new Runnable() {
                public void run() {
                    for (RequestHandle cancel : (List) AsyncHttpClient.this.requestMap.get(context)) {
                        cancel.cancel(z);
                    }
                    AsyncHttpClient.this.requestMap.remove(context);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(c61891).start();
            } else {
                c61891.run();
            }
        }
    }

    public void cancelAllRequests(boolean z) {
        for (List<RequestHandle> list : this.requestMap.values()) {
            if (list != null) {
                for (RequestHandle cancel : list) {
                    cancel.cancel(z);
                }
            }
        }
        this.requestMap.clear();
    }

    public CookieStore getCookieStore() {
        return this.httpClient.getCookieStore();
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
    }
}
