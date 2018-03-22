package com.huawei.cloudservice.opensdk;

import android.os.Bundle;
import com.huawei.hwid.openapi.out.OutReturn.ParamStr;

public class OutReturn {
    public static final int getRetCode(Bundle bundle) {
        if (bundle == null) {
            return -1;
        }
        return bundle.getInt(ParamStr.RET_CODE, -1);
    }

    public static final String getErrInfo(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        return bundle.getString(ParamStr.Err_Info);
    }

    public static final int getRetResCode(Bundle bundle) {
        if (bundle == null) {
            return -1;
        }
        return bundle.getInt(ParamStr.RET_RES_CODE);
    }

    public static final String getRetContent(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        return bundle.getString(ParamStr.RET_RES_CONTENT);
    }

    public static final Bundle getRetHeads(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = bundle.getBundle(ParamStr.RET_RES_HEAD);
        if (bundle2 == null) {
            return new Bundle();
        }
        return bundle2;
    }

    public static final String getNSPSTATUS(Bundle bundle) {
        Bundle retHeads = getRetHeads(bundle);
        if (retHeads.containsKey(ParamStr.RET_NSP_STATUS)) {
            return retHeads.getString(ParamStr.RET_NSP_STATUS);
        }
        return "";
    }

    public static final String getAccessToken(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        return bundle.getString("access_token");
    }

    public static boolean isRequestSuccess(Bundle bundle) {
        boolean z = true;
        if (bundle == null) {
            return false;
        }
        if (1 != getRetCode(bundle)) {
            z = false;
        }
        return z;
    }

    public static Bundle creatReturn(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(ParamStr.RET_CODE, i);
        bundle.putString(ParamStr.Err_Info, str);
        return bundle;
    }

    public static Bundle creatParamErrRet(String str) {
        return creatReturn(2000, str);
    }

    public static Bundle creatRunTimeErrRet(String str) {
        return creatReturn(100, str);
    }

    public static Bundle addSuccessCode(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(ParamStr.RET_CODE, 1);
        return bundle;
    }

    public static Bundle addFailCode(Bundle bundle, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(ParamStr.RET_CODE, i);
        return bundle;
    }
}
