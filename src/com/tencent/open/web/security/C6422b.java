package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
public class C6422b extends InputConnectionWrapper {
    public static String f22287a;
    public static boolean f22288b = false;
    public static boolean f22289c = false;

    public C6422b(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        f22289c = true;
        f22287a = charSequence.toString();
        C6367n.m29107b("CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }

    public boolean commitText(CharSequence charSequence, int i) {
        f22289c = true;
        f22287a = charSequence.toString();
        C6367n.m29107b("CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            C6367n.m29110c("CaptureInputConnection", "sendKeyEvent");
            f22287a = String.valueOf((char) keyEvent.getUnicodeChar());
            f22289c = true;
            C6367n.m29107b("CaptureInputConnection", "s: " + f22287a);
        }
        C6367n.m29107b("CaptureInputConnection", "-->sendKeyEvent: " + f22287a);
        return super.sendKeyEvent(keyEvent);
    }
}
