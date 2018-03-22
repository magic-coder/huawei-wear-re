package com.snowballtech.apdu;

import android.content.Context;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;

public interface IApdu {
    void SetDevice(String str);

    void closeChannel(Content content) throws SnowballException;

    void closeChannlAll();

    TaskResult<Content> executeApdu(Context context, Content content);

    TaskResult<Content> executeApduKeep(Context context, Content content);

    TaskResult<INfcChannel> fetchChannel(Context context, Content content) throws SnowballException;

    void release();
}
