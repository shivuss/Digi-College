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

public class remarks extends AppCompatActivity {

    EditText t1,t2,t3;
    String s1,s2,s3,ReturnValue;

    public void send(View v){
        s1=t1.getText().toString();
        s2=t2.getText().toString();
        s3=t3.getText().toString();
        if(s1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter Replyid",Toast.LENGTH_LONG).show();
        }
        if(s2.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter Remarks",Toast.LENGTH_LONG).show();
        }
        if(s1.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter By",Toast.LENGTH_LONG).show();
        }
        else {


            String strurl = "http://192.168.43.184/staffstudent/insertremarks.php";

            new addremarks().execute(strurl);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remarks);
        t1=(EditText)findViewById(R.id.editText30);
        t2=(EditText)findViewById(R.id.editText31);
        t3=(EditText)findViewById(R.id.editText32);

    }

    private class addremarks extends AsyncTask <String,Void,Void>  {
        @Override
        protected Void doInBackground(String... strings) {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("s1", s1));
            nameValuePairs.add(new BasicNameValuePair("s2", s2));
            nameValuePairs.add(new BasicNameValuePair("s3", s3));



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
