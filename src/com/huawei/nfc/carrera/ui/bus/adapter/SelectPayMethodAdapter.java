package com.huawei.nfc.carrera.ui.bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.List;

public class SelectPayMethodAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private int mSelectPostion = 0;
    private List<Integer> payMethodList = new ArrayList();

    class ViewHolder {
        ImageView payTypeIcon;
        TextView payTypeName;
        CheckBox radio;

        private ViewHolder() {
        }
    }

    public SelectPayMethodAdapter(Context context, List<Integer> list) {
        this.payMethodList = list;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.payMethodList.size();
    }

    public Object getItem(int i) {
        return this.payMethodList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = this.mLayoutInflater.inflate(R.layout.hwpay_select_item, null);
            viewHolder.payTypeIcon = (ImageView) view.findViewById(R.id.cardButton);
            viewHolder.payTypeName = (TextView) view.findViewById(R.id.paytype_title);
            viewHolder.radio = (CheckBox) view.findViewById(R.id.checkbutton1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.radio.setChecked(i == this.mSelectPostion);
        if (2 == ((Integer) this.payMethodList.get(i)).intValue()) {
            viewHolder.payTypeIcon.setImageResource(R.drawable.huaweipay_selectpage_wechat_pay);
            viewHolder.payTypeName.setText(R.string.huaweipay_wechat_pay);
        }
        return view;
    }

    public int getSelectPostion() {
        return this.mSelectPostion;
    }

    public void setSelectPostion(int i) {
        this.mSelectPostion = i;
        notifyDataSetChanged();
    }
}
