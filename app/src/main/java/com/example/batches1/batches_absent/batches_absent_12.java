package com.example.batches1.batches_absent;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.batches1.R;
import com.example.batches1.database.DatabaseHelper;




import java.util.ArrayList;

public class batches_absent_12 extends AppCompatActivity {
    DatabaseHelper mydb2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_12view);
        Intent intent = getIntent();
        String name=intent.getStringExtra("NAME");
        String da=intent.getStringExtra("DATE");

        ListView listView = (ListView) findViewById(R.id.newlistview);

        mydb2 = new DatabaseHelper(this);




        final ArrayList<String> thelist = new ArrayList<>();


        Cursor dataNEW = mydb2.absent(name,da);

        if(dataNEW.getCount()==0){
            Toast.makeText(batches_absent_12.this, "empty data base", Toast.LENGTH_LONG).show();
        }
        else {

            while (dataNEW.moveToNext()) {
                thelist.add(dataNEW.getString(0));

                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
            }
        }


    }
}

