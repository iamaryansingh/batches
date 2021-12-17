package com.example.batches1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    Button click1,click2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_terminal1);
        click1= findViewById(R.id.button);
        click2=findViewById(R.id.button2);
        click1.setOnClickListener(this);
        click2.setOnClickListener(this);
    }
   @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button:
                if(.getBoolean("user_logged_in",false)){
                    val intent= Intent(this,MainView::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    LoginPage()
                }
                Toast.makeText(this,"welcome to login page",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent1t= new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent1t);
                break;
        }
}}
