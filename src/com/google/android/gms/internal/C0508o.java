package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0385x;
import com.google.android.gms.common.api.Status;

public class C0508o<R extends C0366w> extends Handler {
    public C0508o() {
        this(Looper.getMainLooper());
    }

    public C0508o(Looper looper) {
        super(looper);
    }

    public void m1499a() {
        removeMessages(2);
    }

    public void m1500a(C0385x<? super R> c0385x, R r) {
        sendMessage(obtainMessage(1, new Pair(c0385x, r)));
    }

    protected void m1501b(C0385x<? super R> c0385x, R r) {
        try {
            c0385x.mo1899a(r);
        } catch (RuntimeException e) {
            C0501m.m1471b((C0366w) r);
            throw e;
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Pair pair = (Pair) message.obj;
                m1501b((C0385x) pair.first, (C0366w) pair.second);
                return;
            case 2:
                ((C0501m) message.obj).m1480b(Status.zzazA);
                return;
            default:
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                return;
        }
    }
}
