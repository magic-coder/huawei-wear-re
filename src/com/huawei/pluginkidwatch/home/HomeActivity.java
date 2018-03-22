package com.huawei.pluginkidwatch.home;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.android.volley.DefaultRetryPolicy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwcloudmodel.mgr.HwWearPushReceiver;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwcommonmodel.datatypes.j;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.l.a.c;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.b;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceInfosIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateOModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceProfile;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceProfileRetModel;
import com.huawei.pluginkidwatch.common.entity.model.GetRewardInfoRetModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.LocationData;
import com.huawei.pluginkidwatch.common.entity.model.RewardGoal;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatus;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.entity.p143c.C1446a;
import com.huawei.pluginkidwatch.common.entity.p143c.C1448c;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.p148c.C1468c;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.p138a.ac;
import com.huawei.pluginkidwatch.common.p138a.ad;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.listview.C1522b;
import com.huawei.pluginkidwatch.common.ui.listview.C1529i;
import com.huawei.pluginkidwatch.common.ui.listview.PariedDevicesSwitcher;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.AlwaysMarqueeScrollView;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.C1599z;
import com.huawei.pluginkidwatch.common.ui.view.CustomCircleProgress;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.home.p151a.C1618a;
import com.huawei.pluginkidwatch.home.p156b.C1621a;
import com.huawei.pluginkidwatch.home.p156b.C1638r;
import com.huawei.pluginkidwatch.home.p156b.C1642v;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.AntilossActivity;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.AntilossPopupDialogActivity;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.service.KidWatchService;
import com.huawei.pluginkidwatch.plugin.p152a.C1723d;
import com.huawei.pluginkidwatch.plugin.p152a.C1743x;
import com.huawei.pluginkidwatch.plugin.setting.activity.RewardActivity;
import com.huawei.pluginkidwatch.plugin.setting.activity.SetRewardGoalActivity;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.main.stories.about.p179a.C2279a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.ui.main.stories.nps.interactors.C2442a;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import net.sqlcipher.database.SQLiteDatabase;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.net.SyslogAppender;

public class HomeActivity extends KidWatchBaseActivity implements Callback, OnRequestPermissionsResultCallback, OnClickListener, AMapLocationListener, InfoWindowAdapter, OnCameraChangeListener, OnMapClickListener, OnMapLoadedListener, OnMarkerClickListener {
    private static boolean aB = true;
    private static boolean bt = false;
    private static String[] cd = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
    static boolean f4103g = false;
    private TextView f4104A;
    private LinearLayout f4105B;
    private LinearLayout f4106C;
    private LocationManagerProxy f4107D;
    private MarkerOptions f4108E;
    private Context f4109F;
    private final int f4110G = 10000;
    private LinearLayout f4111H;
    private LinearLayout f4112I;
    private LinearLayout f4113J;
    private RelativeLayout f4114K;
    private RelativeLayout f4115L;
    private RelativeLayout f4116M;
    private RelativeLayout f4117N;
    private RelativeLayout f4118O;
    private RelativeLayout f4119P;
    private Button f4120Q;
    private ImageView f4121R = null;
    private Animation f4122S = null;
    private Animation f4123T = null;
    private boolean f4124U = false;
    private ImageButton f4125V;
    private boolean f4126W = false;
    private Bitmap f4127X = null;
    private Marker f4128Y;
    private Marker f4129Z;
    private Toast aA;
    private final int aC = SdkConstants.TIME_OUT;
    private final int aD = 5000;
    private final int aE = 10000;
    private DisplayMetrics aF;
    private final int aG = 73;
    private final int aH = SyslogAppender.LOG_LOCAL1;
    private final int aI = 32;
    private Animation aJ;
    private final int aK = 3;
    private ViewTreeObserver aL;
    private WatchStatus aM = null;
    private Gson aN = new Gson();
    private String aO = "";
    private String aP = "";
    private String aQ = "kidIndex";
    private ArrayList<C1395k> aR = new ArrayList();
    private ContentValues aS;
    private int aT = 500;
    private int aU = 10;
    private final int aV = 10;
    private final int aW = 50;
    private int aX = 0;
    private RewardGoal aY;
    private int aZ = -1;
    private float aa;
    private final String ab = "null";
    private C1565a ac = null;
    private final int ad = 33;
    private final int ae = 111;
    private final int af = 9999;
    private final int ag = 10002;
    private final int ah = HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE;
    private final int ai = 10004;
    private final int aj = MessageObserver.RET_AUTH_ERROR;
    private final int ak = HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION;
    private final int al = 10007;
    private final int am = MessageObserver.RET_CHECK_PARAM_ERROR;
    private final int an = 10009;
    private final int ao = 10010;
    private final int ap = 10060;
    private LinearLayout aq;
    private final int ar = 5;
    private final int as = 25;
    private final int at = 50;
    private final int au = 75;
    private final int av = 100;
    private final int aw = 300000;
    private final int ax = 86400000;
    private final long ay = 3600000;
    private final int az = 300000;
    public TextView f4130b;
    private final int bA = 3;
    private final int bB = 4;
    private Circle bC = null;
    private final String bD = "1";
    private final String bE = "0";
    private final String bF = "1";
    private final String bG = "0";
    private final int bH = 0;
    private final int bI = 2;
    private final int bJ = 3;
    private final int bK = 365;
    private final int bL = 5;
    private final int bM = 1;
    private LinearLayout bN;
    private Double bO;
    private Double bP;
    private String bQ;
    private Double bR;
    private Double bS;
    private C1507h bT = null;
    private LinearLayout bU;
    private LinearLayout bV;
    private LinearLayout bW;
    private CheckBox bX;
    private CheckBox bY;
    private TextView bZ;
    private Timer ba = null;
    private CustomDialog bb;
    private CustomDialog bc;
    private CustomDialog bd = null;
    private CustomDialog be = null;
    private CustomDialog bf = null;
    private CustomDialog bg = null;
    private BluetoothAdapter bh = BluetoothAdapter.getDefaultAdapter();
    private DrawerLayout bi;
    private FrameLayout bj;
    private FrameLayout bk;
    private ImageView bl;
    private ImageView bm;
    private ImageView bn;
    private TextView bo;
    private TextView bp;
    private AlwaysMarqueeScrollView bq;
    private boolean br = false;
    private boolean bs = false;
    private boolean bu = false;
    private ImageButton bv;
    private C1621a bw;
    private boolean bx = false;
    private final int by = 1;
    private final int bz = 2;
    public Handler f4131c;
    private long ca;
    private C2279a cb;
    private boolean cc = false;
    private AnimationListener ce = new C1657l(this);
    private AnimationListener cf = new C1676w(this);
    private DrawerListener cg = new ai(this);
    private C1529i ch = new bf(this);
    private OnClickListener ci = new C1646b(this);
    private Runnable cj = new C1648c(this);
    private Runnable ck = new C1649d(this);
    private Runnable cl = new C1650e(this);
    private Runnable cm = new C1651f(this);
    private Runnable cn = new C1652g(this);
    private Runnable co = new C1659n(this);
    private OnClickListener cp = new C1666q(this);
    private OnClickListener cq = new C1675v(this);
    private OnItemClickListener cr = new C1677x(this);
    private Runnable cs = new an(this);
    private final BroadcastReceiver ct = new ar(this);
    private OnClickListener cu = new au(this);
    private OnClickListener cv = new aw(this);
    private OnClickListener cw = new ax(this);
    private OnClickListener cx = new ay(this);
    private final BroadcastReceiver cy = new bb(this);
    public bo f4132d;
    public bu f4133e;
    public TextView f4134f;
    OnClickListener f4135h = new C1661p(this);
    CustomDialog f4136i = null;
    private int f4137j = 0;
    private String f4138k = "com.huawei.pluginkidwatch.home.HomeActivity";
    private C1413d f4139l;
    private MapView f4140m;
    private AMap f4141n;
    private BroadcastReceiver f4142o;
    private ReceiverAntilossAlarm f4143p;
    private LatLng f4144q = null;
    private int f4145r;
    private PariedDevicesSwitcher f4146s;
    private ListView f4147t = null;
    private ArrayList<C1522b> f4148u = null;
    private C1599z f4149v = null;
    private ImageButton f4150w;
    private ImageButton f4151x;
    private CustomCircleProgress f4152y;
    private boolean f4153z = false;

    public class ReceiverAntilossAlarm extends BroadcastReceiver {
        final /* synthetic */ HomeActivity f4102a;

        public ReceiverAntilossAlarm(HomeActivity homeActivity) {
            this.f4102a = homeActivity;
        }

        public void onReceive(Context context, Intent intent) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===================收到随行报警的广播 ");
            C2538c.m12674b("KIDWATCH_HomeActivity", "ReceiverAntilossAlarm action = " + intent.getAction());
            if (!this.f4102a.isFinishing() && "start.antiloss.alarm".equals(r0)) {
                this.f4102a.runOnUiThread(new bj(this));
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        setContentView(h.activity_k1_home);
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============Enter HomeActivity onCreate");
        if (C1642v.m7777a(this)) {
            this.bu = C1497q.m6937a((Context) this, "kidwatch_antiloss_state", false).booleanValue();
            C2538c.m12674b("KIDWATCH_HomeActivity", "===============onCreate Start KidWatchService  mAntilossState : " + this.bu);
            bt = true;
            startService(new Intent(getApplicationContext(), KidWatchService.class));
        }
        C1462f.m6737f();
        this.f4126W = true;
        this.f4109F = this;
        C1462f.m6716a(getApplicationContext());
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_from_notification", false)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========Come from notification");
            int intExtra = intent.getIntExtra("devicecode_from_notification", 0);
            if (intExtra != 0) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==========modify devicecode in sharedpreferences");
                C1497q.m6943a(this.f4109F, "sharedpreferences_watch_device_code", intExtra + "");
            }
        }
        this.aF = new DisplayMetrics();
        this.aS = new ContentValues();
        this.f4140m = (MapView) findViewById(g.map);
        this.f4140m.onCreate(bundle);
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========bind phoneService");
        this.aX = C1492l.m6901a(this.f4109F, 50.0f);
        ap();
        this.f4131c = new Handler(this);
        C1446a.m6678a(getApplicationContext()).m6679a();
        intent = new Intent();
        intent.setClassName(this.f4109F, "com.huawei.pluginkidwatch.home.K1PushService");
        intent.setPackage(this.f4109F.getPackageName());
        startService(intent);
        super.onCreate(bundle);
        if (this.bu) {
            C1497q.m6942a((Context) this, "kidwatch_antiloss_state", Boolean.valueOf(false));
            this.f4131c.sendEmptyMessage(10007);
        }
        this.cb = C2279a.m11722a();
        aI();
        if (!C1492l.m6913a((Context) this, cd)) {
            C1492l.m6910a((Activity) this, cd);
        }
    }

    protected void mo2517a() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "KIDWATCH_HomeActivity", "===============Enter initView");
        this.f4146s = (PariedDevicesSwitcher) findViewById(g.main_parieddevicesswitcher_kidname);
        this.f4146s.setOnSwitcherClickListener(this.ch);
        this.f4147t = this.f4146s.getListView();
        this.f4151x = (ImageButton) findViewById(g.main_imbt_right);
        this.f4151x.setOnClickListener(this.cp);
        this.f4130b = (TextView) findViewById(g.main_tv_menu_drawable);
        this.f4114K = (RelativeLayout) findViewById(g.main_relative_sport);
        this.f4115L = (RelativeLayout) findViewById(g.main_relative_chat);
        this.f4105B = (LinearLayout) findViewById(g.tips_lly);
        this.f4106C = (LinearLayout) findViewById(g.tips_lly_k2);
        this.f4120Q = (Button) findViewById(g.main_btn_call);
        this.f4116M = (RelativeLayout) findViewById(g.main_relative_call);
        this.f4117N = (RelativeLayout) findViewById(g.main_relative_Reward);
        this.f4118O = (RelativeLayout) findViewById(g.main_relative_track);
        this.f4119P = (RelativeLayout) findViewById(g.main_liner_bluetooth);
        this.f4121R = (ImageView) findViewById(g.main_btn_antiloss_ani);
        this.f4125V = (ImageButton) findViewById(g.main_btn_antiloss);
        this.f4150w = (ImageButton) findViewById(g.main_imbt_menu);
        this.bm = (ImageView) findViewById(g.main_img_ruler);
        this.f4104A = (TextView) findViewById(g.main_tv_ruler);
        this.f4134f = (TextView) findViewById(g.main_tv_setting_drawable);
        this.f4105B.setOnClickListener(this);
        this.f4106C.setOnClickListener(this);
        this.f4114K.setOnClickListener(this.cq);
        this.f4115L.setOnClickListener(this.cq);
        this.f4116M.setOnClickListener(this.cq);
        this.f4118O.setOnClickListener(this.cq);
        this.f4119P.setOnClickListener(this.cq);
        this.f4117N.setOnClickListener(this.cq);
        this.f4125V.setOnClickListener(this.cq);
        this.f4150w.setOnClickListener(this.f4135h);
        this.f4152y = (CustomCircleProgress) findViewById(g.main_imbt_refresh);
        this.aq = (LinearLayout) findViewById(g.main_liner_refresh);
        this.aq.setOnClickListener(this.ci);
        this.bN = (LinearLayout) findViewById(g.main_liner_navigation);
        this.bN.setOnClickListener(this.cu);
        aC();
        this.f4139l = C1417a.m6594a(getApplicationContext());
        C1638r.m7755a(this, this.f4139l);
        this.aL = this.f4120Q.getViewTreeObserver();
        this.aL.addOnGlobalLayoutListener(new C1619a(this));
        this.f4122S = AnimationUtils.loadAnimation(this, b.antiloss_anim_display_one);
        this.f4122S.setAnimationListener(this.ce);
        this.f4123T = AnimationUtils.loadAnimation(this, b.antiloss_anim_display_two);
        this.f4123T.setAnimationListener(this.cf);
        C1495o.m6928a(this.f4109F, 9);
        m7614p();
        m7595h();
        m7609m();
        m7519a(null);
        at();
    }

    private void m7595h() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter initDrawerLayout()");
        this.bi = (DrawerLayout) findViewById(g.main_content_drawer_layout);
        this.bi.setScrimColor(getResources().getColor(d.menu_bg_colors_side));
        this.bi.setDrawerShadow(getResources().getDrawable(C1617f.kw_pic_shadow2), 3);
        this.bi.setDrawerShadow(getResources().getDrawable(C1617f.kw_pic_shadow), 5);
        this.bj = (FrameLayout) findViewById(g.main_left_menu);
        this.bk = (FrameLayout) findViewById(g.main_right_menu);
        this.bj.setOnClickListener(this);
        this.bk.setOnClickListener(this);
        this.f4132d = new bo();
        this.f4133e = new bu();
        getFragmentManager().beginTransaction().replace(g.main_left_menu, this.f4132d).commitAllowingStateLoss();
        getFragmentManager().beginTransaction().replace(g.main_right_menu, this.f4133e).commitAllowingStateLoss();
        this.bi.setDrawerListener(this.cg);
    }

    private void m7550a(boolean z) {
        int i = GravityCompat.START;
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter opendCloseMenu()");
        if (this.bi.isDrawerOpen(z ? this.bk : this.bj)) {
            this.bi.closeDrawer(z ? GravityCompat.END : GravityCompat.START);
        }
        if (this.bi.isDrawerOpen(z ? this.bj : this.bk)) {
            DrawerLayout drawerLayout = this.bi;
            if (!z) {
                i = GravityCompat.END;
            }
            drawerLayout.closeDrawer(i);
            return;
        }
        drawerLayout = this.bi;
        if (!z) {
            i = GravityCompat.END;
        }
        drawerLayout.openDrawer(i);
    }

    private void m7599i() {
        C2538c.m12677c("KIDWATCH_HomeActivity", "Enter getFrequencyModeWatchSetting !");
        if (!C1483c.m6831b(C1462f.m6746j())) {
            C2538c.m12677c("KIDWATCH_HomeActivity", "=========== getFrequencyModeWatchSetting deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
        } else if (C1490j.m6890a("LCS_PowerSaveMode")) {
            GetWatchSettingModel getWatchSettingModel = new GetWatchSettingModel();
            getWatchSettingModel.deviceCode = C1462f.m6746j();
            getWatchSettingModel.settingType = "PositioningStrategy";
            this.f4139l.mo2487a(getWatchSettingModel, new av(this));
            C2538c.m12674b("KIDWATCH_HomeActivity", "Leave getFrequencyModeWatchSetting !");
        } else {
            C2538c.m12677c("KIDWATCH_HomeActivity", "Leave getFrequencyModeWatchSetting because not support K1AbilitySetUtil.POWER_SAVE_MODE!");
            C1462f.m6715a(1);
        }
    }

    private void m7602j() {
        GetDeviceProfileRetModel getDeviceProfileRetModel = new GetDeviceProfileRetModel();
        getDeviceProfileRetModel.deviceCode = C1462f.m6746j();
        this.f4139l.mo2483a(getDeviceProfileRetModel, new be(this));
    }

    private void m7528a(DeviceProfile deviceProfile) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===== Enter updataLocalTable");
        if (deviceProfile == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===== deviceInfo null ");
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========updataLocalTable deviceInfo = ", deviceProfile.toString());
        C1395k a = C1392h.m6269a(this.f4109F, C1462f.m6744i(), C1462f.m6746j());
        a.f3083c = deviceProfile.name;
        a.f3088h = deviceProfile.birthday;
        a.f3089i = deviceProfile.height;
        a.f3090j = deviceProfile.weight;
        a.f3091k = deviceProfile.sex;
        a.f3093m = deviceProfile.simCardNum;
        a.f3098r = deviceProfile.bigPortraitUrl;
        C1392h.m6287a(this.f4109F, C1462f.m6744i(), a, false);
        C2538c.m12674b("KIDWATCH_HomeActivity", "====www=  updataLocalTable mDeviceInfoTable111=" + a);
        if (String.valueOf(deviceProfile.deviceCode).equals(C1462f.m6746j())) {
            C1462f.m6718a(a);
        }
        C1462f.m6730c(true);
        C2538c.m12674b("KIDWATCH_HomeActivity", "===== Leave updataLocalTable");
    }

    private void m7605k() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter dealWithResertFactoryInHome()");
        this.f4146s.setDeviceName("");
        this.aY = null;
        this.aZ = -1;
        m7567b(false);
        this.f4130b.setVisibility(8);
        C1638r.m7763c();
        if (this.f4141n != null) {
            this.f4141n.clear();
        }
        this.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        C1462f.m6722a(false);
    }

    private void m7607l() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============Enter noPrivilage");
        C1392h.m6283a(this.f4109F, C1462f.m6748k());
        C1392h.m6306d(this.f4109F, C1462f.m6746j());
        C1392h.m6310e(this.f4109F, C1462f.m6746j());
        C1462f.m6718a(null);
        C1462f.m6731d("");
        C1462f.m6722a(true);
        C1497q.m6943a(this.f4109F, "sharedpreferences_watch_device_code", "");
        m7605k();
    }

    private void m7567b(boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter disableAllButton()");
        this.f4116M.setEnabled(z);
        this.f4114K.setEnabled(z);
        this.f4118O.setEnabled(z);
        this.f4117N.setEnabled(z);
        this.f4119P.setClickable(z);
        this.f4125V.setClickable(z);
        this.f4115L.setEnabled(z);
        this.bN.setEnabled(z);
    }

    private String m7516a(String str, String str2, boolean z) {
        C2538c.m12677c("KIDWATCH_HomeActivity", "Enter getCurDeviceCodeFromAllDeviceInfo isK1 = " + z);
        ArrayList a = C1392h.m6272a(this.f4109F, str);
        if (a == null) {
            return str2;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            C1395k c1395k = (C1395k) it.next();
            C2538c.m12677c("KIDWATCH_HomeActivity", "infoTable devicetype = " + c1395k.f3099s);
            if (z) {
                if (!String.valueOf(1).equals(c1395k.f3099s)) {
                    return String.valueOf(c1395k.f3082b);
                }
            } else if (String.valueOf(1).equals(c1395k.f3099s)) {
                return String.valueOf(c1395k.f3082b);
            }
        }
        return str2;
    }

    private String m7559b(String str, String str2) {
        int d = C1467b.m6789d(this.f4109F);
        C1395k a = C1392h.m6269a(this.f4109F, str, str2);
        C2538c.m12674b("KIDWATCH_HomeActivity", "updateCurDeviceCode... TempSelect = " + d + ", deviceInfoTable = " + a.toString());
        C2538c.m12677c("KIDWATCH_HomeActivity", "updateCurDeviceCode... TempSelect = " + d);
        if (5 == d) {
            if (String.valueOf(1).equals(a.f3099s)) {
                return m7516a(str, str2, true);
            }
            return str2;
        } else if (7 != d || String.valueOf(1).equals(a.f3099s)) {
            return str2;
        } else {
            return m7516a(str, str2, false);
        }
    }

    private void m7609m() {
        int i;
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Enter iniData");
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========current pid:" + Process.myPid());
        String f = C1093a.m4739a(this.f4109F).m4753f();
        String b = C1497q.m6945b(this.f4109F, "push_access_token", "");
        String c = C1093a.m4739a(this.f4109F).m4750c();
        String c2 = C1093a.m4739a(this.f4109F).m4750c();
        String b2 = C1497q.m6945b(this.f4109F, "sharedpreferences_watch_device_code", "");
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("intent_kidwatch_device_type")) {
            i = -1;
        } else {
            i = intent.getIntExtra("intent_kidwatch_device_type", -1);
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========== iniData intent getIntExtra INTENT_KEY_DEVICE_TYPE deviceType = " + i);
        }
        if (-1 != i) {
            b2 = m7559b(c, b2);
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "========== accessToken : " + f + "\n pushToken : " + b + "\n huaweHuid : " + c + "\n userId : " + c2 + "\n devicecode : " + b2);
        C1462f.m6719a(f);
        C1462f.m6738f(b);
        if ("".equals(c)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===123initData======= huid:" + C1093a.m4739a(this.f4109F).m4750c());
            C1462f.m6729c(r1);
        } else {
            C1462f.m6729c(c);
        }
        C1462f.m6725b(c2);
        C1462f.m6731d(b2);
        this.f4131c.sendEmptyMessage(10010);
        if (C1492l.m6919c(C1462f.m6746j())) {
            m7567b(true);
        } else {
            m7567b(false);
            this.f4130b.setVisibility(8);
            C1638r.m7763c();
        }
        C1462f.m6732d(false);
        this.aU = 10;
        getWindowManager().getDefaultDisplay().getMetrics(this.aF);
        this.aT = this.aF.widthPixels - C1492l.m6901a(this.f4109F, 32.0f);
        this.aJ = AnimationUtils.loadAnimation(this, b.scale);
        m7612o();
        m7623t();
        m7644f();
        m7645g();
        if (C1462f.m6748k() != null) {
            this.f4146s.setDeviceName(C1462f.m6748k().f3083c);
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===========no deviceinfo ，so titlename don't show");
        }
        this.f4142o = new bk(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.kone.broadcast.get.watch.status");
        intentFilter.addAction("com.huawei.kone.broadcast.get.bind.device");
        intentFilter.addAction("com.huawei.pluginkidwatch.homeactivity.emergency_locat");
        intentFilter.addAction("com.huawei.pluginkidwatch.homeactivity.no.privalage");
        intentFilter.addAction("com.huawei.plugin.account.login.st.to.at");
        LocalBroadcastManager.getInstance(this.f4109F).registerReceiver(this.f4142o, intentFilter);
        this.f4143p = new ReceiverAntilossAlarm(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("start.antiloss.alarm");
        LocalBroadcastManager.getInstance(this.f4109F).registerReceiver(this.f4143p, intentFilter);
        registerReceiver(this.ct, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        b2 = C1497q.m6945b(this.f4109F, "main_map_last_app_position", "");
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========get saved position：", b2);
        try {
            if (!"".equals(b2)) {
                this.f4144q = (LatLng) this.aN.fromJson(b2, LatLng.class);
            }
        } catch (JsonSyntaxException e) {
            this.f4144q = null;
            C2538c.m12674b("KIDWATCH_HomeActivity", "gson fromJson Exception !!");
        }
        if (this.f4141n == null) {
            this.f4141n = this.f4140m.getMap();
            UiSettings uiSettings = this.f4141n.getUiSettings();
            uiSettings.setZoomControlsEnabled(false);
            uiSettings.setRotateGesturesEnabled(false);
            this.f4141n.setOnMapLoadedListener(this);
            this.f4141n.setOnMarkerClickListener(this);
            this.f4141n.setOnCameraChangeListener(this);
            this.f4141n.setOnMapClickListener(this);
            this.f4141n.setInfoWindowAdapter(this);
            this.f4141n.moveCamera(CameraUpdateFactory.zoomTo(17.0f));
            m7505Z();
            m7499W();
        }
        this.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION);
        au();
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Leave iniData");
        this.bw = new C1621a(this.f4109F);
        this.bw.m7672a(C1462f.m6746j());
        if (C1483c.m6829b(this.f4109F) && !C1492l.m6912a()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", " token = " + C1093a.m4739a(this.f4109F).m4753f());
            C1462f.m6719a(b2);
            new C1448c(this.f4109F).m6682a(this.f4109F);
        }
    }

    private void m7611n() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Enter getDataFromCloud()");
        Interpolator linearInterpolator = new LinearInterpolator();
        if (this.aJ != null) {
            this.aJ.setInterpolator(linearInterpolator);
        }
        m7640a(true, false);
    }

    private void m7612o() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Enter getLastWatchStatusFromDB()");
        ad b = C1392h.m6289b(this.f4109F, C1462f.m6744i(), C1462f.m6746j());
        this.aO = "";
        this.aP = "";
        this.aM = null;
        if (b != null) {
            String e = b.m6236e();
            this.aO = b.m6240g();
            this.aP = b.m6238f();
            if ("".equals(e)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "======make mWatchStatus null");
                this.aM = null;
                return;
            }
            try {
                this.aM = (WatchStatus) this.aN.fromJson(e, WatchStatus.class);
                if (this.aM != null) {
                    j.c(this.aM.version);
                    C1462f.m6735e(this.aM.version);
                    return;
                }
                return;
            } catch (JsonSyntaxException e2) {
                C2538c.m12680e("KIDWATCH_HomeActivity", "====== error occured in convert json to model e = " + e2.getMessage());
                this.aM = null;
                return;
            }
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "======getLastWatchStatusFromDB enter else");
    }

    private WatchStatus m7513a(WatchStatus watchStatus, WatchStatus watchStatus2, boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========Enter updateWatchStatus  updateWearState:" + z);
        if (watchStatus2 == null) {
            return null;
        }
        if (z) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========total update");
            return watchStatus2;
        } else if (watchStatus == null) {
            return watchStatus2;
        } else {
            watchStatus2.wearState = watchStatus.wearState;
            return watchStatus2;
        }
    }

    private WatchStatus m7512a(WatchStatus watchStatus, int i) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========Enter updateWatchStatusValue  stateValue:" + i);
        if (watchStatus == null) {
            return null;
        }
        watchStatus.wearState = i;
        if (this.f4128Y == null || !this.f4128Y.isInfoWindowShown()) {
            return watchStatus;
        }
        this.f4128Y.hideInfoWindow();
        this.f4128Y.showInfoWindow();
        return watchStatus;
    }

    private void m7519a(Bitmap bitmap) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============Enter initHeadMarkerProperty");
        if (this.f4128Y != null) {
            this.f4128Y.remove();
        }
        this.f4127X = m7553b(bitmap);
        this.f4108E = new MarkerOptions();
        this.f4108E.draggable(false);
        this.f4108E.anchor(0.5f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f4108E.title("");
        this.f4108E.icon(BitmapDescriptorFactory.fromBitmap(this.f4127X));
        this.f4127X.recycle();
        this.f4128Y = this.f4141n.addMarker(this.f4108E);
        m7496V();
        m7593g(false);
    }

    private void m7614p() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============refreshInitDataUI()");
        int d = C1467b.m6789d(this.f4109F);
        C2538c.m12677c("KIDWATCH_HomeActivity", "===www=======current device refreshInitDataUIUI" + d);
        C1467b.m6788c(this.f4109F, d);
        C1467b.m6784a(this, d);
        if (7 == d) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===www=======current device refreshInitDataUIK2");
            this.f4119P.setVisibility(4);
            this.bN.setVisibility(0);
            this.f4115L.setVisibility(0);
            this.f4118O.setVisibility(8);
            if (this.f4132d != null) {
                if (this.f4132d.isAdded()) {
                    this.f4132d.f4302h.setText(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k2);
                    this.f4132d.f4303i.setVisibility(4);
                    this.f4132d.f4299e.setVisibility(0);
                }
                if (this.f4133e != null && this.f4133e.isAdded()) {
                    this.f4133e.f4327a.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===www=======current devicerefreshInitDataUI K1");
        this.f4119P.setVisibility(0);
        this.bN.setVisibility(4);
        this.f4115L.setVisibility(8);
        this.f4118O.setVisibility(0);
        if (this.f4132d != null) {
            if (this.f4132d.isAdded()) {
                this.f4132d.f4302h.setText(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k1);
                this.f4132d.f4303i.setVisibility(0);
                this.f4132d.f4299e.setVisibility(8);
            }
            if (this.f4133e != null && this.f4133e.isAdded()) {
                this.f4133e.f4327a.setVisibility(8);
            }
        }
    }

    private void m7617q() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============refreshHomeUI()");
        int c = C1467b.m6787c(this.f4109F);
        C2538c.m12677c("KIDWATCH_HomeActivity", "===www=======current device refreshHomeUI" + c);
        C1467b.m6784a(this, c);
        C1467b.m6788c(this.f4109F, c);
        if (7 == c) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===www=======current device refreshHomeUIK2");
            this.f4119P.setVisibility(4);
            this.bN.setVisibility(0);
            this.f4115L.setVisibility(0);
            this.f4118O.setVisibility(8);
            if (this.f4132d != null) {
                if (this.f4132d.isAdded()) {
                    this.f4132d.f4302h.setText(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k2);
                    this.f4132d.f4303i.setVisibility(4);
                    this.f4132d.f4299e.setVisibility(0);
                }
                if (this.f4133e == null) {
                    return;
                }
                if (this.f4133e.isAdded()) {
                    this.f4133e.f4327a.setVisibility(0);
                }
            } else {
                return;
            }
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===www=======current devicerefreshHomeUI K1");
        this.f4119P.setVisibility(0);
        this.bN.setVisibility(4);
        this.f4115L.setVisibility(8);
        this.f4118O.setVisibility(0);
        if (this.f4133e != null) {
            if (this.f4133e.isAdded()) {
                this.f4133e.f4327a.setVisibility(8);
            }
            if (this.f4132d == null) {
                return;
            }
            if (this.f4132d.isAdded()) {
                this.f4132d.f4302h.setText(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k1);
                this.f4132d.f4303i.setVisibility(0);
                this.f4132d.f4299e.setVisibility(8);
            }
        } else {
            return;
        }
        m7517a(c);
    }

    private void m7517a(int i) {
        this.br = C1497q.m6937a(this.f4109F, "main_map_show_tips", true).booleanValue();
        C2538c.m12674b("KIDWATCH_HomeActivity", "===www=======Enter showMask tipFlag" + this.br);
        if (this.br) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========SHOW TIPS");
            this.bi.setDrawerLockMode(1, this.bj);
            this.bi.setDrawerLockMode(1, this.bk);
            C1497q.m6942a(this.f4109F, "main_map_show_tips", Boolean.valueOf(false));
            if (C1497q.m6937a(this.f4109F, "sharedpreferences_new_device_bind", false).booleanValue()) {
                C1497q.m6942a(this.f4109F, "sharedpreferences_new_device_bind", Boolean.valueOf(false));
                C1483c.m6828b(this.f4109F, C1680l.IDS_plugin_kidwatch_common_bind_success);
            }
            if (7 == i) {
                this.f4106C.setVisibility(0);
            } else {
                this.f4105B.setVisibility(0);
            }
            this.bm.setVisibility(4);
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========HIDE TIPS");
        this.f4105B.setVisibility(8);
        this.f4106C.setVisibility(8);
        this.bm.setVisibility(0);
    }

    private Bitmap m7553b(Bitmap bitmap) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============Enter contrustHeadImage");
        if (bitmap != null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==============(null!=bitmap)");
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==============(null==bitmap)");
        }
        View inflate = getLayoutInflater().inflate(h.main_head_marker, null);
        ImageView imageView = (ImageView) inflate.findViewById(g.main_map_headimage);
        if (bitmap == null) {
            bitmap = m7618r();
        }
        imageView.setImageBitmap(bitmap);
        Bitmap a = C1492l.m6905a(inflate);
        if (!(bitmap == null || bitmap.isRecycled())) {
            bitmap.recycle();
        }
        if (a == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==============null==res");
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==============null!=res");
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============Leave contrustHeadImage");
        return a;
    }

    private Bitmap m7618r() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============Enter getHeadBipmap");
        m7623t();
        if (this.ac == null) {
            this.ac = new C1565a();
        }
        if (C1462f.m6748k() != null) {
            new Thread(new bh(this)).start();
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "============use default");
        Bitmap s = m7620s();
        C2538c.m12674b("KIDWATCH_HomeActivity", "============ Leave getHeadBipmap");
        return s;
    }

    private void m7573c(Bitmap bitmap) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Enter changeHeadImage");
        if (bitmap == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "changeHeadImage--->headBitmap_temp is null");
        }
        runOnUiThread(new bi(this, bitmap));
    }

    private Bitmap m7620s() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============ Enter  getDefaultBitmap");
        if (C1462f.m6748k() != null && 1 == C1462f.m6748k().f3091k) {
            return C1492l.m6903a(BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_user_girl));
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=============KWCache.curDeviceInfo is null, head boy");
        return C1492l.m6903a(BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_user_boy));
    }

    private void m7623t() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============ Enter  updateCurrentDeviceInfo");
        C1395k a = C1392h.m6269a(this.f4109F, C1462f.m6744i(), C1462f.m6746j());
        C2538c.m12674b("KIDWATCH_HomeActivity", "============ Enter  updateCurrentDeviceInfo curTable = " + a);
        C2538c.m12677c("KIDWATCH_HomeActivity", "===www=======current device type = " + a.f3099s);
        if (1 == C1492l.m6920d(a.f3099s)) {
            j.a(a.f3096p);
            j.b("K2");
            C1467b.m6786b(this, 7);
        } else {
            j.a(a.f3096p);
            j.b("K1");
            C1467b.m6786b(this, 5);
        }
        C1462f.m6718a(a);
        C2538c.m12674b("KIDWATCH_HomeActivity", "============ Enter  updateCurrentDeviceInfo after set setCurDeviceInfo = " + C1462f.m6748k());
        C2538c.m12674b("KIDWATCH_HomeActivity", "============ Enter  updateCurrentDeviceInfo after set huid = " + C1462f.m6744i());
        C1497q.m6943a(this.f4109F, "K1_DEVICE_MAC", a.f3096p);
        m7527a(a);
    }

    private void m7624u() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "goingRefreshLocationPosition ...........");
        if (C1492l.m6916b(this.f4109F)) {
            ar();
            m7576c(false);
            return;
        }
        C1483c.m6824a(this.f4109F, C1680l.IDS_plugin_kidwatch_common_network_disable);
    }

    private void m7627v() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Enter removeRunnable");
        this.f4131c.removeCallbacks(this.cm);
        this.f4131c.removeCallbacks(this.cl);
        this.f4131c.removeCallbacks(this.ck);
        this.f4131c.removeCallbacks(this.cj);
        this.f4131c.removeCallbacks(this.co);
        m7456B();
    }

    private void m7629w() {
        this.f4132d.f4304j = false;
        C1497q.m6942a(this.f4109F, "Has_been_initiated_shutdown", Boolean.valueOf(false));
        if (this.f4132d.f4305k != null) {
            this.f4132d.f4301g.removeCallbacks(this.f4132d.f4305k);
            this.f4132d.m7809a(true);
        }
    }

    private void m7631x() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "======Enter stopSoS");
        this.bx = false;
        m7612o();
        m7503Y();
        as();
        this.f4131c.removeCallbacks(this.co);
    }

    public void m7640a(boolean z, boolean z2) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter getBindDeviceInfos");
        this.f4131c.postDelayed(this.cl, 10000);
        ar();
        this.f4139l.mo2472a(new BindDeviceInfosIOEntityModel(), new C1653h(this, z, z2));
    }

    private void m7566b(String str) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=============Enter updateDeviceCode deviceCode：" + str);
        C1497q.m6943a(this.f4109F, "sharedpreferences_watch_device_code", str);
        C1462f.m6731d(str);
        if (C1492l.m6919c(str)) {
            m7567b(true);
            return;
        }
        m7567b(false);
        this.f4130b.setVisibility(8);
    }

    private void m7551a(boolean z, boolean z2, boolean z3) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter getWatchStatus");
        this.f4131c.postDelayed(this.cl, 10000);
        if (z2) {
            ar();
        }
        WatchStatusIOModel watchStatusIOModel = new WatchStatusIOModel();
        watchStatusIOModel.deviceCode = C1462f.m6746j();
        this.f4139l.mo2505a(watchStatusIOModel, new C1654i(this, z2, z, z3));
    }

    private void m7576c(boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter getWatchStatusInSOS :" + z);
        ar();
        this.bx = true;
        if (this.f4128Y != null && this.f4128Y.isVisible()) {
            this.f4128Y.hideInfoWindow();
            this.f4128Y.showInfoWindow();
        }
        WatchStatusIOModel watchStatusIOModel = new WatchStatusIOModel();
        watchStatusIOModel.deviceCode = C1462f.m6746j();
        this.f4139l.mo2505a(watchStatusIOModel, new C1655j(this, z));
    }

    private void m7633y() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter startTimer");
        if (this.ba != null) {
            this.ba.cancel();
        }
        this.ba = new Timer();
        try {
            this.ba.schedule(new C1656k(this), 5000, 5000);
        } catch (Exception e) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====ERROR! e = " + e.getMessage());
        }
    }

    private void m7531a(WatchStatus watchStatus, LocationData locationData, boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter processInChinaResult===");
        m7575c(C1462f.m6746j());
        this.aU = 0;
        this.aM = m7513a(this.aM, watchStatus, false);
        LatLng latLng = new LatLng(locationData.lat, locationData.lon);
        m7525a(latLng, false);
        m7455A();
        m7526a(new LatLonPoint(latLng.latitude, latLng.longitude), C1462f.m6746j(), false);
        if (z) {
            this.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }
    }

    private void m7575c(String str) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============Enter getUpdateState");
        CommonStateOModel commonStateOModel = new CommonStateOModel();
        commonStateOModel.type = "0";
        commonStateOModel.deviceCode = C1462f.m6746j();
        this.f4139l.mo2474a(commonStateOModel, new C1658m(this, str));
    }

    private void m7583d(boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter processNotInChinaResult===");
        if (z) {
            if (this.aU <= 0) {
                this.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
                if (this.f4138k.equals(C1492l.m6907a(this.f4109F))) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "==================主页在栈顶，显示失败toast");
                    if (!(this.bi.isDrawerOpen(this.bj) || this.bi.isDrawerOpen(this.bk))) {
                        C1483c.m6828b(this.f4109F, C1680l.IDS_plugin_kidwatch_main_get_status_error);
                    }
                } else {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "==================主页不在栈顶，不显示失败toast");
                }
            } else {
                ar();
                this.f4131c.postDelayed(this.cm, 5000);
            }
        }
        m7635z();
    }

    private void m7585e(boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter getWatchFailure");
        m7612o();
        m7503Y();
        if (!C1492l.m6916b(this.f4109F) && z) {
            m7518a(this.f4109F, C1680l.IDS_plugin_kidwatch_common_network_disable, false);
        } else if (z) {
            m7518a(this.f4109F, C1680l.IDS_plugin_kidwatch_main_get_status_error, false);
        }
        this.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
    }

    private void m7518a(Context context, int i, boolean z) {
        String a = C1492l.m6907a(context);
        if (context == null || !a.equals(this.f4138k)) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=========HomeActivity is invisable, so return");
        } else if (z) {
            C1483c.m6824a(context, i);
        } else {
            C1483c.m6828b(context, i);
        }
    }

    private void m7635z() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============Enter changeMapCenter");
        if (this.f4128Y != null && this.f4128Y.isVisible()) {
            LatLng position = this.f4128Y.getPosition();
            if (position != null) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=============Move center of map");
                this.f4141n.animateCamera(CameraUpdateFactory.changeLatLng(position));
            }
        }
    }

    private void m7455A() {
        long j;
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Enter printTime");
        if (this.aM != null) {
            j = this.aM.lastLocation.time;
        } else {
            j = 0;
        }
        String str = "";
        if (j > 0) {
            String format = new SimpleDateFormat("MM-dd HH:mm", Locale.US).format(new Date(j));
            C2538c.m12674b("KIDWATCH_HomeActivity", "===========手表上报位置的时间:" + format);
        }
    }

    private void m7456B() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========Enter stopTimer");
        this.bx = false;
        this.f4131c.removeCallbacks(this.co);
        if (this.ba != null) {
            this.ba.cancel();
        }
    }

    private void m7458C() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============Enter getSOSLocation");
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        this.f4131c.removeCallbacks(this.co);
        this.f4131c.postDelayed(this.co, 120000);
        commonRetOModel.data = "";
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 3;
        this.f4139l.mo2473a(commonRetOModel, new C1660o(this));
    }

    private void m7561b(DeviceProfile deviceProfile) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter saveProifleToDB");
        C1395k c1395k = new C1395k();
        if ("".equals(C1462f.m6744i())) {
            C1462f.m6729c(C1093a.m4739a(this.f4109F).m4750c());
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter saveProifleToDB KWCache.getHuaweiHuid() = " + C1462f.m6744i() + "; deviceInfo.mac = " + deviceProfile.mac);
        C2538c.m12677c("KIDWATCH_HomeActivity", "==========Enter saveProifleToDB device type = " + deviceProfile.deviceType);
        c1395k.f3081a = C1462f.m6744i();
        c1395k.f3097q = deviceProfile.primaryHuid;
        c1395k.f3082b = deviceProfile.deviceCode;
        c1395k.f3093m = deviceProfile.simCardNum;
        c1395k.f3098r = deviceProfile.bigPortraitUrl;
        c1395k.f3099s = deviceProfile.deviceType + "";
        if (deviceProfile.height == 0) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========用户没有设置过个人信息，将默认值保存到数据库");
            c1395k.f3083c = getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_nickname_default);
            c1395k.f3088h = "2008-01-01";
            c1395k.f3089i = C1492l.m6920d("35");
            c1395k.f3090j = C1492l.m6920d("110");
            c1395k.f3091k = 2;
        } else {
            c1395k.f3083c = deviceProfile.name;
            c1395k.f3088h = deviceProfile.birthday;
            c1395k.f3089i = deviceProfile.height;
            c1395k.f3090j = deviceProfile.weight;
            c1395k.f3091k = deviceProfile.sex;
        }
        if (!"".equals(deviceProfile.mac)) {
            c1395k.f3096p = deviceProfile.mac;
        }
        if (!"".equals(C1462f.m6744i().trim())) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "====www123============saveProifleToDB mDeviceInfoTable = " + c1395k);
            C1392h.m6287a(this.f4109F, C1462f.m6744i(), c1395k, false);
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Leave saveProifleToDB");
    }

    private void m7461D() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============Enter resetLocalData");
        this.aO = "";
        this.aP = "";
        this.aM = null;
        this.aY = null;
        this.aZ = -1;
        new ac(this.f4109F).m6222a(C1462f.m6744i());
        C1392h.m6298b(this.f4109F, C1462f.m6744i());
        C1462f.m6718a(null);
        m7566b("");
        C1462f.m6736e(false);
        this.f4146s.setDeviceName("");
        if (this.f4141n != null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============ aMap.clear()");
            this.f4141n.clear();
        }
    }

    private void m7549a(List<DeviceProfile> list) {
        String str = "";
        int i = 0;
        for (DeviceProfile deviceProfile : list) {
            if (deviceProfile != null) {
                int i2;
                if (!C1492l.m6919c(str)) {
                    str = String.valueOf(deviceProfile.deviceCode);
                }
                if (String.valueOf(deviceProfile.deviceCode).equals(C1462f.m6746j())) {
                    i2 = 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (i == 0) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "================updateDeviceCode 3");
            m7566b(str);
            if (this.f4141n != null) {
                this.f4141n.clear();
            }
        }
    }

    private void m7527a(C1395k c1395k) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=================Enter setMainFlag1");
        if (c1395k == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=================Enter setMainFlag2");
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=================Enter setMainFlag3" + c1395k.toString());
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=================Enter setMainFlag4" + C1462f.m6744i());
        if (c1395k == null || C1462f.m6744i() == null || !C1462f.m6744i().equals(c1395k.f3097q)) {
            C1462f.m6736e(false);
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=================PrimaryHuid:", c1395k.f3097q);
            C1462f.m6736e(true);
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=================Leave setMainFlag    KWCache.IS_MAIN_OWNER：", C1462f.m6754n() + "");
    }

    private void m7463E() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter showStartAntilossDialog");
        C1595v c1595v = new C1595v(this);
        c1595v.m7339a(C1680l.IDS_plugin_kidwatch_feature_antiloss_start);
        c1595v.m7348b(C1680l.IDS_plugin_kidwatch_feature_antiloss_start_notice);
        c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new C1667r(this));
        c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new C1672s(this));
        this.bb = c1595v.m7338a();
        this.bb.show();
    }

    private void m7465F() {
        if (this.bd == null || !this.bd.isShowing()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter showAntilossExceptionExitDialog");
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_common_tips);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_main_exception_exit_warning);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new C1673t(this));
            this.bd = c1595v.m7338a();
            this.bd.show();
        }
    }

    private void m7467G() {
        if (this.be == null || !this.be.isShowing()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter showChangeDevicesAntilossDialog");
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_common_tips);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_main_change_kiddevices_tip);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new C1674u(this));
            this.be = c1595v.m7338a();
            this.be.show();
        }
    }

    private void m7468H() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter startAntilossActivity");
        this.cc = false;
        if (bt) {
            bt = C1497q.m6937a((Context) this, "kidwatch_service_state", false).booleanValue();
        }
        if (C1642v.m7777a(this) && !bt) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===============startAntilossActivity start KidWatchService");
            bt = true;
            startService(new Intent(getApplicationContext(), KidWatchService.class));
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter startAntilossActivity");
        startActivity(new Intent(this, AntilossActivity.class));
    }

    private void m7470I() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter startAntilossFunction");
        C1723d a = C1743x.m8322a((Context) this).m8323a();
        if (!this.bh.isEnabled()) {
            m7463E();
        } else if (a != null && 7 == a.m8303j()) {
            mo2518d();
        } else if (C1492l.m6913a((Context) this, C1466a.m6781e())) {
            m7468H();
        } else {
            this.cc = true;
            C1492l.m6910a((Activity) this, C1466a.m6781e());
        }
    }

    public void mo2518d() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============Enter showAntilossAlarmDialog");
        C1773a.m8552a((Context) this).m8555a(this, "", AntilossPopupDialogActivity.class);
    }

    private void m7473J() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter goToAntiloss");
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        c.a().a(BaseApplication.m2632b(), a.ae.a(), hashMap, 0);
        if (VERSION.SDK_INT < 19) {
            C1483c.m6832c(this.f4109F, getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_not_support, new Object[]{getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_title)}));
        } else if (!getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            C1483c.m6832c(this.f4109F, getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_not_btsupport, new Object[]{getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_title)}));
        } else if (C1462f.m6748k() == null || C1462f.m6748k().f3096p == null || "".equals(C1462f.m6748k().f3096p)) {
            C1483c.m6832c(this.f4109F, getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_not_btmac));
        } else {
            m7470I();
        }
    }

    private void m7525a(LatLng latLng, boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============= Enter moveToPosition");
        if (latLng == null || this.f4128Y == null) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=================latLng or realTimePosition is null");
            return;
        }
        this.f4128Y.setPosition(latLng);
        m7524a(latLng);
        if (C1468c.f3413a != latLng) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "================= 显示头像大头针");
            m7593g(true);
            if (z) {
                ai();
            }
        } else {
            C2538c.m12680e("KIDWATCH_HomeActivity", "================= 发现大头针到北京的场景");
            m7496V();
            m7593g(false);
        }
        this.f4141n.animateCamera(CameraUpdateFactory.changeLatLng(latLng));
    }

    private void m7524a(LatLng latLng) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==================Enter moveCircle()");
        if (this.bC != null) {
            this.bC.remove();
        }
        if (latLng != null && this.aM != null && this.f4128Y.isVisible()) {
            int d = C1492l.m6920d(this.aM.lastLocation.radius);
            C2538c.m12674b("KIDWATCH_HomeActivity", "===lastLocation.type:" + this.aM.lastLocation.type);
            this.bC = this.f4141n.addCircle(new CircleOptions().center(latLng).radius((double) m7552b(d)).strokeColor(Color.rgb(0, 188, 195)).strokeWidth(0.0f).fillColor(getResources().getColor(d.main_circle_color_bg)));
        }
    }

    private int m7552b(int i) {
        int i2 = 100;
        int i3 = 200;
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter getPositioningRadius  radiusReal:" + i);
        if (this.aM != null) {
            switch (C1492l.m6920d(this.aM.lastLocation.type)) {
                case 1:
                    if (i < 100) {
                        i2 = i;
                        break;
                    }
                    break;
                case 2:
                    if (i >= 200) {
                        i2 = 200;
                        break;
                    }
                    i2 = i;
                    break;
                case 3:
                    if (i < 200) {
                        i3 = i;
                    }
                    i2 = i3;
                    break;
                case 4:
                    if (i >= 500) {
                        i2 = 500;
                        break;
                    }
                    i2 = i;
                    break;
                default:
                    if (i >= 20) {
                        i2 = 20;
                        break;
                    }
                    i2 = i;
                    break;
            }
        }
        i2 = 0;
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Leave getPositioningRadius radiusReal:" + i);
        return i2;
    }

    private void m7474K() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "================ Enter getK1Device ");
        if (this.aR != null) {
            this.aR.clear();
        }
        if (this.f4148u != null) {
            this.f4148u.clear();
        } else {
            this.f4148u = new ArrayList();
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "huid:", C1462f.m6744i() + "");
        if ("".equals(C1462f.m6744i())) {
            C1462f.m6729c(C1093a.m4739a(this.f4109F).m4750c());
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "huid2:", C1462f.m6744i() + "");
        this.aR = C1392h.m6272a(this.f4109F, C1462f.m6744i());
        if (this.aR != null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "================当前用户绑定的所有手表数目为：", this.aR.size() + "");
            Iterator it = this.aR.iterator();
            while (it.hasNext()) {
                C1395k c1395k = (C1395k) it.next();
                C2538c.m12674b("KIDWATCH_HomeActivity", "================arr:", c1395k.f3082b + "");
                C2538c.m12677c("KIDWATCH_HomeActivity", "================arr.data1 = ", c1395k.f3099s + "");
                C1522b c1522b = new C1522b();
                c1522b.m7036a(c1395k.f3083c);
                if (1 == C1492l.m6920d(c1395k.f3099s)) {
                    c1522b.m7035a(7);
                } else {
                    c1522b.m7035a(5);
                }
                c1522b.m7039b(c1395k.f3082b);
                if (C1462f.m6746j().equals(c1395k.f3082b + "")) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "================setSelect(true) :", c1395k.f3082b + "");
                    c1522b.m7037a(true);
                }
                C2538c.m12674b("KIDWATCH_HomeActivity", "================pairedDeviceInfo :", c1522b.toString() + "");
                this.f4148u.add(c1522b);
            }
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "================数据库中没有找到当前用户绑定的手表信息");
        }
        C1522b c1522b2 = new C1522b();
        c1522b2.m7036a(getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_back_main_activity));
        c1522b2.m7035a(97);
        c1522b2.m7039b(9999);
        c1522b2.m7037a(false);
        this.f4148u.add(c1522b2);
    }

    private void m7476L() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter initPopuWindow()");
        this.f4149v = new C1599z(this.f4109F, this.f4148u);
        if (this.f4147t != null) {
            this.f4147t.setAdapter(this.f4149v);
            this.f4147t.setItemsCanFocus(true);
            this.f4147t.setOnItemClickListener(this.cr);
        }
    }

    private void m7532a(C1522b c1522b) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============otherTypeDeviceClicked===");
        C1723d a = C1743x.m8322a((Context) this).m8323a();
        if (a == null || 3 == a.m8302i() || a.m8302i() == 0 || -1 == a.m8302i()) {
            m7627v();
            C1467b.m6785b(this.f4109F);
            Intent intent = new Intent();
            intent.setClassName(this, "com.huawei.bone.root.MainActivity");
            intent.putExtra("START_MAIN_FRAGMENT", 3);
            startActivity(intent);
            C1467b.m6785b(this.f4109F);
            finish();
        } else if (this.f4131c != null) {
            this.f4131c.sendEmptyMessage(MessageObserver.RET_CHECK_PARAM_ERROR);
        }
    }

    private void m7572c(int i) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========GO TO K1===");
        if (C1462f.m6746j().equals(String.valueOf(((C1522b) this.f4148u.get(i)).m7041d()))) {
            m7590f(true);
            return;
        }
        C1723d a = C1743x.m8322a((Context) this).m8323a();
        if (a == null || 3 == a.m8302i() || a.m8302i() == 0 || -1 == a.m8302i()) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putInt(this.aQ, i);
            message.setData(bundle);
            message.what = 9999;
            this.f4131c.sendMessage(message);
        } else if (this.f4131c != null) {
            this.f4131c.sendEmptyMessage(MessageObserver.RET_CHECK_PARAM_ERROR);
        }
    }

    private void m7479M() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=============Add device is clicked");
        Intent intent = new Intent();
        intent.setClassName(this, "com.huawei.ui.device.activity.adddevice.AddDeviceActivity");
        intent.setPackage(this.f4109F.getPackageName());
        this.f4109F.startActivity(intent);
        m7590f(false);
    }

    private void m7590f(boolean z) {
        if (this.f4146s != null) {
            this.f4146s.m7029a(z);
        }
    }

    private void m7480N() {
        if (this.f4121R != null) {
            this.f4121R.setVisibility(0);
            this.f4121R.startAnimation(this.f4122S);
        }
    }

    private void m7483O() {
        if (this.f4121R != null) {
            this.f4121R.setVisibility(8);
            this.f4121R.clearAnimation();
        }
    }

    private void m7485P() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============Enter refreshAntilossStateView");
        C1723d a = C1743x.m8322a((Context) this).m8323a();
        if (a == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====kwBtDevice = null");
            this.f4125V.setImageResource(C1617f.kw_pic_map_antiloss_stop);
            if (this.f4124U) {
                this.f4124U = false;
                m7483O();
                return;
            }
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====kwBtDevice.getAntilossState() = " + a.m8303j());
        if (6 == a.m8303j() || 8 == a.m8303j()) {
            this.f4125V.setImageResource(C1617f.kw_pic_map_antiloss_doing);
            if (!this.f4124U) {
                this.f4124U = true;
                m7480N();
            }
        } else if (9 == a.m8303j()) {
            this.f4125V.setImageResource(C1617f.kw_pic_map_antiloss_stop);
            if (this.f4124U) {
                this.f4124U = false;
                m7483O();
            }
        } else if (7 == a.m8303j()) {
            this.f4125V.setImageResource(C1617f.kw_pic_map_antiloss_alarm);
            if (!this.f4124U) {
                this.f4124U = true;
                m7480N();
            }
        }
    }

    protected void onResume() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============Enter onResume");
        super.onResume();
        this.f4140m.onResume();
        this.f4131c.removeCallbacks(this.cn);
        this.f4131c.postDelayed(this.cn, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
        C1462f.m6716a(getApplicationContext());
        m7485P();
        if (C1462f.m6753m()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============KWCache.isProfileChanged is true");
            C1462f.m6730c(false);
            if (C1462f.m6748k() != null) {
                this.f4146s.setDeviceName(C1462f.m6748k().f3083c);
            }
            this.f4127X = m7553b(null);
            this.f4128Y.setIcon(BitmapDescriptorFactory.fromBitmap(this.f4127X));
            this.f4127X.recycle();
        }
        long a = C1497q.m6936a(this.f4109F, "main_map_last_time_of_updata_status");
        if (System.currentTimeMillis() - a > LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME && System.currentTimeMillis() - a < 86400000) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============more than 10min");
            m7551a(false, true, true);
        } else if (C1462f.m6714C()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============from trackActivity");
            C1462f.m6739f(false);
            m7551a(false, true, true);
        } else if (this.f4128Y != null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============ normal onReusme");
            if (!"".equals(this.aP.trim()) && this.f4128Y.isVisible()) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=====buildNameText:", this.aP);
                m7496V();
                m7525a(this.f4128Y.getPosition(), true);
            }
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===========onReusme Enter default");
        }
        C1497q.m6942a(this.f4109F, "sharedpreferences_guide_introduce_boolean", Boolean.valueOf(true));
        if (!(this.f4126W || !"".equals(C1462f.m6746j()) || C1462f.m6723a())) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===========onReusme ,no devicecode,so need getDataFromCloud");
            m7611n();
        }
        C1618a.m7659a(false);
        this.f4126W = false;
        C1638r.m7759a(this);
        m7486Q();
        this.aZ = -1;
        this.aY = null;
        m7600i(false);
        m7603j(false);
        if (C1462f.m6723a() && this.bi != null) {
            this.bi.closeDrawers();
        }
        this.f4131c.postDelayed(new C1678y(this), 10000);
        aJ();
        if (!this.a && !this.f4153z) {
            C2538c.m12677c("KIDWATCH_HomeActivity", ">>>>>>>>>>>>>>>>>>> 发生了从后台切到前台进行紧急定位 goingRefreshLocationPosition !!!");
            m7624u();
        }
    }

    private void m7486Q() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter showAppPosition ");
        if (C1497q.m6944b(this.f4109F, "main_map_is_show_app_position").booleanValue()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========show app position");
            if (this.f4129Z == null) {
                m7499W();
                return;
            } else if (this.f4129Z.isVisible()) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=========app is showing");
                return;
            } else {
                m7499W();
                return;
            }
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========switch is off ,so don't show app position");
        if (this.f4129Z != null) {
            this.f4129Z.remove();
        }
    }

    protected void onPause() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "onPause");
        super.onPause();
        this.f4140m.onPause();
        ad();
    }

    protected void onStop() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "onStop");
        super.onStop();
        this.f4131c.removeCallbacks(this.cn);
        ad();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f4140m.onSaveInstanceState(bundle);
    }

    protected void onDestroy() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "======onDestroy");
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====OnCreateNum: " + C1462f.m6734e());
        if (1 >= C1462f.m6734e()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===============unband phoneService");
            m7627v();
            this.f4140m.onDestroy();
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f4142o);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f4143p);
            unregisterReceiver(this.ct);
            C1462f.m6757q();
            unregisterReceiver(this.cy);
        }
        C1462f.m6741g();
        ad();
        if (!(this.f4109F == null || isFinishing())) {
            C1506g.m6979b();
        }
        if (this.bd != null) {
            this.bd.dismiss();
            this.bd = null;
        }
        if (this.be != null) {
            this.be.dismiss();
            this.be = null;
        }
        C2442a.m12231a(false);
        HwWearPushReceiver.m3496a(getApplicationContext());
        super.onDestroy();
        if (this.f4131c != null) {
            this.f4131c.removeCallbacksAndMessages(null);
        }
    }

    private void m7488R() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============Enter stopKidWatchService");
        if (C1642v.m7777a(this)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===============Stop KidWatchService");
            bt = false;
            stopService(new Intent(getApplicationContext(), KidWatchService.class));
        }
    }

    private void m7490S() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "======Enter saveCurrentStatus");
        if (m7493T()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "======Save watchStatus");
            String i = C1462f.m6744i();
            if ("".equals(i)) {
                i = C1093a.m4739a(this.f4109F).m4750c();
                C2538c.m12674b("KIDWATCH_HomeActivity", "===123initData======= huid = " + i);
                C1462f.m6729c(i);
            }
            ad adVar = new ad();
            adVar.m6227a(this.aM.deviceCode);
            adVar.m6228a(i);
            adVar.m6226a(this.aM.lastLocation.lat);
            adVar.m6230b(this.aM.lastLocation.lon);
            adVar.m6231b(this.aN.toJson(this.aM));
            adVar.m6233c(this.aP);
            adVar.m6235d(this.aO);
            C1392h.m6286a(this.f4109F, C1462f.m6744i(), adVar);
        }
        C1497q.m6943a(this.f4109F, "sharedpreferences_watch_device_code", C1462f.m6746j());
    }

    private boolean m7493T() {
        if ("".equals(C1462f.m6746j()) || this.aM == null || 0.0d == this.aM.lastLocation.lat || 0.0d == this.aM.lastLocation.lon || this.aM.deviceCode != C1492l.m6920d(C1462f.m6746j())) {
            return false;
        }
        return true;
    }

    protected void onStart() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "======Enter onStart");
        super.onStart();
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        if (this.aa != cameraPosition.zoom) {
            this.aa = cameraPosition.zoom;
            m7496V();
        }
        m7494U();
    }

    private void m7494U() {
        CharSequence charSequence;
        int scalePerPixel = (int) (this.f4141n.getScalePerPixel() * ((float) this.aX));
        String str = "";
        if (scalePerPixel <= 1000) {
            charSequence = "" + scalePerPixel + getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_ruler_m);
        } else {
            charSequence = "" + (scalePerPixel / 1000) + getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_ruler_km);
        }
        if (this.f4104A != null) {
            this.f4104A.setText(charSequence);
        }
    }

    private void m7496V() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter hideMarkerInfoWindow=====");
        if (this.f4128Y != null) {
            this.f4128Y.hideInfoWindow();
        }
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        if (this.aa != cameraPosition.zoom) {
            this.aa = cameraPosition.zoom;
            m7496V();
        }
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter onClick");
        if (g.main_right_menu == view.getId()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========right fragement is clicked");
        } else if (g.tips_lly == view.getId()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========hide tips");
            this.f4105B.setVisibility(8);
            this.bi.setDrawerLockMode(0, this.bj);
            this.bi.setDrawerLockMode(0, this.bk);
            this.bm.setVisibility(0);
        } else if (g.tips_lly_k2 == view.getId()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========hide tips");
            this.f4106C.setVisibility(8);
            this.bi.setDrawerLockMode(0, this.bj);
            this.bi.setDrawerLockMode(0, this.bk);
            this.bm.setVisibility(0);
        }
    }

    public void onMapClick(LatLng latLng) {
        m7496V();
    }

    private void m7499W() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "Enter getPositionByMobileNet");
        this.f4131c.postDelayed(this.ck, 10000);
        this.f4107D = LocationManagerProxy.getInstance((Activity) this);
        if (this.f4107D != null) {
            new Thread(new C1679z(this)).start();
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "Leave getPositionByMobileNet");
    }

    private void m7501X() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "================Enter stopLocation");
        if (this.f4107D != null) {
            this.f4107D.removeUpdates((AMapLocationListener) this);
            this.f4107D.destroy();
        }
        this.f4107D = null;
    }

    public void onMapLoaded() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "================Enter onMapLoaded");
        LatLng latLng = this.f4144q;
        if (this.f4141n == null) {
            this.f4140m = (MapView) findViewById(g.map);
            this.f4141n = this.f4140m.getMap();
        }
        this.f4141n.moveCamera(CameraUpdateFactory.zoomTo(17.0f));
        if (this.aM != null) {
            m7503Y();
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====Move To Beijing , and Make HeadMarker Invisable ");
            if (latLng == null || 0.0d == latLng.latitude) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=====================地图设定在北京");
                this.f4141n.moveCamera(CameraUpdateFactory.changeLatLng(C1468c.f3413a));
                this.f4128Y.setPosition(C1468c.f3413a);
                m7524a(this.f4128Y.getPosition());
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "====================地图设定在手机位置");
                this.f4141n.moveCamera(CameraUpdateFactory.changeLatLng(latLng));
                this.f4128Y.setPosition(latLng);
                m7524a(this.f4128Y.getPosition());
            }
            m7496V();
            m7593g(false);
        }
        m7494U();
    }

    private void m7503Y() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Move To Last");
        LatLng ac = ac();
        if (ac == null) {
            m7505Z();
            return;
        }
        this.f4141n.moveCamera(CameraUpdateFactory.changeLatLng(ac));
        this.f4128Y.setPosition(ac);
        m7524a(this.f4128Y.getPosition());
        m7593g(true);
        if (!"".equals(this.aP.trim())) {
            ai();
        }
    }

    private void m7505Z() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter moveToAppPosition");
        if (this.f4144q == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "====================appPosition is NULL");
        } else if (0.0d == this.f4144q.latitude) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "====================地图设定在北京===");
            this.f4141n.moveCamera(CameraUpdateFactory.changeLatLng(C1468c.f3413a));
        } else {
            this.f4141n.moveCamera(CameraUpdateFactory.changeLatLng(this.f4144q));
        }
    }

    private void m7593g(boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============showMarkerOfHead  show:", z + "");
        this.f4128Y.setVisible(z);
        if (z) {
            m7524a(this.f4128Y.getPosition());
        } else {
            aa();
        }
    }

    private void aa() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "Enter hideCircle");
        if (this.bC != null) {
            this.bC.remove();
        }
    }

    private void ab() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===============destoryMarkerOfHead");
        this.f4128Y.destroy();
    }

    private LatLng ac() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==================Enter getLastVision");
        if (this.aM != null) {
            return new LatLng(this.aM.lastLocation.lat, this.aM.lastLocation.lon);
        }
        return null;
    }

    public boolean onMarkerClick(Marker marker) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "======Enter onMarkerClick=========");
        if (!marker.equals(this.f4128Y)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "======未知marker被点击=========");
        } else if (this.f4128Y.isInfoWindowShown()) {
            this.f4128Y.hideInfoWindow();
        } else if ("".equals(this.aP.trim())) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====no buildNameText,so getAddress again");
            m7526a(new LatLonPoint(this.f4128Y.getPosition().latitude, this.f4128Y.getPosition().longitude), C1462f.m6746j(), false);
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====buildNameText:", this.aP);
            ai();
        }
        return true;
    }

    private void m7580d(int i) {
        if (this.aA != null && i >= 0 && aB) {
            this.aA.show();
            m7523a(this.aA, i);
        }
    }

    private void m7523a(Toast toast, int i) {
        new Timer().schedule(new aa(this, i), 3000);
    }

    private void ad() {
        if (this.aA != null) {
            aB = false;
            this.aA.cancel();
        }
    }

    private void ae() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter showRemotDialog");
        if (this.bc == null || !this.bc.isShowing()) {
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_menu_record_title);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_menu_record_discr);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_start, new ab(this));
            c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new ac(this));
            this.bc = c1595v.m7338a();
            this.bc.show();
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Dialog已经显示，无需再次显示");
    }

    private void af() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter makeRemoteCall");
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.data = "";
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 7;
        aB = true;
        this.f4139l.mo2473a(commonRetOModel, new ad(this));
    }

    private void ag() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter makeCall");
        m7623t();
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Make Call To :", C1462f.m6748k().f3093m);
        if (C1492l.m6913a((Context) this, C1466a.m6778b())) {
            ah();
        } else {
            C1492l.m6910a((Activity) this, C1466a.m6778b());
        }
    }

    private void ah() {
        if (C1462f.m6748k() == null || "".equals(C1462f.m6748k().f3093m)) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=====error to make call to watch,so call up the dial activity");
            startActivity(new Intent("android.intent.action.CALL_BUTTON"));
            return;
        }
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse("tel://" + C1462f.m6748k().f3093m));
        startActivity(intent);
    }

    private void ai() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============Enter showWindowInfo=====");
        if ("".equals(this.aP.trim())) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "======没有位置信息，不显示infoWindow=========");
        } else if (this.f4128Y == null || !this.f4128Y.isVisible()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========realTimePosition is invisable");
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========show windowinfo after 150ms=======");
            this.f4131c.postDelayed(this.cj, 150);
        }
    }

    private void m7520a(ImageView imageView) {
        C2538c.m12680e("KIDWATCH_HomeActivity", "===========Enter setBatteryInfo");
        if (this.aM == null || this.aM.battery == null || "".equals(this.aM.battery)) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "==============Hide battery image");
            imageView.setVisibility(4);
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============mWatchStatus.battery:", this.aM.battery);
        imageView.setVisibility(0);
        if (C1492l.m6919c(this.aM.battery)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=============Battery level :" + this.aM.battery);
            switch (C1492l.m6920d(this.aM.battery)) {
                case 5:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 5");
                    imageView.setImageResource(C1617f.kw_pic_popup_list_battery_empty);
                    return;
                case 25:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 25");
                    imageView.setImageResource(C1617f.kw_pic_popup_list_battery_2);
                    return;
                case 50:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 50");
                    imageView.setImageResource(C1617f.kw_pic_popup_list_battery_3);
                    return;
                case 75:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 75");
                    imageView.setImageResource(C1617f.kw_pic_popup_list_battery_4);
                    return;
                case 100:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 100");
                    imageView.setImageResource(C1617f.kw_pic_popup_list_battery_ful);
                    return;
                default:
                    C2538c.m12680e("KIDWATCH_HomeActivity", "==============Unknown battery level: ", this.aM.battery);
                    imageView.setImageResource(C1617f.kw_pic_popup_list_battery_3);
                    return;
            }
        }
    }

    private void m7521a(ImageView imageView, TextView textView) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========Enter setBatteryOfMenu");
        if (this.aM == null || this.aM.battery == null || "".equals(this.aM.battery)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==============Hide battery image");
            textView.setVisibility(4);
            this.bl.setImageResource(C1617f.kw_pic_battery_no_value);
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============mWatchStatus.battery:", this.aM.battery);
        imageView.setVisibility(0);
        textView.setVisibility(0);
        if (C1492l.m6919c(this.aM.battery)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=============Enter battery switch");
            switch (C1492l.m6920d(this.aM.battery)) {
                case 5:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 5");
                    this.bl.setImageResource(C1617f.kw_pic_battery5);
                    textView.setText("5%");
                    return;
                case 25:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 25");
                    this.bl.setImageResource(C1617f.kw_pic_battery25);
                    textView.setText("25%");
                    return;
                case 50:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 50");
                    this.bl.setImageResource(C1617f.kw_pic_battery50);
                    textView.setText("50%");
                    return;
                case 75:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 75");
                    this.bl.setImageResource(C1617f.kw_pic_battery75);
                    textView.setText("75%");
                    return;
                case 100:
                    C2538c.m12674b("KIDWATCH_HomeActivity", "============== Battery level 100");
                    this.bl.setImageResource(C1617f.kw_pic_battery100);
                    textView.setText("100%");
                    return;
                default:
                    C2538c.m12680e("KIDWATCH_HomeActivity", "==============Unknown battery level: ", this.aM.battery);
                    this.bl.setImageResource(C1617f.kw_pic_battery50);
                    textView.setText("50%");
                    return;
            }
        }
    }

    private void m7522a(TextView textView, TextView textView2) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==============setTimeInfo ");
        String str = "";
        String str2 = "";
        if (this.bx) {
            textView.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_main_positing));
            textView2.setVisibility(8);
            return;
        }
        String str3;
        if (this.aM == null || this.aM.lastLocation == null) {
            str3 = str;
            str = str2;
        } else {
            int d;
            int d2;
            long j;
            int i = 0;
            try {
                long j2 = this.aM.lastLocation.time;
                int d3 = C1492l.m6920d(this.aM.lastLocation.type);
                d = C1492l.m6920d(this.aM.lastLocation.radius);
                d2 = C1492l.m6920d(this.aM.lastLocation.motionType);
                i = d3;
                j = j2;
            } catch (Exception e) {
                d = 0;
                C2538c.m12674b("KIDWATCH_HomeActivity", "======setTimeInfo execption !!!");
                d2 = i;
                i = 0;
                j = 0;
            }
            if (j > 0) {
                str = m7515a(j, d2, this.aM.wearState);
            }
            if ("null".equals(str)) {
                str3 = "";
            } else {
                str3 = str;
            }
            str = m7514a(i, j, d, this.aM.wearState);
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "======time:" + str3);
        C2538c.m12674b("KIDWATCH_HomeActivity", "======positionType:" + str);
        textView.setText(str3 + str);
        textView2.setText("");
        textView2.setVisibility(8);
    }

    private String m7514a(int i, long j, int i2, int i3) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter getPositingType = " + i + ", time = " + j);
        String str = "";
        int c = C1467b.m6787c(this.f4109F);
        C2538c.m12677c("KIDWATCH_HomeActivity", "===www=======current device refreshHomeUI = " + c);
        switch (i3) {
            case 0:
                str = getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_turn_off);
                break;
            case 2:
                if (7 != c) {
                    str = getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_pick_down);
                    break;
                }
                str = "";
                break;
            case 3:
                if (7 != c) {
                    str = getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_wearing);
                    break;
                }
                str = "";
                break;
            default:
                C2538c.m12674b("KIDWATCH_HomeActivity", "=======wearState:" + i3);
                break;
        }
        String str2 = "(";
        switch (i) {
            case 1:
                str2 = str2 + getString(C1680l.IDS_plugin_kidwatch_main_map_compass);
                break;
            case 2:
                str2 = str2 + getString(C1680l.IDS_plugin_kidwatch_main_map_wifi);
                break;
            case 3:
                str2 = str2 + getString(C1680l.IDS_plugin_kidwatch_main_map_mix);
                break;
            case 4:
                str2 = str2 + getString(C1680l.IDS_plugin_kidwatch_main_map_cum);
                break;
            default:
                str2 = str2 + getString(C1680l.IDS_plugin_kidwatch_main_map_mix);
                break;
        }
        if (m7552b(i2) <= 0) {
            return str2 + HwAccountConstants.BLANK + str + ")";
        }
        if ("".equals(str)) {
            return str2 + HwAccountConstants.BLANK + String.format(getString(C1680l.IDS_plugin_kidwatch_main_map_precision), new Object[]{Integer.valueOf(r2)}) + ")";
        }
        return str2 + HwAccountConstants.BLANK + String.format(getString(C1680l.IDS_plugin_kidwatch_main_map_precision), new Object[]{Integer.valueOf(r2)}) + HwAccountConstants.BLANK + str + ")";
    }

    private String m7515a(long j, int i, int i2) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter getTimeToShow reportTime:" + j + "   moveType:" + i + "  wearState:" + i2);
        String str = "";
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(j);
        DateFormat simpleDateFormat = new SimpleDateFormat("dd", Locale.US);
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======currentTime - reportTime:" + (currentTimeMillis - j));
        if (currentTimeMillis - j < 120000 || (1 == i && i2 != 0 && currentTimeMillis - j < 4200000)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======getTimeToShow-->2 min");
            str = getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_current_position);
        } else if (currentTimeMillis - j < LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======getTimeToShow-->2-5 min");
            str = String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_recent_position), new Object[]{((currentTimeMillis - j) / FileWatchdog.DEFAULT_DELAY) + ""});
        } else if (currentTimeMillis - j < 3000000) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======getTimeToShow-->5-50 min");
            str = String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_recent_position), new Object[]{"5"});
        } else {
            DateFormat simpleDateFormat2;
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======getTimeToShow-->more than 50 min");
            int d = C1492l.m6920d(simpleDateFormat.format(Long.valueOf(currentTimeMillis)));
            int d2 = C1492l.m6920d(simpleDateFormat.format(Long.valueOf(j)));
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======curDay:" + d);
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======serverTime:" + d2);
            if (d != d2) {
                simpleDateFormat2 = new SimpleDateFormat("MM-dd HH:mm", Locale.US);
            } else {
                simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.US);
            }
            str = getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_long_position) + simpleDateFormat2.format(date);
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=======Leave getTimeToShow:" + str);
        return str;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        m7590f(true);
        if (i == 4) {
            if (this.bi.isDrawerOpen(this.bj) || this.bi.isDrawerOpen(this.bk)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "======关闭抽屉");
                this.bi.closeDrawers();
                return false;
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======没有抽屉打开");
            if (this.f4137j == 0) {
                C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_common_back_to_exit);
                this.f4137j++;
                this.f4131c.postDelayed(new af(this), 1500);
                return false;
            } else if (this.f4137j >= 1) {
                aq();
                return super.onKeyDown(i, keyEvent);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m7526a(LatLonPoint latLonPoint, String str, boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==================Enter getAddress()");
        C2538c.m12674b("KIDWATCH_HomeActivity", "==================Enter getAddress():" + z);
        this.aO = "";
        this.aP = "";
        RegeocodeQuery regeocodeQuery = new RegeocodeQuery(latLonPoint, 200.0f, GeocodeSearch.AMAP);
        GeocodeSearch geocodeSearch = new GeocodeSearch(this);
        ServiceSettings.getInstance().setProtocol(2);
        geocodeSearch.setOnGeocodeSearchListener(new ag(this, str));
        geocodeSearch.getFromLocationAsyn(regeocodeQuery);
    }

    public boolean handleMessage(Message message) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==== message.what:", message.what + "");
        switch (message.what) {
            case 33:
                C2538c.m12674b("KIDWATCH_HomeActivity", "================ case 中，获取手表状态 ");
                break;
            case 111:
                C2538c.m12674b("KIDWATCH_HomeActivity", "==== handlmessage enter HANDLER_UPDATA_B1B2");
                Iterator it = this.f4148u.iterator();
                while (it.hasNext()) {
                    C1522b c1522b = (C1522b) it.next();
                    C2538c.m12674b("KIDWATCH_HomeActivity", "==wwpp  handlmessage  device list---" + c1522b.toString());
                }
                if (this.f4147t != null) {
                    this.f4149v.m7369a(this.f4148u);
                    break;
                }
                break;
            case 9999:
                Bundle data = message.getData();
                if (data != null) {
                    int i = data.getInt(this.aQ);
                    this.aY = null;
                    this.aZ = -1;
                    this.aO = "";
                    this.aP = "";
                    this.aM = null;
                    m7627v();
                    m7496V();
                    m7593g(false);
                    ab();
                    C1462f.m6752m("");
                    if (this.f4132d != null && this.f4132d.isAdded()) {
                        this.f4132d.f4298d.setVisibility(8);
                        this.f4132d.f4297c.setVisibility(8);
                    }
                    this.f4146s.setDeviceName(((C1522b) this.f4148u.get(i)).m7034a());
                    this.f4145r = ((C1522b) this.f4148u.get(i)).m7041d();
                    C2538c.m12674b("KIDWATCH_HomeActivity", "================updateDeviceCode 4");
                    m7566b(String.valueOf(this.f4145r));
                    ak();
                    m7623t();
                    m7600i(false);
                    m7603j(false);
                    m7519a(null);
                    ar();
                    al();
                    this.aU = 10;
                    m7645g();
                    m7551a(true, true, false);
                    this.f4130b.setVisibility(4);
                    C1638r.m7761b(this.f4109F);
                    C1638r.m7759a(this);
                    m7629w();
                    m7617q();
                    if (this.bw != null) {
                        this.bw.m7672a(C1462f.m6746j());
                    }
                    m7590f(true);
                    aF();
                    break;
                }
                break;
            case 10002:
                C2538c.m12674b("KIDWATCH_HomeActivity", "================ case 中，更新手表头像, No Delete");
                this.f4127X = m7553b(null);
                this.f4128Y.setIcon(BitmapDescriptorFactory.fromBitmap(this.f4127X));
                this.f4127X.recycle();
                break;
            case HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE /*10003*/:
                as();
                break;
            case 10004:
                break;
            case MessageObserver.RET_AUTH_ERROR /*10005*/:
                m7576c(true);
                break;
            case HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION /*10006*/:
                C2538c.m12674b("KIDWATCH_HomeActivity", "===========MSG_INIT_DATA");
                m7476L();
                m7611n();
                break;
            case 10007:
                m7465F();
                break;
            case MessageObserver.RET_CHECK_PARAM_ERROR /*10008*/:
                m7467G();
                break;
            case 10009:
                m7512a(this.aM, message.arg1);
                break;
            case 10010:
                aj();
                break;
            case 10060:
                aH();
                break;
            default:
                C2538c.m12674b("KIDWATCH_HomeActivity", "==== handlmessage enter default");
                break;
        }
        return false;
    }

    private void aj() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========Enter deleteVoiceInDB");
        new Thread(new ah(this)).start();
    }

    private void ak() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========Enter resetMenuView");
        if (this.bj == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========null==leftmenu,return");
            return;
        }
        this.bp = (TextView) this.bj.findViewById(g.menu_tv_update_new);
        this.bq = (AlwaysMarqueeScrollView) this.bj.findViewById(g.menu_tv_update_status);
        if (this.bp != null) {
            this.bp.setVisibility(4);
        }
        if (this.bq != null) {
            this.bq.setVisibility(8);
        }
    }

    private void al() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=============procesConnectedKid");
        if (C1462f.m6748k() != null) {
            m7527a(C1462f.m6748k());
            C1723d a = C1743x.m8322a((Context) this).m8323a();
            if (a == null) {
                C1743x.m8322a((Context) this).m8324a(new C1723d(this, C1462f.m6748k().f3096p));
            } else if (!a.m8281a().equals(C1462f.m6748k().f3096p)) {
                if (2 == a.m8302i()) {
                    a.m8283a(2, new ak(this, a));
                } else {
                    a.m8301h();
                }
                C1743x.m8322a((Context) this).m8324a(new C1723d(this, C1462f.m6748k().f3096p));
            }
            m7485P();
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===========KWCache.curDeviceInfo  NULL");
    }

    public void onLocationChanged(Location location) {
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========网络定位到app当前位置成功");
            Double valueOf = Double.valueOf(aMapLocation.getLatitude());
            Double valueOf2 = Double.valueOf(aMapLocation.getLongitude());
            if (valueOf2.doubleValue() < 73.0d || valueOf2.doubleValue() > 136.0d) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==========定位到的app位置不在国内，不予显示");
                return;
            }
            this.f4131c.removeCallbacks(this.ck);
            m7501X();
            this.f4144q = new LatLng(valueOf.doubleValue(), valueOf2.doubleValue());
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========保存app位置：", this.aN.toJson(this.f4144q));
            C1497q.m6943a(this.f4109F, "main_map_last_app_position", r2);
            C1497q.m6943a(this.f4109F, "menu_last_city_phone", aMapLocation.getCity());
            if (C1497q.m6944b(this.f4109F, "main_map_is_show_app_position").booleanValue()) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==========显示app当前位置marker");
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(valueOf.doubleValue(), valueOf2.doubleValue()));
                this.f4129Z = this.f4141n.addMarker(markerOptions);
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==========开关关闭，不显示app位置");
                if (this.f4129Z != null) {
                    this.f4129Z.setVisible(false);
                }
            }
            if (this.f4128Y == null || this.f4128Y.getPosition() == C1468c.f3413a) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==========将手机位置设置为当前位置");
                this.f4141n.getCameraPosition();
                this.f4141n.animateCamera(CameraUpdateFactory.changeLatLng(this.f4144q), 300, new al(this));
                return;
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========将手机位置设置为当前位置");
        }
    }

    private void m7560b(C1395k c1395k) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==www== addtocontact kidinfo = " + c1395k.toString() + "    ,PortraitUrl = " + c1395k.f3098r);
        new am(this, c1395k).execute(new String[0]);
    }

    public String m7636a(String str) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww== getRawId=");
        Cursor query = getContentResolver().query(Uri.parse("content://com.android.contacts/data/phones/filter/" + str), null, null, null, null);
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex("contact_id")));
                Cursor query2 = getContentResolver().query(RawContacts.CONTENT_URI, new String[]{"_id"}, "contact_id=?", new String[]{String.valueOf(valueOf)}, null);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww== 1rawContactId=" + query2.getString(query2.getColumnIndex("_id")));
                        query2.close();
                        query.close();
                        return query2.getString(query2.getColumnIndex("_id"));
                    }
                    query2.close();
                }
            }
            query.close();
        }
        return "";
    }

    public void m7639a(String str, String str2) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  enter  method --upDateName");
        ArrayList arrayList = new ArrayList();
        arrayList.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{str2 + "", "vnd.android.cursor.item/name"}).withValue("data1", str).build());
        try {
            getContentResolver().applyBatch("com.android.contacts", arrayList);
        } catch (Exception e) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====ERROR! e = " + e.getMessage());
        }
    }

    private void m7547a(String str, String str2, byte[] bArr) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  enter  method --addKidInfoToContact");
        try {
            long parseId = ContentUris.parseId(getContentResolver().insert(RawContacts.CONTENT_URI, this.aS));
            C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  rawContactId=" + parseId);
            if (!"".equals(str)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  enter  method --addKidInfoToContact  name");
                this.aS.clear();
                this.aS.put("raw_contact_id", Long.valueOf(parseId));
                this.aS.put("mimetype", "vnd.android.cursor.item/name");
                this.aS.put("data2", str);
                getContentResolver().insert(Data.CONTENT_URI, this.aS);
            }
            if (!"".equals(str2)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  enter  method --addKidInfoToContact  phoneNum");
                this.aS.clear();
                this.aS.put("raw_contact_id", Long.valueOf(parseId));
                this.aS.put("mimetype", "vnd.android.cursor.item/phone_v2");
                this.aS.put("data1", str2);
                this.aS.put("data2", Integer.valueOf(2));
                getContentResolver().insert(Data.CONTENT_URI, this.aS);
            }
            if (bArr != null) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  enter  method --addKidInfoToContact  data");
                this.aS.put("raw_contact_id", Long.valueOf(parseId));
                this.aS.put("mimetype", "vnd.android.cursor.item/photo");
                this.aS.put("data15", bArr);
                getContentResolver().insert(Data.CONTENT_URI, this.aS);
            }
        } catch (Exception e) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==ww==  enter  method --addKidInfoToContact  Exception = " + e.getMessage());
        }
    }

    private void m7596h(boolean z) {
        if (this.bv != null) {
            this.bv.setEnabled(z);
        }
    }

    public View getInfoContents(Marker marker) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=============Enter getInfoContents");
        View inflate = getLayoutInflater().inflate(h.watch_status_layout, null);
        m7638a(marker, inflate);
        return inflate;
    }

    public View getInfoWindow(Marker marker) {
        return null;
    }

    public void m7638a(Marker marker, View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=============Enter render");
        C2538c.m12674b("KIDWATCH_HomeActivity", "render->streetNameText:" + this.aO);
        C2538c.m12674b("KIDWATCH_HomeActivity", "render->Enter buildNameText:" + this.aP);
        TextView textView = (TextView) view.findViewById(g.main_tv_street_position);
        TextView textView2 = (TextView) view.findViewById(g.main_tv_street_position_down);
        ((TextView) view.findViewById(g.main_tv_time)).setMaxWidth(this.aT - C1492l.m6901a(this.f4109F, (float) BitmapDescriptorFactory.HUE_GREEN));
        textView.setMaxWidth(this.aT - C1492l.m6901a(this.f4109F, (float) BitmapDescriptorFactory.HUE_GREEN));
        textView2.setMaxWidth(this.aT - C1492l.m6901a(this.f4109F, (float) BitmapDescriptorFactory.HUE_GREEN));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.main_linar_status_listen);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(g.main_liner_status_left);
        TextView textView3 = (TextView) view.findViewById(g.main_tv_time);
        TextView textView4 = (TextView) view.findViewById(g.main_tv_position_type);
        ImageView imageView = (ImageView) view.findViewById(g.main_im_battery);
        this.bv = (ImageButton) view.findViewById(g.main_im_status_listen);
        m7596h(!f4103g);
        m7522a(textView3, textView4);
        m7520a(imageView);
        if (this.aM == null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "render->null == mWatchStatus");
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            return;
        }
        if ("".equals(this.aP)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "render->buildNameText 6");
            C2538c.m12674b("KIDWATCH_HomeActivity", "render->buildNameText is not ...");
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            view.setVisibility(8);
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "render->buildNameText 1");
            textView.setVisibility(0);
            if (this.aP.equals(getString(C1680l.IDS_plugin_kidwatch_main_map_not_connected))) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "render->buildNameText 4");
                textView.setText(this.aP);
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "render->buildNameText 5");
                textView.setText(this.aP + getResources().getString(C1680l.IDS_plugin_kidwatch_main_map_position_nearby));
            }
            if ("".equals(this.aO)) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "render->buildNameText 2");
                textView2.setVisibility(8);
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "render->buildNameText 3");
                textView2.setVisibility(0);
                textView2.setText(this.aO);
            }
        }
        this.bv.setOnClickListener(new ao(this));
    }

    protected void onNewIntent(Intent intent) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "====================Enter onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        this.f4126W = true;
        this.f4109F = this;
        this.aU = 10;
        if (intent.getBooleanExtra("is_from_notification", false)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========Come From Notification  onNewIntent");
            int intExtra = intent.getIntExtra("devicecode_from_notification", 0);
            C2538c.m12674b("KIDWATCH_HomeActivity", "=========onNewIntent Modify devicecode in SharedPreferences, deviceCode:" + intExtra);
            if (intExtra != 0) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=========onNewIntent Modify devicecode in SharedPreferences, deviceCode:" + intExtra);
                C1497q.m6943a(this.f4109F, "sharedpreferences_watch_device_code", intExtra + "");
            }
        }
        ap();
        if (C1497q.m6944b(this.f4109F, "resutunbindall").booleanValue()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "======1关闭抽屉");
            this.bi.closeDrawers();
            C1497q.m6942a(this.f4109F, "resutunbindall", Boolean.valueOf(false));
            return;
        }
        mo2517a();
    }

    private void m7600i(boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter getRewardInfo");
        GetRewardInfoRetModel getRewardInfoRetModel = new GetRewardInfoRetModel();
        getRewardInfoRetModel.deviceCode = C1462f.m6746j();
        this.f4139l.mo2484a(getRewardInfoRetModel, new ap(this, z));
    }

    private void m7603j(boolean z) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========== Enter getRewardGoalFromCloud");
        if (C1483c.m6831b(C1462f.m6746j())) {
            GetWatchSettingModel getWatchSettingModel = new GetWatchSettingModel();
            getWatchSettingModel.deviceCode = C1462f.m6746j();
            getWatchSettingModel.settingType = "rewardGoal";
            this.f4139l.mo2487a(getWatchSettingModel, new aq(this, z));
            return;
        }
        C2538c.m12677c("KIDWATCH_HomeActivity", "=========== getRewardGoalFromCloud deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
    }

    private void am() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter procressRewardResult()");
        if (this.aY == null || -1 == this.aZ) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========Error happened in procressRewardResult");
            ao();
        } else if (this.aY.getGoal() <= 0) {
            ao();
        } else {
            m7529a(this.aY);
        }
    }

    private void an() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============Enter gotoReward");
        if (!C1492l.m6916b(this.f4109F)) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "========== Network is unavailable");
            C1483c.m6824a(this.f4109F, C1680l.IDS_plugin_kidwatch_common_network_disable);
        } else if (this.aY == null || -1 == this.aZ) {
            C1506g.m6978a(this.f4109F, getResources().getString(C1680l.IDS_plugin_kidwatch_menu_peroid_get_data), false);
            m7600i(true);
        } else if (this.aY.getGoal() < 5) {
            ao();
        } else {
            m7529a(this.aY);
        }
    }

    private void ao() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========== Enter gotoSetRewardGoalActivity");
        Intent intent = new Intent();
        intent.setFlags(1);
        intent.setClass(this, SetRewardGoalActivity.class);
        startActivity(intent);
    }

    private void m7529a(RewardGoal rewardGoal) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========== Enter gotoRewaedActivity");
        if (rewardGoal == null) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "==========model is NULL");
            return;
        }
        RewardGoal rewardGoal2 = new RewardGoal();
        rewardGoal2.setReward(rewardGoal.getReward());
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========babyHope2 没有反base64前:" + rewardGoal2.getReward());
        rewardGoal2.setGoal(rewardGoal.getGoal());
        Intent intent = new Intent();
        intent.setFlags(1);
        intent.putExtra("new_goal", rewardGoal2.getGoal());
        intent.putExtra("new_hope", rewardGoal2.getReward());
        intent.putExtra("notification_reward_reward_goal", this.aZ);
        intent.setClass(this, RewardActivity.class);
        startActivity(intent);
    }

    private void ap() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============Enter closeBoneActivity");
        Intent intent = new Intent();
        intent.setAction(BaseActivity.CLEAN_ACTIVITY);
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f4109F);
        if (instance != null) {
            instance.sendBroadcast(intent);
        }
    }

    private void aq() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "============Enter closeKoneActivity");
        C1497q.m6942a((Context) this, "kidwatch_antiloss_state", Boolean.valueOf(false));
        m7488R();
        Intent intent = new Intent();
        intent.setAction("golbal_finish_all_kidwatch_activity");
        LocalBroadcastManager.getInstance(this.f4109F).sendBroadcast(intent);
    }

    private void ar() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "========Enter startAnimation");
        if (!this.f4153z && !this.f4152y.getCartoomState()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "========Enter startAnimation 11111");
            this.f4152y.setVisibility(0);
            this.f4152y.m7199a(20);
            this.f4153z = true;
            this.aq.setClickable(false);
        }
    }

    private void as() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========Enter clearAnimation");
        this.f4152y.m7198a();
        this.f4153z = false;
        this.aq.setClickable(true);
    }

    private void at() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "======Enter qstnSurveyInit");
        if (com.huawei.q.a.a.a()) {
            if (this.aM != null) {
                j.c(this.aM.version);
                C2538c.m12674b("KIDWATCH_HomeActivity", "========version:" + this.aM.version);
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "========mWatchStatus is null");
            }
            if (C1492l.m6916b(this.f4109F)) {
                C2442a.m12225a(this.f4109F).m12270b();
                return;
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "======Network is disabled");
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=========qstnSurveyInit-->没有选中用户体验改进计划，return");
    }

    private void au() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====Enter getAllPushMessage");
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.receiver.LoopVoiceReceiver");
        sendBroadcast(intent, "com.huawei.bone.permission.LOCAL_BROADCAST");
    }

    private void m7548a(String str, boolean z) {
        int i = 0;
        C2538c.m12674b("KIDWATCH_HomeActivity", "========= Enter setDeviceSettingsInfo!");
        if (z) {
            i = 1;
        }
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        Map hashMap = new HashMap();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        hashMap.put(str, Integer.valueOf(i));
        setWatchSettingIOModel.settingMap = hashMap;
        m7530a(setWatchSettingIOModel, str, z);
    }

    private void m7530a(SetWatchSettingIOModel setWatchSettingIOModel, String str, boolean z) {
        if (this.f4139l != null) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========Enter sendDevcieSettingsInfoToCloud");
            this.f4139l.mo2496a(setWatchSettingIOModel, new at(this));
        }
    }

    private void av() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========setCloudSettingWatchLogReport send 1111");
        if (C1490j.m6890a("MTCS_UploadLog") && C1462f.m6754n()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==========setCloudSettingWatchLogReport send 2222");
            m7548a("LogSwitch", com.huawei.q.a.a.a());
        }
    }

    private void aw() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation====Enter skipToThirdApp");
        ad b = C1392h.m6289b(this.f4109F, C1462f.m6744i(), C1462f.m6746j());
        if (b != null) {
            this.bO = Double.valueOf(b.m6232c());
            this.bP = Double.valueOf(b.m6234d());
        }
        if (C1462f.m6748k() != null) {
            this.bQ = C1462f.m6748k().f3083c;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation== position：" + this.f4144q);
        if (this.f4144q != null) {
            this.bR = Double.valueOf(this.f4144q.latitude);
            this.bS = Double.valueOf(this.f4144q.longitude);
        } else {
            this.bR = Double.valueOf(34.99148d);
            this.bS = Double.valueOf(108.998328d);
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation==initKid_infomation:myLat=" + this.bR + ",myLon=" + this.bS);
        ax();
    }

    private void ax() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation====Enter initSkipView()");
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation====type" + C1491k.m6898b(this.f4109F, "save_navigation_map"));
        switch (C1491k.m6898b(this.f4109F, "save_navigation_map")) {
            case 0:
                C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation======skipToNet：");
                if (C1483c.m6826a(getApplication(), "com.autonavi.minimap")) {
                    az();
                    C1491k.m6895a(this.f4109F, "save_navigation_map", 1);
                    return;
                } else if (!C1483c.m6826a(getApplication(), "com.baidu.BaiduMap")) {
                    aA();
                    return;
                } else if (!isFinishing()) {
                    C1491k.m6895a(this.f4109F, "save_navigation_map", 5);
                    aB();
                    return;
                } else {
                    return;
                }
            case 1:
                C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation======skipToNet：");
                this.bX.setChecked(true);
                this.bY.setChecked(false);
                if (C1483c.m6826a(getApplication(), "com.autonavi.minimap")) {
                    az();
                    C1491k.m6895a(this.f4109F, "save_navigation_map", 1);
                    return;
                } else if (!C1483c.m6826a(getApplication(), "com.baidu.BaiduMap")) {
                    aA();
                    return;
                } else if (!isFinishing()) {
                    aB();
                    C1491k.m6895a(this.f4109F, "save_navigation_map", 5);
                    return;
                } else {
                    return;
                }
            case 2:
                C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation======baiduMap：");
                this.bX.setChecked(false);
                this.bY.setChecked(true);
                if (C1483c.m6826a(getApplication(), "com.baidu.BaiduMap")) {
                    ay();
                    C1491k.m6895a(this.f4109F, "save_navigation_map", 2);
                    return;
                } else if (!C1483c.m6826a(getApplication(), "com.autonavi.minimap")) {
                    aA();
                    return;
                } else if (!isFinishing()) {
                    aB();
                    C1491k.m6895a(this.f4109F, "save_navigation_map", 5);
                    return;
                } else {
                    return;
                }
            case 5:
                C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation====Enter no choice map");
                this.bX.setChecked(false);
                this.bY.setChecked(false);
                if (C1483c.m6826a(this.f4109F, "com.baidu.BaiduMap") || C1483c.m6826a(this.f4109F, "com.autonavi.minimap")) {
                    aB();
                    return;
                } else {
                    aA();
                    return;
                }
            default:
                return;
        }
    }

    private void ay() {
        String str;
        C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==Enter method SkipToBaiduApp()");
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation==kid==baidumap:kidLat=" + this.bO + ",kidLog=" + this.bP + ",kidName=" + this.bQ);
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation==kid==baidumap:distance=" + C1483c.m6820a(this.bR.doubleValue(), this.bS.doubleValue(), this.bO.doubleValue(), this.bP.doubleValue()));
        String str2 = "";
        if (2.0d >= C1483c.m6820a(this.bR.doubleValue(), this.bS.doubleValue(), this.bO.doubleValue(), this.bP.doubleValue())) {
            str = "walking";
        } else {
            str = "driving";
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation==kid==baidumap:mode=" + str);
        C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==Enter method SkipToGaodeApp()  baiduAppUri= " + ("intent://map/direction?origin=latlng:" + this.bR + "," + this.bS + "|name:我的位置&destination=latlng:" + this.bO + "," + this.bP + "|name:" + this.bQ + "的位置&mode=" + str + "&coord_type=gcj02&src=com.huawei.bone#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end"));
        try {
            startActivity(Intent.getIntent("intent://map/direction?origin=latlng:" + this.bR + "," + this.bS + "|name:我的位置&destination=latlng:" + this.bO + "," + this.bP + "|name:" + this.bQ + "的位置&mode=" + str + "&coord_type=gcj02&src=com.huawei.bone#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end"));
        } catch (URISyntaxException e) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==URISyntaxException e" + e.getMessage());
        }
    }

    private void az() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==Enter method SkipToGaodeApp() ");
        try {
            C2538c.m12674b("KIDWATCH_HomeActivity", "===navigation==kidGaode==location:kidLat=" + this.bR + ",kidLog=" + this.bR + ",kidName=" + this.bQ);
            C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==Enter method SkipToGaodeApp()  gaodeMapAppUri= " + ("androidamap://route?sourceApplication=softname&slat=" + this.bR + "&slon=" + this.bS + "&sname=我的位置&dlat=" + this.bO + "&dlon=" + this.bP + "&dname=" + this.bQ + "的位置&dev=0&m=1&t=2"));
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(r0));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage("com.autonavi.minimap");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C1483c.m6828b((Context) this, C1680l.IDS_confirm_intent_action);
            C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==leave method SkipToGaodeApp() ActivityNotFoundException e!!!");
        }
    }

    private void aA() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==Enter method SkipToNetApp() ");
        try {
            C1491k.m6895a(this.f4109F, "save_navigation_map", 0);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://wap.amap.com/?type=smpz01"));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C1483c.m6828b((Context) this, C1680l.IDS_confirm_intent_action);
            C2538c.m12674b("KIDWATCH_HomeActivity", "==navigation==Leave method SkipToNetApp() ActivityNotFoundException e");
        }
    }

    private void aB() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww== get fetchChangeLog = success==showDialog");
        if (!isFinishing() && this.bT != null) {
            aE();
            this.bT.show();
        }
    }

    private void aC() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww== get fetchChangeLog = success==initMapChoiceDialog()");
        if (this.bT == null) {
            this.bT = new C1507h(this.f4109F, SdkConstants.REQUEST_CAMERA_VIDEO, 226, h.dialog_navigation_choice_map, m.servicedialog, false);
        }
        aD();
    }

    private void aD() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "Enter initDialogContent");
        this.bU = (LinearLayout) this.bT.findViewById(g.layout_gaode_map_linearLayout);
        this.bV = (LinearLayout) this.bT.findViewById(g.layout_baidu_map_linearLayout);
        this.bW = (LinearLayout) this.bT.findViewById(g.layout_no_map_linearLayout);
        this.bX = (CheckBox) this.bT.findViewById(g.layout_gaode_map_radio);
        this.bY = (CheckBox) this.bT.findViewById(g.layout_baidu_map_radio);
        this.bZ = (TextView) this.bT.findViewById(g.menu_setting_navigation_cancle);
        this.bU.setOnClickListener(this.cv);
        this.bV.setOnClickListener(this.cw);
        this.bZ.setOnClickListener(this.cx);
        aE();
    }

    private void aE() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==map==Enter dialogContent()");
        if (C1483c.m6826a(this.f4109F, "com.baidu.BaiduMap") || C1483c.m6826a(this.f4109F, "com.autonavi.minimap")) {
            if (C1483c.m6826a(this.f4109F, "com.baidu.BaiduMap")) {
                this.bV.setVisibility(0);
            } else {
                this.bV.setVisibility(8);
                this.bW.setVisibility(8);
            }
            if (C1483c.m6826a(this.f4109F, "com.autonavi.minimap")) {
                this.bU.setVisibility(0);
                return;
            }
            this.bU.setVisibility(8);
            this.bW.setVisibility(8);
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "==map==Enter no map");
        C1491k.m6895a(this.f4109F, "save_navigation_map", 5);
    }

    public boolean m7641a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ca < j) {
            return true;
        }
        this.ca = currentTimeMillis;
        return false;
    }

    public void mo2519e() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==ww===enter  refreshAbility");
        String str = C1462f.m6746j() + "CONTACTNUM";
        int b = C1490j.m6891b("ABS_MaxNum");
        C2538c.m12674b("KIDWATCH_HomeActivity", " ===============haveNumSpecifyAbility Ability contactNum : " + b);
        if (b > -1) {
            C2538c.m12674b("KIDWATCH_HomeActivity", " ===============haveNumSpecifyAbility insert SharedPreferencesUtil " + b);
            C1497q.m6947b(this.f4109F, str, b - 5);
        }
    }

    private void aF() {
        C1395k k = C1462f.m6748k();
        if (k.f3093m == null || "".equals(k.f3093m)) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "==ww== bindDeviceInfo.SimCardNum is null ");
            if (C1462f.m6754n() && C1483c.m6830b(this.f4109F, this.f4138k)) {
                aG();
            }
        }
    }

    private void aG() {
        if (this.bf == null || !this.bf.isShowing()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter showWatchPhoneNumNullNoticeDialog");
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_common_tips);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_main_watch_phone_num_is_null_notice);
            c1595v.m7347a(false);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_main_watch_phone_num_is_null_sure, new az(this));
            c1595v.m7342a(new ba(this));
            this.bf = c1595v.m7338a();
            this.bf.show();
        }
    }

    private void aH() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "autoCheckAppNewVersionService()");
        this.cb.m11733b();
    }

    private void aI() {
        C2538c.m12674b("KIDWATCH_HomeActivity", "registerAutoCheckBroadcast()");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_band_auto_check_new_version_result");
        registerReceiver(this.cy, intentFilter, C0976c.f1642a, null);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "Activity-onRequestPermissionsResult() PermissionsManager.notifyPermissionsChange()");
        com.huawei.hwcommonmodel.d.a.b.a().a(strArr, iArr);
        switch (i) {
            case 1:
                Map hashMap = new HashMap();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "permissions = ", strArr[i2], ", grantResults = ", Integer.valueOf(iArr[i2]));
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (hashMap.containsKey("android.permission.CALL_PHONE")) {
                    if (((Integer) hashMap.get("android.permission.CALL_PHONE")).intValue() == 0) {
                        ah();
                        return;
                    }
                    return;
                } else if (!hashMap.containsKey("android.permission.ACCESS_COARSE_LOCATION") && !hashMap.containsKey("android.permission.ACCESS_FINE_LOCATION")) {
                    return;
                } else {
                    if ((((Integer) hashMap.get("android.permission.ACCESS_COARSE_LOCATION")).intValue() == 0 || ((Integer) hashMap.get("android.permission.ACCESS_FINE_LOCATION")).intValue() == 0) && this.cc) {
                        m7468H();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    public void m7644f() {
        c.a().a(C1093a.m4739a(this.f4109F).m4750c());
    }

    public void m7645g() {
        com.huawei.l.a.a aVar = new com.huawei.l.a.a();
        C1395k k = C1462f.m6748k();
        if (k != null) {
            aVar.b(k.f3096p);
            aVar.a(1 == C1492l.m6920d(k.f3099s) ? "K2" : "K1");
        }
        aVar.c(C1491k.m6899b(this.f4109F, C1462f.m6746j() + "beforeVersion", ""));
        c.a().a(aVar);
    }

    private void aJ() {
        if (com.huawei.ui.main.stories.a.a.a.a(this.f4109F).a()) {
            C2538c.m12677c("KIDWATCH_HomeActivity", "IS Login!");
            return;
        }
        C2538c.m12677c("KIDWATCH_HomeActivity", "IS NOT Login!");
        aK();
    }

    private void aK() {
        if (this.bg == null || !this.bg.isShowing()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=======Enter showAppReLoginDialog");
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_common_tips);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_main_relogin_notice);
            c1595v.m7347a(false);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new bc(this));
            c1595v.m7342a(new bd(this));
            this.bg = c1595v.m7338a();
            this.bg.show();
        }
    }
}
