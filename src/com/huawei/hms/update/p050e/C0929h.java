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

/* compiled from: DownloadProgress */
public class C0929h extends C0917b {
    private ProgressBar f1515a;
    private TextView f1516b;
    private OnKeyListener f1517c = new C0928a();

    /* compiled from: DownloadProgress */
    class C0928a implements OnKeyListener {
        private C0928a() {
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
        builder.setOnKeyListener(this.f1517c);
        this.f1515a = (ProgressBar) inflate.findViewById(b.download_info_progress);
        this.f1516b = (TextView) inflate.findViewById(b.hms_progress_text);
        m3229a(0, 0);
        return builder.create();
    }

    void m3229a(int i, int i2) {
        Activity f = m3213f();
        if (f == null || f.isFinishing()) {
            C0887a.m3096c("DownloadProgress", "In setDownloading, The activity is null or finishing.");
        } else if (this.f1516b != null && this.f1515a != null) {
            int i3 = 0;
            if (i >= 0 && i2 > 0) {
                i3 = (int) ((((long) i) * 100) / ((long) i2));
            }
            this.f1515a.setProgress(i3);
            this.f1516b.setText(NumberFormat.getPercentInstance().format((double) (((float) i3) / 100.0f)));
        }
    }
}
