package com.xly.moblogin;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.mob.tools.utils.UIHandler;
import com.xly.moblogin.enity.UserInfo;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;


/**
 * Created by nil on 2016/5/27.
 */
public class TLogin implements PlatformActionListener, Handler.Callback {
    Context context;

    public TLogin(Context context) {
        this.context = context;
    }

    //监听
    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        PlatformDb pdb = platform.getDb();
        login(new UserInfo(pdb.getToken(), pdb.getExpiresIn() + "", pdb.getUserId(), pdb.getUserName()));
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        UIHandler.sendEmptyMessage(2, this);
    }

    @Override
    public void onCancel(Platform platform, int i) {
        UIHandler.sendEmptyMessage(3, this);
    }

    //handler回调
    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {

            case 1: {
                String data = msg.obj.toString() + "";
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                Log.e("ttttt", data);
            }
            break;
            case 2: {
                Toast.makeText(context, "登陆失败", Toast.LENGTH_SHORT).show();
                Log.e("ttttt", "登陆失败");
            }
            break;
            case 3: {
                Toast.makeText(context, "取消授权", Toast.LENGTH_SHORT).show();
                Log.e("ttttt", "取消授权");
            }
            break;
        }
        return false;
    }

    //授权
    public void authorize(Platform plat) {
        if (plat.isValid()) {
            PlatformDb pdb = plat.getDb();
            String userId = pdb.getUserId();
            if (!TextUtils.isEmpty(userId)) {
                login(new UserInfo(pdb.getToken(), pdb.getExpiresIn() + "", pdb.getUserId(), pdb.getUserName()));
                return;
            }
        }
        //若本地没有授权过就请求用户数据
        plat.setPlatformActionListener(this);//
        plat.SSOSetting(false);//此处设置为false，则在优先采用客户端授权的方法，设置true会采用网页方式
        plat.showUser(null);//获得用户数据
    }

    //登录接口
    private void login(UserInfo info) {
        Message msg = new Message();
        msg.what = 1;
        msg.obj = info;
        UIHandler.sendMessage(msg, this);
    }
}
