package cn.com.fmsh.tsm.business.bean;

import java.util.ArrayList;
import java.util.List;

public class CardAppInfo {
    private /* synthetic */ String f9555a;
    private /* synthetic */ String f9556b;
    private /* synthetic */ Integer f9557c;
    private /* synthetic */ int f9558d = 0;
    private /* synthetic */ byte[] f9559e;
    private /* synthetic */ String f9560f;
    private /* synthetic */ boolean f9561g = false;
    private /* synthetic */ List<CardAppRecord> f9562h = new ArrayList();
    private /* synthetic */ String f9563i;
    private /* synthetic */ String f9564j;

    public void addRecord(CardAppRecord cardAppRecord) {
        if (cardAppRecord != null) {
            this.f9562h.add(cardAppRecord);
        }
    }

    public void addRecord(CardAppRecord[] cardAppRecordArr) {
        if (this.f9562h != null) {
            for (Object add : cardAppRecordArr) {
                this.f9562h.add(add);
            }
        }
    }

    public Integer getBalance() {
        return this.f9557c;
    }

    public String getBalanceDelayDate() {
        return this.f9560f;
    }

    public byte[] getCardAppNo() {
        return this.f9559e;
    }

    public int getCardType() {
        return this.f9558d;
    }

    public String getFaceId() {
        return this.f9556b;
    }

    public String getMoc() {
        return this.f9563i;
    }

    public CardAppRecord[] getRecords() {
        return (this.f9562h == null || this.f9562h.size() < 1) ? null : (CardAppRecord[]) this.f9562h.toArray(new CardAppRecord[0]);
    }

    public String getTime4Validity() {
        return this.f9564j;
    }

    public String getTitle() {
        return this.f9555a;
    }

    public boolean isAppClose() {
        return this.f9561g;
    }

    public void setAppClose(boolean z) {
        this.f9561g = z;
    }

    public void setBalance(Integer num) {
        this.f9557c = num;
    }

    public void setCardAppNo(byte[] bArr) {
        this.f9559e = bArr;
    }

    public void setCardType(int i) {
        this.f9558d = i;
    }

    public void setDelayDate(String str) {
        this.f9560f = str;
    }

    public void setFaceId(String str) {
        this.f9556b = str;
    }

    public void setMoc(String str) {
        this.f9563i = str;
    }

    public void setTime4Validity(String str) {
        this.f9564j = str;
    }

    public void setTitle(String str) {
        this.f9555a = str;
    }
}
