package org.apache.log4j.helpers;

import java.io.File;

public abstract class FileWatchdog extends Thread {
    public static final long DEFAULT_DELAY = 60000;
    protected long delay = DEFAULT_DELAY;
    File file;
    protected String filename;
    boolean interrupted = false;
    long lastModif = 0;
    boolean warnedAlready = false;

    protected abstract void doOnChange();

    protected FileWatchdog(String str) {
        super("FileWatchdog");
        this.filename = str;
        this.file = new File(str);
        setDaemon(true);
        checkAndConfigure();
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    protected void checkAndConfigure() {
        try {
            if (this.file.exists()) {
                long lastModified = this.file.lastModified();
                if (lastModified > this.lastModif) {
                    this.lastModif = lastModified;
                    doOnChange();
                    this.warnedAlready = false;
                }
            } else if (!this.warnedAlready) {
                LogLog.debug(new StringBuffer().append("[").append(this.filename).append("] does not exist.").toString());
                this.warnedAlready = true;
            }
        } catch (SecurityException e) {
            LogLog.warn(new StringBuffer().append("Was not allowed to read check file existance, file:[").append(this.filename).append("].").toString());
            this.interrupted = true;
        }
    }

    public void run() {
        while (!this.interrupted) {
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
            }
            checkAndConfigure();
        }
    }
}
