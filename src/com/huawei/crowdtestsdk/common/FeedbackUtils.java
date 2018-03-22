package com.huawei.crowdtestsdk.common;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.ZipUtils;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.lcagent.client.LogMetricInfo;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class FeedbackUtils {
    static ZipUtils zipUtil = new ZipUtils();

    public static String formatSendingStatus(Context context, String str) {
        if (context == null) {
            return "";
        }
        if (str == null) {
            return context.getString(ResUtil.getResId(context, "sdk_crowdtest_feedback_status_sending", ResUtil.TYPE_STRING));
        }
        File file = new File(str);
        if (file == null || file.isDirectory()) {
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

    public static String compressLog(Context context, String str, Collection<String> collection, CommonDevice commonDevice) {
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = SdkConstants.getTargetUploadPathString(context) + C2513i.m12493a(4, "quesNo", commonDevice);
        FileUtils.createFile(str2);
        ZipUtils zipUtils = new ZipUtils();
        List arrayList;
        if (TextUtils.isEmpty(str)) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logPath is null!");
            if (collection != null && collection.size() > 0) {
                arrayList = new ArrayList(collection);
                if (zipUtils.compress((String[]) arrayList.toArray(new String[arrayList.size()]), str2)) {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog]Compress success!");
                }
            }
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logPath:" + str);
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logExist:" + new File(str).exists());
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logSize:" + new File(str).length());
            if (collection != null && collection.size() > 0) {
                arrayList = new ArrayList(collection);
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                if (zipUtils.compress((String[]) arrayList.toArray(new String[arrayList.size()]), str2)) {
                    FileUtils.deleteFile(str);
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]" + str + " was deleted!");
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress success!");
                } else {
                    C2511g.m12484d("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress failed1!");
                }
            } else if (!FileUtils.moveFile(str, str2)) {
                arrayList = new ArrayList();
                arrayList.add(str);
                if (zipUtils.compress((String[]) arrayList.toArray(new String[arrayList.size()]), str2)) {
                    FileUtils.deleteFile(str);
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress success!");
                } else {
                    C2511g.m12484d("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress failed2!");
                }
            }
        }
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return str2;
    }

    public static String compressLog(Context context, String str, Collection<String> collection, String str2, CommonDevice commonDevice) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = SdkConstants.getTargetUploadPathString(context) + C2513i.m12493a(1, str2, commonDevice);
        FileUtils.createFile(str3);
        ZipUtils zipUtils = new ZipUtils();
        List arrayList;
        if (TextUtils.isEmpty(str)) {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logPath is null!");
            if (collection != null && collection.size() > 0) {
                arrayList = new ArrayList(collection);
                if (zipUtils.compress((String[]) arrayList.toArray(new String[arrayList.size()]), str3)) {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog]Compress success!");
                }
            }
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logPath:" + str);
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logExist:" + new File(str).exists());
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]logSize:" + new File(str).length());
            if (collection != null && collection.size() > 0) {
                arrayList = new ArrayList(collection);
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                if (zipUtils.compress((String[]) arrayList.toArray(new String[arrayList.size()]), str3)) {
                    FileUtils.deleteFile(str);
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]" + str + " was deleted!");
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress success!");
                } else {
                    C2511g.m12484d("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress failed1!");
                }
            } else if (!FileUtils.moveFile(str, str3)) {
                arrayList = new ArrayList();
                arrayList.add(str);
                if (zipUtils.compress((String[]) arrayList.toArray(new String[arrayList.size()]), str3)) {
                    FileUtils.deleteFile(str);
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress success!");
                } else {
                    C2511g.m12484d("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress failed2!");
                }
            }
        }
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressLog.withDevice]Compress cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return str3;
    }

    public static Uri insertRecord(Context context, Uri uri, DBItemSet dBItemSet, String str, int i, String str2) {
        Uri uri2 = null;
        ContentValues parseDbItemSet = parseDbItemSet(dBItemSet);
        try {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.insertRecord]mUri:" + uri);
            parseDbItemSet.put("state", str);
            parseDbItemSet.put(FeedbackHistoryConstants.COLUMN_NAME_IS_DRAFT, Integer.valueOf(i));
            parseDbItemSet.put(FeedbackHistoryConstants.COLUMN_NAME_SEND_STATUS, str2);
            C2511g.m12484d("BETACLUB_SDK", "HHHHH" + parseDbItemSet);
            uri2 = context.getContentResolver().insert(uri, parseDbItemSet);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[FeedbackUtils.insertRecord]SQLiteFullException:", e);
        } catch (Throwable e2) {
            C2511g.m12482b("BETACLUB_SDK", "[FeedbackUtils.insertRecord]Exception:", e2);
        }
        return uri2;
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
        return contentValues;
    }

    public static void updateRecord(Context context, Uri uri, DBItemSet dBItemSet, String str, int i, String str2) {
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
    }

    public static LogMetricInfo getMetricLogInfo(LogCollectManager logCollectManager, int i) {
        Throwable th;
        LogMetricInfo logMetricInfo = null;
        if (i >= 0) {
            if (logCollectManager != null) {
                try {
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.getMetricLogInfo]Start logId:" + i);
                    LogMetricInfo captureLogMetric = logCollectManager.captureLogMetric(i);
                    if (i == SpecialIssueType.BUG_TYPE_ID_CHARGE && captureLogMetric == null) {
                        try {
                            captureLogMetric = logCollectManager.captureLogMetric(105);
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            logMetricInfo = captureLogMetric;
                            th = th2;
                            C2511g.m12482b("BETACLUB_SDK", "[FeedbackUtils.getMetricLogInfo]Exception:", th);
                            return logMetricInfo;
                        }
                    }
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.getMetricLogInfo]End logId:" + i);
                    logMetricInfo = captureLogMetric;
                } catch (Exception e2) {
                    th = e2;
                    C2511g.m12482b("BETACLUB_SDK", "[FeedbackUtils.getMetricLogInfo]Exception:", th);
                    return logMetricInfo;
                }
            }
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.getMetricLogInfo]LogMetricInfo:" + logMetricInfo);
        }
        return logMetricInfo;
    }

    public static String compressWearableLog(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        String str = SdkConstants.getTargetLogPathString(context) + "HwSystemLog_" + Calendar.getInstance().getTimeInMillis() + LightCloudConstants.ZIP_POSTFIX;
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressWearableLog]logZip->" + str);
        try {
            if (zipUtil.compress((String[]) list.toArray(new String[list.size()]), str)) {
                C2511g.m12481b("BETACLUB_SDK", "[FeedbackUtils.compressWearableLog]wearable log compress success");
            }
        } catch (Exception e) {
            C2511g.m12484d("BETACLUB_SDK", "compress Bone log Exception" + e);
        }
        return str;
    }
}
