package com.huawei.wallet.logic.multicard;

public interface MultiCard {

    public enum SupportMode {
        MODE_SUPPORT_UNKNOWN,
        MODE_NOT_SUPPORT_GEMINI,
        MODE_SUPPORT_HW_GEMINI,
        MODE_SUPPORT_MTK_GEMINI
    }

    String mo5146a(int i);
}
