package com.huawei.nfc.carrera.ui.bus.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryRecordsListCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import com.huawei.nfc.carrera.ui.bus.BusBaseActivity;
import com.huawei.nfc.carrera.ui.bus.adapter.GeneralTradeInfo;
import com.huawei.nfc.carrera.ui.bus.adapter.TimeTradeAdapter;
import com.huawei.nfc.carrera.ui.carddetail.CardDetailViewPager;
import com.huawei.nfc.carrera.ui.carddetail.MyPagerAdapter;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.ui.widget.PullExpandableListView;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BusCardTradeDetailActivity extends BusBaseActivity implements OnPageChangeListener, OnClickListener, QueryRecordsListCallback {
    private static final String DIAL_HEAD = "tel:";
    static final int DONE_DETAILS_TAB_INDEX = 0;
    private static final int ERROR_TAB_INDEX = -1;
    static final String EXTRA_KEY_CARD_ISSUERID = "traffic_card_issuerId";
    static final String EXTRA_KEY_CARD_SERVICE_HOTLINE = "traffic_card_service_hotline";
    static final String EXTRA_KEY_ENTER_TRADE_DETAIL_TYPE = "enter_type";
    private static final String HUAWEI_SERVICE_HOTLINE = "400 830 8300";
    static final int UNDONE_DETAILS_TAB_INDEX = 1;
    static Comparator<GeneralTradeInfo> sTradeInfoComparator = new C56131();
    private LinearLayout loadingTradeLayout;
    private LinearLayout loadingUndoneLayout;
    private TextView mDoneTradeTv;
    private String mIssuerId;
    private TextView mLoadingText;
    private CardDetailViewPager mPager;
    private String mServiceHotlineNumber;
    private TimeTradeAdapter mTradeAdapter;
    private PullExpandableListView mTradeList;
    private RelativeLayout mTradeRecoredLayout;
    private TextView mTradeServiceHotLineTextView;
    private RelativeLayout mTradeServiceHotlineLayout;
    private TextView mUnDoneTradeTv;
    private TextView mUndoServiceHotLineTextView;
    private RelativeLayout mUndoServiceHotlineLayout;
    private RelativeLayout mUndoneRecoredLayout;
    private TimeTradeAdapter mUndoneTradeAdapter;
    private PullExpandableListView mUndoneTradeList;
    private TextView noTradeData;
    private ImageView noTradeDataIv;
    private TextView noUndoneTradeData;
    private ImageView noUndoneTradeDataIv;
    private int selectIndex;
    private ArrayList<List<GeneralTradeInfo>> tradeChildList = new ArrayList();
    private ArrayList<String> tradeyyyyMMList = new ArrayList();
    private ArrayList<List<GeneralTradeInfo>> undonechildList = new ArrayList();
    private ArrayList<String> undoneyyyyMMAirList = new ArrayList();

    final class C56131 implements Comparator<GeneralTradeInfo> {
        C56131() {
        }

        public int compare(GeneralTradeInfo generalTradeInfo, GeneralTradeInfo generalTradeInfo2) {
            return generalTradeInfo2.getmDate().compareTo(generalTradeInfo.getmDate());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R.layout.nfc_buscard_trade_detail_layout);
        if (initParams()) {
            init();
            return;
        }
        LogX.e("BusCardTradeDetailActivity, initParams failed");
        finish();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            LogX.e("initParams, intent == null");
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e("initParams, bundle == null");
            return false;
        }
        this.selectIndex = extras.getInt(EXTRA_KEY_ENTER_TRADE_DETAIL_TYPE, -1);
        this.mIssuerId = intent.getStringExtra("traffic_card_issuerId");
        this.mServiceHotlineNumber = intent.getStringExtra(EXTRA_KEY_CARD_SERVICE_HOTLINE);
        if (this.mServiceHotlineNumber != null) {
            this.mServiceHotlineNumber = formatPhoneNumber(this.mServiceHotlineNumber);
        }
        if (TextUtils.isEmpty(this.mServiceHotlineNumber)) {
            this.mServiceHotlineNumber = HUAWEI_SERVICE_HOTLINE;
        }
        if (-1 != this.selectIndex && !StringUtil.isEmpty(this.mIssuerId, true)) {
            return true;
        }
        LogX.e("initParams, illegal params");
        return false;
    }

    public static String formatPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String format;
        switch (str.length()) {
            case 10:
                format = String.format("%s %s %s", new Object[]{str.substring(0, 3), str.substring(3, 6), str.substring(6, 10)});
                break;
            case 11:
                format = String.format("%s %s %s", new Object[]{str.substring(0, 3), str.substring(3, 7), str.substring(7, 11)});
                break;
            case 12:
                format = String.format("%s %s %s", new Object[]{str.substring(0, 4), str.substring(4, 8), str.substring(8, 12)});
                break;
            default:
                return str;
        }
        return format;
    }

    protected void init() {
        super.init();
        setTitle(getString(R.string.nfc_trade_record));
        this.mUndoneRecoredLayout = (RelativeLayout) findViewById(R.id.right);
        this.mUnDoneTradeTv = (TextView) findViewById(R.id.nfc_undone_trade);
        this.mUndoneRecoredLayout.setOnClickListener(this);
        this.mTradeRecoredLayout = (RelativeLayout) findViewById(R.id.layout_left);
        this.mDoneTradeTv = (TextView) findViewById(R.id.nfc_done_trade);
        this.mTradeRecoredLayout.setOnClickListener(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        View inflate = layoutInflater.inflate(R.layout.nfc_trade_detail_with_time, null);
        this.mUndoneTradeList = (PullExpandableListView) inflate.findViewById(R.id.bus_trade_detail_record_listview);
        this.mUndoneTradeList.setGroupIndicator(null);
        this.noUndoneTradeData = (TextView) inflate.findViewById(R.id.nfc_textview_no_bus_trade_record);
        this.noUndoneTradeDataIv = (ImageView) inflate.findViewById(R.id.nfc_imageview_no_bus_trade_record);
        this.loadingUndoneLayout = (LinearLayout) inflate.findViewById(R.id.buscard_trade_info_loading_layout);
        this.mLoadingText = (TextView) inflate.findViewById(R.id.progress_bar_content);
        this.mLoadingText.setText(getString(R.string.nfc_loading_new));
        ProgressBar progressBar = (ProgressBar) this.loadingUndoneLayout.findViewById(R.id.progress_bar);
        if (VERSION.SDK_INT > 22) {
            progressBar.setIndeterminateDrawable(this.mContext.getApplicationContext().getResources().getDrawable(R.drawable.app_update_checking));
        }
        this.mUndoServiceHotlineLayout = (RelativeLayout) inflate.findViewById(R.id.layout_buscard_trade_service_hotline);
        this.mUndoServiceHotLineTextView = (TextView) inflate.findViewById(R.id.txt_buscard_trade_service_hotline_number);
        this.mUndoServiceHotLineTextView.setText(this.mServiceHotlineNumber);
        this.mUndoServiceHotLineTextView.setOnClickListener(this);
        View inflate2 = layoutInflater.inflate(R.layout.nfc_trade_detail_with_time, null);
        this.mTradeList = (PullExpandableListView) inflate2.findViewById(R.id.bus_trade_detail_record_listview);
        this.mTradeList.setGroupIndicator(null);
        this.noTradeData = (TextView) inflate2.findViewById(R.id.nfc_textview_no_bus_trade_record);
        this.noTradeDataIv = (ImageView) inflate2.findViewById(R.id.nfc_imageview_no_bus_trade_record);
        this.loadingTradeLayout = (LinearLayout) inflate2.findViewById(R.id.buscard_trade_info_loading_layout);
        this.mLoadingText = (TextView) inflate2.findViewById(R.id.progress_bar_content);
        this.mLoadingText.setText(getString(R.string.nfc_loading_new));
        progressBar = (ProgressBar) this.loadingTradeLayout.findViewById(R.id.progress_bar);
        if (VERSION.SDK_INT > 22) {
            progressBar.setIndeterminateDrawable(this.mContext.getApplicationContext().getResources().getDrawable(R.drawable.app_update_checking));
        }
        this.mTradeServiceHotlineLayout = (RelativeLayout) inflate2.findViewById(R.id.layout_buscard_trade_service_hotline);
        this.mTradeServiceHotLineTextView = (TextView) inflate2.findViewById(R.id.txt_buscard_trade_service_hotline_number);
        this.mTradeServiceHotLineTextView.setText(this.mServiceHotlineNumber);
        this.mTradeServiceHotLineTextView.setOnClickListener(this);
        List arrayList = new ArrayList();
        arrayList.add(inflate2);
        arrayList.add(inflate);
        this.mPager = (CardDetailViewPager) findViewById(R.id.nfc_bus_card_pager);
        this.mPager.setAllowScroll(true);
        this.mPager.setOnPageChangeListener(this);
        this.mPager.setAdapter(new MyPagerAdapter(arrayList));
        this.undonechildList = new ArrayList();
        this.tradeChildList = new ArrayList();
        this.undoneyyyyMMAirList = new ArrayList();
        this.tradeyyyyMMList = new ArrayList();
        setSelectTab(this.selectIndex);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.id.layout_left == id) {
            setSelectTab(0);
        } else if (R.id.right == id) {
            setSelectTab(1);
        } else if (R.id.txt_buscard_trade_service_hotline_number == id) {
            callServiceHotLine();
        }
    }

    private void callServiceHotLine() {
        if (!TextUtils.isEmpty(this.mServiceHotlineNumber)) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(DIAL_HEAD + this.mServiceHotlineNumber)));
            } catch (Throwable e) {
                LogX.e("BusCardTradeDetailActivity go to dial:", e, false);
            }
        }
    }

    private void setSelectTab(int i) {
        LogX.i("select index : " + i);
        this.selectIndex = i;
        switch (i) {
            case 0:
                this.mUndoneRecoredLayout.setBackgroundResource(R.drawable.nfc_detail_sub_tab_normal_right_white);
                this.mTradeRecoredLayout.setBackgroundResource(R.drawable.nfc_detail_sub_tab_selected_left_white);
                this.mDoneTradeTv.setTextColor(this.mContext.getResources().getColor(R.color.buscard_trade_selected_title_color));
                this.mUnDoneTradeTv.setTextColor(this.mContext.getResources().getColor(R.color.buscard_trade_unselected_title_color));
                if (this.tradeChildList == null || this.tradeChildList.isEmpty() || this.tradeyyyyMMList == null || this.tradeyyyyMMList.isEmpty()) {
                    LogX.i("info is null ");
                    showLoadingTradeLayout();
                    this.cardOperateLogicManager.queryRecords(this.mIssuerId, 0, this);
                    break;
                }
            case 1:
                this.mUndoneRecoredLayout.setBackgroundResource(R.drawable.nfc_detail_sub_tab_selected_right_white);
                this.mTradeRecoredLayout.setBackgroundResource(R.drawable.nfc_detail_sub_tab_normal_left_white);
                this.mDoneTradeTv.setTextColor(this.mContext.getResources().getColor(R.color.buscard_trade_unselected_title_color));
                this.mUnDoneTradeTv.setTextColor(this.mContext.getResources().getColor(R.color.buscard_trade_selected_title_color));
                if (this.undonechildList == null || this.undonechildList.isEmpty() || this.undoneyyyyMMAirList == null || this.undoneyyyyMMAirList.isEmpty()) {
                    LogX.i("info is null ");
                    showLoadingUndoneLayout();
                    this.cardOperateLogicManager.queryRecords(this.mIssuerId, 1, this);
                    break;
                }
            default:
                LogX.e("error index : " + i + " !");
                break;
        }
        this.mPager.setCurrentItem(i);
    }

    private void refreshTradeData2UI() {
        if (this.tradeChildList == null || this.tradeChildList.isEmpty() || this.tradeyyyyMMList == null || this.tradeyyyyMMList.isEmpty()) {
            LogX.d("query detail record list success, but list is empty.");
            showNoTradeLayout();
            return;
        }
        if (this.mTradeAdapter == null) {
            this.mTradeAdapter = new TimeTradeAdapter(this, this.tradeyyyyMMList, this.tradeChildList);
            this.mTradeList.setAdapter(this.mTradeAdapter);
        } else {
            this.mTradeAdapter.setData(this.tradeChildList);
        }
        this.mTradeAdapter.notifyDataSetChanged();
        this.mTradeList.expandAllGroup();
        showTradeLayout();
        LogX.d("RecordListCallback: get detailRecordList size = " + this.tradeChildList.size());
    }

    private void refreshUndoneTradeData2UI() {
        if (this.undonechildList == null || this.undonechildList.isEmpty() || this.undoneyyyyMMAirList == null || this.undoneyyyyMMAirList.isEmpty()) {
            LogX.d("query detail record list success, but list is empty.");
            showNoRechargeLayout();
            return;
        }
        if (this.mUndoneTradeAdapter == null) {
            this.mUndoneTradeAdapter = new TimeTradeAdapter(this, this.undoneyyyyMMAirList, this.undonechildList);
            this.mUndoneTradeList.setAdapter(this.mUndoneTradeAdapter);
        } else {
            this.mUndoneTradeAdapter.setData(this.undonechildList);
        }
        this.mUndoneTradeAdapter.notifyDataSetChanged();
        this.mUndoneTradeList.expandAllGroup();
        showRechargeLayout();
        LogX.d("refreshAirTradeData: get detailRecordList size = " + this.undonechildList.size());
    }

    private String getFomatorYearMonth(String str) {
        String[] strArr = new String[]{str.substring(0, 4), str.substring(4, 6)};
        String str2 = "";
        if (strArr.length == 2) {
            return DateUtils.formatDateTime(this, getCalendar(strArr).getTimeInMillis(), 65572);
        }
        return str2;
    }

    private Calendar getCalendar(String[] strArr) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, Integer.valueOf(strArr[0]).intValue());
        instance.set(2, Integer.valueOf(strArr[1]).intValue() - 1);
        instance.set(5, 1);
        return instance;
    }

    private void showLoadingUndoneLayout() {
        if (this.loadingUndoneLayout != null) {
            this.loadingUndoneLayout.setVisibility(0);
        }
        if (this.noUndoneTradeData != null) {
            this.noUndoneTradeData.setVisibility(8);
            this.noUndoneTradeDataIv.setVisibility(8);
        }
        if (this.mUndoneTradeList != null) {
            this.mUndoneTradeList.setVisibility(8);
        }
        if (this.mUndoServiceHotlineLayout != null) {
            this.mUndoServiceHotlineLayout.setVisibility(8);
        }
    }

    private void showLoadingTradeLayout() {
        if (this.loadingTradeLayout != null) {
            this.loadingTradeLayout.setVisibility(0);
        }
        if (this.noTradeData != null) {
            this.noTradeData.setVisibility(8);
            this.noTradeDataIv.setVisibility(8);
        }
        if (this.mTradeList != null) {
            this.mTradeList.setVisibility(8);
        }
        if (this.mTradeServiceHotlineLayout != null) {
            this.mTradeServiceHotlineLayout.setVisibility(8);
        }
    }

    private void showNoRechargeLayout() {
        if (this.loadingUndoneLayout != null) {
            this.loadingUndoneLayout.setVisibility(8);
        }
        if (this.noUndoneTradeData != null) {
            this.noUndoneTradeData.setVisibility(0);
            this.noUndoneTradeDataIv.setVisibility(0);
        }
        if (this.mUndoneTradeList != null) {
            this.mUndoneTradeList.setVisibility(8);
        }
        if (this.mUndoServiceHotlineLayout != null) {
            this.mUndoServiceHotlineLayout.setVisibility(8);
        }
    }

    private void showNoTradeLayout() {
        if (this.loadingTradeLayout != null) {
            this.loadingTradeLayout.setVisibility(8);
        }
        if (this.noTradeData != null) {
            this.noTradeData.setVisibility(0);
            this.noTradeDataIv.setVisibility(0);
        }
        if (this.mTradeList != null) {
            this.mTradeList.setVisibility(8);
        }
        if (this.mTradeServiceHotlineLayout != null) {
            this.mTradeServiceHotlineLayout.setVisibility(8);
        }
    }

    private void showRechargeLayout() {
        if (this.loadingUndoneLayout != null) {
            this.loadingUndoneLayout.setVisibility(8);
        }
        if (this.noUndoneTradeData != null) {
            this.noUndoneTradeData.setVisibility(8);
            this.noUndoneTradeDataIv.setVisibility(8);
        }
        if (this.mUndoneTradeList != null) {
            this.mUndoneTradeList.setVisibility(0);
        }
        if (this.mUndoServiceHotlineLayout != null) {
            this.mUndoServiceHotlineLayout.setVisibility(0);
        }
    }

    private void showTradeLayout() {
        if (this.loadingTradeLayout != null) {
            this.loadingTradeLayout.setVisibility(8);
        }
        if (this.noTradeData != null) {
            this.noTradeData.setVisibility(8);
            this.noTradeDataIv.setVisibility(8);
        }
        if (this.mTradeList != null) {
            this.mTradeList.setVisibility(0);
        }
        if (this.mTradeServiceHotlineLayout != null) {
            this.mTradeServiceHotlineLayout.setVisibility(0);
        }
    }

    public void queryRecordsListCallback(int i, int i2, List<RecordInfo> list) {
        List list2 = null;
        if (!list.isEmpty()) {
            List list3;
            List list4;
            List<GeneralTradeInfo> changeRecordListToTradeList = GeneralTradeInfo.changeRecordListToTradeList(this, list);
            if (i == 1) {
                list3 = this.undoneyyyyMMAirList;
                list4 = this.undonechildList;
            } else {
                Object obj = this.tradeyyyyMMList;
                Object obj2 = this.tradeChildList;
            }
            list3.clear();
            list4.clear();
            Collections.sort(changeRecordListToTradeList, sTradeInfoComparator);
            Object obj3 = null;
            for (GeneralTradeInfo generalTradeInfo : changeRecordListToTradeList) {
                String replaceAll = generalTradeInfo.getmDate().replaceAll("[-| |:]", "");
                if (replaceAll.length() >= 6) {
                    replaceAll = replaceAll.substring(0, 6);
                    if (!replaceAll.equals(obj3)) {
                        list2 = new ArrayList();
                        list3.add(getFomatorYearMonth(replaceAll));
                        list4.add(list2);
                    }
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    list2.add(generalTradeInfo);
                    obj3 = replaceAll;
                }
            }
        }
        if (i == 0) {
            refreshTradeData2UI();
            return;
        }
        if (1 == this.selectIndex) {
            handleCommonErrorCode(i2);
        }
        refreshUndoneTradeData2UI();
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        setSelectTab(i);
    }
}
