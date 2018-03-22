package com.huawei.nfc.carrera.ui.bus.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportedTrafficCardListItem;
import com.huawei.wallet.R;

public class BindBusCardSwitchItem extends LinearLayout {
    private Context mContext;
    private ImageView mImgBusCardLogo;
    private TextView mTextBusCardDes;
    private TextView mTextBusCardStatus;

    public BindBusCardSwitchItem(Context context, SupportedTrafficCardListItem supportedTrafficCardListItem, ViewGroup viewGroup) {
        super(context);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.nfc_bind_bus_card_switch_item, this, true);
        this.mImgBusCardLogo = (ImageView) inflate.findViewById(R.id.bus_card_icon);
        this.mTextBusCardDes = (TextView) inflate.findViewById(R.id.bus_card_type);
        this.mTextBusCardStatus = (TextView) inflate.findViewById(R.id.bus_card_status);
        this.mImgBusCardLogo.setImageBitmap(supportedTrafficCardListItem.getLogo());
        this.mTextBusCardDes.setText(supportedTrafficCardListItem.getCardName());
        this.mTextBusCardStatus.setText(getCardStatusText(supportedTrafficCardListItem));
    }

    public void setData(SupportedTrafficCardListItem supportedTrafficCardListItem) {
        this.mImgBusCardLogo.setImageBitmap(supportedTrafficCardListItem.getLogo());
        this.mTextBusCardDes.setText(supportedTrafficCardListItem.getCardName());
        this.mTextBusCardStatus.setText(getCardStatusText(supportedTrafficCardListItem));
    }

    private String getCardStatusText(SupportedTrafficCardListItem supportedTrafficCardListItem) {
        if (supportedTrafficCardListItem.getStatus() == 2) {
            return this.mContext.getString(R.string.nfc_bind_bus_card_status_added);
        }
        if (supportedTrafficCardListItem.getStatus() == 11 || supportedTrafficCardListItem.getStatus() == 12 || supportedTrafficCardListItem.getStatus() == 13) {
            return this.mContext.getString(R.string.nfc_bind_bus_card_status_continue);
        }
        return "";
    }
}
