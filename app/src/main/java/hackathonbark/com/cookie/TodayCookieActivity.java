package hackathonbark.com.cookie;

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

public class TodayCookieActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_cookie);

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL("https://i0jhkm18rh.execute-api.ap-northeast-2.amazonaws.com/startup/cookie?user_id=1");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(con.getInputStream());
                    String res = convertStreamToString(in);
                    Log.d("eunchan", res);

                    JSONObject json = new JSONObject(res);
                    final String str = json.getJSONObject("result").getString("memo");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView textView = (TextView) findViewById(R.id.textViewCookie);
//                            Toast.makeText(TodayCookieActivity.this, str, Toast.LENGTH_SHORT).show();

                            Typeface type  = Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf");
                            textView.setTypeface(type);
//                            textView.setText(str);

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
    }

    public void onClick(View v) {
        switch(v.getId()) {
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
