package com.snowballtech.business.inner;

import android.content.Context;
import com.snowballtech.business.bean.CardBaseSe;
import com.snowballtech.business.bean.Tlv;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.TlvDecodeUtil;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.DateTimeUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.ArrayList;
import java.util.List;

public class BusinessCommon {
    private String TAG = Constant.LOG_FLAG_CARD_QUERY;
    private int mediaType;

    public BusinessCommon(int i) {
        this.mediaType = i;
    }

    public int fetchInstallStatus(Context context, String str) throws SnowballException {
        int parseInt;
        LogUtil.log(this.TAG, " CardInfo_cardQuery fetchInstallStatus begin, instanceId=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        List<CardBaseSe> synchronizedCardsStatusFromServer = new BusinessCardsStatus(this.mediaType).synchronizedCardsStatusFromServer(context, false);
        if (synchronizedCardsStatusFromServer != null && synchronizedCardsStatusFromServer.size() > 0) {
            for (CardBaseSe cardBaseSe : synchronizedCardsStatusFromServer) {
                if (str.equals(cardBaseSe.getInstance_id())) {
                    LogUtil.log(this.TAG, " CardInfo_cardQuery find the cardBaseSe ");
                    parseInt = ValueUtil.parseInt(cardBaseSe.getInstall_status());
                    break;
                }
            }
        }
        parseInt = 0;
        LogUtil.log(this.TAG, " CardInfo_cardQuery fetchInstallStatus install_status:" + parseInt + ",instanceId=" + str + ",costtime=" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return parseInt;
    }

    public Tlv fetchTlvFirst(String str, String str2) {
        if (!(ValueUtil.isEmpty(str) || ValueUtil.isEmpty(str2))) {
            List<Tlv> buildTlvsForFull = new TlvDecodeUtil().buildTlvsForFull(str2);
            if (buildTlvsForFull != null && buildTlvsForFull.size() > 0) {
                for (Tlv tlv : buildTlvsForFull) {
                    if (tlv.getTag().equals(str)) {
                        return tlv;
                    }
                }
            }
        }
        return null;
    }

    public List<Tlv> fetchTlvs(String str, String str2) {
        List<Tlv> arrayList = new ArrayList();
        if (!(ValueUtil.isEmpty(str) || ValueUtil.isEmpty(str2))) {
            List<Tlv> buildTlvsForFull = new TlvDecodeUtil().buildTlvsForFull(str2);
            if (buildTlvsForFull != null && buildTlvsForFull.size() > 0) {
                for (Tlv tlv : buildTlvsForFull) {
                    if (tlv.getTag().equals(str)) {
                        arrayList.add(tlv);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<Tlv> fetchTlvsExclude(String str, String... strArr) {
        List<Tlv> arrayList = new ArrayList();
        if (!ValueUtil.isEmpty(str)) {
            List<Tlv> buildTlvsForFull = new TlvDecodeUtil().buildTlvsForFull(str);
            if (strArr != null && strArr.length > 0 && buildTlvsForFull != null && buildTlvsForFull.size() > 0) {
                for (Tlv tlv : buildTlvsForFull) {
                    for (Object equals : strArr) {
                        if (tlv.getTag().equals(equals)) {
                            break;
                        }
                        arrayList.add(tlv);
                    }
                }
            } else {
                return buildTlvsForFull;
            }
        }
        return arrayList;
    }

    public String formatDatetimeForTransaction(String str) {
        if (ValueUtil.isEmpty(str)) {
            return null;
        }
        String currentDateString = DateTimeUtil.currentDateString("yyyy");
        if (str.length() == 10) {
            str = currentDateString + str;
        } else if (str.length() <= 12) {
            str = currentDateString.substring(0, 2) + str;
        }
        return DateTimeUtil.format(DateTimeUtil.parseDateString(str, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss");
    }

    public String formatDateForTransaction(String str) {
        if (ValueUtil.isEmpty(str)) {
            return null;
        }
        String currentDateString = DateTimeUtil.currentDateString("yyyy");
        if (str.length() <= 12) {
            str = currentDateString.substring(0, 2) + str;
        }
        return DateTimeUtil.format(DateTimeUtil.parseDateString(str, "yyyyMMdd"), "yyyy-MM-dd");
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }
}
