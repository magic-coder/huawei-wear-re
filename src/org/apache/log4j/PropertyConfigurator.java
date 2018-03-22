package org.apache.log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.log4j.config.PropertySetter;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;

public class PropertyConfigurator implements Configurator {
    static final String ADDITIVITY_PREFIX = "log4j.additivity.";
    static final String APPENDER_PREFIX = "log4j.appender.";
    private static final String APPENDER_REF_TAG = "appender-ref";
    static final String CATEGORY_PREFIX = "log4j.category.";
    static final String FACTORY_PREFIX = "log4j.factory";
    private static final String INTERNAL_ROOT_NAME = "root";
    public static final String LOGGER_FACTORY_KEY = "log4j.loggerFactory";
    static final String LOGGER_PREFIX = "log4j.logger.";
    private static final String LOGGER_REF = "logger-ref";
    static final String RENDERER_PREFIX = "log4j.renderer.";
    private static final String RESET_KEY = "log4j.reset";
    static final String ROOT_CATEGORY_PREFIX = "log4j.rootCategory";
    static final String ROOT_LOGGER_PREFIX = "log4j.rootLogger";
    private static final String ROOT_REF = "root-ref";
    static final String THRESHOLD_PREFIX = "log4j.threshold";
    private static final String THROWABLE_RENDERER_PREFIX = "log4j.throwableRenderer";
    static Class class$org$apache$log4j$Appender;
    static Class class$org$apache$log4j$Layout;
    static Class class$org$apache$log4j$spi$ErrorHandler;
    static Class class$org$apache$log4j$spi$Filter;
    static Class class$org$apache$log4j$spi$LoggerFactory;
    static Class class$org$apache$log4j$spi$ThrowableRenderer;
    protected LoggerFactory loggerFactory = new DefaultCategoryFactory();
    protected Hashtable registry = new Hashtable(11);
    private LoggerRepository repository;

    public void doConfigure(String str, LoggerRepository loggerRepository) {
        FileInputStream fileInputStream;
        Throwable e;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (InterruptedIOException e2) {
                        Thread.currentThread().interrupt();
                    } catch (Throwable th) {
                    }
                }
                doConfigure(properties, loggerRepository);
            } catch (Exception e3) {
                e = e3;
                try {
                    Thread.currentThread().interrupt();
                    LogLog.error(new StringBuffer().append("Could not read configuration file [").append(str).append("].").toString(), e);
                    LogLog.error(new StringBuffer().append("Ignoring configuration file [").append(str).append("].").toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (InterruptedIOException e4) {
                            Thread.currentThread().interrupt();
                        } catch (Throwable th2) {
                        }
                    }
                } catch (Throwable th3) {
                    e = th3;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (InterruptedIOException e5) {
                            Thread.currentThread().interrupt();
                        } catch (Throwable th4) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            if ((e instanceof InterruptedIOException) || (e instanceof InterruptedException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error(new StringBuffer().append("Could not read configuration file [").append(str).append("].").toString(), e);
            LogLog.error(new StringBuffer().append("Ignoring configuration file [").append(str).append("].").toString());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th5) {
            e = th5;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e;
        }
    }

    public static void configure(String str) {
        new PropertyConfigurator().doConfigure(str, LogManager.getLoggerRepository());
    }

    public static void configure(URL url) {
        new PropertyConfigurator().doConfigure(url, LogManager.getLoggerRepository());
    }

    public static void configure(InputStream inputStream) {
        new PropertyConfigurator().doConfigure(inputStream, LogManager.getLoggerRepository());
    }

    public static void configure(Properties properties) {
        new PropertyConfigurator().doConfigure(properties, LogManager.getLoggerRepository());
    }

    public static void configureAndWatch(String str) {
        configureAndWatch(str, FileWatchdog.DEFAULT_DELAY);
    }

    public static void configureAndWatch(String str, long j) {
        PropertyWatchdog propertyWatchdog = new PropertyWatchdog(str);
        propertyWatchdog.setDelay(j);
        propertyWatchdog.start();
    }

    public void doConfigure(Properties properties, LoggerRepository loggerRepository) {
        this.repository = loggerRepository;
        String property = properties.getProperty(LogLog.DEBUG_KEY);
        if (property == null) {
            property = properties.getProperty(LogLog.CONFIG_DEBUG_KEY);
            if (property != null) {
                LogLog.warn("[log4j.configDebug] is deprecated. Use [log4j.debug] instead.");
            }
        }
        if (property != null) {
            LogLog.setInternalDebugging(OptionConverter.toBoolean(property, true));
        }
        property = properties.getProperty(RESET_KEY);
        if (property != null && OptionConverter.toBoolean(property, false)) {
            loggerRepository.resetConfiguration();
        }
        property = OptionConverter.findAndSubst(THRESHOLD_PREFIX, properties);
        if (property != null) {
            loggerRepository.setThreshold(OptionConverter.toLevel(property, Level.ALL));
            LogLog.debug(new StringBuffer().append("Hierarchy threshold set to [").append(loggerRepository.getThreshold()).append("].").toString());
        }
        configureRootCategory(properties, loggerRepository);
        configureLoggerFactory(properties);
        parseCatsAndRenderers(properties, loggerRepository);
        LogLog.debug("Finished configuring.");
        this.registry.clear();
    }

    public void doConfigure(InputStream inputStream, LoggerRepository loggerRepository) {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            doConfigure(properties, loggerRepository);
        } catch (Throwable e) {
            if (e instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            LogLog.error(new StringBuffer().append("Could not read configuration file from InputStream [").append(inputStream).append("].").toString(), e);
            LogLog.error(new StringBuffer().append("Ignoring configuration InputStream [").append(inputStream).append("].").toString());
        }
    }

    public void doConfigure(URL url, LoggerRepository loggerRepository) {
        Properties properties = new Properties();
        LogLog.debug(new StringBuffer().append("Reading configuration from URL ").append(url).toString());
        InputStream inputStream = null;
        try {
            URLConnection openConnection = url.openConnection();
            openConnection.setUseCaches(false);
            inputStream = openConnection.getInputStream();
            properties.load(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException e) {
                    Thread.currentThread().interrupt();
                } catch (IOException e2) {
                } catch (RuntimeException e3) {
                }
            }
            doConfigure(properties, loggerRepository);
        } catch (Throwable e4) {
            if ((e4 instanceof InterruptedIOException) || (e4 instanceof InterruptedException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error(new StringBuffer().append("Could not read configuration file from URL [").append(url).append("].").toString(), e4);
            LogLog.error(new StringBuffer().append("Ignoring configuration file [").append(url).append("].").toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException e5) {
                    Thread.currentThread().interrupt();
                } catch (IOException e6) {
                } catch (RuntimeException e7) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException e8) {
                    Thread.currentThread().interrupt();
                } catch (IOException e9) {
                } catch (RuntimeException e10) {
                }
            }
        }
    }

    protected void configureLoggerFactory(Properties properties) {
        String findAndSubst = OptionConverter.findAndSubst(LOGGER_FACTORY_KEY, properties);
        if (findAndSubst != null) {
            Class class$;
            LogLog.debug(new StringBuffer().append("Setting category factory to [").append(findAndSubst).append("].").toString());
            if (class$org$apache$log4j$spi$LoggerFactory == null) {
                class$ = class$("org.apache.log4j.spi.LoggerFactory");
                class$org$apache$log4j$spi$LoggerFactory = class$;
            } else {
                class$ = class$org$apache$log4j$spi$LoggerFactory;
            }
            this.loggerFactory = (LoggerFactory) OptionConverter.instantiateByClassName(findAndSubst, class$, this.loggerFactory);
            PropertySetter.setProperties(this.loggerFactory, properties, "log4j.factory.");
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    void configureRootCategory(Properties properties, LoggerRepository loggerRepository) {
        String str = ROOT_LOGGER_PREFIX;
        String findAndSubst = OptionConverter.findAndSubst(ROOT_LOGGER_PREFIX, properties);
        if (findAndSubst == null) {
            findAndSubst = OptionConverter.findAndSubst(ROOT_CATEGORY_PREFIX, properties);
            str = ROOT_CATEGORY_PREFIX;
        }
        if (findAndSubst == null) {
            LogLog.debug("Could not find root logger information. Is this OK?");
            return;
        }
        Logger rootLogger = loggerRepository.getRootLogger();
        synchronized (rootLogger) {
            parseCategory(properties, rootLogger, str, INTERNAL_ROOT_NAME, findAndSubst);
        }
    }

    protected void parseCatsAndRenderers(Properties properties, LoggerRepository loggerRepository) {
        Enumeration propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            if (str.startsWith(CATEGORY_PREFIX) || str.startsWith(LOGGER_PREFIX)) {
                String substring;
                if (str.startsWith(CATEGORY_PREFIX)) {
                    substring = str.substring(CATEGORY_PREFIX.length());
                } else if (str.startsWith(LOGGER_PREFIX)) {
                    substring = str.substring(LOGGER_PREFIX.length());
                } else {
                    substring = null;
                }
                String findAndSubst = OptionConverter.findAndSubst(str, properties);
                Logger logger = loggerRepository.getLogger(substring, this.loggerFactory);
                synchronized (logger) {
                    parseCategory(properties, logger, str, substring, findAndSubst);
                    parseAdditivityForLogger(properties, logger, substring);
                }
            } else if (str.startsWith(RENDERER_PREFIX)) {
                r1 = str.substring(RENDERER_PREFIX.length());
                String findAndSubst2 = OptionConverter.findAndSubst(str, properties);
                if (loggerRepository instanceof RendererSupport) {
                    RendererMap.addRenderer((RendererSupport) loggerRepository, r1, findAndSubst2);
                }
            } else if (str.equals(THROWABLE_RENDERER_PREFIX) && (loggerRepository instanceof ThrowableRendererSupport)) {
                Class class$;
                r1 = THROWABLE_RENDERER_PREFIX;
                if (class$org$apache$log4j$spi$ThrowableRenderer == null) {
                    class$ = class$("org.apache.log4j.spi.ThrowableRenderer");
                    class$org$apache$log4j$spi$ThrowableRenderer = class$;
                } else {
                    class$ = class$org$apache$log4j$spi$ThrowableRenderer;
                }
                ThrowableRenderer throwableRenderer = (ThrowableRenderer) OptionConverter.instantiateByKey(properties, r1, class$, null);
                if (throwableRenderer == null) {
                    LogLog.error("Could not instantiate throwableRenderer.");
                } else {
                    new PropertySetter(throwableRenderer).setProperties(properties, "log4j.throwableRenderer.");
                    ((ThrowableRendererSupport) loggerRepository).setThrowableRenderer(throwableRenderer);
                }
            }
        }
    }

    void parseAdditivityForLogger(Properties properties, Logger logger, String str) {
        String findAndSubst = OptionConverter.findAndSubst(new StringBuffer().append(ADDITIVITY_PREFIX).append(str).toString(), properties);
        LogLog.debug(new StringBuffer().append("Handling log4j.additivity.").append(str).append("=[").append(findAndSubst).append("]").toString());
        if (findAndSubst != null && !findAndSubst.equals("")) {
            boolean toBoolean = OptionConverter.toBoolean(findAndSubst, true);
            LogLog.debug(new StringBuffer().append("Setting additivity for \"").append(str).append("\" to ").append(toBoolean).toString());
            logger.setAdditivity(toBoolean);
        }
    }

    void parseCategory(Properties properties, Logger logger, String str, String str2, String str3) {
        String nextToken;
        LogLog.debug(new StringBuffer().append("Parsing for [").append(str2).append("] with value=[").append(str3).append("].").toString());
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ",");
        if (!(str3.startsWith(",") || str3.equals(""))) {
            if (stringTokenizer.hasMoreTokens()) {
                nextToken = stringTokenizer.nextToken();
                LogLog.debug(new StringBuffer().append("Level token is [").append(nextToken).append("].").toString());
                if (!Configurator.INHERITED.equalsIgnoreCase(nextToken) && !"null".equalsIgnoreCase(nextToken)) {
                    logger.setLevel(OptionConverter.toLevel(nextToken, Level.DEBUG));
                } else if (str2.equals(INTERNAL_ROOT_NAME)) {
                    LogLog.warn("The root logger cannot be set to null.");
                } else {
                    logger.setLevel(null);
                }
                LogLog.debug(new StringBuffer().append("Category ").append(str2).append(" set to ").append(logger.getLevel()).toString());
            } else {
                return;
            }
        }
        logger.removeAllAppenders();
        while (stringTokenizer.hasMoreTokens()) {
            nextToken = stringTokenizer.nextToken().trim();
            if (!(nextToken == null || nextToken.equals(","))) {
                LogLog.debug(new StringBuffer().append("Parsing appender named \"").append(nextToken).append("\".").toString());
                Appender parseAppender = parseAppender(properties, nextToken);
                if (parseAppender != null) {
                    logger.addAppender(parseAppender);
                }
            }
        }
    }

    Appender parseAppender(Properties properties, String str) {
        Appender registryGet = registryGet(str);
        if (registryGet != null) {
            LogLog.debug(new StringBuffer().append("Appender \"").append(str).append("\" was already parsed.").toString());
            return registryGet;
        }
        Class class$;
        String stringBuffer = new StringBuffer().append(APPENDER_PREFIX).append(str).toString();
        String stringBuffer2 = new StringBuffer().append(stringBuffer).append(".layout").toString();
        if (class$org$apache$log4j$Appender == null) {
            class$ = class$("org.apache.log4j.Appender");
            class$org$apache$log4j$Appender = class$;
        } else {
            class$ = class$org$apache$log4j$Appender;
        }
        registryGet = (Appender) OptionConverter.instantiateByKey(properties, stringBuffer, class$, null);
        if (registryGet == null) {
            LogLog.error(new StringBuffer().append("Could not instantiate appender named \"").append(str).append("\".").toString());
            return null;
        }
        registryGet.setName(str);
        if (registryGet instanceof OptionHandler) {
            Class class$2;
            if (registryGet.requiresLayout()) {
                if (class$org$apache$log4j$Layout == null) {
                    class$2 = class$("org.apache.log4j.Layout");
                    class$org$apache$log4j$Layout = class$2;
                } else {
                    class$2 = class$org$apache$log4j$Layout;
                }
                Layout layout = (Layout) OptionConverter.instantiateByKey(properties, stringBuffer2, class$2, null);
                if (layout != null) {
                    registryGet.setLayout(layout);
                    LogLog.debug(new StringBuffer().append("Parsing layout options for \"").append(str).append("\".").toString());
                    PropertySetter.setProperties(layout, properties, new StringBuffer().append(stringBuffer2).append(".").toString());
                    LogLog.debug(new StringBuffer().append("End of parsing for \"").append(str).append("\".").toString());
                }
            }
            String stringBuffer3 = new StringBuffer().append(stringBuffer).append(".errorhandler").toString();
            if (OptionConverter.findAndSubst(stringBuffer3, properties) != null) {
                if (class$org$apache$log4j$spi$ErrorHandler == null) {
                    class$2 = class$("org.apache.log4j.spi.ErrorHandler");
                    class$org$apache$log4j$spi$ErrorHandler = class$2;
                } else {
                    class$2 = class$org$apache$log4j$spi$ErrorHandler;
                }
                ErrorHandler errorHandler = (ErrorHandler) OptionConverter.instantiateByKey(properties, stringBuffer3, class$2, null);
                if (errorHandler != null) {
                    registryGet.setErrorHandler(errorHandler);
                    LogLog.debug(new StringBuffer().append("Parsing errorhandler options for \"").append(str).append("\".").toString());
                    parseErrorHandler(errorHandler, stringBuffer3, properties, this.repository);
                    Properties properties2 = new Properties();
                    String[] strArr = new String[]{new StringBuffer().append(stringBuffer3).append(".").append(ROOT_REF).toString(), new StringBuffer().append(stringBuffer3).append(".").append(LOGGER_REF).toString(), new StringBuffer().append(stringBuffer3).append(".").append(APPENDER_REF_TAG).toString()};
                    for (Entry entry : properties.entrySet()) {
                        int i = 0;
                        while (i < strArr.length && !strArr[i].equals(entry.getKey())) {
                            i++;
                        }
                        if (i == strArr.length) {
                            properties2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    PropertySetter.setProperties(errorHandler, properties2, new StringBuffer().append(stringBuffer3).append(".").toString());
                    LogLog.debug(new StringBuffer().append("End of errorhandler parsing for \"").append(str).append("\".").toString());
                }
            }
            PropertySetter.setProperties(registryGet, properties, new StringBuffer().append(stringBuffer).append(".").toString());
            LogLog.debug(new StringBuffer().append("Parsed \"").append(str).append("\" options.").toString());
        }
        parseAppenderFilters(properties, str, registryGet);
        registryPut(registryGet);
        return registryGet;
    }

    private void parseErrorHandler(ErrorHandler errorHandler, String str, Properties properties, LoggerRepository loggerRepository) {
        if (OptionConverter.toBoolean(OptionConverter.findAndSubst(new StringBuffer().append(str).append(ROOT_REF).toString(), properties), false)) {
            errorHandler.setLogger(loggerRepository.getRootLogger());
        }
        String findAndSubst = OptionConverter.findAndSubst(new StringBuffer().append(str).append(LOGGER_REF).toString(), properties);
        if (findAndSubst != null) {
            errorHandler.setLogger(this.loggerFactory == null ? loggerRepository.getLogger(findAndSubst) : loggerRepository.getLogger(findAndSubst, this.loggerFactory));
        }
        findAndSubst = OptionConverter.findAndSubst(new StringBuffer().append(str).append(APPENDER_REF_TAG).toString(), properties);
        if (findAndSubst != null) {
            Appender parseAppender = parseAppender(properties, findAndSubst);
            if (parseAppender != null) {
                errorHandler.setBackupAppender(parseAppender);
            }
        }
    }

    void parseAppenderFilters(Properties properties, String str, Appender appender) {
        String stringBuffer = new StringBuffer().append(APPENDER_PREFIX).append(str).append(".filter.").toString();
        int length = stringBuffer.length();
        Hashtable hashtable = new Hashtable();
        Enumeration keys = properties.keys();
        String str2 = "";
        while (keys.hasMoreElements()) {
            String substring;
            String str3 = (String) keys.nextElement();
            if (str3.startsWith(stringBuffer)) {
                Object obj;
                int indexOf = str3.indexOf(46, length);
                if (indexOf != -1) {
                    String substring2 = str3.substring(0, indexOf);
                    substring = str3.substring(indexOf + 1);
                    obj = substring2;
                } else {
                    substring = str2;
                    str2 = str3;
                }
                Vector vector = (Vector) hashtable.get(obj);
                if (vector == null) {
                    vector = new Vector();
                    hashtable.put(obj, vector);
                }
                if (indexOf != -1) {
                    vector.add(new NameValue(substring, OptionConverter.findAndSubst(str3, properties)));
                }
            } else {
                substring = str2;
            }
            str2 = substring;
        }
        Enumeration sortedKeyEnumeration = new SortedKeyEnumeration(hashtable);
        while (sortedKeyEnumeration.hasMoreElements()) {
            substring2 = (String) sortedKeyEnumeration.nextElement();
            substring = properties.getProperty(substring2);
            if (substring != null) {
                Class class$;
                LogLog.debug(new StringBuffer().append("Filter key: [").append(substring2).append("] class: [").append(properties.getProperty(substring2)).append("] props: ").append(hashtable.get(substring2)).toString());
                if (class$org$apache$log4j$spi$Filter == null) {
                    class$ = class$("org.apache.log4j.spi.Filter");
                    class$org$apache$log4j$spi$Filter = class$;
                } else {
                    class$ = class$org$apache$log4j$spi$Filter;
                }
                Filter filter = (Filter) OptionConverter.instantiateByClassName(substring, class$, null);
                if (filter != null) {
                    PropertySetter propertySetter = new PropertySetter(filter);
                    Enumeration elements = ((Vector) hashtable.get(substring2)).elements();
                    while (elements.hasMoreElements()) {
                        NameValue nameValue = (NameValue) elements.nextElement();
                        propertySetter.setProperty(nameValue.key, nameValue.value);
                    }
                    propertySetter.activate();
                    LogLog.debug(new StringBuffer().append("Adding filter of type [").append(filter.getClass()).append("] to appender named [").append(appender.getName()).append("].").toString());
                    appender.addFilter(filter);
                }
            } else {
                LogLog.warn(new StringBuffer().append("Missing class definition for filter: [").append(substring2).append("]").toString());
            }
        }
    }

    void registryPut(Appender appender) {
        this.registry.put(appender.getName(), appender);
    }

    Appender registryGet(String str) {
        return (Appender) this.registry.get(str);
    }
}
