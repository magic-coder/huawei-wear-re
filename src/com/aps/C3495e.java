package com.aps;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

final class C3495e implements Serializable {
    protected byte[] f13154a = new byte[16];
    protected byte[] f13155b = new byte[16];
    protected byte[] f13156c = new byte[16];
    protected short f13157d = (short) 0;
    protected short f13158e = (short) 0;
    protected byte f13159f = (byte) 0;
    protected byte[] f13160g = new byte[16];
    protected byte[] f13161h = new byte[32];
    protected short f13162i = (short) 0;
    protected ArrayList f13163j = new ArrayList();
    private byte f13164k = (byte) 41;
    private short f13165l = (short) 0;

    C3495e() {
    }

    private Boolean m17526a(DataOutputStream dataOutputStream) {
        Boolean.valueOf(true);
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream2.flush();
            dataOutputStream2.write(this.f13154a);
            dataOutputStream2.write(this.f13155b);
            dataOutputStream2.write(this.f13156c);
            dataOutputStream2.writeShort(this.f13157d);
            dataOutputStream2.writeShort(this.f13158e);
            dataOutputStream2.writeByte(this.f13159f);
            this.f13160g[15] = (byte) 0;
            dataOutputStream2.write(C3502l.m17542a(this.f13160g, this.f13160g.length));
            this.f13161h[31] = (byte) 0;
            dataOutputStream2.write(C3502l.m17542a(this.f13161h, this.f13161h.length));
            dataOutputStream2.writeShort(this.f13162i);
            for (short s = (short) 0; s < this.f13162i; s = (short) (s + 1)) {
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream3 = new DataOutputStream(byteArrayOutputStream2);
                dataOutputStream3.flush();
                by byVar = (by) this.f13163j.get(s);
                if (!(byVar.f13085c == null || byVar.f13085c.m17525a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(byVar.f13086d == null || byVar.f13086d.m17466a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(byVar.f13087e == null || byVar.f13087e.m17555a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(byVar.f13088f == null || byVar.f13088f.m17530a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(byVar.f13089g == null || byVar.f13089g.m17529a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                byVar.f13083a = Integer.valueOf(byteArrayOutputStream2.size() + 4).shortValue();
                dataOutputStream2.writeShort(byVar.f13083a);
                dataOutputStream2.writeInt(byVar.f13084b);
                dataOutputStream2.write(byteArrayOutputStream2.toByteArray());
            }
            this.f13165l = Integer.valueOf(byteArrayOutputStream.size()).shortValue();
            dataOutputStream.writeByte(this.f13164k);
            dataOutputStream.writeShort(this.f13165l);
            dataOutputStream.write(byteArrayOutputStream.toByteArray());
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }

    protected final byte[] m17527a() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m17526a(new DataOutputStream(byteArrayOutputStream));
        return byteArrayOutputStream.toByteArray();
    }
}
