package com.huawei.hms.api.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import com.huawei.android.a.a.d;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.C0827a;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.p038b.C0838f;
import com.huawei.hms.p039c.C0859g;
import com.huawei.hms.support.log.C0887a;

/* compiled from: BindingFailedResolution */
public class C0840a implements ServiceConnection, C0827a {
    private Activity f1334a;
    private boolean f1335b = true;
    private C0839a f1336c;
    private Handler f1337d = null;

    /* compiled from: BindingFailedResolution */
    class C0839a extends C0838f {
        private C0839a() {
        }

        protected String mo2235a(Context context) {
            String a = C0859g.m3026a(context, null);
            String a2 = C0859g.m3026a(context, "com.huawei.hwid");
            return context.getResources().getString(d.hms_bindfaildlg_message, new Object[]{a, a2});
        }

        protected String mo2236b(Context context) {
            return context.getResources().getString(d.hms_confirm);
        }
    }

    public void mo2239a(Activity activity, boolean z) {
        this.f1334a = activity;
        C0844d.f1340a.m2993a(this.f1334a);
        m2972a(activity);
    }

    private void m2972a(Activity activity) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.hwid", HuaweiApiAvailability.ACTIVITY_NAME);
        try {
            activity.startActivityForResult(intent, m2987c());
        } catch (ActivityNotFoundException e) {
            C0887a.m3098d("BindingFailedResolution", "ActivityNotFoundException：" + e.getMessage());
            m2976e();
        }
    }

    public void mo2237a() {
        m2979h();
        C0844d.f1340a.m2994b(this.f1334a);
        this.f1334a = null;
    }

    public boolean mo2240a(int i, int i2, Intent intent) {
        if (i != m2987c()) {
            return false;
        }
        m2976e();
        return true;
    }

    private void m2976e() {
        if (m2977f()) {
            m2978g();
            return;
        }
        C0887a.m3098d("BindingFailedResolution", "In connect, bind core try fail");
        m2975b(false);
    }

    public void mo2241b() {
        if (this.f1336c != null) {
            C0887a.m3094b("BindingFailedResolution", "re show prompt dialog");
            m2980i();
        }
    }

    public int m2987c() {
        return 2003;
    }

    public void mo2238a(int i, KeyEvent keyEvent) {
        C0887a.m3094b("BindingFailedResolution", "On key up when resolve conn error");
    }

    protected Activity m2988d() {
        return this.f1334a;
    }

    private void m2975b(boolean z) {
        if (this.f1335b) {
            this.f1335b = false;
            m2984a(z);
        }
    }

    protected void m2984a(boolean z) {
        if (m2988d() != null) {
            if (z) {
                m2971a(0);
            } else {
                m2980i();
            }
        }
    }

    private boolean m2977f() {
        Activity d = m2988d();
        if (d == null) {
            return false;
        }
        Intent intent = new Intent(HuaweiApiAvailability.SERVICES_ACTION);
        intent.setPackage("com.huawei.hwid");
        return d.bindService(intent, this, 1);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m2979h();
        m2975b(true);
        Context d = m2988d();
        if (d != null) {
            C0859g.m3027a(d, (ServiceConnection) this);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    private void m2971a(int i) {
        Activity d = m2988d();
        if (d != null && !d.isFinishing()) {
            C0887a.m3094b("BindingFailedResolution", "finishBridgeActivity：" + i);
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            d.setResult(-1, intent);
            d.finish();
        }
    }

    private void m2978g() {
        if (this.f1337d != null) {
            this.f1337d.removeMessages(2);
        } else {
            this.f1337d = new Handler(Looper.getMainLooper(), new C0841b(this));
        }
        this.f1337d.sendEmptyMessageDelayed(2, 3000);
    }

    private void m2979h() {
        if (this.f1337d != null) {
            this.f1337d.removeMessages(2);
            this.f1337d = null;
        }
    }

    private void m2980i() {
        Activity d = m2988d();
        if (d != null && !d.isFinishing()) {
            if (this.f1336c == null) {
                this.f1336c = new C0839a();
            } else {
                this.f1336c.m2959b();
            }
            C0887a.m3098d("BindingFailedResolution", "showPromptdlg to resolve conn error");
            this.f1336c.m2957a(d, new C0843c(this));
        }
    }
}
