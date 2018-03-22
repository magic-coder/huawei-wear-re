package com.aps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.BitSet;

public final class an {
    private RandomAccessFile f12909a;
    private C3502l f12910b;
    private String f12911c = "";
    private File f12912d = null;

    protected an(C3502l c3502l) {
        this.f12910b = c3502l;
    }

    protected final synchronized void m17281a(long j, byte[] bArr) {
        int i = 0;
        synchronized (this) {
            this.f12912d = this.f12910b.m17551a(j);
            if (this.f12912d != null) {
                try {
                    this.f12909a = new RandomAccessFile(this.f12912d, "rw");
                    byte[] bArr2 = new byte[this.f12910b.m17550a()];
                    int readInt = this.f12909a.read(bArr2) == -1 ? 0 : this.f12909a.readInt();
                    BitSet b = C3502l.m17544b(bArr2);
                    int a = (this.f12910b.m17550a() + 4) + (readInt * 1500);
                    if (readInt < 0 || readInt > (this.f12910b.m17550a() << 3)) {
                        this.f12909a.close();
                        this.f12912d.delete();
                        if (this.f12909a != null) {
                            try {
                                this.f12909a.close();
                            } catch (IOException e) {
                            }
                        }
                    } else {
                        this.f12909a.seek((long) a);
                        byte[] a2 = C3502l.m17541a(bArr);
                        this.f12909a.writeInt(a2.length);
                        this.f12909a.writeLong(j);
                        this.f12909a.write(a2);
                        b.set(readInt, true);
                        this.f12909a.seek(0);
                        this.f12909a.write(C3502l.m17540a(b));
                        readInt++;
                        if (readInt != (this.f12910b.m17550a() << 3)) {
                            i = readInt;
                        }
                        this.f12909a.writeInt(i);
                        if (!this.f12911c.equalsIgnoreCase(this.f12912d.getName())) {
                            this.f12911c = this.f12912d.getName();
                        }
                        this.f12912d.length();
                        if (this.f12909a != null) {
                            try {
                                this.f12909a.close();
                            } catch (IOException e2) {
                            }
                        }
                        this.f12912d = null;
                    }
                } catch (FileNotFoundException e3) {
                    if (this.f12909a != null) {
                        try {
                            this.f12909a.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IOException e5) {
                    if (this.f12909a != null) {
                        try {
                            this.f12909a.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (Throwable th) {
                    if (this.f12909a != null) {
                        try {
                            this.f12909a.close();
                        } catch (IOException e7) {
                        }
                    }
                }
            }
        }
        return;
    }
}
