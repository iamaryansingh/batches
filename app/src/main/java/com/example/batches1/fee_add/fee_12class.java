package com.example.batches1.fee_add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.batches1.R;
import com.example.batches1.database.DatabaseHelper;
import com.example.batches1.fee_payview.fee_12payview;
import com.example.batches1.fee_view.fee_12view;

import java.text.SimpleDateFormat;
import java.util.Date;


public class fee_12class extends AppCompatActivity {
    DatabaseHelper mydb;
    Button add, paid,npaid;
    EditText name;
    EditText fee,feetp,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fee_add);
        add = (Button) findViewById(R.id.Add);
        paid = (Button) findViewById(R.id.Paid);
        npaid = (Button) findViewById(R.id.Npaid);
        name = (EditText) findViewById(R.id.username);
        mydb=new DatabaseHelper(this);
        fee = (EditText) findViewById(R.id.fee);
        feetp = (EditText) findViewById(R.id.fee2);
        date=(EditText) findViewById(R.id.newdate);;


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry=name.getText().toString();
                String secondEntry=fee.getText().toString();
                String thirdentry=feetp.getText().toString();
                String four=date.getText().toString();


                if (name.length()!=0) {
                    AddData(newEntry,secondEntry,thirdentry,four);
                    name.setText("");
                }
                else {
                    Toast.makeText(fee_12class.this, "you must be putting something in the text field", Toast.LENGTH_LONG).show();
                }

            }
        });

        paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String da=date.getText().toString();
                Intent intent = new Intent(fee_12class.this, fee_12payview.class);
                intent.putExtra("DATETOPAY",da);
                startActivity(intent);
            }
        });
        npaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String da=date.getText().toString();
                Intent intent = new Intent(fee_12class.this, fee_12view.class);
                intent.putExtra("DATETOPAY",da);
                startActivity(intent);


            }
        });
    }

    public void AddData(String newEntry, String secondEntry,String third,String four){
        boolean insertData=mydb.addDatafee(newEntry,secondEntry,third,four);
        if(insertData==true){
            Toast.makeText(fee_12class.this, "successfully entered", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(fee_12class.this, "something went wrong", Toast.LENGTH_LONG).show();
        }
        clearText();
    }
    public void clearText()
    {
        name.setText("");
        fee.setText("");

    }
}