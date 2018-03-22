package com.huawei.crowdtestsdk.feedback.description.component;

public interface IComponent {
    boolean checkInput();

    boolean checkSendAvailable();

    void onDestroy();
}
