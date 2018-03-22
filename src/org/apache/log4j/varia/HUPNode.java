package org.apache.log4j.varia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import org.apache.log4j.helpers.LogLog;

/* compiled from: ExternallyRolledFileAppender */
class HUPNode implements Runnable {
    DataInputStream dis;
    DataOutputStream dos;
    ExternallyRolledFileAppender er;
    Socket socket;

    public HUPNode(Socket socket, ExternallyRolledFileAppender externallyRolledFileAppender) {
        this.socket = socket;
        this.er = externallyRolledFileAppender;
        try {
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
        } catch (InterruptedIOException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (RuntimeException e3) {
            e3.printStackTrace();
        }
    }

    public void run() {
        try {
            String readUTF = this.dis.readUTF();
            LogLog.debug("Got external roll over signal.");
            if (ExternallyRolledFileAppender.ROLL_OVER.equals(readUTF)) {
                synchronized (this.er) {
                    this.er.rollOver();
                }
                this.dos.writeUTF(ExternallyRolledFileAppender.OK);
            } else {
                this.dos.writeUTF("Expecting [RollOver] string.");
            }
            this.dos.close();
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            LogLog.error("Unexpected exception. Exiting HUPNode.", e);
        } catch (Throwable e2) {
            LogLog.error("Unexpected exception. Exiting HUPNode.", e2);
        } catch (Throwable e22) {
            LogLog.error("Unexpected exception. Exiting HUPNode.", e22);
        }
    }
}
