package com.huawei.ui.homewear21.p175a;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.ab.C0630m;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.l.a.c;
import com.huawei.login.p087a.C1092a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.ae;
import com.huawei.ui.commonui.dialog.af;
import com.huawei.ui.commonui.webview.WebViewActivity;
import com.huawei.ui.device.activity.device.DeviceManagerListActivity;
import com.huawei.ui.homewear21.f;
import com.huawei.ui.homewear21.g;
import com.huawei.ui.homewear21.h;
import com.huawei.ui.main.stories.about.activity.AboutActivity;
import com.huawei.ui.main.stories.about.p179a.C2287i;
import com.huawei.ui.main.stories.guide.activity.BasicInfoSettingActivity;
import com.huawei.ui.main.stories.messagecenter.activity.MessageCenterActivity;
import com.huawei.ui.main.stories.settings.activity.PersonalDataSettingsActivity;
import com.huawei.ui.main.stories.settings.activity.PersonalPrivacySettingsActivity;
import com.huawei.up.a.a;
import com.huawei.up.model.UserInfomation;
import java.util.HashMap;

/* compiled from: LeftMenuFragment */
public abstract class cf extends Fragment implements OnClickListener {
    af f8107a;
    ae f8108b;
    private Context f8109c;
    private ImageView f8110d;
    private ImageView f8111e;
    private TextView f8112f;
    private LinearLayout f8113g;
    private LinearLayout f8114h;
    private LinearLayout f8115i;
    private LinearLayout f8116j;
    private LinearLayout f8117k;
    private LinearLayout f8118l;
    private LinearLayout f8119m;
    private LinearLayout f8120n;
    private cm f8121o;
    private Context f8122p;
    private final BroadcastReceiver f8123q = new cg(this);

    public abstract void m11589a();

    public void m11590a(Context context) {
        this.f8122p = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C2538c.m12677c("LeftMenuFragment", "==========Enter onCreateView()");
        View inflate = layoutInflater.inflate(g.fragment_left_menu, viewGroup, false);
        m11573a(inflate);
        if (this.f8121o == null) {
            C2538c.m12677c("LeftMenuFragment", "weakHandler is null");
            this.f8121o = new cm(this.f8109c.getMainLooper(), this);
        }
        int b = C1093a.m4739a(this.f8109c).m4749b();
        boolean z = (b == 0 || b == -1) ? false : true;
        C2538c.m12677c("LeftMenuFragment", "login third type! login type is:" + b, ", isThirdLogin = ", Boolean.valueOf(z));
        if (C0630m.m2297a(this.f8109c).m2320e() && !z && C1092a.m4717b(BaseApplication.m2632b()) && C1092a.m4717b(BaseApplication.m2632b()) && C1092a.m4721c(BaseApplication.m2632b())) {
            C2538c.m12677c("LeftMenuFragment", "download");
            m11582d();
        }
        return inflate;
    }

    private void m11582d() {
        new Thread(new ch(this)).start();
    }

    private void m11573a(View view) {
        C2538c.m12677c("LeftMenuFragment", "==========Enter initView()");
        this.f8109c = getActivity();
        this.f8113g = (LinearLayout) view.findViewById(f.left_menu_llyt_home);
        this.f8114h = (LinearLayout) view.findViewById(f.left_menu_llyt_personalprofile);
        this.f8115i = (LinearLayout) view.findViewById(f.left_menu_llyt_vmall);
        this.f8116j = (LinearLayout) view.findViewById(f.left_menu_llyt_messagecenter);
        this.f8117k = (LinearLayout) view.findViewById(f.left_menu_llyt_devicemanager);
        this.f8118l = (LinearLayout) view.findViewById(f.left_menu_llyt_huawei_club);
        this.f8119m = (LinearLayout) view.findViewById(f.left_menu_llyt_settings);
        this.f8120n = (LinearLayout) view.findViewById(f.left_menu_llyt_about);
        this.f8111e = (ImageView) view.findViewById(f.left_menu_iv_head);
        this.f8112f = (TextView) view.findViewById(f.left_menu_tv_nickname);
        this.f8110d = (ImageView) view.findViewById(f.left_menu_iv_red_point);
        if (C0969i.m3482a(52)) {
            this.f8115i.setVisibility(0);
        } else {
            this.f8115i.setVisibility(8);
        }
        if (C0969i.m3482a(29)) {
            this.f8118l.setVisibility(0);
        } else {
            this.f8118l.setVisibility(8);
        }
        this.f8113g.setOnClickListener(this);
        this.f8114h.setOnClickListener(this);
        this.f8115i.setOnClickListener(this);
        this.f8116j.setOnClickListener(this);
        this.f8117k.setOnClickListener(this);
        this.f8118l.setOnClickListener(this);
        this.f8119m.setOnClickListener(this);
        this.f8120n.setOnClickListener(this);
        this.f8111e.setOnClickListener(this);
        this.f8112f.setOnClickListener(this);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C2538c.m12677c("LeftMenuFragment", "==========Enter onActivityCreated()");
        m11591b();
        m11585g();
    }

    public void m11591b() {
        if (C1071a.m4507a(this.f8109c).m4521e()) {
            this.f8110d.setVisibility(0);
        } else {
            this.f8110d.setVisibility(4);
        }
    }

    public void onResume() {
        C2538c.m12677c("LeftMenuFragment", "Enter onResume()：");
        super.onResume();
        if (!(this.f8108b == null || this.f8107a == null)) {
            C2538c.m12677c("LeftMenuFragment", "noteDialog is not null, dismiss dialog first....");
            this.f8107a.a(this.f8108b);
            this.f8107a = null;
            this.f8108b = null;
            m11583e();
        }
        m11592c();
    }

    private void m11577a(Class<?> cls) {
        getActivity().startActivity(new Intent(getActivity(), cls));
    }

    private void m11583e() {
        int b = C1093a.m4739a(this.f8109c).m4749b();
        boolean z = (b == 0 || b == -1) ? false : true;
        C2538c.m12677c("LeftMenuFragment", "login third type! login type is:" + b, ", isThirdLogin = ", Boolean.valueOf(z));
        if (!C0969i.m3482a(38) && C1092a.m4717b(BaseApplication.m2632b()) && z) {
            C2538c.m12680e("LeftMenuFragment", "login third type! login type is:" + b);
        } else if (!C0630m.m2297a(BaseApplication.m2632b()).m2320e()) {
            C2538c.m12677c("LeftMenuFragment", "onClick() if (!HWUserProfileMgr.getInstance(mContext).getIfAccountArea())");
            Intent intent = new Intent();
            intent.setClass(this.f8109c, BasicInfoSettingActivity.class);
            intent.putExtra("flag", "personal");
            this.f8109c.startActivity(intent);
        } else if (z) {
            C2538c.m12677c("LeftMenuFragment", "third part not go");
        } else if (C1092a.m4717b(BaseApplication.m2632b()) && C1092a.m4721c(BaseApplication.m2632b())) {
            new C1092a(this.f8109c, null).m4732a(this.f8122p, new cj(this));
        }
    }

    private void m11576a(UserInfomation userInfomation) {
        if (userInfomation != null) {
            C2538c.m12674b("LeftMenuFragment", "userinfo = " + userInfomation.toString());
            Object picPath = userInfomation.getPicPath();
            if (TextUtils.isEmpty(picPath)) {
                this.f8111e.setImageResource(h.ic_personal_head);
                C2538c.m12679d("LeftMenuFragment", "handleWhenGetUserInfoSuccess()! headImgPath is null! ");
            } else {
                Bitmap a = com.huawei.hwcommonmodel.d.f.a(this.f8109c, picPath);
                if (a != null) {
                    this.f8111e.setImageBitmap(a);
                }
            }
            CharSequence name = userInfomation.getName();
            if (name == null || name.equals("")) {
                name = new a(this.f8109c).a();
                if (name != null) {
                    this.f8112f.setText(name);
                    return;
                }
                return;
            }
            this.f8112f.setText(name);
            return;
        }
        C2538c.m12679d("LeftMenuFragment", "handleWhenGetUserInfoSuccess()! userinfo is null! ");
    }

    private void m11584f() {
        C2538c.m12679d("LeftMenuFragment", "Enter initWeakhandler");
        if (this.f8121o == null) {
            this.f8121o = new cm(this.f8122p.getMainLooper(), this);
            return;
        }
        C2538c.m12679d("LeftMenuFragment", "Enter initWeakhandler not null");
    }

    public void m11592c() {
        C2538c.m12677c("LeftMenuFragment", "Enter updateUserName()：");
        m11584f();
        C0630m.m2297a(BaseApplication.m2632b()).m2306a(new ck(this));
    }

    private void m11585g() {
        LocalBroadcastManager.getInstance(this.f8109c).registerReceiver(this.f8123q, new IntentFilter("com.huawei.bone.action.FITNESS_USERINFO_UPDATED"));
    }

    private void m11586h() {
        try {
            LocalBroadcastManager.getInstance(this.f8109c).unregisterReceiver(this.f8123q);
        } catch (RuntimeException e) {
            C2538c.m12679d("LeftMenuFragment", e.getMessage());
        }
    }

    private void m11587i() {
        String a = C2287i.m11757a(this.f8109c).m11758a();
        if (this.f8109c != null) {
            m11578a(a, 1);
        }
    }

    private void m11578a(String str, int i) {
        C2538c.m12674b("LeftMenuFragment", "startWebViewActivity() -> url = ", str, ", jumpModeKey = ", Integer.valueOf(i));
        Intent intent = new Intent(this.f8109c, WebViewActivity.class);
        intent.putExtra("WebViewActivity.REQUEST_URL_KEY", str);
        intent.putExtra("WebViewActivity.JUMP_MODE_KEY", i);
        this.f8109c.startActivity(intent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12680e("LeftMenuFragment", "back from HuaweiAccountApk.requestCode = " + i + ",resultCode = " + i2);
        switch (i) {
            case 1:
                C2538c.m12677c("LeftMenuFragment", "refresh headImage and name.");
                C0630m.m2297a(BaseApplication.m2632b()).m2305a(this.f8122p, new cl(this));
                return;
            case 2:
                if (i2 == 2) {
                    m11589a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (f.left_menu_iv_head == id || f.left_menu_tv_nickname == id) {
            m11589a();
            m11583e();
        } else if (f.left_menu_llyt_home == id) {
            m11589a();
        } else if (f.left_menu_llyt_personalprofile == id) {
            m11589a();
            m11577a(PersonalDataSettingsActivity.class);
            c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cM.a(), new HashMap(), 0);
        } else if (f.left_menu_llyt_vmall == id) {
            m11589a();
            m11578a("https://m.vmall.com", 2);
            c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cO.a(), new HashMap(), 0);
        } else if (f.left_menu_llyt_messagecenter == id) {
            m11589a();
            m11577a(MessageCenterActivity.class);
            c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cN.a(), new HashMap(), 0);
        } else if (f.left_menu_llyt_devicemanager == id) {
            m11589a();
            startActivityForResult(new Intent(getActivity(), DeviceManagerListActivity.class), 2);
            c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cP.a(), new HashMap(), 0);
        } else if (f.left_menu_llyt_huawei_club == id) {
            m11589a();
            m11587i();
            c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cQ.a(), new HashMap(), 0);
        } else if (f.left_menu_llyt_settings == id) {
            m11589a();
            m11577a(PersonalPrivacySettingsActivity.class);
            c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cR.a(), new HashMap(), 0);
        } else if (f.left_menu_llyt_about == id) {
            m11589a();
            m11577a(AboutActivity.class);
            c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.cS.a(), new HashMap(), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        m11586h();
    }

    private void m11588j() {
        C2538c.m12677c("LeftMenuFragment", "enter showNoteHwidRunBackDialog:");
        this.f8107a = null;
        this.f8108b = null;
        this.f8107a = new af(this.f8109c);
        this.f8108b = this.f8107a.a();
        this.f8108b.show();
    }
}
