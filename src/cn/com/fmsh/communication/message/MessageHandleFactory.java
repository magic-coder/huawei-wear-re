package cn.com.fmsh.communication.message;

import cn.com.fmsh.communication.message.core.MessageHandler;

public class MessageHandleFactory {
    private static /* synthetic */ MessageHandler f9430a;

    private static synchronized /* synthetic */ void m13016a() {
        synchronized (MessageHandleFactory.class) {
            if (f9430a == null) {
                f9430a = new MessageHandler();
            }
        }
    }

    public static MessageHandler getMessageHandler() {
        if (f9430a == null) {
            m13016a();
        }
        return f9430a;
    }
}
