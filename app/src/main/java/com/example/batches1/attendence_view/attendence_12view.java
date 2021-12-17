package com.example.batches1.attendence_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.batches1.R;
import com.example.batches1.database.DatabaseHelper;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class attendence_12view extends AppCompatActivity {
    DatabaseHelper mydb;
    //EditText date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_12view);

        final ListView listView = (ListView) findViewById(R.id.newlistview);
        mydb = new DatabaseHelper(this);
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d");
        final String newdate =sdf.format(new Date());

        final ArrayList<String> thelist = new ArrayList<>();
        final Cursor data = mydb.getListContents();


        if (data.getCount() == 0) {
            Toast.makeText(attendence_12view.this, "empty data base", Toast.LENGTH_LONG ).show();
        } else {

            while (data.moveToNext()) {
                thelist.add(data.getString(1));


                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String newval=newdate;


                String name=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(attendence_12view.this, "present", Toast.LENGTH_LONG).show();

                mydb.getone(name,newval);


            }


        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String newval=newdate;

                String name=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(attendence_12view.this, "absent", Toast.LENGTH_LONG).show();

                mydb.gettwo(name,newval);
                return true;
            }
        });

    }
}


