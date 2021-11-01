package com.example.shivu.staffstudent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class staff_details extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5,t6,t7;
    String s1,s2,s3,s4,s5,s6,s7,ReturnValue;

    public void insertstaff(View v)
    {
        s1=t1.getText().toString();
        s2=t2.getText().toString();
        s3=t3.getText().toString();
        s4=t4.getText().toString();
        s5=t5.getText().toString();
        s6=t6.getText().toString();
        s7=t7.getText().toString();
        if(s1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter staffid",Toast.LENGTH_LONG).show();
        }
        if(s2.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter staffname",Toast.LENGTH_LONG).show();
        }
        if(s3.equals(""))
    {
        Toast.makeText(getApplicationContext(),"Please enter address",Toast.LENGTH_LONG).show();
    }
        if(s4.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter departmentid",Toast.LENGTH_LONG).show();
        }
        if(s5.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter subject",Toast.LENGTH_LONG).show();
        }
        if(s6.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter emailid",Toast.LENGTH_LONG).show();
        }
        if(s7.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter contact number",Toast.LENGTH_LONG).show();
        }








        String strurl="http://192.168.43.184/staffstudent/insertstaff.php";

        new addstaff().execute(strurl);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_details);

        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
        t3=(EditText)findViewById(R.id.editText3);
        t4=(EditText)findViewById(R.id.editText4);
        t5=(EditText)findViewById(R.id.editText5);
        t6=(EditText)findViewById(R.id.editText6);
        t7=(EditText)findViewById(R.id.editText7);


    }

    private class addstaff extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... strings) {

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("s1", s1));
            nameValuePairs.add(new BasicNameValuePair("s2", s2));
            nameValuePairs.add(new BasicNameValuePair("s3", s3));
            nameValuePairs.add(new BasicNameValuePair("s4", s4));
            nameValuePairs.add(new BasicNameValuePair("s5", s5));
            nameValuePairs.add(new BasicNameValuePair("s6", s6));
            nameValuePairs.add(new BasicNameValuePair("s7", s7));


            DbHttpResponse myHttpResponse = new DbHttpResponse();
            String rspTxt = myHttpResponse.getResponseString(strings[0], nameValuePairs);

            ReturnValue = rspTxt;

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Toast.makeText(getApplicationContext(), "connecting", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            int startval = 0;
            startval = ReturnValue.indexOf("<!DOCTYPE");

            if (startval > 0) {
                ReturnValue = ReturnValue.substring(0, startval);
            }

            ReturnValue = ReturnValue.replace("\r\n\r\n", "");
            Toast.makeText(getApplicationContext(), ReturnValue, Toast.LENGTH_LONG).show();

        }
    }
}
