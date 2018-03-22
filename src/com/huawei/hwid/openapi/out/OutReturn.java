package com.huawei.hwid.openapi.out;

import android.os.Bundle;

public class OutReturn {

    public class ParamStr {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String Err_Info = "err_info";
        public static final String RET_CODE = "ret_code";
        public static final String RET_NSP_STATUS = "NSP_STATUS";
        public static final String RET_RES_CODE = "res_code";
        public static final String RET_RES_CONTENT = "res_content";
        public static final String RET_RES_HEAD = "res_head";
    }

    public class Ret_code {
        public static final int FAILED = -1;
        public static final int NETWORK_ERR = 102;
        public static final int PARM_ERR = 2000;
        public static final int SERVER_RSP_FAILED = 1000;
        public static final int SUCCESS = 1;
        public static final int SYSTEM_AUTH_FAILED = 101;
        public static final int SYSTEM_ERR = 100;
        public static final int USER_CANCEL = 2;
    }

    public static Bundle addFailCode(Bundle bundle, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(ParamStr.RET_CODE, i);
        return bundle;
    }

    public static Bundle addSuccessCode(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(ParamStr.RET_CODE, 1);
        return bundle;
    }

    public static Bundle creatParamErrRet(String str) {
        return creatReturn(2000, str);
    }

    public static Bundle creatReturn(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(ParamStr.RET_CODE, i);
        bundle.putString(ParamStr.Err_Info, str);
        return bundle;
    }

    public static Bundle creatRunTimeErrRet(String str) {
        return creatReturn(100, str);
    }

    public static final String getAccessToken(Bundle bundle) {
        return bundle == null ? "" : bundle.getString("access_token");
    }

    public static final String getErrInfo(Bundle bundle) {
        return bundle == null ? "" : bundle.getString(ParamStr.Err_Info);
    }

    public static final String getNSPSTATUS(Bundle bundle) {
        Bundle retHeads = getRetHeads(bundle);
        return (retHeads == null || !retHeads.containsKey(ParamStr.RET_NSP_STATUS)) ? "" : retHeads.getString(ParamStr.RET_NSP_STATUS);
    }

    public static final int getRetCode(Bundle bundle) {
        return bundle == null ? -1 : bundle.getInt(ParamStr.RET_CODE, -1);
    }

    public static final String getRetContent(Bundle bundle) {
        return bundle == null ? "" : bundle.getString(ParamStr.RET_RES_CONTENT);
    }

    public static final Bundle getRetHeads(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = bundle.getBundle(ParamStr.RET_RES_HEAD);
        return bundle2 == null ? new Bundle() : bundle2;
    }

    public static final int getRetResCode(Bundle bundle) {
        return bundle == null ? -1 : bundle.getInt(ParamStr.RET_RES_CODE);
    }

    public static boolean isRequestSuccess(Bundle bundle) {
        boolean z = true;
        if (bundle == null) {
            return false;
        }
        if (getRetCode(bundle) != 1) {
            z = false;
        }
        return z;
    }
}
