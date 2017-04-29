package hackathonbark.com.cookie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by BaeSungSin on 2017-04-29.
 */

public class TodayActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);


        findViewById(R.id.btnSetting).setOnClickListener(this);
        findViewById(R.id.btnCookie).setOnClickListener(this);

    }
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSetting:
//                startActivity(new Intent(this, TypeSettingActivity.class));
                startActivity(new Intent(this, AlarmSettingActivity.class));
                break;


            case R.id.btnCookie:
                startActivity(new Intent(this, TodayCookieActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}
