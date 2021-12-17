
package com.example.batches1.students_add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.batches1.R;
import com.example.batches1.database.DatabaseHelper6;
import com.example.batches1.students_view.student_mix2view;


public class Main11Activity extends AppCompatActivity {
    EditText myname,phoneno;
    Button add,delete,modify,viewall;
    DatabaseHelper6 mydbsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_class12);
        add=(Button)findViewById(R.id.Add);
        delete=(Button)findViewById(R.id.Del);
        viewall=(Button)findViewById(R.id.Via);
        modify=(Button)findViewById(R.id.Mod);
        mydbsecond=new DatabaseHelper6(this);
        myname=(EditText)findViewById(R.id.username);
        phoneno=(EditText)findViewById(R.id.phone);

        DeleteData();

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main11Activity.this, student_mix2view.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry=myname.getText().toString();
                String secondEntry=phoneno.getText().toString();
                if (myname.length()!=0) {
                    AddData(newEntry,secondEntry);
                    myname.setText("");
                }
                else {
                    Toast.makeText(Main11Activity.this, "you must be putting something in the text field", Toast.LENGTH_LONG).show();
                }

            }
        });



    }
    public void AddData(String newEntry, String secondEntry){
        boolean insertData=mydbsecond.addData(newEntry,secondEntry);
        if(insertData==true){
            Toast.makeText(Main11Activity.this, "successfully entered", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(Main11Activity.this, "something went wrong", Toast.LENGTH_LONG).show();
        }
        clearText();
    }
    public void clearText()
    {
        myname.setText("");
        phoneno.setText("");
        myname.requestFocus();
    }
    public void DeleteData(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleterow=mydbsecond.deletedata(myname.getText().toString());
                if (deleterow>0){
                    Toast.makeText(Main11Activity.this, "successfuly deleted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Main11Activity.this, "something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}









