package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.CardOperateLogic;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.NullifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleCUPCardNullifiedTask extends CUPTsmLibDataWaiter {
    private static final String TAG = "HandleCUPCardNullifiedTask";
    private final String mRefId;

    public HandleCUPCardNullifiedTask(Context context, String str) {
        super(context, "DELETE");
        this.mRefId = str;
    }

    public boolean modifyCUPCard() {
        boolean z = false;
        NullifyCUPCardRequest nullifyCUPCardRequest = new NullifyCUPCardRequest();
        nullifyCUPCardRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        nullifyCUPCardRequest.setRsaKeyIndex(-1);
        nullifyCUPCardRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        nullifyCUPCardRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        nullifyCUPCardRequest.cardRefId = this.mRefId;
        CardServerBaseResponse nullifyCUPCard = ServerServiceFactory.createCardServerApi(this.mContext).nullifyCUPCard(nullifyCUPCardRequest);
        if (nullifyCUPCard != null) {
            LogX.i("send delete card request, resultCode: " + nullifyCUPCard.returnCode);
            switch (nullifyCUPCard.returnCode) {
                case -4:
                    Map hashMap = new HashMap();
                    String str = "sendDeleteCardRequest nullifyCUPCard server overload 503";
                    hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                    LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_OVERLOAD_ERR, hashMap, str, false, false);
                    break;
                case 0:
                    z = checkAndCleanData();
                    break;
                case 1342:
                    z = removeTaInfo(this.mRefId);
                    break;
                default:
                    LogX.e("nullifyCUPCard err, return code : " + nullifyCUPCard.returnCode);
                    z = handleDefaultErr(nullifyCUPCard);
                    break;
            }
            if (z) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
            }
        }
        return z;
    }

    private boolean handleDefaultErr(CardServerBaseResponse cardServerBaseResponse) {
        List arrayList = new ArrayList();
        arrayList.add(this.mRefId);
        boolean checkAndCleanCupTAData = checkAndCleanCupTAData(arrayList);
        if (!checkAndCleanCupTAData) {
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mRefId);
            if (card != null) {
                Map hashMap = new HashMap();
                String str = "sendDeleteCardRequest retrun code : " + cardServerBaseResponse.returnCode;
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                hashMap.put("issuerId", card.issuerId);
                hashMap.put("productId", card.productId);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR, hashMap, str, true, false);
            }
        }
        return checkAndCleanCupTAData;
    }

    private boolean checkAndCleanData() {
        CardOperateLogic.getInstance(this.mContext).registerCUPOperationListener("DELETE", this.mRefId, this);
        List arrayList = new ArrayList();
        arrayList.add(this.mRefId);
        C2538c.b(TAG, new Object[]{" cleanCUPCard waitOperationResult "});
        boolean waitOperationResult = waitOperationResult(arrayList);
        CardOperateLogic.getInstance(this.mContext).unregisterCUPOperationListener("DELETE", this.mRefId, this);
        LogX.d("checkAndCleanData result : " + waitOperationResult);
        if (waitOperationResult) {
            return waitOperationResult;
        }
        return checkAndCleanCupTAData(arrayList);
    }
}
