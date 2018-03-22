package org.apache.log4j.helpers;

public class FormattingInfo {
    boolean leftAlign = false;
    int max = Integer.MAX_VALUE;
    int min = -1;

    void reset() {
        this.min = -1;
        this.max = Integer.MAX_VALUE;
        this.leftAlign = false;
    }

    void dump() {
        LogLog.debug(new StringBuffer().append("min=").append(this.min).append(", max=").append(this.max).append(", leftAlign=").append(this.leftAlign).toString());
    }
}
