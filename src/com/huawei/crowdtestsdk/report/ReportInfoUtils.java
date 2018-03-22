package com.huawei.crowdtestsdk.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.bases.ReportRequestItem;
import com.huawei.crowdtestsdk.bases.ReportResponseItem;
import com.huawei.crowdtestsdk.constants.ReportConstants;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.crowdtestsdk.utils.PhoneInfo;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.List;

public class ReportInfoUtils {
    public static final int FEEDBACK_FAILED = 124;
    public static final int FEEDBACK_SUCCESS = 123;

    final class C07911 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$deviceId;
        final /* synthetic */ GroupMemberItem val$gItem;
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ String val$hardwareVersion;
        final /* synthetic */ String val$hwWearableAppVersion;
        final /* synthetic */ ImeiItem val$imeiItem;
        final /* synthetic */ String val$projectId;
        final /* synthetic */ ProductVersionItem val$pvItem;
        final /* synthetic */ String val$routerBrand;
        final /* synthetic */ String val$versionName;

        C07911(ImeiItem imeiItem, String str, String str2, ProductVersionItem productVersionItem, GroupMemberItem groupMemberItem, Context context, String str3, String str4, String str5, String str6, Handler handler) {
            this.val$imeiItem = imeiItem;
            this.val$projectId = str;
            this.val$deviceId = str2;
            this.val$pvItem = productVersionItem;
            this.val$gItem = groupMemberItem;
            this.val$context = context;
            this.val$versionName = str3;
            this.val$routerBrand = str4;
            this.val$hwWearableAppVersion = str5;
            this.val$hardwareVersion = str6;
            this.val$handler = handler;
        }

        public void run() {
            C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.reportFeedbackInfo]Task starts!");
            ReportInfoUtils.reportUserImei(this.val$imeiItem, this.val$projectId, this.val$deviceId);
            boolean uploadCurrentDeviceVersionInfoByUser = HttpBetaAccess.getInstance().uploadCurrentDeviceVersionInfoByUser(this.val$pvItem);
            C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.reportFeedbackInfo]Result1 : " + uploadCurrentDeviceVersionInfoByUser);
            boolean updateGroupMemberInfoByUser = HttpBetaAccess.getInstance().updateGroupMemberInfoByUser(this.val$gItem);
            C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.reportFeedbackInfo]Result2 : " + updateGroupMemberInfoByUser);
            ReportInfoUtils.uploadUserReportInfo(this.val$context, this.val$projectId, this.val$deviceId, this.val$versionName, this.val$routerBrand, this.val$hwWearableAppVersion, this.val$hardwareVersion);
            Message obtainMessage = this.val$handler.obtainMessage();
            if (uploadCurrentDeviceVersionInfoByUser && updateGroupMemberInfoByUser) {
                obtainMessage.what = ReportInfoUtils.FEEDBACK_SUCCESS;
            } else {
                obtainMessage.what = ReportInfoUtils.FEEDBACK_FAILED;
            }
            this.val$handler.sendEmptyMessage(obtainMessage.what);
        }
    }

    public static void reportFeedbackInfo(Context context, Handler handler, ImeiItem imeiItem, ProductVersionItem productVersionItem, GroupMemberItem groupMemberItem, String str, String str2, String str3, String str4, String str5, String str6) {
        C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.reportFeedbackInfo]deviceId : " + str2);
        imeiItem.setProjectId(str);
        imeiItem.setUserImeiNo(str2);
        productVersionItem.setProjectId(str);
        productVersionItem.setCurrentProdVer(str3);
        groupMemberItem.setProjectId(str);
        new Thread(new C07911(imeiItem, str, str2, productVersionItem, groupMemberItem, context, str3, str4, str5, str6, handler)).start();
    }

    public static boolean reportUserImei(ImeiItem imeiItem, String str, String str2) {
        imeiItem.setProjectId(str);
        imeiItem.setUserImeiNo(str2);
        return HttpBetaAccess.getInstance().updateImeiInfoByUser(imeiItem);
    }

    public static void uploadUserReportInfo(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.uploadUserReportInfo] is called!");
        List<ReportRequestItem> userReportItemListFromWeb = HttpBetaAccess.getInstance().getUserReportItemListFromWeb();
        if (userReportItemListFromWeb == null || userReportItemListFromWeb.isEmpty() || StringUtils.isNullOrEmpty(str2)) {
            C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.uploadUserReportInfo] requestList is null:" + (userReportItemListFromWeb == null));
            return;
        }
        for (ReportRequestItem reportRequestItem : userReportItemListFromWeb) {
            Object reportResponseItem = new ReportResponseItem();
            reportResponseItem.setProjectId(str);
            reportResponseItem.setImeiNo(str2);
            reportResponseItem.setReportSetId(reportRequestItem.getReportSetId());
            C2511g.m12481b("BETACLUB_SDK", "response is " + new Gson().toJson(reportResponseItem).toString());
            String reportCode = reportRequestItem.getReportCode() != null ? reportRequestItem.getReportCode() : "";
            C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.uploadUserReportInfo]reportCode:" + reportCode);
            if (ReportConstants.USER_REPORT_PARAM_LIST.contains(reportCode)) {
                int indexOf = ReportConstants.USER_REPORT_PARAM_LIST.indexOf(reportCode);
                C2511g.m12481b("BETACLUB_SDK", "[ReportInfoUtils.uploadUserReportInfo]index:" + indexOf + ",reportCode:" + reportCode + "was reported!");
                switch (indexOf) {
                    case 0:
                        reportResponseItem.setReportValue(str3);
                        break;
                    case 1:
                        reportResponseItem.setReportValue(str6);
                        break;
                    case 2:
                        reportResponseItem.setReportValue(Build.MODEL);
                        break;
                    case 3:
                        reportResponseItem.setReportValue(PhoneInfo.getDeviceVersion());
                        break;
                    case 4:
                        reportResponseItem.setReportValue(VERSION.RELEASE);
                        break;
                    case 5:
                        reportResponseItem.setReportValue("1.1");
                        break;
                    case 6:
                        reportResponseItem.setReportValue(str4);
                        break;
                    case 7:
                        reportResponseItem.setReportValue(str5);
                        break;
                }
                HttpBetaAccess.getInstance().updateUserReportItem(reportResponseItem);
            }
        }
    }
}
