package com.huawei.crowdtestsdk.bases;

import android.util.SparseArray;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.utils.ResUtil;

public class CreateType {
    public static final SparseArray<Integer> createTypeResIdIndex = new SparseArray();

    public enum CREATE_TYPE {
        NEW,
        ADD_ATTACH
    }

    static {
        createTypeResIdIndex.put(CREATE_TYPE.NEW.ordinal(), Integer.valueOf(ResUtil.getResId(AppContext.getInstance().getApplicationContext(), "sdk_crowdtest_create_type_new", ResUtil.TYPE_STRING)));
        createTypeResIdIndex.put(CREATE_TYPE.ADD_ATTACH.ordinal(), Integer.valueOf(ResUtil.getResId(AppContext.getInstance().getApplicationContext(), "sdk_crowdtest_create_type_add_attachment", ResUtil.TYPE_STRING)));
    }
}
