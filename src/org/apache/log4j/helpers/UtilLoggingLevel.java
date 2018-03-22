package org.apache.log4j.helpers;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

public class UtilLoggingLevel extends Level {
    public static final UtilLoggingLevel CONFIG = new UtilLoggingLevel(CONFIG_INT, "CONFIG", 6);
    public static final int CONFIG_INT = 14000;
    public static final UtilLoggingLevel FINE = new UtilLoggingLevel(FINE_INT, "FINE", 7);
    public static final UtilLoggingLevel FINER = new UtilLoggingLevel(FINER_INT, "FINER", 8);
    public static final int FINER_INT = 12000;
    public static final UtilLoggingLevel FINEST = new UtilLoggingLevel(FINEST_INT, "FINEST", 9);
    public static final int FINEST_INT = 11000;
    public static final int FINE_INT = 13000;
    public static final UtilLoggingLevel INFO = new UtilLoggingLevel(20000, "INFO", 5);
    public static final UtilLoggingLevel SEVERE = new UtilLoggingLevel(SEVERE_INT, "SEVERE", 0);
    public static final int SEVERE_INT = 22000;
    public static final int UNKNOWN_INT = 10000;
    public static final UtilLoggingLevel WARNING = new UtilLoggingLevel(WARNING_INT, "WARNING", 4);
    public static final int WARNING_INT = 21000;
    private static final long serialVersionUID = 909301162611820211L;

    protected UtilLoggingLevel(int i, String str, int i2) {
        super(i, str, i2);
    }

    public static UtilLoggingLevel toLevel(int i, UtilLoggingLevel utilLoggingLevel) {
        switch (i) {
            case FINEST_INT /*11000*/:
                return FINEST;
            case FINER_INT /*12000*/:
                return FINER;
            case FINE_INT /*13000*/:
                return FINE;
            case CONFIG_INT /*14000*/:
                return CONFIG;
            case 20000:
                return INFO;
            case WARNING_INT /*21000*/:
                return WARNING;
            case SEVERE_INT /*22000*/:
                return SEVERE;
            default:
                return utilLoggingLevel;
        }
    }

    public static Level toLevel(int i) {
        return toLevel(i, FINEST);
    }

    public static List getAllPossibleLevels() {
        List arrayList = new ArrayList();
        arrayList.add(FINE);
        arrayList.add(FINER);
        arrayList.add(FINEST);
        arrayList.add(INFO);
        arrayList.add(CONFIG);
        arrayList.add(WARNING);
        arrayList.add(SEVERE);
        return arrayList;
    }

    public static Level toLevel(String str) {
        return toLevel(str, Level.DEBUG);
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        String toUpperCase = str.toUpperCase();
        if (toUpperCase.equals("SEVERE")) {
            return SEVERE;
        }
        if (toUpperCase.equals("WARNING")) {
            return WARNING;
        }
        if (toUpperCase.equals("INFO")) {
            return INFO;
        }
        if (toUpperCase.equals("CONFI")) {
            return CONFIG;
        }
        if (toUpperCase.equals("FINE")) {
            return FINE;
        }
        if (toUpperCase.equals("FINER")) {
            return FINER;
        }
        if (toUpperCase.equals("FINEST")) {
            return FINEST;
        }
        return level;
    }
}
