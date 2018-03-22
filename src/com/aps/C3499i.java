package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final class C3499i implements Serializable {
    protected byte f13179a = (byte) 0;
    protected ArrayList f13180b = new ArrayList();
    private byte f13181c = (byte) 8;

    C3499i() {
    }

    protected final Boolean m17530a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f13181c);
            dataOutputStream.writeByte(this.f13179a);
            for (byte b = (byte) 0; b < this.f13179a; b++) {
                C3500j c3500j = (C3500j) this.f13180b.get(b);
                dataOutputStream.write(c3500j.f13182a);
                dataOutputStream.writeShort(c3500j.f13183b);
                dataOutputStream.write(C3502l.m17542a(c3500j.f13184c, c3500j.f13184c.length));
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }
}
