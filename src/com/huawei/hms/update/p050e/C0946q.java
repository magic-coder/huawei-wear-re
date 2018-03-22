package com.huawei.hms.update.p050e;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.C0827a;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.p039c.C0857e;
import com.huawei.hms.p039c.C0859g;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hms.update.p045a.C0898e;
import com.huawei.hms.update.p045a.C0899f;
import com.huawei.hms.update.p045a.C0902i;
import com.huawei.hms.update.p045a.p046a.C0890a;
import com.huawei.hms.update.p045a.p046a.C0891b;
import com.huawei.hms.update.p045a.p046a.C0892c;
import com.huawei.hms.update.p045a.p046a.C0893d;
import com.huawei.hms.update.p048c.C0914a;
import com.huawei.hms.update.p050e.C0924e.C0922b;
import com.huawei.hms.update.p050e.C0924e.C0923c;
import com.huawei.hms.update.p050e.C0941m.C0938b;
import com.huawei.hms.update.p050e.C0941m.C0939c;
import com.huawei.hms.update.p050e.C0941m.C0940d;
import com.huawei.hms.update.provider.UpdateProvider;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: UpdateWizard */
public class C0946q extends C0916a implements C0827a, C0891b {
    private WeakReference<Activity> f1533a;
    private C0890a f1534b;
    private C0917b f1535c;
    private C0892c f1536d;
    private int f1537e = -1;

    public void mo2239a(Activity activity, boolean z) {
        this.f1533a = new WeakReference(activity);
        if (z) {
            m3269a(C0930i.class);
        } else {
            m3272e();
        }
    }

    public void mo2237a() {
        m3274g();
        m3277j();
        C0914a.m3197a(null);
        this.f1533a = null;
    }

    public int m3288d() {
        if (this.f1537e == 1) {
            return 2001;
        }
        if (this.f1537e == 2) {
            return 2002;
        }
        if (this.f1537e == 3) {
            return 2003;
        }
        return 2001;
    }

    public boolean mo2240a(int i, int i2, Intent intent) {
        Activity c = mo2283c();
        if (c == null || c.isFinishing()) {
            return false;
        }
        if (this.f1537e == 1 && i == 2001) {
            if (m3270a(c)) {
                m3267a(0);
                return true;
            }
            m3267a(8);
            return true;
        } else if (this.f1537e == 2 && i == 2002) {
            if (m3270a(c)) {
                m3267a(0);
                return true;
            }
            m3202a(8, this.f1537e);
            m3271b(c);
            return true;
        } else if (this.f1537e != 3 || i != 2003) {
            return false;
        } else {
            if (m3270a(c)) {
                m3267a(0);
                return true;
            }
            m3267a(8);
            return true;
        }
    }

    private boolean m3270a(Activity activity) {
        return new C0857e(activity).m3018b("com.huawei.hwid") >= 20502300;
    }

    public void mo2241b() {
        if (this.f1535c != null) {
            Class cls = this.f1535c.getClass();
            this.f1535c.m3210c();
            this.f1535c = null;
            m3269a(cls);
        }
    }

    public void mo2270a(int i, C0892c c0892c) {
        if (C0887a.m3093a()) {
            C0887a.m3092a("UpdateWizard", "Enter onCheckUpdate, status: " + C0893d.m3123a(i));
        }
        switch (i) {
            case 1000:
                this.f1536d = c0892c;
                m3269a(C0929h.class);
                m3276i();
                return;
            case 1201:
            case 1202:
            case 1203:
                m3269a(C0938b.class);
                return;
            default:
                return;
        }
    }

    public void mo2269a(int i, int i2, int i3, File file) {
        if (C0887a.m3093a()) {
            C0887a.m3092a("UpdateWizard", "Enter onDownloadPackage, status: " + C0893d.m3123a(i) + ", reveived: " + i2 + ", total: " + i3);
        }
        switch (i) {
            case 2000:
                m3274g();
                if (file == null) {
                    m3267a(8);
                    return;
                } else {
                    m3268a(file);
                    return;
                }
            case 2100:
                if (this.f1535c != null && (this.f1535c instanceof C0929h)) {
                    ((C0929h) this.f1535c).m3229a(i2, i3);
                    return;
                }
                return;
            case 2201:
                if (!(this.f1536d == null || this.f1534b == null)) {
                    this.f1536d.m3122c(this.f1534b.mo2264a());
                }
                m3269a(C0939c.class);
                return;
            case 2202:
                m3269a(C0922b.class);
                return;
            case 2203:
            case 2204:
                m3269a(C0940d.class);
                return;
            default:
                return;
        }
    }

    private void m3268a(File file) {
        Context c = mo2283c();
        if (c != null && !c.isFinishing()) {
            if (new C0857e(c).m3017a(file.toString(), "com.huawei.hwid", HuaweiApiAvailability.SERVICES_SIGNATURE)) {
                Uri a = C0946q.m3266a(c, file);
                if (a == null) {
                    C0887a.m3098d("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
                    m3267a(8);
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(a, "application/vnd.android.package-archive");
                intent.setFlags(3);
                try {
                    c.startActivityForResult(intent, m3288d());
                    return;
                } catch (ActivityNotFoundException e) {
                    C0887a.m3098d("UpdateWizard", "In startInstaller, Failed to start package installer." + e.getMessage());
                    m3267a(8);
                    return;
                }
            }
            C0887a.m3098d("UpdateWizard", "In startInstaller, Failed to verify package archive.");
            m3267a(8);
        }
    }

    private static Uri m3266a(Context context, File file) {
        Object obj = 1;
        C0857e c0857e = new C0857e(context);
        String packageName = context.getPackageName();
        String str = packageName + UpdateProvider.AUTHORITIES_SUFFIX;
        if (VERSION.SDK_INT <= 23 || (context.getApplicationInfo().targetSdkVersion <= 23 && !c0857e.m3016a(packageName, str))) {
            obj = null;
        }
        if (obj != null) {
            return UpdateProvider.getUriForFile(context, str, file);
        }
        return Uri.fromFile(file);
    }

    Activity mo2283c() {
        if (this.f1533a == null) {
            return null;
        }
        return (Activity) this.f1533a.get();
    }

    void mo2281a(C0917b c0917b) {
        C0887a.m3094b("UpdateWizard", "Enter onCancel.");
        if (c0917b instanceof C0930i) {
            if (C0859g.m3028a()) {
                this.f1537e = 1;
            } else {
                this.f1537e = 2;
            }
            m3267a(13);
        } else if (c0917b instanceof C0919d) {
            m3277j();
            m3267a(13);
        } else if (c0917b instanceof C0929h) {
            m3277j();
            m3269a(C0923c.class);
        } else if (c0917b instanceof C0923c) {
            m3269a(C0929h.class);
            m3276i();
        } else if (c0917b instanceof C0922b) {
            m3267a(13);
        }
    }

    void mo2282b(C0917b c0917b) {
        C0887a.m3094b("UpdateWizard", "Enter onDoWork.");
        if (c0917b instanceof C0930i) {
            c0917b.m3210c();
            m3272e();
        } else if (c0917b instanceof C0923c) {
            c0917b.m3210c();
            m3267a(13);
        } else if (c0917b instanceof C0922b) {
            m3269a(C0929h.class);
            m3276i();
        } else if (c0917b instanceof C0938b) {
            m3267a(8);
        } else if (c0917b instanceof C0939c) {
            m3267a(8);
        } else if (c0917b instanceof C0940d) {
            m3267a(8);
        }
    }

    private void m3272e() {
        if (C0859g.m3028a()) {
            this.f1537e = 1;
            m3269a(C0919d.class);
            m3275h();
            return;
        }
        m3273f();
    }

    private void m3273f() {
        this.f1537e = 2;
        Activity c = mo2283c();
        if (c != null && !c.isFinishing()) {
            String str = "com.huawei.hwid";
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.huawei.hwid"));
                intent.setPackage("com.android.vending");
                c.startActivityForResult(intent, m3288d());
            } catch (ActivityNotFoundException e) {
                C0887a.m3098d("UpdateWizard", "can not open google play");
            }
        }
    }

    private void m3271b(Activity activity) {
        this.f1537e = 3;
        String str = "com.huawei.hwid";
        try {
            activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.huawei.hwid")), m3288d());
        } catch (ActivityNotFoundException e) {
            C0887a.m3098d("UpdateWizard", "can not find web to hold update hms apk");
        }
    }

    private void m3269a(Class<? extends C0917b> cls) {
        Exception e;
        m3274g();
        try {
            C0917b c0917b = (C0917b) cls.newInstance();
            c0917b.m3208a((C0916a) this);
            this.f1535c = c0917b;
            return;
        } catch (InstantiationException e2) {
            e = e2;
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (IllegalStateException e4) {
            e = e4;
        }
        C0887a.m3098d("UpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
    }

    private void m3274g() {
        if (this.f1535c != null) {
            try {
                this.f1535c.m3210c();
                this.f1535c = null;
            } catch (IllegalStateException e) {
                C0887a.m3098d("UpdateWizard", "In dismissDialog, Failed to dismiss the dialog." + e.getMessage());
            }
        }
    }

    private void m3275h() {
        this.f1536d = null;
        Context c = mo2283c();
        if (c != null && !c.isFinishing()) {
            m3277j();
            this.f1534b = new C0902i(new C0898e(c));
            this.f1534b.mo2265a(this);
        }
    }

    private void m3276i() {
        Context c = mo2283c();
        if (c != null && !c.isFinishing()) {
            m3277j();
            this.f1534b = new C0902i(new C0899f(c));
            this.f1534b.mo2266a(this, this.f1536d);
        }
    }

    private void m3277j() {
        if (this.f1534b != null) {
            this.f1534b.mo2267b();
            this.f1534b = null;
        }
    }

    private void m3267a(int i) {
        Activity c = mo2283c();
        if (c != null && !c.isFinishing()) {
            m3202a(i, this.f1537e);
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, getClass().getName());
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            c.setResult(-1, intent);
            c.finish();
        }
    }

    public void mo2238a(int i, KeyEvent keyEvent) {
        if (4 == i) {
            C0887a.m3094b("UpdateWizard", "In onKeyUp, Call finish.");
            Activity c = mo2283c();
            if (c != null && !c.isFinishing()) {
                c.setResult(0, null);
                c.finish();
            }
        }
    }
}
