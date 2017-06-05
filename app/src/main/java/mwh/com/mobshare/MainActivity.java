package mwh.com.mobshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.xly.moblogin.TLoginActivity;
import com.xly.smscheck.SmsCheck;
import cn.sharesdk.onekeyshare.share.Share;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_mob_share;
    private Button bt_login;
    private Button bt_sms_check;
    private SmsCheck smsCheck;
    private Share share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsCheck = new SmsCheck(getApplicationContext());
        share = new Share(getApplicationContext());
        bt_mob_share = (Button) findViewById(R.id.bt_mob_share);
        bt_login = (Button) findViewById(R.id.bt_other_login);
        bt_sms_check = (Button) findViewById(R.id.bt_sms_check);
        //设置监听
        bt_login.setOnClickListener(this);
        bt_mob_share.setOnClickListener(this);
        bt_sms_check.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_mob_share:
                share.showShare();
                break;
            case R.id.bt_other_login:
                Intent intent = new Intent(this, TLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_sms_check:
                smsCheck.smsCheck();
                smsCheck.smsGUICheck();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
