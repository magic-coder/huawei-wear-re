package com.huawei.pluginkidwatch.plugin.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.pluginkidwatch.g;

/* compiled from: ChatBaseCell */
public class av extends LinearLayout implements OnClickListener, OnLongClickListener {
    protected ImageView f4743a;
    protected ImageView f4744b;
    protected ImageView f4745c;
    protected ProgressBar f4746d;
    protected TextView f4747e;
    protected TextView f4748f;
    protected TextView f4749g;
    protected TextView f4750h;
    protected ImageView f4751i;
    protected ImageView f4752j;
    protected int f4753k;
    protected boolean f4754l;
    protected int f4755m = -1;
    private OnClickListener f4756n;
    private OnLongClickListener f4757o;
    private OnClickListener f4758p;
    private FrameLayout f4759q;
    private FrameLayout f4760r;
    private LinearLayout f4761s;
    private LinearLayout f4762t;
    private CheckBox f4763u;

    public av(Context context) {
        super(context);
    }

    public boolean getPlay() {
        return this.f4754l;
    }

    public void setPlay(boolean z) {
        this.f4754l = z;
    }

    public void setIsReaded(boolean z) {
        if (z) {
            this.f4752j.setVisibility(8);
        } else {
            this.f4752j.setVisibility(0);
        }
    }

    public Integer getTime() {
        return Integer.valueOf(this.f4753k);
    }

    private int m8465a(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    protected void setSoundbgLen(Integer num) {
        int i = 10;
        int a = m8465a(60.0f);
        int a2 = m8465a(10.0f);
        if (num.intValue() <= 10) {
            i = num.intValue();
        }
        i = (i * a2) + a;
        LayoutParams layoutParams = this.f4744b.getLayoutParams();
        layoutParams.width = i;
        this.f4744b.setLayoutParams(layoutParams);
    }

    public void setTimeLength(Integer num) {
        this.f4753k = num.intValue();
        this.f4748f.setText(String.valueOf(this.f4753k) + " \"");
        setSoundbgLen(num);
    }

    public void setTime(String str) {
        this.f4747e.setText(str);
        if (str == null || "".equals(str)) {
            this.f4747e.setVisibility(8);
        } else {
            this.f4747e.setVisibility(0);
        }
    }

    public Drawable getPhoto() {
        return this.f4743a.getDrawable();
    }

    public void setPhoto(Drawable drawable) {
        this.f4743a.setImageDrawable(drawable);
    }

    public void setPhoto(int i) {
        this.f4743a.setImageResource(i);
    }

    public void setPhoto(Bitmap bitmap) {
        this.f4743a.setImageBitmap(bitmap);
    }

    public void setmRelationText(String str) {
        this.f4749g.setText(str);
    }

    public void setStatus(int i) {
        if (this.f4755m != i) {
            if (1 == i || 3 == i) {
                this.f4751i.setVisibility(0);
                this.f4746d.setVisibility(8);
            } else if (2 == i) {
                this.f4746d.setVisibility(0);
                this.f4751i.setVisibility(8);
            } else {
                this.f4746d.setVisibility(8);
                this.f4751i.setVisibility(8);
            }
        }
        this.f4755m = i;
    }

    public av(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public av(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setTextContent(String str) {
        this.f4750h.setText(str);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f4743a = (ImageView) findViewById(g.userPhoto);
        this.f4749g = (TextView) findViewById(g.chatsendercell_relation);
        this.f4750h = (TextView) findViewById(g.chat_cell_tv_text);
        this.f4744b = (ImageView) findViewById(g.soundbg);
        this.f4745c = (ImageView) findViewById(g.playAnim);
        this.f4746d = (ProgressBar) findViewById(g.uploadAnim);
        this.f4747e = (TextView) findViewById(g.message_time);
        this.f4751i = (ImageView) findViewById(g.chatcell_status);
        this.f4752j = (ImageView) findViewById(g.chatcell_isreaded);
        this.f4748f = (TextView) findViewById(g.timelabel);
        this.f4759q = (FrameLayout) findViewById(g.chat_frame_text);
        this.f4760r = (FrameLayout) findViewById(g.chat_cell_frame_video);
        this.f4761s = (LinearLayout) findViewById(g.layout_chat_check);
        this.f4762t = (LinearLayout) findViewById(g.chatcell_click_ll);
        this.f4763u = (CheckBox) findViewById(g.chat_cb_Select);
        this.f4744b.setOnClickListener(this);
        this.f4744b.setOnLongClickListener(this);
        this.f4759q.setOnLongClickListener(this);
        this.f4750h.setOnLongClickListener(this);
        this.f4751i.setOnClickListener(this);
    }

    public void setOnCheckChangeListener(OnClickListener onClickListener) {
        this.f4763u.setOnClickListener(onClickListener);
        this.f4761s.setOnClickListener(onClickListener);
        this.f4743a.setOnClickListener(onClickListener);
        this.f4749g.setOnClickListener(onClickListener);
        this.f4750h.setOnClickListener(onClickListener);
        this.f4759q.setOnClickListener(onClickListener);
        this.f4760r.setOnClickListener(onClickListener);
        this.f4744b.setOnClickListener(onClickListener);
        this.f4751i.setOnClickListener(onClickListener);
        this.f4762t.setOnClickListener(onClickListener);
    }

    public void setChecked(boolean z) {
        this.f4763u.setChecked(z);
    }

    public void m8466a(boolean z) {
        if (z) {
            this.f4761s.setVisibility(0);
        } else {
            this.f4761s.setVisibility(8);
        }
    }

    public void setCheckStatus(boolean z) {
        this.f4763u.setChecked(z);
    }

    public void setFrameTextVisiable(boolean z) {
        if (z) {
            this.f4759q.setVisibility(0);
        } else {
            this.f4759q.setVisibility(8);
        }
    }

    public void setFrameVideoVisiable(boolean z) {
        if (z) {
            this.f4760r.setVisibility(0);
        } else {
            this.f4760r.setVisibility(8);
        }
    }

    public void setClickListener(OnClickListener onClickListener) {
        this.f4744b.setOnClickListener(this);
        this.f4756n = onClickListener;
    }

    public void setLoneClickListener(OnLongClickListener onLongClickListener) {
        this.f4757o = onLongClickListener;
    }

    public void onClick(View view) {
        if (g.soundbg == view.getId() && this.f4756n != null) {
            this.f4756n.onClick(this);
        } else if (g.chatcell_status == view.getId() && this.f4758p != null && this.f4751i.getVisibility() == 0) {
            this.f4758p.onClick(this);
        }
    }

    public void setResendListener(OnClickListener onClickListener) {
        this.f4751i.setOnClickListener(this);
        this.f4758p = onClickListener;
    }

    public boolean onLongClick(View view) {
        if (this.f4757o != null) {
            return this.f4757o.onLongClick(this);
        }
        return false;
    }
}
