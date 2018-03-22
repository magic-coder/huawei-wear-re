package com.huawei.hms.update.p050e;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import com.huawei.android.a.a.d;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.C0827a;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hms.update.p048c.C0914a;
import com.huawei.hms.update.p049d.C0915a;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SilentUpdateWizard */
public class C0944o extends C0916a implements C0827a {
    private WeakReference<Activity> f1525a;
    private BroadcastReceiver f1526b;
    private Handler f1527c = new Handler();
    private C0917b f1528d;
    private boolean f1529e = false;
    private C0827a f1530f;
    private Handler f1531g = new C0945p(this);

    /* compiled from: SilentUpdateWizard */
    class C0943a implements Runnable {
        final /* synthetic */ C0944o f1524a;

        private C0943a(C0944o c0944o) {
            this.f1524a = c0944o;
        }

        public void run() {
            this.f1524a.m3249b(14);
        }
    }

    public void mo2239a(Activity activity, boolean z) {
        this.f1525a = new WeakReference(activity);
        m3243a(activity);
    }

    private void m3243a(Activity activity) {
        Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        intent.setPackage("com.huawei.appmarket");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pkgName", "com.huawei.hwid");
            jSONObject.put("versioncode", 20502300);
            jSONArray.put(jSONObject);
            intent.putExtra("params", jSONArray.toString());
            intent.putExtra("isHmsOrApkUpgrade", true);
            intent.putExtra("buttonDlgY", activity.getString(d.hms_install));
            intent.putExtra("buttonDlgN", activity.getString(d.hms_cancel));
            intent.putExtra("upgradeDlgContent", activity.getString(d.hms_update_message_new, new Object[]{"%P"}));
            try {
                activity.startActivityForResult(intent, 2000);
            } catch (ActivityNotFoundException e) {
                C0887a.m3098d("SilentUpdateWizard", "ActivityNotFoundException");
            }
        } catch (JSONException e2) {
            C0887a.m3098d("SilentUpdateWizard", "create hmsJsonObject fail" + e2.getMessage());
        }
    }

    public void mo2237a() {
        this.f1525a = null;
        this.f1527c.removeCallbacksAndMessages(null);
        m3257e();
        if (this.f1528d != null) {
            this.f1528d.m3210c();
            this.f1528d = null;
        }
        if (!this.f1529e || this.f1530f == null) {
            C0914a.m3197a(null);
        } else {
            this.f1530f.mo2237a();
        }
    }

    public boolean mo2240a(int i, int i2, Intent intent) {
        if (this.f1529e && this.f1530f != null) {
            return this.f1530f.mo2240a(i, i2, intent);
        }
        if (i != 2000) {
            return false;
        }
        if (i2 == 0) {
            m3256d();
            m3242a(20000);
            return true;
        } else if (i2 == 4) {
            m3253c(13);
            return true;
        } else {
            m3202a(i2, 0);
            m3248a(true);
            return true;
        }
    }

    public void mo2241b() {
        if (this.f1529e && this.f1530f != null) {
            this.f1530f.mo2241b();
        } else if (this.f1528d != null) {
            Class cls = this.f1528d.getClass();
            this.f1528d.m3210c();
            this.f1528d = null;
            m3247a(cls);
        }
    }

    private void m3248a(boolean z) {
        Activity c = mo2283c();
        if (c != null) {
            if (this.f1530f == null) {
                m3250b(c);
            }
            if (this.f1530f != null) {
                this.f1529e = true;
                C0914a.m3197a(this.f1530f.getClass());
                this.f1530f.mo2239a(c, z);
            }
        }
    }

    private void m3250b(Activity activity) {
        Exception e;
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_EX_NAME);
            if (stringExtra != null) {
                try {
                    this.f1530f = (C0827a) Class.forName(stringExtra).asSubclass(C0827a.class).newInstance();
                } catch (ClassCastException e2) {
                    e = e2;
                    C0887a.m3098d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                } catch (InstantiationException e3) {
                    e = e3;
                    C0887a.m3098d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                } catch (IllegalAccessException e4) {
                    e = e4;
                    C0887a.m3098d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                } catch (ClassNotFoundException e5) {
                    e = e5;
                    C0887a.m3098d("SilentUpdateWizard", "getBridgeActivityDelegate error" + e.getMessage());
                }
            }
        }
    }

    private void m3256d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.progress.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.installerservice.Receiver");
        this.f1526b = new C0915a(this.f1531g);
        Activity c = mo2283c();
        if (c != null) {
            c.registerReceiver(this.f1526b, intentFilter);
        }
    }

    private void m3257e() {
        Activity c = mo2283c();
        if (c != null && this.f1526b != null) {
            c.unregisterReceiver(this.f1526b);
            this.f1526b = null;
        }
    }

    void mo2281a(C0917b c0917b) {
        C0887a.m3092a("SilentUpdateWizard", "on SilentUpdate cancelled");
    }

    void mo2282b(C0917b c0917b) {
        C0887a.m3092a("SilentUpdateWizard", "on SilentUpdate dowork");
    }

    Activity mo2283c() {
        if (this.f1525a == null) {
            return null;
        }
        return (Activity) this.f1525a.get();
    }

    private void m3242a(int i) {
        this.f1527c.removeCallbacksAndMessages(null);
        this.f1527c.postDelayed(new C0943a(), (long) i);
    }

    private void m3249b(int i) {
        this.f1527c.removeCallbacksAndMessages(null);
        m3257e();
        if (this.f1528d != null) {
            this.f1528d.m3210c();
            this.f1528d = null;
        }
        m3202a(i, 0);
        m3248a(false);
    }

    private void m3244a(Bundle bundle) {
        Object obj = null;
        if (bundle.containsKey("UpgradePkgName")) {
            obj = bundle.getString("UpgradePkgName");
        }
        if (obj != null && "com.huawei.hwid".equals(obj) && bundle.containsKey("downloadtask.status")) {
            int i = bundle.getInt("downloadtask.status");
            if (i == 3 || i == 5 || i == 6 || i == 8) {
                m3249b(i);
            } else if (i == 4) {
                m3242a(60000);
            } else {
                m3242a(20000);
            }
        }
    }

    private void m3251b(Bundle bundle) {
        Object obj = null;
        if (bundle.containsKey("UpgradePkgName")) {
            obj = bundle.getString("UpgradePkgName");
        }
        if (obj != null && "com.huawei.hwid".equals(obj) && bundle.containsKey("UpgradeDownloadProgress") && bundle.containsKey("UpgradeAppName")) {
            int i = bundle.getInt("UpgradeDownloadProgress");
            m3242a(20000);
            if (i >= 99) {
                i = 99;
            }
            if (this.f1528d == null) {
                m3247a(C0935l.class);
            }
            if (this.f1528d != null) {
                ((C0935l) this.f1528d).m3232a(i);
            }
        }
    }

    private void m3254c(Bundle bundle) {
        if (bundle.containsKey("packagename") && bundle.containsKey("status")) {
            String string = bundle.getString("packagename");
            int i = bundle.getInt("status");
            if (string != null && "com.huawei.hwid".equals(string)) {
                if (i == 2) {
                    this.f1527c.removeCallbacksAndMessages(null);
                    if (this.f1528d != null) {
                        ((C0935l) this.f1528d).m3232a(100);
                    }
                    m3253c(0);
                } else if (i == -1 || i == -2) {
                    m3249b(i);
                } else {
                    m3242a(60000);
                }
            }
        }
    }

    private void m3247a(Class<? extends C0917b> cls) {
        Exception e;
        try {
            C0917b c0917b = (C0917b) cls.newInstance();
            c0917b.m3208a((C0916a) this);
            this.f1528d = c0917b;
            return;
        } catch (InstantiationException e2) {
            e = e2;
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (IllegalStateException e4) {
            e = e4;
        }
        C0887a.m3098d("SilentUpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
    }

    private void m3253c(int i) {
        Activity c = mo2283c();
        if (c != null && !c.isFinishing()) {
            m3202a(i, 0);
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, getClass().getName());
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            c.setResult(-1, intent);
            c.finish();
        }
    }

    public void mo2238a(int i, KeyEvent keyEvent) {
        if (this.f1529e && this.f1530f != null) {
            this.f1530f.mo2238a(i, keyEvent);
        }
    }
}
