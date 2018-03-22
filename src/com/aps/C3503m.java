package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

final class C3503m implements Serializable {
    protected int f13193a = 0;
    protected int f13194b = 0;
    protected short f13195c = (short) 0;
    protected short f13196d = (short) 0;
    protected int f13197e = 0;
    protected byte f13198f = (byte) 0;
    private byte f13199g = (byte) 4;

    C3503m() {
    }

    protected final Boolean m17555a(DataOutputStream dataOutputStream) {
        Boolean valueOf = Boolean.valueOf(false);
        try {
            dataOutputStream.writeByte(this.f13199g);
            dataOutputStream.writeInt(this.f13193a);
            dataOutputStream.writeInt(this.f13194b);
            dataOutputStream.writeShort(this.f13195c);
            dataOutputStream.writeShort(this.f13196d);
            dataOutputStream.writeInt(this.f13197e);
            dataOutputStream.writeByte(this.f13198f);
            valueOf = Boolean.valueOf(true);
        } catch (IOException e) {
        }
        return valueOf;
    }
}
