package edu.cs.carpoolr.carpoolr;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Pranav on 5/29/2015.
 */
public class SchedulerFragment extends Fragment
{
    public SchedulerFragment()
    {}

    public static SchedulerFragment NewInstance()
    {
        SchedulerFragment frag = new SchedulerFragment();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_schedulrpage, container, false);

        return rootView;
    }
}
