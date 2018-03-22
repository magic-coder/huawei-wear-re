package com.huawei.ui.homewear21.p175a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.ab.C0630m;
import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.g.a.v;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.c.d;
import com.huawei.hwcloudmodel.model.unite.SyncKey;
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordReq;
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetPrivacyRecordReq;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdatamigrate.hihealth.c.bd;
import com.huawei.hwdatamigrate.hihealth.p067c.be;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.hwfitnessmgr.receiver.SyncFitnessDetailDataBroadcastReceiver;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.hwversionmgr.utils.C1080f;
import com.huawei.l.a.a;
import com.huawei.l.a.c;
import com.huawei.login.ui.login.C1093a;
import com.huawei.nfc.PluginPay;
import com.huawei.p030d.p031a.C0800a;
import com.huawei.p085j.C1089a;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.ui.commonui.dialog.ao;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.webview.WebViewActivity;
import com.huawei.ui.device.activity.adddevice.AddDeviceActivity;
import com.huawei.ui.device.activity.update.BandUpdateDialogActivity;
import com.huawei.ui.device.activity.update.UpdateVersionActivity;
import com.huawei.ui.device.p170a.C1975c;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.p170a.C1996x;
import com.huawei.ui.device.p170a.C1998z;
import com.huawei.ui.device.p170a.ae;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.device.p170a.ar;
import com.huawei.ui.device.views.p174c.C2192a;
import com.huawei.ui.device.views.p174c.C2194c;
import com.huawei.ui.homewear21.b;
import com.huawei.ui.homewear21.card.p176a.C2243a;
import com.huawei.ui.homewear21.card.p176a.C2247e;
import com.huawei.ui.homewear21.card.p176a.C2254l;
import com.huawei.ui.homewear21.card.views.PariedDevicesSwitcher;
import com.huawei.ui.homewear21.e;
import com.huawei.ui.homewear21.f;
import com.huawei.ui.homewear21.g;
import com.huawei.ui.homewear21.h;
import com.huawei.ui.homewear21.i;
import com.huawei.ui.homewear21.j;
import com.huawei.ui.main.stories.about.p179a.C2286h;
import com.huawei.ui.main.stories.downloadhihealth.activity.HealthStartActivity;
import com.huawei.ui.main.stories.guide.p181a.C2378a;
import com.huawei.ui.main.stories.lightcloud.LightCloud;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.ui.main.stories.p177a.p178a.C2278b;
import com.huawei.ui.main.stories.settings.p185a.C2460a;
import com.sina.weibo.sdk.constant.WBConstants;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HomeFragment */
public class C2217a extends Fragment implements OnRequestPermissionsResultCallback {
    private static C1204c f7990W = null;
    private static C1975c f7991X = null;
    private static ExecutorService aB = Executors.newFixedThreadPool(4);
    private static int aC = 0;
    private static String[] aM = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.CALL_PHONE"};
    private static String[] aN = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CALL_PHONE"};
    private static a af = null;
    private static WeakReference<DrawerLayout> at = null;
    private static WeakReference<FrameLayout> au = null;
    private static com.huawei.hwcloudmodel.callback.a<AddPrivacyRecordRsp> bI = new bk();
    private Context f7992A;
    private LocalBroadcastManager f7993B;
    private u f7994C;
    private u f7995D;
    private boolean f7996E = false;
    private HandlerThread f7997F = null;
    private cd f7998G = null;
    private C2378a f7999H;
    private int f8000I = 1;
    private Animation f8001J = null;
    private Animation f8002K = null;
    private boolean f8003L = false;
    private C1990r f8004M;
    private C2286h f8005N;
    private ae f8006O;
    private String f8007P = "";
    private ScrollView f8008Q;
    private boolean f8009R = false;
    private d f8010S;
    private u f8011T = null;
    private CustomAlertDialog f8012U = null;
    private c f8013V = null;
    private ar f8014Y;
    private ah f8015Z;
    C2460a f8016a = null;
    private List<MessageObject> aA = new ArrayList();
    private String aD = "";
    private int aE = 0;
    private String aF = "";
    private Boolean aG = Boolean.valueOf(false);
    private String aH = "";
    private Boolean aI = Boolean.valueOf(false);
    private Boolean aJ = Boolean.valueOf(false);
    private Boolean aK = Boolean.valueOf(false);
    private u aL = null;
    private View aO = null;
    private ImageView aP = null;
    private TextView aQ = null;
    private View aR = null;
    private TextView aS = null;
    private ImageView aT = null;
    private Pattern aU;
    private u aV = null;
    private Object aW = new Object();
    private Object aX = new Object();
    private boolean aY = false;
    private View aZ = null;
    private C2278b aa;
    private String ab = "";
    private int ac = 0;
    private String ad = "";
    private Boolean ae = Boolean.valueOf(false);
    private DeviceInfo ag = null;
    private String ah = "";
    private ListView ai;
    private ListView aj;
    private ArrayList<C2194c> ak = new ArrayList();
    private ArrayList<C2194c> al = new ArrayList();
    private C2192a am;
    private C2192a an;
    private DeviceCapability ao = null;
    private C1998z ap;
    private u aq;
    private com.huawei.ui.commonui.dialog.a ar;
    private LinearLayout as;
    private int av = 0;
    private boolean aw = false;
    private int ax = -1;
    private long ay = 0;
    private C2254l az = null;
    public View f8017b = null;
    private AnimationListener bA = new aj(this);
    private AnimationListener bB = new ak(this);
    private final BroadcastReceiver bC = new at(this);
    private final BroadcastReceiver bD = new au(this);
    private BroadcastReceiver bE = new aw(this);
    private IBaseResponseCallback bF = new ax(this);
    private final BroadcastReceiver bG = new bg(this);
    private final BroadcastReceiver bH = new bh(this);
    private List<bz> bJ = new ArrayList();
    private ImageView ba = null;
    private View bb = null;
    private ImageView bc = null;
    private int bd = -1;
    private ai be = null;
    private View bf;
    private C2247e bg;
    private ce bh = new C2218b(this, this);
    private boolean bi = false;
    private boolean bj = false;
    private OnClickListener bk = new bx(this);
    private OnItemClickListener bl = new C2220d(this);
    private OnItemClickListener bm = new C2221e(this);
    private OnCheckedChangeListener bn = new C2222f(this);
    private OnCheckedChangeListener bo = new C2224h(this);
    private OnCheckedChangeListener bp = new C2226j(this);
    private OnCheckedChangeListener bq = new C2228l(this);
    private OnClickListener br = new C2230n(this);
    private OnClickListener bs = new C2231o(this);
    private OnClickListener bt = new C2232p(this);
    private Handler bu = new C2234r(this);
    private Runnable bv = new C2238v(this);
    private final BroadcastReceiver bw = new ad(this);
    private final BroadcastReceiver bx = new ae(this);
    private final BroadcastReceiver by = new af(this);
    private final BroadcastReceiver bz = new ag(this);
    private View f8018c;
    private PariedDevicesSwitcher f8019d;
    private ImageView f8020e;
    private Button f8021f;
    private TextView f8022g;
    private RelativeLayout f8023h;
    private ImageView f8024i;
    private TextView f8025j;
    private ImageView f8026k;
    private ImageView f8027l;
    private TextView f8028m;
    private LinearLayout f8029n;
    private LinearLayout f8030o;
    private FrameLayout f8031p;
    private LinearLayout f8032q;
    private LinearLayout f8033r;
    private TextView f8034s;
    private TextView f8035t;
    private TextView f8036u;
    private TextView f8037v;
    private View f8038w;
    private ViewStub f8039x;
    private View f8040y;
    private Context f8041z;

    public C2217a(DrawerLayout drawerLayout, FrameLayout frameLayout) {
        if (drawerLayout == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "drawer is null");
        } else {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "drawer is not null");
            C2217a.m11449a(drawerLayout);
        }
        if (frameLayout == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "frame is null");
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "frame is not null");
        C2217a.m11450a(frameLayout);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onCreateView time:", Long.valueOf(System.currentTimeMillis()));
        View a = m11438a(layoutInflater, viewGroup);
        this.f8041z = getActivity();
        this.f7992A = BaseApplication.m2632b();
        this.bg = new C2247e(this.f8041z, this.f8018c);
        this.f7993B = LocalBroadcastManager.getInstance(BaseApplication.m2632b());
        this.f8004M = C1990r.m10400a(this.f7992A);
        this.f8005N = C2286h.m11749a();
        this.f7999H = new C2378a(this.f7992A);
        this.f8006O = new ae(this.f7992A);
        m11406K();
        this.ag = C2243a.m11601a().m11614c();
        m11416P();
        this.f8010S = d.a(this.f8041z);
        if (this.ag != null) {
            this.f8007P = this.ag.getUUID();
            this.f8019d.m11687a(new DeviceInfo[0]);
            m11485b(this.ag);
            if (2 == this.ag.getDeviceConnectState()) {
                this.f8009R = true;
            } else {
                this.f8009R = false;
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onCreateView isConnected:" + this.f8009R + " state:" + this.ag.getDeviceConnectState());
        }
        this.f7997F = new HandlerThread("HomeFragment");
        this.f7997F.start();
        this.f7998G = new cd(this.f7997F.getLooper(), this);
        this.f7998G.post(this.bh);
        this.bu.sendEmptyMessageDelayed(1018, 1500);
        this.as.setVisibility(8);
        m11540a();
        m11549d();
        an();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Leave onCreateView time:", Long.valueOf(System.currentTimeMillis()));
        m11564u();
        c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.a.a(), new HashMap(), 0);
        return a;
    }

    private void m11532w() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter weakRunnableRun");
        m11412N();
        if (this.f7996E) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "onCreateView() if (mifNoNeedLogin)");
            C0630m.m2297a(this.f7992A).m2315b(this.f7992A);
            m11538z();
        } else {
            m11536y();
        }
        this.f8016a.m12300b();
        m11535x();
        this.bu.sendEmptyMessageDelayed(1022, 2000);
    }

    private void m11535x() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter checkMigrateData");
        Intent intent = new Intent();
        intent.setPackage(this.f8041z.getPackageName());
        intent.setAction("com.huawei.bone.service.check_data_to_migrate");
        this.f8041z.startService(intent);
    }

    private void m11536y() {
        com.huawei.ui.main.stories.a.a.a a = com.huawei.ui.main.stories.a.a.a.a(this.f8041z);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "IS Login!" + a.a());
        m11538z();
    }

    private void m11538z() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "enterHomeFragmentLoggedProcess()!");
        m11401H();
        C2538c.m12674b("HomeFragment", "dataSync 2");
        ao();
        aX();
        aW();
        m11386A();
    }

    private void m11386A() {
        C2538c.m12674b("HomeFragment", "enter notificationAlert");
        this.ao = this.f8004M.m10411a();
        if (this.ao != null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "enter notificationAlert isMessage_alert = " + this.ao.isMessage_alert());
            if (this.f8006O != null) {
                DeviceInfo c = C2243a.m11601a().m11614c();
                if (c != null && 2 == c.getDeviceConnectState() && this.ao != null && this.ao.isMessage_alert()) {
                    boolean a = this.f8006O.m10304a();
                    C2538c.m12661a("MainUI", 0, "HomeFragment", "isClosed:  " + a + "isAchieve: " + m11391C());
                    if (!a && r1) {
                        m11465a(bz.NOTIFICATION);
                        m11470a(C1080f.m4595a(), this.f8041z);
                    }
                }
            }
        }
    }

    private void m11388B() {
        u a = new w(this.f8041z).a(i.IDS_service_area_notice_title).b(this.f8041z.getString(i.IDS_nottification_settings_remind)).a(i.IDS_yes, new ac(this)).b(i.IDS_no, new C2233q(this)).a();
        a.setCancelable(false);
        if (!a.isShowing() && !getActivity().isFinishing()) {
            a.show();
        }
    }

    private boolean m11391C() {
        String a = C0996a.m3612a(this.f8041z, String.valueOf(10000), "sp_dialog_check_time");
        C2538c.m12661a("MainUI", 0, "HomeFragment", "isEnableDialog: strLastTime = " + a);
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        Date c = C1080f.m4604c(a);
        if (c == null) {
            return true;
        }
        if (Math.abs(System.currentTimeMillis() - c.getTime()) <= 86400000) {
            return false;
        }
        return true;
    }

    private void m11470a(String str, Context context) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "setDialogCheckTime,time-----------" + str);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(context, String.valueOf(10000), "sp_dialog_check_time", str, c0993c);
    }

    private boolean m11393D() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenEsimOrAddDevice enter");
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenEsimOrAddDevice openSim:" + new C2378a(BaseApplication.m2632b()).m12004h());
        return new C2378a(BaseApplication.m2632b()).m12004h();
    }

    public void m11540a() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenEsimOrAddDevice enter");
        if (m11393D()) {
            this.bi = false;
            if (m11547b()) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenEsimOrAddDevice the device is leo");
                return;
            }
            this.bi = true;
            C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenEsimOrAddDevice the device is not leo");
            Intent intent = new Intent(this.f7992A, AddDeviceActivity.class);
            intent.putExtra("KEY_ANROIDWEAR_OPEN_ESIM_FLAG", true);
            super.startActivity(intent);
        }
    }

    public boolean m11547b() {
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        this.ag = C2243a.m11601a().m11614c();
        if (this.ag == null || 10 != this.ag.getProductType()) {
            return false;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "leoOpenEsim producttype: " + this.ag.getProductType());
        C2538c.m12661a("MainUI", 0, "HomeFragment", "leoOpenEsim isConnected: " + this.f8009R);
        if (!this.f8009R) {
            return true;
        }
        this.ao = this.f8004M.m10411a();
        if (this.ao != null) {
            C2538c.m12661a("MainUI", 1, "HomeFragment", "leoOpenEsim isSuppport ESim: " + this.ao.isSupportEsim());
            if (this.ao.isSupportEsim()) {
                m11430W();
            }
            c2378a.m12003h(false);
            return true;
        }
        C2538c.m12661a("MainUI", 1, "HomeFragment", "leoOpenEsim null ==deviceCapability ");
        return true;
    }

    private void m11394E() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenEsim enter");
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenEsim openSim:" + c2378a.m12004h());
        if (m11393D()) {
            m11547b();
        }
    }

    public boolean m11548c() {
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        this.ag = C2243a.m11601a().m11614c();
        if (this.ag == null || 10 != this.ag.getProductType()) {
            return false;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "leoOpenEsim producttype: " + this.ag.getProductType());
        C2538c.m12661a("MainUI", 0, "HomeFragment", "leoOpenEsim isConnected: " + this.f8009R);
        if (!this.f8009R) {
            return true;
        }
        this.ao = this.f8004M.m10411a();
        if (this.ao != null) {
            C2538c.m12661a("MainUI", 1, "HomeFragment", "isSupportPay isSupportPay: " + this.ao.isSupportPay());
            if (this.ao.isSupportPay()) {
                m11428V();
            }
            c2378a.m12003h(false);
            return true;
        }
        C2538c.m12661a("MainUI", 1, "HomeFragment", "leoOpenEsim null ==deviceCapability ");
        return true;
    }

    private void m11396F() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenWallet enter");
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenWallet openSim:" + c2378a.m12006i());
        if (m11399G()) {
            m11548c();
        }
    }

    private boolean m11399G() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "isNeedOpenWallet enter");
        C2538c.m12661a("MainUI", 0, "HomeFragment", "isNeedOpenWallet isNeed:" + new C2378a(BaseApplication.m2632b()).m12006i());
        return new C2378a(BaseApplication.m2632b()).m12006i();
    }

    public void m11549d() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "androidWearOpenWalletOrAddDevice enter");
        if (m11399G()) {
            this.bj = false;
            if (m11548c()) {
                C2538c.m12661a("MainUI", 1, "HomeFragment", "androidWearOpenWalletOrAddDevice the device is leo");
                return;
            }
            this.bj = true;
            C2538c.m12661a("MainUI", 1, "HomeFragment", "androidWearOpenWalletOrAddDevice the device is not leo");
            Intent intent = new Intent(this.f7992A, AddDeviceActivity.class);
            intent.putExtra("KEY_ANROIDWEAR_OPEN_WALLET_FLAG", true);
            super.startActivity(intent);
        }
    }

    private void m11401H() {
        if (this.f8013V == null) {
            this.f8013V = c.a();
        }
        if (f7990W == null) {
            f7990W = C1204c.m5370a(this.f8041z);
        }
        if (af == null) {
            af = new a();
        }
        this.f8013V.a(C1093a.m4739a(this.f8041z).m4750c());
        C2538c.m12674b("HomeFragment", "huid = " + C1093a.m4739a(this.f8041z).m4750c());
        DeviceInfo c = f7990W.m5447c();
        if (c != null) {
            af.b(c.getDeviceIdentify());
            af.a(C1996x.m10459b(c.getProductType()));
            C2538c.m12674b("HomeFragment", "setBIAnalyticsData.getUUID = " + c.getUUID());
        }
        f7990W.m5425a(new an(this, c));
    }

    private View m11438a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f8018c == null) {
            this.f8018c = layoutInflater.inflate(g.fragment_main_home_21, viewGroup, false);
        } else {
            ((ViewGroup) this.f8018c.getParent()).removeView(this.f8018c);
        }
        return this.f8018c;
    }

    private void m11403I() {
        if (getActivity() != null) {
            Intent intent = new Intent(this.f8041z, WebViewActivity.class);
            C2538c.m12674b("HomeFragment", "openAppHelpActivity url = " + this.f8005N.m11754a(this.f8041z));
            intent.putExtra("WebViewActivity.REQUEST_URL_KEY", r1);
            intent.putExtra("WebViewActivity.JUMP_MODE_KEY", 0);
            getActivity().startActivity(intent);
        }
    }

    private void m11404J() {
        if (getActivity().isFinishing()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "openHuaweiAppStore(): activity is finishing");
            return;
        }
        C2243a.m11601a().m11613b(this.f8041z);
    }

    private void m11406K() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter initView");
        View findViewById = this.f8018c.findViewById(f.home_fragment_title_view);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Utils.getStatusBarHeight(activityContext)=" + com.huawei.ui.commonui.d.c.a(this.f7992A));
        LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = com.huawei.ui.commonui.d.c.a(this.f7992A);
        findViewById.setLayoutParams(layoutParams);
        this.f8019d = (PariedDevicesSwitcher) com.huawei.ui.commonui.d.d.a(this.f8018c, f.devices_switcher);
        this.f8020e = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_fragment_bluetooth_image);
        this.f8025j = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_fragment_bluetooth_tv);
        this.f8026k = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.battery_image);
        this.f8028m = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.battery_textview);
        this.f8023h = (RelativeLayout) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_drawer_llyt_menu);
        this.f8024i = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_drawer_iv_red_point);
        this.as = (LinearLayout) com.huawei.ui.commonui.d.d.a(this.f8018c, f.fragment_social_ad);
        this.f8029n = (LinearLayout) com.huawei.ui.commonui.d.d.a(this.f8018c, f.lly_reconnect);
        this.bf = com.huawei.ui.commonui.d.d.a(this.f8018c, f.card_heart_rate_view);
        this.aU = Pattern.compile("assets://(.*)");
        this.aO = com.huawei.ui.commonui.d.d.a(this.f8018c, f.card_notification_layout);
        this.aO.setOnClickListener(this.bk);
        this.aP = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.image_notify_icon);
        this.aP.setVisibility(8);
        this.aQ = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.tv_notify_message_content);
        this.aQ.setVisibility(0);
        this.f8017b = com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_notify_message_unread);
        this.f8017b.setOnClickListener(this.bk);
        this.f8017b.setVisibility(8);
        this.aR = com.huawei.ui.commonui.d.d.a(this.f8018c, f.card_download_hihealth_layout);
        this.aR.setOnClickListener(this.bk);
        this.bb = com.huawei.ui.commonui.d.d.a(this.f8018c, f.notification_alert_layout);
        this.bc = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.notification_alert_icon);
        this.bc.setOnClickListener(this.bk);
        this.aS = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.tv_download_hihealth_content);
        this.aS.setText(getResources().getString(i.IDS_health_start_step_one_skip) + HwAccountConstants.BLANK + getResources().getString(i.IDS_health_start_step_two_two_skip));
        if (com.huawei.ui.commonui.d.c.e(this.f7992A)) {
            this.aT = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_icon);
            this.aT.setVisibility(8);
            this.aT = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_icon_left);
            this.aT.setVisibility(0);
        } else {
            this.aT = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_icon_left);
            this.aT.setVisibility(8);
            this.aT = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_icon);
            this.aT.setVisibility(0);
        }
        this.aT.setOnClickListener(this.bk);
        m11408L();
        this.f8023h.setOnClickListener(new bc(this));
        this.f8030o = (LinearLayout) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_fragment_lly_id);
        this.f8031p = (FrameLayout) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_fragment_title_frame);
        this.f8031p.getBackground().setAlpha(0);
        this.f8031p.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f8030o.getViewTreeObserver().addOnScrollChangedListener(new bq(this));
        this.f8032q = (LinearLayout) com.huawei.ui.commonui.d.d.a(this.f8018c, f.lly_bluetooth);
        this.f8033r = (LinearLayout) com.huawei.ui.commonui.d.d.a(this.f8018c, f.fragment_home_21_fitness);
        this.f8033r.setOnClickListener(this.bt);
        this.f8034s = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.tv_fitness_one_number);
        this.f8035t = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.tv_fitness_two_number);
        this.f8036u = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.tv_fitness_three_number);
        this.f8037v = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.tv_fitness_three_unit);
        if (C0956c.m3349a()) {
            this.f8037v.setText(i.IDS_band_data_sport_distance_unit_en);
        } else {
            this.f8037v.setText(i.IDS_band_data_sport_distance_unit);
        }
        this.f8034s.setText(C0956c.m3344a(0.0d, 1, 0));
        this.f8035t.setText(C0956c.m3344a(0.0d, 1, 0));
        this.f8036u.setText(C0956c.m3344a(0.0d, 1, 2));
        this.f8039x = (ViewStub) com.huawei.ui.commonui.d.d.a(this.f8018c, f.fragment_home_21_no_device_stub);
        this.f8038w = this.f8039x;
        this.f8040y = com.huawei.ui.commonui.d.d.a(this.f8018c, f.fragment_home_21_normal);
        this.f8032q.setOnClickListener(this.br);
        this.f8030o.setOnClickListener(this.br);
        this.f8001J = AnimationUtils.loadAnimation(this.f8041z, b.anim_max_min);
        this.f8001J.setAnimationListener(this.bA);
        this.f8002K = AnimationUtils.loadAnimation(this.f8041z, b.anim_min_max);
        this.f8002K.setAnimationListener(this.bB);
        this.f8008Q = (ScrollView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.sv_device_setting);
        this.f8019d.setBaseResponseCallback(new bw(this));
        this.aZ = com.huawei.ui.commonui.d.d.a(this.f8018c, f.card_download_hihealth_swim_layout);
        this.aZ.setOnClickListener(this.bk);
        if (com.huawei.ui.commonui.d.c.e(this.f7992A)) {
            this.ba = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_swim_icon);
            this.ba.setVisibility(8);
            this.ba = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_icon_swim_left);
            this.ba.setVisibility(0);
        } else {
            this.ba = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_icon_swim_left);
            this.ba.setVisibility(8);
            this.ba = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.btn_download_hihealth_swim_icon);
            this.ba.setVisibility(0);
        }
        this.ba.setOnClickListener(this.bk);
        bw();
    }

    private void m11408L() {
        PackageInfo k = C0977d.m3572k(this.f7992A);
        if (k != null) {
            if (20100000 <= k.versionCode) {
                this.aR.setVisibility(8);
                C2538c.m12661a("MainUI", 0, "HomeFragment", "initView() 运动健康已安装，是2.1版本，不显示横幅");
            } else if (this.f7999H.m12002g()) {
                this.aR.setVisibility(8);
                C2538c.m12661a("MainUI", 0, "HomeFragment", "initView() 运动健康未安装，不是2.1版本，横幅状态为YES，不显示横幅");
            } else {
                this.aR.setVisibility(0);
                C2538c.m12661a("MainUI", 0, "HomeFragment", "initView() 运动健康未安装，不是2.1版本，横幅状态为NO，显示横幅");
            }
        } else if (this.f7999H.m12002g()) {
            this.aR.setVisibility(8);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "initView() 运动健康未安装，横幅状态为YES，不显示横幅");
        } else {
            this.aR.setVisibility(0);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "initView() 运动健康未安装，横幅状态为NO，显示横幅");
        }
    }

    private void m11446a(int i) {
        c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.ct.a(), new HashMap(), 0);
        PackageInfo k = C0977d.m3572k(this.f8041z);
        if (k != null) {
            C2538c.m12674b("HomeFragment", "CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode);
            if (20100000 <= k.versionCode) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter gotoHealth ");
                C0977d.m3530a(this.f8041z, i);
                return;
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter gotoHealth download");
            this.f8041z.startActivity(new Intent(this.f8041z, HealthStartActivity.class));
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter gotoHealth download");
        this.f8041z.startActivity(new Intent(this.f8041z, HealthStartActivity.class));
    }

    private void m11410M() {
        c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.ct.a(), new HashMap(), 0);
        PackageInfo k = C0977d.m3572k(this.f8041z);
        if (k != null) {
            C2538c.m12674b("HomeFragment", "CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode);
            if (20100000 <= k.versionCode) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter gotoHealth ");
                this.ag = C2243a.m11601a().m11614c();
                if (this.ag != null) {
                    String b = C1988p.m10381a(BaseApplication.m2632b()).m10391b(this.ag.getProductType());
                    C2538c.m12677c("HomeFragment", "productName:" + b);
                    C0977d.m3529a(this.ag.getProductType(), b, this.ag.getDeviceIdentify(), this.f8041z, "PORSCHE DESIGN".equals(b));
                    return;
                }
                C0977d.m3530a(this.f8041z, 0);
                return;
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter gotoHealth download");
            this.f8041z.startActivity(new Intent(this.f8041z, HealthStartActivity.class));
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter gotoHealth download");
        this.f8041z.startActivity(new Intent(this.f8041z, HealthStartActivity.class));
    }

    private void m11412N() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter initData");
        f7991X = new C1975c();
        f7991X.m10374a(new by(this));
        this.az = C2254l.m11647a();
        this.aa = new C2278b();
        ar();
        ax();
        au();
        av();
        m11484b(0);
        aI();
        aP();
        bi();
        aR();
        aY();
        aZ();
        aM();
        bk();
        if (!C0630m.m2297a(this.f8041z).m2320e()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "initData() if (!HWUserProfileMgr.getInstance(activityContext).getIfAccountArea())");
            this.f7996E = true;
        }
        this.f8014Y = new ar(this.f8041z.getApplicationContext());
        this.f8016a = C2460a.m12288a(this.f8041z.getApplicationContext());
        aB.execute(new C2219c(this));
        bb();
        this.bu.sendEmptyMessage(1010);
        if (!(getActivity() == null || getActivity().getIntent() == null)) {
            m11471a(getActivity().getIntent().getStringExtra("openPackageName"), getActivity().getIntent().getStringExtra("openClassName"));
        }
        bH();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11414O() {
        /*
        r13 = this;
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Enter refreshSettingData() isConnected:";
        r5 = r5.append(r6);
        r6 = r13.f8009R;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = r13.f8004M;
        r0 = r0.m10411a();
        r13.ao = r0;
        r0 = r13.ak;
        r0.clear();
        r0 = r13.al;
        r0.clear();
        r0 = r13.ai;
        r1 = r13.am;
        r13.m11542a(r0, r1);
        r0 = r13.aj;
        r1 = r13.an;
        r13.m11542a(r0, r1);
        r13.m11424T();
        r0 = r13.ao;
        if (r0 != 0) goto L_0x004b;
    L_0x004a:
        return;
    L_0x004b:
        r0 = new com.huawei.ui.device.a.z;
        r1 = r13.f8041z;
        r0.<init>(r1);
        r13.ap = r0;
        r0 = com.huawei.ui.homewear21.card.p176a.C2243a.m11601a();
        r0 = r0.m11614c();
        r13.ag = r0;
        r13.m11416P();
        r0 = 0;
        r1 = r13.ag;
        if (r1 == 0) goto L_0x093f;
    L_0x0066:
        r1 = 0;
        r13.av = r1;
        r1 = r13.ag;
        r11 = r1.getDeviceIdentify();
        r1 = 3;
        r2 = r13.ag;
        r2 = r2.getProductType();
        if (r1 == r2) goto L_0x0082;
    L_0x0078:
        r1 = 10;
        r2 = r13.ag;
        r2 = r2.getProductType();
        if (r1 != r2) goto L_0x09d8;
    L_0x0082:
        r0 = 1;
        r10 = r0;
    L_0x0084:
        if (r10 != 0) goto L_0x0975;
    L_0x0086:
        r0 = r13.ao;
        r0 = r0.isSupportSportTotal();
        if (r0 == 0) goto L_0x0975;
    L_0x008e:
        r0 = 11;
        r1 = r13.ag;
        r1 = r1.getProductType();
        if (r0 == r1) goto L_0x0975;
    L_0x0098:
        r0 = 1;
        r9 = r0;
    L_0x009a:
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isGold_card = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isGold_card();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isActivity_reminder = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isActivity_reminder();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isBluetooth_off_alert = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isBluetooth_off_alert();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isCall_mute = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isCall_mute();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isEvent_alarm = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isEvent_alarm();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isSmart_alarm = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isSmart_alarm();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isAvoid_disturb = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isAvoid_disturb();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isMessage_alert = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isMessage_alert();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isWeather_push = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isWeather_push();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isAuto_light_screen = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isAuto_light_screen();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isContacts = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isContacts();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isOta_update = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isOta_update();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isFactory_reset = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isFactory_reset();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isReserveSync = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isReserveSync();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "HomeFragment";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "refreshSettingData() isSupportHelp = ";
        r3 = r3.append(r4);
        r4 = r13.ao;
        r4 = r4.isSupportHelp();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r0 = "HomeFragment";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "refreshSettingData() isSupportPay = ";
        r3 = r3.append(r4);
        r4 = r13.ao;
        r4 = r4.isSupportPay();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isSupportCoreSleep = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isSupportCoreSleep();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isSupportHeartRate = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isSupportHeartRateEnable();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isRotate_switch_screen = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isRotate_switch_screen();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isSupportLeftRightHandWearMode = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isSupportLeftRightHandWearMode();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isSupportOneLevelMenu = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isSupportOneLevelMenu();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "refreshSettingData() isSupportEphemerisInfoUpdate = ";
        r5 = r5.append(r6);
        r6 = r13.ao;
        r6 = r6.isSupportEphemerisInfoUpdate();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = -2;
        r1 = r13.ag;
        r1 = r1.getProductType();
        if (r0 != r1) goto L_0x0411;
    L_0x03f7:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.ic_drawer_settins;
        r3 = 22;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_general;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x0411:
        r0 = r13.ag;
        if (r0 == 0) goto L_0x0475;
    L_0x0415:
        r0 = r13.ao;
        if (r0 == 0) goto L_0x0475;
    L_0x0419:
        r0 = "HomeFragment";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "deviceCapability.isSupportSportTotal() value ";
        r3 = r3.append(r4);
        r4 = r13.ao;
        r4 = r4.isSupportSportTotal();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        r0 = r13.ao;
        r0 = r0.isSupportSportTotal();
        if (r0 != 0) goto L_0x0979;
    L_0x0445:
        r0 = 11;
        r1 = r13.ag;
        r1 = r1.getProductType();
        if (r0 != r1) goto L_0x0979;
    L_0x044f:
        r0 = r13.f8033r;
        r1 = 8;
        r0.setVisibility(r1);
        r1 = 1;
        r2 = com.huawei.ui.homewear21.h.ic_card_health;
        r3 = 27;
        r4 = 6;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_main_homefragment_health_app;
        r5 = r0.getString(r5);
        r0 = r13.f7992A;
        r6 = com.huawei.ui.homewear21.i.IDS_setting_view_fitness_tip;
        r6 = r0.getString(r6);
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x0475:
        r0 = r13.ao;
        if (r0 == 0) goto L_0x004a;
    L_0x0479:
        r0 = "MainUI";
        r1 = 1;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "-VersionConfig.isFeatureSupport(FeatureId.SUPPORT_CORE_SLEEP) :";
        r5 = r5.append(r6);
        r6 = 58;
        r6 = com.huawei.hwcloudmodel.p060b.C0969i.m3482a(r6);
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = r13.ao;
        r0 = r0.isSupportCoreSleep();
        if (r0 == 0) goto L_0x04f9;
    L_0x04a8:
        r0 = 58;
        r0 = com.huawei.hwcloudmodel.p060b.C0969i.m3482a(r0);
        if (r0 == 0) goto L_0x04f9;
    L_0x04b0:
        r0 = r13.f8004M;
        r0 = r0.m10444h();
        if (r0 == 0) goto L_0x0988;
    L_0x04b8:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_status_enabled;
        r7 = r0.getString(r1);
    L_0x04c0:
        r0 = "MainUI";
        r1 = 1;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "add coreSleep item, coreSleepStatus : ";
        r5 = r5.append(r6);
        r5 = r5.append(r7);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_accuratesleep;
        r3 = 23;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_fitness_core_sleep_title;
        r5 = r0.getString(r5);
        r6 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x04f9:
        r0 = r13.ao;
        r0 = r0.isActivity_reminder();
        if (r0 == 0) goto L_0x0568;
    L_0x0501:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_idlereminders;
        r3 = 1;
        r4 = 0;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_moving_remind;
        r5 = r0.getString(r5);
        r0 = r13.f7992A;
        r6 = com.huawei.ui.homewear21.i.IDS_btsetting_stand_alert_message;
        r6 = r0.getString(r6);
        r7 = "";
        r0 = 1;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = 0;
        r12 = r13.bn;
        r8[r0] = r12;
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = "MainUI";
        r1 = 0;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "initData() getIdleRemind ";
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r0 = r13.aG();
        r1 = "MainUI";
        r2 = 1;
        r3 = "HomeFragment";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "initData() getIdleRemindNoCallBack ";
        r6 = r6.append(r7);
        r6 = r6.append(r0);
        r6 = r6.toString();
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12661a(r1, r2, r3, r4);
        r1 = r13.aW;
        monitor-enter(r1);
        r2 = r13.ak;	 Catch:{ all -> 0x0992 }
        r3 = 1;
        r2 = r13.m11444a(r2, r3);	 Catch:{ all -> 0x0992 }
        r2.m11260a(r0);	 Catch:{ all -> 0x0992 }
        monitor-exit(r1);	 Catch:{ all -> 0x0992 }
    L_0x0568:
        r0 = r13.ao;
        r0 = r0.isSupportHeartRateEnable();
        if (r0 == 0) goto L_0x0598;
    L_0x0570:
        r0 = r13.f8004M;
        r0 = r0.m10443g();
        if (r0 == 0) goto L_0x0995;
    L_0x0578:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_status_enabled;
        r7 = r0.getString(r1);
    L_0x0580:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_heartrate;
        r3 = 24;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_HeartRate_switch;
        r5 = r0.getString(r5);
        r6 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x0598:
        if (r9 == 0) goto L_0x05ac;
    L_0x059a:
        r1 = 1;
        r2 = 0;
        r3 = -9668; // 0xffffffffffffda3c float:NaN double:NaN;
        r4 = 5;
        r5 = "";
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x05ac:
        if (r10 == 0) goto L_0x05d0;
    L_0x05ae:
        r0 = 15;
        r0 = com.huawei.hwcloudmodel.p060b.C0969i.m3482a(r0);
        if (r0 == 0) goto L_0x05d0;
    L_0x05b6:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.ic_card_apps;
        r3 = 18;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_main_discovery_tab_service_huawei_application_market;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x05d0:
        r0 = r13.ao;
        r0 = r0.isSupportPay();
        if (r0 == 0) goto L_0x0602;
    L_0x05d8:
        r0 = 53;
        r0 = com.huawei.hwcloudmodel.p060b.C0969i.m3482a(r0);
        if (r0 == 0) goto L_0x0602;
    L_0x05e0:
        r0 = r13.f7992A;
        r0 = com.huawei.ui.commonui.d.c.c(r0);
        if (r0 == 0) goto L_0x0602;
    L_0x05e8:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.ic_list_wallet;
        r3 = 19;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_main_homefragment_wallet;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x0602:
        r0 = r13.ao;
        r0 = r0.isSupportEsim();
        if (r0 != 0) goto L_0x099f;
    L_0x060a:
        r0 = r13.ao;
        r0 = r0.isSupportMultiSim();
        if (r0 == 0) goto L_0x0622;
    L_0x0612:
        r0 = 54;
        r0 = com.huawei.hwcloudmodel.p060b.C0969i.m3482a(r0);
        if (r0 == 0) goto L_0x0622;
    L_0x061a:
        r0 = r13.f8041z;
        r0 = com.huawei.ui.commonui.d.c.b(r0);
        if (r0 == 0) goto L_0x0622;
    L_0x0622:
        r0 = r13.ao;
        r0 = r0.isGold_card();
        if (r0 == 0) goto L_0x064c;
    L_0x062a:
        r0 = 14;
        r0 = com.huawei.hwcloudmodel.p060b.C0969i.m3482a(r0);
        if (r0 == 0) goto L_0x064c;
    L_0x0632:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.ic_list_huaweimenber;
        r3 = 20;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_main_discovery_tab_service_huawei_member;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x064c:
        r0 = r13.ag;
        if (r0 == 0) goto L_0x0673;
    L_0x0650:
        if (r10 == 0) goto L_0x0673;
    L_0x0652:
        r0 = r13.ao;
        r0 = r0.isSupportHelp();
        if (r0 == 0) goto L_0x0673;
    L_0x065a:
        r1 = 1;
        r2 = com.huawei.ui.homewear21.h.ic_list_help;
        r3 = 17;
        r4 = 4;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_main_discovery_tab_service_help;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x0673:
        r0 = r13.ao;
        r0 = r0.isEvent_alarm();
        if (r0 != 0) goto L_0x0683;
    L_0x067b:
        r0 = r13.ao;
        r0 = r0.isSmart_alarm();
        if (r0 == 0) goto L_0x069c;
    L_0x0683:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_alarm;
        r3 = 4;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_prompt;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x069c:
        r0 = r13.ao;
        r0 = r0.isAvoid_disturb();
        if (r0 == 0) goto L_0x06c0;
    L_0x06a4:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_donotdisturb;
        r3 = 5;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_setting_disturb_title;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
        r13.aH();
    L_0x06c0:
        r0 = r13.ao;
        r0 = r0.isMessage_alert();
        if (r0 == 0) goto L_0x06e1;
    L_0x06c8:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_massagealert;
        r3 = 6;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_nottification_settings_b2_ex;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x06e1:
        r0 = r13.ao;
        r0 = r0.isContacts();
        if (r0 == 0) goto L_0x0703;
    L_0x06e9:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_contact;
        r3 = 12;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_contact_favorite_contacts;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x0703:
        r0 = r13.ao;
        r0 = r0.isWeather_push();
        if (r0 == 0) goto L_0x0732;
    L_0x070b:
        r0 = r13.f8004M;
        r0 = r0.m10448l();
        if (r0 == 0) goto L_0x09bb;
    L_0x0713:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_status_enabled;
        r7 = r0.getString(r1);
    L_0x071b:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_weatherreport;
        r3 = 7;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_weather_push;
        r5 = r0.getString(r5);
        r6 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x0732:
        r0 = r13.ao;
        r0 = r0.isBluetooth_off_alert();
        if (r0 == 0) goto L_0x078b;
    L_0x073a:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_bluetoothdisconnected;
        r3 = 2;
        r4 = 1;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_anti_lost_remind;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 1;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = 0;
        r12 = r13.bo;
        r8[r0] = r12;
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r13.m11427U();
        r1 = "MainUI";
        r2 = 1;
        r3 = "HomeFragment";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "initData() getBTLostRemindEnableNoCallBack ";
        r6 = r6.append(r7);
        r6 = r6.append(r0);
        r6 = r6.toString();
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12661a(r1, r2, r3, r4);
        r1 = r13.aW;
        monitor-enter(r1);
        r2 = r13.ak;	 Catch:{ all -> 0x09c5 }
        r3 = 2;
        r2 = r13.m11444a(r2, r3);	 Catch:{ all -> 0x09c5 }
        r2.m11260a(r0);	 Catch:{ all -> 0x09c5 }
        monitor-exit(r1);	 Catch:{ all -> 0x09c5 }
    L_0x078b:
        r0 = r13.ao;
        r0 = r0.isSupportOneLevelMenu();
        if (r0 == 0) goto L_0x07ad;
    L_0x0793:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_one_level_menu;
        r3 = 28;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_one_level_menu_settings_title;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x07ad:
        r0 = r13.ao;
        r0 = r0.isAuto_light_screen();
        if (r0 == 0) goto L_0x080e;
    L_0x07b5:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_awakescreen;
        r3 = 11;
        r4 = 0;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_auto_light_item;
        r5 = r0.getString(r5);
        r0 = r13.f7992A;
        r6 = com.huawei.ui.homewear21.i.IDS_btsetting_auto_light_message;
        r6 = r0.getString(r6);
        r7 = "";
        r0 = 1;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = 0;
        r12 = r13.bp;
        r8[r0] = r12;
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r13.m11421R();
        r1 = "MainUI";
        r2 = 1;
        r3 = "HomeFragment";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "initData() getRotateWakeScreemNoCallBack ";
        r6 = r6.append(r7);
        r6 = r6.append(r0);
        r6 = r6.toString();
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12661a(r1, r2, r3, r4);
        r1 = r13.aW;
        monitor-enter(r1);
        r2 = r13.ak;	 Catch:{ all -> 0x09c8 }
        r3 = 11;
        r2 = r13.m11444a(r2, r3);	 Catch:{ all -> 0x09c8 }
        r2.m11260a(r0);	 Catch:{ all -> 0x09c8 }
        monitor-exit(r1);	 Catch:{ all -> 0x09c8 }
    L_0x080e:
        r0 = r13.ao;
        r0 = r0.isRotate_switch_screen();
        if (r0 == 0) goto L_0x0869;
    L_0x0816:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_switchscreen;
        r3 = 25;
        r4 = 1;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_screen_switch;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 1;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = 0;
        r12 = r13.bq;
        r8[r0] = r12;
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r13.m11423S();
        r1 = "MainUI";
        r2 = 1;
        r3 = "HomeFragment";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "initData() getRotateSwitchScreenmNoCallBack ";
        r6 = r6.append(r7);
        r6 = r6.append(r0);
        r6 = r6.toString();
        r4[r5] = r6;
        com.huawei.p190v.C2538c.m12661a(r1, r2, r3, r4);
        r1 = r13.aW;
        monitor-enter(r1);
        r2 = r13.ak;	 Catch:{ all -> 0x09cb }
        r3 = 25;
        r2 = r13.m11444a(r2, r3);	 Catch:{ all -> 0x09cb }
        r2.m11260a(r0);	 Catch:{ all -> 0x09cb }
        monitor-exit(r1);	 Catch:{ all -> 0x09cb }
    L_0x0869:
        r0 = r13.ao;
        r0 = r0.isSupportLeftRightHandWearMode();
        if (r0 == 0) goto L_0x089c;
    L_0x0871:
        r0 = "";
        r0 = r13.f8004M;
        r1 = 0;
        r0 = r0.m10410a(r1);
        if (r0 != 0) goto L_0x09ce;
    L_0x087c:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_WearPrefenc_left;
        r7 = r0.getString(r1);
    L_0x0884:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.ic_home_peidaifangshi;
        r3 = 26;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_wear_prefence;
        r5 = r0.getString(r5);
        r6 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x089c:
        if (r9 == 0) goto L_0x08b0;
    L_0x089e:
        r1 = 1;
        r2 = 0;
        r3 = -9668; // 0xffffffffffffda3c float:NaN double:NaN;
        r4 = 5;
        r5 = "";
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x08b0:
        if (r10 != 0) goto L_0x08d3;
    L_0x08b2:
        r0 = r13.ao;
        r0 = r0.isSupportHelp();
        if (r0 == 0) goto L_0x08d3;
    L_0x08ba:
        r1 = 1;
        r2 = com.huawei.ui.homewear21.h.ic_list_help;
        r3 = 17;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_main_discovery_tab_service_help;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
    L_0x08d3:
        r0 = r13.ao;
        r0 = r0.isOta_update();
        if (r0 == 0) goto L_0x091c;
    L_0x08db:
        r0 = r13.f8004M;
        r8 = r0.m10441e();
        r0 = "MainUI";
        r1 = 1;
        r2 = "HomeFragment";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "initData() isNew = ";
        r5 = r5.append(r6);
        r5 = r5.append(r8);
        r5 = r5.toString();
        r3[r4] = r5;
        com.huawei.p190v.C2538c.m12661a(r0, r1, r2, r3);
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_deviceupdate;
        r3 = 13;
        r4 = 2;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_ota_update_band_update;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r9 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11473a(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    L_0x091c:
        r0 = r13.ao;
        r0 = r0.isFactory_reset();
        if (r0 == 0) goto L_0x004a;
    L_0x0924:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.home_ic_list_restore;
        r3 = 14;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_settings_restore_factory_settings;
        r5 = r0.getString(r5);
        r6 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r7 = r11;
        r0.m11490b(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x004a;
    L_0x093f:
        r0 = r13.av;
        r0 = r0 + 1;
        r13.av = r0;
        r0 = "HomeFragment";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Enter refreshSettingData(),deviceMac is null!";
        r3 = r3.append(r4);
        r4 = r13.av;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12679d(r0, r1);
        r0 = r13.av;
        r1 = 3;
        if (r0 >= r1) goto L_0x004a;
    L_0x096a:
        r0 = r13.bu;
        r1 = 1014; // 0x3f6 float:1.421E-42 double:5.01E-321;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.sendEmptyMessageDelayed(r1, r2);
        goto L_0x004a;
    L_0x0975:
        r0 = 0;
        r9 = r0;
        goto L_0x009a;
    L_0x0979:
        r0 = r13.f8033r;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r13.bf;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x0475;
    L_0x0988:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_status_disabled;
        r7 = r0.getString(r1);
        goto L_0x04c0;
    L_0x0992:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0992 }
        throw r0;
    L_0x0995:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_status_disabled;
        r7 = r0.getString(r1);
        goto L_0x0580;
    L_0x099f:
        r1 = r13.f8009R;
        r2 = com.huawei.ui.homewear21.h.ic_list_simcard;
        r3 = 21;
        r4 = 3;
        r0 = r13.f7992A;
        r5 = com.huawei.ui.homewear21.i.IDS_plugin_sim_wirless_manage;
        r5 = r0.getString(r5);
        r6 = "";
        r7 = "";
        r0 = 0;
        r8 = new android.widget.CompoundButton.OnCheckedChangeListener[r0];
        r0 = r13;
        r0.m11474a(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x0622;
    L_0x09bb:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_status_disabled;
        r7 = r0.getString(r1);
        goto L_0x071b;
    L_0x09c5:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x09c5 }
        throw r0;
    L_0x09c8:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x09c8 }
        throw r0;
    L_0x09cb:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x09cb }
        throw r0;
    L_0x09ce:
        r0 = r13.f7992A;
        r1 = com.huawei.ui.homewear21.i.IDS_WearPrefenc_right;
        r7 = r0.getString(r1);
        goto L_0x0884;
    L_0x09d8:
        r10 = r0;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.ui.homewear21.a.a.O():void");
    }

    private void m11416P() {
        if (this.ag != null) {
            this.ah = this.ag.getDeviceIdentify();
        }
    }

    private void m11418Q() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "refreshSettingView() mGeneralList = " + this.ak + ",+mDeviceList = " + this.al);
        this.aj = (ListView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.list_device_setting);
        this.ai = (ListView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.list_general_setting);
        this.am = new C2192a(this.f8041z, this.ak);
        this.an = new C2192a(this.f8041z, this.al);
        this.ai.setAdapter(this.am);
        m11542a(this.ai, this.am);
        this.ai.setOnItemClickListener(this.bm);
        this.aj.setAdapter(this.an);
        m11542a(this.aj, this.an);
        this.aj.setOnItemClickListener(this.bl);
        m11556k();
    }

    private boolean m11421R() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getRotateWakeScreem enter.");
        return this.f8004M.m10431b();
    }

    private boolean m11423S() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getRotateSwitchScreenmNoCallBack enter.");
        return this.f8004M.m10435c();
    }

    public void m11550e() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "enterUpdateActivity");
        Intent intent = new Intent();
        intent.setClass(this.f8041z, UpdateVersionActivity.class);
        getActivity().startActivity(intent);
        c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cF.a(), new HashMap(), 0);
    }

    public void m11551f() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "enterUpdateEphemerisActivity no startActivity");
    }

    private void m11451a(Switch switchR) {
        if (switchR != null) {
            switchR.performClick();
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "switchPerformClick mSwitch is null");
    }

    protected void m11544a(Class<?> cls) {
        this.f8041z.startActivity(new Intent(this.f8041z, cls));
    }

    protected void m11545a(Class<?> cls, int i) {
        startActivityForResult(new Intent(this.f8041z, cls), i);
    }

    private void m11448a(int i, ArrayList<C2194c> arrayList, boolean z) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "setSettingItemSwitchChecked id= " + i + ",isChecked =" + z);
        synchronized (this.aW) {
            m11444a((ArrayList) arrayList, i).m11260a(z);
        }
        m11424T();
    }

    private void m11424T() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "notifyUpdateSettingList() mGeneralAdapter = " + this.am + ", mDeviceAdapter = " + this.an);
        if (this.am != null) {
            this.am.notifyDataSetChanged();
        }
        if (this.an != null) {
            this.an.notifyDataSetChanged();
        }
    }

    public void m11542a(ListView listView, C2192a c2192a) {
        if (listView != null && c2192a != null) {
            int i = 0;
            for (int i2 = 0; i2 < c2192a.getCount(); i2++) {
                View view = c2192a.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (c2192a.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    private C2194c m11444a(ArrayList<C2194c> arrayList, int i) {
        C2194c c2194c = new C2194c();
        Iterator it = arrayList.iterator();
        C2194c c2194c2 = c2194c;
        while (it.hasNext()) {
            c2194c = (C2194c) it.next();
            if (c2194c.m11256a() == i) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "getItem getID = " + c2194c.m11256a());
            } else {
                c2194c = c2194c2;
            }
            c2194c2 = c2194c;
        }
        return c2194c2;
    }

    public void m11552g() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getGoldCard()");
        this.ap.m10474a(this.bu);
    }

    private boolean m11427U() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getBluetoothOffalert enter.");
        return this.f8004M.m10439d();
    }

    private void m11474a(boolean z, int i, int i2, int i3, String str, String str2, String str3, OnCheckedChangeListener... onCheckedChangeListenerArr) {
        synchronized (this.aW) {
            this.ak.add(m11493c(z, i, i2, i3, str, str2, str3, onCheckedChangeListenerArr));
        }
    }

    private void m11473a(boolean z, int i, int i2, int i3, String str, String str2, String str3, boolean z2, OnCheckedChangeListener... onCheckedChangeListenerArr) {
        synchronized (this.aX) {
            this.al.add(m11480b(z, i, i2, i3, str, str2, str3, z2, onCheckedChangeListenerArr));
        }
    }

    private void m11490b(boolean z, int i, int i2, int i3, String str, String str2, String str3, OnCheckedChangeListener... onCheckedChangeListenerArr) {
        synchronized (this.aX) {
            this.al.add(m11493c(z, i, i2, i3, str, str2, str3, onCheckedChangeListenerArr));
        }
    }

    private C2194c m11480b(boolean z, int i, int i2, int i3, String str, String str2, String str3, boolean z2, OnCheckedChangeListener... onCheckedChangeListenerArr) {
        C2194c c2194c = new C2194c();
        c2194c.m11257a(i2);
        c2194c.m11262b(i3);
        c2194c.m11259a(str);
        c2194c.m11263b(str2);
        c2194c.m11267c(str3);
        c2194c.m11264b(z2);
        c2194c.m11266c(i);
        c2194c.m11268c(z);
        if (onCheckedChangeListenerArr.length != 0) {
            c2194c.m11258a(onCheckedChangeListenerArr[0]);
        }
        return c2194c;
    }

    private C2194c m11493c(boolean z, int i, int i2, int i3, String str, String str2, String str3, OnCheckedChangeListener... onCheckedChangeListenerArr) {
        C2194c c2194c = new C2194c();
        c2194c.m11257a(i2);
        c2194c.m11262b(i3);
        c2194c.m11259a(str);
        c2194c.m11263b(str2);
        c2194c.m11267c(str3);
        c2194c.m11266c(i);
        c2194c.m11268c(z);
        if (onCheckedChangeListenerArr.length != 0) {
            c2194c.m11258a(onCheckedChangeListenerArr[0]);
        }
        return c2194c;
    }

    private void m11428V() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "Enter gotoWallet");
        PluginPay instance = PluginPay.getInstance(this.f8041z);
        instance.setAdapter(com.huawei.g.a.b.a());
        instance.goToCardListActivity();
    }

    private void m11430W() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "Enter gotoSimCard");
        com.huawei.sim.a a = com.huawei.sim.a.a(this.f8041z);
        a.setAdapter(v.a());
        a.a();
    }

    private void m11432X() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "Enter gotoMember");
        if (this.bu != null) {
            this.bu.sendEmptyMessage(12);
            m11552g();
            return;
        }
        C2538c.m12680e("HomeFragment", "handler is null!");
    }

    private void m11484b(int i) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter refreshState:" + i);
        this.bu.removeMessages(1001);
        this.bu.sendEmptyMessageDelayed(1001, (long) i);
    }

    private void m11434Y() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "updateNewUpdateData:hasNewVesion:" + C1071a.m4507a(this.f7992A).m4521e());
        if (C1071a.m4507a(this.f7992A).m4521e()) {
            this.f8024i.setVisibility(0);
        } else {
            this.f8024i.setVisibility(4);
        }
    }

    private void m11436Z() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "updateNewRed isRedTip= " + C1071a.m4507a(this.f7992A).m4523f());
        synchronized (this.aX) {
            if (r0) {
                m11546a(true);
            } else {
                m11546a(false);
            }
        }
    }

    public void m11546a(boolean z) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "setBandRedTip isRedTip= " + z);
        Iterator it = this.al.iterator();
        while (it.hasNext()) {
            C2194c c2194c = (C2194c) it.next();
            if (c2194c.m11256a() == 13) {
                if (z) {
                    c2194c.m11264b(true);
                } else {
                    c2194c.m11264b(false);
                }
            }
            m11424T();
        }
    }

    private void aa() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter clearMessageCenterLocalDeviceMessage");
        C1971j a = C1971j.m10236a(this.f8041z);
        a.m10254b("device", "device_type_connected", new C2236t(this, a));
        a.m10254b("device", "device_ota", new C2237u(this, a));
    }

    private void ab() {
        this.ag = C2243a.m11601a().m11614c();
        if (this.ag != null) {
            this.f8007P = this.ag.getUUID();
            int deviceConnectState = this.ag.getDeviceConnectState();
            C2538c.m12661a("MainUI", 0, "HomeFragment", "bluetooth status: " + deviceConnectState);
            if (2 == deviceConnectState || 1 == deviceConnectState) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "connected or connecting");
                return;
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "begin connect in ui , name:" + this.ag.getDeviceName());
            m11495c(1);
            this.bu.removeCallbacks(this.bv);
            this.bu.postDelayed(this.bv, 20000);
            C2243a.m11601a().m11610a(C2243a.m11601a().m11617f());
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "no deivce info");
    }

    private void ac() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "enter beginBackgroundSync():");
        al();
        ak();
    }

    private void ad() {
        com.huawei.hwdatamigrate.a a = com.huawei.hwdatamigrate.a.a(this.f7992A);
        boolean a2 = a.a();
        boolean b = a.b();
        if (a2 && b) {
            C2538c.m12674b("HomeFragment", "not need to migrate");
        } else if (a.b(this.f7992A)) {
            C2538c.m12674b("HomeFragment", " need to migrate");
            Message obtain = Message.obtain();
            obtain.what = 1004;
            this.bu.sendMessage(obtain);
        }
    }

    public void m11553h() {
        m11507e(i.IDS_data_migration_tip);
        new Thread(new C2239w(this)).start();
    }

    private void ae() {
        com.huawei.h.a.a(this.f7992A).onDataMigrate();
        com.huawei.i.a.a(this.f7992A).onDataMigrate();
        C1204c.m5370a(this.f7992A).onDataMigrate();
        C1035a.m4176b().onDataMigrate();
        com.huawei.u.a.a().onDataMigrate();
        com.huawei.ad.b.a.a(this.f7992A).onDataMigrate();
        C1026q.m4018a(this.f7992A).m4134c(null);
        this.bu.sendEmptyMessage(1005);
    }

    private void af() {
        try {
            com.huawei.t.a.a().b();
            C1026q.m4018a(this.f7992A).m4134c(new C2240x(this));
        } catch (Exception e) {
            C2538c.m12674b("HomeFragment", "startHealthMigrateData exception is " + e.getMessage());
        }
        this.bu.sendEmptyMessageDelayed(1017, 600000);
    }

    public void m11554i() {
        com.huawei.hwdatamigrate.a.a(this.f7992A).a(true);
        ai();
    }

    private void ag() {
        com.huawei.hwdatamigrate.a.a(this.f7992A).b(true);
        ai();
        m11556k();
    }

    private void m11472a(List<DataDeviceAvoidDisturbInfo> list) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "handleGetNoDisturbSuccess()");
        if (list == null || list.size() == 0) {
            C2538c.m12680e("HomeFragment", "ERROR list!");
            return;
        }
        DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo = (DataDeviceAvoidDisturbInfo) list.get(0);
        C2538c.m12661a("MainUI", 1, "HomeFragment", "handleGetNoDisturbSuccess() switch=" + dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_switch());
        if (dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_switch() == 0 && dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_time_switch() == 0) {
            m11447a(5, this.ak, this.f7992A.getString(i.IDS_status_disabled));
        } else if (dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_switch() != 0) {
            m11447a(5, this.ak, this.f7992A.getString(i.IDS_status_enabled));
        } else if (dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_switch() == 0 && dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_time_switch() != 0) {
            m11447a(5, this.ak, this.f8004M.m10412a(this.f8041z, dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_start_time(), dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_end_time()));
        }
        m11452a(dataDeviceAvoidDisturbInfo);
    }

    private void m11452a(DataDeviceAvoidDisturbInfo dataDeviceAvoidDisturbInfo) {
        if (this.ao != null && this.ao.isAuto_light_screen()) {
            int i;
            if (f7990W == null || !this.ao.isSupportQueryAllowDisturbContent()) {
                i = 0;
            } else {
                i = f7990W.m5455g();
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "updateDeviceSettingRotate() allowContent = " + i);
            if (20 != (i & 20)) {
                m11444a(this.ak, 11).m11263b(this.f7992A.getString(i.IDS_btsetting_auto_light_message));
            } else if (20 == (dataDeviceAvoidDisturbInfo.getDevice_avoid_disturb_type() & 20)) {
                m11444a(this.ak, 11).m11263b(null);
            } else {
                m11444a(this.ak, 11).m11263b(this.f7992A.getString(i.IDS_btsetting_auto_light_message));
            }
        }
    }

    private void m11447a(int i, ArrayList<C2194c> arrayList, String str) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "setSettingItemSwitchChecked id= " + i + ",rightText =" + str);
        synchronized (this.aW) {
            m11444a((ArrayList) arrayList, i).m11267c(str);
        }
        m11424T();
    }

    public void m11555j() {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "enter showRestoreFactoryDialog()");
        C1988p a = C1988p.m10381a(this.f7992A);
        this.ag = C2243a.m11601a().m11614c();
        m11416P();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "currentDeviceType = " + this.ag.getProductType());
        String string = this.f7992A.getString(i.IDS_settings_restore_factory_prompt, new Object[]{a.m10391b(r1)});
        if (11 == this.ag.getProductType() && "HUAWEI CM-R1P".equals(this.ag.getDeviceName())) {
            string = this.f7992A.getString(i.IDS_settings_restore_factory_prompt, new Object[]{this.f8041z.getString(i.IDS_huawei_r1_pro_content)});
        }
        if (this.aq == null) {
            this.aq = new w(this.f8041z).a(i.IDS_settings_restore_factory_settings).b(string).a(i.IDS_plugin_menu_reset, new C2242z(this)).b(i.IDS_settings_button_cancal, new C2241y(this)).a();
            this.aq.setCancelable(false);
            this.aq.show();
        }
    }

    private void ah() {
        C2538c.m12674b("HomeFragment", "handleWhenGetDetailDataSuccess() ENTER");
        aj();
    }

    private void ai() {
        m11414O();
        m11418Q();
        m11424T();
    }

    private void aj() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter handleWhenGetDetailDataSuccessDelayTodu!");
        C2243a.m11601a().m11607a(this.f8041z);
    }

    private void ak() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getMaintWhenSyncSuccess()");
        Boolean valueOf = Boolean.valueOf(false);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getMaintWhenSyncSuccess() isOpenUploadLog = " + valueOf);
        this.f8014Y.m10362a(new aa(this));
    }

    private void al() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "autoCheckBandCheckVersionService");
        if (this.ao == null || !this.ao.isOta_update()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "autoCheckBandCheckVersionService not support");
            return;
        }
        if (this.f8015Z == null) {
            this.f8015Z = ah.m10316a(this.f8041z);
        }
        this.f8015Z.m10334c();
    }

    private void am() {
        C2538c.m12674b("HomeFragment", "dataSync 4");
        ao();
        m11401H();
        aX();
        aW();
        this.f8016a.m12296a();
        an();
        aL();
        m11386A();
        bF();
    }

    private void an() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "enter syncCardInformationToWacth");
        C2538c.m12661a("MainUI", 0, "HomeFragment", " syncCardInformationToWacth isSyncCardInformation : " + this.aw);
        if (!C0969i.m3482a(53) || this.aw) {
            return;
        }
        if (this.ag == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", " syncCardInformationToWacth currentDeviceInfo is null return");
        } else if (2 != this.ag.getDeviceConnectState()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", " syncCardInformationToWacth DEVICE_CONNECTED return");
        } else {
            this.ao = this.f8004M.m10411a();
            if (this.ao != null) {
                this.aw = true;
                if (this.ag != null && this.ao.isSupportPay()) {
                    String c = C1093a.m4739a(this.f8041z).m4750c();
                    C2538c.m12661a("MainUI", 0, "HomeFragment", " syncCardInformationToWacth userID : " + c);
                    if (!(c == null || "".equals(c))) {
                        C1089a.m4692a().m4698a(c, null);
                    }
                    PluginPay instance = PluginPay.getInstance(this.f8041z);
                    instance.setAdapter(com.huawei.g.a.b.a());
                    instance.SyncCardInformation();
                }
            }
        }
    }

    private void ao() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter dataSync()");
        if (this.bu == null) {
            C2538c.m12679d("HomeFragment", "dataSync() if (mCardFlowInteractors == null || handler == null)");
            return;
        }
        C2243a.m11601a().m11609a(new ab(this));
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Leave dataSync()");
    }

    private void m11485b(DeviceInfo deviceInfo) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter updateIdImage ：" + deviceInfo.getProductType());
        if (deviceInfo.getProductType() == 10 && TextUtils.equals(deviceInfo.getDeviceModel(), "PORSCHE DESIGN")) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter updateIdImage ：baoshijie!!!!!");
            this.f8030o.setBackgroundResource(h.id_home_watch2p);
        } else if (deviceInfo.getProductType() == 11 && TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
            this.f8030o.setBackgroundResource(h.r1_pro_banner);
        } else {
            this.f8030o.setBackgroundResource(C2243a.m11601a().m11606a(deviceInfo.getProductType()));
        }
    }

    private void m11495c(int i) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter updateBluetoothState isConnect：" + i);
        this.f8020e.clearAnimation();
        if (2 == i) {
            this.f8020e.setImageResource(h.ic_bluetooth_connected);
            this.f8025j.setText(this.f8041z.getResources().getString(i.IDS_myfitnesspal_login));
            this.f8029n.setVisibility(8);
            this.bu.sendEmptyMessage(1002);
        } else if (1 == i) {
            ap();
        } else if (5 == i) {
            this.f8020e.setImageResource(h.ic_bluetooth_disconnected);
            this.f8025j.setText(this.f8041z.getResources().getString(i.IDS_myfitnesspal_logout));
            this.f8026k.setVisibility(4);
            this.f8028m.setVisibility(4);
            this.f8029n.setVisibility(0);
            aB();
        } else {
            this.f8020e.setImageResource(h.ic_bluetooth_disconnected);
            this.f8025j.setText(this.f8041z.getResources().getString(i.IDS_myfitnesspal_logout));
            this.f8026k.setVisibility(4);
            this.f8028m.setVisibility(4);
            this.f8029n.setVisibility(0);
            aq();
            m11489b(false);
        }
    }

    private void ap() {
        this.f8020e.setImageResource(h.ic_bluetooth_connecting);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), b.anim_bt_connecting);
        this.f8020e.clearAnimation();
        this.f8020e.startAnimation(loadAnimation);
        this.f8025j.setText(this.f8041z.getResources().getString(i.IDS_device_connecting_21));
        this.f8026k.setVisibility(4);
        this.f8028m.setVisibility(4);
        this.f8029n.setVisibility(8);
    }

    private void aq() {
        if (this.f8015Z != null && this.f8015Z.m10329a()) {
            this.f8015Z.m10325a(Boolean.valueOf(false));
        }
    }

    private void m11502d(int i) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter refreshBattery value:" + i);
        Message message = new Message();
        message.what = 1003;
        message.arg1 = i;
        this.bu.sendMessage(message);
    }

    private void ar() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter registerDeviceBatteryRefreshBroadcast");
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.BATTERY_LEVEL");
        intentFilter.addAction("com.huawei.bone.action.BATTERY_LEVEL");
        if (this.f8041z != null) {
            this.f8041z.registerReceiver(this.bw, intentFilter, C0976c.f1642a, null);
        }
    }

    private void as() {
        try {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter unRegisterDeviceBatteryRefreshBroadcast():");
            if (this.f8041z != null) {
                this.f8041z.unregisterReceiver(this.bw);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void at() {
        try {
            this.f7993B.unregisterReceiver(this.bx);
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void m11507e(int i) {
        if (getActivity() == null || getActivity().isFinishing()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "activity is finish");
        } else if (this.ar == null) {
            com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(this.f8041z, j.app_update_dialogActivity);
            this.ar = com.huawei.ui.commonui.dialog.a.a(this.f8041z);
            this.ar.a(this.f8041z.getString(i));
            this.ar.a();
        } else {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "mLoadingDialog21 is not null");
        }
    }

    public void m11556k() {
        if (getActivity() != null && !getActivity().isFinishing() && this.ar != null) {
            this.ar.cancel();
            this.ar = null;
            C2538c.m12661a("MainUI", 0, "HomeFragment", "destroy mLoadingDialog21");
        }
    }

    private void au() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("parieddevicesswitcher_wait_dialog_broadcast");
        this.f7993B = LocalBroadcastManager.getInstance(BaseApplication.m2632b());
        if (this.f7993B != null) {
            this.f7993B.registerReceiver(this.bx, intentFilter);
        } else {
            this.f7993B = LocalBroadcastManager.getInstance(BaseApplication.m2632b());
        }
    }

    private void av() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.CORE_SLEEP_DATA_SYNC_COMPLETED");
        intentFilter.addAction("com.huawei.bone.action.open_gps");
        intentFilter.setPriority(1000);
        intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
        this.f8041z.registerReceiver(this.bz, intentFilter, C0976c.f1642a, null);
    }

    private void aw() {
        try {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter unregisterNonLocalBroadcast()!");
            this.f8041z.unregisterReceiver(this.bz);
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (Exception e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void ax() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "registerAutoCheckBroadcast()");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_band_auto_check_new_version_result");
        this.f8041z.registerReceiver(this.by, intentFilter, C0976c.f1642a, null);
    }

    private void ay() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "unregisterAppCheckBroadcast()");
        try {
            this.f8041z.unregisterReceiver(this.by);
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void m11467a(String str) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "showForcedUpdateDialog deviceName:" + str);
        if (this.f8015Z == null) {
            this.f8015Z = ah.m10316a(this.f8041z);
        }
        if (this.f8015Z.m10353t()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "band is showing!");
        } else if (C0977d.m3576o(this.f8041z)) {
            this.aH = str;
            this.aI = Boolean.valueOf(true);
            this.aJ = Boolean.valueOf(true);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "showForcedUpdateDialog isBackground!");
        } else {
            Intent intent = new Intent();
            intent.putExtra("deviceName", str);
            intent.putExtra("isForced", true);
            intent.setClass(this.f8041z, BandUpdateDialogActivity.class);
            this.f8041z.startActivity(intent);
        }
    }

    private void m11469a(String str, int i, String str2, String str3, boolean z) {
        if (this.f8015Z == null) {
            this.f8015Z = ah.m10316a(this.f8041z);
        }
        if (this.f8015Z.m10353t()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "band is showing!");
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "showBandAutoCheckDialog version:" + str);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "showBandAutoCheckDialog size:" + i);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "showBandAutoCheckDialog changeLog:" + str2);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "showBandAutoCheckDialog deviceName:" + str3);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "showBandAutoCheckDialog showCheckbox:" + z);
        if (C0977d.m3576o(this.f8041z)) {
            this.aD = str;
            this.aE = i;
            this.aF = str2;
            this.aG = Boolean.valueOf(z);
            this.aI = Boolean.valueOf(false);
            this.aJ = Boolean.valueOf(true);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "showBandAutoCheckDialog isBackground!");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("name", str);
        intent.putExtra(UploadFile.SIZE_LABEL, i);
        intent.putExtra(WBConstants.ACTION_LOG_TYPE_MESSAGE, str2);
        intent.putExtra("show", z);
        intent.setClass(this.f8041z, BandUpdateDialogActivity.class);
        this.f8041z.startActivity(intent);
    }

    private void az() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter showConnectingDeviceNoteDialog():");
        if (this.f7994C == null || !this.f7994C.isShowing()) {
            this.f7994C = new w(this.f8041z).a(i.IDS_device_replace_dialog_title_notification).b(i.IDS_device_connecting_now_please_wait).a();
            this.f7994C.setCancelable(true);
            this.f7994C.show();
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "waitConnectingDlg is showing ,return");
    }

    private void aA() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter dismissConnectingDeviceNoteDialog():");
        if (this.f7994C != null && this.f7994C.isShowing()) {
            this.f7994C.cancel();
        }
    }

    private void aB() {
        C2538c.m12674b("HomeFragment", "showBandUnavailableDialog");
        C2538c.m12674b("HomeFragment", "isForeground : " + C0977d.m3560f(this.f8041z, "com.huawei.bone.root.MainActivity"));
        if (!C0977d.m3560f(this.f8041z, "com.huawei.bone.root.MainActivity")) {
            return;
        }
        if (this.aV == null || !this.aV.isShowing()) {
            this.aV = new w(this.f8041z).a(i.IDS_service_area_notice_title).b(this.f8041z.getString(i.IDS_band_is_unavailable_tip_string_new)).a(i.IDS_common_notification_know_tips, new ah(this)).a();
            this.aV.setCancelable(false);
            if (!this.aV.isShowing()) {
                this.aV.show();
                return;
            }
            return;
        }
        C2538c.m12674b("HomeFragment", "showBandUnavailableDialog Already show!");
    }

    public void m11543a(DeviceInfo deviceInfo) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "handleConnectStateChanged() Process.myPid():" + Process.myPid());
        if (this.f8019d == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "initView is not completed");
        }
    }

    private boolean m11511f(int i) {
        boolean z;
        if (3 == i || 10 == i) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12674b("HomeFragment", "Enter isWatch type:" + i + " res:" + z);
        return z;
    }

    private void m11496c(DeviceInfo deviceInfo) {
        C2538c.m12674b("HomeFragment", "Enter connectedChanged");
        aA();
        this.bu.removeMessages(1013);
        this.bu.sendEmptyMessageDelayed(1013, 1000);
        this.bu.removeCallbacks(this.bv);
        this.f8019d.m11689c();
        if (deviceInfo != null) {
            int deviceConnectState = deviceInfo.getDeviceConnectState();
            C2538c.m12674b("HomeFragment", "connectedChanged(): " + deviceInfo.getDeviceName() + ",state = " + deviceConnectState);
            this.ag = C2243a.m11601a().m11614c();
            if (this.ag != null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "currentDeviceInfo.getProductType():" + this.ag.getProductType());
                C2538c.m12661a("MainUI", 0, "HomeFragment", "deviceInfo.getProductType():" + deviceInfo.getProductType());
                if (!((m11511f(this.ag.getProductType()) && m11511f(deviceInfo.getProductType())) || this.ag.getProductType() == deviceInfo.getProductType() || -1 == deviceInfo.getProductType() || 2 == deviceConnectState)) {
                    C2538c.m12661a("MainUI", 0, "HomeFragment", "get a connect change report,but it is not belong to current device,so return");
                    return;
                }
            }
            switch (deviceConnectState) {
                case 2:
                    this.f8009R = true;
                    m11495c(2);
                    am();
                    if (this.ax == 0) {
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "connected change view!");
                        m11489b(true);
                    }
                    this.f8019d.m11687a(new DeviceInfo[0]);
                    m11485b(deviceInfo);
                    Object uuid = deviceInfo.getUUID() == null ? "" : deviceInfo.getUUID();
                    C2538c.m12674b("HomeFragment", "currentUUID:" + uuid + "  lastDeviceUUID:" + this.f8007P);
                    if (uuid.equals(this.f8007P) || TextUtils.isEmpty(uuid)) {
                        C2538c.m12674b("HomeFragment", "connectedChanged() mac error or same mac");
                    } else {
                        this.f8008Q.smoothScrollTo(0, 0);
                        this.f8007P = uuid;
                        aI();
                    }
                    if (!this.bi) {
                        m11394E();
                    }
                    if (!this.bj) {
                        m11396F();
                    }
                    C2254l.m11647a().m11659d();
                    break;
                default:
                    this.f8009R = false;
                    m11495c(deviceConnectState);
                    break;
            }
            C2538c.m12674b("HomeFragment", "connectedChanged() isConnected:" + this.f8009R);
            ai();
            return;
        }
        C2538c.m12680e("HomeFragment", "deviceInfo is null!");
    }

    private void m11503d(DeviceInfo deviceInfo) {
        C2538c.m12661a("MainUI", 0, "Enter processConnectedStateChange ", new Object[0]);
        if (deviceInfo == null || C2243a.m11601a() == null || C2243a.m11601a().m11618g()) {
            C2538c.m12661a("MainUI", 0, "processConnectedStateChange close BT Dialog!", new Object[0]);
            if (this.be != null) {
                this.be.dismiss();
                this.be = null;
                return;
            }
            return;
        }
        C2538c.m12661a("MainUI", 0, "processConnectedStateChange BT switch is false!", new Object[0]);
        bE();
    }

    public void m11557l() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "handlePhoneServiceBindSuccess()");
        if (this.f8020e == null) {
            C2538c.m12679d("HomeFragment", "handlePhoneServiceBindSuccess if (mCurrentDeviceBand == null)");
            return;
        }
        m11489b(true);
        C2538c.m12674b("HomeFragment", "dataSync 3");
        ao();
    }

    private void m11489b(boolean z) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter showNoDevicesView");
        C2538c.m12661a("MainUI", 0, "HomeFragment", "list size:" + C2243a.m11601a().m11617f().size());
        if (C2243a.m11601a().m11617f().size() > 0 || this.ag != null) {
            if (this.ag == null && z) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "auto change");
                this.f8019d.m11686a();
            }
            this.f8040y.setVisibility(0);
            if (this.f8038w != null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "auto change3");
                this.f8038w.setVisibility(8);
            }
            aF();
            return;
        }
        aC();
        this.f8019d.m11687a(new DeviceInfo[0]);
        this.f8040y.setVisibility(8);
        this.f8038w.setVisibility(0);
        this.f8030o.setBackgroundResource(0);
        aE();
    }

    private void aC() {
        if (this.f8039x.getParent() != null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "viewStub loaded");
            this.f8039x.inflate();
            this.f8021f = (Button) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_fragment_paired);
            this.f8021f.setOnClickListener(this.bs);
            this.f8022g = (TextView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.home_fragment_note);
            this.f8027l = (ImageView) com.huawei.ui.commonui.d.d.a(this.f8018c, f.fragment_home_no_device_image);
            this.f8038w = this.f8039x;
            String string = this.f7992A.getString(i.IDS_main_no_device_click);
            int[] iArr = new int[]{this.f7992A.getString(i.IDS_main_no_device, new Object[]{string}).indexOf(string)};
            CharSequence spannableString = new SpannableString(r1);
            spannableString.setSpan(new ai(this), iArr[0], string.length() + iArr[0], 33);
            this.f8022g.setText(spannableString);
            this.f8022g.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "viewStub loaded enter else");
    }

    private int aD() {
        int i = h.id_nodevice_talkband_b3;
        if (1 == this.f8000I) {
            i = h.id_nodevice_talkband_b3;
        } else if (2 == this.f8000I) {
            i = h.id_nodevice_talkband_b2;
        } else if (3 == this.f8000I) {
            i = h.id_nodevice_talkband_b1;
        } else if (4 == this.f8000I) {
            i = h.id_nodevice_talkband_b0;
        } else if (5 == this.f8000I) {
            i = h.id_nodevice_metis;
        } else if (6 == this.f8000I) {
            i = h.id_nodevice_colorband;
        } else if (7 == this.f8000I) {
            i = h.id_nodevice_watch2sport;
        } else if (8 == this.f8000I) {
            i = h.id_nodevice_eris;
        } else if (9 == this.f8000I) {
            i = h.id_nodevice_talkband_a1;
        } else if (10 == this.f8000I) {
            i = h.id_nodevice_honorband_r1;
        } else if (11 == this.f8000I) {
            i = h.id_nodevice_nyx;
        } else if (12 == this.f8000I) {
            i = h.id_nodevice_grus;
        } else if (this.f8000I == 0) {
            i = h.id_nodevice_watch;
        }
        this.f8000I = (this.f8000I + 1) % 13;
        return i;
    }

    private void aE() {
        if (true != this.f8003L && this.f8027l != null) {
            this.f8003L = true;
            this.f8027l.clearAnimation();
            this.f8027l.setVisibility(0);
            this.f8027l.startAnimation(this.f8001J);
        }
    }

    private void aF() {
        if (this.f8027l != null) {
            this.f8003L = false;
            this.f8027l.setVisibility(8);
            this.f8027l.clearAnimation();
        }
    }

    private boolean aG() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getIdleRemind enter.");
        return this.f8004M.m10442f();
    }

    private void aH() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNoDisturb()");
        this.f8004M.m10415a(this.f8041z, new al(this));
    }

    public void m11558m() {
        if (getActivity() != null && !getActivity().isFinishing() && this.aq != null) {
            this.aq.cancel();
            this.aq = null;
            C2538c.m12661a("MainUI", 0, "HomeFragment", "destroy RestoreFactoryDialog");
        }
    }

    private void m11475a(String[] strArr) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "requestPermissions() hasPermissionNeeded =" + com.huawei.hwcommonmodel.d.b.a(this.f7992A, strArr));
        if (com.huawei.hwcommonmodel.d.b.a(this.f7992A, strArr)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "requestPermissions() permission if (!hasPermissionNeeded) ELSE");
            return;
        }
        com.huawei.hwcommonmodel.d.b.a(this, strArr, new am(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Activity-onRequestPermissionsResult(), PermissionsManager.notifyPermissionsChange()");
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Activity-onRequestPermissionsResult() READ_PHONE_STATE permissione =" + this.f8041z.checkCallingPermission("android.permission.READ_PHONE_STATE"));
        if (this.bu != null) {
            this.bu.sendEmptyMessage(1015);
        }
        if (r0 == 0) {
            Intent intent = new Intent(this.f8041z, PhoneService.class);
            intent.setAction("com.huawei.bone.action.REGISTER_PHONE_LISTEN");
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Activity-onRequestPermissionsResult(), start PhoneService first");
            this.f8041z.startService(intent);
        }
        com.huawei.hwcommonmodel.d.a.b.a().a(strArr, iArr);
    }

    public void onStart() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onStart()");
        super.onStart();
        this.bu.sendEmptyMessageAtTime(1009, 3000);
    }

    public void onResume() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onResume Process.myPid():" + Process.myPid());
        super.onResume();
        aK();
        this.bg.m11645c();
        Executors.newSingleThreadExecutor().execute(new aq(this));
        aO();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "onResume lastSyncTime = " + this.ay + ",currentTime = " + System.currentTimeMillis());
        if (System.currentTimeMillis() - this.ay >= 120000) {
            this.ay = System.currentTimeMillis();
            aL();
        }
        m11484b(200);
        m11434Y();
        m11436Z();
        bD();
        this.ag = C2243a.m11601a().m11614c();
        m11416P();
        if (this.ag != null) {
            m11485b(this.ag);
        }
        this.f8019d.m11687a(this.ag);
        m11489b(true);
        m11503d(this.ag);
        m11408L();
        aB.execute(new cb());
        C1026q.m4018a(this.f7992A).m4147o();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onResume isMigrateDataEnter = " + this.aY);
        if (!this.aY) {
            this.aY = true;
            aB.execute(new ca());
        }
        if (C1093a.m4739a(this.f8041z).m4752e() == 7 && bq()) {
            Executors.newSingleThreadExecutor().execute(new ar(this));
        }
        if (C0800a.m2682a()) {
            C0996a c0996a = new C0996a();
            C2538c.m12661a("MainUI", 0, "HomeFragment", "the flag is " + C0996a.m3612a(BaseApplication.m2632b(), "security_setting", "popup_flag"));
            if ("true".equals(C0996a.m3612a(BaseApplication.m2632b(), "security_setting", "popup_flag"))) {
                new ao(this.f8041z).a().show();
                C0996a.m3611a(BaseApplication.m2632b(), "security_setting", "popup_flag", "false", null);
            }
        }
        aJ();
        bA();
        this.bu.sendEmptyMessageDelayed(27, 500);
        bF();
    }

    private void aI() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter getPermissions");
        this.ag = C2243a.m11601a().m11614c();
        if (this.ag != null) {
            this.ao = this.f8004M.m10411a();
            if (this.ao == null || !this.ao.isWeather_push()) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "NOT SUPPORT WEATHER PUSH");
                m11475a(aM);
                return;
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "SUPPORT WEATHER PUSH");
            m11475a(aN);
        }
    }

    private void aJ() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onResume private void showRateRemiderDialog() = " + this.f7999H.m12014m());
        if (this.f7999H.m12014m()) {
            m11465a(bz.RATE);
        }
    }

    private void aK() {
        List b = this.f8019d.m11688b();
        if (b != null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onResume updateSwitchPopwindow devices.size() = " + b.size());
        }
        if (b == null || b.size() - 1 <= 0) {
            this.f8019d.f8210a.setVisibility(8);
        } else {
            this.f8019d.f8210a.setVisibility(0);
        }
    }

    private void aL() {
        C1026q.m4018a(this.f7992A).m4130b(new as(this));
    }

    private void aM() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter registerGetKidWatchSuccessBroadcast():");
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.DEVICE_LIST_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.ACTION_GET_KIDWATCH_SUCCESS");
        if (this.f8041z != null) {
            this.f8041z.registerReceiver(this.bC, intentFilter, C0976c.f1642a, null);
        }
    }

    private void aN() {
        try {
            if (this.f8041z != null) {
                this.f8041z.unregisterReceiver(this.bC);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void aO() {
        int c = C0977d.m3546c(this.f7992A, C0996a.m3612a(this.f7992A, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_TOTAL_STEPS_FROM_DEVICE_FLAG"));
        int c2 = C0977d.m3546c(this.f7992A, C0996a.m3612a(this.f7992A, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_TOTAL_CAL_FROM_DEVICE_FLAG"));
        C2538c.m12661a("MainUI", 0, "HomeFragment", " totalSteps =" + c + " totalCal =" + c2 + " totalDistance =" + C0977d.m3546c(this.f7992A, C0996a.m3612a(this.f7992A, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_TOTAL_DISTANCE_FROM_DEVICE_FLAG")));
        double d = (double) r0;
        if (C0956c.m3349a()) {
            d = C0956c.m3342a(d, 3);
            this.f8037v.setText(i.IDS_band_data_sport_distance_unit_en);
        } else {
            this.f8037v.setText(i.IDS_band_data_sport_distance_unit);
        }
        this.f8034s.setText(C0956c.m3344a((double) c, 1, 0));
        this.f8035t.setText(C0956c.m3344a((double) c2, 1, 0));
        this.f8036u.setText(C0956c.m3344a(d / 1000.0d, 1, 2));
    }

    public void onPause() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onPause");
        super.onPause();
        aF();
        if (this.be != null) {
            this.be.dismiss();
            this.be = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onDestroy");
        this.az.m11657b();
        this.f7997F.quit();
        this.f7998G.removeCallbacksAndMessages(null);
        this.bu.removeCallbacksAndMessages(null);
        this.bg.m11643a();
        v.l();
        com.huawei.g.a.b.b();
        as();
        ay();
        at();
        aQ();
        aV();
        aw();
        m11558m();
        ba();
        bj();
        bl();
        aN();
        c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cl.a(), new HashMap(), 0);
        this.f7993B = null;
        this.bi = false;
        this.bj = false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "Enter onActivityResult requestcode:" + i + ";resultcode:" + i2);
        super.onActivityResult(i, i2, intent);
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onActivityResult");
        String string;
        C1990r c1990r;
        C1990r c1990r2;
        switch (i) {
            case 5:
                aH();
                return;
            case 7:
                if (this.f8004M.m10448l()) {
                    string = this.f7992A.getString(i.IDS_status_enabled);
                } else {
                    string = this.f7992A.getString(i.IDS_status_disabled);
                }
                m11447a(7, this.ak, string);
                return;
            case 23:
                if (i2 == -1) {
                    c1990r = this.f8004M;
                    C2538c.m12661a("MainUI", 1, "HomeFragment", "coreSleepButton:" + intent.getStringExtra("status"));
                    c1990r2 = this.f8004M;
                    if ("0".equals(intent.getStringExtra("status"))) {
                        m11447a(23, this.ak, this.f7992A.getString(i.IDS_status_disabled));
                        return;
                    } else {
                        m11447a(23, this.ak, this.f7992A.getString(i.IDS_status_enabled));
                        return;
                    }
                }
                return;
            case 24:
                if (i2 == -1) {
                    c1990r = this.f8004M;
                    C2538c.m12661a("MainUI", 1, "HomeFragment", "heartRateButton:" + intent.getStringExtra("status"));
                    c1990r2 = this.f8004M;
                    if ("0".equals(intent.getStringExtra("status"))) {
                        m11447a(24, this.ak, this.f7992A.getString(i.IDS_status_disabled));
                        return;
                    } else {
                        m11447a(24, this.ak, this.f7992A.getString(i.IDS_status_enabled));
                        return;
                    }
                }
                return;
            case 26:
                string = "";
                if (this.f8004M.m10410a(null) == 0) {
                    string = this.f7992A.getString(i.IDS_WearPrefenc_left);
                } else {
                    string = this.f7992A.getString(i.IDS_WearPrefenc_right);
                }
                m11447a(26, this.ak, string);
                return;
            case 101:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter checkGpsPermission 1");
                bC();
                return;
            case 102:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter checkGpsPermission 2");
                bC();
                return;
            default:
                C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter onActivityResult default");
                return;
        }
    }

    private void aP() {
        this.f7993B.registerReceiver(this.bD, new IntentFilter("com.huawei.bone.action.CLOUD_SWITCH_CHANGED"));
    }

    private void aQ() {
        try {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "HomeFragment Enter unregisterGetWeatherBroadcast()!");
            this.f7993B.unregisterReceiver(this.bD);
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "unregisterGetWeatherBroadcast() e1 = " + e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "unregisterGetWeatherBroadcast() e2 = " + e2.getMessage());
        }
    }

    private void aR() {
        C1204c.m5370a(this.f7992A).m5458h(new av(this));
    }

    private boolean aS() {
        return PluginPay.getInstance(this.f8041z).isShowPay();
    }

    private boolean aT() {
        return com.huawei.sim.a.a(this.f8041z).b();
    }

    private void m11471a(String str, String str2) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "openApp() className = " + str2 + ",packName=" + str);
        if (!this.f7992A.getPackageName().equals(str)) {
            return;
        }
        RunningTaskInfo aU;
        if ("com.huawei.nfc.carrera.ui.cardlist.AddBankOrBusCardActivity".equals(str2)) {
            if (aT()) {
                C2538c.m12680e("HomeFragment", "wallet：正在eSIM");
                aU = aU();
                if (aU != null) {
                    m11468a(aU.topActivity.getClassName(), aU.id);
                    return;
                }
                return;
            }
            C2538c.m12661a("MainUI", 1, "HomeFragment", "openApp() isInWallet = " + aS());
            if (!aS()) {
                m11428V();
            }
        } else if ("com.huawei.bone.root.MainActivity".equals(str2)) {
            C2538c.m12680e("HomeFragment", "APP_OPEN_MAIN_CLASS");
            aU = aU();
            if (aU != null) {
                m11468a(aU.topActivity.getClassName(), aU.id);
            }
        } else if (!"com.huawei.sim.esim.view.EsimActivationActivity".equals(str2) && !"com.huawei.sim.esim.view.WirelessManagerAcitivity".equals(str2)) {
        } else {
            if (aS()) {
                C2538c.m12680e("HomeFragment", "eSIM：正在显示钱包");
                aU = aU();
                if (aU != null) {
                    m11468a(aU.topActivity.getClassName(), aU.id);
                }
            } else if (!aT()) {
                m11430W();
            }
        }
    }

    private RunningTaskInfo aU() {
        List<RunningTaskInfo> runningTasks = ((ActivityManager) this.f8041z.getSystemService("activity")).getRunningTasks(30);
        RunningTaskInfo runningTaskInfo = null;
        if (runningTasks != null && runningTasks.size() > 0) {
            for (RunningTaskInfo runningTaskInfo2 : runningTasks) {
                RunningTaskInfo runningTaskInfo22;
                if (!this.f7992A.getPackageName().equals(runningTaskInfo22.topActivity.getPackageName())) {
                    runningTaskInfo22 = runningTaskInfo;
                }
                runningTaskInfo = runningTaskInfo22;
            }
        }
        return runningTaskInfo;
    }

    private void m11468a(String str, int i) {
        if (str != null) {
            try {
                ActivityManager activityManager = (ActivityManager) this.f8041z.getSystemService("activity");
                C2538c.m12661a("MainUI", 0, "HomeFragment", "registerOpenAppIBaseResponseCallback() 在后台，拉到前台 " + str);
                Intent intent = new Intent();
                intent.setClass(this.f8041z, Class.forName(str));
                intent.setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                activityManager.moveTaskToFront(i, 1);
                this.f8041z.startActivity(intent);
            } catch (ClassNotFoundException e) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "exception:" + e.getMessage());
            }
        }
    }

    private void aV() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "unRegisterWearableManager() ");
        C1204c.m5370a(this.f7992A).m5463l();
    }

    private void aW() {
        if (this.f8004M == null) {
            C2538c.m12679d("HomeFragment", "pushWeatherReport() if (mDeviceInteractors == null)");
            return;
        }
        this.bu.removeMessages(1015);
        if (C0972a.m3502b() == null || C0972a.m3499a() == null || !C0972a.m3499a().isWeather_push() || !this.f8004M.m10448l()) {
            C2538c.m12661a("MainUI", 1, "HomeFragment", "cannot pushWeatherReport2Device");
        } else {
            C2538c.m12661a("MainUI", 1, "HomeFragment", "pushWeatherReport() pushWeatherReport2Device");
            this.f8004M.m10449m();
        }
        this.bu.sendEmptyMessageDelayed(1015, 7200000);
    }

    private void aX() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "checkLocationServiceStatus() ENTER");
        if (this.f8004M == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "checkLocationServiceStatus() if (mDeviceInteractors == null)");
            return;
        }
        this.ao = this.f8004M.m10411a();
        if (!this.f8004M.m10448l()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "checkLocationServiceStatus() if (!mDeviceInteractors.getWeatherReportSwitch())");
        } else if (this.ao == null || !this.ao.isWeather_push()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "not support weather push！");
        } else {
            LocationManager locationManager = (LocationManager) this.f8041z.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            if (locationManager == null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "checkLocationServiceStatus() if (locationManager == null)");
                return;
            }
            boolean z;
            C2538c.m12661a("MainUI", 0, "HomeFragment", "checkLocationServiceStatus() GPS_PROVIDER=" + locationManager.isProviderEnabled("gps") + "NETWORK_PROVIDER=" + locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER));
            if (C0972a.m3499a() == null || !C0972a.m3499a().isWeather_push()) {
                z = false;
            } else {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "isWeather_push capability is:" + true);
                z = true;
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "checkGPSStatus() isDeviceSupportWeatherPush: " + z);
            if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER) && z) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "checkLocationServiceStatus() if (!locationManager.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER) && !locationManager.isProviderEnabled(android.location.LocationManager.NETWORK_PROVIDER)&& isDeviceSupportWeatherPush");
                m11541a(i.IDS_homewear_turn_on_location_services_tip, 102);
            }
        }
    }

    public static DrawerLayout m11520n() {
        if (at != null) {
            return (DrawerLayout) at.get();
        }
        return null;
    }

    public static void m11449a(DrawerLayout drawerLayout) {
        at = new WeakReference(drawerLayout);
    }

    public static FrameLayout m11522o() {
        if (au != null) {
            return (FrameLayout) au.get();
        }
        return null;
    }

    public static void m11450a(FrameLayout frameLayout) {
        au = new WeakReference(frameLayout);
    }

    private void aY() {
        com.huawei.p.a.a();
        C1089a.m4692a();
    }

    private void aZ() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter registerDeleteDeviceBroadcast");
        IntentFilter intentFilter = new IntentFilter("action_delete_debice_in_device_manager_list");
        intentFilter.addAction("com.huawei.hihealth.user_preference");
        if (this.f7993B != null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter registerDeleteDeviceBroadcast localBroadcastManager != null");
            this.f7993B.registerReceiver(this.bE, intentFilter);
        }
    }

    private void ba() {
        try {
            this.f7993B.unregisterReceiver(this.bE);
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void bb() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter startMessageNotificationObserver!");
        this.az = C2254l.m11647a();
        if (this.az != null) {
            this.az.m11654a(this.f7998G);
            this.az.m11655a(this.bF);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "startMessageNotificationObserver getMessageTotalList");
            this.az.m11658c();
        } else {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "startMessageNotificationObserver enter null");
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Leave startMessageNotificationObserver!");
    }

    private void bc() {
        this.az.m11655a(this.bF);
    }

    private void bd() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter checkGoHealthForBind");
        this.ag = C2243a.m11601a().m11614c();
        if (this.ag == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter checkGoHealthForBind return");
            return;
        }
        f7991X.m10371a(this.ag.getProductType(), new ay(this));
    }

    private void be() {
        boolean z;
        if (Math.abs(System.currentTimeMillis() - C0977d.m3551d(this.f7992A, C0996a.m3612a(this.f7992A, String.valueOf(10000), "homefragment_time_of_show_goto_health"))) < m11559p()) {
            z = false;
        } else {
            z = true;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "time space:" + Math.abs(System.currentTimeMillis() - C0977d.m3551d(this.f7992A, C0996a.m3612a(this.f7992A, String.valueOf(10000), "homefragment_time_of_show_goto_health"))) + " isSpaceMatch:" + z);
        if (C0969i.m3482a(60)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "checkGoHealthForBind inchina");
            this.ag = C2243a.m11601a().m11614c();
            if (!f7991X.m10378b()) {
                return;
            }
            if (z) {
                C0996a.m3611a(this.f8041z, String.valueOf(10000), "homefragment_time_of_show_goto_health", System.currentTimeMillis() + "", new C0993c());
                bg();
                return;
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "not force migrate and time not match");
        } else if (z) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "checkGoHealthForBind overabord");
            bf();
        }
    }

    private void bf() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter overabroadcheckGoHealthForBind");
        if (C0969i.m3482a(60)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "overabroadcheckGoHealthForBind in china ,return");
            return;
        }
        this.ag = C2243a.m11601a().m11614c();
        if (this.ag != null) {
            if (f7990W == null) {
                f7990W = C1204c.m5370a(this.f8041z);
            }
            Executors.newSingleThreadExecutor().execute(new az(this));
        }
    }

    public long m11559p() {
        C2538c.m12677c("HomeFragment", "Enter getSpaceTime current:" + C0977d.m3551d(BaseApplication.m2632b(), C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10000), "union_join_show_notice_time")));
        if (C0977d.m3551d(BaseApplication.m2632b(), C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10000), "union_join_show_notice_time")) < 4) {
            return 86400000;
        }
        return LightCloudConstants.LightCloud_INTERVAL_TIME;
    }

    private void bg() {
        C2538c.m12677c("HomeFragment", "Enter guideToHealth");
        this.bu.postDelayed(new bd(this), 1000);
    }

    public String m11560q() {
        String str = "";
        if (this.aA != null && this.aA.size() > 0) {
            str = ((MessageObject) this.aA.get(0)).getImgUri();
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getNotificationIconUrl tepIconUrl = " + str);
        return str;
    }

    public String m11561r() {
        String str = "";
        if (this.aA != null && this.aA.size() > 0) {
            str = ((MessageObject) this.aA.get(0)).getMsgTitle();
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getMessageContent tepTitle = " + str);
        return str;
    }

    private void bh() {
        if (this.aA == null || this.aA.size() <= 0) {
            this.aO.setVisibility(8);
            return;
        }
        this.aO.setVisibility(0);
        this.aP.setImageDrawable(null);
        this.aQ.setVisibility(0);
        this.aQ.setText(m11561r());
        C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNotificationCardUI iconUrl = " + m11560q());
        m11488b(r0);
    }

    private void m11488b(String str) {
        if (str == null || str.isEmpty()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNotificationCardUI 5 iconUrl is null or isEmpty use ic_default_message_icon");
            this.aP.setImageDrawable(this.f7992A.getResources().getDrawable(h.ic_default_message_icon));
            return;
        }
        String scheme = Uri.parse(str).getScheme();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNotificationCardUI iconUrl 1 scheme = " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            int dimensionPixelSize = this.f7992A.getResources().getDimensionPixelSize(com.huawei.ui.homewear21.d.card_item_notification_panel_message_left_width);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNotificationCardUI iconUrl 2 scheme = " + scheme + " iconWidth = " + dimensionPixelSize);
            Picasso.with(this.f7992A).load(str).resize(dimensionPixelSize, dimensionPixelSize).placeholder(h.ic_default_message_icon).into(this.aP);
            return;
        }
        Matcher matcher = this.aU.matcher(str);
        scheme = matcher.find() ? matcher.group(1) : "";
        C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNotificationCardUI iconUrl 3 host = " + scheme);
        if (scheme == null || scheme.isEmpty()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNotificationCardUI iconUrl 4 host is null or isEmpty use ic_default_message_icon");
            this.aP.setImageDrawable(this.f7992A.getResources().getDrawable(h.ic_default_message_icon));
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "updateNotificationCardUI iconUrl getAssets().open(host) decodeStream");
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(this.f7992A.getAssets().open(scheme));
            C2538c.m12661a("MainUI", 0, "HomeFragment", "getAssets() open BitmapFactory.decodeStream");
            if (decodeStream != null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "getAssets() open BitmapFactory.decodeStream setImageDrawable");
                this.aP.setImageDrawable(new BitmapDrawable(decodeStream));
            }
        } catch (IOException e) {
            C2538c.m12680e("HomeFragment", "getAssets() open BitmapFactory.decodeStream e = " + e.getMessage());
        }
    }

    public String m11562s() {
        String str = "";
        if (this.aA != null && this.aA.size() > 0) {
            str = ((MessageObject) this.aA.get(0)).getMsgId();
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getMessageID tepMessageID = " + str);
        return str;
    }

    public String m11563t() {
        String str = "";
        if (this.aA != null && this.aA.size() > 0) {
            str = ((MessageObject) this.aA.get(0)).getDetailUri();
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getDetailUrl tepDetialUrl = " + str);
        return str;
    }

    private void bi() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter registerUpdateHealthDataBroadcast");
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.FITNESS_DATA_TODAY_SYNC");
        if (this.f8041z != null) {
            this.f8041z.registerReceiver(this.bG, intentFilter, C0976c.f1642a, null);
        }
    }

    private void bj() {
        try {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter unRegisterUpdateHealthDataBroadcast():");
            if (this.f8041z != null) {
                this.f8041z.unregisterReceiver(this.bG);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void bk() {
        this.f8041z.registerReceiver(this.bH, new IntentFilter("com.huawei.bone.action.ACTION_DIALOG_DISMISS"), C0976c.f1642a, null);
    }

    private void bl() {
        try {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter unregisterDialogDismissBroadcast()!");
            if (this.f8041z != null) {
                this.f8041z.unregisterReceiver(this.bH);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", e2.getMessage());
        }
    }

    private void bm() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter showDataSynchronizingDialog():");
        this.f7995D = new w(this.f8041z).a(i.IDS_device_replace_dialog_title_notification).b(i.IDS_device_synchronizing_data_content).a();
        this.f7995D.setCancelable(true);
        this.f7995D.show();
    }

    private void bn() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter dismissDataSynchronizingDialog():");
        if (this.f7995D != null && this.f7995D.isShowing()) {
            this.f7995D.cancel();
        }
    }

    private void bo() {
        GetPrivacyRecordReq getPrivacyRecordReq = new GetPrivacyRecordReq();
        getPrivacyRecordReq.setPrivacyId(Integer.valueOf(10000));
        this.f8010S.a(getPrivacyRecordReq, new bi(this));
    }

    private void m11453a(com.huawei.hwdatamigrate.hihealth.f.b bVar) {
        if (!WebViewActivity.a(this.f8041z)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "startSync when in wifi condition");
            bVar.a();
        } else if ("true".equals(C0996a.m3612a(this.f8041z, String.valueOf(10000), "key_allowed_with_3G"))) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "startSync when KEY_ALLOWED_WITH_3G is true");
            bVar.a();
        }
    }

    private HiAccountInfo bp() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getHiAccountInfo called");
        HiAccountInfo hiAccountInfo = new HiAccountInfo();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "the user_id is " + C1093a.m4739a(this.f8041z).m4750c());
        String g = C1093a.m4739a(this.f8041z).m4754g();
        hiAccountInfo.setHuid(r1);
        hiAccountInfo.setServiceToken(g);
        hiAccountInfo.setAccessToken("");
        return hiAccountInfo;
    }

    private boolean bq() {
        ArrayList c = new bd().c(be.m3648a(), C1093a.m4739a(this.f8041z).m4750c());
        if (c == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "migratetables is null.");
            return false;
        } else if (c.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void br() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "AddPrivacyRecord Enter");
        AddPrivacyRecordReq addPrivacyRecordReq = new AddPrivacyRecordReq();
        addPrivacyRecordReq.setPrivacyId(Integer.valueOf(10000));
        addPrivacyRecordReq.setOpinion(Integer.valueOf(1));
        addPrivacyRecordReq.setDescription("Privacy ID of the migration of abroad version");
        this.f8010S.a(addPrivacyRecordReq, bI);
    }

    private void bs() {
        com.huawei.hwdatamigrate.hihealth.f.b a = com.huawei.hwdatamigrate.hihealth.f.b.a(this.f8041z);
        if (this.f8011T == null) {
            this.f8011T = new w(this.f8041z).a(i.IDS_service_area_notice_title).b(i.IDS_app_help_3gnet_diag_conent).b(i.IDS_apphelp_pwindows_back_button, new bm(this)).a(i.IDS_apphelp_pwindows_continue_button, new bl(this, a)).a();
            this.f8011T.setCancelable(false);
        }
        if (!getActivity().isFinishing()) {
            this.f8011T.show();
        }
    }

    private void bt() {
        if (!getActivity().isFinishing() && this.f8011T != null) {
            this.f8011T.cancel();
        }
    }

    private void bu() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "getSyncVersions Enter retryTimes is " + aC);
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(1));
        arrayList.add(Integer.valueOf(2));
        arrayList.add(Integer.valueOf(3));
        try {
            List<SyncKey> arrayList2 = C1017i.m3898a(this.f8041z, 2, arrayList2);
            if (arrayList2 == null || arrayList2.size() == 0) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "no data in versionsList");
            } else {
                int i;
                C2538c.m12661a("MainUI", 0, "HomeFragment", "list size of  getSyncVersionsResp is " + arrayList2.size());
                for (SyncKey version : arrayList2) {
                    if (version.getVersion().longValue() != 0) {
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i != 0) {
                    bo();
                }
            }
            aC = 0;
        } catch (C1004h e) {
            C2538c.m12680e("HomeFragment", "SyncException: get data error: " + e.getMessage());
            if (aC < 3) {
                aC++;
                bu();
            }
        }
    }

    private void bv() {
        if (this.aR == null || this.aZ == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support Swim ItemView is null , return");
        } else if (this.aR.getVisibility() == 0) {
            this.aZ.setVisibility(8);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support refreshSwimCardItemView is show , return");
        } else if (-1 == this.bd || this.bd > 10001100) {
            this.aZ.setVisibility(8);
        } else {
            this.aZ.setVisibility(0);
        }
    }

    private void bw() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support Swim() enter.");
        if (this.aR == null || this.aZ == null || this.f7999H == null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support Swim ItemView is null , return");
        } else if (this.aR.getVisibility() == 0) {
            this.aZ.setVisibility(8);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support CardItemView is show , return");
        } else if (C0977d.m3572k(this.f7992A) == null) {
            this.aZ.setVisibility(8);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support Health is not install , return");
        } else {
            if (by()) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support appHasUpdate");
            } else if (this.f7999H.m12008j()) {
                this.aZ.setVisibility(8);
                C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh Health Support Health has show , return");
                return;
            }
            aB.execute(new bn(this));
        }
    }

    private void bx() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter gotoHealth download");
        Intent intent = new Intent(this.f8041z, HealthStartActivity.class);
        intent.putExtra("action_need_download_new_health_app", 1);
        this.f8041z.startActivity(intent);
    }

    private boolean by() {
        boolean z = true;
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter appHasUpdate");
        int l = this.f7999H.m12011l();
        int d = C0977d.m3550d(this.f8041z);
        C2538c.m12661a("MainUI", 1, "HomeFragment", " refresh Health Support  loadAppVersion ： " + l + " ; currentAppVersion : " + d);
        if (1 == l || d <= l) {
            z = false;
        } else {
            this.f7999H.m12007j(false);
        }
        this.f7999H.m11990b(d);
        return z;
    }

    private void bz() {
        this.f7999H.m12012l(false);
        if (this.f8012U == null || !this.f8012U.isShowing()) {
            View inflate = LayoutInflater.from(this.f8041z).inflate(g.fragment_set_rate_reminder_dialog, null);
            ImageView imageView = (ImageView) inflate.findViewById(f.fragment_set_rate_reminder_dialog_image);
            TextView textView = (TextView) inflate.findViewById(f.fragment_set_rate_reminder_dialog_text);
            DeviceInfo c = C2243a.m11601a().m11614c();
            if (c == null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "refresh dialog Support deviceInfo is null , return");
                m11487b(bz.RATE);
                return;
            }
            if (3 == c.getProductType() || 10 == c.getProductType() || 8 == c.getProductType()) {
                imageView.setImageResource(e.home_set_rate_watch_remider_image);
                textView.setText(i.IDS_main_homefragment_rate_reminder_watch_text);
            } else if (13 == c.getProductType() || 15 == c.getProductType() || 12 == c.getProductType()) {
                imageView.setImageResource(e.home_set_rate_band_remider_image);
                textView.setText(i.IDS_main_homefragment_rate_reminder_band_text);
            } else {
                m11487b(bz.RATE);
                return;
            }
            com.huawei.ui.commonui.dialog.c b = new com.huawei.ui.commonui.dialog.c(this.f8041z).b(i.IDS_common_notification_know_tips, new bo(this));
            this.f8012U = b.a();
            b.a(inflate);
            this.f8012U.setCancelable(false);
            if (!this.f8012U.isShowing() && !getActivity().isFinishing()) {
                this.f8012U.show();
                return;
            }
            return;
        }
        C2538c.m12674b("HomeFragment", "showDialogSetlock Already show!");
        m11487b(bz.RATE);
    }

    private void bA() {
        C2538c.m12677c("HomeFragment", "checkGpsSwitch");
        if (SyncFitnessDetailDataBroadcastReceiver.m4149a()) {
            bB();
        }
    }

    private void bB() {
        C2538c.m12677c("HomeFragment", "need show gps switch note");
        SyncFitnessDetailDataBroadcastReceiver.m4148a(false);
        if (com.huawei.s.j.a(this.f8041z)) {
            bC();
        } else {
            m11541a(i.IDS_hw_show_sport_dialog_open_gps_content, 101);
        }
    }

    private void bC() {
        if (getActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            m11475a(aN);
        }
    }

    public void m11541a(int i, int i2) {
        ai a = new ak(this.f8041z).a(i).b(i.IDS_user_permission_know, new br(this)).a(i.IDS_main_btn_state_settings, new bp(this, i2)).a();
        if (!a.isShowing() && !getActivity().isFinishing()) {
            a.show();
        }
    }

    private void m11465a(bz bzVar) {
        switch (bv.f8095a[bzVar.ordinal()]) {
            case 1:
                bz();
                return;
            case 2:
                m11388B();
                return;
            default:
                this.bJ.add(bzVar);
                return;
        }
    }

    private void m11487b(bz bzVar) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter removeMessage:" + bzVar + " messageList.size():" + this.bJ.size());
    }

    private void bD() {
        if (this.aJ.booleanValue()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter checkIsNeedShowDialog isNeedShowDialog");
            Intent intent;
            if (this.aI.booleanValue()) {
                intent = new Intent();
                intent.putExtra("deviceName", this.aH);
                intent.putExtra("isForced", true);
                intent.setClass(this.f8041z, BandUpdateDialogActivity.class);
                this.f8041z.startActivity(intent);
            } else {
                intent = new Intent();
                intent.putExtra("name", this.aD);
                intent.putExtra(UploadFile.SIZE_LABEL, this.aE);
                intent.putExtra(WBConstants.ACTION_LOG_TYPE_MESSAGE, this.aF);
                intent.putExtra("show", this.aG);
                intent.setClass(this.f8041z, BandUpdateDialogActivity.class);
                this.f8041z.startActivity(intent);
            }
            this.aJ = Boolean.valueOf(false);
        }
    }

    private void bE() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter showOpenSystemBluetoothDialog!!!");
        if (C2243a.m11601a() == null || C2243a.m11601a().m11618g()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "showOpenSystemBluetoothDialog 0000 !!!");
        } else if (this.be != null) {
            if (!this.be.isShowing()) {
                this.be.show();
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "showOpenSystemBluetoothDialog 1111 !!!");
        } else {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "showOpenSystemBluetoothDialog 2222 !!!");
            String string = this.f8041z.getResources().getString(i.IDS_app_name);
            string = String.format(this.f8041z.getResources().getString(i.IDS_device_bt_open_request_info), new Object[]{string});
            this.be = new ak(this.f8041z).a(string).b(this.f8041z.getResources().getString(i.IDS_device_bt_open_info_tip)).b(i.IDS_device_bt_left_btn_info, new bt(this)).a(i.IDS_device_bt_right_btn_info, new bs(this)).a();
            this.be.setCancelable(false);
            this.be.show();
        }
    }

    private void bF() {
        if (this.aK.booleanValue()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "onResume is checking notification");
            return;
        }
        DeviceInfo c = C2243a.m11601a().m11614c();
        if (c == null || 2 != c.getDeviceConnectState()) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "onResume is checking notification not connected");
            return;
        }
        if (this.ao == null) {
            this.ao = this.f8004M.m10411a();
        }
        if (this.ao.isMessage_alert() && this.f8006O.m10304a()) {
            aB.execute(new cc());
        } else {
            m11466a(Boolean.valueOf(false));
        }
    }

    private void bG() {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "enter checkIsNLEnable");
        if (C0977d.m3577p(this.f7992A)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "NL service is running!");
            m11466a(Boolean.valueOf(false));
            this.aK = Boolean.valueOf(false);
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "NL service is disabled ,need make message!");
        m11466a(Boolean.valueOf(true));
        this.aK = Boolean.valueOf(false);
    }

    private void m11466a(Boolean bool) {
        if (bool.booleanValue()) {
            if (this.aR == null || this.aZ == null || this.bb == null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "refreshBanner is null , return");
                return;
            }
            this.aZ.setVisibility(8);
            this.aZ.setVisibility(8);
            this.bb.setVisibility(0);
        } else if (this.bb != null) {
            this.bb.setVisibility(8);
        }
    }

    private void bH() {
        if (!C0969i.m3482a(60)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "initLightCloud not support");
        } else if (C0977d.m3555e(this.f7992A)) {
            LightCloud.getInstance(this.f7992A).doRefreshBatch(new bu(this));
        } else {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "no net to lightcloud");
        }
    }

    public void m11564u() {
        if (1 == C0977d.m3567i(this.f7992A)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "wifi state, enter triggerCtSdkCheck!");
            Intent intent = new Intent();
            intent.setAction("com.huawei.crowdtestsdk.UPLOAD_CHECK");
            this.f7992A.sendBroadcast(intent, "com.huawei.crowdtestsdk.permission.CTSDKGLOBAL");
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "unWifi state, don't triggerCtSdkCheck!");
    }
}
