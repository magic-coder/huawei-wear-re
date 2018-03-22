package com.huawei.pluginmessagecenter;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageGenerator */
public class C5864c {
    private static volatile C5864c f20130b;
    private Context f20131a;

    private C5864c(Context context) {
        this.f20131a = context.getApplicationContext();
    }

    public static C5864c m27047a(Context context) {
        if (f20130b == null) {
            synchronized (C5864c.class) {
                if (f20130b == null) {
                    f20130b = new C5864c(context);
                }
            }
        }
        return f20130b;
    }

    public boolean m27050a(MessageObject messageObject) {
        if (messageObject == null) {
            C5861g.m27024c("MessageGenerator", "Message object is null.");
            return false;
        }
        C5861g.m27024c("MessageGenerator", "generateMessage messageObjects=============" + messageObject);
        List arrayList = new ArrayList();
        arrayList.add(messageObject);
        return C5862a.m27025a(this.f20131a).m27040a(arrayList);
    }

    public String m27049a(String str, String str2) {
        C5861g.m27024c("MessageGenerator", "Enter requestMessageId | module = " + str + "    type = " + str2);
        if (!m27048b(str, str2)) {
            return "";
        }
        C5861g.m27024c("MessageGenerator", "Leave requestMessageId | module = " + str + "    type = " + str2);
        return C5862a.m27025a(this.f20131a).m27036a(str, str2);
    }

    private boolean m27048b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }
}
