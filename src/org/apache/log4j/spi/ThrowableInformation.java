package org.apache.log4j.spi;

import java.io.Serializable;
import org.apache.log4j.Category;
import org.apache.log4j.DefaultThrowableRenderer;

public class ThrowableInformation implements Serializable {
    static final long serialVersionUID = -4748765566864322735L;
    private transient Category category;
    private String[] rep;
    private transient Throwable throwable;

    public ThrowableInformation(Throwable th) {
        this.throwable = th;
    }

    public ThrowableInformation(Throwable th, Category category) {
        this.throwable = th;
        this.category = category;
    }

    public ThrowableInformation(String[] strArr) {
        if (strArr != null) {
            this.rep = (String[]) strArr.clone();
        }
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public synchronized String[] getThrowableStrRep() {
        if (this.rep == null) {
            ThrowableRenderer throwableRenderer;
            if (this.category != null) {
                LoggerRepository loggerRepository = this.category.getLoggerRepository();
                if (loggerRepository instanceof ThrowableRendererSupport) {
                    throwableRenderer = ((ThrowableRendererSupport) loggerRepository).getThrowableRenderer();
                    if (throwableRenderer != null) {
                        this.rep = DefaultThrowableRenderer.render(this.throwable);
                    } else {
                        this.rep = throwableRenderer.doRender(this.throwable);
                    }
                }
            }
            throwableRenderer = null;
            if (throwableRenderer != null) {
                this.rep = throwableRenderer.doRender(this.throwable);
            } else {
                this.rep = DefaultThrowableRenderer.render(this.throwable);
            }
        }
        return (String[]) this.rep.clone();
    }
}
