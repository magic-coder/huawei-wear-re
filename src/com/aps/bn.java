package com.aps;

import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: SimpleDiskCache */
public class bn {
    private static List<File> f13057a = new ArrayList();
    private ay f13058b;
    private int f13059c;

    private bn(File file, int i, long j) throws IOException {
        this.f13059c = i;
        this.f13058b = ay.m17357a(file, i, 1, j);
    }

    public static synchronized bn m17428a(File file, int i, long j) throws IOException {
        bn bnVar;
        synchronized (bn.class) {
            if (f13057a.contains(file)) {
                throw new IllegalStateException("Cache dir " + file.getAbsolutePath() + " was used before.");
            }
            f13057a.add(file);
            bnVar = new bn(file, i, j);
        }
        return bnVar;
    }

    public void m17434a() {
        try {
            if (f13057a != null) {
                f13057a.clear();
            }
            if (this.f13058b != null) {
                this.f13058b.close();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Map<String, Serializable> m17433a(String str) throws IOException {
        bc a = this.f13058b.m17378a(m17430b(str));
        if (a == null) {
            return null;
        }
        try {
            Map<String, Serializable> a2 = m17429a(a);
            return a2;
        } finally {
            a.close();
        }
    }

    public OutputStream m17432a(String str, Map<String, ? extends Serializable> map) throws IOException {
        OutputStream outputStream = null;
        az b = this.f13058b.m17380b(m17430b(str));
        if (b != null) {
            try {
                OutputStream objectOutputStream = new ObjectOutputStream(b.m17385a(0));
                objectOutputStream.writeObject(map);
                outputStream = new bp(objectOutputStream, b, null);
            } catch (IOException e) {
                b.m17387b();
                throw e;
            }
        }
        return outputStream;
    }

    public void m17435b(String str, Map<String, ? extends Serializable> map) throws IOException {
        OutputStream outputStream = null;
        try {
            outputStream = m17432a(str, map);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private Map<String, Serializable> m17429a(bc bcVar) throws IOException {
        Throwable e;
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(bcVar.m17403a(0)));
            try {
                Map<String, Serializable> map = (Map) objectInputStream.readObject();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return map;
            } catch (ClassNotFoundException e2) {
                e = e2;
                try {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    e = th;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e;
                }
            }
        } catch (ClassNotFoundException e3) {
            e = e3;
            objectInputStream = null;
            throw new RuntimeException(e);
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e;
        }
    }

    private String m17430b(String str) {
        return m17431c(str);
    }

    private String m17431c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(GameManager.DEFAULT_CHARSET));
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError();
        }
    }
}
