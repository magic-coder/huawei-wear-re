package org.apache.log4j.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class SimpleSocketServer {
    static Logger cat;
    static Class class$org$apache$log4j$net$SimpleSocketServer;
    static int port;

    static {
        Class class$;
        if (class$org$apache$log4j$net$SimpleSocketServer == null) {
            class$ = class$("org.apache.log4j.net.SimpleSocketServer");
            class$org$apache$log4j$net$SimpleSocketServer = class$;
        } else {
            class$ = class$org$apache$log4j$net$SimpleSocketServer;
        }
        cat = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length == 2) {
            init(strArr[0], strArr[1]);
        } else {
            usage("Wrong number of arguments.");
        }
        try {
            cat.info(new StringBuffer().append("Listening on port ").append(port).toString());
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                cat.info("Waiting to accept a new client.");
                Socket accept = serverSocket.accept();
                cat.info(new StringBuffer().append("Connected to client at ").append(accept.getInetAddress()).toString());
                cat.info("Starting new socket node.");
                new Thread(new SocketNode(accept, LogManager.getLoggerRepository()), new StringBuffer().append("SimpleSocketServer-").append(port).toString()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void usage(String str) {
        Class class$;
        System.err.println(str);
        PrintStream printStream = System.err;
        StringBuffer append = new StringBuffer().append("Usage: java ");
        if (class$org$apache$log4j$net$SimpleSocketServer == null) {
            class$ = class$("org.apache.log4j.net.SimpleSocketServer");
            class$org$apache$log4j$net$SimpleSocketServer = class$;
        } else {
            class$ = class$org$apache$log4j$net$SimpleSocketServer;
        }
        printStream.println(append.append(class$.getName()).append(" port configFile").toString());
        System.exit(1);
    }

    static void init(String str, String str2) {
        try {
            port = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            usage(new StringBuffer().append("Could not interpret port number [").append(str).append("].").toString());
        }
        if (str2.endsWith(".xml")) {
            DOMConfigurator.configure(str2);
        } else {
            PropertyConfigurator.configure(str2);
        }
    }
}
