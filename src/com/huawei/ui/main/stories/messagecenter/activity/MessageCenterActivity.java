package com.huawei.ui.main.stories.messagecenter.activity;

import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.a.g;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.f;
import com.huawei.ui.commonui.dialog.h;
import com.huawei.ui.main.j;
import com.huawei.ui.main.stories.messagecenter.interactors.C2422e;
import com.huawei.ui.main.stories.messagecenter.interactors.C2423f;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

public class MessageCenterActivity extends BaseActivity implements MessageObserver {
    private ListView f8683a;
    private RelativeLayout f8684b;
    private C2423f f8685c;
    private List<MessageObject> f8686d = new ArrayList();
    private boolean f8687e = false;
    private C2417f f8688f = null;
    private f f8689g = null;
    private Runnable f8690h = new C2414c(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.c("MessageCenterActivity", "Enter onCreate!");
        if (this.f8686d != null) {
            this.f8686d.clear();
        }
        setContentView(com.huawei.ui.main.g.activity_message_center_list);
        this.f8683a = (ListView) findViewById(com.huawei.ui.main.f.items_listView1);
        this.f8688f = new C2417f(this);
        C1971j.m10236a(BaseApplication.m2632b()).m10245a((MessageObserver) this);
        this.f8684b = (RelativeLayout) findViewById(com.huawei.ui.main.f.messageCenter_layout_no_message);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        LayoutParams layoutParams = (LayoutParams) this.f8684b.getLayoutParams();
        layoutParams.topMargin = ((int) (((float) displayMetrics.heightPixels) * NFCBaseActivity.PERCENT_MARGIN_30)) - ((int) ((getResources().getDisplayMetrics().density * 50.0f) + 0.5f));
        this.f8684b.setLayoutParams(layoutParams);
        this.f8683a.setOnItemClickListener(new C2412a(this));
        this.f8687e = false;
        this.f8685c = new C2423f(this, new ArrayList());
        this.f8683a.setAdapter(this.f8685c);
        m12139a();
        new Thread(this.f8690h).start();
        if (this.f8688f != null) {
            this.f8688f.sendEmptyMessageDelayed(2, FileWatchdog.DEFAULT_DELAY);
        }
        g.c("MessageCenterActivity", "Leave onCreate!");
    }

    private void m12139a() {
        if (this.f8689g == null) {
            this.f8689g = new h(this, Boolean.valueOf(true)).a().a(false).b();
            this.f8689g.a(j.IDS_getting_file);
        }
        this.f8689g.show();
    }

    private void m12144b() {
        if (this.f8689g != null) {
            this.f8689g.dismiss();
            this.f8689g = null;
        }
        if (this.f8688f != null) {
            this.f8688f.removeMessages(2);
        }
    }

    private void m12148c() {
        g.c("MessageCenterActivity", "Start messageCenterRunnable!");
        C1971j.m10236a(BaseApplication.m2632b()).m10242a(new C2413b(this));
    }

    private void m12140a(Message message) {
        List list = (List) message.obj;
        m12147b(list);
        this.f8686d = list;
        g.c("MessageCenterActivity", "messageCenterHandler REFRESH_MESSAGE showMessageCenterList mMessageList = " + this.f8686d);
        m12143a(this.f8686d);
        m12144b();
        C1971j.m10236a(BaseApplication.m2632b()).m10241a();
    }

    private void m12151d() {
        this.f8683a.setVisibility(8);
        this.f8684b.setVisibility(0);
    }

    private void m12143a(List<MessageObject> list) {
        this.f8683a.setVisibility(0);
        this.f8684b.setVisibility(8);
        this.f8685c.m12176a(list);
        this.f8685c.notifyDataSetChanged();
    }

    public void onChange(int i, MessageChangeEvent messageChangeEvent) {
        g.c("MessageCenterActivity", "Enter onChange() flag: " + i);
        if (i == 0) {
            C1971j.m10236a(BaseApplication.m2632b()).m10242a(new C2415d(this, i));
        } else if (this.f8686d != null && this.f8686d.size() <= 0) {
            this.f8688f.sendEmptyMessage(1);
        }
    }

    private void m12147b(List<MessageObject> list) {
        if (!list.isEmpty()) {
            for (MessageObject a : list) {
                m12141a(a);
            }
        }
    }

    private void m12141a(MessageObject messageObject) {
        new C2422e(this, messageObject).m12173a();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (this.f8687e) {
            C1971j.m10236a(BaseApplication.m2632b()).m10241a();
        }
    }

    protected void onPause() {
        super.onPause();
        this.f8687e = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        C1971j.m10236a(BaseApplication.m2632b()).m10251b((MessageObserver) this);
        C0977d.m3575n(BaseApplication.m2632b());
    }
}
