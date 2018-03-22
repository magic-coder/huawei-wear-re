package com.huawei.feedback.ui.CustomEdittext;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import com.huawei.phoneserviceuni.common.d.c;

public class CustomEditText extends EditText {
    private C4427a f16431a;
    private Handler f16432b;

    public interface C4427a {
        void m21282a();
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void m21283a(Handler handler) {
        this.f16432b = handler;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        super.onCreateInputConnection(editorInfo);
        InputConnection c4430b = new C4430b(this);
        c4430b.m21288a(this.f16431a);
        editorInfo.initialSelStart = Selection.getSelectionStart(getEditableText());
        editorInfo.initialSelEnd = Selection.getSelectionEnd(getEditableText());
        editorInfo.initialCapsMode = c4430b.getCursorCapsMode(getInputType());
        c4430b.m21289a(new C4429a(this));
        return c4430b;
    }

    public boolean m21284a() {
        if (this.f16432b == null || getSelectionEnd() - getSelectionStart() > 0) {
            return false;
        }
        if (getSelectionStart() != 0 && getText().length() != 0) {
            return false;
        }
        c.d("CustomEditText", "doEmptyDelete");
        this.f16432b.sendEmptyMessage(-109);
        return true;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (IndexOutOfBoundsException e) {
            if (charSequence != null) {
                setText(charSequence.toString());
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
