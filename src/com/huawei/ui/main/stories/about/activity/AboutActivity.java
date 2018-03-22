package com.huawei.ui.main.stories.about.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.bone.C6753R;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.h;
import com.huawei.ui.main.j;
import com.huawei.ui.main.stories.about.activity.cloudservice.HuaweiCloudServiceActivity;
import com.huawei.ui.main.stories.about.activity.developoption.DevelopOptionActivity;
import com.huawei.ui.main.stories.about.activity.legalinformation.LegalInformationActivity;
import com.huawei.ui.main.stories.about.activity.update.AppUpdateDialogActivity;
import com.huawei.ui.main.stories.about.p179a.C2290l;
import com.huawei.ui.main.stories.guide.activity.UserExperienceImprovementActivity;
import com.huawei.ui.main.stories.guide.p181a.C2378a;
import java.util.HashMap;
import java.util.Map;

public class AboutActivity extends BaseActivity implements OnClickListener {
    private static String[] f8299H = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private int f8300A = 11;
    private u f8301B;
    private a f8302C = null;
    private Handler f8303D = new C2307g(this);
    private IDeviceDFXBaseResponseCallback f8304E = new C2309i(this);
    private BroadcastReceiver f8305F = new C2312l(this);
    private final BroadcastReceiver f8306G = new C2324n(this);
    private final BroadcastReceiver f8307I = new C2292b(this);
    private Context f8308a = null;
    private TextView f8309b;
    private TextView f8310c;
    private ImageView f8311d;
    private ImageView f8312e;
    private RelativeLayout f8313f;
    private RelativeLayout f8314g;
    private RelativeLayout f8315h;
    private RelativeLayout f8316i;
    private RelativeLayout f8317j;
    private RelativeLayout f8318k;
    private RelativeLayout f8319l;
    private RelativeLayout f8320m;
    private RelativeLayout f8321n;
    private View f8322o;
    private View f8323p;
    private View f8324q;
    private View f8325r;
    private TextView f8326s;
    private TextView f8327t;
    private ImageView f8328u;
    private int f8329v = 0;
    private C2290l f8330w;
    private int f8331x = 0;
    private boolean f8332y = false;
    private int f8333z = 10;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_about_info);
        this.f8308a = this;
        C2538c.m12674b("AboutActivity", "onCreate()");
        m11778c();
        this.f8330w = new C2290l(this.f8308a);
    }

    private void m11778c() {
        this.f8312e = (ImageView) d.a(this, f.huawei_wear_log);
        this.f8312e.setOnClickListener(this);
        this.f8310c = (TextView) d.a(this, f.about_app_version);
        m11770a(m11787h());
        this.f8313f = (RelativeLayout) d.a(this, f.setting_about_update);
        this.f8326s = (TextView) d.a(this, f.tip);
        this.f8311d = (ImageView) d.a(this, f.app_version_line);
        this.f8313f.setOnClickListener(this);
        if (C0969i.m3481a() == 0) {
            this.f8313f.setVisibility(0);
            this.f8311d.setVisibility(0);
        } else {
            this.f8313f.setVisibility(8);
            this.f8311d.setVisibility(8);
        }
        this.f8314g = (RelativeLayout) d.a(this, f.setting_about_cloud_service);
        this.f8328u = (ImageView) d.a(this, f.about_img_line);
        this.f8314g.setOnClickListener(this);
        this.f8315h = (RelativeLayout) d.a(this, f.setting_about_law_info);
        this.f8315h.setOnClickListener(this);
        this.f8318k = (RelativeLayout) d.a(this, f.setting_about_userexperience);
        this.f8318k.setOnClickListener(this);
        this.f8316i = (RelativeLayout) d.a(this, f.setting_about_hotline);
        this.f8316i.setOnClickListener(this);
        if (C0969i.m3482a(36)) {
            this.f8316i.setVisibility(0);
        } else {
            this.f8316i.setVisibility(8);
        }
        this.f8317j = (RelativeLayout) d.a(this, f.setting_about_feedbacklog);
        this.f8322o = findViewById(f.setting_about_feedbacklog_line);
        this.f8317j.setOnClickListener(this);
        this.f8317j.setVisibility(8);
        this.f8322o.setVisibility(8);
        this.f8319l = (RelativeLayout) d.a(this, f.setting_about_developer_option);
        this.f8323p = d.a(this, f.setting_about_developer_option_line);
        this.f8319l.setOnClickListener(this);
        C2538c.m12674b("AboutActivity", "initListView() leave");
        this.f8309b = (TextView) d.a(this, f.about_tv_privacy);
        this.f8309b.setOnClickListener(this);
        if (c.e(this.f8308a)) {
            ((ImageView) d.a(this, f.setting_about_update_rightImage)).setBackgroundResource(h.ic_arrow_previous);
            ((ImageView) d.a(this, f.setting_about_law_rightImage)).setBackgroundResource(h.ic_arrow_previous);
            ((ImageView) d.a(this, f.hotline_rightImage)).setBackgroundResource(h.ic_arrow_previous);
            ((ImageView) d.a(this, f.setting_about_user_rightImage)).setBackgroundResource(h.ic_arrow_previous);
        }
        this.f8320m = (RelativeLayout) d.a(this, f.setting_about_user_profile_and_suggestions);
        this.f8324q = d.a(this, f.setting_about_user_profile_and_suggestions_line);
        this.f8320m.setOnClickListener(this);
        if (C0969i.m3482a(16)) {
            this.f8320m.setVisibility(0);
            this.f8324q.setVisibility(0);
        } else {
            this.f8320m.setVisibility(8);
            this.f8324q.setVisibility(8);
        }
        if (!C0977d.m3569j()) {
            C2538c.m12677c("AboutActivity", "not is ChinaROM");
            this.f8320m.setVisibility(8);
            this.f8324q.setVisibility(8);
        }
        this.f8321n = (RelativeLayout) d.a(this, f.setting_about_beta_question);
        this.f8325r = findViewById(f.setting_about_beta_question_line);
        this.f8327t = (TextView) d.a(this, f.setting_about_beta_text);
        this.f8321n.setOnClickListener(this);
        m11779d();
    }

    private void m11779d() {
        this.f8321n.setVisibility(8);
        this.f8325r.setVisibility(8);
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12674b("AboutActivity", "===www====onResume()");
        m11785g();
        m11774b(new C2378a(BaseApplication.m2632b()).m12010k());
    }

    public void onClick(View view) {
        C2538c.m12674b("AboutActivity", "onClick()");
        int id = view.getId();
        if (id != f.about_tv_privacy) {
            if (id == f.setting_about_update) {
                C2538c.m12674b("AboutActivity", "onItemClick(): id = LIST_ITEM_APP_UPDATE");
                synchronized (this) {
                    if (this.f8329v == 1) {
                        C2538c.m12674b("AboutActivity", "Is Already Check!");
                        return;
                    }
                    m11793a();
                    com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cW.a(), new HashMap(), 0);
                }
            } else if (id == f.setting_about_cloud_service) {
                m11795a(HuaweiCloudServiceActivity.class);
            } else if (id == f.setting_about_law_info) {
                m11795a(LegalInformationActivity.class);
                com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cX.a(), new HashMap(), 0);
            } else if (id == f.setting_about_hotline) {
                m11784f();
                com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cY.a(), new HashMap(), 0);
            } else if (id == f.setting_about_userexperience) {
                m11795a(UserExperienceImprovementActivity.class);
                com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cZ.a(), new HashMap(), 0);
            } else if (id == f.setting_about_feedbacklog) {
                m11782e();
                com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.da.a(), new HashMap(), 0);
            } else if (id == f.setting_about_developer_option) {
                m11795a(DevelopOptionActivity.class);
            } else if (id == f.huawei_wear_log) {
                this.f8331x++;
                if (this.f8331x >= 5) {
                    new Handler().post(new C2291a(this));
                }
            } else if (id == f.setting_about_user_profile_and_suggestions) {
                m11791k();
                Map hashMap = new HashMap();
                hashMap.put("click", "1");
                com.huawei.l.a.c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.dc.a(), hashMap, 0);
            } else if (id == f.setting_about_beta_question) {
                C2538c.m12674b("AboutActivity", "onItemClick(): id = setting_about_beta_question");
                m11792l();
            } else {
                C2538c.m12674b("AboutActivity", "onItemClick(): id = default");
            }
        }
    }

    protected void m11795a(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public void m11793a() {
        C2538c.m12674b("AboutActivity", " enterUpdateActivity():");
        Intent intent = new Intent();
        intent.putExtra("UpdateMode", 2);
        intent.setClass(this.f8308a, AppUpdateDialogActivity.class);
        this.f8308a.startActivity(intent);
    }

    private void m11782e() {
        if (this.f8301B == null) {
            this.f8301B = new w(this.f8308a).a(j.IDS_about_feedback_log_title).b(j.IDS_about_feedback_log_content).a(j.IDS_user_permission_ok, new C2305e(this)).b(j.IDS_settings_button_cancal, new C2295d(this)).a();
            this.f8301B.setCancelable(false);
        }
        if (!isFinishing()) {
            this.f8301B.show();
        }
    }

    private void m11784f() {
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.f8308a.getString(j.IDS_main_sns_member_service_call_number_item_2))));
    }

    private void m11785g() {
        C2538c.m12677c("AboutActivity", "showAppUpdateNew: haveNewAppVersion = " + C1071a.m4507a(this.f8308a).m4521e());
        if (C1071a.m4507a(this.f8308a).m4521e()) {
            m11771a(true);
        } else {
            m11771a(false);
        }
    }

    private void m11770a(String str) {
        C2538c.m12674b("AboutActivity", "updateAppVersionUI() enter version=" + str);
        if (this.f8310c != null) {
            if (TextUtils.isEmpty(str)) {
                this.f8310c.setVisibility(8);
            } else {
                this.f8310c.setText(String.format(this.f8308a.getString(j.IDS_settings_app_version), new Object[]{str}));
            }
        }
        C2538c.m12674b("AboutActivity", "updateAppVersionUI() leave");
    }

    private void m11771a(boolean z) {
        C2538c.m12674b("AboutActivity", "showAppNewVersion: show = " + z);
        if (z) {
            CharSequence string = this.f8308a.getString(j.IDS_settings_button_new);
            this.f8326s.setVisibility(0);
            this.f8326s.setText(string);
            return;
        }
        this.f8326s.setVisibility(8);
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12674b("AboutActivity", "onDestroy()");
        C0977d.m3575n(this.f8308a);
    }

    private String m11787h() {
        String str = "";
        try {
            return this.f8308a.getPackageManager().getPackageInfo(this.f8308a.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            C2538c.m12674b("AboutActivity", "getAppVersion() error :" + e.toString());
            return str;
        }
    }

    private void m11774b(boolean z) {
        this.f8319l.setVisibility(8);
        this.f8323p.setVisibility(8);
        this.f8312e.setClickable(false);
    }

    private void m11773b(String str) {
        C2538c.m12677c("AboutActivity", "showLoadingDialog()");
        if (!isFinishing()) {
            if (this.f8302C == null) {
                a aVar = new a(this, C6753R.style.black_12sp_65alpha);
                this.f8302C = a.a(this);
                this.f8302C.a(str);
                this.f8302C.setCancelable(false);
            } else {
                this.f8302C.a(str);
            }
            if (this.f8302C != null) {
                this.f8302C.a();
                C2538c.m12677c("AboutActivity", "mLoadingUserInformationDialog.show()");
            }
        }
    }

    private void m11789i() {
        if (!isFinishing()) {
            C2538c.m12677c("AboutActivity", "enter dismissLoadingDialog()");
            if (this.f8302C != null && this.f8302C.isShowing()) {
                C2538c.m12677c("AboutActivity", "dismissLoadingDialog()!");
                this.f8302C.cancel();
                this.f8302C = null;
            }
        }
    }

    protected void m11794a(int i) {
        if (!isFinishing()) {
            w wVar = new w(this.f8308a);
            wVar.a(j.IDS_service_area_notice_title);
            wVar.b(i);
            wVar.a(j.IDS_settings_button_ok, new C2326p(this));
            u a = wVar.a();
            a.setCancelable(true);
            if (!a.isShowing()) {
                a.show();
            }
        }
    }

    private void m11790j() {
        if (com.huawei.hwappdfxmgr.f.c.a(this.f8308a)) {
            DeviceInfo c = C1204c.m5370a(this.f8308a).m5447c();
            if (c != null && 2 != c.getDeviceConnectState()) {
                C2538c.m12674b("AboutActivity", "bt is disconnected");
                m11794a(j.IDS_hw_show_log_bt_disconnect);
                return;
            } else if (HWDeviceDFXManager.getInstance(this.f8308a).isDeviceSuport()) {
                m11773b(getString(j.IDS_hw_show_log_progress));
                this.f8332y = true;
                com.huawei.hwdatamigrate.common.j.a(this.f8308a, HWDeviceDFXConstants.ISGETLOG_FROM_ABOUTACTIVITY, Boolean.valueOf(true));
                C2538c.m12677c("AboutActivity", "ISGETLOG_FROM_ABOUTACTIVITY  == ISGETLOG_FROM_ABOUTACTIVITY");
                HWDeviceDFXManager.getInstance(this.f8308a).getDeviceLog(this.f8304E);
                return;
            } else {
                C2538c.m12674b("AboutActivity", "device is not supported");
                m11773b(getString(j.IDS_hw_show_log_upload_progress));
                this.f8330w.m11765a(false);
                Message obtain = Message.obtain();
                obtain.what = 0;
                this.f8303D.sendMessageDelayed(obtain, 600000);
                return;
            }
        }
        C2538c.m12674b("AboutActivity", "wifi is disconnected");
        m11794a(j.IDS_hw_show_log_wifi_disconnect);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = 1;
        if (1 == i) {
            if (iArr[0] != 0) {
                i2 = 0;
            }
            if (i2 != 0) {
                m11790j();
            }
        } else if (i == this.f8333z) {
            C2538c.m12677c("AboutActivity", "getpermission onRequestPermissionsResult back");
            if (iArr[0] == 0) {
                C2538c.m12677c("AboutActivity", "成功获取权限");
                if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") != 0) {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, this.f8300A);
                }
            }
        } else if (i == this.f8300A && iArr[0] == 0) {
            if (new com.huawei.hwappdfxmgr.c.a().a(this) == 0) {
                C2538c.m12677c("AboutActivity", "Questions and Suggestions enter successful");
                return;
            }
            C2538c.m12677c("AboutActivity", "Questions and Suggestions errorCode : " + new com.huawei.hwappdfxmgr.c.a().a(this));
        }
    }

    private void m11791k() {
        C2538c.m12677c("AboutActivity", "transfer enter");
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            C2538c.m12677c("AboutActivity", "have not permission");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.f8333z);
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, this.f8300A);
        } else {
            C2538c.m12677c("AboutActivity", "have permission");
            if (new com.huawei.hwappdfxmgr.c.a().a(this) == 0) {
                C2538c.m12677c("AboutActivity", "Questions and Suggestions enter successful");
                return;
            }
            C2538c.m12677c("AboutActivity", "Questions and Suggestions errorCode : " + new com.huawei.hwappdfxmgr.c.a().a(this));
        }
    }

    private void m11792l() {
        FeedbackParams feedbackParams = new FeedbackParams();
        DeviceInfo c = C1204c.m5370a(this.f8308a).m5447c();
        if (c != null) {
            String uuid = c.getUUID();
            C2538c.m12674b("AboutActivity", "identify: " + uuid);
            if (uuid != null) {
                uuid = uuid.replace(":", "");
            }
            C2538c.m12674b("AboutActivity", "identify: " + uuid);
            feedbackParams.setDeviceId(uuid);
            feedbackParams.setProductName(c.getDeviceName());
            com.huawei.hwappdfxmgr.a.a.a().a(this, feedbackParams, new C2327q(this));
            return;
        }
        C2538c.m12674b("AboutActivity", "没有连接设备");
    }
}
