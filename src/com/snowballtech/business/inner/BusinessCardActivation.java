package com.snowballtech.business.inner;

import android.content.Context;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.ApduUtil;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ValueUtil;

public class BusinessCardActivation extends BusinessCommon {
    private String TAG = Constant.LOG_FLAG_CARD_QUERY;
    private CommonUtils commonUtils = CommonUtils.getInstance();

    public BusinessCardActivation(int i) {
        super(i);
    }

    public String fetchActivation(Context context, String str) throws SnowballException {
        String str2;
        LogUtil.log(this.TAG, " CardInfo_cardQuery fetchActivation begin " + str);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.commonUtils.isCardBank(str)) {
            str2 = ApduUtil.getInstance().retriveCardStatus(context, str, getMediaType()) + "";
        } else {
            String[] retriveCardStatusForProxy = ApduUtil.getInstance().retriveCardStatusForProxy(context, getMediaType());
            if (retriveCardStatusForProxy.length > 0) {
                for (String str3 : retriveCardStatusForProxy) {
                    LogUtil.log(this.TAG, "proxyApp is " + str3);
                }
            }
            if (retriveCardStatusForProxy == null || retriveCardStatusForProxy.length <= 1 || ValueUtil.isEmpty(retriveCardStatusForProxy[1]) || str.equals(SeConstants.MIFARE_VCM_INSTANCE_ID)) {
                LogUtil.log(this.TAG, "start to retriveCardStatus ");
                str2 = ApduUtil.getInstance().retriveCardStatus(context, str, getMediaType()) + "";
            } else if (retriveCardStatusForProxy[1].equalsIgnoreCase(str)) {
                if ((ApduUtil.getInstance().retriveCardStatus(context, SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS, getMediaType()) + "").equals("1")) {
                    str2 = retriveCardStatusForProxy[0];
                } else {
                    str2 = "0";
                }
            } else if (retriveCardStatusForProxy == null || retriveCardStatusForProxy.length <= 1 || !retriveCardStatusForProxy[1].equals("noActiveCard")) {
                str2 = "0";
            } else {
                str2 = ApduUtil.getInstance().retriveCardStatus(context, str, getMediaType()) + "";
            }
        }
        LogUtil.log(this.TAG, " CardInfo_cardQuery fetchActivation end " + str + ",activation_status:" + str2 + "," + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return str2;
    }
}
