package com.huawei.p091m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.google.gson.Gson;
import com.huawei.coresleepresult.HwCoreSleepDataProvider;
import com.huawei.coresleepresult.a.b;
import com.huawei.coresleepresult.a.c;
import com.huawei.coresleepresult.a.d;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonservice.model.C0988a;
import com.huawei.hwcommonservice.model.CoreSleepRRDataInfo;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager;
import com.huawei.hwfitnessmgr.receiver.SyncFitnessPrivateBroadcastReceiver;
import com.huawei.m.a;
import com.huawei.m.e;
import com.huawei.m.f;
import com.huawei.m.g;
import com.huawei.m.h;
import com.huawei.m.i;
import com.huawei.m.j;
import com.huawei.m.k;
import com.huawei.m.l;
import com.huawei.m.m;
import com.huawei.m.n;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: HwCoreSleepMgr */
public class C1111d extends C0628a {
    private static C1111d f2293c = null;
    ExecutorService f2294a;
    public int f2295b = 0;
    private C1204c f2296d;
    private HWDeviceDFXManager f2297e;
    private long f2298f = 0;
    private List<b> f2299g;
    private List<d> f2300h;
    private List<c> f2301i;
    private Context f2302j;
    private k f2303k;
    private boolean f2304l = false;
    private boolean f2305m = false;
    private long f2306n = 0;
    private a f2307o;
    private HandlerThread f2308p;
    private DeviceCapability f2309q = null;
    private Timer f2310r = null;
    private l f2311s = null;
    private C0988a f2312t = null;
    private final BroadcastReceiver f2313u = new i(this);

    public static C1111d m4931a(Context context) {
        C1111d c1111d;
        synchronized (C1111d.class) {
            C2538c.m12677c("HwCoreSleepMgr", "HwCoreSleepMgr getInstance() 1..................");
            if (f2293c == null) {
                f2293c = new C1111d(BaseApplication.m2632b());
            }
            c1111d = f2293c;
        }
        return c1111d;
    }

    private C1111d(Context context) {
        super(context);
        C2538c.m12677c("HwCoreSleepMgr", "HwCoreSleepMgr new start!..................");
        this.f2302j = BaseApplication.m2632b();
        this.f2307o = a.a();
        this.f2309q = C0972a.m3499a();
        this.f2296d = C1204c.m5370a(this.f2302j);
        if (this.f2296d == null) {
            C2538c.m12677c("HwCoreSleepMgr", "mHWDeviceConfigManager is null");
        }
        this.f2297e = HWDeviceDFXManager.getInstance(this.f2302j);
        if (this.f2297e == null) {
            C2538c.m12677c("HwCoreSleepMgr", "mHwDeviceDFXManager is null!");
        }
        this.f2294a = Executors.newFixedThreadPool(2);
        this.f2308p = new HandlerThread("HwCoreSleepMgr");
        this.f2308p.start();
        this.f2303k = new k(this, this.f2308p.getLooper());
        m4962m();
        C2538c.m12677c("HwCoreSleepMgr", "HwCoreSleepMgr new success!..................");
    }

    protected Integer getModuleId() {
        return Integer.valueOf(30);
    }

    public void m4965a(int i, ArrayList<byte[]> arrayList, ArrayList<byte[]> arrayList2) {
        C2538c.m12677c("HwCoreSleepMgr", " ENTER procCoreSleepData");
        if (this.f2304l) {
            C2538c.m12677c("HwCoreSleepMgr", "procCoreSleepData is running");
            return;
        }
        this.f2304l = true;
        if (this.f2303k != null && this.f2303k.hasMessages(0)) {
            this.f2303k.removeMessages(0);
        }
        if (arrayList2.size() == 0) {
            C2538c.m12677c("HwCoreSleepMgr", "procCoreSleepData data is null");
            this.f2295b = -1;
            this.f2304l = false;
            return;
        }
        int i2;
        C2538c.m12677c("HwCoreSleepMgr", "CoreSleepData from BT is as follow:");
        m4944b((ArrayList) arrayList, (ArrayList) arrayList2);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (arrayList.size() > 0) {
            C2538c.m12677c("HwCoreSleepMgr", "strDataContent size = " + arrayList.size());
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList3.add(i2, arrayList.get(i2));
            }
        }
        if (arrayList2.size() > 0) {
            C2538c.m12677c("HwCoreSleepMgr", "strStatusContent size = " + arrayList2.size());
            for (i2 = 0; i2 < arrayList2.size(); i2++) {
                arrayList4.add(i2, arrayList2.get(i2));
            }
        }
        C2538c.m12677c("HwCoreSleepMgr", "CoreSleepData before getCpcResult(mStrDataContent, mStrStatusContent) is as follow:");
        m4944b(arrayList3, arrayList4);
        if (i == 0) {
            m4938a(arrayList3, arrayList4);
            return;
        }
        C2538c.m12677c("HwCoreSleepMgr", " procCoreSleepData err, errCode = " + i);
    }

    private void m4952f() {
        int i;
        C2538c.m12677c("HwCoreSleepMgr", "enter setCoreSleepSyncRate()");
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.m12677c("HwCoreSleepMgr", "syncCoreSleepRate, current time = ", Long.valueOf(currentTimeMillis), ",begin synctime = ", Long.valueOf(this.f2306n), ",total time = ", Long.valueOf(1200000));
        if (currentTimeMillis - this.f2306n > 1200000) {
            C2538c.m12677c("HwCoreSleepMgr", "setCoreSleepSyncRate() time out");
            i = 100;
            m4956h();
            this.f2295b = -1;
            m4972e();
            this.f2305m = false;
            C2538c.m12677c("HwCoreSleepMgr", " setCoreSleepSyncRate sync time out");
        } else {
            C2538c.m12677c("HwCoreSleepMgr", "(currTime - beginSyncTime) < totalTime");
            if (1 == this.f2295b) {
                C2538c.m12677c("HwCoreSleepMgr", "rate = 100");
                i = 100;
                m4956h();
                m4960k();
                this.f2305m = false;
            } else if (-1 == this.f2295b) {
                i = 100;
                m4956h();
                m4972e();
                this.f2305m = false;
            } else {
                int i2 = (int) (((((double) (currentTimeMillis - this.f2306n)) / ((double) 1200000)) * 100.0d) + 2.0d);
                if (i2 <= 0 || i2 >= 40) {
                    i = (int) ((((((double) (currentTimeMillis - this.f2306n)) - (0.4d * ((double) 1200000))) / (((double) 1200000) * HeatmapTileProvider.DEFAULT_OPACITY)) * 20.0d) + 80.0d);
                } else {
                    i = (int) (((((double) (currentTimeMillis - this.f2306n)) / ((double) 1200000)) * 100.0d) * 2.0d);
                    if (i == 0) {
                        i = 1;
                    }
                }
                C2538c.m12677c("HwCoreSleepMgr", "rate :speed up = " + i);
            }
        }
        com.huawei.ui.commonui.d.a.a(this.f2302j).a(i);
        C2538c.m12677c("HwCoreSleepMgr", "leave setCoreSleepSyncRate()");
    }

    private void m4938a(ArrayList<byte[]> arrayList, ArrayList<byte[]> arrayList2) {
        C2538c.m12677c("HwCoreSleepMgr", "enter getCpcResult()");
        C2538c.m12677c("HwCoreSleepMgr", "CoreSleepData in getCpcResult is as follow:");
        m4944b((ArrayList) arrayList, (ArrayList) arrayList2);
        if (this.f2312t != null) {
            this.f2305m = false;
            CoreSleepRRDataInfo coreSleepRRDataInfo = new CoreSleepRRDataInfo();
            coreSleepRRDataInfo.setRRDataContent(arrayList);
            coreSleepRRDataInfo.setStatusContent(arrayList2);
            m4934a(coreSleepRRDataInfo, this.f2312t);
            this.f2304l = false;
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("value", "1");
        com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.dn.a(), hashMap, 0);
        this.f2299g = new ArrayList();
        this.f2300h = new ArrayList();
        this.f2301i = new ArrayList();
        this.f2303k.sendEmptyMessageDelayed(1, 180000);
        m4939a((ArrayList) arrayList, (ArrayList) arrayList2, new e(this));
    }

    public void m4963a() {
        this.f2295b = -1;
    }

    public void m4969b() {
        this.f2303k.sendEmptyMessageDelayed(2, 3000);
    }

    private void m4954g() {
        C2538c.m12677c("HwCoreSleepMgr", "handle sync error");
        this.f2295b = -1;
        com.huawei.ui.commonui.d.a.a(this.f2302j).a(100);
        m4972e();
    }

    private void m4956h() {
        C2538c.m12677c("HwCoreSleepMgr", "enter canleTimer");
        if (this.f2311s != null) {
            this.f2311s.cancel();
            this.f2311s = null;
            C2538c.m12677c("HwCoreSleepMgr", "sync time out,task cancle");
        }
        if (this.f2310r != null) {
            this.f2310r.cancel();
            this.f2310r = null;
            C2538c.m12677c("HwCoreSleepMgr", "sync time out,synctimer cancle");
        }
    }

    public void m4966a(long j) {
        String deviceIdentify;
        C2538c.m12677c("HwCoreSleepMgr", " enter updateLastSyncTime,time =" + j);
        C0993c c0993c = new C0993c();
        String l = Long.toString(j);
        DeviceInfo c = C1204c.m5370a(this.f2302j).m5447c();
        String str = "";
        if (c != null) {
            deviceIdentify = c.getDeviceIdentify();
        } else {
            deviceIdentify = str;
        }
        C2538c.m12674b("HwCoreSleepMgr", "currentDeviceMac is:" + deviceIdentify);
        Gson gson = new Gson();
        C2538c.m12674b("HwCoreSleepMgr", "get timeStrFromSharedPreference is: " + getSharedPreference("kStorage_CoreSleepMgr_Long_LastSyncTime"));
        try {
            Object obj = (List) gson.fromJson(getSharedPreference("kStorage_CoreSleepMgr_Long_LastSyncTime"), new f(this).getType());
        } catch (Exception e) {
            C2538c.m12680e("HwCoreSleepMgr", "fromJson parse fail.");
            List list = null;
        }
        if (r5 == null) {
            C2538c.m12677c("HwCoreSleepMgr", "lastSyncTimeList is null.");
            Object arrayList = new ArrayList();
            com.huawei.m.a.a aVar = new com.huawei.m.a.a();
            aVar.a(deviceIdentify);
            aVar.b(l);
            arrayList.add(aVar);
            C2538c.m12677c("HwCoreSleepMgr", "timeNew:" + new Gson().toJson(arrayList).toString());
            setSharedPreference("kStorage_CoreSleepMgr_Long_LastSyncTime", str, c0993c);
        } else if (r5.size() != 0) {
            com.huawei.m.a.a aVar2;
            C2538c.m12674b("HwCoreSleepMgr", "lastSyncTimeList: " + r5.toString());
            boolean z = false;
            for (com.huawei.m.a.a aVar22 : r5) {
                boolean z2;
                if (deviceIdentify.equalsIgnoreCase(aVar22.a())) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
            C2538c.m12677c("HwCoreSleepMgr", "isExist:" + z);
            if (z) {
                for (com.huawei.m.a.a aVar222 : r5) {
                    if (deviceIdentify.equalsIgnoreCase(aVar222.a())) {
                        aVar222.b(l);
                    }
                }
            } else {
                aVar222 = new com.huawei.m.a.a();
                aVar222.a(deviceIdentify);
                aVar222.b(l);
                r5.add(aVar222);
            }
            C2538c.m12677c("HwCoreSleepMgr", "timeUpdateStr:" + new Gson().toJson((Object) r5).toString());
            setSharedPreference("kStorage_CoreSleepMgr_Long_LastSyncTime", str, c0993c);
        }
    }

    public long m4970c() {
        String deviceIdentify;
        List list;
        C2538c.m12677c("HwCoreSleepMgr", "enter getLastSyncTime():");
        this.f2298f = 0;
        String str = "";
        DeviceInfo c = C1204c.m5370a(this.f2302j).m5447c();
        if (c != null) {
            deviceIdentify = c.getDeviceIdentify();
        } else {
            deviceIdentify = str;
        }
        C2538c.m12674b("HwCoreSleepMgr", "currentDeviceMac is: " + deviceIdentify);
        Gson gson = new Gson();
        C2538c.m12674b("HwCoreSleepMgr", "timeStrFromSharedPreference is: " + getSharedPreference("kStorage_CoreSleepMgr_Long_LastSyncTime"));
        try {
            list = (List) gson.fromJson(getSharedPreference("kStorage_CoreSleepMgr_Long_LastSyncTime"), new g(this).getType());
        } catch (Exception e) {
            C2538c.m12680e("HwCoreSleepMgr", "fromJson parse fail....");
            list = null;
        }
        if (list == null) {
            C2538c.m12677c("HwCoreSleepMgr", "lastSyncTimeList is null! ");
        } else if (list.size() != 0) {
            C2538c.m12677c("HwCoreSleepMgr", "lastSyncTimeList: " + list.toString());
            for (com.huawei.m.a.a aVar : list) {
                if (deviceIdentify.equalsIgnoreCase(aVar.a())) {
                    str = aVar.b();
                    if (!(str == null || str.isEmpty())) {
                        try {
                            this.f2298f = Long.parseLong(str);
                        } catch (Exception e2) {
                            C2538c.m12677c("HwCoreSleepMgr", " getLastCoreSleepSyncTime error:" + e2.getMessage());
                        }
                    }
                }
            }
        }
        C2538c.m12677c("HwCoreSleepMgr", " getLastCoreSleepSyncTime lastTimeStamp=" + this.f2298f);
        return this.f2298f;
    }

    public void m4964a(int i, int i2, boolean z, C0988a c0988a) {
        C2538c.m12677c("HwCoreSleepMgr", "syncRRDataForThrirPart not SupportCrowdFunding");
        try {
            c0988a.m3600a(100002, 0, 0, null);
        } catch (RemoteException e) {
            C2538c.m12677c("HwCoreSleepMgr", "Remote Exception  ", e);
        }
    }

    public void m4967a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HwCoreSleepMgr", "enter syncCoreSleepData. isSyncing = " + this.f2305m);
        C2538c.m12677c("HwCoreSleepMgr", "isFeatureIDSupport :" + C0969i.m3482a(58));
        if (!C0969i.m3482a(58)) {
            C2538c.m12677c("HwCoreSleepMgr", "this version don't support core sleep ,don't sync core sleep data." + r0);
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(100002, "this siteID don't support core sleep.");
            }
        } else if (!this.f2305m) {
            C2538c.m12677c("HwCoreSleepMgr", "syncCoreSleepData coreSleepMgrThreadPool.execute syncCoreSleep. isSyncing = " + this.f2305m);
            if (SyncFitnessPrivateBroadcastReceiver.m4152a() && this.f2309q != null && this.f2309q.isSupportSendCoreSleepOutState()) {
                C2538c.m12677c("HwCoreSleepMgr", "syncCoreSleepData isManualSync is true  同步科学睡眠前先通知单板出睡！！！");
                com.huawei.hwfitnessmgr.deviceadapter.d.g(1);
            }
            this.f2294a.execute(new n(this, (int) (m4970c() / 1000), (int) (System.currentTimeMillis() / 1000), iBaseResponseCallback));
        }
    }

    private void m4933a(int i, int i2, boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HwCoreSleepMgr", "enter syncCoreSleepDetailDataRun()");
        if (this.f2305m) {
            C2538c.m12677c("HwCoreSleepMgr", "syncing ,return ");
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(PayStatusCodes.PAY_STATE_TIME_OUT, " is syncing");
                return;
            }
            return;
        }
        this.f2305m = true;
        this.f2295b = 2;
        this.f2306n = System.currentTimeMillis();
        try {
            if (this.f2311s != null) {
                this.f2311s.cancel();
            }
            this.f2311s = new l(this);
            this.f2310r = new Timer();
            this.f2310r.schedule(this.f2311s, 0, 2000);
        } catch (Exception e) {
            C2538c.m12677c("HwCoreSleepMgr", "timer error" + e.getMessage());
        }
        m4942b(i, i2, z, iBaseResponseCallback);
        this.f2303k.sendEmptyMessageDelayed(0, 1200000);
    }

    private void m4942b(int i, int i2, boolean z, IBaseResponseCallback iBaseResponseCallback) {
        if (this.f2297e == null) {
            C2538c.m12677c("HwCoreSleepMgr", "mHWDeviceDFXManager is null");
            return;
        }
        C2538c.m12677c("HwCoreSleepMgr", " sendCommand() start time = ", Integer.valueOf(i), ",end time = ", Integer.valueOf(i2));
        m4959j();
        this.f2297e.getSleepDetailFromDevice(i, i2, z, new h(this, iBaseResponseCallback));
    }

    private void m4939a(ArrayList<byte[]> arrayList, ArrayList<byte[]> arrayList2, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HwCoreSleepMgr", "enter procCpcData() ,strDataContent = ", arrayList, ",strStatusContent = ", arrayList2);
        this.f2294a.execute(new m(this, arrayList, arrayList2, iBaseResponseCallback));
    }

    private void m4945b(ArrayList<byte[]> arrayList, ArrayList<byte[]> arrayList2, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HwCoreSleepMgr", "enter procCpcDataRun() ,strDataContent = ", arrayList, ",strStatusContent = ", arrayList2);
        new HwCoreSleepDataProvider().a(arrayList, arrayList2, iBaseResponseCallback);
    }

    private void m4957i() {
        C2538c.m12677c("HwCoreSleepMgr", "hwcoresleepmgr registerDeviceToHiHealth");
        if (this.f2296d != null) {
            DeviceInfo c = this.f2296d.m5447c();
            if (c != null) {
                com.huawei.al.a.a(c);
                return;
            }
            C2538c.m12680e("HwCoreSleepMgr", "hwcoresleepmgr registerDeviceToHiHealth deviceInfo is null");
            return;
        }
        C2538c.m12680e("HwCoreSleepMgr", "hwcoresleepmgr registerDeviceToHiHealth enter mHWDeviceConfigManager is null");
    }

    public long m4971d() {
        long c = m4970c();
        C2538c.m12677c("HwCoreSleepMgr", "enter getNewSyncTime(),LastSyncTime:" + c);
        if (this.f2301i == null || this.f2301i.size() == 0) {
            C2538c.m12677c("HwCoreSleepMgr", "mSleepErrorFramesList size = 0,Can not update SyncTime");
            return c + FileWatchdog.DEFAULT_DELAY;
        }
        long j = c;
        int i = 0;
        while (i < this.f2301i.size()) {
            if (((c) this.f2301i.get(i)).a() > j && (((c) this.f2301i.get(i)).b() == 104 || ((c) this.f2301i.get(i)).b() == 215 || ((c) this.f2301i.get(i)).b() == 217 || ((c) this.f2301i.get(i)).b() == FitnessSleepType.HW_FITNESS_NOON || ((c) this.f2301i.get(i)).b() == 252)) {
                j = ((c) this.f2301i.get(i)).a();
            }
            i++;
        }
        if (this.f2300h == null || this.f2300h.size() == 0) {
            C2538c.m12677c("HwCoreSleepMgr", "mSleepStatusFramesList size = 0,Can not update SyncTime");
            return j + FileWatchdog.DEFAULT_DELAY;
        } else if (this.f2299g != null && this.f2299g.size() != 0) {
            for (i = 0; i < this.f2300h.size(); i++) {
                if (((d) this.f2300h.get(i)).b() > j) {
                    j = ((d) this.f2300h.get(i)).b();
                }
            }
            C2538c.m12677c("HwCoreSleepMgr", "Leave getNewSyncTime(),NewSyncTime:" + (j + FileWatchdog.DEFAULT_DELAY));
            return j + FileWatchdog.DEFAULT_DELAY;
        } else if (m4968a(this.f2300h)) {
            C2538c.m12677c("HwCoreSleepMgr", "mSleepCalcFramesList size = 0, Has Night Sleep, Can not update SyncTime");
            return j + FileWatchdog.DEFAULT_DELAY;
        } else {
            for (i = 0; i < this.f2300h.size(); i++) {
                if (((d) this.f2300h.get(i)).b() > j) {
                    j = ((d) this.f2300h.get(i)).b();
                }
            }
            C2538c.m12677c("HwCoreSleepMgr", "mSleepCalcFramesList size = 0,Can Only update noonSleep Time");
            return j + FileWatchdog.DEFAULT_DELAY;
        }
    }

    public boolean m4968a(List<d> list) {
        for (int i = 0; i < list.size(); i++) {
            if (((Integer) ((d) list.get(i)).c().get(0)).intValue() != 5) {
                return true;
            }
        }
        return false;
    }

    private void m4959j() {
        C2538c.m12677c("HwCoreSleepMgr", "sendSyncStartBroadcast.");
        this.f2302j.sendBroadcast(new Intent("com.huawei.bone.action.CORE_SLEEP_DATA_SYNC_START"));
    }

    private void m4960k() {
        C2538c.m12677c("HwCoreSleepMgr", "sendSyncSuccBroadcast.");
        this.f2302j.sendBroadcast(new Intent("com.huawei.bone.action.CORE_SLEEP_DATA_SYNC_SUCCESS"));
    }

    public void m4972e() {
        C2538c.m12677c("HwCoreSleepMgr", "sendSyncFailBroadcast.");
        this.f2302j.sendBroadcast(new Intent("com.huawei.bone.action.CORE_SLEEP_DATA_SYNC_FAILED"));
    }

    protected void onDestroy() {
        super.onDestroy();
        m4956h();
        if (this.f2305m) {
            m4954g();
        }
        this.f2305m = false;
        if (this.f2303k != null) {
            this.f2303k.removeCallbacksAndMessages(null);
        }
        m4961l();
    }

    private void m4961l() {
        try {
            this.f2302j.unregisterReceiver(this.f2313u);
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("HwCoreSleepMgr", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("HwCoreSleepMgr", e2.getMessage());
        }
    }

    private void m4944b(ArrayList<byte[]> arrayList, ArrayList<byte[]> arrayList2) {
        int i;
        int i2;
        if (arrayList.size() > 0) {
            i = 0;
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                i += ((byte[]) arrayList.get(i2)).length;
            }
            C2538c.m12677c("HwCoreSleepMgr", "strDataContent length = " + i);
        } else {
            C2538c.m12677c("HwCoreSleepMgr", "strDataContent is null");
        }
        if (arrayList2.size() > 0) {
            i = 0;
            for (i2 = 0; i2 < arrayList2.size(); i2++) {
                i += ((byte[]) arrayList2.get(i2)).length;
            }
            C2538c.m12677c("HwCoreSleepMgr", "strStatusContent length = " + i);
            return;
        }
        C2538c.m12677c("HwCoreSleepMgr", "strStatusContent is null");
    }

    private void m4962m() {
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        this.f2302j.registerReceiver(this.f2313u, intentFilter, C0976c.f1642a, null);
    }

    private void m4934a(CoreSleepRRDataInfo coreSleepRRDataInfo, C0988a c0988a) {
        if (coreSleepRRDataInfo != null && this.f2312t != null) {
            this.f2294a.execute(new j(this, coreSleepRRDataInfo));
        }
    }
}
