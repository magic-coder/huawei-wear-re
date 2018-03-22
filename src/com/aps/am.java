package com.aps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;

public final class am {
    private RandomAccessFile f12906a;
    private C3502l f12907b;
    private File f12908c = null;

    protected am(C3502l c3502l) {
        this.f12907b = c3502l;
    }

    private static byte m17273a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, bArr3.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            gZIPInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e) {
        }
        return bArr2[0];
    }

    private static int m17274a(int i, int i2, int i3) {
        int i4 = ((i3 - 1) * 1500) + i;
        while (i4 >= i2) {
            i4 -= 1500;
        }
        return i4;
    }

    private int m17275a(BitSet bitSet) {
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                return this.f12907b.m17550a() + ((i * 1500) + 4);
            }
        }
        return 0;
    }

    private ArrayList m17276a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            try {
                this.f12906a.seek((long) i);
                int readInt = this.f12906a.readInt();
                this.f12906a.readLong();
                if (readInt <= 0 || readInt > 1500) {
                    return null;
                }
                byte[] bArr = new byte[readInt];
                this.f12906a.read(bArr);
                byte a = m17273a(bArr);
                if (a != (byte) 3 && a != (byte) 4 && a != (byte) 41) {
                    return null;
                }
                arrayList.add(bArr);
                i += 1500;
            } catch (IOException e) {
            }
        }
        return arrayList;
    }

    private BitSet m17277b() {
        BitSet bitSet = null;
        byte[] bArr = new byte[this.f12907b.m17550a()];
        try {
            this.f12906a.read(bArr);
            bitSet = C3502l.m17544b(bArr);
        } catch (IOException e) {
        }
        return bitSet;
    }

    protected final int m17278a() {
        int i = 0;
        synchronized (this) {
            this.f12908c = this.f12907b.m17553b();
            try {
                if (this.f12908c != null) {
                    this.f12906a = new RandomAccessFile(this.f12907b.m17553b(), "rw");
                    byte[] bArr = new byte[this.f12907b.m17550a()];
                    this.f12906a.read(bArr);
                    BitSet b = C3502l.m17544b(bArr);
                    for (int i2 = 0; i2 < b.size(); i2++) {
                        if (b.get(i2)) {
                            i++;
                        }
                    }
                }
                if (this.f12906a != null) {
                    try {
                        this.f12906a.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (this.f12906a != null) {
                    try {
                        this.f12906a.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                if (this.f12906a != null) {
                    try {
                        this.f12906a.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (NullPointerException e6) {
                if (this.f12906a != null) {
                    try {
                        this.f12906a.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (Throwable th) {
                if (this.f12906a != null) {
                    try {
                        this.f12906a.close();
                    } catch (IOException e8) {
                    }
                }
            }
            this.f12908c = null;
        }
        return i;
    }

    protected final synchronized C3501k m17279a(int i) {
        C3501k c3501k = null;
        synchronized (this) {
            if (this.f12907b != null) {
                synchronized (this) {
                    this.f12908c = this.f12907b.m17553b();
                    if (this.f12908c == null) {
                    } else {
                        C3501k c3501k2;
                        try {
                            this.f12906a = new RandomAccessFile(this.f12908c, "rw");
                            BitSet b = m17277b();
                            if (b == null) {
                                this.f12908c.delete();
                                if (this.f12906a != null) {
                                    try {
                                        this.f12906a.close();
                                    } catch (Exception e) {
                                    }
                                }
                            } else {
                                int a = m17275a(b);
                                ArrayList a2 = m17276a(a, m17274a(a, (int) this.f12908c.length(), i));
                                if (a2 == null) {
                                    this.f12908c.delete();
                                    if (this.f12906a != null) {
                                        try {
                                            this.f12906a.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                } else {
                                    c3501k2 = new C3501k(this.f12908c, a2, new int[]{((a - this.f12907b.m17550a()) - 4) / 1500, ((r2 - this.f12907b.m17550a()) - 4) / 1500});
                                    if (this.f12906a != null) {
                                        try {
                                            this.f12906a.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    if (c3501k2 != null) {
                                        if (c3501k2.m17534c() > 100 && c3501k2.m17534c() < 5242880) {
                                            c3501k = c3501k2;
                                        }
                                    }
                                    this.f12908c.delete();
                                    this.f12908c = null;
                                }
                            }
                        } catch (FileNotFoundException e4) {
                            if (this.f12906a != null) {
                                try {
                                    this.f12906a.close();
                                    c3501k2 = null;
                                } catch (Exception e5) {
                                    c3501k2 = null;
                                }
                            }
                            c3501k2 = null;
                        } catch (Exception e6) {
                            if (this.f12906a != null) {
                                try {
                                    this.f12906a.close();
                                    c3501k2 = null;
                                } catch (Exception e7) {
                                    c3501k2 = null;
                                }
                            }
                            c3501k2 = null;
                        } catch (Throwable th) {
                            if (this.f12906a != null) {
                                try {
                                    this.f12906a.close();
                                } catch (Exception e8) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return c3501k;
    }

    protected final synchronized void m17280a(C3501k c3501k) {
        BitSet bitSet = null;
        synchronized (this) {
            synchronized (this) {
                this.f12908c = c3501k.f13185a;
                if (this.f12908c == null) {
                } else {
                    try {
                        this.f12906a = new RandomAccessFile(this.f12908c, "rw");
                        byte[] bArr = new byte[this.f12907b.m17550a()];
                        this.f12906a.read(bArr);
                        bitSet = C3502l.m17544b(bArr);
                        if (c3501k.m17533b()) {
                            for (int i = c3501k.f13186b[0]; i <= c3501k.f13186b[1]; i++) {
                                bitSet.set(i, false);
                            }
                            this.f12906a.seek(0);
                            this.f12906a.write(C3502l.m17540a(bitSet));
                        }
                        if (this.f12906a != null) {
                            try {
                                this.f12906a.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        if (this.f12906a != null) {
                            try {
                                this.f12906a.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (IOException e4) {
                        if (this.f12906a != null) {
                            try {
                                this.f12906a.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (Throwable th) {
                        if (this.f12906a != null) {
                            try {
                                this.f12906a.close();
                            } catch (IOException e6) {
                            }
                        }
                    }
                    if (bitSet.isEmpty()) {
                        this.f12908c.delete();
                    }
                    this.f12908c = null;
                }
            }
        }
        return;
    }
}
