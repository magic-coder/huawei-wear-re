package com.huawei.crowdtestsdk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import com.huawei.androidcommon.utils.Md5Utils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.bases.CreateType.CREATE_TYPE;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.bases.SendType.SEND_TYPE;
import com.huawei.crowdtestsdk.bases.TbdtsCreationUnit;
import com.huawei.crowdtestsdk.bases.TbdtsStatus;
import com.huawei.crowdtestsdk.common.FeedbackUtils;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.crowdtestsdk.constants.IntegrationConstants.ACTIONS;
import com.huawei.crowdtestsdk.constants.SdfConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.devices.UnknownDevice;
import com.huawei.crowdtestsdk.feedback.description.DescriptionParas;
import com.huawei.crowdtestsdk.feedback.task.CreateIssueAsyncTask;
import com.huawei.crowdtestsdk.feedback.task.CreateIssueTask;
import com.huawei.crowdtestsdk.feedback.task.CreateIssueTask.OnCreationCallback;
import com.huawei.crowdtestsdk.utils.PhoneInfo;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import com.huawei.uploadlog.p188c.C2514j;
import com.huawei.uploadlog.p188c.C2515k;
import java.io.File;
import java.util.ArrayList;
import java.util.TimeZone;

public class CreateIssueBackgroundService extends Service {
    public static final String ACTION_RESPONSE_FOR_BACKGROUND = "com.huawei.crowdtestsdk.BROADCAST_TYPE_RESPONSE";
    private DBItemSet dbItemSet = null;
    CommonDevice device = new UnknownDevice();
    private int netType;

    class C07921 implements OnCreationCallback {
        C07921() {
        }

        public void callback(TbdtsStatus tbdtsStatus) {
            if (tbdtsStatus == null) {
                CreateIssueBackgroundService.this.onCreateTbdtsFailed(0);
            } else if (CreateIssueTask.parseTbdtsStatus(tbdtsStatus)) {
                String tbdtsQuesNo = tbdtsStatus.getTbdtsQuesNo();
                if (StringUtils.isNullOrEmpty(tbdtsQuesNo)) {
                    CreateIssueBackgroundService.this.onCreateTbdtsFailed(0);
                    return;
                }
                CreateIssueBackgroundService.this.onCreateTbdtsSucceed(tbdtsQuesNo);
                C2511g.m12477a("BETACLUB_SDK", "[CreateIssueBackgroundService.createIssue]Issue created success, update time preference!");
            } else {
                CreateIssueBackgroundService.this.onCreateTbdtsFailed(tbdtsStatus.getStatus());
            }
        }
    }

    public class CreateIssueBackgroundBinder extends Binder {
        public CreateIssueBackgroundService getService() {
            return CreateIssueBackgroundService.this;
        }
    }

    public void onCreate() {
        C2511g.m12481b("BETACLUB_SDK", "CreateIssueBackgroundService onCreate");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2511g.m12481b("BETACLUB_SDK", "CreateIssueBackgroundService onStartCommand");
        if (intent != null) {
            String stringExtra = intent.getStringExtra(IntegrationConstants.REQUEST_TYPE);
            String stringExtra2 = intent.getStringExtra("Type");
            if ("Request".equalsIgnoreCase(stringExtra2)) {
                handleRequest(stringExtra, intent);
            } else if ("Response".equalsIgnoreCase(stringExtra2)) {
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    private void handleRequest(String str, Intent intent) {
        if (ACTIONS.ACTION_START_ONEKEY_FEEDBACK.equalsIgnoreCase(str)) {
            this.netType = intent.getIntExtra(IntegrationConstants.UPLOAD_NET_TYPE, 1);
            String stringExtra = intent.getStringExtra(IntegrationConstants.FILE_PATH);
            C2511g.m12481b("BETACLUB_SDK", "[CreateIssueBackgroundService.handleRequest]logPath : " + stringExtra);
            if (StringUtils.isNullOrEmpty(stringExtra)) {
                responseToRequester(str, -1, getResources().getString(ResUtil.getResId(this, "background_error_log_empty", ResUtil.TYPE_STRING)));
                return;
            }
            String c = C2515k.m12549c();
            long longExtra = intent.getLongExtra(IntegrationConstants.OCCURRENCE_TIME, -1);
            C2511g.m12481b("BETACLUB_SDK", "[CreateIssueBackgroundService.handleRequest]occurrenceTime : " + longExtra);
            String stringExtra2 = intent.getStringExtra(IntegrationConstants.FEEDBACK_DESCRIPTION_SUMMERY);
            C2511g.m12481b("BETACLUB_SDK", "[CreateIssueBackgroundService.handleRequest]desSummary : " + stringExtra2);
            String stringExtra3 = intent.getStringExtra(IntegrationConstants.FEEDBACK_DESCRIPTION_DETAIL);
            TbdtsCreationUnit tbdtsCreationUnit = new TbdtsCreationUnit();
            tbdtsCreationUnit.setPROJECT_ID(c);
            tbdtsCreationUnit.setPHONE_MODEL(PhoneInfo.getDeviceModel());
            tbdtsCreationUnit.setPHONE_VER(PhoneInfo.getDeviceFullVersion());
            tbdtsCreationUnit.setRECURE((String) DescriptionParas.recure.get(0));
            String description = getDescription(this, stringExtra2, stringExtra3);
            tbdtsCreationUnit.setDESCRIPTION(description);
            tbdtsCreationUnit.setUSER_ACCOUNT(C2514j.m12523c());
            tbdtsCreationUnit.setAPPEAR_DATE(SdfConstants.getDateTime(longExtra));
            tbdtsCreationUnit.setAPPEAR_TIME_ZONE(TimeZone.getDefault().getID());
            createIssue(tbdtsCreationUnit);
            this.dbItemSet = new DBItemSet(Md5Utils.getMD5(stringExtra), SpecialIssueType.BUG_TYPE_ID_CHARGE, description, 1, longExtra, null, stringExtra, null, new ArrayList(), new ArrayList(), c, C2515k.m12552d(), this.device.getDeviceHelper(), null, CREATE_TYPE.NEW.ordinal(), SEND_TYPE.SEND_ON_WIFI.ordinal(), System.currentTimeMillis());
        }
    }

    private void responseToRequester(String str, int i, String str2) {
        C2511g.m12481b("BETACLUB_SDK", "[CreateIssueBackgroundService.responseToRequester]start");
        Intent intent = new Intent(ACTION_RESPONSE_FOR_BACKGROUND);
        intent.putExtra(IntegrationConstants.REQUEST_TYPE, str);
        intent.putExtra(IntegrationConstants.RESPONSE_CODE, i);
        if (!StringUtils.isNullOrEmpty(str2)) {
            intent.putExtra(IntegrationConstants.RESPONSE_STATUS_DESCRIPTION, str2);
        }
        sendBroadcast(intent);
    }

    private String getDescription(Context context, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(context.getResources().getString(ResUtil.getResId(context, "description_old_detail_title", ResUtil.TYPE_STRING)));
        stringBuilder.append("\n");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private void createIssue(TbdtsCreationUnit tbdtsCreationUnit) {
        new CreateIssueAsyncTask(tbdtsCreationUnit, new C07921()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void onCreateTbdtsFailed(int i) {
        C2511g.m12477a("BETACLUB_SDK", "[CreateIssueBackgroundService.onCreateTbdtsFailed]Create issue failed, Code:" + i);
        responseToRequester(ACTIONS.ACTION_START_ONEKEY_FEEDBACK, -1, CreateIssueTask.getErrorMsgByRetCode(this, i));
        C2511g.m12477a("BETACLUB_SDK", "[CreateIssueBackgroundService.onCreateTbdtsFailed]End");
    }

    private void onCreateTbdtsSucceed(String str) {
        responseToRequester(ACTIONS.ACTION_START_ONEKEY_FEEDBACK, 200, null);
        if (this.dbItemSet != null) {
            String compressLog = FeedbackUtils.compressLog(this, this.dbItemSet.logPath, null, str, this.device);
            long md5 = Md5Utils.getMD5(compressLog);
            long length = new File(compressLog).length();
            this.dbItemSet.logId = md5;
            this.dbItemSet.mCompressdLogPath = compressLog;
            this.dbItemSet.tbdtsNo = str;
            String str2 = "BETACLUB_SDK";
            StringBuilder append = new StringBuilder().append("[CreateIssueBackgroundService.onCreateTbdtsSucceed]quesNo:");
            if (str == null) {
                str = null;
            }
            C2511g.m12477a(str2, append.append(str).toString());
            FeedbackUtils.insertRecord(this, FeedbackHistoryConstants.CONTENT_URI_LOG, this.dbItemSet, FeedbackUtils.formatSendingStatus(this, this.dbItemSet.mCompressdLogPath), 1, "2");
            C2513i.m12496a(this, compressLog, md5, length, this.netType, SdkConstants.getCommercialVersion(), 5);
            this.dbItemSet = null;
        }
    }

    public void onDestroy() {
        C2511g.m12481b("BETACLUB_SDK", "[CreateIssueBackgroundService.onDestroy]enter");
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return new CreateIssueBackgroundBinder();
    }
}
