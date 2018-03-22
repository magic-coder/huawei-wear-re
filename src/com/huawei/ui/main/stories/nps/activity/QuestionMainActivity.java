package com.huawei.ui.main.stories.nps.activity;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcommonmodel.datatypes.j;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.stories.nps.interactors.C2442a;
import com.huawei.ui.main.stories.nps.interactors.db.QstnSurveyTable;
import com.huawei.ui.main.stories.nps.interactors.mode.CommitResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.CreateCommitAnswer;
import com.huawei.ui.main.stories.nps.interactors.mode.CreateQuestionAnswer;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSureyResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyDetailResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.Records;
import com.huawei.ui.main.stories.nps.interactors.mode.TypeParams;
import com.huawei.ui.main.stories.nps.interactors.p183a.C2441a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class QuestionMainActivity extends BaseActivity implements OnClickListener {
    private String f8720a = "QuestionMainActivity";
    private Type f8721b = new C2431f(this).getType();
    private Context f8722c;
    private ViewPager f8723d;
    private PagerAdapter f8724e;
    private Button f8725f;
    private CustomTitleBar f8726g;
    private u f8727h = null;
    private C2427b f8728i;
    private List<QstnSureyResponse> f8729j = new ArrayList();
    private int f8730k = 0;
    private int f8731l = -1;
    private String f8732m;
    private CommitResponse f8733n;
    private Type f8734o = new C2432g(this).getType();
    private UUID f8735p;
    private String f8736q;
    private String f8737r;
    private String f8738s;
    private String f8739t;
    private QstnSurveyTable f8740u;
    private boolean f8741v = false;
    private C2442a f8742w = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_nps_question_main);
        this.f8722c = this;
        this.f8742w = C2442a.m12225a(this.f8722c);
        C2538c.m12674b(this.f8720a, "nps Enter QuestionMainActivity onCreate !");
        if ("".equals(j.a())) {
            C2538c.m12674b(this.f8720a, "nps Enter QuestionMainActivity wearmac is null finish !");
            finish();
            return;
        }
        C2538c.m12674b(this.f8720a, "nps Enter QuestionMainActivity onCreate init!");
        m12188d();
        this.f8723d = (ViewPager) d.a(this, f.pager);
        this.f8724e = new C2437l(this, getSupportFragmentManager());
        this.f8723d.setAdapter(this.f8724e);
        this.f8725f = (Button) d.a(this, f.question_next);
        this.f8725f.setVisibility(0);
        this.f8725f.setOnClickListener(this);
        this.f8726g = (CustomTitleBar) d.a(this, f.question_main_title);
        this.f8738s = Locale.getDefault().getLanguage();
        this.f8735p = UUID.randomUUID();
        this.f8736q = j.b();
        this.f8737r = j.c();
        if (this.f8737r == null || "".equals(this.f8737r)) {
            this.f8737r = "firmware";
        }
        this.f8739t = "Android:" + VERSION.SDK_INT;
        this.f8729j = C2441a.m12223a();
        if (this.f8729j.size() < 1) {
            m12186c();
        }
        if (this.f8729j.size() < 1) {
            C2538c.m12674b(this.f8720a, "nps QuestionMainActivity mQuestions is null finish !");
            finish();
            return;
        }
        this.f8731l = this.f8729j.size() - 1;
        this.f8724e.notifyDataSetChanged();
        m12200a(this.f8730k);
        m12198i();
    }

    private void m12186c() {
        JsonSyntaxException jsonSyntaxException;
        List list;
        if (this.f8742w != null) {
            if (this.f8729j == null) {
                this.f8729j = new ArrayList();
            }
            String e = this.f8742w.m12273e();
            C2538c.m12677c(this.f8720a, "======nps initQuestionsCache getQuestionDetail response:  " + e);
            QstnSurveyDetailResponse qstnSurveyDetailResponse = new QstnSurveyDetailResponse();
            try {
                QstnSurveyDetailResponse qstnSurveyDetailResponse2 = (QstnSurveyDetailResponse) new Gson().fromJson(e, this.f8721b);
                try {
                    C2538c.m12677c(this.f8720a, "======nps initQuestionsCache detailResponse !!!");
                    qstnSurveyDetailResponse = qstnSurveyDetailResponse2;
                } catch (JsonSyntaxException e2) {
                    JsonSyntaxException jsonSyntaxException2 = e2;
                    qstnSurveyDetailResponse = qstnSurveyDetailResponse2;
                    jsonSyntaxException = jsonSyntaxException2;
                    C2538c.m12677c(this.f8720a, "======nps initQuestionsCache json error!!!" + jsonSyntaxException.getMessage());
                    list = null;
                    list = qstnSurveyDetailResponse.getSurveyContent().getQuestions();
                    if (r0 == null) {
                        C2538c.m12674b(this.f8720a, "=========nps initQuestionsCache null == questionList");
                        return;
                    }
                    for (QstnSureyResponse add : r0) {
                        this.f8729j.add(add);
                    }
                }
            } catch (JsonSyntaxException e3) {
                jsonSyntaxException = e3;
                C2538c.m12677c(this.f8720a, "======nps initQuestionsCache json error!!!" + jsonSyntaxException.getMessage());
                list = null;
                list = qstnSurveyDetailResponse.getSurveyContent().getQuestions();
                if (r0 == null) {
                    while (r1.hasNext()) {
                        this.f8729j.add(add);
                    }
                }
                C2538c.m12674b(this.f8720a, "=========nps initQuestionsCache null == questionList");
                return;
            }
            list = null;
            if (!(qstnSurveyDetailResponse == null || qstnSurveyDetailResponse.getSurveyContent() == null)) {
                list = qstnSurveyDetailResponse.getSurveyContent().getQuestions();
            }
            if (r0 == null) {
                C2538c.m12674b(this.f8720a, "=========nps initQuestionsCache null == questionList");
                return;
            }
            while (r1.hasNext()) {
                this.f8729j.add(add);
            }
        }
    }

    private void m12188d() {
        C2538c.m12677c(this.f8720a, "========nps Enter handlerIntent ");
        if (getIntent() != null) {
            this.f8740u = this.f8742w.m12272d();
            if (this.f8740u != null) {
                C2538c.m12677c(this.f8720a, "========nps mQstnSurveyTable:" + this.f8740u.toString());
            }
        }
    }

    public void onClick(View view) {
        if (f.question_next == view.getId()) {
            m12200a(this.f8730k);
        }
    }

    public void m12200a(int i) {
        C2538c.m12677c(this.f8720a, "=======nps Enter changePage  index:" + i);
        this.f8723d.setCurrentItem(i, true);
        String str = "";
        if (i < this.f8731l) {
            str = String.format(getString(com.huawei.ui.main.j.IDS_nps_question_survey_next), new Object[]{Integer.valueOf(i + 1), Integer.valueOf(this.f8729j.size())});
        } else if (i == this.f8731l) {
            str = getString(com.huawei.ui.main.j.IDS_nps_submit);
        } else if (i == this.f8731l + 1) {
            m12199a();
            str = getString(com.huawei.ui.main.j.IDS_nps_submit);
        } else {
            str = getString(com.huawei.ui.main.j.IDS_nps_submit);
            m12199a();
        }
        this.f8725f.setText(str.toUpperCase());
        if (this.f8729j != null && i < this.f8729j.size()) {
            this.f8726g.setTitleText(((QstnSureyResponse) this.f8729j.get(i)).getTitle());
        }
        this.f8730k++;
    }

    public void m12199a() {
        C2538c.m12677c(this.f8720a, "==========nps Enter commitCenterData");
        if (C0977d.m3555e((Context) this)) {
            C2538c.m12677c(this.f8720a, "nps ready commit...");
            m12190e();
            m12191f();
        }
    }

    private void m12190e() {
        C2538c.m12677c(this.f8720a, "==========nps Enter initPostData");
        Integer.valueOf(0);
        Object arrayList = new ArrayList();
        for (int i = 0; i < this.f8729j.size(); i++) {
            CreateQuestionAnswer createQuestionAnswer = new CreateQuestionAnswer();
            QstnSureyResponse qstnSureyResponse = (QstnSureyResponse) this.f8729j.get(i);
            Integer id = qstnSureyResponse.getId();
            String questionType = qstnSureyResponse.getQuestionType();
            createQuestionAnswer.setQuestionId(id);
            createQuestionAnswer.setQuestionType(questionType);
            CreateCommitAnswer createCommitAnswer;
            if (questionType.equals(TypeParams.QUESTION_FIELD)) {
                if (Records.getStringDataCenter().get(id) != null) {
                    createCommitAnswer = new CreateCommitAnswer();
                    createCommitAnswer.setQuestionId(id);
                    questionType = (String) Records.getStringDataCenter().get(id);
                    C2538c.m12677c(this.f8720a, "==========nps answer to commit:" + questionType);
                    createCommitAnswer.setAnswer(questionType);
                    arrayList.add(createCommitAnswer);
                }
            } else if (!questionType.equals(TypeParams.QUESTION_CHOOSE_SINGEL)) {
                C2538c.m12677c(this.f8720a, "==========nps unsupport type");
            } else if (Records.getOptionResult().get(id) != null) {
                createCommitAnswer = new CreateCommitAnswer();
                createCommitAnswer.setQuestionId(id);
                questionType = (String) Records.getOptionResult().get(id);
                C2538c.m12674b(this.f8720a, "==========nps answer to commit:" + questionType);
                createCommitAnswer.setAnswer(questionType);
                arrayList.add(createCommitAnswer);
            }
            createQuestionAnswer.setAnswers(arrayList);
            C2538c.m12674b(this.f8720a, "==========initPostData questionAnswer.questionId = " + createQuestionAnswer.getQuestionId());
        }
        this.f8732m = new Gson().toJson(arrayList);
        C2538c.m12677c(this.f8720a, "nps upload answer core data--->" + this.f8732m);
    }

    private void m12191f() {
        C2538c.m12677c(this.f8720a, "=========nps Enter postData");
        if (this.f8741v) {
            C2538c.m12677c(this.f8720a, "========nps isPosting is true ,return");
            return;
        }
        C2538c.m12677c(this.f8720a, "nps 提交问卷 RUL：osgOvs/submitSurvey.htm");
        this.f8741v = true;
        if (this.f8742w != null) {
            this.f8742w.m12267a(this.f8732m, m12193g(), m12201b());
        }
    }

    private Listener<String> m12193g() {
        return new C2433h(this);
    }

    protected ErrorListener m12201b() {
        return new C2435j(this);
    }

    private void m12196h() {
        C2538c.m12677c(this.f8720a, "==========nps Enter showComitSureDialog");
        if (this.f8727h != null) {
            C2538c.m12677c(this.f8720a, "==========nps commitSuccessDialog is showing, return");
            return;
        }
        this.f8727h = new w(this.f8722c).a(com.huawei.ui.main.j.IDS_nps_success_title).b(com.huawei.ui.main.j.IDS_nps_success_message_1).a(getString(com.huawei.ui.main.j.IDS_settings_button_nps_ok).toUpperCase(), new C2436k(this)).a();
        this.f8727h.setCanceledOnTouchOutside(false);
        if (!isFinishing()) {
            this.f8727h.show();
        }
    }

    private void m12198i() {
        C2538c.m12677c(this.f8720a, "==========nps Enter updateQstnSurveyTable");
        if (this.f8740u != null) {
            this.f8740u.setLastSurveyTime(new Date().getTime());
            if (this.f8742w != null) {
                this.f8742w.m12265a(this.f8740u);
            }
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
