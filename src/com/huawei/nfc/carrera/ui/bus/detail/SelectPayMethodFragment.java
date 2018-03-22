package com.huawei.nfc.carrera.ui.bus.detail;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.ui.bus.adapter.SelectPayMethodAdapter;
import com.huawei.p190v.C2538c;
import com.huawei.pay.e.c.a;
import com.huawei.pay.ui.util.UiUtil;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.List;

public class SelectPayMethodFragment extends Fragment implements OnClickListener, OnTouchListener {
    public static final int PAY_METHOD_HWPAY = 1;
    public static final int PAY_METHOD_WX = 2;
    public static final String TAG = "SelectPayMethodFragment";
    private String amount = "0.00";
    private TextView bMeramount;
    private TextView bMername;
    private TextView bMernameTxt;
    private TextView bPayAmount;
    private TextView bProductName;
    private TextView bRroductFullname;
    private Button huaweipayRecharge;
    private String issuerId;
    private PayMethodCallback mListener;
    private String mMerchant = "上海公共交通卡股份有限公司";
    private ListView mPayListView;
    private TextView mPayMore_tv;
    private TextView mPayMore_tv_tip;
    private SelectPayMethodAdapter mSelectPayMethodAdapter;
    private String mTrafficCardInfo = "上海公共交通卡充值";
    private List<Integer> payMethodLists = new ArrayList();
    private int selectPayMethod = 2;

    public interface PayMethodCallback {
        void onSelectedCallback(int i);
    }

    class C56231 implements OnClickListener {
        C56231() {
        }

        public void onClick(View view) {
            SelectPayMethodFragment.this.selectPayMethod = 1;
            SelectPayMethodFragment.this.mListener.onSelectedCallback(SelectPayMethodFragment.this.selectPayMethod);
        }
    }

    public static final SelectPayMethodFragment newSelectPayMethodFragment(int i, double d, String str) {
        SelectPayMethodFragment selectPayMethodFragment = new SelectPayMethodFragment();
        Bundle bundle = new Bundle();
        C2538c.c(TAG, new Object[]{"newSelectPayMethodFragment amount " + d});
        bundle.putInt("amount", (int) d);
        bundle.putInt(IssuerInfoColumns.COLUMN_NAME_MODE, i);
        bundle.putString("issuerId", str);
        selectPayMethodFragment.setArguments(bundle);
        return selectPayMethodFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (PayMethodCallback) activity;
        } catch (Throwable e) {
            a.a("ClassCastException.", e, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hwpay_channel_select_fragment_portrait, null);
        Bundle arguments = getArguments();
        this.amount = String.valueOf(arguments.getInt("amount"));
        this.issuerId = arguments.getString("issuerId");
        int i = arguments.getInt(IssuerInfoColumns.COLUMN_NAME_MODE);
        if (Constant.FM_SH_CARD_ISSERID.equals(this.issuerId)) {
            if (1 == i) {
                this.mMerchant = "上海复旦微电子";
                this.mTrafficCardInfo = "上海公共交通卡开卡充值";
            } else if (2 == i) {
                this.mMerchant = "上海公共交通卡股份有限公司";
                this.mTrafficCardInfo = "上海公共交通卡充值";
            }
        } else if (Constant.FM_LNT_CARD_ISSERID.equals(this.issuerId)) {
            if (1 == i) {
                this.mMerchant = "上海复旦微电子";
                this.mTrafficCardInfo = "岭南通";
            } else if (2 == i) {
                this.mMerchant = "上海复旦微电子";
                this.mTrafficCardInfo = "岭南通";
            }
        }
        initView(inflate);
        initListener();
        initPayLists();
        return inflate;
    }

    private void initView(View view) {
        this.bProductName = (TextView) view.findViewById(R.id.b_product_name);
        this.bProductName.setText(R.string.huaweipay_product_name);
        this.bRroductFullname = (TextView) view.findViewById(R.id.b_product_fullname);
        this.bRroductFullname.setText(this.mTrafficCardInfo);
        this.bMernameTxt = (TextView) view.findViewById(R.id.ll_b_mername_txt);
        this.bMernameTxt.setText(R.string.hwpay_metchant_name);
        this.bMername = (TextView) view.findViewById(R.id.b_mername);
        this.bMername.setText(this.mMerchant);
        this.bMeramount = (TextView) view.findViewById(R.id.b_meramount);
        this.bMeramount.setText(getString(R.string.huaweipay_amount, new Object[]{this.amount + ""}));
        this.bPayAmount = (TextView) view.findViewById(R.id.b_pay_amount);
        this.bPayAmount.setText(getString(R.string.huaweipay_amount, new Object[]{this.amount + ""}));
        this.huaweipayRecharge = (Button) view.findViewById(R.id.huaweipay_recharge);
        UiUtil.setOrangeButtonBackground(getActivity(), this.huaweipayRecharge);
        this.huaweipayRecharge.setText(getString(R.string.huaweipay_pay_confirm_amount, new Object[]{this.amount}));
        ((TextView) view.findViewById(R.id.huaweipay_select_title_txt)).setText(R.string.huaweipay_select_title);
        this.mPayListView = (ListView) view.findViewById(R.id.hwpay_channel_select_listview);
        this.mPayMore_tv = (TextView) view.findViewById(R.id.buscard_pay_more_tv);
        this.mPayMore_tv_tip = (TextView) view.findViewById(R.id.buscard_pay_more_tv_tip);
        this.mPayMore_tv_tip.setText(String.format(getString(R.string.huaweipay_channel_pay_tip), new Object[]{"(", ")"}));
        this.mPayMore_tv.setOnClickListener(new C56231());
    }

    public void setPayAmount(double d) {
        this.bMeramount.setText(getString(R.string.huaweipay_amount, new Object[]{this.amount + ""}));
        this.bPayAmount.setText(getString(R.string.huaweipay_amount, new Object[]{String.valueOf(this.amount)}));
        this.huaweipayRecharge.setText(getString(R.string.huaweipay_pay_confirm_amount, new Object[]{this.amount}));
    }

    private void initListener() {
        this.huaweipayRecharge.setOnClickListener(this);
    }

    private void initPayLists() {
        this.payMethodLists = new ArrayList();
        this.payMethodLists.add(Integer.valueOf(2));
        this.mSelectPayMethodAdapter = new SelectPayMethodAdapter(getActivity(), this.payMethodLists);
        this.mPayListView.setAdapter(this.mSelectPayMethodAdapter);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        if (R.id.huaweipay_recharge == view.getId() && this.mListener != null) {
            this.selectPayMethod = 2;
            this.mListener.onSelectedCallback(this.selectPayMethod);
        }
    }
}
