package com.example.shivu.staffstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class forgotpass extends AppCompatActivity {

    EditText t1;
    String s1,ReturnValue;

    public void next(View v)
    {
        s1=t1.getText().toString();

        if(s1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter valid Username",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        t1=(EditText)findViewById(R.id.editText38);
    }
}
