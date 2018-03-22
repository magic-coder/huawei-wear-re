package com.huawei.nfc.carrera.ui.bus.detail;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClient.Builder;
import com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.pay.HuaweiPay;
import com.huawei.hms.support.api.pay.PayResult;
import com.huawei.hms.support.api.pay.PayResultInfo;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.RechargeMoney;
import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.ApplyPayOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RefundCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.wxpay.WXPayCallback;
import com.huawei.nfc.carrera.logic.wxpay.WXPayManager;
import com.huawei.nfc.carrera.ui.bus.BusBaseActivity;
import com.huawei.nfc.carrera.ui.bus.detail.SelectPayMethodFragment.PayMethodCallback;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.ui.bus.util.TimeUtil;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.ui.util.UiUtil;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.ui.commonui.dialog.ae;
import com.huawei.ui.commonui.dialog.af;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.PackageUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscardRechargeAcitvity extends BusBaseActivity implements OnClickListener, ConnectionCallbacks, OnConnectionFailedListener, QueryTrafficCardInfoCallback, ApplyPayOrderCallback, QueryAndHandleUnfinishedOrderCallback, RechargeCallback, RefundCallback, WXPayCallback, PayMethodCallback {
    static final String EXTRA_KEY_CARD_ISSUERID = "traffic_card_issuerId";
    static final String EXTRA_KEY_CARD_PRODUCTD = "traffic_card_productId";
    private static final String EXTRA_RESULT = "intent.extra.RESULT";
    private static String FRAGMENT_TAG_SELECT = "select_fragment_recharge";
    private static final int HANDLER_EVENT_PAY_NOT_CONNECTED = 103;
    protected static final int HANDLER_EVENT_PAY_RESULT = 101;
    protected static final int HANDLER_EVENT_PAY_START = 100;
    private static final int HANDLER_ONWINDOW_FOCUSCHANGED_WAIT = 104;
    private static final String PACKAGE_NAME_WECHAT = "com.tencent.mm";
    protected static final int RECHARGE_FAIL_REQUESTCODE = 105;
    private static final int REQUEST_RESOLVE_ERROR = 102;
    private static final String TAG = "PluginPay BuscardRechargeAcitvity";
    private static SparseIntArray sErrorCodeTable = new SparseIntArray();
    private ArrayList<Button> btnRechargeList;
    private af dialogBuilder = null;
    private boolean isFinish = false;
    private boolean isFromWindow = false;
    private boolean isHasUnfinfishedOrders = false;
    private boolean isRechargeable;
    private ImageView mCardImageView;
    private HuaweiApiClient mHuaweiApiClient;
    private String mIssuerId;
    private String mMoneyLabel;
    private int mNormalRechargeAmountTextColor;
    private String mProductId;
    private boolean mResolvingError = false;
    private SelectPayMethodFragment mSelectPayMethodFragment;
    private int mSelectedRechargeAmountTextColor;
    private TrafficCardInfo mTrafficCardInfo;
    private ae noteDialog = null;
    private double payAmount;
    private Handler payhandler = new C56214();
    private RechargeMoney rechargeMoney;
    private int rechargeWidth;
    private TextView textPayAmount;
    private TrafficOrder trafficOrder;

    class C56181 implements OnCancelListener {
        C56181() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            LogX.i("PluginPay BuscardRechargeAcitvityonCreate, cancel queryRechargeMoney");
        }
    }

    class C56192 implements OnClickListener {
        C56192() {
        }

        public void onClick(View view) {
        }
    }

    class C56203 implements ResultCallback<PayResult> {
        C56203() {
        }

        public void onResult(PayResult payResult) {
            Status status = payResult.getStatus();
            C2538c.c(BuscardRechargeAcitvity.TAG, new Object[]{"applyIssueOrderCallback, apply status : " + status});
            if (status.getStatusCode() == 0) {
                try {
                    status.startResolutionForResult(BuscardRechargeAcitvity.this, 101);
                } catch (SendIntentException e) {
                    C2538c.e("hwpay", new Object[]{"SendIntentException e"});
                }
            }
        }
    }

    class C56214 extends Handler {
        C56214() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    BuscardRechargeAcitvity.this.startPay(BuscardRechargeAcitvity.this.trafficOrder);
                    return;
                case 103:
                    BuscardRechargeAcitvity.this.showToast(R.string.nfc_bus_card_pay_fail);
                    return;
                case 104:
                    BuscardRechargeAcitvity.this.onWindowFocusChangedWait();
                    return;
                default:
                    return;
            }
        }
    }

    class C56225 implements OnClickListener {
        C56225() {
        }

        public void onClick(View view) {
            BuscardRechargeAcitvity.this.finish();
        }
    }

    static {
        sErrorCodeTable.append(1003, R.string.nfc_bus_card_recharge_failed_balance_is_minus);
        sErrorCodeTable.append(1001, R.string.nfc_bus_card_balance_reach_limit);
        sErrorCodeTable.append(1005, R.string.nfc_bus_offline_card_after_expire_date_error);
        sErrorCodeTable.append(1004, R.string.nfc_bus_offline_card_date_error);
        sErrorCodeTable.append(1006, R.string.nfc_bus_offline_card_date_error);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R.layout.nfc_activity_buscard_recharge);
        if (initParams()) {
            init();
            return;
        }
        LogX.e("PluginPay BuscardRechargeAcitvityinitParams failed!");
        finish();
    }

    protected void onStart() {
        super.onStart();
        initHMS();
        int isHuaweiMobileServicesAvailable = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this);
        C2538c.c(TAG, new Object[]{"onStart, isAvaiable: " + isHuaweiMobileServicesAvailable});
        if (isHuaweiMobileServicesAvailable != 0) {
            HuaweiApiAvailability instance = HuaweiApiAvailability.getInstance();
            if (instance.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                this.mResolvingError = true;
                instance.resolveError(this, isHuaweiMobileServicesAvailable, 102);
            }
        } else if (!this.mHuaweiApiClient.isConnecting() && !this.mHuaweiApiClient.isConnected()) {
            this.mHuaweiApiClient.connect();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.noteDialog != null) {
            this.noteDialog.dismiss();
            this.dialogBuilder = null;
            this.noteDialog = null;
        }
    }

    public void initHMS() {
        this.mHuaweiApiClient = new Builder(getApplicationContext()).addApi(HuaweiPay.PAY_API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        this.mIssuerId = intent.getStringExtra("traffic_card_issuerId");
        this.mProductId = intent.getStringExtra("traffic_card_productId");
        if (!StringUtil.isEmpty(this.mIssuerId, true) && !StringUtil.isEmpty(this.mProductId, true)) {
            return true;
        }
        LogX.e("PluginPay BuscardRechargeAcitvityinitParams, illegal params");
        return false;
    }

    protected void init() {
        super.init();
        setTitle(R.string.nfc_buscard_recharge_title);
        this.mCardImageView = (ImageView) findViewById(R.id.buscard_recharge_card_res);
        this.btnRechargeList = new ArrayList();
        this.btnRechargeList.add((Button) findViewById(R.id.buscard_recharge_amount_1));
        this.btnRechargeList.add((Button) findViewById(R.id.buscard_recharge_amount_2));
        this.btnRechargeList.add((Button) findViewById(R.id.buscard_recharge_amount_3));
        this.btnRechargeList.add((Button) findViewById(R.id.buscard_recharge_amount_4));
        this.btnRechargeList.add((Button) findViewById(R.id.buscard_recharge_amount_5));
        this.btnRechargeList.add((Button) findViewById(R.id.buscard_recharge_amount_6));
        this.rechargeWidth = (getResources().getDisplayMetrics().widthPixels - (((int) getResources().getDimension(R.dimen.nfc_bus_recharge_margin)) * 6)) / 3;
        for (int i = 0; i < this.btnRechargeList.size(); i++) {
            ((Button) this.btnRechargeList.get(i)).setVisibility(8);
            ((Button) this.btnRechargeList.get(i)).setOnClickListener(this);
        }
        Button button = (Button) findViewById(R.id.buscard_recharge_do_recharge);
        button.setOnClickListener(this);
        UiUtil.setOrangeButtonBackground(this, button);
        this.textPayAmount = (TextView) findViewById(R.id.buscard_recharge_pay_amount_tv);
        this.mMoneyLabel = getString(R.string.nfc_money_type);
        this.mSelectedRechargeAmountTextColor = getResources().getColor(R.color.white);
        this.mNormalRechargeAmountTextColor = getResources().getColor(R.color.buscard_money_text_color);
        showLoadingDialog(R.string.nfc_loading, true, new C56181());
        WXPayManager.getInstance().setRequest(false);
        this.cardInfoManager.queryTrafficCardInfo(this.mIssuerId, 2, "", this);
    }

    public void onClick(View view) {
        boolean z = true;
        int id = view.getId();
        if (R.id.buscard_recharge_amount_1 == id || R.id.buscard_recharge_amount_2 == id || R.id.buscard_recharge_amount_3 == id || R.id.buscard_recharge_amount_4 == id || R.id.buscard_recharge_amount_5 == id || R.id.buscard_recharge_amount_6 == id) {
            this.rechargeMoney = (RechargeMoney) view.getTag();
            if (this.rechargeMoney.getPayMoney() <= 0.0d) {
                z = false;
            }
            this.isRechargeable = z;
            this.textPayAmount.setText(MoneyUtil.changeIntoDisplayMoney(this.mMoneyLabel, this.rechargeMoney.getPayMoney()));
            this.payAmount = this.rechargeMoney.getPayMoney();
            refreshRechargeBtn(id);
        } else if (R.id.buscard_recharge_do_recharge != id) {
        } else {
            if (TimeUtil.isFastDoubleClick()) {
                LogX.e("PluginPay BuscardRechargeAcitvityonClick, isFastDoubleClick");
            } else if (this.isRechargeable) {
                boolean z2;
                if (this.mTrafficCardInfo != null && this.mTrafficCardInfo.isWxPaySupport() && 14 == this.mTrafficCardInfo.getMode()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                LogX.i("onClick, recharge card isSh : " + z2 + " ; TrafficCardInfo : " + this.mTrafficCardInfo);
                if (z2) {
                    requestShOrder();
                    return;
                }
                showLoadingDialog(R.string.nfc_loading, false, null);
                if (Constant.TFTONG_CARD_ISSERID.equals(this.mIssuerId)) {
                    this.rechargeMoney.setPayMoney((double) MoneyUtil.convertYuanToFen(String.valueOf(this.rechargeMoney.getPayMoney())));
                    this.rechargeMoney.setRechargeMoney((double) MoneyUtil.convertYuanToFen(String.valueOf(this.rechargeMoney.getRechargeMoney())));
                    ApplyOrderInfo applyOrderInfo = new ApplyOrderInfo(2, this.rechargeMoney);
                    applyOrderInfo.setRechargePayment(this.rechargeMoney);
                    this.cardOperateLogicManager.applyPayOrder(this.mIssuerId, applyOrderInfo, this);
                    return;
                }
                this.cardOperateLogicManager.applyPayOrder(this.mIssuerId, this.payAmount, 2, 1, "", this);
            } else {
                showErrorDialog(getString(R.string.nfc_get_recharge_amount_failed));
            }
        }
    }

    private void refreshRechargeBtn(int i) {
        for (int i2 = 0; i2 < this.btnRechargeList.size(); i2++) {
            Button button = (Button) this.btnRechargeList.get(i2);
            if (i == button.getId()) {
                button.setBackgroundResource(R.drawable.nfc_buscard_recharge_bg);
                button.setTextColor(this.mSelectedRechargeAmountTextColor);
            } else {
                button.setBackgroundResource(R.drawable.nfc_buscard_recharge_normal_bg);
                button.setTextColor(this.mNormalRechargeAmountTextColor);
            }
        }
    }

    public void rechargeCallback(int i) {
        if (isFinishing()) {
            LogX.i(TAG, "rechargeCallback failed. activity finished.");
            return;
        }
        destroyLoadingDialog();
        LogX.i(TAG, "rechargeCallback, resultCode=" + i);
        if (i == 0) {
            showToast(R.string.nfc_bus_card_recharge_success);
            setResult(-1);
            finish();
            return;
        }
        LogX.e("PluginPay BuscardRechargeAcitvityrechargeCallback, recharge failed");
        String str = "";
        if (this.mTrafficCardInfo != null) {
            str = this.mTrafficCardInfo.getAid();
        }
        if (i == 1301 || i == RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE || i == RechargeCallback.RETURN_RECHARGE_REACH_LIMIT_REFUNDABLE) {
            jump2ResultActivity(getString(R.string.nfc_bus_card_recharge_fail_dialog_content), getErrorMessage(i), 1, this.mIssuerId, str, 0, false, false);
        } else {
            jump2ResultActivity(getString(R.string.nfc_bus_card_recharge_fail_dialog_content), getString(R.string.nfc_recharge_fail), 1, this.mIssuerId, str, 0, true, false);
        }
    }

    public void applyPayOrderCallback(int i, TrafficOrder trafficOrder) {
        destroyLoadingDialog();
        LogX.i("PluginPay BuscardRechargeAcitvityapplyRechargeOrderCallback, resultCode=" + i);
        if (i != 0 || trafficOrder == null) {
            LogX.e("PluginPay BuscardRechargeAcitvityapplyRechargeOrderCallback, apply failed");
            LogX.e("PluginPay BuscardRechargeAcitvityapplyRechargeOrderCallback, apply failed");
            showErrorDialog(getErrorMessage(i));
            return;
        }
        this.trafficOrder = trafficOrder;
        this.payhandler.sendEmptyMessage(100);
    }

    private void showErrorDialog(String str) {
        C6022u a = new C6024w(this.mContext).m27591a(R.string.nfc_card_list_dialog_title).m27598b(str).m27593a(R.string.nfc_cvv_code_introduction_ok, new C56192()).m27590a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    protected boolean handleCommonErrorCode(int i) {
        if (super.handleCommonErrorCode(i)) {
            return true;
        }
        int i2 = sErrorCodeTable.get(i, 0);
        if (i2 == 0) {
            return false;
        }
        showToast(i2);
        return true;
    }

    protected void startPay(TrafficOrder trafficOrder) {
        C2538c.c(TAG, new Object[]{" order PayType  " + trafficOrder.getPayType() + " ; order WxPayInfo : " + trafficOrder.getWxPayInfo()});
        if (trafficOrder.getPayType() != 2 || trafficOrder.getWxPayInfo() == null) {
            startHWPay(trafficOrder);
        } else if (!WXPayManager.getInstance().pay(trafficOrder.getWxPayInfo(), this)) {
            LogX.e("applyRechargeOrderCallback, wxpay is fail");
            WXPayManager.getInstance().setRequest(false);
        }
    }

    private void startHWPay(TrafficOrder trafficOrder) {
        if (this.mHuaweiApiClient.isConnected()) {
            asyncCallPay(trafficOrder);
            return;
        }
        C2538c.c(TAG, new Object[]{"Connect failed, please connect first."});
        this.payhandler.sendEmptyMessage(103);
        this.mHuaweiApiClient.connect();
    }

    private void asyncCallPay(TrafficOrder trafficOrder) {
        PayReq makePayReq = trafficOrder.getPayInfo().makePayReq();
        C2538c.c(TAG, new Object[]{"payReq=" + makePayReq.toString()});
        HuaweiPay.HuaweiPayApi.pay(this.mHuaweiApiClient, makePayReq).setResultCallback(new C56203());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (101 == i) {
            String str = "Payment failed";
            PayResultInfo payResultInfoFromIntent = HuaweiPay.HuaweiPayApi.getPayResultInfoFromIntent(intent);
            if (payResultInfoFromIntent != null) {
                Map hashMap = new HashMap();
                hashMap.put("returnCode", Integer.valueOf(payResultInfoFromIntent.getReturnCode()));
                C2538c.c(TAG, new Object[]{"onActivityResult returnCode : " + payResultInfoFromIntent.getReturnCode()});
                if (payResultInfoFromIntent.getReturnCode() == 0) {
                    hashMap.put("returnCode", Integer.valueOf(payResultInfoFromIntent.getReturnCode()));
                    hashMap.put(HwPayConstant.KEY_USER_NAME, payResultInfoFromIntent.getUserName());
                    hashMap.put("orderID", payResultInfoFromIntent.getOrderID());
                    hashMap.put("amount", payResultInfoFromIntent.getAmount());
                    hashMap.put("errMsg", payResultInfoFromIntent.getErrMsg());
                    hashMap.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, payResultInfoFromIntent.getTime());
                    hashMap.put(HwPayConstant.KEY_REQUESTID, payResultInfoFromIntent.getRequestId());
                    showLoadingDialog(R.string.nfc_bus_card_recharge, false, null);
                    this.cardOperateLogicManager.recharge(this.mIssuerId, this.trafficOrder, this);
                } else if (30000 == payResultInfoFromIntent.getReturnCode()) {
                    str = "Payment is canceled.";
                    LogX.i("PluginPay BuscardRechargeAcitvityuser canceled");
                }
            } else {
                if (14 == this.mTrafficCardInfo.getMode()) {
                    showToast(R.string.huaweipay_channel_pay_not_support_tip);
                } else {
                    showToast(R.string.nfc_bus_card_pay_fail);
                }
                LogX.e("PluginPay BuscardRechargeAcitvityonActivityResult, pay failed");
            }
            C2538c.c(TAG, new Object[]{"Payment result " + str});
        } else if (102 == i) {
            C2538c.c(TAG, new Object[]{"onActivityResult, ResultCode: " + i2 + ", Intent: " + intent});
            this.mResolvingError = false;
            if (i2 == -1) {
                int intExtra = intent.getIntExtra("intent.extra.RESULT", 0);
                if (intExtra == 0) {
                    if (!this.mHuaweiApiClient.isConnecting() && !this.mHuaweiApiClient.isConnected()) {
                        this.mHuaweiApiClient.connect();
                        return;
                    }
                    return;
                } else if (intExtra == 13) {
                    C2538c.c(TAG, new Object[]{"解决错误过程被用户取消"});
                    return;
                } else if (intExtra == 8) {
                    C2538c.c(TAG, new Object[]{"发生内部错误，重试可以解决"});
                    return;
                } else {
                    C2538c.c(TAG, new Object[]{"未知返回码"});
                    return;
                }
            }
            C2538c.c(TAG, new Object[]{"调用解决方案发生错误"});
        } else if (105 == i && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void queryTrafficCardInfoCallback(int i, TrafficCardInfo trafficCardInfo) {
        if (isFinishing()) {
            LogX.i("PluginPay BuscardRechargeAcitvityqueryRechargeMoneyCallback, activity is finishing");
            return;
        }
        destroyLoadingDialog();
        if (i != 0 || trafficCardInfo == null) {
            LogX.e("PluginPay BuscardRechargeAcitvityqueryRechargeMoneyCallback, query failed");
            showNoNetDialog();
            return;
        }
        this.mTrafficCardInfo = trafficCardInfo;
        bindViews();
    }

    @SuppressLint({"NewApi"})
    private void bindViews() {
        if (this.mTrafficCardInfo != null) {
            if (this.mTrafficCardInfo.getCardIcon() != null) {
                this.mCardImageView.setImageBitmap(this.mTrafficCardInfo.getCardIcon());
            }
            List rechargeAmounts = this.mTrafficCardInfo.getRechargeAmounts();
            if (rechargeAmounts != null && !rechargeAmounts.isEmpty()) {
                int min = Math.min(rechargeAmounts.size(), this.btnRechargeList.size());
                for (int i = 0; i < this.btnRechargeList.size(); i++) {
                    if (i < min) {
                        ((Button) this.btnRechargeList.get(i)).setText(this.mMoneyLabel + ((RechargeMoney) rechargeAmounts.get(i)).getStringForRechargeMoney());
                        ((Button) this.btnRechargeList.get(i)).setTag(rechargeAmounts.get(i));
                        ((Button) this.btnRechargeList.get(i)).setVisibility(0);
                        LayoutParams layoutParams = (LayoutParams) ((Button) this.btnRechargeList.get(i)).getLayoutParams();
                        layoutParams.width = this.rechargeWidth;
                        ((Button) this.btnRechargeList.get(i)).setLayoutParams(layoutParams);
                    } else {
                        ((Button) this.btnRechargeList.get(i)).setVisibility(8);
                    }
                }
                ((Button) this.btnRechargeList.get(0)).callOnClick();
            }
        }
    }

    public void refundCallback(int i) {
    }

    private void showNoNetDialog() {
        C6022u a = new C6024w(this.mContext).m27591a(R.string.nfc_card_list_dialog_title).m27598b(this.mContext.getString(R.string.nfc_bus_no_net_dialog)).m27593a(R.string.nfc_cvv_code_introduction_ok, new C56225()).m27590a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    public void onConnected() {
        C2538c.c(TAG, new Object[]{"onConnected, IsConnected: " + this.mHuaweiApiClient.isConnected()});
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        C2538c.c(TAG, new Object[]{"onConnectionFailed, ErrorCode: " + connectionResult.getErrorCode()});
        if (!this.mResolvingError) {
            int errorCode = connectionResult.getErrorCode();
            if (6 == errorCode) {
                showNoteHwidRunBackDialog();
                return;
            }
            HuaweiApiAvailability instance = HuaweiApiAvailability.getInstance();
            if (instance.isUserResolvableError(errorCode)) {
                this.mResolvingError = true;
                instance.resolveError(this, errorCode, 102);
            }
        }
    }

    private void showNoteHwidRunBackDialog() {
        C2538c.c(TAG, new Object[]{"enter showNoteHwidRunBackDialog:"});
        this.dialogBuilder = new af(this.mContext);
        this.noteDialog = this.dialogBuilder.m27498a();
        this.noteDialog.show();
    }

    public void onConnectionSuspended(int i) {
        C2538c.c(TAG, new Object[]{"onConnectionSuspended, cause: " + i + ", IsConnected: " + this.mHuaweiApiClient.isConnected()});
    }

    protected String getErrorMessage(int i) {
        LogX.e("PluginPay BuscardRechargeAcitvityapplyRechargeOrderCallback, apply failed errorCode" + i);
        String commonErrorMessage = super.getCommonErrorMessage(i);
        if (commonErrorMessage != null) {
            return commonErrorMessage;
        }
        switch (i) {
            case 10:
            case 20:
            case 99:
                return getString(R.string.nfc_bus_offline_read_card_failed);
            case 21:
            case 22:
                return getString(R.string.nfc_bus_offline_card_in_blacklist);
            case 23:
                return getString(R.string.nfc_bus_offline_card_balance_error);
            case 24:
                return getString(R.string.nfc_overdraft_negative);
            case 1001:
                return getString(R.string.nfc_balance_reach_limit);
            case 1002:
                return getString(R.string.nfc_repeat_order);
            case 1003:
                return getString(R.string.nfc_recharge_amount_less_than_overdraft);
            case 1004:
            case 1005:
            case 1006:
                return getString(R.string.nfc_bus_offline_card_date_error);
            case 1007:
                return getString(R.string.nfc_recharge_amount_error);
            case 1008:
            case IssueTrafficCardCallback.RETURN_FAILED_CITYCODE_ILLEGAL /*1103*/:
                return getString(R.string.nfc_get_city_failed);
            case 1010:
                return getString(R.string.nfc_sp_out_of_service);
            case IssueTrafficCardCallback.RETURN_FAILED_REPEAT_ISSUERCARD /*1102*/:
                return getString(R.string.nfc_sp_return_error);
            case 1301:
            case RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE /*1304*/:
                return getString(R.string.nfc_recharge_fail_customer_service);
            case RechargeCallback.RETURN_RECHARGE_FAILED_RETRYABLE /*1302*/:
            case RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE_RETRYABLE /*1303*/:
                return getString(R.string.nfc_recharge_fail);
            case RechargeCallback.RETURN_RECHARGE_REACH_LIMIT_REFUNDABLE /*1305*/:
                return getString(R.string.nfc_sp_recharge_reach_limit);
            default:
                return getString(R.string.nfc_sp_return_error);
        }
    }

    protected void jump2ResultActivity(String str, String str2, int i, String str3, String str4, int i2, boolean z, boolean z2) {
        Intent intent = new Intent(this, ShowBindBusResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fail_desc", str);
        bundle.putString(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        bundle.putInt(ShowBindBusResultActivity.FAIL_OPR_TYPE_KEY, i);
        bundle.putString("issuerId", str3);
        bundle.putString(ShowBindBusResultActivity.CARD_AID, str4);
        bundle.putInt("key_enterance", i2);
        bundle.putBoolean(ShowBindBusResultActivity.RETRY_KEY, z);
        bundle.putBoolean(ShowBindBusResultActivity.OPENCARD_KEY, z2);
        intent.putExtras(bundle);
        startActivityForResult(intent, 105);
    }

    public void onWXPaySuccess() {
        if (!this.isFromWindow) {
            if (this.trafficOrder == null) {
                WXPayManager.getInstance().setRequest(false);
                this.isFinish = false;
                LogX.i("onWXPaySuccess:trafficOrder is null");
                showLoadingDialog(R.string.nfc_bus_card_recharge, false, null);
                this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(this.mIssuerId, 1, this);
                return;
            }
            LogX.i("user success");
            showLoadingDialog(R.string.nfc_bus_card_recharge, false, null);
            this.cardOperateLogicManager.recharge(this.mIssuerId, this.trafficOrder, this);
        }
    }

    public void onWXPayFail(int i) {
        showToast(R.string.nfc_bus_card_pay_fail);
        LogX.i("user pay failed");
    }

    public void onWXPayCancel() {
        LogX.i("user canceled");
    }

    public void onSelectedCallback(int i) {
        boolean z = true;
        this.trafficOrder = null;
        WXPayManager.getInstance().setRequest(false);
        this.isFinish = false;
        this.isFromWindow = false;
        if (!(i == 2 || i == 1)) {
            z = false;
        }
        if (!z) {
            LogX.i("onSelectedCallback paymethod is not ok");
        } else if (i != 2 || PackageUtil.m28463b(this.mContext, "com.tencent.mm")) {
            if (this.mSelectPayMethodFragment != null && this.mSelectPayMethodFragment.isVisible()) {
                getFragmentManager().beginTransaction().hide(this.mSelectPayMethodFragment).commit();
                setTitle(R.string.nfc_buscard_recharge_title);
            }
            showLoadingDialog(R.string.nfc_loading, false, null);
            this.cardOperateLogicManager.applyPayOrder(this.mIssuerId, this.payAmount, 2, i, "", this);
        } else {
            showErrorDialog(getString(R.string.huaweipay_wechat_pay_err_tips));
        }
    }

    public void queryAndHandleUnfinishedOrderCallback(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        this.trafficOrder = null;
        if (i != 0) {
            destroyLoadingDialog();
            if (this.isHasUnfinfishedOrders) {
                C2538c.c(TAG, new Object[]{"queryAndHandleUnfinishedOrderCallback isHasUnfinfishedOrders : " + this.isHasUnfinfishedOrders});
                showToast(getErrorMessage(i));
                return;
            }
            return;
        }
        if (orderHandleResultInfo != null) {
            LogX.i("queryAndHandleUnfinishedOrderCallback total cnt : " + orderHandleResultInfo.toString());
        }
        LogX.i("queryAndHandleUnfinishedOrderCallback resultType : " + i2);
        switch (i2) {
            case 1201:
                destroyLoadingDialog();
                jump2ResultActivity(getString(R.string.nfc_bus_card_recharge_fail_dialog_content), getString(R.string.nfc_bus_card_balance_reach_limit), 1, this.mIssuerId, this.mTrafficCardInfo.getAid(), 0, false, false);
                finish();
                return;
            case 10000:
                destroyLoadingDialog();
                return;
            case 10001:
                this.isHasUnfinfishedOrders = true;
                return;
            case 10002:
                destroyLoadingDialog();
                showToast(R.string.nfc_bus_card_recharge_success);
                this.isHasUnfinfishedOrders = false;
                setResult(-1);
                finish();
                return;
            default:
                LogX.e("queryAndHandleUnfinishedOrderCallback err, return resultType : " + i2);
                destroyLoadingDialog();
                return;
        }
    }

    private void requestShOrder() {
        setTitle(R.string.huaweipay_channel_title);
        if (this.mSelectPayMethodFragment == null) {
            this.mSelectPayMethodFragment = SelectPayMethodFragment.newSelectPayMethodFragment(2, this.rechargeMoney.getPayMoney(), this.mIssuerId);
        }
        if (this.mSelectPayMethodFragment.isAdded()) {
            this.mSelectPayMethodFragment.setPayAmount(this.rechargeMoney.getPayMoney());
            getFragmentManager().beginTransaction().show(this.mSelectPayMethodFragment).commit();
            return;
        }
        getFragmentManager().beginTransaction().add(R.id.recharge_container, this.mSelectPayMethodFragment, FRAGMENT_TAG_SELECT).commit();
    }

    public void onBackPressed() {
        if (this.mSelectPayMethodFragment == null || !this.mSelectPayMethodFragment.isVisible()) {
            super.onBackPressed();
            return;
        }
        getFragmentManager().beginTransaction().hide(this.mSelectPayMethodFragment).commit();
        setTitle(R.string.nfc_buscard_recharge_title);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId() || this.mSelectPayMethodFragment == null || !this.mSelectPayMethodFragment.isVisible()) {
            return super.onOptionsItemSelected(menuItem);
        }
        getFragmentManager().beginTransaction().hide(this.mSelectPayMethodFragment).commit();
        setTitle(R.string.nfc_buscard_recharge_title);
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        int i = 1;
        C2538c.c(TAG, new Object[]{"onWindowFocusChanged hasFocus : " + z});
        if (!z || !this.isFinish || !WXPayManager.getInstance().isRequest() || TextUtils.isEmpty(this.mIssuerId) || this.trafficOrder == null || this.cardOperateLogicManager == null) {
            i = 0;
        }
        if (i != 0) {
            this.payhandler.sendEmptyMessageDelayed(104, 200);
        }
        super.onWindowFocusChanged(z);
    }

    private void onWindowFocusChangedWait() {
        boolean z = (!WXPayManager.getInstance().isRequest() || TextUtils.isEmpty(this.mIssuerId) || this.trafficOrder == null || this.cardOperateLogicManager == null) ? false : true;
        C2538c.c(TAG, new Object[]{"enter onWindowFocusChangedWait isToFun : " + z});
        if (z) {
            WXPayManager.getInstance().setRequest(false);
            this.isFinish = false;
            this.isFromWindow = true;
            C2538c.c(TAG, new Object[]{"user recharge to function"});
            showLoadingDialog(R.string.nfc_loading, false, null);
            this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(this.mIssuerId, 1, this);
        }
    }

    protected void onPause() {
        this.isFinish = true;
        super.onPause();
    }
}
