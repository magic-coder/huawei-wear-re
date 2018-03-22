package com.huawei.crowdtestsdk.net;

import com.google.gson.Gson;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.crowdtestsdk.bases.UploadItem;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.constants.UrlConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpClient;
import com.huawei.crowdtestsdk.httpaccess.HttpResult;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.HashMap;
import java.util.Map;

public class UploadProgress {
    private static final int UPLOAD_THRESHOLD_0 = 0;
    private static final int UPLOAD_THRESHOLD_1 = 1;
    private static final int UPLOAD_THRESHOLD_100 = 100;
    private static final int UPLOAD_THRESHOLD_20 = 20;
    private static final int UPLOAD_THRESHOLD_5 = 5;
    private static final int UPLOAD_THRESHOLD_50 = 50;
    private static final int UPLOAD_THRESHOLD_70 = 70;
    private static UploadProgress instance = new UploadProgress();
    private Map<String, Integer> taskProgressMap = new HashMap();

    public static UploadProgress getInstance() {
        if (instance == null) {
            instance = new UploadProgress();
        }
        return instance;
    }

    public static boolean updateUploadProgress(UploadItem uploadItem) {
        String str = UrlConstants.updateUploadProgressUrlNew;
        String toJson = new Gson().toJson((Object) uploadItem);
        C2511g.m12481b(SdkConstants.TAG_HTTP, "[HttpCommonAccess.updateUploadProgress]uploadJson:" + toJson);
        HttpResult postDataWithRetry = HttpClient.getInstance().postDataWithRetry(str, toJson, null);
        if (postDataWithRetry != null && postDataWithRetry.isResponseOK() && "1".equals(postDataWithRetry.content)) {
            return true;
        }
        return false;
    }

    public void updateUploadProgress(String str, String str2, int i) {
        if (isNeedUpdateUploadProgress(str, i)) {
            String fileNameByPath = FileUtils.getFileNameByPath(str2);
            C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.updateUploadProgress]filePath -->" + str2);
            if (fileNameByPath == null) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.updateUploadProgress]fileName == null");
                return;
            }
            String fileSizeStr = FileUtils.getFileSizeStr(str2);
            String fileSizeStr2 = FileUtils.getFileSizeStr((FileUtils.getFileSize(str2) * ((long) i)) / 100);
            C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.updateUploadProgress]totalSize :" + fileSizeStr);
            C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.updateUploadProgress]currentSize :" + fileSizeStr2);
            HttpBetaAccess.getInstance().updateUploadProgress(str, fileNameByPath, String.valueOf(i), fileSizeStr, fileSizeStr2);
        }
    }

    public void updateUploadProgressNoAttachment(String str) {
        HttpBetaAccess.getInstance().updateUploadProgress(str, "无附件", "100", "0M", "0M");
    }

    private boolean isNeedUpdateUploadProgress(String str, int i) {
        if (this.taskProgressMap == null) {
            return false;
        }
        if (i == 0) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]UPLOAD_THRESHOLD_0");
            return true;
        } else if (i == 100) {
            C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]UPLOAD_THRESHOLD_100");
            return true;
        } else if (this.taskProgressMap.containsKey(str)) {
            int intValue = ((Integer) this.taskProgressMap.get(str)).intValue();
            C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]The current progress:" + i);
            C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]The last progress:" + intValue);
            this.taskProgressMap.put(str, Integer.valueOf(i));
            if (intValue < 1 && i >= 1) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]Report the progress:1%");
                return true;
            } else if (intValue < 5 && i >= 5) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]Report the progress:5%");
                return true;
            } else if (intValue < 20 && i >= 20) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]Report the progress:20%");
                return true;
            } else if (intValue < 50 && i >= 50) {
                C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]Report the progress:50%");
                return true;
            } else if (intValue >= 70 || i < 70) {
                return false;
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[UploadProgress.isNeedUpdateUploadProgress]Report the progress:70%");
                return true;
            }
        } else {
            this.taskProgressMap.put(str, Integer.valueOf(i));
            return true;
        }
    }
}
