package com.huawei.nfc.carrera.ui.bus.opencard;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportedTrafficCardListCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportedTrafficCardListItem;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.cardoperate.response.InitEseResultCallback;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.ui.bindcard.CardInstructionActivity;
import com.huawei.nfc.carrera.ui.bus.BusBaseActivity;
import com.huawei.nfc.carrera.ui.bus.adapter.BusCardSwitchAdapter;
import com.huawei.nfc.carrera.ui.bus.detail.BuscardDetailActivity;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.ui.bus.util.TimeUtil;
import com.huawei.nfc.carrera.ui.cardlist.AddBankOrBusCardActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.Map;

public class BindBusCardSwitchActivity extends BusBaseActivity implements QuerySupportedTrafficCardListCallback, IssueTrafficCardCallback, QueryAndHandleUnfinishedOrderCallback, InitEseResultCallback {
    public static final String KEY_ENTERANCE = "key_enterance";
    private static final String SUPPORT_CARD_BJ = "90000028";
    private static final String SUPPORT_CARD_LIST = "SUPPORT_CARD_LIST";
    private static final String SUPPORT_CARD_SZ = "90000025";
    private static final String TAG = "PluginPay BindBusCardSwitchActivity ";
    public static final String TRAFFIC_CARD_ISSUE_REQUEST_ID = "traffic_card_issue_request_id";
    private ListView cardListLayout;
    private LinearLayout emptyListLayout;
    private int entranceType = -1;
    private String issuerId;
    private LinearLayout loadingLayout;
    private String mCardAid;
    private String mCardName;
    private long mCardRequestId;
    private C6022u mCustomDlg = null;
    private ArrayList<String> supportList = null;

    class C56351 implements OnItemClickListener {
        C56351() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (TimeUtil.isFastDoubleClick()) {
                LogX.e("PluginPay BindBusCardSwitchActivity onClick, isFastDoubleClick");
                return;
            }
            SupportedTrafficCardListItem supportedTrafficCardListItem = (SupportedTrafficCardListItem) view.getTag();
            int status = supportedTrafficCardListItem.getStatus();
            BindBusCardSwitchActivity.this.issuerId = supportedTrafficCardListItem.getIssuerId();
            BindBusCardSwitchActivity.this.mCardName = supportedTrafficCardListItem.getCardName();
            BindBusCardSwitchActivity.this.mCardAid = supportedTrafficCardListItem.getAid();
            C2538c.b(BindBusCardSwitchActivity.TAG, new Object[]{"buscard status : " + status + " ; issuerId : " + BindBusCardSwitchActivity.this.issuerId});
            if (BindBusCardSwitchActivity.this.supportList != null) {
                for (int i2 = 0; i2 < BindBusCardSwitchActivity.this.supportList.size(); i2++) {
                    C2538c.b(BindBusCardSwitchActivity.TAG, new Object[]{"supportList issruerID : " + ((String) BindBusCardSwitchActivity.this.supportList.get(i2))});
                }
                if (!(BindBusCardSwitchActivity.this.supportList.contains(BindBusCardSwitchActivity.this.issuerId) || BindBusCardSwitchActivity.SUPPORT_CARD_SZ.equals(BindBusCardSwitchActivity.this.issuerId) || "90000028".equals(BindBusCardSwitchActivity.this.issuerId))) {
                    BindBusCardSwitchActivity.this.showDialog();
                    return;
                }
            }
            C2538c.b(BindBusCardSwitchActivity.TAG, new Object[]{"supportList is null "});
            if (!(BindBusCardSwitchActivity.SUPPORT_CARD_SZ.equals(BindBusCardSwitchActivity.this.issuerId) || "90000028".equals(BindBusCardSwitchActivity.this.issuerId))) {
                BindBusCardSwitchActivity.this.showDialog();
                return;
            }
            switch (status) {
                case 0:
                    LogX.i("PluginPay BindBusCardSwitchActivity tsm , card not opened ," + supportedTrafficCardListItem.getIssuerId());
                    BindBusCardSwitchActivity.this.cardOperateLogicManager.preIssueTrafficCard(supportedTrafficCardListItem.getIssuerId());
                    BindBusCardSwitchActivity.this.jumpToCardInstructionActivity(BindBusCardSwitchActivity.this.issuerId, 11, BindBusCardSwitchActivity.this.mCardName, BindBusCardSwitchActivity.this.mCardRequestId);
                    return;
                case 2:
                    LogX.i("PluginPay BindBusCardSwitchActivity detail issuerId." + supportedTrafficCardListItem.toString());
                    BindBusCardSwitchActivity.this.jumpToCardDeatil(supportedTrafficCardListItem.getIssuerId(), supportedTrafficCardListItem.getProductId());
                    return;
                case 11:
                case 12:
                    BindBusCardSwitchActivity.this.showOpenCardProgressDialog();
                    BindBusCardSwitchActivity.this.cardOperateLogicManager.queryAndHandleUnfinfishedOrders(supportedTrafficCardListItem.getIssuerId(), 0, BindBusCardSwitchActivity.this);
                    return;
                case 13:
                    BindBusCardSwitchActivity.this.showOpenCardProgressDialog();
                    BindBusCardSwitchActivity.this.cardOperateLogicManager.issueTrafficCard(supportedTrafficCardListItem.getIssuerId(), null, BindBusCardSwitchActivity.this);
                    return;
                default:
                    LogX.e("PluginPay BindBusCardSwitchActivity initCardList, error card status!");
                    return;
            }
        }
    }

    class C56362 implements OnClickListener {
        C56362() {
        }

        public void onClick(View view) {
            BindBusCardSwitchActivity.this.mCustomDlg.dismiss();
            BindBusCardSwitchActivity.this.mCustomDlg = null;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setTitle(R.string.nfc_buscard_select_service_area);
        setContentView(R.layout.nfc_bind_bus_card_switch_activity);
        this.supportList = getIntent().getStringArrayListExtra(SUPPORT_CARD_LIST);
        init();
    }

    protected void onResume() {
        C2538c.b(TAG, new Object[]{" supportList : " + this.supportList});
        if (this.supportList == null) {
            this.supportList = ESEInfoManager.getInstance(this.mContext).getSupportList();
        }
        this.cardInfoManager.querySupportedTrafficCardList(this);
        super.onResume();
    }

    protected void init() {
        super.init();
        this.loadingLayout = (LinearLayout) findViewById(R.id.bind_bus_cardlist_loading_layout);
        ProgressBar progressBar = (ProgressBar) this.loadingLayout.findViewById(R.id.progress_bar);
        if (VERSION.SDK_INT > 22) {
            progressBar.setIndeterminateDrawable(this.mContext.getApplicationContext().getResources().getDrawable(R.drawable.app_update_checking));
        }
        this.emptyListLayout = (LinearLayout) findViewById(R.id.bind_bus_cardlist_empty_layout);
        this.cardListLayout = (ListView) findViewById(R.id.bind_bus_card_switch_list);
        Intent intent = getIntent();
        if (intent != null) {
            this.mCardRequestId = intent.getLongExtra(TRAFFIC_CARD_ISSUE_REQUEST_ID, 0);
        }
        this.cardOperateLogicManager.initEseInfo(this);
        showWhichLayout(0, 8, 8);
    }

    private void initCardList(ArrayList<SupportedTrafficCardListItem> arrayList) {
        LogX.i("PluginPay BindBusCardSwitchActivity initCardList start");
        this.cardListLayout.setAdapter(new BusCardSwitchAdapter(getApplicationContext(), arrayList));
        this.cardListLayout.setOnItemClickListener(new C56351());
        LogX.i("PluginPay BindBusCardSwitchActivity initCardList end");
    }

    private void showOpenCardProgressDialog() {
        if (this.pluginPayAdapter == null) {
            return;
        }
        if (this.pluginPayAdapter.getDeviceProtocol() == 13) {
            showProgress(this.progressDialog21, getString(R.string.nfc_bind_bus_opening_card_new1), false, null);
        } else {
            showProgress(this.progressDialog21, getString(R.string.nfc_bind_bus_opening_card_new), false, null);
        }
    }

    private void jumpToCardDeatil(String str, String str2) {
        Intent intent = new Intent(this, BuscardDetailActivity.class);
        intent.putExtra(BuscardDetailActivity.EXTRA_KEY_CARD_ISSUERID, str);
        intent.putExtra(BuscardDetailActivity.EXTRA_KEY_CARD_PRODUCTD, str2);
        startActivity(intent);
    }

    public void querySupportedTrafficCardListCallback(Map<String, SupportedTrafficCardListItem> map) {
        if (isFinishing()) {
            LogX.i("PluginPay BindBusCardSwitchActivity querySupportedTrafficCardListCallback, activity is finishing");
            return;
        }
        LogX.i("PluginPay BindBusCardSwitchActivity querySupportedTrafficCardListCallback begin");
        if (map == null || map.isEmpty()) {
            showWhichLayout(8, 0, 8);
            LogX.e("PluginPay BindBusCardSwitchActivity querySupportedTrafficCardListCallback, empty list");
            return;
        }
        showWhichLayout(8, 8, 0);
        initCardList(new ArrayList(map.values()));
    }

    public void queryAndHandleUnfinishedOrderCallback(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        upLoadLog(i, i2, orderHandleResultInfo);
        if (i != 0) {
            dismissProgress(this.progressDialog21);
            jump2ResultActivity(getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.issuerId, this.mCardAid, this.entranceType, true, true);
            return;
        }
        if (orderHandleResultInfo != null) {
            LogX.i("PluginPay BindBusCardSwitchActivity BindBusCardSwitchActivity queryAndHandleUnfinishedOrderCallback total cnt : " + orderHandleResultInfo.getTotalOrderCnt() + " rechargeCnt : " + orderHandleResultInfo.getRechargeOrderCnt() + " issueCnt : " + orderHandleResultInfo.getIssueCardOrderCnt() + " refund : " + orderHandleResultInfo.getRefundOrderCnt());
        }
        switch (i2) {
            case 10000:
                dismissProgress(this.progressDialog21);
                jump2ResultActivity(getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.issuerId, this.mCardAid, this.entranceType, false, true);
                return;
            case 10001:
                return;
            case 10002:
                dismissProgress(this.progressDialog21);
                if (orderHandleResultInfo == null || orderHandleResultInfo.getIssueCardOrderCnt() <= 0) {
                    jump2ResultActivity(getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.issuerId, this.mCardAid, this.entranceType, true, true);
                    return;
                }
                this.cardInfoManager.refreshCardList();
                jump2ResultActivity(getString(R.string.nfc_bind_bus_card_success), getString(R.string.nfc_bind_bus_success_decribe_text), 0, this.issuerId, this.mCardAid, this.entranceType, false, true);
                return;
            default:
                return;
        }
    }

    private void showWhichLayout(int i, int i2, int i3) {
        if (this.loadingLayout != null) {
            this.loadingLayout.setVisibility(i);
        }
        if (this.emptyListLayout != null) {
            this.emptyListLayout.setVisibility(i2);
        }
        if (this.cardListLayout != null) {
            this.cardListLayout.setVisibility(i3);
        }
    }

    public void issueTrafficCardCallback(int i) {
        dismissProgress(this.progressDialog21);
        if (!handleCommonErrorCode(i)) {
            if (i == 0) {
                openCardLogUpload(this.issuerId, "0", "");
                this.cardInfoManager.refreshCardList();
                jump2ResultActivity(getString(R.string.nfc_bind_bus_card_success), getString(R.string.nfc_bind_bus_success_decribe_text), 0, this.issuerId, this.mCardAid, this.entranceType, false, true);
                return;
            }
            if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
                openCardLogUpload(this.issuerId, String.valueOf(i), "issueTrafficCardCallback, issue Traffic Card fail");
            }
            jump2ResultActivity(getString(R.string.nfc_bind_bus_card_fail), getErrorMessage(i), 1, this.issuerId, this.mCardAid, this.entranceType, true, true);
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, AddBankOrBusCardActivity.class);
        intent.setFlags(65536);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

    private void jumpToCardInstructionActivity(String str, int i, String str2, long j) {
        LogX.d("PluginPay BindBusCardSwitchActivity jumpToCardInstructionActivity.issuerId." + str + ",cardType" + i);
        Intent intent = new Intent(this, CardInstructionActivity.class);
        intent.putExtra("issuer_id", str);
        intent.putExtra("card_type", i);
        intent.putExtra("card_name", str2);
        intent.putExtra(ShowBindBusResultActivity.CARD_REQUEST_ID_KEY, j);
        intent.putExtra("key_enterance", this.entranceType);
        startActivity(intent);
        finish();
    }

    public void initEseResult(int i) {
    }

    private void showDialog() {
        if (this.mCustomDlg == null || !this.mCustomDlg.isShowing()) {
            C6024w c6024w = new C6024w(this.mContext);
            c6024w.m27591a(R.string.nfc_card_list_dialog_title);
            c6024w.m27596b(R.string.nfc_device_version_does_not_support_the_city_bus_card);
            c6024w.m27593a(R.string.nfc_quick_pass_button_text, new C56362());
            this.mCustomDlg = c6024w.m27590a();
            this.mCustomDlg.setCancelable(false);
            if (!this.mCustomDlg.isShowing()) {
                this.mCustomDlg.show();
                return;
            }
            return;
        }
        C2538c.b(TAG, new Object[]{"showDialogSetlock Already show!"});
    }

    protected String getErrorMessage(int i) {
        String commonErrorMessage = super.getCommonErrorMessage(i);
        if (commonErrorMessage != null) {
            return commonErrorMessage;
        }
        switch (i) {
            case 10:
            case 99:
                return getString(R.string.nfc_create_order_failed);
            case 1008:
            case IssueTrafficCardCallback.RETURN_FAILED_CITYCODE_ILLEGAL /*1103*/:
                return getString(R.string.nfc_get_city_failed);
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

    private void upLoadLog(int i, int i2, OrderHandleResultInfo orderHandleResultInfo) {
        if (i != 0) {
            if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
                openCardLogUpload(this.issuerId, String.valueOf(i), "queryAndHandleUnfinishedOrderCallback, query Unfinished Order fail");
            }
        } else if (i2 != 10002 || orderHandleResultInfo == null || orderHandleResultInfo.getIssueCardOrderCnt() <= 0) {
            openCardLogUpload(this.issuerId, "1", "queryAndHandleUnfinishedOrderCallback, resultType : " + i2);
        } else {
            openCardLogUpload(this.issuerId, "0", "");
        }
    }
}
