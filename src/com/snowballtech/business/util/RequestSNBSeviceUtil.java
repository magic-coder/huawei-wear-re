package com.snowballtech.business.util;

import android.content.Context;
import com.snowballtech.business.bean.Spid;
import com.snowballtech.business.config.BusinessConfigs;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.code.WSBaseMessageCode;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;
import com.snowballtech.data.interaction.RequesterParam;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RequestSNBSeviceUtil {
    private Context mContext;
    private RequesterParam<String> mRequesterParam;
    private String sp_id = "";

    public RequestSNBSeviceUtil(Context context) {
        this.mContext = context;
    }

    public <T> TaskResult<T> postService(String str, String str2, Class<T> cls) throws SnowballException {
        buildRequestParam(null, str, str2, null);
        return ConfigUtil.getInstance().instanceRequester().requestData(this.mRequesterParam, cls);
    }

    public <T> TaskResult<T> postService(Map<String, String> map, String str, String str2, Class<T> cls) throws SnowballException {
        buildRequestParam(map, str, str2, null);
        return ConfigUtil.getInstance().instanceRequester().requestData(this.mRequesterParam, cls);
    }

    public TaskResult<InputStream> postService(String str, String str2, String str3) throws SnowballException {
        buildRequestParam(null, str, str2, str3);
        return ConfigUtil.getInstance().instanceRequester().requestData(this.mRequesterParam);
    }

    private void buildRequestParam(Map<String, String> map, String str, String str2, String str3) throws SnowballException {
        int i;
        int i2;
        if (this.mRequesterParam == null) {
            this.mRequesterParam = new RequesterParam();
        }
        this.mRequesterParam.setContext(this.mContext);
        this.mRequesterParam.setRequestType(3);
        this.mRequesterParam.setParam(null);
        this.mRequesterParam.setRequestMethod(1);
        if (ValueUtil.isEmpty(str)) {
            i = 0;
            i2 = 0;
        } else if (str.equals("downPost")) {
            Map hashMap = new HashMap();
            hashMap.put("requestParam", "2");
            this.mRequesterParam.setRequestType(2);
            this.mRequesterParam.setParam(hashMap);
            this.mRequesterParam.setServerUrl(BusinessConfigs.fetchDynamicDexUrl());
            i = 1;
            i2 = 0;
        } else if (!str.equals("down")) {
            this.mRequesterParam.setServerUrl(BusinessConfigs.fetchServer());
            i = 0;
            i2 = 1;
        } else if (ValueUtil.isEmpty(str3)) {
            this.mRequesterParam.setServerUrl("");
            LogUtil.loge("snowballtech_", "buildRequestParam() should never come here, and operation is " + str);
            i = 0;
            i2 = 0;
        } else {
            this.mRequesterParam.setServerUrl(str3);
            this.mRequesterParam.setRequestMethod(0);
            i = 0;
            i2 = 0;
        }
        if (map == null) {
            map = CommonUtils.getInstance().getProviderRequestHeader(this.mContext, 0);
        }
        if (!ValueUtil.isEmpty(str2)) {
            Spid spid = (Spid) JsonUtil.getInstance().deSerializeString(str2, Spid.class);
            if (!(spid == null || spid.getSp_id() == null)) {
                this.sp_id = spid.getSp_id();
                map.put(WSBaseMessageCode.HEADER_SNBPS_SPID, this.sp_id);
            }
        }
        if (i2 == 1) {
            map.put(WSBaseMessageCode.HEADER_SNBPS_OPERATION, str);
        }
        if (i != 0) {
            this.mRequesterParam.setHeaderParam(null);
        } else {
            this.mRequesterParam.setHeaderParam(map);
        }
        if (ValueUtil.isEmpty(str2)) {
            this.mRequesterParam.setRequestObj(null);
        } else {
            this.mRequesterParam.setRequestObj(str2);
        }
        LogUtil.log("snowballtech_", "url is" + this.mRequesterParam.getServerUrl());
    }

    public String getSp_id() {
        return this.sp_id;
    }

    public void setSp_id(String str) {
        this.sp_id = str;
    }
}
