package com.huawei.ui.main.stories.nps.interactors.mode;

import java.util.List;

public class CreateAnswerSheetRequest {
    private Integer questionnaireId;
    private List<CreateQuestionAnswer> questions;
    private Integer userId;

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer num) {
        this.userId = num;
    }

    public Integer getQuestionnaireId() {
        return this.questionnaireId;
    }

    public void setQuestionnaireId(Integer num) {
        this.questionnaireId = num;
    }

    public List<CreateQuestionAnswer> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<CreateQuestionAnswer> list) {
        this.questions = list;
    }

    public void getAnswerSheetName() {
    }

    public void requestAnswerSheetHeadUrl() {
    }

    public void downloadAnswerSheetNameUrl() {
    }

    public void judgeAnswerSheetWeightBySomeInfo() {
    }

    public void setAnswerSheetSwitchUpload() {
    }

    public void updataAnswerSheetLocalTable() {
    }

    public void dealWithAnswerSheetResetFactory() {
    }

    public void refreshAnswerSheetInitData() {
    }

    public void queryAnswerSheetProcessData() {
    }

    public void contrustAnswerSheetHeadImage() {
    }

    public void changeAnswerSheetDeviceInfo() {
    }
}
