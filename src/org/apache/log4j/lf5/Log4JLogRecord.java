package org.apache.log4j.lf5;

import org.apache.log4j.spi.ThrowableInformation;

public class Log4JLogRecord extends LogRecord {
    public boolean isSevereLevel() {
        if (LogLevel.ERROR.equals(getLevel()) || LogLevel.FATAL.equals(getLevel())) {
            return true;
        }
        return false;
    }

    public void setThrownStackTrace(ThrowableInformation throwableInformation) {
        String[] throwableStrRep = throwableInformation.getThrowableStrRep();
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : throwableStrRep) {
            stringBuffer.append(new StringBuffer().append(append).append("\n").toString());
        }
        this._thrownStackTrace = stringBuffer.toString();
    }
}
