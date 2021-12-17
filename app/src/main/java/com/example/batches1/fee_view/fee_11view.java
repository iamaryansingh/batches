package com.example.batches1.fee_view;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

//import com.example.batches1.database.DatabaseHelper7;
import com.example.batches1.R;
import com.example.batches1.database.DatabaseHelper2;




import java.util.ArrayList;

public class fee_11view extends AppCompatActivity {
    DatabaseHelper2 mydb2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_12view);
        Intent intent = getIntent();
        String da=intent.getStringExtra("DATETOPAY");
        ListView listView = (ListView) findViewById(R.id.newlistview);
        mydb2 = new DatabaseHelper2(this);




        final ArrayList<String> thelist = new ArrayList<>();
        Cursor dataNEW = mydb2.getListContentstwo(da);

        if(dataNEW.getCount()==0){
            Toast.makeText(fee_11view.this, "empty data base", Toast.LENGTH_SHORT).show();
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

