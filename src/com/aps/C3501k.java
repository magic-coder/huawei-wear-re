package com.aps;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class C3501k {
    protected File f13185a;
    protected int[] f13186b;
    private ArrayList f13187c;
    private boolean f13188d = false;

    protected C3501k(File file, ArrayList arrayList, int[] iArr) {
        this.f13185a = file;
        this.f13187c = arrayList;
        this.f13186b = iArr;
    }

    protected final void m17531a(boolean z) {
        this.f13188d = z;
    }

    public byte[] m17532a() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Iterator it = this.f13187c.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            try {
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            } catch (IOException e) {
            }
        }
        try {
            byteArrayOutputStream.close();
            dataOutputStream.close();
        } catch (IOException e2) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    protected final boolean m17533b() {
        return this.f13188d;
    }

    protected final int m17534c() {
        if (this.f13187c == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f13187c.size(); i2++) {
            i += this.f13187c.get(i2) != null ? ((byte[]) this.f13187c.get(i2)).length : 0;
        }
        return i;
    }
}
