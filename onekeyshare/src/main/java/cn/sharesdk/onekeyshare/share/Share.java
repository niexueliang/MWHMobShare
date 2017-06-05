package cn.sharesdk.onekeyshare.share;
import android.content.Context;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.R;

/**
 * Created by nil on 2016/5/27.
 */
public class Share {
    Context context;

    public Share(Context context) {
        this.context = context;
    }

    public void showShare() {
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitle(context.getString(R.string.share_title));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(context.getString(R.string.share_title_url));
        // text是分享文本，所有平台都需要这个字段
        oks.setText(context.getString(R.string.share_title_text));
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(context.getString(R.string.share_url));
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(context.getString(R.string.share_comment));
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(context.getString(R.string.share_site));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(context.getString(R.string.share_site_url));
        oks.show(context);
    }
}
