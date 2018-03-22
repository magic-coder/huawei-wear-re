package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.p041a.C0870a;
import com.huawei.hms.support.p043b.C0881a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PendingResultImpl */
public abstract class C0871a<R extends Result, T extends IMessageEntity> extends PendingResult<R> {
    private CountDownLatch f1363a;
    private R f1364b = null;
    private WeakReference<ApiClient> f1365c;
    private String f1366d = null;
    private long f1367e = 0;
    protected DatagramTransport transport = null;

    /* compiled from: PendingResultImpl */
    public class C0872a<R extends Result> extends Handler {
        public C0872a() {
            this(Looper.getMainLooper());
        }

        public C0872a(Looper looper) {
            super(looper);
        }

        public void m3064a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    m3065b((ResultCallback) pair.first, (Result) pair.second);
                    return;
                default:
                    return;
            }
        }

        protected void m3065b(ResultCallback<? super R> resultCallback, R r) {
            resultCallback.onResult(r);
        }
    }

    public abstract R onComplete(T t);

    public C0871a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        this.f1366d = str;
        m3062a(apiClient, str, iMessageEntity, getResponseType());
    }

    public C0871a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        m3062a(apiClient, str, iMessageEntity, cls);
    }

    private void m3062a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        Throwable e;
        if (apiClient == null) {
            throw new IllegalArgumentException("apiClient cannot be null.");
        }
        this.f1365c = new WeakReference(apiClient);
        this.f1363a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(new Class[]{String.class, IMessageEntity.class, Class.class}).newInstance(new Object[]{str, iMessageEntity, cls});
        } catch (InstantiationException e2) {
            e = e2;
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        } catch (IllegalArgumentException e4) {
            e = e4;
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        } catch (ClassNotFoundException e7) {
            e = e7;
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        }
    }

    protected Class<T> getResponseType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            genericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
            if (genericSuperclass != null) {
                return (Class) genericSuperclass;
            }
        }
        return null;
    }

    public final R await() {
        this.f1367e = System.currentTimeMillis();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        ApiClient apiClient = (ApiClient) this.f1365c.get();
        if (checkApiClient(apiClient)) {
            this.transport.mo2231a(apiClient, new C0876b(this));
            try {
                this.f1363a.await();
            } catch (InterruptedException e) {
                m3060a(ErrorCode.INTERNAL_ERROR, null);
            }
            return this.f1364b;
        }
        m3060a(ErrorCode.CLIENT_API_INVALID, null);
        return this.f1364b;
    }

    public R await(long j, TimeUnit timeUnit) {
        this.f1367e = System.currentTimeMillis();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        ApiClient apiClient = (ApiClient) this.f1365c.get();
        if (checkApiClient(apiClient)) {
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.transport.mo2232b(apiClient, new C0877c(this, atomicBoolean));
            try {
                if (!this.f1363a.await(j, timeUnit)) {
                    atomicBoolean.set(true);
                    m3060a(ErrorCode.EXECUTE_TIMEOUT, null);
                }
            } catch (InterruptedException e) {
                m3060a(ErrorCode.INTERNAL_ERROR, null);
            }
            return this.f1364b;
        }
        m3060a(ErrorCode.CLIENT_API_INVALID, null);
        return this.f1364b;
    }

    public final void setResultCallback(ResultCallback<R> resultCallback) {
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        this.f1367e = System.currentTimeMillis();
        if (looper == null) {
            looper = Looper.myLooper();
        }
        C0872a c0872a = new C0872a(looper);
        ApiClient apiClient = (ApiClient) this.f1365c.get();
        if (checkApiClient(apiClient)) {
            this.transport.mo2232b(apiClient, new C0878d(this, c0872a, resultCallback));
            return;
        }
        m3060a(ErrorCode.CLIENT_API_INVALID, null);
        c0872a.m3064a(resultCallback, this.f1364b);
    }

    private void m3060a(int i, IMessageEntity iMessageEntity) {
        m3059a(i);
        if (i <= 0) {
            this.f1364b = onComplete(iMessageEntity);
        } else {
            this.f1364b = onError(i);
        }
    }

    protected R onError(int i) {
        Class a;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            genericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        } else {
            genericSuperclass = null;
        }
        if (genericSuperclass != null) {
            a = C0870a.m3057a(genericSuperclass);
        } else {
            a = null;
        }
        if (a != null) {
            try {
                this.f1364b = (Result) a.newInstance();
                this.f1364b.setStatus(new Status(i));
            } catch (Exception e) {
                return null;
            }
        }
        return this.f1364b;
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return apiClient != null && apiClient.isConnected();
    }

    private void m3059a(int i) {
        ApiClient apiClient = (ApiClient) this.f1365c.get();
        if (apiClient != null && this.f1366d != null && this.f1367e != 0) {
            Map hashMap = new HashMap();
            hashMap.put("package", apiClient.getPackageName());
            hashMap.put("sdk_ver", String.valueOf(20502300));
            Object obj = null;
            SubAppInfo subAppInfo = apiClient.getSubAppInfo();
            if (subAppInfo != null) {
                obj = subAppInfo.getSubAppID();
            }
            if (obj == null) {
                obj = apiClient.getAppID();
            }
            hashMap.put("app_id", obj);
            String[] split = this.f1366d.split("\\.");
            if (split.length == 2) {
                hashMap.put("service", split[0]);
                hashMap.put("api_name", split[1]);
            }
            hashMap.put("result", String.valueOf(i));
            hashMap.put("cost_time", String.valueOf(System.currentTimeMillis() - this.f1367e));
            C0881a.m3076a().m3078a(apiClient.getContext(), "HMS_SDK_API_CALL", hashMap);
        }
    }
}
