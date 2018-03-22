package com.leisen.wallet.sdk.oma;

import com.snowballtech.apdu.constant.Constant;

public class SmartCardBean {
    public static final int READER_TYPE_ESE = 1;
    public static final int READER_TYPE_SD = 2;
    public static final int READER_TYPE_SIM = 0;
    private String aid;
    private String command;
    private int reader = -1;

    public SmartCardBean(int i, String str) {
        this.reader = i;
        this.aid = str;
    }

    public SmartCardBean(int i, String str, String str2) {
        this.reader = i;
        this.aid = str;
        this.command = str2;
    }

    public int getReader() {
        return this.reader;
    }

    public void setReader(int i) {
        this.reader = i;
    }

    public String getReaderName() {
        switch (this.reader) {
            case 0:
                return Constant._UICC_TERMINAL;
            case 1:
                return Constant._ESE_TERMINAL;
            case 2:
                return Constant._SD_TERMINAL;
            default:
                return null;
        }
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void smartCardBeanSAI1() {
    }

    public void smartCardBeanSAI2() {
    }

    public void smartCardBeanSAI3() {
    }

    public void smartCardBeanSAI4() {
    }

    public void smartCardBeanSAI5() {
    }
}
