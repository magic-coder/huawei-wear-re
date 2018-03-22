package com.squareup.haha.perflib;

public class StackTrace {
    StackFrame[] mFrames;
    int mOffset = 0;
    StackTrace mParent = null;
    int mSerialNumber;
    int mThreadSerialNumber;

    private StackTrace() {
    }

    public StackTrace(int i, int i2, StackFrame[] stackFrameArr) {
        this.mSerialNumber = i;
        this.mThreadSerialNumber = i2;
        this.mFrames = stackFrameArr;
    }

    public final StackTrace fromDepth(int i) {
        StackTrace stackTrace = new StackTrace();
        if (this.mParent != null) {
            stackTrace.mParent = this.mParent;
        } else {
            stackTrace.mParent = this;
        }
        stackTrace.mOffset = this.mOffset + i;
        return stackTrace;
    }

    public final void dump() {
        for (StackFrame stackFrame : this.mFrames) {
            System.out.println(stackFrame.toString());
        }
    }
}