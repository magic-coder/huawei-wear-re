package com.snowballtech.common.bean;

public class Command {
    private String checker;
    private String command;
    private int index;
    private Integer progress;
    private String result;

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public String getChecker() {
        return this.checker;
    }

    public void setChecker(String str) {
        this.checker = str;
    }
}
