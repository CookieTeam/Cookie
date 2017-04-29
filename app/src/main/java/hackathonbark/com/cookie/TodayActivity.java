package hackathonbark.com.cookie;

import android.content.Intent;
import android.graphics.Typeface;
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

public class TodayActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent cookieIntent;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        cookieIntent = new Intent(TodayActivity.this, TodayCookieActivity.class);
        if (getIntent().getStringExtra("weahter") == null) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    URL url = null;
                    try {
                        url = new URL("https://i0jhkm18rh.execute-api.ap-northeast-2.amazonaws.com/startup/cookie?user_id=cookie");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        InputStream in = new BufferedInputStream(con.getInputStream());
                        String res = convertStreamToString(in);
                        Log.d("eunchan", res);
                        JSONObject json = new JSONObject(res);
                        final String weather = json.getJSONObject("result").getString("weather");
                        final String intro = json.getJSONObject("result").getString("intro");
                        final String content = json.getJSONObject("result").getString("content");
                        final String writer = json.getJSONObject("result").getString("writer");
                        final String rurl = json.getJSONObject("result").getString("rurl");
                        cookieIntent.putExtra("content", content);
                        cookieIntent.putExtra("writer", writer);
                        cookieIntent.putExtra("rurl", rurl);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView4 = (TextView) findViewById(R.id.textView4);
                                TextView textView5 = (TextView) findViewById(R.id.textView5);
                                textView4.setText(weather);
                                textView5.setText(intro);
                            }
                        });
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            String weather = getIntent().getStringExtra("weather");
            String intro = getIntent().getStringExtra("intro");
            String content = getIntent().getStringExtra("content");
            String writer = getIntent().getStringExtra("writer");
            String rurl = getIntent().getStringExtra("rurl");
        }

        findViewById(R.id.btnCookie).setOnClickListener(this);
        Typeface type = Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf");
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setTypeface(type);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setTypeface(type);
        findViewById(R.id.btnTodayExit).setOnClickListener(this);
        findViewById(R.id.btnTodayInbox).setOnClickListener(this);
        findViewById(R.id.btnTodaySetting).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTodayExit:
                finish();
                break;

            case R.id.btnTodayInbox:
                startActivity(new Intent(this, InboxActivity.class));
                break;

            case R.id.btnCookie:
                startActivity(cookieIntent);
                break;
            case R.id.btnTodaySetting:
                startActivity(new Intent(this, TypeSettingActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}
