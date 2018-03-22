package org.apache.log4j.lf5;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerRepository;

public class DefaultLF5Configurator implements Configurator {
    static Class class$org$apache$log4j$lf5$DefaultLF5Configurator;

    private DefaultLF5Configurator() {
    }

    public static void configure() throws IOException {
        Class class$;
        String str = "/org/apache/log4j/lf5/config/defaultconfig.properties";
        if (class$org$apache$log4j$lf5$DefaultLF5Configurator == null) {
            class$ = class$("org.apache.log4j.lf5.DefaultLF5Configurator");
            class$org$apache$log4j$lf5$DefaultLF5Configurator = class$;
        } else {
            class$ = class$org$apache$log4j$lf5$DefaultLF5Configurator;
        }
        URL resource = class$.getResource(str);
        if (resource != null) {
            PropertyConfigurator.configure(resource);
            return;
        }
        throw new IOException(new StringBuffer().append("Error: Unable to open the resource").append(str).toString());
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public void doConfigure(InputStream inputStream, LoggerRepository loggerRepository) {
        throw new IllegalStateException("This class should NOT be instantiated!");
    }

    public void doConfigure(URL url, LoggerRepository loggerRepository) {
        throw new IllegalStateException("This class should NOT be instantiated!");
    }
}
