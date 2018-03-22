package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportBankInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportNFCBankInfo;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryDicsRequset;
import com.huawei.nfc.carrera.server.card.response.DicItem;
import com.huawei.nfc.carrera.server.card.response.QueryDicsResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p483b.C5723a;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupportBankInfoView extends RelativeLayout {
    private static final String CGB_ISSUERID = "03060000";
    private static final String CMB_ISSUERID = "03080000";
    private static final String DIC_NAME = "Huawei_Watch_LEO";
    private static final String IS_SUPPORT_DEBITCARD = "2";
    private static final int SHOW_SUPPORT_BANK_INFOS = 1;
    private static final String TAG = "SupportBankInfoView";
    private static ExecutorService threadPool = Executors.newFixedThreadPool(1);
    private boolean isOnlySupportCGBdebitCard = false;
    private boolean isOnlySupportCMBdebitCard = false;
    private Context mContext;
    private Handler mHandler = new C56082();
    protected C6002a mLoadingDialog21;
    private RelativeLayout mSupportBanksLayout;
    private SupportCardInfoAdapter mSupportCardAdapter;
    private GridView mSupportCardList;

    class C56071 implements QuerySupportBankInfoCallback {

        class C56061 implements OnTouchListener {
            C56061() {
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        C56071() {
        }

        public void queryResultCallback(Map<String, SupportNFCBankInfo> map) {
            SupportBankInfoView.this.mSupportBanksLayout.setVisibility(8);
            SupportBankInfoView.this.dismissProgressDialog();
            if (map == null || map.isEmpty()) {
                LogX.d("query support bank infos, but empty.");
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            for (SupportNFCBankInfo supportNFCBankInfo : map.values()) {
                C5723a c5723a = new C5723a();
                c5723a.m26381a(supportNFCBankInfo.getNfcBankName());
                boolean equals = supportNFCBankInfo.getIssuerId().equals(SupportBankInfoView.CMB_ISSUERID);
                C2538c.b(SupportBankInfoView.TAG, new Object[]{"showSupportBankInfos isCMBIssuerId : " + equals + " ; isOnlySupportCMBdebitCard : " + SupportBankInfoView.this.isOnlySupportCMBdebitCard});
                if (equals && SupportBankInfoView.this.isOnlySupportCMBdebitCard) {
                    supportNFCBankInfo.setSupportCardType(2);
                }
                equals = supportNFCBankInfo.getIssuerId().equals(SupportBankInfoView.CGB_ISSUERID);
                C2538c.b(SupportBankInfoView.TAG, new Object[]{"showSupportBankInfos isCGBIssuerId : " + equals + " ; isOnlySupportCGBdebitCard : " + SupportBankInfoView.this.isOnlySupportCGBdebitCard});
                if (equals && SupportBankInfoView.this.isOnlySupportCGBdebitCard) {
                    supportNFCBankInfo.setSupportCardType(2);
                }
                if (2 == supportNFCBankInfo.getSupportCardType()) {
                    c5723a.m26383b(true);
                    c5723a.m26382a(false);
                } else if (3 == supportNFCBankInfo.getSupportCardType()) {
                    c5723a.m26383b(false);
                    c5723a.m26382a(true);
                } else if (4 == supportNFCBankInfo.getSupportCardType()) {
                    c5723a.m26383b(true);
                    c5723a.m26382a(true);
                } else {
                    LogX.e("unsupport cardType : " + supportNFCBankInfo.getSupportCardType());
                }
                if (linkedHashMap.containsKey(c5723a.m26380a())) {
                    C5723a c5723a2 = (C5723a) linkedHashMap.get(c5723a.m26380a());
                    if (c5723a2.m26385c() || c5723a.m26385c()) {
                        equals = true;
                    } else {
                        equals = false;
                    }
                    c5723a2.m26383b(equals);
                    if (c5723a2.m26384b() || c5723a.m26384b()) {
                        equals = true;
                    } else {
                        equals = false;
                    }
                    c5723a2.m26382a(equals);
                } else {
                    linkedHashMap.put(c5723a.m26380a(), c5723a);
                    arrayList.add(c5723a);
                }
            }
            if (!arrayList.isEmpty()) {
                SupportBankInfoView.this.mSupportBanksLayout.setVisibility(0);
                SupportBankInfoView.this.mSupportCardAdapter = new SupportCardInfoAdapter(SupportBankInfoView.this.mContext, arrayList);
                SupportBankInfoView.this.mSupportCardList.setAdapter(SupportBankInfoView.this.mSupportCardAdapter);
                SupportBankInfoView.this.setListViewHeightBasedOnChildren(SupportBankInfoView.this.mSupportCardList);
                SupportBankInfoView.this.mSupportCardList.setOnTouchListener(new C56061());
            }
        }
    }

    class C56082 extends Handler {
        C56082() {
        }

        public void dispatchMessage(Message message) {
            if (1 == message.what) {
                SupportBankInfoView.this.showSupportBankInfos(SupportBankInfoView.this.mContext);
            }
        }
    }

    class SupportBOC implements Runnable {
        private SupportBOC() {
        }

        public void run() {
            String value;
            C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDic startSupportCMB"});
            QueryDicsResponse access$800 = SupportBankInfoView.this.getSupportBankFromServer(Constant.SUPPORT_CMB_DEBIT_CARDINFO);
            if (access$800 == null || access$800.returnCode != 0) {
                C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicCMB Response is null object"});
            } else {
                C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicsResponseCMB SUCCESS"});
                if (access$800.dicItems.size() > 0) {
                    value = ((DicItem) access$800.dicItems.get(0)).getValue();
                    if (value == null || value.equals("") || !value.equals("2")) {
                        SupportBankInfoView.this.isOnlySupportCMBdebitCard = false;
                    } else {
                        C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicsResponseCMB info : " + value});
                        SupportBankInfoView.this.isOnlySupportCMBdebitCard = true;
                    }
                } else {
                    C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicCMB The size of result's dictory is zero"});
                }
            }
            access$800 = SupportBankInfoView.this.getSupportBankFromServer(Constant.SUPPORT_CGB_DEBIT_CARDINFO);
            if (access$800 == null || access$800.returnCode != 0) {
                C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicCGB Response is null object"});
            } else {
                C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicsresponseCGB SUCCESS"});
                if (access$800.dicItems.size() > 0) {
                    value = ((DicItem) access$800.dicItems.get(0)).getValue();
                    if (value == null || value.equals("") || !value.equals("2")) {
                        SupportBankInfoView.this.isOnlySupportCGBdebitCard = false;
                    } else {
                        C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicsresponseCGB info : " + value});
                        SupportBankInfoView.this.isOnlySupportCGBdebitCard = true;
                    }
                } else {
                    C2538c.b(SupportBankInfoView.TAG, new Object[]{"QueryDicCGB The size of result's dictory is zero"});
                }
            }
            SupportBankInfoView.this.mHandler.sendEmptyMessage(1);
        }
    }

    public SupportBankInfoView(Context context) {
        super(context);
        init(context);
    }

    public SupportBankInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public SupportBankInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView(context);
        showProgressDialog(null, this.mContext.getString(R.string.nfc_loading), false);
        getOnlySupportBOCdebitCardInfo();
    }

    private void initView(Context context) {
        LayoutInflater.from(this.mContext).inflate(R.layout.nfc_activity_support_bank_info, this);
        this.mSupportCardList = (GridView) findViewById(R.id.nfc_support_card_info_list);
        this.mSupportBanksLayout = (RelativeLayout) findViewById(R.id.have_support_card_layout);
    }

    private void showSupportBankInfos(Context context) {
        LogicApiFactory.createCardManager(context.getApplicationContext()).querySupportNFCBankInfos(new C56071());
    }

    private void setListViewHeightBasedOnChildren(GridView gridView) {
        int i = 0;
        ListAdapter adapter = gridView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            if (count > 0) {
                View view = adapter.getView(0, null, gridView);
                if (view != null) {
                    view.measure(0, 0);
                    i = view.getMeasuredHeight();
                }
            }
            if (count % 2 == 0) {
                i *= count / 2;
            } else {
                i *= (count / 2) + 1;
            }
            LayoutParams layoutParams = gridView.getLayoutParams();
            layoutParams.height = i;
            gridView.setLayoutParams(layoutParams);
        }
    }

    public void showProgressDialog(String str, String str2, boolean z) {
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(this.mContext, R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a(this.mContext);
            this.mLoadingDialog21.m27476a(str2);
            this.mLoadingDialog21.setCancelable(z);
            this.mLoadingDialog21.m27474a();
        }
        if (this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.show();
            C2538c.c(TAG, new Object[]{"mLoadingDialog.show()"});
        }
    }

    public void dismissProgressDialog() {
        if (this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.cancel();
            this.mLoadingDialog21 = null;
            C2538c.c(TAG, new Object[]{"destroy mLoadingDialog21"});
        }
    }

    private void getOnlySupportBOCdebitCardInfo() {
        C2538c.b(TAG, new Object[]{"enter getOnlySupportBOCdebitCardInfo "});
        threadPool.execute(new SupportBOC());
    }

    private QueryDicsResponse getSupportBankFromServer(String str) {
        QueryDicsRequset queryDicsRequset = new QueryDicsRequset();
        queryDicsRequset.dicName = DIC_NAME;
        queryDicsRequset.itemName = str;
        return ServerServiceFactory.createCardServerApi(this.mContext).queryDics(queryDicsRequset);
    }
}
