package hackathonbark.com.cookie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BaeSungSin on 2017-04-29.
 */

public class SettingActivity extends AppCompatActivity implements View.OnClickListener, Setting1.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ViewPager vp = (ViewPager)findViewById(R.id.vp);
        vp.setAdapter(new PAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
    }

    public void onClick(View v) {
        switch(v.getId()) {
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class PAdapter extends FragmentStatePagerAdapter
    {

        public PAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position)
            {
                case 0:
                    return new Setting1();
                case 1:
                    return new Setting2();
                case 2:
                    return new Setting3();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
