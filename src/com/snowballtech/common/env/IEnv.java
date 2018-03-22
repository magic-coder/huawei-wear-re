package com.snowballtech.common.env;

import java.util.Map;

public interface IEnv {
    void SetDevice(String str);

    Map<String, String> fetchEnv();
}
