package com.huawei.nfc.carrera.ui.cardlist.explanddetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.storage.db.DataModel.CardOrderColumns;
import com.huawei.nfc.carrera.ui.bindcard.BindCardActivity;
import com.huawei.nfc.carrera.ui.bindcard.InputCardNumActivity;
import com.huawei.nfc.carrera.ui.carddetail.CardInfoDetailActivity;
import com.huawei.nfc.carrera.ui.nullifycard.NullifyVerifyPasswordActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.p130e.p489b.C5728a;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;

public class ExplandCardInstructionToDelete implements OnClickListener {
    private UniCardInfo cardListItem = null;
    private Button deleteCardButton;
    private TextView detail;
    private Context mContext;
    private TextView tvDescription;

    public ExplandCardInstructionToDelete(Context context) {
        this.mContext = context;
    }

    @SuppressLint({"InflateParams"})
    public View initView(int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.nfc_homefragment_card_instruction_to_delete, null);
        this.tvDescription = (TextView) inflate.findViewById(R.id.cardinstru_instruction);
        this.tvDescription.setText(this.mContext.getString(R.string.nfc_card_instruction_delete_desc_new1));
        this.deleteCardButton = (Button) inflate.findViewById(R.id.delete_card_btn);
        this.deleteCardButton.setOnClickListener(this);
        this.detail = (TextView) inflate.findViewById(R.id.cardinstru_detail_delete);
        this.detail.setOnClickListener(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = i;
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    public void setData(UniCardInfo uniCardInfo) {
        if (uniCardInfo != null) {
            this.cardListItem = uniCardInfo;
        }
    }

    public void onClick(View view) {
        if (this.cardListItem != null) {
            final TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.cardListItem.m28110c());
            if (card != null) {
                int id = view.getId();
                if (id == R.id.delete_card_btn) {
                    LogicApiFactory.createCardManager(this.mContext).queryBankIssuerInfo(this.cardListItem.m28123j(), new QueryBankIssuerInfoCallback() {
                        public void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo) {
                            if (i == 0 && bankIssuerInfo != null) {
                                Intent intent = new Intent();
                                intent.putExtra("readd_card", true);
                                intent.setClass(ExplandCardInstructionToDelete.this.mContext, BindCardActivity.class);
                                intent.putExtra("issuer_id", ExplandCardInstructionToDelete.this.cardListItem.m28123j());
                                intent.putExtra("card_type", card.cardType);
                                intent.putExtra("issuer_mode", bankIssuerInfo.getMode());
                                intent.putExtra(CardOrderColumns.COLUMN_NAME_REFENCE_ID, ExplandCardInstructionToDelete.this.cardListItem.m28110c());
                                intent.putExtra(InputCardNumActivity.INTENT_KEY_CARD_NUM, C5728a.m26402a(card.fpanDigest, ExplandCardInstructionToDelete.this.mContext.getApplicationContext()));
                                ExplandCardInstructionToDelete.this.mContext.startActivity(intent);
                            }
                        }
                    });
                } else if (id == R.id.cardinstru_detail_delete) {
                    clickDetailAction();
                }
            }
        }
    }

    private void clickDetailAction() {
        if (this.cardListItem == null || StringUtil.isEmpty(this.cardListItem.m28107b(), true)) {
            LogX.e("the clicked card info is illegal.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NullifyVerifyPasswordActivity.CARD_GROUP_TYPE, this.cardListItem.m28113d());
        bundle.putString("issuerId", this.cardListItem.m28123j());
        bundle.putString("productId", this.cardListItem.m28117f());
        bundle.putString(CardInfoDetailActivity.REFERENCE_ID, this.cardListItem.m28110c());
        Intent intent = new Intent();
        intent.setClass(this.mContext, NFCEntranceActivity.class);
        intent.setAction(NFCEntranceActivity.CARD_PACKAGE_JUMP_TO_CARD__DETAIL_ACTION);
        intent.putExtra("CARD_INFO", bundle);
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.startActivity(intent);
    }
}
