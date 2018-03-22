package com.huawei.nfc.carrera.logic.cardoperate.cup.identifycard;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.logic.spi.unionpay.response.CUPEncryptResponse;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.request.IdentifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.IdentifyCUPCardResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public class CUPCardIdentifier {
    CardServerApi mCardServerApi;
    Context mContext;
    CUPService mCupServiceApi;

    public CUPCardIdentifier(Context context, CUPService cUPService, CardServerApi cardServerApi) {
        this.mContext = context;
        this.mCupServiceApi = cUPService;
        this.mCardServerApi = cardServerApi;
    }

    public IdentifyCardResult indentifyCUPCard(String str) {
        IdentifyCardResult identifyCardResult = new IdentifyCardResult();
        CUPEncryptResponse encryptCardInfo = this.mCupServiceApi.encryptCardInfo(str);
        LogX.d("indentifyCard, encrypte response code: " + encryptCardInfo.responseCode);
        if (encryptCardInfo.responseCode == 0) {
            if (!StringUtil.isEmpty(encryptCardInfo.encrytedStr, true)) {
                IdentifyCUPCardRequest identifyCUPCardRequest = new IdentifyCUPCardRequest();
                identifyCUPCardRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
                identifyCUPCardRequest.encryptedFpan = encryptCardInfo.encrytedStr;
                identifyCUPCardRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
                identifyCUPCardRequest.setRsaKeyIndex(-1);
                identifyCUPCardRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
                IdentifyCUPCardResponse identifyCUPCard = this.mCardServerApi.identifyCUPCard(identifyCUPCardRequest);
                LogX.d("indentifyCard, response" + identifyCUPCard.returnCode);
                switch (identifyCUPCard.returnCode) {
                    case -4:
                        identifyCardResult.setResultCode(-3);
                        Map hashMap = new HashMap();
                        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "CUPCardOperator identifyCUPCard server overload 503");
                        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_IDENTIFY_ERR, hashMap, "indentifyCUPCard err", false, false);
                        break;
                    case -2:
                        identifyCardResult.setResultCode(-3);
                        break;
                    case -1:
                        identifyCardResult.setResultCode(-2);
                        break;
                    case 0:
                        identifyCardResult.setResultCode(0);
                        identifyCardResult.setIssuerId(identifyCUPCard.issuerId);
                        identifyCardResult.setBankCardType(identifyCUPCard.cardType);
                        break;
                    case IdentifyCUPCardResponse.ERR_CHECK_CARD_BIN_FAIL /*1110*/:
                    case 1301:
                    case IdentifyCUPCardResponse.ERR_NO_ISSUER_INFO /*1349*/:
                    case IdentifyCUPCardResponse.ERR_UNSUPPORTED_CARD_TYPE /*1617*/:
                    case IdentifyCUPCardResponse.ERR_NO_BANK_INFO /*1618*/:
                        identifyCardResult.setResultCode(-4);
                        break;
                    default:
                        Map hashMap2 = new HashMap();
                        hashMap2.put(CloudEyeLogger.FAIL_CODE, String.valueOf(identifyCUPCard.returnCode));
                        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_IDENTIFY_ERR, hashMap2, "indentifyCUPCard err", true, false);
                        identifyCardResult.setResultCode(-99);
                        break;
                }
            }
            LogX.d("indentifyCard, encryptedStr is illegal.");
            identifyCardResult.setResultCode(-99);
        } else {
            switch (encryptCardInfo.responseCode) {
                case -5:
                    identifyCardResult.setResultCode(-5);
                    break;
                case -3:
                    identifyCardResult.setResultCode(-3);
                    break;
                case -1:
                    identifyCardResult.setResultCode(-1);
                    break;
                default:
                    identifyCardResult.setResultCode(-99);
                    break;
            }
        }
        return identifyCardResult;
    }
}
