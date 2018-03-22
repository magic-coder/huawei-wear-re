package com.huawei.ui.main.stories.settings.p185a;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.huawei.ab.C0630m;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.e;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.wheelview.a;
import com.huawei.ui.main.j;
import com.huawei.up.model.UserInfomation;

/* compiled from: UserProfileSettingsInteractors */
public class C2465f {
    private static final String f8845A = BaseApplication.m2632b().getResources().getString(j.IDS_weight_array_unit);
    private static final String f8846u = BaseApplication.m2632b().getResources().getString(j.IDS_cm);
    final String[] f8847a = new String[201];
    final String[] f8848b = new String[8];
    final String[] f8849c = new String[12];
    final String[] f8850d = new String[2];
    final String[] f8851e = new String[241];
    final String[] f8852f = new String[531];
    final String[] f8853g = new String[2];
    a f8854h;
    Dialog f8855i;
    a f8856j;
    Dialog f8857k;
    IBaseResponseCallback f8858l = new C2466g(this);
    private Context f8859m;
    private Handler f8860n;
    private int f8861o;
    private int f8862p;
    private int f8863q;
    private String f8864r;
    private int f8865s;
    private int f8866t;
    private int f8867v;
    private String f8868w;
    private int f8869x;
    private int f8870y;
    private int f8871z;

    public int m12316a() {
        return this.f8861o;
    }

    public void m12317a(int i) {
        this.f8861o = i;
    }

    public int m12321b() {
        return this.f8865s;
    }

    public void m12322b(int i) {
        this.f8865s = i;
    }

    public String m12324c() {
        return this.f8864r;
    }

    public void m12320a(String str) {
        this.f8864r = str;
    }

    public int m12326d() {
        return this.f8866t;
    }

    public void m12325c(int i) {
        this.f8866t = i;
    }

    public int m12328e() {
        return this.f8870y;
    }

    public void m12327d(int i) {
        this.f8870y = i;
    }

    public int m12330f() {
        return this.f8871z;
    }

    public void m12329e(int i) {
        this.f8871z = i;
    }

    public String m12331g() {
        return this.f8868w;
    }

    public void m12323b(String str) {
        this.f8868w = str;
    }

    public C2465f(Context context, Handler handler) {
        this.f8859m = context;
        this.f8860n = handler;
        m12315n();
    }

    private void m12315n() {
        int i;
        m12319a(this.f8858l);
        for (i = 0; i <= 200; i++) {
            this.f8847a[i] = C0956c.m3344a((double) (i + 50), 1, 0);
        }
        for (i = 0; i <= 7; i++) {
            this.f8848b[i] = C0956c.m3344a((double) (i + 1), 1, 0);
        }
        for (i = 0; i <= 11; i++) {
            this.f8849c[i] = C0956c.m3344a((double) (i + 0), 1, 0);
        }
        this.f8850d[0] = this.f8859m.getResources().getString(j.IDS_cm);
        this.f8850d[1] = this.f8859m.getResources().getString(j.IDS_ft);
        for (i = 0; i <= 240; i++) {
            this.f8851e[i] = C0956c.m3344a((double) (i + 10), 1, 0);
        }
        for (i = 0; i <= 530; i++) {
            this.f8852f[i] = C0956c.m3344a((double) (i + 22), 1, 0);
        }
        this.f8853g[0] = this.f8859m.getResources().getString(j.IDS_weight_array_unit);
        this.f8853g[1] = this.f8859m.getResources().getString(j.IDS_lbs);
    }

    public void m12319a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("UserProfileSettingsInteractors", "enter getUserInfo():");
        C0630m.m2297a(this.f8859m).m2306a(iBaseResponseCallback);
    }

    public void m12318a(Context context, UserInfomation userInfomation, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("UserProfileSettingsInteractors", "enter setUserInfo():");
        C0630m.m2297a(this.f8859m).m2311a(true, context, userInfomation, iBaseResponseCallback);
    }

    public void m12332h() {
        C2538c.m12677c("UserProfileSettingsInteractors", "enter editHeight():");
        this.f8854h = new a(this.f8859m, 0);
        this.f8854h.a(-2130706433, -15884293);
        this.f8854h.setOnWheelChangedListener(new C2470k(this));
        int b;
        if (1 == m12326d()) {
            C2538c.m12677c("UserProfileSettingsInteractors", "HEIGHT_UNIT_FT == heightTypeGetFromDB ,heightValue = " + m12321b() + ",getHeightType() = " + m12326d());
            b = m12321b();
            if (b < 12 || b > 107) {
                b = 12;
            }
            int b2 = e.b(b);
            b = e.c(b);
            this.f8854h.b();
            this.f8854h.c(this.f8850d, m12326d(), false);
            this.f8854h.a(this.f8848b, b2 - 1, true);
            this.f8854h.setFirstWheelPickValueUnit(this.f8859m.getString(j.IDS_ft));
            this.f8854h.b(this.f8849c, b + 0, true);
            this.f8854h.setSecondWheelPickValueUnit(this.f8859m.getString(j.IDS_ins));
        } else if (m12326d() == 0) {
            C2538c.m12677c("UserProfileSettingsInteractors", "HEIGHT_UNIT_CM == heightTypeGetFromDB，heightValue = " + m12321b() + ",getHeightType() = " + m12326d());
            this.f8854h.a();
            b = m12321b();
            if (b < 50 || b > 250) {
                b = 50;
            }
            this.f8854h.c(this.f8850d, m12326d(), false);
            this.f8854h.a(this.f8847a, b - 50, true);
        }
        this.f8855i = this.f8854h.a(this.f8859m.getString(j.IDS_sns_height_title), new C2471l(this), this.f8859m.getString(j.IDS_settings_button_ok).toUpperCase(), new C2472m(this), this.f8859m.getString(j.IDS_settings_button_cancal).toUpperCase());
    }

    private void m12309c(String str) {
        int i;
        C2538c.m12677c("UserProfileSettingsInteractors", "enter updateDBHeight():");
        C2538c.m12677c("UserProfileSettingsInteractors", "heightTypeUpdated: " + str);
        if (str.equalsIgnoreCase(this.f8859m.getString(j.IDS_cm))) {
            i = 0;
        } else {
            i = 1;
        }
        C2538c.m12677c("UserProfileSettingsInteractors", "heightTypeUpdatedInt====" + i);
        m12319a(new C2473n(this, str, i));
    }

    public void m12333i() {
        m12319a(new C2475p(this));
    }

    public void m12334j() {
        C2538c.m12677c("UserProfileSettingsInteractors", "enter editWeight():");
        this.f8856j = new a(this.f8859m, 1);
        this.f8856j.a(-2130706433, -15884293);
        this.f8856j.setOnWheelChangedListener(new C2476q(this));
        if (1 == m12328e()) {
            C2538c.m12677c("UserProfileSettingsInteractors", "WEIGHT_UNIT_LB == weight_type,weight_type = " + m12328e() + ", getWeightValue() = " + m12330f());
            this.f8856j.a(this.f8852f, m12330f() - 22, true);
            this.f8856j.c(this.f8853g, 1, false);
        } else if (m12328e() == 0) {
            this.f8856j.a(this.f8851e, m12330f() - 10, true);
            this.f8856j.c(this.f8853g, 0, false);
        }
        this.f8857k = this.f8856j.a(this.f8859m.getString(j.IDS_sns_weight_title), new C2477r(this), this.f8859m.getString(j.IDS_settings_button_ok).toUpperCase(), new C2478s(this), this.f8859m.getString(j.IDS_settings_button_cancal).toUpperCase());
    }

    private void m12312d(String str) {
        int i;
        C2538c.m12677c("UserProfileSettingsInteractors", "enter updateDBWeight():");
        if (str.equalsIgnoreCase(this.f8859m.getString(j.IDS_weight_array_unit))) {
            i = 0;
        } else {
            i = 1;
        }
        C2538c.m12677c("UserProfileSettingsInteractors", "weightTypeUpdatedInt = " + i);
        m12319a(new C2467h(this, str, i));
    }

    public void m12335k() {
        m12319a(new C2469j(this));
    }

    public void m12336l() {
        C2538c.m12677c("UserProfileSettingsInteractors", "destroyDialogAndWheelView()");
        if (this.f8857k != null) {
            this.f8857k.cancel();
            this.f8857k = null;
        }
        if (this.f8855i != null) {
            this.f8855i.cancel();
            this.f8855i = null;
        }
        this.f8854h = null;
        this.f8856j = null;
    }

    public void m12337m() {
        C2538c.m12677c("UserProfileSettingsInteractors", "sendBroadcastToRefreshUnitSet():");
        Intent intent = new Intent();
        intent.setAction("com.huawei.bone.action.REFRESH_UNIT");
        this.f8859m = BaseApplication.m2632b();
        this.f8859m.sendBroadcast(intent, C0976c.f1642a);
    }
}
