package edu.cs.carpoolr.carpoolr;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Pranav on 6/5/2015.
 */
public class discover extends ListActivity {
    ArrayAdapter<Carpool> arrayAdapter;
    ArrayList<Carpool> carpools;

    public static final String KEY_NAME = "Carpool Name";

    private Firebase mRef;

    String hostName;
    String startTime;
    String endTime;
    String startLocation;
    String endLocation;
    boolean hasChild = true;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discoverpage);
        carpools = new ArrayList<Carpool>();
        Firebase.setAndroidContext(this);
        while (hasChild) {

            mRef = new Firebase("https://glowing-inferno-3968.firebaseio.com/Carpool_" + i);
            //Firebase carpool = mRef.child()
            System.out.println("While loop engaged");
            mRef.child("Host").addValueEventListener(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mRef.child("Start Time").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    //System.out.println(snapshot.getValue());
                    startTime = snapshot.getValue().toString();
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }
            });

            mRef.child("End Time").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    //System.out.println(snapshot.getValue());
                    endTime = snapshot.getValue().toString();
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }
            });

            mRef.child("StartLocation").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    //System.out.println(snapshot.getValue());
                    startLocation = snapshot.getValue().toString();
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }
            });

            mRef.child("EndLocation").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    //System.out.println(snapshot.getValue());
                    endLocation = snapshot.getValue().toString();
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }
            });
            carpools.add(new Carpool(hostName, startLocation, startTime, endTime, endLocation));
            System.out.println("Carpool Added");
            /*mRef = new Firebase("https://glowing-inferno-3968.firebaseio.com");
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    i++;
                    if (dataSnapshot.hasChild("Carpool_" + i) == true) {

                       hasChild = true;
                    }

                    else
                    {
                        hasChild = false;

                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            */
            hasChild = false;
        }

        /*
        setListAdapter(arrayAdapter);
        */
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        /*TextView t = (TextView) v.findViewById(R.id.textView);
        t.setText("Sign up successful");*/
        Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_discoverpage, menu);
        return true;
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
}
