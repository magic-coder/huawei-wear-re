package com.huawei.nfc.carrera.ui.bus.detail;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4371b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryOfflineTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.UninstallTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OfflineTrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.BusBaseActivity;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.ui.webview.NormalWebViewActivity;
import com.huawei.nfc.carrera.ui.webview.PolicyActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;
import com.huawei.wallet.utils.TimeUtil;

public class BuscardDetailActivity extends BusBaseActivity implements OnClickListener, QueryTrafficCardInfoCallback, QueryAndHandleUnfinishedOrderCallback, QueryOfflineTrafficCardInfoCallback {
    private static final String DIAL_HEAD = "tel:";
    public static final String EXTRA_KEY_CARD_ISSUERID = "traffic_card_issuerId";
    public static final String EXTRA_KEY_CARD_PRODUCTD = "traffic_card_productId";
    private static final String HUAWEI_BJ_AID = "9156000014010001";
    private static final String HUAWEI_BJ_FAQ_URL = "https://pcpay.vmall.com/agreement/leo-card/leo_bj_faq_cn.html";
    private static final String HUAWEI_LN_AID = "5943542E55534552";
    private static final String HUAWEI_LN_FAQ_URL = "https://pcpay.vmall.com/agreement/leo-card/leo_ln_faq_cn.html";
    private static final String HUAWEI_SERVICE_HOTLINE = "4008308300";
    private static final String HUAWEI_SH_AID = "A00000000386980701";
    private static final String HUAWEI_SH_FAQ_URL = "https://pcpay.vmall.com/agreement/leo-card/leo_sh_faq_cn.html";
    private static final String HUAWEI_SUZH_AID = "535558494E2E4D46";
    private static final String HUAWEI_SUZH_FAQ_URL = "https://pcpay.vmall.com/agreement/leo-card/leo_suzh_faq_cn.html";
    private static final String HUAWEI_SZ_AID = "535A542E57414C4C45542E454E56";
    private static final String HUAWEI_SZ_FAQ_URL = "https://pcpay.vmall.com/agreement/leo-card/leo_sz_faq_cn.html";
    private static final String HUAWEI_WN_FAQ_URL = "https://pcpay.vmall.com/agreement/leo-card/leo_wh_faq_cn.html";
    private static final String HUAWEI_WUHANTONG_AID = "A0000053425748544B";
    private static final int RECHARGE_REQUEST_CODE = 100;
    private static final String TAG = "PluginPay BuscardDetailActivity ";
    private String cardAgUrl;
    private Bitmap cardLogo;
    private String cardName;
    private String cardProUrl;
    private TextView mAgreementTv;
    private TextView mBuscardNameTv;
    private ImageView mBuscardRes;
    String mCardAid;
    private C4371b mDealUnfinishedProgressDialog;
    private String mIssuerId;
    private RelativeLayout mLayoutProblem;
    private RelativeLayout mLayoutServiceHotline;
    private RelativeLayout mLayoutTradeDetails;
    private String mMoneyLabel;
    private String mProductId;
    private int mReadCardInfoType = 7;
    private Button mRecharge;
    private String mServiceHotlineNumber;
    private TextView mShowBalance;
    private TextView mShowCardNum;
    private TextView mShowCardValidity;
    private C6002a progress21;
    private Button removeBuscard;

    class C56152 implements UninstallTrafficCardCallback {
        C56152() {
        }

        public void uninstallTrafficCardCallback(int i) {
            BuscardDetailActivity.this.stopProgress();
            switch (i) {
                case 0:
                    LogX.d("PluginPay BuscardDetailActivity uninstallTrafficCardCallback: Delete card success,go to NFC HomeFragment.");
                    BuscardDetailActivity.this.showToast(R.string.nfc_card_delete_done);
                    Intent intent = new Intent();
                    intent.setClass(BuscardDetailActivity.this, CardHolderActivity.class);
                    intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                    intent.setPackage(BuscardDetailActivity.this.getPackageName());
                    BuscardDetailActivity.this.startActivity(intent);
                    break;
                case 11:
                    BuscardDetailActivity.this.showToast(R.string.error_no_network_failed);
                    break;
                case 25:
                    BuscardDetailActivity.this.showToast(R.string.nfc_bindcard_error_connection_failed);
                    break;
                default:
                    BuscardDetailActivity.this.showToast(R.string.nfc_card_delete_fail);
                    break;
            }
            BuscardDetailActivity.this.finish();
        }
    }

    class C56163 implements OnClickListener {
        C56163() {
        }

        public void onClick(View view) {
            BuscardDetailActivity.this.deleteBusCard();
        }
    }

    class C56174 implements OnClickListener {
        C56174() {
        }

        public void onClick(View view) {
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R.layout.nfc_activity_buscard_detail);
        if (initParams()) {
            init();
            return;
        }
        LogX.e("PluginPay BuscardDetailActivity BuscardDetailActivity, initParams failed!");
        finish();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        this.mIssuerId = intent.getStringExtra(EXTRA_KEY_CARD_ISSUERID);
        this.mProductId = intent.getStringExtra(EXTRA_KEY_CARD_PRODUCTD);
        if (!StringUtil.isEmpty(this.mIssuerId, true) && !StringUtil.isEmpty(this.mProductId, true)) {
            return true;
        }
        LogX.e("PluginPay BuscardDetailActivity initParams, illegal params");
        return false;
    }

    protected void init() {
        super.init();
        setTitle(R.string.nfc_cardlist_detail);
        this.mBuscardRes = (ImageView) findViewById(R.id.buscard_detail_icon_iv);
        this.mBuscardNameTv = (TextView) findViewById(R.id.buscard_detail_card_name_tv);
        this.mLayoutTradeDetails = (RelativeLayout) findViewById(R.id.buscard_detail_trade_detail_layout);
        this.mLayoutProblem = (RelativeLayout) findViewById(R.id.buscard_detail_problem_rl);
        this.mRecharge = (Button) findViewById(R.id.buscard_detail_card_charge);
        this.mShowBalance = (TextView) findViewById(R.id.buscard_detail_card_balance);
        this.mShowBalance.setText(R.string.nfc_bus_card_querying);
        this.mShowCardNum = (TextView) findViewById(R.id.buscard_detail_entity_num_tv);
        this.mShowCardNum.setText(R.string.nfc_bus_card_querying);
        this.mShowCardValidity = (TextView) findViewById(R.id.buscard_detail_entity_validity_tv);
        this.mShowCardValidity.setText(R.string.nfc_bus_card_querying);
        this.mLayoutProblem.setOnClickListener(this);
        this.mLayoutTradeDetails.setOnClickListener(this);
        this.mRecharge.setOnClickListener(this);
        this.mLayoutServiceHotline = (RelativeLayout) findViewById(R.id.buscard_detail_hotline_layout);
        this.mLayoutServiceHotline.setOnClickListener(this);
        this.mAgreementTv = (TextView) findViewById(R.id.buscard_detail_agreement_tv);
        this.mAgreementTv.setOnClickListener(this);
        this.removeBuscard = (Button) findViewById(R.id.card_info_delete_buscard);
        this.removeBuscard.setOnClickListener(this);
        this.mDealUnfinishedProgressDialog = C4372a.m21001b(this);
        this.mDealUnfinishedProgressDialog.setCanceledOnTouchOutside(false);
        this.mMoneyLabel = getString(R.string.nfc_money_type);
        showLoadingDialog(R.string.nfc_loading, true, null);
        this.cardInfoManager.queryTrafficCardInfo(this.mIssuerId, 0, "", this);
        this.cardOperateLogicManager.queryOfflineTrafficCardInfo(this.mIssuerId, this.mReadCardInfoType, this);
        this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(this.mIssuerId, 1, this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            this.mShowBalance.setText(R.string.nfc_bus_card_querying);
            this.cardOperateLogicManager.queryOfflineTrafficCardInfo(this.mIssuerId, this.mReadCardInfoType, this);
            cardEventTopUp();
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
        startActivity(intent);
    }

    private void cardEventTopUp() {
        if (!StringUtil.isEmpty(this.mIssuerId, true)) {
            final IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this).cacheIssuerInfoItem(this.mIssuerId);
            if (cacheIssuerInfoItem != null && cacheIssuerInfoItem.getAid() != null) {
                new Thread(new Runnable() {
                    public void run() {
                        WalletTaManager.getInstance(BuscardDetailActivity.this).cardEvent(cacheIssuerInfoItem.getAid(), 1);
                    }
                }).start();
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        if (R.id.buscard_detail_card_charge == id) {
            intent = new Intent(this, BuscardRechargeAcitvity.class);
            intent.putExtra(EXTRA_KEY_CARD_ISSUERID, this.mIssuerId);
            intent.putExtra(EXTRA_KEY_CARD_PRODUCTD, this.mProductId);
            startActivityForResult(intent, 100);
        } else if (R.id.buscard_detail_hotline_layout == id) {
            callServiceHotLine();
        } else if (R.id.buscard_detail_trade_detail_layout == id) {
            intent = new Intent(this, BusCardTradeDetailActivity.class);
            intent.putExtra("enter_type", 0);
            intent.putExtra(EXTRA_KEY_CARD_ISSUERID, this.mIssuerId);
            intent.putExtra("traffic_card_service_hotline", this.mServiceHotlineNumber);
            startActivity(intent);
        } else if (R.id.buscard_detail_problem_rl == id) {
            if (!TextUtils.isEmpty(this.cardProUrl)) {
                goIntoWebview(getString(R.string.nfc_detail_scene_problem_entrance), this.cardProUrl);
            }
        } else if (R.id.buscard_detail_agreement_tv == id) {
            if (!TextUtils.isEmpty(this.cardAgUrl)) {
                goIntoWebview(getString(R.string.nfc_open_buscard_instruction), this.cardAgUrl);
            }
        } else if (R.id.card_info_delete_buscard == id) {
            showDialog();
        }
    }

    private void callServiceHotLine() {
        if (!TextUtils.isEmpty(this.mServiceHotlineNumber)) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(DIAL_HEAD + this.mServiceHotlineNumber)));
            } catch (Throwable e) {
                LogX.e("PluginPay BuscardDetailActivity BuscardDetailActivity go to dial:", e, false);
            }
        }
    }

    private void goIntoWebview(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setClass(this, PolicyActivity.class);
            intent.putExtra(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_TITLE, str);
            intent.putExtra(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_URL, str2);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            LogX.e("PluginPay BuscardDetailActivity BusCard Detail goInto Agreement failed");
        }
    }

    public void queryAndHandleUnfinishedOrderCallback(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        if (handleCommonErrorCode(i)) {
            dismissDealUnfinishedOrderProgress();
            return;
        }
        if (orderHandleResultInfo != null) {
            LogX.i("PluginPay BuscardDetailActivity queryAndHandleUnfinishedOrderCallback total cnt : " + orderHandleResultInfo.getTotalOrderCnt() + " rechargeCnt : " + orderHandleResultInfo.getRechargeOrderCnt() + " issueCnt : " + orderHandleResultInfo.getIssueCardOrderCnt() + " refund : " + orderHandleResultInfo.getRefundOrderCnt());
        }
        switch (i2) {
            case 1201:
                this.cardOperateLogicManager.queryOfflineTrafficCardInfo(this.mIssuerId, this.mReadCardInfoType, this);
                dismissDealUnfinishedOrderProgress();
                showToast(R.string.nfc_bus_card_balance_reach_limit);
                return;
            case 10000:
            case 10001:
                return;
            case 10002:
                this.cardOperateLogicManager.queryOfflineTrafficCardInfo(this.mIssuerId, this.mReadCardInfoType, this);
                cardEventTopUp();
                dismissDealUnfinishedOrderProgress();
                return;
            default:
                return;
        }
    }

    private void dismissDealUnfinishedOrderProgress() {
        if (isFinishing()) {
            LogX.w("PluginPay BuscardDetailActivity dismissDealUnfinishedOrderProgress, activity is finishing");
        } else if (this.mDealUnfinishedProgressDialog != null && this.mDealUnfinishedProgressDialog.isShowing()) {
            this.mDealUnfinishedProgressDialog.dismiss();
        }
    }

    public void queryTrafficCardInfoCallback(int i, TrafficCardInfo trafficCardInfo) {
        if (isFinishing()) {
            LogX.i("PluginPay BuscardDetailActivity queryTrafficCardInfoCallback, activity is finishing");
            return;
        }
        destroyLoadingDialog();
        if (i != 0 || trafficCardInfo == null) {
            handleCommonErrorCode(i);
            finish();
            return;
        }
        LogX.i("PluginPay BuscardDetailActivity queryTrafficCardInfoCallback, info.toString :  " + trafficCardInfo.toString());
        this.cardName = trafficCardInfo.getName();
        this.cardAgUrl = trafficCardInfo.getAgreementUrl();
        this.cardProUrl = trafficCardInfo.getProUrl();
        this.cardLogo = trafficCardInfo.getCardLogo();
        this.mServiceHotlineNumber = trafficCardInfo.getContactHuaweiNum();
        this.mCardAid = trafficCardInfo.getAid();
        if (TextUtils.isEmpty(this.mServiceHotlineNumber)) {
            this.mServiceHotlineNumber = HUAWEI_SERVICE_HOTLINE;
        }
        if ("535A542E57414C4C45542E454E56".equalsIgnoreCase(trafficCardInfo.getAid())) {
            this.cardProUrl = HUAWEI_SZ_FAQ_URL;
        } else if ("9156000014010001".equalsIgnoreCase(trafficCardInfo.getAid())) {
            this.cardProUrl = HUAWEI_BJ_FAQ_URL;
        } else if ("A00000000386980701".equalsIgnoreCase(trafficCardInfo.getAid())) {
            this.cardProUrl = HUAWEI_SH_FAQ_URL;
        } else if ("5943542E55534552".equalsIgnoreCase(trafficCardInfo.getAid())) {
            this.cardProUrl = HUAWEI_LN_FAQ_URL;
        } else if ("A0000053425748544B".equalsIgnoreCase(trafficCardInfo.getAid())) {
            this.cardProUrl = HUAWEI_WN_FAQ_URL;
        } else if ("535558494E2E4D46".equalsIgnoreCase(trafficCardInfo.getAid())) {
            this.cardProUrl = HUAWEI_SUZH_FAQ_URL;
        }
        bindViews(trafficCardInfo);
    }

    private void bindViews(TrafficCardInfo trafficCardInfo) {
        if (!TextUtils.isEmpty(this.cardName)) {
            this.mBuscardNameTv.setText(this.cardName);
        }
        if (this.cardLogo != null) {
            this.mBuscardRes.setImageBitmap(this.cardLogo);
        }
        C2538c.c(TAG, new Object[]{" is test : " + false});
        this.removeBuscard.setVisibility(8);
    }

    public void queryOfflineTrafficCardInfoCallback(int i, OfflineTrafficCardInfo offlineTrafficCardInfo) {
        C2538c.c(TAG, new Object[]{"queryOfflineTrafficCardInfoCallback  resultCode : " + i});
        if (i != 0) {
            handleCommonErrorCode(i);
        } else if (offlineTrafficCardInfo != null) {
            Boolean valueOf;
            this.mShowBalance.setText(this.mMoneyLabel + offlineTrafficCardInfo.getBalance());
            if (!StringUtil.isEmpty(offlineTrafficCardInfo.getCardNo(), true)) {
                this.mShowCardNum.setText(offlineTrafficCardInfo.getCardNo());
            }
            if (!StringUtil.isEmpty(offlineTrafficCardInfo.getExpireDate(), true)) {
                this.mShowCardValidity.setText(offlineTrafficCardInfo.getExpireDate());
                valueOf = Boolean.valueOf(TimeUtil.m28485b(offlineTrafficCardInfo.getExpireDate(), "yyyy/MM/dd"));
                C2538c.b(TAG, new Object[]{"queryOfflineTrafficCardInfoCallback getCardBalance isOverdue : " + valueOf + ",cardInfo.expireDate=" + offlineTrafficCardInfo.getExpireDate()});
                IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this).cacheIssuerInfoItem(this.mIssuerId);
                if (!(cacheIssuerInfoItem == null || !"9156000014010001".equals(cacheIssuerInfoItem.getAid()) || valueOf.booleanValue())) {
                    handleCommonErrorCode(28);
                }
            }
            if (!StringUtil.isEmpty(offlineTrafficCardInfo.getStartdate(), true)) {
                valueOf = Boolean.valueOf(TimeUtil.m28486c(offlineTrafficCardInfo.getStartdate(), "yyyy/MM/dd"));
                C2538c.b(TAG, new Object[]{"queryOfflineTrafficCardInfoCallback getCardBalance notEnabled : " + valueOf + ",cardInfo.startdate=" + offlineTrafficCardInfo.getStartdate()});
                if (valueOf.booleanValue()) {
                    handleCommonErrorCode(26);
                }
            }
        }
    }

    private void deleteBusCard() {
        startProgress(getString(R.string.nfc_card_deleting));
        C2538c.c(TAG, new Object[]{" enter deleteBusCard "});
        LogicApiFactory.createCardOperateApi(getApplicationContext()).uninstallTrafficCard(this.mIssuerId, new C56152());
    }

    private void startProgress(String str) {
        if (this.progress21 == null || !this.progress21.isShowing()) {
            this.progress21 = C6002a.m27468a((Context) this);
            this.progress21.m27476a(str);
            this.progress21.setCanceledOnTouchOutside(false);
            this.progress21.m27474a();
        }
    }

    private void stopProgress() {
        if (this.progress21 != null && this.progress21.isShowing()) {
            this.progress21.dismiss();
            this.progress21 = null;
        }
    }

    private void showDialog() {
        new C6024w(this).m27591a(R.string.nfc_card_list_dialog_title).m27596b(R.string.nfc_delete_buscard_tip).m27597b(R.string.huaweipay_hcoin_use_flow_cancel, new C56174()).m27593a(R.string.huaweipay_hcoin_use_flow_sure, new C56163()).m27590a().show();
    }
}
