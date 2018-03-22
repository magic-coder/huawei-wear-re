package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.c.b;
import com.huawei.hihealth.c.e;
import com.huawei.hihealth.data.c.c;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.unite.AddHealthStatReq;
import com.huawei.hwcloudmodel.model.unite.AddSleepStatReq;
import com.huawei.hwdatamigrate.hihealth.c.bm;
import com.huawei.hwdatamigrate.hihealth.c.g;
import com.huawei.hwdatamigrate.hihealth.sync.b.h;
import com.huawei.hwdatamigrate.hihealth.sync.c.k;
import com.huawei.hwdatamigrate.hihealth.sync.c.l;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1018m;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiSyncSleepStat */
public class C1010i implements C1006d {
    private a f1736a;
    private Context f1737b;
    private HiSyncOption f1738c;
    private int f1739d;
    private int f1740e = 0;
    private bm f1741f;
    private h f1742g;
    private com.huawei.hwdatamigrate.hihealth.sync.b.a f1743h;
    private g f1744i;
    private l f1745j;
    private int f1746k;
    private int f1747l = 0;
    private final int[] f1748m = new int[]{44001, 44002, 44003, 44005, 44004, 44006, 44007};
    private final String[] f1749n = new String[]{"stat_sleep_deep_duration", "stat_sleep_shallow_duration", "stat_sleep_wake_duration", "stat_sleep_wake_count", "stat_sleep_duration_sum", "stat_sleep_start_time", "stat_sleep_end_time"};

    public C1010i(@NonNull Context context, @NonNull HiSyncOption hiSyncOption, int i, int i2) {
        C2538c.m12677c("Debug_HiSyncSleepStat", "HiSyncSleepStat create");
        this.f1737b = context.getApplicationContext();
        this.f1738c = hiSyncOption;
        this.f1739d = i;
        m3780c();
    }

    private void m3780c() {
        this.f1736a = a.a(this.f1737b);
        this.f1741f = bm.a(this.f1737b);
        this.f1746k = b.a(System.currentTimeMillis());
        this.f1742g = new h(this.f1737b);
        this.f1743h = new com.huawei.hwdatamigrate.hihealth.sync.b.a(this.f1737b);
        this.f1744i = g.a(this.f1737b);
        this.f1745j = new l(this.f1737b, this.f1738c, this.f1739d);
    }

    private void m3774a(SparseArray<Integer> sparseArray, boolean z) throws C1004h {
        if (z) {
            C2538c.m12677c("Debug_HiSyncSleepStat", "downloadAllStat too much need to download ,start a thread ! downloadDaysMap is ", sparseArray);
            m3778b((SparseArray) sparseArray);
            return;
        }
        C2538c.m12677c("Debug_HiSyncSleepStat", "downloadAllStat do not need to start a thread ! downloadDaysMap is ", sparseArray);
        m3773a((SparseArray) sparseArray);
    }

    private void m3773a(SparseArray<Integer> sparseArray) throws C1004h {
        C2538c.m12677c("Debug_HiSyncSleepStat", "downloadAllStatByTimeSync downloadDaysMap is ", sparseArray);
        if (sparseArray == null || sparseArray.size() <= 0) {
            C2538c.m12679d("Debug_HiSyncSleepStat", "downloadAllStatByTimeSync() downloadDaysMap is null,stop pullStat");
            return;
        }
        m3781c(sparseArray);
    }

    private void m3778b(SparseArray<Integer> sparseArray) {
        if (sparseArray == null || sparseArray.size() <= 0) {
            C2538c.m12679d("Debug_HiSyncSleepStat", "downloadAllStatByTime() downloadDaysMap is null,stop pullDataByVersion");
            return;
        }
        new Thread(new k(this, sparseArray, null)).start();
    }

    private void m3781c(SparseArray<Integer> sparseArray) throws C1004h {
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            int keyAt = sparseArray.keyAt(size);
            this.f1745j.a(keyAt, ((Integer) sparseArray.get(keyAt)).intValue(), this.f1741f, this.f1742g);
        }
    }

    private boolean m3776a(List<HiHealthData> list) throws C1004h {
        int i = this.f1747l + 1;
        this.f1747l = i;
        C1017i.m3899a(i, this.f1738c.getSyncAction());
        List a = this.f1742g.a(list);
        if (a.isEmpty()) {
            this.f1740e++;
            return false;
        }
        AddSleepStatReq addSleepStatReq = new AddSleepStatReq();
        addSleepStatReq.setSleepTotal(a);
        addSleepStatReq.setTimeZone(((HiHealthData) list.get(0)).getTimeZone());
        while (this.f1740e < 2) {
            if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(this.f1736a.a(addSleepStatReq), false)) {
                C2538c.m12677c("Debug_HiSyncSleepStat", "addSleepStat success ! uploadCount is ,", Integer.valueOf(this.f1747l), ",stat is ", e.a(a));
                return true;
            }
            this.f1740e++;
        }
        C2538c.m12677c("Debug_HiSyncSleepStat", "addSleepStat failed ! uploadCount is ,", Integer.valueOf(this.f1747l), ",stat is ", e.a(a));
        return false;
    }

    private void m3772a(int i) throws C1004h {
        while (this.f1740e < 2) {
            List a = C1018m.m3907a(this.f1737b, i, this.f1748m, this.f1749n, 50, 0);
            if (a == null || a.isEmpty()) {
                break;
            } else if (m3776a(a)) {
                C1018m.m3908a(this.f1737b, a, this.f1748m, i);
            }
        }
        this.f1740e = 0;
    }

    private void m3777b(int i) throws C1004h {
        while (this.f1740e < 2) {
            List a = C1018m.m3907a(this.f1737b, i, c.b(), com.huawei.hihealth.data.a.a.b(), 50, 0);
            if (a == null || a.isEmpty()) {
                break;
            } else if (m3779b(a)) {
                C1018m.m3908a(this.f1737b, a, c.b(), i);
            }
        }
        this.f1740e = 0;
    }

    private boolean m3779b(List<HiHealthData> list) throws C1004h {
        int i = this.f1747l + 1;
        this.f1747l = i;
        C1017i.m3899a(i, this.f1738c.getSyncAction());
        List a = this.f1743h.a(list);
        if (a.isEmpty()) {
            this.f1740e++;
            return false;
        }
        AddHealthStatReq addHealthStatReq = new AddHealthStatReq();
        addHealthStatReq.setProfessionalSleepTotal(a);
        addHealthStatReq.setTimeZone(((HiHealthData) list.get(0)).getTimeZone());
        while (this.f1740e < 2) {
            if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(this.f1736a.a(addHealthStatReq), false)) {
                C2538c.m12677c("Debug_HiSyncSleepStat", "addCoreSleepStat success ! uploadCount is ,", Integer.valueOf(this.f1747l), ",stat is ", e.a(a));
                return true;
            }
            this.f1740e++;
        }
        C2538c.m12677c("Debug_HiSyncSleepStat", "addCoreSleepStat failed ! uploadCount is ,", Integer.valueOf(this.f1747l), ",stat is ", e.a(a));
        return false;
    }

    public void mo2311a() throws C1004h {
        SparseArray a;
        boolean z;
        C2538c.m12677c("Debug_HiSyncSleepStat", "Enter pullDataByVersion() begin !");
        long a2 = b.a(this.f1746k);
        if (C1017i.m3901a()) {
            C2538c.m12677c("Debug_HiSyncSleepStat", "pullDataByVersion first sync pull all stat");
            a = C1017i.m3896a(1388509200000L, a2, 90);
            z = true;
        } else {
            C2538c.m12677c("Debug_HiSyncSleepStat", "pullDataByVersion only pullDataByVersion recent stat");
            a = C1017i.m3896a(a2 - 864000000, a2, 90);
            z = false;
        }
        m3774a(a, z);
        C2538c.m12677c("Debug_HiSyncSleepStat", "pullDataByVersion end !");
    }

    public void mo2313b() throws C1004h {
        C2538c.m12677c("Debug_HiSyncSleepStat", "pushData() begin !");
        if (C1015e.m3862b()) {
            int a = this.f1744i.a(this.f1739d);
            if (a <= 0) {
                C2538c.m12679d("Debug_HiSyncSleepStat", "pushData() no statClient get, maybe no data need to push ,push end !");
            } else {
                m3772a(a);
                m3777b(a);
            }
            C2538c.m12677c("Debug_HiSyncSleepStat", "pushData() end !");
            return;
        }
        C2538c.m12679d("Debug_HiSyncSleepStat", "pushData() dataPrivacy switch is closed ,can not pushData right now ,push end !");
    }

    public void mo2312a(long j, long j2) throws C1004h {
        m3774a(C1017i.m3896a(j, j2, 90), false);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncSleepStat{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
