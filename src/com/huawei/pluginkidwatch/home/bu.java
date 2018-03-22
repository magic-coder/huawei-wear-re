package com.huawei.pluginkidwatch.home;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.xy.sms.a.a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.home.p156b.C1621a;
import com.huawei.pluginkidwatch.plugin.setting.activity.AppHelpActivity;
import com.huawei.pluginkidwatch.plugin.setting.activity.CheckBillActivity;
import com.huawei.pluginkidwatch.plugin.setting.activity.ProfileSettingActivity;
import java.util.HashMap;

/* compiled from: SettingFragment */
public class bu extends Fragment implements OnClickListener {
    public LinearLayout f4327a;
    private LinearLayout f4328b;
    private ImageView f4329c;
    private ImageView f4330d;
    private TextView f4331e;
    private LinearLayout f4332f;
    private TextView f4333g;
    private LinearLayout f4334h;
    private LinearLayout f4335i;
    private TextView f4336j;
    private Context f4337k;
    private C1565a f4338l = null;
    private HashMap<String, String> f4339m = null;
    private OnTouchListener f4340n = new bv(this);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C2538c.m12674b("KIDWATCH_SettingFragment", "====onCreateView is enter==");
        View inflate = layoutInflater.inflate(h.activity_settings, viewGroup, false);
        m7815a(inflate);
        return inflate;
    }

    private void m7815a(View view) {
        this.f4337k = getActivity();
        if (this.f4338l == null) {
            this.f4338l = new C1565a();
        }
        if (!C1492l.m6916b(this.f4337k)) {
            C2538c.m12680e("KIDWATCH_SettingFragment", "========== Network is unavailable");
            C1483c.m6824a(this.f4337k, C1680l.IDS_plugin_kidwatch_common_network_disable);
        }
        this.f4328b = (LinearLayout) view.findViewById(g.setting_llyt_profile_head);
        this.f4332f = (LinearLayout) view.findViewById(g.setting_llyt_disney_world);
        this.f4334h = (LinearLayout) view.findViewById(g.setting_llyt_huafen);
        this.f4335i = (LinearLayout) view.findViewById(g.setting_llyt_faq);
        this.f4327a = (LinearLayout) view.findViewById(g.setting_llyt_bill);
        this.f4336j = (TextView) view.findViewById(g.setting_tv_bill);
        this.f4331e = (TextView) view.findViewById(g.setting_tv_kid_name);
        this.f4333g = (TextView) view.findViewById(g.setting_tv_user_simcardnum);
        this.f4329c = (ImageView) view.findViewById(g.setting_iv_profile_head);
        this.f4330d = (ImageView) view.findViewById(g.setting_iv_profile_selected_head);
        if (C1462f.m6748k() != null) {
            this.f4331e.setText(C1462f.m6748k().f3083c);
        }
        this.f4328b.setOnClickListener(this);
        this.f4332f.setOnClickListener(this);
        this.f4328b.setOnTouchListener(this.f4340n);
        this.f4334h.setOnClickListener(this);
        this.f4335i.setOnClickListener(this);
        this.f4327a.setOnClickListener(this);
        m7820c();
        m7823a();
        m7822e();
        this.f4332f.setVisibility(8);
        this.f4329c.setImageBitmap(m7821d());
    }

    private void m7820c() {
        C2538c.m12674b("KIDWATCH_SettingFragment", "===www=======Enter initBillLayout");
        C2538c.m12677c("KIDWATCH_SettingFragment", "===www=======current device initBillLayout" + C1467b.m6789d(this.f4337k));
        if (7 == C1467b.m6789d(this.f4337k)) {
            this.f4327a.setVisibility(0);
        } else {
            this.f4327a.setVisibility(8);
        }
    }

    public void m7823a() {
        C2538c.m12674b("KIDWATCH_SettingFragment", "==========Enter processLayoutClickable()");
        if ("".equals(C1462f.m6746j())) {
            this.f4328b.setEnabled(false);
            this.f4327a.setEnabled(false);
            this.f4336j.setEnabled(false);
            return;
        }
        this.f4328b.setEnabled(true);
        this.f4327a.setEnabled(true);
        this.f4336j.setEnabled(true);
    }

    public void onDestroy() {
        super.onDestroy();
        a.a(this.f4337k);
    }

    public void onClick(View view) {
        int id = view.getId();
        String str;
        if (g.setting_llyt_huafen == id) {
            str = "";
            C2538c.m12677c("KIDWATCH_SettingFragment", "===www=======huafenUrl currentDeviceType" + C1467b.m6787c(this.f4337k));
            if (7 == C1467b.m6787c(this.f4337k)) {
                str = "http://club.huawei.com/forum-2405-1.html";
            } else {
                str = "http://club.huawei.com/cn/forum-1421-1.html";
            }
            C2538c.m12674b("KIDWATCH_SettingFragment", "===www=======huafenUrl==" + str);
            m7817a(str, 1);
        } else if (g.setting_llyt_faq == id) {
            str = "";
            C2538c.m12677c("KIDWATCH_SettingFragment", "===www=======faqUrl currentDeviceType" + C1467b.m6787c(this.f4337k));
            if (7 == C1467b.m6787c(this.f4337k)) {
                str = "http://health.vmall.com/help/k2/app2.1/zh-CN/index.html";
            } else {
                str = "http://health.vmall.com/help/k1/app2.1/zh/index.html";
            }
            C2538c.m12674b("KIDWATCH_SettingFragment", "===www=======faqUrl==" + str);
            m7817a(str, 2);
        } else if (g.setting_llyt_profile_head == id) {
            startActivity(new Intent(this.f4337k, ProfileSettingActivity.class));
        } else if (g.setting_llyt_disney_world == id) {
            m7817a("http://www.dol.cn/minisite/index.aspx", 3);
        } else if (g.setting_llyt_bill != id) {
        } else {
            if (C1490j.m6888a() == null || C1490j.m6888a().size() <= 0 || !C1490j.m6888a().containsKey("abilityRet")) {
                C1483c.m6832c(this.f4337k, getResources().getString(C1680l.IDS_plugin_kidwatch_common_network_exception_notice));
                C1621a c1621a = new C1621a(this.f4337k);
                C2538c.m12674b("KIDWATCH_SettingFragment", "===============not Support billCheck KWCache.getDeviceCode()" + C1462f.m6746j());
                if (!("".equals(C1462f.m6746j()) || C1462f.m6746j() == null)) {
                    c1621a.m7672a(C1462f.m6746j());
                }
                C2538c.m12674b("KIDWATCH_SettingFragment", "===============not Support billCheck");
                return;
            }
            C2538c.m12674b("KIDWATCH_SettingFragment", "===============Support billCheck");
            startActivity(new Intent(this.f4337k, CheckBillActivity.class));
        }
    }

    private void m7817a(String str, int i) {
        Intent intent = new Intent(this.f4337k, AppHelpActivity.class);
        intent.putExtra("com.huawei.bone.ui.setting.AppHelpActivity.APP_HELP_BASE_URL", str);
        intent.putExtra("com.huawei.bone.ui.setting.AppHelpActivity.JUMP_MODE_KEY", i);
        startActivityForResult(intent, 0);
    }

    private Bitmap m7821d() {
        Bitmap a;
        C2538c.m12674b("KIDWATCH_SettingFragment", "============Enter getDefaultHeadBipmap");
        if (C1462f.m6748k() == null || 1 != C1462f.m6748k().f3091k) {
            C2538c.m12674b("KIDWATCH_SettingFragment", "=============KWCache.curDeviceInfo is null, 设备默认小男孩图片");
            a = C1492l.m6903a(BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_user_boy));
        } else {
            a = C1492l.m6903a(BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_user_girl));
        }
        C2538c.m12674b("KIDWATCH_SettingFragment", "============ Leave getDefaultHeadBipmap");
        return a;
    }

    private void m7816a(ImageView imageView) {
        if (imageView != null) {
            C2538c.m12674b("KIDWATCH_SettingFragment", "=============Enter setHeadViewImage!");
            if (C1462f.m6748k() == null || C1462f.m6748k().f3098r == null || C1462f.m6748k().f3098r.isEmpty()) {
                C2538c.m12674b("KIDWATCH_SettingFragment", "=============setHeadViewImage url is nulll set DefaultHeadBipmap");
                this.f4329c.setImageBitmap(m7821d());
            } else {
                C2538c.m12674b("KIDWATCH_SettingFragment", "=============setHeadViewImage 设置头像图片");
                this.f4338l.m7221a(this.f4337k, imageView, C1462f.m6748k().f3098r);
            }
            C2538c.m12674b("KIDWATCH_SettingFragment", "=============Leave setHeadViewImage!");
        }
    }

    public void onResume() {
        C2538c.m12674b("KIDWATCH_SettingFragment", "===onResume is enter=====");
        m7824b();
        super.onResume();
    }

    public void m7824b() {
        String i = C1462f.m6744i();
        if ("".equals(i)) {
            i = C1093a.m4739a(this.f4337k).m4750c();
            C2538c.m12674b("KIDWATCH_SettingFragment", "===123initData======= huid = " + i);
            C1462f.m6729c(i);
        }
        C1462f.m6718a(C1392h.m6269a(this.f4337k, i, C1462f.m6746j()));
        m7816a(this.f4329c);
        this.f4330d.setVisibility(8);
        if (C1462f.m6748k() != null) {
            this.f4331e.setText(C1462f.m6748k().f3083c);
            this.f4333g.setText(C1462f.m6748k().f3093m);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void m7822e() {
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        C2538c.m12674b("KIDWATCH_SettingFragment", "=checkBill= Enter SettingFragment initBillData");
        new Thread(new bw(this)).start();
    }
}
