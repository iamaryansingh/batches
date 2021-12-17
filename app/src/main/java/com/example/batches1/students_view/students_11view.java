package com.example.batches1.students_view;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.batches1.R;
import com.example.batches1.ThreeColoumnListAdapter;
import com.example.batches1.User;
import com.example.batches1.database.DatabaseHelper2;

import java.util.ArrayList;

public class students_11view extends AppCompatActivity {
    DatabaseHelper2 mydb;
    ArrayList<User> userList;
    ListView listView;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_12view);
        mydb= new DatabaseHelper2(this);
        userList=new ArrayList<>();
        Cursor data=mydb.getListContents();
        int numRows= data.getCount();
        if(numRows==0){
            Toast.makeText(students_11view.this, "nothing in this db", Toast.LENGTH_LONG).show();
        }
        else {
            while (data.moveToNext()){
                user=new User(data.getString(0),data.getString(1),data.getString(2));
                userList.add(user);

            }
            ThreeColoumnListAdapter adapter= new ThreeColoumnListAdapter(this,R.layout.adapter,userList);
            listView=(ListView) findViewById(R.id.newlistview);
            listView.setAdapter(adapter);
        }
    }
}


