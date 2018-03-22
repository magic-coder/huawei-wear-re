package com.tencent.open.p543c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.web.security.C6421a;
import com.tencent.open.web.security.C6422b;

/* compiled from: ProGuard */
public class C6387b extends C6386a {
    public static boolean f22207a;
    private KeyEvent f22208b;
    private C6422b f22209c;

    public C6387b(Context context) {
        super(context);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        C6367n.m29107b("SecureWebView", "-->dispatchKeyEvent, is device support: " + f22207a);
        if (!f22207a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        switch (keyEvent.getKeyCode()) {
            case 4:
                return super.dispatchKeyEvent(keyEvent);
            case 66:
                return super.dispatchKeyEvent(keyEvent);
            case 67:
                C6422b.f22288b = true;
                return super.dispatchKeyEvent(keyEvent);
            default:
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (C6421a.f22286a) {
                    int unicodeChar = keyEvent.getUnicodeChar();
                    if ((unicodeChar >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125)) {
                        this.f22208b = new KeyEvent(0, 17);
                        return super.dispatchKeyEvent(this.f22208b);
                    }
                }
                return super.dispatchKeyEvent(keyEvent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C6367n.m29107b("SecureWebView", "-->onKeyDown, is device support: " + f22207a);
        if (!f22207a) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        switch (keyEvent.getKeyCode()) {
            case 4:
                return super.onKeyDown(i, keyEvent);
            case 66:
                return super.onKeyDown(i, keyEvent);
            case 67:
                C6422b.f22288b = true;
                return super.onKeyDown(i, keyEvent);
            default:
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.onKeyDown(i, keyEvent);
                }
                if (C6421a.f22286a) {
                    int unicodeChar = keyEvent.getUnicodeChar();
                    if ((unicodeChar >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125)) {
                        this.f22208b = new KeyEvent(0, 17);
                        return super.onKeyDown(this.f22208b.getKeyCode(), this.f22208b);
                    }
                }
                return super.onKeyDown(i, keyEvent);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        C6367n.m29110c("SecureWebView", "-->create input connection, is edit: " + C6421a.f22286a);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C6367n.m29107b("SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection != null) {
            f22207a = true;
            this.f22209c = new C6422b(super.onCreateInputConnection(editorInfo), false);
            return this.f22209c;
        }
        f22207a = false;
        return onCreateInputConnection;
    }
}
