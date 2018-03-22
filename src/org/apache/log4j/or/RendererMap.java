package org.apache.log4j.or;

import java.util.Hashtable;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.RendererSupport;

public class RendererMap {
    static Class class$org$apache$log4j$or$ObjectRenderer;
    static ObjectRenderer defaultRenderer = new DefaultRenderer();
    Hashtable map = new Hashtable();

    public static void addRenderer(RendererSupport rendererSupport, String str, String str2) {
        Class class$;
        LogLog.debug(new StringBuffer().append("Rendering class: [").append(str2).append("], Rendered class: [").append(str).append("].").toString());
        if (class$org$apache$log4j$or$ObjectRenderer == null) {
            class$ = class$("org.apache.log4j.or.ObjectRenderer");
            class$org$apache$log4j$or$ObjectRenderer = class$;
        } else {
            class$ = class$org$apache$log4j$or$ObjectRenderer;
        }
        ObjectRenderer objectRenderer = (ObjectRenderer) OptionConverter.instantiateByClassName(str2, class$, null);
        if (objectRenderer == null) {
            LogLog.error(new StringBuffer().append("Could not instantiate renderer [").append(str2).append("].").toString());
            return;
        }
        try {
            rendererSupport.setRenderer(Loader.loadClass(str), objectRenderer);
        } catch (Throwable e) {
            LogLog.error(new StringBuffer().append("Could not find class [").append(str).append("].").toString(), e);
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public String findAndRender(Object obj) {
        if (obj == null) {
            return null;
        }
        return get(obj.getClass()).doRender(obj);
    }

    public ObjectRenderer get(Object obj) {
        if (obj == null) {
            return null;
        }
        return get(obj.getClass());
    }

    public ObjectRenderer get(Class cls) {
        while (cls != null) {
            ObjectRenderer objectRenderer = (ObjectRenderer) this.map.get(cls);
            if (objectRenderer != null) {
                return objectRenderer;
            }
            objectRenderer = searchInterfaces(cls);
            if (objectRenderer != null) {
                return objectRenderer;
            }
            cls = cls.getSuperclass();
        }
        return defaultRenderer;
    }

    ObjectRenderer searchInterfaces(Class cls) {
        ObjectRenderer objectRenderer = (ObjectRenderer) this.map.get(cls);
        if (objectRenderer != null) {
            return objectRenderer;
        }
        Class[] interfaces = cls.getInterfaces();
        for (Class searchInterfaces : interfaces) {
            ObjectRenderer searchInterfaces2 = searchInterfaces(searchInterfaces);
            if (searchInterfaces2 != null) {
                return searchInterfaces2;
            }
        }
        return null;
    }

    public ObjectRenderer getDefaultRenderer() {
        return defaultRenderer;
    }

    public void clear() {
        this.map.clear();
    }

    public void put(Class cls, ObjectRenderer objectRenderer) {
        this.map.put(cls, objectRenderer);
    }
}
