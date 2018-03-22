package com.huawei.hwid.update.p453d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hwid.activity.C5063a;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p075d.C5209d;
import com.huawei.hwid.update.p449a.C5260e;
import com.huawei.hwid.update.p449a.C5263f;
import com.huawei.hwid.update.p449a.C5269h;
import com.huawei.hwid.update.p449a.p450a.C5252a;
import com.huawei.hwid.update.p449a.p450a.C5253b;
import com.huawei.hwid.update.p449a.p450a.C5254c;
import com.huawei.hwid.update.p449a.p450a.C5255d;
import com.huawei.hwid.update.p453d.C5287d.C5285b;
import com.huawei.hwid.update.p453d.C5287d.C5286c;
import com.huawei.hwid.update.p453d.C5301h.C5298b;
import com.huawei.hwid.update.p453d.C5301h.C5299c;
import com.huawei.hwid.update.p453d.C5301h.C5300d;
import com.huawei.hwid.update.provider.UpdateProvider;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: UpdateWizard */
public class C5305j extends C5277a implements C5063a, C5253b {
    private WeakReference<Activity> f18986a;
    private C5252a f18987b;
    private C5279b f18988c;
    private C5254c f18989d;
    private int f18990e = 0;
    private int f18991f = -1;

    public void mo4669a(Activity activity, boolean z) {
        this.f18986a = new WeakReference(activity);
        if (z) {
            m25634a(C5294g.class);
            return;
        }
        this.f18991f = 1;
        m25634a(C5280c.class);
        m25637f();
    }

    public void mo4667a() {
        m25636e();
        m25639h();
        this.f18986a = null;
    }

    public int m25650d() {
        return 2001;
    }

    public boolean mo4671a(int i, int i2, Intent intent) {
        Activity c = mo4674c();
        if (c == null || c.isFinishing()) {
            return false;
        }
        C5165e.m24906b("UpdateWizard", "updateType = " + this.f18991f + ",requestCode = " + i);
        if (this.f18991f != 1 || i != 2001) {
            return false;
        }
        if (m25635a(c)) {
            m25632a(0);
            return true;
        }
        m25632a(8);
        return true;
    }

    private boolean m25635a(Activity activity) {
        return new C5209d(activity).m25339b("com.huawei.hwid") >= 20300000;
    }

    public void mo4672b() {
        if (this.f18988c != null) {
            Class cls = this.f18988c.getClass();
            this.f18988c.m25561c();
            this.f18988c = null;
            m25634a(cls);
        }
    }

    public void mo4657a(int i, C5254c c5254c) {
        C5165e.m24906b("UpdateWizard", "Enter onCheckUpdate, status: " + C5255d.m25477a(i));
        switch (i) {
            case 1000:
                this.f18989d = c5254c;
                m25634a(C5290e.class);
                m25638g();
                return;
            case 1201:
            case 1202:
            case 1203:
                m25634a(C5298b.class);
                return;
            case 2205:
                m25636e();
                m25639h();
                m25632a(15);
                return;
            default:
                return;
        }
    }

    public void mo4656a(int i, int i2, int i3, File file) {
        switch (i) {
            case 2000:
                m25636e();
                C5165e.m24906b("UpdateWizard", "download_success");
                if (file == null) {
                    m25632a(8);
                    return;
                } else {
                    m25633a(file);
                    return;
                }
            case 2100:
                if (this.f18988c != null && (this.f18988c instanceof C5290e)) {
                    int i4;
                    if (i2 < 0 || i3 <= 0) {
                        i4 = 0;
                    } else {
                        i4 = (int) ((((long) i2) * 100) / ((long) i3));
                    }
                    this.f18990e = i4;
                    ((C5290e) this.f18988c).m25581b(i4);
                    return;
                }
                return;
            case 2101:
                C5165e.m24906b("UpdateWizard", "download_canceled");
                return;
            case 2201:
                if (!(this.f18989d == null || this.f18987b == null)) {
                    this.f18989d.m25476c(this.f18987b.mo4651a());
                }
                m25634a(C5299c.class);
                return;
            case 2202:
                m25634a(C5285b.class);
                return;
            case 2203:
            case 2204:
                m25634a(C5300d.class);
                return;
            default:
                return;
        }
    }

    private void m25633a(File file) {
        Context c = mo4674c();
        if (c == null || c.isFinishing()) {
            C5165e.m24906b("UpdateWizard", "activity is null");
        } else if (new C5209d(c).m25338a(file.toString(), "com.huawei.hwid", HuaweiApiAvailability.SERVICES_SIGNATURE)) {
            Uri a = C5305j.m25631a(c, file);
            if (a == null) {
                C5165e.m24910d("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
                m25632a(8);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(a, "application/vnd.android.package-archive");
            intent.setFlags(3);
            try {
                c.startActivityForResult(intent, m25650d());
            } catch (ActivityNotFoundException e) {
                C5165e.m24910d("UpdateWizard", "In startInstaller, Failed to start package installer." + e.getMessage());
                m25632a(8);
            }
        } else {
            C5165e.m24910d("UpdateWizard", "In startInstaller, Failed to verify package archive.");
            m25632a(8);
        }
    }

    private static Uri m25631a(Context context, File file) {
        Object obj = 1;
        C5209d c5209d = new C5209d(context);
        String packageName = context.getPackageName();
        String str = packageName + ".hwid.update.provider";
        if (VERSION.SDK_INT <= 23 || (context.getApplicationInfo().targetSdkVersion <= 23 && !c5209d.m25337a(packageName, str))) {
            obj = null;
        }
        if (obj != null) {
            return UpdateProvider.a(context, str, file);
        }
        return Uri.fromFile(file);
    }

    Activity mo4674c() {
        if (this.f18986a == null) {
            return null;
        }
        return (Activity) this.f18986a.get();
    }

    void mo4670a(C5279b c5279b) {
        C5165e.m24906b("UpdateWizard", "Enter onCancel.");
        if (c5279b instanceof C5294g) {
            this.f18991f = 1;
            m25632a(13);
        } else if (c5279b instanceof C5280c) {
            m25639h();
            m25632a(13);
        } else if (c5279b instanceof C5290e) {
            m25639h();
            m25634a(C5286c.class);
        } else if (c5279b instanceof C5286c) {
            m25634a(C5290e.class);
            m25638g();
        } else if (c5279b instanceof C5285b) {
            m25632a(13);
        } else {
            C5165e.m24906b("UpdateWizard", "dialog is dismiss");
            m25632a(8);
        }
    }

    void mo4673b(C5279b c5279b) {
        C5165e.m24906b("UpdateWizard", "Enter onDoWork.");
        if (c5279b instanceof C5294g) {
            c5279b.m25561c();
            this.f18991f = 1;
            m25634a(C5280c.class);
            m25637f();
        } else if (c5279b instanceof C5286c) {
            c5279b.m25561c();
            m25632a(13);
        } else if (c5279b instanceof C5285b) {
            m25634a(C5290e.class);
            m25638g();
        } else if (c5279b instanceof C5298b) {
            m25632a(8);
        } else if (c5279b instanceof C5299c) {
            m25632a(8);
        } else if (c5279b instanceof C5300d) {
            m25632a(8);
        }
    }

    private void m25634a(Class<? extends C5279b> cls) {
        Exception e;
        m25636e();
        try {
            C5279b c5279b = (C5279b) cls.newInstance();
            if (this.f18990e > 0 && (c5279b instanceof C5290e)) {
                ((C5290e) c5279b).m25580a(this.f18990e);
            }
            c5279b.m25559a((C5277a) this);
            this.f18988c = c5279b;
        } catch (InstantiationException e2) {
            e = e2;
            C5165e.m24910d("UpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        } catch (IllegalAccessException e3) {
            e = e3;
            C5165e.m24910d("UpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        } catch (IllegalStateException e4) {
            e = e4;
            C5165e.m24910d("UpdateWizard", "In showDialog, Failed to show the dialog." + e.getMessage());
        }
    }

    private void m25636e() {
        if (this.f18988c != null) {
            try {
                this.f18988c.m25561c();
                this.f18988c = null;
            } catch (IllegalStateException e) {
                C5165e.m24910d("UpdateWizard", "In dismissDialog, Failed to dismiss the dialog." + e.getMessage());
            }
        }
    }

    private void m25637f() {
        this.f18989d = null;
        Context c = mo4674c();
        if (c != null && !c.isFinishing()) {
            m25639h();
            this.f18987b = new C5269h(new C5260e(c));
            this.f18987b.mo4652a(this);
        }
    }

    private void m25638g() {
        Context c = mo4674c();
        if (c != null && !c.isFinishing()) {
            m25639h();
            this.f18987b = new C5269h(new C5263f(c));
            this.f18987b.mo4653a(this, this.f18989d);
        }
    }

    private void m25639h() {
        if (this.f18987b != null) {
            this.f18987b.mo4654b();
            this.f18987b = null;
        }
    }

    private void m25632a(int i) {
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
        if (4 == i) {
            C5165e.m24906b("UpdateWizard", "In onKeyUp, Call finish.");
            Activity c = mo4674c();
            if (c != null && !c.isFinishing()) {
                c.setResult(0, null);
                c.finish();
            }
        }
    }
}
