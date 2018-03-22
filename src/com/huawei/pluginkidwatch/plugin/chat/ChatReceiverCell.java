package com.huawei.pluginkidwatch.plugin.chat;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import com.huawei.pluginkidwatch.C1617f;

public class ChatReceiverCell extends av {
    private AnimationDrawable f4764n = null;

    public void setPlay(boolean z) {
        if (this.l != z) {
            if (z) {
                this.c.setBackgroundResource(C1617f.receiver_playanim);
                this.f4764n = (AnimationDrawable) this.c.getBackground();
                this.f4764n.stop();
                this.f4764n.start();
            } else {
                if (this.f4764n != null) {
                    this.f4764n.stop();
                }
                this.c.setBackgroundResource(C1617f.receiver_voice_node_playing003);
            }
        }
        this.l = z;
    }

    public ChatReceiverCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatReceiverCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
