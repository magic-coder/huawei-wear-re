package org.apache.log4j.config;

public class PropertySetterException extends Exception {
    private static final long serialVersionUID = -1352613734254235861L;
    protected Throwable rootCause;

    public PropertySetterException(String str) {
        super(str);
    }

    public PropertySetterException(Throwable th) {
        this.rootCause = th;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message != null || this.rootCause == null) {
            return message;
        }
        return this.rootCause.getMessage();
    }
}
