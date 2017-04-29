package hackathonbark.com.cookie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;

import java.util.ArrayList;

public class TypeSettingActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_setting);

        final String[] titles = getResources().getStringArray(R.array.countries);
//        final TypedArray colors = getResources().obtainTypedArray(R.array.colors);
//        final TypedArray images = getResources().obtainTypedArray(R.array.images);
        final BubbleGradient bg1 = new BubbleGradient(ContextCompat.getColor(TypeSettingActivity.this, R.color.bg1s),
                ContextCompat.getColor(TypeSettingActivity.this, R.color.bg1e));
        final BubbleGradient bg2 = new BubbleGradient(ContextCompat.getColor(TypeSettingActivity.this, R.color.bg2s),
                ContextCompat.getColor(TypeSettingActivity.this, R.color.bg2e));
        final BubbleGradient bg3 = new BubbleGradient(ContextCompat.getColor(TypeSettingActivity.this, R.color.bg3s),
                ContextCompat.getColor(TypeSettingActivity.this, R.color.bg3e));
        final BubbleGradient bg4 = new BubbleGradient(ContextCompat.getColor(TypeSettingActivity.this, R.color.bg4s),
                ContextCompat.getColor(TypeSettingActivity.this, R.color.bg4e));
        final BubbleGradient bg5 = new BubbleGradient(ContextCompat.getColor(TypeSettingActivity.this, R.color.bg5s),
                ContextCompat.getColor(TypeSettingActivity.this, R.color.bg5e));

        com.igalata.bubblepicker.rendering.BubblePicker picker =
                (com.igalata.bubblepicker.rendering.BubblePicker)findViewById(R.id.picker);
        picker.setItems(new ArrayList<PickerItem>() {{
            for (int i = 0; i < titles.length; ++i) {
                if( i < 4 ) {
                    add(new PickerItem(titles[i], ContextCompat.getDrawable(TypeSettingActivity.this, R.drawable.i), true,
                            ContextCompat.getColor(TypeSettingActivity.this, R.color.bg1s), bg1, 0.1f,
                            Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf"), getResources().getColor(R.color.white, null), 73f
                            ));
                } else if (i < 6 ) {
                    add(new PickerItem(titles[i], ContextCompat.getDrawable(TypeSettingActivity.this, R.drawable.i), true,
                            ContextCompat.getColor(TypeSettingActivity.this, R.color.bg2s), bg2, 0.1f,
                            Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf"), getResources().getColor(R.color.white, null), 73f
                            ));
                } else if (i < 8 ) {
                    add(new PickerItem(titles[i], ContextCompat.getDrawable(TypeSettingActivity.this, R.drawable.i), true,
                            ContextCompat.getColor(TypeSettingActivity.this, R.color.bg3s), bg3, 0.1f,
                            Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf"), getResources().getColor(R.color.white, null), 73f
                            ));
                } else if ( i < 9 ) {
                    add(new PickerItem(titles[i], ContextCompat.getDrawable(TypeSettingActivity.this, R.drawable.i), true,
                            ContextCompat.getColor(TypeSettingActivity.this, R.color.bg4s), bg4, 0.1f,
                            Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf"), getResources().getColor(R.color.white, null), 73f
                            ));
                } else {
                    add(new PickerItem(titles[i], ContextCompat.getDrawable(TypeSettingActivity.this, R.drawable.i), true,
                            ContextCompat.getColor(TypeSettingActivity.this, R.color.bg5s), bg5, 0.1f,
                            Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf"), getResources().getColor(R.color.white, null), 73f
                            ));
                }
            }
        }});

        findViewById(R.id.btnTypeBack).setOnClickListener(this);
        findViewById(R.id.btnTypeExit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnTypeExit:
                startActivity(new Intent(this, AlarmSettingActivity.class));
                finish();
                break;
            case R.id.btnTypeBack:
                finish();
                break;

        }
    }
}
