package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;
import com.huawei.nfc.carrera.ui.bus.detail.BuscardDetailActivity;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.ui.bus.opencard.BindBusCardAddActivity;
import com.huawei.nfc.carrera.ui.bus.opencard.BindBusCardSwitchActivity;
import com.huawei.nfc.carrera.ui.webview.WebViewActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.p130e.p489b.C5728a;
import com.huawei.wallet.R;

public class CardInstructionActivity extends WebViewActivity {
    private static final String KEY_ENTERANCE = "key_enterance";
    private final String TAG = CardInstructionActivity.class.getSimpleName();
    private int cardType;
    private int entranceType = -1;
    private String fPan;
    private String issuerId;
    private int issuerMode;
    private String mCardName;
    private long mCardRequestId;
    private String mInstructionUrl;

    class C55781 implements QueryTrafficCardInfoCallback {
        C55781() {
        }

        public void queryTrafficCardInfoCallback(int i, TrafficCardInfo trafficCardInfo) {
            if (trafficCardInfo != null) {
                CardInstructionActivity.this.mInstructionUrl = trafficCardInfo.getLicUrl();
                if (!StringUtil.isEmpty(CardInstructionActivity.this.mInstructionUrl, true)) {
                    CardInstructionActivity.this.loadWebView(CardInstructionActivity.this.mInstructionUrl);
                    return;
                }
                return;
            }
            LogX.e(CardInstructionActivity.this.TAG, "queryTrafficCardInfoCallback error");
        }
    }

    class C55792 implements QueryBankIssuerInfoCallback {
        C55792() {
        }

        public void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo) {
            LogX.e(CardInstructionActivity.this.TAG, "queryBankIssuerInfoCallback begin");
            if (i == 0 && bankIssuerInfo != null) {
                if (3 == CardInstructionActivity.this.cardType) {
                    CardInstructionActivity.this.mInstructionUrl = bankIssuerInfo.getCreditTcUrl();
                } else if (2 == CardInstructionActivity.this.cardType) {
                    CardInstructionActivity.this.mInstructionUrl = bankIssuerInfo.getDebitTcUrl();
                } else {
                    LogX.e("initCardInstructionUrl, card type illegal.");
                    return;
                }
                if (!StringUtil.isEmpty(CardInstructionActivity.this.mInstructionUrl, true)) {
                    LogX.e(CardInstructionActivity.this.TAG, "queryBankIssuerInfoCallback is ok.mInstructionUrl." + CardInstructionActivity.this.mInstructionUrl);
                    CardInstructionActivity.this.loadWebView(CardInstructionActivity.this.mInstructionUrl);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        if (initParams()) {
            initAndLoadCardInstructionUrl();
        } else {
            finish();
        }
    }

    protected String getTitleStrResc() {
        return getString(R.string.nfc_open_card_instruction);
    }

    protected void loadWebviewSuccess() {
        LogX.d(this.TAG, "loadWebviewSuccess");
        if (this.webviewCodeResult == 0) {
            this.acceptButton.setVisibility(0);
            this.acceptButton.setEnabled(true);
            return;
        }
        this.acceptButton.setVisibility(8);
    }

    protected void loadWebviewFailed() {
        LogX.d(this.TAG, "loadWebviewFailed");
        this.acceptButton.setVisibility(8);
    }

    protected void loadingProgress() {
        LogX.d(this.TAG, "loadingProgress");
        this.acceptButton.setVisibility(0);
        this.acceptButton.setEnabled(false);
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            LogX.e(this.TAG, "initParams intent empty.");
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e(this.TAG, "bundle empty.");
            return false;
        }
        this.issuerId = extras.getString("issuer_id");
        this.fPan = C5728a.m26404b(extras.getString(InputCardNumActivity.INTENT_KEY_CARD_NUM), getApplicationContext());
        this.cardType = extras.getInt("card_type");
        this.issuerMode = extras.getInt("issuer_mode");
        this.mCardRequestId = extras.getLong(ShowBindBusResultActivity.CARD_REQUEST_ID_KEY, 0);
        this.mCardName = extras.getString("card_name");
        if (StringUtil.isEmpty(this.issuerId, true)) {
            return false;
        }
        if (this.cardType == 11) {
            return true;
        }
        return true;
    }

    private void initAndLoadCardInstructionUrl() {
        if (this.cardType == 11) {
            setTitle(R.string.nfc_open_buscard_instruction);
            LogicApiFactory.createCardManager(getApplicationContext()).queryTrafficCardInfo(this.issuerId, 0, "", new C55781());
            return;
        }
        LogicApiFactory.createCardManager(getApplicationContext()).queryBankIssuerInfo(this.issuerId, new C55792());
    }

    public void onClickEvent(View view) {
        if (R.id.accept_button == view.getId()) {
            agreeLicenceJumpToBind();
        }
    }

    private void agreeLicenceJumpToBind() {
        Intent intent = new Intent();
        if (this.cardType == 11) {
            LogX.d("agreeLicenceJumpToBind.BindBusCardAddActivity.issuerId." + this.issuerId);
            intent.setClass(this, BindBusCardAddActivity.class);
            intent.putExtra("key_enterance", this.entranceType);
            intent.putExtra(BuscardDetailActivity.EXTRA_KEY_CARD_ISSUERID, this.issuerId);
            intent.putExtra("traffic_card_request_id", this.mCardRequestId);
            intent.putExtra("traffic_card_name", this.mCardName);
            startActivity(intent);
            finish();
            return;
        }
        LogX.d("agreeLicenceJumpToBind.BindCardActivity.issuer_id." + this.issuerId);
        intent.setClass(this, BindCardActivity.class);
        intent.putExtra("issuer_id", this.issuerId);
        intent.putExtra("card_type", this.cardType);
        intent.putExtra("issuer_mode", this.issuerMode);
        intent.putExtra(InputCardNumActivity.INTENT_KEY_CARD_NUM, C5728a.m26402a(this.fPan, getApplicationContext()));
        startActivity(intent);
        finish();
    }

    public void onClick(View view) {
        if (R.id.no_network_tip == view.getId()) {
            LogX.i(this.TAG, "onClick nfc_no_network_text.");
            showLoadingProgress();
            LogX.d("WebViewActivity : " + this.mInstructionUrl);
            if (StringUtil.isEmpty(this.mInstructionUrl, true)) {
                loadWebView(this.mInstructionUrl);
                return;
            }
            return;
        }
        super.onClick(view);
    }

    public void onBackPressed() {
        super.onBackPressed();
        startBindBusCardSwitchActivity();
    }

    private void startBindBusCardSwitchActivity() {
        Intent intent = new Intent(this, BindBusCardSwitchActivity.class);
        intent.setFlags(65536);
        startActivity(intent);
    }
}
