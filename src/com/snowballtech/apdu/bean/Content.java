package com.snowballtech.apdu.bean;

import com.snowballtech.common.bean.Command;
import java.util.List;

public class Content {
    private int channelType = 0;
    private String channel_status;
    private List<Command> commands;
    private String instance_id;
    private int mediaType = 0;
    private String progress_current;
    private List<Command> results;
    private Boolean succeed;

    public String getInstance_id() {
        return this.instance_id;
    }

    public void setInstance_id(String str) {
        this.instance_id = str;
    }

    public List<Command> getCommands() {
        return this.commands;
    }

    public void setCommands(List<Command> list) {
        this.commands = list;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public void setChannelType(int i) {
        this.channelType = i;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public String getChannel_status() {
        return this.channel_status;
    }

    public void setChannel_status(String str) {
        this.channel_status = str;
    }

    public String getProgress_current() {
        return this.progress_current;
    }

    public void setProgress_current(String str) {
        this.progress_current = str;
    }

    public Boolean getSucceed() {
        return this.succeed;
    }

    public void setSucceed(Boolean bool) {
        this.succeed = bool;
    }

    public List<Command> getResults() {
        return this.results;
    }

    public void setResults(List<Command> list) {
        this.results = list;
    }
}
