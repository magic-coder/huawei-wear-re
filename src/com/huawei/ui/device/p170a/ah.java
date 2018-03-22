package com.huawei.ui.device.p170a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.text.TextUtils;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwservicesmgr.C1053k;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.hwversionmgr.utils.C1080f;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.device.i;
import com.huawei.ui.main.stories.messagecenter.interactors.C2422e;
import com.huawei.ui.main.stories.p177a.p178a.C2278b;
import com.huawei.y.a.a;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

/* compiled from: UpdateInteractors */
public class ah {
    private static ah f6865q;
    public int f6866a = 0;
    public String f6867b = null;
    public String f6868c = null;
    public String f6869d = null;
    public DataDeviceInfo f6870e;
    public int f6871f = -1;
    public String f6872g = null;
    public String f6873h = null;
    public String f6874i = "";
    public DeviceInfo f6875j;
    public int f6876k = 0;
    C1053k f6877l = new al(this);
    private Context f6878m;
    private C1071a f6879n;
    private C1204c f6880o;
    private a f6881p;
    private int f6882r = 2;
    private boolean f6883s = false;

    public boolean m10329a() {
        return this.f6883s;
    }

    public void m10325a(Boolean bool) {
        this.f6883s = bool.booleanValue();
    }

    ah(Context context) {
        this.f6878m = context;
        this.f6876k = 0;
        this.f6879n = C1071a.m4507a(this.f6878m);
        this.f6880o = C1204c.m5370a(this.f6878m);
    }

    public static ah m10316a(Context context) {
        C2538c.m12677c("UpdateInteractors", "getInstance,instance-----------" + f6865q);
        if (f6865q == null) {
            C2538c.m12677c("UpdateInteractors", "new UpdateInteractors()");
            f6865q = new ah(BaseApplication.m2632b());
        }
        return f6865q;
    }

    public int m10331b() {
        return this.f6882r;
    }

    public void m10334c() {
        C2538c.m12677c("UpdateInteractors", "enter autoCheckBandNewVersionService");
        if (this.f6880o == null) {
            this.f6880o = C1204c.m5370a(this.f6878m);
        }
        this.f6880o.m5425a(new ai(this));
    }

    public void m10337d() {
        if (m10343j()) {
            if (this.f6879n == null) {
                this.f6879n = C1071a.m4507a(this.f6878m);
            }
            C2538c.m12677c("UpdateInteractors", "enter autoDownload");
            this.f6879n.m4518d();
            return;
        }
        C2538c.m12677c("UpdateInteractors", "auto download not in wifi");
    }

    public void m10338e() {
        if (this.f6879n == null) {
            this.f6879n = C1071a.m4507a(this.f6878m);
        }
        if (this.f6880o == null) {
            this.f6880o = C1204c.m5370a(this.f6878m);
        }
        this.f6875j = this.f6880o.m5447c();
        if (this.f6875j != null) {
            this.f6871f = this.f6875j.getProductType();
            this.f6872g = this.f6875j.getDeviceIdentify();
            C2538c.m12677c("UpdateInteractors", "deviceType : " + this.f6871f + " deviceSoftVersion: " + this.f6873h + "deviceBtMac:" + this.f6872g);
        }
        if (this.f6871f == -1 || this.f6872g == null) {
            Intent intent = new Intent("action_app_check_new_version_state");
            intent.addFlags(1610612736);
            intent.putExtra("result", 3);
            intent.putExtra("state", 11);
            this.f6878m.sendBroadcast(intent, C0976c.f1642a);
        } else if (this.f6873h == null) {
            C2538c.m12674b("UpdateInteractors", "doManualCheckDeviceNewVersion,deviceSoftVersion is null");
            this.f6880o.m5425a(new aj(this));
        } else {
            this.f6879n.m4510a(this.f6871f, this.f6873h, this.f6872g, Boolean.valueOf(false));
        }
    }

    public void m10339f() {
        C2538c.m12677c("UpdateInteractors", "doDownloadAppFile ");
        if (this.f6878m != null) {
            C1071a.m4507a(this.f6878m).m4514b(Boolean.valueOf(false));
        }
    }

    public void m10340g() {
        C2538c.m12677c("UpdateInteractors", "cancelDownloadApp");
        if (this.f6878m != null) {
            C1071a.m4507a(this.f6878m).m4516c();
        }
    }

    public String m10341h() {
        C2538c.m12677c("UpdateInteractors", "enter getBandCheckNewVersion");
        String str = "";
        if (this.f6878m != null) {
            return C1071a.m4507a(this.f6878m).m4526i();
        }
        return str;
    }

    public String m10342i() {
        C2538c.m12677c("UpdateInteractors", "enter getBandStorePath");
        String str = "";
        if (this.f6878m != null) {
            return C1071a.m4507a(this.f6878m).m4527j();
        }
        return str;
    }

    public boolean m10330a(long j) {
        C2538c.m12677c("UpdateInteractors", "checkMemory needSize = " + j);
        StatFs statFs = new StatFs(this.f6878m.getFilesDir().getAbsolutePath());
        if (((long) (((double) (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()))) * 0.9d)) > j) {
            return true;
        }
        return false;
    }

    public boolean m10343j() {
        C2538c.m12677c("UpdateInteractors", "isWifiConnected");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6878m.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    public boolean m10344k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6878m.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public void m10345l() {
        C2538c.m12677c("UpdateInteractors", "isNeedTransfer get auto ota checkbox status,isAutoupdate = " + new C2278b().m11721a());
        if (new C2278b().m11721a()) {
            if (this.f6879n == null) {
                this.f6879n = C1071a.m4507a(this.f6878m);
            }
            Object l = this.f6879n.m4529l();
            if (!this.f6879n.m4524g()) {
                C2538c.m12677c("UpdateInteractors", "band new package is not exist");
                return;
            } else if (l == null || TextUtils.isEmpty(l)) {
                C2538c.m12677c("UpdateInteractors", "band new package version is not exist");
                return;
            } else if (this.f6876k != 0) {
                C2538c.m12677c("UpdateInteractors", "is manaual updating updateStatus:" + this.f6876k);
                return;
            } else {
                C2538c.m12677c("UpdateInteractors", "is transfering :" + this.f6883s);
                if (!this.f6883s) {
                    this.f6881p = a.c();
                    if (this.f6881p == null) {
                        C2538c.m12677c("UpdateInteractors", "HWOTABaseMgr is null");
                        return;
                    }
                    C2538c.m12677c("UpdateInteractors", "isNeedTransfer() new mHWOTABaseMgr = " + this.f6881p);
                    this.f6882r = this.f6881p.a();
                    C2538c.m12677c("UpdateInteractors", "isNeedTransfer() new mOtaType = " + this.f6882r);
                    this.f6881p.a(l, new ak(this));
                    return;
                }
                return;
            }
        }
        C2538c.m12677c("UpdateInteractors", "WLAN auto update close, return");
    }

    public String m10324a(String str) {
        String str2 = "";
        if (this.f6878m != null) {
            return C1071a.m4507a(this.f6878m).m4508a(str);
        }
        return str2;
    }

    public DeviceInfo m10346m() {
        DeviceInfo deviceInfo = null;
        if (this.f6878m != null) {
            deviceInfo = C1204c.m5370a(this.f6878m).m5447c();
        }
        if (deviceInfo != null) {
            this.f6871f = deviceInfo.getProductType();
            this.f6874i = deviceInfo.getDeviceName();
            this.f6872g = deviceInfo.getDeviceIdentify();
            C2538c.m12677c("UpdateInteractors", "getCurrentDeviceInfo() deviceType = " + this.f6871f);
            C2538c.m12677c("UpdateInteractors", "getCurrentDeviceInfo() mDeviceName = " + this.f6874i);
            C2538c.m12677c("UpdateInteractors", "getCurrentDeviceInfo() deviceBtMac = " + this.f6872g);
            C2538c.m12677c("UpdateInteractors", "getCurrentDeviceInfo() getFirstConnectTime" + deviceInfo.getFirstConnectTime());
        }
        return deviceInfo;
    }

    public void m10326a(String str, int i, String str2, C1053k c1053k) {
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() version = " + str);
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() updateMode = " + i);
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() filePath = " + str2);
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() mHWOTABaseMgr = " + this.f6881p);
        this.f6881p = a.c();
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() new mHWOTABaseMgr = " + this.f6881p);
        this.f6882r = this.f6881p.a();
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() new mOtaType = " + this.f6882r);
        this.f6881p.a(str, i, str2, c1053k);
        C2538c.m12677c("UpdateInteractors", "is transfering " + this.f6883s);
        this.f6883s = true;
    }

    public void m10347n() {
        C2538c.m12677c("UpdateInteractors", "enter startAutoTransfer :" + this.f6883s);
        this.f6883s = true;
        String h = m10341h();
        String i = m10342i();
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() version = " + h);
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() updateMode = " + 2);
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() filePath = " + i);
        this.f6881p = a.c();
        if (this.f6881p == null) {
            C2538c.m12677c("UpdateInteractors", "HWOTABaseMgr is null");
            return;
        }
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() new mHWOTABaseMgr = " + this.f6881p);
        this.f6882r = this.f6881p.a();
        C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() new mOtaType = " + this.f6882r);
        m10318a(h, i, 2);
    }

    private void m10318a(String str, String str2, int i) {
        C2538c.m12677c("UpdateInteractors", " enter startTransferOtaFile ");
        this.f6881p.a(str, i, str2, this.f6877l);
    }

    public void m10327a(String str, int i, String str2, String str3) {
        C2538c.m12677c("UpdateInteractors", "is transfering :" + this.f6883s);
        if (!this.f6883s) {
            C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() mHWOTABaseMgr = " + this.f6881p);
            String format = String.format(this.f6878m.getString(i.IDS_update_new_version_message), new Object[]{str});
            this.f6869d = format + "\n" + c.a(this.f6878m, (long) i) + "\n" + str2;
            this.f6881p = a.c();
            if (this.f6881p == null) {
                C2538c.m12677c("UpdateInteractors", "HWOTABaseMgr is null");
                return;
            }
            C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() new mHWOTABaseMgr = " + this.f6881p);
            this.f6882r = this.f6881p.a();
            C2538c.m12677c("UpdateInteractors", "startTransferOtaFile() new mOtaType = " + this.f6882r);
            this.f6881p.a(str, new am(this));
        }
    }

    public boolean m10333b(String str) {
        C2538c.m12677c("UpdateInteractors", "isOtaFileExist(): path = " + str);
        if (TextUtils.isEmpty(str)) {
            C2538c.m12680e("UpdateInteractors", "isOtaFileExist() error, file path is empty...");
            return false;
        }
        C2538c.m12677c("UpdateInteractors", "isOtaFileExist: bExist = " + new File(str).exists());
        return new File(str).exists();
    }

    public void m10332b(Boolean bool) {
        if (bool.booleanValue()) {
            m10317a(1);
        }
    }

    public void m10348o() {
        m10317a(3);
    }

    private void m10317a(int i) {
        m10346m();
        C1971j a = C1971j.m10236a(this.f6878m);
        a.m10254b("device", "device_ota", new an(this, a, i));
    }

    private void m10321b(boolean z) {
        C2538c.m12677c("UpdateInteractors", "enter deleteMessage");
        C1971j a = C1971j.m10236a(this.f6878m);
        C2422e c2422e = new C2422e(this.f6878m);
        a.m10254b("device", "device_ota", new ap(this, z, a, c2422e));
        c2422e.m12174a(20171027);
    }

    public void m10328a(boolean z) {
        m10321b(z);
        C2538c.m12677c("UpdateInteractors", "enter deleteMessage  ture");
    }

    public void m10349p() {
        m10321b(false);
        C2538c.m12677c("UpdateInteractors", "enter deleteMessage  false");
    }

    public void m10350q() {
        C2538c.m12677c("UpdateInteractors", "initUpdateInteractors ");
        Executors.newSingleThreadExecutor().execute(new aq(this));
        if (this.f6878m != null) {
            C1071a.m4507a(this.f6878m).m4530m();
        }
        this.f6876k = 0;
        this.f6866a = 0;
        this.f6867b = null;
        this.f6868c = null;
        this.f6869d = "";
        this.f6870e = null;
        this.f6871f = -1;
        this.f6872g = null;
        this.f6873h = null;
        this.f6874i = null;
        this.f6875j = null;
        this.f6879n = null;
        this.f6880o = null;
        this.f6881p = null;
    }

    public void m10351r() {
        if (this.f6879n == null) {
            this.f6879n = C1071a.m4507a(this.f6878m);
        }
        C2538c.m12677c("UpdateInteractors", "enter deleteDfu");
        this.f6879n.m4525h();
    }

    public void m10352s() {
        C2538c.m12677c("UpdateInteractors", "enter release");
        this.f6879n = null;
        this.f6880o = null;
        this.f6881p = null;
    }

    public void m10336c(String str) {
        if (this.f6879n == null) {
            this.f6879n = C1071a.m4507a(this.f6878m);
        }
        this.f6879n.m4517c(str);
    }

    public boolean m10353t() {
        List runningTasks = ((ActivityManager) this.f6878m.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            C2538c.m12677c("UpdateInteractors", "current activity  :" + ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName());
            if (TextUtils.equals(((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName(), "com.huawei.ui.device.activity.update.BandUpdateDialogActivity")) {
                return true;
            }
        }
        return false;
    }

    public boolean m10354u() {
        C1204c a = C1204c.m5370a(BaseApplication.m2632b());
        if (a == null || a.m5447c() == null) {
            C2538c.m12680e("UpdateInteractors", "deviceConfigManager.getCurrentDeviceInfo() is null!!");
            return false;
        } else if (5 != a.m5447c().getProductType()) {
            return false;
        } else {
            return true;
        }
    }

    public void m10355v() {
        C1080f.m4601b(C1080f.m4595a(), this.f6878m);
    }

    public void m10335c(Boolean bool) {
        if (this.f6878m != null) {
            C1071a.m4507a(this.f6878m).m4512a(Boolean.valueOf(false), bool);
        }
    }

    public boolean m10356w() {
        DeviceInfo m = m10346m();
        if (m == null) {
            return false;
        }
        if (!ah.m10323d(m.getFirstConnectTime())) {
            return false;
        }
        C2538c.m12677c("UpdateInteractors", "isBetweenOneDay");
        return true;
    }

    public static boolean m10323d(String str) {
        C2538c.m12677c("UpdateInteractors", "isAlreadyUpdatedOfBand: strLastTime = " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long longValue = C0977d.m3541b(str).longValue();
        if (longValue == 0) {
            return false;
        }
        C2538c.m12677c("UpdateInteractors", "Long.valueOf(strLastTime) = " + longValue);
        if (Math.abs(new Date().getTime() - longValue) <= 86400000) {
            return true;
        }
        C2538c.m12677c("UpdateInteractors", "return value is = false");
        return false;
    }
}
