package com.huawei.pluginkidwatch.plugin.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.b;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetVoiceModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1397m;
import com.huawei.pluginkidwatch.common.p138a.aa;
import com.huawei.pluginkidwatch.common.p138a.ab;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.pulltorefreshview.C1532a;
import com.huawei.pluginkidwatch.common.ui.pulltorefreshview.PullToRefreshLayout;
import com.huawei.pluginkidwatch.common.ui.pulltorefreshview.PullableListView;
import com.huawei.pluginkidwatch.common.ui.title.CustomTitle;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1745b;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.snowballtech.data.interaction.constants.Constant;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class ChatActivity extends KidWatchBaseActivity implements OnRequestPermissionsResultCallback {
    private static int aa = 0;
    private static boolean ab = false;
    private static boolean ac = false;
    private static final int[] f4692b = new int[]{C1617f.kw_pic_voice_1, C1617f.kw_pic_voice_2, C1617f.kw_pic_voice_3, C1617f.kw_pic_voice_4, C1617f.kw_pic_voice_5, C1617f.kw_pic_voice_6, C1617f.kw_pic_voice_7, C1617f.kw_pic_voice_8, C1617f.kw_pic_voice_9, C1617f.kw_pic_voice_10};
    private LinearLayout f4693A;
    private LinearLayout f4694B;
    private View f4695C;
    private ImageView f4696D;
    private ImageView f4697E;
    private FrameLayout f4698F = null;
    private FrameLayout f4699G = null;
    private FrameLayout f4700H = null;
    private RelativeLayout f4701I;
    private RelativeLayout f4702J;
    private RelativeLayout f4703K;
    private PullToRefreshLayout f4704L;
    private as f4705M;
    private MediaRecorder f4706N;
    private MediaPlayer f4707O;
    private C1413d f4708P = null;
    private Context f4709Q;
    private Animation f4710R = null;
    private C1507h f4711S = null;
    private C1507h f4712T = null;
    private CustomDialog f4713U;
    private CustomTitle f4714V;
    private InputMethodManager f4715W;
    private long f4716X = 0;
    private long f4717Y = 0;
    private int[] f4718Z = new int[]{0, 0, 0, 0};
    private OnTouchListener aA = new C1762p(this);
    private Runnable aB = new C1765s(this);
    private Runnable aC = new C1766t(this);
    private BroadcastReceiver aD = new aa(this);
    private Runnable aE = new ab(this);
    private final BroadcastReceiver aF = new ai(this);
    private String ad = "";
    private int ae = 0;
    private boolean af = false;
    private boolean ag = false;
    private boolean ah = true;
    private int ai = 10;
    private boolean aj = false;
    private boolean ak = true;
    private int al = 1;
    private C1532a am = new C1758l(this);
    private OnClickListener an = new C1772z(this);
    private OnClickListener ao = new al(this);
    private OnClickListener ap = new am(this);
    private OnClickListener aq = new aq(this);
    private OnClickListener ar = new C1748b(this);
    private TextWatcher as = new C1749c(this);
    private Runnable at = new C1750d(this);
    private OnClickListener au = new C1751e(this);
    private OnLongClickListener av = new C1754h(this);
    private OnClickListener aw = new C1755i(this);
    private OnClickListener ax = new C1756j(this);
    private Handler ay = new C1757k(this);
    private Runnable az = new C1760n(this);
    private List<C1744a> f4719c;
    private List<C1744a> f4720d;
    private List<C1744a> f4721e = new ArrayList();
    private List<C1744a> f4722f = new ArrayList();
    private ArrayList<ab> f4723g;
    private List<UserInfo> f4724h = null;
    private PullableListView f4725i;
    private FrameLayout f4726j;
    private FrameLayout f4727k;
    private FrameLayout f4728l;
    private Timer f4729m = null;
    private Timer f4730n = null;
    private ImageView f4731o;
    private ImageView f4732p;
    private ImageView f4733q;
    private ImageView f4734r;
    private TextView f4735s;
    private TextView f4736t;
    private Button f4737u;
    private Button f4738v;
    private ImageButton f4739w;
    private EditText f4740x;
    private LinearLayout f4741y;
    private LinearLayout f4742z;

    protected void mo2517a() {
        C2538c.m12674b("ChatActivity", "=====Enter initView");
        requestWindowFeature(1);
        setContentView(h.activity_chat);
        this.f4709Q = this;
        this.f4714V = (CustomTitle) findViewById(g.featre_chat_title);
        ac = C1492l.m6912a();
        this.f4708P = C1417a.m6594a(getApplicationContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.aF, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.chat.refresh");
        LocalBroadcastManager.getInstance(this.f4709Q).registerReceiver(this.aD, intentFilter);
        if (getIntent() == null || !getIntent().getBooleanExtra("is_from_notification", false)) {
            ab = C1490j.m6890a("IPS_FamilyTalk");
        } else {
            C2538c.m12674b("ChatActivity", "=====Come from notification");
            ab = true;
            if (C1462f.m6746j() == null || "".equals(C1462f.m6746j())) {
                C2538c.m12674b("ChatActivity", "=====Go to home");
                Intent intent = new Intent();
                intent.setClass(this, HomeActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        }
        this.f4719c = new ArrayList();
        this.f4720d = new ArrayList();
        this.f4710R = AnimationUtils.loadAnimation(this.f4709Q, b.chat_rotate_animation);
        this.f4710R.setInterpolator(new LinearInterpolator());
        this.f4705M = new as(this, this.f4719c, this.ax, this.av, this.aq, this.ay);
        this.f4725i = (PullableListView) findViewById(g.content_view);
        this.f4725i.setAdapter(this.f4705M);
        m8370a(this.f4725i);
        this.f4725i.setOnTouchListener(new C1747a(this));
        this.f4704L = (PullToRefreshLayout) findViewById(g.refresh_view);
        this.f4704L.setOnRefreshListener(this.am);
        this.ae = 0;
        this.f4704L.setForbidden(false);
        this.f4726j = (FrameLayout) findViewById(g.maskView);
        this.f4731o = (ImageView) findViewById(g.chat_single_1);
        this.f4732p = (ImageView) findViewById(g.chat_single_2);
        this.f4733q = (ImageView) findViewById(g.chat_single_3);
        this.f4734r = (ImageView) findViewById(g.chat_single_4);
        this.f4727k = (FrameLayout) findViewById(g.chat_frame_record);
        this.f4728l = (FrameLayout) findViewById(g.chat_frame_speak_short);
        this.f4701I = (RelativeLayout) findViewById(g.relative_chat_select);
        this.f4702J = (RelativeLayout) findViewById(g.relative_chat_cancle_select);
        this.f4703K = (RelativeLayout) findViewById(g.relative_chat_delete);
        this.f4735s = (TextView) findViewById(g.recordTip);
        this.f4736t = (TextView) findViewById(g.chat_count_down);
        this.f4696D = (ImageView) findViewById(g.chat_view_circle);
        this.f4697E = (ImageView) findViewById(g.chat_img_speak_short);
        this.f4737u = (Button) findViewById(g.feature_chat_button);
        this.f4738v = (Button) findViewById(g.chat_send);
        this.f4739w = (ImageButton) findViewById(g.chat_img_change_method_text);
        this.f4739w.setTag(Boolean.valueOf(false));
        this.f4740x = (EditText) findViewById(g.feature_chat_edittext);
        this.f4740x.setHint(String.format(this.f4709Q.getResources().getString(C1680l.IDS_plugin_kidwatch_chat_edit_hint), new Object[]{Integer.valueOf(30)}));
        this.f4740x.addTextChangedListener(this.as);
        this.f4741y = (LinearLayout) findViewById(g.chat_lly_text);
        this.f4742z = (LinearLayout) findViewById(g.chat_lly_normal);
        this.f4693A = (LinearLayout) findViewById(g.chat_lly_delete);
        this.f4694B = (LinearLayout) findViewById(g.lly_chat_bottom);
        this.f4695C = findViewById(g.chat_line);
        this.f4698F = (FrameLayout) findViewById(g.feature_chat_main_fragement);
        this.f4699G = (FrameLayout) findViewById(g.feature_frame_not_support);
        this.f4700H = (FrameLayout) findViewById(g.feature_frame_no_message);
        this.f4737u.setOnTouchListener(this.aA);
        this.f4738v.setOnClickListener(this.ar);
        this.f4739w.setOnClickListener(this.au);
        this.f4715W = (InputMethodManager) getSystemService("input_method");
        this.f4701I.setOnClickListener(this.an);
        this.f4702J.setOnClickListener(this.ao);
        this.f4703K.setOnClickListener(this.ap);
        m8451t();
        if (ab) {
            C2538c.m12674b("ChatActivity", "=====支持群聊,support");
            this.f4694B.setVisibility(0);
            this.f4741y.setVisibility(8);
            this.f4698F.setVisibility(0);
            this.f4699G.setVisibility(8);
            ArrayList h = C1392h.m6315h(getApplicationContext(), C1462f.m6746j());
            C1462f.m6712A().clear();
            C1462f.m6713B().clear();
            Iterator it = h.iterator();
            while (it.hasNext()) {
                C1397m c1397m = (C1397m) it.next();
                C2538c.m12674b("ChatActivity", "=====数据库读出的数据:" + c1397m.toString());
                if (c1397m.f3112d.equals(C1462f.m6744i())) {
                    this.ad = c1397m.f3119k;
                    C2538c.m12674b("ChatActivity", "=====myRelationType:" + this.ad);
                }
                C1462f.m6712A().put(c1397m.f3112d, c1397m.f3109a);
                C1462f.m6713B().put(c1397m.f3112d, c1397m.f3119k);
            }
            m8331D();
            C2538c.m12674b("ChatActivity", "=====显示等待");
            C1506g.m6978a(this.f4709Q, "", false);
            this.ay.postDelayed(this.az, 50);
            return;
        }
        C2538c.m12674b("ChatActivity", "=====不支持群聊，not support");
        this.f4698F.setVisibility(8);
        this.f4737u.setVisibility(8);
        this.f4699G.setVisibility(0);
    }

    private void m8386a(boolean z) {
        int i = 20;
        C2538c.m12674b("ChatActivity", "=====Enter addDataToAdapter");
        int lastVisiblePosition = this.f4725i.getLastVisiblePosition();
        C2538c.m12674b("ChatActivity", "=====Enter addDataToAdapter num" + lastVisiblePosition);
        if (this.f4720d.size() >= 20) {
            this.f4719c.addAll(0, this.f4720d.subList(this.f4720d.size() - 20, this.f4720d.size()));
            this.f4720d.subList(this.f4720d.size() - 20, this.f4720d.size()).clear();
        } else {
            this.f4719c.addAll(0, this.f4720d);
            i = this.f4720d.size();
            this.f4720d.clear();
        }
        if (this.f4720d.size() > 0) {
            m8397b(false);
        } else {
            m8397b(true);
        }
        this.f4705M.m8494a(this.ae);
        if (z) {
            C2538c.m12674b("ChatActivity", "====addSize:" + i);
            if (i > 1) {
                this.f4725i.setSelection(i - 1);
            } else {
                this.f4725i.setSelection(i);
            }
        }
    }

    private void m8397b(boolean z) {
        if (this.f4720d == null || this.f4720d.size() == 0) {
            this.f4704L.setForbidden(true);
        } else {
            this.f4704L.setForbidden(z);
        }
    }

    private void m8417e() {
        if (this.f4719c == null || this.f4719c.size() == 0) {
            C2538c.m12674b("ChatActivity", "=====retutn ");
            return;
        }
        this.f4702J.setVisibility(0);
        this.f4701I.setVisibility(8);
        for (C1744a c1744a : this.f4719c) {
            c1744a.f4786u = true;
            c1744a.f4787v = true;
        }
        this.f4705M.m8494a(this.ae);
    }

    private void m8420f() {
        this.f4701I.setVisibility(0);
        this.f4702J.setVisibility(8);
        if (this.f4719c == null || this.f4719c.size() == 0) {
            C2538c.m12674b("ChatActivity", "=====retutn 2 ");
            return;
        }
        for (C1744a c1744a : this.f4719c) {
            c1744a.f4786u = true;
            c1744a.f4787v = false;
        }
        this.f4705M.m8494a(this.ae);
    }

    private void m8385a(List<C1744a> list) {
        if (list != null) {
            C2538c.m12674b("ChatActivity", "====deleteVoice list.size:" + list);
            new Thread(new an(this, list)).start();
        }
    }

    private void m8396b(List<C1744a> list) {
        if (this.f4712T == null) {
            this.f4712T = new C1507h(this.f4709Q, h.dialog_profile_config, m.servicedialog, false);
        }
        this.f4712T.show();
        TextView textView = (TextView) this.f4712T.findViewById(g.menu_tv_remote_shutdown_sure);
        ((TextView) this.f4712T.findViewById(g.dialog_tv_title)).setText(getString(C1680l.IDS_plugin_kidwatch_chat_delete));
        textView.setText(getString(C1680l.IDS_plugin_kidwatch_common_ok));
        this.f4712T.findViewById(g.menu_tv_remote_shutdown_cancle).setOnClickListener(new ao(this));
        this.f4712T.findViewById(g.menu_tv_remote_shutdown_sure).setOnClickListener(new ap(this, list));
    }

    private void m8370a(ListView listView) {
        C2538c.m12674b("ChatActivity", "=======Enter setListViewSelection");
        if (listView != null) {
            int count = listView.getCount();
            C2538c.m12674b("ChatActivity", "=======count:" + count);
            if (count > 0) {
                listView.setSelection(count - 1);
            }
        }
    }

    private String m8362a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(HwAccountConstants.BLANK);
        }
        return stringBuffer.toString();
    }

    private String m8365a(String str) {
        if (str == null) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                return str.substring(i, str.length());
            }
        }
        return str;
    }

    private void m8382a(C1744a c1744a) {
        if ((this.f4711S == null || !this.f4711S.isShowing()) && c1744a != null) {
            if (this.f4711S == null) {
                this.f4711S = new C1507h(this.f4709Q, h.dialog_profile_config, m.servicedialog, false);
            }
            this.f4711S.show();
            ((TextView) this.f4711S.findViewById(g.dialog_tv_title)).setText(C1680l.IDS_plugin_kidwatch_chat_send_failure);
            this.f4711S.findViewById(g.menu_tv_remote_shutdown_cancle).setOnClickListener(new C1752f(this));
            TextView textView = (TextView) this.f4711S.findViewById(g.menu_tv_remote_shutdown_sure);
            textView.setText(C1680l.IDS_plugin_kidwatch_chat_send_again);
            textView.setTextColor(getResources().getColor(d.black));
            textView.setOnClickListener(new C1753g(this, c1744a));
            return;
        }
        C2538c.m12674b("ChatActivity", "=====Dialog已经显示，无需再次显示");
    }

    private void m8425g() {
        this.aj = false;
        if (m8426h() == 40) {
            try {
                C2538c.m12674b("ChatActivity", "取到了" + m8426h() + "条，可能没取完，继续");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                C2538c.m12680e("ChatActivity", "InterruptedException e" + e.getMessage());
            }
            C2538c.m12674b("ChatActivity", "=====Enter initMsglist");
            Collection arrayList = new ArrayList();
            Collection arrayList2 = new ArrayList();
            C2538c.m12674b("ChatActivity", "取到了" + C1392h.m6314g(this.f4709Q, C1462f.m6744i(), C1462f.m6746j()).size() + "条，全部取到了，结束");
            Iterator it = r0.iterator();
            while (it.hasNext()) {
                ab abVar = (ab) it.next();
                if (aa.m6205f()) {
                    C2538c.m12674b("ChatActivity", "终止获取");
                    this.f4722f.clear();
                    this.aj = true;
                    this.f4721e.clear();
                    return;
                }
                C2538c.m12674b("ChatActivity", "=====voice:" + abVar.toString());
                if (abVar.f2997h == null) {
                    C2538c.m12674b("ChatActivity", "=====voice.local_url  is null,continue");
                } else {
                    if (2 == abVar.f3002m) {
                        C2538c.m12674b("ChatActivity", "=====修改上传状态");
                        abVar.f3002m = 1;
                    }
                    C1744a a = C1744a.m8467a(abVar);
                    if (a != null) {
                        if (3 == a.f4772g || (4 == abVar.f3002m && Math.abs(System.currentTimeMillis() - C1492l.m6922f(abVar.f3009t)) > LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME)) {
                            C2538c.m12674b("ChatActivity", "===========语音还未下载成功，暂不显示  status：" + a.f4772g);
                            arrayList.add(abVar);
                        } else if (4 != abVar.f3002m) {
                            arrayList2.add(a);
                        } else {
                            C2538c.m12674b("ChatActivity", "=====正在下载，而且下载的时间小于5分钟，所以不显示，也不重新下载");
                        }
                    }
                }
            }
            C2538c.m12674b("ChatActivity", "befor msgList.size()=" + this.f4719c.size());
            C2538c.m12674b("ChatActivity", "缓存中有新消息 newTempMsgList.size()=" + this.f4722f.size());
            C2538c.m12674b("ChatActivity", "befor newTempMsgList1.size()=" + this.f4721e.size());
            int size = this.f4719c.size() - this.f4722f.size();
            C2538c.m12674b("ChatActivity", "befor newMsgCount=" + size);
            Collections.sort(arrayList2);
            if (size > 0 && size <= arrayList2.size()) {
                arrayList2.subList(arrayList2.size() - size, arrayList2.size()).clear();
            }
            C2538c.m12674b("ChatActivity", "after tempMsgList1.size()=" + arrayList2.size());
            if (this.f4723g != null) {
                this.f4723g.clear();
            } else {
                this.f4723g = new ArrayList();
            }
            this.f4723g.addAll(arrayList);
            if (this.f4720d != null) {
                this.f4720d.clear();
            } else {
                this.f4720d = new ArrayList();
            }
            this.f4720d.addAll(arrayList2);
            this.ay.sendEmptyMessage(1000);
            if (this.f4720d.size() > 0) {
                m8397b(false);
            } else {
                m8397b(true);
            }
            this.aj = true;
            this.f4722f.clear();
            this.f4721e.clear();
            C2538c.m12674b("ChatActivity", "=====Leave initMsglist");
            return;
        }
        C2538c.m12674b("ChatActivity", "取到了" + m8426h() + "条，全部取到了，结束");
        this.aj = true;
        this.f4721e.clear();
    }

    private int m8426h() {
        C2538c.m12674b("ChatActivity", "=====Enter getNewMsg");
        C2538c.m12674b("ChatActivity", "getNewMsg dirPath:" + m8461y());
        File file = new File(r0);
        if (!file.exists() && file.mkdirs()) {
            C2538c.m12674b("ChatActivity", "getNewMsg create file success");
        }
        if (this.f4720d != null) {
            this.f4720d.clear();
        } else {
            this.f4720d = new ArrayList();
        }
        if (this.f4723g != null) {
            this.f4723g.clear();
        } else {
            this.f4723g = new ArrayList();
        }
        ArrayList a = C1392h.m6274a(this.f4709Q, C1462f.m6744i(), C1462f.m6746j(), 40);
        C2538c.m12674b("ChatActivity", "getNewMsg =====voiceList.size:" + a.size());
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ab abVar = (ab) it.next();
            C2538c.m12674b("ChatActivity", "getNewMsg =====voice:" + abVar.toString());
            if (abVar.f2997h == null) {
                C2538c.m12674b("ChatActivity", "getNewMsg =====voice.local_url  is null,continue");
            } else {
                if (2 == abVar.f3002m) {
                    C2538c.m12674b("ChatActivity", "getNewMsg =====修改上传状态");
                    abVar.f3002m = 1;
                }
                C1744a a2 = C1744a.m8467a(abVar);
                if (a2 != null) {
                    if (3 == a2.f4772g || (4 == abVar.f3002m && Math.abs(System.currentTimeMillis() - C1492l.m6922f(abVar.f3009t)) > LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME)) {
                        C2538c.m12674b("ChatActivity", "getNewMsg ===========语音还未下载成功，暂不显示  status：" + a2.f4772g);
                        this.f4723g.add(abVar);
                    } else if (4 != abVar.f3002m) {
                        this.f4720d.add(a2);
                        this.f4721e.add(a2);
                    } else {
                        C2538c.m12674b("ChatActivity", "getNewMsg =====正在下载，而且下载的时间小于5分钟，所以不显示，也不重新下载");
                    }
                }
            }
        }
        Collections.sort(this.f4720d);
        this.ay.sendEmptyMessage(1000);
        this.ay.sendEmptyMessage(1002);
        C2538c.m12674b("ChatActivity", "=====Leave getNewMsg");
        return a.size();
    }

    private void m8429i() {
        int i;
        for (C1744a c1744a : this.f4719c) {
            C2538c.m12674b("ChatActivity", "=====MSG_HIDE_KEYBORD " + c1744a.toString());
            if (!((C1744a) r3.next()).f4787v) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i != 0) {
            this.f4702J.setVisibility(0);
            this.f4701I.setVisibility(8);
            return;
        }
        this.f4702J.setVisibility(8);
        this.f4701I.setVisibility(0);
    }

    private void m8431j() {
        this.f4731o.setImageDrawable(getResources().getDrawable(f4692b[this.f4718Z[0]]));
        this.f4732p.setImageDrawable(getResources().getDrawable(f4692b[this.f4718Z[1]]));
        this.f4733q.setImageDrawable(getResources().getDrawable(f4692b[this.f4718Z[2]]));
        this.f4734r.setImageDrawable(getResources().getDrawable(f4692b[this.f4718Z[3]]));
    }

    private void m8368a(MotionEvent motionEvent) {
        this.f4717Y = System.currentTimeMillis();
        m8433k();
        m8447r();
        if (motionEvent.getY() < 0.0f) {
            m8439n();
        } else if (this.ah) {
            this.f4737u.setEnabled(false);
            m8366a(C1680l.IDS_plugin_kidwatch_chat_short_tips, C1617f.kw_pic_chat_short);
            this.ay.postDelayed(new C1764r(this), 1000);
        } else if (this.f4726j.isShown()) {
            m8439n();
            m8367a(this.f4716X, this.f4717Y);
        } else {
            C2538c.m12674b("ChatActivity", "=====弹出框没有显示");
        }
        this.ah = true;
    }

    private void m8433k() {
        this.f4736t.setText("10 \"");
    }

    private void m8434l() {
        C2538c.m12674b("ChatActivity", "=====MotionEvent.ACTION_DOWN有权限");
        this.ay.removeCallbacks(this.aB);
        this.ah = true;
        this.ay.postDelayed(this.aB, 1000);
        if (1 != this.al) {
            this.f4717Y = 0;
            this.f4716X = System.currentTimeMillis();
            m8437m();
            m8326A();
            m8328B();
            m8442p();
            m8444q();
            m8370a(this.f4725i);
            this.f4696D.startAnimation(this.f4710R);
        }
    }

    private int m8387b(int i) {
        Integer valueOf = Integer.valueOf(0);
        if (i >= 0 && i < 10) {
            valueOf = Integer.valueOf(0);
        } else if (i >= 10 && i < 20) {
            valueOf = Integer.valueOf(1);
        } else if (i >= 20 && i < 30) {
            valueOf = Integer.valueOf(2);
        } else if (i >= 30 && i < 40) {
            valueOf = Integer.valueOf(3);
        } else if (i >= 40 && i < 50) {
            valueOf = Integer.valueOf(4);
        } else if (i >= 50 && i < 60) {
            valueOf = Integer.valueOf(5);
        } else if (i >= 60 && i < 70) {
            valueOf = Integer.valueOf(6);
        } else if (i >= 70 && i < 80) {
            valueOf = Integer.valueOf(7);
        } else if (i >= 80 && i < 90) {
            valueOf = Integer.valueOf(8);
        } else if (i >= 90 && i < 100) {
            valueOf = Integer.valueOf(9);
        } else if (i >= 100) {
            valueOf = Integer.valueOf(9);
        }
        return valueOf.intValue();
    }

    private void m8437m() {
        C2538c.m12674b("ChatActivity", "=====Enter showMask");
        if (!this.f4726j.isShown()) {
            this.f4726j.setVisibility(0);
        }
    }

    private void m8439n() {
        C2538c.m12674b("ChatActivity", "=====Enter hideMask");
        this.f4726j.setVisibility(8);
        this.f4737u.setText(C1680l.IDS_plugin_kidwatch_chat_button_text);
    }

    private void m8441o() {
        C2538c.m12674b("ChatActivity", "=====Enter cancelMask");
        this.f4735s.setText(C1680l.IDS_plugin_kidwatch_chat_cancel_tips);
        this.f4735s.setTextColor(getResources().getColor(d.setting_profile_give_up));
        this.f4727k.setVisibility(8);
        this.f4697E.setImageDrawable(getResources().getDrawable(C1617f.kw_img_voice_cancel));
        this.f4728l.setVisibility(0);
    }

    private void m8366a(int i, int i2) {
        C2538c.m12674b("ChatActivity", "=====Enter warningMask");
        this.f4735s.setText(i);
        this.f4735s.setTextColor(getResources().getColor(d.kw_color_black_65alpha));
        this.f4735s.setBackgroundColor(0);
        this.f4697E.setImageResource(i2);
        this.f4727k.setVisibility(8);
        this.f4728l.setVisibility(0);
    }

    private void m8442p() {
        this.f4735s.setTextColor(getResources().getColor(d.kw_color_black_65alpha));
        this.f4735s.setText(C1680l.IDS_plugin_kidwatch_chat_record_tips);
        this.f4735s.setBackgroundColor(0);
        this.f4727k.setVisibility(0);
        this.f4728l.setVisibility(8);
    }

    private void m8444q() {
        C2538c.m12674b("ChatActivity", "=====Enter startRecord");
        C1745b.m8476a(this.f4709Q, true);
        String c = m8400c("tmp.amr");
        C2538c.m12674b("ChatActivity", "startRecord fileName:" + c);
        File file = new File(c);
        if (file.exists()) {
            boolean delete = file.delete();
            C2538c.m12674b("ChatActivity", "=====res:" + delete);
        }
        if (this.f4706N != null) {
            C2538c.m12674b("ChatActivity", "startRecord is recording");
            return;
        }
        this.f4706N = new MediaRecorder();
        try {
            this.f4706N.setAudioSource(1);
            this.f4706N.setOutputFormat(3);
            this.f4706N.setAudioEncoder(1);
            this.f4706N.setOutputFile(c);
            this.f4706N.setAudioEncodingBitRate(5150);
            this.f4706N.prepare();
            this.f4706N.start();
            this.ay.postDelayed(this.aC, 100);
        } catch (Exception e) {
            this.f4706N = null;
            C2538c.m12674b("ChatActivity", "===========startRecord error !!! ,e:" + e.getMessage());
        }
    }

    private void m8447r() {
        C2538c.m12674b("ChatActivity", "stopRecord");
        m8330C();
        C1745b.m8476a(this.f4709Q, false);
        try {
            if (this.f4706N != null) {
                this.f4706N.stop();
                this.f4706N.reset();
                this.f4706N.release();
            }
        } catch (Exception e) {
            C2538c.m12674b("ChatActivity", "======ERROR!!! e:" + e.getMessage());
        }
        this.f4706N = null;
        this.ay.removeCallbacks(this.aC);
    }

    private void m8367a(long j, long j2) {
        C2538c.m12674b("ChatActivity", "======Enter saveRecord");
        String c = m8400c("tmp.amr");
        String z = m8463z();
        C2538c.m12674b("ChatActivity", "saveRecord:" + z);
        File file = new File(c);
        if (file.exists()) {
            if (!file.renameTo(new File(z))) {
                C2538c.m12674b("ChatActivity", "reName failure");
            }
            if (this.f4700H.getVisibility() == 0) {
                this.f4700H.setVisibility(8);
            }
            ab abVar = new ab();
            abVar.f2993d = C1462f.m6744i();
            abVar.f2999j = C1492l.m6920d(C1462f.m6746j());
            abVar.f3000k = C1462f.m6744i();
            abVar.f2997h = z;
            abVar.f2996g = System.currentTimeMillis() + "";
            abVar.f2990a = C1462f.m6746j();
            abVar.f2992c = getString(C1680l.IDS_plugin_kidwatch_chat_me);
            abVar.f3003n = true;
            abVar.f3006q = this.ad;
            abVar.f3002m = 2;
            abVar.f3007r = j + "";
            abVar.f2994e = "0";
            C1397m g = C1392h.m6313g(this.f4709Q, C1462f.m6744i());
            if (g != null) {
                abVar.f2998i = g.f3111c;
            }
            C1392h.m6277a(this.f4709Q, abVar);
            C1744a a = C1744a.m8467a(abVar);
            if (a != null) {
                C2538c.m12674b("ChatActivity", "===========saveRecord -->modal is null,return");
                this.f4719c.add(a);
                if (!this.aj) {
                    C2538c.m12674b("ChatActivity", "后台没有获取完，新发的语音消息加入缓存");
                    this.f4722f.add(a);
                }
                a.f4772g = 2;
                a.f4777l = j + "";
                a.f4778m = j2 + "";
                m8394b(a);
                this.f4705M.m8494a(this.ae);
                m8370a(this.f4725i);
                return;
            }
            return;
        }
        C2538c.m12674b("ChatActivity", "===========saveRecord -->音频文件不存在");
    }

    private ab m8360a(String str, String str2) {
        if (this.f4700H.getVisibility() == 0) {
            this.f4700H.setVisibility(8);
        }
        ab abVar = new ab();
        abVar.f2993d = C1462f.m6744i();
        abVar.f2999j = C1492l.m6920d(C1462f.m6746j());
        abVar.f3000k = C1462f.m6744i();
        abVar.f2997h = str2;
        abVar.f2996g = System.currentTimeMillis() + "";
        abVar.f2990a = C1462f.m6746j();
        abVar.f2992c = getResources().getString(C1680l.IDS_plugin_kidwatch_chat_me);
        abVar.f3003n = true;
        abVar.f3006q = this.ad;
        abVar.f3002m = 2;
        abVar.f3007r = this.f4716X + "";
        abVar.f2994e = "1";
        abVar.f2995f = str.trim();
        C1397m g = C1392h.m6313g(this.f4709Q, C1462f.m6744i());
        if (g != null) {
            abVar.f2998i = g.f3111c;
        }
        C1392h.m6277a(this.f4709Q, abVar);
        this.f4705M.m8494a(this.ae);
        m8370a(this.f4725i);
        return abVar;
    }

    private void m8395b(String str) {
        FileInputStream fileInputStream;
        IOException e;
        IllegalStateException e2;
        Throwable th;
        C2538c.m12674b("ChatActivity", "playRecord enter,path:" + str);
        if (str != null) {
            if (this.f4707O == null) {
                this.f4707O = new MediaPlayer();
            }
            C1745b.m8476a(this.f4709Q, true);
            this.f4707O.reset();
            this.f4707O.setAudioStreamType(3);
            File file = new File(str);
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    if (file.exists()) {
                        this.f4707O.setDataSource(fileInputStream.getFD());
                        this.f4707O.setVolume(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                        this.f4707O.setOnCompletionListener(new C1767u(this));
                        this.f4707O.setOnErrorListener(new C1768v(this));
                        this.f4707O.prepare();
                        this.f4707O.start();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            C2538c.m12674b("ChatActivity", "==========fis.close() error!!! " + e3.getMessage());
                        }
                    }
                } catch (IllegalStateException e4) {
                    e2 = e4;
                    try {
                        C2538c.m12674b("ChatActivity", "==========playRecord error!!! " + e2.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e32) {
                                C2538c.m12674b("ChatActivity", "==========fis.close() error!!! " + e32.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                C2538c.m12674b("ChatActivity", "==========fis.close() error!!! " + e5.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e32 = e6;
                    C2538c.m12674b("ChatActivity", "==========playRecord error!!! " + e32.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e322) {
                            C2538c.m12674b("ChatActivity", "==========fis.close() error!!! " + e322.getMessage());
                        }
                    }
                }
            } catch (IllegalStateException e7) {
                e2 = e7;
                fileInputStream = null;
                C2538c.m12674b("ChatActivity", "==========playRecord error!!! " + e2.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e8) {
                e322 = e8;
                fileInputStream = null;
                C2538c.m12674b("ChatActivity", "==========playRecord error!!! " + e322.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
    }

    private void m8449s() {
        C2538c.m12674b("ChatActivity", "=======Enter stopPlay");
        try {
            if (this.f4707O != null && this.f4707O.isPlaying()) {
                this.f4707O.stop();
                this.f4707O.release();
                this.f4707O = null;
                C2538c.m12674b("ChatActivity", "stopPlay end");
            }
            for (C1744a c1744a : this.f4719c) {
                c1744a.f4774i = false;
            }
            this.f4705M.m8494a(this.ae);
        } catch (IllegalStateException e) {
            C2538c.m12674b("ChatActivity", "======stopPlay IllegalStateException exception:" + e.getMessage());
        }
    }

    private void m8394b(C1744a c1744a) {
        C2538c.m12674b("ChatActivity", "======Enter uploadFile");
        if (c1744a == null) {
            C2538c.m12674b("ChatActivity", "======modal is null,return");
            return;
        }
        C2538c.m12674b("ChatActivity", "uploadFile:" + c1744a.f4767b);
        new ar(this, c1744a).start();
    }

    private void m8383a(C1744a c1744a, int i) {
        C2538c.m12674b("ChatActivity", "=====Enter saveVoiceToCloudResult voiceStatus:" + i);
        if (c1744a == null) {
            C2538c.m12674b("ChatActivity", "=====saveVoiceToCloudResult mModal is null,return");
            return;
        }
        this.ay.post(new C1769w(this, c1744a, i));
    }

    private void m8384a(String str, String str2, String str3, C1744a c1744a) {
        C2538c.m12674b("ChatActivity", "====Enter addVoice  downLoadUrl:" + str);
        if (c1744a == null) {
            C2538c.m12674b("ChatActivity", "====null == mModel");
            return;
        }
        GetVoiceModel getVoiceModel = new GetVoiceModel();
        getVoiceModel.chatMessage.url = str;
        getVoiceModel.chatMessage.messageType = 0;
        getVoiceModel.chatMessage.key = str2;
        getVoiceModel.chatMessage.iv = str3;
        getVoiceModel.chatMessage.createTime = System.currentTimeMillis() / 1000;
        getVoiceModel.chatMessage.serverTime = 0;
        getVoiceModel.chatMessage.fromId = C1462f.m6744i();
        getVoiceModel.chatMessage.groupId = C1492l.m6920d(C1462f.m6746j());
        getVoiceModel.deviceCode = C1492l.m6920d(C1462f.m6746j());
        this.f4708P.mo2486a(getVoiceModel, new C1770x(this, c1744a));
    }

    private void m8405c(C1744a c1744a) {
        C2538c.m12674b("ChatActivity", "====Enter addText  ");
        GetVoiceModel getVoiceModel = new GetVoiceModel();
        getVoiceModel.chatMessage.messageType = 1;
        getVoiceModel.chatMessage.createTime = System.currentTimeMillis() / 1000;
        getVoiceModel.chatMessage.serverTime = 0;
        getVoiceModel.chatMessage.fromId = C1462f.m6744i();
        getVoiceModel.chatMessage.groupId = C1492l.m6920d(C1462f.m6746j());
        getVoiceModel.deviceCode = C1492l.m6920d(C1462f.m6746j());
        try {
            getVoiceModel.chatMessage.text = URLEncoder.encode(C1492l.m6924h(c1744a.f4785t), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("ChatActivity", "========编码失败");
            getVoiceModel.chatMessage.text = c1744a.f4785t;
        }
        C2538c.m12674b("ChatActivity", "========正常url编码：" + URLEncoder.encode(c1744a.f4785t), GameManager.DEFAULT_CHARSET);
        C2538c.m12674b("ChatActivity", "========转换后url编码：" + URLEncoder.encode(C1492l.m6924h(c1744a.f4785t)), GameManager.DEFAULT_CHARSET);
        this.f4708P.mo2486a(getVoiceModel, new C1771y(this, c1744a));
    }

    private void m8412d(C1744a c1744a) {
        C2538c.m12674b("ChatActivity", "=======Enter updateVoiceDb");
        if (c1744a == null) {
            C2538c.m12674b("ChatActivity", "=======updateVoiceDb model is null ,return");
            return;
        }
        C2538c.m12674b("ChatActivity", "=======model.toString: " + c1744a.toString());
        ab a = C1392h.m6268a(this.f4709Q, C1462f.m6744i(), C1462f.m6746j(), c1744a.f4767b);
        if (a != null) {
            a.f3002m = c1744a.f4772g;
            a.f3003n = c1744a.f4776k;
            C2538c.m12674b("ChatActivity", "=======table.status: " + a.f3002m);
            C1392h.m6277a(this.f4709Q, a);
            return;
        }
        C2538c.m12674b("ChatActivity", "=======更新数据库失败");
    }

    protected void onResume() {
        super.onResume();
        aa.m6204e();
        C2538c.m12674b("ChatActivity", "=======Enter onResume");
        m8439n();
        m8459x();
        aa = 0;
        m8453u();
        m8451t();
        m8334E();
        if (this.af && 1 != this.ae) {
            this.af = false;
            if (this.f4719c != null) {
                C2538c.m12674b("ChatActivity", "=======解鎖屏幕");
                this.f4719c.clear();
                this.f4705M.m8494a(this.ae);
            }
            this.ay.post(this.az);
        }
    }

    private void m8451t() {
        C2538c.m12674b("ChatActivity", "=======Enter cancleNotification");
        String b = C1497q.m6945b(this.f4709Q, "chat_group_id", C1462f.m6746j());
        C2538c.m12674b("ChatActivity", "=======notificationGroupid:" + b + " \ndeviceCode:" + C1462f.m6746j());
        if (b != null && b.equals(C1462f.m6746j())) {
            C1495o.m6928a(this.f4709Q, 11);
        }
    }

    private void m8453u() {
        C2538c.m12674b("ChatActivity", "=======Enter startCircle");
        if (ac) {
            C2538c.m12674b("ChatActivity", "=======isEmui return");
            return;
        }
        aa = 0;
        this.ay.removeCallbacks(this.aE);
        if (ab) {
            this.ay.postDelayed(this.aE, StatisticConfig.MIN_UPLOAD_INTERVAL);
            return;
        }
        C2538c.m12674b("ChatActivity", "=======not support chat");
    }

    private void m8455v() {
        C2538c.m12674b("ChatActivity", "=======Enter cancleCircle");
        this.ay.removeCallbacks(this.aE);
    }

    private int m8456w() {
        int i;
        switch (aa) {
            case 0:
                i = 30000;
                break;
            case 1:
                i = Constant.READ_TIMEOUT_TOS;
                break;
            case 2:
                i = 60000;
                break;
            case 3:
                i = SdkConstants.TIME_OUT;
                break;
            case 4:
                i = 180000;
                break;
            case 5:
                i = 240000;
                break;
            default:
                i = 480000;
                break;
        }
        aa++;
        C2538c.m12674b("ChatActivity", "=======getSpaceTime res:" + i);
        return i;
    }

    protected void onPause() {
        C2538c.m12674b("ChatActivity", "=======Enter onPause");
        m8447r();
        m8439n();
        super.onPause();
        if (!this.aj) {
            C2538c.m12674b("ChatActivity", "onPause,消息没有获取结束，需要停止数据库工作线程");
            aa.m6203d();
        }
    }

    public void onSaveClick(View view) {
        C2538c.m12674b("ChatActivity", "=======Enter onSaveClick");
    }

    private void m8459x() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.receiver.LoopVoiceReceiver");
        sendBroadcast(intent, "com.huawei.bone.permission.LOCAL_BROADCAST");
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        C2538c.m12674b("ChatActivity", "======Enter onStop");
        this.ay.removeCallbacks(this.at);
        m8447r();
        m8439n();
        m8449s();
        m8455v();
        m8334E();
        super.onStop();
    }

    protected void onDestroy() {
        C2538c.m12674b("ChatActivity", "======Enter onDestroy");
        m8455v();
        C1506g.m6979b();
        if (this.aF != null) {
            unregisterReceiver(this.aF);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.aD);
        super.onDestroy();
    }

    private String m8461y() {
        C2538c.m12674b("ChatActivity", "=====Enter getDirPath");
        File filesDir = getFilesDir();
        C2538c.m12674b("ChatActivity", "=====dirPath:" + (filesDir.getAbsolutePath() + File.separator + C1462f.m6746j()));
        return filesDir.getAbsolutePath() + File.separator + C1462f.m6746j();
    }

    private String m8400c(String str) {
        C2538c.m12674b("ChatActivity", "=====Enter getTmpRecordPath");
        C2538c.m12674b("ChatActivity", "=====Leave getTmpRecordPath filePath:" + (m8461y() + File.separator + str));
        return m8461y() + File.separator + str;
    }

    private String m8463z() {
        int intValue;
        C2538c.m12674b("ChatActivity", "=====Enter getNewRecordPath");
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String y = m8461y();
        int i = 0;
        for (C1744a c1744a : this.f4719c) {
            if (i <= c1744a.f4766a.intValue()) {
                intValue = c1744a.f4766a.intValue();
            } else {
                intValue = i;
            }
            i = intValue;
        }
        stringBuilder.append(y).append(File.separator).append(i + 1).append("_me_").append(System.currentTimeMillis() + "").append(simpleDateFormat.format(date)).append(".amr");
        C2538c.m12674b("ChatActivity", "=====Leave  getNewRecordPath " + stringBuilder.toString() + "\n msgId:" + intValue);
        return stringBuilder.toString();
    }

    private void m8326A() {
        C2538c.m12674b("ChatActivity", "=====Enter timer");
        if (this.f4729m == null) {
            this.f4729m = new Timer();
        } else {
            this.f4729m.cancel();
        }
        this.ai = 10;
        this.f4729m = new Timer();
        this.f4729m.schedule(new ac(this), 0, 1000);
    }

    private void m8328B() {
        C2538c.m12674b("ChatActivity", "=====Enter startRecordTimer");
        if (this.f4730n == null) {
            this.f4730n = new Timer();
        } else {
            this.f4730n.cancel();
        }
        this.f4730n = new Timer();
        this.f4730n.schedule(new ad(this), 10000);
    }

    private void m8330C() {
        if (this.f4729m != null) {
            this.f4729m.cancel();
            this.f4729m = null;
        }
        if (this.f4730n != null) {
            this.f4730n.cancel();
            this.f4730n = null;
        }
    }

    private void m8331D() {
        C2538c.m12674b("ChatActivity", "==enter  getBindUsers ");
        DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel = new DeviceBindUsersIOEntityModel();
        deviceBindUsersIOEntityModel.deviceCode = C1462f.m6746j();
        this.f4708P.mo2477a(deviceBindUsersIOEntityModel, new ag(this));
    }

    private void m8406c(List<UserInfo> list) {
        new ah(this, list).execute(new String[0]);
    }

    private synchronized void m8413d(List<UserInfo> list) {
        C2538c.m12674b("ChatActivity", "=====Enter updateDB");
        if (list != null && list.size() > 0) {
            C1392h.m6311f(this.f4709Q, C1462f.m6746j());
            for (UserInfo a : list) {
                C1392h.m6279a(this.f4709Q, a, C1462f.m6746j());
            }
        }
    }

    private void m8334E() {
        if (getCurrentFocus() != null && this.f4715W != null) {
            this.f4715W.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    private void m8369a(EditText editText) {
        C2538c.m12674b("ChatActivity", "=====Enter showKeyboard");
        if (editText != null) {
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        C2538c.m12674b("ChatActivity", "========Enter onKeyUp");
        if (i == 4) {
            if (1 == this.ae) {
                C2538c.m12674b("ChatActivity", "========Enter onKeyUp1");
                m8336F();
                return true;
            } else if (this.f4719c != null && this.f4719c.size() > 0) {
                int i2;
                for (C1744a c1744a : this.f4719c) {
                    if (2 == c1744a.f4772g) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 != 0) {
                    m8338G();
                    return true;
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    private void m8336F() {
        this.ae = 0;
        if (this.f4719c != null && this.f4719c.size() > 0) {
            for (C1744a c1744a : this.f4719c) {
                c1744a.f4786u = false;
                c1744a.f4787v = false;
            }
            this.f4705M.m8494a(this.ae);
        }
        m8397b(false);
        this.f4742z.setVisibility(0);
        this.f4693A.setVisibility(8);
        this.f4695C.setVisibility(8);
        this.f4714V.getBackBt().setVisibility(8);
    }

    private void m8338G() {
        C2538c.m12674b("ChatActivity", "=====Enter showGiveUpDialog");
        if (this.f4713U == null || !this.f4713U.isShowing()) {
            C1595v c1595v = new C1595v(this);
            c1595v.m7339a(C1680l.IDS_plugin_kidwatch_chat_back_title);
            c1595v.m7348b(C1680l.IDS_plugin_kidwatch_chat_back_message);
            c1595v.m7340a(C1680l.IDS_plugin_kidwatch_common_ok, new aj(this));
            c1595v.m7349b(C1680l.IDS_plugin_kidwatch_common_cancel, new ak(this));
            this.f4713U = c1595v.m7338a();
            this.f4713U.show();
            return;
        }
        C2538c.m12674b("ChatActivity", "=====Dialog已经显示，无需再次显示");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C2538c.m12674b("ChatActivity", "Activity-onRequestPermissionsResult()......");
        com.huawei.hwcommonmodel.d.a.b.a().a(strArr, iArr);
    }
}
