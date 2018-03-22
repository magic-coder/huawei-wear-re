package org.apache.log4j.config;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.config.PropertyGetter.PropertyCallback;

public class PropertyPrinter implements PropertyCallback {
    protected Hashtable appenderNames;
    protected boolean doCapitalize;
    protected Hashtable layoutNames;
    protected int numAppenders;
    protected PrintWriter out;

    public PropertyPrinter(PrintWriter printWriter) {
        this(printWriter, false);
    }

    public PropertyPrinter(PrintWriter printWriter, boolean z) {
        this.numAppenders = 0;
        this.appenderNames = new Hashtable();
        this.layoutNames = new Hashtable();
        this.out = printWriter;
        this.doCapitalize = z;
        print(printWriter);
        printWriter.flush();
    }

    protected String genAppName() {
        StringBuffer append = new StringBuffer().append("A");
        int i = this.numAppenders;
        this.numAppenders = i + 1;
        return append.append(i).toString();
    }

    protected boolean isGenAppName(String str) {
        if (str.length() < 2 || str.charAt(0) != 'A') {
            return false;
        }
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
            i++;
        }
        return true;
    }

    public void print(PrintWriter printWriter) {
        printOptions(printWriter, Logger.getRootLogger());
        Enumeration currentLoggers = LogManager.getCurrentLoggers();
        while (currentLoggers.hasMoreElements()) {
            printOptions(printWriter, (Logger) currentLoggers.nextElement());
        }
    }

    protected void printOptions(PrintWriter printWriter, Category category) {
        Enumeration allAppenders = category.getAllAppenders();
        Level level = category.getLevel();
        String level2 = level == null ? "" : level.toString();
        while (allAppenders.hasMoreElements()) {
            Appender appender = (Appender) allAppenders.nextElement();
            String str = (String) this.appenderNames.get(appender);
            if (str == null) {
                str = appender.getName();
                if (str == null || isGenAppName(str)) {
                    str = genAppName();
                }
                this.appenderNames.put(appender, str);
                printOptions(printWriter, appender, new StringBuffer().append("log4j.appender.").append(str).toString());
                if (appender.getLayout() != null) {
                    printOptions(printWriter, appender.getLayout(), new StringBuffer().append("log4j.appender.").append(str).append(".layout").toString());
                }
            }
            level2 = new StringBuffer().append(level2).append(", ").append(str).toString();
        }
        String stringBuffer = category == Logger.getRootLogger() ? "log4j.rootLogger" : new StringBuffer().append("log4j.logger.").append(category.getName()).toString();
        if (level2 != "") {
            printWriter.println(new StringBuffer().append(stringBuffer).append("=").append(level2).toString());
        }
        if (!category.getAdditivity() && category != Logger.getRootLogger()) {
            printWriter.println(new StringBuffer().append("log4j.additivity.").append(category.getName()).append("=false").toString());
        }
    }

    protected void printOptions(PrintWriter printWriter, Logger logger) {
        printOptions(printWriter, (Category) logger);
    }

    protected void printOptions(PrintWriter printWriter, Object obj, String str) {
        printWriter.println(new StringBuffer().append(str).append("=").append(obj.getClass().getName()).toString());
        PropertyGetter.getProperties(obj, this, new StringBuffer().append(str).append(".").toString());
    }

    public void foundProperty(Object obj, String str, String str2, Object obj2) {
        if (!(obj instanceof Appender) || !"name".equals(str2)) {
            if (this.doCapitalize) {
                str2 = capitalize(str2);
            }
            this.out.println(new StringBuffer().append(str).append(str2).append("=").append(obj2.toString()).toString());
        }
    }

    public static String capitalize(String str) {
        if (!Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        if (str.length() != 1 && !Character.isLowerCase(str.charAt(1))) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.setCharAt(0, Character.toUpperCase(str.charAt(0)));
        return stringBuffer.toString();
    }

    public static void main(String[] strArr) {
        PropertyPrinter propertyPrinter = new PropertyPrinter(new PrintWriter(System.out));
    }
}
