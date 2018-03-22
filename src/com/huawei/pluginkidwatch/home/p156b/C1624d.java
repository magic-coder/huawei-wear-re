package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwversionmgr.c.b.a;
import com.huawei.hwversionmgr.p079a.C1070g;
import com.huawei.hwversionmgr.utils.C1078c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateOModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceModel;
import com.huawei.pluginkidwatch.common.entity.model.UpdateInfo;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1390f;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1410z;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.ay;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1897n;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;

/* compiled from: CheckNewVersionUtils */
public abstract class C1624d {
    private static boolean f4200k = false;
    private static int f4201l = 0;
    private static int f4202s = 3600000;
    private static int f4203t = 30000;
    public C1507h f4204a = null;
    private String f4205b = "";
    private int f4206c = 0;
    private String f4207d = "";
    private String f4208e = "";
    private String f4209f = "";
    private a f4210g;
    private String f4211h = "";
    private C1637q f4212i = new C1637q();
    private boolean f4213j = false;
    private CustomDialog f4214m = null;
    private Context f4215n;
    private C1413d f4216o;
    private CustomDialog f4217p = null;
    private C1897n f4218q;
    private Handler f4219r = new Handler();
    private C1636p f4220u;
    private String f4221v;
    private OnClickListener f4222w = new C1631k(this);
    private OnClickListener f4223x = new C1632l(this);

    public abstract void mo2556a(boolean z);

    public abstract void mo2557a(boolean z, int i, String str, String str2);

    public abstract boolean mo2558a();

    static /* synthetic */ int m7713l() {
        int i = f4201l;
        f4201l = i + 1;
        return i;
    }

    public C1624d(Context context, C1413d c1413d) {
        this.f4215n = context;
        this.f4216o = c1413d;
    }

    public void m7733a(Context context, boolean z) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== getImeiAndCheckNewVersion=== ");
        if (!C1492l.m6916b(this.f4215n)) {
            C1483c.m6824a(this.f4215n, C1680l.IDS_plugin_kidwatch_common_network_disable);
        } else if (z || C1392h.m6309e(this.f4215n, C1462f.m6744i(), C1462f.m6746j()) == null) {
            if (!z) {
                this.f4213j = false;
                this.f4219r.postDelayed(this.f4212i, StatisticConfig.MIN_UPLOAD_INTERVAL);
                this.f4218q = new C1897n(context, this.f4217p);
                this.f4218q.m9667a(C1680l.IDS_plugin_kidwatch_menu_update_check_new_version);
            }
            WatchStatusIOModel watchStatusIOModel = new WatchStatusIOModel();
            watchStatusIOModel.deviceCode = C1462f.m6746j();
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== mWatchStatusIOModel " + watchStatusIOModel.toString());
            this.f4216o.mo2505a(watchStatusIOModel, new C1625e(this, context, z));
        } else {
            C1483c.m6824a(this.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_check_new_version_updating);
        }
    }

    private void m7696c(Context context, boolean z) {
        if (C1483c.m6831b(C1462f.m6746j())) {
            GetDeviceModel getDeviceModel = new GetDeviceModel();
            getDeviceModel.deviceCode = C1462f.m6746j();
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============model.deviceCode" + C1462f.m6746j());
            this.f4216o.mo2482a(getDeviceModel, new C1628h(this, context, z));
            return;
        }
        C2538c.m12677c("KIDWATCH_CheckNewVersionUtils", "=========== getDeviceImeiFromCloud deviceCode:" + C1462f.m6746j() + "   invald deviceCode return!!!");
    }

    public void m7738b(Context context, boolean z) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter doCheckBandNewVersion");
        this.f4210g = new a();
        C1078c.m4563a("https://query.hicloud.com/Ring/v2/CheckEx.action?ruleAttr=true");
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============doCheckBandNewVersion setCheckUrl :https://query.hicloud.com/Ring/v2/CheckEx.action?ruleAttr=true");
        PackageInfo packageInfo = new PackageInfo();
        String str = this.f4221v;
        C2538c.m12677c("KIDWATCH_CheckNewVersionUtils", "===www=======check new version" + C1467b.m6787c(this.f4215n));
        if (7 == C1467b.m6787c(this.f4215n)) {
            packageInfo.packageName = "com.huawei.ktwo.firmware";
        } else {
            packageInfo.packageName = "com.huawei.kone.firmware";
        }
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== KWCache.DEVICE_VERSION == " + C1462f.m6750l());
        if ("".equals(C1462f.m6750l()) || C1462f.m6750l() == null) {
            packageInfo.versionName = String.valueOf(0);
        } else {
            packageInfo.versionName = C1462f.m6750l();
        }
        packageInfo.versionCode = 0;
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== update date ----versionCode = " + packageInfo.versionCode + " ,packageName =" + packageInfo.packageName + " , versionName = " + packageInfo.versionName + " , imei = " + str);
        this.f4210g.a(packageInfo, str, this.f4215n, new C1629i(this, z, context), Boolean.valueOf(false));
    }

    private boolean m7718n() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=============Enter HomeActivity updateCheckVersionTable()");
        C1390f c1390f = new C1390f();
        c1390f.f3059b = C1492l.m6920d(C1462f.m6746j());
        c1390f.f3058a = C1462f.m6744i();
        c1390f.f3060c = Long.toString(System.currentTimeMillis());
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "updateCheckVersionTable:" + c1390f.toString());
        return C1392h.m6282a(this.f4215n, c1390f);
    }

    private boolean m7720o() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=============Enter HomeActivity updateCheckVersionTable()");
        C1390f c1390f = new C1390f();
        c1390f.f3059b = C1492l.m6920d(C1462f.m6746j());
        c1390f.f3058a = C1462f.m6744i();
        c1390f.f3061d = Long.toString(System.currentTimeMillis());
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "updateCheckVersionTable:" + c1390f.toString());
        return C1392h.m6282a(this.f4215n, c1390f);
    }

    private void m7681a(Context context) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=============Enter fetchChangeLog");
        this.f4210g.a(this.f4215n.getApplicationContext(), new C1630j(this, context), Boolean.valueOf(false));
    }

    private void m7682a(Context context, List<C1070g> list) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== get fetchChangeLog = success==showDialog");
        C2538c.m12677c("KIDWATCH_CheckNewVersionUtils", "===www=======check new version" + C1467b.m6787c(this.f4215n));
        if (7 == C1467b.m6787c(this.f4215n)) {
            this.f4204a = new C1507h(context, SdkConstants.REQUEST_CAMERA_VIDEO, 345, h.dialog_updata_list_k2, m.servicedialog, false);
        } else {
            this.f4204a = new C1507h(context, SdkConstants.REQUEST_CAMERA_VIDEO, 345, h.dialog_updata_list, m.servicedialog, false);
        }
        if (!mo2558a()) {
            if (C1392h.m6309e(context, C1462f.m6744i(), C1462f.m6746j()) != null) {
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==www=========is dialog updating" + C1392h.m6309e(context, C1462f.m6744i(), C1462f.m6746j()));
                return;
            }
            this.f4204a.setCancelable(false);
            this.f4204a.show();
            ListView listView = (ListView) this.f4204a.findViewById(g.menu_setting_updata_listview);
            if (list != null && list.size() > 0) {
                listView.setAdapter(new ay(this.f4215n, list));
            }
            TextView textView = (TextView) this.f4204a.findViewById(g.menu_setting_updata_unbusy);
            ((TextView) this.f4204a.findViewById(g.menu_setting_updata_cancle)).setOnClickListener(this.f4222w);
            textView.setOnClickListener(this.f4223x);
        }
    }

    private void m7721p() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "============Enter startUpdateKone()=======");
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.updateType = 1;
        updateInfo.versionMd5 = this.f4205b;
        updateInfo.versionNum = this.f4208e;
        updateInfo.versionSize = this.f4206c;
        updateInfo.versionURL = this.f4207d;
        updateInfo.versionID = this.f4209f;
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "=======changeLog updateInfo=" + updateInfo.toString());
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 10;
        commonRetOModel.data = updateInfo.toString();
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww==== update model" + commonRetOModel);
        m7683a(commonRetOModel);
    }

    private void m7723q() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "============Enter saveUpdateInfo()=======");
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.updateType = 1;
        updateInfo.versionMd5 = this.f4205b;
        updateInfo.versionNum = this.f4208e;
        updateInfo.versionSize = this.f4206c;
        updateInfo.versionURL = this.f4207d;
        updateInfo.versionID = this.f4209f;
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "====forceUpdate=== updateInfo=" + updateInfo.toString());
        C1491k.m6897a(this.f4215n, C1462f.m6746j() + "updateInfo", updateInfo.toString());
    }

    private void m7726r() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter startForceUpdate()");
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww====force update updateInfo" + C1491k.m6899b(this.f4215n, C1462f.m6746j() + "updateInfo", ""));
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 10;
        commonRetOModel.data = r0;
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww====force update model" + commonRetOModel);
        m7683a(commonRetOModel);
    }

    private void m7727s() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter startForceUpdate()");
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww====force update updateInfo" + C1491k.m6899b(this.f4215n, C1462f.m6746j() + "updateInfo", ""));
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 10;
        commonRetOModel.data = r0;
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww====data updateInfo" + r0);
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww====data model.deviceCode" + commonRetOModel.deviceCode);
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww====data model.type" + commonRetOModel.type);
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww====data model" + commonRetOModel);
    }

    private void m7683a(CommonRetOModel commonRetOModel) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter sendUpdateCommand");
        this.f4216o.mo2473a(commonRetOModel, new C1633m(this));
    }

    private void m7680a(int i, boolean z, String str, String str2) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter saveUpdateStatus");
        C1410z c1410z = new C1410z();
        c1410z.f3209a = C1462f.m6744i();
        c1410z.f3215g = C1492l.m6920d(C1462f.m6746j());
        c1410z.f3213e = C1462f.m6750l();
        c1410z.f3214f = str;
        c1410z.f3211c = i;
        c1410z.f3210b = z;
        c1410z.f3212d = false;
        c1410z.f3216h = str2;
        c1410z.f3217i = String.valueOf(System.currentTimeMillis());
        C1392h.m6285a(this.f4215n, c1410z);
    }

    private void m7729t() {
        if (this.f4220u != null) {
            this.f4219r.removeCallbacks(this.f4220u);
        }
    }

    public void m7739b(boolean z) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter getUpdateState");
        CommonStateOModel commonStateOModel = new CommonStateOModel();
        commonStateOModel.type = "1";
        commonStateOModel.deviceCode = C1462f.m6746j();
        this.f4216o.mo2474a(commonStateOModel, new C1634n(this, z));
    }

    public void m7732a(int i, boolean z) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter freshUiState type:" + i, "  isShowToast:" + z);
        if (5 == i) {
            m7700d(z);
        }
        m7693b(i);
        switch (i) {
            case 0:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============无效状态，正在通知手表升级 ̬");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state1, null, m7745h());
                break;
            case 1:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============开始下载升级包");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state2, null, m7745h());
                break;
            case 2:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============下载升级包失败");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state9, null, m7745h());
                m7729t();
                if (!z) {
                    C1483c.m6824a(this.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_state9);
                    break;
                }
                break;
            case 3:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==============================下载升级包完成，正在校验升级包");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state3, null, m7745h());
                break;
            case 4:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============升级包校验通过，开始升级，请勿关机");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state4, null, m7745h());
                break;
            case 6:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============升级失败");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state9, null, m7745h());
                m7729t();
                if (!z) {
                    C1483c.m6824a(this.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_state9);
                    break;
                }
                break;
            case 7:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============升级包错误，请联系华为客服");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state9, null, m7745h());
                m7729t();
                if (!z) {
                    C1483c.m6824a(this.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_state9);
                    break;
                }
                break;
            case 8:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============当前电量低不允许升级，请连接充电器");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state6, null, m7745h());
                break;
            case 9:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============手表未摘下，不允许升级，请摘下手表");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state7, null, m7745h());
                break;
            case 10:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "================当前手表在通话，不允许升级");
                mo2556a(true);
                mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_update_state8, null, m7745h());
                break;
            default:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============FOTA default");
                break;
        }
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============freshUiState-->setVersion");
    }

    private void m7700d(boolean z) {
        WatchStatusIOModel watchStatusIOModel = new WatchStatusIOModel();
        watchStatusIOModel.deviceCode = C1462f.m6746j();
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== updateSuccessGetWatchStatus " + watchStatusIOModel.toString());
        this.f4216o.mo2505a(watchStatusIOModel, new C1635o(this, z));
    }

    private void m7693b(int i) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter changeUpdateStatusInDb type:" + i);
        if (2 == i || 5 == i || 6 == i || 7 == i) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============delete update infoDeviceCode:" + C1462f.m6746j());
            C1392h.m6312f(this.f4215n, C1462f.m6744i(), C1462f.m6746j());
            return;
        }
        C1410z e = C1392h.m6309e(this.f4215n, C1462f.m6744i(), C1462f.m6746j());
        if (e == null || e.f3215g <= 0) {
            C2538c.m12680e("KIDWATCH_CheckNewVersionUtils", "===============Error!!!");
        } else if (e.f3214f.equals(C1462f.m6750l())) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter changeUpdateStatusInDb table is not  null");
            C1392h.m6312f(this.f4215n, C1462f.m6744i(), C1462f.m6746j());
        } else {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter changeUpdateStatusInDb table is null");
            e.f3211c = i;
            C1392h.m6285a(this.f4215n, e);
        }
    }

    private void m7689a(C1897n c1897n) {
        if (c1897n != null) {
            c1897n.m9666a();
        }
        this.f4219r.removeCallbacks(this.f4212i);
    }

    public void m7737b() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter  removeRunnableInLife");
        this.f4219r.removeCallbacks(this.f4212i);
        this.f4219r.removeCallbacks(this.f4220u);
    }

    public void m7740c() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter  removeRunnableInClose");
        this.f4219r.removeCallbacks(this.f4212i);
    }

    public void m7741d() {
        if (C1392h.m6309e(this.f4215n, C1462f.m6744i(), C1462f.m6746j()) == null) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter  haveNewViewUI getWatchVersion = " + m7745h());
            mo2557a(true, C1680l.IDS_plugin_kidwatch_menu_new_version_found, null, m7745h());
            mo2556a(true);
        }
    }

    public void m7742e() {
        if (C1392h.m6309e(this.f4215n, C1462f.m6744i(), C1462f.m6746j()) == null) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===============Enter  haveNoNewViewUI getWatchVersion = " + m7745h());
            mo2556a(false);
            mo2557a(false, -1, null, m7745h());
        }
    }

    public void m7743f() {
        mo2556a(false);
        mo2557a(false, -1, this.f4215n.getString(C1680l.IDS_plugin_kidwatch_menu_update_state5), m7745h());
        C1497q.m6942a(this.f4215n, C1462f.m6746j(), Boolean.valueOf(false));
    }

    public void m7744g() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "enter showForcedUpdateDialog");
        if (C1492l.m6916b(this.f4215n)) {
            if (C1392h.m6309e(this.f4215n, C1462f.m6744i(), C1462f.m6746j()) != null) {
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==www=========is updating" + C1392h.m6309e(this.f4215n, C1462f.m6744i(), C1462f.m6746j()));
                return;
            } else if (!C1497q.m6944b(this.f4215n, C1462f.m6746j()).booleanValue()) {
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==www===have no new version");
                return;
            } else if (this.f4214m == null) {
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==www===enter force dialog");
                m7730u();
                return;
            } else {
                return;
            }
        }
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==www===isNetworkConnected!");
    }

    private void m7730u() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "enter ForcedUpdateDialog");
        String str = "";
        C2538c.m12677c("KIDWATCH_CheckNewVersionUtils", "===www=======check new version forcedialog" + C1467b.m6787c(this.f4215n));
        if (7 == C1467b.m6787c(this.f4215n)) {
            str = this.f4215n.getString(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k2);
        } else {
            str = this.f4215n.getString(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k1);
        }
        C1595v a = new C1595v(this.f4215n).m7346a(this.f4215n.getString(C1680l.IDS_plugin_kidwatch_main_smart_band_forced_update)).m7347a(false).m7351b(String.format(this.f4215n.getString(C1680l.IDS_plugin_kidwatch_main_forced_update_message), new Object[]{str})).m7349b(C1680l.IDS_plugin_kidwatch_menu_update_unbusy, new C1627g(this)).m7340a(C1680l.IDS_plugin_kidwatch_common_exit_app, new C1626f(this)).m7347a(false);
        if (this.f4214m == null) {
            this.f4214m = a.m7338a();
            this.f4214m.show();
            return;
        }
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "band forced update dialog is already exist!");
    }

    private void m7731v() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===www===Enter dismissForcedUpdateDialog()");
        if (this.f4214m != null) {
            this.f4214m.dismiss();
            this.f4214m = null;
        }
    }

    public String m7745h() {
        String str;
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===www===Enter getWatchVersion=== version = " + C1491k.m6899b(this.f4215n, C1462f.m6746j() + "beforeVersion", ""));
        String str2 = "";
        if ("".equals(C1491k.m6899b(this.f4215n, C1462f.m6746j() + "beforeVersion", ""))) {
            str = null;
        } else {
            str = String.format(this.f4215n.getString(C1680l.IDS_plugin_kidwatch_menu_version_show_content), new Object[]{str});
        }
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "===www===Enter getWatchVersion=== showMsg = " + str);
        return str;
    }
}
