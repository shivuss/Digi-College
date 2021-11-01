package com.example.shivu.staffstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hodhome extends AppCompatActivity {

    public void addstaff(View v)
    {
        Intent i1=new Intent(getApplication(),staff_details.class);
        startActivity(i1);
    }
    public void viewquery(View v)
    {
        Intent i1=new Intent(getApplication(),viewquerydetailsonly.class);
        startActivity(i1);
    }
    public void block(View v)
    {
        Intent i1=new Intent(getApplication(),department.class);
        startActivity(i1);
    }
    public void addstudent(View v)
    {
        Intent i1=new Intent(getApplication(),studentdetails.class);
        startActivity(i1);
    }
    public void addnotice(View v)
    {
        Intent i1=new Intent(getApplication(),addnotice.class);
        startActivity(i1);
    }
    public void changepassword(View v)
    {
        Intent i1=new Intent(getApplication(),changepassword.class);

        Bundle bb=new Bundle();
        bb.putString("username",user);
        i1.putExtras(bb);

        startActivity(i1);
    }
    public void logout(View v)
    {
        Intent i1=new Intent(getApplication(),login.class);
        startActivity(i1);
    }
String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodhome);

        Bundle bun=getIntent().getExtras();
        user=bun.getString("username");
    }
}
