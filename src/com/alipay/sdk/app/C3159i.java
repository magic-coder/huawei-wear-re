package com.alipay.sdk.app;

import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.BaseResponse;

public enum C3159i {
    SUCCEEDED(TradeCode.SUCESS_4_PLATFORM, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(BaseResponse.RESULT_CODE_APPLY_APDU_INVALID_TRANSCATION, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    
    public int f10551h;
    public String f10552i;

    private C3159i(int i, String str) {
        this.f10551h = i;
        this.f10552i = str;
    }

    public static C3159i m13996a(int i) {
        switch (i) {
            case 4001:
                return PARAMS_ERROR;
            case 5000:
                return DOUBLE_REQUEST;
            case BaseResponse.RESULT_CODE_APPLY_APDU_INVALID_TRANSCATION /*6001*/:
                return CANCELED;
            case 6002:
                return NETWORK_ERROR;
            case 8000:
                return PAY_WAITTING;
            case TradeCode.SUCESS_4_PLATFORM /*9000*/:
                return SUCCEEDED;
            default:
                return FAILED;
        }
    }
}
