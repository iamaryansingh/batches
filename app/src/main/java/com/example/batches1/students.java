package com.example.batches1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.batches1.students_add.Main10Activity;
import com.example.batches1.students_add.Main11Activity;
import com.example.batches1.students_add.Main6Activity;
import com.example.batches1.students_add.Main7Activity;
import com.example.batches1.students_add.Main8Activity;
import com.example.batches1.students_add.Main9Activity;

public class students extends AppCompatActivity  implements View.OnClickListener {
    Button click1,click2,click3,click4,click5,click6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students);
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
                Intent intent= new Intent(students.this, Main6Activity.class);
                startActivity(intent);
                break;
            case R.id.button10:
                Toast.makeText(this,"welcome to class 11th",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(students.this, Main7Activity.class);
                startActivity(intent1);
                break;
            case R.id.button11:
                Toast.makeText(this,"welcome to class 10th",Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(students.this, Main8Activity.class);
                startActivity(intent2);
                break;
            case R.id.button12:
                Toast.makeText(this,"welcome to class 9th",Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(students.this, Main9Activity.class);
                startActivity(intent3);
                break;
            case R.id.button13:
                Toast.makeText(this,"welcome to MIX 1",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(students.this, Main10Activity.class);
                startActivity(intent4);
                break;
            case R.id.button14:
                Toast.makeText(this,"welcome to MIX2",Toast.LENGTH_SHORT).show();
                Intent intent5= new Intent(students.this, Main11Activity.class);
                startActivity(intent5);
                break;
}}}
