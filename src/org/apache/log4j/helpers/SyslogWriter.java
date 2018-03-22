package org.apache.log4j.helpers;

import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;

public class SyslogWriter extends Writer {
    static String syslogHost;
    final int SYSLOG_PORT = 514;
    private InetAddress address;
    private DatagramSocket ds;
    private final int port;

    public SyslogWriter(String str) {
        syslogHost = str;
        if (str == null) {
            throw new NullPointerException("syslogHost");
        }
        int port;
        if (str.indexOf("[") != -1 || str.indexOf(58) == str.lastIndexOf(58)) {
            try {
                URL url = new URL(new StringBuffer().append("http://").append(str).toString());
                if (url.getHost() != null) {
                    str = url.getHost();
                    if (str.startsWith("[") && str.charAt(str.length() - 1) == ']') {
                        str = str.substring(1, str.length() - 1);
                    }
                    port = url.getPort();
                    if (port == -1) {
                        port = 514;
                    }
                    this.port = port;
                    this.address = InetAddress.getByName(str);
                    this.ds = new DatagramSocket();
                }
            } catch (Throwable e) {
                LogLog.error("Malformed URL: will attempt to interpret as InetAddress.", e);
            }
        }
        port = -1;
        if (port == -1) {
            port = 514;
        }
        this.port = port;
        try {
            this.address = InetAddress.getByName(str);
        } catch (Throwable e2) {
            LogLog.error(new StringBuffer().append("Could not find ").append(str).append(". All logging will FAIL.").toString(), e2);
        }
        try {
            this.ds = new DatagramSocket();
        } catch (Throwable e22) {
            e22.printStackTrace();
            LogLog.error(new StringBuffer().append("Could not instantiate DatagramSocket to ").append(str).append(". All logging will FAIL.").toString(), e22);
        }
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        write(new String(cArr, i, i2));
    }

    public void write(String str) throws IOException {
        int i = 1024;
        if (this.ds != null && this.address != null) {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length < 1024) {
                i = length;
            }
            this.ds.send(new DatagramPacket(bytes, i, this.address, this.port));
        }
    }

    public void flush() {
    }

    public void close() {
        if (this.ds != null) {
            this.ds.close();
        }
    }
}
