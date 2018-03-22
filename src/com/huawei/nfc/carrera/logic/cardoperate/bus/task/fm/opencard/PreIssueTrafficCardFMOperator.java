package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.opencard;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.CreateSSDTsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

public class PreIssueTrafficCardFMOperator {
    private static final String TAG = "PreIssueTrafficCardSNBOperator";
    private Context mContext;
    private IssuerInfoItem mInfos;

    public PreIssueTrafficCardFMOperator(Context context, IssuerInfoItem issuerInfoItem) {
        this.mContext = context;
        this.mInfos = issuerInfoItem;
    }

    public void preIssueTrafficCard() {
        LogX.i("tsm preIssueTrafficCard begin");
        if (this.mInfos == null) {
            LogX.w("tsm PreIssueTrafficCardSNBTask installSSD failed, can not find issuer info.");
            return;
        }
        String aid = this.mInfos.getAid();
        if (StringUtil.isEmpty(aid, true)) {
            LogX.w("tsm PreIssueTrafficCardSNBTask installSSD failed, aid or productId is illegal. aid = " + aid);
            return;
        }
        CreateSSDTsmOperator createSSDTsmOperator = new CreateSSDTsmOperator(this.mContext, aid, this.mInfos.getIssuerId());
        C2538c.b(TAG, new Object[]{" CardEvent CREATESSD bus cardEvent START_LOCK"});
        WalletTaManager.getInstance(this.mContext).lockCardEvent(aid);
        int excute = createSSDTsmOperator.excute();
        C2538c.b(TAG, new Object[]{" CardEvent CREATESSD bus cardEvent END_LOCK"});
        WalletTaManager.getInstance(this.mContext).unLockCardEvent(aid);
        LogX.i("IssueTrafficCardFMOperator createDMSD result=" + excute);
        if (excute != 0) {
            String str = "tsm PreIssueTrafficCardSNBTask installSSD, create ssd failed response = " + excute;
            Map hashMap = new HashMap();
            hashMap.put("aid", aid);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excute));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_DMSD_INSTALL_FAIL, hashMap, str, false, false);
            return;
        }
        LogX.i("create SSD  successfully");
    }
}
