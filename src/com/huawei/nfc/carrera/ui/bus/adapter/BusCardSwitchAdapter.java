package com.huawei.nfc.carrera.ui.bus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportedTrafficCardListItem;
import com.huawei.nfc.carrera.ui.bus.widget.BindBusCardSwitchItem;
import java.util.ArrayList;

public class BusCardSwitchAdapter extends BaseAdapter {
    private ArrayList<SupportedTrafficCardListItem> mBusCardInfos;
    private Context mContext;

    public BusCardSwitchAdapter(Context context, ArrayList<SupportedTrafficCardListItem> arrayList) {
        this.mContext = context;
        this.mBusCardInfos = arrayList;
    }

    public int getCount() {
        return this.mBusCardInfos.size();
    }

    public Object getItem(int i) {
        return this.mBusCardInfos.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new BindBusCardSwitchItem(this.mContext, (SupportedTrafficCardListItem) this.mBusCardInfos.get(i), viewGroup);
        } else {
            ((BindBusCardSwitchItem) view).setData((SupportedTrafficCardListItem) this.mBusCardInfos.get(i));
        }
        view.setTag(this.mBusCardInfos.get(i));
        return view;
    }
}
