package com.huawei.nfc.carrera.ui.swipe;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.CardInfoManagerApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.CardListItem;
import com.huawei.nfc.carrera.logic.swipe.SwipeLogicManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.ui.carddisplay.AnimUtil;
import com.huawei.wallet.ui.carddisplay.CardDisplayManager;
import com.huawei.wallet.ui.carddisplay.CardDisplayManager.OnAnimateListener;
import com.huawei.wallet.ui.carddisplay.CardLayout;
import com.huawei.wallet.ui.carddisplay.CardLayout.OnItemClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwipeListController implements SetCardDefaultCallback, OnAnimateListener, OnItemClickListener {
    public static final String ALI_PACKAGENAME = "com.eg.android.AlipayGphone";
    public static final String WEIXIN_PACKAGENAME = "com.tencent.mm";
    private int bottomViewMarginTop;
    private int cardCount;
    private CardDisplayManager cardDisplayManager;
    private int cardHeight;
    private CardInfoManagerApi cardInfoManagerApi;
    private CardLayout cardListContainer;
    private int cardWidth;
    private int cardsMarginTop;
    private CardListItem defaultCardInfo;
    private int firstCardDistanceToBottom;
    private int initBottomViewY;
    private boolean isCalfirstCardDistanceToBottom;
    private boolean isScanPayMode = false;
    private boolean isScrollEnable = false;
    private int itemClickIndex = -1;
    private List<CardListItem> listItems = new ArrayList();
    private SwipeActivity mContext;
    private ScanPayView scanPayView;
    private ScrollView scrollView;
    List<String> supportPay = new ArrayList();
    private SwipeLogicManager swipeLogicManager;
    private TipFragmentContainer tipViewContainer;
    private TextView topView;
    private int topViewHeight;
    private List<UniCardInfo> uniCardInfos = new ArrayList();

    class OnTouchListenrtImpl2 implements OnTouchListener {
        OnTouchListenrtImpl2() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class OnTouchListenrtImpl implements OnTouchListener {
        OnTouchListenrtImpl() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public SwipeListController(Context context, SwipeLogicManager swipeLogicManager) {
        this.mContext = (SwipeActivity) context;
        this.cardInfoManagerApi = LogicApiFactory.createCardManager(this.mContext);
        this.swipeLogicManager = swipeLogicManager;
    }

    public void refreshNFCCardListView(List<CardListItem> list) {
        this.isScanPayMode = false;
        initCardListView(list);
    }

    public void refreshScanPayListView(List<CardListItem> list, List<String> list2) {
        this.isScanPayMode = true;
        if (!(list2 == null || list2.isEmpty())) {
            this.supportPay.clear();
            this.supportPay.addAll(list2);
            this.scanPayView = (ScanPayView) this.mContext.findViewById(R.id.nfc_card_swipe_scanView);
            this.scanPayView.setData(this.supportPay);
        }
        initCardListView(list);
    }

    private void initCardListView(List<CardListItem> list) {
        this.cardListContainer = (CardLayout) this.mContext.findViewById(R.id.nfc_card_swipe_container);
        this.cardListContainer.setItemClickListener(this);
        this.cardListContainer.setDragEnable(false);
        this.topView = (TextView) this.mContext.findViewById(R.id.swipe_paytext);
        this.scrollView = (ScrollView) this.mContext.findViewById(R.id.swipe_scroll);
        this.cardsMarginTop = (int) this.mContext.getResources().getDimension(R.dimen.scanpay_cards_top_margin);
        this.cardCount = list.size();
        initCardListData(list);
        loadCardListView();
    }

    public int getScreenHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private void setParam(int i) {
        int screenHeight = getScreenHeight() - i;
        if (this.cardDisplayManager != null) {
            this.cardDisplayManager.m28175a(screenHeight);
        }
        this.isCalfirstCardDistanceToBottom = true;
        this.firstCardDistanceToBottom = screenHeight;
    }

    private void disPlayCardsView(int i) {
        initTipContainer();
        this.cardDisplayManager.m28184a(this.uniCardInfos);
        if (this.defaultCardInfo == null) {
            LogX.w("showPayModeList failed.defaultCardInfo is null");
            return;
        }
        this.cardDisplayManager.m28178a(i, this.tipViewContainer, 2);
        initFirstStep(this.defaultCardInfo.getCardGroup());
        this.topView.setVisibility(8);
        if (this.scanPayView != null) {
            if (this.cardCount > 1) {
                setBottomViewLayoutParam();
                this.scanPayView.setY((this.cardDisplayManager.m28207k() + ((float) this.cardDisplayManager.m28202g())) + ((float) this.bottomViewMarginTop));
            } else if (this.cardCount == 1) {
                setBottomViewLayoutParam();
                this.scanPayView.setY((float) (this.cardDisplayManager.m28169a() + this.bottomViewMarginTop));
            } else {
                this.scanPayView.setY(0.0f);
                this.scanPayView.setVisibility(0);
            }
            LogX.i("scanView,getY() is:  " + this.scanPayView.getY());
        }
    }

    private void disPlayCardsView() {
        this.cardDisplayManager.m28184a(this.uniCardInfos);
        initTipContainer();
        this.cardDisplayManager.m28193c();
        if (this.scanPayView == null) {
            return;
        }
        if (this.cardCount > 0) {
            setBottomViewLayoutParam();
            return;
        }
        this.scanPayView.setY(0.0f);
        this.scanPayView.setVisibility(0);
    }

    private void setBottomViewLayoutParam() {
        if (this.bottomViewMarginTop == 0) {
            this.bottomViewMarginTop = (int) this.mContext.getResources().getDimension(R.dimen.scanpay_bottom_top_margin);
        }
        this.initBottomViewY = this.cardDisplayManager.mo5153d() + this.bottomViewMarginTop;
        LogX.i("setBottomViewLayoutParam initBottomViewY= " + this.initBottomViewY + ", marginTop= " + this.bottomViewMarginTop);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.scanPayView.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = this.initBottomViewY;
            this.scanPayView.setLayoutParams(marginLayoutParams);
            this.scanPayView.setVisibility(0);
        }
    }

    private void initCardListData(List<CardListItem> list) {
        this.listItems.clear();
        this.listItems.addAll(list);
        this.uniCardInfos.clear();
        for (int i = 0; i < list.size(); i++) {
            CardListItem cardListItem = (CardListItem) list.get(i);
            this.uniCardInfos.add(convertItemToUniCard(cardListItem));
            if (cardListItem.isDefault()) {
                this.itemClickIndex = i;
                this.defaultCardInfo = cardListItem;
            }
        }
        if (this.defaultCardInfo == null && this.listItems.size() > 0) {
            this.itemClickIndex = this.listItems.size() - 1;
            setDefaultCard((CardListItem) this.listItems.get(this.itemClickIndex));
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "This is No default Card on Swip");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_VERIFY_FINFER_FAIL, hashMap, null, false, false);
        }
    }

    private UniCardInfo convertItemToUniCard(CardListItem cardListItem) {
        String string;
        UniCardInfo uniCardInfo = new UniCardInfo();
        if (cardListItem.getCardGroup() == 1) {
            string = this.mContext.getString(R.string.nfc_card_num_show, new Object[]{cardListItem.getFpanFour()});
        } else {
            string = cardListItem.getFpanFour();
        }
        uniCardInfo.m28115e(string);
        uniCardInfo.m28120g(cardListItem.getCardIconLocalPath());
        uniCardInfo.m28112c(cardListItem.getProductId());
        uniCardInfo.m28111c(cardListItem.getCardGroup());
        uniCardInfo.m28104a(cardListItem.getStatusUpdateTime());
        return uniCardInfo;
    }

    private void loadCardListView() {
        this.cardWidth = this.mContext.getResources().getDisplayMetrics().widthPixels - (((int) this.mContext.getResources().getDimension(R.dimen.nfc_cardlist_leftorright_margin)) * 2);
        this.cardHeight = (int) (((double) this.cardWidth) / 1.6d);
        if (this.cardDisplayManager == null) {
            this.cardDisplayManager = new CardDisplayManager(this.mContext, this.cardListContainer, this.cardWidth, this.cardHeight);
        }
        LogX.i("cardHeight is :" + this.cardHeight + "  and cardWith is :" + this.cardWidth);
        this.cardDisplayManager.m28184a(this.uniCardInfos);
        this.cardDisplayManager.m28196d(2);
        this.cardDisplayManager.m28183a((OnAnimateListener) this);
        showCardListView();
    }

    private void showCardListView() {
        LogX.i("isCalfirstCardDistanceToBottom is:  " + this.isCalfirstCardDistanceToBottom);
        final Rect rect = new Rect();
        final ViewTreeObserver viewTreeObserver = this.cardListContainer.getViewTreeObserver();
        if (this.cardListContainer.getHeight() > 0) {
            this.topViewHeight = this.topView.getMeasuredHeight();
            this.cardListContainer.getGlobalVisibleRect(rect);
            int i = rect.top;
            if (i > 0) {
                setParam(i);
                if (this.cardDisplayManager.m28206j() == 0.0f) {
                    this.cardDisplayManager.m28174a((float) this.topViewHeight);
                } else {
                    this.cardDisplayManager.m28174a(0.0f);
                }
                showCardListViewByMode(this.isScanPayMode);
                return;
            }
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                LogX.i("isCalfirstCardDistanceToBottom is" + SwipeListController.this.isCalfirstCardDistanceToBottom);
                if (!SwipeListController.this.isCalfirstCardDistanceToBottom && SwipeListController.this.cardListContainer.getHeight() > 0) {
                    SwipeListController.this.topViewHeight = SwipeListController.this.topView.getMeasuredHeight();
                    SwipeListController.this.cardListContainer.getGlobalVisibleRect(rect);
                    int i = rect.top;
                    if (i > 0) {
                        SwipeListController.this.setParam(i);
                        SwipeListController.this.cardDisplayManager.m28174a((float) SwipeListController.this.topViewHeight);
                        SwipeListController.this.showCardListViewByMode(SwipeListController.this.isScanPayMode);
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        }
                    }
                }
            }
        });
    }

    private void showCardListViewByMode(boolean z) {
        if (z) {
            if (this.supportPay.isEmpty()) {
                if (this.listItems.size() > 0) {
                    disPlayCardsView(this.itemClickIndex);
                    this.swipeLogicManager.reportBIOnNFCSelected(this.defaultCardInfo);
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "No cards and No Pay Form");
                    LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SWIPE_VERIFY_FINFER_FAIL, hashMap, null, false, false);
                }
            } else if (!this.swipeLogicManager.isLastPayNFC() || this.listItems.size() <= 0) {
                disPlayCardsView();
            } else {
                disPlayCardsView(this.itemClickIndex);
                this.swipeLogicManager.reportBIOnNFCSelected(this.defaultCardInfo);
            }
            LogX.i("showCardListViewByMode:cardlist load finish");
            return;
        }
        disPlayCardsView(this.itemClickIndex);
    }

    private void initTipContainer() {
        if (this.tipViewContainer == null) {
            this.tipViewContainer = new TipFragmentContainer(this.mContext, this.mContext.getSupportFragmentManager());
            this.tipViewContainer.setId(R.id.card_brief);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.cardWidth, ((this.firstCardDistanceToBottom - this.cardHeight) - this.cardDisplayManager.m28186b(2)) + this.topViewHeight);
            layoutParams.addRule(14);
            this.tipViewContainer.setLayoutParams(layoutParams);
            this.mContext.setContainer(this.tipViewContainer);
        }
    }

    private void initFirstStep(int i) {
        LogX.i("cardType is: " + i);
        if (i == 2) {
            this.mContext.toNextStep();
        } else {
            this.mContext.checkAndStartNewSwipe();
        }
    }

    public void onItemClick(View view, int i) {
        if (!this.cardDisplayManager.m28204h()) {
            if (!this.tipViewContainer.isShown() && !this.listItems.isEmpty()) {
                setDefaultCard((CardListItem) this.listItems.get(i));
                initFirstStep(this.defaultCardInfo.getCardGroup());
                this.itemClickIndex = i;
            } else if (this.tipViewContainer.isShown()) {
                this.tipViewContainer.pauseFragments();
            }
            startTopViewAninate();
            this.cardDisplayManager.m28181a(view, i, this.tipViewContainer);
        }
    }

    private void startTopViewAninate() {
        if (this.cardDisplayManager.m28205i()) {
            AnimUtil.m28157a(this.topView);
        } else {
            AnimUtil.m28158a(this.topView, this.topViewHeight);
        }
    }

    public void onAnimateUpdate(int i, float f, boolean z) {
        if (this.cardCount <= 1) {
            return;
        }
        if (this.itemClickIndex != this.cardCount - 1) {
            if (i == this.cardCount - 1 && this.scanPayView != null) {
                updateBottomViewPos(f, z);
            }
        } else if (i == this.cardCount - 2 && this.scanPayView != null) {
            updateBottomViewPos(f, z);
        }
    }

    private void updateBottomViewPos(float f, boolean z) {
        float g = ((float) this.bottomViewMarginTop) + (((float) this.cardDisplayManager.m28202g()) + f);
        if (g < ((float) this.initBottomViewY)) {
            if (z) {
                this.scanPayView.setY((float) this.initBottomViewY);
            }
        } else if (this.isScrollEnable) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.scanPayView.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) g;
                this.scanPayView.setLayoutParams(marginLayoutParams);
            }
        } else {
            this.scanPayView.setY(g);
        }
    }

    public void onAllAnimateEnd(boolean z) {
        if (z || this.isScrollEnable) {
            this.scrollView.setOnTouchListener(new OnTouchListenrtImpl());
        } else {
            this.scrollView.setOnTouchListener(new OnTouchListenrtImpl2());
        }
    }

    public void onAnimateEnd(int i, boolean z) {
        LogX.i(" onAnimateEnd cardIndex=" + i + ", isCollapse= " + z);
    }

    public void onAnimateStart(int i, boolean z) {
        LogX.i(" onAnimateStart cardIndex=" + i + ", cardDisplayManager.getMoveOffset()=" + this.cardDisplayManager.m28206j());
        if (i == 0 && this.scanPayView != null) {
            updateBottomView(z);
        }
    }

    private void updateBottomView(boolean z) {
        if (this.cardCount == 1) {
            float f;
            if (z) {
                f = 0.0f;
            } else {
                f = (float) (this.cardDisplayManager.m28169a() + this.cardsMarginTop);
            }
            startBottomViewAnimator(500, f);
        }
    }

    private void startBottomViewAnimator(int i, float f) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{this.scanPayView.getY() - ((float) this.initBottomViewY), f});
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.scanPayView, new PropertyValuesHolder[]{ofFloat}).setDuration((long) i);
        duration.setInterpolator(new DecelerateInterpolator(1.5f));
        duration.start();
    }

    private void setDefaultCard(CardListItem cardListItem) {
        this.defaultCardInfo = cardListItem;
        if (!cardListItem.isDefault()) {
            this.cardInfoManagerApi.setCardDefault(cardListItem.getReferenceId(), this);
            if (this.isScanPayMode) {
                this.swipeLogicManager.reportBIOnNFCSelected(this.defaultCardInfo);
            }
        }
    }

    public void setResultCallback(int i) {
        if (i == 0) {
            for (int i2 = 0; i2 < this.listItems.size(); i2++) {
                if (i2 == this.itemClickIndex) {
                    ((CardListItem) this.listItems.get(i2)).setDefault(true);
                } else {
                    ((CardListItem) this.listItems.get(i2)).setDefault(false);
                }
            }
            return;
        }
        if (!this.cardListContainer.m28259d()) {
            this.cardDisplayManager.m28181a(this.cardListContainer.getChildAt(this.itemClickIndex), this.itemClickIndex, this.tipViewContainer);
        }
        LogX.e("Set default Card Faild on SwipActivity");
    }

    public CardListItem getDefaultCard() {
        return this.defaultCardInfo;
    }
}
