package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public class DailyRollingFileAppender extends FileAppender {
    static final int HALF_DAY = 2;
    static final int TOP_OF_DAY = 3;
    static final int TOP_OF_HOUR = 1;
    static final int TOP_OF_MINUTE = 0;
    static final int TOP_OF_MONTH = 5;
    static final int TOP_OF_TROUBLE = -1;
    static final int TOP_OF_WEEK = 4;
    static final TimeZone gmtTimeZone = TimeZone.getTimeZone("GMT");
    int checkPeriod = -1;
    private String datePattern = "'.'yyyy-MM-dd";
    private long nextCheck = (System.currentTimeMillis() - 1);
    Date now = new Date();
    RollingCalendar rc = new RollingCalendar();
    private String scheduledFilename;
    SimpleDateFormat sdf;

    public DailyRollingFileAppender(Layout layout, String str, String str2) throws IOException {
        super(layout, str, true);
        this.datePattern = str2;
        activateOptions();
    }

    public void setDatePattern(String str) {
        this.datePattern = str;
    }

    public String getDatePattern() {
        return this.datePattern;
    }

    public void activateOptions() {
        super.activateOptions();
        if (this.datePattern == null || this.fileName == null) {
            LogLog.error(new StringBuffer().append("Either File or DatePattern options are not set for appender [").append(this.name).append("].").toString());
            return;
        }
        this.now.setTime(System.currentTimeMillis());
        this.sdf = new SimpleDateFormat(this.datePattern);
        int computeCheckPeriod = computeCheckPeriod();
        printPeriodicity(computeCheckPeriod);
        this.rc.setType(computeCheckPeriod);
        this.scheduledFilename = new StringBuffer().append(this.fileName).append(this.sdf.format(new Date(new File(this.fileName).lastModified()))).toString();
    }

    void printPeriodicity(int i) {
        switch (i) {
            case 0:
                LogLog.debug(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled every minute.").toString());
                return;
            case 1:
                LogLog.debug(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled on top of every hour.").toString());
                return;
            case 2:
                LogLog.debug(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at midday and midnight.").toString());
                return;
            case 3:
                LogLog.debug(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at midnight.").toString());
                return;
            case 4:
                LogLog.debug(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at start of week.").toString());
                return;
            case 5:
                LogLog.debug(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at start of every month.").toString());
                return;
            default:
                LogLog.warn(new StringBuffer().append("Unknown periodicity for appender [").append(this.name).append("].").toString());
                return;
        }
    }

    int computeCheckPeriod() {
        RollingCalendar rollingCalendar = new RollingCalendar(gmtTimeZone, Locale.getDefault());
        Date date = new Date(0);
        if (this.datePattern != null) {
            for (int i = 0; i <= 5; i++) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern);
                simpleDateFormat.setTimeZone(gmtTimeZone);
                String format = simpleDateFormat.format(date);
                rollingCalendar.setType(i);
                String format2 = simpleDateFormat.format(new Date(rollingCalendar.getNextCheckMillis(date)));
                if (format != null && format2 != null && !format.equals(format2)) {
                    return i;
                }
            }
        }
        return -1;
    }

    void rollOver() throws IOException {
        if (this.datePattern == null) {
            this.errorHandler.error("Missing DatePattern option in rollOver().");
            return;
        }
        String stringBuffer = new StringBuffer().append(this.fileName).append(this.sdf.format(this.now)).toString();
        if (!this.scheduledFilename.equals(stringBuffer)) {
            closeFile();
            File file = new File(this.scheduledFilename);
            if (file.exists()) {
                file.delete();
            }
            if (new File(this.fileName).renameTo(file)) {
                LogLog.debug(new StringBuffer().append(this.fileName).append(" -> ").append(this.scheduledFilename).toString());
            } else {
                LogLog.error(new StringBuffer().append("Failed to rename [").append(this.fileName).append("] to [").append(this.scheduledFilename).append("].").toString());
            }
            try {
                setFile(this.fileName, true, this.bufferedIO, this.bufferSize);
            } catch (IOException e) {
                this.errorHandler.error(new StringBuffer().append("setFile(").append(this.fileName).append(", true) call failed.").toString());
            }
            this.scheduledFilename = stringBuffer;
        }
    }

    protected void subAppend(LoggingEvent loggingEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= this.nextCheck) {
            this.now.setTime(currentTimeMillis);
            this.nextCheck = this.rc.getNextCheckMillis(this.now);
            try {
                rollOver();
            } catch (Throwable e) {
                if (e instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error("rollOver() failed.", e);
            }
        }
        super.subAppend(loggingEvent);
    }
}
