package edu.cs.carpoolr.carpoolr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageButton;

import com.firebase.client.Firebase;


public class MainActivity extends ActionBarActivity {

    FragmentPagerAdapter mPagerAdapter;

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        getSupportActionBar().hide();

        mPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment NewInstance()
        {
            PlaceholderFragment f = new PlaceholderFragment();
            return f;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ImageButton initialize = (ImageButton) rootView.findViewById(R.id.imageButton);

            initialize.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    startActivity( new Intent(getActivity(),InitializeActivity.class) );
                }
            });

            ImageButton discover = (ImageButton) rootView.findViewById(R.id.imageButton2);

            discover.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View k) {
                    startActivity( new Intent("CarpoolrCSProject.discoverpage") );
                }
            });

            return rootView;
        }
    }
}
