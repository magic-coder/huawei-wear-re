package com.huawei.ui.main.stories.nps.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSureyResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.Records;
import com.huawei.ui.main.stories.nps.interactors.p184b.C2443a;

@SuppressLint({"ValidFragment"})
/* compiled from: FiledFragment */
public class C2427b extends Fragment {
    private String f8751a = "FiledFragment";
    private TextView f8752b;
    private QstnSureyResponse f8753c;
    private EditText f8754d;
    private String f8755e;
    private Integer f8756f;
    private int f8757g;
    private TextWatcher f8758h = new C2428c(this);

    @SuppressLint({"ValidFragment"})
    public C2427b(QstnSureyResponse qstnSureyResponse, int i) {
        this.f8753c = qstnSureyResponse;
        this.f8757g = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.fragment_nps_question_filed, viewGroup, false);
        this.f8752b = (TextView) d.a(inflate, f.field_title);
        this.f8754d = (EditText) d.a(inflate, f.field_content_et);
        this.f8754d.addTextChangedListener(this.f8758h);
        this.f8752b.setText(this.f8757g + "." + this.f8753c.getQuestion() + C2443a.m12274a(this.f8753c.getQuestionType()));
        this.f8756f = this.f8753c.getId();
        this.f8755e = (String) Records.getStringDataCenter().get(this.f8756f);
        Records.getStringDataCenter().put(this.f8756f, "");
        return inflate;
    }
}
