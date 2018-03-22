package com.huawei.ui.main.stories.nps.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSureyResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyChooseResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.Records;
import com.huawei.ui.main.stories.nps.interactors.p184b.C2443a;
import com.huawei.ui.main.stories.nps.views.C2457a;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"ValidFragment"})
/* compiled from: SingleFragment */
public class C2438m extends Fragment {
    private String f8770a = "SingleFragment";
    private QstnSureyResponse f8771b;
    private List<QstnSurveyChooseResponse> f8772c;
    private ListView f8773d;
    private TextView f8774e;
    private int f8775f;
    private Handler f8776g = new C2439n(this);
    private C2457a f8777h;
    private String[] f8778i;
    private HashMap<String, Boolean> f8779j = new HashMap();

    @SuppressLint({"ValidFragment"})
    public C2438m(QstnSureyResponse qstnSureyResponse, int i) {
        this.f8771b = qstnSureyResponse;
        this.f8775f = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.fragment_nps_question_single, viewGroup, false);
        this.f8772c = this.f8771b.getChoose();
        this.f8773d = (ListView) d.a(inflate, f.single_listview);
        this.f8779j.clear();
        if (this.f8772c != null) {
            this.f8778i = new String[this.f8772c.size()];
            for (int i = 0; i < this.f8772c.size(); i++) {
                if (((QstnSurveyChooseResponse) this.f8772c.get(i)).getRemark() != null) {
                    this.f8778i[i] = ((QstnSurveyChooseResponse) this.f8772c.get(i)).getName() + "(" + ((QstnSurveyChooseResponse) this.f8772c.get(i)).getRemark() + ")";
                } else {
                    this.f8778i[i] = ((QstnSurveyChooseResponse) this.f8772c.get(i)).getName();
                }
                if (i == 0) {
                    this.f8779j.put(i + "", Boolean.valueOf(true));
                } else {
                    this.f8779j.put(i + "", Boolean.valueOf(false));
                }
            }
        }
        this.f8777h = new C2457a(getContext(), this.f8778i, this.f8779j, this.f8776g);
        this.f8773d.setAdapter(this.f8777h);
        this.f8773d.setChoiceMode(1);
        this.f8773d.setOnItemClickListener(new C2440o(this));
        this.f8774e = (TextView) d.a(inflate, f.single_title);
        this.f8774e.setText(this.f8775f + "." + this.f8771b.getQuestion() + C2443a.m12274a(this.f8771b.getQuestionType()));
        this.f8773d.setItemChecked(0, true);
        m12222a();
        return inflate;
    }

    public void m12222a() {
        C2538c.m12677c(this.f8770a, "==========Enter saveData");
        int checkedItemPosition = this.f8773d.getCheckedItemPosition();
        if (this.f8772c == null || this.f8772c.size() < checkedItemPosition - 1) {
            C2538c.m12677c(this.f8770a, "==========saveData  error1 !!!");
        } else if (this.f8771b == null) {
            C2538c.m12677c(this.f8770a, "==========saveData  error2 !!!");
        } else {
            Records.getOptionResult().put(this.f8771b.getId(), ((QstnSurveyChooseResponse) this.f8772c.get(checkedItemPosition)).getName());
            C2538c.m12677c(this.f8770a, "finish single successful getOptionResult:" + Records.getOptionResult());
        }
    }
}
