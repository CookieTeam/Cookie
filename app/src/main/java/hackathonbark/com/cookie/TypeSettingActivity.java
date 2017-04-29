package hackathonbark.com.cookie;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;

import java.util.ArrayList;

public class TypeSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_setting);

        final String[] titles = getResources().getStringArray(R.array.countries);
        final TypedArray colors = getResources().obtainTypedArray(R.array.colors);
//        final TypedArray images = getResources().obtainTypedArray(R.array.images);

        com.igalata.bubblepicker.rendering.BubblePicker picker =
                (com.igalata.bubblepicker.rendering.BubblePicker)findViewById(R.id.picker);
        picker.setItems(new ArrayList<PickerItem>() {{
            for (int i = 0; i < titles.length; ++i) {
//                add(new PickerItem(titles[i], colors.getColor((i * 2) % 8, 0),
//                        ContextCompat.getColor(TypeSettingActivity.this, android.R.color.white),
//                        ContextCompat.getDrawable(TypeSettingActivity.this, images.getResourceId(i, 0))));
                add(new PickerItem(titles[i], ContextCompat.getDrawable(TypeSettingActivity.this, R.drawable.i), true,
                        colors.getColor((i * 2) % 8, 0), new BubbleGradient(), 0.1f,
                        Typeface.createFromAsset(getAssets(), "DXPnMStd-Regular.otf"), getResources().getColor(R.color.white, null), 80f,
                        ContextCompat.getDrawable(TypeSettingActivity.this, R.drawable.transparent)));
            }
        }});

    }
}
