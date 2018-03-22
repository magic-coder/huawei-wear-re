package org.apache.log4j.lf5.viewer;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;
import com.snowballtech.common.code.WSBaseMessageCode;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogTableColumn implements Serializable {
    public static final LogTableColumn CATEGORY = new LogTableColumn("Category");
    public static final LogTableColumn DATE = new LogTableColumn(WSBaseMessageCode.HEADER_DATE);
    public static final LogTableColumn LEVEL = new LogTableColumn("Level");
    public static final LogTableColumn LOCATION = new LogTableColumn("Location");
    public static final LogTableColumn MESSAGE = new LogTableColumn(XMLMessage.MESSAGE);
    public static final LogTableColumn MESSAGE_NUM = new LogTableColumn("Message #");
    public static final LogTableColumn NDC = new LogTableColumn("NDC");
    public static final LogTableColumn THREAD = new LogTableColumn("Thread");
    public static final LogTableColumn THROWN = new LogTableColumn("Thrown");
    private static LogTableColumn[] _log4JColumns = new LogTableColumn[]{DATE, THREAD, MESSAGE_NUM, LEVEL, NDC, CATEGORY, MESSAGE, LOCATION, THROWN};
    private static Map _logTableColumnMap = new HashMap();
    private static final long serialVersionUID = -4275827753626456547L;
    protected String _label;

    static {
        int i = 0;
        while (i < _log4JColumns.length) {
            _logTableColumnMap.put(_log4JColumns[i].getLabel(), _log4JColumns[i]);
            i++;
        }
    }

    public LogTableColumn(String str) {
        this._label = str;
    }

    public String getLabel() {
        return this._label;
    }

    public static LogTableColumn valueOf(String str) throws LogTableColumnFormatException {
        LogTableColumn logTableColumn = null;
        if (str != null) {
            str = str.trim();
            logTableColumn = (LogTableColumn) _logTableColumnMap.get(str);
        }
        if (logTableColumn != null) {
            return logTableColumn;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("Error while trying to parse (").append(str).append(") into").toString());
        stringBuffer.append(" a LogTableColumn.");
        throw new LogTableColumnFormatException(stringBuffer.toString());
    }

    public boolean equals(Object obj) {
        if ((obj instanceof LogTableColumn) && getLabel() == ((LogTableColumn) obj).getLabel()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this._label.hashCode();
    }

    public String toString() {
        return this._label;
    }

    public static List getLogTableColumns() {
        return Arrays.asList(_log4JColumns);
    }

    public static LogTableColumn[] getLogTableColumnArray() {
        return _log4JColumns;
    }
}
