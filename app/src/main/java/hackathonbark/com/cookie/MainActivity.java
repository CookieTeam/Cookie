package hackathonbark.com.cookie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.CallbackManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        com.wang.avi.AVLoadingIndicatorView avi = (com.wang.avi.AVLoadingIndicatorView)findViewById(R.id.avi);
//        avi.show();


        // Facebook Login
//        callbackManager = CallbackManager.Factory.create();
//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
//                Log.d("eunchan", "success");
//            }
//
//            @Override
//            public void onCancel() {
//                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG).show();
//                Log.d("eunchan", "cancel");
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                Log.d("eunchan", "error");
//            }
//        });

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnSignUp).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.btnLogin:
                startActivity(new Intent(this, TodayActivity.class));
                break;

            case R.id.btnSignUp:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
        }


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//    }
}
