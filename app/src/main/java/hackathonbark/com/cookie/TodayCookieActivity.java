package hackathonbark.com.cookie;

import android.os.Bundle;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by BaeSungSin on 2017-04-29.
 */

public class TodayCookieActivity extends AppCompatActivity implements View.OnClickListener{

    String rurl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_cookie);

        TextView tv = (TextView)findViewById(R.id.textViewCookie);
        tv.setText(getIntent().getStringExtra("content") + "\n\n" + getIntent().getStringExtra("writer"));
        rurl = getIntent().getStringExtra("rurl");

        Typeface type = Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf");
        ((TextView)findViewById(R.id.textViewCookie)).setTypeface(type);

        findViewById(R.id.textViewCookie).setOnClickListener(this);
        findViewById(R.id.btnTodayCookieBack).setOnClickListener(this);
        findViewById(R.id.btnTodayCookiePlay).setOnClickListener(this);

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnTodayCookiePlay:
                MediaPlayer player = new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    player.setDataSource(rurl);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.textViewCookie:
                Dialog dialog = new Dialog(TodayCookieActivity.this, R.style.Theme_AppCompat_Light_NoActionBar_FullScreen);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                dialog.setContentView(R.layout.dialog_today_cookie);
                dialog.setCancelable(true);
                dialog.show();
                break;
            case R.id.btnTodayCookieBack:
                finish();
                break;
        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
