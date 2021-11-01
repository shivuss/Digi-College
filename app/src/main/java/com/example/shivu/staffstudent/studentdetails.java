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

public class studentdetails extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5,t6;
    String s1,s2,s3,s4,s5,s6,ReturnValue;

    public void send(View v)
    {
        s1=t1.getText().toString();
        s2=t2.getText().toString();
        s3=t3.getText().toString();
        s4=t4.getText().toString();
        s5=t5.getText().toString();
        s6=t6.getText().toString();
        if(s1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter student id",Toast.LENGTH_LONG).show();
        }
        if(s2.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter student name",Toast.LENGTH_LONG).show();
        }
        if(s3.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter address",Toast.LENGTH_LONG).show();
        }
        if(s4.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter email id",Toast.LENGTH_LONG).show();
        }
        if(s5.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter department id",Toast.LENGTH_LONG).show();
        }
        if(s6.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter contact number",Toast.LENGTH_LONG).show();
        }





        String strurl="http://192.168.43.184/staffstudent/insertstudent.php";

        new addstudentdetails().execute(strurl);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdetails);

        t1=(EditText)findViewById(R.id.editText11);
        t2=(EditText)findViewById(R.id.editText12);
        t3=(EditText)findViewById(R.id.editText13);
        t4=(EditText)findViewById(R.id.editText14);
        t5=(EditText)findViewById(R.id.editText15);
        t6=(EditText)findViewById(R.id.editText16);

    }

    private class addstudentdetails extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... strings) {


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("s1", s1));
                nameValuePairs.add(new BasicNameValuePair("s2", s2));
                nameValuePairs.add(new BasicNameValuePair("s3", s3));
                nameValuePairs.add(new BasicNameValuePair("s4", s4));
                nameValuePairs.add(new BasicNameValuePair("s5", s5));
                nameValuePairs.add(new BasicNameValuePair("s6", s6));



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
