package com.huawei.crowdtestsdk.history;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.huawei.crowdtestsdk.history.bean.ProjectViewHolder;
import com.huawei.crowdtestsdk.utils.ResUtil;

class ProjectListViewAdapter extends ResourceCursorAdapter {
    public ProjectListViewAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, i, cursor, z);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        ProjectViewHolder projectViewHolder = new ProjectViewHolder();
        projectViewHolder.setProjectIcon((ImageView) newView.findViewById(ResUtil.getResId(context, "personal_issue_project_left_icon", "id")));
        projectViewHolder.setTvProjectTitle((TextView) newView.findViewById(ResUtil.getResId(context, "personal_issue_project_name", "id")));
        newView.setTag(projectViewHolder);
        return newView;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        if (cursor != null) {
            ProjectViewHolder projectViewHolder = (ProjectViewHolder) view.getTag();
            CharSequence string = cursor.getString(2);
            projectViewHolder.getProjectIcon().setImageResource(ResUtil.getResId(context, "sdk_crowdtest_project_icon_joining", ResUtil.TYPE_DRAWABLE));
            projectViewHolder.getTvProjectTitle().setText(string);
        }
    }
}
