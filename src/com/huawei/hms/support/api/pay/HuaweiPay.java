package com.huawei.hms.support.api.pay;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;

public class HuaweiPay {
    public static final HuaweiPayApi HuaweiPayApi = new HuaweiPayApiImpl();
    public static final Api<NoOptions> PAY_API = new Api("HuaweiPay.API");
}
