package com.huawei.nfc.carrera.ui.cardlist.explanddetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.nfc.NFCEntranceActivity;
import com.huawei.nfc.carrera.logic.CardInfoManagerApi;
import com.huawei.nfc.carrera.logic.CardOperateLogicApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryRecordsListCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import com.huawei.nfc.carrera.logic.security.CheckFpPasswdCallback;
import com.huawei.nfc.carrera.logic.security.FpPasswordInstructionVerifier;
import com.huawei.nfc.carrera.ui.bus.util.TimeUtil;
import com.huawei.nfc.carrera.ui.carddetail.CardInfoDetailActivity;
import com.huawei.nfc.carrera.ui.nullifycard.NullifyVerifyPasswordActivity;
import com.huawei.nfc.carrera.ui.webview.NormalWebViewActivity;
import com.huawei.nfc.carrera.ui.webview.PolicyActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.ui.widget.LocalLinkMovementMethod;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExplandCardInstruction extends FrameLayout implements OnClickListener, QueryRecordsListCallback, CheckFpPasswdCallback {
    private static final String ABOUT_QUICK_PASS_WEBVEIW_URL = "https://pcpay.vmall.com/agreement/yinlian-cloud-pay.html";
    private static final String TAG = "ExplandCardInstruction";
    private Activity activity;
    private TextView balanceOrConsume;
    private LinearLayout buacardDetail;
    private UniCardInfo cardDetail;
    private CardInfoManagerApi cardInfoManagerApi;
    private CardOperateLogicApi cardOperateLogicManager;
    protected FpPasswordInstructionVerifier fpVerifier;
    private TextView tradeAmount;
    private TextView tradeTime;
    private TextView tv_cardName;
    private TextView tv_description;
    private TextView tv_detail_tip;

    class C56531 implements QueryBankCardInfoCallback {
        C56531() {
        }

        public void queryBankCardInfoCallback(int i, BankCardInfo bankCardInfo) {
            if (i == 0 && bankCardInfo != null) {
                ExplandCardInstruction.this.tv_cardName.setText(bankCardInfo.getCardName());
            }
        }
    }

    class C56542 extends ClickableSpan {
        C56542() {
        }

        public void onClick(View view) {
            String string = ExplandCardInstruction.this.activity.getString(R.string.nfc_about_quick_pass);
            Intent intent = new Intent(ExplandCardInstruction.this.activity, PolicyActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_URL, ExplandCardInstruction.ABOUT_QUICK_PASS_WEBVEIW_URL);
            bundle.putString(NormalWebViewActivity.BUNDLE_KEY_WEBVEIW_TITLE, string);
            intent.putExtras(bundle);
            ExplandCardInstruction.this.activity.startActivity(intent);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(ExplandCardInstruction.this.getResources().getColor(R.color.brandcolor));
        }
    }

    public ExplandCardInstruction(Activity activity) {
        super(activity);
        this.activity = activity;
        this.cardInfoManagerApi = LogicApiFactory.createCardManager(activity);
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.card_instruction, null);
        this.tv_cardName = (TextView) inflate.findViewById(R.id.cardinstru_title);
        this.tv_detail_tip = (TextView) inflate.findViewById(R.id.cardinstru_detail_tv);
        this.tv_description = (TextView) inflate.findViewById(R.id.cardinstru_instruction);
        this.buacardDetail = (LinearLayout) inflate.findViewById(R.id.buscard_detail);
        this.balanceOrConsume = (TextView) inflate.findViewById(R.id.balance_or_consume);
        this.tradeAmount = (TextView) inflate.findViewById(R.id.trade_amount);
        this.tradeTime = (TextView) inflate.findViewById(R.id.consume_time);
        this.tv_detail_tip.setOnClickListener(this);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 14;
        inflate.setLayoutParams(layoutParams);
        setId(R.id.card_brief);
        addView(inflate);
    }

    public void setData(UniCardInfo uniCardInfo) {
        if (uniCardInfo != null) {
            C2538c.b(TAG, new Object[]{"setData(),item.getCardGroup()=" + uniCardInfo.m28113d()});
            this.cardDetail = uniCardInfo;
            switch (uniCardInfo.m28113d()) {
                case 1:
                    setDesInfo();
                    this.cardInfoManagerApi.queryBankCardInfo(uniCardInfo.m28110c(), new C56531());
                    return;
                case 2:
                    this.tv_cardName.setText(R.string.nfc_card_instruction_recent_consume);
                    this.tv_description.setText(R.string.nfc_card_instruction_quering_trade_record_new);
                    this.cardOperateLogicManager = LogicApiFactory.createCardOperateApi(this.activity.getApplicationContext());
                    this.cardOperateLogicManager.queryRecords(uniCardInfo.m28123j(), 0, this);
                    return;
                default:
                    return;
            }
        }
    }

    private void setDesInfo() {
        int i = 0;
        String string = this.activity.getString(R.string.nfc_card_instruction_quick_pass);
        String string2 = this.activity.getString(R.string.nfc_card_instruction_normal_desc, new Object[]{string});
        CharSequence spannableString = new SpannableString(string2);
        int indexOf = string2.indexOf(string);
        int length = string.length() + indexOf;
        if (indexOf == -1) {
            length = string2.length();
        } else {
            i = indexOf;
        }
        spannableString.setSpan(new C56542(), i, length, 33);
        this.tv_description.setText(spannableString);
        this.tv_description.setMovementMethod(LocalLinkMovementMethod.getInstance());
    }

    public void onClick(View view) {
        if (R.id.cardinstru_detail_tv == view.getId()) {
            clickDetailAction();
        }
    }

    private void clickDetailAction() {
        if (this.cardDetail == null || StringUtil.isEmpty(this.cardDetail.m28107b(), true)) {
            LogX.e("the clicked card info is illegal.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NullifyVerifyPasswordActivity.CARD_GROUP_TYPE, this.cardDetail.m28113d());
        bundle.putString("issuerId", this.cardDetail.m28123j());
        bundle.putString("productId", this.cardDetail.m28117f());
        bundle.putString(CardInfoDetailActivity.REFERENCE_ID, this.cardDetail.m28110c());
        Intent intent = new Intent();
        intent.setClass(this.activity, NFCEntranceActivity.class);
        intent.setAction(NFCEntranceActivity.CARD_PACKAGE_JUMP_TO_CARD__DETAIL_ACTION);
        intent.putExtra("CARD_INFO", bundle);
        intent.setPackage(this.activity.getPackageName());
        this.activity.startActivity(intent);
    }

    public void queryRecordsListCallback(int i, int i2, List<RecordInfo> list) {
        if (i != 1) {
            if (list.isEmpty()) {
                this.tv_description.setText(R.string.nfc_card_instruction_unable_query_record);
                return;
            }
            this.tv_description.setVisibility(8);
            this.buacardDetail.setVisibility(0);
            RecordInfo recordInfo = (RecordInfo) list.get(0);
            try {
                LogX.i("NumberFormatException " + recordInfo.getRecordTime());
                if (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(recordInfo.getRecordTime()).after(new Date()) && Double.parseDouble(recordInfo.getRecordAmount()) <= 0.0d && list.size() > 0) {
                    recordInfo = (RecordInfo) list.get(1);
                }
            } catch (NumberFormatException e) {
                LogX.e("NumberFormatException " + e.getMessage());
            } catch (IllegalArgumentException e2) {
                LogX.e("IllegalArgumentException " + e2.getMessage());
            } catch (ParseException e3) {
                LogX.e("ParseException " + e3.getMessage());
            }
            this.tradeAmount.setText(this.activity.getString(R.string.nfc_money_type) + recordInfo.getRecordAmount());
            CharSequence formatDate2String = TimeUtil.formatDate2String(TimeUtil.parseString2Date(recordInfo.getRecordTime(), "yyyy-MM-dd HH:mm:ss"), "yyyy/MM/dd HH:mm:ss");
            this.tradeTime.setVisibility(0);
            this.tradeTime.setText(formatDate2String);
            if (recordInfo.getRecordType() == 11) {
                this.balanceOrConsume.setText(R.string.nfc_bus_card_trade_details_consume);
            } else if (recordInfo.getRecordType() == 10) {
                this.balanceOrConsume.setText(R.string.nfc_bus_card_trade_details_recharge);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        LogX.i("ExplandCardInstruction   onWindowFocusChanged  is :" + z);
        if (z) {
            startUseFingerprint();
        } else {
            stopUseFingerprint();
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        LogX.i("ExplandCardInstruction   onWindowVisibilityChanged  is :" + i);
        if (i == 0) {
            startUseFingerprint();
        } else {
            stopUseFingerprint();
        }
    }

    private void openFpVerifer() {
        if (this.fpVerifier == null) {
            this.fpVerifier = new FpPasswordInstructionVerifier(this.activity);
        }
        if (checkFingerPrint()) {
            if (this.fpVerifier == null) {
                this.fpVerifier = new FpPasswordInstructionVerifier(this.activity);
            }
            this.fpVerifier.startCheckFpPassword(this);
            LogX.i("fpVerifier is started");
        }
    }

    public void startUseFingerprint() {
        openFpVerifer();
    }

    public void stopUseFingerprint() {
        if (this.fpVerifier != null) {
            LogX.d("release fp verifier now.");
            this.fpVerifier.release();
            this.fpVerifier = null;
        }
        LogX.i("fpVerifier is stoped");
    }

    public void onChecking(int i) {
        LogX.d("onChecking(), and checking status: " + i);
    }

    public void onCheckResult(int i) {
        LogX.d("onCheckResult, and check result: " + i);
    }

    private boolean checkFingerPrint() {
        if (1 == this.fpVerifier.checkValidFpPassword()) {
            return true;
        }
        return false;
    }
}
