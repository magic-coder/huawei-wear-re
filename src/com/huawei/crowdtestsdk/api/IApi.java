package com.huawei.crowdtestsdk.api;

import android.content.Context;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.bases.bean_new.CloudLoginBean;
import com.huawei.crowdtestsdk.feedback.FeedbackDescriptionActivity.FeedbackCallback;
import com.huawei.crowdtestsdk.home.SendLogTask.Callback;

public interface IApi {
    void gotoFeedback(Context context, CloudLoginBean cloudLoginBean, FeedbackParams feedbackParams, FeedbackCallback feedbackCallback);

    void init(Context context, int i);

    void sendLog(Context context, FeedbackParams feedbackParams, String str, boolean z, Callback callback);

    void unInit(Context context);
}
