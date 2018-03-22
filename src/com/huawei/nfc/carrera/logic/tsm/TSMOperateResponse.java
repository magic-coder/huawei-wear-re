package com.huawei.nfc.carrera.logic.tsm;

public class TSMOperateResponse {
    public static final int RETURN_NETWORK_ERROR = 100010;
    public static final int RETURN_REQUESTPARAM_CONN_UNAVAILABLE = 100005;
    public static final int RETURN_REQUESTPARAM_CPLC_IS_NULL = 100002;
    public static final int RETURN_REQUESTPARAM_FUNCALLID_IS_NULL = 100004;
    public static final int RETURN_REQUESTPARAM_NO_NETWORK = 100006;
    public static final int RETURN_REQUESTPARAM_SERVICEID_IS_NULL = 100003;
    public static final int RETURN_REQUESTPARAM_ST_INVALID = 100007;
    public static final int RETURN_REQUEST_PARAMS_IS_NULL = 100001;
    public static final int RETURN_RESPONSE_PARSE_ERROR = 100012;
    public static final int RETURN_SERVER_ERROR = 100013;
    public static final int RETURN_UNKNOW_ERROR = 100011;
    public static final int TSM_OPERATE_RESULT_SUCCESS = 100000;
    private String msg = "Success";
    private int resultCode;

    public TSMOperateResponse(int i, String str) {
        this.resultCode = i;
        this.msg = str;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getPrintMsg() {
        return "resultCode : " + this.resultCode + " msg : " + this.msg;
    }
}
