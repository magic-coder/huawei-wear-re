package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.tsm.business.enums.EnumTradeType;
import java.io.Serializable;

public class CardAppRecord implements Serializable {
    private static final /* synthetic */ long serialVersionUID = 1;
    private /* synthetic */ EnumTradeType f9565a;
    private /* synthetic */ byte f9566b;
    private /* synthetic */ byte f9567c;
    private /* synthetic */ int f9568d;
    private /* synthetic */ int f9569e;
    private /* synthetic */ int f9570f;
    private /* synthetic */ String f9571g;
    private /* synthetic */ String f9572h;
    private /* synthetic */ String f9573i;
    private /* synthetic */ int f9574j;

    public int getAmount() {
        return this.f9568d;
    }

    public int getBalance() {
        return this.f9569e;
    }

    public byte getOriTradeType() {
        return this.f9567c;
    }

    public int getOverdraft() {
        return this.f9574j;
    }

    public byte getTerminalTradeType() {
        return this.f9566b;
    }

    public String getTradeDate() {
        return this.f9571g;
    }

    public String getTradeDevice() {
        return this.f9573i;
    }

    public int getTradeNo() {
        return this.f9570f;
    }

    public String getTradeTime() {
        return this.f9572h;
    }

    public EnumTradeType getTradeType() {
        return this.f9565a;
    }

    public void setAmount(int i) {
        this.f9568d = i;
    }

    public void setBalance(int i) {
        this.f9569e = i;
    }

    public void setOriTradeType(byte b) {
        this.f9567c = b;
    }

    public void setOverdraft(int i) {
        this.f9574j = i;
    }

    public void setTerminalTradeType(byte b) {
        this.f9566b = b;
    }

    public void setTradeDate(String str) {
        this.f9571g = str;
    }

    public void setTradeDevice(String str) {
        this.f9573i = str;
    }

    public void setTradeNo(int i) {
        this.f9570f = i;
    }

    public void setTradeTime(String str) {
        this.f9572h = str;
    }

    public void setTradeType(EnumTradeType enumTradeType) {
        this.f9565a = enumTradeType;
    }
}
