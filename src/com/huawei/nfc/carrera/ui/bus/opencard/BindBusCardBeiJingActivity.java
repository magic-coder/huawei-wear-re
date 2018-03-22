package com.huawei.nfc.carrera.ui.bus.opencard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.huawei.nfc.carrera.logic.cardinfo.model.IssueMoney;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.ui.bus.detail.BuscardDetailActivity;
import com.huawei.nfc.carrera.ui.bus.util.TimeUtil;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.ui.util.UiUtil;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.wallet.R;
import java.util.regex.Pattern;

public class BindBusCardBeiJingActivity extends BindBusCardAddActivity {
    private String aid = "";
    private Button btnOpenCard;
    private EditText edtPhonenum;
    private String name = "";
    private String phoneNum = "";

    protected void onCreateInit() {
        setRequestedOrientation(1);
        setTitle(R.string.nfc_bind_bus_card_beijing_title);
        setContentView(R.layout.nfc_add_bus_card_beijing);
        if (initParams()) {
            init();
        } else {
            finish();
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void init() {
        this.progressDialog21 = C6002a.m27468a((Context) this);
        this.progressDialog21.setCanceledOnTouchOutside(false);
        this.textPayAmount = (TextView) findViewById(R.id.add_buscard_beijing_activity_pay_amount);
        this.textStdOpenAmount = (TextView) findViewById(R.id.add_buscard_beijing_activity_open_card_amount_orginal);
        this.textOpenAmount = (TextView) findViewById(R.id.add_buscard_beijing_activity_open_card_amount_real);
        this.textChargeAmount = (TextView) findViewById(R.id.add_buscard_beijing_activity_recharge_amount);
        this.edtPhonenum = (EditText) findViewById(R.id.add_buscard_beijing_activity_edt_phonenum);
        this.btnOpenCard = (Button) findViewById(R.id.add_buscard_beijing_activity_open_card_btn);
        if (this.btnOpenCard != null) {
            UiUtil.setOrangeButtonBackground(this, this.btnOpenCard);
            this.btnOpenCard.setOnClickListener(this);
        }
        this.applyOrderProgressDialog = C6002a.m27468a((Context) this);
        this.applyOrderProgressDialog.setCanceledOnTouchOutside(false);
        String string = getString(R.string.nfc_money_type);
        if (Math.abs(this.mIssueMoney.getIssueMoney() - this.mIssueMoney.getIssueStdMoney()) > 0.0d) {
            this.textStdOpenAmount.setVisibility(0);
            this.textStdOpenAmount.setText(MoneyUtil.changeIntoDisplayMoney(string, this.mIssueMoney.getIssueStdMoney()));
            this.textStdOpenAmount.getPaint().setFlags(17);
        }
        this.payAmount = this.mIssueMoney.getPayMoney();
        this.rechargeAmount = this.payAmount - this.mIssueMoney.getIssueMoney();
        this.textOpenAmount.setText(MoneyUtil.changeIntoDisplayMoney(string, this.mIssueMoney.getIssueMoney()));
        this.textChargeAmount.setText(MoneyUtil.changeIntoDisplayMoney(string, this.mIssueMoney.getRechargeMoney()));
        this.textPayAmount.setText(MoneyUtil.changeIntoDisplayMoney(string, this.mIssueMoney.getPayMoney()));
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            this.mIssueMoney = new IssueMoney();
            LogX.e("initParams, intent == null");
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            this.mIssueMoney = new IssueMoney();
            LogX.e("initParams, bundle == null");
            return false;
        }
        this.mIssuerId = extras.getString(BuscardDetailActivity.EXTRA_KEY_CARD_ISSUERID, "");
        this.aid = extras.getString("traffic_card_aid", "");
        this.name = extras.getString("traffic_card_name", "");
        this.mIssueMoney = (IssueMoney) extras.getSerializable("traffic_card_issuemoney");
        if (!StringUtil.isEmpty(this.mIssuerId, true)) {
            return true;
        }
        LogX.e("initParams, illegal params");
        return false;
    }

    public void onClick(View view) {
        if (TimeUtil.isFastDoubleClick()) {
            LogX.e("onClick, isFastDoubleClick");
            return;
        }
        this.phoneNum = this.edtPhonenum.getText().toString();
        if (StringUtil.isEmpty(this.phoneNum, true)) {
            showToast(R.string.nfc_bind_bus_card_beijing_phonenum_hint);
        } else if (isValidMobilePhone(this.phoneNum)) {
            showProgress(this.applyOrderProgressDialog, getString(R.string.nfc_loading), true, null);
            this.cardOperateLogicManager.applyPayOrder(this.mIssuerId, this.payAmount, this.rechargeAmount <= 0.0d ? 1 : 3, 1, "", this);
        } else {
            showToast(R.string.nfc_bind_bus_card_beijing_phonenum_toast);
        }
    }

    public void applyPayOrderCallback(int i, TrafficOrder trafficOrder) {
        LogX.i("applyIssueOrderCallback, mLoadingDialog21 status" + this.mLoadingDialog21.isShowing());
        if (this.mLoadingDialog21.isShowing() && this.isVisible) {
            dismissProgress(this.applyOrderProgressDialog);
            LogX.i("applyIssueOrderCallback, resultCode=" + i);
            if (i != 0 || trafficOrder == null) {
                LogX.e("applyIssueOrderCallback, apply failed");
                if (1 == i || 10 == i || 23 == i || 24 == i || 25 == i || 99 == i) {
                    openCardLogUpload(this.mIssuerId, String.valueOf(i), "applyIssueOrderCallback, apply failed");
                }
                showErrorDialog(getErrorMessage(i));
                return;
            }
            this.trafficOrder = trafficOrder;
            this.trafficOrder.setPhoneNum(this.phoneNum);
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
            } else {
                startPay(trafficOrder);
                return;
            }
        }
        dismissProgress(this.applyOrderProgressDialog);
        LogX.i("applyIssueOrderCallback, no need to handle callback");
    }

    protected void reportCardOpened() {
        NfcHianalyticsUtil.onReportForCardOpenAction(this, this.aid, this.name, this.mIssuerId);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public boolean isValidMobilePhone(String str) {
        if (StringUtil.isEmpty(str, true)) {
            return false;
        }
        return Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
    }
}
