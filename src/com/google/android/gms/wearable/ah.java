package com.google.android.gms.wearable;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class ah implements ServiceConnection {
    private ah(WearableListenerService wearableListenerService) {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
