package com.snowballtech.business.util;

import android.content.Context;
import com.snowballtech.business.bean.ResponseCardsStatus;
import com.snowballtech.business.constant.CacheKey;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.common.code.WSBaseMessageCode;
import com.snowballtech.common.env.IEnv;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.PreferencesUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.Map;

public class CardStatuCacheUtils {
    private static CardStatuCacheUtils instance;
    private PreferencesUtil mPreferencesUtil = PreferencesUtil.getInstance();

    public static CardStatuCacheUtils getInstance() {
        if (instance == null) {
            synchronized (CardStatuCacheUtils.class) {
                instance = new CardStatuCacheUtils();
            }
        }
        return instance;
    }

    public void saveCache(ResponseCardsStatus responseCardsStatus, Context context) {
        if (responseCardsStatus == null || ValueUtil.isEmpty(responseCardsStatus.getDevice_uid())) {
            LogUtil.loge(Constant.LOG_FLAG_UPDATA_CACHE, "can't find the device_id");
        } else {
            this.mPreferencesUtil.keepEntity(CacheKey.WS_SDK_CARDS_STATUS_WSPROVIDER_KEY + responseCardsStatus.getDevice_uid(), responseCardsStatus, context);
        }
    }

    public ResponseCardsStatus getCardCache(String str, Context context) {
        return (ResponseCardsStatus) this.mPreferencesUtil.getEntity(CacheKey.WS_SDK_CARDS_STATUS_WSPROVIDER_KEY + str, ResponseCardsStatus.class, context);
    }

    public String getCardCacheByString(Context context) throws SnowballException {
        IEnv instanceEnv = ConfigUtil.getInstance().instanceEnv();
        if (instanceEnv == null) {
            return this.mPreferencesUtil.getField(CacheKey.WS_SDK_CARDS_STATUS_WSPROVIDER_KEY, context);
        }
        Map fetchEnv = instanceEnv.fetchEnv();
        if (fetchEnv == null || fetchEnv.size() <= 0 || ValueUtil.isEmpty((String) fetchEnv.get(WSBaseMessageCode.HEADER_SNBPS_IMEI))) {
            return "";
        }
        return this.mPreferencesUtil.getField(CacheKey.WS_SDK_CARDS_STATUS_WSPROVIDER_KEY + ((String) fetchEnv.get(WSBaseMessageCode.HEADER_SNBPS_IMEI)), context);
    }
}
