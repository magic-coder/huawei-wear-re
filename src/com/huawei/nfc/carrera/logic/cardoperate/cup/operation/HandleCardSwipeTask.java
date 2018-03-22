package com.huawei.nfc.carrera.logic.cardoperate.cup.operation;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import java.util.List;

public class HandleCardSwipeTask extends HandleCardOperateBaseTask {
    private final Context mContext;

    public HandleCardSwipeTask(Context context, CUPService cUPService, HandleOperationResutTask handleOperationResutTask, CardOperateListener cardOperateListener) {
        super(cUPService, handleOperationResutTask, cardOperateListener);
        this.mContext = context;
    }

    protected String getOperateEventTag() {
        return CUPCardOperator.OPERATE_EVENT_WIPEOUT;
    }

    protected boolean isOperationSatisfied(List<String> list) {
        return true;
    }

    protected boolean prepareLocalInfo(List<String> list) {
        LogX.i("swipe, prepareLocalInfo");
        boolean z = false;
        for (String str : list) {
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
            if (card == null) {
                LogX.d("swipe prepare, refId not exsited in ta.");
            } else {
                LogX.d("delete prepare now, refId: " + str + ",existed status: " + card.cardStatus);
                if (3 == card.cardStatus) {
                    LogX.d("swipe prepare, card nullified in ta, refId: " + str);
                } else {
                    try {
                        WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 3);
                        z = true;
                    } catch (WalletTaCardNotExistException e) {
                        LogX.e("ta card not exist exception.");
                        return false;
                    } catch (WalletTaSystemErrorException e2) {
                        LogX.e("wallet ta system error exception.");
                        return false;
                    }
                }
            }
        }
        if (z) {
            CardInfoManager.getInstance(this.mContext).refreshCardList();
        }
        return true;
    }

    protected boolean handleSuccessResult(List<String> list) {
        boolean z = true;
        for (String str : list) {
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
            if (card == null) {
                LogX.d("update after delete, refId not exsited in ta.");
            } else {
                boolean z2;
                LogX.d("delete after swipe, ta info now, refId: " + str);
                try {
                    WalletTaManager.getInstance(this.mContext).removeCard(str);
                    CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(card.aid, null);
                    z2 = z;
                } catch (WalletTaCardNotExistException e) {
                    LogX.e("ta card not exist exception.");
                    z2 = z;
                } catch (WalletTaSystemErrorException e2) {
                    LogX.e("wallet ta system error exception.");
                    z2 = false;
                }
                z = z2;
            }
        }
        return z;
    }

    protected void handleFailResult(List<String> list, int i) {
    }
}
