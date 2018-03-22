package com.huawei.pluginmessagecenter.service;

import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.List;

public interface PullMessageCallBack {
    void pullMessageResult(int i, List<MessageObject> list);
}
