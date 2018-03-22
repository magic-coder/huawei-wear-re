package org.apache.log4j.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.CyclicBuffer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public class SocketHubAppender extends AppenderSkeleton {
    static final int DEFAULT_PORT = 4560;
    public static final String ZONE = "_log4j_obj_tcpaccept_appender.local.";
    private boolean advertiseViaMulticastDNS;
    private String application;
    private CyclicBuffer buffer = null;
    private boolean locationInfo = false;
    private Vector oosList = new Vector();
    private int port = 4560;
    private ServerMonitor serverMonitor = null;
    private ServerSocket serverSocket;
    private ZeroConfSupport zeroConf;

    class ServerMonitor implements Runnable {
        private boolean keepRunning = true;
        private Thread monitorThread = new Thread(this);
        private Vector oosList;
        private int port;
        private final SocketHubAppender this$0;

        public ServerMonitor(SocketHubAppender socketHubAppender, int i, Vector vector) {
            this.this$0 = socketHubAppender;
            this.port = i;
            this.oosList = vector;
            this.monitorThread.setDaemon(true);
            this.monitorThread.setName(new StringBuffer().append("SocketHubAppender-Monitor-").append(this.port).toString());
            this.monitorThread.start();
        }

        public synchronized void stopMonitor() {
            if (this.keepRunning) {
                LogLog.debug("server monitor thread shutting down");
                this.keepRunning = false;
                try {
                    if (SocketHubAppender.access$000(this.this$0) != null) {
                        SocketHubAppender.access$000(this.this$0).close();
                        SocketHubAppender.access$002(this.this$0, null);
                    }
                } catch (IOException e) {
                }
                try {
                    this.monitorThread.join();
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
                this.monitorThread = null;
                LogLog.debug("server monitor thread shut down");
            }
        }

        private void sendCachedEvents(ObjectOutputStream objectOutputStream) throws IOException {
            if (SocketHubAppender.access$100(this.this$0) != null) {
                for (int i = 0; i < SocketHubAppender.access$100(this.this$0).length(); i++) {
                    objectOutputStream.writeObject(SocketHubAppender.access$100(this.this$0).get(i));
                }
                objectOutputStream.flush();
                objectOutputStream.reset();
            }
        }

        public void run() {
            SocketHubAppender.access$002(this.this$0, null);
            try {
                SocketHubAppender.access$002(this.this$0, this.this$0.createServerSocket(this.port));
                SocketHubAppender.access$000(this.this$0).setSoTimeout(1000);
                try {
                    SocketHubAppender.access$000(this.this$0).setSoTimeout(1000);
                    while (this.keepRunning) {
                        Socket accept;
                        try {
                            accept = SocketHubAppender.access$000(this.this$0).accept();
                        } catch (InterruptedIOException e) {
                            accept = null;
                        } catch (Throwable e2) {
                            LogLog.error("exception accepting socket, shutting down server socket.", e2);
                            this.keepRunning = false;
                            accept = null;
                        } catch (Throwable e22) {
                            LogLog.error("exception accepting socket.", e22);
                            accept = null;
                        }
                        if (accept != null) {
                            try {
                                InetAddress inetAddress = accept.getInetAddress();
                                LogLog.debug(new StringBuffer().append("accepting connection from ").append(inetAddress.getHostName()).append(" (").append(inetAddress.getHostAddress()).append(")").toString());
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                                if (SocketHubAppender.access$100(this.this$0) != null && SocketHubAppender.access$100(this.this$0).length() > 0) {
                                    sendCachedEvents(objectOutputStream);
                                }
                                this.oosList.addElement(objectOutputStream);
                            } catch (Throwable e222) {
                                if (e222 instanceof InterruptedIOException) {
                                    Thread.currentThread().interrupt();
                                }
                                LogLog.error("exception creating output stream on socket.", e222);
                            } catch (Throwable th) {
                                try {
                                    SocketHubAppender.access$000(this.this$0).close();
                                } catch (InterruptedIOException e3) {
                                    Thread.currentThread().interrupt();
                                } catch (IOException e4) {
                                }
                            }
                        }
                    }
                    try {
                        SocketHubAppender.access$000(this.this$0).close();
                    } catch (InterruptedIOException e5) {
                        Thread.currentThread().interrupt();
                    } catch (IOException e6) {
                    }
                } catch (Throwable e2222) {
                    LogLog.error("exception setting timeout, shutting down server socket.", e2222);
                    try {
                        SocketHubAppender.access$000(this.this$0).close();
                    } catch (InterruptedIOException e7) {
                        Thread.currentThread().interrupt();
                    } catch (IOException e8) {
                    }
                }
            } catch (Throwable e22222) {
                if ((e22222 instanceof InterruptedIOException) || (e22222 instanceof InterruptedException)) {
                    Thread.currentThread().interrupt();
                }
                LogLog.error("exception setting timeout, shutting down server socket.", e22222);
                this.keepRunning = false;
            }
        }
    }

    static ServerSocket access$000(SocketHubAppender socketHubAppender) {
        return socketHubAppender.serverSocket;
    }

    static ServerSocket access$002(SocketHubAppender socketHubAppender, ServerSocket serverSocket) {
        socketHubAppender.serverSocket = serverSocket;
        return serverSocket;
    }

    static CyclicBuffer access$100(SocketHubAppender socketHubAppender) {
        return socketHubAppender.buffer;
    }

    public SocketHubAppender(int i) {
        this.port = i;
        startServer();
    }

    public void activateOptions() {
        if (this.advertiseViaMulticastDNS) {
            this.zeroConf = new ZeroConfSupport(ZONE, this.port, getName());
            this.zeroConf.advertise();
        }
        startServer();
    }

    public synchronized void close() {
        if (!this.closed) {
            LogLog.debug(new StringBuffer().append("closing SocketHubAppender ").append(getName()).toString());
            this.closed = true;
            if (this.advertiseViaMulticastDNS) {
                this.zeroConf.unadvertise();
            }
            cleanUp();
            LogLog.debug(new StringBuffer().append("SocketHubAppender ").append(getName()).append(" closed").toString());
        }
    }

    public void cleanUp() {
        LogLog.debug("stopping ServerSocket");
        this.serverMonitor.stopMonitor();
        this.serverMonitor = null;
        LogLog.debug("closing client connections");
        while (this.oosList.size() != 0) {
            ObjectOutputStream objectOutputStream = (ObjectOutputStream) this.oosList.elementAt(0);
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Throwable e) {
                    Thread.currentThread().interrupt();
                    LogLog.error("could not close oos.", e);
                } catch (Throwable e2) {
                    LogLog.error("could not close oos.", e2);
                }
                this.oosList.removeElementAt(0);
            }
        }
    }

    public void append(LoggingEvent loggingEvent) {
        if (loggingEvent != null) {
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
            if (this.buffer != null) {
                this.buffer.add(loggingEvent);
            }
        }
        if (loggingEvent != null && this.oosList.size() != 0) {
            int i = 0;
            while (i < this.oosList.size()) {
                ObjectOutputStream objectOutputStream;
                try {
                    objectOutputStream = (ObjectOutputStream) this.oosList.elementAt(i);
                } catch (ArrayIndexOutOfBoundsException e) {
                    objectOutputStream = null;
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.writeObject(loggingEvent);
                        objectOutputStream.flush();
                        objectOutputStream.reset();
                    } catch (IOException e2) {
                        if (e2 instanceof InterruptedIOException) {
                            Thread.currentThread().interrupt();
                        }
                        this.oosList.removeElementAt(i);
                        LogLog.debug("dropped connection");
                        i--;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean requiresLayout() {
        return false;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setApplication(String str) {
        this.application = str;
    }

    public String getApplication() {
        return this.application;
    }

    public int getPort() {
        return this.port;
    }

    public void setBufferSize(int i) {
        this.buffer = new CyclicBuffer(i);
    }

    public int getBufferSize() {
        if (this.buffer == null) {
            return 0;
        }
        return this.buffer.getMaxSize();
    }

    public void setLocationInfo(boolean z) {
        this.locationInfo = z;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public void setAdvertiseViaMulticastDNS(boolean z) {
        this.advertiseViaMulticastDNS = z;
    }

    public boolean isAdvertiseViaMulticastDNS() {
        return this.advertiseViaMulticastDNS;
    }

    private void startServer() {
        this.serverMonitor = new ServerMonitor(this, this.port, this.oosList);
    }

    protected ServerSocket createServerSocket(int i) throws IOException {
        return new ServerSocket(i);
    }
}
