package hackathonbark.com.cookie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class CookieBroadcaseReceiver extends BroadcastReceiver {
    public CookieBroadcaseReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startActivity(new Intent(context, CookieActivity.class));
    }
}
