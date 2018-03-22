package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.content.Context;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.c.e;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.unite.DelHealthDataReq;
import com.huawei.hwcloudmodel.model.userprofile.DeviceInfo;
import com.huawei.hwcloudmodel.model.userprofile.GetBindDeviceReq;
import com.huawei.hwdatamigrate.hihealth.c.bj;
import com.huawei.hwdatamigrate.hihealth.c.bm;
import com.huawei.hwdatamigrate.hihealth.c.v;
import com.huawei.hwdatamigrate.hihealth.sync.a.g;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: SyncUtil */
public class C1018m {
    public static HiDeviceInfo m3906a(Context context, long j) throws C1004h {
        if (context == null || j == 0) {
            return null;
        }
        GetBindDeviceReq getBindDeviceReq = new GetBindDeviceReq();
        getBindDeviceReq.setDeviceCode(Long.valueOf(j));
        CloudCommonReponse a = a.a(context).a(getBindDeviceReq);
        if (g.a(a, true)) {
            List deviceInfos = a.getDeviceInfos();
            if (deviceInfos == null || deviceInfos.isEmpty()) {
                C2538c.m12680e("HiH_SyncUtil", "getOneBindDevice error,deviceInfos is null or empty ,deviceCode is ", Long.valueOf(j));
                return C1018m.m3905a(j);
            }
            DeviceInfo deviceInfo = (DeviceInfo) deviceInfos.get(0);
            if (deviceInfo == null) {
                C2538c.m12680e("HiH_SyncUtil", "getOneBindDevice error,deviceInfo is null  ,deviceCode is ", Long.valueOf(j));
                return C1018m.m3905a(j);
            }
            HiDeviceInfo hiDeviceInfo = new HiDeviceInfo();
            hiDeviceInfo.setDeviceUniqueCode(deviceInfo.getUniqueId());
            hiDeviceInfo.setDeviceName(deviceInfo.getName());
            hiDeviceInfo.setDeviceType(deviceInfo.getProductId().intValue());
            hiDeviceInfo.setFirmwareVersion(deviceInfo.getFirmwareVersion());
            hiDeviceInfo.setHardwareVersion(deviceInfo.getHardwareVersion());
            hiDeviceInfo.setSoftwareVersion(deviceInfo.getSoftwareVersion());
            return hiDeviceInfo;
        }
        C2538c.m12680e("HiH_SyncUtil", "getOneBindDevice error,no device get from cloud ,deviceCode is ", Long.valueOf(j));
        return C1018m.m3905a(j);
    }

    public static long m3904a(long j, int i) {
        return j - (86400000 * ((long) i));
    }

    public static int m3903a(Context context) {
        if (context == null) {
            return 0;
        }
        return com.huawei.hwdatamigrate.hihealth.i.a.a(context.getPackageName());
    }

    public static boolean m3909a(Context context, int i, int i2, long j) {
        if (bm.a(context).b(i, j, i2) != null) {
            return false;
        }
        C2538c.m12677c("HiH_SyncUtil", "checkFirstSyncByType no such data in db ,type is ", Integer.valueOf(i2), " deviceCode is ", Long.valueOf(j));
        return true;
    }

    public static boolean m3910a(Context context, String[] strArr) throws C1004h {
        DelHealthDataReq delHealthDataReq = new DelHealthDataReq();
        delHealthDataReq.setRecordIds(strArr);
        return g.a(a.a(context).a(delHealthDataReq), false);
    }

    private static HiDeviceInfo m3905a(long j) {
        HiDeviceInfo hiDeviceInfo = new HiDeviceInfo();
        hiDeviceInfo.setDeviceUniqueCode(Long.toString(j));
        hiDeviceInfo.setDeviceName("UNKNOWN");
        hiDeviceInfo.setDeviceType(32);
        hiDeviceInfo.setFirmwareVersion("UNKNOWN");
        hiDeviceInfo.setHardwareVersion("UNKNOWN");
        hiDeviceInfo.setSoftwareVersion("UNKNOWN");
        return hiDeviceInfo;
    }

    public static List<HiHealthData> m3907a(Context context, int i, int[] iArr, String[] strArr, int i2, int i3) {
        List a = v.a(context).a(i, iArr);
        if (a == null || a.isEmpty()) {
            C2538c.m12679d("HiH_SyncUtil", "getUploadStat no syncDays get !", " types is ", e.a(iArr));
            return null;
        }
        List<HiHealthData> a2 = bj.a(context).a(i, i2, iArr, strArr, a, i3);
        if (a2 == null || a2.isEmpty()) {
            C2538c.m12679d("HiH_SyncUtil", "getUploadStat no stat get !", " types is ", e.a(iArr));
            return null;
        }
        C2538c.m12677c("HiH_SyncUtil", "getUploadStat syncDays is ", a);
        return a2;
    }

    public static void m3908a(Context context, List<HiHealthData> list, int[] iArr, int i) {
        for (HiHealthData hiHealthData : list) {
            for (int a : iArr) {
                v.a(context).a(i, hiHealthData.getStartTime(), a);
            }
        }
    }
}
