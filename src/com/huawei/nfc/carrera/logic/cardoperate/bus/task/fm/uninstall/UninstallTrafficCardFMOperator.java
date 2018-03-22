package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.uninstall;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.UninstallTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteSSDTsmOperator;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.SynESETsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public class UninstallTrafficCardFMOperator {
    private Context mContext;
    private IssuerInfoItem mInfo;
    private UninstallTrafficCardResultHandler mResultHandler;

    public UninstallTrafficCardFMOperator(Context context, IssuerInfoItem issuerInfoItem, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = uninstallTrafficCardResultHandler;
    }

    public void uninstall() {
        String aid = this.mInfo.getAid();
        if (StringUtil.isEmpty(aid, true)) {
            LogX.w("UninstallTrafficCardFMOperator uninstall failed. aid is illegal.");
            this.mResultHandler.handleResult(10);
            return;
        }
        int excute = new SynESETsmOperator(this.mContext, aid, this.mInfo.getIssuerId()).excute();
        LogX.i("synESETsmOperator resultCode :" + excute);
        if (excute != 0) {
            this.mResultHandler.handleResult(handleTsmOperatorReturnCode(excute));
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "SynESETsmOperator ERROR");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "" + excute);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_DELETE_FAIL, hashMap, "SynESETsmOperator return resultCode : " + excute, false, false);
            return;
        }
        excute = new DeleteSSDTsmOperator(this.mContext, aid, this.mInfo.getIssuerId(), true).excute();
        LogX.i("DeleteSSDTsmOperator result is :" + excute);
        if (excute != 0) {
            this.mResultHandler.handleResult(handleTsmOperatorReturnCode(excute));
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "DeleteSSDTsmOperator ERROR");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "" + excute);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_DELETE_FAIL, hashMap, "DeleteSSDTsmOperator return excuteResultCode : " + excute, false, false);
        } else if (updateTaAndReport(aid)) {
            this.mResultHandler.handleResult(0);
        }
    }

    private int handleTsmOperatorReturnCode(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -1) {
            return 11;
        }
        if (i == -2) {
            return 25;
        }
        return 99;
    }

    private boolean updateTaAndReport(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).removeCardByAid(str);
            CardInfoManager.getInstance(this.mContext).refreshCardList();
            CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(str, null, true);
            return true;
        } catch (Throwable e) {
            LogX.w("UninstallTrafficCardTask updateTaAndReport WalletTaCardNotExistException, ta removeCard failed", e);
            return false;
        } catch (Throwable e2) {
            LogX.w("UninstallTrafficCardTask updateTaAndReport WalletTaSystemErrorException, ta removeCard failed", e2);
            return false;
        }
    }
}
