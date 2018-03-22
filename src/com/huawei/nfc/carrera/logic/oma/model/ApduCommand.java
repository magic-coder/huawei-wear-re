package com.huawei.nfc.carrera.logic.oma.model;

import com.huawei.nfc.carrera.util.StringUtil;
import java.util.Locale;

public class ApduCommand {
    private static final int SW_LENGTH = 4;
    private String apdu;
    private String checker;
    private int index;
    private String rapdu;
    private String sw = "";

    public ApduCommand(int i, String str, String str2) {
        this.index = i;
        this.apdu = str;
        this.checker = str2;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String getApdu() {
        return this.apdu;
    }

    public void setApdu(String str) {
        this.apdu = str;
    }

    public String getRapdu() {
        return this.rapdu;
    }

    public void setRapdu(String str) {
        this.rapdu = str;
    }

    public String getChecker() {
        return this.checker;
    }

    public void setChecker(String str) {
        this.checker = str;
    }

    public void setChecker(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            this.checker = null;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append(strArr[i].toUpperCase(Locale.getDefault()));
            if (i != strArr.length - 1) {
                stringBuilder.append("|");
            }
        }
        this.checker = stringBuilder.toString();
    }

    public String getSw() {
        return this.sw;
    }

    public void setSw(String str) {
        this.sw = str;
    }

    public void parseRapduAndSw(String str) {
        if (StringUtil.isEmpty(str, true) || str.length() < 4) {
            this.rapdu = str;
            return;
        }
        this.rapdu = str.substring(0, str.length() - 4);
        this.sw = str.substring(str.length() - 4, str.length());
    }

    public String toString() {
        return "ApduCommand{index=" + this.index + ", apdu='" + this.apdu + '\'' + ", rapdu='" + this.rapdu + '\'' + ", checker='" + this.checker + '\'' + ", sw='" + this.sw + '\'' + '}';
    }
}
