package hackathonbark.com.cookie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by BaeSungSin on 2017-04-29.
 */

public class FragPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> pages=new ArrayList<>();

    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    //Add pages
    public void addPage(Fragment f)
    {
        pages.add(f);
    }

    //set title for for tab
    public CharSequence getPageTitle(int position){
        return pages.get(position).toString();
    }




}
