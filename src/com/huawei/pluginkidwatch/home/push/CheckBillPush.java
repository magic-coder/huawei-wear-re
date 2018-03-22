package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import cn.com.xy.sms.a.c;
import cn.com.xy.sms.a.f;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1388d;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.home.push.bean.BanlanceBean;
import com.huawei.pluginkidwatch.plugin.setting.activity.CheckBillActivity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckBillPush implements IPushProcess {
    private static final int GET_REQUEST_TIMES = 15000;
    private static final String SHAREKEY = "BILLCOMMOND";
    private static final String TAG = "CheckBillPush";
    private boolean isShow = false;
    private BanlanceBean mBanlanceBean = new BanlanceBean();
    private C1388d mBillInfoTable = null;
    private Context mContext;
    private Gson mGson = new Gson();
    private String mMsg = null;
    private String mOperatorNum = "";
    private String mPhoneNum = null;
    private Handler requestHandler = null;
    private Runnable requestRunnable = new C16632();
    private String shareKey = "";

    class C16621 implements f {
        C16621() {
        }

        public void execute(Object... objArr) {
            C2538c.m12674b(CheckBillPush.TAG, "=checkBill= OperatorMsg callback method [" + objArr[0] + "]\t [" + objArr[1] + "]\n");
            if (objArr[1] == null || objArr[1].toString().isEmpty()) {
                C2538c.m12674b(CheckBillPush.TAG, "=checkBill= mOperatorMsgCallBack   null");
                return;
            }
            C2538c.m12674b(CheckBillPush.TAG, "=checkBill= mOperatorMsgCallBack   [" + objArr[1].toString() + "]");
            CheckBillPush.this.parseFromJson(objArr[1].toString());
        }
    }

    class C16632 implements Runnable {
        C16632() {
        }

        public void run() {
            C2538c.m12674b(CheckBillPush.TAG, "=checkBill= requestRunnable ");
            CheckBillPush.this.freshUI(CheckBillPush.this.mBillInfoTable);
        }
    }

    public void processPushMsg(Context context, String str, boolean z) {
        this.mContext = context;
        this.isShow = z;
        C2538c.m12674b(TAG, "=checkBill= enter processPushMsg strMsg : " + str + " ; show : " + z);
        this.requestHandler = new Handler(context.getMainLooper());
        if (str == null || str.length() <= 0) {
            C2538c.m12674b("=checkBill= processPushMsg strMsg is null", new Object[0]);
            return;
        }
        try {
            this.mBanlanceBean = (BanlanceBean) this.mGson.fromJson(str, BanlanceBean.class);
            String str2 = "";
            if (this.mBanlanceBean != null) {
                str2 = C1392h.m6269a(this.mContext, C1093a.m4739a(this.mContext).m4750c(), this.mBanlanceBean.deviceCode).f3093m;
                C2538c.m12674b(TAG, "=checkBill= number : " + str2);
                if (!(str2 == null || str2.isEmpty())) {
                    this.mPhoneNum = str2.substring(0, 7);
                    this.shareKey = this.mBanlanceBean.deviceCode + this.mPhoneNum + SHAREKEY;
                    str2 = C1497q.m6945b(this.mContext, this.shareKey, "");
                    C2538c.m12674b(TAG, "=checkBill=  getBillCommond  Commond = " + str2);
                    if (!str2.equals("")) {
                        this.mOperatorNum = str2.split(",")[0];
                        C2538c.m12674b(TAG, "=checkBill=  getBillCommond  mOperatorNum =  " + this.mOperatorNum);
                    }
                }
                C2538c.m12674b(TAG, "=checkBill= phoneNum =" + this.mPhoneNum);
                this.mBillInfoTable = new C1388d();
                this.mBillInfoTable.f3046g = this.mBanlanceBean.deviceCode;
                this.mBillInfoTable.f3041b = this.mBanlanceBean.data.balanceMessage;
                this.mBillInfoTable.f3042c = this.mBanlanceBean.data.time;
                this.mMsg = this.mBanlanceBean.data.balanceMessage;
                C2538c.m12674b(TAG, "=checkBill=  processPushMsg  mMsg  : " + this.mMsg + ";  mPhoneNum : " + this.mPhoneNum + ";  mOperatorNum : " + this.mOperatorNum + ";  mPhoneNum : " + this.mPhoneNum);
                if (this.mMsg == null || this.mMsg.isEmpty() || this.mPhoneNum == null || this.mPhoneNum.isEmpty() || this.mOperatorNum == null || this.mOperatorNum.isEmpty()) {
                    freshUI(this.mBillInfoTable);
                } else {
                    getQueryOperatorMsg();
                }
            }
        } catch (JsonSyntaxException e) {
            C2538c.m12674b("=checkBill= processPushMsg 解析查话费通知发生异常 e = " + e.getMessage(), new Object[0]);
        }
    }

    private void getQueryOperatorMsg() {
        C2538c.m12674b(TAG, "=checkBill= Enter getQueryOperatorMsg Msg = " + this.mMsg);
        C2538c.m12674b(TAG, "=checkBill= Enter getQueryOperatorMsg mContext.getApplicationContext() = " + this.mContext.getApplicationContext() + " ; mPhoneNum : " + this.mPhoneNum + " ; mMsg : " + this.mMsg);
        this.requestHandler.postDelayed(this.requestRunnable, 15000);
        JSONObject a = c.a(this.mContext.getApplicationContext(), "1", this.mOperatorNum, "", this.mMsg, 0, null, new C16621());
        if (a == null || a.toString().isEmpty()) {
            C2538c.m12674b(TAG, "=checkBill= getQueryOperatorMsg   null");
            return;
        }
        C2538c.m12674b(TAG, "=checkBill= getQueryOperatorMsg   [" + a.toString() + "]");
    }

    private void parseFromJson(String str) {
        C2538c.m12674b(TAG, "=checkBill= enter parseFromJson ");
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("ADACTION")) {
                C2538c.m12680e(TAG, "=checkBill= isNull(actions or ADACTION)");
                this.mBillInfoTable.f3043d = "";
                freshUI(this.mBillInfoTable);
                return;
            }
            if (!jSONObject.isNull("op_balance_balance")) {
                str2 = jSONObject.getString("op_balance_balance");
            }
            if (!jSONObject.isNull("op_balance_smsremain")) {
                str3 = jSONObject.getString("op_balance_smsremain");
            }
            if (!jSONObject.isNull("op_balance_date")) {
                str4 = jSONObject.getString("op_balance_date");
            }
            C2538c.m12674b(TAG, "=checkBill= parseFromJson ADACTION  op_balance_balance =" + str2 + " ; op_balance_smsremain = " + str3 + " ; op_balance_date = " + str4);
            this.mBillInfoTable.f3043d = str2;
            this.mBillInfoTable.f3044e = str3;
            freshUI(this.mBillInfoTable);
        } catch (JSONException e) {
            C2538c.m12680e(TAG, "=checkBill= parseFromJson JSONException " + e.getMessage());
            freshUI(this.mBillInfoTable);
        }
    }

    private void freshUI(C1388d c1388d) {
        C2538c.m12674b(TAG, "=checkBill= enter freshUI");
        if (c1388d == null) {
            C2538c.m12674b(TAG, "=checkBill= saveBillInfoTable table : null");
            return;
        }
        ArrayList i = C1392h.m6316i(this.mContext, c1388d.f3046g);
        String str = "";
        String str2 = c1388d.f3042c;
        if (i != null && i.size() >= 1) {
            if (C1392h.m6291b(this.mContext, c1388d) != null) {
                C2538c.m12674b(TAG, "=checkBill= saveBillInfoTable 本地已保存该数据 : " + c1388d.f3042c + " dataBytiem size : " + r0.f3042c);
                return;
            }
            str = ((C1388d) i.get(i.size() - 1)).f3042c;
        }
        long f = C1492l.m6922f(str);
        long f2 = C1492l.m6922f(str2);
        C2538c.m12674b(TAG, "=checkBill= saveBillInfoTable timeLong1 : " + f + " ; timeLong2 : " + f2);
        if (f > f2) {
            c1388d.f3042c = (f + 1) + "";
        }
        C1392h.m6281a(this.mContext, c1388d);
        if (this.requestRunnable != null) {
            this.requestHandler.removeCallbacks(this.requestRunnable);
        }
        str2 = String.format(this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_settings_check_bill_main_push_message), new Object[]{this.mBanlanceBean.name});
        if (this.mBanlanceBean.deviceCode.equals(C1462f.m6746j())) {
            if (CheckBillActivity.class.getName().equals(C1492l.m6907a(this.mContext))) {
                C2538c.m12674b(TAG, "=checkBill= 发送广播告知有新短信");
                C1462f.m6717a(this.mBillInfoTable);
                Intent intent = new Intent();
                intent.setAction("com.huawei.pluginkidwatch.plugin.setting.ACTIVITY.CHECKBILLACTIVITY.HAVENEWBILL");
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
            } else if (this.isShow) {
                C1495o.m6930a(this.mContext, CheckBillActivity.class, str2, this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), str2, 12, new int[0]);
            }
            try {
                C1497q.m6943a(this.mContext, "notification_current_checkbill_devicecode", this.mBanlanceBean.deviceCode);
                C1462f.m6717a(this.mBillInfoTable);
            } catch (Exception e) {
                C2538c.m12680e(TAG, "=checkBill= Exception e = " + e.getMessage());
            }
        } else if (C1492l.m6919c(this.mBanlanceBean.deviceCode)) {
            C2538c.m12674b(TAG, "=checkBill= processPushMsg 和当前devicecode不相同，进home");
            if (this.isShow) {
                C1495o.m6930a(this.mContext, HomeActivity.class, str2, this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), str2, 12, C1492l.m6920d(this.mBanlanceBean.deviceCode));
            }
        } else {
            C2538c.m12674b(TAG, "=checkBill= processPushMsg Receive wrong push");
        }
    }
}
