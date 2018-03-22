package com.huawei.hwfitnessmgr;

import android.os.RemoteException;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import com.huawei.al.C4028a;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.a.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwdatamigrate.C4794a;
import com.huawei.hwdatamigrate.p407a.C4769b;
import com.huawei.hwdatamigrate.p407a.ai;
import com.huawei.hwdatamigrate.p407a.aj;
import com.huawei.hwdatamigrate.p407a.am;
import com.huawei.hwdatamigrate.p407a.an;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwservicesmgr.a.q;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: FitnessDataMigration */
public class C5011b {
    private static C5011b f18179g;
    private static int f18180h = 0;
    C4794a f18181a = C4794a.m22935a(BaseApplication.b());
    ai f18182b = null;
    am f18183c = null;
    List<HiHealthData> f18184d;
    IBaseResponseCallback f18185e = null;
    IBaseResponseCallback f18186f = null;
    private Semaphore f18187i = new Semaphore(1);
    private String f18188j = "";

    private C5011b() {
        C2538c.c("FitnessDataMigration", new Object[]{"FitnessDataMigration Constructor"});
        this.f18181a = C4794a.m22935a(BaseApplication.b());
    }

    public static C5011b m24079a() {
        C2538c.c("FitnessDataMigration", new Object[]{"getInstance() context"});
        if (f18179g == null) {
            f18179g = new C5011b();
            f18180h = 0;
        }
        return f18179g;
    }

    public void m24099a(q qVar) {
        C2538c.c("FitnessDataMigration", new Object[]{"activityReminderDataMigrate "});
        C4769b f = C4794a.m22935a(BaseApplication.b()).m22944f(BaseApplication.b());
        if (f != null) {
            ActivityReminder activityReminder = new ActivityReminder();
            activityReminder.setEnabled(f.f17536g);
            new C5010a().m24075a(qVar, 0, activityReminder);
        }
    }

    void m24102b() {
        this.f18184d = new ArrayList();
    }

    private long m24078a(String str, int i) {
        long j = 0;
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(str).getTime() + (((long) (i * 60)) * 1000);
        } catch (ParseException e) {
            C2538c.c("FitnessDataMigration", new Object[]{"e.getMessage() = " + e.getMessage()});
            return j;
        }
    }

    private int m24077a(String str) {
        if (str.equals("00:11:22:33:AF:50")) {
            return 0;
        }
        com.huawei.n.c a = com.huawei.n.c.a(BaseApplication.b());
        if (a != null) {
            try {
                int a2;
                List<DeviceInfo> a3 = a.a();
                C2538c.c("FitnessDataMigration", new Object[]{"getDeviceTypeIdByMac deviceList:", a3});
                if (a3 != null) {
                    for (DeviceInfo deviceInfo : a3) {
                        if (str.equals(deviceInfo.getDeviceIdentify())) {
                            a2 = C4028a.m19822a(deviceInfo.getProductType());
                            break;
                        }
                    }
                }
                a2 = 0;
                return a2;
            } catch (RemoteException e) {
                C2538c.e("FitnessDataMigration", new Object[]{"getDeviceTypeIdByMac() error = " + e.getMessage()});
                q.a(BaseApplication.b());
                return 0;
            } catch (Exception e2) {
                C2538c.e("FitnessDataMigration", new Object[]{"getDeviceTypeIdByMac getUsedDeviceList error:", e2.getMessage()});
                return 0;
            }
        }
        C2538c.e("FitnessDataMigration", new Object[]{"getDeviceTypeIdByMac mHWDeviceConfigManager is null"});
        return 0;
    }

    private void m24088b(String str) {
        C2538c.c("FitnessDataMigration", new Object[]{"registerDeviceToHiHealth enter mac", str});
        if (!this.f18188j.equals(str)) {
            this.f18188j = str;
            HiDeviceInfo hiDeviceInfo = new HiDeviceInfo();
            hiDeviceInfo.setDeviceUniqueCode(str + "#ANDROID21");
            int a = m24077a(str);
            if (a != 0) {
                hiDeviceInfo.setDeviceType(a);
            } else {
                hiDeviceInfo.setDeviceType(1);
            }
            List arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(0));
            C2538c.c("FitnessDataMigration", new Object[]{"registerDeviceToHiHealth mac:", hiDeviceInfo.getDeviceUniqueCode(), " type=", Integer.valueOf(hiDeviceInfo.getDeviceType())});
            b.a(BaseApplication.b()).a(hiDeviceInfo, arrayList, new C5012c(this));
        }
    }

    private boolean m24085a(int i, int i2) {
        if (i == 2) {
            if (i2 > 0 && i2 < 500) {
                return true;
            }
        } else if (i == 4) {
            if (i2 > 0 && i2 < SupportMenu.USER_MASK) {
                return true;
            }
        } else if (i2 > 0) {
            return true;
        }
        return false;
    }

    private void m24082a(int i, long j, String str, String str2, String str3, String str4, String str5, int i2) {
        int parseInt;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        try {
            i3 = Integer.parseInt(str);
            i5 = (int) (Double.valueOf(str3).doubleValue() * 1000.0d);
            i4 = Integer.parseInt(str2);
            parseInt = Integer.parseInt(str4);
        } catch (Exception e) {
            C2538c.c("FitnessDataMigration", new Object[]{" saveSportData Exception:", e.getMessage()});
            parseInt = 0;
        }
        if (j != 0) {
            if (i3 > 0 || i4 > 0 || i5 > 0) {
                HiHealthData hiHealthData;
                if (m24085a(2, i3)) {
                    HiHealthData hiHealthData2 = new HiHealthData(2);
                    hiHealthData2.setTimeInterval(j, FileWatchdog.DEFAULT_DELAY + j);
                    hiHealthData2.setValue(i3);
                    hiHealthData2.setDeviceUUID(str5);
                    if (2 == i2 || 3 == i2) {
                        hiHealthData2.setSyncStatus(1);
                    }
                    this.f18184d.add(hiHealthData2);
                }
                if (m24085a(4, i5)) {
                    HiHealthData hiHealthData3 = new HiHealthData(4);
                    hiHealthData3.setTimeInterval(j, FileWatchdog.DEFAULT_DELAY + j);
                    hiHealthData3.setValue(i5);
                    hiHealthData3.setDeviceUUID(str5);
                    if (2 == i2 || 3 == i2) {
                        hiHealthData3.setSyncStatus(1);
                    }
                    this.f18184d.add(hiHealthData3);
                }
                if (m24085a(3, i4)) {
                    hiHealthData = new HiHealthData(3);
                    hiHealthData.setValue(i4);
                    hiHealthData.setTimeInterval(j, FileWatchdog.DEFAULT_DELAY + j);
                    hiHealthData.setDeviceUUID(str5);
                    if (2 == i2 || 3 == i2) {
                        hiHealthData.setSyncStatus(1);
                    }
                    this.f18184d.add(hiHealthData);
                }
                if (m24085a(5, parseInt)) {
                    hiHealthData = new HiHealthData(5);
                    hiHealthData.setValue(parseInt);
                    hiHealthData.setTimeInterval(j, FileWatchdog.DEFAULT_DELAY + j);
                    hiHealthData.setDeviceUUID(str5);
                    if (2 == i2 || 3 == i2) {
                        hiHealthData.setSyncStatus(1);
                    }
                    this.f18184d.add(hiHealthData);
                }
                HiHealthData hiHealthData4 = new HiHealthData(i);
                hiHealthData4.setTimeInterval(j, FileWatchdog.DEFAULT_DELAY + j);
                hiHealthData4.setDeviceUUID(str5);
                if (2 == i2 || 3 == i2) {
                    hiHealthData4.setSyncStatus(1);
                }
                this.f18184d.add(hiHealthData4);
            }
        }
    }

    private boolean m24086a(String[] strArr, int i) {
        if (strArr == null || strArr.length <= i) {
            return false;
        }
        return true;
    }

    private boolean m24089b(String[] strArr, int i) {
        if (strArr == null || strArr.length <= i || strArr[i].equals("-1") || strArr[i].equals("0") || strArr[i].equals("")) {
            return false;
        }
        return true;
    }

    private void m24084a(an anVar) {
        String str;
        C2538c.c("FitnessDataMigration", new Object[]{"saveSportTableData data=", anVar.m22814a()});
        int i = anVar.f17468N;
        C2538c.c("FitnessDataMigration", new Object[]{"saveSportTableData downloadState=", Integer.valueOf(i)});
        String str2 = anVar.f17467M;
        if (str2 == null || str2.equals("")) {
            str = "00:11:22:33:AF:50";
        } else {
            str = str2;
        }
        String str3 = anVar.f17466L;
        String[] c = m24091c(anVar.a);
        String[] c2 = m24091c(anVar.b);
        String[] c3 = m24091c(anVar.c);
        String[] c4 = m24091c(anVar.d);
        String[] c5 = m24091c(anVar.e);
        String[] c6 = m24091c(anVar.f);
        String[] c7 = m24091c(anVar.i);
        String[] c8 = m24091c(anVar.j);
        String[] c9 = m24091c(anVar.k);
        String[] c10 = m24091c(anVar.l);
        m24088b(str);
        int i2 = 0;
        while (i2 < 1440) {
            if (m24089b(c, i2) && m24086a(c2, i2) && m24086a(c3, i2)) {
                m24082a(20002, m24078a(str3, i2), c[i2], c2[i2], c3[i2], "0", str + "#ANDROID21", i);
            } else if (m24089b(c4, i2) && m24086a(c5, i2) && m24086a(c6, i2)) {
                m24082a(20003, m24078a(str3, i2), c4[i2], c5[i2], c6[i2], "0", str + "#ANDROID21", i);
            } else if (m24089b(c7, i2)) {
                m24082a(20005, m24078a(str3, i2), "0", "0", c7[i2], "0", str + "#ANDROID21", i);
            } else if (m24089b(c8, i2) && m24086a(c9, i2) && m24086a(c10, i2)) {
                m24082a(20004, m24078a(str3, i2), c8[i2], "0", c10[i2], c9[i2], str + "#ANDROID21", i);
            }
            i2++;
        }
    }

    private String[] m24091c(String str) {
        if (str == null) {
            return null;
        }
        return str.split(",");
    }

    private void m24090c() {
        C2538c.c("FitnessDataMigration", new Object[]{"saveDataToHiHealth enter dataList.size:" + this.f18184d.size()});
        C2538c.c("FitnessDataMigration", new Object[]{"need acquire mSemaphore"});
        try {
            this.f18187i.acquire();
        } catch (InterruptedException e) {
            C2538c.e("FitnessDataMigration", new Object[]{"fetch lock get failed"});
        }
        C2538c.c("FitnessDataMigration", new Object[]{"acquire mSemaphore success"});
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        hiDataInsertOption.setDatas(this.f18184d);
        b.a(BaseApplication.b()).a(hiDataInsertOption, new C5013d(this));
    }

    public void m24101a(ArrayList<an> arrayList) {
        C2538c.c("FitnessDataMigration", new Object[]{"sportDataDataMigrate "});
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            an anVar = (an) it.next();
            m24102b();
            m24084a(anVar);
            m24090c();
        }
    }

    private long m24087b(String str, int i) {
        long a = m24078a(str, i);
        if (a > 0) {
            return a - 14400000;
        }
        return a;
    }

    private void m24083a(aj ajVar) {
        C2538c.c("FitnessDataMigration", new Object[]{"saveSleepTable data=", ajVar.m22803a()});
        String str = ajVar.f17414l;
        String str2 = ajVar.f17413k;
        int i = ajVar.f17415m;
        C2538c.c("FitnessDataMigration", new Object[]{"saveSleepTable downloadState=", Integer.valueOf(i)});
        if (str == null || str.equals("")) {
            str = "00:11:22:33:AF:50";
        }
        String[] strArr = null;
        if (ajVar.g != null) {
            strArr = ajVar.g.split(",");
        }
        m24088b(str);
        int i2 = 0;
        while (i2 < 1440) {
            if (strArr != null && strArr.length > i2) {
                int i3;
                if (strArr[i2].equals(HwAccountConstants.TYPE_TWITTER)) {
                    i3 = 22002;
                } else if (strArr[i2].equals("5")) {
                    i3 = 22001;
                } else if (strArr[i2].equals("60")) {
                    i3 = 22003;
                } else {
                    i3 = 0;
                }
                long b = m24087b(str2, i2);
                if (i3 != 0 && b > 0) {
                    HiHealthData hiHealthData = new HiHealthData(i3);
                    hiHealthData.setTimeInterval(b, FileWatchdog.DEFAULT_DELAY + b);
                    hiHealthData.setDeviceUUID(str);
                    if (2 == i || 3 == i) {
                        hiHealthData.setSyncStatus(1);
                    }
                    this.f18184d.add(hiHealthData);
                }
            }
            i2++;
        }
    }

    public void m24103b(ArrayList<aj> arrayList) {
        C2538c.c("FitnessDataMigration", new Object[]{"sleepDataDataMigrate size=", Integer.valueOf(arrayList.size())});
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aj ajVar = (aj) it.next();
            m24102b();
            m24083a(ajVar);
            m24090c();
        }
    }

    private ArrayList<aj> m24092d() {
        if (this.f18182b != null) {
            return this.f18182b.m22801c();
        }
        C2538c.e("FitnessDataMigration", new Object[]{"getVer15SleepData mSleepDatasDB is null "});
        return null;
    }

    private ArrayList<an> m24094e() {
        if (this.f18183c != null) {
            return this.f18183c.m22812c();
        }
        C2538c.e("FitnessDataMigration", new Object[]{"getVer15SportData mSportDatasDB is null "});
        return null;
    }

    private void m24095f() {
        C2538c.c("FitnessDataMigration", new Object[]{"migrateFitnessData "});
        if (this.f18181a == null) {
            C2538c.e("FitnessDataMigration", new Object[]{"migrateFitnessData mHWMigrateDataMgr is null "});
            m24096g();
            m24097h();
            return;
        }
        ArrayList e = m24094e();
        while (e != null && e.size() > 0) {
            m24101a(e);
            e = m24094e();
        }
        e = m24092d();
        while (e != null && e.size() > 0) {
            m24103b(e);
            e = m24092d();
        }
    }

    private String m24080a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    private void m24093d(String str) {
        C2538c.c("FitnessDataMigration", new Object[]{"initMigration "});
        f18180h++;
        String str2 = "";
        if (i.a(57)) {
            str2 = m24080a(System.currentTimeMillis() - LightCloudConstants.LightCloud_INTERVAL_TIME);
        } else {
            str2 = m24080a(System.currentTimeMillis() - 126144000000L);
        }
        this.f18182b = new ai(BaseApplication.b());
        this.f18183c = new am(BaseApplication.b());
        if (TextUtils.isEmpty(str)) {
            this.f18182b.m22799a(this.f18181a.m22946h(BaseApplication.b()), str2);
            this.f18183c.m22810a(this.f18181a.m22946h(BaseApplication.b()), str2);
            return;
        }
        this.f18182b.m22799a(str, str2);
        this.f18183c.m22810a(str, str2);
    }

    private void m24096g() {
        C2538c.c("FitnessDataMigration", new Object[]{"finishMigration"});
        f18180h--;
        if (f18180h <= 0) {
            this.f18182b.m22802d();
            this.f18183c.m22813d();
        }
        this.f18185e.onResponse(0, null);
    }

    private void m24097h() {
        C2538c.c("FitnessDataMigration", new Object[]{"finishMigrationByhuid"});
        f18180h--;
        if (f18180h <= 0) {
            this.f18182b.m22802d();
            this.f18183c.m22813d();
        }
        this.f18186f.onResponse(0, null);
    }

    public void m24098a(IBaseResponseCallback iBaseResponseCallback) {
        this.f18185e = iBaseResponseCallback;
        C2538c.c("FitnessDataMigration", new Object[]{"fitnessDataDataMigrate "});
        m24093d(null);
        m24095f();
        m24096g();
    }

    public void m24100a(String str, IBaseResponseCallback iBaseResponseCallback) {
        this.f18186f = iBaseResponseCallback;
        C2538c.c("FitnessDataMigration", new Object[]{"fitnessDataDataMigrateByhuid "});
        m24093d(str);
        m24095f();
        m24097h();
    }
}
