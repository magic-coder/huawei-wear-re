package com.huawei.ui.main.stories.nps.interactors.mode;

import java.util.List;

public class QstnSureyResponse {
    private Integer id;
    private List<QstnSurveyChooseResponse> options;
    private String pictureUrl;
    private String question;
    private String subTitle;
    private String type;

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public void setPictureUrl(String str) {
        this.pictureUrl = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getTitle() {
        return this.subTitle;
    }

    public void setTitle(String str) {
        this.subTitle = str;
    }

    public List<QstnSurveyChooseResponse> getChoose() {
        return this.options;
    }

    public void setChoose(List<QstnSurveyChooseResponse> list) {
        this.options = list;
    }

    public String getQuestionType() {
        return this.type;
    }

    public void setQuestionType(String str) {
        this.type = str;
    }

    public void QSRData1() {
    }

    public void QSRData2() {
    }

    public void QSRData3() {
    }

    public void QSRData4() {
    }

    public void QSRData5() {
    }

    public void QSRData6() {
    }

    public void QSRData7() {
    }

    public void QSRData8() {
    }

    public void QSRData9() {
    }
}
