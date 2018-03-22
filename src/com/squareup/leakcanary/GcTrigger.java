package com.squareup.leakcanary;

public interface GcTrigger {
    public static final GcTrigger DEFAULT = new C25891();

    final class C25891 implements GcTrigger {
        C25891() {
        }

        public void runGc() {
            Runtime.getRuntime().gc();
            enqueueReferences();
            System.runFinalization();
        }

        private void enqueueReferences() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new AssertionError();
            }
        }
    }

    void runGc();
}
