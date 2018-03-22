package org.apache.log4j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.DefaultRepositorySelector;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.NOPLoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.apache.log4j.spi.RootLogger;

public class LogManager {
    public static final String CONFIGURATOR_CLASS_KEY = "log4j.configuratorClass";
    public static final String DEFAULT_CONFIGURATION_FILE = "log4j.properties";
    public static final String DEFAULT_CONFIGURATION_KEY = "log4j.configuration";
    public static final String DEFAULT_INIT_OVERRIDE_KEY = "log4j.defaultInitOverride";
    static final String DEFAULT_XML_CONFIGURATION_FILE = "log4j.xml";
    private static Object guard = null;
    private static RepositorySelector repositorySelector = new DefaultRepositorySelector(new Hierarchy(new RootLogger(Level.DEBUG)));

    static {
        String systemProperty = OptionConverter.getSystemProperty(DEFAULT_INIT_OVERRIDE_KEY, null);
        if (systemProperty == null || "false".equalsIgnoreCase(systemProperty)) {
            URL resource;
            String systemProperty2 = OptionConverter.getSystemProperty(DEFAULT_CONFIGURATION_KEY, null);
            String systemProperty3 = OptionConverter.getSystemProperty(CONFIGURATOR_CLASS_KEY, null);
            if (systemProperty2 == null) {
                resource = Loader.getResource(DEFAULT_XML_CONFIGURATION_FILE);
                if (resource == null) {
                    resource = Loader.getResource(DEFAULT_CONFIGURATION_FILE);
                }
            } else {
                try {
                    resource = new URL(systemProperty2);
                } catch (MalformedURLException e) {
                    resource = Loader.getResource(systemProperty2);
                }
            }
            if (resource != null) {
                LogLog.debug(new StringBuffer().append("Using URL [").append(resource).append("] for automatic log4j configuration.").toString());
                try {
                    OptionConverter.selectAndConfigure(resource, systemProperty3, getLoggerRepository());
                    return;
                } catch (Throwable e2) {
                    LogLog.warn("Error during default initialization", e2);
                    return;
                }
            }
            LogLog.debug(new StringBuffer().append("Could not find resource: [").append(systemProperty2).append("].").toString());
            return;
        }
        LogLog.debug("Default initialization of overridden by log4j.defaultInitOverrideproperty.");
    }

    public static void setRepositorySelector(RepositorySelector repositorySelector, Object obj) throws IllegalArgumentException {
        if (guard != null && guard != obj) {
            throw new IllegalArgumentException("Attempted to reset the LoggerFactory without possessing the guard.");
        } else if (repositorySelector == null) {
            throw new IllegalArgumentException("RepositorySelector must be non-null.");
        } else {
            guard = obj;
            repositorySelector = repositorySelector;
        }
    }

    private static boolean isLikelySafeScenario(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().indexOf("org.apache.catalina.loader.WebappClassLoader.stop") != -1;
    }

    public static LoggerRepository getLoggerRepository() {
        if (repositorySelector == null) {
            repositorySelector = new DefaultRepositorySelector(new NOPLoggerRepository());
            guard = null;
            Throwable illegalStateException = new IllegalStateException("Class invariant violation");
            String str = "log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.";
            if (isLikelySafeScenario(illegalStateException)) {
                LogLog.debug(str, illegalStateException);
            } else {
                LogLog.error(str, illegalStateException);
            }
        }
        return repositorySelector.getLoggerRepository();
    }

    public static Logger getRootLogger() {
        return getLoggerRepository().getRootLogger();
    }

    public static Logger getLogger(String str) {
        return getLoggerRepository().getLogger(str);
    }

    public static Logger getLogger(Class cls) {
        return getLoggerRepository().getLogger(cls.getName());
    }

    public static Logger getLogger(String str, LoggerFactory loggerFactory) {
        return getLoggerRepository().getLogger(str, loggerFactory);
    }

    public static Logger exists(String str) {
        return getLoggerRepository().exists(str);
    }

    public static Enumeration getCurrentLoggers() {
        return getLoggerRepository().getCurrentLoggers();
    }

    public static void shutdown() {
        getLoggerRepository().shutdown();
    }

    public static void resetConfiguration() {
        getLoggerRepository().resetConfiguration();
    }
}
