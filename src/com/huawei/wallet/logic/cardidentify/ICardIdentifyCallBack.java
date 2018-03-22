package com.huawei.wallet.logic.cardidentify;

public interface ICardIdentifyCallBack {
    void onCardBackPressed();

    void onIndetify(CardIdentifyInfo cardIdentifyInfo);

    void onSwitch2Input();
}
