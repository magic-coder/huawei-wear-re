package cn.com.fmsh.communication.message.tagvalue;

import cn.com.fmsh.communication.message.enumerate.ETagType;
import java.util.HashMap;
import java.util.Map;

public class HandlerFactory {
    private static /* synthetic */ HandlerFactory f9486a;
    private /* synthetic */ Map<ETagType, StringValueHandler> f9487b = new HashMap();

    private /* synthetic */ HandlerFactory() {
        m13018a();
    }

    private final /* synthetic */ void m13018a() {
        this.f9487b.put(ETagType.S, new StringValueHandler4asc());
        this.f9487b.put(ETagType.N, new StringValueHandler4cn());
        this.f9487b.put(ETagType.U, new StringValueHandler4utf());
        this.f9487b.put(ETagType.H, new StringValueHandler4hex());
        this.f9487b.put(ETagType.G, new StringValueHandler4gbk());
    }

    public static HandlerFactory instance() {
        if (f9486a == null) {
            f9486a = new HandlerFactory();
        }
        return f9486a;
    }

    public StringValueHandler getStringValueHandle(ETagType eTagType) {
        return (StringValueHandler) this.f9487b.get(eTagType);
    }
}
