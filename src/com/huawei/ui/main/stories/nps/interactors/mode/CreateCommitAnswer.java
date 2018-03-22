package com.huawei.ui.main.stories.nps.interactors.mode;

public class CreateCommitAnswer {
    private String answer;
    private Integer questionId;

    public Integer getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(Integer num) {
        this.questionId = num;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public String toString() {
        return "CreateCommitAnswer{questionId=" + this.questionId + ", answer='" + this.answer + '\'' + '}';
    }
}
