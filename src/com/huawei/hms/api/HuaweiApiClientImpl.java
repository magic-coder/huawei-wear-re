package com.huawei.hms.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener;
import com.huawei.hms.api.internal.C0845e;
import com.huawei.hms.api.internal.C0847g;
import com.huawei.hms.api.internal.IPCTransport;
import com.huawei.hms.core.aidl.C0861a;
import com.huawei.hms.core.aidl.C0862b;
import com.huawei.hms.core.aidl.C0865e;
import com.huawei.hms.core.aidl.C0865e.C0867a;
import com.huawei.hms.core.aidl.C0868f;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.p039c.C0857e;
import com.huawei.hms.p039c.C0859g;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.p042a.C0873a;
import com.huawei.hms.support.log.C0887a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiClientImpl extends HuaweiApiClient implements ServiceConnection {
    private final Context f1307a;
    private String f1308b;
    private final String f1309c;
    private volatile C0865e f1310d;
    private String f1311e;
    private AtomicInteger f1312f = new AtomicInteger(1);
    private List<Scope> f1313g;
    private List<PermissionInfo> f1314h;
    private Map<Api<?>, ApiOptions> f1315i;
    private SubAppInfo f1316j;
    private ConnectionCallbacks f1317k;
    private OnConnectionFailedListener f1318l;
    private Handler f1319m = null;

    class C0828a implements ResultCallback<ResolveResult<ConnectResp>> {
        final /* synthetic */ HuaweiApiClientImpl f1305a;

        private C0828a(HuaweiApiClientImpl huaweiApiClientImpl) {
            this.f1305a = huaweiApiClientImpl;
        }

        public /* synthetic */ void onResult(Object obj) {
            m2925a((ResolveResult) obj);
        }

        public void m2925a(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new C0835d(this, resolveResult));
        }
    }

    class C0829b implements ResultCallback<ResolveResult<DisconnectResp>> {
        final /* synthetic */ HuaweiApiClientImpl f1306a;

        private C0829b(HuaweiApiClientImpl huaweiApiClientImpl) {
            this.f1306a = huaweiApiClientImpl;
        }

        public /* synthetic */ void onResult(Object obj) {
            m2926a((ResolveResult) obj);
        }

        public void m2926a(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new C0836e(this, resolveResult));
        }
    }

    public HuaweiApiClientImpl(Context context) {
        this.f1307a = context;
        this.f1309c = C0859g.m3025a(context);
        this.f1308b = this.f1309c;
    }

    public Context getContext() {
        return this.f1307a;
    }

    public String getPackageName() {
        return this.f1307a.getPackageName();
    }

    public String getAppID() {
        return this.f1308b;
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public final SubAppInfo getSubAppInfo() {
        return this.f1316j;
    }

    public List<Scope> getScopes() {
        return this.f1313g;
    }

    public List<PermissionInfo> getPermissionInfos() {
        return this.f1314h;
    }

    public Map<Api<?>, ApiOptions> getApiMap() {
        return this.f1315i;
    }

    public C0865e getService() {
        return this.f1310d;
    }

    public String getSessionId() {
        return this.f1311e;
    }

    public void connect() {
        C0887a.m3098d("HuaweiApiClientImpl", "====== HMSSDK version: 20502300 ======");
        int i = this.f1312f.get();
        C0887a.m3094b("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i);
        if (i != 3 && i != 5 && i != 2 && i != 4) {
            this.f1308b = TextUtils.isEmpty(this.f1309c) ? C0859g.m3025a(this.f1307a) : this.f1309c;
            i = C0845e.m2995a(this.f1307a);
            C0887a.m3094b("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + i);
            if (i == 0) {
                m2928a(5);
                if (m2932a()) {
                    m2934b();
                    return;
                }
                m2928a(1);
                C0887a.m3098d("HuaweiApiClientImpl", "In connect, bind core service fail");
                if (this.f1318l != null) {
                    this.f1318l.onConnectionFailed(new ConnectionResult(6));
                }
            } else if (this.f1318l != null) {
                this.f1318l.onConnectionFailed(new ConnectionResult(i));
            }
        }
    }

    private void m2928a(int i) {
        this.f1312f.set(i);
    }

    private boolean m2932a() {
        Intent intent = new Intent(HuaweiApiAvailability.SERVICES_ACTION);
        intent.setPackage("com.huawei.hwid");
        return this.f1307a.bindService(intent, this, 1);
    }

    private void m2934b() {
        if (this.f1319m != null) {
            this.f1319m.removeMessages(2);
        } else {
            this.f1319m = new Handler(Looper.getMainLooper(), new C0831b(this));
        }
        this.f1319m.sendEmptyMessageDelayed(2, 3000);
    }

    private void m2937c() {
        if (this.f1319m != null) {
            this.f1319m.removeMessages(2);
            this.f1319m = null;
        }
    }

    public void disconnect() {
        int i = this.f1312f.get();
        C0887a.m3094b("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i);
        switch (i) {
            case 2:
                m2928a(4);
                return;
            case 3:
                m2928a(4);
                m2938d();
                return;
            case 5:
                m2937c();
                m2928a(4);
                return;
            default:
                return;
        }
    }

    public boolean isConnected() {
        return this.f1312f.get() == 3;
    }

    public boolean isConnecting() {
        int i = this.f1312f.get();
        return i == 2 || i == 5;
    }

    public void setApiMap(Map<Api<?>, ApiOptions> map) {
        this.f1315i = map;
    }

    public void setScopes(List<Scope> list) {
        this.f1313g = list;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f1314h = list;
    }

    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo == null) {
            return false;
        }
        Object subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.f1309c) ? C0859g.m3025a(this.f1307a) : this.f1309c)) {
            return false;
        }
        this.f1316j = new SubAppInfo(subAppInfo);
        return true;
    }

    public void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.f1317k = connectionCallbacks;
    }

    public void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.f1318l = onConnectionFailedListener;
    }

    private void m2938d() {
        C0873a.m3066a((ApiClient) this, m2939e()).setResultCallback(new C0829b());
    }

    private DisconnectInfo m2939e() {
        List arrayList = new ArrayList();
        if (this.f1315i != null) {
            for (Api apiName : this.f1315i.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return new DisconnectInfo(this.f1313g, arrayList);
    }

    private void m2931a(ResolveResult<DisconnectResp> resolveResult) {
        C0887a.m3094b("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        m2942h();
        m2928a(1);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0887a.m3094b("HuaweiApiClientImpl", "Enter onServiceConnected.");
        m2937c();
        this.f1310d = C0867a.m3044a(iBinder);
        if (this.f1310d == null) {
            C0887a.m3098d("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            m2942h();
            m2928a(1);
            if (this.f1318l != null) {
                this.f1318l.onConnectionFailed(new ConnectionResult(10));
            }
        } else if (this.f1312f.get() == 5) {
            m2928a(2);
            m2940f();
        } else if (this.f1312f.get() != 3) {
            m2942h();
        }
    }

    private void m2940f() {
        C0887a.m3094b("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        C0873a.m3067a((ApiClient) this, m2941g()).setResultCallback(new C0828a());
    }

    private ConnectInfo m2941g() {
        String d = new C0857e(this.f1307a).m3020d(this.f1307a.getPackageName());
        String str = d == null ? "" : d;
        List arrayList = new ArrayList();
        if (this.f1315i != null) {
            for (Api apiName : this.f1315i.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return new ConnectInfo(arrayList, this.f1313g, str, this.f1316j == null ? null : this.f1316j.getSubAppID());
    }

    private void m2936b(ResolveResult<ConnectResp> resolveResult) {
        Object obj;
        ConnectResp connectResp = (ConnectResp) resolveResult.getValue();
        if (connectResp != null) {
            this.f1311e = connectResp.sessionId;
        }
        if (this.f1316j == null) {
            obj = null;
        } else {
            obj = this.f1316j.getSubAppID();
        }
        if (!TextUtils.isEmpty(obj)) {
            this.f1308b = obj;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        C0887a.m3094b("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
        if (Status.SUCCESS.equals(resolveResult.getStatus())) {
            if (resolveResult.getValue() != null) {
                C0847g.m2998a().m2999a(((ConnectResp) resolveResult.getValue()).protocolVersion);
            }
            m2928a(3);
            if (this.f1317k != null) {
                this.f1317k.onConnected();
            }
        } else if (resolveResult.getStatus() == null || resolveResult.getStatus().getStatusCode() != 1001) {
            m2942h();
            m2928a(1);
            if (this.f1318l != null) {
                this.f1318l.onConnectionFailed(new ConnectionResult(statusCode));
            }
        } else {
            m2942h();
            m2928a(1);
            if (this.f1317k != null) {
                this.f1317k.onConnectionSuspended(3);
            }
        }
    }

    private void m2942h() {
        C0859g.m3027a(this.f1307a, (ServiceConnection) this);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C0887a.m3094b("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f1310d = null;
        m2928a(1);
        if (this.f1317k != null) {
            this.f1317k.onConnectionSuspended(1);
        }
    }

    public int asyncRequest(Bundle bundle, String str, int i, ResultCallback<BundleResult> resultCallback) {
        if (resultCallback == null || str == null || bundle == null) {
            return ErrorCode.ARGUMENTS_INVALID;
        }
        if (!isConnected()) {
            return ErrorCode.CLIENT_API_INVALID;
        }
        C0862b c0862b = new C0862b(str, i);
        C0868f a = C0861a.m3030a(c0862b.m3036c());
        c0862b.m3034a(bundle);
        c0862b.f1358b = a.m3050a(new RequestHeader(getAppID(), getPackageName(), 20502300, getSessionId()), new Bundle());
        try {
            getService().mo2245a(c0862b, new C0834c(this, resultCallback));
            return 0;
        } catch (RemoteException e) {
            return ErrorCode.INTERNAL_ERROR;
        }
    }
}
