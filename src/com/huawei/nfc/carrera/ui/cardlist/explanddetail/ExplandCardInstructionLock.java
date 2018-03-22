package com.huawei.nfc.carrera.ui.cardlist.explanddetail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.nfc.NFCEntranceActivity;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;
import com.huawei.nfc.carrera.ui.carddetail.CardInfoDetailActivity;
import com.huawei.nfc.carrera.ui.nullifycard.NullifyVerifyPasswordActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;

public class ExplandCardInstructionLock implements OnClickListener {
    private UniCardInfo cardDetail;
    private Context mContext;
    private Button phoneToBank;
    private TextView tv_detail_tip;

    class C56551 implements QueryBankIssuerInfoCallback {
        C56551() {
        }

        public void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo) {
            if (i == 0 && !StringUtil.isEmpty(bankIssuerInfo.getContactNumber(), true)) {
                ExplandCardInstructionLock.this.callServicePhone(bankIssuerInfo.getContactNumber());
            }
        }
    }

    public ExplandCardInstructionLock(Context context) {
        this.mContext = context;
    }

    public View initView(int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.card_instruction_lock, null);
        this.tv_detail_tip = (TextView) inflate.findViewById(R.id.cardinstru_detail_tv);
        this.phoneToBank = (Button) inflate.findViewById(R.id.cardinstru_phone_to_bank);
        this.tv_detail_tip.setOnClickListener(this);
        this.phoneToBank.setOnClickListener(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = i;
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.id.cardinstru_detail_tv == id) {
            clickDetailAction();
        } else if (R.id.cardinstru_phone_to_bank == id && this.cardDetail != null) {
            LogicApiFactory.createCardManager(this.mContext).queryBankIssuerInfo(this.cardDetail.m28123j(), new C56551());
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
        intent.setClass(this.mContext, NFCEntranceActivity.class);
        intent.setAction(NFCEntranceActivity.CARD_PACKAGE_JUMP_TO_CARD__DETAIL_ACTION);
        intent.putExtra("CARD_INFO", bundle);
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.startActivity(intent);
    }

    private void callServicePhone(String str) {
        try {
            this.mContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
        } catch (Throwable e) {
            LogX.e("ExplandCardInstructionLock jump to dial:", e, false);
        }
    }

    public void setData(UniCardInfo uniCardInfo) {
        if (uniCardInfo != null) {
            this.cardDetail = uniCardInfo;
        }
    }
}
