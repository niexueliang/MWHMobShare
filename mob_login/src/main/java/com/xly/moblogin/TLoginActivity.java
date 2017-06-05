package com.xly.moblogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;


/**
 * Created by nil on 2016/5/27.
 */
public class TLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Platform platform;
    private TLogin tLogin;
    private CardView qqLogin;
    private CardView weiboLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_login);
        tLogin = new TLogin(getApplicationContext());
        qqLogin = (CardView) findViewById(R.id.QQ_Login);
        weiboLogin = (CardView) findViewById(R.id.Weibo_Login);
        qqLogin.setOnClickListener(this);
        weiboLogin.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        ShareSDK.initSDK(this);
        if (v.getId() == R.id.QQ_Login) {
            platform = ShareSDK.getPlatform(QZone.NAME);
            tLogin.authorize(platform);
        } else if (v.getId() == R.id.Weibo_Login) {
            platform = ShareSDK.getPlatform(SinaWeibo.NAME);
            tLogin.authorize(platform);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (platform != null) {
            platform.removeAccount();
        }
    }
}
