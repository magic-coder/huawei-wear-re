package com.huawei.pluginaf500.receiver;

/* compiled from: PhoneCommandReceiver */
class C1376d implements Runnable {
    final /* synthetic */ int f2966a;
    final /* synthetic */ PhoneCommandReceiver f2967b;

    C1376d(PhoneCommandReceiver phoneCommandReceiver, int i) {
        this.f2967b = phoneCommandReceiver;
        this.f2966a = i;
    }

    public void run() {
        this.f2967b.f2962b.setRingerMode(this.f2966a);
    }
}
