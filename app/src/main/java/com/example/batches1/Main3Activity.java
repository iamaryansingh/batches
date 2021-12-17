package com.example.batches1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.batches1.students_add.Main6Activity;
import com.example.batches1.students_view.students_12view;

public class Main3Activity extends AppCompatActivity {
    Button click1;
    TextView edtusername;
    TextView edtPassword;

   // String validpassword = "maths";
    //String validusername = "balwinder singh";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.login_terminal2);
        click1 = findViewById(R.id.logi);
        //edtusername = findViewById(R.id.user);
      //  edtPassword = findViewById(R.id.pass);


        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


        String username = String.valueOf(edtusername);
        String password = String.valueOf(edtPassword);

        //if ((validusername == username) && (validpassword == password)) {
                Intent intent=new Intent(Main3Activity.this, main_display.class);
                startActivity(intent);
        //}
        //else {
          //  Toast.makeText(Main3Activity.this,"wrong username or password",Toast.LENGTH_SHORT).show();
            //}}
        }});
    }
}
