package com.huawei.nfc.carrera.logic.appletcardinfo.model;

import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.utils.TimeUtil;
import java.util.ArrayList;
import java.util.List;

public class CardInfo {
    private int amount;
    private String cardNum;
    private String enableDate;
    private String expireDate;
    private int overdraftAmount;
    private List<TransactionRecord> records;

    public List<TransactionRecord> getRecords() {
        return new ArrayList(this.records);
    }

    public void setRecords(List<TransactionRecord> list) {
        this.records = new ArrayList(list);
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String str) {
        this.cardNum = str;
    }

    public void setEnableDate(String str) {
        this.enableDate = str;
    }

    public String getEnableDate() {
        return this.enableDate;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public int getOverdraftAmount() {
        return this.overdraftAmount;
    }

    public void setOverdraftAmount(int i) {
        this.overdraftAmount = i;
    }

    public int getBalanceByFenUnit() {
        return this.amount - Math.abs(this.overdraftAmount);
    }

    public String getFormatedBalanceByYuanUnit() {
        return MoneyUtil.convertFenToYuan((long) getBalanceByFenUnit());
    }

    public String getFormatedExpireDate(String str) {
        if (StringUtil.isEmpty(this.expireDate, true)) {
            return null;
        }
        return TimeUtil.m28482a(TimeUtil.m28483a(this.expireDate, "yyyyMMdd"), str);
    }
}
