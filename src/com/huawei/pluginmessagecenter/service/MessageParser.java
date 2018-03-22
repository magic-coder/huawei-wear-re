package com.huawei.pluginmessagecenter.service;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.login.ui.login.a;
import com.huawei.pluginmessagecenter.p499a.C5856b;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.data.CloudMessageObject;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.ArrayList;
import java.util.List;

public class MessageParser {
    private static final int DEFAULT_POSITION = 0;
    private static final String TAG = "MessageParser";

    public static List<MessageObject> parseMessageArray(Context context, String str) throws JsonSyntaxException {
        C5861g.m27024c(TAG, "parseMessageArray() ==> json = " + str);
        List<MessageObject> arrayList = new ArrayList();
        CloudMessageObject[] cloudMessageObjectArr = (CloudMessageObject[]) new Gson().fromJson(str, CloudMessageObject[].class);
        String c = a.a(context).c();
        if (cloudMessageObjectArr != null) {
            int i = 0;
            while (i < cloudMessageObjectArr.length) {
                if (cloudMessageObjectArr[i] != null) {
                    MessageObject messageObject = new MessageObject();
                    messageObject.setMsgId(cloudMessageObjectArr[i].getMsgId());
                    messageObject.setMsgType(cloudMessageObjectArr[i].getMsgType());
                    messageObject.setMsgTitle(cloudMessageObjectArr[i].getMsgTitle());
                    messageObject.setExpireTime(C5856b.m27004a(cloudMessageObjectArr[i].getExpireTime()));
                    messageObject.setMsgContent(cloudMessageObjectArr[i].getMsgContext());
                    messageObject.setFlag(cloudMessageObjectArr[i].getFlag());
                    messageObject.setWeight(cloudMessageObjectArr[i].getWeight());
                    messageObject.setImgUri(cloudMessageObjectArr[i].getImgUri());
                    messageObject.setDetailUri(cloudMessageObjectArr[i].getDetailUri());
                    messageObject.setMsgFrom(cloudMessageObjectArr[i].getFrom());
                    messageObject.setCreateTime(cloudMessageObjectArr[i].getCreateTime());
                    messageObject.setPosition(getPosition(cloudMessageObjectArr[i].getPosition()).intValue());
                    messageObject.setImei(cloudMessageObjectArr[i].getMsgDevice());
                    messageObject.setMsgPosition(cloudMessageObjectArr[i].getMsgPosition());
                    if (cloudMessageObjectArr[i].getMsgId() != null && cloudMessageObjectArr[i].getMsgId().startsWith("S")) {
                        messageObject.setHuid(c);
                    }
                    arrayList.add(messageObject);
                }
                i++;
            }
        }
        C5861g.m27024c(TAG, "parseMessageArray:" + arrayList);
        return arrayList;
    }

    private static Integer getPosition(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            C5861g.m27023b(TAG, "getPosition() NumberFormatException" + e);
            return Integer.valueOf(0);
        }
    }
}
