package com.snowballtech.business.util;

import android.content.Context;
import com.snowballtech.business.bean.CplcCacheForWatch;
import com.snowballtech.business.bean.CplcCacheForWatchList;
import com.snowballtech.business.constant.CacheKey;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.PreferencesUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class WatchCacheUtils {
    private static WatchCacheUtils instance;
    private PreferencesUtil mPreferencesUtil = PreferencesUtil.getInstance();

    public static WatchCacheUtils getInstance() {
        if (instance == null) {
            instance = new WatchCacheUtils();
        }
        return instance;
    }

    public void saveCpLcCache(CplcCacheForWatch cplcCacheForWatch, Context context) {
        Object cacheForCplc = getCacheForCplc(context);
        if (cacheForCplc == null || cacheForCplc.getWatchCplcList() == null) {
            cacheForCplc = new CplcCacheForWatchList();
            cacheForCplc.setWatchCplcList(new ArrayList());
            cacheForCplc.getWatchCplcList().add(cplcCacheForWatch);
            LogUtil.log(Constant.LOG_FLAG_UPDATA_CACHE, "cache is null create new cache");
        } else if (!cacheForCplc.getWatchCplcList().contains(cplcCacheForWatch)) {
            LogUtil.log(Constant.LOG_FLAG_UPDATA_CACHE, "uid not find add new device_uid");
            cacheForCplc.getWatchCplcList().add(cplcCacheForWatch);
        } else {
            return;
        }
        this.mPreferencesUtil.keepEntity(CacheKey.KEY_CPLC_ID, cacheForCplc, context);
    }

    public CplcCacheForWatch getCplcCache(String str, Context context) {
        CplcCacheForWatchList cacheForCplc = getCacheForCplc(context);
        if (ValueUtil.isEmpty(str)) {
            LogUtil.loge(Constant.LOG_FLAG_UPDATA_CACHE, "uid is null ");
            return null;
        } else if (cacheForCplc == null || cacheForCplc.getWatchCplcList() == null) {
            LogUtil.log(Constant.LOG_FLAG_UPDATA_CACHE, "uid " + str + "not find in cache");
            return null;
        } else {
            CplcCacheForWatch cplcCacheForWatch;
            Iterator it = cacheForCplc.getWatchCplcList().iterator();
            while (it.hasNext()) {
                cplcCacheForWatch = (CplcCacheForWatch) it.next();
                if (cplcCacheForWatch.getDevice_uid().equals(str)) {
                    break;
                }
            }
            cplcCacheForWatch = null;
            return cplcCacheForWatch;
        }
    }

    private CplcCacheForWatchList getCacheForCplc(Context context) {
        return (CplcCacheForWatchList) this.mPreferencesUtil.getEntity(CacheKey.KEY_CPLC_ID, CplcCacheForWatchList.class, context);
    }

    public void removeCplcCache(String str, Context context) {
        CplcCacheForWatchList cacheForCplc = getCacheForCplc(context);
        if (ValueUtil.isEmpty(str)) {
            LogUtil.loge(Constant.LOG_FLAG_UPDATA_CACHE, "uid is null ");
        } else if (cacheForCplc == null || cacheForCplc.getWatchCplcList() == null) {
            LogUtil.log(Constant.LOG_FLAG_UPDATA_CACHE, "uid " + str + "not find in cache");
        } else {
            CplcCacheForWatch cplcCacheForWatch;
            Object obj;
            Iterator it = cacheForCplc.getWatchCplcList().iterator();
            while (it.hasNext()) {
                cplcCacheForWatch = (CplcCacheForWatch) it.next();
                LogUtil.log(Constant.LOG_FLAG_UPDATA_CACHE, "before record, uid:" + cplcCacheForWatch.getDevice_uid() + " and cplc:" + cplcCacheForWatch.getCplc());
            }
            Iterator it2 = cacheForCplc.getWatchCplcList().iterator();
            while (it2.hasNext()) {
                obj = (CplcCacheForWatch) it2.next();
                if (obj.getDevice_uid().equals(str)) {
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                cacheForCplc.getWatchCplcList().remove(obj);
            }
            it = cacheForCplc.getWatchCplcList().iterator();
            while (it.hasNext()) {
                cplcCacheForWatch = (CplcCacheForWatch) it.next();
                LogUtil.log(Constant.LOG_FLAG_UPDATA_CACHE, "after record, uid:" + cplcCacheForWatch.getDevice_uid() + " and cplc:" + cplcCacheForWatch.getCplc());
            }
        }
    }
}
