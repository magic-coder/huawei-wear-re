package com.squareup.leakcanary;

public interface WatchExecutor {
    public static final WatchExecutor NONE = new C25951();

    final class C25951 implements WatchExecutor {
        C25951() {
        }

        public void execute(Retryable retryable) {
        }
    }

    void execute(Retryable retryable);
}
