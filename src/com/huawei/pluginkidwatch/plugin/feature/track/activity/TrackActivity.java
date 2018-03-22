package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.WeightedLatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;
import com.amap.api.services.route.RouteSearch.FromAndTo;
import com.amap.api.services.route.RouteSearch.OnRouteSearchListener;
import com.amap.api.services.route.WalkRouteResult;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.LocationData;
import com.huawei.pluginkidwatch.common.entity.model.MotionPath;
import com.huawei.pluginkidwatch.common.entity.model.MotionPathsIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1408x;
import com.huawei.pluginkidwatch.common.p138a.ad;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1499a;
import com.huawei.pluginkidwatch.common.ui.p150a.C1500b;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1509k;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.j;
import com.huawei.pluginkidwatch.plugin.feature.track.p164a.C1818a;
import com.huawei.pluginkidwatch.plugin.menu.activity.SettingLocationActivity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.helpers.FileWatchdog;

public class TrackActivity extends KidWatchBaseActivity implements Callback, OnClickListener, OnMapClickListener, OnMapLoadedListener, OnMarkerClickListener, OnRouteSearchListener {
    private LocationData f5075A = null;
    private LocationData f5076B = null;
    private LocationData f5077C = null;
    private LocationData f5078D = null;
    private List<LocationData> f5079E = new ArrayList();
    private List<LatLonPoint> f5080F = new ArrayList();
    private List<LatLonPoint> f5081G = new ArrayList();
    private List<LatLonPoint> f5082H = new ArrayList();
    private List<LatLonPoint> f5083I = new ArrayList();
    private C1413d f5084J;
    private Gson f5085K = new Gson();
    private Marker f5086L;
    private GeocodeSearch f5087M;
    private String f5088N = "";
    private String f5089O = "";
    private LocationData f5090P = new LocationData();
    private int f5091Q = 0;
    private boolean[] f5092R = new boolean[]{false, false};
    private LocationData f5093S = null;
    private int f5094T = 0;
    private boolean f5095U = false;
    private boolean f5096V = false;
    private Marker f5097W;
    private Marker f5098X;
    private double f5099Y = 0.0d;
    private boolean f5100Z = false;
    private boolean aa = false;
    private C1827i ab = C1827i.MAEKER_DOT1;
    private long ac = 0;
    private long ad = 0;
    private double ae = 0.0d;
    private List<LocationData> af = new ArrayList();
    private RouteSearch ag;
    private List<LocationData> ah = new ArrayList();
    private boolean ai = true;
    private boolean aj = true;
    private boolean ak = false;
    private C1828j al;
    private Marker am;
    private MarkerOptions an;
    private List<LocationData> ao = new ArrayList();
    private List<LocationData> ap = new ArrayList();
    private boolean aq = false;
    private boolean ar = true;
    private Timer as = null;
    private TimerTask at = new C1829k();
    private int au = 0;
    private int av = 0;
    private C1378e aw = new C1820b(this);
    private C1378e ax = new C1822d(this);
    private C1509k ay = new C1824f(this);
    private OnGeocodeSearchListener az = new C1826h(this);
    private Context f5101b;
    private TextView f5102c;
    private ImageView f5103d;
    private ImageView f5104e;
    private TextView f5105f;
    private RelativeLayout f5106g;
    private LinearLayout f5107h = null;
    private TextView f5108i;
    private int f5109j = 0;
    private boolean f5110k = false;
    private boolean f5111l = false;
    private boolean f5112m = false;
    private boolean f5113n = false;
    private String f5114o = "";
    private String f5115p = "";
    private int f5116q = 0;
    private Handler f5117r;
    private MapView f5118s;
    private AMap f5119t;
    private MarkerOptions f5120u;
    private MarkerOptions f5121v;
    private MarkerOptions f5122w;
    private Marker f5123x;
    private Marker f5124y;
    private Map<Long, Marker> f5125z = new HashMap();

    public boolean handleMessage(Message message) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "==== message.what:", message.what + "");
        switch (message.what) {
            case 1:
                m8765j();
                break;
            case 2:
                C1483c.m6832c(this.f5101b, this.f5101b.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_track_nodata));
                break;
            case 3:
                C2538c.m12674b("KIDWATCH_TrackActivity", "==== message.obj:", (String) message.obj);
                m8713a(r0);
                break;
            case 4:
                C1506g.m6978a(this.f5101b, "", false);
                break;
        }
        return false;
    }

    protected void onCreate(Bundle bundle) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "====onCreate");
        requestWindowFeature(1);
        setContentView(h.activity_track);
        this.f5101b = this;
        this.av = C1467b.m6787c(this.f5101b);
        C2538c.m12677c("KIDWATCH_TrackActivity", "===www=======current device type = " + this.av);
        this.f5118s = (MapView) findViewById(g.feature_track_map);
        this.f5118s.onCreate(bundle);
        super.onCreate(bundle);
        C1462f.m6739f(true);
    }

    protected void mo2517a() {
        m8742d();
        m8750e();
    }

    private void m8742d() {
        this.f5102c = (TextView) findViewById(g.feature_rlyt_track_title);
        C2538c.m12677c("KIDWATCH_TrackActivity", "===www=======current device currentDevice" + C1467b.m6789d(this.f5101b));
        if (7 == C1467b.m6789d(this.f5101b)) {
            this.f5102c.setText(C1680l.IDS_plugin_kidwatch_menu_track_history);
        }
        C1499a.m6962a(new Date());
        this.f5114o = C1485e.m6867d(new Date());
        this.f5117r = new Handler(this);
        this.f5084J = C1417a.m6594a(this.f5101b);
        this.f5087M = new GeocodeSearch(this);
        ServiceSettings.getInstance().setProtocol(2);
        this.f5087M.setOnGeocodeSearchListener(this.az);
        if (this.f5119t == null) {
            this.f5119t = this.f5118s.getMap();
            UiSettings uiSettings = this.f5119t.getUiSettings();
            uiSettings.setZoomControlsEnabled(false);
            uiSettings.setRotateGesturesEnabled(false);
            this.f5119t.setOnMarkerClickListener(this);
            this.f5119t.setOnMapClickListener(this);
            this.f5119t.setOnMapLoadedListener(this);
            m8775o();
        }
        this.ag = new RouteSearch(this);
        this.ag.setRouteSearchListener(this);
        this.f5103d = (ImageView) findViewById(g.feature_iv_track_topdate_left);
        this.f5105f = (TextView) findViewById(g.feature_tv_track_topdate);
        this.f5104e = (ImageView) findViewById(g.feature_iv_track_topdate_right);
        this.f5106g = (RelativeLayout) findViewById(g.feature_rlyt_track_title_right);
        this.f5108i = (TextView) findViewById(g.feature_tv_track_title_right);
        this.f5103d.setOnClickListener(this);
        this.f5104e.setOnClickListener(this);
        this.f5104e.setEnabled(false);
        this.f5106g.setOnClickListener(this);
        this.f5105f.setOnClickListener(this);
        this.f5105f.setText(C1485e.m6861c());
        this.f5108i.setText(C1485e.m6861c().substring(8, 10));
        this.f5107h = (LinearLayout) findViewById(g.not_used_status_tips_llt);
        if (C1490j.m6890a("LCS_PowerSaveMode") && C1462f.m6760t() == 0) {
            this.f5107h.setVisibility(0);
            this.f5107h.setOnClickListener(this);
            return;
        }
        this.f5107h.setVisibility(8);
    }

    private void m8750e() {
        if ("".equals(C1462f.m6746j())) {
            m8778p();
            return;
        }
        if (this.ai) {
            m8752f();
        }
        m8713a(this.f5114o);
    }

    private void m8713a(String str) {
        C1506g.m6978a(this.f5101b, "", false);
        MotionPathsIOEntityModel motionPathsIOEntityModel = new MotionPathsIOEntityModel();
        motionPathsIOEntityModel.deviceCode = C1462f.m6746j();
        motionPathsIOEntityModel.dateEnd = str;
        this.f5115p = str;
        motionPathsIOEntityModel.daysCount = 1;
        this.f5084J.mo2490a(motionPathsIOEntityModel, this.ax);
    }

    private void m8752f() {
        C2538c.m12674b("KIDWATCH_TrackActivity", "getCountDaysTrackData");
        new C1819a(this).execute(new String[0]);
    }

    private void m8698a(int i) {
        String b = C1485e.m6858b(this.f5114o, "yyyyMMdd");
        MotionPathsIOEntityModel motionPathsIOEntityModel = new MotionPathsIOEntityModel();
        motionPathsIOEntityModel.deviceCode = C1462f.m6746j();
        motionPathsIOEntityModel.dateEnd = b;
        motionPathsIOEntityModel.daysCount = i;
        this.f5116q = i;
        this.f5084J.mo2490a(motionPathsIOEntityModel, this.aw);
    }

    private void m8714a(String str, Map<String, MotionPath[]> map) {
        if (this.ah == null || this.ah.size() <= 0) {
            this.ah = new ArrayList();
        } else {
            this.ah.clear();
        }
        if (this.ao == null || this.ao.size() <= 0) {
            this.ao = new ArrayList();
        } else {
            this.ao.clear();
        }
        if (this.ap == null || this.ap.size() <= 0) {
            this.ap = new ArrayList();
        } else {
            this.ap.clear();
        }
        if (map.containsKey(str)) {
            MotionPath[] motionPathArr = (MotionPath[]) map.get(str);
            if (motionPathArr != null && motionPathArr.length > 0) {
                this.ac = 0;
                for (int i = 0; i < motionPathArr.length; i++) {
                    for (LocationData locationData : motionPathArr[i].lbsDatas) {
                        if (this.ai) {
                            if (this.f5099Y == locationData.lat || this.f5099Y == locationData.lon || C1492l.m6920d(locationData.type) >= 5 || (("1".equals(locationData.type) && C1492l.m6920d(locationData.radius) > 200) || (("2".equals(locationData.type) && C1492l.m6920d(locationData.radius) > HeartRateDetail.HEART_RATE_TYPE_SPORT) || ("3".equals(locationData.type) && C1492l.m6920d(locationData.radius) > HeartRateDetail.HEART_RATE_TYPE_SPORT)))) {
                                C2538c.m12674b("KIDWATCH_TrackActivity", "========抛弃经度或者纬度为0.0或者(gps定位的精度大于200米)或者(WiFi或者混合定位的精度大于600米)或者其他定位方式的异常点=====");
                            } else {
                                this.ah.add(locationData);
                            }
                        } else if (!str.equals(C1485e.m6867d(new Date()))) {
                            this.f5079E.add(locationData);
                        } else if (locationData.time <= System.currentTimeMillis()) {
                            this.f5079E.add(locationData);
                        }
                    }
                }
                if (this.ai) {
                    m8756g();
                    m8730b(str);
                    return;
                }
                Collections.sort(this.f5079E, new C1818a());
            }
        }
    }

    private void m8730b(String str) {
        int size = this.ao.size();
        if (size > 1) {
            Object obj = null;
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                Object obj2;
                LocationData locationData = (LocationData) this.ao.get(i);
                if (!"4".equals(locationData.type)) {
                    if (1 == i2 && this.ap != null) {
                        this.ap.add(obj);
                    }
                    i3 = 0;
                    obj2 = obj;
                } else if (size - 1 != i || i2 != 0) {
                    int i4 = i2 + 1;
                    LocationData locationData2 = locationData;
                    i3 = i4;
                } else if (this.ap != null) {
                    this.ap.add(locationData);
                    i3 = i2;
                    obj2 = obj;
                } else {
                    i3 = i2;
                    obj2 = obj;
                }
                i++;
                obj = obj2;
                i2 = i3;
            }
            m8738c(str);
        } else if (size > 0) {
            m8705a((LocationData) this.ao.get(0), str);
        }
    }

    private void m8738c(String str) {
        int i = 0;
        if (this.ap != null) {
            int size = this.ap.size();
            if (size > 0) {
                m8725b(size);
                for (int i2 = 0; i2 < size; i2++) {
                    LocationData locationData = (LocationData) this.ap.get(i2);
                    if (this.ao.contains(locationData)) {
                        this.ao.remove(locationData);
                    }
                }
            }
        }
        while (i < this.ao.size()) {
            m8705a((LocationData) this.ao.get(i), str);
            i++;
        }
    }

    private void m8725b(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            LocationData locationData = (LocationData) this.ap.get(i2);
            if (locationData == this.ao.get(0)) {
                ((LocationData) this.ao.get(1)).time = locationData.time;
            } else {
                for (int i3 = 0; i3 < this.ao.size(); i3++) {
                    if (locationData == this.ao.get(i3)) {
                        ((LocationData) this.ao.get(i3 - 1)).endTime = locationData.endTime;
                    }
                }
            }
        }
    }

    private void m8756g() {
        Collections.sort(this.ah, new C1818a());
        int size = this.ah.size();
        if (size <= 0) {
            return;
        }
        if (size > 1) {
            LocationData locationData = (LocationData) this.ah.get(0);
            if ("4".equals(locationData.type)) {
                this.f5078D = locationData;
                this.ah.remove(0);
                this.au = 0;
                m8758h();
            }
            if (this.ah.size() <= 0) {
                return;
            }
            if (this.ah.size() > 1) {
                m8763i();
                return;
            } else {
                m8766j((LocationData) this.ah.get(0));
                return;
            }
        }
        m8766j((LocationData) this.ah.get(0));
    }

    private void m8758h() {
        LocationData locationData = (LocationData) this.ah.get(this.au);
        if (!"4".equals(locationData.type)) {
            return;
        }
        if (m8721b(this.f5078D, locationData) <= 100.0f) {
            this.ah.remove(this.au);
            if (this.ah.size() <= 0) {
                this.f5078D.endTime = String.valueOf(locationData.time);
                m8766j(this.f5078D);
                return;
            } else if (this.au != this.ah.size()) {
                m8758h();
                return;
            } else {
                return;
            }
        }
        this.au++;
        if (this.au != this.ah.size()) {
            m8758h();
        }
    }

    private void m8763i() {
        List arrayList = new ArrayList();
        int size = this.ah.size();
        for (int i = 0; i < size; i++) {
            this.f5110k = false;
            this.f5111l = false;
            if (i == 0) {
                this.f5110k = true;
            } else if (size - 1 == i) {
                this.f5111l = true;
            }
            m8706a((LocationData) this.ah.get(i), arrayList);
        }
    }

    public void onClick(View view) {
        if (this.ak && this.al != null) {
            this.al.m8796a();
        }
        String trim = this.f5105f.getText().toString().trim();
        if (g.feature_iv_track_topdate_left == view.getId()) {
            m8770l();
            this.f5104e.setEnabled(true);
            this.f5106g.setVisibility(0);
            trim = C1485e.m6858b(trim, "yyyy年MM月dd日");
            if (trim != null && !"".equals(trim)) {
                this.f5105f.setText(trim);
                C1499a.m6962a(C1485e.m6851a(C1485e.m6866d(trim)));
                m8747d(trim);
            }
        } else if (g.feature_iv_track_topdate_right == view.getId()) {
            m8770l();
            trim = C1485e.m6864c(trim, "yyyy年MM月dd日");
            if (!(trim == null || "".equals(trim))) {
                this.f5105f.setText(trim);
                C1499a.m6962a(C1485e.m6851a(C1485e.m6866d(trim)));
                m8747d(trim);
            }
            if (this.f5105f.getText().toString().trim().equals(C1485e.m6861c())) {
                this.f5104e.setEnabled(false);
                this.f5106g.setVisibility(8);
            }
        } else if (g.feature_tv_track_topdate == view.getId()) {
            C1500b.m6965a(this.f5101b, C1485e.m6851a(C1485e.m6866d(trim)), this.ay);
        } else if (g.feature_rlyt_track_title_right == view.getId()) {
            m8770l();
            m8747d(C1485e.m6861c());
            this.f5105f.setText(C1485e.m6861c());
            this.f5104e.setEnabled(false);
            this.f5106g.setVisibility(8);
            C1499a.m6962a(C1485e.m6851a(C1485e.m6866d(C1485e.m6861c())));
        } else if (g.not_used_status_tips_llt == view.getId()) {
            Intent intent = new Intent();
            intent.setClass(this, SettingLocationActivity.class);
            startActivity(intent);
        }
    }

    private void m8765j() {
        int size = this.f5079E.size();
        this.aq = false;
        this.ar = true;
        this.f5075A = null;
        this.f5076B = null;
        this.f5077C = null;
        this.f5095U = false;
        this.f5096V = false;
        C2538c.m12674b("KIDWATCH_TrackActivity", "=======drawTrackToMap===len====" + size);
        if (this.f5125z == null || this.f5125z.size() <= 0) {
            this.f5125z = new HashMap();
        } else {
            this.f5125z.clear();
        }
        if (this.f5119t != null) {
            this.f5119t.clear();
        } else {
            this.f5119t = this.f5118s.getMap();
            UiSettings uiSettings = this.f5119t.getUiSettings();
            uiSettings.setZoomControlsEnabled(false);
            uiSettings.setRotateGesturesEnabled(false);
            this.f5119t.setOnMarkerClickListener(this);
            this.f5119t.setOnMapClickListener(this);
            this.f5119t.setOnMapLoadedListener(this);
        }
        m8778p();
        if (size > 0) {
            m8735c(size);
            if (this.ak) {
                m8743d(size);
                return;
            } else {
                m8751e(size);
                return;
            }
        }
        C1506g.m6979b();
    }

    private void m8735c(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if ("true".equals(((LocationData) this.f5079E.get(i2)).data2)) {
                this.aq = true;
                return;
            }
        }
    }

    private void m8743d(int i) {
        if (this.al != null) {
            this.al.m8796a();
        }
        if (i == 1) {
            this.f5096V = true;
            if ("0".equals(((LocationData) this.f5079E.get(0)).data1)) {
                m8702a((LocationData) this.f5079E.get(0));
                return;
            }
            return;
        }
        this.al = new C1828j(this);
        this.al.start();
    }

    private void m8751e(int i) {
        LocationData locationData = null;
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            LocationData locationData2 = (LocationData) this.f5079E.get(i2);
            if (i == 1) {
                this.f5096V = true;
                if (!this.ai) {
                    m8702a(locationData2);
                } else if ("0".equals(locationData2.data1)) {
                    m8702a(locationData2);
                }
                C1506g.m6979b();
            } else {
                if (i2 == 0) {
                    this.f5095U = true;
                    m8702a(locationData2);
                }
                if (i2 > 0) {
                    LocationData locationData3 = (LocationData) this.f5079E.get(i2 - 1);
                    if (this.ai) {
                        if (!"false".equals(locationData3.data2)) {
                            locationData3 = locationData;
                        }
                        if ("true".equals(locationData2.data2)) {
                            arrayList.add(locationData2);
                        }
                        if ("false".equals(locationData2.data2)) {
                            m8704a(locationData3, locationData2, arrayList);
                        }
                        this.ae = m8688a(locationData3, locationData2);
                        if (i2 <= 1 || !"0".equals(locationData2.data1)) {
                            locationData = locationData3;
                        } else {
                            m8702a(locationData3);
                            locationData = locationData3;
                        }
                    } else {
                        this.ae = m8688a(locationData3, locationData2);
                        if (i2 > 1) {
                            m8702a(locationData3);
                        }
                    }
                    if (i - 1 == i2) {
                        this.f5096V = true;
                        m8702a(locationData2);
                        if (this.f5081G == null || this.f5081G.size() <= 0) {
                            C1506g.m6979b();
                        } else {
                            m8768k();
                        }
                    }
                }
            }
        }
    }

    private void m8768k() {
        C2538c.m12674b("KIDWATCH_TrackActivity", "setTrivingTimer is enter!");
        if (this.as == null) {
            this.as = new Timer();
        }
        if (this.as != null) {
            this.at.cancel();
        }
        this.at = new C1829k();
        this.as.schedule(this.at, 3000);
    }

    private void m8770l() {
        if (this.as != null) {
            this.as.cancel();
            this.as = null;
        }
    }

    private void m8744d(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====addVerPolyline is enter====");
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
        polylineOptions.add(new LatLng(latLonPoint2.getLatitude(), latLonPoint2.getLongitude()));
        polylineOptions.color(Color.parseColor("#25bff1"));
        polylineOptions.width(10.0f);
        if (7 == this.av) {
            polylineOptions.setDottedLine(true);
        }
        this.f5119t.addPolyline(polylineOptions);
    }

    private void m8772m() {
        this.an = new MarkerOptions();
        this.an.draggable(true);
        this.an.anchor(0.5f, 0.5f);
        this.an.icon(BitmapDescriptorFactory.fromResource(C1617f.kw_track_play));
        this.am = this.f5119t.addMarker(this.an);
    }

    private double m8686a(double d, LatLng latLng) {
        return latLng.latitude - (latLng.longitude * d);
    }

    private double m8685a(double d) {
        if (d == Double.MAX_VALUE) {
            return 1.0E-4d;
        }
        return Math.abs((1.0E-4d * d) / Math.sqrt(WeightedLatLng.DEFAULT_INTENSITY + (d * d)));
    }

    private void m8704a(LocationData locationData, LocationData locationData2, List<LocationData> list) {
        float b = m8721b(locationData, locationData2);
        long f = C1492l.m6922f(locationData.endTime);
        long f2 = C1492l.m6922f(locationData2.endTime);
        float a = m8693a(b, f, f2);
        f = f2 - f;
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====addPolyline======endTime====" + locationData2.endTime);
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====addPolyline======speed====" + a);
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====addPolyline======boolIsTrivingFlag====" + this.aq);
        if (!this.aq && this.aj && a >= 2.0f && a <= 42.0f && f >= FileWatchdog.DEFAULT_DELAY && f <= 960000) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "=====乘车场景====");
            C2538c.m12674b("KIDWATCH_TrackActivity", "=====联网场景Network====" + C1492l.m6916b(this.f5101b));
            if (C1492l.m6916b(this.f5101b)) {
                C2538c.m12674b("KIDWATCH_TrackActivity", "=====联网场景====");
                LatLonPoint latLonPoint = new LatLonPoint(locationData.lat, locationData.lon);
                LatLonPoint latLonPoint2 = new LatLonPoint(locationData2.lat, locationData2.lon);
                C2538c.m12674b("KIDWATCH_TrackActivity", "===========addPolyline=====startPoint===" + latLonPoint.toString());
                C2538c.m12674b("KIDWATCH_TrackActivity", "===========addPolyline=====endPoint===" + latLonPoint2.toString());
                m8786a(latLonPoint, latLonPoint2);
                return;
            }
            C2538c.m12674b("KIDWATCH_TrackActivity", "=====没有联网场景====");
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(new LatLng(locationData.lat, locationData.lon));
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                polylineOptions.add(new LatLng(((LocationData) list.get(i)).lat, ((LocationData) list.get(i)).lon));
            }
            list.clear();
        }
        polylineOptions.add(new LatLng(locationData2.lat, locationData2.lon));
        polylineOptions.color(Color.parseColor("#25bff1"));
        polylineOptions.width(10.0f);
        if (7 == this.av) {
            polylineOptions.setDottedLine(true);
        }
        this.f5119t.addPolyline(polylineOptions);
    }

    public void m8786a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint != null) {
            m8787b(latLonPoint, latLonPoint2);
        }
    }

    public void m8787b(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint2 != null) {
            if (this.f5081G != null) {
                this.f5081G.add(latLonPoint);
            }
            if (this.f5082H != null) {
                this.f5082H.add(latLonPoint2);
            }
            m8788c(latLonPoint, latLonPoint2);
        }
    }

    public void m8788c(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "=======searchRouteResult=========");
        this.ag.calculateDriveRouteAsyn(new DriveRouteQuery(new FromAndTo(latLonPoint, latLonPoint2), 5, null, null, ""));
    }

    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {
    }

    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====onDriveRouteSearched==rCode=" + i);
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====onDriveRouteSearched==boolIsNeedBackTriving=" + this.ar);
        if (this.ar && i == 0 && driveRouteResult != null && driveRouteResult.getPaths() != null && driveRouteResult.getPaths().size() > 0) {
            DrivePath drivePath = (DrivePath) driveRouteResult.getPaths().get(0);
            float distance = drivePath.getDistance();
            PolylineOptions polylineOptions = new PolylineOptions();
            LatLonPoint startPos = driveRouteResult.getStartPos();
            LatLonPoint targetPos = driveRouteResult.getTargetPos();
            C2538c.m12674b("KIDWATCH_TrackActivity", "===========onDriveRouteSearched=====startPoint===" + startPos.toString());
            C2538c.m12674b("KIDWATCH_TrackActivity", "===========onDriveRouteSearched=====endPoint===" + targetPos.toString());
            if (this.f5080F.contains(startPos) && this.f5080F.contains(targetPos)) {
                if (this.f5083I != null) {
                    this.f5083I.add(startPos);
                }
                polylineOptions.add(new LatLng(startPos.getLatitude(), startPos.getLongitude()));
                float calculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(startPos.getLatitude(), startPos.getLongitude()), new LatLng(targetPos.getLatitude(), targetPos.getLongitude()));
                C2538c.m12674b("KIDWATCH_TrackActivity", "=====onDriveRouteSearched driveDistance==" + distance);
                C2538c.m12674b("KIDWATCH_TrackActivity", "=====onDriveRouteSearched distance==" + calculateLineDistance);
                if (distance < calculateLineDistance || ((double) distance) > ((double) calculateLineDistance) * 1.5d) {
                    C2538c.m12674b("KIDWATCH_TrackActivity", "===乘车路径规划两点之间线路使用直连效果===");
                } else {
                    List steps = drivePath.getSteps();
                    long a = m8694a(startPos);
                    for (int i2 = 0; i2 < steps.size(); i2++) {
                        for (LatLonPoint latLonPoint : ((DriveStep) steps.get(i2)).getPolyline()) {
                            long j = a + 1;
                            m8697a(latLonPoint.getLongitude(), latLonPoint.getLatitude(), j);
                            polylineOptions.add(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
                            a = j;
                        }
                    }
                }
                polylineOptions.add(new LatLng(targetPos.getLatitude(), targetPos.getLongitude()));
                polylineOptions.color(Color.parseColor("#25bff1"));
                polylineOptions.width(10.0f);
                if (7 == this.av) {
                    polylineOptions.setDottedLine(true);
                }
                this.f5119t.addPolyline(polylineOptions);
            }
        }
    }

    private long m8694a(LatLonPoint latLonPoint) {
        int size = this.f5079E.size();
        for (int i = 0; i < size; i++) {
            LocationData locationData = (LocationData) this.f5079E.get(i);
            if (locationData.lat == latLonPoint.getLatitude() && locationData.lon == latLonPoint.getLongitude()) {
                return locationData.time;
            }
        }
        return 0;
    }

    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {
    }

    private void m8702a(LocationData locationData) {
        LatLng latLng = new LatLng(locationData.lat, locationData.lon);
        this.f5121v = new MarkerOptions();
        this.f5121v.draggable(true);
        this.f5121v.anchor(0.5f, 0.5f);
        this.f5121v.position(latLng);
        if (this.f5095U) {
            this.f5121v.icon(BitmapDescriptorFactory.fromResource(C1617f.kw_track_dot_2));
        } else if (this.f5096V) {
            this.f5121v.icon(BitmapDescriptorFactory.fromResource(C1617f.kw_pic_gps_user_track));
        } else {
            this.f5121v.icon(BitmapDescriptorFactory.fromResource(C1617f.kw_track_dot_1));
        }
        this.f5123x = this.f5119t.addMarker(this.f5121v);
        if (!(true == this.f5095U || true == this.f5096V)) {
            this.f5123x.setRotateAngle((float) this.ae);
        }
        this.f5123x.setVisible(true);
        if (this.f5095U) {
            this.f5097W = this.f5123x;
        } else if (this.f5096V) {
            this.f5098X = this.f5123x;
        } else {
            this.f5125z.put(Long.valueOf(locationData.time), this.f5123x);
        }
        if (this.f5095U) {
            this.f5095U = false;
        }
        if (this.f5096V) {
            this.f5096V = false;
        }
    }

    private double m8688a(LocationData locationData, LocationData locationData2) {
        double d = 0.0d;
        LatLng latLng = new LatLng(locationData.lat, locationData.lon);
        LatLng latLng2 = new LatLng(locationData2.lat, locationData2.lon);
        double a = m8687a(latLng, latLng2);
        if (a != Double.MAX_VALUE) {
            if ((latLng2.latitude - latLng.latitude) * a <= 0.0d) {
                d = 180.0d;
            }
            return (d + (180.0d * (Math.atan(a) / 3.141592653589793d))) - 90.0d;
        } else if (latLng2.latitude > latLng.latitude) {
            return 0.0d;
        } else {
            return 180.0d;
        }
    }

    private double m8687a(LatLng latLng, LatLng latLng2) {
        if (latLng2.longitude == latLng.longitude) {
            return Double.MAX_VALUE;
        }
        return (latLng2.latitude - latLng.latitude) / (latLng2.longitude - latLng.longitude);
    }

    private void m8727b(LocationData locationData) {
        this.f5090P = locationData;
        if (this.f5124y != null && this.f5124y.isVisible()) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "=====clickedIconMarker is not null======");
            this.f5124y.setVisible(false);
            this.f5124y.remove();
            if (this.f5075A != null) {
                this.ae = m8688a(this.f5075A, this.f5076B);
                m8702a(this.f5075A);
            }
        }
        if (true == this.f5100Z || true == this.aa) {
            if (this.f5100Z) {
                this.f5100Z = false;
            }
            if (this.aa) {
                this.aa = false;
                return;
            }
            return;
        }
        Marker marker = (Marker) this.f5125z.get(Long.valueOf(locationData.time));
        if (marker != null) {
            marker.remove();
        }
        LatLng latLng = new LatLng(locationData.lat, locationData.lon);
        this.f5122w = new MarkerOptions();
        this.f5122w.draggable(true);
        this.f5122w.anchor(0.5f, 0.5f);
        this.f5122w.position(latLng);
        this.f5122w.icon(BitmapDescriptorFactory.fromResource(C1617f.kw_track_dot_3));
        this.f5124y = this.f5119t.addMarker(this.f5122w);
        this.ae = m8688a(locationData, this.f5077C);
        this.f5124y.setRotateAngle((float) this.ae);
        this.f5124y.setVisible(true);
        this.f5075A = locationData;
        m8736c(locationData);
    }

    private void m8736c(LocationData locationData) {
        if (this.f5086L != null && this.f5086L.isVisible()) {
            this.f5086L.setVisible(false);
            this.f5086L.remove();
        }
        if (this.ai) {
            C1408x c1408x = new C1408x();
            c1408x.f3190d = C1492l.m6920d(C1462f.m6746j());
            c1408x.f3188b = String.valueOf(locationData.time);
            C1392h.m6294b(this.f5101b, c1408x);
            if ("".equals(c1408x.f3197k) && "".equals(c1408x.f3198l)) {
                m8726b(new LatLonPoint(locationData.lat, locationData.lon));
                return;
            }
            this.f5089O = c1408x.f3197k;
            this.f5088N = c1408x.f3198l;
            m8745d(locationData);
            return;
        }
        m8726b(new LatLonPoint(locationData.lat, locationData.lon));
    }

    private void m8745d(LocationData locationData) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====Enter addPositionOnMap");
        if (this.f5086L != null && this.f5086L.isVisible()) {
            this.f5086L.setVisible(false);
            this.f5086L.remove();
        }
        Bitmap a = C1492l.m6905a(m8696a(getLayoutInflater().inflate(h.track_position_layout, null), locationData));
        LatLng latLng = new LatLng(locationData.lat, locationData.lon);
        this.f5120u = new MarkerOptions();
        this.f5120u.draggable(true);
        if (C1827i.MAEKER_DOT1 == this.ab || C1827i.MAEKER_DOT3 == this.ab) {
            this.f5120u.anchor(0.5f, 1.1f);
        } else {
            this.f5120u.anchor(0.5f, 1.15f);
        }
        this.f5120u.position(latLng);
        this.f5120u.icon(BitmapDescriptorFactory.fromBitmap(a));
        this.f5086L = this.f5119t.addMarker(this.f5120u);
        this.f5086L.setVisible(true);
    }

    private View m8696a(View view, LocationData locationData) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "==============Enter updatePositionDescribe");
        String str = "";
        int e = m8748e(locationData);
        TextView textView = (TextView) view.findViewById(g.feature_tv_buliding_name);
        TextView textView2 = (TextView) view.findViewById(g.feature_tv_street_name);
        TextView textView3 = (TextView) view.findViewById(g.feature_tv_stay_time);
        TextView textView4 = (TextView) view.findViewById(g.feature_tv_time);
        if ("".equals(this.f5089O)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(this.f5089O);
        }
        if ("".equals(this.f5088N)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(this.f5088N);
        }
        if (e > 0) {
            CharSequence format;
            str = "";
            int i = e / 60;
            int i2 = e % 60;
            textView3.setVisibility(0);
            if (i > 0) {
                String string = this.f5101b.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_track_staytime2);
                Object[] objArr = new Object[2];
                objArr[0] = this.f5101b.getResources().getQuantityString(j.IDS_plugin_kidwatch_common_hour_unit, i, new Object[]{Integer.valueOf(i)});
                objArr[1] = this.f5101b.getResources().getQuantityString(j.IDS_plugin_kidwatch_common_minute_unit, i2, new Object[]{Integer.valueOf(i2)});
                format = String.format(string, objArr);
            } else {
                str = this.f5101b.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_track_staytime1);
                Object[] objArr2 = new Object[1];
                objArr2[0] = this.f5101b.getResources().getQuantityString(j.IDS_plugin_kidwatch_common_minute_unit, i2, new Object[]{Integer.valueOf(i2)});
                format = String.format(str, objArr2);
            }
            textView3.setText(format);
        } else {
            textView3.setVisibility(8);
        }
        textView4.setText(String.format(this.f5101b.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_track_arrivetime), new Object[]{m8773n()}));
        C2538c.m12674b("KIDWATCH_TrackActivity", "==============Leave updatePositionDescribe");
        return view;
    }

    private int m8748e(LocationData locationData) {
        return (int) (((C1492l.m6922f(locationData.endTime) - locationData.time) / 1000) / 60);
    }

    private String m8773n() {
        return C1485e.m6846a((C1485e.m6868e(C1485e.m6847a(this.f5090P.time)) * 60) + C1485e.m6869f(C1485e.m6847a(this.f5090P.time)));
    }

    private void m8726b(LatLonPoint latLonPoint) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "==================Enter getAddress()");
        this.f5087M.getFromLocationAsyn(new RegeocodeQuery(latLonPoint, 200.0f, GeocodeSearch.AMAP));
    }

    protected void onResume() {
        super.onResume();
        this.f5118s.onResume();
        if (C1490j.m6890a("LCS_PowerSaveMode") && C1462f.m6760t() == 0) {
            this.f5107h.setVisibility(0);
            this.f5107h.setOnClickListener(this);
            return;
        }
        this.f5107h.setVisibility(8);
    }

    protected void onPause() {
        super.onPause();
        this.f5118s.onPause();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5118s.onSaveInstanceState(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1500b.m6964a();
        C1506g.m6979b();
        m8770l();
        this.f5118s.onDestroy();
    }

    protected void onStop() {
        super.onStop();
        C1506g.m6979b();
    }

    public void onMapLoaded() {
        if (this.f5079E == null || this.f5079E.size() <= 0) {
            m8775o();
        }
    }

    private void m8775o() {
        LatLng latLng;
        ad b = C1392h.m6289b(this.f5101b, C1462f.m6744i(), C1462f.m6746j());
        this.f5119t.moveCamera(CameraUpdateFactory.zoomTo(17.0f));
        if (b != null) {
            latLng = new LatLng(b.m6232c(), b.m6234d());
        } else {
            String b2 = C1497q.m6945b(this.f5101b, "main_map_last_app_position", "");
            C2538c.m12674b("KIDWATCH_TrackActivity", "=========onMapLoaded：", b2);
            try {
                latLng = !"".equals(b2) ? (LatLng) this.f5085K.fromJson(b2, LatLng.class) : null;
            } catch (JsonSyntaxException e) {
                C2538c.m12680e("KIDWATCH_TrackActivity", "Exception e = " + e.getMessage());
                latLng = null;
            }
        }
        if (latLng != null) {
            this.f5119t.moveCamera(CameraUpdateFactory.changeLatLng(latLng));
        }
    }

    public void onMapClick(LatLng latLng) {
        if (this.f5086L != null && this.f5086L.isVisible()) {
            this.f5086L.setVisible(false);
            this.f5086L.remove();
        }
    }

    private void m8778p() {
        if (this.f5079E.size() > 0) {
            Builder builder = new Builder();
            LatLngBounds latLngBounds = null;
            int i = 0;
            while (i < this.f5079E.size()) {
                LocationData locationData = (LocationData) this.f5079E.get(i);
                i++;
                latLngBounds = builder.include(new LatLng(locationData.lat, locationData.lon)).build();
            }
            this.f5119t.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 10));
        }
    }

    public boolean onMarkerClick(Marker marker) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "======Enter onMarkerClick=========");
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        c.a().a(BaseApplication.m2632b(), a.W.a(), hashMap, 0);
        LocationData locationData;
        if (marker.equals(this.f5097W)) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "======firstMarker被点击=========");
            this.ab = C1827i.MAEKER_DOT2;
            locationData = (LocationData) this.f5079E.get(0);
            this.f5100Z = true;
            m8727b(locationData);
            m8753f(locationData);
        } else if (marker.equals(this.f5098X)) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "======lastMarker被点击=========");
            this.ab = C1827i.MAEKER_USER;
            locationData = (LocationData) this.f5079E.get(this.f5079E.size() - 1);
            this.aa = true;
            m8727b(locationData);
            m8753f(locationData);
        } else if (marker.equals(this.f5124y)) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "======clickedIconMarker被点击=========");
            this.ab = C1827i.MAEKER_DOT3;
            m8753f(this.f5090P);
        } else {
            m8701a(marker);
        }
        return false;
    }

    private void m8701a(Marker marker) {
        if (this.f5125z != null) {
            for (Entry entry : this.f5125z.entrySet()) {
                if (marker.equals(entry.getValue())) {
                    C2538c.m12674b("KIDWATCH_TrackActivity", "======坐标marker被点击=========");
                    int size = this.f5079E.size();
                    for (int i = 0; i < size; i++) {
                        LocationData locationData = (LocationData) this.f5079E.get(i);
                        if (((Long) entry.getKey()).longValue() == locationData.time) {
                            if (this.ai) {
                                m8699a(i, locationData);
                            } else {
                                this.ab = C1827i.MAEKER_DOT1;
                                this.f5077C = (LocationData) this.f5079E.get(i + 1);
                                m8727b(locationData);
                                this.f5076B = (LocationData) this.f5079E.get(i + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m8699a(int i, LocationData locationData) {
        int size = this.f5079E.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            LocationData locationData2 = (LocationData) this.f5079E.get(i2);
            if ("0".equals(locationData2.data1)) {
                this.ab = C1827i.MAEKER_DOT1;
                this.f5077C = locationData2;
                m8727b(locationData);
                this.f5076B = locationData2;
                return;
            }
        }
    }

    private void m8753f(LocationData locationData) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "======Enter showPositionMarker=========");
        if (this.f5119t == null) {
            return;
        }
        if (this.f5086L == null || !this.f5086L.isVisible()) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "=====显示地理位置信息Marker");
            this.f5090P = locationData;
            m8736c(locationData);
            return;
        }
        C2538c.m12674b("KIDWATCH_TrackActivity", "=====隐藏地理位置信息Marker");
        this.f5086L.setVisible(false);
        this.f5086L.remove();
    }

    private void m8747d(String str) {
        if (this.f5079E == null || this.f5079E.size() <= 0) {
            this.f5079E = new ArrayList();
        } else {
            this.f5079E.clear();
        }
        if (this.f5080F == null || this.f5080F.size() <= 0) {
            this.f5080F = new ArrayList();
        } else {
            this.f5080F.clear();
        }
        if (this.f5081G == null || this.f5081G.size() <= 0) {
            this.f5081G = new ArrayList();
        } else {
            this.f5081G.clear();
        }
        if (this.f5082H == null || this.f5082H.size() <= 0) {
            this.f5082H = new ArrayList();
        } else {
            this.f5082H.clear();
        }
        if (this.f5083I == null || this.f5083I.size() <= 0) {
            this.f5083I = new ArrayList();
        } else {
            this.f5083I.clear();
        }
        if (this.f5119t != null) {
            this.f5119t.clear();
        }
        new Thread(new C1825g(this, str)).start();
    }

    private void m8700a(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        this.f5117r.sendMessage(message);
    }

    private void m8706a(LocationData locationData, List<LocationData> list) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "===throwPoint=====lonPreLocationTime=====" + this.ac);
        this.f5112m = false;
        this.f5113n = false;
        if (this.f5110k) {
            m8757g(locationData);
            return;
        }
        float b = m8721b(this.f5093S, locationData);
        C2538c.m12674b("KIDWATCH_TrackActivity", "========speed=====" + m8693a(b, this.ac, locationData.time));
        if (b <= 100.0f) {
            m8731b((List) list, locationData);
        } else if (b > 100.0f) {
            float a;
            if (a > 42.0f) {
                m8737c(locationData, (List) list);
                return;
            }
            list.add(locationData);
            boolean[] zArr = this.f5092R;
            int i = this.f5091Q;
            this.f5091Q = i + 1;
            zArr[i] = true;
        }
        if (this.af == null || this.af.size() <= 0) {
            this.af = new ArrayList();
        } else {
            this.af.clear();
        }
        if (this.f5092R[0] && this.f5092R[1]) {
            m8728b(locationData, (List) list);
            if (!this.f5113n) {
                m8717a((List) list, false);
                m8766j(m8762i(this.f5093S));
                this.f5093S = (LocationData) list.get(0);
                this.ac = this.f5093S.time;
                b = m8721b((LocationData) list.get(0), (LocationData) list.get(1));
                a = m8693a(b, this.ac, ((LocationData) list.get(1)).time);
                if (b <= 100.0f) {
                    m8716a((List) list, locationData);
                    if (!this.f5112m) {
                        return;
                    }
                    return;
                } else if (b <= 100.0f) {
                    return;
                } else {
                    if (a <= 42.0f) {
                        m8715a((List) list);
                        if (!this.f5112m) {
                            list.remove(0);
                            zArr = this.f5092R;
                            i = this.f5091Q;
                            this.f5091Q = i + 1;
                            zArr[i] = true;
                            return;
                        }
                        return;
                    }
                    list.clear();
                    m8737c(locationData, (List) list);
                    return;
                }
            }
            return;
        }
        m8759h(locationData);
    }

    private void m8728b(LocationData locationData, List<LocationData> list) {
        if (m8721b(this.f5093S, (LocationData) list.get(0)) > m8721b(this.f5093S, (LocationData) list.get(1)) * 3.0f) {
            list.remove(0);
            boolean[] zArr = this.f5092R;
            int i = this.f5091Q - 1;
            this.f5091Q = i;
            zArr[i] = false;
            if (this.f5111l) {
                m8766j(m8762i(this.f5093S));
                this.ad = locationData.time;
                m8766j(m8762i((LocationData) list.get(0)));
                m8717a((List) list, true);
            }
            this.f5113n = true;
        }
    }

    private void m8715a(List<LocationData> list) {
        this.ad = ((LocationData) list.get(0)).time;
        if (this.f5111l) {
            m8766j(m8762i((LocationData) list.get(0)));
            this.ad = ((LocationData) list.get(1)).time;
            m8766j(m8762i((LocationData) list.get(1)));
            list.clear();
            this.f5112m = true;
        }
    }

    private void m8716a(List<LocationData> list, LocationData locationData) {
        this.f5094T++;
        this.f5093S.lat = ((this.f5093S.lat * ((double) this.f5094T)) + ((LocationData) list.get(1)).lat) / ((double) (this.f5094T + 1));
        this.f5093S.lon = ((this.f5093S.lon * ((double) this.f5094T)) + ((LocationData) list.get(1)).lon) / ((double) (this.f5094T + 1));
        this.ad = locationData.time;
        this.ac = locationData.time;
        list.clear();
        if (this.f5111l) {
            m8766j(m8762i(this.f5093S));
            this.f5094T = 0;
            this.f5112m = true;
        }
    }

    private void m8731b(List<LocationData> list, LocationData locationData) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "========time=====" + locationData.time);
        this.f5094T++;
        this.f5093S.lat = ((this.f5093S.lat * ((double) this.f5094T)) + locationData.lat) / ((double) (this.f5094T + 1));
        this.f5093S.lon = ((this.f5093S.lon * ((double) this.f5094T)) + locationData.lon) / ((double) (this.f5094T + 1));
        if (this.f5091Q > 0) {
            this.f5092R[this.f5091Q - 1] = false;
            this.f5091Q = 0;
        }
        if (list != null) {
            list.clear();
        }
        this.ad = locationData.time;
        this.ac = locationData.time;
    }

    private void m8757g(LocationData locationData) {
        this.f5093S = locationData;
        this.ad = locationData.time;
        this.ac = locationData.time;
    }

    private void m8759h(LocationData locationData) {
        if (this.f5111l && !this.f5092R[1]) {
            if (this.f5092R[0]) {
                float a = m8693a(m8721b(this.f5093S, locationData), this.ac, locationData.time);
                this.f5092R[0] = false;
                if (a <= 42.0f) {
                    m8766j(m8762i(this.f5093S));
                    this.ad = locationData.time;
                    m8766j(m8762i(locationData));
                } else {
                    this.ad = locationData.time;
                    m8766j(m8762i(this.f5093S));
                }
            } else {
                m8766j(m8762i(this.f5093S));
            }
            this.f5091Q = 0;
            this.f5094T = 0;
        }
    }

    private void m8737c(LocationData locationData, List<LocationData> list) {
        if (this.af != null) {
            this.af.add(locationData);
            if (3 == this.af.size()) {
                LocationData locationData2 = (LocationData) this.af.get(0);
                LocationData locationData3 = (LocationData) this.af.get(1);
                LocationData locationData4 = (LocationData) this.af.get(2);
                float b = m8721b(locationData2, locationData3);
                float b2 = m8721b(locationData2, locationData4);
                float a = m8693a(b, locationData2.time, locationData3.time);
                float a2 = m8693a(b2, locationData2.time, locationData4.time);
                if (a <= 42.0f && a2 <= 42.0f) {
                    m8717a((List) list, true);
                    m8746d(locationData2, (List) list);
                } else if (a <= 42.0f || a >= 100.0f || a2 <= 42.0f || a2 >= 100.0f) {
                    if (this.f5111l) {
                        m8717a((List) list, true);
                        this.ad = locationData.time;
                        m8766j(m8762i(this.f5093S));
                    }
                    this.af.clear();
                } else {
                    m8717a((List) list, true);
                    m8703a(locationData2, locationData3, locationData4, list);
                }
            } else if (this.f5111l) {
                if (list == null || list.size() != 1 || !this.f5092R[0] || this.f5092R[1]) {
                    this.ad = locationData.time;
                    m8766j(m8762i(this.f5093S));
                } else {
                    m8766j(m8762i(this.f5093S));
                    this.ad = locationData.time;
                    m8766j(m8762i((LocationData) list.get(0)));
                }
                m8717a((List) list, true);
                this.af.clear();
            }
        }
    }

    private void m8717a(List<LocationData> list, boolean z) {
        this.f5091Q = 0;
        this.f5094T = 0;
        this.f5092R[0] = false;
        this.f5092R[1] = false;
        if (z && list != null) {
            list.clear();
        }
    }

    private void m8746d(LocationData locationData, List<LocationData> list) {
        m8766j(m8762i(this.f5093S));
        this.f5093S = locationData;
        this.ac = locationData.time;
        this.ad = this.ac;
        C2538c.m12674b("KIDWATCH_TrackActivity", "===throwHighSpeed=====lonPreLocationTime=====" + this.ac);
        for (int i = 1; i < this.af.size(); i++) {
            m8706a((LocationData) this.af.get(i), (List) list);
        }
    }

    private void m8703a(LocationData locationData, LocationData locationData2, LocationData locationData3, List<LocationData> list) {
        m8766j(m8762i(this.f5093S));
        this.ad = locationData.time;
        m8766j(m8762i(locationData));
        this.f5093S = locationData2;
        this.ac = locationData2.time;
        this.ad = this.ac;
        if (this.af != null) {
            this.af.clear();
        } else {
            this.af = new ArrayList();
        }
        C2538c.m12674b("KIDWATCH_TrackActivity", "===throwHighSpeed=====lonPreLocationTime02=====" + this.ac);
        m8706a(locationData3, (List) list);
    }

    private float m8721b(LocationData locationData, LocationData locationData2) {
        return AMapUtils.calculateLineDistance(new LatLng(locationData.lat, locationData.lon), new LatLng(locationData2.lat, locationData2.lon));
    }

    private float m8693a(float f, long j, long j2) {
        return f / ((float) ((j2 / 1000) - (j / 1000)));
    }

    private LocationData m8762i(LocationData locationData) {
        LocationData locationData2 = new LocationData();
        locationData2.time = locationData.time;
        locationData2.lat = locationData.lat;
        locationData2.lon = locationData.lon;
        locationData2.elev = locationData.elev;
        locationData2.hacc = locationData.hacc;
        locationData2.name = locationData.name;
        locationData2.radius = locationData.radius;
        locationData2.type = locationData.type;
        locationData2.endTime = String.valueOf(this.ad);
        return locationData2;
    }

    private void m8766j(LocationData locationData) {
        if (this.ao != null) {
            this.ao.add(locationData);
        }
    }

    private void m8705a(LocationData locationData, String str) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "========date=====" + str);
        locationData.lon = m8719b(locationData.lon);
        locationData.lat = m8719b(locationData.lat);
        locationData.data1 = "0";
        locationData.data2 = "false";
        C1408x c1408x = new C1408x();
        c1408x.f3190d = C1492l.m6920d(C1462f.m6746j());
        c1408x.f3187a = str;
        c1408x.f3188b = String.valueOf(locationData.time);
        c1408x.f3189c = locationData.lon;
        c1408x.f3191e = locationData.lat;
        c1408x.f3194h = locationData.name;
        c1408x.f3195i = locationData.radius;
        c1408x.f3196j = locationData.type;
        c1408x.f3199m = locationData.endTime;
        c1408x.f3200n = locationData.data1;
        c1408x.f3201o = locationData.data2;
        if (1 == this.f5109j) {
            if (!str.equals(C1485e.m6867d(new Date()))) {
                this.f5079E.add(locationData);
                this.f5080F.add(new LatLonPoint(locationData.lat, locationData.lon));
                C1392h.m6267a(this.f5101b, c1408x);
            } else if (locationData.time <= System.currentTimeMillis()) {
                this.f5079E.add(locationData);
                this.f5080F.add(new LatLonPoint(locationData.lat, locationData.lon));
                C1392h.m6267a(this.f5101b, c1408x);
            }
        } else if (2 == this.f5109j) {
            C1392h.m6267a(this.f5101b, c1408x);
        }
    }

    private double m8719b(double d) {
        if (String.valueOf(d).split("\\.")[1].length() > 6) {
            return new BigDecimal(d).setScale(6, 4).doubleValue();
        }
        return d;
    }

    private void m8697a(double d, double d2, long j) {
        C1408x c1408x = new C1408x();
        c1408x.f3190d = C1492l.m6920d(C1462f.m6746j());
        c1408x.f3187a = this.f5115p;
        c1408x.f3188b = String.valueOf(j);
        c1408x.f3189c = d;
        c1408x.f3191e = d2;
        c1408x.f3200n = "1";
        c1408x.f3201o = "true";
        C1392h.m6267a(this.f5101b, c1408x);
    }
}
