package hackathonbark.com.cookie;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Animation animAlpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
        animAlpha.reset();
        Animation animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        animBounce.reset();
        Animation animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        animBlink.reset();
        Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animZoomIn.reset();
        Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        animZoomOut.reset();
        Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        animSlideDown.reset();
        Animation animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animSlideUp.reset();

        animAlpha.setFillAfter(false);
        findViewById(R.id.imgSplashCookie1).startAnimation(animAlpha);
        findViewById(R.id.imgSplashCookie2).startAnimation(animAlpha);
        findViewById(R.id.imgSplashTitle).startAnimation(animAlpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                anim.reset();
                anim.setFillAfter(true);
                findViewById(R.id.imgSplashLogo).startAnimation(anim);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        }, 5000);
    }
}
