package com.snowballtech.business.util;

import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.user.task.IWalletServiceTask;
import com.snowballtech.business.user.task.TaskParam;
import com.snowballtech.business.user.task.WTaskCardQuery;
import com.snowballtech.business.user.task.WTaskConsumeParse;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class PluginUtils {
    private static volatile PluginUtils singleton;
    private final String TAG = "CommonUtils";

    public static PluginUtils getInstance() {
        if (singleton == null) {
            synchronized (PluginUtils.class) {
                if (singleton == null) {
                    singleton = new PluginUtils();
                }
            }
        }
        return singleton;
    }

    public int validateParam(TaskParam taskParam, IWalletServiceTask iWalletServiceTask) throws SnowballException {
        if (ValueUtil.isEmpty(taskParam.getInputParam())) {
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_SP_ID_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_SP_ID_NULL);
        }
        WSProviderBean wSProviderBean = (WSProviderBean) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), WSProviderBean.class);
        if (wSProviderBean == null) {
            LogUtil.loge("CommonUtils", "validateParam  wsProviderBean is null");
        } else if (iWalletServiceTask instanceof WTaskCardQuery) {
            if (ValueUtil.isEmpty(wSProviderBean.getInstance_id())) {
                throw new SnowballException(" cardQuery instance_id参数为空", (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
            }
        } else if (!(iWalletServiceTask instanceof WTaskConsumeParse)) {
            LogUtil.loge("CommonUtils", "validateParam  do NOT need check param for this API");
        } else if (ValueUtil.isEmpty(wSProviderBean.getInstance_id())) {
            throw new SnowballException(" consumeParse instance_id参数为空", (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
        } else if (ValueUtil.isEmpty(wSProviderBean.getData())) {
            throw new SnowballException(" consumeParse data参数为空", (int) CodeMessage.BUSINESS_PARAM_DATA_NULL);
        }
        return 0;
    }
}
