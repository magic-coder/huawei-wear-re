package com.huawei.ui.device.activity.alarm;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.google.gson.Gson;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.activity.eventalarm.EventAlarmClockActivity;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.h;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1974b;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.views.p173b.C2189a;
import com.huawei.ui.device.views.p173b.C2190b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlarmActivity extends BaseActivity implements OnItemClickListener {
    private static final Object f7060B = new Object();
    private static long f7061q;
    private static String f7062r = "7:00";
    private static String f7063s = WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD;
    private static boolean f7064t = false;
    private int f7065A;
    private Handler f7066C = new C2025j(this, this);
    private Runnable f7067D = new C2016a(this);
    private OnCheckedChangeListener f7068E = new C2023h(this);
    private Context f7069a = null;
    private ListView f7070b = null;
    private LinearLayout f7071c = null;
    private ImageView f7072d = null;
    private LinearLayout f7073e = null;
    private TextView f7074f = null;
    private ScrollView f7075g = null;
    private TextView f7076h = null;
    private TextView f7077i = null;
    private Switch f7078j;
    private C1990r f7079k;
    private C1974b f7080l;
    private List<SmartAlarmInfo> f7081m = new ArrayList();
    private List<EventAlarmInfo> f7082n = new ArrayList();
    private List<C2190b> f7083o = new ArrayList();
    private C2189a f7084p = null;
    private SmartAlarmInfo f7085u;
    private int f7086v;
    private int f7087w;
    private int f7088x;
    private int f7089y;
    private int f7090z;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7069a = BaseApplication.m2632b();
        C2538c.m12677c("AlarmActivity", "onCreate()");
        setContentView(f.activity_alarm_black);
        this.f7079k = C1990r.m10400a(null);
        this.f7080l = C1974b.m10364a(null);
        m10584b();
        C2538c.m12677c("AlarmActivity", "==once== curSecond = " + Calendar.getInstance().get(13));
        this.f7066C.postDelayed(this.f7067D, (long) (60000 - ((r0 - 1) * 1000)));
        C2538c.m12677c("AlarmActivity", "==once== send message alarm time");
    }

    public void onClickEventAlarmSwitch(View view) {
        if (view != null) {
            Switch switchR;
            if (view instanceof Switch) {
                switchR = (Switch) view;
            } else {
                switchR = null;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (switchR != null) {
                C2538c.m12677c("AlarmActivity", "onClickEventAlarmSwitch() position = " + intValue + ",isChecked = " + switchR.isChecked());
                m10576a(intValue, r1);
            }
        }
    }

    private void m10576a(int i, boolean z) {
        C2538c.m12677c("AlarmActivity", "updateEventAlarm()");
        EventAlarmInfo eventAlarmInfo = (EventAlarmInfo) this.f7082n.get(i);
        if (z) {
            eventAlarmInfo.setEventAlarmEnable(1);
        } else {
            eventAlarmInfo.setEventAlarmEnable(0);
        }
        this.f7082n.set(i, eventAlarmInfo);
        this.f7079k.m10419a(this.f7082n, new C2017b(this));
        Message obtainMessage = this.f7066C.obtainMessage();
        obtainMessage.what = 104;
        this.f7066C.sendMessage(obtainMessage);
    }

    private void m10584b() {
        this.f7074f = (TextView) d.a(this, e.smart_alarm_time1);
        this.f7076h = (TextView) d.a(this, e.smart_alarm_day);
        this.f7073e = (LinearLayout) d.a(this, e.smart_alarm_text);
        this.f7078j = (Switch) d.a(this, e.smart_alarm_switch_button);
        this.f7077i = (TextView) d.a(this, e.alarm_bottom_tv);
        this.f7075g = (ScrollView) d.a(this, e.event_alarm_scrollview);
        this.f7075g.smoothScrollTo(0, 0);
        this.f7073e.setOnClickListener(new C2018c(this));
        this.f7070b = (ListView) d.a(this, e.event_alarm_list);
        this.f7070b.setOnItemClickListener(this);
        this.f7071c = (LinearLayout) d.a(this, e.event_alarm_bottom_add_layout);
        this.f7071c.setOnClickListener(new C2019d(this));
        this.f7072d = (ImageView) d.a(this, e.add_iv);
        this.f7077i.setText(String.format(this.f7069a.getString(i.IDS_settings_mult_alarm_clock_list_msg), new Object[]{C1990r.m10400a(this.f7069a).m10446j(), C1990r.m10400a(this.f7069a).m10446j()}));
    }

    private void m10586c() {
        m10590e();
        m10588d();
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12677c("AlarmActivity", "onResume()");
        m10586c();
    }

    private void m10588d() {
        this.f7079k.m10433c(new C2020e(this));
    }

    private void m10590e() {
        this.f7081m = this.f7079k.m10445i();
        C2538c.m12677c("AlarmActivity", "mSmartAlarmList.size()" + this.f7081m.size());
        if (this.f7081m.size() != 0) {
            this.f7085u = (SmartAlarmInfo) this.f7081m.get(0);
            this.f7086v = this.f7085u.getSmartAlarmIndex();
            this.f7087w = this.f7085u.getSmartAlarmEnable();
            this.f7088x = this.f7085u.getSmartAlarmStartTime_hour();
            this.f7089y = this.f7085u.getSmartAlarmStartTime_mins();
            this.f7090z = this.f7085u.getSmartAlarmRepeat();
            this.f7065A = this.f7085u.getSmartAlarmAheadTime();
            if (this.f7090z == 0 && 1 == this.f7087w) {
                this.f7087w = m10573a(this.f7085u);
            }
            C2538c.m12677c("AlarmActivity", "smartAlarmIndex =" + this.f7086v);
            C2538c.m12677c("AlarmActivity", "smartAlarmEnable =" + this.f7087w);
            C2538c.m12677c("AlarmActivity", "smartAlarmStartTime = " + ((this.f7088x * 100) + this.f7089y));
            C2538c.m12677c("AlarmActivity", "smartAlarmRepeat =" + this.f7090z);
            C2538c.m12677c("AlarmActivity", "smartAlarmAheadTime =" + this.f7065A);
            m10592f();
            return;
        }
        C2538c.m12677c("AlarmActivity", "getSmartAlarm() mSmartAlarmList == null or size = 0");
    }

    private int m10573a(SmartAlarmInfo smartAlarmInfo) {
        int i;
        int smartAlarmEnable = smartAlarmInfo.getSmartAlarmEnable();
        String a = C0996a.m3612a(this.f7069a, String.valueOf(10010), "ONCE_SMART_ALARM_INFO");
        C2538c.m12677c("AlarmActivity", "==once== onceSmartAlarmIsOver json = " + a);
        if (TextUtils.isEmpty(a)) {
            C2538c.m12679d("AlarmActivity", "==once== onceSmartAlarmIsOver json is null");
            i = smartAlarmEnable;
        } else {
            List list = (List) new Gson().fromJson(a, new C2021f(this).getType());
            i = smartAlarmEnable;
            for (int i2 = 0; i2 < list.size(); i2++) {
                SmartAlarmInfo smartAlarmInfo2 = (SmartAlarmInfo) list.get(i2);
                if (smartAlarmInfo2.getSmartAlarmIndex() == smartAlarmInfo.getSmartAlarmIndex()) {
                    C2538c.m12677c("AlarmActivity", "==once== CurTime = " + (System.currentTimeMillis() / 1000));
                    if (System.currentTimeMillis() / 1000 >= smartAlarmInfo2.getSmartAlarmTime()) {
                        i = 0;
                    }
                }
            }
        }
        C2538c.m12677c("AlarmActivity", "==once== onceSmartAlarmIsOver iRet = " + i);
        return i;
    }

    private void m10592f() {
        C2538c.m12677c("AlarmActivity", "enter updateSmartAlarmUI()");
        if (this.f7087w == 1) {
            f7064t = true;
        } else {
            f7064t = false;
        }
        this.f7078j.setChecked(f7064t);
        this.f7078j.setOnCheckedChangeListener(this.f7068E);
        C1974b c1974b = this.f7080l;
        f7062r = C1974b.m10365a(this.f7069a, (this.f7088x * 100) + this.f7089y);
        f7063s = C0956c.m3344a((double) this.f7065A, 1, 0);
        if ("0".equals(f7063s)) {
            this.f7074f.setText(String.format(this.f7069a.getString(i.IDS_settings_smart_time_detail_close), new Object[]{f7062r, f7063s}));
        } else {
            this.f7074f.setText(this.f7069a.getResources().getQuantityString(h.IDS_settings_smart_time_detail, C0977d.m3523a(f7063s), new Object[]{f7062r, f7063s}));
        }
        this.f7076h.setText(this.f7080l.m10366a(this.f7090z));
    }

    private void m10594g() {
        C2538c.m12677c("AlarmActivity", "updateEventAlarmUI()");
        this.f7079k.m10433c(new C2022g(this));
    }

    private void m10596h() {
        this.f7083o.clear();
        for (int i = 0; i < this.f7082n.size(); i++) {
            EventAlarmInfo eventAlarmInfo = (EventAlarmInfo) this.f7082n.get(i);
            C2190b c2190b = new C2190b();
            this.f7083o.add(c2190b.m11227a(c2190b, eventAlarmInfo, this.f7080l, this.f7069a));
        }
    }

    private void m10577a(Intent intent) {
        int i;
        C2538c.m12677c("AlarmActivity", "updateSmartAlarmUI()");
        int intExtra = intent.getIntExtra("smart_time", 0);
        int intExtra2 = intent.getIntExtra("week_day", 31);
        String stringExtra = intent.getStringExtra("ahead_time");
        if (this.f7069a.getString(i.IDS_settings_about_huawei_cloud_service_action_turn_off).equals(stringExtra)) {
            TextView textView = this.f7074f;
            String string = this.f7069a.getString(i.IDS_settings_smart_time_detail_close);
            r6 = new Object[2];
            C1974b c1974b = this.f7080l;
            r6[0] = C1974b.m10365a(this.f7069a, intExtra);
            r6[1] = stringExtra;
            textView.setText(String.format(string, r6));
            i = 0;
        } else {
            i = Integer.parseInt(stringExtra);
            String a = C0956c.m3344a((double) i, 1, 0);
            Resources resources = this.f7069a.getResources();
            int i2 = h.IDS_settings_smart_time_detail;
            int a2 = C0977d.m3523a(a);
            r8 = new Object[2];
            C1974b c1974b2 = this.f7080l;
            r8[0] = C1974b.m10365a(this.f7069a, intExtra);
            r8[1] = a;
            this.f7074f.setText(resources.getQuantityString(i2, a2, r8));
        }
        this.f7076h.setText(this.f7080l.m10366a(intExtra2));
        this.f7088x = intExtra / 100;
        this.f7089y = intExtra % 100;
        if (this.f7085u != null) {
            this.f7085u.setSmartAlarmAheadTime(i);
            this.f7085u.setSmartAlarmEnable(1);
            this.f7085u.setSmartAlarmRepeat(intExtra2);
            this.f7085u.setSmartAlarmStartTime_hour(this.f7088x);
            this.f7085u.setSmartAlarmStartTime_mins(this.f7089y);
            C2538c.m12677c("AlarmActivity", "updateSmartAlarmUI() update mSmartAlarmInfo finish!");
        }
        this.f7078j.setChecked(true);
    }

    private void m10597i() {
        C2538c.m12677c("AlarmActivity", "addButtonClick()");
        if (this.f7083o == null) {
            C2538c.m12680e("AlarmActivity", "addButtonClick() mEventAlarmItemList == null");
            return;
        }
        C2538c.m12677c("AlarmActivity", "addButtonClick() mEventAlarmItemList.size() = " + this.f7083o.size());
        if (this.f7083o.size() < 5) {
            Intent intent = new Intent(this.f7069a, EventAlarmClockActivity.class);
            intent.putExtra("from_add_button", true);
            startActivityForResult(intent, 0);
        } else if (!m10580a(3000)) {
            C2538c.m12677c("AlarmActivity", "addButtonClick() Can't greater than 5");
        }
    }

    public static boolean m10580a(long j) {
        boolean z;
        synchronized (f7060B) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f7061q < j) {
                z = true;
            } else {
                f7061q = currentTimeMillis;
                z = false;
            }
        }
        return z;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12677c("AlarmActivity", "onItemClick: position = " + i);
        if (this.f7083o == null || this.f7083o.size() == 0) {
            C2538c.m12677c("AlarmActivity", "mEventAlarmItemList.size() == 0 or mEventAlarmItemList is null");
            return;
        }
        C2538c.m12677c("AlarmActivity", "onItemClick: mEventAlarmItemList.size() = " + this.f7083o.size());
        if (i < this.f7083o.size()) {
            C2538c.m12677c("AlarmActivity", "mEventAlarmItemList.get(position)" + this.f7083o.get(i));
            C2538c.m12677c("AlarmActivity", "item ==" + r0.m11234c() + "----" + r0.m11237d() + "---" + ((C2190b) this.f7083o.get(i)).m11239e());
            Intent intent = new Intent(this.f7069a, EventAlarmClockActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("from_list_item", r0);
            intent.putExtras(bundle);
            startActivityForResult(intent, 0);
            return;
        }
        C2538c.m12680e("AlarmActivity", "position error");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12677c("AlarmActivity", "onActivityResult requestCode = " + i + ",resultCode = " + i2);
        switch (i2) {
            case 10:
                m10577a(intent);
                return;
            case 11:
                m10594g();
                return;
            default:
                return;
        }
    }

    protected void onStop() {
        super.onStop();
        this.f7066C.removeMessages(100);
        this.f7066C.removeMessages(102);
        this.f7066C.removeMessages(104);
        C2538c.m12677c("AlarmActivity", "==once== onStop");
    }

    protected void onDestroy() {
        C0977d.m3575n(this.f7069a);
        super.onDestroy();
        this.f7066C.removeMessages(100);
        this.f7066C.removeMessages(102);
        this.f7066C.removeMessages(104);
        this.f7066C.removeCallbacks(this.f7067D);
        C2538c.m12677c("AlarmActivity", "==once== onDestroy");
    }
}
