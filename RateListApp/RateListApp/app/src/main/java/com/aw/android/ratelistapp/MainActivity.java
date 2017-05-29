package com.aw.android.ratelistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.google.android.gms.samples.vision.barcodereader.BarcodeActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        final Button button1 = (Button) findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent in = new Intent(getApplicationContext(),
                        all_items_activity.class);
                    startActivity(in);
                }
            });
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,
                        search_item_activity.class);
                startActivity(in);
            }
        });
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Barcode ki activity yahan se launch hgi
                Intent in = new Intent(MainActivity.this,
                        BarcodeActivity.class);
                startActivity(in);
            }
        });
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,
                        feedback_activity.class);
                startActivity(in);
            }
        });
        }


    private void writeNewitem(String id,String name,String price,DatabaseReference mDatabase) {
        com.aw.android.ratelistapp.model.item it = new com.aw.android.ratelistapp.model.item(id,name, price);
        mDatabase.child("items").child(id).setValue(it);

    }
}
