package org.apache.log4j;

import java.util.Hashtable;
import java.util.Stack;

public class NDC {
    static final int REAP_THRESHOLD = 5;
    static Hashtable ht = new Hashtable();
    static int pushCounter = 0;

    class DiagnosticContext {
        String fullMessage;
        String message;

        DiagnosticContext(String str, DiagnosticContext diagnosticContext) {
            this.message = str;
            if (diagnosticContext != null) {
                this.fullMessage = new StringBuffer().append(diagnosticContext.fullMessage).append(' ').append(str).toString();
            } else {
                this.fullMessage = str;
            }
        }
    }

    private NDC() {
    }

    private static Stack getCurrentStack() {
        if (ht != null) {
            return (Stack) ht.get(Thread.currentThread());
        }
        return null;
    }

    public static void clear() {
        Stack currentStack = getCurrentStack();
        if (currentStack != null) {
            currentStack.setSize(0);
        }
    }

    public static Stack cloneStack() {
        Stack currentStack = getCurrentStack();
        if (currentStack == null) {
            return null;
        }
        return (Stack) currentStack.clone();
    }

    public static void inherit(Stack stack) {
        if (stack != null) {
            ht.put(Thread.currentThread(), stack);
        }
    }

    public static String get() {
        Stack currentStack = getCurrentStack();
        if (currentStack == null || currentStack.isEmpty()) {
            return null;
        }
        return ((DiagnosticContext) currentStack.peek()).fullMessage;
    }

    public static int getDepth() {
        Stack currentStack = getCurrentStack();
        if (currentStack == null) {
            return 0;
        }
        return currentStack.size();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void lazyRemove() {
        /*
        r1 = 0;
        r0 = ht;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r3 = ht;
        monitor-enter(r3);
        r0 = pushCounter;	 Catch:{ all -> 0x0014 }
        r0 = r0 + 1;
        pushCounter = r0;	 Catch:{ all -> 0x0014 }
        r2 = 5;
        if (r0 > r2) goto L_0x0017;
    L_0x0012:
        monitor-exit(r3);	 Catch:{ all -> 0x0014 }
        goto L_0x0005;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r0 = 0;
        pushCounter = r0;	 Catch:{ all -> 0x0014 }
        r4 = new java.util.Vector;	 Catch:{ all -> 0x0014 }
        r4.<init>();	 Catch:{ all -> 0x0014 }
        r0 = ht;	 Catch:{ all -> 0x0014 }
        r5 = r0.keys();	 Catch:{ all -> 0x0014 }
        r2 = r1;
    L_0x0026:
        r0 = r5.hasMoreElements();	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0044;
    L_0x002c:
        r0 = 4;
        if (r2 > r0) goto L_0x0044;
    L_0x002f:
        r0 = r5.nextElement();	 Catch:{ all -> 0x0014 }
        r0 = (java.lang.Thread) r0;	 Catch:{ all -> 0x0014 }
        r6 = r0.isAlive();	 Catch:{ all -> 0x0014 }
        if (r6 == 0) goto L_0x003f;
    L_0x003b:
        r0 = r2 + 1;
    L_0x003d:
        r2 = r0;
        goto L_0x0026;
    L_0x003f:
        r4.addElement(r0);	 Catch:{ all -> 0x0014 }
        r0 = r1;
        goto L_0x003d;
    L_0x0044:
        monitor-exit(r3);	 Catch:{ all -> 0x0014 }
        r2 = r4.size();
    L_0x0049:
        if (r1 >= r2) goto L_0x0005;
    L_0x004b:
        r0 = r4.elementAt(r1);
        r0 = (java.lang.Thread) r0;
        r3 = new java.lang.StringBuffer;
        r3.<init>();
        r5 = "Lazy NDC removal for thread [";
        r3 = r3.append(r5);
        r5 = r0.getName();
        r3 = r3.append(r5);
        r5 = "] (";
        r3 = r3.append(r5);
        r5 = ht;
        r5 = r5.size();
        r3 = r3.append(r5);
        r5 = ").";
        r3 = r3.append(r5);
        r3 = r3.toString();
        org.apache.log4j.helpers.LogLog.debug(r3);
        r3 = ht;
        r3.remove(r0);
        r1 = r1 + 1;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.NDC.lazyRemove():void");
    }

    public static String pop() {
        Stack currentStack = getCurrentStack();
        if (currentStack == null || currentStack.isEmpty()) {
            return "";
        }
        return ((DiagnosticContext) currentStack.pop()).message;
    }

    public static String peek() {
        Stack currentStack = getCurrentStack();
        if (currentStack == null || currentStack.isEmpty()) {
            return "";
        }
        return ((DiagnosticContext) currentStack.peek()).message;
    }

    public static void push(String str) {
        Stack currentStack = getCurrentStack();
        if (currentStack == null) {
            DiagnosticContext diagnosticContext = new DiagnosticContext(str, null);
            currentStack = new Stack();
            ht.put(Thread.currentThread(), currentStack);
            currentStack.push(diagnosticContext);
        } else if (currentStack.isEmpty()) {
            currentStack.push(new DiagnosticContext(str, null));
        } else {
            currentStack.push(new DiagnosticContext(str, (DiagnosticContext) currentStack.peek()));
        }
    }

    public static void remove() {
        if (ht != null) {
            ht.remove(Thread.currentThread());
            lazyRemove();
        }
    }

    public static void setMaxDepth(int i) {
        Stack currentStack = getCurrentStack();
        if (currentStack != null && i < currentStack.size()) {
            currentStack.setSize(i);
        }
    }
}
