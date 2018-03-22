package com.p248b.p249a.p250a.p251a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.UUID;

/* compiled from: GaiaLink */
public class C3532f {
    private static final UUID f13322a = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final UUID f13323b = UUID.fromString("00001107-D102-11E1-9B23-00025B00A5A5");
    private static /* synthetic */ int[] f13324x;
    private C3527a f13325c;
    private final int f13326d;
    private boolean f13327e;
    private boolean f13328f;
    private boolean f13329g;
    private BluetoothAdapter f13330h;
    private BluetoothDevice f13331i;
    private DatagramSocket f13332j;
    private BluetoothSocket f13333k;
    private InputStream f13334l;
    private C3535i f13335m;
    private C3533g f13336n;
    private Handler f13337o;
    private Handler f13338p;
    private Handler f13339q;
    private C3536j f13340r;
    private boolean f13341s;
    private boolean f13342t;
    private BluetoothServerSocket f13343u;
    private BroadcastReceiver f13344v;
    private Context f13345w;

    static /* synthetic */ int[] m17678d() {
        int[] iArr = f13324x;
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
            f13324x = iArr;
        }
        return iArr;
    }

    public void m17698a(boolean z) {
        if (this.f13325c != null) {
            this.f13325c.m17639a(z);
        }
    }

    public C3532f() {
        this.f13326d = 1024;
        this.f13327e = true;
        this.f13328f = false;
        this.f13329g = false;
        this.f13330h = null;
        this.f13331i = null;
        this.f13332j = null;
        this.f13333k = null;
        this.f13334l = null;
        this.f13337o = null;
        this.f13338p = null;
        this.f13339q = null;
        this.f13340r = C3536j.BT_GAIA;
        this.f13341s = false;
        this.f13342t = false;
        this.f13330h = BluetoothAdapter.getDefaultAdapter();
    }

    public C3532f(C3536j c3536j) {
        this.f13326d = 1024;
        this.f13327e = true;
        this.f13328f = false;
        this.f13329g = false;
        this.f13330h = null;
        this.f13331i = null;
        this.f13332j = null;
        this.f13333k = null;
        this.f13334l = null;
        this.f13337o = null;
        this.f13338p = null;
        this.f13339q = null;
        this.f13340r = C3536j.BT_GAIA;
        this.f13341s = false;
        this.f13342t = false;
        this.f13330h = BluetoothAdapter.getDefaultAdapter();
        this.f13340r = c3536j;
    }

    public void m17697a(String str) throws IOException {
        if (this.f13341s || this.f13342t) {
            throw new IOException("Incorrect state");
        }
        switch (C3532f.m17678d()[this.f13340r.ordinal()]) {
            case 1:
            case 2:
                m17674b(str);
                return;
            case 3:
                m17676c(str);
                return;
            default:
                return;
        }
    }

    private boolean m17680e() {
        return VERSION.SDK_INT >= 10;
    }

    private void m17674b(String str) throws IOException {
        String toUpperCase = str.toUpperCase();
        if (!m17700a()) {
            throw new IOException("Bluetooth is not available");
        } else if (BluetoothAdapter.checkBluetoothAddress(toUpperCase)) {
            if (this.f13327e) {
                Log.i("GaiaLink", "connect BT " + str);
            }
            this.f13331i = this.f13330h.getRemoteDevice(toUpperCase);
            switch (C3532f.m17678d()[this.f13340r.ordinal()]) {
                case 1:
                    this.f13333k = m17664a(f13322a);
                    break;
                case 2:
                    this.f13333k = m17664a(f13323b);
                    break;
                default:
                    throw new IOException("Unsupported Transport " + this.f13340r.toString());
            }
            this.f13336n = new C3533g();
            this.f13336n.start();
        } else {
            throw new IOException("Illegal Bluetooth address");
        }
    }

    @TargetApi(10)
    private BluetoothSocket m17664a(UUID uuid) throws IOException {
        try {
            if (m17680e()) {
                return this.f13331i.createInsecureRfcommSocketToServiceRecord(uuid);
            }
            return this.f13331i.createRfcommSocketToServiceRecord(uuid);
        } catch (IOException e) {
            try {
                return (BluetoothSocket) this.f13331i.getClass().getMethod("createRfcommSocket", new Class[]{Integer.TYPE}).invoke(this.f13331i, new Object[]{Integer.valueOf(1)});
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                throw new IOException();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                throw new IOException();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                throw new IOException();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                throw new IOException();
            }
        }
    }

    private void m17676c(String str) throws IOException {
        this.f13332j = new DatagramSocket();
        this.f13332j.connect(InetAddress.getByName("10.0.2.2"), 7700);
        this.f13335m = new C3535i();
        this.f13335m.start();
        int[] iArr = new int[6];
        if (this.f13327e) {
            Log.i("GaiaLink", "connect UDP " + str);
        }
        for (int i = 0; i < 6; i++) {
            iArr[i] = Integer.valueOf(str.toUpperCase().substring(i * 3, (i * 3) + 2), 16).intValue();
        }
        m17694a(10, 8193, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]);
    }

    public boolean m17700a() {
        return this.f13330h != null;
    }

    public void m17701b() throws IOException {
        switch (C3532f.m17678d()[this.f13340r.ordinal()]) {
            case 1:
            case 2:
                m17682f();
                break;
            case 3:
                m17683g();
                break;
        }
        this.f13342t = false;
        this.f13329g = false;
        if (this.f13345w != null) {
            this.f13345w.unregisterReceiver(this.f13344v);
        }
    }

    private void m17682f() throws IOException {
        if (this.f13327e) {
            Log.i("GaiaLink", "disconnect BT");
        }
        if (this.f13333k != null) {
            this.f13335m = null;
            try {
                if (this.f13334l != null) {
                    this.f13334l.close();
                }
            } catch (Exception e) {
                Log.e("GaiaLink", "disconnectBluetooth() mInputStream.close() Exception=" + e);
            }
            this.f13334l = null;
            try {
                if (!(this.f13333k == null || this.f13333k.getOutputStream() == null)) {
                    this.f13333k.getOutputStream().close();
                }
            } catch (Exception e2) {
                Log.e("GaiaLink", "disconnectBluetooth() mBTSocket.getOutputStream().close() Exception=" + e2);
            }
            try {
                this.f13333k.close();
            } catch (Exception e22) {
                Log.e("GaiaLink", "disconnectBluetooth() mBTSocket.close() Exception=" + e22);
            }
            this.f13333k = null;
            this.f13331i = null;
            m17698a(false);
        }
    }

    private void m17683g() throws IOException {
        if (this.f13327e) {
            Log.i("GaiaLink", "disconnect UDP");
        }
        if (this.f13332j != null) {
            this.f13332j.disconnect();
            this.f13332j.close();
        }
    }

    public void m17699a(byte[] bArr, int i) throws IOException {
        try {
            if (this.f13333k != null) {
                OutputStream outputStream = this.f13333k.getOutputStream();
                outputStream.write(bArr, 0, i);
                outputStream.flush();
                if (this.f13327e) {
                    Log.i("GaiaLink", "sendRaw: count = " + i);
                }
                if (this.f13337o != null) {
                    this.f13337o.obtainMessage(C3534h.STREAM.ordinal(), Integer.valueOf(i)).sendToTarget();
                    return;
                }
                return;
            }
            Log.e("GaiaLink", "sendRaw: mBTSocket = null");
            this.f13337o.obtainMessage(C3534h.STREAM.ordinal(), Integer.valueOf(i)).sendToTarget();
        } catch (IOException e) {
            Log.e("GaiaLink", "sendRaw: Exception = " + e.toString());
        }
    }

    public void m17693a(int i, int i2, byte[] bArr, int i3) throws IOException {
        byte[] a = C3528b.m17645a(i, i2, bArr, i3);
        if (this.f13338p != null) {
            String str = "→ " + C3528b.m17641a(i) + HwAccountConstants.BLANK + C3528b.m17641a(i2);
            for (byte a2 : bArr) {
                str = new StringBuilder(String.valueOf(str)).append(HwAccountConstants.BLANK).append(C3528b.m17640a(a2)).toString();
            }
            Log.d("GaiaLink", str);
            this.f13338p.obtainMessage(C3534h.DEBUG.ordinal(), str).sendToTarget();
        }
        m17671a(a);
    }

    private void m17671a(byte[] bArr) throws IOException {
        if (!this.f13329g) {
            switch (C3532f.m17678d()[this.f13340r.ordinal()]) {
                case 1:
                case 2:
                    if (this.f13333k == null) {
                        throw new IOException("GaiaLink is not connected");
                    }
                    if (this.f13327e) {
                        Log.i("GaiaLink", "send " + bArr.length);
                    }
                    this.f13333k.getOutputStream().write(bArr);
                    return;
                case 3:
                    if (this.f13332j == null) {
                        throw new IOException("GaiaLink is not connected");
                    }
                    this.f13332j.send(new DatagramPacket(bArr, bArr.length));
                    return;
                default:
                    return;
            }
        }
    }

    public void m17692a(int i, int i2, byte[] bArr) throws IOException {
        if (bArr == null) {
            m17694a(i, i2, new int[0]);
        } else {
            m17693a(i, i2, bArr, bArr.length);
        }
    }

    public void m17694a(int i, int i2, int... iArr) throws IOException {
        if (iArr == null || iArr.length == 0) {
            byte[] a = C3528b.m17642a(i, i2);
            if (this.f13338p != null) {
                String str = "→ " + C3528b.m17641a(i) + HwAccountConstants.BLANK + C3528b.m17641a(i2);
                Log.d("GaiaLink", str);
                this.f13338p.obtainMessage(C3534h.DEBUG.ordinal(), str).sendToTarget();
            }
            m17671a(a);
            return;
        }
        byte[] bArr = new byte[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            bArr[i3] = (byte) iArr[i3];
        }
        m17692a(i, i2, bArr);
    }

    public void m17690a(int i, int i2) throws IOException {
        m17692a(10, 1585, new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i, (byte) (i2 >>> 24), (byte) (i2 >>> 16), (byte) (i2 >>> 8), (byte) i2});
        this.f13329g = true;
    }

    public void m17691a(int i, int i2, C3530d c3530d, int... iArr) throws IOException {
        byte[] bArr;
        if (iArr == null) {
            bArr = new byte[1];
        } else {
            byte[] bArr2 = new byte[(iArr.length + 1)];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                bArr2[i3 + 1] = (byte) iArr[i3];
            }
            bArr = bArr2;
        }
        bArr[0] = (byte) c3530d.ordinal();
        m17692a(i, 32768 | i2, bArr);
    }

    public void m17696a(C3531e c3531e, C3530d c3530d, int... iArr) throws IOException {
        m17691a(c3531e.m17660g(), c3531e.m17662i(), c3530d, iArr);
    }

    public void m17695a(Handler handler) {
        this.f13337o = handler;
    }

    public String m17702c() {
        return this.f13331i.getName();
    }

    private void m17665a(C3531e c3531e) {
        if (this.f13338p != null) {
            String str = "← " + C3528b.m17641a(c3531e.m17660g()) + HwAccountConstants.BLANK + C3528b.m17641a(c3531e.m17662i());
            if (c3531e.m17658e() != null) {
                for (byte a : c3531e.m17658e()) {
                    str = new StringBuilder(String.valueOf(str)).append(HwAccountConstants.BLANK).append(C3528b.m17640a(a)).toString();
                }
            }
            if (this.f13327e) {
                Log.d("GaiaLink", str);
            }
            this.f13338p.obtainMessage(C3534h.DEBUG.ordinal(), str).sendToTarget();
        }
    }
}
