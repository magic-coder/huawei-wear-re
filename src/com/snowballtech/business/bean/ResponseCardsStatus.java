package com.snowballtech.business.bean;

import java.util.List;

public class ResponseCardsStatus {
    private List<CardBaseSe> aid_list;
    private String device_cplc;
    private String device_uid;
    private String need_upload;
    private String resp_code;
    private String resp_msg;
    private String ws_version_code;

    public List<CardBaseSe> getAid_list() {
        return this.aid_list;
    }

    public void setAid_list(List<CardBaseSe> list) {
        this.aid_list = list;
    }

    public String getResp_code() {
        return this.resp_code;
    }

    public void setResp_code(String str) {
        this.resp_code = str;
    }

    public String getResp_msg() {
        return this.resp_msg;
    }

    public void setResp_msg(String str) {
        this.resp_msg = str;
    }

    public String getNeed_upload() {
        return this.need_upload;
    }

    public void setNeed_upload(String str) {
        this.need_upload = str;
    }

    public String getWs_version_code() {
        return this.ws_version_code;
    }

    public void setWs_version_code(String str) {
        this.ws_version_code = str;
    }

    public String getDevice_uid() {
        return this.device_uid;
    }

    public void setDevice_uid(String str) {
        this.device_uid = str;
    }

    public String getDevice_cplc() {
        return this.device_cplc;
    }

    public void setDevice_cplc(String str) {
        this.device_cplc = str;
    }
}
