package com.example.batches1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                //startActivity(intent);
                Intent intent= new Intent(MainActivity.this,main_display.class);
                startActivity(intent);
                finish();

            }
        },2500);
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG,"--onStart--");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"--onRestart--");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"--onResume--");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"--onPause--");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"--onStop--");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"--onDestroy--");
    }
}
