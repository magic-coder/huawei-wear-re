package com.huawei.pay.ui.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.huawei.ag.c;
import com.huawei.ag.d;
import com.huawei.cp3.widget.C4372a;
import com.huawei.pay.e.c.a;

public class UiUtil {

    final class C57431 implements OnGlobalLayoutListener {
        final /* synthetic */ Activity val$act;
        final /* synthetic */ float val$percent;
        final /* synthetic */ Rect val$rect;
        final /* synthetic */ View val$root;
        final /* synthetic */ View val$v;
        final /* synthetic */ ViewTreeObserver val$vto;

        C57431(View view, Rect rect, Activity activity, View view2, float f, ViewTreeObserver viewTreeObserver) {
            this.val$root = view;
            this.val$rect = rect;
            this.val$act = activity;
            this.val$v = view2;
            this.val$percent = f;
            this.val$vto = viewTreeObserver;
        }

        public void onGlobalLayout() {
            if (this.val$root.getHeight() > 0) {
                this.val$root.getGlobalVisibleRect(this.val$rect);
                int i = this.val$rect.top;
                if (i > 0) {
                    UiUtil.setViewMargin(this.val$act, this.val$v, this.val$percent, i);
                    if (this.val$vto.isAlive()) {
                        this.val$vto.removeGlobalOnLayoutListener(this);
                    }
                }
            }
        }
    }

    public static void setDialogView(Context context, AlertDialog alertDialog, View view) {
        if (context != null && alertDialog != null && view != null) {
            alertDialog.setView(view);
        }
    }

    public static int getScreenHeight(Activity activity) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWith(Activity activity) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static void setViewMargin(Activity activity, View view, View view2, float f) {
        if (view != null && view2 != null) {
            Rect rect = new Rect();
            if (view.getHeight() > 0) {
                view.getGlobalVisibleRect(rect);
                a.b("setViewMargin rect top=" + rect.top, false);
                if (rect.top > 0) {
                    setViewMargin(activity, view2, f, rect.top);
                    return;
                }
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new C57431(view, rect, activity, view2, f, viewTreeObserver));
        }
    }

    private static void setViewMargin(Activity activity, View view, float f, int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = (int) ((((float) getScreenHeight(activity)) * f) - ((float) i));
        view.setLayoutParams(marginLayoutParams);
    }

    @SuppressLint({"NewApi"})
    public static void setOrangeButtonBackground(Context context, Button button) {
        if (context == null) {
            a.b("setOrangeButtonBackground,but context is null", false);
        } else if (C4372a.m21003c()) {
            button.setBackground(context.getResources().getDrawable(d.btn_background_emui5));
            button.setTextColor(context.getResources().getColor(c.white));
        } else {
            button.setBackground(context.getResources().getDrawable(d.cp3_orange_button));
            button.setTextColor(context.getResources().getColor(c.white));
        }
    }
}
