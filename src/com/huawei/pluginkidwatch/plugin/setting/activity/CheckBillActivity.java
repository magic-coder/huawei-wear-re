package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import cn.com.xy.sms.a.c;
import cn.com.xy.sms.a.f;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BalanceCommand;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1490j;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1388d;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.view.TextImgButton;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.plugin.setting.p167b.C1936a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckBillActivity extends KidWatchBaseActivity implements OnClickListener {
    private Handler f6291A = new Handler();
    private boolean f6292B = false;
    private String f6293C = "";
    private Runnable f6294D = new ab(this);
    private Runnable f6295E = new ac(this);
    private Runnable f6296F = new ad(this);
    Handler f6297b = new C1933x(this);
    f f6298c = new C1935z(this);
    f f6299d = new aa(this);
    private List<C1388d> f6300e;
    private List<C1388d> f6301f;
    private C1936a f6302g;
    private Context f6303h;
    private String f6304i = "";
    private C1413d f6305j;
    private ListView f6306k;
    private TextImgButton f6307l;
    private RelativeLayout f6308m;
    private LinearLayout f6309n;
    private RelativeLayout f6310o;
    private FrameLayout f6311p;
    private LinearLayout f6312q;
    private int f6313r = 10;
    private String f6314s = "";
    private String f6315t = "";
    private String f6316u = "";
    private C1388d f6317v = null;
    private long f6318w = 0;
    private LocalBroadcastManager f6319x;
    private BroadcastReceiver f6320y;
    private boolean f6321z = false;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_check_bill);
        this.f6303h = this;
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter initView ");
        m9805f();
        m9799d();
        m9803e();
        m9811i();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter onResume ");
        m9818m();
        C2538c.m12674b("CheckBillActivity", "=checkBill= onResume mCommond : " + this.f6293C);
        if (!this.f6293C.equals("")) {
            m9813j();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter onDestroy ");
        if (this.f6319x != null) {
            this.f6319x.unregisterReceiver(this.f6320y);
        }
        m9817l();
    }

    private void m9799d() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter initDB ");
        this.f6301f = C1392h.m6316i(this.f6303h, C1462f.m6746j());
        if (this.f6301f == null || this.f6301f.size() == 0) {
            C2538c.m12674b("CheckBillActivity", "=checkBill= tempListData is null or size = 0 ");
            m9809h();
            return;
        }
        if (this.f6301f.size() <= 20) {
            this.f6300e.addAll(this.f6301f);
        } else {
            this.f6300e.addAll(this.f6301f.subList(this.f6301f.size() - 20, this.f6301f.size()));
        }
        this.f6318w = C1492l.m6922f(((C1388d) this.f6300e.get(this.f6300e.size() - 1)).f3042c);
        C2538c.m12674b("CheckBillActivity", "=checkBill= lastDBtime" + this.f6318w);
        for (int i = 0; i < this.f6300e.size(); i++) {
            C2538c.m12674b("CheckBillActivity", "=checkBill= BillInfoTable 第 " + i + " 个 ：" + this.f6300e.get(i));
        }
        m9809h();
        this.f6302g.notifyDataSetChanged();
    }

    private void m9803e() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter getSimNum ");
        String str = null;
        if (C1462f.m6748k() != null) {
            str = C1462f.m6748k().f3093m;
        }
        if (str == null || str.isEmpty()) {
            this.f6304i = "";
            C2538c.m12674b("CheckBillActivity", "=checkBill=  getSimNum is null");
        } else {
            this.f6304i = C1462f.m6748k().f3093m.substring(0, 7);
        }
        C2538c.m12674b("CheckBillActivity", "=checkBill= phoneNum =" + this.f6304i);
    }

    public void onClick(View view) {
        if (g.bill_telephone_textview != view.getId()) {
            return;
        }
        if (!C1492l.m6916b(this.f6303h)) {
            C1483c.m6834d(this.f6303h, getResources().getString(C1680l.IDS_plugin_kidwatch_common_network_disable));
        } else if (this.f6321z) {
            this.f6297b.sendEmptyMessage(7);
        } else if (this.f6304i == null || this.f6304i.isEmpty()) {
            this.f6297b.sendEmptyMessage(8);
        } else {
            this.f6321z = true;
            this.f6297b.sendEmptyMessage(1);
            m9792a(this.f6314s, this.f6315t);
        }
    }

    private void m9805f() {
        this.f6307l = (TextImgButton) findViewById(g.bill_telephone_textview);
        this.f6308m = (RelativeLayout) findViewById(g.check_bill_listView_datas_rellay);
        this.f6309n = (LinearLayout) findViewById(g.check_bill_listView_not_datas_linlay);
        this.f6310o = (RelativeLayout) findViewById(g.feature_frame_not_support_check_bill);
        this.f6311p = (FrameLayout) findViewById(g.check_bill_frameLayout);
        this.f6312q = (LinearLayout) findViewById(g.bill_check_relay);
        this.f6307l.setOnClickListener(this);
        this.f6306k = (ListView) findViewById(g.check_bill_listView);
        if (getIntent() == null || !getIntent().getBooleanExtra("is_from_notification", false)) {
            this.f6292B = C1490j.m6890a("DMS_Balance");
        } else {
            C2538c.m12674b("CheckBillActivity", "=====Come from notification");
            this.f6292B = true;
            if (C1462f.m6746j() == null || "".equals(C1462f.m6746j())) {
                C2538c.m12674b("CheckBillActivity", "=====Go to home");
                Intent intent = new Intent();
                intent.setClass(this, HomeActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        }
        m9806g();
        this.f6305j = C1417a.m6594a(getApplicationContext());
        this.f6300e = new ArrayList();
        this.f6301f = new ArrayList();
        this.f6302g = new C1936a(this.f6303h, this.f6300e);
        this.f6306k.setAdapter(this.f6302g);
        this.f6306k.setItemsCanFocus(false);
        this.f6320y = new ae(this);
        IntentFilter intentFilter = new IntentFilter("com.huawei.pluginkidwatch.plugin.setting.ACTIVITY.CHECKBILLACTIVITY.HAVENEWBILL");
        this.f6319x = LocalBroadcastManager.getInstance(this);
        this.f6319x.registerReceiver(this.f6320y, intentFilter);
    }

    private void m9806g() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter isSupportBillCheck " + this.f6292B);
        if (this.f6292B) {
            this.f6310o.setVisibility(8);
            this.f6311p.setVisibility(0);
            this.f6312q.setVisibility(0);
            return;
        }
        this.f6310o.setVisibility(0);
        this.f6311p.setVisibility(8);
        this.f6312q.setVisibility(8);
    }

    private void m9809h() {
        if (!this.f6292B) {
            C2538c.m12674b("CheckBillActivity", "=checkBill=  customLocationRateSupport = false");
        } else if (this.f6300e == null || this.f6300e.size() <= 0) {
            C2538c.m12674b("CheckBillActivity", "=checkBill=  initRefreshView mBillInfoTables is null ");
            this.f6309n.setVisibility(0);
            this.f6308m.setVisibility(8);
        } else {
            C2538c.m12674b("CheckBillActivity", "=checkBill=  initRefreshView mBillInfoTables size = " + this.f6300e.size());
            this.f6308m.setVisibility(0);
            this.f6309n.setVisibility(8);
        }
    }

    private void m9811i() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter getBillCommond ");
        this.f6316u = C1462f.m6746j() + this.f6304i + "BILLCOMMOND";
        this.f6293C = C1497q.m6945b(this.f6303h, this.f6316u, "");
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_loading), false);
        C2538c.m12674b("CheckBillActivity", "=checkBill=  getBillCommond  Commond = " + this.f6293C);
        new Thread(new C1931v(this)).start();
    }

    private void m9813j() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= Enter getWatchStatus ");
        WatchStatusIOModel watchStatusIOModel = new WatchStatusIOModel();
        watchStatusIOModel.deviceCode = C1462f.m6746j();
        watchStatusIOModel.type = "1";
        C2538c.m12674b("CheckBillActivity", "=checkBill= getWatchStatus  model = " + watchStatusIOModel.toString());
        this.f6305j.mo2505a(watchStatusIOModel, new C1932w(this));
    }

    private void m9792a(String str, String str2) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= Enter sendCommand");
        C2538c.m12674b("CheckBillActivity", "=checkBill= send operateCode = " + str + " ; commandCode = " + str2);
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            this.f6297b.sendEmptyMessage(9);
            return;
        }
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        BalanceCommand balanceCommand = new BalanceCommand();
        balanceCommand.operateCode = str;
        balanceCommand.commandCode = str2;
        commonRetOModel.data = balanceCommand.toString();
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 16;
        this.f6305j.mo2473a(commonRetOModel, new C1934y(this));
    }

    private void m9814k() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= Enter getQueryOperatorCmd");
        this.f6291A.postDelayed(this.f6296F, 15000);
        if (C1492l.m6916b(this.f6303h)) {
            if (c.a(this.f6303h.getApplicationContext(), this.f6304i, "", null, this.f6298c) == null) {
                C2538c.m12674b("CheckBillActivity", "=checkBill= queryOperator   null");
                return;
            }
            C2538c.m12674b("CheckBillActivity", "=checkBill= queryOperator   [" + c.a(this.f6303h.getApplicationContext(), this.f6304i, "", null, this.f6298c).toString() + "]");
            return;
        }
        this.f6297b.sendEmptyMessage(5);
        C1506g.m6979b();
    }

    private void m9791a(String str) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= Enter getQueryOperatorMsg");
        if (C1492l.m6916b(this.f6303h)) {
            C2538c.m12674b("CheckBillActivity", "=checkBill=  getQueryOperatorMsg Msg = " + str + " ; mOperatorNum  : " + this.f6314s);
            this.f6291A.postDelayed(this.f6295E, 15000);
            if (c.a(this.f6303h.getApplicationContext(), "1", this.f6314s, "", str, 0, null, this.f6299d) == null) {
                C2538c.m12674b("CheckBillActivity", "=checkBill= getQueryOperatorMsg   null");
                return;
            }
            C2538c.m12674b("CheckBillActivity", "=checkBill= getQueryOperatorMsg   [" + c.a(this.f6303h.getApplicationContext(), "1", this.f6314s, "", str, 0, null, this.f6299d).toString() + "]");
            return;
        }
        this.f6297b.sendEmptyMessage(5);
    }

    private void m9817l() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= Enter stopTimer");
        this.f6321z = false;
        this.f6313r = 10;
        if (this.f6294D != null) {
            this.f6297b.removeCallbacks(this.f6294D);
        }
        if (this.f6295E != null) {
            this.f6291A.removeCallbacks(this.f6295E);
        }
        if (this.f6296F != null) {
            this.f6291A.removeCallbacks(this.f6296F);
        }
    }

    private void m9796b(String str) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter parseFromJson ");
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("actions")) {
                JSONArray jSONArray = new JSONArray(jSONObject.getString("actions"));
                str8 = str4;
                str7 = str3;
                str6 = str2;
                str4 = str5;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (!jSONObject2.isNull(SMSKeyInfo.TAG_KEY)) {
                        str6 = jSONObject2.getString(SMSKeyInfo.TAG_KEY);
                    }
                    if (!jSONObject2.isNull("targetTo")) {
                        str7 = jSONObject2.getString("targetTo");
                    }
                    if (!jSONObject2.isNull("type")) {
                        str8 = jSONObject2.getString("type");
                    }
                    if (!jSONObject2.isNull("value")) {
                        str4 = jSONObject2.getString("value");
                    }
                    C2538c.m12674b("CheckBillActivity", "=checkBill= parseFromJson actions key = " + str6 + " ;  type = " + str8 + " ; targetTo =" + str7 + " ; value = " + str4);
                    if (str6.equals("opBalance")) {
                        C2538c.m12674b("CheckBillActivity", "=checkBill= save SharePre shareKey targetTo =" + str7 + " ; value = " + str4);
                        this.f6314s = str7;
                        this.f6315t = str4;
                        C1497q.m6943a(this.f6303h, this.f6316u, str7 + "," + str4);
                        m9813j();
                        return;
                    }
                }
            } else if (!jSONObject.isNull("ADACTION")) {
                if (!jSONObject.isNull("op_balance_balance")) {
                    str6 = jSONObject.getString("op_balance_balance");
                }
                if (!jSONObject.isNull("op_balance_smsremain")) {
                    str7 = jSONObject.getString("op_balance_smsremain");
                }
                if (!jSONObject.isNull("op_balance_date")) {
                    str8 = jSONObject.getString("op_balance_date");
                }
                C2538c.m12674b("CheckBillActivity", "=checkBill= parseFromJson ADACTION  op_balance_balance =" + str6 + " ; op_balance_smsremain = " + str7 + " ; op_balance_date = " + str8);
                if (this.f6317v == null) {
                    this.f6297b.sendEmptyMessage(4);
                    return;
                }
                this.f6317v.f3043d = str6;
                this.f6317v.f3044e = str7;
                m9790a(this.f6317v);
            } else if (jSONObject.isNull("status")) {
                C2538c.m12680e("CheckBillActivity", "=checkBill= isNull(actions or ADACTION)");
                this.f6317v.f3043d = "";
                m9790a(this.f6317v);
            } else {
                str8 = jSONObject.getString("status");
                C2538c.m12680e("CheckBillActivity", "=checkBill= codeStatus : " + str8);
                if (str8 != null) {
                    if (str8.equals("201")) {
                        this.f6297b.sendEmptyMessage(10);
                    }
                    if (str8.equals("301")) {
                        this.f6297b.sendEmptyMessage(11);
                    }
                }
            }
            C2538c.m12674b("CheckBillActivity", "=checkBill=   mBillInfoTables.length = " + this.f6300e.size());
        } catch (JSONException e) {
            this.f6317v.f3043d = "";
            m9790a(this.f6317v);
            C2538c.m12680e("CheckBillActivity", "=checkBill= parseFromJson JSONException " + e.getMessage());
        }
    }

    private void m9818m() {
        C2538c.m12674b("CheckBillActivity", "=checkBill= Enter cancleNotification");
        if (C1492l.m6920d(C1462f.m6746j()) == C1492l.m6920d(C1497q.m6945b(this.f6303h, "notification_current_checkbill_devicecode", ""))) {
            C2538c.m12674b("CheckBillActivity", "=checkBill= deviceCode is fromNotif");
            String str = "";
            ArrayList i = C1392h.m6316i(this.f6303h, C1462f.m6746j());
            if (i != null && i.size() > 0) {
                this.f6318w = C1492l.m6922f(((C1388d) i.get(i.size() - 1)).f3042c);
                C2538c.m12674b("CheckBillActivity", "=checkBill= Enter cancleNotification lastDBtime : " + this.f6318w);
            }
            C1495o.m6928a(this.f6303h, 12);
            C1388d z = C1462f.m6766z();
            if (z != null) {
                long f = C1492l.m6922f(z.f3042c);
                long j = 0;
                if (this.f6300e != null && this.f6300e.size() > 0) {
                    j = C1492l.m6922f(((C1388d) this.f6300e.get(this.f6300e.size() - 1)).f3042c);
                }
                if (f > j) {
                    this.f6297b.obtainMessage(2, z).sendToTarget();
                } else {
                    return;
                }
            }
            return;
        }
        C1497q.m6943a(this.f6303h, "notification_current_checkbill_devicecode", "");
        C1462f.m6717a(null);
    }

    private void m9790a(C1388d c1388d) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= enter saveBillInfoTable");
        if (c1388d != null) {
            ArrayList i = C1392h.m6316i(this.f6303h, c1388d.f3046g);
            String str = "";
            String str2 = c1388d.f3042c;
            if (i != null && i.size() >= 1) {
                str = ((C1388d) i.get(i.size() - 1)).f3042c;
            }
            long f = C1492l.m6922f(str);
            long f2 = C1492l.m6922f(str2);
            C2538c.m12674b("CheckBillActivity", "=checkBill= saveBillInfoTable table : " + c1388d);
            C2538c.m12674b("CheckBillActivity", "=checkBill= saveBillInfoTable timeLong1 :  ; timeLong2 : " + f2);
            if (f < f2) {
                C1392h.m6281a(this.f6303h, c1388d);
                this.f6297b.obtainMessage(2, c1388d).sendToTarget();
            }
        }
    }
}
