package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.unite.AddSportDataReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByTimeReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByTimeRsp;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByVersionReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByVersionRsp;
import com.huawei.hwcloudmodel.model.unite.SportDetail;
import com.huawei.hwcloudmodel.model.unite.SyncKey;
import com.huawei.hwdatamigrate.hihealth.b.b.b;
import com.huawei.hwdatamigrate.hihealth.c.ah;
import com.huawei.hwdatamigrate.hihealth.c.bj;
import com.huawei.hwdatamigrate.hihealth.c.bm;
import com.huawei.hwdatamigrate.hihealth.c.g;
import com.huawei.hwdatamigrate.hihealth.c.m;
import com.huawei.hwdatamigrate.hihealth.c.s;
import com.huawei.hwdatamigrate.hihealth.sync.b.i;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1016h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HiSyncSport */
public class C1011m implements C1006d {
    private a f1750a;
    private bj f1751b;
    private Context f1752c;
    private HiSyncOption f1753d;
    private int f1754e;
    private int f1755f = 0;
    private g f1756g;
    private bm f1757h;
    private i f1758i;
    private s f1759j;
    private m f1760k;
    private ah f1761l;
    private long f1762m;
    private long f1763n;
    private double f1764o;
    private double f1765p;
    private double f1766q;
    private int f1767r;
    private com.huawei.hwdatamigrate.hihealth.h.a f1768s;
    private List<SyncKey> f1769t;
    private SparseArray<Integer> f1770u;
    private HiDataReadOption f1771v;
    private int f1772w = 0;

    public C1011m(@NonNull Context context, @NonNull HiSyncOption hiSyncOption, int i, int i2) {
        C2538c.m12677c("HiH_HiSyncSport", "HiSyncSport create");
        this.f1752c = context.getApplicationContext();
        this.f1753d = hiSyncOption;
        this.f1754e = i;
        this.f1767r = hiSyncOption.getSyncModel();
        m3802c();
    }

    private void m3802c() {
        this.f1750a = a.a(this.f1752c);
        this.f1758i = new i(this.f1752c);
        this.f1751b = bj.a(this.f1752c);
        this.f1756g = g.a(this.f1752c);
        this.f1757h = bm.a(this.f1752c);
        this.f1759j = s.a(this.f1752c);
        this.f1760k = m.a(this.f1752c);
        this.f1761l = ah.a(this.f1752c);
        this.f1768s = com.huawei.hwdatamigrate.hihealth.h.a.a(this.f1752c);
        this.f1771v = m3804e();
    }

    private GetSportDataByVersionRsp m3786a(GetSportDataByVersionReq getSportDataByVersionReq) {
        return this.f1750a.a(getSportDataByVersionReq);
    }

    private void m3803d() throws C1004h {
        C2538c.m12677c("HiH_HiSyncSport", "downloadByVersion");
        for (SyncKey a : this.f1769t) {
            m3791a(a);
        }
    }

    private void m3791a(SyncKey syncKey) throws C1004h {
        C2538c.m12677c("HiH_HiSyncSport", "downloadByKey key = ", syncKey);
        if (syncKey == null || syncKey.getType().intValue() != 1) {
            C2538c.m12679d("HiH_HiSyncSport", "downloadByKey the key is not right");
            return;
        }
        long longValue = syncKey.getDeviceCode().longValue();
        long longValue2 = syncKey.getVersion().longValue();
        if (longValue2 <= 0) {
            C2538c.m12679d("HiH_HiSyncSport", "downloadByKey the maxVersion is not right , wrong key is ", syncKey);
            return;
        }
        GetSportDataByVersionReq getSportDataByVersionReq = new GetSportDataByVersionReq();
        getSportDataByVersionReq.setDataType(Integer.valueOf(this.f1753d.getSyncMethod()));
        getSportDataByVersionReq.setDeviceCode(Long.valueOf(longValue));
        b b = this.f1757h.b(this.f1754e, longValue, 1);
        if (b == null) {
            getSportDataByVersionReq.setVersion(0);
            m3790a(getSportDataByVersionReq, longValue2);
        } else if (b.c() < longValue2) {
            getSportDataByVersionReq.setVersion(Long.valueOf(b.c()));
            m3790a(getSportDataByVersionReq, longValue2);
        } else {
            C2538c.m12677c("HiH_HiSyncSport", "do not need download data,DB version is ", Long.valueOf(b.c()), ", max version is ", Long.valueOf(longValue2));
        }
    }

    private void m3799b(long j, long j2) throws C1004h {
        C2538c.m12677c("HiH_HiSyncSport", "performDownloadByTime startTime is ", Long.valueOf(j), " endTime is ", Long.valueOf(j2));
        this.f1770u = C1017i.m3896a(j, j2, 9);
        C2538c.m12677c("HiH_HiSyncSport", "performDownloadByTime downloadDaysMap is ", this.f1770u);
        if (this.f1770u == null) {
            C2538c.m12679d("HiH_HiSyncSport", "performDownloadByTime downloadDaysMap is null");
            return;
        }
        int size = this.f1770u.size();
        if (size <= 0) {
            C2538c.m12679d("HiH_HiSyncSport", "performDownloadByTime downloadDaysMap size is wrong, size is ", Integer.valueOf(size));
            return;
        }
        this.f1764o = WeightedLatLng.DEFAULT_INTENSITY / ((double) size);
        for (int i = size - 1; i >= 0; i--) {
            int keyAt = this.f1770u.keyAt(i);
            m3793a(m3787a(keyAt, ((Integer) this.f1770u.get(keyAt)).intValue()));
        }
    }

    private Map<String, List<SportDetail>> m3787a(int i, int i2) throws C1004h {
        C2538c.m12677c("HiH_HiSyncSport", "downloadOneByTime startDay is ", Integer.valueOf(i), " endDay is ", Integer.valueOf(i2));
        if (i > i2) {
            return null;
        }
        CloudCommonReponse a = m3785a(i, i2, 1, this.f1753d.getSyncMethod());
        if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(a, false)) {
            return a.getData();
        }
        C2538c.m12679d("HiH_HiSyncSport", "downloadOneByTime warning");
        return null;
    }

    private void m3793a(Map<String, List<SportDetail>> map) throws C1004h {
        if (map == null || map.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncSport", "downloadOneByTime stringListMap is null or empty");
            return;
        }
        m3795a((Map) map, true);
        this.f1768s.b();
    }

    private GetSportDataByTimeRsp m3785a(int i, int i2, int i3, int i4) {
        GetSportDataByTimeReq getSportDataByTimeReq = new GetSportDataByTimeReq();
        getSportDataByTimeReq.setQueryType(Integer.valueOf(i3));
        getSportDataByTimeReq.setDataType(Integer.valueOf(i4));
        getSportDataByTimeReq.setStartTime(Long.valueOf((long) i));
        getSportDataByTimeReq.setEndTime(Long.valueOf((long) i2));
        return this.f1750a.a(getSportDataByTimeReq);
    }

    private void m3790a(GetSportDataByVersionReq getSportDataByVersionReq, long j) throws C1004h {
        C2538c.m12677c("HiH_HiSyncSport", "performDownloadByVersion GetSportDataByVersionReq = ", getSportDataByVersionReq, " maxVersion = ", Long.valueOf(j));
        this.f1762m = getSportDataByVersionReq.getVersion().longValue();
        if (this.f1762m <= 0) {
            this.f1762m = 0;
        }
        this.f1763n = this.f1762m;
        int i = 0;
        while (true) {
            long b = m3796b(getSportDataByVersionReq, j);
            C2538c.m12677c("HiH_HiSyncSport", "performDownloadByVersion downCurrentVersion = ", Long.valueOf(b), " maxVersion = ", Long.valueOf(j));
            i++;
            if (b > -1) {
                if (!this.f1757h.a(this.f1754e, 1, b, getSportDataByVersionReq.getDeviceCode().longValue())) {
                    C2538c.m12679d("HiH_HiSyncSport", "performDownloadByVersion saveVersionToDB failed ");
                }
                getSportDataByVersionReq.setVersion(Long.valueOf(b));
                if (i >= 20) {
                    C2538c.m12679d("HiH_HiSyncSport", "performDownloadByVersion pullDataByVersion too many times.");
                    return;
                } else if (this.f1767r != 3 && b >= j) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private long m3796b(GetSportDataByVersionReq getSportDataByVersionReq, long j) throws C1004h {
        boolean z = false;
        GetSportDataByVersionRsp a = m3786a(getSportDataByVersionReq);
        if (!com.huawei.hwdatamigrate.hihealth.sync.a.g.a(a, z)) {
            return -1;
        }
        Map a2 = m3788a(a);
        if (a2 == null || a2.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncSport", "downloadByVersionOnce stringListMap is null or empty");
            return -1;
        }
        long b;
        if (a.getCurrentVersion() == null) {
            b = m3797b(a2);
        } else {
            b = a.getCurrentVersion().longValue();
        }
        if (b <= this.f1763n) {
            C2538c.m12679d("HiH_HiSyncSport", "downloadByVersionOnce downloadVersion is ", Long.valueOf(b), " smaller than currentVersion ", Long.valueOf(this.f1763n));
            return -1;
        }
        this.f1764o = ((double) (b - this.f1763n)) / ((double) (j - this.f1762m));
        this.f1763n = b;
        if (C1017i.m3901a()) {
            try {
                com.huawei.hwdatamigrate.hihealth.b.a.a.a(this.f1752c).a();
                C2538c.m12677c("HiH_HiSyncSport", "downloadByVersionOnce first sync ,save data to temp ,downloadVersion is ", Long.valueOf(b));
                z = m3795a(a2, false);
            } catch (Exception e) {
                C2538c.m12679d("HiH_HiSyncSport", "downloadByVersionOnce() e = ", e.getMessage());
            } finally {
                com.huawei.hwdatamigrate.hihealth.b.a.a.a(this.f1752c).b();
            }
        } else {
            z = m3795a(a2, true);
        }
        if (z) {
            return b;
        }
        return -1;
    }

    private Map<String, List<SportDetail>> m3788a(GetSportDataByVersionRsp getSportDataByVersionRsp) {
        if (this.f1767r != 3) {
            return getSportDataByVersionRsp.getData();
        }
        Map<String, List<SportDetail>> hashMap = new HashMap();
        List detailInfos = getSportDataByVersionRsp.getDetailInfos();
        if (detailInfos == null || detailInfos.isEmpty()) {
            return null;
        }
        hashMap.put("one", detailInfos);
        return hashMap;
    }

    private long m3797b(Map<String, List<SportDetail>> map) {
        long j = Long.MIN_VALUE;
        long j2 = Long.MAX_VALUE;
        for (List<SportDetail> list : map.values()) {
            if (!(list == null || list.isEmpty())) {
                for (SportDetail version : list) {
                    long longValue = version.getVersion().longValue();
                    if (longValue >= j) {
                        j = longValue;
                    }
                    if (longValue < j2) {
                        j2 = longValue;
                    }
                }
            }
        }
        return j;
    }

    private boolean m3795a(@NonNull Map<String, List<SportDetail>> map, boolean z) throws C1004h {
        double size = (double) map.size();
        for (List list : map.values()) {
            C1016h.m3890a(this.f1752c, WeightedLatLng.DEFAULT_INTENSITY / size, this.f1764o, this.f1766q);
            List list2;
            if (!(list2 == null || list2.isEmpty())) {
                list2 = this.f1758i.a(list2, this.f1754e, this.f1767r);
                if (!(list2 == null || list2.isEmpty())) {
                    if (!C1017i.m3901a() || z) {
                        this.f1768s.a(list2, this.f1754e);
                        if (z) {
                            this.f1768s.c(list2);
                            this.f1768s.b();
                        } else {
                            this.f1768s.b(list2);
                        }
                    } else {
                        C1005a.m3720a(this.f1752c, list2, 1, this.f1754e);
                    }
                }
            }
        }
        return true;
    }

    private void m3792a(List<HiHealthData> list) {
        if (list != null && !list.isEmpty()) {
            for (HiHealthData hiHealthData : list) {
                if (this.f1759j.a(hiHealthData.getDataID(), hiHealthData.getLong("modified_time"), 1) > 0) {
                    long startTime = hiHealthData.getStartTime();
                    long endTime = hiHealthData.getEndTime();
                    int clientID = hiHealthData.getClientID();
                    this.f1760k.a(clientID, startTime, endTime, 2, 1);
                    this.f1760k.a(clientID, startTime, endTime, 4, 1);
                    this.f1760k.a(clientID, startTime, endTime, 3, 1);
                    this.f1760k.a(clientID, startTime, endTime, 5, 1);
                }
            }
        }
    }

    private void m3800b(List<HiHealthData> list) {
        if (list != null && !list.isEmpty()) {
            for (HiHealthData hiHealthData : list) {
                this.f1761l.a(hiHealthData.getDataID(), hiHealthData.getLong("modified_time"), 1);
            }
        }
    }

    private boolean m3794a(List<HiHealthData> list, int i) throws C1004h {
        int i2 = this.f1772w + 1;
        this.f1772w = i2;
        C1017i.m3899a(i2, this.f1753d.getSyncAction());
        List b = this.f1758i.b(list, i, this.f1767r);
        if (b == null || b.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncSport", "addDataToCloud sportDetails is null or empty dataType is ", Integer.valueOf(i));
            return false;
        }
        AddSportDataReq addSportDataReq = new AddSportDataReq();
        addSportDataReq.setDetailInfo(b);
        addSportDataReq.setTimeZone(((HiHealthData) list.get(0)).getTimeZone());
        while (this.f1755f < 2) {
            if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(this.f1750a.a(addSportDataReq), false)) {
                C2538c.m12677c("HiH_HiSyncSport", "addDataToCloud OK ! uploadCount is ", Integer.valueOf(this.f1772w), " dataType is ", Integer.valueOf(i));
                C2538c.m12677c("HiH_", "addDataToCloud OK ! uploadCount is ", Integer.valueOf(this.f1772w), " dataType is ", Integer.valueOf(i));
                return true;
            }
            this.f1755f++;
        }
        C2538c.m12677c("HiH_HiSyncSport", "addDataToCloud failed ! uploadCount is ", Integer.valueOf(this.f1772w), " dataType is ", Integer.valueOf(i));
        C2538c.m12677c("HiH_", "addDataToCloud failed ! uploadCount is ", Integer.valueOf(this.f1772w), " dataType is ", Integer.valueOf(i));
        return false;
    }

    private void m3789a(int i) throws C1004h {
        while (this.f1755f < 2) {
            List a = this.f1751b.a(i, this.f1771v, 60);
            if (a != null && !a.isEmpty()) {
                if (!m3794a(a, 1)) {
                    C2538c.m12679d("HiH_HiSyncSport", "uploadSportData upload failed，clientId is ", Integer.valueOf(i));
                    break;
                }
                m3792a(a);
                if (a.size() < 60) {
                    C2538c.m12677c("HiH_HiSyncSport", "uploadSportData the size is smaller than HiSyncUtil.UPLOAD_SPORT_DATA_MAX, size is", Integer.valueOf(a.size()));
                    break;
                }
            }
            break;
        }
        this.f1755f = 0;
    }

    private void m3798b(int i) throws C1004h {
        while (this.f1755f < 2) {
            List c = m3801c(i);
            if (c != null && !c.isEmpty()) {
                if (!m3794a(c, 3)) {
                    C2538c.m12679d("HiH_HiSyncSport", "uploadSleepData upload failed，clientId is ", Integer.valueOf(i));
                    break;
                }
                m3800b(c);
                if (c.size() < 60) {
                    C2538c.m12677c("HiH_HiSyncSport", "uploadSleepData the size is smaller than HiSyncUtil.UPLOAD_SPORT_DATA_MAX, size is", Integer.valueOf(c.size()));
                    break;
                }
            }
            break;
        }
        this.f1755f = 0;
    }

    private List<HiHealthData> m3801c(int i) {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(22001));
        arrayList.add(Integer.valueOf(22002));
        arrayList.add(Integer.valueOf(22003));
        return this.f1761l.a(i, arrayList, 60);
    }

    private HiDataReadOption m3804e() {
        HiDataReadOption hiDataReadOption = new HiDataReadOption();
        int[] iArr = new int[]{2, 4, 3, 5};
        hiDataReadOption.setConstantsKey(new String[]{"step", "calorie", "distance", "altitude_offset"});
        hiDataReadOption.setType(iArr);
        hiDataReadOption.setAlignType(20001);
        return hiDataReadOption;
    }

    public void m3807a(double d) {
        this.f1766q = d;
    }

    private void m3805f() throws C1004h {
        if (this.f1767r == 3) {
            C2538c.m12677c("HiH_HiSyncSport", "pullDataByVersion 3.0 model");
            this.f1769t = C1017i.m3902b(this.f1752c, this.f1753d.getSyncMethod(), this.f1753d.getSyncDataType());
        } else if (this.f1767r == 2) {
            C2538c.m12677c("HiH_HiSyncSport", "pullDataByVersion 2.0 model");
            this.f1769t = C1017i.m3897a(this.f1752c, this.f1753d.getSyncMethod(), this.f1753d.getSyncDataType());
        }
        C2538c.m12677c("HiH_HiSyncSport", "pullDataByVersion() syncKeys is ", this.f1769t);
    }

    public void mo2311a() throws C1004h {
        C2538c.m12677c("HiH_HiSyncSport", "pullDataByVersion() begin !");
        this.f1766q = 22.0d;
        C1016h.m3888a(this.f1766q, "SYNC_SPORT_DOWNLOAD_PERCENT_MAX_ALL");
        m3805f();
        if (this.f1769t == null || this.f1769t.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncSport", "pullDataByVersion() syncKeys is null,stop pullDataByVersion");
            return;
        }
        m3803d();
        C1016h.m3889a(this.f1752c);
        C2538c.m12677c("HiH_HiSyncSport", "pullDataByVersion() end !");
    }

    public void mo2313b() throws C1004h {
        C2538c.m12677c("HiH_HiSyncSport", "pushData() begin !");
        if (C1015e.m3862b()) {
            C1016h.m3888a(10.0d, "SYNC_SPORT_UPLOAD_PERCENT_MAX");
            List<Integer> d = this.f1756g.d(this.f1754e);
            if (d == null || d.isEmpty()) {
                C2538c.m12679d("HiH_HiSyncSport", "pushData() no client get, maybe no data need to pushData");
            } else {
                this.f1765p = WeightedLatLng.DEFAULT_INTENSITY / ((double) d.size());
                for (Integer num : d) {
                    m3789a(num.intValue());
                    m3798b(num.intValue());
                    C1016h.m3890a(this.f1752c, WeightedLatLng.DEFAULT_INTENSITY, this.f1765p, 10.0d);
                }
            }
            C1016h.m3889a(this.f1752c);
            C2538c.m12677c("HiH_HiSyncSport", "pushData() end !");
            return;
        }
        C2538c.m12679d("HiH_HiSyncSport", "pushData() dataPrivacy switch is closed ,can not pushData right now ,push end !");
    }

    public void mo2312a(long j, long j2) throws C1004h {
        C1016h.m3888a(this.f1766q, "SYNC_SPORT_DOWNLOAD_PERCENT_BY_TIME");
        m3799b(j, j2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncSport{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
