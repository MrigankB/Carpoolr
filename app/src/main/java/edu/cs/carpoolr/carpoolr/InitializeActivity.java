package edu.cs.carpoolr.carpoolr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Pranav on 5/29/2015.
 */
public class InitializeActivity extends Activity {
    private Firebase mRef;

    private ImageButton mSubmitButton;
    private EditText mNameText;
    private EditText mStartLocationText;
    private EditText mEndLocationText;
    private EditText mStartTime;
    private EditText mEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://glowing-inferno-3968.firebaseio.com/");



        mSubmitButton = (ImageButton) findViewById(R.id.submitButton);
        mNameText = (EditText) findViewById(R.id.nameText);
        mStartLocationText = (EditText) findViewById(R.id.startLocationText);
        mEndLocationText = (EditText) findViewById(R.id.endLocationText);
        mStartTime = (EditText) findViewById(R.id.startTime);
        mEndTime = (EditText) findViewById(R.id.endTime);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.child("hello").setValue("world");

                String carpoolName = generateCarpoolName();


                Firebase thisCarpool = mRef.child(carpoolName);

                EditText[] texts = {mNameText, mStartLocationText, mEndLocationText, mStartTime, mEndTime};

                System.out.println("nameText = "+mNameText.getText());
                thisCarpool.child("Host").setValue(""+mNameText.getText());
                System.out.println("carpoolName = " + carpoolName);

                thisCarpool.child("StartLocation").setValue(""+mStartLocationText.getText());
                thisCarpool.child("EndLocation").setValue(""+mEndLocationText.getText());
                thisCarpool.child("Start Time").setValue(""+mStartTime.getText());
                thisCarpool.child("End Time").setValue(""+mEndTime.getText());

                Toast.makeText(InitializeActivity.this, "Submit successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(InitializeActivity.this, discoverpage.class);
                intent.putExtra(discoverpage.KEY_NAME, carpoolName);
                startActivity(intent);


            }
        });
    }


    String generateCarpoolName (){
        String combined = "Carpool_";
        for (int i=0;i<10;i++){
            combined=combined+""+new Random().nextInt(10);
        }

        return combined;
    }
}
