package com.huawei.ui.main.stories.nps.interactors.mode;

public class QstnSurveyChooseResponse {
    private Integer id;
    private String name;
    private String remark;

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
