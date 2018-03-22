package org.apache.log4j.helpers;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerRepository;

public class OptionConverter {
    static String DELIM_START = "${";
    static int DELIM_START_LEN = 2;
    static char DELIM_STOP = '}';
    static int DELIM_STOP_LEN = 1;
    static Class class$java$lang$String;
    static Class class$org$apache$log4j$Level;
    static Class class$org$apache$log4j$spi$Configurator;

    private OptionConverter() {
    }

    public static String[] concatanateArrays(String[] strArr, String[] strArr2) {
        Object obj = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        System.arraycopy(strArr2, 0, obj, strArr.length, strArr2.length);
        return obj;
    }

    public static String convertSpecialChars(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            char charAt;
            int i2 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 == '\\') {
                i = i2 + 1;
                charAt = str.charAt(i2);
                if (charAt == 'n') {
                    charAt = '\n';
                } else if (charAt == 'r') {
                    charAt = '\r';
                } else if (charAt == 't') {
                    charAt = '\t';
                } else if (charAt == 'f') {
                    charAt = '\f';
                } else if (charAt == '\b') {
                    charAt = '\b';
                } else if (charAt == '\"') {
                    charAt = '\"';
                } else if (charAt == '\'') {
                    charAt = '\'';
                } else if (charAt == '\\') {
                    charAt = '\\';
                }
            } else {
                int i3 = i2;
                charAt = charAt2;
                i = i3;
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            str2 = System.getProperty(str, str2);
        } catch (Throwable th) {
            LogLog.debug(new StringBuffer().append("Was not allowed to read system property \"").append(str).append("\".").toString());
        }
        return str2;
    }

    public static Object instantiateByKey(Properties properties, String str, Class cls, Object obj) {
        String findAndSubst = findAndSubst(str, properties);
        if (findAndSubst != null) {
            return instantiateByClassName(findAndSubst.trim(), cls, obj);
        }
        LogLog.error(new StringBuffer().append("Could not find value for key ").append(str).toString());
        return obj;
    }

    public static boolean toBoolean(String str, boolean z) {
        if (str == null) {
            return z;
        }
        String trim = str.trim();
        if ("true".equalsIgnoreCase(trim)) {
            return true;
        }
        if ("false".equalsIgnoreCase(trim)) {
            return false;
        }
        return z;
    }

    public static int toInt(String str, int i) {
        if (str != null) {
            String trim = str.trim();
            try {
                i = Integer.valueOf(trim).intValue();
            } catch (NumberFormatException e) {
                LogLog.error(new StringBuffer().append("[").append(trim).append("] is not in proper int form.").toString());
                e.printStackTrace();
            }
        }
        return i;
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        String trim = str.trim();
        int indexOf = trim.indexOf(35);
        if (indexOf != -1) {
            String substring = trim.substring(indexOf + 1);
            trim = trim.substring(0, indexOf);
            if (DateLayout.NULL_DATE_FORMAT.equalsIgnoreCase(trim)) {
                return null;
            }
            LogLog.debug(new StringBuffer().append("toLevel:class=[").append(substring).append("]").append(":pri=[").append(trim).append("]").toString());
            try {
                Class class$;
                Class loadClass = Loader.loadClass(substring);
                Class[] clsArr = new Class[2];
                if (class$java$lang$String == null) {
                    class$ = class$("java.lang.String");
                    class$java$lang$String = class$;
                } else {
                    class$ = class$java$lang$String;
                }
                clsArr[0] = class$;
                if (class$org$apache$log4j$Level == null) {
                    class$ = class$("org.apache.log4j.Level");
                    class$org$apache$log4j$Level = class$;
                } else {
                    class$ = class$org$apache$log4j$Level;
                }
                clsArr[1] = class$;
                return (Level) loadClass.getMethod("toLevel", clsArr).invoke(null, new Object[]{trim, level});
            } catch (ClassNotFoundException e) {
                LogLog.warn(new StringBuffer().append("custom level class [").append(substring).append("] not found.").toString());
                return level;
            } catch (Throwable e2) {
                LogLog.warn(new StringBuffer().append("custom level class [").append(substring).append("]").append(" does not have a class function toLevel(String, Level)").toString(), e2);
                return level;
            } catch (Throwable e22) {
                if ((e22.getTargetException() instanceof InterruptedException) || (e22.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                LogLog.warn(new StringBuffer().append("custom level class [").append(substring).append("]").append(" could not be instantiated").toString(), e22);
                return level;
            } catch (Throwable e222) {
                LogLog.warn(new StringBuffer().append("class [").append(substring).append("] is not a subclass of org.apache.log4j.Level").toString(), e222);
                return level;
            } catch (Throwable e2222) {
                LogLog.warn(new StringBuffer().append("class [").append(substring).append("] cannot be instantiated due to access restrictions").toString(), e2222);
                return level;
            } catch (Throwable e22222) {
                LogLog.warn(new StringBuffer().append("class [").append(substring).append("], level [").append(trim).append("] conversion failed.").toString(), e22222);
                return level;
            }
        } else if (DateLayout.NULL_DATE_FORMAT.equalsIgnoreCase(trim)) {
            return null;
        } else {
            return Level.toLevel(trim, level);
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static long toFileSize(String str, long j) {
        if (str == null) {
            return j;
        }
        String toUpperCase = str.trim().toUpperCase();
        long j2 = 1;
        int indexOf = toUpperCase.indexOf("KB");
        if (indexOf != -1) {
            j2 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            toUpperCase = toUpperCase.substring(0, indexOf);
        } else {
            indexOf = toUpperCase.indexOf("MB");
            if (indexOf != -1) {
                j2 = 1048576;
                toUpperCase = toUpperCase.substring(0, indexOf);
            } else {
                indexOf = toUpperCase.indexOf("GB");
                if (indexOf != -1) {
                    j2 = 1073741824;
                    toUpperCase = toUpperCase.substring(0, indexOf);
                }
            }
        }
        if (toUpperCase == null) {
            return j;
        }
        try {
            return Long.valueOf(toUpperCase).longValue() * j2;
        } catch (Throwable e) {
            LogLog.error(new StringBuffer().append("[").append(toUpperCase).append("] is not in proper int form.").toString());
            LogLog.error(new StringBuffer().append("[").append(str).append("] not in expected format.").toString(), e);
            return j;
        }
    }

    public static String findAndSubst(String str, Properties properties) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        try {
            return substVars(property, properties);
        } catch (Throwable e) {
            LogLog.error(new StringBuffer().append("Bad option value [").append(property).append("].").toString(), e);
            return property;
        }
    }

    public static Object instantiateByClassName(String str, Class cls, Object obj) {
        if (str != null) {
            try {
                Class loadClass = Loader.loadClass(str);
                if (cls.isAssignableFrom(loadClass)) {
                    obj = loadClass.newInstance();
                } else {
                    LogLog.error(new StringBuffer().append("A \"").append(str).append("\" object is not assignable to a \"").append(cls.getName()).append("\" variable.").toString());
                    LogLog.error(new StringBuffer().append("The class \"").append(cls.getName()).append("\" was loaded by ").toString());
                    LogLog.error(new StringBuffer().append("[").append(cls.getClassLoader()).append("] whereas object of type ").toString());
                    LogLog.error(new StringBuffer().append("\"").append(loadClass.getName()).append("\" was loaded by [").append(loadClass.getClassLoader()).append("].").toString());
                }
            } catch (Throwable e) {
                LogLog.error(new StringBuffer().append("Could not instantiate class [").append(str).append("].").toString(), e);
            } catch (Throwable e2) {
                LogLog.error(new StringBuffer().append("Could not instantiate class [").append(str).append("].").toString(), e2);
            } catch (Throwable e22) {
                LogLog.error(new StringBuffer().append("Could not instantiate class [").append(str).append("].").toString(), e22);
            } catch (Throwable e222) {
                LogLog.error(new StringBuffer().append("Could not instantiate class [").append(str).append("].").toString(), e222);
            }
        }
        return obj;
    }

    public static String substVars(String str, Properties properties) throws IllegalArgumentException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(DELIM_START, i);
            if (indexOf == -1) {
                break;
            }
            stringBuffer.append(str.substring(i, indexOf));
            int indexOf2 = str.indexOf(DELIM_STOP, indexOf);
            if (indexOf2 == -1) {
                throw new IllegalArgumentException(new StringBuffer().append('\"').append(str).append("\" has no closing brace. Opening brace at position ").append(indexOf).append('.').toString());
            }
            String substring = str.substring(DELIM_START_LEN + indexOf, indexOf2);
            String systemProperty = getSystemProperty(substring, null);
            if (systemProperty == null && properties != null) {
                systemProperty = properties.getProperty(substring);
            }
            if (systemProperty != null) {
                stringBuffer.append(substVars(systemProperty, properties));
            }
            i = DELIM_STOP_LEN + indexOf2;
        }
        if (i == 0) {
            return str;
        }
        stringBuffer.append(str.substring(i, str.length()));
        return stringBuffer.toString();
    }

    public static void selectAndConfigure(InputStream inputStream, String str, LoggerRepository loggerRepository) {
        Configurator configurator;
        if (str != null) {
            Class class$;
            LogLog.debug(new StringBuffer().append("Preferred configurator class: ").append(str).toString());
            if (class$org$apache$log4j$spi$Configurator == null) {
                class$ = class$("org.apache.log4j.spi.Configurator");
                class$org$apache$log4j$spi$Configurator = class$;
            } else {
                class$ = class$org$apache$log4j$spi$Configurator;
            }
            configurator = (Configurator) instantiateByClassName(str, class$, null);
            if (configurator == null) {
                LogLog.error(new StringBuffer().append("Could not instantiate configurator [").append(str).append("].").toString());
                return;
            }
        }
        configurator = new PropertyConfigurator();
        configurator.doConfigure(inputStream, loggerRepository);
    }

    public static void selectAndConfigure(URL url, String str, LoggerRepository loggerRepository) {
        Configurator configurator;
        String file = url.getFile();
        if (str == null && file != null && file.endsWith(".xml")) {
            str = "org.apache.log4j.xml.DOMConfigurator";
        }
        if (str != null) {
            Class class$;
            LogLog.debug(new StringBuffer().append("Preferred configurator class: ").append(str).toString());
            if (class$org$apache$log4j$spi$Configurator == null) {
                class$ = class$("org.apache.log4j.spi.Configurator");
                class$org$apache$log4j$spi$Configurator = class$;
            } else {
                class$ = class$org$apache$log4j$spi$Configurator;
            }
            configurator = (Configurator) instantiateByClassName(str, class$, null);
            if (configurator == null) {
                LogLog.error(new StringBuffer().append("Could not instantiate configurator [").append(str).append("].").toString());
                return;
            }
        }
        configurator = new PropertyConfigurator();
        configurator.doConfigure(url, loggerRepository);
    }
}
