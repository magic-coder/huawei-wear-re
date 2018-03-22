package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final class C3497g implements Serializable {
    protected byte f13166a = (byte) 0;
    protected ArrayList f13167b = new ArrayList();
    private byte f13168c = (byte) 3;

    C3497g() {
    }

    protected final Boolean m17529a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f13168c);
            dataOutputStream.writeByte(this.f13166a);
            for (int i = 0; i < this.f13167b.size(); i++) {
                C3498h c3498h = (C3498h) this.f13167b.get(i);
                dataOutputStream.writeByte(c3498h.f13169a);
                Object obj = new byte[c3498h.f13169a];
                System.arraycopy(c3498h.f13170b, 0, obj, 0, c3498h.f13169a < c3498h.f13170b.length ? c3498h.f13169a : c3498h.f13170b.length);
                dataOutputStream.write(obj);
                dataOutputStream.writeDouble(c3498h.f13171c);
                dataOutputStream.writeInt(c3498h.f13172d);
                dataOutputStream.writeInt(c3498h.f13173e);
                dataOutputStream.writeDouble(c3498h.f13174f);
                dataOutputStream.writeByte(c3498h.f13175g);
                dataOutputStream.writeByte(c3498h.f13176h);
                obj = new byte[c3498h.f13176h];
                System.arraycopy(c3498h.f13177i, 0, obj, 0, c3498h.f13176h < c3498h.f13177i.length ? c3498h.f13176h : c3498h.f13177i.length);
                dataOutputStream.write(obj);
                dataOutputStream.writeByte(c3498h.f13178j);
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }
}
