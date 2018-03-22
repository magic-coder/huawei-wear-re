package org.apache.log4j;

import org.apache.log4j.spi.LoggerFactory;

class DefaultCategoryFactory implements LoggerFactory {
    DefaultCategoryFactory() {
    }

    public Logger makeNewLoggerInstance(String str) {
        return new Logger(str);
    }
}
