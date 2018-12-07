package com.example.cocdejesus.de_jesus;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void exit(View v) {


        System.exit(0);
    }

    public void onClick(View v) {

        startActivity(new Intent(FirstActivity.this, SecondActivity.class));

    }

}
