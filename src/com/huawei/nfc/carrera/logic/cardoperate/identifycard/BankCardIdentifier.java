package com.huawei.nfc.carrera.logic.cardoperate.identifycard;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.cup.identifycard.IdentifyCardResult;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryDicsRequset;
import com.huawei.nfc.carrera.server.card.response.DicItem;
import com.huawei.nfc.carrera.server.card.response.QueryDicsResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class BankCardIdentifier {
    private static final int CARD_BIN_CNT = 6;
    private static final String DIC_NAME = "bankcard.bin";
    private static final String SPLITER = ",";
    private static final String TAG = "BankCardIdentifier";
    private final Context mContext;

    public BankCardIdentifier(Context context) {
        this.mContext = context;
    }

    public IdentifyCardResult identifyCardNum(String str) {
        LogX.d("====Enter identifyCardNum");
        IdentifyCardResult identifyCardResult = new IdentifyCardResult();
        identifyCardResult.setResultCode(-99);
        if (StringUtil.isEmpty(str, true)) {
            LogX.d("====Enter StringUtil.isEmpty(cardNum, true)");
        } else {
            String[] issuerIdFromServer = getIssuerIdFromServer(str.substring(0, 6));
            if (issuerIdFromServer.length > 1) {
                identifyCardResult.setResultCode(0);
                identifyCardResult.setIssuerId(issuerIdFromServer[0]);
                identifyCardResult.setBankCardType(Integer.parseInt(issuerIdFromServer[1]));
            } else {
                LogX.d(TAG, "get card bin error");
            }
        }
        return identifyCardResult;
    }

    private String[] getIssuerIdFromServer(String str) {
        QueryDicsRequset queryDicsRequset = new QueryDicsRequset();
        queryDicsRequset.dicName = DIC_NAME;
        queryDicsRequset.itemName = str;
        QueryDicsResponse queryDics = ServerServiceFactory.createCardServerApi(this.mContext).queryDics(queryDicsRequset);
        if (queryDics == null || queryDics.returnCode != 0) {
            Object valueOf;
            String[] strArr = new String[0];
            String str2 = TAG;
            StringBuilder append = new StringBuilder().append("query dictionary failed from wallet server return code : ");
            if (queryDics != null) {
                valueOf = Integer.valueOf(queryDics.returnCode);
            } else {
                valueOf = null;
            }
            LogX.e(str2, append.append(valueOf).toString());
            return strArr;
        }
        int size = queryDics.dicItems.size();
        if (size <= 0) {
            LogX.d(TAG, "there is not matched issuer data.");
            return new String[0];
        } else if (size > 1) {
            LogX.e(TAG, "card bin data duplicated at server.");
            return new String[0];
        } else {
            DicItem dicItem = (DicItem) queryDics.dicItems.get(0);
            LogX.d("getIssuerIdFromServer, item name: " + dicItem.getName());
            String value = dicItem.getValue();
            String[] strArr2;
            if (!str.equals(dicItem.getParent()) || value == null) {
                strArr2 = new String[0];
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "getIssuerIdFromServer failed. query server failed. retCode = " + queryDics.returnCode);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_QUERY_ISSUER_ID_ERR, hashMap, null, false, false);
                LogX.e(TAG, "query dictionary failed, incorrect data configuration at server.");
                return strArr2;
            }
            strArr2 = value.split(SPLITER);
            if (strArr2.length == 2) {
                return strArr2;
            }
            LogX.e(TAG, "query dictionary failed, incorrect data configuration at server. data : " + value);
            return new String[0];
        }
    }
}
