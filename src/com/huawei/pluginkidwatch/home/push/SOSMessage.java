package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.google.gson.Gson;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.home.push.bean.SOSMessageBean;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;

public class SOSMessage implements IPushProcess {
    private static final long ONE_HOUR = 3600000;
    private String TAG = "SOSMessage";
    private boolean boolShow = false;
    private C1401q dbData;
    private GeocodeSearch geocoderSearch;
    private Gson gson = new Gson();
    private LatLng latLng;
    private long lonInterTime = 0;
    private Context mContext;
    private OnGeocodeSearchListener mGeocodeSearchListener = new C16651();
    private SOSMessageBean sosMessageBean = new SOSMessageBean();
    private String watchLocation = "";

    class C16651 implements OnGeocodeSearchListener {
        C16651() {
        }

        public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        }

        public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
            C2538c.m12674b(SOSMessage.this.TAG, "onRegeocodeSearched result: " + i);
            String str = "";
            if (!(i != 0 || regeocodeResult == null || regeocodeResult.getRegeocodeAddress() == null || regeocodeResult.getRegeocodeAddress().getFormatAddress() == null)) {
                try {
                    str = str + regeocodeResult.getRegeocodeAddress().getCity();
                    C2538c.m12674b(SOSMessage.this.TAG, "tempWatchLocation: " + str);
                    str = str + regeocodeResult.getRegeocodeAddress().getTownship();
                    C2538c.m12674b(SOSMessage.this.TAG, "tempWatchLocation: " + str);
                    if (regeocodeResult.getRegeocodeAddress().getRoads().size() > 0) {
                        str = str + ((RegeocodeRoad) regeocodeResult.getRegeocodeAddress().getRoads().get(0)).getName();
                        C2538c.m12674b(SOSMessage.this.TAG, "tempWatchLocation: " + str);
                        if (regeocodeResult.getRegeocodeAddress().getPois().size() > 0) {
                            str = str + ((PoiItem) regeocodeResult.getRegeocodeAddress().getPois().get(0)).toString();
                            C2538c.m12674b(SOSMessage.this.TAG, "tempWatchLocation: " + str);
                        }
                    }
                } catch (Exception e) {
                    Exception exception = e;
                    str = regeocodeResult.getRegeocodeAddress().getFormatAddress();
                    C2538c.m12680e(SOSMessage.this.TAG, "Exception e = " + exception.getMessage());
                }
                C2538c.m12674b(SOSMessage.this.TAG, "onRegeocodeSearched watchLocation: " + SOSMessage.this.watchLocation);
            }
            if (SOSMessage.this.watchLocation.length() <= 0) {
                SOSMessage.this.watchLocation = str;
            }
            SOSMessage.this.SaveDataInDB();
            if (SOSMessage.this.boolShow && SOSMessage.this.lonInterTime <= SOSMessage.ONE_HOUR) {
                SOSMessage.this.ShowNotification();
            }
        }
    }

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(this.TAG, "====== SOSMessage == process start=======");
        this.mContext = context;
        this.boolShow = z;
        this.geocoderSearch = new GeocodeSearch(this.mContext);
        ServiceSettings.getInstance().setProtocol(2);
        this.geocoderSearch.setOnGeocodeSearchListener(this.mGeocodeSearchListener);
        if (str != null && str.length() > 0) {
            this.sosMessageBean = (SOSMessageBean) this.gson.fromJson(str, SOSMessageBean.class);
            this.lonInterTime = System.currentTimeMillis() - C1492l.m6922f(getTime());
        }
        C2538c.m12674b(this.TAG, "====== Save SOS message======" + this.sosMessageBean.toString());
        this.watchLocation = this.sosMessageBean.data.name;
        try {
            this.latLng = new LatLng(Double.valueOf(this.sosMessageBean.data.lat).doubleValue(), Double.valueOf(this.sosMessageBean.data.lon).doubleValue());
            getAddress(new LatLonPoint(this.latLng.latitude, this.latLng.longitude));
        } catch (NumberFormatException e) {
            this.watchLocation = "";
            SaveDataInDB();
            if (z && this.lonInterTime <= ONE_HOUR) {
                ShowNotification();
            }
        }
    }

    private void ShowNotification() {
        String str = "";
        str = getWatchTime();
        String format = String.format(this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_send_emergency_notice), new Object[]{this.sosMessageBean.name, str});
        C1495o.m6930a(this.mContext, NotificationHistoryActivity.class, format, this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 0, new int[0]);
    }

    private void SaveDataInDB() {
        this.dbData = new C1401q();
        this.dbData.f3147c = this.sosMessageBean.deviceCode;
        this.dbData.f3149e = C1492l.m6920d(this.sosMessageBean.type);
        this.dbData.f3148d = this.sosMessageBean.name;
        this.dbData.f3150f = getTime();
        this.dbData.f3152h = this.watchLocation;
        this.dbData.f3153i = "";
        this.dbData.f3154j = "";
        this.dbData.f3155k = "";
        this.dbData.f3156l = "";
        C1392h.m6288b(this.mContext, this.dbData);
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.plugin.menu.notification.history");
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
    }

    private String getTime() {
        String str = "";
        if (this.sosMessageBean.data.time == null || "".equals(this.sosMessageBean.data.time)) {
            return this.sosMessageBean.time;
        }
        return this.sosMessageBean.data.time;
    }

    private String getWatchTime() {
        String string = this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_notification_history_am);
        String str = "";
        str = C1485e.m6847a(C1492l.m6922f(getTime()));
        if (C1485e.m6854a(this.mContext)) {
            return C1485e.m6863c(str);
        }
        if (string.equals(C1485e.m6848a(this.mContext, str))) {
            return String.format(this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_notice_time12am), new Object[]{C1485e.m6857b(str)});
        }
        return String.format(this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_notice_time12pm), new Object[]{C1485e.m6857b(str)});
    }

    private void getAddress(LatLonPoint latLonPoint) {
        C2538c.m12674b(this.TAG, "==================Enter getAddress()");
        this.geocoderSearch.getFromLocationAsyn(new RegeocodeQuery(latLonPoint, 200.0f, GeocodeSearch.AMAP));
    }
}
