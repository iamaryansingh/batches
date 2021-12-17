package com.example.batches1.bathes_add;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.batches1.R;
import com.example.batches1.batches_view.batch_mix1;
import com.example.batches1.database.DatabaseHelper5;
import com.example.batches1.batches_present.batches_present_mix1;
import com.example.batches1.batches_absent.batches_absent_mix1;



public class view_batchesmix1 extends AppCompatActivity {
    EditText myname,date;
    DatabaseHelper5 mydb;

    Button viewall,viewonlyp,viewonlyab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_batches);
        myname=(EditText)findViewById(R.id.username);
        date=(EditText)findViewById(R.id.newdate);
        viewall=(Button) findViewById(R.id.Via);
        mydb=new DatabaseHelper5(this);
        viewonlyp=(Button)findViewById(R.id.Viewp);
        viewonlyab=(Button)findViewById(R.id.Viewab);




        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view_batchesmix1.this, batch_mix1.class);
                startActivity(intent);
            }
        });
        viewonlyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=myname.getText().toString();
                String da=date.getText().toString();
                Intent intent=new Intent(view_batchesmix1.this, batches_present_mix1.class);
                intent.putExtra("NAME",name);
                intent.putExtra("DATE",da);
                startActivity(intent);
            }
        });
        viewonlyab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=myname.getText().toString();
                String da=date.getText().toString();
                Intent intent=new Intent(view_batchesmix1.this, batches_absent_mix1.class);
                intent.putExtra("NAME",name);
                intent.putExtra("DATE",da);
                startActivity(intent);
            }
        });
    }
}
