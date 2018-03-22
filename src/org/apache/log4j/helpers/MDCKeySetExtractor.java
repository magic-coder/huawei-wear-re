package org.apache.log4j.helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Set;
import org.apache.log4j.pattern.LogEvent;
import org.apache.log4j.spi.LoggingEvent;

public final class MDCKeySetExtractor {
    public static final MDCKeySetExtractor INSTANCE = new MDCKeySetExtractor();
    static Class class$org$apache$log4j$pattern$LogEvent;
    static Class class$org$apache$log4j$spi$LoggingEvent;
    private final Method getKeySetMethod;

    private MDCKeySetExtractor() {
        Method method = null;
        try {
            Class class$;
            if (class$org$apache$log4j$spi$LoggingEvent == null) {
                class$ = class$("org.apache.log4j.spi.LoggingEvent");
                class$org$apache$log4j$spi$LoggingEvent = class$;
            } else {
                class$ = class$org$apache$log4j$spi$LoggingEvent;
            }
            method = class$.getMethod("getPropertyKeySet", null);
        } catch (Exception e) {
        }
        this.getKeySetMethod = method;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public Set getPropertyKeySet(LoggingEvent loggingEvent) throws Exception {
        if (this.getKeySetMethod != null) {
            return (Set) this.getKeySetMethod.invoke(loggingEvent, null);
        }
        Class class$;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(loggingEvent);
        objectOutputStream.close();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        if (class$org$apache$log4j$pattern$LogEvent == null) {
            class$ = class$("org.apache.log4j.pattern.LogEvent");
            class$org$apache$log4j$pattern$LogEvent = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LogEvent;
        }
        String name = class$.getName();
        if (toByteArray[6] != (byte) 0 && toByteArray[7] != name.length()) {
            return null;
        }
        Set propertyKeySet;
        for (int i = 0; i < name.length(); i++) {
            toByteArray[i + 8] = (byte) name.charAt(i);
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(toByteArray));
        Object readObject = objectInputStream.readObject();
        if (readObject instanceof LogEvent) {
            propertyKeySet = ((LogEvent) readObject).getPropertyKeySet();
        } else {
            propertyKeySet = null;
        }
        objectInputStream.close();
        return propertyKeySet;
    }
}
