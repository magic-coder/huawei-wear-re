package com.tencent.open;

import com.tencent.open.p541a.C6367n;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ProGuard */
public class C6414i {
    public void m29270a(String str, List<String> list, C6419h c6419h) {
        Method method = null;
        for (Method method2 : getClass().getDeclaredMethods()) {
            if (method2.getName().equals(str) && method2.getParameterTypes().length == list.size()) {
                method = method2;
                break;
            }
        }
        if (method != null) {
            try {
                Object invoke;
                switch (list.size()) {
                    case 0:
                        invoke = method.invoke(this, new Object[0]);
                        break;
                    case 1:
                        invoke = method.invoke(this, new Object[]{list.get(0)});
                        break;
                    case 2:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1)});
                        break;
                    case 3:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2)});
                        break;
                    case 4:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3)});
                        break;
                    case 5:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)});
                        break;
                    default:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)});
                        break;
                }
                Class returnType = method.getReturnType();
                C6367n.m29107b("openSDK_LOG.JsBridge", "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
                if ("void".equals(returnType.getName()) || returnType == Void.class) {
                    if (c6419h != null) {
                        c6419h.mo5339a(null);
                    }
                } else if (c6419h != null && mo5335a()) {
                    c6419h.mo5340a(invoke != null ? invoke.toString() : null);
                }
            } catch (Throwable e) {
                C6367n.m29108b("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                if (c6419h != null) {
                    c6419h.mo5338a();
                }
            }
        } else if (c6419h != null) {
            c6419h.mo5338a();
        }
    }

    public boolean mo5335a() {
        return false;
    }
}
