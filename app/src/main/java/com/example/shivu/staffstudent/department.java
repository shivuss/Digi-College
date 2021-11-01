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

public class department extends AppCompatActivity {
    EditText t1,t2;
    String s1,s2,ReturnValue;

    public void send(View v) {
        s1 = t1.getText().toString();
        s2 = t2.getText().toString();

        if(s1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please Enter Department ID",Toast.LENGTH_LONG).show();
        }
        if(s2.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please Enter Department Name",Toast.LENGTH_LONG).show();
        }
        else {

            String strurl = "http://192.168.43.184/staffstudent/insertdepartment.php";

            new adddepartment().execute(strurl);
        }


    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);


        t1=(EditText)findViewById(R.id.editText17);
        t2=(EditText)findViewById(R.id.editText18);

}

    private class adddepartment extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... strings) {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("s1", s1));
            nameValuePairs.add(new BasicNameValuePair("s2", s2));



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

