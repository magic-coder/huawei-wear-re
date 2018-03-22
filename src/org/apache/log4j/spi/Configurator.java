package org.apache.log4j.spi;

import java.io.InputStream;
import java.net.URL;

public interface Configurator {
    public static final String INHERITED = "inherited";
    public static final String NULL = "null";

    void doConfigure(InputStream inputStream, LoggerRepository loggerRepository);

    void doConfigure(URL url, LoggerRepository loggerRepository);
}
