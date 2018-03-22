package com.huawei.ui.main.stories.nps.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSureyResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.TypeParams;

/* compiled from: QuestionMainActivity */
class C2437l extends FragmentStatePagerAdapter {
    final /* synthetic */ QuestionMainActivity f8769a;

    public C2437l(QuestionMainActivity questionMainActivity, FragmentManager fragmentManager) {
        this.f8769a = questionMainActivity;
        super(fragmentManager);
    }

    public Fragment getItem(int i) {
        String questionType = ((QstnSureyResponse) this.f8769a.f8729j.get(i)).getQuestionType();
        if (TypeParams.QUESTION_FIELD.equals(questionType)) {
            this.f8769a.f8728i = new C2427b((QstnSureyResponse) this.f8769a.f8729j.get(i), i + 1);
            return this.f8769a.f8728i;
        } else if (TypeParams.QUESTION_CHOOSE_SINGEL.equals(questionType)) {
            return new C2438m((QstnSureyResponse) this.f8769a.f8729j.get(i), i + 1);
        } else {
            return new C2438m((QstnSureyResponse) this.f8769a.f8729j.get(i), i + 1);
        }
    }

    public int getCount() {
        return this.f8769a.f8729j.size();
    }
}
