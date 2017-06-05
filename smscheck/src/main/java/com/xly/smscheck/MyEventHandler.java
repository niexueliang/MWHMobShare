package com.xly.smscheck;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by nil on 2016/5/27.
 */
public class MyEventHandler extends EventHandler implements Handler.Callback{


    @Override
    public void afterEvent(int event, int result, Object data) {
        super.afterEvent(event, result, data);
        if (result == SMSSDK.RESULT_COMPLETE) {
            //回调完成
            if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                //提交验证码成功
                Log.e("ttttt","提交验证码成功");
            } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                Log.e("ttttt","获取验证码成功");
                //获取验证码成功
            } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                //key1:zone第一个值是区号  key2:rule第二个值是手机匹配的规则

            }
        }else if(result==SMSSDK.RESULT_ERROR){
            Log.e("ttttt","验证失败");
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }
}
