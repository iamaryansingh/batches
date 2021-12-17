package com.example.batches1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.batches1.fee_add.fee_12class;
import com.example.batches1.fee_add.fee_11class;




public class fees extends AppCompatActivity  implements View.OnClickListener {
    Button click1,click2,click3,click4,click5,click6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fees);
        click1=findViewById(R.id.button9);
        click1.setOnClickListener(this);
        click2=findViewById(R.id.button10);
        click2.setOnClickListener(this);
        click3=findViewById(R.id.button11);
        click3.setOnClickListener(this);
        click4=findViewById(R.id.button12);
        click4.setOnClickListener(this);
        click5=findViewById(R.id.button13);
        click5.setOnClickListener(this);
        click6=findViewById(R.id.button14);
        click6.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button9:
                Toast.makeText(this,"welcome to class 12th",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(fees.this, fee_12class.class);
                startActivity(intent);
                break;
            case R.id.button10:
                Toast.makeText(this,"welcome to class 11th",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(fees.this, fee_11class.class);
                startActivity(intent1);
                break;
            case R.id.button11:
                Toast.makeText(this,"welcome to class 10th",Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(fees.this, fee_11class.class);
                startActivity(intent2);
                break;
            case R.id.button12:
                Toast.makeText(this,"welcome to class 9th",Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(fees.this, fee_11class.class);
                startActivity(intent3);
                break;
            case R.id.button13:
                Toast.makeText(this,"welcome to MIX 1",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(fees.this, fee_11class.class);
                startActivity(intent4);
                break;
            case R.id.button14:
                Toast.makeText(this,"welcome to MIX2",Toast.LENGTH_SHORT).show();
                Intent intent5= new Intent(fees.this, fee_11class.class);
                startActivity(intent5);
                break;
        }}}
