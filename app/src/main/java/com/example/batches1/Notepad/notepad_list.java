package com.example.batches1.Notepad;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.batches1.R;

import java.util.ArrayList;
import java.util.HashSet;

public class notepad_list extends AppCompatActivity {
    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.add_note,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
         if (item.getItemId()==R.id.add_note){
             Intent intent=new Intent(getApplicationContext(),notepad.class);
             startActivity(intent);
             return true;
         }
         return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepadlist);

        ListView listView=(ListView) findViewById(R.id.listview);

        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("om.example.batches1", Context.MODE_PRIVATE);

        HashSet<String> set= (HashSet<String>)sharedPreferences.getStringSet("notes",null);
        if(set ==null) {

            notes.add("please enter here");
        }
        else{
            notes=new ArrayList(set);
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,notes);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),notepad.class);
                intent.putExtra("noteId",i);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemToDeletet=i;
                new AlertDialog.Builder(notepad_list.this)

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                notes.remove(itemToDeletet);

                                arrayAdapter.notifyDataSetChanged();

                                SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("om.example.batches1", Context.MODE_PRIVATE);

                                HashSet<String> set = new HashSet(notepad_list.notes);

                                sharedPreferences.edit().putStringSet("notes",set).apply();
                            }
                        }
                        )
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }

        });
    }
}
