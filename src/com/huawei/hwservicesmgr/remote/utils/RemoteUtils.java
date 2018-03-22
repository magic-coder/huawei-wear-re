package com.huawei.hwservicesmgr.remote.utils;

import com.google.gson.Gson;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.remote.RemoteServiceMgr;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class RemoteUtils {
    public static final String TAG = RemoteUtils.class.getSimpleName();

    public static Map<String, Object> generateRetMap(Object obj, String str) {
        Map<String, Object> hashMap = new HashMap();
        Gson gson = new Gson();
        if (obj != null) {
            if ((obj instanceof String) || (obj instanceof JSONArray)) {
                hashMap.put("value", obj.toString());
            } else {
                hashMap.put("value", gson.toJson(obj));
            }
        }
        if (!hashMap.containsKey("code")) {
            hashMap.put("code", "100000");
        }
        hashMap.put(RemoteServiceMgr.FUNC_NAME, str);
        C2538c.c("RemoteUtils", new Object[]{gson.toJson(hashMap)});
        return hashMap;
    }

    public static DeviceInfo getCurrentDeviceInfo(C1023c cVar) {
        if (cVar == null) {
            return null;
        }
        List<DeviceInfo> a = cVar.a();
        if (a.size() != 0) {
            C2538c.c(TAG, new Object[]{"getCurrentDeviceInfo() deviceInfoList.size() = " + a.size()});
            for (DeviceInfo deviceInfo : a) {
                if (1 == deviceInfo.getDeviceActiveState()) {
                    return deviceInfo;
                }
            }
            C2538c.e(TAG, new Object[]{"getCurrentDeviceInfo() deviceInfo's ActiveState not DeviceActiveState.DEVICE_ACTIVE_ENABLE"});
            return null;
        }
        C2538c.e(TAG, new Object[]{"getCurrentDeviceInfo() deviceInfoList is null"});
        return null;
    }

    public static int getTrackTypeByClassification(C1023c cVar) {
        int i = 6;
        C2538c.c(TAG, new Object[]{"getTrackTypeByClassification() enter"});
        if (cVar != null) {
            int d = cVar.d();
            C2538c.c(TAG, new Object[]{"getTrackTypeByClassification() deviceClassification:" + d});
            switch (d) {
                case 1:
                    i = 4;
                    break;
                case 2:
                    i = 5;
                    break;
            }
        }
        C2538c.c(TAG, new Object[]{"getTrackTypeByClassification() trackType = " + i});
        return i;
    }
}
