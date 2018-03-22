package com.huawei.nfc.carrera.logic.cardoperate.cup.operation;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import java.util.List;

public class HandleCardDeleteTask extends HandleCardOperateBaseTask {
    private final Context mContext;

    public HandleCardDeleteTask(Context context, CUPService cUPService, HandleOperationResutTask handleOperationResutTask, CardOperateListener cardOperateListener) {
        super(cUPService, handleOperationResutTask, cardOperateListener);
        this.mContext = context;
    }

    protected String getOperateEventTag() {
        return "DELETE";
    }

    protected boolean isOperationSatisfied(List<String> list) {
        return true;
    }

    protected boolean prepareLocalInfo(List<String> list) {
        boolean z = false;
        for (String str : list) {
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
            if (card == null) {
                LogX.d("delete prepare, refId not exsited in ta.");
            } else {
                LogX.d("delete prepare now, refId: " + str + ",existed status: " + card.cardStatus);
                if (3 == card.cardStatus) {
                    LogX.d("delete prepare, card nullified in ta, refId: " + str);
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
            LogX.d("delete ta info now, refId: " + str);
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
            if (card == null) {
                LogX.d("delete ta info now, not existed: " + str);
            } else {
                boolean z2;
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
        CardInfoManager.getInstance(this.mContext).refreshCardList();
        return z;
    }

    protected void handleFailResult(List<String> list, int i) {
    }
}
