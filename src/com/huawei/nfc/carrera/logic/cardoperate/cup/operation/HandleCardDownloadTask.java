package com.huawei.nfc.carrera.logic.cardoperate.cup.operation;

import android.content.Context;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.LogX;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class HandleCardDownloadTask extends HandleCardOperateBaseTask {
    private final Context mContext;

    public HandleCardDownloadTask(Context context, CUPService cUPService, HandleOperationResutTask handleOperationResutTask, CardOperateListener cardOperateListener) {
        super(cUPService, handleOperationResutTask, cardOperateListener);
        this.mContext = context;
    }

    protected String getOperateEventTag() {
        return CUPCardOperator.OPERATE_EVENT_DOWNLOAD;
    }

    protected boolean isOperationSatisfied(List<String> list) {
        for (String str : list) {
            Object obj;
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
            if (card == null) {
                LogX.d("handle card download event, but the card not existed.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    LogX.e("task sleep, interrupted.");
                }
                card = WalletTaManager.getInstance(this.mContext).getCard(str);
            }
            if (card == null || !(98 == card.cardStatus || 97 == card.cardStatus || 96 == card.cardStatus || 95 == card.cardStatus || 93 == card.cardStatus || 94 == card.cardStatus)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                LogX.d("download statified, refId: " + str);
            } else {
                LogX.d("download not statified, refId: " + str);
                return false;
            }
        }
        return true;
    }

    protected boolean prepareLocalInfo(List<String> list) {
        for (String str : list) {
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
            if (card == null) {
                LogX.d("download prepare failed, refId: " + str);
                return false;
            }
            LogX.d("download prepare now, refId: " + str + ",existed status: " + card.cardStatus);
            switch (card.cardStatus) {
                case 93:
                case 96:
                    card.cardStatus = 95;
                    break;
                case 94:
                case 98:
                    card.cardStatus = 97;
                    break;
                case 95:
                case 97:
                    break;
                default:
                    LogX.d("download prepare failed, refId: " + str);
                    return false;
            }
            storeDownloadInfo(str, 97);
            try {
                WalletTaManager.getInstance(this.mContext).updateCardStatus(str, card.cardStatus);
            } catch (WalletTaCardNotExistException e) {
                LogX.e("ta card not exist exception.");
                return false;
            } catch (WalletTaSystemErrorException e2) {
                LogX.e("wallet ta system error exception.");
                return false;
            }
        }
        return true;
    }

    protected boolean handleSuccessResult(List<String> list) {
        return true;
    }

    protected void handleFailResult(List<String> list, int i) {
        for (String str : list) {
            if (WalletTaManager.getInstance(this.mContext).getCard(str) == null) {
                LogX.d("download prepare failed, refId: " + str);
            }
        }
        CardInfoManager.getInstance(this.mContext).refreshCardList();
    }

    private void storeDownloadInfo(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constant.KEY_DOWNLOAD_INFO_SSID, this.mSsid);
            jSONObject.put("sign", this.mSign);
            jSONObject.put(Constant.KEY_DOWNLOAD_INFO_TIME_STAMP, System.currentTimeMillis());
            NFCPreferences.getInstance(this.mContext).remove(str);
            NFCPreferences.getInstance(this.mContext).putString(str, jSONObject.toString());
        } catch (JSONException e) {
            LogX.d("parsPushConsumeMsg, get json exception.");
        }
    }
}
