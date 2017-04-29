package hackathonbark.com.cookie;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText Edittext_id = (EditText)findViewById(R.id.edittext_id);
        EditText Edittext_pw = (EditText)findViewById(R.id.edittext_pw);
        EditText Edittext_age = (EditText)findViewById(R.id.edittext_age);

        Typeface type  = Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf");
        Edittext_id.setTypeface(type);
        Edittext_pw.setTypeface(type);
        Edittext_age.setTypeface(type);


        findViewById(R.id.btnLogin).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnLogin:
                startActivity(new Intent(this, TodayActivity.class));
                break;
            case R.id.btnSignUpExit:
                finish();
                break;
            case R.id.btnSignUpBack:
                finish();
                break;
        }
    }
}
