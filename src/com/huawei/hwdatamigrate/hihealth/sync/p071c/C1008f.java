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
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.SportTotalData;
import com.huawei.hwcloudmodel.model.unite.AddSportTotalReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDimenStatReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDimenStatRsp;
import com.huawei.hwdatamigrate.hihealth.c.bm;
import com.huawei.hwdatamigrate.hihealth.c.g;
import com.huawei.hwdatamigrate.hihealth.sync.b.k;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1016h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1018m;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiSyncDimenSportStat */
public class C1008f implements C1006d {
    private a f1711a;
    private Context f1712b;
    private HiSyncOption f1713c;
    private int f1714d;
    private int f1715e = 0;
    private g f1716f;
    private bm f1717g;
    private int f1718h;
    private k f1719i;
    private int f1720j = 0;

    public C1008f(@NonNull Context context, @NonNull HiSyncOption hiSyncOption, int i, int i2) {
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "HiSyncSportStat create");
        this.f1712b = context.getApplicationContext();
        this.f1713c = hiSyncOption;
        this.f1714d = i;
        m3740c();
    }

    private GetSportDimenStatRsp m3731a(GetSportDimenStatReq getSportDimenStatReq) {
        return this.f1711a.a(getSportDimenStatReq);
    }

    private void m3733a(SparseArray<Integer> sparseArray) throws C1004h {
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "downloadAllStatByTimeSync downloadDaysMap : ", sparseArray);
        if (sparseArray == null || sparseArray.size() <= 0) {
            C2538c.m12679d("Debug_HiSyncDimenSportStat", "downloadAllStatByTimeSync() downloadDaysMap is null,stop pullStat");
            return;
        }
        m3741c(sparseArray);
    }

    private void m3734a(SparseArray<Integer> sparseArray, boolean z) throws C1004h {
        if (z) {
            C2538c.m12677c("Debug_HiSyncDimenSportStat", "downloadAllStat too much need to download ,start a thread ! downloadDaysMap is ", sparseArray);
            m3738b((SparseArray) sparseArray);
            return;
        }
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "downloadAllStat do not need to start a thread ! downloadDaysMap is ", sparseArray);
        m3733a((SparseArray) sparseArray);
    }

    private void m3738b(SparseArray<Integer> sparseArray) {
        if (sparseArray == null || sparseArray.size() <= 0) {
            C2538c.m12679d("Debug_HiSyncDimenSportStat", "downloadAllStatByTime() downloadDaysMap is null,stop pullDataByVersion");
            return;
        }
        new Thread(new com.huawei.hwdatamigrate.hihealth.sync.c.g(this, sparseArray)).start();
    }

    private void m3740c() {
        this.f1711a = a.a(this.f1712b);
        this.f1719i = new k(this.f1712b);
        this.f1716f = g.a(this.f1712b);
        this.f1717g = bm.a(this.f1712b);
        this.f1718h = b.a(System.currentTimeMillis());
    }

    private void m3741c(SparseArray<Integer> sparseArray) throws C1004h {
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            int keyAt = sparseArray.keyAt(size);
            m3732a(keyAt, ((Integer) sparseArray.get(keyAt)).intValue());
        }
    }

    private void m3732a(int i, int i2) throws C1004h {
        if (i > i2 || i <= 0) {
            C2538c.m12679d("Debug_HiSyncDimenSportStat", "downloadOneStatByTime the .. time is not right");
            return;
        }
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "downloadOneStatByTime startTime is ", Integer.valueOf(i), " , endTime is ", Integer.valueOf(i2));
        GetSportDimenStatReq getSportDimenStatReq = new GetSportDimenStatReq();
        getSportDimenStatReq.setStartTime(Integer.valueOf(i));
        getSportDimenStatReq.setEndTime(Integer.valueOf(i2));
        CloudCommonReponse a = m3731a(getSportDimenStatReq);
        if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(a, false)) {
            List sportStat = a.getSportStat();
            this.f1717g.a(this.f1714d, this.f1713c.getSyncDataType(), i2, 0);
            if (sportStat == null || sportStat.isEmpty()) {
                C2538c.m12679d("Debug_HiSyncDimenSportStat", "downloadOneStatByTime stringListMap is null or empty");
                return;
            }
            m3737a(sportStat);
        }
    }

    private void m3737a(List<SportTotalData> list) {
        for (SportTotalData sportTotalData : this.f1719i.c(list)) {
            if (sportTotalData != null) {
                m3735a(sportTotalData);
            }
        }
    }

    private void m3735a(SportTotalData sportTotalData) {
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "saveStatToDB cloudDimenTotalStat is ", e.a(sportTotalData));
        List a = this.f1719i.a(sportTotalData, this.f1714d);
        if (a != null && !a.isEmpty()) {
            com.huawei.hwdatamigrate.hihealth.h.a.a(this.f1712b).a(a);
        }
    }

    private boolean m3739b(List<HiHealthData> list) throws C1004h {
        int i = this.f1720j + 1;
        this.f1720j = i;
        C1017i.m3899a(i, this.f1713c.getSyncAction());
        List a = this.f1719i.a(list);
        if (a.isEmpty()) {
            this.f1715e++;
            C2538c.m12679d("Debug_HiSyncDimenSportStat", "addDimenSportStat sportTotals is null or empty");
            return false;
        }
        AddSportTotalReq addSportTotalReq = new AddSportTotalReq();
        addSportTotalReq.setTotalInfo(a);
        addSportTotalReq.setTimeZone(((HiHealthData) list.get(0)).getTimeZone());
        while (this.f1715e < 2) {
            if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(this.f1711a.a(addSportTotalReq), false)) {
                C2538c.m12677c("Debug_HiSyncDimenSportStat", "addDimenSportStat success ! uploadCount is ,", Integer.valueOf(this.f1720j), ",stat is ", e.a(a));
                return true;
            }
            this.f1715e++;
        }
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "addDimenSportStat failed ! uploadCount is ", Integer.valueOf(this.f1720j));
        return false;
    }

    public void m3743a(int i) throws C1004h {
        while (this.f1715e < 2) {
            List a = C1018m.m3907a(this.f1712b, i, c.a(), com.huawei.hihealth.data.a.a.a(), 50, 0);
            if (a == null || a.isEmpty()) {
                break;
            } else if (m3739b(a)) {
                C1018m.m3908a(this.f1712b, a, c.a(), i);
            }
        }
        this.f1715e = 0;
    }

    public void mo2311a() throws C1004h {
        SparseArray a;
        boolean z;
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "pullDataByVersion() begin !");
        long a2 = b.a(this.f1718h);
        if (C1017i.m3901a()) {
            C2538c.m12677c("Debug_HiSyncDimenSportStat", "pullDataByVersion() first sync pull all stat");
            a = C1017i.m3896a(1388509200000L, a2, 90);
            z = true;
        } else {
            C2538c.m12677c("Debug_HiSyncDimenSportStat", "pullDataByVersion() only pullDataByVersion recent stat");
            a = C1017i.m3896a(a2 - 864000000, a2, 90);
            z = false;
        }
        m3734a(a, z);
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "pullDataByVersion() end !");
    }

    public void mo2313b() throws C1004h {
        C2538c.m12677c("Debug_HiSyncDimenSportStat", "pushData() begin !");
        if (C1015e.m3862b()) {
            C1016h.m3888a(10.0d, "SYNC_SPORT_STAT_DOWNLOAD_PERCENT_MAX");
            int a = this.f1716f.a(this.f1714d);
            if (a <= 0) {
                C2538c.m12679d("Debug_HiSyncDimenSportStat", "pushData() no statClient get, maybe no data need to pushData");
            } else {
                m3743a(a);
            }
            C1016h.m3889a(this.f1712b);
            C2538c.m12677c("Debug_HiSyncDimenSportStat", "pushData() end !");
            return;
        }
        C2538c.m12679d("Debug_HiSyncDimenSportStat", "pushData() dataPrivacy switch is closed ,can not pushData right now ,push end !");
    }

    public void mo2312a(long j, long j2) throws C1004h {
        m3738b(C1017i.m3896a(j, j2, 90));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncSportStat{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
