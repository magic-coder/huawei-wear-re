package com.huawei.crowdtestsdk.history;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.androidcommon.utils.DateTimeUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.utils.ResUtil;
import java.util.Date;

public class IssueStatusFlowUnit extends LinearLayout {
    private static final String nullString = "null";
    private boolean isCurrent = false;
    private boolean isLast = false;
    private TextView textQuesDelayTime;
    private TextView textQuesRemarks;
    private ImageView timeLineCenterPoint;
    private View timeLineDownLine;
    private View timeLineUpLine;
    private TextView txtAssigneeName;
    private TextView txtAssigneeNameMulti;
    private TextView txtQuesStatus;
    private TextView txtQuesStatusUpdateTime;

    public IssueStatusFlowUnit(Context context) {
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(ResUtil.getResId(context, "sdk_crowdtest_layout_issue_status_flow_item", ResUtil.TYPE_LAYOUT), this);
        initView();
    }

    public IssueStatusFlowUnit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(ResUtil.getResId(context, "sdk_crowdtest_layout_issue_status_flow_item", ResUtil.TYPE_LAYOUT), this);
        initView();
    }

    private void initView() {
        this.timeLineUpLine = findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_up", "id"));
        this.timeLineDownLine = findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_down", "id"));
        this.timeLineCenterPoint = (ImageView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_center_point", "id"));
        this.txtQuesStatus = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_ques_status", "id"));
        this.txtAssigneeName = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_ques_status_process_name", "id"));
        this.txtAssigneeNameMulti = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_ques_status_process_name_multi", "id"));
        this.txtQuesStatusUpdateTime = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_ques_status_update_time", "id"));
        this.textQuesDelayTime = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_ques_status_delay_time", "id"));
        this.textQuesRemarks = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_line_ques_status_process_remarks", "id"));
    }

    public void setStartFlow() {
        this.timeLineUpLine.setVisibility(4);
    }

    public void setEndFlow() {
        this.timeLineDownLine.setVisibility(4);
    }

    public void setCurrentFlow() {
        this.timeLineCenterPoint.setImageResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_point_current", ResUtil.TYPE_DRAWABLE));
        this.txtQuesStatus.setTextColor(Color.rgb(40, 192, 198));
        this.txtQuesStatusUpdateTime.setTextColor(Color.rgb(40, 192, 198));
        this.txtAssigneeName.setTextColor(Color.rgb(40, 192, 198));
        this.txtAssigneeNameMulti.setTextColor(Color.rgb(40, 192, 198));
        this.textQuesDelayTime.setTextColor(Color.rgb(40, 192, 198));
        this.timeLineDownLine.setBackgroundColor(Color.rgb(200, 200, 200));
    }

    public void setUnCompleteFlow() {
        this.timeLineCenterPoint.setImageResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_time_point_uncomplete", ResUtil.TYPE_DRAWABLE));
        this.txtQuesStatus.setTextColor(Color.rgb(200, 200, 200));
        this.txtQuesStatusUpdateTime.setTextColor(Color.rgb(200, 200, 200));
        this.timeLineUpLine.setBackgroundColor(Color.rgb(200, 200, 200));
        this.timeLineDownLine.setBackgroundColor(Color.rgb(200, 200, 200));
    }

    public void setStatus(String str) {
        this.txtQuesStatus.setText(str);
    }

    public void setAssigneeName(String str) {
        if (str == null || str.isEmpty() || "null".equalsIgnoreCase(str)) {
            this.txtAssigneeName.setText("");
            this.txtAssigneeNameMulti.setText("");
        } else if (str.contains(",")) {
            this.txtAssigneeNameMulti.setVisibility(0);
            this.txtAssigneeName.setVisibility(8);
            this.txtAssigneeNameMulti.setText("[" + str + "]");
        } else {
            this.txtAssigneeName.setVisibility(0);
            this.txtAssigneeNameMulti.setVisibility(8);
            this.txtAssigneeName.setText("[" + str + "]");
        }
    }

    public void setStatusRemarks(String str) {
        if (str == null || str.isEmpty() || "null".equalsIgnoreCase(str)) {
            this.textQuesRemarks.setText("");
            return;
        }
        this.textQuesRemarks.setText(str);
        this.textQuesRemarks.setVisibility(0);
    }

    public void setStatusUpdateTime(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            this.txtQuesStatusUpdateTime.setVisibility(8);
        } else if (this.isCurrent) {
            this.txtQuesStatusUpdateTime.setVisibility(8);
            if (this.isLast) {
                this.textQuesDelayTime.setVisibility(8);
                return;
            }
            long time = (new Date().getTime() - (DateTimeUtils.getTimeInSeconds(str) * 1000)) / 3600000;
            long j = time / 24;
            time %= 24;
            this.textQuesDelayTime.setText(String.format(getResources().getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_text_ques_flow_name_delay_time", ResUtil.TYPE_STRING)), new Object[]{Long.valueOf(j), Long.valueOf(time)}));
            this.textQuesDelayTime.setVisibility(0);
        } else {
            this.textQuesDelayTime.setVisibility(8);
            this.txtQuesStatusUpdateTime.setText(str);
            this.txtQuesStatusUpdateTime.setVisibility(0);
        }
    }

    public void setIsCurrent(boolean z) {
        this.isCurrent = z;
    }

    public void setIsLast(boolean z) {
        this.isLast = z;
    }
}
