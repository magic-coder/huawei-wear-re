package com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload;

public interface Pullable {
    boolean canPullDown();

    boolean canPullUp();

    void setMode(Mode mode);
}
