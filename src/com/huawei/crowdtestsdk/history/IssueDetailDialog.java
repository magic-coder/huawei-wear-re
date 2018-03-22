package com.huawei.crowdtestsdk.history;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.huawei.crowdtestsdk.R;

public class IssueDetailDialog {
    private ImageView closeBtn;
    private AlertDialog dialog;
    private IssueStatusFlowWidget flowWidget;

    class C07641 implements OnClickListener {
        C07641() {
        }

        public void onClick(View view) {
            IssueDetailDialog.this.close();
        }
    }

    protected IssueDetailDialog(Context context, String str) {
        init(context);
        start(str);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sdk_crowdtest_layout_issue_details_dialog, null);
        this.dialog = new Builder(context).create();
        this.dialog.show();
        this.dialog.getWindow().setContentView(inflate);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        LayoutParams attributes = this.dialog.getWindow().getAttributes();
        attributes.width = i - 30;
        this.dialog.getWindow().setAttributes(attributes);
        this.flowWidget = (IssueStatusFlowWidget) inflate.findViewById(R.id.sdk_crowdtest_issue_item_status_flow);
        this.closeBtn = (ImageView) inflate.findViewById(R.id.sdk_crowdtest_personal_issue_flow_status_close);
        this.closeBtn.setOnClickListener(new C07641());
    }

    private void start(String str) {
        this.flowWidget.setIssueNumber(str);
        this.flowWidget.start();
    }

    private void close() {
        this.dialog.dismiss();
    }
}
