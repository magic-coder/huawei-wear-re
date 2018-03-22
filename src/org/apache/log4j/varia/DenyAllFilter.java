package org.apache.log4j.varia;

import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class DenyAllFilter extends Filter {
    public String[] getOptionStrings() {
        return null;
    }

    public void setOption(String str, String str2) {
    }

    public int decide(LoggingEvent loggingEvent) {
        return -1;
    }
}
