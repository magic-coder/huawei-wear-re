package org.apache.log4j.lf5.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatManager {
    private DateFormat _dateFormat = null;
    private Locale _locale = null;
    private String _pattern = null;
    private TimeZone _timeZone = null;

    public DateFormatManager() {
        configure();
    }

    public DateFormatManager(TimeZone timeZone) {
        this._timeZone = timeZone;
        configure();
    }

    public DateFormatManager(Locale locale) {
        this._locale = locale;
        configure();
    }

    public DateFormatManager(String str) {
        this._pattern = str;
        configure();
    }

    public DateFormatManager(TimeZone timeZone, Locale locale) {
        this._timeZone = timeZone;
        this._locale = locale;
        configure();
    }

    public DateFormatManager(TimeZone timeZone, String str) {
        this._timeZone = timeZone;
        this._pattern = str;
        configure();
    }

    public DateFormatManager(Locale locale, String str) {
        this._locale = locale;
        this._pattern = str;
        configure();
    }

    public DateFormatManager(TimeZone timeZone, Locale locale, String str) {
        this._timeZone = timeZone;
        this._locale = locale;
        this._pattern = str;
        configure();
    }

    public synchronized TimeZone getTimeZone() {
        TimeZone timeZone;
        if (this._timeZone == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this._timeZone;
        }
        return timeZone;
    }

    public synchronized void setTimeZone(TimeZone timeZone) {
        this._timeZone = timeZone;
        configure();
    }

    public synchronized Locale getLocale() {
        Locale locale;
        if (this._locale == null) {
            locale = Locale.getDefault();
        } else {
            locale = this._locale;
        }
        return locale;
    }

    public synchronized void setLocale(Locale locale) {
        this._locale = locale;
        configure();
    }

    public synchronized String getPattern() {
        return this._pattern;
    }

    public synchronized void setPattern(String str) {
        this._pattern = str;
        configure();
    }

    public synchronized String getOutputFormat() {
        return this._pattern;
    }

    public synchronized void setOutputFormat(String str) {
        this._pattern = str;
        configure();
    }

    public synchronized DateFormat getDateFormatInstance() {
        return this._dateFormat;
    }

    public synchronized void setDateFormatInstance(DateFormat dateFormat) {
        this._dateFormat = dateFormat;
    }

    public String format(Date date) {
        return getDateFormatInstance().format(date);
    }

    public String format(Date date, String str) {
        DateFormat dateFormatInstance = getDateFormatInstance();
        if (dateFormatInstance instanceof SimpleDateFormat) {
            dateFormatInstance = (SimpleDateFormat) dateFormatInstance.clone();
            ((SimpleDateFormat) dateFormatInstance).applyPattern(str);
        }
        return dateFormatInstance.format(date);
    }

    public Date parse(String str) throws ParseException {
        return getDateFormatInstance().parse(str);
    }

    public Date parse(String str, String str2) throws ParseException {
        DateFormat dateFormatInstance = getDateFormatInstance();
        if (dateFormatInstance instanceof SimpleDateFormat) {
            dateFormatInstance = (SimpleDateFormat) dateFormatInstance.clone();
            ((SimpleDateFormat) dateFormatInstance).applyPattern(str2);
        }
        return dateFormatInstance.parse(str);
    }

    private synchronized void configure() {
        this._dateFormat = SimpleDateFormat.getDateTimeInstance(0, 0, getLocale());
        this._dateFormat.setTimeZone(getTimeZone());
        if (this._pattern != null) {
            ((SimpleDateFormat) this._dateFormat).applyPattern(this._pattern);
        }
    }
}
