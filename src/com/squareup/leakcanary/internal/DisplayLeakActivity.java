package com.squareup.leakcanary.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.leisen.wallet.sdk.http.RequestParams;
import com.squareup.leakcanary.AnalysisResult;
import com.squareup.leakcanary.BuildConfig;
import com.squareup.leakcanary.CanaryLog;
import com.squareup.leakcanary.DefaultLeakDirectoryProvider;
import com.squareup.leakcanary.HeapDump;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.LeakDirectoryProvider;
import com.squareup.leakcanary.R;
import com.squareup.leakcanary.R$string;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;

public final class DisplayLeakActivity extends Activity {
    private static final String SHOW_LEAK_EXTRA = "show_latest";
    private static LeakDirectoryProvider leakDirectoryProvider = null;
    private Button actionButton;
    private TextView failureView;
    List<Leak> leaks;
    private ListView listView;
    String visibleLeakRefKey;

    class C25961 implements OnMenuItemClickListener {
        C25961() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            DisplayLeakActivity.this.shareLeak();
            return true;
        }
    }

    class C25972 implements OnMenuItemClickListener {
        C25972() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            DisplayLeakActivity.this.shareHeapDump();
            return true;
        }
    }

    class C25983 implements OnClickListener {
        C25983() {
        }

        public void onClick(View view) {
            DisplayLeakActivity.this.deleteVisibleLeak();
        }
    }

    class C26005 implements OnClickListener {
        C26005() {
        }

        public void onClick(View view) {
            DisplayLeakActivity.this.deleteVisibleLeak();
        }
    }

    class C26016 implements OnItemClickListener {
        C26016() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            DisplayLeakActivity.this.visibleLeakRefKey = ((Leak) DisplayLeakActivity.this.leaks.get(i)).heapDump.referenceKey;
            DisplayLeakActivity.this.updateUi();
        }
    }

    class C26037 implements OnClickListener {

        class C26021 implements DialogInterface.OnClickListener {
            C26021() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                DisplayLeakActivity.this.deleteAllLeaks();
            }
        }

        C26037() {
        }

        public void onClick(View view) {
            new Builder(DisplayLeakActivity.this).setIcon(17301543).setTitle(R$string.leak_canary_delete_all).setMessage(R$string.leak_canary_delete_all_leaks_title).setPositiveButton(17039370, new C26021()).setNegativeButton(17039360, null).show();
        }
    }

    class Leak {
        final HeapDump heapDump;
        final AnalysisResult result;
        final File resultFile;

        Leak(HeapDump heapDump, AnalysisResult analysisResult, File file) {
            this.heapDump = heapDump;
            this.result = analysisResult;
            this.resultFile = file;
        }
    }

    class LeakListAdapter extends BaseAdapter {
        LeakListAdapter() {
        }

        public int getCount() {
            return DisplayLeakActivity.this.leaks.size();
        }

        public Leak getItem(int i) {
            return (Leak) DisplayLeakActivity.this.leaks.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            if (view == null) {
                view = LayoutInflater.from(DisplayLeakActivity.this).inflate(R.layout.leak_canary_leak_row, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.leak_canary_row_text);
            TextView textView2 = (TextView) view.findViewById(R.id.leak_canary_row_time);
            Leak item = getItem(i);
            String str = (DisplayLeakActivity.this.leaks.size() - i) + ". ";
            if (item.result.failure == null) {
                String classSimpleName = DisplayLeakActivity.classSimpleName(item.result.className);
                String formatShortFileSize = Formatter.formatShortFileSize(DisplayLeakActivity.this, item.result.retainedHeapSize);
                classSimpleName = DisplayLeakActivity.this.getString(R$string.leak_canary_class_has_leaked, new Object[]{classSimpleName, formatShortFileSize});
                if (item.result.excludedLeak) {
                    classSimpleName = DisplayLeakActivity.this.getString(R$string.leak_canary_excluded_row, new Object[]{classSimpleName});
                }
                charSequence = str + classSimpleName;
            } else {
                charSequence = str + item.result.failure.getClass().getSimpleName() + HwAccountConstants.BLANK + item.result.failure.getMessage();
            }
            textView.setText(charSequence);
            textView2.setText(DateUtils.formatDateTime(DisplayLeakActivity.this, item.resultFile.lastModified(), 17));
            return view;
        }
    }

    class LoadLeaks implements Runnable {
        static final Executor backgroundExecutor = LeakCanaryInternals.newSingleThreadExecutor("LoadLeaks");
        static final List<LoadLeaks> inFlight = new ArrayList();
        DisplayLeakActivity activityOrNull;
        private final LeakDirectoryProvider leakDirectoryProvider;
        private final Handler mainHandler = new Handler(Looper.getMainLooper());

        class C26041 implements FilenameFilter {
            C26041() {
            }

            public boolean accept(File file, String str) {
                return str.endsWith(".result");
            }
        }

        class C26052 implements Comparator<Leak> {
            C26052() {
            }

            public int compare(Leak leak, Leak leak2) {
                return Long.valueOf(leak2.resultFile.lastModified()).compareTo(Long.valueOf(leak.resultFile.lastModified()));
            }
        }

        static void load(DisplayLeakActivity displayLeakActivity, LeakDirectoryProvider leakDirectoryProvider) {
            Runnable loadLeaks = new LoadLeaks(displayLeakActivity, leakDirectoryProvider);
            inFlight.add(loadLeaks);
            backgroundExecutor.execute(loadLeaks);
        }

        static void forgetActivity() {
            for (LoadLeaks loadLeaks : inFlight) {
                loadLeaks.activityOrNull = null;
            }
            inFlight.clear();
        }

        LoadLeaks(DisplayLeakActivity displayLeakActivity, LeakDirectoryProvider leakDirectoryProvider) {
            this.activityOrNull = displayLeakActivity;
            this.leakDirectoryProvider = leakDirectoryProvider;
        }

        public void run() {
            FileInputStream fileInputStream;
            Throwable e;
            Throwable th;
            final List arrayList = new ArrayList();
            for (File file : this.leakDirectoryProvider.listFiles(new C26041())) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        arrayList.add(new Leak((HeapDump) objectInputStream.readObject(), (AnalysisResult) objectInputStream.readObject(), file));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        if (file.delete()) {
                            try {
                                CanaryLog.m12770d(e, "Could not read result file %s, could not delete it either.", file);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            CanaryLog.m12770d(e, "Could not read result file %s, deleted it.", file);
                        }
                        if (fileInputStream == null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (ClassNotFoundException e5) {
                        e = e5;
                        if (file.delete()) {
                            CanaryLog.m12770d(e, "Could not read result file %s, could not delete it either.", file);
                        } else {
                            CanaryLog.m12770d(e, "Could not read result file %s, deleted it.", file);
                        }
                        if (fileInputStream == null) {
                            fileInputStream.close();
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    fileInputStream = fileInputStream2;
                    if (file.delete()) {
                        CanaryLog.m12770d(e, "Could not read result file %s, deleted it.", file);
                    } else {
                        CanaryLog.m12770d(e, "Could not read result file %s, could not delete it either.", file);
                    }
                    if (fileInputStream == null) {
                        fileInputStream.close();
                    }
                } catch (ClassNotFoundException e7) {
                    e = e7;
                    fileInputStream = null;
                    if (file.delete()) {
                        CanaryLog.m12770d(e, "Could not read result file %s, could not delete it either.", file);
                    } else {
                        CanaryLog.m12770d(e, "Could not read result file %s, deleted it.", file);
                    }
                    if (fileInputStream == null) {
                        fileInputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            }
            Collections.sort(arrayList, new C26052());
            this.mainHandler.post(new Runnable() {
                public void run() {
                    LoadLeaks.inFlight.remove(LoadLeaks.this);
                    if (LoadLeaks.this.activityOrNull != null) {
                        LoadLeaks.this.activityOrNull.leaks = arrayList;
                        LoadLeaks.this.activityOrNull.updateUi();
                    }
                }
            });
            return;
            throw th;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
    }

    public static PendingIntent createPendingIntent(Context context) {
        return createPendingIntent(context, null);
    }

    public static PendingIntent createPendingIntent(Context context, String str) {
        Intent intent = new Intent(context, DisplayLeakActivity.class);
        intent.putExtra(SHOW_LEAK_EXTRA, str);
        intent.setFlags(335544320);
        return PendingIntent.getActivity(context, 1, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }

    public static void setLeakDirectoryProvider(LeakDirectoryProvider leakDirectoryProvider) {
        leakDirectoryProvider = leakDirectoryProvider;
    }

    private static LeakDirectoryProvider leakDirectoryProvider(Context context) {
        LeakDirectoryProvider leakDirectoryProvider = leakDirectoryProvider;
        if (leakDirectoryProvider == null) {
            return new DefaultLeakDirectoryProvider(context);
        }
        return leakDirectoryProvider;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.visibleLeakRefKey = bundle.getString("visibleLeakRefKey");
        } else {
            Intent intent = getIntent();
            if (intent.hasExtra(SHOW_LEAK_EXTRA)) {
                this.visibleLeakRefKey = intent.getStringExtra(SHOW_LEAK_EXTRA);
            }
        }
        this.leaks = (List) getLastNonConfigurationInstance();
        setContentView(R.layout.leak_canary_display_leak);
        this.listView = (ListView) findViewById(R.id.leak_canary_display_leak_list);
        this.failureView = (TextView) findViewById(R.id.leak_canary_display_leak_failure);
        this.actionButton = (Button) findViewById(R.id.leak_canary_action);
        updateUi();
    }

    public Object onRetainNonConfigurationInstance() {
        return this.leaks;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("visibleLeakRefKey", this.visibleLeakRefKey);
    }

    protected void onResume() {
        super.onResume();
        LoadLeaks.load(this, leakDirectoryProvider(this));
    }

    public void setTheme(int i) {
        if (i == R.style.leak_canary_LeakCanary_Base) {
            super.setTheme(i);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        LoadLeaks.forgetActivity();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Leak visibleLeak = getVisibleLeak();
        if (visibleLeak == null) {
            return false;
        }
        menu.add(R$string.leak_canary_share_leak).setOnMenuItemClickListener(new C25961());
        if (visibleLeak.heapDump.heapDumpFile.exists()) {
            menu.add(R$string.leak_canary_share_heap_dump).setOnMenuItemClickListener(new C25972());
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.visibleLeakRefKey = null;
            updateUi();
        }
        return true;
    }

    public void onBackPressed() {
        if (this.visibleLeakRefKey != null) {
            this.visibleLeakRefKey = null;
            updateUi();
            return;
        }
        super.onBackPressed();
    }

    void shareLeak() {
        Leak visibleLeak = getVisibleLeak();
        String leakInfo = LeakCanary.leakInfo(this, visibleLeak.heapDump, visibleLeak.result, true);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", leakInfo);
        startActivity(Intent.createChooser(intent, getString(R$string.leak_canary_share_with)));
    }

    void shareHeapDump() {
        File file = getVisibleLeak().heapDump.heapDumpFile;
        file.setReadable(true, false);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(RequestParams.APPLICATION_OCTET_STREAM);
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        startActivity(Intent.createChooser(intent, getString(R$string.leak_canary_share_with)));
    }

    void deleteVisibleLeak() {
        Leak visibleLeak = getVisibleLeak();
        File file = visibleLeak.heapDump.heapDumpFile;
        if (!visibleLeak.resultFile.delete()) {
            CanaryLog.m12769d("Could not delete result file %s", visibleLeak.resultFile.getPath());
        }
        if (!file.delete()) {
            CanaryLog.m12769d("Could not delete heap dump file %s", file.getPath());
        }
        this.visibleLeakRefKey = null;
        this.leaks.remove(visibleLeak);
        updateUi();
    }

    void deleteAllLeaks() {
        leakDirectoryProvider(this).clearLeakDirectory();
        this.leaks = Collections.emptyList();
        updateUi();
    }

    void updateUi() {
        if (this.leaks == null) {
            setTitle("Loading leaks...");
            return;
        }
        if (this.leaks.isEmpty()) {
            this.visibleLeakRefKey = null;
        }
        Leak visibleLeak = getVisibleLeak();
        if (visibleLeak == null) {
            this.visibleLeakRefKey = null;
        }
        ListAdapter adapter = this.listView.getAdapter();
        this.listView.setVisibility(0);
        this.failureView.setVisibility(8);
        if (visibleLeak != null) {
            AnalysisResult analysisResult = visibleLeak.result;
            if (analysisResult.failure != null) {
                this.listView.setVisibility(8);
                this.failureView.setVisibility(0);
                this.failureView.setText(getString(R$string.leak_canary_failure_report) + BuildConfig.LIBRARY_VERSION + HwAccountConstants.BLANK + BuildConfig.GIT_SHA + "\n" + Log.getStackTraceString(analysisResult.failure));
                setTitle(R$string.leak_canary_analysis_failed);
                invalidateOptionsMenu();
                getActionBar().setDisplayHomeAsUpEnabled(true);
                this.actionButton.setVisibility(0);
                this.actionButton.setText(R$string.leak_canary_delete);
                this.actionButton.setOnClickListener(new C25983());
                this.listView.setAdapter(null);
                return;
            }
            DisplayLeakAdapter displayLeakAdapter;
            if (adapter instanceof DisplayLeakAdapter) {
                displayLeakAdapter = (DisplayLeakAdapter) adapter;
            } else {
                displayLeakAdapter = new DisplayLeakAdapter();
                this.listView.setAdapter(displayLeakAdapter);
                this.listView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        displayLeakAdapter.toggleRow(i);
                    }
                });
                invalidateOptionsMenu();
                getActionBar().setDisplayHomeAsUpEnabled(true);
                this.actionButton.setVisibility(0);
                this.actionButton.setText(R$string.leak_canary_delete);
                this.actionButton.setOnClickListener(new C26005());
            }
            HeapDump heapDump = visibleLeak.heapDump;
            displayLeakAdapter.update(analysisResult.leakTrace, heapDump.referenceKey, heapDump.referenceName);
            String formatShortFileSize = Formatter.formatShortFileSize(this, analysisResult.retainedHeapSize);
            String classSimpleName = classSimpleName(analysisResult.className);
            setTitle(getString(R$string.leak_canary_class_has_leaked, new Object[]{classSimpleName, formatShortFileSize}));
            return;
        }
        int i;
        if (adapter instanceof LeakListAdapter) {
            ((LeakListAdapter) adapter).notifyDataSetChanged();
        } else {
            this.listView.setAdapter(new LeakListAdapter());
            this.listView.setOnItemClickListener(new C26016());
            invalidateOptionsMenu();
            setTitle(getString(R$string.leak_canary_leak_list_title, new Object[]{getPackageName()}));
            getActionBar().setDisplayHomeAsUpEnabled(false);
            this.actionButton.setText(R$string.leak_canary_delete_all);
            this.actionButton.setOnClickListener(new C26037());
        }
        Button button = this.actionButton;
        if (this.leaks.size() == 0) {
            i = 8;
        } else {
            i = 0;
        }
        button.setVisibility(i);
    }

    Leak getVisibleLeak() {
        if (this.leaks == null) {
            return null;
        }
        for (Leak leak : this.leaks) {
            if (leak.heapDump.referenceKey.equals(this.visibleLeakRefKey)) {
                return leak;
            }
        }
        return null;
    }

    static String classSimpleName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }
}
