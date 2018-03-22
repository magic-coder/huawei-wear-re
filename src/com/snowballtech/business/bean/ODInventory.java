package com.snowballtech.business.bean;

public class ODInventory {
    public static final String TRANSACTION_AMOUNT = "transaction_amount";
    public static final String TRANSACTION_STATUS = "transaction_status";
    public static final String TRANSACTION_TIME = "transaction_time";
    public static final String TRANSACTION_TYPE = "transaction_type";
    public String transaction_amount;
    public int transaction_status;
    public String transaction_time;
    public String transaction_type;

    public String getTransaction_time() {
        return this.transaction_time;
    }

    public void setTransaction_time(String str) {
        this.transaction_time = str;
    }

    public String getTransaction_type() {
        return this.transaction_type;
    }

    public void setTransaction_type(String str) {
        this.transaction_type = str;
    }

    public int getTransaction_status() {
        return this.transaction_status;
    }

    public void setTransaction_status(int i) {
        this.transaction_status = i;
    }

    public String getTransaction_amount() {
        return this.transaction_amount;
    }

    public void setTransaction_amount(String str) {
        this.transaction_amount = str;
    }
}
