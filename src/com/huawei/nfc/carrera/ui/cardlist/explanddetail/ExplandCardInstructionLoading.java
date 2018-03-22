package com.huawei.nfc.carrera.ui.cardlist.explanddetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.huawei.nfc.carrera.ui.bus.detail.BuscardDetailActivity;
import com.huawei.nfc.carrera.ui.carddetail.CardInfoDetailActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;

public class ExplandCardInstructionLoading implements OnClickListener {
    private UniCardInfo cardDetail = null;
    private Context mContext;
    private TextView tv_detail_tip;

    public ExplandCardInstructionLoading(Context context) {
        this.mContext = context;
    }

    @SuppressLint({"InflateParams"})
    public View initView(int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.nfc_homefragment_card_instruction, null);
        this.tv_detail_tip = (TextView) inflate.findViewById(R.id.cardinstru_detail_tv);
        this.tv_detail_tip.setOnClickListener(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.height = i;
        inflate.setLayoutParams(layoutParams);
        if (this.cardDetail != null && this.cardDetail.m28102a() == 3) {
            LogX.i("====test====null != cardDetail");
            ((TextView) inflate.findViewById(R.id.cardinstru_instruction)).setText(this.mContext.getResources().getString(R.string.nfc_card_instruction_nullifying_desc_new));
        }
        return inflate;
    }

    public void setData(UniCardInfo uniCardInfo) {
        if (uniCardInfo != null) {
            this.cardDetail = uniCardInfo;
        }
    }

    public void onClick(View view) {
        if (R.id.cardinstru_detail_tv == view.getId()) {
            clickDetailAction();
        }
    }

    private void clickDetailAction() {
        if (this.cardDetail == null || StringUtil.isEmpty(this.cardDetail.m28107b(), true)) {
            LogX.e("the clicked card info is illegal.");
        } else {
            jumpToDetail();
        }
    }

    private void jumpToDetail() {
        if (this.cardDetail != null) {
            if (2 == this.cardDetail.m28113d()) {
                LogX.i("jumpToCardDetailActivity : jump to traffic card detail activity");
                jumpToTrafficCardDetailActivity(this.cardDetail.m28123j(), this.cardDetail.m28117f());
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("issuerId", this.cardDetail.m28123j());
            intent.putExtra(CardInfoDetailActivity.REFERENCE_ID, this.cardDetail.m28110c());
            intent.setClass(this.mContext, CardInfoDetailActivity.class);
            this.mContext.startActivity(intent);
        }
    }

    private void jumpToTrafficCardDetailActivity(String str, String str2) {
        Intent intent = new Intent(this.mContext, BuscardDetailActivity.class);
        intent.putExtra(BuscardDetailActivity.EXTRA_KEY_CARD_ISSUERID, str);
        intent.putExtra(BuscardDetailActivity.EXTRA_KEY_CARD_PRODUCTD, str2);
        this.mContext.startActivity(intent);
    }
}
