package cmb.pb.ui;

import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;

final class C2865c implements OnKeyboardActionListener {
    final /* synthetic */ PBKeyboardActivity f9293a;

    C2865c(PBKeyboardActivity pBKeyboardActivity) {
        this.f9293a = pBKeyboardActivity;
    }

    public final void onKey(int i, int[] iArr) {
        Editable text = this.f9293a.f9285r.getText();
        int selectionStart = this.f9293a.f9285r.getSelectionStart();
        if (i == -3) {
            PBKeyboardActivity.m12964a(this.f9293a);
            return;
        }
        if (i == -5) {
            if (text != null && text.length() > 0 && selectionStart > 0) {
                text.delete(selectionStart - 1, selectionStart);
                if (this.f9293a.f9288x && PBKeyboardActivity.f9256i != null) {
                    PBKeyboardActivity.f9256i.m13006a(selectionStart);
                }
            }
        } else if (i == -1) {
            if (this.f9293a.f9263D == PBKeyboardActivity.f9247F) {
                PBKeyboardActivity.m12966a(this.f9293a, this.f9293a.f9284q);
                this.f9293a.f9276h.setKeyboard(this.f9293a.f9284q);
                this.f9293a.f9263D = PBKeyboardActivity.f9247F;
            } else if (this.f9293a.f9263D == PBKeyboardActivity.f9248G) {
                this.f9293a.f9276h.setKeyboard(this.f9293a.f9283p);
                this.f9293a.f9263D = PBKeyboardActivity.f9249H;
            } else if (this.f9293a.f9263D == PBKeyboardActivity.f9249H) {
                this.f9293a.f9276h.setKeyboard(this.f9293a.f9279l);
                this.f9293a.f9263D = PBKeyboardActivity.f9248G;
            }
        } else if (i == -2) {
            if (this.f9293a.f9263D == PBKeyboardActivity.f9247F) {
                this.f9293a.f9276h.setKeyboard(this.f9293a.f9279l);
                this.f9293a.f9263D = PBKeyboardActivity.f9248G;
            } else if (this.f9293a.f9263D == PBKeyboardActivity.f9252K) {
                if (this.f9293a.f9286s != null) {
                    this.f9293a.f9286s.setText("返回");
                    this.f9293a.f9286s.setOnClickListener(this.f9293a.f9266O);
                }
                this.f9293a.f9276h.setKeyboard(this.f9293a.f9284q);
                this.f9293a.f9263D = PBKeyboardActivity.f9247F;
            } else {
                this.f9293a.f9276h.setKeyboard(this.f9293a.f9284q);
                this.f9293a.f9263D = PBKeyboardActivity.f9247F;
            }
        } else if (i == 57419) {
            if (selectionStart > 0) {
                this.f9293a.f9285r.setSelection(selectionStart - 1);
            }
        } else if (i == 57421) {
            if (selectionStart < this.f9293a.f9285r.length()) {
                this.f9293a.f9285r.setSelection(selectionStart + 1);
            }
        } else if (i == 128) {
            if (!this.f9293a.f9288x || PBKeyboardActivity.f9256i == null) {
                text.insert(selectionStart, "€");
            } else {
                PBKeyboardActivity.f9256i.m13007a(selectionStart, "€");
                text.insert(selectionStart, "*");
            }
        } else if (!this.f9293a.f9288x || PBKeyboardActivity.f9256i == null) {
            text.insert(selectionStart, Character.toString((char) i));
        } else {
            PBKeyboardActivity.f9256i.m13007a(selectionStart, Character.toString((char) i));
            text.insert(selectionStart, "*");
        }
        if (this.f9293a.f9262C) {
            String editable = text.toString();
            Handler h = PBKeyboardActivity.f9259v;
            if (h != null) {
                Message message = new Message();
                message.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("KeyString", editable);
                message.setData(bundle);
                h.sendMessage(message);
            }
        }
    }

    public final void onPress(int i) {
    }

    public final void onRelease(int i) {
    }

    public final void onText(CharSequence charSequence) {
    }

    public final void swipeDown() {
    }

    public final void swipeLeft() {
    }

    public final void swipeRight() {
    }

    public final void swipeUp() {
    }
}
