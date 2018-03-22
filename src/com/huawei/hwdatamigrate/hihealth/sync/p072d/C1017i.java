package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.content.Context;
import android.util.SparseArray;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.unite.GetSyncVersionsReq;
import com.huawei.hwcloudmodel.model.unite.SyncKey;
import com.huawei.hwdatamigrate.hihealth.sync.a.g;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.p190v.C2538c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* compiled from: HiSyncUtil */
public class C1017i {
    private static boolean f1819a = false;

    public static boolean m3901a() {
        return f1819a;
    }

    public static void m3900a(boolean z) {
        f1819a = z;
    }

    public static List<SyncKey> m3897a(Context context, int i, int i2) throws C1004h {
        if (context == null) {
            return null;
        }
        SyncKey syncKey = new SyncKey();
        syncKey.setDataType(Integer.valueOf(i));
        syncKey.setType(Integer.valueOf(i2));
        List arrayList = new ArrayList();
        arrayList.add(syncKey);
        GetSyncVersionsReq getSyncVersionsReq = new GetSyncVersionsReq();
        getSyncVersionsReq.setSyncKeys(arrayList);
        CloudCommonReponse a = a.a(context).a(getSyncVersionsReq);
        C2538c.m12677c("HiH_HiSyncUtil", "getVersionByType rsp is ", a);
        g.a(a, true);
        if (a != null) {
            return a.getVersions();
        }
        return null;
    }

    public static List<SyncKey> m3902b(Context context, int i, int i2) {
        if (context == null) {
            return null;
        }
        SyncKey syncKey = new SyncKey();
        syncKey.setDataType(Integer.valueOf(i));
        syncKey.setType(Integer.valueOf(i2));
        syncKey.setVersion(Long.valueOf(System.currentTimeMillis()));
        syncKey.setDeviceCode(Long.valueOf(0));
        List<SyncKey> arrayList = new ArrayList();
        arrayList.add(syncKey);
        return arrayList;
    }

    public static SparseArray<Integer> m3896a(long j, long j2, int i) {
        if (j > j2 || j < 1388509200000L || i < 1) {
            C2538c.m12679d("HiH_HiSyncUtil", "divideDate error input startTime is ", Long.valueOf(j), " , endTime is ", Long.valueOf(j2), " , range is ", Integer.valueOf(i));
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance2.setTimeInMillis(j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SparseArray<Integer> sparseArray = new SparseArray();
        while (true) {
            Integer valueOf = Integer.valueOf(Integer.parseInt(simpleDateFormat.format(instance.getTime())));
            instance.add(5, i);
            if (instance.before(instance2)) {
                try {
                    Integer valueOf2 = Integer.valueOf(Integer.parseInt(simpleDateFormat.format(instance.getTime())));
                    instance.add(5, 1);
                    sparseArray.put(valueOf.intValue(), valueOf2);
                } catch (Exception e) {
                    C2538c.m12680e("HiH_HiSyncUtil", "divideDate date change error is ", e.getMessage());
                    return null;
                }
            }
            instance.add(5, -i);
            sparseArray.put(valueOf.intValue(), Integer.valueOf(Integer.parseInt(simpleDateFormat.format(instance2.getTime()))));
            return sparseArray;
        }
    }

    public static List<SyncKey> m3898a(Context context, int i, List<Integer> list) throws C1004h {
        if (context == null || list == null || list.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Integer num : list) {
            SyncKey syncKey = new SyncKey();
            syncKey.setDataType(Integer.valueOf(i));
            syncKey.setType(num);
            arrayList.add(syncKey);
        }
        GetSyncVersionsReq getSyncVersionsReq = new GetSyncVersionsReq();
        getSyncVersionsReq.setSyncKeys(arrayList);
        CloudCommonReponse a = a.a(context).a(getSyncVersionsReq);
        C2538c.m12677c("HiH_HiSyncUtil", "getVersionByType Rsp is ", a);
        g.a(a, true);
        return a.getVersions();
    }

    public static void m3899a(int i, int i2) throws C1004h {
        if (i >= 200) {
            C2538c.m12680e("HiH_HiSyncUtil", "uploadCountMaxCheck too much upload count is ", Integer.valueOf(i));
            throw new C1004h("SYNC_EX: UPLOAD_TOO_MUCH ");
        }
    }
}
