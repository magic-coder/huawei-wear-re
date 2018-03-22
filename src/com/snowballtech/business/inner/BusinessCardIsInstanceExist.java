package com.snowballtech.business.inner;

import android.content.Context;
import com.snowballtech.business.bean.CardBaseSe;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.List;

public class BusinessCardIsInstanceExist extends BusinessCommon {
    private String TAG = Constant.LOG_FLAG_IS_INSTANCE_EXISTED;

    public BusinessCardIsInstanceExist(int i) {
        super(i);
    }

    public int isInstanceExist(Context context, String str, boolean z) throws SnowballException {
        if (ValueUtil.isEmpty(str)) {
            LogUtil.loge(this.TAG, " fetchInstallStatusFromServer failure,instance_id is null ");
        } else {
            List<CardBaseSe> synchronizedCardsStatusFromServer = new BusinessCardsStatus(getMediaType()).synchronizedCardsStatusFromServer(context, z);
            if (synchronizedCardsStatusFromServer == null || synchronizedCardsStatusFromServer.size() <= 0) {
                LogUtil.loge(this.TAG, " fetchInstallStatusFromServer no data ");
            } else {
                for (CardBaseSe cardBaseSe : synchronizedCardsStatusFromServer) {
                    if (cardBaseSe.getInstance_id().equals(str)) {
                        return ValueUtil.parseInt(cardBaseSe.getInstall_status());
                    }
                }
            }
        }
        return 0;
    }
}
