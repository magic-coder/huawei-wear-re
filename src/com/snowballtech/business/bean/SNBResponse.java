package com.snowballtech.business.bean;

import com.snowballtech.common.bean.Command;
import java.util.List;

public class SNBResponse {
    private List<Command> commands;
    private String data;
    private String end_flag;
    private String extra_info;
    private String next_step;
    private String resp_code;
    private String resp_msg;
    private String response_time_stamp;
    private String session;
    private String token;

    public String getNext_step() {
        return this.next_step;
    }

    public void setNext_step(String str) {
        this.next_step = str;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public List<Command> getCommands() {
        return this.commands;
    }

    public void setCommands(List<Command> list) {
        this.commands = list;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getExtra_info() {
        return this.extra_info;
    }

    public void setExtra_info(String str) {
        this.extra_info = str;
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

    public String getEnd_flag() {
        return this.end_flag;
    }

    public void setEnd_flag(String str) {
        this.end_flag = str;
    }

    public String getResponse_time_stamp() {
        return this.response_time_stamp;
    }

    public void setResponse_time_stamp(String str) {
        this.response_time_stamp = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }
}
