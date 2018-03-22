package com.huawei.hwid.update.p453d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.text.NumberFormat;

/* compiled from: DownloadProgress */
public class C5290e extends C5279b {
    private ProgressBar f18966a;
    private TextView f18967b;
    private int f18968c = 0;
    private OnKeyListener f18969d = new C5289a();

    /* compiled from: DownloadProgress */
    class C5289a implements OnKeyListener {
        private C5289a() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4 && keyEvent.getRepeatCount() == 0;
        }
    }

    public AlertDialog mo4663a() {
        Builder builder = new Builder(m25564f(), m25565g());
        View inflate = View.inflate(m25564f(), C5180k.m25031d(m25564f(), "cs_download_progress"), null);
        builder.setView(inflate);
        builder.setCancelable(false);
        builder.setOnKeyListener(this.f18969d);
        this.f18966a = (ProgressBar) inflate.findViewById(C5180k.m25032e(m25564f(), "download_info_progress"));
        this.f18967b = (TextView) inflate.findViewById(C5180k.m25032e(m25564f(), "hms_progress_text"));
        m25581b(this.f18968c);
        return builder.create();
    }

    public void m25580a(int i) {
        this.f18968c = i;
    }

    void m25581b(int i) {
        Activity f = m25564f();
        if (f == null || f.isFinishing()) {
            C5165e.m24908c("DownloadProgress", "In setDownloading, The activity is null or finishing.");
        } else if (this.f18967b != null && this.f18966a != null) {
            this.f18966a.setProgress(i);
            this.f18967b.setText(NumberFormat.getPercentInstance().format((double) (((float) i) / 100.0f)));
        }
    }
}
