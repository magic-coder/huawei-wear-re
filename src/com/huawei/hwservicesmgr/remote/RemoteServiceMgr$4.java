package com.huawei.hwservicesmgr.remote;

import android.content.Intent;
import android.os.RemoteException;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p032e.C4399n;
import com.huawei.p190v.C2538c;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class RemoteServiceMgr$4 extends C4399n {
    final /* synthetic */ RemoteServiceMgr this$0;

    RemoteServiceMgr$4(RemoteServiceMgr remoteServiceMgr) {
        this.this$0 = remoteServiceMgr;
    }

    public void requestWearTask(final Map map) throws RemoteException {
        C2538c.c("RemoteServiceMgr", new Object[]{"requestWearTask has been called"});
        C2538c.c("RemoteServiceMgr", new Object[]{"the function name is " + map.get(RemoteServiceMgr.FUNC_NAME)});
        C2538c.c("RemoteServiceMgr", new Object[]{"the parameters are " + map.get(RemoteServiceMgr.PARAMETERS)});
        final String str = (String) map.get(RemoteServiceMgr.PARAMETERS);
        final IParser iParser = (IParser) RemoteServiceMgr.access$1200().get(map.get(RemoteServiceMgr.FUNC_NAME));
        if (iParser == null) {
            Map hashMap = new HashMap();
            hashMap.put("code", "100000");
            hashMap.put("value", map.get(RemoteServiceMgr.FUNC_NAME) + " not found");
            RemoteServiceMgr.access$100().mo4455a(hashMap);
            return;
        }
        if ("syncFitnessDetailData".equals(map.get(RemoteServiceMgr.FUNC_NAME))) {
            C2538c.c("RemoteServiceMgr", new Object[]{"user refresh data in health homePage.Agree to do coreSleep sync."});
            Intent intent = new Intent("com.huawei.bone.action.ACTION_HEALTH_MANUAL_DROP_DO_REFRESH");
            intent.setPackage("com.huawei.bone");
            RemoteServiceMgr.access$1000(this.this$0).sendBroadcast(intent, com.huawei.hwcommonmodel.b.c.a);
        }
        RemoteServiceMgr.access$1400(this.this$0).execute(new Runnable() {
            public void run() {
                Exception e;
                try {
                    if (str == null || str.length() == 0) {
                        C2538c.c("RemoteServiceMgr", new Object[]{"the parser is " + iParser.getClass().getSimpleName()});
                        C2538c.c("RemoteServiceMgr", new Object[]{"the method is " + iParser.getClass().getMethod((String) map.get(RemoteServiceMgr.FUNC_NAME), new Class[]{IBaseResponseCallback.class}).getName()});
                        r0.invoke(iParser, new Object[]{RemoteServiceMgr.access$1300()});
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    iParser.getClass().getMethod((String) map.get(RemoteServiceMgr.FUNC_NAME), new Class[]{jSONObject.getClass(), IBaseResponseCallback.class}).invoke(iParser, new Object[]{jSONObject, RemoteServiceMgr.access$1300()});
                } catch (JSONException e2) {
                    e = e2;
                    C2538c.e("RemoteServiceMgr", new Object[]{"ERROR :" + e.getMessage()});
                } catch (NoSuchMethodException e3) {
                    e = e3;
                    C2538c.e("RemoteServiceMgr", new Object[]{"ERROR :" + e.getMessage()});
                } catch (IllegalAccessException e4) {
                    e = e4;
                    C2538c.e("RemoteServiceMgr", new Object[]{"ERROR :" + e.getMessage()});
                } catch (InvocationTargetException e5) {
                    C2538c.e("RemoteServiceMgr", new Object[]{"Parameter ERROR! " + e5.getTargetException().getMessage()});
                }
            }
        });
    }
}
