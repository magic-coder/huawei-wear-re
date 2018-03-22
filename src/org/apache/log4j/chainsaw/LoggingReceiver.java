package org.apache.log4j.chainsaw;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

class LoggingReceiver extends Thread {
    private static final Logger LOG;
    static Class class$org$apache$log4j$chainsaw$LoggingReceiver;
    private MyTableModel mModel;
    private ServerSocket mSvrSock;

    class Slurper implements Runnable {
        private final Socket mClient;
        private final LoggingReceiver this$0;

        Slurper(LoggingReceiver loggingReceiver, Socket socket) {
            this.this$0 = loggingReceiver;
            this.mClient = socket;
        }

        public void run() {
            LoggingReceiver.access$000().debug("Starting to get data");
            try {
                while (true) {
                    LoggingReceiver.access$100(this.this$0).addEvent(new EventDetails((LoggingEvent) new ObjectInputStream(this.mClient.getInputStream()).readObject()));
                }
            } catch (EOFException e) {
                LoggingReceiver.access$000().info("Reached EOF, closing connection");
                try {
                    this.mClient.close();
                } catch (Throwable e2) {
                    LoggingReceiver.access$000().warn("Error closing connection", e2);
                }
            } catch (SocketException e3) {
                LoggingReceiver.access$000().info("Caught SocketException, closing connection");
                this.mClient.close();
            } catch (Throwable e22) {
                LoggingReceiver.access$000().warn("Got IOException, closing connection", e22);
                this.mClient.close();
            } catch (Throwable e222) {
                LoggingReceiver.access$000().warn("Got ClassNotFoundException, closing connection", e222);
                this.mClient.close();
            }
        }
    }

    static Logger access$000() {
        return LOG;
    }

    static MyTableModel access$100(LoggingReceiver loggingReceiver) {
        return loggingReceiver.mModel;
    }

    static {
        Class class$;
        if (class$org$apache$log4j$chainsaw$LoggingReceiver == null) {
            class$ = class$("org.apache.log4j.chainsaw.LoggingReceiver");
            class$org$apache$log4j$chainsaw$LoggingReceiver = class$;
        } else {
            class$ = class$org$apache$log4j$chainsaw$LoggingReceiver;
        }
        LOG = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    LoggingReceiver(MyTableModel myTableModel, int i) throws IOException {
        setDaemon(true);
        this.mModel = myTableModel;
        this.mSvrSock = new ServerSocket(i);
    }

    public void run() {
        LOG.info("Thread started");
        while (true) {
            try {
                LOG.debug("Waiting for a connection");
                Socket accept = this.mSvrSock.accept();
                LOG.debug(new StringBuffer().append("Got a connection from ").append(accept.getInetAddress().getHostName()).toString());
                Thread thread = new Thread(new Slurper(this, accept));
                thread.setDaemon(true);
                thread.start();
            } catch (Throwable e) {
                LOG.error("Error in accepting connections, stopping.", e);
                return;
            }
        }
    }
}
