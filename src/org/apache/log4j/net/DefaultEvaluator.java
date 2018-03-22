package org.apache.log4j.net;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;

/* compiled from: SMTPAppender */
class DefaultEvaluator implements TriggeringEventEvaluator {
    DefaultEvaluator() {
    }

    public boolean isTriggeringEvent(LoggingEvent loggingEvent) {
        return loggingEvent.getLevel().isGreaterOrEqual(Level.ERROR);
    }
}
