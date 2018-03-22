package com.huawei.ui.main.stories.nps.interactors.mode;

import java.util.List;

public class QuestionnaireInfo {
    private String endDesc;
    private Integer id;
    private String pictureUrl;
    private List<QstnSureyResponse> questions;
    private String startDesc;
    private String title;

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public void setPictureUrl(String str) {
        this.pictureUrl = str;
    }

    public String getStartDes() {
        return this.startDesc;
    }

    public void setStartDes(String str) {
        this.startDesc = str;
    }

    public String getEndDes() {
        return this.endDesc;
    }

    public void setEndDes(String str) {
        this.endDesc = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<QstnSureyResponse> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<QstnSureyResponse> list) {
        this.questions = list;
    }

    public void QIData1() {
    }

    public void QIData2() {
    }

    public void QIData3() {
    }

    public void QIData4() {
    }

    public void QIData5() {
    }

    public void QIData6() {
    }

    public void QIData7() {
    }

    public void QIData8() {
    }

    public void QIData9() {
    }
}
