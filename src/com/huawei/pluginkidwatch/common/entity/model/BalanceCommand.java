package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class BalanceCommand implements Serializable {
    public String commandCode;
    public String operateCode;

    public interface balanceCommandSAI10 {
    }

    public interface balanceCommandSAI11 {
    }

    public interface balanceCommandSAI12 {
    }

    public interface balanceCommandSAI13 {
    }

    public interface balanceCommandSAI14 {
    }

    public interface balanceCommandSAI15 {
    }

    public interface balanceCommandSAI16 {
    }

    public interface balanceCommandSAI1 {
    }

    public interface balanceCommandSAI2 {
    }

    public interface balanceCommandSAI3 {
    }

    public interface balanceCommandSAI4 {
    }

    public interface balanceCommandSAI5 {
    }

    public interface balanceCommandSAI6 {
    }

    public interface balanceCommandSAI7 {
    }

    public interface balanceCommandSAI8 {
    }

    public interface balanceCommandSAI9 {
    }

    public String getOperateCode() {
        return this.operateCode;
    }

    public String getCommandCode() {
        return this.commandCode;
    }

    public void setOperateCode(String str) {
        this.operateCode = str;
    }

    public void setCommandCode(String str) {
        this.commandCode = str;
    }

    public String toString() {
        return "{\"operateCode\":\"" + this.operateCode + "\",\"commandCode\":\"" + this.commandCode + "\"" + '}';
    }
}
