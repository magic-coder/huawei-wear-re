package com.huawei.feedback.ui.CustomEdittext;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.widget.TextView;
import com.huawei.feedback.ui.CustomEdittext.CustomEditText.C4427a;
import com.huawei.phoneserviceuni.common.d.c;
import java.lang.reflect.InvocationTargetException;

/* compiled from: SmileyInputConnection */
public class C4430b extends BaseInputConnection {
    protected C4428a f16434a = null;
    private final TextView f16435b;
    private C4427a f16436c;

    /* compiled from: SmileyInputConnection */
    public interface C4428a {
        boolean mo4460a();
    }

    public void m21289a(C4428a c4428a) {
        this.f16434a = c4428a;
    }

    public C4430b(TextView textView) {
        super(textView, true);
        this.f16435b = textView;
    }

    public void m21288a(C4427a c4427a) {
        this.f16436c = c4427a;
    }

    public Editable getEditable() {
        TextView textView = this.f16435b;
        if (textView != null) {
            return textView.getEditableText();
        }
        return null;
    }

    public boolean beginBatchEdit() {
        this.f16435b.beginBatchEdit();
        return true;
    }

    public boolean endBatchEdit() {
        this.f16435b.endBatchEdit();
        return true;
    }

    public boolean clearMetaKeyStates(int i) {
        Editable editable = getEditable();
        if (editable == null) {
            return false;
        }
        KeyListener keyListener = this.f16435b.getKeyListener();
        if (keyListener != null) {
            try {
                keyListener.clearMetaKeyState(this.f16435b, editable, i);
            } catch (AbstractMethodError e) {
                c.d("SmileyInputConnection", "kl AbstractMethodError");
            }
        }
        return true;
    }

    public boolean commitCompletion(CompletionInfo completionInfo) {
        c.a("SmileyInputConnection", "commitCompletion " + completionInfo);
        this.f16435b.beginBatchEdit();
        this.f16435b.onCommitCompletion(completionInfo);
        this.f16435b.endBatchEdit();
        return true;
    }

    public boolean performEditorAction(int i) {
        c.a("SmileyInputConnection", "performEditorAction " + i);
        this.f16435b.onEditorAction(i);
        return true;
    }

    public boolean performContextMenuAction(int i) {
        c.a("SmileyInputConnection", "performContextMenuAction " + i);
        this.f16435b.beginBatchEdit();
        this.f16435b.onTextContextMenuItem(i);
        this.f16435b.endBatchEdit();
        return true;
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        if (this.f16435b != null) {
            ExtractedText extractedText = new ExtractedText();
            if (this.f16435b.extractText(extractedTextRequest, extractedText)) {
                if ((i & 1) == 0) {
                    return extractedText;
                }
                m21287a(this.f16435b, extractedTextRequest);
                return extractedText;
            }
        }
        return null;
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f16435b.onPrivateIMECommand(str, bundle);
        return true;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        if (this.f16435b == null) {
            return super.commitText(charSequence, i);
        }
        CharSequence error = this.f16435b.getError();
        boolean commitText = super.commitText(charSequence, i);
        CharSequence error2 = this.f16435b.getError();
        if (error2 == null || !error2.toString().equals(error.toString())) {
            return commitText;
        }
        this.f16435b.setError(null, null);
        return commitText;
    }

    public boolean finishComposingText() {
        if (this.f16436c != null) {
            this.f16436c.m21282a();
        }
        return super.finishComposingText();
    }

    private void m21287a(TextView textView, ExtractedTextRequest extractedTextRequest) {
        try {
            textView.getClass().getMethod("setExtracting", new Class[]{ExtractedTextRequest.class}).invoke(textView, new Object[]{extractedTextRequest});
        } catch (NoSuchMethodException e) {
            c.d("SmileyInputConnection", "setExtracting NoSuchMethodException");
        } catch (IllegalAccessException e2) {
            c.d("SmileyInputConnection", "setExtracting IllegalAccessException");
        } catch (IllegalArgumentException e3) {
            c.d("SmileyInputConnection", "setExtracting IllegalArgumentException");
        } catch (InvocationTargetException e4) {
            c.d("SmileyInputConnection", "setExtracting InvocationTargetException");
        } catch (Exception e5) {
            c.d("SmileyInputConnection", "setExtracting unknow Exception");
        }
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        c.d("SmileyInputConnection", "sendKeyEvent");
        if (keyEvent.getKeyCode() == 67 && keyEvent.getAction() == 0 && this.f16434a.mo4460a()) {
            return true;
        }
        return super.sendKeyEvent(keyEvent);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        c.d("SmileyInputConnection", "deleteSurroundingText");
        if (i == 1 && i2 == 0) {
            if (getTextBeforeCursor(1, 0) == null) {
                return false;
            }
            if (getTextBeforeCursor(1, 0).length() == 0) {
                this.f16434a.mo4460a();
            }
        }
        return super.deleteSurroundingText(i, i2);
    }
}
