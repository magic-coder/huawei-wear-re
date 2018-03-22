package com.huawei.nfc.carrera.logic;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.ui.carddisplay.CardListInfoListener;
import java.util.List;

public interface NFCOpenApi {
    View getCardDetailView(UniCardInfo uniCardInfo, Activity activity, int i);

    void initNFC(Activity activity);

    boolean isCanDragStop(int i, int i2, List<UniCardInfo> list, Context context);

    boolean isShowQuickPayTipDialog(Context context);

    void jumpToAddCardActivity(Activity activity);

    void onDragStop(int i, int i2, List<UniCardInfo> list);

    void refreshCardList();

    void registerCardListInfoListener(CardListInfoListener cardListInfoListener);

    void setRefreshRF(boolean z);

    void unregisterCardListListener(CardListInfoListener cardListInfoListener);
}
