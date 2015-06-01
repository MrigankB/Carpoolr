package edu.cs.carpoolr.carpoolr;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.List;


public class discoverpage extends ListActivity {

    ArrayAdapter<String> arrayAdapter;
    Carpool[] carpools;

    public static final String KEY_NAME = "Carpool Name";

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discoverpage);

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://glowing-inferno-3968.firebaseio.com/");
        //Firebase carpool = mRef.child()

        for(int i = 0; i < 1; i++)
        {

            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    System.out.println(""+dataSnapshot.getValue());
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {}
            });
        }
        //arrayAdapter = new CarpoolAdaptor(this, );

        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
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
