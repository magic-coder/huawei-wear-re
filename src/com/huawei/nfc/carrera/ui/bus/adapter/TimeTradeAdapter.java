package com.huawei.nfc.carrera.ui.bus.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.List;

public class TimeTradeAdapter extends BaseExpandableListAdapter {
    private List<List<GeneralTradeInfo>> mChildList;
    private Context mContext;
    private List<String> mGroupList;
    private LayoutInflater mInflater = LayoutInflater.from(this.mContext);

    class ViewHolder {
        TextView amountTx;
        TextView dateTx;
        ImageView lineImg;
        TextView productNameTx;
        TextView statusTx;
        TextView unitTx;

        ViewHolder() {
        }
    }

    class ViewHolderGroup {
        TextView dateTextView;

        ViewHolderGroup() {
        }
    }

    public TimeTradeAdapter(Context context, List<String> list, List<List<GeneralTradeInfo>> list2) {
        this.mContext = context;
        this.mGroupList = list;
        this.mChildList = list2;
        LogX.d("********", "TimeTradeAdapter [mGroupList : " + this.mGroupList.size() + "], [mChildList : " + this.mChildList.size() + "]" + this.mChildList.toString());
    }

    public Object getChild(int i, int i2) {
        return ((List) this.mChildList.get(i)).get(i2);
    }

    public int getChildrenCount(int i) {
        LogX.d("********", "getChildrenCount [child count : " + ((List) this.mChildList.get(i)).size() + "]");
        return ((List) this.mChildList.get(i)).size();
    }

    public Object getGroup(int i) {
        return this.mGroupList.get(i);
    }

    public int getGroupCount() {
        LogX.d("********", "getGroupCount [group count : " + this.mGroupList.size() + "]");
        return this.mGroupList.size();
    }

    public long getGroupId(int i) {
        return 0;
    }

    public long getChildId(int i, int i2) {
        return 0;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        ViewHolderGroup viewHolderGroup;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.nfc_buscard_trade_title_item, null);
            viewHolderGroup = new ViewHolderGroup();
            viewHolderGroup.dateTextView = (TextView) view.findViewById(R.id.nfc_time_list_date);
            view.setTag(viewHolderGroup);
        } else {
            viewHolderGroup = (ViewHolderGroup) view.getTag();
        }
        viewHolderGroup.dateTextView.setText((String) this.mGroupList.get(i));
        return view;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        GeneralTradeInfo generalTradeInfo = (GeneralTradeInfo) ((List) this.mChildList.get(i)).get(i2);
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            view = this.mInflater.inflate(R.layout.nfc_buscard_trade_info_item, null);
            viewHolder2.productNameTx = (TextView) view.findViewById(R.id.nfc_trade_info_item_product_name);
            viewHolder2.amountTx = (TextView) view.findViewById(R.id.nfc_trade_info_item_amount);
            viewHolder2.unitTx = (TextView) view.findViewById(R.id.nfc_trade_info_item_unit);
            viewHolder2.statusTx = (TextView) view.findViewById(R.id.nfc_trade_info_item_status);
            viewHolder2.lineImg = (ImageView) view.findViewById(R.id.nfc_trade_info_item_listview_line);
            viewHolder2.dateTx = (TextView) view.findViewById(R.id.nfc_trade_info_item_date);
            view.setTag(viewHolder2);
            view.setTag(R.id.trade_hoder_id, viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag(R.id.trade_hoder_id);
            if (viewHolder == null) {
                LogX.i("hold is null!", false);
                viewHolder = new ViewHolder();
            }
        }
        view.setTag(generalTradeInfo);
        viewHolder.productNameTx.setText("" + generalTradeInfo.getmTypeDesc());
        viewHolder.dateTx.setText(generalTradeInfo.getmDate());
        if (TextUtils.isEmpty(generalTradeInfo.getmStatusDesc())) {
            viewHolder.statusTx.setVisibility(8);
        } else {
            viewHolder.statusTx.setText("" + generalTradeInfo.getmStatusDesc());
            viewHolder.statusTx.setVisibility(0);
        }
        viewHolder.amountTx.setText("" + generalTradeInfo.getmAmount());
        viewHolder.unitTx.setText(generalTradeInfo.getUnitText());
        viewHolder.unitTx.setVisibility(0);
        if (!z || i == this.mGroupList.size() - 1) {
            viewHolder.lineImg.setVisibility(0);
        } else {
            viewHolder.lineImg.setVisibility(8);
        }
        return view;
    }

    public void setData(ArrayList<List<GeneralTradeInfo>> arrayList) {
        this.mChildList = arrayList;
    }
}
