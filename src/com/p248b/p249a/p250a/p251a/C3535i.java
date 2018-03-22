package com.p248b.p249a.p250a.p251a;

import android.util.Log;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/* compiled from: GaiaLink */
class C3535i extends Thread {
    private static /* synthetic */ int[] f13354h;
    byte[] f13355a;
    int f13356b;
    int f13357c;
    int f13358d;
    boolean f13359e;
    DatagramSocket f13360f;
    final /* synthetic */ C3532f f13361g;

    private C3535i(C3532f c3532f) {
        this.f13361g = c3532f;
        this.f13355a = new byte[270];
        this.f13357c = 0;
        this.f13358d = 254;
        this.f13360f = null;
    }

    static /* synthetic */ int[] m17705a() {
        int[] iArr = f13354h;
        if (iArr == null) {
            iArr = new int[C3536j.values().length];
            try {
                iArr[C3536j.BT_GAIA.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C3536j.BT_SPP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C3536j.INET_UDP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f13354h = iArr;
        }
        return iArr;
    }

    public void run() {
        switch (C3535i.m17705a()[this.f13361g.f13340r.ordinal()]) {
            case 1:
            case 2:
                m17706b();
                break;
            case 3:
                m17707c();
                break;
        }
        if (this.f13361g.f13337o == null) {
            Log.e("GaiaLink", "reader: no receive handler");
        } else {
            this.f13361g.f13337o.obtainMessage(C3534h.DISCONNECTED.ordinal()).sendToTarget();
        }
    }

    private void m17706b() {
        byte[] bArr = new byte[1024];
        this.f13359e = false;
        Log.i("GaiaLink", "runSppReader start...");
        if (this.f13361g.f13341s) {
            try {
                if (this.f13361g.f13333k != null) {
                    this.f13361g.f13333k = this.f13361g.f13343u.accept();
                    this.f13361g.f13334l = this.f13361g.f13333k.getInputStream();
                    this.f13361g.f13337o.obtainMessage(C3534h.CONNECTED.ordinal(), this.f13361g.f13331i.getAddress()).sendToTarget();
                    this.f13361g.f13342t = true;
                    this.f13361g.f13341s = false;
                    this.f13359e = true;
                } else {
                    this.f13361g.f13337o.obtainMessage(C3534h.ERROR.ordinal(), this.f13361g.f13331i.getAddress()).sendToTarget();
                    this.f13359e = false;
                }
            } catch (IOException e) {
                if (this.f13361g.f13327e) {
                    Log.e("GaiaLink", "runSppReader: accept: " + e.toString());
                }
                this.f13361g.f13337o.obtainMessage(C3534h.ERROR.ordinal(), e).sendToTarget();
                this.f13359e = false;
            }
        } else {
            this.f13361g.f13337o.obtainMessage(C3534h.CONNECTED.ordinal(), this.f13361g.f13331i.getAddress()).sendToTarget();
            this.f13361g.f13342t = true;
            this.f13359e = true;
        }
        while (this.f13359e) {
            try {
                int read = this.f13361g.f13334l.read(bArr);
                if (read < 0) {
                    this.f13359e = false;
                } else {
                    m17704a(bArr, read);
                    this.f13361g.m17698a(true);
                }
            } catch (IOException e2) {
                if (this.f13361g.f13327e) {
                    Log.e("GaiaLink", "runSppReader: read: " + e2.toString());
                }
                this.f13359e = false;
            }
        }
    }

    private void m17707c() {
        this.f13359e = false;
        if (this.f13361g.f13337o != null) {
            byte[] bArr = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 1024);
            try {
                this.f13360f = new DatagramSocket(7701);
                if (this.f13361g.f13327e) {
                    Log.i("GaiaLink", "rx skt on 7701");
                }
                this.f13359e = true;
            } catch (Exception e) {
                if (this.f13361g.f13327e) {
                    Log.e("GaiaLink", "runUdpReader: " + e.toString());
                }
                e.printStackTrace();
            }
            while (this.f13359e) {
                try {
                    this.f13360f.receive(datagramPacket);
                    int length = datagramPacket.getLength();
                    if (this.f13361g.f13328f) {
                        Log.i("GaiaLink", "rx " + length);
                    }
                    if (length < 0) {
                        this.f13359e = false;
                    } else {
                        m17704a(bArr, length);
                    }
                } catch (IOException e2) {
                    if (this.f13361g.f13327e) {
                        Log.e("GaiaLink", "runUdpReader: " + e2.toString());
                    }
                    e2.printStackTrace();
                    this.f13359e = false;
                }
            }
            if (this.f13361g.f13327e) {
                Log.e("GaiaLink", "going exit");
            }
        } else if (this.f13361g.f13327e) {
            Log.e("GaiaLink", "No receive_handler");
        }
    }

    private void m17704a(byte[] bArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f13357c > 0 && this.f13357c < 270) {
                this.f13355a[this.f13357c] = bArr[i2];
                if (this.f13357c == 2) {
                    this.f13356b = bArr[i2];
                } else if (this.f13357c == 3) {
                    int i3;
                    int i4 = bArr[i2] + 8;
                    if ((this.f13356b & 1) != 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    this.f13358d = i3 + i4;
                    if (this.f13361g.f13328f) {
                        Log.d("GaiaLink", "expect " + this.f13358d);
                    }
                }
                this.f13357c++;
                if (this.f13357c == this.f13358d) {
                    if (this.f13361g.f13328f) {
                        Log.d("GaiaLink", "got " + this.f13358d);
                    }
                    if (this.f13361g.f13337o != null) {
                        C3531e c3531e = new C3531e(this.f13355a, this.f13357c);
                        this.f13361g.m17665a(c3531e);
                        if (c3531e.m17656c() != C3529c.START || this.f13361g.f13342t) {
                            if (this.f13361g.f13327e) {
                                Log.i("GaiaLink", "unhandled " + C3528b.m17641a(c3531e.m17661h()));
                            }
                            this.f13361g.f13337o.obtainMessage(C3534h.UNHANDLED.ordinal(), c3531e).sendToTarget();
                        } else {
                            if (this.f13361g.f13327e) {
                                Log.i("GaiaLink", "start");
                            }
                            this.f13361g.f13337o.obtainMessage(C3534h.CONNECTED.ordinal(), this.f13361g.f13331i.getAddress()).sendToTarget();
                            this.f13361g.f13342t = true;
                        }
                    } else if (this.f13361g.f13327e) {
                        Log.e("GaiaLink", "No receiver");
                    }
                    this.f13357c = 0;
                    this.f13358d = 254;
                }
            } else if (bArr[i2] == (byte) -1) {
                this.f13357c = 1;
            }
        }
    }
}
