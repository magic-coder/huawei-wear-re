package com.huawei.feedback.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.feedback.c;
import com.huawei.feedback.d;
import com.huawei.feedback.logic.C4413c;
import java.util.List;

/* compiled from: FeedbackShowImageAdapter */
public class ae extends BaseAdapter {
    private List<C4413c> f16568a;
    private Context f16569b;
    private Handler f16570c;

    /* compiled from: FeedbackShowImageAdapter */
    class C4450a implements OnClickListener {
        final /* synthetic */ ae f16564a;
        private C4451b f16565b;

        public C4450a(ae aeVar, C4451b c4451b) {
            this.f16564a = aeVar;
            this.f16565b = c4451b;
        }

        public void onClick(View view) {
            int intValue = ((Integer) this.f16565b.f16566a.getTag()).intValue();
            if (intValue < this.f16564a.f16568a.size()) {
                this.f16564a.f16568a.remove(intValue);
                this.f16564a.f16570c.sendEmptyMessage(1001);
            }
        }
    }

    /* compiled from: FeedbackShowImageAdapter */
    class C4451b {
        public ImageView f16566a;
        public ImageView f16567b;

        private C4451b() {
        }
    }

    public ae(List<C4413c> list, Context context, Handler handler) {
        this.f16568a = list;
        this.f16569b = context;
        this.f16570c = handler;
    }

    public int getCount() {
        return this.f16568a.size();
    }

    public Object getItem(int i) {
        return this.f16568a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4451b c4451b;
        int a = m21455a();
        if (view == null) {
            view = LayoutInflater.from(this.f16569b).inflate(d.c(this.f16569b, "feedback_edit_upload_item"), null);
            c4451b = new C4451b();
            c4451b.f16567b = (ImageView) view.findViewById(d.a(this.f16569b, "feedback_edit_activity_image"));
            c4451b.f16566a = (ImageView) view.findViewById(d.a(this.f16569b, "feedback_edit_activity_delete_image"));
            LayoutParams layoutParams = (LayoutParams) c4451b.f16567b.getLayoutParams();
            layoutParams.width = a;
            layoutParams.height = a;
            c4451b.f16567b.setLayoutParams(layoutParams);
            view.setTag(c4451b);
        } else {
            c4451b = (C4451b) view.getTag();
        }
        C4413c c4413c = (C4413c) this.f16568a.get(i);
        if (c4413c == null) {
            c4451b.f16567b.setImageDrawable(this.f16569b.getResources().getDrawable(d.e(this.f16569b, "feedback_edit_add_image_selector")));
            c4451b.f16566a.setVisibility(8);
        } else {
            Bitmap a2 = c.a(BitmapFactory.decodeFile(c4413c.m21245a()), a, a);
            Bitmap b = c.b(c.a(a2, (float) this.f16569b.getResources().getDimensionPixelSize(d.f(this.f16569b, "feedback_ui_9_dip"))), (float) this.f16569b.getResources().getDimensionPixelSize(d.f(this.f16569b, "feedback_ui_9_dip")));
            if (b != null) {
                c4451b.f16567b.setImageBitmap(b);
                c4451b.f16566a.setVisibility(0);
                c4451b.f16566a.setTag(Integer.valueOf(i));
                c4451b.f16566a.setOnClickListener(new C4450a(this, c4451b));
            }
            if (!(a2 == null || a2.isRecycled())) {
                a2.recycle();
            }
        }
        return view;
    }

    private int m21455a() {
        int s = c.s(this.f16569b);
        int i = c.u(this.f16569b) ? 24 : 16;
        if (s < c.a(this.f16569b, (float) ((i * 2) + SdkConstants.REQUEST_CAMERA_VIDEO))) {
            return (s - c.a(this.f16569b, (float) ((i * 2) + 24))) / 4;
        }
        return c.a(this.f16569b, 75.0f);
    }
}
