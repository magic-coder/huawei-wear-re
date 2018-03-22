package com.huawei.crowdtestsdk.constants;

import com.huawei.uploadlog.p188c.C2511g;

public class UrlConstants {
    public static final String UNI_RED_URL = "uniportalRedirectUrl";
    public static final String UNI_URL = "uniportalUrl";
    public static final String URL_PRE = "urlPre";
    public static final String apkCreateQuestionUrl = "/services/base/apkques/apkCreateQuestion";
    public static final String apkGetQuesWorkFlowInfoUrl = "/services/jalor/workflow/form/taskform/json/%s";
    public static final String checkAuthInfoBeanUrl = (urlPre + "/services/base/baseactivity/findWhetherJoinActivity");
    public static final String environmentUrl = (urlPre + "/servlet/environment");
    public static final String findActRuTaskInfoUrl = "/services/tbdtsbeta/betaquestion/findActRuTaskInfo/%s";
    public static final String findBetaUserIdUrl = "/services/tbdtsbeta/betauser/findBetaUserId/%s";
    public static final String findMyBetaQuestionUrl = "/services/tbdtsbeta/mybeta/findMyBetaQuestion/%s";
    public static final String findProjectListByProTypeUrl = "/services/tbdtsbeta/betaproject/findProjectsByProdTypeAndUser/%s/%d";
    public static final String findProjectListUrl = (urlPre + "/services/tbdtsbeta/betaquestion/findPagedProdHasNoCommList/users/%s/page/%d/%d");
    public static final String findUserReportItemList = "/services/betaApk/ApkActivity/findPagedBetaReportSetList/page/%d/%d";
    public static final String getQuestionDetailUrl = "/services/tbdtsbeta/betaquestion/fullTabform/%s";
    public static final String issueListByProjIdUrlPreFormat = "/services/tbdtsbeta/mybeta/findPageMyBetaQuestionList/page/%d/%d?createdName=%s&language=zh_CN&projectId=%s";
    public static final String issueListByProjIdUrlPreFormat_sit = "/services/betaApk/ApkDealQues/findPageMyBetaQuestionList/page/%d/%d?createdName=%s&language=zh_CN&projectId=%s";
    public static final String issueSearchDetailUrl = "/services/base/basequestion/findPagedBetaQuestionList/page/zh_CN/30/1?tbdtsQuesNo=%s";
    public static final String issueSearchDetailUrlOld = "/services/tbdtsbeta/betaquestion/searchQuestionDetail/%s/zh_CN";
    public static final String issueSearchDetailUrl_sit = "/services/betaApk/ApkDealQues/findPagedBetaQuestionList/page/zh_CN/30/1?tbdtsQuesNo=%s";
    public static final String issueStatusListContentUrl = "/services/tbdtsbeta/betauser/findLookUpList/tbdts_base_ques_status";
    public static final String issueWorkFlowUrlPreFormat = "/services/jalor/workflow/log/find/logs/%s";
    public static final String loginHwAccountUrl = (urlPre + "/loginCloud");
    public static String logoutWebServer = (urlPre + "/servlet/logout");
    public static final String productTypeListUrlPreFormat = "/services/base/baseactivity/findProdTypesByUserId/%s";
    public static final String reportImeiInfo = "/services/tbdtsbeta/betaUserImei/reportImeiInfo";
    public static final String uniportalRedirectUrl = "https://uniportal.huawei.com/uniportal/?redirect=http://betaclub.huawei.com/tbdts_mini/";
    public static final String uniportalRedirectUrl_product = "https://uniportal.huawei.com/uniportal/?redirect=https://betaclub.huawei.com/tbdts_mini/";
    public static final String uniportalRedirectUrl_sit = "https://uniportal-beta.huawei.com/uniportal/?redirect=http://weblink01-ts.huawei.com/tbdts/";
    public static final String uniportalUrl = "https://uniportal.huawei.com";
    public static final String uniportalUrl_product = "https://uniportal.huawei.com";
    public static final String uniportalUrl_sit = "https://uniportal-beta.huawei.com";
    public static final String updateBetaDealQuestionByQuesIDUrl = "/services/tbdtsbeta/betaquestion/updateBetaDealQuestsionByQuesID";
    public static final String updateBetaUserAgreementUrl = "/services/tbdtsuser_new/betausertotal/updateBetaUserAgreement";
    public static final String updateBetaUserAgreementUrl_sit = "/services/betaApk/ApkDealQues/updateBetaUserAgreement";
    public static final String updateDeviceVersionUrl = "/services/tbdtsbeta/betaUserImei/updateCurrentProdVerByUser";
    public static final String updateGroupMemberInfoByUser = "/services/tbdtsbeta/betaUserImei/updateGroupMemberInfoByUser";
    public static final String updateMyBetaQuestionUrl = "/services/tbdtsbeta/mybeta/updateAppendQuesAtt";
    public static final String updateMyBetaQuestionUrl_sit = "/services/betaApk/ApkDealQues/updateAppendQuesAtt";
    public static final String updateRegisterQuestionUrl = "/services/tbdtsbeta/betaquestion/updateRegisterQuestsion";
    public static final String updateUploadProgressUrl = "/services/base/apkques/createAttachUploadStatus/%s/%s/%s/%s/%s";
    public static final String updateUploadProgressUrlNew = (urlPre + "/services/base/attachStatus/createApkAttachStatus");
    public static final String updateUserReportItem = "/services/tbdtsbeta/apkReport/apkReportProductInfo";
    public static final String urlPre = getBetaclubUrl(URL_PRE);
    public static final String urlPre_product = "https://betaclub.huawei.com/tbdts_mini";
    public static final String urlPre_sit = "http://weblink01-ts.huawei.com/tbdts";

    public static String getBetaclubUrl(String str) {
        if (URL_PRE.equalsIgnoreCase(str)) {
            return urlPre_product;
        }
        if (UNI_RED_URL.equalsIgnoreCase(str)) {
            return uniportalRedirectUrl_product;
        }
        if (UNI_URL.equalsIgnoreCase(str)) {
            return "https://uniportal.huawei.com";
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            C2511g.m12484d("BETACLUB_SDK", "连接类型错误！");
            return "";
        }
    }
}
