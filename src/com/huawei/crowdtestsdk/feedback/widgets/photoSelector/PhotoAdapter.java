package com.huawei.crowdtestsdk.feedback.widgets.photoSelector;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.crowdtestsdk.utils.ResUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

public class PhotoAdapter extends FolderListAdapter<String> {
    private static final ArrayList<String> mSelectedImagePaths = new ArrayList();
    private Context mContext;
    private String mDirPath;

    public static ArrayList<String> getSelectedImagePaths() {
        return mSelectedImagePaths;
    }

    public PhotoAdapter(Context context, List<String> list, int i, String str) {
        super(context, list, i);
        this.mDirPath = str;
        this.mContext = context;
        mSelectedImagePaths.clear();
    }

    public void convert(ViewHolder viewHolder, final String str) {
        viewHolder.setImageResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_id_item_image", "id"), ResUtil.getResId(this.mContext, "sdk_crowdtest_photoselector_pictures_no", ResUtil.TYPE_DRAWABLE));
        viewHolder.setImageResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_id_item_select", "id"), ResUtil.getResId(this.mContext, "sdk_crowdtest_photoselector_picture_unselected", ResUtil.TYPE_DRAWABLE));
        viewHolder.setImageByUrl(ResUtil.getResId(this.mContext, "sdk_crowdtest_id_item_image", "id"), this.mDirPath + "/" + str);
        viewHolder.setImageResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_photo_selector_picture_icon", "id"), ResUtil.getResId(this.mContext, "sdk_crowdtest_photo_selector_icon_video", ResUtil.TYPE_DRAWABLE));
        final ImageView imageView = (ImageView) viewHolder.getView(ResUtil.getResId(this.mContext, "sdk_crowdtest_id_item_image", "id"));
        final ImageView imageView2 = (ImageView) viewHolder.getView(ResUtil.getResId(this.mContext, "sdk_crowdtest_id_item_select", "id"));
        LinearLayout linearLayout = (LinearLayout) viewHolder.getView(ResUtil.getResId(this.mContext, "sdk_crowdtest_item_select", "id"));
        ImageView imageView3 = (ImageView) viewHolder.getView(ResUtil.getResId(this.mContext, "sdk_crowdtest_photo_selector_picture_icon", "id"));
        if (str.endsWith(".mp4")) {
            imageView3.setVisibility(0);
        } else {
            imageView3.setVisibility(8);
        }
        imageView.setColorFilter(null);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Uri fromFile = Uri.fromFile(new File(PhotoAdapter.this.mDirPath + "/" + str));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(fromFile, "image/*");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                PhotoAdapter.this.mContext.startActivity(intent);
            }
        });
        linearLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (PhotoAdapter.mSelectedImagePaths.contains(PhotoAdapter.this.mDirPath + "/" + str)) {
                    PhotoAdapter.mSelectedImagePaths.remove(PhotoAdapter.this.mDirPath + "/" + str);
                    imageView2.setImageResource(ResUtil.getResId(PhotoAdapter.this.mContext, "sdk_crowdtest_photoselector_picture_unselected", ResUtil.TYPE_DRAWABLE));
                    imageView.setColorFilter(null);
                    return;
                }
                PhotoAdapter.mSelectedImagePaths.add(PhotoAdapter.this.mDirPath + "/" + str);
                imageView2.setImageResource(ResUtil.getResId(PhotoAdapter.this.mContext, "sdk_crowdtest_photoselector_picture_selected", ResUtil.TYPE_DRAWABLE));
                imageView.setColorFilter(Color.parseColor("#77000000"));
            }
        });
        if (mSelectedImagePaths.contains(this.mDirPath + "/" + str)) {
            imageView2.setImageResource(ResUtil.getResId(this.mContext, "sdk_crowdtest_photoselector_picture_selected", ResUtil.TYPE_DRAWABLE));
            imageView.setColorFilter(Color.parseColor("#77000000"));
        }
    }
}
