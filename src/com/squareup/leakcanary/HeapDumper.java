package com.squareup.leakcanary;

import java.io.File;

public interface HeapDumper {
    public static final HeapDumper NONE = new C25921();
    public static final File RETRY_LATER = null;

    final class C25921 implements HeapDumper {
        C25921() {
        }

        public File dumpHeap() {
            return RETRY_LATER;
        }
    }

    File dumpHeap();
}
