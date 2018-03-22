package com.huawei.aa;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.aa.a.b;
import com.huawei.aa.a.c;
import com.huawei.aa.a.d;
import com.huawei.aa.a.e;
import com.huawei.aa.a.f;
import com.huawei.aa.b.a;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p036a.C0824b;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HWStressMgr */
public class C0629a extends C0628a {
    private static final Object f1083d = new Object();
    private static C0629a f1084e;
    private static long f1085m = 86400000;
    private static long f1086n = (7 * f1085m);
    private int f1087A;
    private int f1088B;
    private int f1089C;
    private List<Integer> f1090D = new ArrayList();
    private boolean f1091E = false;
    private boolean f1092F = false;
    List<HiHealthData> f1093a;
    List<HiHealthData> f1094b;
    IBaseResponseCallback f1095c = new b(this);
    private C1204c f1096f;
    private e f1097g;
    private IBaseResponseCallback f1098h;
    private ExecutorService f1099i;
    private boolean f1100j = false;
    private long f1101k = 0;
    private long f1102l = 0;
    private boolean f1103o = false;
    private String f1104p = "";
    private f f1105q = new f();
    private List<e> f1106r = new ArrayList();
    private e f1107s = new e();
    private int f1108t;
    private int f1109u;
    private int f1110v;
    private List<Integer> f1111w = new ArrayList();
    private c f1112x = new c();
    private List<b> f1113y = new ArrayList();
    private b f1114z = new b();

    void m2292a() {
        this.f1093a = new ArrayList();
        this.f1094b = new ArrayList();
    }

    public C0629a(Context context) {
        super(context);
        C2538c.m12677c("HWStressMgr", "HWStressMgr Constructor context = " + context);
        this.f1096f = C1204c.m5370a(context);
        if (this.f1096f == null) {
            C2538c.m12680e("HWStressMgr", "mHWDeviceConfigManager is null");
            return;
        }
        this.f1096f.m5423a(32, this.f1095c);
        this.f1099i = Executors.newFixedThreadPool(2);
        this.f1097g = new e(this, this);
        new a().a(this);
    }

    public static C0629a m2258a(Context context) {
        C0629a c0629a;
        synchronized (f1083d) {
            C2538c.m12677c("HWStressMgr", "getInstance() context = " + context);
            if (f1084e == null) {
                f1084e = new C0629a(BaseApplication.m2632b());
            }
            c0629a = f1084e;
        }
        return c0629a;
    }

    public void m2293a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWStressMgr", "enter toSyncStressDetailData");
        this.f1099i.execute(new f(this, iBaseResponseCallback));
    }

    private void m2272b(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWStressMgr", "enter syncStressDetailDataStart");
        C2538c.m12677c("HWStressMgr", "syncStressDetailDataStart isHiHealthDataLogin:" + C0970w.m3488a(C1093a.m4739a(BaseApplication.m2632b()).m4750c()));
        if (C0970w.m3488a(C1093a.m4739a(BaseApplication.m2632b()).m4750c())) {
            boolean z;
            C2538c.m12677c("HWStressMgr", "hiHealthVersionCode = " + C0824b.m2914a(BaseApplication.m2632b()).m2912b());
            if (C0824b.m2914a(BaseApplication.m2632b()).m2912b() > 10001100) {
                z = true;
            } else {
                z = false;
            }
            C2538c.m12677c("HWStressMgr", "isHiHealthSupportStress:" + z);
            if (z) {
                DeviceInfo c = this.f1096f.m5447c();
                if (C0972a.m3499a() != null) {
                    this.f1100j = C0972a.m3499a().isSupportStress();
                    if (this.f1100j) {
                        C2538c.m12677c("HWStressMgr", "support stress ,begin to sync data.");
                        if (c == null || c.getDeviceConnectState() != 2) {
                            C2538c.m12677c("HWStressMgr", "no device is connected.");
                            if (iBaseResponseCallback != null) {
                                iBaseResponseCallback.onResponse(400003, "no device is connected.");
                                return;
                            }
                            return;
                        }
                        m2277c(iBaseResponseCallback);
                        return;
                    }
                    C2538c.m12677c("HWStressMgr", "don't support stress.");
                    iBaseResponseCallback.onResponse(400004, "don't support stress.");
                    return;
                }
                C2538c.m12677c("HWStressMgr", "CapabilityUtils.getDeviceCapability() is null!");
                if (iBaseResponseCallback != null) {
                    iBaseResponseCallback.onResponse(400003, " CapabilityUtils.getDeviceCapability() is null.");
                    return;
                }
                return;
            }
            C2538c.m12677c("HWStressMgr", "the hiHealth is not support storage stress.do other data sync.");
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(400007, "hiHealth not support store stress.");
                return;
            }
            return;
        }
        C2538c.m12677c("HWStressMgr", "the hiHealth not login.do other data sync.");
        if (iBaseResponseCallback != null) {
            iBaseResponseCallback.onResponse(400006, "hiHealth data not Login.");
        }
    }

    private void m2277c(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWStressMgr", "enter syncStressDetailDataRun(): isSyncing = " + this.f1103o);
        if (this.f1103o) {
            C2538c.m12677c("HWStressMgr", "isSyncing,please wait, return.");
            iBaseResponseCallback.onResponse(400002, "isSyncing already.");
            return;
        }
        m2291j();
        this.f1098h = iBaseResponseCallback;
        this.f1103o = true;
        this.f1101k = System.currentTimeMillis();
        this.f1102l = m2289h();
        C2538c.m12677c("HWStressMgr", "currentTime = " + this.f1101k + ", lastSyncTime = " + this.f1102l);
        if (this.f1102l == 0 || this.f1101k - this.f1102l > f1086n) {
            this.f1102l = this.f1101k - f1086n;
        }
        int i = (int) (this.f1102l / 1000);
        int i2 = (int) (this.f1101k / 1000);
        this.f1097g.sendEmptyMessageDelayed(0, 180000);
        com.huawei.aa.c.b.a(i, i2);
    }

    private void m2268a(byte[] bArr) {
        C2538c.m12677c("HWStressMgr", "enter processStressFrameIndexList(), data =  " + C0973a.m3509a(bArr));
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                C2538c.m12680e("HWStressMgr", "processStressFrameIndexList return errorCode:" + com.huawei.aa.c.c.a(bArr));
                if (this.f1098h != null) {
                    this.f1098h.onResponse(400003, Integer.valueOf(r0));
                }
                if (this.f1097g != null) {
                    this.f1097g.removeMessages(0);
                }
                this.f1103o = false;
                return;
            }
            this.f1105q = com.huawei.aa.c.c.b(bArr);
            C2538c.m12677c("HWStressMgr", "stressRecordIndexList = " + this.f1105q.toString());
            this.f1108t = this.f1105q.b();
            C2538c.m12677c("HWStressMgr", "stress frameCount :" + this.f1108t);
            if (this.f1108t > 0) {
                this.f1111w = this.f1105q.a();
                if (this.f1111w != null) {
                    C2538c.m12677c("HWStressMgr", "stress indexList :" + this.f1111w.toString());
                    this.f1109u = this.f1111w.size();
                    C2538c.m12677c("HWStressMgr", "stressIndexListSize :" + this.f1109u);
                    this.f1110v = 0;
                    com.huawei.aa.c.b.a(((Integer) this.f1111w.get(0)).intValue());
                    return;
                }
                C2538c.m12677c("HWStressMgr", "no stress frame index.start to sync relax data.");
                m2280d();
                return;
            }
            C2538c.m12677c("HWStressMgr", "else : no stress frame index.start to sync relax data.");
            m2280d();
        } catch (Exception e) {
            C2538c.m12677c("HWStressMgr", " Exception :" + e.getMessage());
        }
    }

    private void m2273b(byte[] bArr) {
        C2538c.m12677c("HWStressMgr", "enter processStressRecordDetail(), data =  " + C0973a.m3509a(bArr));
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                C2538c.m12680e("HWStressMgr", "processStressRecordDetail return errorCode:" + com.huawei.aa.c.c.a(bArr));
                if (this.f1098h != null) {
                    this.f1098h.onResponse(400003, Integer.valueOf(r0));
                }
                if (this.f1097g != null) {
                    this.f1097g.removeMessages(0);
                }
                this.f1103o = false;
                return;
            }
            this.f1107s = com.huawei.aa.c.c.c(bArr);
            C2538c.m12677c("HWStressMgr", "stressRecordDetails = " + this.f1107s.toString());
            this.f1106r.add(this.f1107s);
            C2538c.m12677c("HWStressMgr", "stressIndexProcessed = " + this.f1110v);
            this.f1110v++;
            if (this.f1110v < this.f1108t) {
                com.huawei.aa.c.b.a(((Integer) this.f1111w.get(this.f1110v)).intValue());
                return;
            }
            C2538c.m12677c("HWStressMgr", "stressRecordDetailsList = " + this.f1106r.toString());
            m2280d();
        } catch (Exception e) {
            C2538c.m12677c("HWStressMgr", " Exception :" + e.getMessage());
        }
    }

    private void m2278c(byte[] bArr) {
        C2538c.m12677c("HWStressMgr", "enter processRelaxFrameIndexList(), data =  " + C0973a.m3509a(bArr));
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                C2538c.m12680e("HWStressMgr", "processRelaxFrameIndexList return errorCode:" + com.huawei.aa.c.c.a(bArr));
                if (this.f1098h != null) {
                    this.f1098h.onResponse(400003, Integer.valueOf(r0));
                }
                if (this.f1097g != null) {
                    this.f1097g.removeMessages(0);
                }
                this.f1103o = false;
                return;
            }
            this.f1112x = com.huawei.aa.c.c.d(bArr);
            C2538c.m12677c("HWStressMgr", "relaxRecordIndexList = " + this.f1112x.toString());
            this.f1087A = this.f1112x.b();
            C2538c.m12677c("HWStressMgr", "relax frameCount :" + this.f1087A);
            if (this.f1087A > 0) {
                this.f1090D = this.f1112x.a();
                if (this.f1090D != null) {
                    C2538c.m12677c("HWStressMgr", "relax indexList :" + this.f1090D.toString());
                    this.f1088B = this.f1090D.size();
                    C2538c.m12677c("HWStressMgr", "relaxIndexListSize" + this.f1088B);
                    this.f1089C = 0;
                    com.huawei.aa.c.b.b(((Integer) this.f1090D.get(0)).intValue());
                    return;
                }
                C2538c.m12677c("HWStressMgr", "no relax frame index.");
                m2284e();
                return;
            }
            C2538c.m12677c("HWStressMgr", "else : no relax frame index.");
            m2284e();
        } catch (Exception e) {
            C2538c.m12677c("HWStressMgr", "relax getIndexList Exception :" + e.getMessage());
        }
    }

    private void m2282d(byte[] bArr) {
        C2538c.m12677c("HWStressMgr", "enter processRelaxRecordDetail(), data =  " + C0973a.m3509a(bArr));
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                C2538c.m12680e("HWStressMgr", "processRelaxRecordDetail return errorCode:" + com.huawei.aa.c.c.a(bArr));
                if (this.f1098h != null) {
                    this.f1098h.onResponse(400003, Integer.valueOf(r0));
                }
                if (this.f1097g != null) {
                    this.f1097g.removeMessages(0);
                }
                this.f1103o = false;
                return;
            }
            this.f1114z = com.huawei.aa.c.c.e(bArr);
            C2538c.m12677c("HWStressMgr", "relaxRecordDetails = " + this.f1114z.toString());
            this.f1113y.add(this.f1114z);
            C2538c.m12677c("HWStressMgr", "relaxIndexProcessed = " + this.f1089C);
            this.f1089C++;
            if (this.f1089C < this.f1087A) {
                com.huawei.aa.c.b.b(((Integer) this.f1090D.get(this.f1089C)).intValue());
                return;
            }
            C2538c.m12677c("HWStressMgr", "relaxRecordDetailsList = " + this.f1113y.toString());
            m2284e();
        } catch (Exception e) {
            C2538c.m12677c("HWStressMgr", " Exception :" + e.getMessage());
        }
    }

    private void m2280d() {
        C2538c.m12677c("HWStressMgr", "startToSyncRelaxDetailsData enter():");
        this.f1102l = m2289h();
        C2538c.m12677c("HWStressMgr", "currentTime = " + this.f1101k + ", lastSyncTime = " + this.f1102l);
        if (this.f1102l == 0 || this.f1101k - this.f1102l > f1086n) {
            this.f1102l = this.f1101k - f1086n;
        }
        com.huawei.aa.c.b.b((int) (this.f1102l / 1000), (int) (this.f1101k / 1000));
    }

    public void m2294b() {
        C2538c.m12677c("HWStressMgr", "hwstessmgr registerDeviceToHiHealth");
        if (this.f1096f != null) {
            DeviceInfo c = this.f1096f.m5447c();
            if (c != null) {
                com.huawei.al.a.a(c);
                return;
            }
            C2538c.m12680e("HWStressMgr", "hwstessmgr registerDeviceToHiHealth deviceInfo is null");
            return;
        }
        C2538c.m12680e("HWStressMgr", "hwstessmgr registerDeviceToHiHealth enter mHWDeviceConfigManager is null");
    }

    private void m2284e() {
        C2538c.m12677c("HWStressMgr", "saveAllDataToHiHealth enter():");
        m2294b();
        m2292a();
        m2287f();
    }

    private void m2287f() {
        C2538c.m12677c("HWStressMgr", "saveStressDetailsListToHiHealth enter():");
        if (this.f1106r == null || this.f1106r.size() <= 0) {
            this.f1091E = true;
            C2538c.m12677c("HWStressMgr", "saveStressDetailsListToHiHealth relaxRecordDetailsList is null.start save relax data.");
            this.f1097g.sendEmptyMessage(1);
            return;
        }
        C2538c.m12677c("HWStressMgr", "stressRecordDetailsList.size() = " + this.f1106r.size());
        for (int i = 0; i < this.f1106r.size(); i++) {
            m2264a((e) this.f1106r.get(i));
        }
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        hiDataInsertOption.setDatas(this.f1093a);
        C0824b.m2914a(BaseApplication.m2632b()).m2903a(hiDataInsertOption, new c(this));
    }

    private void m2288g() {
        C2538c.m12677c("HWStressMgr", "saveRelaxDetailsListToHiHealth enter():");
        if (this.f1113y == null || this.f1113y.size() <= 0) {
            C2538c.m12677c("HWStressMgr", "saveRelaxDetailsListToHiHealth relaxRecordDetailsList is null!end saveToHealth.");
            this.f1092F = true;
            C2538c.m12677c("HWStressMgr", "saveStressSuccess = " + this.f1091E);
            C2538c.m12677c("HWStressMgr", "saveRelaxSuccess = " + this.f1092F);
            if (this.f1091E && this.f1092F) {
                m2262a(this.f1101k);
            }
            if (this.f1098h != null) {
                this.f1098h.onResponse(400001, "save successful.");
            }
            if (this.f1097g != null) {
                this.f1097g.removeMessages(0);
            }
            this.f1103o = false;
            return;
        }
        C2538c.m12677c("HWStressMgr", "relaxRecordDetailsList.size() = " + this.f1113y.size());
        for (int i = 0; i < this.f1113y.size(); i++) {
            m2263a((b) this.f1113y.get(i));
        }
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        hiDataInsertOption.setDatas(this.f1094b);
        C0824b.m2914a(BaseApplication.m2632b()).m2903a(hiDataInsertOption, new d(this));
    }

    private void m2264a(e eVar) {
        C2538c.m12677c("HWStressMgr", "saveStressDetailData enter:");
        List a = eVar.a();
        C2538c.m12677c("HWStressMgr", "list size = " + a.size());
        for (int i = 0; i < a.size(); i++) {
            long c = ((d) a.get(i)).c();
            int a2 = ((d) a.get(i)).a();
            switch (((d) a.get(i)).b()) {
                case 1:
                    m2260a(2019, c, a2);
                    break;
                case 2:
                    m2260a(2020, c, a2);
                    break;
                default:
                    break;
            }
        }
        C2538c.m12677c("HWStressMgr", "stressList:" + this.f1093a.toString());
    }

    private void m2260a(int i, long j, int i2) {
        C2538c.m12677c("HWStressMgr", "enter AddToHealthStressList(): stressType = " + i + ",stressTime = " + j + ",stressScore = " + i2);
        HiHealthData hiHealthData = new HiHealthData(i);
        long j2 = 1000 * j;
        hiHealthData.setTimeInterval(j2, j2);
        hiHealthData.setValue(i2);
        hiHealthData.setDeviceUUID(com.huawei.al.a.a());
        this.f1093a.add(hiHealthData);
    }

    private void m2263a(b bVar) {
        C2538c.m12677c("HWStressMgr", "enter saveRelaxDetailData()");
        List a = bVar.a();
        C2538c.m12677c("HWStressMgr", "list size = " + a.size());
        for (int i = 0; i < a.size(); i++) {
            int d = ((com.huawei.aa.a.a) a.get(i)).d();
            long c = ((com.huawei.aa.a.a) a.get(i)).c();
            int a2 = ((com.huawei.aa.a.a) a.get(i)).a();
            int b = ((com.huawei.aa.a.a) a.get(i)).b();
            switch (d) {
                case 1:
                    m2261a(TradeCode.ALIPAY_ONE_KEY_QUERY, c, a2, b);
                    break;
                default:
                    break;
            }
        }
        C2538c.m12677c("HWStressMgr", "relaxList:" + this.f1094b.toString());
    }

    private void m2261a(int i, long j, int i2, int i3) {
        C2538c.m12677c("HWStressMgr", "enter addToHealthRelaxList(): relaxType = " + i + ",relaxTime = " + j + ",relaxLength = " + i2 + ",relaxScore = " + i3);
        HiHealthData hiHealthData = new HiHealthData(i);
        long j2 = j * 1000;
        hiHealthData.setTimeInterval(j2, ((((long) i2) * 60) * 1000) + j2);
        hiHealthData.setValue(i3);
        hiHealthData.setDeviceUUID(com.huawei.al.a.a());
        this.f1094b.add(hiHealthData);
    }

    private long m2289h() {
        C2538c.m12674b("HWStressMgr", "getLastSyncTime enter");
        return new a().b(this);
    }

    private void m2262a(long j) {
        C2538c.m12674b("HWStressMgr", "setLastSyncTime time = " + j);
        new a().a(this, j);
    }

    protected Integer getModuleId() {
        return Integer.valueOf(32);
    }

    protected void onDestroy() {
        super.onDestroy();
        C0629a.m2290i();
        this.f1103o = false;
        m2291j();
    }

    private static void m2290i() {
        synchronized (f1083d) {
            f1084e = null;
        }
    }

    private void m2291j() {
        C2538c.m12677c("HWStressMgr", "enter resetAllParams():");
        if (this.f1097g != null) {
            this.f1097g.removeCallbacksAndMessages(null);
        }
        this.f1098h = null;
        this.f1108t = 0;
        this.f1109u = 0;
        this.f1087A = 0;
        this.f1088B = 0;
        this.f1105q = new f();
        this.f1112x = new c();
        if (this.f1106r != null) {
            this.f1106r.clear();
        }
        if (this.f1113y != null) {
            this.f1113y.clear();
        }
        this.f1091E = false;
        this.f1092F = false;
    }

    public String m2295c() {
        DeviceInfo c = this.f1096f.m5447c();
        if (c != null) {
            this.f1104p = c.getDeviceIdentify();
        }
        return this.f1104p;
    }
}
