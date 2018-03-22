package com.huawei.crowdtestsdk.common;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.androidcommon.utils.AndroidUtils;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.Md5Utils;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.bases.BugInfo;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.bases.SendType.SEND_TYPE;
import com.huawei.crowdtestsdk.bases.UploadItem;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.constants.TbdtsConstants;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.devices.IssueMakerFactory;
import com.huawei.crowdtestsdk.net.UploadProgress;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.lcagent.client.LogMetricInfo;
import com.huawei.uploadlog.p188c.C2506b;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class IssueMaker {
    protected Collection<String> attachmentList = null;
    protected BugInfo bugInfo = null;
    protected int bugTypeId = 100;
    protected AtomicBoolean collectLogCompleted = new AtomicBoolean(false);
    private AsyncTask<Object, Object, Object> collectLogTask = new C06771();
    protected Context context = null;
    protected DBItemSet dbItemSet = null;
    private CommonDevice device = null;
    protected boolean dropLogAfterComplete = false;
    protected long id = 0;
    protected boolean isNewFeedback = true;
    protected String logPath = null;
    protected LogMetricInfo metricInfo = null;
    private AsyncTask<Object, Object, Object> packageBugTask = new C06782();
    protected SEND_TYPE sendType = SEND_TYPE.UNKNOWN;
    private String tbdtsNo;
    protected Uri uri = null;

    class C06771 extends AsyncTask<Object, Object, Object> {
        C06771() {
        }

        protected Object doInBackground(Object... objArr) {
            IssueMaker.this.collectLogCompleted.set(false);
            try {
                Log.d("BETACLUB_SDK", "[IssueMaker.collectLogTask.doInBackground]Start");
                UploadItem uploadItem = new UploadItem();
                uploadItem.setStartTimeValue(System.currentTimeMillis());
                uploadItem.setEndTimeValue(System.currentTimeMillis());
                uploadItem.setStatusType(1);
                uploadItem.setApkVer(AndroidUtils.getAppVersionName(C2506b.m12452a().m12454b()));
                uploadItem.setCurrentEvent(1);
                uploadItem.setFileName("LogCollectStart");
                uploadItem.setNetTransType(NetworkUtils.getNetworkType(C2506b.m12452a().m12454b()));
                uploadItem.setCreatorId(TbdtsConstants.getInstance().getCurrentUserId());
                UploadProgress.updateUploadProgress(uploadItem);
                C2511g.m12484d("BETACLUB_SDK", "[IssueMaker.collectLogTask.doInBackground]uploadItem1:" + uploadItem.toJsonString());
                IssueMaker.this.metricInfo = FeedbackUtils.getMetricLogInfo(null, IssueMaker.this.bugTypeId);
                if (IssueMaker.this.metricInfo == null) {
                    uploadItem.setFileName("LogCollectEnd-Null");
                } else {
                    File file = new File(IssueMaker.this.metricInfo.path);
                    uploadItem.setFileName(file.getName());
                    uploadItem.setTotalSize(file.length());
                }
                uploadItem.setStartTimeValue(System.currentTimeMillis());
                uploadItem.setEndTimeValue(System.currentTimeMillis());
                uploadItem.setStatusType(1);
                uploadItem.setApkVer(AndroidUtils.getAppVersionName(C2506b.m12452a().m12454b()));
                uploadItem.setCurrentEvent(4);
                uploadItem.setNetTransType(NetworkUtils.getNetworkType(C2506b.m12452a().m12454b()));
                uploadItem.setCreatorId(TbdtsConstants.getInstance().getCurrentUserId());
                UploadProgress.updateUploadProgress(uploadItem);
                C2511g.m12484d("BETACLUB_SDK", "[IssueMaker.collectLogTask.doInBackground]uploadItem2:" + uploadItem.toJsonString());
                Log.d("BETACLUB_SDK", "[IssueMaker.collectLogTask.doInBackground]End");
            } catch (Throwable e) {
                Log.w("BETACLUB_SDK", "[IssueMaker.collectLogTask.doInBackground]Exception", e);
            }
            return null;
        }

        protected void onPostExecute(Object obj) {
            Log.i("BETACLUB_SDK", "[IssueMaker.collectLogTask.onPostExecute]Start");
            IssueMaker.this.collectLogCompleted.set(true);
            if (IssueMaker.this.dropLogAfterComplete) {
                IssueMaker.this.dropLog();
            }
            super.onPostExecute(obj);
            Log.d("BETACLUB_SDK", "[IssueMaker.collectLogTask.onPostExecute]End");
        }
    }

    class C06782 extends AsyncTask<Object, Object, Object> {
        C06782() {
        }

        public Object doInBackground(Object... objArr) {
            C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.packageBugTask.doInBackground]Start");
            C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.packageBugTask.doInBackground]collectLogCompleted:" + IssueMaker.this.collectLogCompleted);
            C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.packageBugTask.doInBackground]sendType:" + IssueMaker.this.sendType);
            C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.packageBugTask.doInBackground]isNewFeedback:" + IssueMaker.this.isNewFeedback);
            while (!IssueMaker.this.collectLogCompleted.get()) {
                try {
                    C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.packageBugTask.doInBackground]Collecting logs");
                    Thread.sleep(1500);
                } catch (Throwable e) {
                    C2511g.m12479a("BETACLUB_SDK", "[IssueMaker.packageTask.doInBackground]InterruptedException", e);
                }
            }
            C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.packageBugTask.doInBackground]==Completed logs");
            C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.packageBugTask.doInBackground]logPtah——>" + IssueMaker.this.logPath);
            IssueMaker.this.dbItemSet.logPath = IssueMaker.this.logPath;
            if (IssueMaker.this.collectLogCompleted.get()) {
                C2511g.m12481b("BETACLUB_SDK", "collectLogCompleted true");
                if (IssueMaker.this.isNewFeedback) {
                    IssueMaker.this.uri = FeedbackUtils.insertRecord(IssueMaker.this.context, IssueMaker.this.uri, IssueMaker.this.dbItemSet, IssueMaker.formatSendingStatus(IssueMaker.this.context, IssueMaker.this.dbItemSet.mCompressdLogPath), 1, "2");
                } else {
                    IssueMaker.this.uri = IssueMaker.updateRecord(IssueMaker.this.context, IssueMaker.this.uri, IssueMaker.this.dbItemSet, IssueMaker.formatSendingStatus(IssueMaker.this.context, IssueMaker.this.dbItemSet.mCompressdLogPath), 1, "2");
                }
            } else {
                C2511g.m12481b("BETACLUB_SDK", "collectLogCompleted false");
                if (IssueMaker.this.isNewFeedback) {
                    IssueMaker.this.uri = FeedbackUtils.insertRecord(IssueMaker.this.context, IssueMaker.this.uri, IssueMaker.this.dbItemSet, IssueMaker.this.context.getString(ResUtil.getResId(IssueMaker.this.context, "sdk_crowdtest_feedback_status_collecting_log", ResUtil.TYPE_STRING)), 1, "0");
                } else {
                    FeedbackUtils.updateRecord(IssueMaker.this.context, IssueMaker.this.uri, IssueMaker.this.dbItemSet, IssueMaker.this.context.getString(ResUtil.getResId(IssueMaker.this.context, "sdk_crowdtest_feedback_status_collecting_log", ResUtil.TYPE_STRING)), 1, "0");
                }
            }
            if (IssueMaker.this.dropLogAfterComplete || IssueMaker.this.sendType == SEND_TYPE.DROP) {
                IssueMaker.this.dropLog();
                return null;
            }
            if (IssueMaker.this.metricInfo != null) {
                IssueMaker.this.dbItemSet.logPath = IssueMaker.this.metricInfo.path;
            }
            IssueMaker.this.send();
            return null;
        }

        protected void onPostExecute(Object obj) {
            IssueMaker.this.finish();
        }
    }

    class C06793 implements Runnable {
        C06793() {
        }

        public void run() {
            if (IssueMaker.this.metricInfo != null && IssueMaker.this.metricInfo.path != null && !IssueMaker.this.metricInfo.path.isEmpty()) {
                FileUtils.deleteFile(IssueMaker.this.metricInfo.path);
                IssueMaker.this.finish();
            }
        }
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }

    public void setCollectLogCompleted(AtomicBoolean atomicBoolean) {
        this.collectLogCompleted = atomicBoolean;
    }

    public IssueMaker(long j) {
        this.id = j;
    }

    public String getTbdtsNo() {
        if (this.bugInfo != null) {
            return this.bugInfo.getQuesNo();
        }
        return null;
    }

    public long getId() {
        return this.id;
    }

    public void startPackageBug(Uri uri, DBItemSet dBItemSet, BugInfo bugInfo, Collection<String> collection, SEND_TYPE send_type, boolean z) {
        C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.startPackageBug]Start");
        this.uri = uri;
        this.dbItemSet = dBItemSet;
        this.bugInfo = bugInfo;
        this.attachmentList = new HashSet(collection);
        this.sendType = send_type;
        this.isNewFeedback = z;
        if (this.context == null) {
            this.context = bugInfo.getContext();
        }
        C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.startPackageBug]sendType:" + send_type + ",dbItemSet:" + dBItemSet.toString() + ", bugInfo:" + bugInfo.toString());
        if (this.sendType == SEND_TYPE.DROP) {
            cancelCollectLog();
            return;
        }
        if (Status.PENDING.equals(this.packageBugTask.getStatus())) {
            C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.startPackageBug]packageBugTask.getStatus()==Status.PENDING");
            this.packageBugTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.startPackageBug]End");
    }

    private void dropLog() {
        new Thread(new C06793()).start();
    }

    private void dropLog(final String str) {
        new Thread(new Runnable() {
            public void run() {
                if (str != null) {
                    FileUtils.deleteFile(str);
                }
                IssueMaker.this.finish();
            }
        }).start();
    }

    private void finish() {
        C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.finish]Send stop service broadcast");
        IssueMakerFactory.destroyIssueMaker(this.id);
        this.context.sendBroadcast(new Intent(SdkConstants.ACTION_STOP_FEEDBACK_SERVICE), SdkConstants.USE_CROWDTESTSDK_PERMISSION);
    }

    public static String formatSendingStatus(Context context, String str) {
        if (context == null) {
            return "";
        }
        if (str == null) {
            return context.getString(ResUtil.getResId(context, "sdk_crowdtest_feedback_status_sending", ResUtil.TYPE_STRING));
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return context.getString(ResUtil.getResId(context, "sdk_crowdtest_feedback_status_sending", ResUtil.TYPE_STRING));
        }
        long length = file.length();
        if (length > 1048576) {
            float f = (((float) length) / 1024.0f) / 1024.0f;
            return new StringBuilder(context.getString(ResUtil.getResId(context, "sdk_crowdtest_feedback_status_sending", ResUtil.TYPE_STRING))).append(String.format(context.getString(ResUtil.getResId(context, "sdk_crowdtest_description_fragment_send_status_MB", ResUtil.TYPE_STRING)), new Object[]{Float.valueOf(f)})).toString();
        }
        f = ((float) length) / 1024.0f;
        return new StringBuilder(context.getString(ResUtil.getResId(context, "sdk_crowdtest_feedback_status_sending", ResUtil.TYPE_STRING))).append(String.format(context.getString(ResUtil.getResId(context, "sdk_crowdtest_description_fragment_send_status_KB", ResUtil.TYPE_STRING)), new Object[]{Float.valueOf(f)})).toString();
    }

    public static Uri updateRecord(Context context, Uri uri, DBItemSet dBItemSet, String str, int i, String str2) {
        ContentValues parseDbItemSet = parseDbItemSet(dBItemSet);
        try {
            parseDbItemSet.put("state", str);
            parseDbItemSet.put(FeedbackHistoryConstants.COLUMN_NAME_LOG_PATH, dBItemSet.mCompressdLogPath);
            parseDbItemSet.put(FeedbackHistoryConstants.COLUMN_NAME_IS_DRAFT, Integer.valueOf(i));
            parseDbItemSet.put(FeedbackHistoryConstants.COLUMN_NAME_SEND_STATUS, str2);
            context.getContentResolver().update(uri, parseDbItemSet, null, null);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[FeedbackUtils.updateRecord]SQLiteFullException:", e);
        } catch (Throwable e2) {
            C2511g.m12482b("BETACLUB_SDK", "[FeedbackUtils.updateRecord]Exception:", e2);
        }
        return uri;
    }

    private static ContentValues parseDbItemSet(DBItemSet dBItemSet) {
        if (dBItemSet == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("type", Integer.valueOf(dBItemSet.typeId));
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_PROBABILITY, Integer.valueOf(dBItemSet.issueProbabilityIndex));
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_OCCURRENCE_TIME, Long.valueOf(dBItemSet.occurrenceTime));
        contentValues.put("description", dBItemSet.issueDescription);
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_AUDIO_ATTACH, dBItemSet.audioString);
        if (dBItemSet.cameraAttachList != null) {
            contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_CAMERA_ATTACH_LIST, TextUtils.join(",", dBItemSet.cameraAttachList));
        }
        if (dBItemSet.otherAttachList != null) {
            contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_OTHER_ATTACH_LIST, TextUtils.join(",", dBItemSet.otherAttachList));
        }
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_LOG_PATH, dBItemSet.mCompressdLogPath);
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_LOG_ID, Long.valueOf(dBItemSet.logId));
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_ONLY_LOG_PATH, dBItemSet.logPath);
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_ACTIVITY_ID, dBItemSet.activityID);
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_ACTIVITY_NAME, dBItemSet.activityName);
        contentValues.put("device", C2513i.m12500a(dBItemSet.deviceHelper));
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_TBDTS_NO, dBItemSet.tbdtsNo);
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_CREATE_TYPE, Integer.valueOf(dBItemSet.createType));
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_SEND_TYPE, Integer.valueOf(dBItemSet.sendType));
        contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_ISSUE_MAKER_ID, Long.valueOf(dBItemSet.issueMakerId));
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.parseDbItemSet]Values:" + contentValues.toString());
        return contentValues;
    }

    private void send() {
        String str;
        if (this.metricInfo != null) {
            str = this.metricInfo.path;
        } else {
            str = this.dbItemSet.logPath;
        }
        this.uri = updateRecord(this.context, this.uri, this.dbItemSet, this.context.getString(ResUtil.getResId(this.context, "sdk_crowdtest_feedback_status_compressing_log", ResUtil.TYPE_STRING)), 1, "1");
        C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.send]device:" + this.device.getProductName());
        C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.send]device:" + this.device.getVersionName());
        C2511g.m12481b("BETACLUB_SDK", "[IssueMaker.send]device:" + this.device.getDeviceId());
        String compressLog = FeedbackUtils.compressLog(this.context, str, this.attachmentList, this.dbItemSet.tbdtsNo, this.device);
        if (StringUtils.isNullOrEmpty(compressLog)) {
            Log.d("BETACLUB_SDK", "[IssueMaker.send]compressedLogPath is null");
            return;
        }
        int i;
        long md5 = Md5Utils.getMD5(compressLog);
        this.dbItemSet.mCompressdLogPath = compressLog;
        this.dbItemSet.logId = md5;
        this.tbdtsNo = this.dbItemSet.tbdtsNo;
        Log.d("BETACLUB_SDK", "[IssueMaker.send]compressedLogPath:" + this.dbItemSet.mCompressdLogPath);
        Log.d("BETACLUB_SDK", "[IssueMaker.send]logId: " + md5);
        Log.d("BETACLUB_SDK", "[IssueMaker.send]tbdtsNo: " + this.tbdtsNo);
        this.uri = updateRecord(this.context, this.uri, this.dbItemSet, formatSendingStatus(this.context, this.dbItemSet.mCompressdLogPath), 1, "2");
        long length = new File(compressLog).length();
        if (this.sendType == SEND_TYPE.SEND_ON_WIFI) {
            i = 1;
        } else {
            i = 7;
        }
        Log.d("BETACLUB_SDK", "[IssueMaker.send]The send file size：" + length);
        if (length == 0) {
            UploadProgress.getInstance().updateUploadProgressNoAttachment(this.bugInfo.getQuesNo());
            ContentValues contentValues = new ContentValues();
            contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
            contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_SEND_STATUS, "done");
            contentValues.put("state", this.context.getString(ResUtil.getResId(this.context, "sdk_crowdtest_feedback_status_send_success", ResUtil.TYPE_STRING)));
            contentValues.put("reserve3", "3");
            this.context.getContentResolver().update(this.uri, contentValues, null, null);
        } else {
            C2513i.m12496a(this.context, compressLog, md5, length, i, SdkConstants.getCommercialVersion(), 5);
            UploadProgress.getInstance().updateUploadProgress(this.bugInfo.getQuesNo(), compressLog, 0);
            Log.d("BETACLUB_SDK", "[IssueMaker.send.updateUploadProgress]bugInfo.getQuesNo()—>" + this.bugInfo.getQuesNo() + ",compressedLogPath—>" + compressLog + ",percent—>" + 0);
        }
        dropLog(str);
    }

    public void cancelCollectLog() {
        Log.i("BETACLUB_SDK", "[IssueMaker.cancelCollectLog]Start");
        if (Status.FINISHED.equals(this.collectLogTask.getStatus())) {
            dropLog();
            finish();
        } else {
            this.dropLogAfterComplete = true;
            this.collectLogTask.cancel(true);
            finish();
        }
        Log.d("BETACLUB_SDK", "[IssueMaker.cancelCollectLog]End");
    }

    public CommonDevice getDevice() {
        return this.device;
    }

    public void setDevice(CommonDevice commonDevice) {
        this.device = commonDevice;
    }
}
