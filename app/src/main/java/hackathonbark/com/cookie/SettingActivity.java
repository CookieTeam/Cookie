package hackathonbark.com.cookie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BaeSungSin on 2017-04-29.
 */

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        EditText editText1 = (EditText) findViewById(R.id.editText) ;

        findViewById(R.id.btnBack).setOnClickListener(this);

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnBack:
                startActivity(new Intent(this, TodayActivity.class));
                break;
//
//            case R.id.btnCookie:
//                startActivity(new Intent(this, TodayCookieActivity.class));
//                break;
        }
    }

}
