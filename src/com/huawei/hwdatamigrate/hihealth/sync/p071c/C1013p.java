package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.unite.AddMotionPathReq;
import com.huawei.hwcloudmodel.model.unite.GetMotionPathByVersionReq;
import com.huawei.hwcloudmodel.model.unite.GetMotionPathByVersionRsp;
import com.huawei.hwcloudmodel.model.unite.MotionPathDetail;
import com.huawei.hwcloudmodel.model.unite.SyncKey;
import com.huawei.hwdatamigrate.hihealth.b.b.b;
import com.huawei.hwdatamigrate.hihealth.c.bm;
import com.huawei.hwdatamigrate.hihealth.c.g;
import com.huawei.hwdatamigrate.hihealth.c.p;
import com.huawei.hwdatamigrate.hihealth.d.l;
import com.huawei.hwdatamigrate.hihealth.p066a.C1001a;
import com.huawei.hwdatamigrate.hihealth.p069e.C1003a;
import com.huawei.hwdatamigrate.hihealth.sync.b.f;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1016h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiSyncTrack */
public class C1013p implements C1006d {
    private Context f1785a;
    private HiSyncOption f1786b;
    private int f1787c;
    private int f1788d = 0;
    private long f1789e;
    private long f1790f;
    private double f1791g;
    private double f1792h;
    private a f1793i;
    private p f1794j;
    private g f1795k;
    private bm f1796l;
    private f f1797m;
    private com.huawei.hwdatamigrate.hihealth.h.a f1798n;
    private int f1799o;
    private List<SyncKey> f1800p;
    private int f1801q = 0;

    public C1013p(@NonNull Context context, @NonNull HiSyncOption hiSyncOption, int i, int i2) {
        C2538c.m12677c("HiH_HiSyncTrack", "HiSyncTrack create");
        this.f1785a = context.getApplicationContext();
        this.f1786b = hiSyncOption;
        this.f1787c = i;
        this.f1799o = hiSyncOption.getSyncModel();
        m3833c();
    }

    private void m3833c() {
        this.f1793i = a.a(this.f1785a);
        this.f1797m = new f(this.f1785a);
        this.f1795k = g.a(this.f1785a);
        this.f1796l = bm.a(this.f1785a);
        this.f1798n = com.huawei.hwdatamigrate.hihealth.h.a.a(this.f1785a);
        this.f1794j = p.a(this.f1785a);
    }

    private GetMotionPathByVersionRsp m3825a(GetMotionPathByVersionReq getMotionPathByVersionReq) {
        return this.f1793i.a(getMotionPathByVersionReq);
    }

    private void m3834d() throws C1004h {
        m3828a((SyncKey) this.f1800p.get(0));
    }

    private void m3828a(SyncKey syncKey) throws C1004h {
        C2538c.m12674b("HiH_HiSyncTrack", "downloadOneByVersion key = ", syncKey);
        if (syncKey == null || syncKey.getType().intValue() != 2) {
            C2538c.m12679d("HiH_HiSyncTrack", "downloadOneByVersion the key is not right");
            return;
        }
        long longValue = syncKey.getDeviceCode().longValue();
        long longValue2 = syncKey.getVersion().longValue();
        if (longValue2 <= 0) {
            C2538c.m12679d("HiH_HiSyncTrack", "downloadOneByVersion the maxVersion is not right , maxVersion is ", Long.valueOf(longValue2));
            return;
        }
        b b = this.f1796l.b(this.f1787c, longValue, this.f1786b.getSyncDataType());
        GetMotionPathByVersionReq getMotionPathByVersionReq = new GetMotionPathByVersionReq();
        getMotionPathByVersionReq.setDataType(Integer.valueOf(this.f1786b.getSyncMethod()));
        getMotionPathByVersionReq.setDeviceCode(Long.valueOf(longValue));
        getMotionPathByVersionReq.setCondition("all");
        if (b == null) {
            getMotionPathByVersionReq.setVersion(0);
            m3827a(getMotionPathByVersionReq, longValue2);
        } else if (b.c() < longValue2) {
            getMotionPathByVersionReq.setVersion(Long.valueOf(b.c()));
            m3827a(getMotionPathByVersionReq, longValue2);
        } else {
            C2538c.m12677c("HiH_HiSyncTrack", "do not need pullDataByVersion data,DBversion is ", Long.valueOf(b.c()));
        }
    }

    private void m3827a(GetMotionPathByVersionReq getMotionPathByVersionReq, long j) throws C1004h {
        this.f1792h = 15.0d;
        C2538c.m12677c("HiH_HiSyncTrack", "performDownloadByVersion req = ", getMotionPathByVersionReq, " maxVersion = ", Long.valueOf(j));
        this.f1789e = getMotionPathByVersionReq.getVersion().longValue();
        if (this.f1789e <= 0) {
            this.f1789e = 0;
        }
        this.f1790f = this.f1789e;
        int i = 0;
        while (true) {
            long b = m3831b(getMotionPathByVersionReq, j);
            C2538c.m12677c("HiH_HiSyncTrack", "performDownloadByVersion downCurrentVersion = ", Long.valueOf(b), " maxVersion = ", Long.valueOf(j));
            i++;
            if (b > -1) {
                if (!this.f1796l.a(this.f1787c, this.f1786b.getSyncDataType(), b, getMotionPathByVersionReq.getDeviceCode().longValue())) {
                    C2538c.m12679d("HiH_HiSyncTrack", "performDownloadByVersion saveVersionToDB failed ");
                }
                getMotionPathByVersionReq.setVersion(Long.valueOf(b));
                if (i >= 20) {
                    C2538c.m12679d("HiH_HiSyncTrack", "performDownloadByVersion pullDataByVersion too many times.");
                    return;
                } else if (this.f1799o != 3 && b >= j) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private long m3831b(GetMotionPathByVersionReq getMotionPathByVersionReq, long j) throws C1004h {
        CloudCommonReponse a = m3825a(getMotionPathByVersionReq);
        if (!com.huawei.hwdatamigrate.hihealth.sync.a.g.a(a, false)) {
            return -1;
        }
        List<MotionPathDetail> detailInfos = a.getDetailInfos();
        if (detailInfos == null || detailInfos.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncTrack", "downloadTrack cloudTracks is null or empty");
            return -1;
        }
        long j2;
        if (a.getCurrentVersion() == null) {
            j2 = Long.MIN_VALUE;
            long j3 = Long.MAX_VALUE;
            for (MotionPathDetail motionPathDetail : detailInfos) {
                if (motionPathDetail != null) {
                    long longValue = motionPathDetail.getVersion().longValue();
                    if (longValue >= j2) {
                        j2 = longValue;
                    }
                    if (longValue >= j3) {
                        longValue = j3;
                    }
                    j3 = longValue;
                }
            }
            C2538c.m12677c("HiH_HiSyncTrack", "downloadTrack maxTempVersion is ", Long.valueOf(j2), " minTempVersion is ", Long.valueOf(j3));
        } else {
            j2 = a.getCurrentVersion().longValue();
        }
        if (j2 <= this.f1790f) {
            C2538c.m12679d("HiH_HiSyncTrack", "downloadTrack downloadVersion <= currentVersion , downloadVersion is ", Long.valueOf(j2), " currentVersion is ", Long.valueOf(this.f1790f));
            return -1;
        }
        this.f1791g = ((double) (j2 - this.f1790f)) / ((double) (j - this.f1789e));
        this.f1790f = j2;
        m3830a((List) detailInfos, true);
        return j2;
    }

    private void m3830a(@NonNull List<MotionPathDetail> list, boolean z) throws C1004h {
        long currentTimeMillis = System.currentTimeMillis();
        List<HiHealthData> a = this.f1797m.a(list, this.f1787c, this.f1799o);
        if (a != null && !a.isEmpty()) {
            C2538c.m12677c("HiH_HiSyncTrack", "saveData cloudTracks is ", Integer.valueOf(a.size()));
            try {
                com.huawei.hwdatamigrate.hihealth.b.a.a.a(this.f1785a).a();
                List a2 = l.a(this.f1785a).a(this.f1787c);
                if (a2 == null || a2.isEmpty()) {
                    C2538c.m12680e("HiH_HiSyncTrack", "saveData() null == clients ||clients.isEmpty ()");
                    return;
                }
                int size = a.size();
                for (HiHealthData a3 : a) {
                    this.f1798n.a(a3, this.f1787c, a2);
                    C1016h.m3890a(this.f1785a, WeightedLatLng.DEFAULT_INTENSITY / ((double) size), this.f1791g, this.f1792h);
                }
                com.huawei.hwdatamigrate.hihealth.b.a.a.a(this.f1785a).b();
                C2538c.m12677c("HiH_HiSyncTrack", "saveData end saveDetailTime =  ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (z) {
                    this.f1798n.c(a);
                    this.f1798n.b();
                    return;
                }
                this.f1798n.b(a);
                this.f1798n.a();
            } catch (Exception e) {
                C2538c.m12679d("HiH_HiSyncTrack", "saveData e is ", e.getMessage());
            } finally {
                com.huawei.hwdatamigrate.hihealth.b.a.a.a(this.f1785a).b();
            }
        }
    }

    private void m3829a(List<HiHealthData> list) {
        if (list != null && !list.isEmpty()) {
            for (HiHealthData hiHealthData : list) {
                long dataID = hiHealthData.getDataID();
                long j = hiHealthData.getLong("modified_time");
                C2538c.m12677c("HiH_HiSyncTrack", "uploadTrackDone modifiedTime is ", Long.valueOf(j), " sequenceID is ", Long.valueOf(dataID));
                if (this.f1794j.a(dataID, j)) {
                    this.f1794j.b(dataID, j);
                }
            }
        }
    }

    private boolean m3832b(List<HiHealthData> list) throws C1004h {
        int i = this.f1801q + 1;
        this.f1801q = i;
        C1017i.m3899a(i, this.f1786b.getSyncAction());
        List a = this.f1797m.a(list, this.f1799o);
        if (a == null || a.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncTrack", "uploadTrackDataOnce cloudTrack is null or empty ");
            return false;
        }
        AddMotionPathReq addMotionPathReq = new AddMotionPathReq();
        addMotionPathReq.setDetailInfo(a);
        addMotionPathReq.setTimeZone(((HiHealthData) list.get(0)).getTimeZone());
        while (this.f1788d < 2) {
            if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(this.f1793i.a(addMotionPathReq), false)) {
                C2538c.m12677c("HiH_HiSyncTrack", "uploadTrackDataOnce OK ! uploadCount is ", Integer.valueOf(this.f1801q));
                return true;
            }
            this.f1788d++;
        }
        C2538c.m12677c("HiH_HiSyncTrack", "uploadTrackDataOnce failed ! uploadCount is ", Integer.valueOf(this.f1801q));
        return false;
    }

    private void m3826a(int i) throws C1004h {
        while (this.f1788d < 2) {
            List a = this.f1794j.a(i, PayStatusCodes.PAY_STATE_PARAM_ERROR, 0, 10);
            if (a != null && !a.isEmpty()) {
                if (!m3832b(a)) {
                    C2538c.m12679d("HiH_HiSyncTrack", "uploadTrack failed , clientId is ", Integer.valueOf(i));
                    break;
                }
                m3829a(a);
                if (a.size() < 10) {
                    C2538c.m12677c("HiH_HiSyncTrack", "uploadTrack the size is smaller than HiSyncUtil.UPLOAD_TRACK_DATA_MAX, size is", Integer.valueOf(a.size()));
                    break;
                }
            }
            break;
        }
        this.f1788d = 0;
    }

    public void mo2311a() throws C1004h {
        C2538c.m12677c("HiH_HiSyncTrack", "downLoad() begin !");
        C1016h.m3888a(18.0d, "SYNC_TRACK_DOWNLOAD_PERCENT_MAX_ALL");
        if (this.f1799o == 3) {
            C2538c.m12677c("HiH_HiSyncTrack", "downLoad 3.0 model");
            this.f1800p = C1017i.m3902b(this.f1785a, this.f1786b.getSyncMethod(), this.f1786b.getSyncDataType());
        } else if (this.f1799o == 2) {
            C2538c.m12677c("HiH_HiSyncTrack", "downLoad 2.0 model");
            this.f1800p = C1017i.m3897a(this.f1785a, this.f1786b.getSyncMethod(), this.f1786b.getSyncDataType());
        }
        if (this.f1800p == null || this.f1800p.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncTrack", "pullDataByVersion() end ! versions is null,stop pullDataByVersion");
        } else {
            m3834d();
        }
        C1016h.m3889a(this.f1785a);
        C1001a.m3640a(this.f1785a, 2);
        C1003a.m3690a().m3692a(4, "HiSyncTrack", null);
        C2538c.m12677c("HiH_HiSyncTrack", "pullDataByVersion() end !");
    }

    public void mo2312a(long j, long j2) throws C1004h {
    }

    public void mo2313b() throws C1004h {
        C2538c.m12677c("HiH_HiSyncTrack", "pushData() begin !");
        if (C1015e.m3862b()) {
            C1016h.m3888a(5.0d, "SYNC_TRACK_UPLOAD_PERCENT_MAX");
            List<Integer> d = this.f1795k.d(this.f1787c);
            if (d == null || d.isEmpty()) {
                C2538c.m12679d("HiH_HiSyncTrack", "pushData() no client get, maybe no data need to pushData");
            } else {
                for (Integer num : d) {
                    C1016h.m3890a(this.f1785a, WeightedLatLng.DEFAULT_INTENSITY, WeightedLatLng.DEFAULT_INTENSITY / ((double) d.size()), 5.0d);
                    m3826a(num.intValue());
                }
            }
            C1016h.m3889a(this.f1785a);
            C2538c.m12677c("HiH_HiSyncTrack", "pushData() end !");
            return;
        }
        C2538c.m12679d("HiH_HiSyncTrack", "pushData() dataPrivacy switch is closed ,can not pushData right now ,push end !");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncTrack{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
