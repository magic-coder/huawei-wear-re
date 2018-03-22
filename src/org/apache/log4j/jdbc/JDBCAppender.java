package org.apache.log4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class JDBCAppender extends AppenderSkeleton implements Appender {
    protected ArrayList buffer = new ArrayList(this.bufferSize);
    protected int bufferSize = 1;
    protected Connection connection = null;
    protected String databasePassword = "mypassword";
    protected String databaseURL = "jdbc:odbc:myDB";
    protected String databaseUser = "me";
    private boolean locationInfo = false;
    protected ArrayList removes = new ArrayList(this.bufferSize);
    protected String sqlStatement = "";

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public void setLocationInfo(boolean z) {
        this.locationInfo = z;
    }

    public void append(LoggingEvent loggingEvent) {
        loggingEvent.getNDC();
        loggingEvent.getThreadName();
        loggingEvent.getMDCCopy();
        if (this.locationInfo) {
            loggingEvent.getLocationInformation();
        }
        loggingEvent.getRenderedMessage();
        loggingEvent.getThrowableStrRep();
        this.buffer.add(loggingEvent);
        if (this.buffer.size() >= this.bufferSize) {
            flushBuffer();
        }
    }

    protected String getLogStatement(LoggingEvent loggingEvent) {
        return getLayout().format(loggingEvent);
    }

    protected void execute(String str) throws SQLException {
        Connection connection;
        Throwable th;
        Statement statement = null;
        try {
            connection = getConnection();
            try {
                statement = connection.createStatement();
                statement.executeUpdate(str);
                if (statement != null) {
                    statement.close();
                }
                closeConnection(connection);
            } catch (Throwable th2) {
                th = th2;
                if (statement != null) {
                    statement.close();
                }
                closeConnection(connection);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            connection = null;
            if (statement != null) {
                statement.close();
            }
            closeConnection(connection);
            throw th;
        }
    }

    protected void closeConnection(Connection connection) {
    }

    protected Connection getConnection() throws SQLException {
        if (!DriverManager.getDrivers().hasMoreElements()) {
            setDriver("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        if (this.connection == null) {
            this.connection = DriverManager.getConnection(this.databaseURL, this.databaseUser, this.databasePassword);
        }
        return this.connection;
    }

    public void close() {
        flushBuffer();
        try {
            if (!(this.connection == null || this.connection.isClosed())) {
                this.connection.close();
            }
        } catch (Exception e) {
            this.errorHandler.error("Error closing connection", e, 0);
        }
        this.closed = true;
    }

    public void flushBuffer() {
        this.removes.ensureCapacity(this.buffer.size());
        Iterator it = this.buffer.iterator();
        while (it.hasNext()) {
            LoggingEvent loggingEvent = (LoggingEvent) it.next();
            try {
                execute(getLogStatement(loggingEvent));
            } catch (Exception e) {
                this.errorHandler.error("Failed to excute sql", e, 2);
            } finally {
                it = this.removes;
                it.add(loggingEvent);
            }
        }
        this.buffer.removeAll(this.removes);
        this.removes.clear();
    }

    public void finalize() {
        close();
    }

    public boolean requiresLayout() {
        return true;
    }

    public void setSql(String str) {
        this.sqlStatement = str;
        if (getLayout() == null) {
            setLayout(new PatternLayout(str));
        } else {
            ((PatternLayout) getLayout()).setConversionPattern(str);
        }
    }

    public String getSql() {
        return this.sqlStatement;
    }

    public void setUser(String str) {
        this.databaseUser = str;
    }

    public void setURL(String str) {
        this.databaseURL = str;
    }

    public void setPassword(String str) {
        this.databasePassword = str;
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
        this.buffer.ensureCapacity(this.bufferSize);
        this.removes.ensureCapacity(this.bufferSize);
    }

    public String getUser() {
        return this.databaseUser;
    }

    public String getURL() {
        return this.databaseURL;
    }

    public String getPassword() {
        return this.databasePassword;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setDriver(String str) {
        try {
            Class.forName(str);
        } catch (Exception e) {
            this.errorHandler.error("Failed to load driver", e, 0);
        }
    }
}
