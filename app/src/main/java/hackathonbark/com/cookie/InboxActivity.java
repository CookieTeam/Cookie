package hackathonbark.com.cookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InboxActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        findViewById(R.id.btnInboxBack).setOnClickListener(this);
        findViewById(R.id.btnInboxExit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnInboxBack:
            case R.id.btnInboxExit:
                finish();
                break;
        }
    }
}
