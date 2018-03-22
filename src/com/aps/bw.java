package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final class bw implements Serializable {
    protected short f13072a = (short) 0;
    protected int f13073b = 0;
    protected byte f13074c = (byte) 0;
    protected byte f13075d = (byte) 0;
    protected ArrayList f13076e = new ArrayList();
    private byte f13077f = (byte) 2;

    bw() {
    }

    protected final Boolean m17466a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f13077f);
            dataOutputStream.writeShort(this.f13072a);
            dataOutputStream.writeInt(this.f13073b);
            dataOutputStream.writeByte(this.f13074c);
            dataOutputStream.writeByte(this.f13075d);
            for (byte b = (byte) 0; b < this.f13075d; b++) {
                dataOutputStream.writeShort(((C3504n) this.f13076e.get(b)).f13200a);
                dataOutputStream.writeInt(((C3504n) this.f13076e.get(b)).f13201b);
                dataOutputStream.writeByte(((C3504n) this.f13076e.get(b)).f13202c);
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }
}
