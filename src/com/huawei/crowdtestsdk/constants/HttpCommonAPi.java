package com.huawei.crowdtestsdk.constants;

public class HttpCommonAPi {
    private static boolean isProductEnv = true;
    public static final boolean isUsedNewInterface = false;

    public static String getUpdateMyBetaQuestionUrl() {
        return UrlConstants.urlPre + UrlConstants.updateMyBetaQuestionUrl;
    }

    public static String getIssueListByProjIdUrlPreFormatUrl() {
        return UrlConstants.issueListByProjIdUrlPreFormat;
    }

    public static String getUpdateBetaUserAgreementUrl() {
        return isProductEnv ? UrlConstants.urlPre + UrlConstants.updateBetaUserAgreementUrl_sit : UrlConstants.urlPre + UrlConstants.updateBetaUserAgreementUrl;
    }

    public static String getIssueSearchDetailUrl() {
        return isProductEnv ? UrlConstants.issueSearchDetailUrl_sit : UrlConstants.issueSearchDetailUrl;
    }

    public static String logoutWebServer() {
        return UrlConstants.logoutWebServer;
    }
}
