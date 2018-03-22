package com.huawei.crowdtestsdk.net;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.bases.AuthRequestItem;
import com.huawei.crowdtestsdk.bases.AuthResponseItem;
import com.huawei.crowdtestsdk.bases.ProjectItem;
import com.huawei.crowdtestsdk.bases.ReportRequestItem;
import com.huawei.crowdtestsdk.bases.ReportResponseItem;
import com.huawei.crowdtestsdk.bases.TbdtsStatus;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.FeedbackProjectConstants;
import com.huawei.crowdtestsdk.constants.HttpCommonAPi;
import com.huawei.crowdtestsdk.constants.TbdtsConstants;
import com.huawei.crowdtestsdk.constants.UrlConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpClient;
import com.huawei.crowdtestsdk.httpaccess.HttpResult;
import com.huawei.crowdtestsdk.httpaccess.HttpUtils;
import com.huawei.crowdtestsdk.report.GroupMemberItem;
import com.huawei.crowdtestsdk.report.ImeiItem;
import com.huawei.crowdtestsdk.report.ProductVersionItem;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import com.huawei.uploadlog.p188c.C2516l;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpBetaAccess extends HttpCommonAccess {
    private static HttpBetaAccess mInstance;
    public long lastupdatetime;
    private Context mContext;
    public Map<String, String> projectTotalIssueFromWebCountMap = new HashMap();

    class C07901 implements Runnable {
        C07901() {
        }

        public void run() {
            HttpBetaAccess.getInstance().updateBetaUserAgreement(false);
        }
    }

    public HttpBetaAccess(Context context) {
        super(context);
        this.mContext = context;
    }

    public static HttpBetaAccess getInstance() {
        if (mInstance == null) {
            mInstance = new HttpBetaAccess(AppContext.getInstance().getApplicationContext());
        }
        return mInstance;
    }

    public List<ProjectItem> getProjectListByProdTypeFromWeb(int i) {
        int i2 = 0;
        List<ProjectItem> arrayList = new ArrayList();
        String currentUserId = TbdtsConstants.getInstance().getCurrentUserId();
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.findProjectListByProTypeUrl, new Object[]{currentUserId, Integer.valueOf(i)}));
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getProjectListByProdTypeFromWeb]url:" + UrlConstants.urlPre + String.format(UrlConstants.findProjectListByProTypeUrl, new Object[]{currentUserId, Integer.valueOf(i)}));
        if (dataWithRetry != null) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getProjectListByProTypeFromWeb]ret : " + dataWithRetry);
            if (!dataWithRetry.isResponseOK()) {
                return null;
            }
            currentUserId = dataWithRetry.content;
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getProjectListByProTypeFromWeb].ret.content : " + currentUserId);
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess].ret.content : " + currentUserId);
            try {
                JSONArray jSONArray = new JSONArray(currentUserId);
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    C2511g.m12481b("BETACLUB_SDK", "getProjectListByProTypeFromWeb.item is " + jSONObject.toString());
                    ProjectItem projectItem = new ProjectItem();
                    projectItem.setProjectId(jSONObject.getString("projectId"));
                    projectItem.setGroupId(jSONObject.getString("groupId"));
                    projectItem.setProductType(String.valueOf(getIntegerValueByString(jSONObject.getString("prodType"))));
                    projectItem.setProjectName(jSONObject.getString("projectName"));
                    projectItem.setVersionList(jSONObject.getString("prodbName"));
                    arrayList.add(projectItem);
                    i2++;
                }
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "getProjectListFromWeb Error!", e);
                return null;
            }
        }
        return arrayList;
    }

    public int reLogin() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lastupdatetime != 0 && this.lastupdatetime - currentTimeMillis < 900000) {
            return 999;
        }
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.reLogin]Check reLogin");
        String str = Constant.DEFAULT_CVN2;
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.findBetaUserIdUrl, new Object[]{str}));
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.reLogin]ret :" + dataWithRetry);
        if (dataWithRetry.isForbit()) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.reLogin]ret isForbit");
        } else if (dataWithRetry.isInternalError()) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.reLogin]ret isInternalError");
            return -98;
        } else if (dataWithRetry.isRedirect()) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.reLogin]ret isLoginFail");
            return -100;
        }
        this.lastupdatetime = currentTimeMillis;
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.reLogin] end!!!");
        return 999;
    }

    public List<ProjectItem> getMyProjectListFromWeb(int i) {
        List<ProjectItem> projectListByProdTypeFromWeb = getProjectListByProdTypeFromWeb(i);
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getMyProjectListFromWeb]myProjectList is null:" + (projectListByProdTypeFromWeb == null));
        writeProjectListToLocal(projectListByProdTypeFromWeb, "product_type = " + i);
        return projectListByProdTypeFromWeb;
    }

    public void writeProjectListToLocal(List<ProjectItem> list, String str) {
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.writeProjectListToLocal]start...");
        if (list == null || list.isEmpty()) {
            C2511g.m12483c("BETACLUB_SDK", "[HttpBetaAccess.writeProjectListToLocal]projectItemList is null or empty!");
            return;
        }
        Uri uri = FeedbackProjectConstants.CONTENT_URI_PROJECT;
        this.mContext.getContentResolver().delete(uri, str, null);
        C2511g.m12481b("BETACLUB_SDK", "writeProjectListToLocal delete project datas");
        for (ProjectItem projectItem : list) {
            if (!"other".equalsIgnoreCase(projectItem.getProjectId())) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("project_id", projectItem.getProjectId());
                contentValues.put(FeedbackProjectConstants.COLUMN_NAME_PROJECT_NAME, projectItem.getProjectName());
                contentValues.put(FeedbackProjectConstants.COLUMN_NAME_PRODUCT_TYPE, projectItem.getProductType());
                contentValues.put(FeedbackProjectConstants.COLUMN_NAME_VERSION_LIST, projectItem.getVersionList());
                contentValues.put(FeedbackProjectConstants.COLUMN_NAME_GROUP_ID, projectItem.getGroupId());
                this.mContext.getContentResolver().insert(uri, contentValues);
            }
        }
    }

    public List<ProjectItem> getAllProjectListFromWeb() {
        List<ProjectItem> arrayList = new ArrayList();
        int d = C2514j.m12526d();
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getAllProjectListFromWeb]proType:" + d);
        if (d == 0) {
            return null;
        }
        Collection projectListByProdTypeFromWeb = getProjectListByProdTypeFromWeb(d);
        if (projectListByProdTypeFromWeb == null) {
            return null;
        }
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getAllProjectListFromWeb]eachList:" + projectListByProdTypeFromWeb.toString());
        arrayList.addAll(projectListByProdTypeFromWeb);
        writeProjectListToLocal(arrayList, null);
        for (ProjectItem projectItem : arrayList) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getAllProjectListFromWeb]" + projectItem.toString());
        }
        return arrayList;
    }

    public TbdtsStatus submitTbdtsIssue(String str) {
        try {
            String str2 = UrlConstants.urlPre + UrlConstants.apkCreateQuestionUrl;
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.submitTbdtsIssue]url : " + str2);
            Object postDataWithRetry = HttpClient.getInstance().postDataWithRetry(str2, str, null);
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.submitTbdtsIssue]ret:" + new Gson().toJson(postDataWithRetry));
            if (!isResultCorrect(postDataWithRetry)) {
                return null;
            }
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.submitTbdtsIssue]Create question:" + postDataWithRetry.content);
            return (TbdtsStatus) new Gson().fromJson(postDataWithRetry.content, TbdtsStatus.class);
        } catch (Throwable e) {
            C2511g.m12479a("BETACLUB_SDK", "[HttpBetaAccess.submitTbdtsIssue]Exception:", e);
            return null;
        }
    }

    public boolean isResultCorrect(HttpResult httpResult) {
        if (httpResult == null || StringUtils.isNullOrEmpty(httpResult.content) || !httpResult.isResponseOK()) {
            return false;
        }
        return true;
    }

    public void updateUploadProgress(String str, String str2, String str3, String str4, String str5) {
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]is running!");
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]tbdtsQuesNo-->" + str);
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]fileName-->" + str2);
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]uploadStatus-->" + str3);
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]totalSize-->" + str4);
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]currentSize-->" + str5);
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty() && str3 != null && !str3.isEmpty()) {
                    HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.updateUploadProgressUrl, new Object[]{str, str2, str3, str4, str5}));
                    if (dataWithRetry == null || !dataWithRetry.isResponseOK()) {
                        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]ret is null!");
                    } else {
                        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]ret.isResponseOK()");
                    }
                }
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "[HttpBetaAccess.updateUploadProgress]Exception:", e);
            }
        }
    }

    public boolean updateUserReportItem(ReportResponseItem reportResponseItem) {
        String str = null;
        if (StringUtils.isUnknownOrEmpty(reportResponseItem.getImeiNo()) || StringUtils.isNullOrEmpty(reportResponseItem.getReportValue())) {
            return false;
        }
        try {
            String str2 = UrlConstants.urlPre + UrlConstants.updateUserReportItem;
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUserReportItem]itemString is " + new Gson().toJson((Object) reportResponseItem));
            HttpResult postDataWithRetry = HttpClient.getInstance().postDataWithRetry(str2, new Gson().toJson((Object) reportResponseItem), null);
            if (postDataWithRetry == null || !postDataWithRetry.isResponseOK()) {
                return false;
            }
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUserReportItem]responseis OK!ret.content:" + postDataWithRetry.content);
            String str3 = null;
            for (String str22 : Arrays.asList(postDataWithRetry.toString().split(","))) {
                if (str22.contains("status")) {
                    String str4 = str;
                    str = str22.substring(str22.lastIndexOf(":") + 1);
                    str22 = str4;
                } else if (str22.contains("description")) {
                    str22 = str22.substring(str22.lastIndexOf(":") + 1);
                    str = str3;
                } else {
                    str22 = str;
                    str = str3;
                }
                str3 = str;
                str = str22;
            }
            if (StringUtils.isNullOrEmpty(str3) || StringUtils.isUnknownOrEmpty(str)) {
                return false;
            }
            if (!Integer.valueOf(str3).equals(Integer.valueOf(-1))) {
                return true;
            }
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateUserReportItem]is fail!description:" + str);
            return false;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpBetaAccess.updateUserReportItem] error!", e);
            return false;
        }
    }

    public boolean updateGroupMemberInfoByUser(GroupMemberItem groupMemberItem) {
        try {
            String str = UrlConstants.urlPre + UrlConstants.updateGroupMemberInfoByUser;
            String toJson = new Gson().toJson((Object) groupMemberItem);
            HttpResult postDataWithRetryWithHwAccount = HttpClient.getInstance().postDataWithRetryWithHwAccount(str, toJson, null);
            C2511g.m12481b("BETACLUB_SDK", "updateGroupMemberInfoByUser json is " + toJson);
            if (postDataWithRetryWithHwAccount != null && postDataWithRetryWithHwAccount.isResponseOK()) {
                return true;
            }
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpBetaAccess].updateGroupMemberInfoByUser error!", e);
        }
        return false;
    }

    public boolean updateImeiInfoByUser(ImeiItem imeiItem) {
        if (StringUtils.isNullOrEmpty(imeiItem.getUserImeiNo())) {
            return false;
        }
        try {
            String str = UrlConstants.urlPre + UrlConstants.reportImeiInfo;
            String toJson = new Gson().toJson((Object) imeiItem);
            HttpResult postDataWithRetryWithHwAccount = HttpClient.getInstance().postDataWithRetryWithHwAccount(str, toJson, null);
            C2511g.m12481b("BETACLUB_SDK", "updateImeiInfoByUser json is " + toJson);
            if (postDataWithRetryWithHwAccount == null || !postDataWithRetryWithHwAccount.isResponseOK()) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpBetaAccess].updateImeiInfoByUser error!", e);
            return false;
        }
    }

    public boolean uploadCurrentDeviceVersionInfoByUser(ProductVersionItem productVersionItem) {
        if (StringUtils.isNullOrEmpty(productVersionItem.getCurrentProdVer())) {
            return false;
        }
        try {
            String str = UrlConstants.urlPre + UrlConstants.updateDeviceVersionUrl;
            String toJson = new Gson().toJson((Object) productVersionItem);
            HttpResult postDataWithRetryWithHwAccount = HttpClient.getInstance().postDataWithRetryWithHwAccount(str, toJson, null);
            C2511g.m12481b("BETACLUB_SDK", "uploadCurrentDeviceVersionInfo json is " + toJson);
            if (postDataWithRetryWithHwAccount == null || !postDataWithRetryWithHwAccount.isResponseOK()) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpBetaAccess].uploadCurrentDeviceVersionInfo error!", e);
            return false;
        }
    }

    public AuthResponseItem getAuthInfoBeanFromServer(AuthRequestItem authRequestItem) {
        if (authRequestItem != null) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getAuthInfoBeanFromServer]request:" + authRequestItem.toString());
        }
        try {
            HttpResult postDataWithRetryNoLogin = postDataWithRetryNoLogin(UrlConstants.checkAuthInfoBeanUrl, new Gson().toJson((Object) authRequestItem), null);
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getAuthInfoBeanFromServer]ret:" + postDataWithRetryNoLogin.content);
            if (isHttpResultCorrect(postDataWithRetryNoLogin)) {
                return (AuthResponseItem) new Gson().fromJson(postDataWithRetryNoLogin.content, AuthResponseItem.class);
            }
            return null;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpBetaAccess.getAuthInfoBeanFromServer]Error!", e);
            return null;
        }
    }

    private HttpResult postDataWithRetryNoLogin(String str, String str2, Map<String, String> map) {
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.postDataWithRetryNoLogin] url---> " + str);
        HttpResult httpResult = null;
        for (int i = 0; i < 2; i++) {
            httpResult = HttpClient.getInstance().postDataWithRetryWithHwAccount(str, str2, map);
            if (httpResult.isResponseOK()) {
                C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.postDataWithRetry] success ");
                break;
            }
        }
        return httpResult;
    }

    public static boolean isHttpResultCorrect(HttpResult httpResult) {
        if (httpResult == null || TextUtils.isEmpty(httpResult.content) || !httpResult.isResponseOK()) {
            return false;
        }
        return true;
    }

    public List<ReportRequestItem> getUserReportItemListFromWeb() {
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getUserReportItemListFromWeb]Start...");
        List arrayList = new ArrayList();
        String str = UrlConstants.urlPre + String.format(UrlConstants.findUserReportItemList, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getUserReportItemListFromWeb]url:" + str);
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(str);
        if (dataWithRetry.isResponseOK()) {
            str = dataWithRetry.content;
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getUserReportItemListFromWeb]content:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pageVO");
                int parseInt = Integer.parseInt(jSONObject.getString("pageSize"));
                int parseInt2 = Integer.parseInt(jSONObject.getString("totalRows"));
                for (int i = 0; i <= parseInt2 / parseInt; i++) {
                    str = UrlConstants.urlPre + String.format(UrlConstants.findUserReportItemList, new Object[]{Integer.valueOf(parseInt), Integer.valueOf(i + 1)});
                    C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getUserReportItemListFromWeb]url:" + str);
                    dataWithRetry = HttpClient.getInstance().getDataWithRetry(str);
                    if (dataWithRetry != null && dataWithRetry.isResponseOK()) {
                        String str2 = "";
                        str = dataWithRetry.content;
                        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getUserReportItemListFromWeb]contentTmp is " + str);
                        JSONArray jSONArray = new JSONObject(str).getJSONArray("result");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getUserReportItemListFromWeb]item is " + jSONObject2.toString());
                            ReportRequestItem reportRequestItem = new ReportRequestItem();
                            reportRequestItem.setReportSetId(jSONObject2.getString("reportSetId"));
                            reportRequestItem.setReportCode(jSONObject2.getString("reportCode"));
                            arrayList.add(reportRequestItem);
                        }
                    }
                }
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "getUserReportItemListFromWeb Error!", e);
            }
            C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.getUserReportItemListFromWeb]reportItemList:" + arrayList.toString());
        }
        return arrayList;
    }

    public boolean updateBetaUserAgreement(boolean z) {
        C2511g.m12481b("BETACLUB_SDK", "[HttpBetaAccess.updateBetaUserAgreement] is called! isAgree is " + z);
        try {
            String updateBetaUserAgreementUrl = HttpCommonAPi.getUpdateBetaUserAgreementUrl();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("userId", C2514j.m12519b());
            jsonObject.addProperty("betaActivityAgreement", z ? "1" : "0");
            if (HttpClient.getInstance().postDataWithRetryWithHwAccount(updateBetaUserAgreementUrl, jsonObject.toString(), null).isResponseOK()) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpBetaAccess.updateBetaUserAgreement]Exception:", e);
            return false;
        }
    }

    public void logout() {
        new Thread(new C07901()).start();
        if (logoutWebServer()) {
            C2511g.m12481b("BETACLUB_SDK", "logout WebServer success!");
        }
        C2514j.m12513a(this.mContext, false);
        C2516l.m12554a();
        HttpUtils.getInstance().clearCookies();
    }

    public boolean logoutWebServer() {
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(HttpCommonAPi.logoutWebServer());
        return dataWithRetry != null && dataWithRetry.isResponseOK();
    }
}
