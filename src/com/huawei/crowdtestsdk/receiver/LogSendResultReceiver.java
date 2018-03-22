package com.huawei.crowdtestsdk.receiver;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2517m;

public class LogSendResultReceiver extends BroadcastReceiver {
    private static final int ERROR = -1;
    private static final String SEND_FAIL = "fail";
    private static final String SEND_SUCCESS = "success";

    public class DealResultAsyncTask extends AsyncTask<String, Void, Boolean> {
        String filePath;
        long logId;
        Context mContext;
        String tbdtsNo;

        public DealResultAsyncTask(long j, String str, Context context) {
            this.logId = j;
            this.filePath = str;
            this.mContext = context;
        }

        protected Boolean doInBackground(String... strArr) {
            boolean z;
            C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]Start");
            String str = strArr[0];
            C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]toAction : " + str);
            String str2 = "log_id=?";
            String[] strArr2 = new String[]{this.logId + ""};
            ContentValues contentValues;
            Cursor query;
            if ("success".equalsIgnoreCase(str)) {
                contentValues = new ContentValues();
                contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("state", this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_feedback_status_send_success", ResUtil.TYPE_STRING)));
                contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_SEND_STATUS, "3");
                C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]Update start!");
                this.mContext.getContentResolver().update(FeedbackHistoryConstants.CONTENT_URI_LOG, contentValues, str2, strArr2);
                C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]Update success end!");
                query = this.mContext.getContentResolver().query(FeedbackHistoryConstants.CONTENT_URI_LOG, null, str2, strArr2, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex(FeedbackHistoryConstants.COLUMN_NAME_LOG_PATH));
                    String string2 = query.getString(query.getColumnIndex(FeedbackHistoryConstants.COLUMN_NAME_ONLY_LOG_PATH));
                    this.tbdtsNo = query.getString(query.getColumnIndex(FeedbackHistoryConstants.COLUMN_NAME_TBDTS_NO));
                    C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]send success tbdtsNo:" + this.tbdtsNo);
                    C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]Delete File:" + string + "/" + string2);
                    FileUtils.deleteFiles(new String[]{string, string2});
                }
                IOUtils.close(query);
                z = true;
            } else {
                if ("fail".equalsIgnoreCase(str)) {
                    contentValues = new ContentValues();
                    contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("state", this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_feedback_status_send_failed", ResUtil.TYPE_STRING)));
                    contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_SEND_STATUS, "-1");
                    this.mContext.getContentResolver().update(FeedbackHistoryConstants.CONTENT_URI_LOG, contentValues, str2, strArr2);
                    C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]Update fail end!");
                    query = this.mContext.getContentResolver().query(FeedbackHistoryConstants.CONTENT_URI_LOG, null, str2, strArr2, null);
                    if (query != null && query.moveToFirst()) {
                        this.tbdtsNo = query.getString(query.getColumnIndex(FeedbackHistoryConstants.COLUMN_NAME_TBDTS_NO));
                        C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.DealResultAsyncTask.doInBackground]send failed tbdtsNo:" + this.tbdtsNo);
                    }
                    IOUtils.close(query);
                }
                z = false;
            }
            return Boolean.valueOf(z);
        }

        protected void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            C2517m.m12567a(this.mContext, this.tbdtsNo, this.filePath, bool.booleanValue());
        }
    }

    public void onReceive(Context context, Intent intent) {
        C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.onReceive]enter");
        int intExtra = intent.getIntExtra("uploadResult", -1);
        Long valueOf = Long.valueOf(intent.getLongExtra("logId", -1));
        String stringExtra = intent.getStringExtra("filepath");
        C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.onReceive] filePath " + stringExtra);
        C2511g.m12481b("BETACLUB_SDK", "[LogSendResultReceiver.onReceive]Server return send file result state is " + intExtra + ",id is:" + valueOf);
        if (intExtra == 0) {
            C2511g.m12477a("BETACLUB_SDK", "[LogSendResultReceiver.onReceive]======Log Send Success, logId:" + valueOf + "======");
            new DealResultAsyncTask(valueOf.longValue(), stringExtra, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"success"});
        } else if (intExtra == 2 || intExtra == 1) {
            C2511g.m12477a("BETACLUB_SDK", "[LogSendResultReceiver.onReceive]======Log Send Failed, logId:" + valueOf + "======");
            new DealResultAsyncTask(valueOf.longValue(), stringExtra, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"fail"});
        } else if (intExtra == -1) {
            C2511g.m12477a("BETACLUB_SDK", "[LogSendResultReceiver.onReceive]======Start receiver with no parameter======");
        }
    }
}
