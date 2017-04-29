package hackathonbark.com.cookie;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static android.content.Context.NOTIFICATION_SERVICE;


public class CookieBroadcaseReceiver extends BroadcastReceiver {
    public CookieBroadcaseReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
//        context.startActivity(new Intent(context, CookieActivity.class));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("title")
                .setContentText("asdfasdfasf");
        PendingIntent i = PendingIntent.getActivity(context, 0, new Intent(context, TodayCookieActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(i);
        NotificationManager manager =  (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }
}
