package com.huawei.nfc.carrera.ui.bus.exception;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.SyncFileToWatchTask;
import com.huawei.nfc.carrera.logic.cardinfo.model.WalletSupportInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.ui.bus.BusBaseActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;
import com.huawei.pay.ui.util.UiUtil;
import com.huawei.wallet.R;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowBindBusResultActivity extends BusBaseActivity implements IssueTrafficCardCallback, QueryAndHandleUnfinishedOrderCallback {
    public static final String CARD_AID = "card_aid";
    public static final String CARD_NAME_KEY = "card_name";
    public static final String CARD_REQUEST_ID_KEY = "card_request_id";
    public static final String ENTERANCE_KEY = "key_enterance";
    public static final String FAIL_DESC_KEY = "fail_desc";
    public static final String FAIL_OPR_TYPE_KEY = "opr_type";
    public static final String FAIL_REASON_KEY = "fail_reason";
    public static final String ISSUERID_KEY = "issuerId";
    public static final int KNOW_IT = 1;
    public static final boolean NEED_RETRY = true;
    public static final boolean NOT_RETRY = false;
    public static final String OPENCARD_KEY = "open_card";
    public static final boolean OPEN_CARD = true;
    public static final boolean RECHARGE = false;
    public static final int RECHARGE_SUCCESS = 2;
    public static final String RETRY_KEY = "need_retry";
    public static final String STARTED_BY_BUSADDACTIVITY = "started_by_which_activity";
    public static final int SUCCESS = 0;
    private static final String TAG = "ShowBindBusResultActivity";
    private static ExecutorService threadPool = Executors.newFixedThreadPool(1);
    private Button btnOK;
    private int entranceType = -1;
    private ImageView imgFailIcon;
    public boolean isNeedRetry;
    public boolean isOpenCard;
    private boolean isSupportDefaultCard = false;
    private String issuerId;
    private String mAid;
    private LinearLayout mBindCardFailedLayout;
    private String mCardName = "";
    private long mCardRequestId;
    private boolean mIsSetAsDefaultCard;
    private int mOprType;
    private RelativeLayout mSetDefaultCardLayout;
    private LinearLayout mSetDefaultCardTipsLayout;
    private boolean mStartedByBindBusCardAddActivity;
    private String strFailDesc;
    private String strFailReason;
    private TextView textFailDesc;
    private TextView textFailReason;

    class C56241 implements OnClickListener {
        C56241() {
        }

        public void onClick(View view) {
            LogX.i("OnClick: mOprType=" + ShowBindBusResultActivity.this.mOprType + ", mIsSetAsDefaultCard=" + ShowBindBusResultActivity.this.mIsSetAsDefaultCard + ", mAid=" + ShowBindBusResultActivity.this.mAid);
            if (ShowBindBusResultActivity.this.isNeedRetry) {
                TACardInfo access$400 = ShowBindBusResultActivity.this.getOpenFailedBusCard(ShowBindBusResultActivity.this.issuerId);
                if (access$400 == null) {
                    ShowBindBusResultActivity.this.strFailReason = ShowBindBusResultActivity.this.getString(R.string.nfc_unknow_error);
                    ShowBindBusResultActivity.this.isNeedRetry = false;
                    ShowBindBusResultActivity.this.updateView();
                    return;
                }
                ShowBindBusResultActivity.this.showProgress(ShowBindBusResultActivity.this.progressDialog21, ShowBindBusResultActivity.this.getString(R.string.nfc_retrying), false, null);
                ShowBindBusResultActivity.this.doRetry(access$400.getCardStatus());
                return;
            }
            ShowBindBusResultActivity.this.finish();
        }
    }

    class C56252 implements OnCheckedChangeListener {
        C56252() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ShowBindBusResultActivity.this.mIsSetAsDefaultCard = z;
        }
    }

    class SetCardDefaultCallbackImpl implements SetCardDefaultCallback {
        private Context mContext;

        public SetCardDefaultCallbackImpl(Context context) {
            this.mContext = context;
        }

        public void setResultCallback(int i) {
            C2538c.c(ShowBindBusResultActivity.TAG, new Object[]{"ShowBindBusResultActivity setResultCallback, resultCode=" + i});
            TACardInfo defaultCard = WalletTaManager.getInstance(this.mContext).getDefaultCard();
            if (defaultCard != null && defaultCard.getCardGroupType() == 2) {
                String issuerId = defaultCard.getIssuerId();
                C2538c.c(ShowBindBusResultActivity.TAG, new Object[]{"syncRFConfFiles after traffic card openned.try to download rfconf for new default card. new card issueid : " + issuerId});
            }
        }
    }

    class SyncFile implements Runnable {
        private SyncFile() {
        }

        public void run() {
            C2538c.b(ShowBindBusResultActivity.TAG, new Object[]{"enter SyncFile"});
            String cardproductIdByIssuerId = WalletTaManager.getInstance(ShowBindBusResultActivity.this.mContext).getCardproductIdByIssuerId(ShowBindBusResultActivity.this.issuerId);
            C2538c.c(ShowBindBusResultActivity.TAG, new Object[]{"syncFileToWatch  productId = " + cardproductIdByIssuerId});
            new SyncFileToWatchTask(ShowBindBusResultActivity.this.mContext).sendBTOfCardPicInfor(cardproductIdByIssuerId);
            C2538c.c(ShowBindBusResultActivity.TAG, new Object[]{"SyncFile end "});
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nfc_show_bind_bus_result_activity);
        super.init();
        if (initParams()) {
            setTitle(R.string.nfc_name);
            this.imgFailIcon = (ImageView) findViewById(R.id.nfc_bind_bus_card_fail_icon);
            UiUtil.setViewMargin((Activity) this, this.parentBodyLinearLayout, this.imgFailIcon, (float) NFCBaseActivity.PERCENT_MARGIN_30);
            this.textFailDesc = (TextView) findViewById(R.id.bind_bus_card_fail);
            this.btnOK = (Button) findViewById(R.id.nfc_bind_bus_fail_btn);
            this.mBindCardFailedLayout = (LinearLayout) findViewById(R.id.nfc_bind_bus_card_failed_layout);
            this.textFailReason = (TextView) findViewById(R.id.bind_bus_card_result);
            this.mSetDefaultCardLayout = (RelativeLayout) findViewById(R.id.nfc_set_default_card_checkbox_layout);
            this.mSetDefaultCardTipsLayout = (LinearLayout) findViewById(R.id.nfc_set_default_card_tips_layout);
            updateView();
            this.btnOK.setOnClickListener(new C56241());
            return;
        }
        finish();
    }

    private TACardInfo getOpenFailedBusCard(String str) {
        List<TACardInfo> cardList = WalletTaManager.getInstance(getApplicationContext()).getCardList();
        if (cardList == null) {
            return null;
        }
        for (TACardInfo tACardInfo : cardList) {
            if (str.equals(tACardInfo.getIssuerId())) {
                return tACardInfo;
            }
        }
        return null;
    }

    private int getCards() {
        List cardList = WalletTaManager.getInstance(getApplicationContext()).getCardList();
        if (cardList == null) {
            return 0;
        }
        LogX.i("getCards, list.size()=" + cardList.size());
        return cardList.size();
    }

    private void doRetry(int i) {
        LogX.i("ShowBindBusResultActivity-doRetry, cardStatus=" + i);
        if (!this.isOpenCard) {
            this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(this.issuerId, 1, this);
        } else if (11 == i || 12 == i) {
            this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(this.issuerId, 0, this);
        } else if (13 == i) {
            this.cardOperateLogicManager.issueTrafficCard(this.issuerId, null, this);
        }
    }

    private void updateView() {
        if (this.mOprType != 0) {
            showHead(this.strFailDesc);
            this.mBindCardFailedLayout.setVisibility(0);
            this.imgFailIcon.setImageResource(R.drawable.ic_failure_normal);
            if (this.isNeedRetry) {
                this.btnOK.setText(getString(R.string.nfc_retry));
                if (this.isOpenCard) {
                    this.strFailReason = String.format(getString(R.string.nfc_bus_card_bind_fail_do_not_pay_again), new Object[]{this.strFailReason});
                } else {
                    this.strFailReason = getString(R.string.nfc_bus_card_recharge_fail_retry);
                }
            } else {
                this.btnOK.setText(getString(R.string.nfc_quick_pass_button_text));
                if (this.isOpenCard) {
                    this.strFailReason = String.format(getString(R.string.nfc_bus_card_bind_fail_go_to_card_list), new Object[]{"", "", ""});
                } else if (getOpenFailedBusCard(this.issuerId) == null) {
                    this.strFailReason = getString(R.string.nfc_bus_card_recharge_fail_retry);
                } else {
                    this.strFailReason = getString(R.string.nfc_bus_card_recharge_fail_can_not_retry);
                }
            }
        } else if (this.isOpenCard) {
            this.btnOK.setText(getString(R.string.nfc_bind_success));
            showHead(this.strFailDesc);
            if (!this.isSupportDefaultCard || getCards() < 2) {
                this.imgFailIcon.setImageResource(R.drawable.ic_successful_normal);
                this.mSetDefaultCardLayout.setVisibility(8);
                this.mSetDefaultCardTipsLayout.setVisibility(8);
                this.mBindCardFailedLayout.setVisibility(0);
                if (this.isSupportDefaultCard && getCards() < 2) {
                    this.strFailReason = getString(R.string.nfc_bind_bus_success_decribe_text_band);
                }
            } else {
                this.mSetDefaultCardLayout.setVisibility(4);
                this.mSetDefaultCardTipsLayout.setVisibility(0);
                this.mBindCardFailedLayout.setVisibility(8);
                CheckBox checkBox = (CheckBox) findViewById(R.id.nfc_set_default_card_checkbox);
                this.mIsSetAsDefaultCard = true;
                ((TextView) findViewById(R.id.nfc_set_default_card_tips_1_txt)).setText(getString(R.string.nfc_set_default_card_operation_tips_1, new Object[]{Integer.valueOf(1)}));
                ((TextView) findViewById(R.id.nfc_set_default_card_tips_2_txt)).setText(getString(R.string.nfc_set_default_card_operation_tips_2, new Object[]{Integer.valueOf(2)}));
                checkBox.setOnCheckedChangeListener(new C56252());
            }
            LogicApiFactory.createCardManager(this.mContext).syncRFConfFiles(true);
            syncFileToWatch();
        } else {
            this.imgFailIcon.setImageResource(R.drawable.ic_successful_normal);
            this.btnOK.setText(getString(R.string.nfc_ok));
            showHead(this.strFailDesc);
            this.mSetDefaultCardLayout.setVisibility(8);
            this.mSetDefaultCardTipsLayout.setVisibility(8);
            this.mBindCardFailedLayout.setVisibility(0);
        }
        this.textFailDesc.setText(this.strFailDesc);
        if (this.strFailReason != null) {
            this.textFailReason.setVisibility(0);
            this.textFailReason.setText(this.strFailReason);
        }
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        this.strFailDesc = extras.getString("fail_desc");
        this.strFailReason = extras.getString(FAIL_REASON_KEY);
        this.mOprType = extras.getInt(FAIL_OPR_TYPE_KEY);
        this.issuerId = extras.getString("issuerId");
        this.entranceType = extras.getInt("key_enterance");
        this.mCardName = extras.getString("card_name", "");
        this.mCardRequestId = extras.getLong(CARD_REQUEST_ID_KEY, 0);
        this.mAid = extras.getString(CARD_AID);
        this.isNeedRetry = extras.getBoolean(RETRY_KEY);
        this.isOpenCard = extras.getBoolean(OPENCARD_KEY);
        this.mStartedByBindBusCardAddActivity = extras.getBoolean(STARTED_BY_BUSADDACTIVITY);
        C2538c.c(TAG, new Object[]{"initParams(),strFailDesc=" + this.strFailDesc + ",strFailReason=" + this.strFailReason + ",mOprType=" + this.mOprType + ",mIssuerId=" + this.issuerId});
        updateSupportDefaultCard();
        return true;
    }

    private void updateSupportDefaultCard() {
        WalletSupportInfo walletAbility = ESEInfoManager.getInstance(getApplicationContext()).getWalletAbility();
        if (walletAbility == null || 1 != walletAbility.getSupportDefautcard()) {
            C2538c.b(TAG, new Object[]{"initCardsView(),walletSupportInfo enter else"});
            this.isSupportDefaultCard = false;
            return;
        }
        C2538c.b(TAG, new Object[]{"initCardsView(),walletSupportInfo=" + walletAbility});
        this.isSupportDefaultCard = true;
    }

    public void queryAndHandleUnfinishedOrderCallback(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        LogX.i("ShowBindBusResultActivity-queryAndHandleUnfinishedOrderCallback, resultCode=" + i + " resultType=" + i2);
        if (i != 0) {
            this.strFailReason = getErrorMessage(i);
            updateView();
            dismissProgress(this.progressDialog21);
            return;
        }
        if (orderHandleResultInfo != null) {
            LogX.i("queryAndHandleUnfinishedOrderCallback total cnt : " + orderHandleResultInfo.getTotalOrderCnt() + " rechargeCnt : " + orderHandleResultInfo.getRechargeOrderCnt() + " issueCnt : " + orderHandleResultInfo.getIssueCardOrderCnt() + " refund : " + orderHandleResultInfo.getRefundOrderCnt());
        }
        if (10001 == i2) {
            C2538c.c(TAG, new Object[]{" exists_unfinished_orders return"});
            return;
        }
        dealResultType(i2, orderHandleResultInfo);
        updateView();
    }

    public void issueTrafficCardCallback(int i) {
        LogX.i("ShowBindBusResultActivity-issueTrafficCardCallback, resultCode=" + i);
        dismissProgress(this.progressDialog21);
        if (i == 0) {
            openCardLogUpload(this.issuerId, "0", "");
            this.mOprType = 0;
            this.isNeedRetry = false;
            this.strFailDesc = getString(R.string.nfc_bind_bus_card_success);
            this.strFailReason = getString(R.string.nfc_bind_bus_success_decribe_text);
            LogicApiFactory.createCardManager(this.mContext).syncRFConfFiles(true);
            syncFileToWatch();
        } else {
            this.strFailReason = getErrorMessage(i);
        }
        updateView();
    }

    private void dealResultType(int i, OrderHandleResultInfo orderHandleResultInfo) {
        switch (i) {
            case 1201:
                this.strFailReason = getString(R.string.nfc_balance_reach_limit);
                this.isNeedRetry = false;
                dismissProgress(this.progressDialog21);
                return;
            case 10000:
                if (this.isOpenCard) {
                    this.strFailReason = getString(R.string.nfc_invocate_card_fail);
                } else {
                    this.strFailReason = getString(R.string.nfc_recharge_fail_customer_service);
                }
                this.isNeedRetry = false;
                dismissProgress(this.progressDialog21);
                return;
            case 10001:
                return;
            case 10002:
                if (this.isOpenCard) {
                    if (orderHandleResultInfo == null || orderHandleResultInfo.getIssueCardOrderCnt() <= 0) {
                        this.strFailReason = getString(R.string.nfc_sp_return_failed);
                    } else {
                        this.mOprType = 0;
                        this.isNeedRetry = false;
                        this.strFailReason = getString(R.string.nfc_bind_bus_success_decribe_text);
                        this.strFailDesc = getString(R.string.nfc_bind_bus_card_success);
                        LogicApiFactory.createCardManager(this.mContext).syncRFConfFiles(true);
                        syncFileToWatch();
                    }
                } else if (orderHandleResultInfo == null || orderHandleResultInfo.getRechargeOrderCnt() <= 0) {
                    this.strFailReason = getString(R.string.nfc_recharge_fail);
                } else {
                    this.mOprType = 0;
                    this.isNeedRetry = false;
                    this.strFailReason = "";
                    this.strFailDesc = getString(R.string.nfc_bus_card_recharge_success);
                    setResult(-1);
                }
                dismissProgress(this.progressDialog21);
                return;
            default:
                dismissProgress(this.progressDialog21);
                return;
        }
    }

    protected String getErrorMessage(int i) {
        String commonErrorMessage = super.getCommonErrorMessage(i);
        if (commonErrorMessage != null) {
            return commonErrorMessage;
        }
        if (this.isOpenCard) {
            switch (i) {
                case 10:
                case 99:
                case IssueTrafficCardCallback.RETURN_FAILED_REPEAT_ISSUERCARD /*1102*/:
                    return getString(R.string.nfc_sp_return_failed);
                case 1008:
                case IssueTrafficCardCallback.RETURN_FAILED_CITYCODE_ILLEGAL /*1103*/:
                    return getString(R.string.nfc_get_city_failed);
                case 1010:
                    return getString(R.string.nfc_sp_out_of_service);
                case IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT /*1101*/:
                    return getString(R.string.nfc_bind_card_fail_open_overcount);
                case IssueTrafficCardCallback.RETURN_FAILED_SSD_INSTALL_FAILED /*1104*/:
                    return getString(R.string.nfc_ssd_install_failed);
                default:
                    return getString(R.string.nfc_sp_return_failed);
            }
        }
        switch (i) {
            case 10:
            case 99:
            case RechargeCallback.RETURN_RECHARGE_FAILED_RETRYABLE /*1302*/:
            case RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE_RETRYABLE /*1303*/:
                return getString(R.string.nfc_recharge_fail);
            case 1008:
            case IssueTrafficCardCallback.RETURN_FAILED_CITYCODE_ILLEGAL /*1103*/:
                return getString(R.string.nfc_get_city_failed);
            case 1301:
            case RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE /*1304*/:
                return getString(R.string.nfc_recharge_fail_customer_service);
            default:
                return getString(R.string.nfc_recharge_fail);
        }
    }

    private void syncFileToWatch() {
        C2538c.c(TAG, new Object[]{"syncFileToWatch  IssuerId = " + this.issuerId});
        threadPool.execute(new SyncFile());
    }

    protected void refreshView(boolean z) {
        super.refreshView(z);
        if (this.mDevicesConnecteStatus == 2) {
            updateSupportDefaultCard();
        }
    }
}
