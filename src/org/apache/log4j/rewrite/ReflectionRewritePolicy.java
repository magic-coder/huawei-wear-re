package org.apache.log4j.rewrite;

import com.sina.weibo.sdk.constant.WBConstants;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public class ReflectionRewritePolicy implements RewritePolicy {
    static Class class$java$lang$Object;

    public LoggingEvent rewrite(LoggingEvent loggingEvent) {
        Object message = loggingEvent.getMessage();
        if (!(message instanceof String)) {
            Map hashMap = new HashMap(loggingEvent.getProperties());
            try {
                Class class$;
                Class cls = message.getClass();
                if (class$java$lang$Object == null) {
                    class$ = class$("java.lang.Object");
                    class$java$lang$Object = class$;
                } else {
                    class$ = class$java$lang$Object;
                }
                PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(cls, class$).getPropertyDescriptors();
                if (propertyDescriptors.length > 0) {
                    Object obj = message;
                    for (int i = 0; i < propertyDescriptors.length; i++) {
                        try {
                            Object invoke = propertyDescriptors[i].getReadMethod().invoke(message, (Object[]) null);
                            if (WBConstants.ACTION_LOG_TYPE_MESSAGE.equalsIgnoreCase(propertyDescriptors[i].getName())) {
                                obj = invoke;
                            } else {
                                hashMap.put(propertyDescriptors[i].getName(), invoke);
                            }
                        } catch (Throwable e) {
                            LogLog.warn(new StringBuffer().append("Unable to evaluate property ").append(propertyDescriptors[i].getName()).toString(), e);
                        }
                    }
                    return new LoggingEvent(loggingEvent.getFQNOfLoggerClass(), loggingEvent.getLogger() != null ? loggingEvent.getLogger() : Logger.getLogger(loggingEvent.getLoggerName()), loggingEvent.getTimeStamp(), loggingEvent.getLevel(), obj, loggingEvent.getThreadName(), loggingEvent.getThrowableInformation(), loggingEvent.getNDC(), loggingEvent.getLocationInformation(), hashMap);
                }
            } catch (Throwable e2) {
                LogLog.warn("Unable to get property descriptors", e2);
            }
        }
        return loggingEvent;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
