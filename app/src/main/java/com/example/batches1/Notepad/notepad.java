package com.example.batches1.Notepad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.batches1.R;

import java.util.HashSet;

public class notepad extends AppCompatActivity {
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad);
        EditText editText=(EditText) findViewById(R.id.editText7);
        Intent intent= getIntent();
         noteId = intent.getIntExtra("noteId", -1);
        if(noteId != -1){
            editText.setText(notepad_list.notes.get(noteId));
        }else
        {
            notepad_list.notes.add("");
            noteId= notepad_list.notes.size() -1;
            notepad_list.arrayAdapter.notifyDataSetChanged();
        }
         editText.addTextChangedListener(new TextWatcher() {
           @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                notepad_list.notes.set(noteId, String.valueOf(charSequence));
                notepad_list.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("om.example.batches1", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(notepad_list.notes);
                sharedPreferences.edit().putStringSet("notes",set).apply();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
