package com.example.shivu.staffstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class principlehome extends AppCompatActivity {


    public void adddepartment(View v)
    {
        Intent i1=new Intent(getApplication(),department.class);
        startActivity(i1);
    }
    public void addstaff(View v)
    {
        Intent i1=new Intent(getApplication(),staff_details.class);
        startActivity(i1);
    }
    public void deluser(View v)
    {
        Intent i1=new Intent(getApplication(),viewlogin.class);
        startActivity(i1);
    }
    public void viewquery(View v)
    {
        Intent i1=new Intent(getApplication(),viewquerydetailsonly.class);
        startActivity(i1);
    }
    public void viewreply(View v)
    {
        Intent i1=new Intent(getApplication(),viewquerydetails.class);
        startActivity(i1);
    }

    public void viewcomment(View v)
    {
        Intent i1=new Intent(getApplication(),viewcommentreply.class);
        startActivity(i1);
    }
    public void viewfeedback(View v)
    {
        Intent i1=new Intent(getApplication(),viewfeedback.class);
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
        setContentView(R.layout.activity_principlehome);
        Bundle bun=getIntent().getExtras();
        user=bun.getString("username");
    }
}
