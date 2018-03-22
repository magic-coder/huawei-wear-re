package com.squareup.leakcanary;

public interface DebuggerControl {
    public static final DebuggerControl NONE = new C25841();

    final class C25841 implements DebuggerControl {
        C25841() {
        }

        public boolean isDebuggerAttached() {
            return false;
        }
    }

    boolean isDebuggerAttached();
}
