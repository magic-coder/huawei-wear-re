package com.huawei.ui.homewear21.card.p176a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.hwservicesmgr.p076a.C1045q;
import com.huawei.n.a;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.b;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.homewear21.h;
import com.huawei.ui.homewear21.i;
import com.huawei.ui.main.stories.guide.p181a.C2378a;
import com.huawei.ui.main.stories.nps.interactors.C2442a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DeviceStateInteractors */
public class C2243a {
    private static final String f8159a = C2243a.class.getSimpleName();
    private static C2243a f8160b = null;
    private static C1204c f8161c;
    private Context f8162d;
    private u f8163e;

    private C2243a(Context context) {
        this.f8162d = context;
    }

    public static C2243a m11601a() {
        if (f8160b == null) {
            f8160b = new C2243a(BaseApplication.m2632b());
        }
        if (f8161c == null) {
            f8161c = C1204c.m5370a(BaseApplication.m2632b());
        }
        return f8160b;
    }

    public int m11612b() {
        DeviceInfo c = f8161c.m5447c();
        if (c != null) {
            return c.getDeviceConnectState();
        }
        return 0;
    }

    public DeviceInfo m11614c() {
        DeviceInfo c = f8161c.m5447c();
        return c != null ? c : null;
    }

    public int m11615d() {
        DeviceInfo c = f8161c.m5447c();
        if (c != null) {
            return c.getProductType();
        }
        return -1;
    }

    public String m11616e() {
        String str = "";
        DeviceInfo c = f8161c.m5447c();
        if (c != null) {
            return c.getDeviceName();
        }
        C2538c.m12677c(f8159a, "getCurrentDeviceName deviceInfo is null");
        return "";
    }

    public void m11608a(IBaseResponseCallback iBaseResponseCallback) {
        if (iBaseResponseCallback != null) {
            f8161c.m5441b(iBaseResponseCallback);
        }
    }

    public List<DeviceInfo> m11617f() {
        List<DeviceInfo> a;
        try {
            a = f8161c.m5421a();
        } catch (RemoteException e) {
            C2538c.m12680e(f8159a, "RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
            a = null;
        }
        if (a != null) {
            return a;
        }
        C2538c.m12680e(f8159a, "getUsedDeviceList null");
        return new ArrayList();
    }

    public void m11610a(List<DeviceInfo> list) {
        try {
            f8161c.m5433a((List) list);
        } catch (RemoteException e) {
            C2538c.m12680e(f8159a, "RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public boolean m11618g() {
        boolean z = false;
        try {
            z = f8161c.m5464m();
        } catch (RemoteException e) {
            C2538c.m12680e(f8159a, "getSystemBluetoothSwitchState RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
        return z;
    }

    public void m11611a(boolean z) {
        try {
            f8161c.m5436a(z);
        } catch (RemoteException e) {
            C2538c.m12680e(f8159a, "openSystemBluetoothSwitch RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public void m11607a(Context context) {
        C2538c.m12677c(f8159a, "nps startNps qstnSurveyActivate###");
        m11604c(context);
    }

    private void m11604c(Context context) {
        C2538c.m12677c(f8159a, "Enter qstnSurveyActivate");
        if (context == null) {
            C2538c.m12677c(f8159a, "qstnSurveyActivate activityContext is null");
        }
        if (C0969i.m3482a(45)) {
            boolean c;
            C2378a c2378a = new C2378a(BaseApplication.m2632b());
            if (c2378a != null) {
                c = c2378a.m11994c();
            } else {
                c = true;
            }
            if (!c) {
                C2538c.m12677c(f8159a, "testnps =========qstnSurveyInit-->没有选中用户体验改进计划，return");
                return;
            }
        }
        if (C0977d.m3555e(this.f8162d)) {
            C2538c.m12677c(f8159a, "testnps, qstnSurveyActivate qstnSurvey.activatedQstnSurvey");
            C2442a.m12225a(this.f8162d).m12270b();
            return;
        }
        C2538c.m12677c(f8159a, "testnps, Network is disabled");
    }

    public void m11609a(b bVar) {
        C2538c.m12677c(f8159a, "Enter refreshAllCardsData");
        C1026q a = C1026q.m4018a(this.f8162d.getApplicationContext());
        if (a == null) {
            C2538c.m12680e(f8159a, "refreshAllCardsData hwFitnessMgr is null return!");
            return;
        }
        C2538c.m12677c(f8159a, "refreshAllCardsData syncFitnessDetailData!!!");
        a.m4130b(new C2244b(this, bVar));
        C2538c.m12677c(f8159a, "Leave refreshAllCardsData");
    }

    public int m11606a(int i) {
        C2538c.m12677c(f8159a, "Enter getIdImage ：" + i);
        int i2 = h.img_home_talkbandb3;
        com.huawei.n.b a = a.a(i);
        if (a.c() != 0) {
            return a.c();
        }
        return i2;
    }

    public void m11613b(Context context) {
        C2538c.m12677c(f8159a, "Enter enterHuaweiAppStore():");
        Boolean.valueOf(false);
        if (C0977d.m3555e(this.f8162d)) {
            Boolean valueOf = Boolean.valueOf(m11603a(m11599a("https://a.vmall.com/exmarket?id=4026633").setPackage("com.huawei.appmarket")));
            C2538c.m12677c(f8159a, "isInstallFlag =" + valueOf);
            if (!valueOf.booleanValue()) {
                C2538c.m12677c(f8159a, "isInstallFlag = false,弹框提示用户下载华为应用市场");
                m11602a(m11599a("https://a.vmall.com/exmarket?id=4026633").setPackage("com.huawei.appmarket"), context);
                return;
            }
            return;
        }
        C2538c.m12677c(f8159a, "Error about network,Network is not Connected!");
        com.huawei.ui.commonui.c.a.a(context, i.IDS_confirm_network_whether_connected);
    }

    private Intent m11599a(String str) {
        C2538c.m12677c(f8159a, "enter createViewIntent():");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268468224);
        return intent;
    }

    private boolean m11603a(Intent intent) {
        C2538c.m12677c(f8159a, " enter openOemAppstore()");
        if (this.f8162d.getPackageManager().resolveActivity(intent, 65536) != null) {
            try {
                this.f8162d.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                C2538c.m12680e(f8159a, "Exception localActivityNotFoundException = " + e.getMessage());
            }
        }
        return false;
    }

    private void m11602a(Intent intent, Context context) {
        C2538c.m12677c(f8159a, " enter showAppStoreDialog()");
        this.f8163e = new w(context).a(i.IDS_device_replace_dialog_title_notification).b(i.IDS_main_sns_app_store_content).a(i.IDS_settings_button_ok, new C2246d(this, intent, context)).b(i.IDS_settings_button_cancal, new C2245c(this)).a();
        this.f8163e.setCancelable(false);
        this.f8163e.show();
    }
}
