package com.example.shivu.staffstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class otp extends AppCompatActivity {

    EditText t1;
    String s1,ReturnValue;

    public void submit(View v)
    {
        s1=t1.getText().toString();

        if(s1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter valid OTP",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        t1=(EditText)findViewById(R.id.editText39);
    }
}
