package com.huawei.crowdtestsdk.receiver;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.history.HistoryStatus;
import com.huawei.crowdtestsdk.net.UploadProgress;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.uploadlog.LogUpload;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogSendProgressReceiver extends BroadcastReceiver {

    public class DealProgressAsyncTask extends AsyncTask<String, Void, Void> {
        long logId;
        Context mContext;
        int percent;

        public DealProgressAsyncTask(long j, int i, Context context) {
            this.logId = j;
            this.mContext = context;
            this.percent = i;
        }

        protected Void doInBackground(String... strArr) {
            C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.DealProgressAsyncTask.doInBackground]Start");
            String str = "log_id=?";
            String[] strArr2 = new String[]{this.logId + ""};
            synchronized (FeedbackHistoryConstants.lock) {
                Cursor query = this.mContext.getContentResolver().query(FeedbackHistoryConstants.CONTENT_URI_LOG, null, str, strArr2, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(4);
                    String string2 = query.getString(13);
                    String string3 = query.getString(7);
                    String string4 = query.getString(16);
                    C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.DealProgressAsyncTask.doInBackground]historyStatus : " + string4);
                    if (!(HistoryStatus.isSentSuccessState(string4) || HistoryStatus.isSentFailState(string4))) {
                        string = LogSendProgressReceiver.updateStatePercent(string, this.percent, string4);
                        C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.DealProgressAsyncTask.doInBackground]Update upload state:" + string);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", string);
                        C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.DealProgressAsyncTask.doInBackground]Sending state is:" + string);
                        this.mContext.getContentResolver().update(FeedbackHistoryConstants.CONTENT_URI_LOG, contentValues, str, strArr2);
                        LogSendProgressReceiver.updateUploadProgress(string2, string3, this.percent);
                        C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.DealProgressAsyncTask.doInBackground]Sending percent" + this.percent);
                    }
                    IOUtils.close(query);
                }
            }
            return null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.onReceive]enter");
        String action = intent.getAction();
        String packageName = context.getPackageName();
        if ("com.huawei.crowdtestsdk.UPLOAD_PROGRESS".equals(action)) {
            action = intent.getStringExtra(JoinConstants.EXCEPTION);
            C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.onReceive] exception:" + action);
            if (StringUtils.isNullOrEmpty(action)) {
                LogUpload logUpload = (LogUpload) intent.getParcelableExtra("mLogUploadInfo");
                if (logUpload == null) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.onReceive]mLogUploadInfo is null");
                    return;
                } else if (packageName.equalsIgnoreCase(logUpload.getFeedBackPackageName()) && logUpload.getContentRange() != null) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.onReceive] updateUploadPercent is called!");
                    updateUploadPercent(context, logUpload);
                    return;
                } else {
                    return;
                }
            }
            C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.onReceive] exception is not null");
        }
    }

    public static void updateUploadPercent(Context context, LogUpload logUpload) {
        CharSequence contentRange = logUpload.getContentRange();
        long size = logUpload.getSize();
        C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.updateUploadPercent]FileSize:" + size);
        C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.updateUploadPercent]ContentRange:" + contentRange);
        if (contentRange != null) {
            int i;
            if (StringUtils.isNullOrEmpty(contentRange)) {
                i = 0;
            } else {
                Matcher matcher = Pattern.compile("\\[[,0-9]+\\]").matcher(contentRange);
                i = 0;
                while (matcher.find()) {
                    i = (int) (((long) i) + parseContentRange(matcher.group()));
                    C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.updateUploadPercent]ranger==" + i);
                }
            }
            if (size < 1) {
                i = 100;
            } else {
                i = (int) ((((float) i) / ((float) size)) * 100.0f);
            }
            C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.updateUploadPercent]percent==" + i);
            new DealProgressAsyncTask(logUpload.getId(), i, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    private static long parseContentRange(String str) {
        try {
            String[] split = str.split(",");
            int parseInt = Integer.parseInt(split[0].substring(1));
            int parseInt2 = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
            C2511g.m12481b("BETACLUB_SDK", "[LogSendProgressReceiver.parseContentRange]Parse range result：" + (parseInt2 - parseInt));
            return (long) (parseInt2 - parseInt);
        } catch (Exception e) {
            C2511g.m12483c("BETACLUB_SDK", "[LogSendProgressReceiver.parseContentRange]Exception：" + str);
            return 0;
        }
    }

    private static String updateStatePercent(String str, int i, String str2) {
        if (str == null) {
            return "";
        }
        if (HistoryStatus.isSentSuccessState(str2)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("[");
        if (lastIndexOf >= 0) {
            return str.substring(0, lastIndexOf) + String.format("[%d%%]", new Object[]{Integer.valueOf(i)});
        }
        return str + String.format("[%d%%]", new Object[]{Integer.valueOf(i)});
    }

    private static void updateUploadProgress(String str, String str2, int i) {
        UploadProgress.getInstance().updateUploadProgress(str, str2, i);
    }
}
