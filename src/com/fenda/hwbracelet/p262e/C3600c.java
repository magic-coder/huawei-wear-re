package com.fenda.hwbracelet.p262e;

import com.fenda.hwbracelet.p263f.C3608d;
import java.nio.ByteBuffer;

/* compiled from: XbMessage */
public class C3600c extends C3598a {
    private byte f13769b;
    private ByteBuffer f13770c = ByteBuffer.allocate(19);

    public C3600c(C3602e c3602e) {
        this.f13769b = c3602e.m18082a();
    }

    public void mo4216a(byte[] bArr) {
        this.f13770c.put(bArr);
    }

    public ByteBuffer mo4215a() {
        return this.f13770c;
    }

    public byte[] mo4217b() {
        ByteBuffer allocate = ByteBuffer.allocate(this.f13770c.position() + 1);
        allocate.put(this.f13769b);
        if (this.f13770c.position() > 0) {
            ByteBuffer duplicate = this.f13770c.duplicate();
            duplicate.flip();
            allocate.put(duplicate);
            duplicate.clear();
        }
        return allocate.array();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BleMessageType: ");
        stringBuilder.append(C3602e.m18081a(this.f13769b).name());
        stringBuilder.append(" MessageData: ");
        stringBuilder.append(C3608d.m18110a(mo4217b()));
        return stringBuilder.toString();
    }
}
