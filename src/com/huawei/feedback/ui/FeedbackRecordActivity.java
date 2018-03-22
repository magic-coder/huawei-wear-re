package com.huawei.feedback.ui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.feedback.FeedbackApi;
import com.huawei.feedback.bean.C4410d;
import com.huawei.feedback.component.ProgressService;
import com.huawei.feedback.d;
import com.huawei.feedback.logic.C4423n;
import com.huawei.feedback.logic.f;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.logupload.LogUpload;
import com.huawei.logupload.a;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.io.File;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import p000a.p001a.p002a.p202b.C2852a;

public class FeedbackRecordActivity extends BaseActivity implements OnItemLongClickListener {
    private static String f16534s = "";
    LogCollectManager f16535a = null;
    private ActionBar f16536b;
    private LinearLayout f16537c;
    private LinearLayout f16538d;
    private ListView f16539e;
    private List<C4410d> f16540f;
    private List<LogUpload> f16541g = new ArrayList();
    private a f16542h;
    private ProgressReceiver f16543i = new ProgressReceiver(this);
    private ProgressStartReceiver f16544j = new ProgressStartReceiver(this);
    private ProgressCancelReceiver f16545k = new ProgressCancelReceiver(this);
    private ProgressPauseReceiver f16546l = new ProgressPauseReceiver(this);
    private AlertDialog f16547m;
    private C4445b f16548n;
    private BroadcastReceiver f16549o = null;
    private IntentFilter f16550p = null;
    private boolean f16551q = false;
    private RelativeLayout f16552r;
    private Handler f16553t = new C4476y(this);
    private OnItemClickListener f16554u = new aa(this);
    private Menu f16555v;
    private int f16556w;

    public class ProgressCancelReceiver extends BroadcastReceiver {
        final /* synthetic */ FeedbackRecordActivity f16526a;

        public ProgressCancelReceiver(FeedbackRecordActivity feedbackRecordActivity) {
            this.f16526a = feedbackRecordActivity;
        }

        public void onReceive(Context context, Intent intent) {
            long j = -1;
            if (intent != null) {
                String action = intent.getAction();
                if ("com.example.logupload.progress.cancel".equals(action)) {
                    c.a("FeedbackRecordActivity", "ProgressCancelReceiver onReceive");
                    try {
                        j = intent.getLongExtra("strID", -1);
                    } catch (Exception e) {
                        c.b("FeedbackRecordActivity", "strId get exception" + e.getMessage());
                    }
                    c.a("FeedbackRecordActivity", "strId:" + j);
                } else if ("com.example.logupload.exception".equals(action)) {
                    long longExtra;
                    try {
                        longExtra = intent.getLongExtra("strID", -1);
                    } catch (Exception e2) {
                        c.b("FeedbackRecordActivity", "strId get exception" + e2.getMessage());
                        longExtra = j;
                    }
                    f.a(String.valueOf(longExtra), 3);
                    for (C4410d c4410d : this.f16526a.f16540f) {
                        if (!TextUtils.isEmpty(c4410d.m21212i()) && longExtra == Long.parseLong(c4410d.m21212i())) {
                            c4410d.m21193b(3);
                            break;
                        }
                    }
                    try {
                        Collections.sort(this.f16526a.f16540f, new C4446c());
                    } catch (IllegalArgumentException e3) {
                        c.d("FeedbackRecordActivity", "Arrays sort IllegalArgumentException");
                    }
                    if (this.f16526a.f16548n != null) {
                        this.f16526a.f16548n.notifyDataSetChanged();
                    }
                    if (this.f16526a.m21443m() > 0 && this.f16526a.f16555v != null && this.f16526a.f16555v.getItem(0) != null && !this.f16526a.f16555v.hasVisibleItems()) {
                        this.f16526a.f16555v.setGroupEnabled(0, true);
                        this.f16526a.f16555v.setGroupVisible(0, true);
                    }
                }
            }
        }
    }

    public class ProgressPauseReceiver extends BroadcastReceiver {
        final /* synthetic */ FeedbackRecordActivity f16527a;

        public ProgressPauseReceiver(FeedbackRecordActivity feedbackRecordActivity) {
            this.f16527a = feedbackRecordActivity;
        }

        public void onReceive(Context context, Intent intent) {
            long longExtra;
            long j = -1;
            if (intent != null) {
                if ("com.example.logupload.progress.pause".equals(intent.getAction())) {
                    c.a("FeedbackRecordActivity", "ProgressPauseReceiver onReceive");
                    try {
                        longExtra = intent.getLongExtra("strID", -1);
                    } catch (Exception e) {
                        c.b("FeedbackRecordActivity", "strId get exception" + e.getMessage());
                        longExtra = j;
                    }
                    for (C4410d c4410d : this.f16527a.f16540f) {
                        if (!TextUtils.isEmpty(c4410d.m21212i()) && r2 == Long.parseLong(c4410d.m21212i())) {
                            c4410d.m21200d("1");
                            if (c4410d.m21214j() != 3) {
                                c4410d.m21193b(5);
                            }
                        }
                    }
                    if (this.f16527a.f16548n != null) {
                        this.f16527a.f16548n.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                c.a("FeedbackRecordActivity", "ProgressPauseReceiver mLogUploadInfo == null");
            }
        }
    }

    public class ProgressReceiver extends BroadcastReceiver {
        final /* synthetic */ FeedbackRecordActivity f16528a;

        public ProgressReceiver(FeedbackRecordActivity feedbackRecordActivity) {
            this.f16528a = feedbackRecordActivity;
        }

        private String m21408a(Intent intent) {
            String str = null;
            try {
                str = intent.getStringExtra("extraValue");
            } catch (Exception e) {
                c.b("FeedbackRecordActivity", "extraValue exception = " + e.getMessage());
            }
            return str;
        }

        private Parcelable m21409b(Intent intent) {
            Parcelable parcelable = null;
            try {
                parcelable = intent.getParcelableExtra("mLogUploadInfo");
            } catch (Exception e) {
                c.b("FeedbackRecordActivity", "parcel exception = " + e.getMessage());
            }
            return parcelable;
        }

        private String m21410c(Intent intent) {
            String str = "";
            try {
                str = intent.getStringExtra(JoinConstants.EXCEPTION);
            } catch (Exception e) {
                c.b("FeedbackRecordActivity", "exception " + e.getMessage());
            }
            return str;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                Parcelable b = m21409b(intent);
                LogUpload logUpload = null;
                if (b != null && (b instanceof LogUpload)) {
                    logUpload = (LogUpload) b;
                }
                if ("com.example.logupload.progress".equals(action)) {
                    String c = m21410c(intent);
                    long j;
                    String[] split;
                    int parseInt;
                    if (TextUtils.isEmpty(c)) {
                        if (logUpload != null) {
                            c.a("FeedbackRecordActivity", "ProgressReceiver onReceive");
                            c.a("FeedbackRecordActivity", "mLogUploadInfo.getId() :" + logUpload.i());
                            c.a("FeedbackRecordActivity", "mLogUploadInfo.getTaskId() :" + logUpload.f());
                            if (FeedbackRecordActivity.f16534s.equals(logUpload.C()) && !TextUtils.isEmpty(logUpload.v())) {
                                for (C4410d c4410d : this.f16528a.f16540f) {
                                    if (!TextUtils.isEmpty(c4410d.m21212i())) {
                                        if (logUpload.i() == Long.parseLong(c4410d.m21212i())) {
                                            action = logUpload.v();
                                            j = logUpload.j();
                                            if (TextUtils.isEmpty(action)) {
                                                action = "0";
                                            } else {
                                                split = action.split(",");
                                                if (split.length >= 2 && !TextUtils.isEmpty(split[1])) {
                                                    action = split[1].substring(0, split[1].length() - 1);
                                                }
                                            }
                                            try {
                                                parseInt = Integer.parseInt(action);
                                                if (j > 0) {
                                                    parseInt = (int) ((((float) parseInt) / ((float) j)) * 100.0f);
                                                    c4410d.m21197c(String.format(Locale.getDefault(), this.f16528a.getResources().getString(d.b(this.f16528a, "feedback_advanced_loguploading")), new Object[]{parseInt + "%"}));
                                                }
                                            } catch (NumberFormatException e) {
                                                c.a("FeedbackRecordActivity", "mLogUploadInfo != null NumberFormatException");
                                            }
                                            action = m21408a(intent);
                                            if ("2".equals(logUpload.c()) && action == null) {
                                                logUpload.c("0");
                                            }
                                            c4410d.m21200d(logUpload.c());
                                            c4410d.m21193b(5);
                                        }
                                    }
                                }
                            }
                        }
                    } else if ("1".equals(c)) {
                        c.a("FeedbackRecordActivity", "exception:" + c);
                        r0 = null;
                        if (this.f16528a.f16542h != null) {
                            try {
                                r0 = this.f16528a.f16542h.a();
                            } catch (RemoteException e2) {
                                c.d("FeedbackRecordActivity", "ProgressReceiver RemoteException");
                            }
                        }
                        if (r0 != null) {
                            for (LogUpload logUpload2 : r0) {
                                if (FeedbackRecordActivity.f16534s.equals(logUpload2.C()) && !"1".equals(logUpload2.c())) {
                                    logUpload2.c("2");
                                    try {
                                        c.a("FeedbackRecordActivity", "updateStatus flag:" + this.f16528a.f16542h.a(logUpload2));
                                        for (C4410d c4410d2 : this.f16528a.f16540f) {
                                            if (!TextUtils.isEmpty(c4410d2.m21212i()) && logUpload2.i() == Long.parseLong(c4410d2.m21212i())) {
                                                c4410d2.m21193b(2);
                                                long j2 = logUpload2.j();
                                                action = logUpload2.v();
                                                if (TextUtils.isEmpty(action)) {
                                                    action = "0";
                                                } else {
                                                    String[] split2 = action.split(",");
                                                    if (split2.length >= 2 && !TextUtils.isEmpty(split2[1])) {
                                                        action = split2[1].substring(0, split2[1].length() - 1);
                                                    }
                                                }
                                                try {
                                                    parseInt = Integer.parseInt(action);
                                                    if (j2 > 0) {
                                                        parseInt = (int) ((((float) parseInt) / ((float) j2)) * 100.0f);
                                                        c4410d2.m21197c(String.format(Locale.getDefault(), this.f16528a.getResources().getString(d.b(this.f16528a, "feedback_advanced_loguploading")), new Object[]{parseInt + "%"}));
                                                    }
                                                } catch (NumberFormatException e3) {
                                                    c.a("FeedbackRecordActivity", "ProgressReceiver NumberFormatException");
                                                }
                                                c4410d2.m21200d(logUpload2.c());
                                                f.c(c4410d2);
                                            }
                                        }
                                        Collections.sort(this.f16528a.f16540f, new C4446c());
                                    } catch (IllegalArgumentException e4) {
                                        c.d("FeedbackRecordActivity", "Arrays sort IllegalArgumentException");
                                    } catch (RemoteException e5) {
                                        c.d("FeedbackRecordActivity", "RemoteException e");
                                    }
                                }
                            }
                        }
                    } else if ("2".equals(c) && logUpload != null) {
                        c.b("FeedbackRecordActivity", "exception:" + c);
                        r0 = null;
                        if (this.f16528a.f16542h != null) {
                            try {
                                r0 = this.f16528a.f16542h.a();
                            } catch (RemoteException e6) {
                                c.d("FeedbackRecordActivity", "FeedbackConstData.SINGLE_TASK RemoteException");
                            }
                        }
                        if (r0 != null) {
                            Object obj;
                            for (LogUpload logUpload22 : r0) {
                                if (logUpload22.i() == logUpload.i()) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                return;
                            }
                            if (FeedbackRecordActivity.f16534s.equals(logUpload.C())) {
                                logUpload.c("2");
                                try {
                                    c.a("FeedbackRecordActivity", "updateStatus flag:" + this.f16528a.f16542h.a(logUpload));
                                    for (C4410d c4410d3 : this.f16528a.f16540f) {
                                        if (!TextUtils.isEmpty(c4410d3.m21212i()) && logUpload.i() == Long.parseLong(c4410d3.m21212i())) {
                                            c4410d3.m21193b(2);
                                            j = logUpload.j();
                                            action = logUpload.v();
                                            if (TextUtils.isEmpty(action)) {
                                                action = "0";
                                            } else {
                                                split = action.split(",");
                                                if (split.length >= 2 && !TextUtils.isEmpty(split[1])) {
                                                    action = split[1].substring(0, split[1].length() - 1);
                                                }
                                            }
                                            try {
                                                parseInt = Integer.parseInt(action);
                                                if (j > 0) {
                                                    parseInt = (int) ((((float) parseInt) / ((float) j)) * 100.0f);
                                                    c4410d3.m21197c(String.format(Locale.getDefault(), this.f16528a.getResources().getString(d.b(this.f16528a, "feedback_advanced_loguploading")), new Object[]{parseInt + "%"}));
                                                }
                                            } catch (NumberFormatException e7) {
                                                c.a("FeedbackRecordActivity", "FeedbackConstData.SINGLE_TASK NumberFormatException");
                                            }
                                            c4410d3.m21200d(logUpload.c());
                                            f.c(c4410d3);
                                        }
                                    }
                                    Collections.sort(this.f16528a.f16540f, new C4446c());
                                } catch (IllegalArgumentException e8) {
                                    c.d("FeedbackRecordActivity", "Arrays sort IllegalArgumentException");
                                } catch (RemoteException e9) {
                                    c.d("FeedbackRecordActivity", "FeedbackConstData.SINGLE_TASK RemoteException e");
                                }
                            }
                        } else {
                            return;
                        }
                    }
                } else if ("com.example.logupload.progressSmall".equals(action) && logUpload != null && FeedbackRecordActivity.f16534s.equals(logUpload.C())) {
                    for (C4410d c4410d32 : this.f16528a.f16540f) {
                        if (!TextUtils.isEmpty(c4410d32.m21212i()) && logUpload.i() == Long.parseLong(c4410d32.m21212i())) {
                            c4410d32.m21193b(3);
                            try {
                                Collections.sort(this.f16528a.f16540f, new C4446c());
                                break;
                            } catch (IllegalArgumentException e10) {
                                c.d("FeedbackRecordActivity", "Arrays sort IllegalArgumentException");
                            }
                        }
                    }
                }
                if (this.f16528a.f16548n != null) {
                    this.f16528a.f16548n.notifyDataSetChanged();
                }
                if (this.f16528a.m21443m() > 0 && this.f16528a.f16555v != null && this.f16528a.f16555v.getItem(0) != null && !this.f16528a.f16555v.hasVisibleItems()) {
                    this.f16528a.f16555v.setGroupEnabled(0, true);
                    this.f16528a.f16555v.setGroupVisible(0, true);
                }
            }
        }
    }

    public class ProgressStartReceiver extends BroadcastReceiver {
        final /* synthetic */ FeedbackRecordActivity f16529a;

        public ProgressStartReceiver(FeedbackRecordActivity feedbackRecordActivity) {
            this.f16529a = feedbackRecordActivity;
        }

        public void onReceive(Context context, Intent intent) {
            long j = -1;
            if (intent != null) {
                if ("com.example.logupload.progress.start".equals(intent.getAction())) {
                    c.a("FeedbackRecordActivity", "ProgressStartReceiver onReceive");
                    long longExtra;
                    try {
                        longExtra = intent.getLongExtra("strID", -1);
                    } catch (Exception e) {
                        c.b("FeedbackRecordActivity", "strId get exception" + e.getMessage());
                        longExtra = j;
                    }
                    for (C4410d c4410d : this.f16529a.f16540f) {
                        if (!TextUtils.isEmpty(c4410d.m21212i()) && r2 == Long.parseLong(c4410d.m21212i())) {
                            c4410d.m21200d("0");
                            if (c4410d.m21214j() != 3) {
                                c4410d.m21193b(5);
                            }
                        }
                    }
                    if (this.f16529a.f16548n != null) {
                        this.f16529a.f16548n.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                c.a("FeedbackRecordActivity", "ProgressStartReceiver mLogUploadInfo == null");
            }
        }
    }

    class C4444a implements OnClickListener {
        final /* synthetic */ FeedbackRecordActivity f16530a;

        private C4444a(FeedbackRecordActivity feedbackRecordActivity) {
            this.f16530a = feedbackRecordActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (-1 == i) {
                this.f16530a.m21436i();
            }
        }
    }

    class C4445b extends BaseAdapter {
        final /* synthetic */ FeedbackRecordActivity f16531a;
        private LayoutInflater f16532b;
        private Context f16533c;

        public C4445b(FeedbackRecordActivity feedbackRecordActivity, Context context) {
            this.f16531a = feedbackRecordActivity;
            this.f16533c = context;
            this.f16532b = LayoutInflater.from(context);
        }

        public int getCount() {
            return this.f16531a.f16540f.size();
        }

        public Object getItem(int i) {
            return this.f16531a.f16540f.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = this.f16532b.inflate(d.c(this.f16531a, "feedback_newfeedback_upload_item"), null);
            if (this.f16531a.f16540f != null && this.f16531a.f16540f.size() > i) {
                CharSequence m;
                String p = ((C4410d) this.f16531a.f16540f.get(i)).m21226p();
                TextView textView = (TextView) inflate.findViewById(d.a(this.f16531a, "feedbackQuestion"));
                TextView textView2 = (TextView) inflate.findViewById(d.a(this.f16531a, "detail_progress"));
                textView2.setVisibility(8);
                if (((C4410d) this.f16531a.f16540f.get(i)).m21224o() == 3) {
                    textView.setText(this.f16531a.m21450a(p));
                } else if (p != null) {
                    textView.setText(p);
                }
                textView = (TextView) inflate.findViewById(d.a(this.f16531a, "feedbackType"));
                if (this.f16531a.f16540f.get(i) != null) {
                    m = ((C4410d) this.f16531a.f16540f.get(i)).m21220m();
                    if (TextUtils.isEmpty(m) || m.trim().matches(HwAccountConstants.DIGITAL_REGX)) {
                        textView.setText(this.f16531a.getResources().getString(d.b(FeedbackApi.getApplicationcontext(), "feedback_cloud_service")));
                    } else {
                        textView.setText(m);
                    }
                }
                int s = ((C4410d) this.f16531a.f16540f.get(i)).m21230s();
                TextView textView3;
                if (s > 0) {
                    textView3 = (TextView) inflate.findViewById(d.a(this.f16533c, "feedbackReply"));
                    textView.setTextColor(this.f16531a.getResources().getColor(d.d(this.f16533c, "feedback_question_type_color")));
                    textView3.setText("(" + s + ")");
                    textView3.setTextColor(this.f16531a.getResources().getColor(d.d(this.f16533c, "feedback_question_type_color")));
                } else {
                    textView3 = (TextView) inflate.findViewById(d.a(this.f16533c, "feedbackReply"));
                    textView.setTextColor(this.f16531a.getResources().getColor(d.d(this.f16533c, "feedback_text_color1")));
                    textView3.setVisibility(8);
                }
                m = ((C4410d) this.f16531a.f16540f.get(i)).m21222n();
                textView = (TextView) inflate.findViewById(d.a(this.f16533c, "feedbackTime"));
                if (m != null) {
                    textView.setText(m);
                }
                int j = ((C4410d) this.f16531a.f16540f.get(i)).m21214j();
                textView = (TextView) inflate.findViewById(d.a(this.f16531a, "tv_uploadfeedback_type"));
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(d.a(this.f16531a, "feedbackRelativeLayout"));
                if (i == 0) {
                    relativeLayout.setVisibility(0);
                    if (j == 3 || j == 0) {
                        textView.setText(this.f16531a.getString(d.b(this.f16531a, "feedback_records")));
                        if (!(this.f16531a.f16555v == null || this.f16531a.f16555v.getItem(0) == null || this.f16531a.f16555v.hasVisibleItems())) {
                            this.f16531a.f16555v.setGroupEnabled(0, true);
                            this.f16531a.f16555v.setGroupVisible(0, true);
                        }
                    } else {
                        textView.setText(this.f16531a.getString(d.b(this.f16531a, "feedback_advanced_logupload_task_title")));
                    }
                } else {
                    s = ((C4410d) this.f16531a.f16540f.get(i - 1)).m21214j();
                    if (((s == 3 || s == 0) && (j == 3 || j == 0)) || ((s == 1 || s == 2 || s == 5) && (j == 1 || j == 2 || j == 5))) {
                        relativeLayout.setVisibility(8);
                    } else {
                        relativeLayout.setVisibility(0);
                        if (j == 3 || j == 0) {
                            textView.setText(this.f16531a.getString(d.b(this.f16531a, "feedback_records")));
                            if (!(this.f16531a.f16555v == null || this.f16531a.f16555v.getItem(0) == null || this.f16531a.f16555v.hasVisibleItems())) {
                                this.f16531a.f16555v.setGroupEnabled(0, true);
                                this.f16531a.f16555v.setGroupVisible(0, true);
                            }
                        } else {
                            textView.setText(this.f16531a.getString(d.b(this.f16531a, "feedback_advanced_logupload_task_title")));
                        }
                    }
                }
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.a(this.f16531a, "feedbackItem_plus"));
                Button button = (Button) inflate.findViewById(d.a(this.f16531a, "btn_upload_retransmit"));
                TextView textView4 = (TextView) inflate.findViewById(d.a(this.f16531a, "tv_uploadprogress"));
                button.setOnClickListener(new ad(this, i));
                if (j == 1) {
                    linearLayout.setVisibility(0);
                    button.setVisibility(0);
                    textView4.setVisibility(4);
                } else if (j == 2) {
                    linearLayout.setVisibility(0);
                    button.setVisibility(0);
                    textView4.setVisibility(0);
                    textView4.setText(this.f16531a.getString(d.b(this.f16531a, "feedback_advanced_logupload_fail")));
                } else if (j == 3 || j == 0) {
                    linearLayout.setVisibility(8);
                    textView2.setVisibility(0);
                    int a = ((C4410d) this.f16531a.f16540f.get(i)).m21187a();
                    String string = this.f16531a.getString(d.b(this.f16531a, "feedback_handle_progress"));
                    p = "";
                    if (a == 0) {
                        textView2.setText(String.format(Locale.getDefault(), string, new Object[]{this.f16531a.getString(d.b(this.f16531a, "feedback_submitted"))}));
                    } else if (a == 1) {
                        textView2.setText(String.format(Locale.getDefault(), string, new Object[]{this.f16531a.getString(d.b(this.f16531a, "feedback_tobe_evaluated"))}));
                    } else if (a == 2) {
                        textView2.setText(String.format(Locale.getDefault(), string, new Object[]{this.f16531a.getString(d.b(this.f16531a, "feedback_has_evaluated"))}));
                    }
                } else if (j == 5) {
                    String str;
                    linearLayout.setVisibility(0);
                    textView4.setVisibility(0);
                    String g = ((C4410d) this.f16531a.f16540f.get(i)).m21208g();
                    if (g == null) {
                        str = "";
                    } else {
                        str = g;
                    }
                    CharSequence f = ((C4410d) this.f16531a.f16540f.get(i)).m21205f();
                    if (str.equals("1") || str.equals("") || str.equals("0")) {
                        button.setVisibility(8);
                        if (f == null) {
                            textView4.setText(String.format(Locale.getDefault(), this.f16531a.getResources().getString(d.b(this.f16531a, "feedback_advanced_loguploading")), new Object[]{"0%"}));
                        } else if ("".equals(f)) {
                            textView4.setText(String.format(Locale.getDefault(), this.f16531a.getResources().getString(d.b(this.f16531a, "feedback_advanced_loguploading")), new Object[]{"0%"}));
                        } else {
                            textView4.setText(f);
                        }
                    } else if (str.equals("2")) {
                        button.setVisibility(0);
                        textView4.setText(this.f16531a.getString(d.b(this.f16531a, "feedback_advanced_logupload_fail")));
                    }
                }
            }
            return inflate;
        }

        public void m21412a(String str) {
            if (this.f16531a.f16540f != null) {
                for (int i = 0; i < this.f16531a.f16540f.size(); i++) {
                    if (((C4410d) this.f16531a.f16540f.get(i)).m21229r().equals(str)) {
                        this.f16531a.f16540f.remove(i);
                    }
                }
                notifyDataSetChanged();
            }
        }
    }

    public class C4446c implements Serializable, Comparator<Object> {
        public int compare(Object obj, Object obj2) {
            C4410d c4410d = (C4410d) obj;
            C4410d c4410d2 = (C4410d) obj2;
            if ((c4410d.m21214j() == 3 || c4410d.m21214j() == 0) && (c4410d2.m21214j() != 3 || c4410d2.m21214j() != 0)) {
                return 1;
            }
            if ((c4410d.m21214j() != 3 || c4410d.m21214j() != 0) && (c4410d2.m21214j() == 3 || c4410d2.m21214j() == 0)) {
                return -1;
            }
            if (((c4410d.m21214j() != 3 && c4410d.m21214j() != 0) || (c4410d2.m21214j() != 3 && c4410d2.m21214j() != 0)) && c4410d.m21214j() == 3 && ((c4410d.m21214j() == 0 || c4410d2.m21214j() == 3) && c4410d2.m21214j() == 0)) {
                return 0;
            }
            String n = c4410d.m21222n();
            String n2 = c4410d2.m21222n();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/M/d HH:mm", Locale.US);
            try {
                Date parse = simpleDateFormat.parse(n);
                Date parse2 = simpleDateFormat.parse(n2);
                if (parse.getTime() > parse2.getTime()) {
                    return -1;
                }
                if (parse.getTime() < parse2.getTime()) {
                    return 1;
                }
                if (parse.getTime() == parse2.getTime()) {
                    return 0;
                }
                return 0;
            } catch (ParseException e) {
                c.d("FeedbackRecordActivity", "ParseException");
            }
        }
    }

    private static void m21421b(String str) {
        f16534s = str;
    }

    private void m21424c(String str) {
        m21421b(str);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (FeedbackApi.getApplicationcontext() == null) {
            c.d("FeedbackRecordActivity", "FeedbackApi.getApplicationcontext() null!");
            finish();
            return;
        }
        m21426d();
        setContentView(d.c(this, "feedback_result"));
        this.f16537c = (LinearLayout) findViewById(d.a(this, "feedback_No_result_prompt"));
        this.f16538d = (LinearLayout) findViewById(d.a(this, "feedback_No_result_prompt_land"));
        this.f16539e = (ListView) findViewById(d.a(this, "feedback_list"));
        registerForContextMenu(this.f16539e);
        this.f16542h = ProgressService.a();
        this.f16552r = (RelativeLayout) findViewById(d.a(this, "feedback_loading"));
        if (TextUtils.isEmpty(getPackageName())) {
            c.d("FeedbackRecordActivity", "getPackageName() null");
        } else {
            m21424c(getPackageName());
            c.d("FeedbackRecordActivity", "packagename" + f16534s);
        }
        if (com.huawei.phoneserviceuni.common.d.a.a(this)) {
            this.f16552r.setVisibility(0);
            new Thread(new C4423n(this, this.f16553t)).start();
            return;
        }
        this.f16553t.sendEmptyMessageDelayed(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION, 200);
    }

    private void m21426d() {
        this.f16536b = getActionBar();
        if (this.f16536b != null) {
            this.f16536b.setDisplayShowCustomEnabled(true);
            this.f16536b.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void m21427e() {
        this.f16549o = new C4477z(this);
        this.f16550p = new IntentFilter("UpdateRecordListBroadcast");
        C2852a.m12942a((Context) this).m12946a(this.f16549o, this.f16550p);
    }

    private void m21429f() {
        if (this.f16540f == null || this.f16540f.size() <= 0) {
            m21442l();
            this.f16539e.setVisibility(8);
            if (this.f16555v != null && this.f16555v.getItem(0) != null) {
                this.f16555v.setGroupEnabled(0, false);
                this.f16555v.setGroupVisible(0, false);
                return;
            }
            return;
        }
        this.f16537c.setVisibility(8);
        this.f16538d.setVisibility(8);
        this.f16539e.setVisibility(0);
        int m = m21443m();
        if (!(this.f16555v == null || this.f16555v.getItem(0) == null)) {
            if (m <= 0) {
                this.f16555v.setGroupEnabled(0, false);
                this.f16555v.setGroupVisible(0, false);
            } else if (!this.f16555v.hasVisibleItems()) {
                this.f16555v.setGroupEnabled(0, true);
                this.f16555v.setGroupVisible(0, true);
            }
        }
        this.f16548n = new C4445b(this, this);
        if (com.huawei.phoneserviceuni.common.d.a.m()) {
            this.f16539e.addFooterView(LayoutInflater.from(this).inflate(d.c(this, "feedback_blank_foot_with_toolbar_emui50"), this.f16539e, false), null, false);
        }
        this.f16539e.setFooterDividersEnabled(false);
        this.f16539e.setAdapter(this.f16548n);
        this.f16539e.setOnItemClickListener(this.f16554u);
        this.f16539e.setOnItemLongClickListener(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f16551q) {
            unregisterReceiver(this.f16543i);
            unregisterReceiver(this.f16544j);
            unregisterReceiver(this.f16545k);
            unregisterReceiver(this.f16546l);
            C2852a.m12942a((Context) this).m12945a(this.f16549o);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (com.huawei.phoneserviceuni.common.d.a.h()) {
            getMenuInflater().inflate(d.g(this, "feedback_record_more"), menu);
            if (!com.huawei.phoneserviceuni.common.d.a.m()) {
                menu.getItem(0).setIcon(d.e(this, "feedback_menu_more_btn_selectorlow"));
            }
            menu.setGroupEnabled(0, false);
            menu.setGroupVisible(0, false);
        } else {
            menu.add(0, d.a(this, "menu_more"), 0, d.b(this, "feedback_record_delete")).setIcon(d.e(this, "feedback_ab_ic_menu")).setShowAsAction(2);
        }
        this.f16555v = menu;
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (d.a(this, "menu_more") == menuItem.getItemId()) {
            m21451b();
            return true;
        } else if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            finish();
            return true;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
            return super.onKeyUp(i, keyEvent);
        }
        m21451b();
        return true;
    }

    public void m21451b() {
        m21434h();
    }

    private void m21431g() {
        this.f16540f = f.a();
        if (this.f16542h != null) {
            try {
                this.f16541g = this.f16542h.a();
                for (LogUpload logUpload : this.f16541g) {
                    Intent intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.putExtra("mLogUploadInfo", logUpload);
                    intent.putExtra("extraValue", "1");
                    FeedbackApi.getApplicationcontext().sendBroadcast(intent);
                }
            } catch (RemoteException e) {
                c.d("FeedbackRecordActivity", "RemoteException: " + e.getMessage());
            }
        }
        m21437j();
        try {
            Collections.sort(this.f16540f, new C4446c());
        } catch (IllegalArgumentException e2) {
            c.d("FeedbackRecordActivity", "Arrays sort IllegalArgumentException");
        }
    }

    private void m21434h() {
        if (this.f16540f != null && this.f16540f.size() != 0) {
            Builder builder = new Builder(this);
            builder.setTitle(d.b(this, "feedback_bitchdelete_dialog_title"));
            builder.setMessage(d.b(this, "feedback_bitchdelete_dialog"));
            builder.setPositiveButton(d.b(this, "feedback_ok"), new C4444a());
            builder.setNegativeButton(d.b(this, "feedback_cancel"), new C4444a());
            builder.create().show();
        }
    }

    private void m21436i() {
        if (this.f16540f != null) {
            f.b();
            if (this.f16548n != null) {
                List<C4410d> arrayList = new ArrayList();
                arrayList.addAll(this.f16540f);
                for (C4410d c4410d : arrayList) {
                    if (c4410d.m21214j() == 3 || c4410d.m21214j() == 0) {
                        this.f16540f.remove(c4410d);
                    }
                }
                this.f16548n.notifyDataSetChanged();
                arrayList.clear();
            }
            if (this.f16540f.size() == 0) {
                m21442l();
                this.f16539e.setVisibility(8);
                if (this.f16555v != null && this.f16555v.getItem(0) != null) {
                    this.f16555v.setGroupEnabled(0, false);
                    this.f16555v.setGroupVisible(0, false);
                    return;
                }
                return;
            }
            int m = m21443m();
            if (this.f16555v != null && this.f16555v.getItem(0) != null) {
                if (m <= 0) {
                    this.f16555v.setGroupEnabled(0, false);
                    this.f16555v.setGroupVisible(0, false);
                } else if (!this.f16555v.hasVisibleItems()) {
                    this.f16555v.setGroupEnabled(0, true);
                    this.f16555v.setGroupVisible(0, true);
                }
            }
        }
    }

    private void m21414a(int i) {
        if (this.f16540f != null && this.f16540f.size() > i) {
            C4410d c4410d = (C4410d) this.f16540f.get(i);
            if (c4410d != null && c4410d.m21214j() != 1) {
                Intent intent = new Intent();
                intent.setClass(this, FeedbackDetailActivity.class);
                intent.putExtra("pQuestionId", c4410d.m21229r());
                startActivityForResult(intent, 10);
            }
        }
    }

    private void m21437j() {
        for (C4410d c4410d : this.f16540f) {
            if (!TextUtils.isEmpty(c4410d.m21212i())) {
                long parseLong = Long.parseLong(c4410d.m21212i());
                Object obj = null;
                for (LogUpload logUpload : this.f16541g) {
                    Object obj2;
                    if (logUpload.i() == parseLong) {
                        String v = logUpload.v();
                        long j = logUpload.j();
                        if (TextUtils.isEmpty(v)) {
                            v = "0";
                        } else {
                            String[] split = v.split(",");
                            if (split.length >= 2 && !TextUtils.isEmpty(split[1])) {
                                v = split[1].substring(0, split[1].length() - 1);
                            }
                        }
                        try {
                            int parseInt = Integer.parseInt(v);
                            if (j > 0) {
                                parseInt = (int) ((((float) parseInt) / ((float) j)) * 100.0f);
                                c4410d.m21197c(String.format(Locale.getDefault(), getResources().getString(d.b(this, "feedback_advanced_loguploading")), new Object[]{parseInt + "%"}));
                            }
                        } catch (NumberFormatException e) {
                            c.a("FeedbackRecordActivity", "NumberFormatException");
                        }
                        c4410d.m21200d(logUpload.c());
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
                if (obj == null) {
                    c.a("FeedbackRecordActivity", "!isFindNoRecord");
                    if (2 == c4410d.m21214j()) {
                        f.a(String.valueOf(parseLong), 3);
                        c4410d.m21193b(3);
                        if (TextUtils.isEmpty(c4410d.m21210h())) {
                            c.a("FeedbackRecordActivity", "file path is empty or null: feedbackInfo.getFilePath()):" + c4410d.m21210h());
                        } else {
                            File file = new File(c4410d.m21210h());
                            if (file.exists() && file.delete()) {
                                c.a("FeedbackRecordActivity", "file delete sccess!");
                            } else {
                                c.a("FeedbackRecordActivity", "file not exist or error! file delete fail!");
                            }
                        }
                    }
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        c.a("resultCode", Integer.toString(i2));
        if (i2 == 101 && intent != null) {
            String stringExtra = intent.getStringExtra("deleted_id");
            if (this.f16548n != null) {
                this.f16548n.m21412a(stringExtra);
            }
            if (this.f16540f != null && this.f16540f.size() == 0) {
                m21442l();
                this.f16539e.setVisibility(8);
                if (!(this.f16555v == null || this.f16555v.getItem(0) == null)) {
                    this.f16555v.setGroupEnabled(0, false);
                    this.f16555v.setGroupVisible(0, false);
                }
            }
        }
        if (i2 == 102 && intent != null) {
            m21431g();
            if (this.f16548n != null) {
                this.f16548n.notifyDataSetChanged();
            }
        }
    }

    private Builder m21419b(int i) {
        View inflate = LayoutInflater.from(this).inflate(i, null);
        Builder builder = new Builder(this);
        builder.setView(inflate);
        return builder;
    }

    private void m21440k() {
        Builder b;
        if (com.huawei.phoneserviceuni.common.d.a.f()) {
            b = m21419b(d.c(this, "feedback_dialog_feedbackrecord_new"));
        } else {
            b = m21419b(d.c(this, "feedback_dialog_feedbackrecord"));
        }
        b.setPositiveButton(getResources().getString(d.b(this, "feedback_record_delete")), new ac(this)).setNegativeButton(d.b(this, "feedback_cancel"), new ab(this));
        this.f16547m = b.create();
        this.f16547m.show();
        this.f16547m.setCanceledOnTouchOutside(false);
    }

    public CharSequence m21450a(String str) {
        String string = getString(d.b(this, "feedbackRecord_draft"));
        CharSequence spannableString = new SpannableString(string + str);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.d(this, "feedback_blue"))), 0, string.length() + 0, 34);
        return spannableString;
    }

    protected void onPause() {
        super.onPause();
        d.i(this, "onPause");
        d.i(this, "onReport");
    }

    protected void onResume() {
        super.onResume();
        d.i(this, "onResume");
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f16556w = i;
        C4410d c4410d = (C4410d) this.f16540f.get(this.f16556w);
        if (c4410d.m21214j() == 3 || c4410d.m21214j() == 0) {
            return false;
        }
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f16537c.getVisibility() == 0 || this.f16538d.getVisibility() == 0) {
            m21442l();
        }
    }

    private void m21442l() {
        if (getResources().getConfiguration().orientation == 2) {
            this.f16537c.setVisibility(8);
            this.f16538d.setVisibility(0);
            return;
        }
        this.f16537c.setVisibility(0);
        this.f16538d.setVisibility(8);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getMenuInflater().inflate(d.g(this, "feedback_record_itemlongclick"), contextMenu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == d.a(this, "item_longclick_delete")) {
            m21440k();
        }
        return true;
    }

    private void m21417a(List<C4410d> list) {
        for (C4410d c4410d : list) {
            if (c4410d != null) {
                C4410d a = f.a(c4410d.m21218l());
                if (a != null) {
                    if (f.d(c4410d.m21218l()) != null) {
                        c.b("FeedbackRecordActivity", "already has reply,do not save answer");
                    } else {
                        try {
                            c4410d.m21215j(new SimpleDateFormat("yyyy/M/d HH:mm", Locale.US).format(new Date()));
                        } catch (IllegalArgumentException e) {
                            c.d("FeedbackRecordActivity", "get date IllegalArgumentException");
                        } catch (Exception e2) {
                            c.d("FeedbackRecordActivity", "get date Exception");
                        }
                        c4410d.m21221m(a.m21229r());
                        c4410d.m21196c(2);
                        if (a.m21220m() != null) {
                            c4410d.m21213i(a.m21220m());
                        }
                        c4410d.m21225o(a.m21233v());
                        c4410d.m21227p(a.m21234w());
                        f.a(c4410d);
                    }
                }
            }
        }
        this.f16553t.sendEmptyMessage(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION);
    }

    private int m21443m() {
        if (this.f16540f == null || this.f16540f.size() == 0) {
            return 0;
        }
        int i = 0;
        for (C4410d c4410d : this.f16540f) {
            int i2;
            if (c4410d.m21214j() == 3 || c4410d.m21214j() == 0) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }
}
