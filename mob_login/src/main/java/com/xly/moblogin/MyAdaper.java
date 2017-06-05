package com.xly.moblogin;

import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.AuthorizeAdapter;

/**
 * 用于修改授权页面
 * Created by nil on 2016/5/26.
 */
public class MyAdaper extends AuthorizeAdapter {
    @Override
    public void onCreate() {
        super.onCreate();
        TitleLayout titleLayout=getTitleLayout();
        titleLayout.getTvTitle().setText("行踪速查");
        //隐藏logo
        hideShareSDKLogo();
        //隐藏分割线
//        titleLayout.getChildAt(1).setVisibility(View.GONE);
    }
}
