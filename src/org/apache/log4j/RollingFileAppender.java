package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Writer;
import org.apache.log4j.helpers.CountingQuietWriter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.LoggingEvent;

public class RollingFileAppender extends FileAppender {
    protected int maxBackupIndex = 1;
    protected long maxFileSize = 10485760;
    private long nextRollover = 0;

    public RollingFileAppender(Layout layout, String str, boolean z) throws IOException {
        super(layout, str, z);
    }

    public RollingFileAppender(Layout layout, String str) throws IOException {
        super(layout, str);
    }

    public int getMaxBackupIndex() {
        return this.maxBackupIndex;
    }

    public long getMaximumFileSize() {
        return this.maxFileSize;
    }

    public void rollOver() {
        boolean delete;
        if (this.qw != null) {
            long count = ((CountingQuietWriter) this.qw).getCount();
            LogLog.debug(new StringBuffer().append("rolling over count=").append(count).toString());
            this.nextRollover = count + this.maxFileSize;
        }
        LogLog.debug(new StringBuffer().append("maxBackupIndex=").append(this.maxBackupIndex).toString());
        if (this.maxBackupIndex > 0) {
            File file = new File(new StringBuffer().append(this.fileName).append('.').append(this.maxBackupIndex).toString());
            if (file.exists()) {
                delete = file.delete();
            } else {
                delete = true;
            }
            for (int i = this.maxBackupIndex - 1; i >= 1 && delete; i--) {
                File file2 = new File(new StringBuffer().append(this.fileName).append(".").append(i).toString());
                if (file2.exists()) {
                    file = new File(new StringBuffer().append(this.fileName).append('.').append(i + 1).toString());
                    LogLog.debug(new StringBuffer().append("Renaming file ").append(file2).append(" to ").append(file).toString());
                    delete = file2.renameTo(file);
                }
            }
            if (delete) {
                file = new File(new StringBuffer().append(this.fileName).append(".").append(1).toString());
                closeFile();
                File file3 = new File(this.fileName);
                LogLog.debug(new StringBuffer().append("Renaming file ").append(file3).append(" to ").append(file).toString());
                boolean renameTo = file3.renameTo(file);
                if (!renameTo) {
                    try {
                        setFile(this.fileName, true, this.bufferedIO, this.bufferSize);
                        delete = renameTo;
                    } catch (Throwable e) {
                        if (e instanceof InterruptedIOException) {
                            Thread.currentThread().interrupt();
                        }
                        LogLog.error(new StringBuffer().append("setFile(").append(this.fileName).append(", true) call failed.").toString(), e);
                    }
                }
                delete = renameTo;
            }
        } else {
            delete = true;
        }
        if (delete) {
            try {
                setFile(this.fileName, false, this.bufferedIO, this.bufferSize);
                this.nextRollover = 0;
            } catch (Throwable e2) {
                if (e2 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error(new StringBuffer().append("setFile(").append(this.fileName).append(", false) call failed.").toString(), e2);
            }
        }
    }

    public synchronized void setFile(String str, boolean z, boolean z2, int i) throws IOException {
        super.setFile(str, z, this.bufferedIO, this.bufferSize);
        if (z) {
            ((CountingQuietWriter) this.qw).setCount(new File(str).length());
        }
    }

    public void setMaxBackupIndex(int i) {
        this.maxBackupIndex = i;
    }

    public void setMaximumFileSize(long j) {
        this.maxFileSize = j;
    }

    public void setMaxFileSize(String str) {
        this.maxFileSize = OptionConverter.toFileSize(str, this.maxFileSize + 1);
    }

    protected void setQWForFiles(Writer writer) {
        this.qw = new CountingQuietWriter(writer, this.errorHandler);
    }

    protected void subAppend(LoggingEvent loggingEvent) {
        super.subAppend(loggingEvent);
        if (this.fileName != null && this.qw != null) {
            long count = ((CountingQuietWriter) this.qw).getCount();
            if (count >= this.maxFileSize && count >= this.nextRollover) {
                rollOver();
            }
        }
    }
}
