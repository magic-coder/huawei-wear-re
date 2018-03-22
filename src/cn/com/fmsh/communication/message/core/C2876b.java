package cn.com.fmsh.communication.message.core;

import cn.com.fmsh.communication.message.enumerate.ETagType;
import java.util.ArrayList;
import java.util.List;

class C2876b {
    private /* synthetic */ byte f9466a;
    private /* synthetic */ int f9467b;
    private /* synthetic */ ETagType f9468c;
    private /* synthetic */ String f9469d;
    private /* synthetic */ List<C2877c> f9470e = new ArrayList();

    public void addTagItem(C2877c c2877c) {
        if (c2877c != null) {
            this.f9470e.add(c2877c);
        }
    }

    public String getDesc() {
        return this.f9469d;
    }

    public byte getId() {
        return this.f9466a;
    }

    public int getLength() {
        return this.f9467b;
    }

    public C2877c[] getTagItemDefines() {
        return (C2877c[]) this.f9470e.toArray(new C2877c[0]);
    }

    public ETagType getType() {
        return this.f9468c;
    }

    public void setDesc(String str) {
        this.f9469d = str;
    }

    public void setId(byte b) {
        this.f9466a = b;
    }

    public void setLength(int i) {
        this.f9467b = i;
    }

    public void setType(ETagType eTagType) {
        this.f9468c = eTagType;
    }
}
