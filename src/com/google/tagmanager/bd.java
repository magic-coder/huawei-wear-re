package com.google.tagmanager;

import android.content.SharedPreferences.Editor;

/* compiled from: SharedPreferencesUtil */
final class bd implements Runnable {
    final /* synthetic */ Editor f14298a;

    bd(Editor editor) {
        this.f14298a = editor;
    }

    public void run() {
        this.f14298a.commit();
    }
}
