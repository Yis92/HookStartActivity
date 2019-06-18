//package com.yi.hook.utils;
//
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//
///**
// * Created by yis on 2018/5/7.
// */
//
//public class AmsInvocationHandler implements InvocationHandler {
//
//    private Context context;
//
//    private Object iActivityManagerObject;
//
//    private Class<?> proxyActivity;
//
//    public AmsInvocationHandler(Context context, Object iActivityManagerObject, Class<?> proxyActivity) {
//        this.context = context;
//        this.iActivityManagerObject = iActivityManagerObject;
//        this.proxyActivity = proxyActivity;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//        Log.i("qqq","3333");
//
//        if ("startActivity".contains(method.getName())) {
//            //换掉
//            Intent intent = null;
//            int index = 0;
//            for (int i = 0; i < args.length; i++) {
//                Object arg = args[i];
//                if (arg instanceof Intent) {
//                    //说明找到了startActivity的Intent参数
//                    intent = (Intent) args[i];
//                    //这个意图是不能被启动的，因为Acitivity没有在清单文件中注册
//                    index = i;
//                }
//            }
//
//            //伪造一个代理的Intent，代理Intent启动的是proxyActivity
//            Intent proxyIntent = new Intent();
//            ComponentName componentName = new ComponentName(context, proxyActivity);
//            proxyIntent.setComponent(componentName);
//            proxyIntent.putExtra("oldIntent", intent);
//            args[index] = proxyIntent;
//        }
//
//        return method.invoke(iActivityManagerObject, args);
//    }
//}
//
//
