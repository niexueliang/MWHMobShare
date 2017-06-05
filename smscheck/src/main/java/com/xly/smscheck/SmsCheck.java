package com.xly.smscheck;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by nil on 2016/5/27.
 */
public class SmsCheck {
    Context context;
    MyEventHandler myEventHandler;
    public SmsCheck(Context context) {
        this.context=context;
    }
    public void smsGUICheck() {
        //mob 的appkey  appsercret
        SMSSDK.initSDK(context, "133a291f8b828", "7134ae695cc545e1460ef6fb60fa2b18");
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    Log.e("ttttt",phoneMap.toString());
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    // 提交用户信息
                    Toast.makeText(context,"country:"+country+"---"+"phone:"+phone,Toast.LENGTH_SHORT).show();
                    Log.e("ttttt","country:"+country+"---"+"phone:"+phone);
                }
            }
        });
        registerPage.show(context);
    }
    //无GUI集成 可以给予短信界面的自定义
    public void smsCheck() {
        SMSSDK.initSDK(context, "133a291f8b828", "7134ae695cc545e1460ef6fb60fa2b18");
        myEventHandler=new MyEventHandler();
        SMSSDK.registerEventHandler(myEventHandler);
        //中国的编号是42
//        SMSSDK.getVerificationCode("86","15378183400");
        SMSSDK.submitVerificationCode("86","15378183400","5597");
    }



    public void unRegisterEventHandler(){
        if(myEventHandler!=null){
            SMSSDK.unregisterEventHandler(myEventHandler);
        }
    }
}
