package hackathonbark.com.cookie;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BaeSungSin on 2017-04-29.
 */

public class AlarmSettingActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_setting);

        EditText editText_hour = (EditText)findViewById(R.id.editText_hour);
        EditText editText_minute = (EditText)findViewById(R.id.editText_minute);

        Typeface type  = Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf");
        editText_hour.setTypeface(type);
        editText_minute.setTypeface(type);

        findViewById(R.id.btnCheck).setOnClickListener(this);


    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnCheck:
                startActivity(new Intent(this, TodayActivity.class));
                finish();
                break;
        }
    }
}