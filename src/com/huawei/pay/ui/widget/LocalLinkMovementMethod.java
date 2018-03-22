package com.huawei.pay.ui.widget;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class LocalLinkMovementMethod extends LinkMovementMethod {
    private int clickColor = 0;

    class Singletone {
        public static final LocalLinkMovementMethod INSTANCE = new LocalLinkMovementMethod();

        private Singletone() {
        }
    }

    public static LocalLinkMovementMethod getInstance() {
        return Singletone.INSTANCE;
    }

    public void setClickColor(int i) {
        this.clickColor = i;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
        if (clickableSpanArr.length != 0) {
            if (action == 1) {
                clickableSpanArr[0].onClick(textView);
                spannable.setSpan(new BackgroundColorSpan(this.clickColor), spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]), 33);
            } else if (action == 0) {
                spannable.setSpan(new BackgroundColorSpan(this.clickColor), spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]), 33);
            }
            return true;
        }
        Selection.removeSelection(spannable);
        Touch.onTouchEvent(textView, spannable, motionEvent);
        return false;
    }
}
