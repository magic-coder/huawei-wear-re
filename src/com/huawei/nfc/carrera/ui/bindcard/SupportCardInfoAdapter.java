package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pay.p483b.C5723a;
import com.huawei.wallet.R;
import java.util.ArrayList;

public class SupportCardInfoAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<C5723a> mSupportBankInfoList;

    class ViewHolder {
        TextView bankNameTv;
        ImageView creditCardImgView;
        ImageView debitCardImgView;

        private ViewHolder() {
        }
    }

    public SupportCardInfoAdapter(Context context, ArrayList<C5723a> arrayList) {
        this.mSupportBankInfoList = arrayList;
        this.mContext = context;
    }

    public int getCount() {
        return this.mSupportBankInfoList != null ? this.mSupportBankInfoList.size() : 0;
    }

    public Object getItem(int i) {
        return this.mSupportBankInfoList != null ? (C5723a) this.mSupportBankInfoList.get(i) : null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            viewHolder = new ViewHolder();
            view = from.inflate(R.layout.nfc_support_bank_info_item, viewGroup, false);
            viewHolder.bankNameTv = (TextView) view.findViewById(R.id.nfc_support_bank_name);
            viewHolder.debitCardImgView = (ImageView) view.findViewById(R.id.nfc_support_bank_debit_card);
            viewHolder.creditCardImgView = (ImageView) view.findViewById(R.id.nfc_support_bank_credit_card);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        C5723a c5723a = (C5723a) this.mSupportBankInfoList.get(i);
        if (c5723a != null) {
            viewHolder.bankNameTv.setText(c5723a.m26380a());
            if (c5723a.m26385c()) {
                viewHolder.debitCardImgView.setVisibility(0);
            } else {
                viewHolder.debitCardImgView.setVisibility(4);
            }
            if (c5723a.m26384b()) {
                viewHolder.creditCardImgView.setVisibility(0);
            } else {
                viewHolder.creditCardImgView.setVisibility(4);
            }
        }
        return view;
    }
}
