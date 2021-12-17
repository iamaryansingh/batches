package com.example.batches1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.batches1.Notepad.notepad_list;
//import com.example.batches1.bathes_add.view_batches;

public class main_display extends AppCompatActivity  implements View.OnClickListener{

    RelativeLayout click1,click2,click3,click4,click5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_display);
        click1=findViewById(R.id.rlbutton2);
        click1.setOnClickListener(this);
        click2= findViewById(R.id.rlbutton1);
        click2.setOnClickListener(this);
        click3=findViewById(R.id.rlbutton3);
        click3.setOnClickListener(this);
        click4=findViewById(R.id.rlbutton4);
        click4.setOnClickListener(this);
        click5=findViewById(R.id.rlbutton5);
        click5.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.rlbutton2:
                Intent intent= new Intent(main_display.this, students.class);
                startActivity(intent);
                break;
            //case R.id.button3:
            case R.id.rlbutton1:
                Intent intent1= new Intent(main_display.this,Attendence.class);
                startActivity(intent1);
                break;
            case R.id.rlbutton5:
                Intent intent2= new Intent(main_display.this, notepad_list.class);
                startActivity(intent2);
                break;
            case R.id.rlbutton3:
                Intent intent3= new Intent(main_display.this, fees.class);
                startActivity(intent3);
                break;
            case R.id.rlbutton4:
                Intent intent4= new Intent(main_display.this, batches.class);
                startActivity(intent4);
                break;

}}}
