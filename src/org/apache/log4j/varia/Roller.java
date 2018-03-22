package org.apache.log4j.varia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Roller {
    static Logger cat;
    static Class class$org$apache$log4j$varia$Roller;
    static String host;
    static int port;

    static {
        Class class$;
        if (class$org$apache$log4j$varia$Roller == null) {
            class$ = class$("org.apache.log4j.varia.Roller");
            class$org$apache$log4j$varia$Roller = class$;
        } else {
            class$ = class$org$apache$log4j$varia$Roller;
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

    Roller() {
    }

    public static void main(String[] strArr) {
        BasicConfigurator.configure();
        if (strArr.length == 2) {
            init(strArr[0], strArr[1]);
        } else {
            usage("Wrong number of arguments.");
        }
        roll();
    }

    static void usage(String str) {
        Class class$;
        System.err.println(str);
        PrintStream printStream = System.err;
        StringBuffer append = new StringBuffer().append("Usage: java ");
        if (class$org$apache$log4j$varia$Roller == null) {
            class$ = class$("org.apache.log4j.varia.Roller");
            class$org$apache$log4j$varia$Roller = class$;
        } else {
            class$ = class$org$apache$log4j$varia$Roller;
        }
        printStream.println(append.append(class$.getName()).append("host_name port_number").toString());
        System.exit(1);
    }

    static void init(String str, String str2) {
        host = str;
        try {
            port = Integer.parseInt(str2);
        } catch (NumberFormatException e) {
            usage(new StringBuffer().append("Second argument ").append(str2).append(" is not a valid integer.").toString());
        }
    }

    static void roll() {
        try {
            Socket socket = new Socket(host, port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(ExternallyRolledFileAppender.ROLL_OVER);
            String readUTF = dataInputStream.readUTF();
            if (ExternallyRolledFileAppender.OK.equals(readUTF)) {
                cat.info("Roll over signal acknowledged by remote appender.");
            } else {
                cat.warn(new StringBuffer().append("Unexpected return code ").append(readUTF).append(" from remote entity.").toString());
                System.exit(2);
            }
        } catch (Throwable e) {
            cat.error(new StringBuffer().append("Could not send roll signal on host ").append(host).append(" port ").append(port).append(" .").toString(), e);
            System.exit(2);
        }
        System.exit(0);
    }
}
