package org.apache.log4j.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public class TelnetAppender extends AppenderSkeleton {
    private int port = 23;
    private SocketHandler sh;

    public class SocketHandler extends Thread {
        private int MAX_CONNECTIONS = 20;
        private Vector connections = new Vector();
        private ServerSocket serverSocket;
        private final TelnetAppender this$0;
        private Vector writers = new Vector();

        public void finalize() {
            close();
        }

        public void close() {
            synchronized (this) {
                Enumeration elements = this.connections.elements();
                while (elements.hasMoreElements()) {
                    try {
                        ((Socket) elements.nextElement()).close();
                    } catch (InterruptedIOException e) {
                        Thread.currentThread().interrupt();
                    } catch (IOException e2) {
                    } catch (RuntimeException e3) {
                    }
                }
            }
            try {
                this.serverSocket.close();
            } catch (InterruptedIOException e4) {
                Thread.currentThread().interrupt();
            } catch (IOException e5) {
            } catch (RuntimeException e6) {
            }
        }

        public synchronized void send(String str) {
            Iterator it = this.connections.iterator();
            Iterator it2 = this.writers.iterator();
            while (it2.hasNext()) {
                it.next();
                PrintWriter printWriter = (PrintWriter) it2.next();
                printWriter.print(str);
                if (printWriter.checkError()) {
                    it.remove();
                    it2.remove();
                }
            }
        }

        public void run() {
            while (!this.serverSocket.isClosed()) {
                try {
                    Socket accept = this.serverSocket.accept();
                    PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
                    if (this.connections.size() < this.MAX_CONNECTIONS) {
                        synchronized (this) {
                            this.connections.addElement(accept);
                            this.writers.addElement(printWriter);
                            printWriter.print(new StringBuffer().append("TelnetAppender v1.0 (").append(this.connections.size()).append(" active connections)\r\n\r\n").toString());
                            printWriter.flush();
                        }
                    } else {
                        printWriter.print("Too many connections.\r\n");
                        printWriter.flush();
                        accept.close();
                    }
                } catch (Throwable e) {
                    if ((e instanceof InterruptedIOException) || (e instanceof InterruptedException)) {
                        Thread.currentThread().interrupt();
                    }
                    if (!this.serverSocket.isClosed()) {
                        LogLog.error("Encountered error while in SocketHandler loop.", e);
                    }
                }
            }
            try {
                this.serverSocket.close();
            } catch (InterruptedIOException e2) {
                Thread.currentThread().interrupt();
            } catch (IOException e3) {
            }
        }

        public SocketHandler(TelnetAppender telnetAppender, int i) throws IOException {
            this.this$0 = telnetAppender;
            this.serverSocket = new ServerSocket(i);
            setName(new StringBuffer().append("TelnetAppender-").append(getName()).append("-").append(i).toString());
        }
    }

    public boolean requiresLayout() {
        return true;
    }

    public void activateOptions() {
        try {
            this.sh = new SocketHandler(this, this.port);
            this.sh.start();
        } catch (InterruptedIOException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (RuntimeException e3) {
            e3.printStackTrace();
        }
        super.activateOptions();
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void close() {
        if (this.sh != null) {
            this.sh.close();
            try {
                this.sh.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    protected void append(LoggingEvent loggingEvent) {
        if (this.sh != null) {
            this.sh.send(this.layout.format(loggingEvent));
            if (this.layout.ignoresThrowable()) {
                String[] throwableStrRep = loggingEvent.getThrowableStrRep();
                if (throwableStrRep != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String append : throwableStrRep) {
                        stringBuffer.append(append);
                        stringBuffer.append("\r\n");
                    }
                    this.sh.send(stringBuffer.toString());
                }
            }
        }
    }
}
