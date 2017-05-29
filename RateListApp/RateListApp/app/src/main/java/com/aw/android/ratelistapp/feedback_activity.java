package com.aw.android.ratelistapp;

/**
 * Created by Taha-PC on 5/28/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aw.android.ratelistapp.model.feedback;
import com.aw.android.ratelistapp.model.item;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class feedback_activity extends Activity {
    TextView statusview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        statusview = (TextView) findViewById(R.id.statustext);
        final Button postbtn = (Button) findViewById(R.id.postcomplaint);
        final EditText complainttext = (EditText)findViewById(R.id.complaintfield);
        final EditText shopnametext = (EditText)findViewById(R.id.shopnamefield);
        final EditText usernametext = (EditText)findViewById(R.id.usernamefield);

        postbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               postcomp(complainttext.getText().toString(), shopnametext.getText().toString(), usernametext.getText().toString());
            }
     });

    }
    public void postcomp(final String complaint,final String shopname,final String username){
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        ValueEventListener listener = new ValueEventListener() {
            boolean one = false;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!one) {
                    dataSnapshot = dataSnapshot.child("complaints");
                    int i = 1;
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        i++;
                    }
                    mDatabase.child("complaints").child(Integer.toString(i)).setValue(new feedback(complaint, shopname, username));
                    statusview.setText("Posted Successfully");
                    one = true;
                    finish();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println(databaseError.toException());
                statusview.setText("Post Unsuccessful");
                // ...
            }
        };
        mDatabase.addValueEventListener(listener);

    }

}

