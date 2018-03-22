package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.RewardGoal;
import com.huawei.pluginkidwatch.common.entity.model.RewardIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.view.WaitingLineView;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.setting.p166a.C1909a;
import com.huawei.pluginkidwatch.plugin.setting.p167b.C1939d;
import com.huawei.pluginkidwatch.plugin.setting.p167b.C1941f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardActivity extends KidWatchBaseActivity implements OnClickListener {
    private RewardGoal f6449A;
    private ListView f6450B;
    private C1939d f6451C;
    private boolean f6452D = false;
    private ImageView f6453E;
    private ImageView f6454F;
    private Button f6455G;
    private BroadcastReceiver f6456H;
    private GridView f6457I;
    private GridView f6458J;
    private GridView f6459K;
    private GridView f6460L;
    private GridView f6461M;
    private GridView f6462N;
    private RelativeLayout f6463O;
    private RelativeLayout f6464P;
    private RelativeLayout f6465Q;
    private RelativeLayout f6466R;
    private RelativeLayout f6467S;
    private RelativeLayout f6468T;
    private RelativeLayout f6469U;
    private RelativeLayout f6470V;
    private LinearLayout f6471W;
    private LinearLayout f6472X;
    private LinearLayout f6473Y;
    private final String f6474Z = "itemImage";
    private SimpleAdapter aa;
    private SimpleAdapter ab;
    private final int ac = 60;
    private final int ad = 76;
    private final int ae = 101;
    private final int af = 14;
    private final int ag = 11;
    private TextView ah;
    private String ai = "";
    private WaitingLineView aj;
    private OnClickListener ak = new bu(this);
    private C1378e al = new bv(this);
    private Handler am = new bw(this);
    private ViewPager f6475b = null;
    private final int f6476c = 0;
    private List<View> f6477d;
    private View f6478e = null;
    private View f6479f = null;
    private ImageView f6480g;
    private TextView f6481h;
    private TextView f6482i;
    private TextView f6483j;
    private TextView f6484k;
    private Button f6485l;
    private TextView f6486m;
    private Context f6487n;
    private LinearLayout f6488o;
    private RelativeLayout f6489p;
    private final int f6490q = 6;
    private final int f6491r = 7;
    private final int f6492s = 8;
    private final int f6493t = 0;
    private final int f6494u = 1;
    private long f6495v = 0;
    private List<C1941f> f6496w = new ArrayList();
    private List<C1941f> f6497x = new ArrayList();
    private C1413d f6498y;
    private int f6499z = 0;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_reward);
        this.f6498y = C1417a.m6594a(getApplicationContext());
        this.f6487n = this;
        C2538c.m12674b("RewardActivity", "=========Enter initView");
        this.f6475b = (ViewPager) findViewById(g.feature_reward_viewpager);
        this.aj = (WaitingLineView) findViewById(g.setting_add_reward_wait_line);
        this.f6453E = (ImageView) findViewById(g.feature_reward_viewpager_top_image_left);
        this.f6453E.setBackgroundResource(C1617f.kw_img_circle);
        this.f6454F = (ImageView) findViewById(g.feature_reward_viewpager_top_image_right);
        this.f6483j = (TextView) findViewById(g.feature_reward_tv_reward);
        this.f6484k = (TextView) findViewById(g.feature_reward_tv_history_info);
        this.f6483j.setOnClickListener(this);
        this.f6484k.setOnClickListener(this);
        this.f6477d = new ArrayList();
        this.f6478e = View.inflate(this, h.activit_reward_left, null);
        this.f6455G = (Button) this.f6478e.findViewById(g.feature_reward_imbt_set_goal);
        this.f6455G.setOnClickListener(this);
        this.f6480g = (ImageView) this.f6478e.findViewById(g.reward_line);
        this.f6481h = (TextView) this.f6478e.findViewById(g.reward_total_numbers);
        this.f6482i = (TextView) this.f6478e.findViewById(g.reward_current_numbers);
        this.f6485l = (Button) this.f6478e.findViewById(g.reward_btn_send_flower);
        this.f6486m = (TextView) this.f6478e.findViewById(g.reward_tv_goal);
        this.ah = (TextView) this.f6478e.findViewById(g.setting_reward_tv_hope);
        this.f6479f = View.inflate(this, h.activit_reward_right, null);
        this.f6450B = (ListView) this.f6479f.findViewById(g.feature_reward_history_list);
        this.f6488o = (LinearLayout) this.f6479f.findViewById(g.feature_reward_no_history);
        this.f6489p = (RelativeLayout) this.f6479f.findViewById(g.feature_reward_history);
        this.f6477d.add(this.f6478e);
        this.f6477d.add(this.f6479f);
        this.f6485l.setOnClickListener(this.ak);
        this.f6475b.setAdapter(new C1909a(this.f6477d));
        this.f6475b.setCurrentItem(0);
        this.f6475b.setOnPageChangeListener(new by(this));
        this.f6457I = (GridView) this.f6478e.findViewById(g.setting_reward_grideview2);
        this.f6458J = (GridView) this.f6478e.findViewById(g.setting_reward_grideview3);
        this.f6459K = (GridView) this.f6478e.findViewById(g.setting_reward_grideview5);
        this.f6460L = (GridView) this.f6478e.findViewById(g.setting_reward_grideview10);
        this.f6461M = (GridView) this.f6478e.findViewById(g.setting_reward_grideview15);
        this.f6462N = (GridView) this.f6478e.findViewById(g.setting_reward_grideview20);
        this.f6463O = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_relavity_5);
        this.f6464P = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_relavity_10);
        this.f6465Q = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_relavity_15);
        this.f6466R = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_relavity_20);
        this.f6467S = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_relavity_2);
        this.f6468T = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_relavity_3);
        this.f6471W = (LinearLayout) this.f6478e.findViewById(g.setting_reward_grideview);
        this.f6472X = (LinearLayout) this.f6478e.findViewById(g.setting_reward_foal_five);
        this.f6473Y = (LinearLayout) this.f6478e.findViewById(g.setting_reward_lin_reached_goal);
        this.f6469U = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_tv_reach_goal);
        this.f6470V = (RelativeLayout) this.f6478e.findViewById(g.setting_reward_relavity_show);
        m10004d();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private void m10004d() {
        C2538c.m12674b("RewardActivity", "=========Enter initData");
        Intent intent = getIntent();
        this.f6456H = new bx(this);
        this.f6449A = new RewardGoal();
        C2538c.m12674b("RewardActivity", "=========intent.getFlags()：" + intent.getFlags());
        this.f6452D = intent.getBooleanExtra("is_from_notification", false);
        if (this.f6452D) {
            C2538c.m12674b("RewardActivity", "=========从通知来");
            this.f6449A.setGoal(C1492l.m6920d(C1497q.m6945b(this.f6487n, "notification_reward_total", "")));
            this.f6449A.setReward(C1497q.m6945b(this.f6487n, "notification_reward_hope", ""));
            this.f6499z = this.f6449A.getGoal();
            this.ai = C1497q.m6945b(this.f6487n, "notification_reward_devicecode", "");
            C1462f.m6719a(C1093a.m4739a(this.f6487n).m4753f());
            C2538c.m12674b("RewardActivity", "=========从通知来达到的奖励总数：" + this.f6449A.getGoal());
            C2538c.m12674b("RewardActivity", "=========从通知来Hope：" + this.f6449A.getReward());
            C2538c.m12674b("RewardActivity", "=========从通知来deviceCodeTemp：" + this.ai);
        } else {
            C2538c.m12674b("RewardActivity", "=========从页面来");
            this.f6449A.setGoal(intent.getIntExtra("new_goal", -1));
            this.f6449A.setReward(intent.getStringExtra("new_hope"));
            this.f6499z = intent.getIntExtra("notification_reward_reward_goal", 0);
            this.ai = C1462f.m6746j();
        }
        C2538c.m12674b("RewardActivity", "=======传入的goal：", this.f6449A.getGoal() + "");
        C2538c.m12674b("RewardActivity", "=======传入的hope：", this.f6449A.getReward() + "");
        C2538c.m12674b("RewardActivity", "=======传入的以奖励：", this.f6499z + "");
        this.f6482i.setText(this.f6499z + "");
        this.f6481h.setText(this.f6449A.getGoal() + "");
        this.f6486m.setText(this.f6449A.getReward());
        IntentFilter intentFilter = new IntentFilter("com.huawei.pluginkidwatch.feature.reward.reached.goal");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f6487n);
        if (!(instance == null || this.f6456H == null)) {
            instance.registerReceiver(this.f6456H, intentFilter);
        }
        this.f6451C = new C1939d(this);
        if (this.f6450B == null) {
            C2538c.m12680e("RewardActivity", "======= histotyListView is null");
        } else {
            this.f6450B.setAdapter(this.f6451C);
        }
        m10010g();
        if (intent.getBooleanExtra("is_from_notification", false)) {
            C2538c.m12680e("RewardActivity", "======= from notification");
            if (this.f6497x != null && this.f6497x.size() > 0) {
                this.f6449A.setGoal(C1492l.m6920d(((C1941f) this.f6497x.get(0)).m10157a()));
                String[] split = ((C1941f) this.f6497x.get(0)).m10161c().split(":");
                if (2 == split.length) {
                    this.f6449A.setReward(split[1]);
                }
                this.f6499z = this.f6449A.getGoal();
                this.f6482i.setText(this.f6499z + "");
                this.f6481h.setText(this.f6449A.getGoal() + "");
                this.f6486m.setText(this.f6449A.getReward());
            }
            this.f6475b.setCurrentItem(1);
        }
        m10006e();
    }

    private void m10006e() {
        int i;
        C2538c.m12674b("RewardActivity", "=============Enter initGraidView");
        List arrayList = new ArrayList();
        for (i = 0; i < 5; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_ten_gray));
            arrayList.add(hashMap);
        }
        ArrayList arrayList2 = new ArrayList();
        for (i = 0; i < 5; i++) {
            hashMap = new HashMap();
            hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_ten));
            arrayList2.add(hashMap);
        }
        this.aa = new SimpleAdapter(this, arrayList, h.item_gridview, new String[]{"itemImage"}, new int[]{g.graidview_itemImage});
        this.ab = new SimpleAdapter(this, arrayList2, h.item_gridview, new String[]{"itemImage"}, new int[]{g.graidview_itemImage});
        m10008f();
    }

    private void m10008f() {
        C2538c.m12674b("RewardActivity", "=============Enter initGridView");
        m9990a(this.f6449A.getGoal());
        m9991a(this.f6499z, this.f6449A.getGoal());
    }

    private void m9991a(int i, int i2) {
        int i3 = 1;
        C2538c.m12674b("RewardActivity", "=============Enter shouRewardNumImage Num:" + i);
        if (5 == i2) {
            if (i <= 2) {
                m9992a(this.f6457I, i);
                m9999b(this.f6458J, 0);
            } else {
                m9992a(this.f6457I, 2);
                m9999b(this.f6458J, i - 2);
            }
        } else if (i > -1 && i <= 5) {
            m10001c(this.f6459K, i);
            this.f6460L.setAdapter(this.aa);
            this.f6461M.setAdapter(this.aa);
            this.f6462N.setAdapter(this.aa);
        } else if (i > 5 && i <= 10) {
            this.f6459K.setAdapter(this.ab);
            m10001c(this.f6460L, i - 5);
            this.f6461M.setAdapter(this.aa);
            this.f6462N.setAdapter(this.aa);
        } else if (i > 10 && i <= 15) {
            this.f6459K.setAdapter(this.ab);
            this.f6460L.setAdapter(this.ab);
            m10001c(this.f6461M, i - 10);
            this.f6462N.setAdapter(this.aa);
        } else if (i <= 15 || i > 20) {
            C2538c.m12680e("RewardActivity", "============ 以奖励个数的大小有误");
        } else {
            this.f6459K.setAdapter(this.ab);
            this.f6460L.setAdapter(this.ab);
            this.f6461M.setAdapter(this.ab);
            m10001c(this.f6462N, i - 15);
        }
        if (this.f6499z >= this.f6449A.getGoal()) {
            this.f6499z = this.f6449A.getGoal();
            this.f6482i.setText(this.f6499z + "");
            this.f6471W.setVisibility(8);
            this.f6472X.setVisibility(8);
            this.f6473Y.setVisibility(0);
            this.f6469U.setVisibility(0);
            this.ah.setText(C1680l.IDS_plugin_kidwatch_feature_reward_shold_do);
            this.ah.setTextSize(17.0f);
            if (this.f6486m.getText().toString().length() <= 11) {
                this.f6486m.setTextSize(26.0f);
            }
            this.f6486m.setTextColor(getResources().getColor(d.common_reward_reach_goal));
            this.f6485l.setVisibility(8);
            this.f6455G.setText(C1680l.IDS_plugin_kidwatch_feature_reward_already_reward);
            this.f6455G.setVisibility(0);
            LayoutParams layoutParams = this.f6465Q.getLayoutParams();
            layoutParams.height = C1492l.m6901a(this.f6487n, 60.0f);
            this.f6470V.setLayoutParams(layoutParams);
        } else {
            i3 = 0;
        }
        Map hashMap = new HashMap();
        hashMap.put("arrive", i3 + "");
        c.a().a(BaseApplication.m2632b(), a.ad.a(), hashMap, 0);
    }

    private void m9992a(GridView gridView, int i) {
        C2538c.m12674b("RewardActivity", "=============Enter setMixGriadViewTwo ");
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            HashMap hashMap = new HashMap();
            if (i2 < i) {
                hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_five));
            } else {
                hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_five_gray));
            }
            arrayList.add(hashMap);
        }
        gridView.setAdapter(new SimpleAdapter(this, arrayList, h.item_gridview_five, new String[]{"itemImage"}, new int[]{g.graidview_itemImage}));
    }

    private void m9999b(GridView gridView, int i) {
        C2538c.m12674b("RewardActivity", "=============Enter setMixGriadViewThree ");
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            HashMap hashMap = new HashMap();
            if (i2 < i) {
                hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_five));
            } else {
                hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_five_gray));
            }
            arrayList.add(hashMap);
        }
        gridView.setAdapter(new SimpleAdapter(this, arrayList, h.item_gridview_five, new String[]{"itemImage"}, new int[]{g.graidview_itemImage}));
    }

    private void m10001c(GridView gridView, int i) {
        C2538c.m12674b("RewardActivity", "=============Enter setMixGriadView ");
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            HashMap hashMap = new HashMap();
            if (i2 < i) {
                hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_ten));
            } else {
                hashMap.put("itemImage", Integer.valueOf(C1617f.kw_pic_reward_goal_ten_gray));
            }
            arrayList.add(hashMap);
        }
        gridView.setAdapter(new SimpleAdapter(this, arrayList, h.item_gridview, new String[]{"itemImage"}, new int[]{g.graidview_itemImage}));
    }

    private void m9990a(int i) {
        C2538c.m12674b("RewardActivity", "=============Enter showGraidView goal:" + i);
        if (20 == i) {
            this.f6471W.setVisibility(0);
            this.f6472X.setVisibility(8);
            this.f6463O.setVisibility(0);
            this.f6464P.setVisibility(0);
            this.f6465Q.setVisibility(0);
            this.f6466R.setVisibility(0);
            m9998b(60);
        } else if (15 == i) {
            this.f6471W.setVisibility(0);
            this.f6472X.setVisibility(8);
            this.f6463O.setVisibility(0);
            this.f6464P.setVisibility(0);
            this.f6465Q.setVisibility(0);
            this.f6466R.setVisibility(8);
            m9998b(76);
        } else if (10 == i) {
            this.f6471W.setVisibility(0);
            this.f6472X.setVisibility(8);
            this.f6463O.setVisibility(0);
            this.f6464P.setVisibility(0);
            this.f6465Q.setVisibility(8);
            this.f6466R.setVisibility(8);
            m9998b(101);
        } else {
            this.f6471W.setVisibility(8);
            this.f6472X.setVisibility(0);
            m9998b(101);
        }
    }

    private void m9998b(int i) {
        C2538c.m12674b("RewardActivity", "=============Enter testGraidView height:", i + "");
        if (i > 0) {
            LayoutParams layoutParams = this.f6465Q.getLayoutParams();
            layoutParams.height = C1492l.m6901a(this.f6487n, (float) i);
            this.f6463O.setLayoutParams(layoutParams);
            this.f6464P.setLayoutParams(layoutParams);
            this.f6465Q.setLayoutParams(layoutParams);
            this.f6466R.setLayoutParams(layoutParams);
            this.f6470V.setLayoutParams(layoutParams);
            this.f6467S.setLayoutParams(layoutParams);
            this.f6468T.setLayoutParams(layoutParams);
        }
    }

    private void m9996a(boolean z) {
        runOnUiThread(new bs(this, z));
    }

    private void m10010g() {
        C2538c.m12674b("RewardActivity", "====================Enter readHistoryFromDB");
        new Thread(new bt(this)).start();
    }

    private void m9995a(List<C1941f> list) {
        int i = 0;
        C2538c.m12674b("RewardActivity", "=======Enter updateShowingFenceList");
        if (list == null || list.size() <= 0) {
            this.am.sendEmptyMessage(7);
            return;
        }
        this.f6497x.clear();
        while (i < list.size()) {
            this.f6497x.add(list.get((list.size() - 1) - i));
            i++;
        }
        this.am.sendEmptyMessage(6);
    }

    private void m10012h() {
        C2538c.m12674b("RewardActivity", "==========Enter addOneReward");
        this.f6485l.setEnabled(false);
        this.aj.setVisibility(0);
        this.aj.m7206a(true);
        RewardIOEntityModel rewardIOEntityModel = new RewardIOEntityModel();
        rewardIOEntityModel.count = 1;
        rewardIOEntityModel.deviceCode = this.ai;
        rewardIOEntityModel.rewardType = 1;
        this.f6498y.mo2492a(rewardIOEntityModel, this.al);
    }

    protected void onResume() {
        super.onResume();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (g.feature_reward_imbt_set_goal == id) {
            m10014i();
        } else if (g.feature_reward_tv_reward == id) {
            this.f6475b.setCurrentItem(0);
        } else if (g.feature_reward_tv_history_info == id) {
            this.f6475b.setCurrentItem(1);
        }
    }

    private void m10014i() {
        C2538c.m12674b("RewardActivity", "==============Enter gotoSetGoal");
        Intent intent = new Intent();
        intent.setClass(this.f6487n, SetRewardGoalActivity.class);
        C2538c.m12674b("RewardActivity", "==============currentNum " + this.f6499z);
        if (!(this.f6449A == null || this.f6449A.getGoal() == 0 || this.f6499z >= this.f6449A.getGoal())) {
            C2538c.m12674b("RewardActivity", "==============mRewardGoal.goal " + this.f6449A.getGoal());
            intent.putExtra("old_goal", this.f6449A.getGoal());
            intent.putExtra("old_hope", this.f6449A.getReward());
        }
        if (this.f6449A == null || this.f6499z < this.f6449A.getGoal()) {
            intent.putExtra("is_modify_goal", true);
        } else {
            C2538c.m12674b("RewardActivity", "===============Make currentNum is zero");
            intent.putExtra("is_modify_goal", false);
        }
        intent.putExtra("reward_from_notification", this.f6452D);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C2538c.m12674b("RewardActivity", "==============Enter onActivityResult,");
        C2538c.m12674b("RewardActivity", "==============resultCode:" + i2);
        C2538c.m12674b("RewardActivity", "==============requestCode:" + i);
        if (1 == i && -1 == i2 && intent != null) {
            int intExtra = intent.getIntExtra("new_goal", 20);
            Object stringExtra = intent.getStringExtra("new_hope");
            C2538c.m12674b("RewardActivity", "==============isMotiry:" + intent.getBooleanExtra("is_modify_goal", false));
            if (!intent.getBooleanExtra("is_modify_goal", false)) {
                this.f6499z = 0;
                this.f6482i.setText(this.f6499z + "");
            }
            this.f6481h.setText(intExtra + "");
            this.f6486m.setText(stringExtra);
            this.f6480g.setVisibility(0);
            this.f6481h.setVisibility(0);
            this.f6485l.setVisibility(0);
            this.f6469U.setVisibility(8);
            this.f6473Y.setVisibility(8);
            this.f6449A.setGoal(intExtra);
            this.f6449A.setReward(stringExtra);
            this.ah.setText(C1680l.IDS_plugin_kidwatch_feature_reward_baby_hope);
            this.ah.setTextSize(12.0f);
            this.f6486m.setTextSize(18.0f);
            this.f6486m.setTextColor(getResources().getColor(d.kw_color_black_85alpha));
            this.f6455G.setText(C1680l.IDS_plugin_kidwatch_feature_goal_change);
            this.f6455G.setVisibility(8);
            m10008f();
        } else if (i2 == 0) {
            C2538c.m12674b("RewardActivity", "========== 0==resultCode");
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onNewIntent(Intent intent) {
        C2538c.m12674b("RewardActivity", "==============Enter onNewIntent");
        setIntent(intent);
        if (intent.getBooleanExtra("is_from_notification", false)) {
            C2538c.m12674b("RewardActivity", "==============onnewIntent 从通知来");
            this.f6475b.setCurrentItem(1);
        }
        super.onNewIntent(intent);
    }

    protected void onDestroy() {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f6487n);
        if (instance != null) {
            instance.unregisterReceiver(this.f6456H);
        }
        C2538c.m12674b("RewardActivity", "==============fresh immeniately");
        super.onDestroy();
    }

    private void m10016j() {
        C2538c.m12674b("RewardActivity", "==========Enter freshBuletooth");
        C1395k a = C1392h.m6269a(this.f6487n, C1462f.m6744i(), C1462f.m6746j());
        if (a != null) {
            try {
                if (a.m6340a() != null) {
                    C2538c.m12674b("RewardActivity", "deviceInfo = " + a.m6340a());
                    this.f6498y.mo2508a(a.m6340a(), C1462f.m6746j());
                }
            } catch (Exception e) {
                C2538c.m12674b("RewardActivity", "==========通过蓝牙发送立即更新发生异常");
            }
        }
    }
}
