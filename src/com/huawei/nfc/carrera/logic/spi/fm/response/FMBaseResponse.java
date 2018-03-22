package com.huawei.nfc.carrera.logic.spi.fm.response;

public class FMBaseResponse {
    public static final int FAILED = -1;
    public static final int NETWORK_ERROR = -2;
    public static final int SUCCESS = 0;
    public int FMCode = -1;
    public int resultCode = -1;

    public interface FMBaseResponseSAI1 {
    }

    public interface FMBaseResponseSAI2 {
    }

    public interface FMBaseResponseSAI3 {
    }

    public interface FMBaseResponseSAI4 {
    }

    public interface FMBaseResponseSAI5 {
    }
}
