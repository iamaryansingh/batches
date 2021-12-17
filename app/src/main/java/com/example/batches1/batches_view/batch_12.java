package com.example.batches1.batches_view;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.batches1.R;
import com.example.batches1.ThreeColoumnListAdapter;
import com.example.batches1.User;
import com.example.batches1.database.DatabaseHelper;

import java.util.ArrayList;

public class batch_12 extends AppCompatActivity {
    DatabaseHelper mydb;
    ArrayList<User> userList;
    ListView listView;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_12view);
        mydb= new DatabaseHelper(this);
        userList=new ArrayList<>();
        Cursor data=mydb.getListContentsfour();
        int numRows= data.getCount();
        if(numRows==0){
            Toast.makeText(batch_12.this, "nothing in this db", Toast.LENGTH_LONG).show();
        }
        else {
            while (data.moveToNext()){
                user=new User(data.getString(1),data.getString(0),data.getString(2));
                userList.add(user);

            }
            ThreeColoumnListAdapter adapter= new ThreeColoumnListAdapter(this,R.layout.adapter,userList);
            listView=(ListView) findViewById(R.id.newlistview);
            listView.setAdapter(adapter);
        }
    }
}


