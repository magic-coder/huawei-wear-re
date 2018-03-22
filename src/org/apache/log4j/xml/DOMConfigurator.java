package org.apache.log4j.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.config.PropertySetter;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMConfigurator implements Configurator {
    static final String ADDITIVITY_ATTR = "additivity";
    static final String APPENDER_REF_TAG = "appender-ref";
    static final String APPENDER_TAG = "appender";
    static final String CATEGORY = "category";
    static final String CATEGORY_FACTORY_TAG = "categoryFactory";
    static final String CLASS_ATTR = "class";
    static final String CONFIGURATION_TAG = "log4j:configuration";
    static final String CONFIG_DEBUG_ATTR = "configDebug";
    static final String EMPTY_STR = "";
    static final String ERROR_HANDLER_TAG = "errorHandler";
    static final String FILTER_TAG = "filter";
    static final String INTERNAL_DEBUG_ATTR = "debug";
    static final String LAYOUT_TAG = "layout";
    static final String LEVEL_TAG = "level";
    static final String LOGGER = "logger";
    static final String LOGGER_FACTORY_TAG = "loggerFactory";
    static final String LOGGER_REF = "logger-ref";
    static final String NAME_ATTR = "name";
    static final String OLD_CONFIGURATION_TAG = "configuration";
    static final Class[] ONE_STRING_PARAM;
    static final String PARAM_TAG = "param";
    static final String PRIORITY_TAG = "priority";
    static final String REF_ATTR = "ref";
    static final String RENDERED_CLASS_ATTR = "renderedClass";
    static final String RENDERER_TAG = "renderer";
    static final String RENDERING_CLASS_ATTR = "renderingClass";
    private static final String RESET_ATTR = "reset";
    static final String ROOT_REF = "root-ref";
    static final String ROOT_TAG = "root";
    static final String THRESHOLD_ATTR = "threshold";
    private static final String THROWABLE_RENDERER_TAG = "throwableRenderer";
    static final String VALUE_ATTR = "value";
    static Class class$java$lang$String = null;
    static Class class$org$apache$log4j$spi$ErrorHandler = null;
    static Class class$org$apache$log4j$spi$Filter = null;
    static Class class$org$apache$log4j$spi$LoggerFactory = null;
    static final String dbfKey = "javax.xml.parsers.DocumentBuilderFactory";
    Hashtable appenderBag = new Hashtable();
    protected LoggerFactory catFactory = null;
    Properties props;
    LoggerRepository repository;

    interface ParseAction {
        Document parse(DocumentBuilder documentBuilder) throws SAXException, IOException;
    }

    class C28021 implements ParseAction {
        private final DOMConfigurator this$0;
        private final String val$filename;

        C28021(DOMConfigurator dOMConfigurator, String str) {
            this.this$0 = dOMConfigurator;
            this.val$filename = str;
        }

        public Document parse(DocumentBuilder documentBuilder) throws SAXException, IOException {
            return documentBuilder.parse(new File(this.val$filename));
        }

        public String toString() {
            return new StringBuffer().append("file [").append(this.val$filename).append("]").toString();
        }
    }

    class C28032 implements ParseAction {
        private final DOMConfigurator this$0;
        private final URL val$url;

        C28032(DOMConfigurator dOMConfigurator, URL url) {
            this.this$0 = dOMConfigurator;
            this.val$url = url;
        }

        public Document parse(DocumentBuilder documentBuilder) throws SAXException, IOException {
            URLConnection openConnection = this.val$url.openConnection();
            openConnection.setUseCaches(false);
            InputStream inputStream = openConnection.getInputStream();
            try {
                InputSource inputSource = new InputSource(inputStream);
                inputSource.setSystemId(this.val$url.toString());
                Document parse = documentBuilder.parse(inputSource);
                return parse;
            } finally {
                inputStream.close();
            }
        }

        public String toString() {
            return new StringBuffer().append("url [").append(this.val$url.toString()).append("]").toString();
        }
    }

    class C28043 implements ParseAction {
        private final DOMConfigurator this$0;
        private final InputStream val$inputStream;

        C28043(DOMConfigurator dOMConfigurator, InputStream inputStream) {
            this.this$0 = dOMConfigurator;
            this.val$inputStream = inputStream;
        }

        public Document parse(DocumentBuilder documentBuilder) throws SAXException, IOException {
            InputSource inputSource = new InputSource(this.val$inputStream);
            inputSource.setSystemId("dummy://log4j.dtd");
            return documentBuilder.parse(inputSource);
        }

        public String toString() {
            return new StringBuffer().append("input stream [").append(this.val$inputStream.toString()).append("]").toString();
        }
    }

    class C28054 implements ParseAction {
        private final DOMConfigurator this$0;
        private final Reader val$reader;

        C28054(DOMConfigurator dOMConfigurator, Reader reader) {
            this.this$0 = dOMConfigurator;
            this.val$reader = reader;
        }

        public Document parse(DocumentBuilder documentBuilder) throws SAXException, IOException {
            InputSource inputSource = new InputSource(this.val$reader);
            inputSource.setSystemId("dummy://log4j.dtd");
            return documentBuilder.parse(inputSource);
        }

        public String toString() {
            return new StringBuffer().append("reader [").append(this.val$reader.toString()).append("]").toString();
        }
    }

    class C28065 implements ParseAction {
        private final DOMConfigurator this$0;
        private final InputSource val$inputSource;

        C28065(DOMConfigurator dOMConfigurator, InputSource inputSource) {
            this.this$0 = dOMConfigurator;
            this.val$inputSource = inputSource;
        }

        public Document parse(DocumentBuilder documentBuilder) throws SAXException, IOException {
            return documentBuilder.parse(this.val$inputSource);
        }

        public String toString() {
            return new StringBuffer().append("input source [").append(this.val$inputSource.toString()).append("]").toString();
        }
    }

    static {
        Class class$;
        Class[] clsArr = new Class[1];
        if (class$java$lang$String == null) {
            class$ = class$("java.lang.String");
            class$java$lang$String = class$;
        } else {
            class$ = class$java$lang$String;
        }
        clsArr[0] = class$;
        ONE_STRING_PARAM = clsArr;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected Appender findAppenderByName(Document document, String str) {
        Appender appender = (Appender) this.appenderBag.get(str);
        if (appender != null) {
            return appender;
        }
        Element element;
        NodeList elementsByTagName = document.getElementsByTagName(APPENDER_TAG);
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (str.equals(item.getAttributes().getNamedItem("name").getNodeValue())) {
                element = (Element) item;
                break;
            }
        }
        element = null;
        if (element == null) {
            LogLog.error(new StringBuffer().append("No appender named [").append(str).append("] could be found.").toString());
            return null;
        }
        appender = parseAppender(element);
        if (appender == null) {
            return appender;
        }
        this.appenderBag.put(str, appender);
        return appender;
    }

    protected Appender findAppenderByReference(Element element) {
        return findAppenderByName(element.getOwnerDocument(), subst(element.getAttribute(REF_ATTR)));
    }

    private static void parseUnrecognizedElement(Object obj, Element element, Properties properties) throws Exception {
        boolean z = false;
        if (obj instanceof UnrecognizedElementHandler) {
            z = ((UnrecognizedElementHandler) obj).parseUnrecognizedElement(element, properties);
        }
        if (!z) {
            LogLog.warn(new StringBuffer().append("Unrecognized element ").append(element.getNodeName()).toString());
        }
    }

    private static void quietParseUnrecognizedElement(Object obj, Element element, Properties properties) {
        try {
            parseUnrecognizedElement(obj, element, properties);
        } catch (Throwable e) {
            if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Error in extension content: ", e);
        }
    }

    protected Appender parseAppender(Element element) {
        String subst = subst(element.getAttribute(CLASS_ATTR));
        LogLog.debug(new StringBuffer().append("Class name: [").append(subst).append(']').toString());
        try {
            Object newInstance = Loader.loadClass(subst).newInstance();
            Appender appender = (Appender) newInstance;
            PropertySetter propertySetter = new PropertySetter(appender);
            appender.setName(subst(element.getAttribute("name")));
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else if (element2.getTagName().equals("layout")) {
                        appender.setLayout(parseLayout(element2));
                    } else if (element2.getTagName().equals(FILTER_TAG)) {
                        parseFilters(element2, appender);
                    } else if (element2.getTagName().equals(ERROR_HANDLER_TAG)) {
                        parseErrorHandler(element2, appender);
                    } else if (element2.getTagName().equals(APPENDER_REF_TAG)) {
                        String subst2 = subst(element2.getAttribute(REF_ATTR));
                        if (appender instanceof AppenderAttachable) {
                            AppenderAttachable appenderAttachable = (AppenderAttachable) appender;
                            LogLog.debug(new StringBuffer().append("Attaching appender named [").append(subst2).append("] to appender named [").append(appender.getName()).append("].").toString());
                            appenderAttachable.addAppender(findAppenderByReference(element2));
                        } else {
                            LogLog.error(new StringBuffer().append("Requesting attachment of appender named [").append(subst2).append("] to appender named [").append(appender.getName()).append("] which does not implement org.apache.log4j.spi.AppenderAttachable.").toString());
                        }
                    } else {
                        parseUnrecognizedElement(newInstance, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            return appender;
        } catch (Throwable e) {
            if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Could not create an Appender. Reported error follows.", e);
            return null;
        }
    }

    protected void parseErrorHandler(Element element, Appender appender) {
        Class class$;
        String subst = subst(element.getAttribute(CLASS_ATTR));
        if (class$org$apache$log4j$spi$ErrorHandler == null) {
            class$ = class$("org.apache.log4j.spi.ErrorHandler");
            class$org$apache$log4j$spi$ErrorHandler = class$;
        } else {
            class$ = class$org$apache$log4j$spi$ErrorHandler;
        }
        ErrorHandler errorHandler = (ErrorHandler) OptionConverter.instantiateByClassName(subst, class$, null);
        if (errorHandler != null) {
            errorHandler.setAppender(appender);
            PropertySetter propertySetter = new PropertySetter(errorHandler);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1) {
                    Element element2 = (Element) item;
                    String tagName = element2.getTagName();
                    if (tagName.equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else if (tagName.equals(APPENDER_REF_TAG)) {
                        errorHandler.setBackupAppender(findAppenderByReference(element2));
                    } else if (tagName.equals(LOGGER_REF)) {
                        subst = element2.getAttribute(REF_ATTR);
                        errorHandler.setLogger(this.catFactory == null ? this.repository.getLogger(subst) : this.repository.getLogger(subst, this.catFactory));
                    } else if (tagName.equals(ROOT_REF)) {
                        errorHandler.setLogger(this.repository.getRootLogger());
                    } else {
                        quietParseUnrecognizedElement(errorHandler, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            appender.setErrorHandler(errorHandler);
        }
    }

    protected void parseFilters(Element element, Appender appender) {
        Class class$;
        String subst = subst(element.getAttribute(CLASS_ATTR));
        if (class$org$apache$log4j$spi$Filter == null) {
            class$ = class$("org.apache.log4j.spi.Filter");
            class$org$apache$log4j$spi$Filter = class$;
        } else {
            class$ = class$org$apache$log4j$spi$Filter;
        }
        Filter filter = (Filter) OptionConverter.instantiateByClassName(subst, class$, null);
        if (filter != null) {
            PropertySetter propertySetter = new PropertySetter(filter);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else {
                        quietParseUnrecognizedElement(filter, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            LogLog.debug(new StringBuffer().append("Adding filter of type [").append(filter.getClass()).append("] to appender named [").append(appender.getName()).append("].").toString());
            appender.addFilter(filter);
        }
    }

    protected void parseCategory(Element element) {
        Logger logger;
        String subst = subst(element.getAttribute("name"));
        String subst2 = subst(element.getAttribute(CLASS_ATTR));
        if ("".equals(subst2)) {
            LogLog.debug("Retreiving an instance of org.apache.log4j.Logger.");
            if (this.catFactory == null) {
                logger = this.repository.getLogger(subst);
            } else {
                logger = this.repository.getLogger(subst, this.catFactory);
            }
        } else {
            LogLog.debug(new StringBuffer().append("Desired logger sub-class: [").append(subst2).append(']').toString());
            try {
                logger = (Logger) Loader.loadClass(subst2).getMethod("getLogger", ONE_STRING_PARAM).invoke(null, new Object[]{subst});
            } catch (Throwable e) {
                if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error(new StringBuffer().append("Could not retrieve category [").append(subst).append("]. Reported error follows.").toString(), e);
                return;
            } catch (Throwable e2) {
                LogLog.error(new StringBuffer().append("Could not retrieve category [").append(subst).append("]. Reported error follows.").toString(), e2);
                return;
            }
        }
        synchronized (logger) {
            boolean toBoolean = OptionConverter.toBoolean(subst(element.getAttribute(ADDITIVITY_ATTR)), true);
            LogLog.debug(new StringBuffer().append("Setting [").append(logger.getName()).append("] additivity to [").append(toBoolean).append("].").toString());
            logger.setAdditivity(toBoolean);
            parseChildrenOfLoggerElement(element, logger, false);
        }
    }

    protected void parseCategoryFactory(Element element) {
        String subst = subst(element.getAttribute(CLASS_ATTR));
        if ("".equals(subst)) {
            LogLog.error("Category Factory tag class attribute not found.");
            LogLog.debug("No Category Factory configured.");
            return;
        }
        Class class$;
        LogLog.debug(new StringBuffer().append("Desired category factory: [").append(subst).append(']').toString());
        if (class$org$apache$log4j$spi$LoggerFactory == null) {
            class$ = class$("org.apache.log4j.spi.LoggerFactory");
            class$org$apache$log4j$spi$LoggerFactory = class$;
        } else {
            class$ = class$org$apache$log4j$spi$LoggerFactory;
        }
        Object instantiateByClassName = OptionConverter.instantiateByClassName(subst, class$, null);
        if (instantiateByClassName instanceof LoggerFactory) {
            this.catFactory = (LoggerFactory) instantiateByClassName;
        } else {
            LogLog.error(new StringBuffer().append("Category Factory class ").append(subst).append(" does not implement org.apache.log4j.LoggerFactory").toString());
        }
        PropertySetter propertySetter = new PropertySetter(instantiateByClassName);
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals(PARAM_TAG)) {
                    setParameter(element2, propertySetter);
                } else {
                    quietParseUnrecognizedElement(instantiateByClassName, element2, this.props);
                }
            }
        }
    }

    protected void parseRoot(Element element) {
        Logger rootLogger = this.repository.getRootLogger();
        synchronized (rootLogger) {
            parseChildrenOfLoggerElement(element, rootLogger, true);
        }
    }

    protected void parseChildrenOfLoggerElement(Element element, Logger logger, boolean z) {
        PropertySetter propertySetter = new PropertySetter(logger);
        logger.removeAllAppenders();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                Element element2 = (Element) item;
                String tagName = element2.getTagName();
                if (tagName.equals(APPENDER_REF_TAG)) {
                    Element element3 = (Element) item;
                    Appender findAppenderByReference = findAppenderByReference(element3);
                    String subst = subst(element3.getAttribute(REF_ATTR));
                    if (findAppenderByReference != null) {
                        LogLog.debug(new StringBuffer().append("Adding appender named [").append(subst).append("] to category [").append(logger.getName()).append("].").toString());
                    } else {
                        LogLog.debug(new StringBuffer().append("Appender named [").append(subst).append("] not found.").toString());
                    }
                    logger.addAppender(findAppenderByReference);
                } else if (tagName.equals(LEVEL_TAG)) {
                    parseLevel(element2, logger, z);
                } else if (tagName.equals("priority")) {
                    parseLevel(element2, logger, z);
                } else if (tagName.equals(PARAM_TAG)) {
                    setParameter(element2, propertySetter);
                } else {
                    quietParseUnrecognizedElement(logger, element2, this.props);
                }
            }
        }
        propertySetter.activate();
    }

    protected Layout parseLayout(Element element) {
        String subst = subst(element.getAttribute(CLASS_ATTR));
        LogLog.debug(new StringBuffer().append("Parsing layout of class: \"").append(subst).append("\"").toString());
        try {
            Object newInstance = Loader.loadClass(subst).newInstance();
            Layout layout = (Layout) newInstance;
            PropertySetter propertySetter = new PropertySetter(layout);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else {
                        parseUnrecognizedElement(newInstance, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            return layout;
        } catch (Throwable e) {
            if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Could not create the Layout. Reported error follows.", e);
            return null;
        }
    }

    protected void parseRenderer(Element element) {
        String subst = subst(element.getAttribute(RENDERING_CLASS_ATTR));
        String subst2 = subst(element.getAttribute(RENDERED_CLASS_ATTR));
        if (this.repository instanceof RendererSupport) {
            RendererMap.addRenderer((RendererSupport) this.repository, subst2, subst);
        }
    }

    protected ThrowableRenderer parseThrowableRenderer(Element element) {
        String subst = subst(element.getAttribute(CLASS_ATTR));
        LogLog.debug(new StringBuffer().append("Parsing throwableRenderer of class: \"").append(subst).append("\"").toString());
        try {
            Object newInstance = Loader.loadClass(subst).newInstance();
            ThrowableRenderer throwableRenderer = (ThrowableRenderer) newInstance;
            PropertySetter propertySetter = new PropertySetter(throwableRenderer);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1) {
                    Element element2 = (Element) item;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else {
                        parseUnrecognizedElement(newInstance, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            return throwableRenderer;
        } catch (Throwable e) {
            if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Could not create the ThrowableRenderer. Reported error follows.", e);
            return null;
        }
    }

    protected void parseLevel(Element element, Logger logger, boolean z) {
        String str;
        String name = logger.getName();
        if (z) {
            str = ROOT_TAG;
        } else {
            str = name;
        }
        String subst = subst(element.getAttribute("value"));
        LogLog.debug(new StringBuffer().append("Level value for ").append(str).append(" is  [").append(subst).append("].").toString());
        if (!Configurator.INHERITED.equalsIgnoreCase(subst) && !"null".equalsIgnoreCase(subst)) {
            name = subst(element.getAttribute(CLASS_ATTR));
            if ("".equals(name)) {
                logger.setLevel(OptionConverter.toLevel(subst, Level.DEBUG));
            } else {
                LogLog.debug(new StringBuffer().append("Desired Level sub-class: [").append(name).append(']').toString());
                try {
                    logger.setLevel((Level) Loader.loadClass(name).getMethod("toLevel", ONE_STRING_PARAM).invoke(null, new Object[]{subst}));
                } catch (Throwable e) {
                    if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                        Thread.currentThread().interrupt();
                    }
                    LogLog.error(new StringBuffer().append("Could not create level [").append(subst).append("]. Reported error follows.").toString(), e);
                    return;
                }
            }
        } else if (z) {
            LogLog.error("Root level cannot be inherited. Ignoring directive.");
        } else {
            logger.setLevel(null);
        }
        LogLog.debug(new StringBuffer().append(str).append(" level set to ").append(logger.getLevel()).toString());
    }

    protected void setParameter(Element element, PropertySetter propertySetter) {
        propertySetter.setProperty(subst(element.getAttribute("name")), subst(OptionConverter.convertSpecialChars(element.getAttribute("value"))));
    }

    public static void configure(Element element) {
        new DOMConfigurator().doConfigure(element, LogManager.getLoggerRepository());
    }

    public static void configureAndWatch(String str) {
        configureAndWatch(str, FileWatchdog.DEFAULT_DELAY);
    }

    public static void configureAndWatch(String str, long j) {
        XMLWatchdog xMLWatchdog = new XMLWatchdog(str);
        xMLWatchdog.setDelay(j);
        xMLWatchdog.start();
    }

    public void doConfigure(String str, LoggerRepository loggerRepository) {
        doConfigure(new C28021(this, str), loggerRepository);
    }

    public void doConfigure(URL url, LoggerRepository loggerRepository) {
        doConfigure(new C28032(this, url), loggerRepository);
    }

    public void doConfigure(InputStream inputStream, LoggerRepository loggerRepository) throws FactoryConfigurationError {
        doConfigure(new C28043(this, inputStream), loggerRepository);
    }

    public void doConfigure(Reader reader, LoggerRepository loggerRepository) throws FactoryConfigurationError {
        doConfigure(new C28054(this, reader), loggerRepository);
    }

    protected void doConfigure(InputSource inputSource, LoggerRepository loggerRepository) throws FactoryConfigurationError {
        if (inputSource.getSystemId() == null) {
            inputSource.setSystemId("dummy://log4j.dtd");
        }
        doConfigure(new C28065(this, inputSource), loggerRepository);
    }

    private final void doConfigure(ParseAction parseAction, LoggerRepository loggerRepository) throws FactoryConfigurationError {
        this.repository = loggerRepository;
        try {
            LogLog.debug(new StringBuffer().append("System property is :").append(OptionConverter.getSystemProperty(dbfKey, null)).toString());
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            LogLog.debug("Standard DocumentBuilderFactory search succeded.");
            LogLog.debug(new StringBuffer().append("DocumentBuilderFactory is: ").append(newInstance.getClass().getName()).toString());
            try {
                newInstance.setValidating(true);
                DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
                newDocumentBuilder.setErrorHandler(new SAXErrorHandler());
                newDocumentBuilder.setEntityResolver(new Log4jEntityResolver());
                parse(parseAction.parse(newDocumentBuilder).getDocumentElement());
            } catch (Throwable e) {
                if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error(new StringBuffer().append("Could not parse ").append(parseAction.toString()).append(".").toString(), e);
            }
        } catch (FactoryConfigurationError e2) {
            LogLog.debug("Could not instantiate a DocumentBuilderFactory.", e2.getException());
            throw e2;
        }
    }

    public void doConfigure(Element element, LoggerRepository loggerRepository) {
        this.repository = loggerRepository;
        parse(element);
    }

    public static void configure(String str) throws FactoryConfigurationError {
        new DOMConfigurator().doConfigure(str, LogManager.getLoggerRepository());
    }

    public static void configure(URL url) throws FactoryConfigurationError {
        new DOMConfigurator().doConfigure(url, LogManager.getLoggerRepository());
    }

    protected void parse(Element element) {
        Element element2;
        int i = 0;
        String tagName = element.getTagName();
        if (!tagName.equals(CONFIGURATION_TAG)) {
            if (tagName.equals(OLD_CONFIGURATION_TAG)) {
                LogLog.warn("The <configuration> element has been deprecated.");
                LogLog.warn("Use the <log4j:configuration> element instead.");
            } else {
                LogLog.error("DOM element is - not a <log4j:configuration> element.");
                return;
            }
        }
        tagName = subst(element.getAttribute(INTERNAL_DEBUG_ATTR));
        LogLog.debug(new StringBuffer().append("debug attribute= \"").append(tagName).append("\".").toString());
        if (tagName.equals("") || tagName.equals("null")) {
            LogLog.debug("Ignoring debug attribute.");
        } else {
            LogLog.setInternalDebugging(OptionConverter.toBoolean(tagName, true));
        }
        tagName = subst(element.getAttribute(RESET_ATTR));
        LogLog.debug(new StringBuffer().append("reset attribute= \"").append(tagName).append("\".").toString());
        if (!"".equals(tagName) && OptionConverter.toBoolean(tagName, false)) {
            this.repository.resetConfiguration();
        }
        tagName = subst(element.getAttribute(CONFIG_DEBUG_ATTR));
        if (!(tagName.equals("") || tagName.equals("null"))) {
            LogLog.warn("The \"configDebug\" attribute is deprecated.");
            LogLog.warn("Use the \"debug\" attribute instead.");
            LogLog.setInternalDebugging(OptionConverter.toBoolean(tagName, true));
        }
        tagName = subst(element.getAttribute(THRESHOLD_ATTR));
        LogLog.debug(new StringBuffer().append("Threshold =\"").append(tagName).append("\".").toString());
        if (!("".equals(tagName) || "null".equals(tagName))) {
            this.repository.setThreshold(tagName);
        }
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Node item = childNodes.item(i2);
            if (item.getNodeType() == (short) 1) {
                element2 = (Element) item;
                String tagName2 = element2.getTagName();
                if (tagName2.equals(CATEGORY_FACTORY_TAG) || tagName2.equals(LOGGER_FACTORY_TAG)) {
                    parseCategoryFactory(element2);
                }
            }
        }
        while (i < length) {
            item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                element2 = (Element) item;
                String tagName3 = element2.getTagName();
                if (tagName3.equals("category") || tagName3.equals(LOGGER)) {
                    parseCategory(element2);
                } else if (tagName3.equals(ROOT_TAG)) {
                    parseRoot(element2);
                } else if (tagName3.equals(RENDERER_TAG)) {
                    parseRenderer(element2);
                } else if (tagName3.equals(THROWABLE_RENDERER_TAG)) {
                    if (this.repository instanceof ThrowableRendererSupport) {
                        ThrowableRenderer parseThrowableRenderer = parseThrowableRenderer(element2);
                        if (parseThrowableRenderer != null) {
                            ((ThrowableRendererSupport) this.repository).setThrowableRenderer(parseThrowableRenderer);
                        }
                    }
                } else if (!(tagName3.equals(APPENDER_TAG) || tagName3.equals(CATEGORY_FACTORY_TAG) || tagName3.equals(LOGGER_FACTORY_TAG))) {
                    quietParseUnrecognizedElement(this.repository, element2, this.props);
                }
            }
            i++;
        }
    }

    protected String subst(String str) {
        return subst(str, this.props);
    }

    public static String subst(String str, Properties properties) {
        try {
            str = OptionConverter.substVars(str, properties);
        } catch (Throwable e) {
            LogLog.warn("Could not perform variable substitution.", e);
        }
        return str;
    }

    public static void setParameter(Element element, PropertySetter propertySetter, Properties properties) {
        propertySetter.setProperty(subst(element.getAttribute("name"), properties), subst(OptionConverter.convertSpecialChars(element.getAttribute("value")), properties));
    }

    public static Object parseElement(Element element, Properties properties, Class cls) throws Exception {
        Object instantiateByClassName = OptionConverter.instantiateByClassName(subst(element.getAttribute(CLASS_ATTR), properties), cls, null);
        if (instantiateByClassName == null) {
            return null;
        }
        PropertySetter propertySetter = new PropertySetter(instantiateByClassName);
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                Element element2 = (Element) item;
                if (element2.getTagName().equals(PARAM_TAG)) {
                    setParameter(element2, propertySetter, properties);
                } else {
                    parseUnrecognizedElement(instantiateByClassName, element2, properties);
                }
            }
        }
        return instantiateByClassName;
    }
}
