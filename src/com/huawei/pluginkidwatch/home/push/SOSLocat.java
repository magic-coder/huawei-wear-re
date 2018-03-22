package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatus;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.home.p151a.C1618a;
import com.huawei.pluginkidwatch.home.push.bean.LocationDataBean;

public class SOSLocat implements IPushProcess {
    private static final int CHINA_LON_MAX = 136;
    private static final int CHINA_LON_MIN = 73;
    private static final String TAG = "RewardReached";
    private Gson gson = new Gson();
    private LocationDataBean locationDataBean = new LocationDataBean();
    private Context mContext;

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(TAG, "============Enter RewardReached strMsg：" + str);
        this.mContext = context;
        if (str == null || str.length() <= 0) {
            C2538c.m12674b(TAG, "======strMsg is null======");
            return;
        }
        this.locationDataBean = (LocationDataBean) this.gson.fromJson(str, LocationDataBean.class);
        saveToCache(this.locationDataBean, true);
    }

    private void saveToCache(LocationDataBean locationDataBean, boolean z) {
        C2538c.m12674b(TAG, "============Enter saveToCache");
        C1618a.m7658a(null);
        if (locationDataBean == null) {
            C2538c.m12680e(TAG, "============bean is null");
            C1618a.m7659a(false);
            return;
        }
        if (C1492l.m6921e(locationDataBean.data.lon) >= 136.0d || C1492l.m6921e(locationDataBean.data.lon) <= 73.0d) {
            C1618a.m7659a(false);
            C1618a.m7658a(null);
        } else {
            WatchStatus watchStatus = new WatchStatus();
            watchStatus.lastLocation.elev = C1492l.m6921e(locationDataBean.data.elev);
            watchStatus.lastLocation.hacc = C1492l.m6921e(locationDataBean.data.hacc);
            watchStatus.lastLocation.lat = C1492l.m6921e(locationDataBean.data.lat);
            watchStatus.lastLocation.lon = C1492l.m6921e(locationDataBean.data.lon);
            watchStatus.lastLocation.name = locationDataBean.data.name;
            watchStatus.lastLocation.time = C1492l.m6922f(locationDataBean.data.time);
            watchStatus.deviceCode = C1492l.m6920d(locationDataBean.deviceCode);
            C1618a.m7658a(watchStatus);
            C1618a.m7659a(true);
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.homeactivity.emergency_locat");
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
    }
}
