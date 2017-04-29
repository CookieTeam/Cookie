package hackathonbark.com.cookie;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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

import static android.content.Context.NOTIFICATION_SERVICE;


public class CookieBroadcaseReceiver extends BroadcastReceiver {
    public CookieBroadcaseReceiver() {
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
    private Intent cookieIntent;
    @Override
    public void onReceive(Context context, Intent intent) {
        cookieIntent = new Intent(context, TodayCookieActivity.class);
        final Context c = context;
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL("https://i0jhkm18rh.execute-api.ap-northeast-2.amazonaws.com/startup/cookie?user_id=cookie");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(con.getInputStream());
                    String res = convertStreamToString(in);

                    JSONObject json = new JSONObject(res);
                    final String weather = json.getJSONObject("result").getString("weather");
                    final String intro = json.getJSONObject("result").getString("intro");
                    final String content = json.getJSONObject("result").getString("content");
                    final String writer = json.getJSONObject("result").getString("writer");
                    final String rurl = json.getJSONObject("result").getString("rurl");
                    final String preview = json.getJSONObject("result").getString("preview");
                    cookieIntent.putExtra("content", content);
                    cookieIntent.putExtra("writer", writer);
                    cookieIntent.putExtra("rurl", rurl);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(c)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("쿠키가 도착했어요")
                            .setContentText(preview);
                    PendingIntent i = PendingIntent.getActivity(c, 0, cookieIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(i);
                    NotificationManager manager =  (NotificationManager)c.getSystemService(NOTIFICATION_SERVICE);
                    manager.notify(1, builder.build());
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
}
