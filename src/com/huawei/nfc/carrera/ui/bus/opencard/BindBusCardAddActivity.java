package com.huawei.nfc.carrera.ui.bus.opencard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
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
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.model.IssueMoney;
import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.ApplyPayOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.logic.wxpay.WXPayCallback;
import com.huawei.nfc.carrera.logic.wxpay.WXPayManager;
import com.huawei.nfc.carrera.ui.bus.BusBaseActivity;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.ui.bus.util.TimeUtil;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.ui.util.UiUtil;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.ui.commonui.dialog.ae;
import com.huawei.ui.commonui.dialog.af;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.PackageUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BindBusCardAddActivity extends BusBaseActivity implements OnClickListener, QueryTrafficCardInfoCallback, ApplyPayOrderCallback, IssueTrafficCardCallback, QueryAndHandleUnfinishedOrderCallback, RechargeCallback, WXPayCallback {
    protected static final String EXTRA_KEY_CARD_AID = "traffic_card_aid";
    protected static final String EXTRA_KEY_CARD_ISSUEMONEY = "traffic_card_issuemoney";
    protected static final String EXTRA_KEY_CARD_ISSUERID = "traffic_card_issuerId";
    protected static final String EXTRA_KEY_CARD_NAME = "traffic_card_name";
    protected static final String EXTRA_KEY_CARD_PRODUCTD = "traffic_card_productId";
    protected static final String EXTRA_KEY_CARD_REQUEST_ID = "traffic_card_request_id";
    private static final String EXTRA_RESULT = "intent.extra.RESULT";
    private static final int HANDLER_EVENT_PAY_NOT_CONNECTED = 103;
    protected static final int HANDLER_EVENT_PAY_RESULT = 101;
    protected static final int HANDLER_EVENT_PAY_START = 100;
    private static final int HANDLER_ONWINDOW_FOCUSCHANGED_WAIT = 104;
    private static final int HANDLER_SHOW_OPEN_CARD_DIALOG = 106;
    private static final String KEY_ENTERANCE = "key_enterance";
    private static final String MAP_GZ = "020";
    private static final String PACKAGE_NAME_WECHAT = "com.tencent.mm";
    protected static final int RECHARGE_FAIL_REQUESTCODE = 105;
    private static final int REQUEST_RESOLVE_ERROR = 102;
    private static final String TAG = "BindBusCardAddActivity";
    private static ExecutorService threadPool = Executors.newFixedThreadPool(1);
    private final String DEFAULT_MONET_SINGAL = "_._";
    private LocationManagerProxy aMapLocManager;
    AMapLocationListener aMapLocationListener = new C56349();
    private ArrayList<Button> amountList;
    protected C6002a applyOrderProgressDialog;
    protected Button btnOpenCard;
    private ConnectionCallbacks connectionCallbacks = new C56261();
    private OnConnectionFailedListener connectionFailedListener = new C56272();
    private af dialogBuilder = null;
    protected int entranceType = -1;
    private boolean isFinish = false;
    private boolean isFromWindow = false;
    private boolean isGetIssueCost;
    private TextView mBusCardDes;
    private ImageView mBusCardRes;
    protected String mCardAid;
    protected String mCardName;
    protected long mCardRequestId;
    private HuaweiApiClient mHuaweiApiClient;
    protected IssueMoney mIssueMoney;
    protected String mIssuerId;
    private int mMode = -1;
    private String mMoneyLabel;
    private int mNormalAmountTextColor;
    private String mProductCode;
    private boolean mResolvingError = false;
    private int mSeletcedAmountTextColor;
    private TrafficCardInfo mTrafficCardInfo;
    private ae noteDialog = null;
    protected double payAmount;
    protected Handler payhandler = new MyHandler(this);
    protected double rechargeAmount;
    private int rechargeWidth;
    private Runnable runnable = new Runnable() {
        public void run() {
            C2538c.c(BindBusCardAddActivity.TAG, new Object[]{"requestLocationData Location time end"});
            BindBusCardAddActivity.this.stopLocation();
            BindBusCardAddActivity.this.cardInfoManager.queryTrafficCardInfo(BindBusCardAddActivity.this.mIssuerId, BindBusCardAddActivity.this.mMode, BindBusCardAddActivity.MAP_GZ, BindBusCardAddActivity.this);
            C2538c.c(BindBusCardAddActivity.TAG, new Object[]{" requestLocationData cityCode ： " + r0});
        }
    };
    protected TextView textChargeAmount;
    protected TextView textOpenAmount;
    protected TextView textPayAmount;
    protected TextView textStdOpenAmount;
    protected TrafficOrder trafficOrder;

    class C56261 implements ConnectionCallbacks {
        C56261() {
        }

        public void onConnected() {
            C2538c.c(BindBusCardAddActivity.TAG, new Object[]{"onConnected, IsConnected: " + BindBusCardAddActivity.this.mHuaweiApiClient.isConnected()});
        }

        public void onConnectionSuspended(int i) {
            C2538c.c(BindBusCardAddActivity.TAG, new Object[]{"onConnectionSuspended, cause: " + i + ", IsConnected: " + BindBusCardAddActivity.this.mHuaweiApiClient.isConnected()});
        }
    }

    class C56272 implements OnConnectionFailedListener {
        C56272() {
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            C2538c.c(BindBusCardAddActivity.TAG, new Object[]{"onConnectionFailed, ErrorCode: " + connectionResult.getErrorCode()});
            if (!BindBusCardAddActivity.this.mResolvingError) {
                int errorCode = connectionResult.getErrorCode();
                if (6 == errorCode) {
                    BindBusCardAddActivity.this.showNoteHwidRunBackDialog();
                    return;
                }
                HuaweiApiAvailability instance = HuaweiApiAvailability.getInstance();
                if (instance.isUserResolvableError(errorCode)) {
                    BindBusCardAddActivity.this.mResolvingError = true;
                    instance.resolveError(BindBusCardAddActivity.this, errorCode, 102);
                }
            }
        }
    }

    class C56283 implements OnCancelListener {
        C56283() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            LogX.i("onCreate, cancel queryIssueMoney");
        }
    }

    class C56294 implements OnClickListener {
        C56294() {
        }

        public void onClick(View view) {
        }
    }

    class C56305 implements ResultCallback<PayResult> {
        C56305() {
        }

        public void onResult(PayResult payResult) {
            BindBusCardAddActivity.this.dismissProgress(BindBusCardAddActivity.this.progressDialog21);
            Status status = payResult.getStatus();
            C2538c.c(BindBusCardAddActivity.TAG, new Object[]{"applyIssueOrderCallback, apply status : " + status});
            if (status.getStatusCode() == 0) {
                try {
                    status.startResolutionForResult(BindBusCardAddActivity.this, 101);
                } catch (SendIntentException e) {
                    C2538c.e("hwpay", new Object[]{"SendIntentException e"});
                }
            }
        }
    }

    class C56338 implements OnClickListener {
        C56338() {
        }

        public void onClick(View view) {
            BindBusCardAddActivity.this.finish();
        }
    }

    class C56349 implements AMapLocationListener {
        C56349() {
        }

        public void onLocationChanged(AMapLocation aMapLocation) {
            BindBusCardAddActivity.this.payhandler.removeCallbacks(BindBusCardAddActivity.this.runnable);
            String cityCode = aMapLocation.getCityCode();
            BindBusCardAddActivity.this.stopLocation();
            C2538c.c(BindBusCardAddActivity.TAG, new Object[]{"AMapLocationListener requestLocationData cityCode=" + cityCode});
            BindBusCardAddActivity.this.cardInfoManager.queryTrafficCardInfo(BindBusCardAddActivity.this.mIssuerId, BindBusCardAddActivity.this.mMode, cityCode, BindBusCardAddActivity.this);
        }

        public void onLocationChanged(Location location) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onProviderDisabled(String str) {
        }
    }

    public class MyHandler extends Handler {
        WeakReference<BindBusCardAddActivity> mActivityReference;

        MyHandler(BindBusCardAddActivity bindBusCardAddActivity) {
            this.mActivityReference = new WeakReference(bindBusCardAddActivity);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (((BindBusCardAddActivity) this.mActivityReference.get()) != null) {
                C2538c.c(BindBusCardAddActivity.TAG, new Object[]{" handleMessage msg : " + message.what});
                switch (message.what) {
                    case 100:
                        BindBusCardAddActivity.this.startPay(BindBusCardAddActivity.this.trafficOrder);
                        return;
                    case 103:
                        BindBusCardAddActivity.this.showToast(R.string.nfc_bus_card_pay_fail);
                        return;
                    case 104:
                        BindBusCardAddActivity.this.onWindowFocusChangedWait();
                        return;
                    case 106:
                        BindBusCardAddActivity.this.showProgressDialog();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    class SetCardDefaultCallbackImpl implements SetCardDefaultCallback {
        SetCardDefaultCallbackImpl() {
        }

        public void setResultCallback(int i) {
            LogX.i("BindBusCardAddActivity,set default card result:" + i);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        onCreateInit();
    }

    public void initHMS() {
        this.mHuaweiApiClient = new Builder(getApplicationContext()).addApi(HuaweiPay.PAY_API).addConnectionCallbacks(this.connectionCallbacks).addOnConnectionFailedListener(this.connectionFailedListener).build();
    }

    private void showNoteHwidRunBackDialog() {
        C2538c.c(TAG, new Object[]{"enter showNoteHwidRunBackDialog:"});
        this.dialogBuilder = new af(this.mContext);
        this.noteDialog = this.dialogBuilder.m27498a();
        this.noteDialog.show();
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
        C2538c.c(TAG, new Object[]{"onStop, ErrorCode: " + HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this)});
        super.onStop();
        if (this.noteDialog != null) {
            this.noteDialog.dismiss();
            this.dialogBuilder = null;
            this.noteDialog = null;
        }
    }

    protected void onCreateInit() {
        setRequestedOrientation(1);
        setTitle(R.string.nfc_bind_bus_card_title);
        setContentView(R.layout.nfc_add_bus_card);
        if (initParams()) {
            init();
            showDefaultView();
            return;
        }
        LogX.e("BindBusCardAddActivity, initParams failed");
        finish();
    }

    protected void init() {
        int i;
        super.init();
        this.mBusCardRes = (ImageView) findViewById(R.id.add_buscard_activity_card_res);
        setCardImageSize(this.mBusCardRes);
        this.mBusCardDes = (TextView) findViewById(R.id.add_buscard_activity_card_des);
        this.amountList = new ArrayList();
        this.amountList.add((Button) findViewById(R.id.add_buscard_activity_recharge_amount_1));
        this.amountList.add((Button) findViewById(R.id.add_buscard_activity_recharge_amount_2));
        this.amountList.add((Button) findViewById(R.id.add_buscard_activity_recharge_amount_3));
        this.amountList.add((Button) findViewById(R.id.add_buscard_activity_recharge_amount_4));
        this.amountList.add((Button) findViewById(R.id.add_buscard_activity_recharge_amount_5));
        this.amountList.add((Button) findViewById(R.id.add_buscard_activity_recharge_amount_6));
        for (i = 0; i < this.amountList.size(); i++) {
            ((Button) this.amountList.get(i)).setOnClickListener(this);
            ((Button) this.amountList.get(i)).setVisibility(8);
        }
        this.rechargeWidth = (getResources().getDisplayMetrics().widthPixels - (((int) getResources().getDimension(R.dimen.nfc_bus_recharge_margin)) * 6)) / 3;
        this.textChargeAmount = (TextView) findViewById(R.id.add_buscard_activity_recharge_amount);
        this.textStdOpenAmount = (TextView) findViewById(R.id.add_buscard_activity_open_card_amount_orginal);
        this.textOpenAmount = (TextView) findViewById(R.id.add_buscard_activity_open_card_amount_real);
        this.textPayAmount = (TextView) findViewById(R.id.add_buscard_activity_pay_amount);
        this.btnOpenCard = (Button) findViewById(R.id.add_buscard_activity_open_card_btn);
        this.btnOpenCard.setOnClickListener(this);
        UiUtil.setOrangeButtonBackground(this, this.btnOpenCard);
        this.applyOrderProgressDialog = C6002a.m27468a((Context) this);
        this.applyOrderProgressDialog.setCanceledOnTouchOutside(false);
        this.mMoneyLabel = getString(R.string.nfc_money_type);
        this.mSeletcedAmountTextColor = getResources().getColor(R.color.white);
        this.mNormalAmountTextColor = getResources().getColor(R.color.add_bus_card_button_text_color);
        showProgress(this.progressDialog21, getString(R.string.nfc_loading), true, new C56283());
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter();
        if (pluginPayAdapter == null) {
            LogX.w("onCreate, null == pluginPayAdapter");
            finish();
            return;
        }
        int i2;
        i = pluginPayAdapter.getDeviceProtocol();
        if (13 == i && Constant.BEIJING_CARD_ISSERID.equals(this.mIssuerId)) {
            LogX.i("nyx and beijing ");
            i2 = 3;
        } else {
            i2 = 1;
        }
        IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this).cacheIssuerInfoItem(this.mIssuerId);
        if (13 == i && cacheIssuerInfoItem != null && Constant.LNT_CARD_AID.equals(cacheIssuerInfoItem.getAid())) {
            LogX.i("nyx and lingnantong ");
            this.btnOpenCard.setText(getString(R.string.nfc_bind_bus_card_sure_open));
            getPositionByMobileNet(1);
            return;
        }
        WXPayManager.getInstance().setRequest(false);
        this.cardInfoManager.queryTrafficCardInfo(this.mIssuerId, i2, "", this);
        if (Constant.BEIJING_CARD_ISSERID.equals(this.mIssuerId)) {
            this.btnOpenCard.setText(getString(R.string.nfc_next_step));
        } else {
            this.btnOpenCard.setText(getString(R.string.nfc_bind_bus_card_sure_open));
        }
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            LogX.e("initParams, intent == null");
            return false;
        }
        this.entranceType = intent.getIntExtra("key_enterance", 0);
        this.mIssuerId = intent.getStringExtra("traffic_card_issuerId");
        if (StringUtil.isEmpty(this.mIssuerId, true)) {
            LogX.e("initParams, illegal params");
            return false;
        }
        this.mCardRequestId = intent.getLongExtra(EXTRA_KEY_CARD_REQUEST_ID, 0);
        this.mCardName = intent.getStringExtra(EXTRA_KEY_CARD_NAME);
        return true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.id.add_buscard_activity_open_card_btn == id) {
            if (TimeUtil.isFastDoubleClick()) {
                LogX.e("onClick, isFastDoubleClick");
            } else if (!this.isGetIssueCost) {
                showToast(R.string.nfc_bus_no_net_dialog);
            } else if (Constant.BEIJING_CARD_ISSERID.equals(this.mIssuerId)) {
                LogX.i("onClick, open BEIJING");
                Intent intent = new Intent(this, BindBusCardBeiJingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("traffic_card_issuerId", this.mIssuerId);
                bundle.putLong(EXTRA_KEY_CARD_REQUEST_ID, this.mCardRequestId);
                bundle.putString(EXTRA_KEY_CARD_AID, this.mTrafficCardInfo.getAid());
                bundle.putString(EXTRA_KEY_CARD_NAME, this.mTrafficCardInfo.getName());
                bundle.putSerializable(EXTRA_KEY_CARD_ISSUEMONEY, this.mIssueMoney);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            } else {
                boolean z;
                if (this.mTrafficCardInfo.isWxPaySupport() && 14 == this.mTrafficCardInfo.getMode()) {
                    z = true;
                } else {
                    z = false;
                }
                LogX.i("onClick, recharge card isSh : " + z + " ; TrafficCardInfo : " + this.mTrafficCardInfo);
                if (z) {
                    onSelectedWXPay();
                    return;
                }
                LogX.i("onClick, open BEIJING else");
                showProgress(this.applyOrderProgressDialog, getString(R.string.nfc_loading), true, null);
                int i = this.rechargeAmount <= 0.0d ? 1 : 3;
                if (Constant.TFTONG_CARD_ISSERID.equals(this.mIssuerId)) {
                    int convertYuanToFen = MoneyUtil.convertYuanToFen(String.valueOf(this.mIssueMoney.getIssueMoney()));
                    id = MoneyUtil.convertYuanToFen(String.valueOf(this.mIssueMoney.getIssueStdMoney()));
                    if (convertYuanToFen < 0) {
                        convertYuanToFen = id;
                    }
                    ApplyOrderInfo applyOrderInfo = new ApplyOrderInfo(i, MoneyUtil.convertYuanToFen(String.valueOf(this.payAmount)), 0);
                    applyOrderInfo.setIssuePayment(convertYuanToFen, id);
                    applyOrderInfo.setRechargePayment(MoneyUtil.convertYuanToFen(String.valueOf(this.rechargeAmount)), MoneyUtil.convertYuanToFen(String.valueOf(this.mIssueMoney.getRechargeMoney())));
                    this.cardOperateLogicManager.applyPayOrder(this.mIssuerId, applyOrderInfo, this);
                    return;
                }
                this.cardOperateLogicManager.applyPayOrder(this.mIssuerId, this.payAmount, i, 1, this.mProductCode, this);
            }
        } else if (R.id.add_buscard_activity_recharge_amount_1 == id || R.id.add_buscard_activity_recharge_amount_2 == id || R.id.add_buscard_activity_recharge_amount_3 == id || R.id.add_buscard_activity_recharge_amount_4 == id || R.id.add_buscard_activity_recharge_amount_5 == id || R.id.add_buscard_activity_recharge_amount_6 == id) {
            refreshIssueMoney(id, (IssueMoney) view.getTag());
        }
    }

    private void refreshIssueMoney(int i, IssueMoney issueMoney) {
        C2538c.b(TAG, new Object[]{"refreshIssueMoney,issueMoney=" + issueMoney.getIssueMoney() + ",issueStdMoney=" + issueMoney.getIssueStdMoney() + ",rechargeMoney=" + issueMoney.getRechargeMoney() + ",payMoney=" + issueMoney.getPayMoney()});
        this.mIssueMoney = issueMoney;
        for (int i2 = 0; i2 < this.amountList.size(); i2++) {
            TextView textView = (TextView) this.amountList.get(i2);
            if (i == textView.getId()) {
                textView.setBackgroundResource(R.drawable.nfc_buscard_recharge_bg);
                textView.setTextColor(this.mSeletcedAmountTextColor);
            } else {
                textView.setBackgroundResource(R.drawable.nfc_buscard_recharge_normal_bg);
                textView.setTextColor(this.mNormalAmountTextColor);
            }
        }
        double issueMoney2 = issueMoney.getIssueMoney();
        double issueStdMoney = issueMoney.getIssueStdMoney();
        if (issueMoney2 < 0.0d) {
            this.isGetIssueCost = false;
            issueMoney2 = issueStdMoney;
        } else {
            this.isGetIssueCost = true;
        }
        if (Math.abs(issueMoney2 - issueStdMoney) > 0.0d) {
            this.textStdOpenAmount.setVisibility(0);
            this.textStdOpenAmount.setText(MoneyUtil.changeIntoDisplayMoney(this.mMoneyLabel, issueStdMoney));
            this.textStdOpenAmount.getPaint().setFlags(17);
        } else {
            this.textStdOpenAmount.setVisibility(8);
        }
        this.payAmount = issueMoney.getPayMoney();
        this.rechargeAmount = this.payAmount - issueMoney.getIssueMoney();
        this.textOpenAmount.setText(MoneyUtil.changeIntoDisplayMoney(this.mMoneyLabel, issueMoney.getIssueMoney()));
        this.textChargeAmount.setText(MoneyUtil.changeIntoDisplayMoney(this.mMoneyLabel, issueMoney.getRechargeMoney()));
        this.textPayAmount.setText(MoneyUtil.changeIntoDisplayMoney(this.mMoneyLabel, issueMoney.getPayMoney()));
    }

    public void applyPayOrderCallback(int i, TrafficOrder trafficOrder) {
        if ((this.mLoadingDialog21 == null || this.mLoadingDialog21.isShowing()) && this.isVisible) {
            dismissProgress(this.applyOrderProgressDialog);
            LogX.i("applyIssueOrderCallback, resultCode=" + i);
            if (i != 0 || trafficOrder == null) {
                if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
                    openCardLogUpload(this.mIssuerId, String.valueOf(i), "applyIssueOrderCallback, apply failed");
                }
                LogX.e("applyIssueOrderCallback, apply failed");
                showErrorDialog(getErrorMessage(i));
                return;
            }
            this.trafficOrder = trafficOrder;
            if (trafficOrder.getHasUnusedIssueOrder()) {
                showProgressDialog();
                this.cardOperateLogicManager.issueTrafficCard(this.mIssuerId, this.trafficOrder, this);
                reportCardOpened();
                return;
            } else if (trafficOrder.isDuplicateApply()) {
                showProgressDialog();
                this.rechargeAmount = 0.0d;
                this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(this.mIssuerId, 0, this);
                return;
            } else if (this.isFromWindow) {
                this.isFromWindow = false;
                onWXPayCancel();
                return;
            } else {
                this.payhandler.sendEmptyMessage(100);
                return;
            }
        }
        dismissProgress(this.applyOrderProgressDialog);
        LogX.i("applyIssueOrderCallback, no need to handle callback");
    }

    protected void showProgressDialog() {
        if (this.pluginPayAdapter == null) {
            return;
        }
        if (this.pluginPayAdapter.getDeviceProtocol() == 13) {
            showProgress(this.progressDialog21, getString(R.string.nfc_bind_bus_opening_card_new1), false, null);
        } else {
            showProgress(this.progressDialog21, getString(R.string.nfc_bind_bus_opening_card_new), false, null);
        }
    }

    protected void showErrorDialog(String str) {
        C6022u a = new C6024w(this.mContext).m27591a(R.string.nfc_card_list_dialog_title).m27598b(str).m27593a(R.string.nfc_cvv_code_introduction_ok, new C56294()).m27590a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    protected void startPay(TrafficOrder trafficOrder) {
        C2538c.c(TAG, new Object[]{" order PayType  " + trafficOrder.getPayType() + " ; order WxPayInfo : " + trafficOrder.getWxPayInfo()});
        if (trafficOrder.getPayType() != 2 || trafficOrder.getWxPayInfo() == null) {
            startHWPay(trafficOrder);
        } else if (!WXPayManager.getInstance().pay(trafficOrder.getWxPayInfo(), this)) {
            LogX.e("applyIssueOrderCallback, wxpay is fail");
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
        showProgress(this.progressDialog21, getString(R.string.nfc_loading), false, null);
        HuaweiPay.HuaweiPayApi.pay(this.mHuaweiApiClient, makePayReq).setResultCallback(new C56305());
    }

    public void queryAndHandleUnfinishedOrderCallback(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        if (i != 0) {
            destroyLoadingDialog();
            jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.mIssuerId, this.mCardAid, this.entranceType, true, true);
            return;
        }
        switch (i2) {
            case 10000:
                destroyLoadingDialog();
                jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.mIssuerId, this.mCardAid, this.entranceType, false, true);
                return;
            case 10001:
                return;
            case 10002:
                destroyLoadingDialog();
                if (orderHandleResultInfo == null || orderHandleResultInfo.getIssueCardOrderCnt() <= 0) {
                    jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.mIssuerId, this.mCardAid, this.entranceType, true, true);
                    return;
                }
                jump2ResultActivity(this.mContext.getString(R.string.nfc_bind_bus_card_success), this.mContext.getString(R.string.nfc_bind_bus_success_decribe_text), 0, this.mIssuerId, this.mCardAid, this.entranceType, false, true);
                LogicApiFactory.createCardManager(this.mContext).refreshCardList();
                return;
            default:
                return;
        }
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
                    if (this.trafficOrder.getPayInfo() == null) {
                        str = "success, but payinfo is null";
                    } else {
                        showProgressDialog();
                        this.cardOperateLogicManager.issueTrafficCard(this.mIssuerId, this.trafficOrder, this);
                    }
                } else if (30000 == payResultInfoFromIntent.getReturnCode()) {
                    str = "Payment is canceled.";
                    LogX.i("user canceled");
                } else {
                    openCardLogUpload(this.mIssuerId, "1", "onActivityResult, pay failed");
                    str = "Payment failed, the ERROR CODE is " + payResultInfoFromIntent.getReturnCode();
                    if (14 == this.mTrafficCardInfo.getMode()) {
                        showToast(R.string.huaweipay_channel_pay_not_support_tip);
                    } else {
                        showToast(R.string.nfc_bus_card_pay_fail);
                    }
                }
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

    public void issueTrafficCardCallback(int i) {
        LogX.i("installTrafficCardCallback resultCode : " + i);
        if (i == 0) {
            LogX.i("installTrafficCardCallback result success & save issuerid to sp , mIssuerId : " + this.mIssuerId);
            if (this.rechargeAmount > 0.0d) {
                this.cardOperateLogicManager.recharge(this.mIssuerId, this.trafficOrder, this);
                return;
            }
            openCardLogUpload(this.mIssuerId, "0", "");
            setDefaultCard();
            dismissProgress(this.progressDialog21);
            jump2ResultActivity(getString(R.string.nfc_bind_bus_card_success), getString(R.string.nfc_bind_bus_success_decribe_text), 0, this.mIssuerId, this.entranceType, false, true);
        } else if (i == IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT) {
            openCardLogUpload(this.mIssuerId, String.valueOf(i), "issueTrafficCardCallback , Has opened the number of cards has reached the limit");
            dismissProgress(this.progressDialog21);
            jump2ResultActivity(getString(R.string.nfc_bind_bus_card_fail), getString(R.string.nfc_bind_card_fail_open_overcount), 1, this.mIssuerId, this.entranceType, false, true);
        } else {
            if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
                openCardLogUpload(this.mIssuerId, String.valueOf(i), "issueTrafficCardCallback, issue Traffic Card fail");
            }
            dismissProgress(this.progressDialog21);
            jump2ResultActivity(getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.mIssuerId, this.entranceType, true, true);
            LogX.e("installTrafficCardCallback, illegal resultCode");
        }
    }

    private void jump2ResultActivity(String str, String str2, int i, String str3, int i2, boolean z, boolean z2) {
        Intent intent = new Intent(this, ShowBindBusResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fail_desc", str);
        bundle.putString(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        bundle.putInt(ShowBindBusResultActivity.FAIL_OPR_TYPE_KEY, i);
        bundle.putString("issuerId", str3);
        bundle.putInt("key_enterance", i2);
        bundle.putLong(ShowBindBusResultActivity.CARD_REQUEST_ID_KEY, this.mCardRequestId);
        bundle.putString("card_name", this.mCardName);
        bundle.putString(ShowBindBusResultActivity.CARD_AID, this.mCardAid);
        bundle.putBoolean(ShowBindBusResultActivity.RETRY_KEY, z);
        bundle.putBoolean(ShowBindBusResultActivity.OPENCARD_KEY, z2);
        intent.putExtras(bundle);
        startActivity(intent);
        if (i == 0) {
            setResult(-1);
            finish();
        }
        if (1 == i) {
            setResult(-1);
            finish();
        }
    }

    protected String getErrorMessage(int i) {
        String commonErrorMessage = super.getCommonErrorMessage(i);
        if (commonErrorMessage != null) {
            return commonErrorMessage;
        }
        switch (i) {
            case 10:
                return getString(R.string.nfc_create_order_failed);
            case 1008:
            case IssueTrafficCardCallback.RETURN_FAILED_CITYCODE_ILLEGAL /*1103*/:
                return getString(R.string.nfc_get_city_failed);
            case 1009:
                return getString(R.string.nfc_card_sold_out);
            case 1010:
                return getString(R.string.nfc_sp_out_of_service);
            case IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT /*1101*/:
                return getString(R.string.nfc_bind_card_fail_open_overcount);
            case IssueTrafficCardCallback.RETURN_FAILED_REPEAT_ISSUERCARD /*1102*/:
                return getString(R.string.nfc_sp_return_failed);
            case IssueTrafficCardCallback.RETURN_FAILED_SSD_INSTALL_FAILED /*1104*/:
                return getString(R.string.nfc_ssd_install_failed);
            default:
                return getString(R.string.nfc_sp_return_failed);
        }
    }

    public void rechargeCallback(int i) {
        if (!isFinishing()) {
            setDefaultCard();
            dismissProgress(this.progressDialog21);
            LogX.i("rechargeCallback, resultCode=" + i);
            if (i != 0) {
                if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
                    openCardLogUpload(this.mIssuerId, String.valueOf(i), "rechargeCallback, recharge failed");
                }
                LogX.w("rechargeCallback, recharge failed");
            } else {
                openCardLogUpload(this.mIssuerId, "0", "");
                cardEventTopUp();
            }
            jump2ResultActivity(getString(R.string.nfc_bind_bus_card_success), getString(R.string.nfc_bind_bus_success_decribe_text), 0, this.mIssuerId, this.entranceType, false, true);
        }
    }

    private void cardEventTopUp() {
        if (!StringUtil.isEmpty(this.mIssuerId, true)) {
            final IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this).cacheIssuerInfoItem(this.mIssuerId);
            if (cacheIssuerInfoItem != null && cacheIssuerInfoItem.getAid() != null) {
                new Thread(new Runnable() {
                    public void run() {
                        WalletTaManager.getInstance(BindBusCardAddActivity.this).cardEvent(cacheIssuerInfoItem.getAid(), 1);
                    }
                }).start();
            }
        }
    }

    private void setDefaultCard() {
        if (!StringUtil.isEmpty(this.mIssuerId, true)) {
            final IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this).cacheIssuerInfoItem(this.mIssuerId);
            if (cacheIssuerInfoItem != null && cacheIssuerInfoItem.getAid() != null) {
                threadPool.execute(new Runnable() {
                    public void run() {
                        try {
                            WalletTaManager.getInstance(BindBusCardAddActivity.this.mContext).setDefaultCard(cacheIssuerInfoItem.getAid());
                        } catch (WalletTaCardNotExistException e) {
                            LogX.i("WalletTaCardNotExistException generateTaCardInfo e = " + e.getMessage());
                        } catch (WalletTaSystemErrorException e2) {
                            LogX.i("WalletTaSystemErrorException generateTaCardInfo e = " + e2.getMessage());
                        }
                    }
                });
            }
        }
    }

    public void queryTrafficCardInfoCallback(int i, TrafficCardInfo trafficCardInfo) {
        LogX.i("queryTrafficCardInfoCallback, resultCode=" + i);
        if (isFinishing()) {
            LogX.i("queryTrafficCardInfoCallback, activity is finishing");
            return;
        }
        dismissProgress(this.progressDialog21);
        if (i != 0 || trafficCardInfo == null) {
            LogX.e("queryTrafficCardInfoCallback, query failed");
            showNoNetDialog();
            return;
        }
        this.mTrafficCardInfo = trafficCardInfo;
        this.mCardAid = this.mTrafficCardInfo.getAid();
        this.mProductCode = this.mTrafficCardInfo.getProductCode();
        bindViews();
    }

    @SuppressLint({"NewApi"})
    private void bindViews() {
        this.mBusCardRes.setImageBitmap(this.mTrafficCardInfo.getCardIcon());
        if (StringUtil.isEmpty(this.mTrafficCardInfo.getProductDesc(), true)) {
            this.mBusCardDes.setVisibility(8);
        } else {
            this.mBusCardDes.setText(this.mTrafficCardInfo.getProductDesc());
        }
        List list = this.mTrafficCardInfo.issueAmounts;
        if (list != null && !list.isEmpty()) {
            int min = Math.min(list.size(), this.amountList.size());
            for (int i = 0; i < min; i++) {
                ((Button) this.amountList.get(i)).setText(this.mMoneyLabel + String.valueOf((int) ((IssueMoney) list.get(i)).getPayMoney()));
                ((Button) this.amountList.get(i)).setTag(list.get(i));
                ((Button) this.amountList.get(i)).setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) ((Button) this.amountList.get(i)).getLayoutParams();
                layoutParams.width = this.rechargeWidth;
                ((Button) this.amountList.get(i)).setLayoutParams(layoutParams);
            }
            ((Button) this.amountList.get(0)).callOnClick();
        }
    }

    private void showDefaultView() {
        this.mBusCardRes.setImageResource(R.drawable.nfc_card_icon_default);
        for (int i = 0; i < this.amountList.size(); i++) {
            ((Button) this.amountList.get(i)).setText(this.mMoneyLabel + "_._");
        }
        this.textOpenAmount.setText(this.mMoneyLabel + "_._");
        this.textChargeAmount.setText(this.mMoneyLabel + "_._");
        this.textPayAmount.setText(this.mMoneyLabel + "_._");
    }

    private void showNoNetDialog() {
        C6022u a = new C6024w(this.mContext).m27591a(R.string.nfc_card_list_dialog_title).m27598b(this.mContext.getString(R.string.nfc_bus_no_net_dialog)).m27593a(R.string.nfc_cvv_code_introduction_ok, new C56338()).m27590a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    protected void reportCardOpened() {
        NfcHianalyticsUtil.onReportForCardOpenAction(this, this.mTrafficCardInfo.getAid(), this.mTrafficCardInfo.getName(), this.mIssuerId);
    }

    public void onBackPressed() {
        super.onBackPressed();
        startBindBusCardSwitchActivity();
    }

    protected void onHomeRetrunArrowClick() {
        super.onHomeRetrunArrowClick();
    }

    private void startBindBusCardSwitchActivity() {
        Intent intent = new Intent(this, BindBusCardSwitchActivity.class);
        intent.setFlags(65536);
        startActivity(intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.payhandler != null) {
            this.payhandler.removeCallbacksAndMessages(null);
        }
    }

    private void getPositionByMobileNet(int i) {
        C2538c.c(TAG, new Object[]{"Enter getPositionByMobileNet"});
        this.mMode = i;
        this.aMapLocManager = LocationManagerProxy.getInstance(this.mContext);
        if (this.aMapLocManager == null) {
            C2538c.c(TAG, new Object[]{"aMapLocManager is null "});
            return;
        }
        this.payhandler.removeCallbacks(this.runnable);
        this.payhandler.postDelayed(this.runnable, 5000);
        this.aMapLocManager.requestLocationData(LocationProviderProxy.AMapNetwork, 200, 100.0f, this.aMapLocationListener);
        C2538c.c(TAG, new Object[]{"Leave getPositionByMobileNet"});
    }

    private void stopLocation() {
        C2538c.c(TAG, new Object[]{"Enter stopLocation"});
        if (this.aMapLocManager != null) {
            this.aMapLocManager.removeUpdates(this.aMapLocationListener);
            this.aMapLocManager.destroy();
        }
        this.aMapLocManager = null;
    }

    public void onWXPaySuccess() {
        C2538c.c(TAG, new Object[]{"user pay success isFromWindow : " + this.isFromWindow});
        if (!this.isFromWindow) {
            if (this.trafficOrder == null) {
                C2538c.c(TAG, new Object[]{"onWXPaySuccess: trafficOrder is null"});
                onSelectedWXPay();
            } else {
                this.payhandler.sendEmptyMessage(106);
                this.cardOperateLogicManager.issueTrafficCard(this.mIssuerId, this.trafficOrder, this);
            }
            reportCardOpened();
        }
    }

    public void onWXPayFail(int i) {
        showToast(R.string.pay_fail);
        C2538c.c(TAG, new Object[]{"user pay fail"});
        openCardLogUpload(this.mIssuerId, "1", "onActivityResult, pay failed");
    }

    public void onWXPayCancel() {
        C2538c.c(TAG, new Object[]{"onWXPayCancel"});
    }

    private void onSelectedWXPay() {
        int i = 1;
        C2538c.c(TAG, new Object[]{"onClick, onSelectedWXPay"});
        this.trafficOrder = null;
        WXPayManager.getInstance().setRequest(false);
        this.isFinish = false;
        this.isFromWindow = false;
        if (PackageUtil.m28463b(this.mContext, "com.tencent.mm")) {
            showProgress(this.applyOrderProgressDialog, getString(R.string.nfc_loading), true, null);
            if (this.rechargeAmount > 0.0d) {
                i = 3;
            }
            this.cardOperateLogicManager.applyPayOrder(this.mIssuerId, this.payAmount, i, 2, this.mProductCode, this);
            return;
        }
        C2538c.c(TAG, new Object[]{"onSelectedWXPay wei xin is not AppInstalled"});
        showErrorDialog(getString(R.string.huaweipay_wechat_pay_err_tips));
    }

    protected void onPause() {
        this.isFinish = true;
        super.onPause();
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
        C2538c.c(TAG, new Object[]{"enter onWindowFocusChangedWait : " + z});
        if (z) {
            this.isFromWindow = true;
            WXPayManager.getInstance().setRequest(false);
            this.isFinish = false;
            onSelectedWXPay();
        }
    }
}
