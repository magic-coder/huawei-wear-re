package com.huawei.pay.ui.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.ag.e;
import com.huawei.ag.f;
import com.huawei.pay.ui.util.UiUtil;

public class DownloadProgressDialog extends AlertDialog {
    private TextView file_isdowning_size;
    private ProgressBar progressBar;
    private TextView progressNum;

    public DownloadProgressDialog(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(f.dialog_download_progress_bank, null);
        this.progressBar = (ProgressBar) inflate.findViewById(e.AppUpdateDialog_progressbar);
        this.progressBar.setProgress(0);
        this.file_isdowning_size = (TextView) inflate.findViewById(e.file_isdowning_size);
        this.progressNum = (TextView) inflate.findViewById(e.AppUpdateDialog_progress);
        UiUtil.setDialogView(context, this, inflate);
    }

    public DownloadProgressDialog(Context context, int i) {
        super(context, i);
        View inflate = LayoutInflater.from(getContext()).inflate(f.dialog_download_progress_bank, null);
        this.progressBar = (ProgressBar) inflate.findViewById(e.AppUpdateDialog_progressbar);
        this.progressBar.setProgress(0);
        this.file_isdowning_size = (TextView) inflate.findViewById(e.file_isdowning_size);
        this.progressNum = (TextView) inflate.findViewById(e.AppUpdateDialog_progress);
        UiUtil.setDialogView(context, this, inflate);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        onWindowAttributesChanged(showBottom(this));
    }

    private LayoutParams showBottom(DownloadProgressDialog downloadProgressDialog) {
        Window window = downloadProgressDialog.getWindow();
        window.setGravity(80);
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        return attributes;
    }

    public void updateProgress(int i, String str) {
        this.progressBar.setProgress(i);
        if (getContext() != null) {
            this.progressNum.setText(i + "%");
        }
        this.file_isdowning_size.setText(str);
    }
}
