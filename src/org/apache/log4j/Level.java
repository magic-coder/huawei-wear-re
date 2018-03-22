package org.apache.log4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.apache.http.client.methods.HttpTrace;

public class Level extends Priority implements Serializable {
    public static final Level ALL = new Level(Integer.MIN_VALUE, "ALL", 7);
    public static final Level DEBUG = new Level(10000, "DEBUG", 7);
    public static final Level ERROR = new Level(Priority.ERROR_INT, "ERROR", 3);
    public static final Level FATAL = new Level(50000, "FATAL", 0);
    public static final Level INFO = new Level(20000, "INFO", 6);
    public static final Level OFF = new Level(Integer.MAX_VALUE, "OFF", 0);
    public static final Level TRACE = new Level(5000, HttpTrace.METHOD_NAME, 7);
    public static final int TRACE_INT = 5000;
    public static final Level WARN = new Level(30000, "WARN", 4);
    static Class class$org$apache$log4j$Level = null;
    static final long serialVersionUID = 3491141966387921974L;

    protected Level(int i, String str, int i2) {
        super(i, str, i2);
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level toLevel(int i) {
        return toLevel(i, DEBUG);
    }

    public static Level toLevel(int i, Level level) {
        switch (i) {
            case Integer.MIN_VALUE:
                return ALL;
            case 5000:
                return TRACE;
            case 10000:
                return DEBUG;
            case 20000:
                return INFO;
            case 30000:
                return WARN;
            case Priority.ERROR_INT /*40000*/:
                return ERROR;
            case 50000:
                return FATAL;
            case Integer.MAX_VALUE:
                return OFF;
            default:
                return level;
        }
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        String toUpperCase = str.toUpperCase();
        if (toUpperCase.equals("ALL")) {
            return ALL;
        }
        if (toUpperCase.equals("DEBUG")) {
            return DEBUG;
        }
        if (toUpperCase.equals("INFO")) {
            return INFO;
        }
        if (toUpperCase.equals("WARN")) {
            return WARN;
        }
        if (toUpperCase.equals("ERROR")) {
            return ERROR;
        }
        if (toUpperCase.equals("FATAL")) {
            return FATAL;
        }
        if (toUpperCase.equals("OFF")) {
            return OFF;
        }
        if (toUpperCase.equals(HttpTrace.METHOD_NAME)) {
            return TRACE;
        }
        if (toUpperCase.equals("İNFO")) {
            return INFO;
        }
        return level;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.level = objectInputStream.readInt();
        this.syslogEquivalent = objectInputStream.readInt();
        this.levelStr = objectInputStream.readUTF();
        if (this.levelStr == null) {
            this.levelStr = "";
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.level);
        objectOutputStream.writeInt(this.syslogEquivalent);
        objectOutputStream.writeUTF(this.levelStr);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private Object readResolve() throws ObjectStreamException {
        Class class$;
        Class cls = getClass();
        if (class$org$apache$log4j$Level == null) {
            class$ = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = class$;
        } else {
            class$ = class$org$apache$log4j$Level;
        }
        if (cls == class$) {
            return toLevel(this.level);
        }
        return this;
    }
}
