package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class LoadAndInstallApplet extends BaseOperatorA {
    private Map<String, String> errorMsgs = new HashMap();
    protected SNBProviderHelper mSnbProviderHelper;

    public LoadAndInstallApplet(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public int loadAndInstallApplet(String str, Map<String, String> map) {
        String makeExtraInfo = makeExtraInfo(map);
        this.errorMsgs.put("extra_param", makeExtraInfo);
        this.errorMsgs.put("aid", str);
        makeExtraInfo = this.mSnbProviderHelper.appletManage(str, makeExtraInfo);
        LogX.i("SNBServiceImpl loadAndInstallApplet respStr = " + makeExtraInfo);
        return analyzeResult(makeExtraInfo);
    }

    protected void reportEmptyErrorMsg() {
        String str = "SNBServiceImpl loadAndInstallApplet failed. response is empty.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_LOAD_AND_INSTALL_APPLET_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportFailErrorMsg(int i, String str) {
        String str2 = "SNBServiceImpl loadAndInstallApplet failed. returnCd : " + i + " msg : " + str;
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_LOAD_AND_INSTALL_APPLET_FAIL, this.errorMsgs, str2, false, false);
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        String str = "SNBServiceImpl loadAndInstallApplet failed, JSONException.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        this.errorMsgs.put("fail_stack", Log.getStackTraceString(jSONException));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_LOAD_AND_INSTALL_APPLET_FAIL, this.errorMsgs, str + Log.getStackTraceString(jSONException), false, false);
    }
}
