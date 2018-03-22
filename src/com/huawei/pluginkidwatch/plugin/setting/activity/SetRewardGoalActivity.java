package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.RewardGoal;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.button.C1520i;
import com.huawei.pluginkidwatch.common.ui.title.CustomTitle;
import com.huawei.pluginkidwatch.common.ui.view.WaitingLineView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.setting.p167b.C1942g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SetRewardGoalActivity extends KidWatchBaseActivity {
    private int f6543A = 0;
    private boolean f6544B = false;
    private boolean f6545C = false;
    private final int f6546D = 14;
    private boolean f6547E;
    private WaitingLineView f6548F;
    private boolean f6549G = false;
    private Handler f6550H = new Handler();
    private boolean f6551I = false;
    private OnClickListener f6552J = new co(this);
    private TextWatcher f6553K = new cr(this);
    private Runnable f6554L = new cs(this);
    public final String f6555b = "SetRewardGoalActivity";
    private C1413d f6556c;
    private Context f6557d;
    private C1520i f6558e;
    private EditText f6559f;
    private CustomTitle f6560g;
    private final int f6561h = 20;
    private int f6562i = 20;
    private LinearLayout f6563j;
    private LinearLayout f6564k;
    private LinearLayout f6565l;
    private LinearLayout f6566m;
    private TextView f6567n;
    private TextView f6568o;
    private TextView f6569p;
    private TextView f6570q;
    private TextView f6571r;
    private TextView f6572s;
    private final int f6573t = 22;
    private final int f6574u = 17;
    private final int f6575v = 5;
    private final int f6576w = 10;
    private final int f6577x = 15;
    private final int f6578y = 20;
    private final int f6579z = 20;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_set_reward_goal);
        this.f6547E = getIntent().getBooleanExtra("is_modify_goal", false);
        this.f6548F = (WaitingLineView) findViewById(g.setting_set_reward_wait_line);
        this.f6563j = (LinearLayout) findViewById(g.setting_rll_reward_img_5);
        this.f6564k = (LinearLayout) findViewById(g.setting_rll_reward_img_10);
        this.f6565l = (LinearLayout) findViewById(g.setting_rll_reward_img_15);
        this.f6566m = (LinearLayout) findViewById(g.setting_rll_reward_img_20);
        this.f6567n = (TextView) findViewById(g.setting_tv_reward_5);
        this.f6568o = (TextView) findViewById(g.setting_tv_reward_10);
        this.f6569p = (TextView) findViewById(g.setting_tv_reward_15);
        this.f6570q = (TextView) findViewById(g.setting_tv_reward_20);
        this.f6571r = (TextView) findViewById(g.setting_reward_etv_hope);
        this.f6572s = (TextView) findViewById(g.setting_reward_num_above);
        this.f6563j.setOnClickListener(this.f6552J);
        this.f6564k.setOnClickListener(this.f6552J);
        this.f6565l.setOnClickListener(this.f6552J);
        this.f6566m.setOnClickListener(this.f6552J);
        this.f6557d = this;
        this.f6556c = C1417a.m6594a(getApplicationContext());
        Intent intent = getIntent();
        if (1 == intent.getFlags()) {
            C2538c.m12674b("SetRewardGoalActivity", "========== From Notification 0  ");
            this.f6545C = true;
            this.f6543A = C1492l.m6920d(C1462f.m6746j());
        } else if (2 == intent.getFlags()) {
            C2538c.m12674b("SetRewardGoalActivity", "========== From Notification 1  ");
            this.f6544B = true;
            this.f6543A = C1942g.m10165a();
        } else if (intent.getBooleanExtra("reward_from_notification", false)) {
            C2538c.m12674b("SetRewardGoalActivity", "========== From Notification 2  ");
            this.f6543A = C1492l.m6920d(C1497q.m6945b(this.f6557d, "notification_reward_devicecode", ""));
        } else {
            C2538c.m12674b("SetRewardGoalActivity", "========== From Notification 4  ");
            this.f6543A = C1492l.m6920d(C1462f.m6746j());
        }
        int intExtra = getIntent().getIntExtra("old_goal", 20);
        CharSequence stringExtra = getIntent().getStringExtra("old_hope");
        this.f6562i = intExtra;
        m10066a(this.f6562i);
        this.f6560g = (CustomTitle) findViewById(g.feature_reward_set_reward_goal_title);
        this.f6559f = (EditText) findViewById(g.setting_reward_etv_hope);
        this.f6559f.addTextChangedListener(this.f6553K);
        this.f6558e = this.f6560g.getMenuBt();
        if (stringExtra != null && !"".equals(stringExtra.trim())) {
            this.f6559f.setText(stringExtra);
        }
    }

    private void m10066a(int i) {
        C2538c.m12674b("SetRewardGoalActivity", "========Enter initGoal:", i + "");
        switch (i) {
            case 5:
                m10081g();
                return;
            case 10:
                m10078f();
                return;
            case 15:
                m10076e();
                return;
            default:
                m10074d();
                return;
        }
    }

    private void m10074d() {
        C2538c.m12674b("SetRewardGoalActivity", "========Enter selectTwenty");
        this.f6563j.setSelected(false);
        this.f6564k.setSelected(false);
        this.f6565l.setSelected(false);
        this.f6566m.setSelected(true);
        this.f6567n.setTextSize(17.0f);
        this.f6568o.setTextSize(17.0f);
        this.f6569p.setTextSize(17.0f);
        this.f6570q.setTextSize(22.0f);
        this.f6562i = 20;
        m10069b(this.f6562i);
    }

    private void m10076e() {
        C2538c.m12674b("SetRewardGoalActivity", "========Enter selectFifteen");
        this.f6563j.setSelected(false);
        this.f6564k.setSelected(false);
        this.f6565l.setSelected(true);
        this.f6566m.setSelected(false);
        this.f6567n.setTextSize(17.0f);
        this.f6568o.setTextSize(17.0f);
        this.f6569p.setTextSize(22.0f);
        this.f6570q.setTextSize(17.0f);
        this.f6562i = 15;
        m10069b(this.f6562i);
    }

    private void m10078f() {
        C2538c.m12674b("SetRewardGoalActivity", "========Enter selectTen");
        this.f6563j.setSelected(false);
        this.f6564k.setSelected(true);
        this.f6565l.setSelected(false);
        this.f6566m.setSelected(false);
        this.f6567n.setTextSize(17.0f);
        this.f6568o.setTextSize(22.0f);
        this.f6569p.setTextSize(17.0f);
        this.f6570q.setTextSize(17.0f);
        this.f6562i = 10;
        m10069b(this.f6562i);
    }

    private void m10081g() {
        C2538c.m12674b("SetRewardGoalActivity", "========Enter selectFive");
        this.f6563j.setSelected(true);
        this.f6564k.setSelected(false);
        this.f6565l.setSelected(false);
        this.f6566m.setSelected(false);
        this.f6567n.setTextSize(22.0f);
        this.f6568o.setTextSize(17.0f);
        this.f6569p.setTextSize(17.0f);
        this.f6570q.setTextSize(17.0f);
        this.f6562i = 5;
        m10069b(this.f6562i);
    }

    private void m10069b(int i) {
        C2538c.m12674b("SetRewardGoalActivity", "=========Enter setDescribe, num:", i + "");
        this.f6572s.setText(String.format(getString(C1680l.IDS_plugin_kidwatch_feature_reward_set_goal_info3), new Object[]{Integer.valueOf(i)}));
    }

    public void onSaveClick(View view) {
        C2538c.m12674b("SetRewardGoalActivity", "==========Enter onSaveClick()");
        String trim = this.f6559f.getText().toString().trim();
        if ("".equals(trim)) {
            C1483c.m6824a(this.f6557d, C1680l.IDS_plugin_kidwatch_feature_reward_set_baby_target);
        } else if (C1492l.m6917b(trim)) {
            if (!C1492l.m6916b(this.f6557d)) {
                C2538c.m12680e("SetRewardGoalActivity", "========== Network is unavailable");
                C1483c.m6824a(this.f6557d, C1680l.IDS_plugin_kidwatch_common_network_disable);
            }
            C2538c.m12674b("SetRewardGoalActivity", "========== is  isSaveGoal : " + this.f6551I);
            if (!this.f6551I) {
                this.f6551I = true;
                m10087j();
            }
        } else {
            C1483c.m6824a(getApplicationContext(), C1680l.IDS_plugin_kidwatch_commom_illegal);
        }
    }

    private void m10083h() {
        C2538c.m12674b("SetRewardGoalActivity", "==========Enter saveRewardGoalToCloud");
        Map hashMap = new HashMap();
        hashMap.put("number", this.f6562i + "");
        c.a().a(BaseApplication.m2632b(), a.ac.a(), hashMap, 0);
        String trim = this.f6559f.getText().toString().trim();
        this.f6558e.setClickable(false);
        RewardGoal rewardGoal = new RewardGoal();
        try {
            rewardGoal.setReward(URLEncoder.encode(C1492l.m6924h(trim), GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("SetRewardGoalActivity", "==========error:" + e.getMessage());
            rewardGoal.setReward(trim);
        }
        rewardGoal.setGoal(this.f6562i);
        hashMap = new HashMap();
        hashMap.put("rewardGoal", rewardGoal);
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        setWatchSettingIOModel.deviceCode = this.f6543A + "";
        setWatchSettingIOModel.settingMap = hashMap;
        this.f6548F.setVisibility(0);
        this.f6548F.m7206a(true);
        this.f6556c.mo2496a(setWatchSettingIOModel, new cp(this));
    }

    private void m10084i() {
        C2538c.m12674b("SetRewardGoalActivity", "===============Enter cancleNotification");
        if (this.f6543A == C1492l.m6920d(C1497q.m6945b(this.f6557d, "notification_current_request_devicecode", ""))) {
            C2538c.m12674b("SetRewardGoalActivity", "========cancle");
            C1495o.m6928a(this.f6557d, 10);
        }
    }

    private void m10087j() {
        C2538c.m12674b("SetRewardGoalActivity", "===============Enter clearRewardInfoInCloud");
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.data = "";
        commonRetOModel.deviceCode = this.f6543A + "";
        commonRetOModel.type = 14;
        this.f6556c.mo2473a(commonRetOModel, new cq(this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f6559f.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (!(motionEvent.getAction() != 0 || getCurrentFocus() == null || getCurrentFocus().getWindowToken() == null)) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onBackClick(View view) {
        C2538c.m12674b("SetRewardGoalActivity", "============== onBackClick====");
        if (this.f6544B) {
            this.f6544B = false;
            this.f6543A = 0;
        }
        onBackPressed();
    }

    private void m10088k() {
        C2538c.m12674b("SetRewardGoalActivity", "==========Enter freshBuletooth");
        C1395k a = C1392h.m6269a(this.f6557d, C1462f.m6744i(), C1462f.m6746j());
        if (a != null && a.f3096p != null) {
            C2538c.m12674b("SetRewardGoalActivity", "deviceInfo = " + a.f3096p);
            this.f6556c.mo2508a(a.f3096p, C1462f.m6746j());
        }
    }

    protected void onDestroy() {
        this.f6549G = false;
        this.f6550H.removeCallbacks(this.f6554L);
        super.onDestroy();
    }
}
