package org.apache.log4j.lf5.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import org.apache.log4j.lf5.Log4JLogRecord;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogLevelFormatException;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;
import org.apache.log4j.lf5.viewer.LogFactor5ErrorDialog;
import org.apache.log4j.lf5.viewer.LogFactor5LoadingDialog;

public class LogFileParser implements Runnable {
    public static final String ATTRIBUTE_DELIMITER = "[slf5s.";
    public static final String CATEGORY_DELIMITER = "[slf5s.CATEGORY]";
    public static final String DATE_DELIMITER = "[slf5s.DATE]";
    public static final String LOCATION_DELIMITER = "[slf5s.LOCATION]";
    public static final String MESSAGE_DELIMITER = "[slf5s.MESSAGE]";
    public static final String NDC_DELIMITER = "[slf5s.NDC]";
    public static final String PRIORITY_DELIMITER = "[slf5s.PRIORITY]";
    public static final String RECORD_DELIMITER = "[slf5s.start]";
    public static final String THREAD_DELIMITER = "[slf5s.THREAD]";
    private static SimpleDateFormat _sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss,S");
    private InputStream _in;
    LogFactor5LoadingDialog _loadDialog;
    private LogBrokerMonitor _monitor;

    class C27761 implements Runnable {
        private final LogFileParser this$0;

        C27761(LogFileParser logFileParser) {
            this.this$0 = logFileParser;
        }

        public void run() {
            LogFileParser.access$000(this.this$0);
        }
    }

    static void access$000(LogFileParser logFileParser) {
        logFileParser.destroyDialog();
    }

    public LogFileParser(File file) throws IOException, FileNotFoundException {
        this(new FileInputStream(file));
    }

    public LogFileParser(InputStream inputStream) throws IOException {
        this._in = null;
        this._in = inputStream;
    }

    public void parse(LogBrokerMonitor logBrokerMonitor) throws RuntimeException {
        this._monitor = logBrokerMonitor;
        new Thread(this).start();
    }

    public void run() {
        Object obj = null;
        this._loadDialog = new LogFactor5LoadingDialog(this._monitor.getBaseFrame(), "Loading file...");
        try {
            LogRecord createLogRecord;
            String loadLogFile = loadLogFile(this._in);
            int i = 0;
            while (true) {
                int indexOf = loadLogFile.indexOf(RECORD_DELIMITER, i);
                if (indexOf == -1) {
                    break;
                }
                createLogRecord = createLogRecord(loadLogFile.substring(i, indexOf));
                obj = 1;
                if (createLogRecord != null) {
                    this._monitor.addMessage(createLogRecord);
                }
                i = RECORD_DELIMITER.length() + indexOf;
            }
            if (i < loadLogFile.length() && obj != null) {
                createLogRecord = createLogRecord(loadLogFile.substring(i));
                if (createLogRecord != null) {
                    this._monitor.addMessage(createLogRecord);
                }
            }
            if (obj == null) {
                throw new RuntimeException("Invalid log file format");
            }
            SwingUtilities.invokeLater(new C27761(this));
            this._in = null;
        } catch (RuntimeException e) {
            destroyDialog();
            displayError("Error - Invalid log file format.\nPlease see documentation on how to load log files.");
        } catch (IOException e2) {
            destroyDialog();
            displayError("Error - Unable to load log file!");
        }
    }

    protected void displayError(String str) {
        LogFactor5ErrorDialog logFactor5ErrorDialog = new LogFactor5ErrorDialog(this._monitor.getBaseFrame(), str);
    }

    private void destroyDialog() {
        this._loadDialog.hide();
        this._loadDialog.dispose();
    }

    private String loadLogFile(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int available = bufferedInputStream.available();
        if (available > 0) {
            stringBuffer = new StringBuffer(available);
        } else {
            stringBuffer = new StringBuffer(1024);
        }
        while (true) {
            available = bufferedInputStream.read();
            if (available != -1) {
                stringBuffer.append((char) available);
            } else {
                bufferedInputStream.close();
                return stringBuffer.toString();
            }
        }
    }

    private String parseAttribute(String str, String str2) {
        int indexOf = str2.indexOf(str);
        if (indexOf == -1) {
            return null;
        }
        return getAttribute(indexOf, str2);
    }

    private long parseDate(String str) {
        long j = 0;
        try {
            String parseAttribute = parseAttribute(DATE_DELIMITER, str);
            if (parseAttribute != null) {
                j = _sdf.parse(parseAttribute).getTime();
            }
        } catch (ParseException e) {
        }
        return j;
    }

    private LogLevel parsePriority(String str) {
        String parseAttribute = parseAttribute(PRIORITY_DELIMITER, str);
        if (parseAttribute == null) {
            return LogLevel.DEBUG;
        }
        try {
            return LogLevel.valueOf(parseAttribute);
        } catch (LogLevelFormatException e) {
            return LogLevel.DEBUG;
        }
    }

    private String parseThread(String str) {
        return parseAttribute(THREAD_DELIMITER, str);
    }

    private String parseCategory(String str) {
        return parseAttribute(CATEGORY_DELIMITER, str);
    }

    private String parseLocation(String str) {
        return parseAttribute(LOCATION_DELIMITER, str);
    }

    private String parseMessage(String str) {
        return parseAttribute(MESSAGE_DELIMITER, str);
    }

    private String parseNDC(String str) {
        return parseAttribute(NDC_DELIMITER, str);
    }

    private String parseThrowable(String str) {
        return getAttribute(str.length(), str);
    }

    private LogRecord createLogRecord(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        LogRecord log4JLogRecord = new Log4JLogRecord();
        log4JLogRecord.setMillis(parseDate(str));
        log4JLogRecord.setLevel(parsePriority(str));
        log4JLogRecord.setCategory(parseCategory(str));
        log4JLogRecord.setLocation(parseLocation(str));
        log4JLogRecord.setThreadDescription(parseThread(str));
        log4JLogRecord.setNDC(parseNDC(str));
        log4JLogRecord.setMessage(parseMessage(str));
        log4JLogRecord.setThrownStackTrace(parseThrowable(str));
        return log4JLogRecord;
    }

    private String getAttribute(int i, String str) {
        int lastIndexOf = str.lastIndexOf(ATTRIBUTE_DELIMITER, i - 1);
        if (lastIndexOf == -1) {
            return str.substring(0, i);
        }
        return str.substring(str.indexOf("]", lastIndexOf) + 1, i).trim();
    }
}
