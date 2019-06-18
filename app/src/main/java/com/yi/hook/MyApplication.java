package com.yi.hook;

import android.app.Application;

import com.yi.hook.activity.ProxyActivity;
import com.yi.hook.utils.HookUtil;

/**
 * Created by yis on 2018/5/7.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //这个ProxyActivity在清单文件中注册过，以后所有的Activity都可以用ProxyActivity无需声明，绕过监测
        HookUtil hookAmsUtil = new HookUtil(ProxyActivity.class, this);
        hookAmsUtil.hookSystemHandler();
        hookAmsUtil.hookAms();//hook 继承Activity情况下的子类
        hookAmsUtil.onHookIPackageManager();//hook 继承AppCompatActivity情况下的子类
    }
}
