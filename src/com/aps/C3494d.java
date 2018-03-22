package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

final class C3494d implements Serializable {
    protected int f13143a = 0;
    protected int f13144b = 0;
    protected int f13145c = 0;
    protected int f13146d = 0;
    protected int f13147e = 0;
    protected short f13148f = (short) 0;
    protected byte f13149g = (byte) 0;
    protected byte f13150h = (byte) 0;
    protected long f13151i = 0;
    protected long f13152j = 0;
    private byte f13153k = (byte) 1;

    C3494d() {
    }

    protected final Boolean m17525a(DataOutputStream dataOutputStream) {
        Boolean valueOf = Boolean.valueOf(false);
        if (dataOutputStream != null) {
            try {
                dataOutputStream.writeByte(this.f13153k);
                dataOutputStream.writeInt(this.f13143a);
                dataOutputStream.writeInt(this.f13144b);
                dataOutputStream.writeInt(this.f13145c);
                dataOutputStream.writeInt(this.f13146d);
                dataOutputStream.writeInt(this.f13147e);
                dataOutputStream.writeShort(this.f13148f);
                dataOutputStream.writeByte(this.f13149g);
                dataOutputStream.writeByte(this.f13150h);
                dataOutputStream.writeLong(this.f13151i);
                dataOutputStream.writeLong(this.f13152j);
                valueOf = Boolean.valueOf(true);
            } catch (IOException e) {
            }
        }
        return valueOf;
    }
}
