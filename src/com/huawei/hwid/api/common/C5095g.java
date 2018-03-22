package com.huawei.hwid.api.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.cloudservice.C4336b;
import com.huawei.cloudservice.C4336b.C4338a;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.api.common.apkimpl.C5079a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: CloudAccountServiceClient2 */
public class C5095g {
    private C4336b f18373a;
    private Context f18374b = null;
    private Intent f18375c = null;
    private int f18376d = 0;
    private CloudRequestHandler f18377e = null;
    private boolean f18378f = false;
    private ServiceConnection f18379g = new C50941(this);

    /* compiled from: CloudAccountServiceClient2 */
    class C50941 implements ServiceConnection {
        final /* synthetic */ C5095g f18372a;

        C50941(C5095g c5095g) {
            this.f18372a = c5095g;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z = false;
            C5165e.m24904a("CloudAccountServiceClient2", "onServiceConnected---");
            int i = 0;
            while (i < 20) {
                this.f18372a.f18373a = C4338a.m20873a(iBinder);
                try {
                    if (this.f18372a.f18373a != null) {
                        break;
                    }
                    Thread.sleep(200);
                    i++;
                } catch (InterruptedException e) {
                    C5165e.m24904a("CloudAccountServiceClient2", "service cannot connected");
                }
            }
            String str = "CloudAccountServiceClient2";
            StringBuilder append = new StringBuilder().append("onServiceConnected---mICloudAccount=");
            if (this.f18372a.f18373a != null) {
                z = true;
            }
            C5165e.m24904a(str, append.append(z).toString());
            this.f18372a.m24545c();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C5165e.m24904a("CloudAccountServiceClient2", "onServiceDisconnected");
            this.f18372a.f18373a = null;
        }
    }

    public C5095g(Context context, Intent intent, int i) {
        this.f18374b = context;
        this.f18375c = intent;
        this.f18376d = i;
    }

    public void m24546a() {
        C5165e.m24904a("CloudAccountServiceClient2", "bindService");
        if (this.f18377e == null) {
            C5165e.m24910d("CloudAccountServiceClient2", "has not set mCloudRequesthandler");
        } else if (C5079a.m24449a(this.f18374b)) {
            m24543b();
        } else {
            this.f18377e.onError(new ErrorStatus(31, "Account hasnot login"));
        }
    }

    private void m24543b() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.ICloudService");
        intent.setPackage("com.huawei.hwid");
        C5165e.m24904a("CloudAccountServiceClient2", "begin to bindService");
        this.f18378f = this.f18374b.getApplicationContext().bindService(intent, this.f18379g, 1);
    }

    private void m24545c() {
        C5165e.m24904a("CloudAccountServiceClient2", "saveLogoutIntent");
        if (this.f18373a != null) {
            try {
                int a = this.f18373a.mo4415a(this.f18375c, this.f18376d);
                if (3 == a) {
                    ErrorStatus errorStatus = new ErrorStatus(38, "already exists same priority");
                    C5165e.m24910d("CloudAccountServiceClient2", "error: " + errorStatus.toString());
                    this.f18377e.onError(errorStatus);
                } else {
                    Bundle bundle = new Bundle();
                    if (2 == a) {
                        bundle.putBoolean(HwAccountConstants.SERVICETOKENAUTH_IS_SECCUSS, true);
                    } else if (1 == a) {
                        bundle.putBoolean(HwAccountConstants.SERVICETOKENAUTH_IS_SECCUSS, false);
                    }
                    C5165e.m24904a("CloudAccountServiceClient2", "onFinish");
                    this.f18377e.onFinish(bundle);
                }
                if (this.f18378f) {
                    this.f18374b.getApplicationContext().unbindService(this.f18379g);
                    this.f18378f = false;
                    return;
                }
                return;
            } catch (RemoteException e) {
                C5165e.m24910d("CloudAccountServiceClient2", "Call Remote Exception");
                errorStatus = new ErrorStatus(38, "RemoteException");
                C5165e.m24910d("CloudAccountServiceClient2", "error: " + errorStatus.toString());
                this.f18377e.onError(errorStatus);
                return;
            }
        }
        errorStatus = new ErrorStatus(38, "failed to get the remote interface");
        C5165e.m24910d("CloudAccountServiceClient2", "error: " + errorStatus.toString());
        this.f18377e.onError(errorStatus);
    }

    public void m24547a(CloudRequestHandler cloudRequestHandler) {
        this.f18377e = cloudRequestHandler;
    }
}
