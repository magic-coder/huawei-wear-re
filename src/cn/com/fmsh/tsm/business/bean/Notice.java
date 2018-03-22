package cn.com.fmsh.tsm.business.bean;

import java.io.Serializable;

public class Notice implements Serializable {
    public static int NOTICE_TXT = 22;
    public static int NOTICE_UNSOLVED = 33;
    private static final /* synthetic */ long serialVersionUID = 1;
    /* synthetic */ int f9621a;
    /* synthetic */ String f9622b;
    /* synthetic */ String f9623c;
    /* synthetic */ String f9624d;
    /* synthetic */ String f9625e;
    /* synthetic */ int f9626f;
    /* synthetic */ byte[] f9627g;

    public String getContent() {
        return this.f9623c;
    }

    public String getEndDate() {
        return this.f9625e;
    }

    public int getNo() {
        return this.f9621a;
    }

    public byte[] getOrder() {
        return this.f9627g;
    }

    public String getStartDate() {
        return this.f9624d;
    }

    public String getTitle() {
        return this.f9622b;
    }

    public int getType() {
        return this.f9626f;
    }

    public void setContent(String str) {
        this.f9623c = str;
    }

    public void setEndDate(String str) {
        this.f9625e = str;
    }

    public void setNo(int i) {
        this.f9621a = i;
    }

    public void setOrder(byte[] bArr) {
        this.f9627g = bArr;
    }

    public void setStartDate(String str) {
        this.f9624d = str;
    }

    public void setTitle(String str) {
        this.f9622b = str;
    }

    public void setType(int i) {
        this.f9626f = i;
    }
}
