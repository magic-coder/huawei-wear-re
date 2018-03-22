package com.huawei.crowdtestsdk.home;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.huawei.androidcommon.utils.Md5Utils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.bases.CreateType.CREATE_TYPE;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.bases.SendType.SEND_TYPE;
import com.huawei.crowdtestsdk.common.FeedbackUtils;
import com.huawei.crowdtestsdk.common.IssueMaker;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.db.FeedbackHistoryConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import com.huawei.uploadlog.p188c.C2514j;
import java.io.File;
import java.util.UUID;

public class SendLogTask extends AsyncTask<String, Void, Void> {
    private BroadcastReceiver SendLogTaskResultReceiver = new C07831();
    private Callback callback;
    private Context context;
    protected DBItemSet dbItemSet = null;
    private CommonDevice device;
    private FeedbackParams feedbackParams;
    private Boolean isNeedCompress;
    protected Uri uri = FeedbackHistoryConstants.CONTENT_URI_LOG;

    class C07831 extends BroadcastReceiver {
        C07831() {
        }

        public void onReceive(Context context, Intent intent) {
            C2511g.m12481b("BETACLUB_SDK", "[SendLogTaskResultReceiver.onReceive] start..");
            int intExtra = intent.getIntExtra(SdkConstants.LOG_UPLOAD_RESULT, 0);
            String stringExtra = intent.getStringExtra(SdkConstants.LOG_UPLOAD_FILENAME);
            C2511g.m12481b("BETACLUB_SDK", "[SendLogTaskResultReceiver.onReceive] filePath:" + stringExtra);
            switch (intExtra) {
                case 16:
                    SendLogTask.this.callback.onSuccess(stringExtra);
                    return;
                case 17:
                    SendLogTask.this.callback.onFailed(stringExtra);
                    return;
                default:
                    SendLogTask.this.callback.onFailed("send log failed");
                    return;
            }
        }
    }

    public interface Callback {
        void onFailed(String str);

        void onSuccess(String str);
    }

    public SendLogTask(Context context, FeedbackParams feedbackParams, CommonDevice commonDevice, Boolean bool, Callback callback) {
        this.context = context;
        this.feedbackParams = feedbackParams;
        this.device = commonDevice;
        this.callback = callback;
        this.isNeedCompress = bool;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.SendLogTaskResultReceiver, new IntentFilter(SdkConstants.ACTION_LOG_UPLOAD_RESULT));
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.onPreExecute] registerReceiver SendLogTaskResultReceiver...");
    }

    protected Void doInBackground(String... strArr) {
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.doInBackground] start...");
        String str = strArr[0];
        if (StringUtils.isNullOrEmpty(str)) {
            C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.doInBackground]logPath is null");
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.doInBackground] logPath:" + str);
            if (this.feedbackParams != null) {
                this.device.setDeviceId(this.feedbackParams.getDeviceId());
                this.device.setVersionName(this.feedbackParams.getProductVersion());
                this.device.setProductName(this.feedbackParams.getProductName());
                C2514j.m12521b(this.context, this.feedbackParams.getDeviceId());
            }
            if (this.isNeedCompress.booleanValue()) {
                str = FeedbackUtils.compressLog(this.context, str, null, this.device);
            }
            send(str);
            C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.doInBackground] end...");
        }
        return null;
    }

    private void send(String str) {
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.send] start..");
        if (StringUtils.isNullOrEmpty(str)) {
            Log.d("BETACLUB_SDK", "[SendLogTask.send]compressedLogPath is null");
            return;
        }
        this.dbItemSet = makeDbItemSet(SEND_TYPE.SEND_NOW, str);
        this.uri = IssueMaker.updateRecord(this.context, this.uri, this.dbItemSet, this.context.getString(R.string.sdk_crowdtest_feedback_status_compressing_log), 1, "1");
        long md5 = Md5Utils.getMD5(str);
        this.dbItemSet.mCompressdLogPath = str;
        this.dbItemSet.logId = md5;
        Log.d("BETACLUB_SDK", "[SendLogTask.send]compressedLogPath:" + this.dbItemSet.mCompressdLogPath);
        Log.d("BETACLUB_SDK", "[SendLogTask.send]logId: " + md5);
        this.uri = IssueMaker.updateRecord(this.context, this.uri, this.dbItemSet, IssueMaker.formatSendingStatus(this.context, this.dbItemSet.mCompressdLogPath), 1, "2");
        long length = new File(str).length();
        Log.d("BETACLUB_SDK", "[SendLogTask.send]The send file size：" + length);
        if (length == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
            contentValues.put(FeedbackHistoryConstants.COLUMN_NAME_SEND_STATUS, "done");
            contentValues.put("state", this.context.getString(R.string.sdk_crowdtest_feedback_status_send_success));
            contentValues.put("reserve3", "3");
            this.context.getContentResolver().update(this.uri, contentValues, null, null);
            return;
        }
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.sendLog]compressedLogPath " + str);
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.sendLog]logId " + md5);
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.sendLog]size " + length);
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.sendLog]netType " + 7);
        C2513i.m12496a(this.context, str, md5, length, 7, 3, 11);
    }

    protected void onPostExecute(Void voidR) {
        super.onPostExecute(voidR);
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.onPostExecute] unregisterReceiver SendLogTaskResultReceiver...");
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.onPostExecute] send log end...");
    }

    private DBItemSet makeDbItemSet(SEND_TYPE send_type, String str) {
        C2511g.m12481b("BETACLUB_SDK", "[SendLogTask.makeDbItemSet] is call");
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        long currentTimeMillis = System.currentTimeMillis();
        if (send_type == SEND_TYPE.SEND_NOW) {
            int hashCode = UUID.randomUUID().hashCode();
            while (hashCode == Integer.MIN_VALUE) {
                hashCode = UUID.randomUUID().hashCode();
            }
            str2 = String.valueOf((long) (0 - Math.abs(hashCode)));
        }
        return new DBItemSet(0, 100, str3, 0, currentTimeMillis, str, null, null, null, null, str4, str5, this.device.getDeviceHelper(), str2, CREATE_TYPE.NEW.ordinal(), send_type.ordinal(), -1);
    }
}
