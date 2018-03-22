package com.huawei.ui.device.activity.goldmember;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IQueryMemberStatusCallback;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import com.huawei.ui.device.h;
import com.huawei.ui.device.i;
import com.huawei.ui.device.j;
import com.huawei.ui.device.p170a.C1998z;
import com.huawei.up.model.UserInfomation;
import com.squareup.picasso.Picasso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VIPUserInfoActivity extends BaseActivity implements OnClickListener {
    private static String f7302d = "VIPUserInfoActivity";
    private static int f7303w = 86400000;
    private static int f7304x = 30;
    private String f7305A;
    private String f7306B;
    private String f7307C;
    private long f7308D = 0;
    private String f7309E = "";
    private ImageView f7310F;
    private Context f7311G;
    private TextView f7312H;
    private TextView f7313I;
    private TextView f7314J;
    private TextView f7315K;
    private TextView f7316L;
    private CustomAlertDialog f7317M;
    private ImageView f7318N;
    private ImageView f7319O;
    private ImageView f7320P;
    private ImageView f7321Q;
    private ImageView f7322R;
    private ImageView f7323S;
    private TextView f7324T;
    private TextView f7325U;
    private a f7326V;
    private Handler f7327W = new C2086g(this);
    private IBaseResponseCallback f7328X = new C2087h(this);
    private IQueryMemberStatusCallback f7329Y = new C2088i(this);
    String f7330a;
    long f7331b;
    C1998z f7332c;
    private LinearLayout f7333e;
    private LinearLayout f7334f;
    private LinearLayout f7335g;
    private LinearLayout f7336h;
    private LinearLayout f7337i;
    private LinearLayout f7338j;
    private LinearLayout f7339k;
    private LinearLayout f7340l;
    private ImageView f7341m;
    private Bitmap f7342n;
    private String f7343o;
    private UserInfomation f7344p = null;
    private TextView f7345q;
    private TextView f7346r;
    private TextView f7347s;
    private TextView f7348t;
    private TextView f7349u;
    private CustomAlertDialog f7350v;
    private int f7351y;
    private int f7352z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7311G = this;
        if (this.f7311G != null) {
            this.f7332c = new C1998z(this.f7311G);
        }
        m10801d();
    }

    protected void onResume() {
        C2538c.m12677c(f7302d, "Enter onResume():");
        super.onResume();
        m10798c();
    }

    private void m10798c() {
        C2538c.m12677c(f7302d, "Enter queryMemberStatus():");
        new Thread(new C2089j(this)).start();
    }

    private void m10801d() {
        C2538c.m12677c(f7302d, "Enter initView():");
        setContentView(f.activity_vip_member_user_info);
        this.f7341m = (ImageView) d.a(this, e.main_sns_Member_user_head_img);
        this.f7310F = (ImageView) d.a(this, e.icon_vip_gold_imageView);
        this.f7339k = (LinearLayout) d.a(this, e.userinfor_Member_expired_reminder_layout);
        this.f7333e = (LinearLayout) d.a(this, e.member_Free_Maintenance_layout);
        this.f7334f = (LinearLayout) d.a(this, e.member_Service_hotline_layout);
        this.f7335g = (LinearLayout) d.a(this, e.member_FreeCleaning_layout);
        this.f7336h = (LinearLayout) d.a(this, e.member_Free_repair_layout);
        this.f7337i = (LinearLayout) d.a(this, e.member_Free_Guarantee_layout);
        this.f7338j = (LinearLayout) d.a(this, e.member_Free_Equipment_guarantee_layout);
        this.f7340l = (LinearLayout) d.a(this, e.main_sns_Member_RelativeLayout);
        this.f7348t = (TextView) d.a(this, e.member_Free_upgrade_TextView);
        this.f7349u = (TextView) d.a(this, e.member_Free_upgrade_title);
        this.f7345q = (TextView) d.a(this, e.main_sns_Member_user_name);
        this.f7347s = (TextView) d.a(this, e.userinfor_Member_expired_reminder);
        this.f7346r = (TextView) d.a(this, e.member_Validity_period);
        this.f7312H = (TextView) d.a(this, e.member_Service_hotline_tv);
        this.f7313I = (TextView) d.a(this, e.member_Free_repair_tv);
        this.f7314J = (TextView) d.a(this, e.member_FreeCleaning_tv);
        this.f7315K = (TextView) d.a(this, e.member_Free_Equipment_guarantee_tv);
        this.f7316L = (TextView) d.a(this, e.member_Free_Guarantee_tv);
        this.f7335g.setOnClickListener(this);
        this.f7336h.setOnClickListener(this);
        this.f7338j.setOnClickListener(this);
        this.f7337i.setOnClickListener(this);
        this.f7334f.setOnClickListener(this);
        this.f7333e.setOnClickListener(this);
        DeviceInfo c = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        if (c == null || 10 != c.getProductType()) {
            this.f7338j.setVisibility(0);
            this.f7337i.setVisibility(0);
        } else {
            C2538c.m12677c(f7302d, "current device is LEO !");
            this.f7338j.setVisibility(8);
            this.f7337i.setVisibility(8);
        }
        this.f7318N = (ImageView) d.a(this, e.vip_member_img0);
        this.f7319O = (ImageView) d.a(this, e.vip_member_img1);
        this.f7320P = (ImageView) d.a(this, e.vip_member_img2);
        this.f7321Q = (ImageView) d.a(this, e.vip_member_img3);
        this.f7322R = (ImageView) d.a(this, e.vip_member_img4);
        this.f7323S = (ImageView) d.a(this, e.vip_member_img5);
        if (c.e(this.f7311G)) {
            this.f7318N.setBackgroundResource(g.ic_enter_left_pressed);
            this.f7319O.setBackgroundResource(g.ic_enter_left_pressed);
            this.f7320P.setBackgroundResource(g.ic_enter_left_pressed);
            this.f7321Q.setBackgroundResource(g.ic_enter_left_pressed);
            this.f7322R.setBackgroundResource(g.ic_enter_left_pressed);
            this.f7323S.setBackgroundResource(g.ic_enter_left_pressed);
        }
        this.f7327W.sendEmptyMessage(6);
    }

    private void m10804e() {
        C2538c.m12677c(f7302d, "enter upDataUserInfo");
        if (this.f7342n != null) {
            this.f7341m.setImageBitmap(this.f7342n);
        }
        if (this.f7344p == null) {
            C2538c.m12677c(f7302d, "mUserInfo is null !");
            return;
        }
        if (this.f7344p.getName() != null) {
            C2538c.m12674b(f7302d, "mUserName = " + this.f7344p.getName());
            this.f7345q.setText(this.f7344p.getName());
        } else {
            this.f7345q.setVisibility(8);
        }
        C2538c.m12677c(f7302d, "levelName = " + this.f7305A + ";levelIconUrl =  " + this.f7306B);
        if (TextUtils.isEmpty(this.f7306B)) {
            this.f7310F.setImageResource(g.icon_vip_gold);
        } else {
            Picasso.with(this).load(this.f7306B).into(this.f7310F);
        }
    }

    private void m10807f() {
        C2538c.m12677c(f7302d, "enter upDataMemberExpired():");
        if (1 == this.f7351y || m10817k() == null || m10817k().isEmpty()) {
            C2538c.m12677c(f7302d, "member is Ordinary");
            this.f7346r.setText(this.f7309E);
            return;
        }
        this.f7346r.setText(new SpannableString(getString(i.IDS_main_sns_member_valid_to, new Object[]{this.f7309E, m10817k()})));
        int i = (int) ((this.f7308D - this.f7331b) / ((long) f7303w));
        C2538c.m12677c(f7302d, "expiredDay" + i);
        if (i <= f7304x) {
            CharSequence spannableString;
            if (i == 0) {
                spannableString = new SpannableString(getResources().getQuantityString(h.IDS_main_sns_member_surplus_time, 1, new Object[]{this.f7309E, getString(i.IDS_main_sns_member_surplus_time_less_than_one_day)}));
            } else {
                spannableString = new SpannableString(getResources().getQuantityString(h.IDS_main_sns_member_surplus_time, i, new Object[]{this.f7309E, Integer.valueOf(i)}));
            }
            this.f7339k.setVisibility(0);
            this.f7347s.setText(spannableString);
            this.f7340l.setPadding(0, m10828a(7.0f), 0, 0);
            return;
        }
        this.f7340l.setPadding(0, m10828a(19.0f), 0, 0);
    }

    private void m10809g() {
        C2538c.m12677c(f7302d, "enter upDataMemberFreeUp():userBand = " + this.f7309E + "->intentLevel=" + this.f7307C);
        this.f7333e.setVisibility(0);
        CharSequence spannableString = new SpannableString(getString(i.IDS_main_sns_member_to_upgrade, new Object[]{this.f7309E, this.f7307C}));
        m10815j();
        this.f7349u.setText(getString(i.IDS_main_sns_member_user_free_upgrade));
        this.f7348t.setText(spannableString);
    }

    private void m10811h() {
        C2538c.m12677c(f7302d, "enter receiveNewRights():");
        this.f7333e.setVisibility(0);
        this.f7348t.setText(getString(i.IDS_main_sns_member_using_new_interests));
        this.f7349u.setText(getString(i.IDS_main_sns_member_receive_more_rights_and_interests));
        this.f7312H.setText("");
        this.f7313I.setText(getResources().getString(i.IDS_main_sns_member_number_of_times));
        this.f7314J.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
        this.f7315K.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
        this.f7316L.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
    }

    private void m10813i() {
        C2538c.m12677c(f7302d, "enter updateServiceArea():");
        this.f7333e.setVisibility(8);
        this.f7312H.setText("");
        this.f7313I.setText(getResources().getString(i.IDS_main_sns_member_number_of_times));
        this.f7314J.setText(getResources().getString(i.IDS_main_sns_member_twice));
        this.f7315K.setText("");
        this.f7316L.setText("");
    }

    private void m10815j() {
        C2538c.m12677c(f7302d, "enter upDataAfterReceiving():");
        if (this.f7351y < 3) {
            this.f7312H.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
            this.f7313I.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
        } else {
            this.f7312H.setText("");
            this.f7313I.setText(getResources().getString(i.IDS_main_sns_member_number_of_times));
        }
        this.f7314J.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
        this.f7315K.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
        this.f7316L.setText(getResources().getString(i.IDS_main_sns_member_upgrade_after_receiving));
    }

    @TargetApi(3)
    private String m10817k() {
        C2538c.m12677c(f7302d, "enter getExpireTime():");
        if (this.f7330a == null) {
            return "";
        }
        try {
            Date parse = new SimpleDateFormat("yyyy/MM/dd").parse(this.f7330a);
            this.f7308D = parse.getTime();
            if (this.f7308D < System.currentTimeMillis()) {
                return null;
            }
            return C0956c.m3346a(parse, 65556);
        } catch (ParseException e) {
            C2538c.m12680e(f7302d, "Exception e = " + e.getMessage());
            return "";
        } catch (Exception e2) {
            C2538c.m12680e(f7302d, "Exception e = " + e2.getMessage());
            return "";
        }
    }

    public void onClick(View view) {
        C2538c.m12677c(f7302d, "enter onClick():");
        int id = view.getId();
        if (id == e.member_Free_Maintenance_layout) {
            m10821m();
        } else if (id == e.member_Service_hotline_layout) {
            if (!m10819l() || this.f7351y >= 3) {
                m10823n();
            } else {
                m10825o();
            }
        } else if (id == e.member_Free_repair_layout) {
            if (!m10819l() || this.f7351y >= 3) {
                m10788a(1);
            } else {
                m10825o();
            }
        } else if (id == e.member_FreeCleaning_layout) {
            if (m10819l()) {
                m10825o();
            } else {
                m10788a(2);
            }
        } else if (id == e.member_Free_Equipment_guarantee_layout) {
            if (m10819l()) {
                m10825o();
            } else {
                m10788a(3);
            }
        } else if (id != e.member_Free_Guarantee_layout) {
        } else {
            if (m10819l()) {
                m10825o();
            } else {
                m10788a(4);
            }
        }
    }

    private boolean m10819l() {
        C2538c.m12677c(f7302d, "enter isFreeActivation():");
        if (this.f7352z > 1) {
            return true;
        }
        return false;
    }

    private void m10821m() {
        C2538c.m12677c(f7302d, "enter gotoUpgrade():");
        if (this.f7350v != null) {
            this.f7350v.dismiss();
        }
        Intent intent = new Intent();
        intent.addFlags(1);
        intent.setClass(this, VIPMemberActivationActivity.class);
        startActivity(intent);
    }

    protected void onDestroy() {
        C2538c.m12677c(f7302d, "enter onDestroy():");
        super.onDestroy();
        if (this.f7327W != null) {
            this.f7327W.removeMessages(0);
            this.f7327W.removeMessages(1);
            this.f7327W.removeMessages(2);
            this.f7327W.removeMessages(3);
            this.f7327W.removeMessages(4);
            this.f7327W.removeMessages(5);
            this.f7327W.removeMessages(6);
            this.f7327W.removeMessages(7);
        }
        if (!(this.f7342n == null || this.f7342n.isRecycled())) {
            this.f7342n.recycle();
            this.f7342n = null;
        }
        if (this.f7317M != null && this.f7317M.isShowing()) {
            this.f7317M.dismiss();
            this.f7317M = null;
        }
    }

    private void m10823n() {
        C2538c.m12677c(f7302d, "enter callHotline():");
        String str = "";
        if (this.f7351y >= 3) {
            str = this.f7311G.getResources().getString(i.IDS_main_sns_member_service_call_number_item_1);
        } else {
            str = this.f7311G.getResources().getString(i.IDS_main_sns_member_service_call_number_item_2);
        }
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    private void m10788a(int i) {
        C2538c.m12677c(f7302d, "enter goToUserRights():");
        Intent intent = new Intent();
        intent.setClass(this, VIPUserRightsActivity.class);
        intent.addFlags(i);
        startActivity(intent);
    }

    private void m10825o() {
        C2538c.m12677c(f7302d, "enter showUpgradeDialog():");
        m10830a(Boolean.valueOf(false));
        View inflate = LayoutInflater.from(this.f7311G).inflate(f.dialog_upgrade_to_huawei_gold_member, null);
        this.f7324T = (TextView) d.a(inflate, e.one_month_free);
        this.f7325U = (TextView) d.a(inflate, e.Member_Free_Extended_warranty);
        DeviceInfo c = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        if (c == null || 10 != c.getProductType()) {
            this.f7324T.setVisibility(0);
            this.f7325U.setVisibility(0);
        } else {
            C2538c.m12677c(f7302d, "current device is LEO !");
            this.f7324T.setVisibility(8);
            this.f7325U.setVisibility(8);
        }
        if (this.f7317M == null && !isFinishing()) {
            C2538c.m12677c(f7302d, "enter showObtainFailed ");
            this.f7317M = new com.huawei.ui.commonui.dialog.c(this.f7311G).a(getResources().getString(i.IDS_main_sns_member_upgrade_to_huawei_gold_title)).a(inflate).a(i.IDS_update_new_version_ok, new C2091l(this)).b(i.IDS_settings_button_cancal, new C2090k(this)).a();
            this.f7317M.setCanceledOnTouchOutside(false);
            this.f7317M.show();
        }
    }

    public int m10828a(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void m10830a(Boolean bool) {
        C2538c.m12677c(f7302d, "enter isClickable():");
        this.f7334f.setClickable(bool.booleanValue());
        this.f7336h.setClickable(bool.booleanValue());
        this.f7337i.setClickable(bool.booleanValue());
        this.f7338j.setClickable(bool.booleanValue());
        this.f7335g.setClickable(bool.booleanValue());
    }

    private void m10794b(int i) {
        if (this.f7311G == null || isFinishing()) {
            C2538c.m12677c(f7302d, "mLoadingDialog21 is not null");
        } else if (this.f7326V == null) {
            a aVar = new a(this.f7311G, j.app_update_dialogActivity);
            this.f7326V = a.a(this.f7311G);
            this.f7326V.a(this.f7311G.getString(i));
            this.f7326V.a();
        } else {
            C2538c.m12677c(f7302d, "mLoadingDialog21 is not null");
        }
    }

    public void m10829a() {
        if (this.f7311G == null || isFinishing()) {
            C2538c.m12677c(f7302d, "destroyLoadingDialog is not null");
        } else if (this.f7326V == null) {
            C2538c.m12677c(f7302d, "destroyLoadingDialog is null");
        } else {
            this.f7326V.cancel();
            this.f7326V = null;
            C2538c.m12677c(f7302d, "destroy mLoadingDialog21");
        }
    }
}
