package cn.com.fmsh.communication.message.core;

import java.util.ArrayList;
import java.util.List;

class C2875a {
    private /* synthetic */ int f9462a;
    private /* synthetic */ String f9463b;
    private /* synthetic */ String f9464c;
    /* synthetic */ List<MessageTagDefine> f9465d = new ArrayList();

    public void addMessageData(MessageTagDefine messageTagDefine) {
        this.f9465d.add(messageTagDefine);
    }

    public String getDesc() {
        return this.f9463b;
    }

    public int getMessageCode() {
        return this.f9462a;
    }

    public MessageTagDefine[] getMessageTagDefines() {
        return (MessageTagDefine[]) this.f9465d.toArray(new MessageTagDefine[0]);
    }

    public String getRetCode() {
        return this.f9464c;
    }

    public void setDesc(String str) {
        this.f9463b = str;
    }

    public void setMessageCode(int i) {
        this.f9462a = i;
    }

    public void setRetCode(String str) {
        this.f9464c = str;
    }
}
