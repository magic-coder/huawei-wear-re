package com.huawei.wallet.model.unicard;

public class BankAppInfo extends BaseInfo {
    private String f21315a = "";

    public int hashCode() {
        return this.f21315a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BankAppInfo)) {
            return false;
        }
        if (this.f21315a.equals(((BankAppInfo) obj).f21315a)) {
            return true;
        }
        return false;
    }
}
