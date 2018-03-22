package com.huawei.nfc.carrera.ui.carddetail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.BaseLibUtil;
import java.util.ArrayList;
import java.util.List;

public class CardDetailActivity extends NFCBaseActivity implements OnClickListener {
    public static final String CARD_NAME = "cardName";
    private static final int FIRST_INSERT_INDEX = 3;
    public static final String HOT_ACTIVITY = "hotActivity";
    private static final int HOT_EVENTS_TAB_INDEX = 0;
    private static final char INSERT_CHARACTER = ' ';
    private static final int NORMAL_PHONE_LENGTH = 10;
    private static final int RECOMMENDED_MERCHANTS_TAB_INDEX = 1;
    public static final String RECOMMEND_MERCHANT = "recommendMerchant";
    private static final int SECOND_INSERT_INDEX = 6;
    public static final String SERVICE_PHONE = "servicePhone";
    private static final String TAG = "BankDetailFragment";
    private WebViewClient hotActivityClient;
    private LinearLayout hotLoading;
    private List<View> listviews;
    private int mErrorCode = 0;
    private RelativeLayout mHotActLayout;
    private CardDetailViewPager mPager;
    private RelativeLayout mRecShopLayout;
    private RelativeLayout networkExceptionLayout;
    private LinearLayout networkFailLayout;
    private TextView noHotActivityData;
    private LinearLayout noNetworkFlash;
    private TextView noRecommendData;
    private TextView phone;
    private WebViewClient recommendClient;
    private LinearLayout recommendLoading;
    private String servicePhone;
    private Button setNetworkButton;
    private String title;
    private String urlHot;
    private String urlRecommend;
    private WebView webViewHot;
    private WebView webViewRecommend;

    class C56371 extends WebViewClient {
        C56371() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            CardDetailActivity.this.mErrorCode = 0;
            CardDetailActivity.this.controlHotLoading(0, 8);
            LogX.i(CardDetailActivity.TAG, "onPageStarted.");
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            if (CardDetailActivity.this.mErrorCode == 0) {
                CardDetailActivity.this.mPager.setVisibility(0);
                CardDetailActivity.this.controlHotLoading(8, 0);
            }
            LogX.i(CardDetailActivity.TAG, "onPageFinished.  mErrorCode : " + CardDetailActivity.this.mErrorCode);
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            LogX.i(CardDetailActivity.TAG, "onReceivedError.errorCode==" + i + "  description==" + str + "  failingUrl==" + str2 + "networkFailLayout" + CardDetailActivity.this.networkFailLayout);
            CardDetailActivity.this.mErrorCode = i;
            CardDetailActivity.this.controlHotLoading(8, 8);
            CardDetailActivity.this.mPager.setVisibility(8);
            if (C4026a.m19819a(CardDetailActivity.this)) {
                CardDetailActivity.this.networkExceptionLayout.setVisibility(0);
            } else {
                CardDetailActivity.this.networkFailLayout.setVisibility(0);
            }
        }
    }

    class C56382 extends WebViewClient {
        C56382() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            CardDetailActivity.this.mErrorCode = 0;
            CardDetailActivity.this.controlRecommendLoading(0, 8);
            LogX.i(CardDetailActivity.TAG, "onPageStarted.");
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            if (CardDetailActivity.this.mErrorCode == 0) {
                CardDetailActivity.this.mPager.setVisibility(0);
                CardDetailActivity.this.controlRecommendLoading(8, 0);
            }
            LogX.i(CardDetailActivity.TAG, "onPageFinished.  mErrorCode : " + CardDetailActivity.this.mErrorCode);
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            LogX.i(CardDetailActivity.TAG, "onReceivedError.errorCode==" + i + "  description==" + str + "  failingUrl==" + str2 + "networkFailLayout" + CardDetailActivity.this.networkFailLayout);
            CardDetailActivity.this.mErrorCode = i;
            CardDetailActivity.this.controlRecommendLoading(8, 8);
            CardDetailActivity.this.mPager.setVisibility(8);
            if (C4026a.m19819a(CardDetailActivity.this)) {
                CardDetailActivity.this.networkExceptionLayout.setVisibility(0);
            } else {
                CardDetailActivity.this.networkFailLayout.setVisibility(0);
            }
        }
    }

    @SuppressLint({"CommitTransaction", "NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        if (initParams()) {
            setTitle(this.title);
            setContentView(R.layout.nfc_detail_layout);
            initWebViewClient();
            initViews();
            this.mHotActLayout.setOnClickListener(this);
            this.mRecShopLayout.setOnClickListener(this);
            this.noNetworkFlash.setOnClickListener(this);
            this.setNetworkButton.setOnClickListener(this);
            setSelectTab(0);
            if (this.urlHot != null) {
                this.webViewHot.loadUrl(this.urlHot);
                this.noHotActivityData.setVisibility(8);
            } else {
                this.noHotActivityData.setVisibility(0);
            }
            if (this.urlRecommend != null) {
                this.webViewRecommend.loadUrl(this.urlRecommend);
                this.noRecommendData.setVisibility(8);
                return;
            }
            this.noRecommendData.setVisibility(0);
            return;
        }
        finish();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            LogX.e("initParams intent empty.");
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e("bundle empty.");
            return false;
        }
        this.urlHot = extras.getString(HOT_ACTIVITY);
        this.urlRecommend = extras.getString(RECOMMEND_MERCHANT);
        this.title = extras.getString("cardName");
        this.servicePhone = extras.getString(SERVICE_PHONE);
        return true;
    }

    private void initViews() {
        this.networkFailLayout = (LinearLayout) findViewById(R.id.network_fail_layout);
        this.networkFailLayout.setOnClickListener(this);
        this.networkExceptionLayout = (RelativeLayout) findViewById(R.id.query_fail_view);
        this.networkExceptionLayout.setOnClickListener(this);
        this.networkExceptionLayout.setVisibility(8);
        this.setNetworkButton = (Button) findViewById(R.id.set_network_button);
        this.noNetworkFlash = (LinearLayout) findViewById(R.id.no_network_tip);
        this.phone = (TextView) findViewById(R.id.number);
        this.phone.setText(formatPhoneNumber(this.servicePhone));
        this.mPager = (CardDetailViewPager) findViewById(R.id.vpager);
        this.listviews = new ArrayList();
        LayoutInflater layoutInflater = getLayoutInflater();
        View inflate = layoutInflater.inflate(R.layout.nfc_detail_hot_activity, null);
        this.webViewHot = (WebView) inflate.findViewById(R.id.webview_hot_activity);
        this.hotLoading = (LinearLayout) inflate.findViewById(R.id.hot_loading);
        initWebViewSettings(this.webViewHot, this.hotActivityClient);
        this.listviews.add(inflate);
        this.noHotActivityData = (TextView) inflate.findViewById(R.id.nfc_textview_hot);
        View inflate2 = layoutInflater.inflate(R.layout.nfc_detail_recommended_merchant, null);
        this.webViewRecommend = (WebView) inflate2.findViewById(R.id.webview_recommend);
        this.recommendLoading = (LinearLayout) inflate2.findViewById(R.id.recommend_loading);
        initWebViewSettings(this.webViewRecommend, this.recommendClient);
        this.listviews.add(inflate2);
        this.noRecommendData = (TextView) inflate2.findViewById(R.id.nfc_textview_recommend);
        this.mPager.setAdapter(new MyPagerAdapter(this.listviews));
        this.mPager.setCurrentItem(0);
        this.mHotActLayout = (RelativeLayout) findViewById(R.id.layout_left);
        this.mRecShopLayout = (RelativeLayout) findViewById(R.id.right);
    }

    private void setSelectTab(int i) {
        switch (i) {
            case 0:
                this.mHotActLayout.setBackgroundResource(R.drawable.nfc_detail_sub_tab_selected_left_white);
                if (this.urlHot == null || this.urlHot.length() == 0) {
                    this.noHotActivityData.setVisibility(0);
                    return;
                }
                this.webViewHot.loadUrl(this.urlHot);
                this.noHotActivityData.setVisibility(8);
                this.networkFailLayout.setVisibility(8);
                this.networkExceptionLayout.setVisibility(8);
                return;
            case 1:
                this.mRecShopLayout.setBackgroundResource(R.drawable.nfc_detail_sub_tab_selected_right_white);
                if (this.urlRecommend == null || this.urlRecommend.length() == 0) {
                    this.noRecommendData.setVisibility(0);
                    return;
                }
                this.webViewRecommend.loadUrl(this.urlRecommend);
                this.noRecommendData.setVisibility(8);
                this.networkFailLayout.setVisibility(8);
                this.networkExceptionLayout.setVisibility(8);
                return;
            default:
                LogX.i("error index : " + i + " !");
                return;
        }
    }

    public void onResume() {
        setSelectTab(this.mPager.getCurrentItem());
        super.onResume();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.id.layout_left == id) {
            setSelectTab(0);
            this.mPager.setCurrentItem(0);
        } else if (R.id.no_network_tip == id || R.id.query_fail_view == id) {
            setSelectTab(this.mPager.getCurrentItem());
        } else if (R.id.set_network_button == id) {
            BaseLibUtil.jumpToSettings(getApplicationContext());
        } else if (R.id.right == id) {
            setSelectTab(1);
            this.mPager.setCurrentItem(1);
        }
    }

    private void initWebViewClient() {
        this.hotActivityClient = new C56371();
        this.recommendClient = new C56382();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebViewSettings(WebView webView, WebViewClient webViewClient) {
        webView.getSettings().setCacheMode(2);
        webView.setWebViewClient(webViewClient);
    }

    private void controlHotLoading(int i, int i2) {
        if (this.hotLoading != null) {
            this.hotLoading.setVisibility(i);
        }
        if (this.webViewHot != null) {
            this.webViewHot.setVisibility(i2);
        }
    }

    private void controlRecommendLoading(int i, int i2) {
        if (this.recommendLoading != null) {
            this.recommendLoading.setVisibility(i);
        }
        if (this.webViewRecommend != null) {
            this.webViewRecommend.setVisibility(i2);
        }
    }

    private String formatPhoneNumber(String str) {
        if (str == null) {
            return null;
        }
        if (10 != str.length()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            if (3 == i || 6 == i) {
                stringBuffer.append(INSERT_CHARACTER);
            }
            stringBuffer.append(str.charAt(i));
            i++;
        }
        return stringBuffer.toString();
    }
}
