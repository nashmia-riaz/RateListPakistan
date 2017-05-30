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

import com.aw.android.ratelistapp.model.item;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class search_item_activity extends Activity {
    private String searchString;
    ArrayList<item> itemsList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        itemsList = new ArrayList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_item);
        final Button searchbtn = (Button) findViewById(R.id.searchbutton);
        final EditText searchname  = (EditText)findViewById(R.id.itemnamefield);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                searchbyname(searchname.getText().toString());
            }
     });


        // Capture the layout's TextView and set the string as its text
//        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText(message);
        Intent intent = getIntent();

        if(intent.getStringExtra(BarcodeActivity.EXTRA_MESSAGE) != null){

            String message = intent.getStringExtra(BarcodeActivity.EXTRA_MESSAGE);

            searchbyname(message);
        }
    }
    public void searchbyname(final String name){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView nview = (TextView)findViewById(R.id.searchedname);
                TextView idview = (TextView)findViewById(R.id.searchedid);
                TextView rview = (TextView)findViewById(R.id.searchedrate);
                dataSnapshot = dataSnapshot.child("items");
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    item post = postSnapshot.getValue(item.class);
                    if(post.getName().toLowerCase().contains(name.toLowerCase())){
                        nview.setText("Name: " + post.getName());
                        idview.setText("ID: "+post.getId());
                        rview.setText("Price: "+post.getRate());
                        break;
                    }
                    else{
                        nview.setText("Item with name: "+name);
                        idview.setText("Not Found");
                        rview.setText("Enter Again");
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println(databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(listener);

    }

}
