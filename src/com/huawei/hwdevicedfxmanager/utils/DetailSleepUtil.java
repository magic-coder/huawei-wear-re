package com.huawei.hwdevicedfxmanager.utils;

import android.os.Environment;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DetailSleepUtil implements MaintenaceInterface {
    public static final String CORE_SLEEP_PATH = (Environment.getExternalStorageDirectory() + "/huaweisystem/CoreSleepLog");
    private static String DATA_FILE_NAME = "sleep_data.bin";
    private static String STATE_FILE_NAME = "sleep_state.bin";
    private static String TAG = "DetailSleepUtil";
    private static DetailSleepUtil instance;
    private ExecutorService executorService;
    private String fileName = "";
    private boolean isStateFileWrite = false;
    private final Object lockObject = new Object();
    private Runnable logRunnable = new C49791();
    private IBaseResponseCallback mCallback;
    private String mDataFilePath = "";
    private String mStateFilePath = "";
    private ArrayList<byte[]> mTransferDataContent;
    private String mTransferDataContentPath;
    private ArrayList<byte[]> mTransferStateContent;
    private String mTransferStateContentPath;

    class C49791 implements Runnable {
        C49791() {
        }

        public void run() {
            ObjectOutputStream objectOutputStream;
            IOException e;
            FileNotFoundException e2;
            Throwable th;
            synchronized (DetailSleepUtil.this.lockObject) {
                C2538c.e(DetailSleepUtil.TAG, new Object[]{"DetailSleep saveFile run ....isStateFileWrite = " + DetailSleepUtil.this.isStateFileWrite});
                C2538c.c(DetailSleepUtil.TAG, new Object[]{" getmTransferStateContentPath :" + DetailSleepUtil.this.getmTransferStateContentPath()});
                C2538c.c(DetailSleepUtil.TAG, new Object[]{" getmTransferDataContentPath :" + DetailSleepUtil.this.getmTransferDataContentPath()});
                C2538c.c(DetailSleepUtil.TAG, new Object[]{" writeFileToSD BuildConfig.IS_DEBUG_VERSION:false"});
                if (DetailSleepUtil.this.isStateFileWrite && DetailSleepUtil.this.getmTransferDataContentPath() == null) {
                    if (DetailSleepUtil.this.mCallback != null) {
                        DetailSleepUtil.this.mCallback.onResponse(10001, "error: when isStateFileWrite is true,getmTransferDataContentPath() should not be null");
                    }
                    DetailSleepUtil.this.isStateFileWrite = false;
                    return;
                }
                if (!(DetailSleepUtil.this.getmTransferStateContentPath() == null || DetailSleepUtil.this.isStateFileWrite)) {
                    try {
                        objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferStateContentPath(), 0));
                        try {
                            if (DetailSleepUtil.this.mTransferStateContent != null) {
                                C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferStateContent size : " + DetailSleepUtil.this.mTransferStateContent.size()});
                            }
                            objectOutputStream.writeObject(DetailSleepUtil.this.mTransferStateContent);
                            objectOutputStream.close();
                            if (DetailSleepUtil.this.mCallback != null) {
                                DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                            }
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                } catch (IOException e3) {
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile Exception e = " + e3.getMessage()});
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                } catch (Throwable th2) {
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                }
                            }
                            DetailSleepUtil.this.isStateFileWrite = true;
                        } catch (FileNotFoundException e4) {
                            e2 = e4;
                            try {
                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile FileNotFoundException e = ", e2.getMessage()});
                                if (DetailSleepUtil.this.mCallback != null) {
                                    DetailSleepUtil.this.mCallback.onResponse(10001, "write state FileNotFoundException e.");
                                }
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                    } catch (IOException e32) {
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile Exception e = " + e32.getMessage()});
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                        DetailSleepUtil.this.isStateFileWrite = true;
                                        if (DetailSleepUtil.this.getmTransferDataContentPath() != null) {
                                            try {
                                                objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferDataContentPath(), 0));
                                                try {
                                                    if (DetailSleepUtil.this.mTransferDataContent != null) {
                                                        C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferDataContent ---size : " + DetailSleepUtil.this.mTransferDataContent.size()});
                                                    }
                                                    objectOutputStream.writeObject(DetailSleepUtil.this.mTransferDataContent);
                                                    objectOutputStream.close();
                                                    if (DetailSleepUtil.this.mCallback != null) {
                                                        DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                                                    }
                                                    if (objectOutputStream != null) {
                                                        try {
                                                            objectOutputStream.close();
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                        } catch (IOException e322) {
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data file Exception e = " + e322.getMessage()});
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                        } catch (Throwable th3) {
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                        }
                                                    }
                                                    DetailSleepUtil.this.isStateFileWrite = false;
                                                } catch (FileNotFoundException e5) {
                                                    e2 = e5;
                                                    try {
                                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data File FileNotFoundException e = ", e2.getMessage()});
                                                        if (DetailSleepUtil.this.mCallback != null) {
                                                            DetailSleepUtil.this.mCallback.onResponse(10001, "write data FileNotFoundException e.");
                                                        }
                                                        if (objectOutputStream != null) {
                                                            try {
                                                                objectOutputStream.close();
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                            } catch (IOException e3222) {
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data file Exception e = " + e3222.getMessage()});
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                                C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                                if (DetailSleepUtil.this.mCallback != null) {
                                                                    DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                                                }
                                                                return;
                                                            } catch (Throwable th4) {
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                            }
                                                        }
                                                        DetailSleepUtil.this.isStateFileWrite = false;
                                                        C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                                        DetailSleepUtil.this.isStateFileWrite = false;
                                                        if (DetailSleepUtil.this.mCallback != null) {
                                                            DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                                        }
                                                        return;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        if (objectOutputStream != null) {
                                                            try {
                                                                objectOutputStream.close();
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                            } catch (IOException e6) {
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data file Exception e = " + e6.getMessage()});
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                                throw th;
                                                            } catch (Throwable th6) {
                                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                            }
                                                        }
                                                        DetailSleepUtil.this.isStateFileWrite = false;
                                                        throw th;
                                                    }
                                                } catch (IOException e7) {
                                                    e3222 = e7;
                                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data file Exception e = " + e3222.getMessage()});
                                                    if (DetailSleepUtil.this.mCallback != null) {
                                                        DetailSleepUtil.this.mCallback.onResponse(10001, "write data file Exception e.");
                                                    }
                                                    if (objectOutputStream != null) {
                                                        try {
                                                            objectOutputStream.close();
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                        } catch (IOException e32222) {
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data file Exception e = " + e32222.getMessage()});
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                            DetailSleepUtil.this.isStateFileWrite = false;
                                                            C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                                            DetailSleepUtil.this.isStateFileWrite = false;
                                                            if (DetailSleepUtil.this.mCallback != null) {
                                                                DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                                            }
                                                            return;
                                                        } catch (Throwable th7) {
                                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                        }
                                                    }
                                                    DetailSleepUtil.this.isStateFileWrite = false;
                                                    C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                                    DetailSleepUtil.this.isStateFileWrite = false;
                                                    if (DetailSleepUtil.this.mCallback != null) {
                                                        DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                                    }
                                                    return;
                                                }
                                            } catch (FileNotFoundException e8) {
                                                e2 = e8;
                                                objectOutputStream = null;
                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data File FileNotFoundException e = ", e2.getMessage()});
                                                if (DetailSleepUtil.this.mCallback != null) {
                                                    DetailSleepUtil.this.mCallback.onResponse(10001, "write data FileNotFoundException e.");
                                                }
                                                if (objectOutputStream != null) {
                                                    objectOutputStream.close();
                                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                }
                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                if (DetailSleepUtil.this.mCallback != null) {
                                                    DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                                }
                                                return;
                                            } catch (IOException e9) {
                                                e32222 = e9;
                                                objectOutputStream = null;
                                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"write data file Exception e = " + e32222.getMessage()});
                                                if (DetailSleepUtil.this.mCallback != null) {
                                                    DetailSleepUtil.this.mCallback.onResponse(10001, "write data file Exception e.");
                                                }
                                                if (objectOutputStream != null) {
                                                    objectOutputStream.close();
                                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                }
                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                if (DetailSleepUtil.this.mCallback != null) {
                                                    DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                                }
                                                return;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                objectOutputStream = null;
                                                if (objectOutputStream != null) {
                                                    objectOutputStream.close();
                                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                                }
                                                DetailSleepUtil.this.isStateFileWrite = false;
                                                throw th;
                                            }
                                        }
                                        C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                        DetailSleepUtil.this.isStateFileWrite = false;
                                        if (DetailSleepUtil.this.mCallback != null) {
                                            DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                        }
                                        return;
                                    } catch (Throwable th9) {
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                    }
                                }
                                DetailSleepUtil.this.isStateFileWrite = true;
                                if (DetailSleepUtil.this.getmTransferDataContentPath() != null) {
                                    objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferDataContentPath(), 0));
                                    if (DetailSleepUtil.this.mTransferDataContent != null) {
                                        C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferDataContent ---size : " + DetailSleepUtil.this.mTransferDataContent.size()});
                                    }
                                    objectOutputStream.writeObject(DetailSleepUtil.this.mTransferDataContent);
                                    objectOutputStream.close();
                                    if (DetailSleepUtil.this.mCallback != null) {
                                        DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                                    }
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                    }
                                    DetailSleepUtil.this.isStateFileWrite = false;
                                }
                                C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                DetailSleepUtil.this.isStateFileWrite = false;
                                if (DetailSleepUtil.this.mCallback != null) {
                                    DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                }
                                return;
                            } catch (Throwable th10) {
                                th = th10;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                    } catch (IOException e62) {
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile Exception e = " + e62.getMessage()});
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                        DetailSleepUtil.this.isStateFileWrite = true;
                                        throw th;
                                    } catch (Throwable th11) {
                                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                    }
                                }
                                DetailSleepUtil.this.isStateFileWrite = true;
                                throw th;
                            }
                        } catch (IOException e10) {
                            e32222 = e10;
                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile Exception e = " + e32222.getMessage()});
                            if (DetailSleepUtil.this.mCallback != null) {
                                DetailSleepUtil.this.mCallback.onResponse(10001, "write state file Exception e.");
                            }
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                } catch (IOException e322222) {
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile Exception e = " + e322222.getMessage()});
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                    DetailSleepUtil.this.isStateFileWrite = true;
                                    if (DetailSleepUtil.this.getmTransferDataContentPath() != null) {
                                        objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferDataContentPath(), 0));
                                        if (DetailSleepUtil.this.mTransferDataContent != null) {
                                            C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferDataContent ---size : " + DetailSleepUtil.this.mTransferDataContent.size()});
                                        }
                                        objectOutputStream.writeObject(DetailSleepUtil.this.mTransferDataContent);
                                        objectOutputStream.close();
                                        if (DetailSleepUtil.this.mCallback != null) {
                                            DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                                        }
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                        }
                                        DetailSleepUtil.this.isStateFileWrite = false;
                                    }
                                    C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                                    DetailSleepUtil.this.isStateFileWrite = false;
                                    if (DetailSleepUtil.this.mCallback != null) {
                                        DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                                    }
                                    return;
                                } catch (Throwable th12) {
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                                }
                            }
                            DetailSleepUtil.this.isStateFileWrite = true;
                            if (DetailSleepUtil.this.getmTransferDataContentPath() != null) {
                                objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferDataContentPath(), 0));
                                if (DetailSleepUtil.this.mTransferDataContent != null) {
                                    C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferDataContent ---size : " + DetailSleepUtil.this.mTransferDataContent.size()});
                                }
                                objectOutputStream.writeObject(DetailSleepUtil.this.mTransferDataContent);
                                objectOutputStream.close();
                                if (DetailSleepUtil.this.mCallback != null) {
                                    DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                                }
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                    C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                                }
                                DetailSleepUtil.this.isStateFileWrite = false;
                            }
                            C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                            DetailSleepUtil.this.isStateFileWrite = false;
                            if (DetailSleepUtil.this.mCallback != null) {
                                DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                            }
                            return;
                        }
                    } catch (FileNotFoundException e11) {
                        e2 = e11;
                        objectOutputStream = null;
                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile FileNotFoundException e = ", e2.getMessage()});
                        if (DetailSleepUtil.this.mCallback != null) {
                            DetailSleepUtil.this.mCallback.onResponse(10001, "write state FileNotFoundException e.");
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                        }
                        DetailSleepUtil.this.isStateFileWrite = true;
                        if (DetailSleepUtil.this.getmTransferDataContentPath() != null) {
                            objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferDataContentPath(), 0));
                            if (DetailSleepUtil.this.mTransferDataContent != null) {
                                C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferDataContent ---size : " + DetailSleepUtil.this.mTransferDataContent.size()});
                            }
                            objectOutputStream.writeObject(DetailSleepUtil.this.mTransferDataContent);
                            objectOutputStream.close();
                            if (DetailSleepUtil.this.mCallback != null) {
                                DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                            }
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                            }
                            DetailSleepUtil.this.isStateFileWrite = false;
                        }
                        C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                        DetailSleepUtil.this.isStateFileWrite = false;
                        if (DetailSleepUtil.this.mCallback != null) {
                            DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                        }
                        return;
                    } catch (IOException e12) {
                        e322222 = e12;
                        objectOutputStream = null;
                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"write stateFile Exception e = " + e322222.getMessage()});
                        if (DetailSleepUtil.this.mCallback != null) {
                            DetailSleepUtil.this.mCallback.onResponse(10001, "write state file Exception e.");
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                        }
                        DetailSleepUtil.this.isStateFileWrite = true;
                        if (DetailSleepUtil.this.getmTransferDataContentPath() != null) {
                            objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferDataContentPath(), 0));
                            if (DetailSleepUtil.this.mTransferDataContent != null) {
                                C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferDataContent ---size : " + DetailSleepUtil.this.mTransferDataContent.size()});
                            }
                            objectOutputStream.writeObject(DetailSleepUtil.this.mTransferDataContent);
                            objectOutputStream.close();
                            if (DetailSleepUtil.this.mCallback != null) {
                                DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                            }
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                                C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                            }
                            DetailSleepUtil.this.isStateFileWrite = false;
                        }
                        C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                        DetailSleepUtil.this.isStateFileWrite = false;
                        if (DetailSleepUtil.this.mCallback != null) {
                            DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                        }
                        return;
                    } catch (Throwable th13) {
                        th = th13;
                        objectOutputStream = null;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                            C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write stateFile ok. "});
                        }
                        DetailSleepUtil.this.isStateFileWrite = true;
                        throw th;
                    }
                }
                if (DetailSleepUtil.this.getmTransferDataContentPath() != null) {
                    objectOutputStream = new ObjectOutputStream(BaseApplication.b().openFileOutput(DetailSleepUtil.this.getmTransferDataContentPath(), 0));
                    if (DetailSleepUtil.this.mTransferDataContent != null) {
                        C2538c.c(DetailSleepUtil.TAG, new Object[]{" mTransferDataContent ---size : " + DetailSleepUtil.this.mTransferDataContent.size()});
                    }
                    objectOutputStream.writeObject(DetailSleepUtil.this.mTransferDataContent);
                    objectOutputStream.close();
                    if (DetailSleepUtil.this.mCallback != null) {
                        DetailSleepUtil.this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                        C2538c.e(DetailSleepUtil.TAG, new Object[]{"finally write data file ok."});
                    }
                    DetailSleepUtil.this.isStateFileWrite = false;
                }
                if (DetailSleepUtil.this.getmTransferStateContentPath() == null && DetailSleepUtil.this.getmTransferDataContentPath() == null) {
                    C2538c.c(DetailSleepUtil.TAG, new Object[]{"getmTransferStateContentPath() is null. getmTransferDataContentPath() is null. "});
                    DetailSleepUtil.this.isStateFileWrite = false;
                    if (DetailSleepUtil.this.mCallback != null) {
                        DetailSleepUtil.this.mCallback.onResponse(10001, "path is all null.");
                    }
                }
            }
        }
    }

    public static DetailSleepUtil getMainInstance() {
        if (instance == null) {
            instance = new DetailSleepUtil();
        }
        return instance;
    }

    private DetailSleepUtil() {
        C2538c.c(TAG, new Object[]{"DetailSleepUtil constructor():"});
        this.mTransferDataContentPath = null;
        this.mTransferStateContentPath = null;
        synchronized (this.lockObject) {
            this.isStateFileWrite = false;
        }
        this.mTransferDataContent = new ArrayList();
        this.mTransferStateContent = new ArrayList();
        this.executorService = Executors.newFixedThreadPool(1);
    }

    public String getmTransferDataContentPath() {
        return this.mTransferDataContentPath;
    }

    public String getmTransferStateContentPath() {
        return this.mTransferStateContentPath;
    }

    public ArrayList filtertFile(ArrayList arrayList, int i) {
        return arrayList;
    }

    public String getDeviceName(int i) {
        return "Huawei";
    }

    public void setMaintCheckTime(String str) {
    }

    public String getMaintCheckTime() {
        return "0";
    }

    public void setMaintRetryResult(boolean z) {
        C2538c.c(TAG, new Object[]{"Enter setMaintRetryResult result = " + z});
        C2538c.c(TAG, new Object[]{" mTransferDataContentPath = " + this.mTransferDataContentPath});
        C2538c.c(TAG, new Object[]{" mTransferStateContentPath = " + this.mTransferStateContentPath});
        C2538c.c(TAG, new Object[]{" mTransferDataContent = " + this.mTransferDataContent});
        C2538c.c(TAG, new Object[]{" mTransferStateContent = " + this.mTransferStateContent});
        if (z) {
            boolean deleteFile;
            if (this.mTransferDataContentPath != null) {
                deleteFile = BaseApplication.b().deleteFile(this.mTransferDataContentPath);
                C2538c.c(TAG, new Object[]{"isDeleteDataSuccess :" + deleteFile});
                this.mTransferDataContentPath = null;
            }
            if (this.mTransferStateContentPath != null) {
                deleteFile = BaseApplication.b().deleteFile(this.mTransferStateContentPath);
                C2538c.c(TAG, new Object[]{"isDeleteStateSuccess :" + deleteFile});
                this.mTransferStateContentPath = null;
            }
            if (this.mTransferDataContent != null) {
                this.mTransferDataContent.clear();
            }
            if (this.mTransferStateContent != null) {
                this.mTransferStateContent.clear();
            }
        }
        synchronized (this.lockObject) {
            this.isStateFileWrite = false;
            C2538c.c(TAG, new Object[]{"----------isStateFileWrite = " + this.isStateFileWrite});
        }
        this.fileName = "";
        C2538c.c(TAG, new Object[]{"Leave setMaintRetryResult fileName = " + this.fileName});
    }

    public boolean getMaintRetryResult() {
        return false;
    }

    public void setMaintRetryNum(int i) {
    }

    public int getMaintRetryNum() {
        return 0;
    }

    public void initMaintenanceParame(int i, String str, String str2) {
    }

    public String getDayDateTime() {
        return "";
    }

    public void deleteTenDayFile() {
    }

    public void writeLogToFile(ArrayList<byte[]> arrayList, String str, Date date) {
        C2538c.c(TAG, new Object[]{"writeLogToFile file_name = " + str});
        if (arrayList != null && arrayList.size() > 0) {
            C2538c.c(TAG, new Object[]{"writeLogToFile file_name = " + str + " file size = " + arrayList.size()});
            for (int i = 0; i < arrayList.size(); i++) {
                if (DATA_FILE_NAME.equals(str)) {
                    this.mTransferDataContent.add(arrayList.get(i));
                } else if (STATE_FILE_NAME.equals(str)) {
                    this.mTransferStateContent.add(arrayList.get(i));
                }
            }
        }
        if ("".equals(this.fileName) || !this.fileName.equals(str)) {
            C2538c.c(TAG, new Object[]{",+file_name = " + str});
            this.fileName = str;
            initMaintenanceFile();
        }
    }

    public void save2File(IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.c(TAG, new Object[]{"save2File enter............"});
        synchronized (this.lockObject) {
            this.mCallback = iBaseResponseCallback;
            C2538c.c(TAG, new Object[]{"mCallback = " + this.mCallback});
        }
        this.executorService.execute(this.logRunnable);
    }

    private void writeFileToSD(String str, ArrayList<byte[]> arrayList) {
        C2538c.c(TAG, new Object[]{"writeFileToSD() enter......"});
        C2538c.c(TAG, new Object[]{"writeFileToSD() leave build type not debug return......"});
    }

    private String getFileName() {
        String str = "CoreSleep" + HwAccountConstants.SPLIIT_UNDERLINE + this.fileName;
        C2538c.c(TAG, new Object[]{" getFileName()  deviceVersion targetPath " + str});
        return str;
    }

    public void initMaintenanceFile() {
        C2538c.c(TAG, new Object[]{"enter initMaintenanceFile():"});
        String fileName = getFileName();
        C2538c.e(TAG, new Object[]{"filePath = " + fileName});
        if (fileName.contains(DATA_FILE_NAME)) {
            this.mTransferDataContentPath = fileName;
        } else if (fileName.contains(STATE_FILE_NAME)) {
            this.mTransferStateContentPath = fileName;
        }
    }

    private void initCoreSleepDataSaveDir(String str) {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if (str.contains(DATA_FILE_NAME)) {
            this.mDataFilePath = format + HwAccountConstants.SPLIIT_UNDERLINE + str;
        } else if (str.contains(STATE_FILE_NAME)) {
            this.mStateFilePath = format + HwAccountConstants.SPLIIT_UNDERLINE + str;
        }
        C2538c.c(TAG, new Object[]{"initCoreSleepDataSaveDir filePath = " + str + "  mDataFilePath = " + this.mDataFilePath + "  mStateFilePath = " + this.mStateFilePath});
    }

    public void onDestroyMaintenance() {
        C2538c.c(TAG, new Object[]{"onDestroyMaintenance"});
    }

    public void cutFolder(String str, String str2) {
    }

    public DeviceCommand maintParametersCommand() {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(2);
        String str = C0973a.a(6) + C0973a.a(1) + C0973a.a(1);
        deviceCommand.setDataLen(C0973a.b(str).length);
        deviceCommand.setDataContent(C0973a.b(str));
        C2538c.c(TAG, new Object[]{"getMaintenanceParameters  deviceCommand = " + deviceCommand.toString()});
        return deviceCommand;
    }

    public DeviceCommand transferFileEndProcess() {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(6);
        String str = C0973a.a(1) + C0973a.a(1) + C0973a.a(1);
        deviceCommand.setDataLen(C0973a.b(str).length);
        deviceCommand.setDataContent(C0973a.b(str));
        C2538c.c(TAG, new Object[]{"transferFileEndProcess  deviceCommand !!!"});
        return deviceCommand;
    }
}
