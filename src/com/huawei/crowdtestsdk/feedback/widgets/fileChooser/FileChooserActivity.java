package com.huawei.crowdtestsdk.feedback.widgets.fileChooser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.androidcommon.storage.SdcardManager;
import com.huawei.crowdtestsdk.constants.SdfConstants;
import com.huawei.crowdtestsdk.feedback.widgets.BaseChooserActivity;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.uploadlog.p188c.C2515k;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileChooserActivity extends BaseChooserActivity {
    File[] currentFiles;
    File currentParent;
    String externalPath;
    private FileAdapter fileAdapter;
    private Comparator<File> fileComparator = new C07321();
    String internalPath;
    List<Map<String, Object>> listItems = new ArrayList();
    ListView listView;
    private Map<Integer, Boolean> mChecked = new HashMap();
    private OnClickListener onClickListener = new C07354();
    OnItemClickListener onItemClickListener = new C07332();
    File root = new File(this.rootPath);
    String rootPath = "/storage";
    File sdcard;
    File sdcard1;
    ArrayList<Map<String, String>> selectItems = new ArrayList();
    TextView textView;
    private ImageView titleBarImage;
    private TextView titleBarText;
    private Button tvOk;

    class C07321 implements Comparator<File> {
        C07321() {
        }

        public int compare(File file, File file2) {
            if (file.isDirectory() && !file2.isDirectory()) {
                return -1;
            }
            if (file.isDirectory() || !file2.isDirectory()) {
                return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
            }
            return 1;
        }
    }

    class C07332 implements OnItemClickListener {
        C07332() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (FileChooserActivity.this.getCanonicalPath().equals(FileChooserActivity.this.rootPath)) {
                if (i == 0) {
                    FileChooserActivity.this.currentParent = FileChooserActivity.this.sdcard;
                    FileChooserActivity.this.currentFiles = FileChooserActivity.this.getListFiles(FileChooserActivity.this.sdcard);
                } else {
                    FileChooserActivity.this.currentParent = FileChooserActivity.this.sdcard1;
                    FileChooserActivity.this.currentFiles = FileChooserActivity.this.getListFiles(FileChooserActivity.this.sdcard1);
                }
                FileChooserActivity.this.inflateListView(FileChooserActivity.this.currentFiles);
                FileChooserActivity.this.fileAdapter.notifyDataSetChanged();
            } else if (i == 0) {
                FileChooserActivity.this.currentParent = FileChooserActivity.this.root;
                FileChooserActivity.this.inflateListView(FileChooserActivity.this.currentFiles);
                FileChooserActivity.this.fileAdapter.notifyDataSetChanged();
            } else if (i == 1) {
                if (FileChooserActivity.this.getCanonicalPath().equals(FileChooserActivity.this.internalPath)) {
                    FileChooserActivity.this.currentParent = FileChooserActivity.this.root;
                } else {
                    FileChooserActivity.this.currentParent = FileChooserActivity.this.currentParent.getParentFile();
                }
                FileChooserActivity.this.currentFiles = FileChooserActivity.this.getListFiles(FileChooserActivity.this.currentParent);
                FileChooserActivity.this.inflateListView(FileChooserActivity.this.currentFiles);
                FileChooserActivity.this.fileAdapter.notifyDataSetChanged();
            } else if (FileChooserActivity.this.currentFiles == null || !FileChooserActivity.this.currentFiles[i - 2].exists()) {
                Toast.makeText(FileChooserActivity.this, ResUtil.getResId(FileChooserActivity.this, "sdk_crowdtest_open_file_exception", ResUtil.TYPE_STRING), 0).show();
            } else if (FileChooserActivity.this.currentFiles[i - 2].isDirectory()) {
                File[] access$100 = FileChooserActivity.this.getListFiles(FileChooserActivity.this.currentFiles[i - 2]);
                FileChooserActivity.this.currentParent = FileChooserActivity.this.currentFiles[i - 2];
                FileChooserActivity.this.currentFiles = access$100;
                FileChooserActivity.this.inflateListView(FileChooserActivity.this.currentFiles);
                FileChooserActivity.this.fileAdapter.notifyDataSetChanged();
            } else {
                if (((Boolean) FileChooserActivity.this.mChecked.get(Integer.valueOf(i - 2))).booleanValue()) {
                    FileChooserActivity.this.mChecked.put(Integer.valueOf(i - 2), Boolean.valueOf(false));
                    Log.d("BETACLUB_SDK", "[FileChooserActivity.onItemClickListener]mArrayIds.remove:position=" + i);
                } else {
                    FileChooserActivity.this.mChecked.put(Integer.valueOf(i - 2), Boolean.valueOf(true));
                    Log.d("BETACLUB_SDK", "[FileChooserActivity.onItemClickListener]mArrayIds.add:position=" + i);
                }
                FileChooserActivity.this.fileAdapter.notifyDataSetChanged();
            }
        }
    }

    class C07343 implements FileFilter {
        C07343() {
        }

        public boolean accept(File file) {
            if (file.isHidden()) {
                return false;
            }
            return true;
        }
    }

    class C07354 implements OnClickListener {
        C07354() {
        }

        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            if (FileChooserActivity.this.getCanonicalPath() == null || FileChooserActivity.this.getCanonicalPath().equals(FileChooserActivity.this.rootPath)) {
                FileChooserActivity.this.finishAndSave();
            } else {
                for (Integer num : FileChooserActivity.this.mChecked.keySet()) {
                    if (((Boolean) FileChooserActivity.this.mChecked.get(num)).booleanValue()) {
                        String str = FileChooserActivity.this.getCanonicalPath() + "/" + ((Map) FileChooserActivity.this.listItems.get(num.intValue() + 2)).get(UploadFile.FILE_NAME).toString();
                        Log.d("BETACLUB_SDK", "[FileChooserActivity.onClickListener]add filePath:" + str);
                        arrayList.add(str);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                Log.d("BETACLUB_SDK", "[FileChooserActivity.onClickListener]selectItemPathList is empty");
                FileChooserActivity.this.finishAndSave();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("pathList", arrayList);
            intent.putExtras(bundle);
            FileChooserActivity.this.setResult(-1, intent);
            FileChooserActivity.this.finishAndSave();
        }
    }

    class FileAdapter extends BaseAdapter {
        private Context mContext;

        public FileAdapter(Context context) {
            this.mContext = context;
        }

        public int getCount() {
            return FileChooserActivity.this.listItems.size();
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                view = LayoutInflater.from(FileChooserActivity.this).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_file_item", ResUtil.TYPE_LAYOUT), null);
                viewHolder.image = (ImageView) view.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_icon", "id"));
                viewHolder.layoutFileDetail = (LinearLayout) view.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_file_detail_layout", "id"));
                viewHolder.tvName = (TextView) view.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_file_name", "id"));
                viewHolder.tvDate = (TextView) view.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_file_date", "id"));
                viewHolder.tvSize = (TextView) view.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_file_size", "id"));
                viewHolder.checkBox = (CheckBox) view.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_check_box", "id"));
                viewHolder.folderEnter = (ImageView) view.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_file_selector_folder_enter", "id"));
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int parseInt = Integer.parseInt(((Map) FileChooserActivity.this.listItems.get(i)).get("icon").toString());
            CharSequence obj = ((Map) FileChooserActivity.this.listItems.get(i)).get(UploadFile.FILE_NAME).toString();
            viewHolder.image.setImageResource(parseInt);
            viewHolder.tvName.setText(obj);
            if (parseInt == ResUtil.getResId(this.mContext, "sdk_crowdtest_filedialog_file", ResUtil.TYPE_DRAWABLE)) {
                CharSequence obj2 = ((Map) FileChooserActivity.this.listItems.get(i)).get("fileSize").toString();
                obj = ((Map) FileChooserActivity.this.listItems.get(i)).get("fileDate").toString();
                viewHolder.layoutFileDetail.setVisibility(0);
                viewHolder.tvDate.setVisibility(0);
                viewHolder.tvSize.setVisibility(0);
                viewHolder.checkBox.setVisibility(0);
                viewHolder.folderEnter.setVisibility(8);
                viewHolder.tvDate.setText(obj);
                viewHolder.tvSize.setText(obj2);
            } else if (parseInt == ResUtil.getResId(this.mContext, "sdk_crowdtest_filedialog_folder", ResUtil.TYPE_DRAWABLE)) {
                int[] iArr = (int[]) ((Map) FileChooserActivity.this.listItems.get(i)).get("folderInfo");
                obj = String.format(FileChooserActivity.this.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_attachment_folder_info", ResUtil.TYPE_STRING)), new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                viewHolder.checkBox.setVisibility(8);
                viewHolder.tvDate.setVisibility(0);
                viewHolder.tvSize.setVisibility(8);
                viewHolder.layoutFileDetail.setVisibility(0);
                viewHolder.folderEnter.setVisibility(0);
                viewHolder.tvDate.setText(obj);
            } else {
                viewHolder.checkBox.setVisibility(8);
                viewHolder.layoutFileDetail.setVisibility(8);
            }
            if (!(FileChooserActivity.this.getCanonicalPath() == null || FileChooserActivity.this.getCanonicalPath().equals(FileChooserActivity.this.rootPath) || viewHolder.checkBox.getVisibility() != 0)) {
                viewHolder.checkBox.setChecked(((Boolean) FileChooserActivity.this.mChecked.get(Integer.valueOf(i - 2))).booleanValue());
                viewHolder.checkBox.setButtonDrawable(ResUtil.getResId(this.mContext, "sdk_crowdtest_selector_checkbox_rectangle_blue", ResUtil.TYPE_DRAWABLE));
            }
            FileChooserActivity.this.textView.setText(FileChooserActivity.this.getCanonicalPath());
            return view;
        }
    }

    class ViewHolder {
        public CheckBox checkBox;
        public ImageView folderEnter;
        public ImageView image;
        public LinearLayout layoutFileDetail;
        public TextView tvDate;
        public TextView tvName;
        public TextView tvSize;

        ViewHolder() {
        }
    }

    private File[] getListFiles(File file) {
        return file.listFiles(new C07343());
    }

    private void finishAndSave() {
        C2515k.m12542a(getCanonicalPath());
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtil.getResId(this, "sdk_crowdtest_activity_file_chooser", ResUtil.TYPE_LAYOUT));
        initStoragePath();
        initView();
        initData();
    }

    private void initStoragePath() {
        SdcardManager instance = SdcardManager.getInstance();
        this.internalPath = "/storage/emulated/0";
        Log.d("BETACLUB_SDK", "[FileChooserActivity.initStoragePath]internalPath" + this.internalPath);
        if (this.internalPath != null) {
            this.sdcard = new File(this.internalPath);
        }
        if (isSdExist().booleanValue()) {
            this.externalPath = instance.getExternalStoragePath(this);
            if (this.externalPath != null) {
                this.sdcard1 = new File(this.externalPath);
            }
        }
    }

    public Boolean isSdExist() {
        if (SdcardManager.getInstance().isExternalMount(this)) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    protected void initView() {
        this.titleBarImage = (ImageView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_image", "id"));
        this.titleBarText = (TextView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_title_bar_text", "id"));
        this.titleBarImage.setImageResource(0);
        this.titleBarImage.setVisibility(8);
        this.titleBarText.setText(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_file_chooser", ResUtil.TYPE_STRING));
        this.listView = (ListView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_list", "id"));
        this.textView = (TextView) findViewById(ResUtil.getResId(this, "sdk_crowdtest_path", "id"));
        this.tvOk = (Button) findViewById(ResUtil.getResId(this, "sdk_crowdtest_select", "id"));
        this.listView.setOnItemClickListener(this.onItemClickListener);
        this.tvOk.setOnClickListener(this.onClickListener);
    }

    private void initData() {
        String b = C2515k.m12546b();
        if (b != null) {
            this.currentParent = new File(b);
            if (!(this.currentParent.exists() && this.currentParent.isDirectory())) {
                this.currentParent = this.root;
            }
        } else {
            this.currentParent = this.root;
        }
        this.currentFiles = getListFiles(this.currentParent);
        inflateListView(this.currentFiles);
        if (this.fileAdapter == null) {
            this.fileAdapter = new FileAdapter(this);
            this.listView.setAdapter(this.fileAdapter);
        }
    }

    private void inflateListView(File[] fileArr) {
        if (fileArr != null) {
            List asList = Arrays.asList(fileArr);
            Collections.sort(asList, this.fileComparator);
            File[] fileArr2 = (File[]) asList.toArray(new File[asList.size()]);
            this.listItems.clear();
            this.selectItems.clear();
            this.mChecked.clear();
            if (getCanonicalPath().equals(this.rootPath)) {
                Map hashMap = new HashMap();
                hashMap.put("icon", Integer.valueOf(ResUtil.getResId(this, "sdk_crowdtest_filedialog_folder", ResUtil.TYPE_DRAWABLE)));
                hashMap.put(UploadFile.FILE_NAME, getString(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_internal_storage", ResUtil.TYPE_STRING)));
                hashMap.put("folderInfo", getFileNum(this.sdcard));
                this.listItems.add(hashMap);
                if (isSdExist().booleanValue()) {
                    hashMap = new HashMap();
                    hashMap.put("icon", Integer.valueOf(ResUtil.getResId(this, "sdk_crowdtest_filedialog_folder", ResUtil.TYPE_DRAWABLE)));
                    hashMap.put(UploadFile.FILE_NAME, getString(ResUtil.getResId(this, "sdk_crowdtest_description_attachment_external_storage", ResUtil.TYPE_STRING)));
                    hashMap.put("folderInfo", getFileNum(this.sdcard1));
                    this.listItems.add(hashMap);
                    return;
                }
                return;
            }
            Map hashMap2 = new HashMap();
            hashMap2.put("icon", Integer.valueOf(ResUtil.getResId(this, "sdk_crowdtest_filedialog_root", ResUtil.TYPE_DRAWABLE)));
            hashMap2.put(UploadFile.FILE_NAME, getString(ResUtil.getResId(this, "sdk_crowdtest_back_to_root", ResUtil.TYPE_STRING)));
            this.listItems.add(hashMap2);
            hashMap2 = new HashMap();
            hashMap2.put("icon", Integer.valueOf(ResUtil.getResId(this, "sdk_crowdtest_filedialog_folder_up", ResUtil.TYPE_DRAWABLE)));
            hashMap2.put(UploadFile.FILE_NAME, getString(ResUtil.getResId(this, "sdk_crowdtest_back_to_previous", ResUtil.TYPE_STRING)));
            this.listItems.add(hashMap2);
            if (fileArr2 != null && fileArr2.length > 0) {
                for (int i = 0; i < fileArr2.length; i++) {
                    Map hashMap3 = new HashMap();
                    if (fileArr2[i].isDirectory()) {
                        hashMap3.put("icon", Integer.valueOf(ResUtil.getResId(this, "sdk_crowdtest_filedialog_folder", ResUtil.TYPE_DRAWABLE)));
                        hashMap3.put("folderInfo", getFileNum(fileArr2[i]));
                    } else {
                        this.mChecked.put(Integer.valueOf(i), Boolean.valueOf(false));
                        hashMap3.put("icon", Integer.valueOf(ResUtil.getResId(this, "sdk_crowdtest_filedialog_file", ResUtil.TYPE_DRAWABLE)));
                        hashMap3.put("fileSize", getFileSizes(fileArr2[i]));
                        hashMap3.put("fileDate", getFileDate(fileArr2[i]));
                    }
                    hashMap3.put(UploadFile.FILE_NAME, fileArr2[i].getName());
                    this.listItems.add(hashMap3);
                }
            }
        }
    }

    private String getCanonicalPath() {
        String str = null;
        try {
            str = this.currentParent.getCanonicalPath();
        } catch (IOException e) {
            Log.e("BETACLUB_SDK", "[FileChooserActivity.getCanonicalPath]exception");
        }
        return str;
    }

    public String getFileDate(File file) {
        if (file == null || !file.exists()) {
            return "unknown";
        }
        return SdfConstants.getDateTimeNoSecond(file.lastModified());
    }

    public String getFileSizes(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return Formatter.formatFileSize(this, file.length());
        }
        return "";
    }

    public int[] getFileNum(File file) {
        int i;
        int i2;
        int[] iArr = new int[2];
        if (file != null && file.exists()) {
            File[] listFiles = getListFiles(file);
            if (listFiles != null && listFiles.length > 0) {
                i = 0;
                i2 = 0;
                for (File isDirectory : listFiles) {
                    if (isDirectory.isDirectory()) {
                        i2++;
                    } else {
                        i++;
                    }
                }
                iArr[0] = i2;
                iArr[1] = i;
                return iArr;
            }
        }
        i = 0;
        i2 = 0;
        iArr[0] = i2;
        iArr[1] = i;
        return iArr;
    }

    public void onBackPressed() {
        if (getCanonicalPath().equals(this.rootPath)) {
            finishAndSave();
            super.onBackPressed();
            return;
        }
        if (getCanonicalPath().equals(this.internalPath)) {
            this.currentParent = this.root;
        } else {
            this.currentParent = this.currentParent.getParentFile();
        }
        this.currentFiles = getListFiles(this.currentParent);
        inflateListView(this.currentFiles);
        this.fileAdapter.notifyDataSetChanged();
    }

    protected void onResume() {
        this.currentFiles = getListFiles(this.currentParent);
        inflateListView(this.currentFiles);
        this.fileAdapter.notifyDataSetChanged();
        super.onResume();
    }
}
