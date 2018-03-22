package com.huawei.hwid.update.p453d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hwid.activity.C5063a;
import com.huawei.hwid.api.common.C5106n;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.update.receive.SilentInstallReceive;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SilentUpdateWizard */
public class C5304i extends C5277a implements C5063a {
    private WeakReference<Activity> f18978a;
    private BroadcastReceiver f18979b;
    private Handler f18980c = new Handler();
    private C5279b f18981d;
    private boolean f18982e = false;
    private int f18983f = 0;
    private C5063a f18984g;
    private Handler f18985h = new C53021(this);

    /* compiled from: SilentUpdateWizard */
    class C53021 extends Handler {
        final /* synthetic */ C5304i f18976a;

        C53021(C5304i c5304i) {
            this.f18976a = c5304i;
        }

        public void handleMessage(Message message) {
            Bundle bundle = (Bundle) message.obj;
            switch (message.what) {
                case 101:
                    this.f18976a.m25609a(bundle);
                    return;
                case 102:
                    this.f18976a.m25616b(bundle);
                    return;
                case 103:
                    this.f18976a.m25619c(bundle);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: SilentUpdateWizard */
    class C5303a implements Runnable {
        final /* synthetic */ C5304i f18977a;

        private C5303a(C5304i c5304i) {
            this.f18977a = c5304i;
        }

        public void run() {
            this.f18977a.m25614b(14);
        }
    }

    public void mo4669a(Activity activity, boolean z) {
        this.f18978a = new WeakReference(activity);
        m25608a(activity);
    }

    private void m25608a(Activity activity) {
        int i = 20300000;
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage("com.huawei.appmarket");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        int d = C5106n.m24596d(activity);
        if (C5106n.m24593b(activity) && !C5106n.m24589a((Context) activity, 20300000)) {
            i = d + 1;
        }
        try {
            jSONObject.put("pkgName", "com.huawei.hwid");
            jSONObject.put("versioncode", i);
            jSONArray.put(jSONObject);
            intent.putExtra("params", jSONArray.toString());
            intent.putExtra("isHmsOrApkUpgrade", true);
            intent.putExtra("buttonDlgY", activity.getString(C5180k.m25027a(activity, "CS_install")));
            intent.putExtra("buttonDlgN", activity.getString(C5180k.m25027a(activity, "cs_cancel")));
            intent.putExtra("upgradeDlgContent", activity.getString(C5180k.m25027a(activity, "cs_update_message_new"), new Object[]{"%P"}));
            try {
                activity.startActivityForResult(intent, 2000);
            } catch (ActivityNotFoundException e) {
                C5165e.m24910d("SilentUpdateWizard", "ActivityNotFoundException");
            }
        } catch (JSONException e2) {
            C5165e.m24910d("SilentUpdateWizard", "create hmsJsonObject fail" + e2.getMessage());
        }
    }

    public void mo4667a() {
        this.f18978a = null;
        this.f18980c.removeCallbacksAndMessages(null);
        m25622e();
        if (this.f18981d != null) {
            this.f18981d.m25561c();
            this.f18981d = null;
        }
        if (this.f18982e && this.f18984g != null) {
            this.f18984g.mo4667a();
        }
    }

    public boolean mo4671a(int i, int i2, Intent intent) {
        if (this.f18982e && this.f18984g != null) {
            return this.f18984g.mo4671a(i, i2, intent);
        }
        C5165e.m24906b("SilentUpdateWizard", "resultCode = " + i2);
        if (i != 2000) {
            return false;
        }
        if (i2 == 0) {
            m25621d();
            m25607a(20000);
            return true;
        } else if (i2 == 4) {
            m25618c(13);
            return true;
        } else {
            C5165e.m24906b("SilentUpdateWizard", "market change to ota download");
            m25613a(true);
            return true;
        }
    }

    public void mo4672b() {
        if (this.f18982e && this.f18984g != null) {
            this.f18984g.mo4672b();
        } else if (this.f18981d != null) {
            Class cls = this.f18981d.getClass();
            this.f18981d.m25561c();
            this.f18981d = null;
            m25612a(cls);
        }
    }

    private void m25613a(boolean z) {
        Activity c = mo4674c();
        if (c != null) {
            if (this.f18984g == null) {
                m25615b(c);
            }
            if (this.f18984g != null) {
                this.f18982e = true;
                this.f18984g.mo4669a(c, z);
            }
        }
    }

    private void m25615b(Activity activity) {
        Exception e;
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_EX_NAME);
            if (stringExtra != null) {
                try {
                    this.f18984g = (C5063a) Class.forName(stringExtra).asSubclass(C5063a.class).newInstance();
                } catch (ClassCastException e2) {
                    e = e2;
                    C5165e.m24910d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                } catch (InstantiationException e3) {
                    e = e3;
                    C5165e.m24910d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                } catch (IllegalAccessException e4) {
                    e = e4;
                    C5165e.m24910d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                } catch (ClassNotFoundException e5) {
                    e = e5;
                    C5165e.m24910d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                }
            }
        }
    }

    private void m25621d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.progress.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.installerservice.Receiver");
        this.f18979b = new SilentInstallReceive(this.f18985h);
        Activity c = mo4674c();
        if (c != null) {
            c.registerReceiver(this.f18979b, intentFilter);
        }
    }

    private void m25622e() {
        Activity c = mo4674c();
        if (c != null && this.f18979b != null) {
            c.unregisterReceiver(this.f18979b);
            this.f18979b = null;
        }
    }

    void mo4670a(C5279b c5279b) {
        C5165e.m24904a("SilentUpdateWizard", "on SilentUpdate cancelled");
    }

    void mo4673b(C5279b c5279b) {
        C5165e.m24904a("SilentUpdateWizard", "on SilentUpdate dowork");
    }

    Activity mo4674c() {
        if (this.f18978a == null) {
            return null;
        }
        return (Activity) this.f18978a.get();
    }

    private void m25607a(int i) {
        this.f18980c.removeCallbacksAndMessages(null);
        this.f18980c.postDelayed(new C5303a(), (long) i);
    }

    private void m25614b(int i) {
        this.f18980c.removeCallbacksAndMessages(null);
        m25622e();
        if (this.f18981d != null) {
            this.f18981d.m25561c();
            this.f18981d = null;
        }
        m25613a(false);
    }

    private void m25609a(Bundle bundle) {
        Object obj = null;
        if (bundle.containsKey("UpgradePkgName")) {
            obj = bundle.getString("UpgradePkgName");
        }
        if (obj == null || !"com.huawei.hwid".equals(obj)) {
            C5165e.m24906b("SilentUpdateWizard", "packageName error");
        } else if (bundle.containsKey("downloadtask.status")) {
            int i = bundle.getInt("downloadtask.status");
            C5165e.m24906b("SilentUpdateWizard", "status = " + i);
            if (i == 3 || i == 5 || i == 6 || i == 8) {
                m25614b(i);
            } else if (i == 4) {
                m25607a(60000);
            } else {
                m25607a(20000);
            }
        }
    }

    private void m25616b(Bundle bundle) {
        Object obj = null;
        if (bundle.containsKey("UpgradePkgName")) {
            obj = bundle.getString("UpgradePkgName");
        }
        if (obj != null && "com.huawei.hwid".equals(obj) && bundle.containsKey("UpgradeDownloadProgress") && bundle.containsKey("UpgradeAppName")) {
            int i = bundle.getInt("UpgradeDownloadProgress");
            m25607a(20000);
            if (i >= 99) {
                i = 99;
            }
            this.f18983f = i;
            if (this.f18981d == null) {
                m25612a(C5290e.class);
            }
            if (this.f18981d != null) {
                ((C5290e) this.f18981d).m25581b(i);
            }
        }
    }

    private void m25619c(Bundle bundle) {
        if (bundle.containsKey("packagename") && bundle.containsKey("status")) {
            String string = bundle.getString("packagename");
            int i = bundle.getInt("status");
            if (string != null && "com.huawei.hwid".equals(string)) {
                C5165e.m24906b("SilentUpdateWizard", "hiapp install status:" + i);
                if (i == 2) {
                    this.f18980c.removeCallbacksAndMessages(null);
                    if (this.f18981d != null) {
                        ((C5290e) this.f18981d).m25581b(100);
                    }
                    m25618c(0);
                } else if (i == -1 || i == -2) {
                    m25614b(i);
                } else {
                    m25607a(60000);
                }
            }
        }
    }

    private void m25612a(Class<? extends C5279b> cls) {
        Exception e;
        try {
            C5279b c5279b = (C5279b) cls.newInstance();
            if (this.f18983f > 0 && (c5279b instanceof C5290e)) {
                ((C5290e) c5279b).m25580a(this.f18983f);
            }
            c5279b.m25559a((C5277a) this);
            this.f18981d = c5279b;
        } catch (InstantiationException e2) {
            e = e2;
            C5165e.m24910d("SilentUpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        } catch (IllegalAccessException e3) {
            e = e3;
            C5165e.m24910d("SilentUpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        } catch (IllegalStateException e4) {
            e = e4;
            C5165e.m24910d("SilentUpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }

    private void m25618c(int i) {
        Activity c = mo4674c();
        if (c != null && !c.isFinishing()) {
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, getClass().getName());
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            c.setResult(-1, intent);
            c.finish();
        }
    }

    public void mo4668a(int i, KeyEvent keyEvent) {
        if (this.f18982e && this.f18984g != null) {
            this.f18984g.mo4668a(i, keyEvent);
        }
    }
}
