package com.example.shivu.staffstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class staffhome extends AppCompatActivity {
    String user;


    public void viewquery(View v)
    {
        Intent i1=new Intent(getApplicationContext(),viewquerydetailsonly.class);
        startActivity(i1);
    }
    public void reply(View v) {
        Intent i1 = new Intent(getApplicationContext(),viewquerydetails.class);
        startActivity(i1);
    }
    public void viewcomment(View v) {
        Intent i1 = new Intent(getApplicationContext(),viewcommentreply.class);
        startActivity(i1);
    }
    public void addstudent(View v) {
        Intent i1 = new Intent(getApplicationContext(),studentdetails.class);
        startActivity(i1);
    }
    public void viewnotice(View v) {
        Intent i1 = new Intent(getApplicationContext(),viewnotice.class);
        startActivity(i1);
    }


    public void changepassword(View v) {
        Intent i1 = new Intent(getApplicationContext(),changepassword.class);
        Bundle bb=new Bundle();
        bb.putString("username",user);
        i1.putExtras(bb);

        startActivity(i1);
    }
    public void logout(View v) {
        Intent i1 = new Intent(getApplicationContext(),login.class);
        startActivity(i1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffhome);

        Bundle bun=getIntent().getExtras();
        user=bun.getString("username");

        Toast.makeText(getApplicationContext(),user, Toast.LENGTH_SHORT).show();

    }
}
