package com.huawei.ui.main.stories.nps.interactors;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.activity.QuestionMainActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: HWNPSManager */
class C2452h implements OnClickListener {
    final /* synthetic */ C2442a f8818a;

    C2452h(C2442a c2442a) {
        this.f8818a = c2442a;
    }

    public void onClick(View view) {
        C2538c.m12677c(this.f8818a.f8785a, "=========nps press PositiveButton");
        Intent intent = new Intent();
        intent.setClassName(this.f8818a.f8786b, QuestionMainActivity.class.getName());
        if (this.f8818a.f8788d != null) {
            this.f8818a.f8788d.id = this.f8818a.f8800q;
        }
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f8818a.f8786b.startActivity(intent);
        C2538c.m12677c(this.f8818a.f8785a, "=========nps press mContext.startActivity");
    }
}
