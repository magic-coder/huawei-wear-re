package org.apache.log4j.rewrite;

import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

public class MapRewritePolicy implements RewritePolicy {
    public LoggingEvent rewrite(LoggingEvent loggingEvent) {
        Object message = loggingEvent.getMessage();
        if (!(message instanceof Map)) {
            return loggingEvent;
        }
        Map hashMap = new HashMap(loggingEvent.getProperties());
        Map map = (Map) message;
        Object obj = map.get(WBConstants.ACTION_LOG_TYPE_MESSAGE);
        if (obj == null) {
            obj = message;
        }
        for (Entry entry : map.entrySet()) {
            if (!WBConstants.ACTION_LOG_TYPE_MESSAGE.equals(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new LoggingEvent(loggingEvent.getFQNOfLoggerClass(), loggingEvent.getLogger() != null ? loggingEvent.getLogger() : Logger.getLogger(loggingEvent.getLoggerName()), loggingEvent.getTimeStamp(), loggingEvent.getLevel(), obj, loggingEvent.getThreadName(), loggingEvent.getThrowableInformation(), loggingEvent.getNDC(), loggingEvent.getLocationInformation(), hashMap);
    }
}
