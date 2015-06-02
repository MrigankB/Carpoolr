package edu.cs.carpoolr.carpoolr;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Pranav on 5/29/2015.
 */
public class SchedulerFragment extends Fragment
{
    protected ArrayAdapter<String> arrayAdapter;

    public SchedulerFragment()
    {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayAdapter = new CarpoolAdaptor(getActivity(), new String[5]);
    }


    public static SchedulerFragment NewInstance()
    {
        SchedulerFragment frag = new SchedulerFragment();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_schedulrpage, container, false);

        ListView list = (ListView) rootView.findViewById(R.id.schedule_list);
        list.setAdapter(arrayAdapter);

        return rootView;
    }
}
