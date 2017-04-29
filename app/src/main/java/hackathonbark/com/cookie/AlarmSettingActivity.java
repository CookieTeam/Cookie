package hackathonbark.com.cookie;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

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
//                startActivity(new Intent(this, TodayActivity.class));
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                EditText hourEditText = (EditText) findViewById(R.id.editText_hour);
                EditText minEditText = (EditText) findViewById(R.id.editText_minute);
                int hour = Integer.parseInt(hourEditText.getText().toString());
                int min = Integer.parseInt(minEditText.getText().toString());

                Intent intent = new Intent(getApplicationContext(), CookieBroadcaseReceiver.class);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, min);
                calendar.set(Calendar.SECOND, 0);

                alarmManager.setExact(AlarmManager.RTC, calendar.getTimeInMillis(), alarmIntent);
                Toast.makeText(this, "설정되었습니다", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}