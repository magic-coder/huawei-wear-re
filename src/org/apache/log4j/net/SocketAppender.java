package org.apache.log4j.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public class SocketAppender extends AppenderSkeleton {
    public static final int DEFAULT_PORT = 4560;
    static final int DEFAULT_RECONNECTION_DELAY = 30000;
    private static final int RESET_FREQUENCY = 1;
    public static final String ZONE = "_log4j_obj_tcpconnect_appender.local.";
    InetAddress address;
    private boolean advertiseViaMulticastDNS;
    private String application;
    private Connector connector;
    int counter = 0;
    boolean locationInfo = false;
    ObjectOutputStream oos;
    int port = DEFAULT_PORT;
    int reconnectionDelay = 30000;
    String remoteHost;
    private ZeroConfSupport zeroConf;

    class Connector extends Thread {
        boolean interrupted = false;
        private final SocketAppender this$0;

        Connector(SocketAppender socketAppender) {
            this.this$0 = socketAppender;
        }

        public void run() {
            while (!this.interrupted) {
                try {
                    sleep((long) this.this$0.reconnectionDelay);
                    LogLog.debug(new StringBuffer().append("Attempting connection to ").append(this.this$0.address.getHostName()).toString());
                    Socket socket = new Socket(this.this$0.address, this.this$0.port);
                    synchronized (this) {
                        this.this$0.oos = new ObjectOutputStream(socket.getOutputStream());
                        SocketAppender.access$002(this.this$0, null);
                        LogLog.debug("Connection established. Exiting connector thread.");
                    }
                    return;
                } catch (InterruptedException e) {
                    LogLog.debug("Connector interrupted. Leaving loop.");
                    return;
                } catch (ConnectException e2) {
                    LogLog.debug(new StringBuffer().append("Remote host ").append(this.this$0.address.getHostName()).append(" refused connection.").toString());
                } catch (IOException e3) {
                    if (e3 instanceof InterruptedIOException) {
                        Thread.currentThread().interrupt();
                    }
                    LogLog.debug(new StringBuffer().append("Could not connect to ").append(this.this$0.address.getHostName()).append(". Exception is ").append(e3).toString());
                }
            }
        }
    }

    static Connector access$002(SocketAppender socketAppender, Connector connector) {
        socketAppender.connector = connector;
        return connector;
    }

    public SocketAppender(InetAddress inetAddress, int i) {
        this.address = inetAddress;
        this.remoteHost = inetAddress.getHostName();
        this.port = i;
        connect(inetAddress, i);
    }

    public SocketAppender(String str, int i) {
        this.port = i;
        this.address = getAddressByName(str);
        this.remoteHost = str;
        connect(this.address, i);
    }

    public void activateOptions() {
        if (this.advertiseViaMulticastDNS) {
            this.zeroConf = new ZeroConfSupport(ZONE, this.port, getName());
            this.zeroConf.advertise();
        }
        connect(this.address, this.port);
    }

    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            if (this.advertiseViaMulticastDNS) {
                this.zeroConf.unadvertise();
            }
            cleanUp();
        }
    }

    public void cleanUp() {
        if (this.oos != null) {
            try {
                this.oos.close();
            } catch (Throwable e) {
                if (e instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error("Could not close oos.", e);
            }
            this.oos = null;
        }
        if (this.connector != null) {
            this.connector.interrupted = true;
            this.connector = null;
        }
    }

    void connect(InetAddress inetAddress, int i) {
        if (this.address != null) {
            try {
                cleanUp();
                this.oos = new ObjectOutputStream(new Socket(inetAddress, i).getOutputStream());
            } catch (Exception e) {
                Exception exception = e;
                if (exception instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                String stringBuffer = new StringBuffer().append("Could not connect to remote log4j server at [").append(inetAddress.getHostName()).append("].").toString();
                if (this.reconnectionDelay > 0) {
                    stringBuffer = new StringBuffer().append(stringBuffer).append(" We will try again later.").toString();
                    fireConnector();
                } else {
                    stringBuffer = new StringBuffer().append(stringBuffer).append(" We are not retrying.").toString();
                    this.errorHandler.error(stringBuffer, exception, 0);
                }
                LogLog.error(stringBuffer);
            }
        }
    }

    public void append(LoggingEvent loggingEvent) {
        if (loggingEvent != null) {
            if (this.address == null) {
                this.errorHandler.error(new StringBuffer().append("No remote host is set for SocketAppender named \"").append(this.name).append("\".").toString());
            } else if (this.oos != null) {
                try {
                    if (this.locationInfo) {
                        loggingEvent.getLocationInformation();
                    }
                    if (this.application != null) {
                        loggingEvent.setProperty("application", this.application);
                    }
                    loggingEvent.getNDC();
                    loggingEvent.getThreadName();
                    loggingEvent.getMDCCopy();
                    loggingEvent.getRenderedMessage();
                    loggingEvent.getThrowableStrRep();
                    this.oos.writeObject(loggingEvent);
                    this.oos.flush();
                    int i = this.counter + 1;
                    this.counter = i;
                    if (i >= 1) {
                        this.counter = 0;
                        this.oos.reset();
                    }
                } catch (Exception e) {
                    if (e instanceof InterruptedIOException) {
                        Thread.currentThread().interrupt();
                    }
                    this.oos = null;
                    LogLog.warn(new StringBuffer().append("Detected problem with connection: ").append(e).toString());
                    if (this.reconnectionDelay > 0) {
                        fireConnector();
                    } else {
                        this.errorHandler.error("Detected problem with connection, not reconnecting.", e, 0);
                    }
                }
            }
        }
    }

    public void setAdvertiseViaMulticastDNS(boolean z) {
        this.advertiseViaMulticastDNS = z;
    }

    public boolean isAdvertiseViaMulticastDNS() {
        return this.advertiseViaMulticastDNS;
    }

    void fireConnector() {
        if (this.connector == null) {
            LogLog.debug("Starting a new connector thread.");
            this.connector = new Connector(this);
            this.connector.setDaemon(true);
            this.connector.setPriority(1);
            this.connector.start();
        }
    }

    static InetAddress getAddressByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Throwable e) {
            if ((e instanceof InterruptedIOException) || (e instanceof InterruptedException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error(new StringBuffer().append("Could not find address of [").append(str).append("].").toString(), e);
            return null;
        }
    }

    public boolean requiresLayout() {
        return false;
    }

    public void setRemoteHost(String str) {
        this.address = getAddressByName(str);
        this.remoteHost = str;
    }

    public String getRemoteHost() {
        return this.remoteHost;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public int getPort() {
        return this.port;
    }

    public void setLocationInfo(boolean z) {
        this.locationInfo = z;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public void setApplication(String str) {
        this.application = str;
    }

    public String getApplication() {
        return this.application;
    }

    public void setReconnectionDelay(int i) {
        this.reconnectionDelay = i;
    }

    public int getReconnectionDelay() {
        return this.reconnectionDelay;
    }
}
