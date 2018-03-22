package com.huawei.bone.root;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.bone.BuildConfig;
import com.huawei.bone.C6753R;
import com.huawei.bone.p552b.C6756a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.b;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwdatamigrate.a.h;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.HiAdSplash;
import com.huawei.openalliance.ad.inter.data.SplashParam.Builder;
import com.huawei.openalliance.ad.inter.listener.SplashListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;
import com.huawei.ui.main.stories.guide.a.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class SplashActivity extends Activity implements OnRequestPermissionsResultCallback {
    private static String[] f23272r = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    Class<?> f23273a = MainActivity.class;
    final C6756a f23274b = new C6756a();
    private int f23275c = 2;
    private CustomAlertDialog f23276d = null;
    private Context f23277e = null;
    private boolean f23278f = false;
    private boolean f23279g = false;
    private TextView f23280h;
    private int f23281i = 0;
    private int f23282j = -1;
    private Activity f23283k;
    private final int f23284l = 4;
    private int f23285m = C6753R.drawable.splash;
    private boolean f23286n = false;
    private a f23287o;
    private Handler f23288p;
    private Handler f23289q = new Handler(new ag(this));
    private final int f23290s = 1;
    private final int f23291t = 2;
    private final String f23292u = "com.huawei.hwid";
    private final int f23293v = 20501300;

    public int m30199a() {
        if (this.f23282j == 1) {
            return 2002;
        }
        if (this.f23282j == 2) {
            return 2003;
        }
        return 2001;
    }

    protected void onCreate(Bundle bundle) {
        C2538c.b("SplashActivity", new Object[]{"onCreate()"});
        super.onCreate(bundle);
        this.f23283k = this;
        this.f23288p = new as(getMainLooper(), this);
        Intent intent = getIntent();
        if (!isTaskRoot()) {
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory("android.intent.category.LAUNCHER") && action != null && action.equals("android.intent.action.MAIN")) {
                    C2538c.c("SplashActivity", new Object[]{"!this.isTaskRoot()  --> finish"});
                    finish();
                    return;
                }
            }
            return;
        }
        if (intent != null && "com.huawei.bone.ACTION_ADD_DEVICE".equals(intent.getAction())) {
            Object stringExtra = intent.getStringExtra("com.huawei.bone.extra.DEVICE_MAC_ADDRESS");
            C2538c.c("SplashActivity", new Object[]{"mac is ", stringExtra});
            if (!TextUtils.isEmpty(stringExtra)) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    try {
                        C2538c.c("SplashActivity", new Object[]{"device type is B0 " + m30176a(defaultAdapter.getRemoteDevice(stringExtra.toUpperCase(Locale.US)))});
                        if (!m30176a(defaultAdapter.getRemoteDevice(stringExtra.toUpperCase(Locale.US)))) {
                            C2538c.c("SplashActivity", new Object[]{"isSupport:", d.q(this)});
                            if ("SUPPORT".equals(d.q(this))) {
                                d.g(this, "com.huawei.bone.ACTION_ADD_DEVICE");
                                finish();
                                return;
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        C2538c.e("SplashActivity", new Object[]{"judge b0 error,", e.getMessage()});
                    }
                }
            }
        }
        this.f23287o = new a(BaseApplication.b());
        C2538c.b("SplashActivity", new Object[]{"onCreate(),getNo=" + this.f23287o.a() + ",protocolNum=" + this.f23275c});
        int i;
        if (this.f23287o.a() < this.f23275c) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.f23287o.b() && r0 == 0) {
            this.f23277e = this;
            if (m30191h()) {
                this.f23273a = ServiceAreaActivity.class;
                m30175a(this.f23273a);
                finish();
                return;
            }
            setContentView(C6753R.layout.activity_splash);
            this.f23280h = (TextView) com.huawei.ui.commonui.d.d.a(this, C6753R.id.huawei_copyright);
            this.f23280h.setText(String.format(getString(C6753R.string.IDS_huawei_wear_copyright), new Object[]{"2015", "2017"}));
            C2538c.b("SplashActivity", new Object[]{"onCreate(),isSupportAD=" + this.f23274b.m30089d()});
            if (this.f23274b.m30089d() && i.a(59) && com.huawei.ui.commonui.d.c.c(this.f23283k)) {
                m30186e();
                this.f23289q.removeMessages(1001);
                this.f23289q.sendEmptyMessageDelayed(1001, 10000);
            } else {
                m30201b();
            }
            m30194k();
            m30188f();
            m30198o();
            return;
        }
        this.f23273a = ProtocolAndClauseActivity.class;
        this.f23287o.a(this.f23275c);
        C2538c.b("SplashActivity", new Object[]{"startProtocolAndClauseActivity."});
        m30175a(this.f23273a);
    }

    private void m30186e() {
        HiAd.init(this, BuildConfig.ADVERTISEMENT_ID);
        if (HiAdSplash.isAvailable(this, BuildConfig.ADVERTISEMENT_ID, 1, 4, false)) {
            C2538c.c("SplashActivity", new Object[]{"is  avaiable"});
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(C6753R.id.splash);
            ViewGroup viewGroup = (ViewGroup) findViewById(C6753R.id.slogan);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(C6753R.id.logo);
            SplashListener ajVar = new aj(this);
            Builder builder = new Builder();
            builder.withAdId(BuildConfig.ADVERTISEMENT_ID).withAdVGroup(relativeLayout).withDeviceType(4).withDefSloganResId(this.f23285m).withIsTest(false).withLogoVGroup(viewGroup2).withOrientation(1).withSloganVGroup(viewGroup);
            HiAdSplash hiAdSplash = new HiAdSplash(this, builder.build(), ajVar);
            return;
        }
        C2538c.c("SplashActivity", new Object[]{"is not avaiable"});
        m30201b();
    }

    public void m30201b() {
        this.f23274b.m30072a();
        this.f23289q.removeMessages(1001);
    }

    private void m30188f() {
        if (VERSION.SDK_INT > 23) {
            getWindow().setNavigationBarColor(0);
            getWindow().setStatusBarColor(0);
        } else {
            getWindow().setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS, HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        }
        getWindow().getDecorView().setSystemUiVisibility(1024);
    }

    private void m30189g() {
        C2538c.c("SplashActivity", new Object[]{"Enter cooperateWithHealth"});
        this.f23274b.m30085c(this.f23277e);
        this.f23274b.m30079a(this.f23288p);
        if (this.f23274b.m30099m()) {
            if (com.huawei.login.a.a.b(BaseApplication.b())) {
                C2538c.c("SplashActivity", new Object[]{"login isHwIDStopped res is ", Boolean.valueOf(com.huawei.login.a.a.f())});
                if (!com.huawei.login.a.a.f()) {
                    m30202d();
                    return;
                }
            }
            if (!this.f23274b.m30084b()) {
                this.f23274b.m30096j();
                return;
            } else if ("0".equals(this.f23274b.m30090e())) {
                C2538c.c("SplashActivity", new Object[]{"Enter cooperateWithHealth current huid is 0"});
                this.f23274b.m30102p();
                return;
            } else {
                this.f23274b.m30095i();
                return;
            }
        }
        this.f23274b.m30102p();
    }

    private boolean m30191h() {
        this.f23274b.m30085c(this.f23277e);
        if ("3".equals(this.f23274b.m30100n())) {
            return true;
        }
        return false;
    }

    private void m30192i() {
        Intent intent = new Intent(this.f23277e, ServiceAreaActivity.class);
        intent.putExtra("splash_start_mode", true);
        startActivityForResult(intent, 1001);
    }

    private void m30193j() {
        if (this.f23276d == null || !this.f23276d.isShowing()) {
            CharSequence string = this.f23277e.getString(C6753R.string.IDS_main_root_reminder_msg);
            View inflate = LayoutInflater.from(this).inflate(C6753R.layout.activity_splash_root_dialog_msg_layout, null);
            ((TextView) inflate.findViewById(C6753R.id.root_dialog_tv)).setText(string);
            CheckBox checkBox = (CheckBox) inflate.findViewById(C6753R.id.agree_checkbox);
            this.f23286n = this.f23287o.n();
            checkBox.setChecked(this.f23286n);
            checkBox.setOnCheckedChangeListener(new ak(this));
            com.huawei.ui.commonui.dialog.c a = new com.huawei.ui.commonui.dialog.c(this.f23277e).a(C6753R.string.IDS_service_area_notice_title).a(C6753R.string.IDS_common_notification_know_tips, new al(this));
            this.f23276d = a.a();
            a.a(inflate);
            this.f23276d.setCancelable(false);
            if (!this.f23276d.isShowing()) {
                this.f23276d.show();
                return;
            }
            return;
        }
        C2538c.b("SplashActivity", new Object[]{"showBandUnavailableDialog Already show!"});
    }

    protected void onDestroy() {
        C2538c.b("SplashActivity", new Object[]{"onDestroy()"});
        super.onDestroy();
        this.f23289q.removeCallbacksAndMessages(null);
        this.f23274b.m30098l();
        this.f23278f = false;
        if (this.f23276d != null) {
            this.f23276d.dismiss();
        }
    }

    private void m30175a(Class<?> cls) {
        Intent intent = new Intent(BaseApplication.b(), cls);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            C2538c.b("SplashActivity", new Object[]{"extras is not null."});
            intent.putExtra("openPackageName", extras.getString("openPackageName", ""));
            intent.putExtra("openClassName", extras.getString("openClassName", ""));
        }
        if (this.f23278f) {
            intent.putExtra("KEY_ANROIDWEAR_OPEN_ESIM_FLAG", true);
        }
        if (this.f23279g) {
            intent.putExtra("KEY_ANROIDWEAR_OPEN_WALLET_FLAG", true);
        }
        startActivity(intent);
        C2538c.b("SplashActivity", new Object[]{"Leave startActivity"});
        finish();
    }

    protected void onResume() {
        super.onResume();
        C2538c.b("SplashActivity", new Object[]{"onResume"});
        this.f23274b.m30097k();
    }

    protected void onRestart() {
        super.onRestart();
        C2538c.b("SplashActivity", new Object[]{"onCreate(),isSupportAD=" + this.f23274b.m30089d()});
        if (this.f23274b.m30089d() && i.a(59) && com.huawei.ui.commonui.d.c.c(this.f23283k)) {
            m30201b();
        }
    }

    private void m30194k() {
        C2538c.c("SplashActivity", new Object[]{"Enter migrateSiteId"});
        String d = h.d(BaseApplication.b());
        int b = com.huawei.login.ui.login.util.c.a(BaseApplication.b()).b();
        C2538c.c("SplashActivity", new Object[]{"migrateSiteId area is ", d, ";siteid is " + b});
        if (PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(d) && -1 == b) {
            com.huawei.login.ui.login.util.c.a(BaseApplication.b()).a(1);
            b = 1;
        }
        if ("0".equals(com.huawei.login.ui.login.a.a(BaseApplication.b()).c())) {
            if (1 == b) {
                com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(1004), "KEY_IF_ACCOUNT_AREA", "1", null);
                C2538c.c("SplashActivity", new Object[]{"retrive huid"});
                new Thread(new am(this, new com.huawei.up.a.a(BaseApplication.b()), com.huawei.login.ui.login.a.a(BaseApplication.b()).g())).start();
            }
            C2538c.c("SplashActivity", new Object[]{"Leave migrateSiteId"});
            return;
        }
        C2538c.c("SplashActivity", new Object[]{"old huid is not 0"});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.c("SplashActivity", new Object[]{"onActivityResult requestCode:" + i});
        Context context = this.f23283k;
        if (context != null && !context.isFinishing()) {
            if (this.f23282j == 1 && i == 2002) {
                if (m30177a(context) || m30183c() || !this.f23274b.m30099m()) {
                    m30189g();
                } else {
                    m30173a((Activity) context);
                }
            } else if (this.f23282j == 2 && i == 2003) {
                if (m30177a(context) || m30183c() || !this.f23274b.m30099m()) {
                    m30189g();
                    return;
                }
                C2538c.c("SplashActivity", new Object[]{"onActivityResult mTryCount:" + this.f23281i});
                if (this.f23281i >= 5) {
                    m30192i();
                } else {
                    m30197n();
                }
            } else if (1001 == i) {
                m30197n();
            }
        }
    }

    private void m30195l() {
        C2538c.c("SplashActivity", new Object[]{"Enter gotoGooglePlayForUadate"});
        this.f23282j = 1;
        Activity activity = this.f23283k;
        if (activity != null && !activity.isFinishing()) {
            String str = "com.huawei.hwid";
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.huawei.hwid"));
                intent.setPackage("com.android.vending");
                activity.startActivityForResult(intent, m30199a());
            } catch (ActivityNotFoundException e) {
                C2538c.e("SplashActivity", new Object[]{"can not open google play"});
            }
        }
    }

    private void m30173a(Activity activity) {
        C2538c.c("SplashActivity", new Object[]{"Enter gotoGooglePlayWeb"});
        this.f23282j = 2;
        String str = "com.huawei.hwid";
        try {
            activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.huawei.hwid")), m30199a());
        } catch (ActivityNotFoundException e) {
            C2538c.e("SplashActivity", new Object[]{"can not find web to hold update hms apk"});
        }
    }

    private boolean m30177a(Context context) {
        boolean z;
        if (new com.huawei.k.a.d(context).a("com.huawei.hwid") >= 20501300) {
            z = true;
        } else {
            z = false;
        }
        C2538c.e("SplashActivity", new Object[]{"isHMSUpdated:" + z});
        return z;
    }

    private boolean m30180b(Context context) {
        boolean z;
        if (new com.huawei.k.a.d(context).a("com.huawei.hwid") > 0) {
            z = true;
        } else {
            z = false;
        }
        C2538c.e("SplashActivity", new Object[]{"versionCode:" + r3});
        return z;
    }

    public static Object m30172a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Object invoke;
        Class cls = null;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C2538c.b("SplashActivity", new Object[]{"invokeFun params invalid"});
        } else {
            Object a = m30171a(str);
            if (a != null) {
                Class cls2;
                Method method;
                try {
                    cls2 = Class.forName(str);
                } catch (ClassNotFoundException e) {
                    C2538c.e("SplashActivity", new Object[]{"can not find class:" + str});
                    cls2 = cls;
                }
                if (cls2 != null) {
                    try {
                        method = cls2.getMethod(str2, clsArr);
                    } catch (NoSuchMethodException e2) {
                        C2538c.e("SplashActivity", new Object[]{"can not find method:" + str2});
                    }
                    if (method != null) {
                        try {
                            invoke = method.invoke(a, objArr);
                        } catch (IllegalAccessException e3) {
                            C2538c.e("SplashActivity", new Object[]{"method can not invoke:" + e3.getMessage()});
                        } catch (IllegalArgumentException e4) {
                            C2538c.e("SplashActivity", new Object[]{"method can not invoke:" + e4.getMessage()});
                        } catch (InvocationTargetException e5) {
                            C2538c.e("SplashActivity", new Object[]{"method can not invoke:" + e5.getMessage()});
                        }
                    }
                }
                Object obj = cls;
                if (method != null) {
                    invoke = method.invoke(a, objArr);
                }
            }
        }
        return invoke;
    }

    public static Object m30171a(String str) {
        Class cls;
        Object newInstance;
        Class cls2 = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            C2538c.e("SplashActivity", new Object[]{"can not find class:" + str});
            cls = cls2;
        }
        if (cls != null) {
            try {
                newInstance = cls.newInstance();
            } catch (InstantiationException e2) {
                C2538c.e("SplashActivity", new Object[]{"class creat instance error :" + e2.getMessage()});
            } catch (IllegalAccessException e3) {
                C2538c.e("SplashActivity", new Object[]{"class creat instance error :" + e3.getMessage()});
            }
        }
        return newInstance;
    }

    public void m30200a(Context context, String str, String str2, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("SplashActivity", new Object[]{"Enter showHmsDialog "});
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.b(context);
        aVar.b(str);
        aVar.c(str2);
        aVar.a(context.getString(C6753R.string.IDS_settings_button_ok), new ao(this, iBaseResponseCallback, aVar));
        aVar.b(context.getString(C6753R.string.IDS_settings_button_cancal), new ap(this, iBaseResponseCallback, aVar));
        if (!aVar.isShowing()) {
            aVar.b();
            aVar.setCancelable(false);
        }
    }

    private void m30196m() {
        C2538c.c("SplashActivity", new Object[]{"Enter downloadHMS !"});
        if (m30183c() || m30177a(this.f23277e.getApplicationContext()) || !this.f23274b.m30099m()) {
            m30189g();
            return;
        }
        this.f23281i = this.f23274b.m30101o();
        C2538c.c("SplashActivity", new Object[]{"downloadHMS  getTryCount = " + this.f23281i});
        if (this.f23281i >= 5) {
            m30192i();
        } else {
            m30197n();
        }
    }

    private void m30197n() {
        if (m30183c() || m30177a(this.f23277e.getApplicationContext()) || !this.f23274b.m30099m()) {
            m30189g();
            return;
        }
        String string;
        String string2;
        if (m30180b(this.f23277e)) {
            string = getResources().getString(C6753R.string.IDS_hwh_home_health_login_update_hwid);
            string2 = getResources().getString(C6753R.string.IDS_hwh_home_health_login_update_old_hwid_notes);
        } else {
            string = getResources().getString(C6753R.string.IDS_service_area_notice_title);
            string2 = getResources().getString(C6753R.string.IDS_hwh_home_health_login_update_notes);
        }
        m30200a(this.f23277e, string, string2, new aq(this));
    }

    public static boolean m30183c() {
        Object b = m30179b("ro.product.locale.region");
        if (!TextUtils.isEmpty(b)) {
            return HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(b);
        }
        b = m30179b("ro.product.locale");
        if (!TextUtils.isEmpty(b)) {
            return b.toLowerCase(Locale.US).contains(HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE);
        }
        b = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        return HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(b);
    }

    private static String m30179b(String str) {
        String str2 = "";
        try {
            Object a = m30172a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{str});
            if (a != null) {
                return (String) a;
            }
        } catch (Exception e) {
            C2538c.c("SplashActivity", new Object[]{"getSystemProperties can not get property: " + e.getMessage()});
        }
        return str2;
    }

    private void m30198o() {
        C2538c.c("SplashActivity", new Object[]{"requestPermissions() hasPermission =" + b.a(getApplicationContext(), f23272r)});
        if (b.a(getApplicationContext(), f23272r)) {
            C2538c.c("SplashActivity", new Object[]{"requestPermissions() PERMISSIONS_NEEDED if (!hasPermissionNeeded) ELSE"});
            if (this.f23287o.n() || !com.huawei.ui.commonui.d.b.a()) {
                m30196m();
                return;
            } else {
                m30193j();
                return;
            }
        }
        b.a(this, f23272r, new ar(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.c("SplashActivity", new Object[]{"onRequestPermissionsResult(), PermissionsManager.notifyPermissionsChange()"});
        if (this.f23287o.n() || !com.huawei.ui.commonui.d.b.a()) {
            m30196m();
        } else {
            m30193j();
        }
        com.huawei.hwcommonmodel.d.a.b.a().a(strArr, iArr);
    }

    public void m30202d() {
        C2538c.c("SplashActivity", new Object[]{"enter showHwIdStoppedDialog():"});
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(this.f23277e, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.b(this.f23277e);
        aVar.b(this.f23277e.getString(C6753R.string.IDS_hw_wechat_rank_show_common_title));
        aVar.c(this.f23277e.getString(C6753R.string.IDS_hwh_home_other_login_hwid_is_stoped));
        aVar.a(this.f23277e.getString(C6753R.string.IDS_main_btn_state_settings).toUpperCase(), new ah(this, aVar));
        aVar.b(this.f23277e.getString(C6753R.string.IDS_hw_health_show_common_dialog_cancle_button).toUpperCase(), new ai(this, aVar));
        if (aVar.isShowing()) {
            C2538c.c("SplashActivity", new Object[]{"show hwIdStoppedDialog is showing..."});
            return;
        }
        C2538c.c("SplashActivity", new Object[]{"show hwIdStoppedDialog"});
        aVar.b();
        aVar.setCancelable(false);
    }

    private boolean m30176a(BluetoothDevice bluetoothDevice) {
        Object name = bluetoothDevice.getName();
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        String toUpperCase = name.toUpperCase(Locale.US);
        if (toUpperCase.startsWith("HONOR ZERO") || toUpperCase.startsWith("HUAWEI B0") || toUpperCase.startsWith("HUAWEI BAND-") || toUpperCase.startsWith("HONOR BAND Z1")) {
            return true;
        }
        return false;
    }
}
