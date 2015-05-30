package edu.cs.carpoolr.carpoolr;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;


/**
 * Created by Pranav on 5/29/2015.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public int getCount()
    {
        return 2;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return MainActivity.PlaceholderFragment.NewInstance();
            case 1:
                return SchedulerFragment.NewInstance();
            default:
                return MainActivity.PlaceholderFragment.NewInstance();
        }
    }
}
