package com.huawei.nfc.carrera.logic.cardoperate.bus;

import android.util.SparseIntArray;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;

public class SpiResultCodeTranslator {
    private static final String TAG = "SpiResultCodeTranslator";
    private static SparseIntArray sReadESECardResultCodeTable = new SparseIntArray();
    private static SparseIntArray sSNBResultCodeTable = new SparseIntArray();

    static {
        sSNBResultCodeTable.append(0, 0);
        sSNBResultCodeTable.append(400001, 11);
        sSNBResultCodeTable.append(400002, 12);
        sSNBResultCodeTable.append(400101, 99);
        sSNBResultCodeTable.append(400102, 99);
        sSNBResultCodeTable.append(400814, 99);
        sSNBResultCodeTable.append(100001, 10);
        sSNBResultCodeTable.append(100002, 99);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_FAILED, 1301);
        sSNBResultCodeTable.append(1131, RechargeCallback.RETURN_RECHARGE_FAILED_RETRYABLE);
        sSNBResultCodeTable.append(1132, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE_RETRYABLE);
        sSNBResultCodeTable.append(1133, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_REACH_LIMIT_REFUNDABLE, RechargeCallback.RETURN_RECHARGE_REACH_LIMIT_REFUNDABLE);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_FAILED_CARD_NOT_EXIST, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_FAILED_CARD_DISABLED, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_FAILED_CARD_RETIRED, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_FAILED_OVER_VALIDITY, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_FAILED_AMOUNT_EXCEEDING_LIMIT, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(1141, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(SNBConstant.SNB_RECHARGE_FAILED_CPLC_RESET_NOT_SATISFIED, RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE);
        sSNBResultCodeTable.append(1134, IssueTrafficCardCallback.RETURN_FAILED_REPEAT_ISSUERCARD);
        sSNBResultCodeTable.append(SNBConstant.SNB_REPEAT_RECHARGE, 0);
        sSNBResultCodeTable.append(100003, 99);
        sSNBResultCodeTable.append(SNBConstant.SNB_SERVER_PROVIDER_OUT_OF_SERVICE, 1010);
        sSNBResultCodeTable.append(SNBConstant.SNB_SERVER_ERROR_OUT_OF_STOCK, 1009);
        sReadESECardResultCodeTable.append(-1, 20);
        sReadESECardResultCodeTable.append(-2, 21);
        sReadESECardResultCodeTable.append(-3, 22);
        sReadESECardResultCodeTable.append(-4, 23);
        sReadESECardResultCodeTable.append(-5, 1006);
        sReadESECardResultCodeTable.append(-6, 1004);
        sReadESECardResultCodeTable.append(-7, 1005);
        sReadESECardResultCodeTable.append(-8, 24);
        sSNBResultCodeTable.append(430001, 20);
        sSNBResultCodeTable.append(430002, 29);
        sSNBResultCodeTable.append(430003, 23);
        sSNBResultCodeTable.append(430004, 21);
        sSNBResultCodeTable.append(430005, 22);
        sSNBResultCodeTable.append(430006, 27);
        sSNBResultCodeTable.append(430007, 24);
        sSNBResultCodeTable.append(430008, 29);
    }

    public static int getSnbResultCode(int i) {
        C2538c.c(TAG, new Object[]{"getSnbResultCode  returnCd : " + i});
        int i2 = sSNBResultCodeTable.get(i, 99);
        C2538c.c(TAG, new Object[]{"getSnbResultCode  errorCd : " + i2});
        return i2;
    }

    public static int geteSEErrorCode(int i) {
        return sReadESECardResultCodeTable.get(i, 99);
    }

    public static int getFmErrorCode(int i) {
        return 0;
    }
}
