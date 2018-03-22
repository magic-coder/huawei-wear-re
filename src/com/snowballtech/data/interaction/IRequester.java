package com.snowballtech.data.interaction;

import android.content.Context;
import com.snowballtech.common.bean.TaskResult;
import java.io.InputStream;

public interface IRequester {
    void init(Context context);

    void release();

    <P> TaskResult<InputStream> requestData(RequesterParam<P> requesterParam);

    <P, R> TaskResult<R> requestData(RequesterParam<P> requesterParam, Class<R> cls);
}
