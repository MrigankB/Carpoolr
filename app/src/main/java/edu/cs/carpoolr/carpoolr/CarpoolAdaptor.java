package edu.cs.carpoolr.carpoolr;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Pranav on 5/27/2015.
 */
public class CarpoolAdaptor extends ArrayAdapter
{
    private LayoutInflater inflater;

    public CarpoolAdaptor(Activity activity, Carpool[] items)
    {
        super(activity, R.layout.discoveritem, items);
        inflater = activity.getWindow().getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return inflater.inflate(R.layout.discoveritem, parent, false);
    }

}
