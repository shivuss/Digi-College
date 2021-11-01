package com.example.shivu.staffstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Thread t1=new Thread()
        {
            public void run()
            {
                try
                {
                   sleep(3000);
                    Intent i1=new Intent(getApplicationContext(),login.class);
                    startActivity(i1);
                }
                catch (Exception e)
                {

                }
            }
        };
        t1.start();


    }
}
