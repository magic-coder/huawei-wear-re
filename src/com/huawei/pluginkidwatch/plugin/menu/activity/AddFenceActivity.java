package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.android.volley.DefaultRetryPolicy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.b;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.AddFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;
import com.huawei.pluginkidwatch.common.lib.p148c.C1468c;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.button.C1520i;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.title.CustomTitle;
import com.huawei.pluginkidwatch.common.ui.view.WaitingLineView;
import com.huawei.pluginkidwatch.common.ui.view.ad;
import com.huawei.pluginkidwatch.common.ui.view.seekbar.SectionSeekBar;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1901r;
import com.huawei.pluginkidwatch.plugin.menu.view.C1857c;
import com.huawei.pluginkidwatch.plugin.menu.view.FenceAddressEditText;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

public class AddFenceActivity extends KidWatchBaseActivity implements AMapLocationListener, OnPoiSearchListener {
    private final int f5416A = 10;
    private int f5417B = 289;
    private Context f5418C;
    private LatLng f5419D;
    private LocationManagerProxy f5420E;
    private String f5421F = "";
    private ProgressDialog f5422G = null;
    private PoiResult f5423H;
    private int f5424I = 0;
    private Query f5425J;
    private C1520i f5426K;
    private boolean f5427L = false;
    private FenceItem f5428M = null;
    private PoiSearch f5429N;
    private CustomTitle f5430O;
    private boolean f5431P = false;
    private final int f5432Q = 10000;
    private String f5433R = "010";
    private final int f5434S = 73;
    private boolean f5435T = true;
    private final int f5436U = SyslogAppender.LOG_LOCAL1;
    private C1507h f5437V = null;
    private TextView f5438W;
    private TextView f5439X;
    private TextView f5440Y;
    private DisplayMetrics f5441Z;
    private Animation aa;
    private WaitingLineView ab;
    private OnGeocodeSearchListener ac = new ad(this);
    private C1857c ad = new ae(this);
    private OnClickListener ae = new af(this);
    private OnMapClickListener af = new ah(this);
    private CancelableCallback ag = new aj(this);
    private CancelableCallback ah = new ak(this);
    private ad ai = new C1881w(this);
    private Runnable aj = new C1883y(this);
    private Runnable ak = new ab(this);
    private Handler al = new ac(this);
    boolean f5442b = false;
    boolean f5443c = false;
    boolean f5444d = false;
    private MapView f5445e;
    private AMap f5446f;
    private SectionSeekBar f5447g;
    private C1413d f5448h;
    private Gson f5449i;
    private Marker f5450j;
    private ImageButton f5451k;
    private ImageButton f5452l;
    private FenceAddressEditText f5453m;
    private boolean f5454n = true;
    private int f5455o = 0;
    private boolean f5456p = false;
    private EditText f5457q;
    private TextView f5458r;
    private final int f5459s = 200;
    private LinearLayout f5460t;
    private final double f5461u = 300.0d;
    private LatLng f5462v = null;
    private GeocodeSearch f5463w;
    private Circle f5464x = null;
    private int f5465y = 300;
    private final int f5466z = 34;

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        setContentView(h.activity_create_fence);
        this.f5445e = (MapView) findViewById(g.menu_elec_fence_add_map);
        this.f5445e.onCreate(bundle);
        super.onCreate(bundle);
    }

    protected void mo2517a() {
        JsonSyntaxException jsonSyntaxException;
        JsonSyntaxException jsonSyntaxException2;
        Interpolator linearInterpolator;
        C2538c.m12674b("AddFenceActivity", "==================Enter initView()");
        this.f5449i = new Gson();
        this.f5418C = this;
        this.f5441Z = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(this.f5441Z);
        Intent intent = getIntent();
        this.f5430O = (CustomTitle) findViewById(g.menu_elec_create_fence_title);
        this.ab = (WaitingLineView) findViewById(g.menu_add_fence_wait_line);
        C2538c.m12674b("AddFenceActivity", "====www==============isFromEditButton" + intent.getBooleanExtra("menu_edit_elec_fence_flag", false));
        if (intent.getBooleanExtra("menu_edit_elec_fence_flag", false)) {
            Object obj;
            this.f5427L = true;
            Object obj2 = null;
            try {
                String stringExtra = intent.getStringExtra("menu_edit_elec_fence");
                try {
                    C2538c.m12674b("AddFenceActivity", "====www=========MENU_EDIT_ELEC_FENCE" + stringExtra);
                    if (stringExtra != null) {
                        this.f5428M = (FenceItem) this.f5449i.fromJson(stringExtra, FenceItem.class);
                    }
                    obj = stringExtra;
                } catch (JsonSyntaxException e) {
                    jsonSyntaxException = e;
                    String str = stringExtra;
                    jsonSyntaxException2 = jsonSyntaxException;
                    C2538c.m12674b("AddFenceActivity", jsonSyntaxException2.getMessage());
                    this.f5430O.setTitleLabel(C1680l.IDS_plugin_kidwatch_menu_electronic_edit_fence);
                    C2538c.m12674b("AddFenceActivity", "==================json:", obj);
                    this.f5448h = C1417a.m6594a(getApplicationContext());
                    this.f5460t = (LinearLayout) findViewById(g.menu_elec_new_fence_choose_name);
                    this.f5451k = (ImageButton) findViewById(g.menu_elec_new_fence_getposition);
                    this.f5452l = (ImageButton) findViewById(g.menu_elec_new_fence_searchpoi);
                    this.f5457q = (EditText) findViewById(g.menu_elec_new_fence_name_content);
                    this.f5458r = (TextView) findViewById(g.menu_fence_tv_range);
                    this.f5453m = (FenceAddressEditText) findViewById(g.menu_elec_new_fence_address_content);
                    this.f5447g = (SectionSeekBar) findViewById(g.menu_elec_fence_seekBar);
                    this.f5426K = this.f5430O.getMenuBt();
                    this.f5451k.setOnClickListener(this.ae);
                    this.f5452l.setOnClickListener(this.ae);
                    this.f5463w = new GeocodeSearch(this);
                    ServiceSettings.getInstance().setProtocol(2);
                    this.f5460t.setOnClickListener(new C1880v(this));
                    this.f5453m.setAddressFocusChandeListener(this.ad);
                    this.f5463w.setOnGeocodeSearchListener(this.ac);
                    m9042f();
                    this.f5447g.setOnChangeProgessListener(this.ai);
                    this.aa = AnimationUtils.loadAnimation(this, b.roal);
                    linearInterpolator = new LinearInterpolator();
                    if (this.aa == null) {
                        this.aa.setInterpolator(linearInterpolator);
                    }
                }
            } catch (JsonSyntaxException e2) {
                jsonSyntaxException = e2;
                obj = obj2;
                jsonSyntaxException2 = jsonSyntaxException;
                C2538c.m12674b("AddFenceActivity", jsonSyntaxException2.getMessage());
                this.f5430O.setTitleLabel(C1680l.IDS_plugin_kidwatch_menu_electronic_edit_fence);
                C2538c.m12674b("AddFenceActivity", "==================json:", obj);
                this.f5448h = C1417a.m6594a(getApplicationContext());
                this.f5460t = (LinearLayout) findViewById(g.menu_elec_new_fence_choose_name);
                this.f5451k = (ImageButton) findViewById(g.menu_elec_new_fence_getposition);
                this.f5452l = (ImageButton) findViewById(g.menu_elec_new_fence_searchpoi);
                this.f5457q = (EditText) findViewById(g.menu_elec_new_fence_name_content);
                this.f5458r = (TextView) findViewById(g.menu_fence_tv_range);
                this.f5453m = (FenceAddressEditText) findViewById(g.menu_elec_new_fence_address_content);
                this.f5447g = (SectionSeekBar) findViewById(g.menu_elec_fence_seekBar);
                this.f5426K = this.f5430O.getMenuBt();
                this.f5451k.setOnClickListener(this.ae);
                this.f5452l.setOnClickListener(this.ae);
                this.f5463w = new GeocodeSearch(this);
                ServiceSettings.getInstance().setProtocol(2);
                this.f5460t.setOnClickListener(new C1880v(this));
                this.f5453m.setAddressFocusChandeListener(this.ad);
                this.f5463w.setOnGeocodeSearchListener(this.ac);
                m9042f();
                this.f5447g.setOnChangeProgessListener(this.ai);
                this.aa = AnimationUtils.loadAnimation(this, b.roal);
                linearInterpolator = new LinearInterpolator();
                if (this.aa == null) {
                    this.aa.setInterpolator(linearInterpolator);
                }
            }
            this.f5430O.setTitleLabel(C1680l.IDS_plugin_kidwatch_menu_electronic_edit_fence);
            C2538c.m12674b("AddFenceActivity", "==================json:", obj);
        }
        this.f5448h = C1417a.m6594a(getApplicationContext());
        this.f5460t = (LinearLayout) findViewById(g.menu_elec_new_fence_choose_name);
        this.f5451k = (ImageButton) findViewById(g.menu_elec_new_fence_getposition);
        this.f5452l = (ImageButton) findViewById(g.menu_elec_new_fence_searchpoi);
        this.f5457q = (EditText) findViewById(g.menu_elec_new_fence_name_content);
        this.f5458r = (TextView) findViewById(g.menu_fence_tv_range);
        this.f5453m = (FenceAddressEditText) findViewById(g.menu_elec_new_fence_address_content);
        this.f5447g = (SectionSeekBar) findViewById(g.menu_elec_fence_seekBar);
        this.f5426K = this.f5430O.getMenuBt();
        this.f5451k.setOnClickListener(this.ae);
        this.f5452l.setOnClickListener(this.ae);
        this.f5463w = new GeocodeSearch(this);
        ServiceSettings.getInstance().setProtocol(2);
        this.f5460t.setOnClickListener(new C1880v(this));
        this.f5453m.setAddressFocusChandeListener(this.ad);
        this.f5463w.setOnGeocodeSearchListener(this.ac);
        m9042f();
        this.f5447g.setOnChangeProgessListener(this.ai);
        this.aa = AnimationUtils.loadAnimation(this, b.roal);
        linearInterpolator = new LinearInterpolator();
        if (this.aa == null) {
            this.aa.setInterpolator(linearInterpolator);
        }
    }

    private void m9042f() {
        C2538c.m12674b("AddFenceActivity", "==================Enter setUpMap()");
        if (this.f5446f == null) {
            this.f5446f = this.f5445e.getMap();
            this.f5446f.setOnMapClickListener(this.af);
            this.f5446f.getUiSettings().setZoomControlsEnabled(false);
            this.f5446f.getUiSettings().setRotateGesturesEnabled(false);
            this.f5446f.setOnCameraChangeListener(new ag(this));
        }
        if (this.f5427L) {
            C2538c.m12674b("AddFenceActivity", "==================Edit fence");
            this.f5465y = this.f5428M.getmFenceRadius();
            C2538c.m12674b("AddFenceActivity", "==================editFenceItem.mFenceRadius-modify:", (this.f5428M.getmFenceRadius() - 200) + "");
            if (this.f5428M.getmFenceRadius() < 300) {
                this.f5428M.setmFenceRadius(300);
                this.f5465y = this.f5428M.getmFenceRadius();
            }
            this.f5447g.setRealProgess(this.f5428M.getmFenceRadius());
            this.f5419D = new LatLng(this.f5428M.getLat(), this.f5428M.getLon());
            this.f5462v = this.f5419D;
            m9035b(this.f5419D, this.f5465y, false);
            this.f5453m.setText(this.f5428M.getmFenceAddress());
            this.f5457q.setText(this.f5428M.getmFenceName());
        } else {
            this.f5457q.requestFocus();
            this.f5447g.setProgress(0);
            C2538c.m12674b("AddFenceActivity", "==================Add fence");
        }
        Message message = new Message();
        message.what = 10000;
        this.al.sendMessage(message);
        if (!this.f5427L) {
            m9070a(true);
        }
        C2538c.m12674b("AddFenceActivity", "==================Leave setUpMap()");
    }

    private void m9025a(LatLonPoint latLonPoint) {
        C2538c.m12674b("AddFenceActivity", "==================Enter getAddress()");
        this.f5463w.getFromLocationAsyn(new RegeocodeQuery(latLonPoint, 200.0f, GeocodeSearch.AMAP));
    }

    private void m9045g() {
        this.f5451k.clearAnimation();
        this.f5451k.setClickable(true);
        if (this.f5420E != null) {
            this.f5420E.removeUpdates((AMapLocationListener) this);
            this.f5420E.destroy();
        }
        this.f5420E = null;
    }

    private void m9023a(LatLng latLng) {
        m9025a(new LatLonPoint(latLng.latitude, latLng.longitude));
        this.f5457q.clearFocus();
        this.f5453m.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            this.f5457q.clearFocus();
            this.f5453m.clearFocus();
        }
    }

    private void m9034b(LatLng latLng) {
        C2538c.m12674b("AddFenceActivity", "==================Enter moveCircle()");
        if (latLng != null) {
            if (this.f5464x != null) {
                this.f5464x.remove();
            }
            C2538c.m12674b("AddFenceActivity", "==================radius:", this.f5465y + "");
            this.f5464x = this.f5446f.addCircle(new CircleOptions().center(latLng).radius((double) this.f5465y).strokeColor(Color.rgb(58, 180, 231)).strokeWidth(3.0f).fillColor(getResources().getColor(d.menu_elec_fence_color_bg)));
        }
    }

    private void m9024a(LatLng latLng, int i, boolean z) {
        C2538c.m12674b("AddFenceActivity", "==================Enter moveToPosition()");
        this.f5453m.clearFocus();
        if (this.f5446f == null || latLng == null) {
            C2538c.m12674b("AddFenceActivity", "=================null == latLng");
            return;
        }
        if (z) {
            this.f5450j.setPosition(latLng);
        }
        this.f5446f.animateCamera(CameraUpdateFactory.changeLatLng(latLng), (long) i, new ai(this));
    }

    public void onLocationChanged(Location location) {
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void m9070a(boolean z) {
        String b = C1497q.m6945b(this.f5418C, "save_fence_map_last_app_position", "");
        try {
            if ("".equals(b)) {
                b = C1497q.m6945b(this.f5418C, "main_map_last_app_position", "");
                if (!"".equals(b)) {
                    this.f5462v = (LatLng) this.f5449i.fromJson(b, LatLng.class);
                    m9035b(this.f5462v, this.f5465y, true);
                    m9053k();
                    return;
                } else if (z) {
                    m9053k();
                    return;
                } else {
                    this.f5462v = C1468c.f3413a;
                    m9035b(this.f5462v, this.f5465y, false);
                    this.f5453m.setText("");
                    return;
                }
            }
            this.f5462v = (LatLng) this.f5449i.fromJson(b, LatLng.class);
            m9035b(this.f5462v, this.f5465y, true);
        } catch (JsonSyntaxException e) {
            this.f5462v = null;
            C2538c.m12680e("AddFenceActivity", "Exception e = " + e.getMessage());
            if (z) {
                m9053k();
                return;
            }
            this.f5462v = C1468c.f3413a;
            m9035b(this.f5462v, this.f5465y, false);
            this.f5453m.setText("");
        }
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (this.f5444d) {
                this.f5444d = true;
            }
            Double valueOf = Double.valueOf(aMapLocation.getLatitude());
            Double valueOf2 = Double.valueOf(aMapLocation.getLongitude());
            if (valueOf2.doubleValue() <= 73.0d || valueOf2.doubleValue() >= 136.0d) {
                m9070a(false);
                C2538c.m12680e("AddFenceActivity", "==========网络定位 失败");
            } else {
                C2538c.m12674b("AddFenceActivity", "==========网络定位到app当前位置成功");
                this.f5462v = new LatLng(valueOf.doubleValue(), valueOf2.doubleValue());
                C2538c.m12674b("AddFenceActivity", "=========电子围栏保存最后一次定位的位置：", this.f5449i.toJson(this.f5462v));
                C1497q.m6943a(this.f5418C, "save_fence_map_last_app_position", r0);
                m9035b(this.f5462v, this.f5465y, true);
                C1497q.m6943a(this.f5418C, "menu_last_city_phone", aMapLocation.getCity());
                C2538c.m12674b("AddFenceActivity", "==========location.getCity()：" + aMapLocation.getCity());
            }
        } else {
            C2538c.m12674b("AddFenceActivity", "==========网络定位手机位置失败，显示");
            m9070a(false);
        }
        this.f5442b = false;
        this.al.removeCallbacks(this.ak);
        m9045g();
    }

    private void m9035b(LatLng latLng, int i, boolean z) {
        C2538c.m12674b("AddFenceActivity", "==========Enter showDefaultElecFence");
        if (isFinishing()) {
            C2538c.m12674b("AddFenceActivity", "==========AddFenceActivity.this.isFinishing()");
            return;
        }
        int a = C1492l.m6901a(this.f5418C, (float) BitmapDescriptorFactory.HUE_ORANGE);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.draggable(false);
        markerOptions.position(latLng);
        markerOptions.anchor(0.5f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(C1492l.m6904a(BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_elec_fence_center), (double) a, ((double) a) * 1.2272727272727273d)));
        if (this.f5450j != null) {
            this.f5450j.remove();
        }
        this.f5450j = this.f5446f.addMarker(markerOptions);
        m9034b(latLng);
        m9024a(latLng, 500, true);
        LatLng position = this.f5450j.getPosition();
        if (z) {
            m9025a(new LatLonPoint(position.latitude, position.longitude));
        }
    }

    public void onSaveClick(View view) {
        C2538c.m12674b("AddFenceActivity", "==========onSaveClick()");
        if (this.f5457q.getText().toString().trim().length() < 1) {
            C1483c.m6824a(this.f5418C, C1680l.IDS_plugin_kidwatch_menu_electronic_fence_input_name);
        } else if (this.f5443c) {
            C1483c.m6824a(getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_electronic_fence_carameing);
        } else if (this.f5444d) {
            C1483c.m6824a(getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_electronic_fence_carameing);
        } else if (this.f5442b) {
            C1483c.m6824a(getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_electronic_fence_positionbymobileNet);
        } else if (this.f5453m.getText() == null || "".equals(this.f5453m.getText().toString())) {
            C1483c.m6824a(getApplicationContext(), C1680l.IDS_plugin_kidwatch_menu_electronic_fence_input_address);
        } else if (this.f5453m.m9713a()) {
            C2538c.m12674b("AddFenceActivity", "手动输入改变了地址信息，需要搜索热点区域进行匹配......");
            this.f5454n = false;
            mo2518d();
        } else {
            m9047h();
        }
    }

    private void m9047h() {
        if (this.f5431P) {
            C2538c.m12674b("AddFenceActivity", "==========正在保存当中，不能连续进行保存");
            return;
        }
        C2538c.m12674b("AddFenceActivity", "==========将保存按钮置为不可点击");
        this.f5426K.setClickable(false);
        C2538c.m12674b("AddFenceActivity", "==========保存电子围栏");
        this.f5431P = true;
        AddFenceIOEntityModel addFenceIOEntityModel = new AddFenceIOEntityModel();
        if (this.f5427L) {
            addFenceIOEntityModel.fenceId = this.f5428M.getmFenceId();
        } else {
            addFenceIOEntityModel.fenceId = null;
        }
        addFenceIOEntityModel.deviceCode = C1462f.m6746j();
        addFenceIOEntityModel.name = this.f5457q.getText().toString().trim();
        addFenceIOEntityModel.fenceRange = "" + this.f5450j.getPosition().latitude + "," + this.f5450j.getPosition().longitude + "," + this.f5465y;
        addFenceIOEntityModel.type = 1;
        addFenceIOEntityModel.isActive = "1";
        addFenceIOEntityModel.locationName = this.f5453m.getText().toString().trim();
        this.ab.setVisibility(0);
        this.ab.m7206a(true);
        this.f5448h.mo2468a(addFenceIOEntityModel, new C1882x(this));
    }

    protected void onResume() {
        super.onResume();
        this.f5445e.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.f5445e.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f5445e.onDestroy();
    }

    public void mo2518d() {
        C2538c.m12674b("AddFenceActivity", "================== Enter searchButton() ");
        this.f5421F = C1497q.m6945b(this.f5418C, "menu_last_city_phone", this.f5433R);
        C2538c.m12674b("AddFenceActivity", "================== currentCity: " + this.f5421F);
        mo2519e();
    }

    protected void mo2519e() {
        C2538c.m12674b("AddFenceActivity", "================== Enter doSearchQuery() ");
        m9049i();
        this.f5424I = 0;
        this.f5425J = new Query(this.f5453m.getText().toString(), "", this.f5421F);
        this.f5425J.setPageSize(10);
        this.f5425J.setPageNum(this.f5424I);
        this.f5429N = new PoiSearch(this, this.f5425J);
        this.f5429N.setOnPoiSearchListener(this);
        this.f5429N.searchPOIAsyn();
    }

    public void onPoiItemDetailSearched(PoiItemDetail poiItemDetail, int i) {
    }

    public void onPoiSearched(PoiResult poiResult, int i) {
        m9051j();
        if (i != 0) {
            C1483c.m6824a(this.f5418C, C1680l.IDS_plugin_kidwatch_menu_electronic_fence_alert_no_result);
        } else if (poiResult == null || poiResult.getQuery() == null) {
            C1483c.m6824a(this.f5418C, C1680l.IDS_plugin_kidwatch_menu_electronic_fence_alert_no_result);
        } else if (poiResult.getQuery().equals(this.f5425J)) {
            this.f5423H = poiResult;
            List pois = this.f5423H.getPois();
            if (pois == null || pois.size() <= 0) {
                C1483c.m6824a(this.f5418C, C1680l.IDS_plugin_kidwatch_menu_electronic_fence_alert_no_result);
                return;
            }
            C1901r.m9677a(pois);
            Intent intent = new Intent();
            intent.setClass(this.f5418C, PoiListActivity.class);
            startActivityForResult(intent, 0);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f5453m.clearFocus();
        if (i == 0) {
            int intExtra = intent.getIntExtra("menu_elec_selected_position", -1);
            if (intExtra < 0) {
                C2538c.m12674b("AddFenceActivity", "==========没有选择任何一个poi点");
                return;
            }
            C2538c.m12674b("AddFenceActivity", "==========选择的地点需要是index：  ", intExtra + "");
            C2538c.m12674b("AddFenceActivity", "==========选择的地点需要是：  ", ((PoiItem) C1901r.m9676a().get(intExtra)).toString() + "");
            LatLonPoint latLonPoint = r0.getLatLonPoint();
            if (!this.f5454n) {
                this.f5456p = false;
            }
            m9025a(latLonPoint);
            this.f5462v = new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
            m9024a(this.f5462v, 1, true);
            m9034b(this.f5462v);
            if (!this.f5454n) {
                this.f5454n = true;
                this.al.postDelayed(this.aj, 1000);
            }
        }
    }

    private void m9049i() {
        C2538c.m12674b("AddFenceActivity", "================== Enter showProgressDialog() ");
        if (this.f5422G == null) {
            this.f5422G = new ProgressDialog(this);
        }
        this.f5422G.setProgressStyle(0);
        this.f5422G.setIndeterminate(false);
        this.f5422G.setCancelable(false);
        this.f5422G.setMessage(getResources().getString(C1680l.IDS_plugin_kidwatch_common_searching) + "\n");
        this.f5422G.show();
    }

    private void m9051j() {
        if (this.f5422G != null) {
            this.f5422G.dismiss();
        }
    }

    private void m9053k() {
        C2538c.m12674b("AddFenceActivity", "===========Enter getPositionByMobileNet");
        this.al.postDelayed(this.ak, 10000);
        this.f5420E = LocationManagerProxy.getInstance((Activity) this);
        if (this.f5420E != null) {
            this.f5420E.requestLocationData(LocationProviderProxy.AMapNetwork, 200, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this);
        }
    }

    private void m9055l() {
        C2538c.m12674b("AddFenceActivity", "==========Enter showChooseNameDialog");
        C2538c.m12674b("AddFenceActivity", "openChoosePhotoDialog");
        if (this.f5437V == null) {
            this.f5437V = new C1507h(this.f5418C, SdkConstants.REQUEST_CAMERA_VIDEO, 100, h.dialog_choose_head_image_list, m.servicedialog, true);
        }
        this.f5437V.show();
        this.f5438W = (TextView) this.f5437V.findViewById(g.profile_setting_take_photo);
        this.f5439X = (TextView) this.f5437V.findViewById(g.profile_setting_choose_from_default);
        this.f5440Y = (TextView) this.f5437V.findViewById(g.profile_setting_choose_from_phone);
        this.f5439X.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_home));
        this.f5438W.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_school));
        this.f5440Y.setVisibility(8);
        this.f5439X.setOnClickListener(new C1884z(this));
        this.f5438W.setOnClickListener(new aa(this));
    }

    private void m9026a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C2538c.m12674b("AddFenceActivity", "===========Enter onTouchEvent");
        this.f5457q.clearFocus();
        this.f5453m.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!(motionEvent.getAction() != 0 || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null)) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            this.f5457q.clearFocus();
        }
        return super.onTouchEvent(motionEvent);
    }
}
