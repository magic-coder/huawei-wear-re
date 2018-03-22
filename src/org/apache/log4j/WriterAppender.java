package org.apache.log4j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

public class WriterAppender extends AppenderSkeleton {
    protected String encoding;
    protected boolean immediateFlush;
    protected QuietWriter qw;

    public WriterAppender() {
        this.immediateFlush = true;
    }

    public WriterAppender(Layout layout, OutputStream outputStream) {
        this(layout, new OutputStreamWriter(outputStream));
    }

    public WriterAppender(Layout layout, Writer writer) {
        this.immediateFlush = true;
        this.layout = layout;
        setWriter(writer);
    }

    public void setImmediateFlush(boolean z) {
        this.immediateFlush = z;
    }

    public boolean getImmediateFlush() {
        return this.immediateFlush;
    }

    public void activateOptions() {
    }

    public void append(LoggingEvent loggingEvent) {
        if (checkEntryConditions()) {
            subAppend(loggingEvent);
        }
    }

    protected boolean checkEntryConditions() {
        if (this.closed) {
            LogLog.warn("Not allowed to write to a closed appender.");
            return false;
        } else if (this.qw == null) {
            this.errorHandler.error(new StringBuffer().append("No output stream or file set for the appender named [").append(this.name).append("].").toString());
            return false;
        } else if (this.layout != null) {
            return true;
        } else {
            this.errorHandler.error(new StringBuffer().append("No layout set for the appender named [").append(this.name).append("].").toString());
            return false;
        }
    }

    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            writeFooter();
            reset();
        }
    }

    protected void closeWriter() {
        if (this.qw != null) {
            try {
                this.qw.close();
            } catch (Throwable e) {
                if (e instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error(new StringBuffer().append("Could not close ").append(this.qw).toString(), e);
            }
        }
    }

    protected OutputStreamWriter createWriter(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter;
        String encoding = getEncoding();
        if (encoding != null) {
            try {
                outputStreamWriter = new OutputStreamWriter(outputStream, encoding);
            } catch (IOException e) {
                if (e instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.warn("Error initializing output writer.");
                LogLog.warn("Unsupported encoding?");
            }
            if (outputStreamWriter != null) {
                return new OutputStreamWriter(outputStream);
            }
            return outputStreamWriter;
        }
        outputStreamWriter = null;
        if (outputStreamWriter != null) {
            return outputStreamWriter;
        }
        return new OutputStreamWriter(outputStream);
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public synchronized void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            LogLog.warn("You have tried to set a null error-handler.");
        } else {
            this.errorHandler = errorHandler;
            if (this.qw != null) {
                this.qw.setErrorHandler(errorHandler);
            }
        }
    }

    public synchronized void setWriter(Writer writer) {
        reset();
        this.qw = new QuietWriter(writer, this.errorHandler);
        writeHeader();
    }

    protected void subAppend(LoggingEvent loggingEvent) {
        this.qw.write(this.layout.format(loggingEvent));
        if (this.layout.ignoresThrowable()) {
            String[] throwableStrRep = loggingEvent.getThrowableStrRep();
            if (throwableStrRep != null) {
                for (String write : throwableStrRep) {
                    this.qw.write(write);
                    this.qw.write(Layout.LINE_SEP);
                }
            }
        }
        if (shouldFlush(loggingEvent)) {
            this.qw.flush();
        }
    }

    public boolean requiresLayout() {
        return true;
    }

    protected void reset() {
        closeWriter();
        this.qw = null;
    }

    protected void writeFooter() {
        if (this.layout != null) {
            String footer = this.layout.getFooter();
            if (footer != null && this.qw != null) {
                this.qw.write(footer);
                this.qw.flush();
            }
        }
    }

    protected void writeHeader() {
        if (this.layout != null) {
            String header = this.layout.getHeader();
            if (header != null && this.qw != null) {
                this.qw.write(header);
            }
        }
    }

    protected boolean shouldFlush(LoggingEvent loggingEvent) {
        return this.immediateFlush;
    }
}
