package com.example.shivu.staffstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class studenthome extends AppCompatActivity {

    String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studenthome);
        Bundle bun=getIntent().getExtras();
        user=bun.getString("username");
    }
}
