package com.snowballtech.business.bean;

import com.snowballtech.apdu.bean.Content;

public class SNBRequest {
    private String command;
    private Content command_results;
    private String current_step = "BOF";
    private String execute_flag;
    private String extra_info;
    private String function_call_id;
    private String package_name;
    private String package_version_code;
    private String package_version_name;
    private String refundData;
    private String service_id;
    private String session;
    private String target_id;
    private String token;

    public String getCurrent_step() {
        return this.current_step;
    }

    public void setCurrent_step(String str) {
        this.current_step = str;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public Content getCommand_results() {
        return this.command_results;
    }

    public void setCommand_results(Content content) {
        this.command_results = content;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public String getPackage_version_name() {
        return this.package_version_name;
    }

    public void setPackage_version_name(String str) {
        this.package_version_name = str;
    }

    public String getPackage_version_code() {
        return this.package_version_code;
    }

    public void setPackage_version_code(String str) {
        this.package_version_code = str;
    }

    public String getExecute_flag() {
        return this.execute_flag;
    }

    public void setExecute_flag(String str) {
        this.execute_flag = str;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public String getTarget_id() {
        return this.target_id;
    }

    public void setTarget_id(String str) {
        this.target_id = str;
    }

    public String getFunction_call_id() {
        return this.function_call_id;
    }

    public void setFunction_call_id(String str) {
        this.function_call_id = str;
    }

    public String getService_id() {
        return this.service_id;
    }

    public void setService_id(String str) {
        this.service_id = str;
    }

    public String getExtra_info() {
        return this.extra_info;
    }

    public void setExtra_info(String str) {
        this.extra_info = str;
    }

    public String getRefundData() {
        return this.refundData;
    }

    public void setRefundData(String str) {
        this.refundData = str;
    }
}
