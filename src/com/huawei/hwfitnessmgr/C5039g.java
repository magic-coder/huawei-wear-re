package com.huawei.hwfitnessmgr;

import android.support.v4.internal.view.SupportMenu;
import com.huawei.al.C4028a;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.a.b;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcommonmodel.C0973a.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.fitnessdatatype.DataTotalMotion;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessComm;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData;
import com.huawei.hwcommonmodel.fitnessdatatype.SleepTotalData;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5018a;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5019b;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5020c;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5021d;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5023f;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5026i;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5027j;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5028k;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5029l;
import com.huawei.hwfitnessmgr.p421a.p422a.C5009a;
import com.huawei.p032e.p264a.p265a.p385a.C4383a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* compiled from: FitnessMgrStorage */
public class C5039g {
    private static C5039g f18241d;
    C5029l f18242a = null;
    List<HiHealthData> f18243b;
    List<HiHealthData> f18244c;
    private C5047o f18245e = null;
    private C5009a f18246f = new C5009a();
    private long f18247g = 0;
    private long f18248h = 0;
    private long f18249i = 0;

    private C5039g() {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"FitnessMgrStorage Constructor"});
        this.f18245e = new C5047o(this, BaseApplication.b().getMainLooper());
    }

    public static C5039g m24302a() {
        C2538c.c("Fitness_MgrStorage", new Object[]{"getInstance() context"});
        if (f18241d == null) {
            f18241d = new C5039g();
        }
        return f18241d;
    }

    public void m24317a(q qVar) {
        new C5048p().m24348a(qVar);
        new C5010a().m24074a(qVar);
        new ba().m24109a(qVar);
    }

    public void m24330b(q qVar) {
        C2538c.c("Fitness_MgrStorage", new Object[]{"initFitnessUserStorage."});
    }

    public boolean m24332b() {
        boolean isClimb;
        DeviceCapability a = a.a();
        if (a != null) {
            isClimb = a.isClimb();
        } else {
            C2538c.c("Fitness_MgrStorage", new Object[]{"getDeviceDataType deviceCapability is null"});
            isClimb = false;
        }
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"isDeviceSupportClimeHeight " + isClimb});
        return isClimb;
    }

    public SleepTotalData m24333c(q qVar) {
        int parseInt;
        Object e;
        int i = 0;
        SleepTotalData sleepTotalData = new SleepTotalData();
        try {
            parseInt = Integer.parseInt(qVar.getSharedPreference("kStorage_FitnessMgr_Int_TotalDeepSleep"));
            try {
                i = Integer.parseInt(qVar.getSharedPreference("kStorage_FitnessMgr_Int_TotalShallowSleep"));
            } catch (NumberFormatException e2) {
                e = e2;
                C2538c.e("Fitness_MgrStorage", new Object[]{"get sleep time Exception:" + e});
                sleepTotalData.setDeepSleepTime(parseInt);
                sleepTotalData.setShallowSleepTime(i);
                return sleepTotalData;
            }
        } catch (NumberFormatException e3) {
            e = e3;
            parseInt = i;
            C2538c.e("Fitness_MgrStorage", new Object[]{"get sleep time Exception:" + e});
            sleepTotalData.setDeepSleepTime(parseInt);
            sleepTotalData.setShallowSleepTime(i);
            return sleepTotalData;
        }
        sleepTotalData.setDeepSleepTime(parseInt);
        sleepTotalData.setShallowSleepTime(i);
        return sleepTotalData;
    }

    public void m24323a(q qVar, C5023f c5023f) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveTodayTotalData get data success total cal=" + c5023f.m24208a()});
        List arrayList = new ArrayList();
        SleepTotalData sleepTotalData = new SleepTotalData();
        arrayList.clear();
        List<DataTotalMotion> b = c5023f.m24212b();
        FitnessTotalData fitnessTotalData = new FitnessTotalData();
        fitnessTotalData.setCalorie(c5023f.m24208a() * 1000);
        for (DataTotalMotion dataTotalMotion : b) {
            C2538c.b("Fitness_MgrStorage", new Object[]{"type" + dataTotalMotion.getMotion_type() + " step= " + dataTotalMotion.getStep() + " cal=" + dataTotalMotion.getCalorie() + " distance=" + dataTotalMotion.getDistance()});
            FitnessTotalData fitnessTotalData2;
            switch (dataTotalMotion.getMotion_type()) {
                case 1:
                    fitnessTotalData.addSteps(dataTotalMotion.getStep());
                    fitnessTotalData.addDistance(dataTotalMotion.getDistance());
                    arrayList.add(new FitnessTotalData(dataTotalMotion));
                    break;
                case 2:
                    fitnessTotalData.addSteps(dataTotalMotion.getStep());
                    fitnessTotalData.addDistance(dataTotalMotion.getDistance());
                    arrayList.add(new FitnessTotalData(dataTotalMotion));
                    break;
                case 3:
                    fitnessTotalData.addSteps(dataTotalMotion.getStep());
                    fitnessTotalData2 = new FitnessTotalData(dataTotalMotion);
                    if (true == qVar.j()) {
                        fitnessTotalData.setHeight(dataTotalMotion.getDistance());
                        fitnessTotalData2.setHeight(fitnessTotalData2.getDistance());
                        fitnessTotalData2.setDistance(0);
                    } else {
                        fitnessTotalData2.setHeight(fitnessTotalData2.getHeight());
                        fitnessTotalData2.setDistance(fitnessTotalData2.getDistance());
                        fitnessTotalData.setHeight(dataTotalMotion.getHeight());
                        fitnessTotalData.addDistance(dataTotalMotion.getDistance());
                    }
                    arrayList.add(fitnessTotalData2);
                    break;
                case 4:
                    fitnessTotalData2 = new FitnessTotalData(dataTotalMotion);
                    fitnessTotalData.addDistance(fitnessTotalData2.getDistance());
                    arrayList.add(fitnessTotalData2);
                    break;
                case 5:
                    break;
                case 6:
                    sleepTotalData.setShallowSleepTime(dataTotalMotion.getSleep_time());
                    break;
                case 7:
                    sleepTotalData.setDeepSleepTime(dataTotalMotion.getSleep_time());
                    break;
                default:
                    break;
            }
        }
        arrayList.add(fitnessTotalData);
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{" steps =" + fitnessTotalData.getSteps() + " calorie =" + fitnessTotalData.getCalorie() + " distance =" + fitnessTotalData.getDistance() + "size=" + arrayList.size()});
        m24319a(qVar, fitnessTotalData);
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_TOTAL_STEPS_FROM_DEVICE_FLAG", String.valueOf(fitnessTotalData.getSteps()), null);
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_TOTAL_CAL_FROM_DEVICE_FLAG", String.valueOf(fitnessTotalData.getCalorie() / 1000), null);
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_TOTAL_DISTANCE_FROM_DEVICE_FLAG", String.valueOf(fitnessTotalData.getDistance()), null);
    }

    public static long m24299a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public void m24319a(q qVar, FitnessTotalData fitnessTotalData) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveTodayTotaltoHiHealth fitnessTotalData :", fitnessTotalData});
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        long a = C5039g.m24299a(System.currentTimeMillis());
        List arrayList = new ArrayList();
        if (fitnessTotalData.getSteps() > 0) {
            HiHealthData hiHealthData = new HiHealthData();
            hiHealthData.setType(PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED);
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            hiHealthData.setTimeInterval(a, System.currentTimeMillis());
            hiHealthData.setValue(fitnessTotalData.getSteps());
            arrayList.add(hiHealthData);
        }
        if (fitnessTotalData.getCalorie() > 0) {
            hiHealthData = new HiHealthData();
            hiHealthData.setType(PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION);
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            hiHealthData.setTimeInterval(a, System.currentTimeMillis());
            hiHealthData.setValue(fitnessTotalData.getCalorie());
            arrayList.add(hiHealthData);
        }
        if (fitnessTotalData.getDistance() > 0) {
            hiHealthData = new HiHealthData();
            hiHealthData.setType(PayStatusCodes.PRODUCT_SOME_NOT_EXIST);
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            hiHealthData.setTimeInterval(a, System.currentTimeMillis());
            hiHealthData.setValue(fitnessTotalData.getDistance());
            arrayList.add(hiHealthData);
        }
        if (fitnessTotalData.getHeight() > 0) {
            hiHealthData = new HiHealthData();
            hiHealthData.setType(40005);
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            hiHealthData.setTimeInterval(a, System.currentTimeMillis());
            hiHealthData.setValue(fitnessTotalData.getHeight());
            arrayList.add(hiHealthData);
        }
        if (arrayList.size() > 0) {
            hiDataInsertOption.setDatas(arrayList);
            b.a(BaseApplication.b()).a(hiDataInsertOption, new C5040h(this));
        }
    }

    public boolean m24329a(long j, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
        if (simpleDateFormat.format(new Date(j * 1000)).equals(simpleDateFormat.format(new Date(j2 * 1000)))) {
            return true;
        }
        C2538c.b("Fitness_MgrStorage", new Object[]{"day=" + simpleDateFormat.format(new Date(j * 1000)) + " date1=" + new Date(j * 1000) + ",day1=" + simpleDateFormat.format(new Date(j2 * 1000)) + " date2=" + new Date(j2 * 1000)});
        return false;
    }

    private boolean m24312b(long j, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (simpleDateFormat.format(new Date(j * 1000)).equals(simpleDateFormat.format(new Date(1000 * j2)))) {
            return true;
        }
        C2538c.b("Fitness_MgrStorage", new Object[]{"checkIsSameGTMDay day=", simpleDateFormat.format(new Date(j * 1000)), ",day1=", simpleDateFormat.format(new Date(1000 * j2))});
        return false;
    }

    private C5021d m24309b(q qVar, C5021d c5021d) {
        C5021d c5021d2 = new C5021d();
        int a = this.f18246f.m24060a();
        int b = this.f18246f.m24063b();
        int c = this.f18246f.m24065c();
        long d = this.f18246f.m24067d();
        int c2 = c5021d.m24199c();
        int d2 = c5021d.m24201d();
        int e = c5021d.m24203e();
        if (c2 < a || d2 < b || e < c) {
            Object[] objArr = new Object[1];
            objArr[0] = "lastTimeStamp " + d + " date1=" + new Date(1000 * d) + " current timeStamp=" + c5021d.m24194a() + ", date2=" + new Date(c5021d.m24194a() * 1000) + " lastcal=" + b + " laststep=" + a + " lastdis=" + c + " curr:cal=" + d2 + " step=" + c2 + " dis=" + e;
            c.a("05", 1, "Fitness_MgrStorage", objArr);
        }
        if (!m24329a(d, c5021d.m24194a())) {
            a = 0;
            b = 0;
            c = 0;
            this.f18246f.m24061a(0);
            this.f18246f.m24066c(0);
            this.f18246f.m24069e(0);
        }
        c5021d2.m24195a(c5021d.m24197b());
        c5021d2.m24198b(c2 - a);
        c5021d2.m24200c(d2 - b);
        c5021d2.m24202d(e - c);
        c5021d2.m24196a(c5021d.m24194a());
        return c5021d2;
    }

    private boolean m24307a(int i, int i2) {
        if (i == 2) {
            if (i2 > 0 && i2 < 500) {
                return true;
            }
        } else if (i == 4) {
            if (i2 > 0 && i2 < SupportMenu.USER_MASK) {
                return true;
            }
        } else if (i == 2018 || i == 2002) {
            if (i2 > 0 && i2 < 255) {
                return true;
            }
        } else if (i == 5) {
            if (i2 > 0 && i2 < 1500) {
                return true;
            }
        } else if (i2 > 0) {
            return true;
        }
        return false;
    }

    private C5021d m24300a(C5021d c5021d, int i) {
        if (!m24307a(m24308b(1), c5021d.m24199c())) {
            C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"invalid date type=" + c5021d.m24197b() + " step=" + c5021d.m24199c() + " TimeStamp=" + c5021d.m24194a() + " date=" + new Date(c5021d.m24194a() * 1000)});
            c5021d.m24198b(0);
        }
        if (!m24307a(m24308b(2), c5021d.m24201d())) {
            C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"invalid date type=" + c5021d.m24197b() + " cal=" + c5021d.m24201d() + " TimeStamp=" + c5021d.m24194a() + " date=" + new Date(c5021d.m24194a() * 1000)});
            c5021d.m24200c(0);
        }
        if (!m24307a(i, c5021d.m24203e())) {
            C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"invalid date type=" + c5021d.m24197b() + " dis=" + c5021d.m24203e() + " TimeStamp=" + c5021d.m24194a() + " date=" + new Date(c5021d.m24194a() * 1000)});
            c5021d.m24202d(0);
        }
        return c5021d;
    }

    private void m24314c(q qVar, C5021d c5021d) {
        int b = c5021d.m24197b();
        int c = c5021d.m24199c();
        int d = c5021d.m24201d();
        int e = c5021d.m24203e();
        int i = 3;
        if (m24332b() && c5021d.m24197b() == 3) {
            i = 5;
        }
        c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveSportData type=" + b + " cal=" + d + " step=" + c + " dis=" + e + " TimeStamp=" + c5021d.m24194a() + " date=" + new Date(c5021d.m24194a() * 1000)});
        C5021d a = m24300a(c5021d, i);
        if (a.m24199c() > 0) {
            HiHealthData hiHealthData = new HiHealthData(2);
            hiHealthData.setTimeInterval(a.m24194a() * 1000, (a.m24194a() + 60) * 1000);
            hiHealthData.setValue(a.m24199c());
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            this.f18243b.add(hiHealthData);
        } else {
            c.b("Fitness_MgrStorage", new Object[]{"invalid date step=" + a.m24199c() + " TimeStamp=" + a.m24194a()});
        }
        if (a.m24203e() > 0) {
            hiHealthData = new HiHealthData(i);
            hiHealthData.setValue(a.m24203e());
            hiHealthData.setTimeInterval(a.m24194a() * 1000, (a.m24194a() + 60) * 1000);
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            this.f18243b.add(hiHealthData);
        } else {
            c.b("Fitness_MgrStorage", new Object[]{"invalid date dis=" + a.m24203e() + " TimeStamp=" + a.m24194a()});
        }
        if (a.m24201d() > 0) {
            HiHealthData hiHealthData2 = new HiHealthData(4);
            hiHealthData2.setTimeInterval(a.m24194a() * 1000, (a.m24194a() + 60) * 1000);
            hiHealthData2.setValue(a.m24201d());
            hiHealthData2.setDeviceUUID(C4028a.m19823a());
            this.f18243b.add(hiHealthData2);
            return;
        }
        c.b("Fitness_MgrStorage", new Object[]{"invalid date cal=", Integer.valueOf(a.m24201d()), " TimeStamp=", Long.valueOf(a.m24194a())});
    }

    private void m24304a(C5021d c5021d) {
        if (c5021d.m24197b() == 0) {
            C2538c.c("Fitness_MgrStorage", new Object[]{"updataLastTotal getCurrentStatus= ", Integer.valueOf(c5021d.m24197b())});
            return;
        }
        int c = c5021d.m24199c();
        int d = c5021d.m24201d();
        int e = c5021d.m24203e();
        if (c == 0 && d == 0 && e == 0) {
            c.e("Fitness_MgrStorage", new Object[]{"updataLastTotal getCurrentStatus: step ,cal ,dis =0"});
            return;
        }
        this.f18246f.m24070f(e);
        this.f18246f.m24064b(c);
        this.f18246f.m24068d(d);
        this.f18246f.m24062a(c5021d.m24194a());
    }

    private C5021d m24301a(q qVar, C5019b c5019b) {
        C5021d c5021d = new C5021d();
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"getSportDataFromMotionStruct st= ", c5019b});
        int b = c5019b.m24179b();
        int c = c5019b.m24181c();
        int d = c5019b.m24183d();
        int a = this.f18246f.m24060a();
        int b2 = this.f18246f.m24063b();
        int c2 = this.f18246f.m24065c();
        long d2 = this.f18246f.m24067d();
        if (b < a || c < b2 || d < c2) {
            c.a("05", 1, "Fitness_MgrStorage", new Object[]{"lastTimeStamp" + d2 + " date1=" + new Date(1000 * d2) + " current timeStamp=" + c5019b.m24187f() + ", date2=" + new Date(((long) c5019b.m24187f()) * 1000) + " lastcal=" + b2 + " laststep=" + a + " lastdis=" + c2 + " curr:cal=" + c + " step=" + b + " dis=" + d});
        }
        if (!m24312b(d2, (long) c5019b.m24187f())) {
            a = 0;
            b2 = 0;
            c2 = 0;
            this.f18246f.m24061a(0);
            this.f18246f.m24066c(0);
            this.f18246f.m24069e(0);
        }
        c5021d.m24195a(c5019b.m24177a());
        c5021d.m24198b(b - a);
        c5021d.m24200c(c - b2);
        c5021d.m24202d(d - c2);
        c5021d.m24196a((long) c5019b.m24187f());
        return c5021d;
    }

    public void m24326a(q qVar, List<C5019b> list) {
        this.f18246f = new ba().m24111b(qVar);
        Collections.sort(list, new C5041i(this));
        m24334c();
        for (C5019b c5019b : list) {
            if (c5019b.m24177a() == 6 || c5019b.m24177a() == 7) {
                C5020c c5020c = new C5020c();
                c5020c.m24192b(c5019b.m24185e());
                c5020c.m24190a((long) c5019b.m24187f());
                m24321a(qVar, c5020c);
            } else if (c5019b.m24177a() != 5) {
                C5021d a = m24301a(qVar, c5019b);
                m24304a(a);
                m24314c(qVar, a);
                m24322a(qVar, a);
            }
        }
        m24337d(qVar);
        m24339e(qVar);
    }

    public void m24331b(q qVar, List<C5018a> list) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveFitnessData enter"});
        int i = qVar.i();
        Collections.sort(list, new C5042j(this));
        m24334c();
        this.f18246f = new ba().m24111b(qVar);
        this.f18247g = this.f18246f.m24067d();
        if (4 == i) {
            for (C5018a a : list) {
                m24320a(qVar, a);
            }
        } else if (qVar.f() == 0) {
            for (C5018a a2 : list) {
                m24320a(qVar, a2);
            }
        } else {
            for (C5018a a22 : list) {
                m24320a(qVar, a22);
            }
        }
        m24339e(qVar);
        C2538c.c("Fitness_MgrStorage", new Object[]{"saveFitnessData leave"});
    }

    public void m24322a(q qVar, C5021d c5021d) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"updateStatus DataRawSportData " + c5021d});
        if (c5021d.m24199c() != 0 || c5021d.m24201d() != 0 || c5021d.m24203e() != 0) {
            if (this.f18242a == null) {
                this.f18242a = new C5029l();
                this.f18242a.m24246a(c5021d.m24194a());
                this.f18242a.m24248b(c5021d.m24197b());
                this.f18242a.m24245a(60);
            } else if (this.f18242a.m24249c() == c5021d.m24197b() && this.f18242a.m24247b() == c5021d.m24194a()) {
                this.f18242a.m24252d(60);
            } else {
                m24311b(qVar, this.f18242a);
                this.f18242a = new C5029l();
                this.f18242a.m24246a(c5021d.m24194a());
                this.f18242a.m24248b(c5021d.m24197b());
                this.f18242a.m24245a(60);
            }
        }
    }

    public void m24321a(q qVar, C5020c c5020c) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"updateStatus DataRawSleepData " + c5020c});
        if (this.f18242a == null) {
            this.f18242a = new C5029l();
            this.f18242a.m24246a(c5020c.m24188a());
            this.f18242a.m24248b(c5020c.m24193c());
            this.f18242a.m24245a(60);
        } else if (this.f18242a.m24249c() == c5020c.m24193c() && this.f18242a.m24247b() == c5020c.m24188a()) {
            this.f18242a.m24252d(60);
        } else {
            m24311b(qVar, this.f18242a);
            this.f18242a = new C5029l();
            this.f18242a.m24246a(c5020c.m24188a());
            this.f18242a.m24248b(c5020c.m24193c());
            this.f18242a.m24245a(60);
        }
    }

    public void m24337d(q qVar) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"updateStatus null"});
        if (this.f18242a != null) {
            m24311b(qVar, this.f18242a);
            this.f18242a = null;
        }
    }

    private void m24315d(q qVar, C5021d c5021d) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"appendToExistData sportData ", c5021d});
        if (c5021d.m24199c() != 0 || c5021d.m24203e() != 0 || c5021d.m24201d() != 0) {
            HiDataReadOption hiDataReadOption = new HiDataReadOption();
            hiDataReadOption.setStartTime(c5021d.m24194a() * 1000);
            hiDataReadOption.setEndTime((c5021d.m24194a() + 60) * 1000);
            hiDataReadOption.setDeviceUUID(C4028a.m19823a());
            hiDataReadOption.setType(new int[]{2, 4, 3, 5});
            b.a(BaseApplication.b()).a(hiDataReadOption, new C5043k(this, c5021d));
        }
    }

    public void m24320a(q qVar, C5018a c5018a) {
        int i;
        List c = c5018a.m24176c();
        List b = c5018a.m24174b();
        int f = qVar.f();
        int i2 = qVar.i();
        c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveFitnessFrame time=" + c5018a.m24171a() + " date=" + new Date(((long) c5018a.m24171a()) * 1000)});
        if (c != null) {
            int size = c.size();
            for (i = 0; i < size; i++) {
                C5021d c5021d = (C5021d) c.get(i);
                if (255 != c5021d.m24197b()) {
                    if (f == 0 || 4 == i2) {
                        c.b("Fitness_MgrStorage", new Object[]{"save V0 detail data with SportData.getStartTime() = " + c5021d.m24194a()});
                        if (this.f18247g < c5021d.m24194a()) {
                            m24314c(qVar, c5021d);
                            m24322a(qVar, c5021d);
                            this.f18246f.m24062a(c5021d.m24194a());
                        } else {
                            c.b("Fitness_MgrStorage", new Object[]{"V0 update data time=" + c5021d.m24194a() + " step=" + c5021d.m24199c() + " cal=" + c5021d.m24201d() + " dis=" + c5021d.m24203e()});
                            if (this.f18247g + 600 < c5021d.m24194a()) {
                                c.e("Fitness_MgrStorage", new Object[]{"V0 Sport data time less than ten minutes with last sync time, so drop it."});
                            } else {
                                m24315d(qVar, c5021d);
                            }
                        }
                    } else if (this.f18247g < c5021d.m24194a()) {
                        C5021d b2 = m24309b(qVar, c5021d);
                        m24304a(b2);
                        m24314c(qVar, b2);
                        m24322a(qVar, c5021d);
                    }
                }
            }
        }
        if (b != null) {
            int size2 = b.size();
            for (i = 0; i < size2; i++) {
                m24321a(qVar, (C5020c) b.get(i));
            }
        }
        m24337d(qVar);
    }

    public void m24328a(List<C5027j> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Total:" + list.size());
        int i = 0;
        for (C5027j c5027j : list) {
            stringBuilder.append("[i:");
            stringBuilder.append(i);
            stringBuilder.append("]");
            stringBuilder.append(c5027j);
            i++;
        }
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{stringBuilder.toString()});
    }

    public void m24327a(q qVar, List<C5026i> list, List<C5028k> list2) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveFitnessData in SEPARATED type"});
        this.f18246f = new ba().m24111b(qVar);
        this.f18247g = this.f18246f.m24067d();
        m24334c();
        m24335c(qVar, (List) list);
        m24338d(qVar, (List) list2);
        m24339e(qVar);
    }

    public void m24324a(q qVar, C5026i c5026i) {
        List<C5027j> b = c5026i.m24232b();
        m24328a((List) b);
        for (C5027j c5027j : b) {
            if (this.f18247g < c5027j.m24233a()) {
                m24310b(qVar, c5027j);
            } else if (c5027j.m24240e() == 1) {
                m24305a(qVar, c5027j);
            }
        }
        if (b.size() > 0) {
            long a = ((C5027j) b.get(b.size() - 1)).m24233a();
            if (this.f18246f.m24067d() < a) {
                this.f18246f.m24062a(a);
            }
        }
    }

    public void m24335c(q qVar, List<C5026i> list) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveSampleFrameList enter"});
        Collections.sort(list, new C5045m(this));
        for (C5026i a : list) {
            m24324a(qVar, a);
        }
    }

    public void m24325a(q qVar, C5028k c5028k) {
        List<C5029l> a = c5028k.m24241a();
        for (C5029l c5029l : a) {
            if (c5029l.m24244a() > this.f18248h) {
                m24311b(qVar, c5029l);
            } else if (c5029l.m24251d() == 1) {
                m24306a(qVar, c5029l);
            } else if ((c5029l.m24249c() == 7 || c5029l.m24249c() == 6) && c5029l.m24244a() > this.f18248h - 1800) {
                m24306a(qVar, c5029l);
            }
        }
        if (a.size() > 0) {
            long a2 = ((C5029l) a.get(a.size() - 1)).m24244a();
            if (a2 > this.f18249i) {
                this.f18249i = a2;
            }
        }
    }

    public void m24338d(q qVar, List<C5028k> list) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveStatusFrameList enter"});
        this.f18248h = C5037e.m24296b(qVar);
        this.f18249i = this.f18248h;
        for (C5028k a : list) {
            m24325a(qVar, a);
        }
    }

    void m24334c() {
        this.f18243b = new ArrayList();
        this.f18244c = new ArrayList();
    }

    private int m24308b(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 5;
            case 6:
                return 2018;
            case 7:
                return 2002;
            default:
                C2538c.e("Fitness_MgrStorage", new Object[]{"getHiHealthSessionType unknow type :" + i});
                return 0;
        }
    }

    private void m24305a(q qVar, C5027j c5027j) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"updateSamplePoint sample:", c5027j});
        m24310b(qVar, c5027j);
    }

    private void m24310b(q qVar, C5027j c5027j) {
        if (m24307a(m24308b(c5027j.m24238c()), c5027j.m24239d())) {
            HiHealthData hiHealthData = new HiHealthData(m24308b(c5027j.m24238c()));
            hiHealthData.setTimeInterval(c5027j.m24233a() * 1000, (c5027j.m24233a() + ((long) c5027j.m24236b())) * 1000);
            hiHealthData.setValue(c5027j.m24239d());
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            this.f18243b.add(hiHealthData);
            return;
        }
        C2538c.b("Fitness_MgrStorage", new Object[]{"insertSamplePoint invalid sample:", c5027j});
    }

    private int m24313c(int i) {
        switch (i) {
            case 1:
                return 20002;
            case 2:
                return 20003;
            case 3:
                return 20004;
            case 4:
                return 20005;
            case 6:
                return 22002;
            case 7:
                return 22001;
            case 9:
                return 20007;
            default:
                C2538c.e("Fitness_MgrStorage", new Object[]{"getHiHealthSessionType unknow type :" + i});
                return 0;
        }
    }

    private void m24306a(q qVar, C5029l c5029l) {
        C2538c.b("Fitness_MgrStorage", new Object[]{"updateStatusToHiHealth :" + c5029l});
        m24311b(qVar, c5029l);
    }

    private void m24311b(q qVar, C5029l c5029l) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"statusPoint :" + c5029l});
        for (long a = c5029l.m24244a(); a < c5029l.m24247b(); a += 60) {
            if (m24313c(c5029l.m24249c()) != 0) {
                HiHealthData hiHealthData = new HiHealthData(m24313c(c5029l.m24249c()));
                hiHealthData.setTimeInterval(1000 * a, (60 + a) * 1000);
                hiHealthData.setDeviceUUID(C4028a.m19823a());
                C2538c.b("Fitness_MgrStorage", new Object[]{"saveStatusToHiHealth hiHealthData:" + hiHealthData});
                this.f18244c.add(hiHealthData);
            }
        }
    }

    public void m24336d() {
        q a = q.a(BaseApplication.b());
        new ba().m24110a(a, this.f18246f);
        C5037e.m24294a(a, this.f18249i);
    }

    public void m24316a(int i) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"procSaveDataComplete enter errCode", Integer.valueOf(i)});
        if (i == 0) {
            m24336d();
        }
        q.a(BaseApplication.b()).a(0);
    }

    void m24339e(q qVar) {
        C2538c.a("05", 1, "Fitness_MgrStorage", new Object[]{"saveDataToHiHealth enter dataList.size:" + this.f18243b.size() + " statusList.size:" + this.f18244c.size()});
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        this.f18243b.addAll(this.f18244c);
        C2538c.c("Fitness_MgrStorage", new Object[]{"saveDataToHiHealth enter dataList.size:" + this.f18243b.size()});
        hiDataInsertOption.setDatas(this.f18243b);
        b.a(BaseApplication.b()).a(hiDataInsertOption, new C5046n(this));
    }

    public void m24318a(q qVar, C4383a c4383a) {
        qVar.setSharedPreference(FitnessComm.KEY_LAST_SLEEP_TIME_STAMP, Long.toString(c4383a.m21048a()), null);
        qVar.setSharedPreference(FitnessComm.KEY_LAST_SLEEP_FREQENCY, Integer.toString(c4383a.m21051b()), null);
    }

    public C4383a m24340f(q qVar) {
        int i = 0;
        C4383a c4383a = new C4383a();
        long j = 0;
        try {
            j = Long.parseLong(qVar.getSharedPreference(FitnessComm.KEY_LAST_SLEEP_TIME_STAMP));
            i = Integer.parseInt(qVar.getSharedPreference(FitnessComm.KEY_LAST_SLEEP_FREQENCY));
        } catch (Exception e) {
            C2538c.e("Fitness_MgrStorage", new Object[]{" getLastSleepData"});
        }
        c4383a.m21050a(j);
        c4383a.m21049a(i);
        return c4383a;
    }
}
