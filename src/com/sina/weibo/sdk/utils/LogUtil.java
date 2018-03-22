package com.sina.weibo.sdk.utils;

import android.util.Log;

public class LogUtil {
    public static boolean sIsLogEnable = false;

    public static void enableLog() {
        sIsLogEnable = true;
    }

    public static void disableLog() {
        sIsLogEnable = false;
    }

    public static void m28661d(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void m28663i(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.i(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void m28662e(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void m28665w(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.w(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static void m28664v(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.v(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }

    public static String getStackTraceMsg() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        return stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
    }
}
