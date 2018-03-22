package com.huawei.hms.api;

import android.content.Context;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.Api.ApiOptions.HasOptions;
import com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions;
import com.huawei.hms.p039c.C0852a;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HuaweiApiClient implements ApiClient {

    public final class Builder {
        private final Context f1299a;
        private final List<Scope> f1300b = new ArrayList();
        private final List<PermissionInfo> f1301c = new ArrayList();
        private final Map<Api<?>, ApiOptions> f1302d = new HashMap();
        private OnConnectionFailedListener f1303e;
        private ConnectionCallbacks f1304f;

        public Builder(Context context) throws NullPointerException {
            C0852a.m3001a(context, "context must not be null.");
            this.f1299a = context.getApplicationContext();
        }

        public HuaweiApiClient build() {
            HuaweiApiClient huaweiApiClientImpl = new HuaweiApiClientImpl(this.f1299a);
            huaweiApiClientImpl.setScopes(this.f1300b);
            huaweiApiClientImpl.setPermissionInfos(this.f1301c);
            huaweiApiClientImpl.setApiMap(this.f1302d);
            huaweiApiClientImpl.setConnectionCallbacks(this.f1304f);
            huaweiApiClientImpl.setConnectionFailedListener(this.f1303e);
            return huaweiApiClientImpl;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            C0852a.m3001a(connectionCallbacks, "listener must not be null.");
            this.f1304f = connectionCallbacks;
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            C0852a.m3001a(onConnectionFailedListener, "listener must not be null.");
            this.f1303e = onConnectionFailedListener;
            return this;
        }

        public Builder addScope(Scope scope) {
            C0852a.m3001a(scope, "scope must not be null.");
            this.f1300b.add(scope);
            return this;
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.f1302d.put(api, null);
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O o) {
            C0852a.m3001a(api, "Api must not be null");
            C0852a.m3001a(o, "Null options are not permitted for this Api");
            this.f1302d.put(api, o);
            if (api.getOptions() != null) {
                this.f1300b.addAll(api.getOptions().getScopeList(o));
                this.f1301c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            return this;
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract void connect();

    public abstract void disconnect();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(SubAppInfo subAppInfo);
}
