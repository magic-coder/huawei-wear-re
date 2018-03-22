package com.huawei.hms.update.p050e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.android.a.a.b;
import com.huawei.android.a.a.c;
import com.huawei.hms.support.log.C0887a;
import java.text.NumberFormat;

/* compiled from: ProgressNoCancel */
public class C0935l extends C0917b {
    private ProgressBar f1520a;
    private TextView f1521b;
    private OnKeyListener f1522c = new C0934a();

    /* compiled from: ProgressNoCancel */
    class C0934a implements OnKeyListener {
        private C0934a() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4 && keyEvent.getRepeatCount() == 0;
        }
    }

    public AlertDialog mo2276a() {
        Builder builder = new Builder(m3213f(), m3214g());
        View inflate = View.inflate(m3213f(), c.hms_download_progress, null);
        builder.setView(inflate);
        builder.setCancelable(false);
        builder.setOnKeyListener(this.f1522c);
        this.f1520a = (ProgressBar) inflate.findViewById(b.download_info_progress);
        this.f1521b = (TextView) inflate.findViewById(b.hms_progress_text);
        m3232a(0);
        return builder.create();
    }

    void m3232a(int i) {
        Activity f = m3213f();
        if (f == null || f.isFinishing()) {
            C0887a.m3096c("ProgressNoCancel", "In setDownloading, The activity is null or finishing.");
        } else if (this.f1521b != null && this.f1520a != null) {
            this.f1520a.setProgress(i);
            this.f1521b.setText(NumberFormat.getPercentInstance().format((double) (((float) i) / 100.0f)));
        }
    }
}
