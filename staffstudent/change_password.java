package com.example.anushanekkanti.bca.jss;

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

public class change_password extends AppCompatActivity {

    EditText t1,t2,t3;
    String s1,s2,s3,ReturnValue,user;
    //String passpattern = "^(?=.*[0-9])(?=.*[A-Z)(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$" ;

    public void change(View v)
    {

        s1=t1.getText().toString();
        s2=t2.getText().toString();
        s3=t3.getText().toString();
        if (s1.equals("")) {
            Toast.makeText(getApplicationContext(), "Paasword should not be empty", Toast.LENGTH_SHORT).show();
            t1.setError("Password should not be empty");
        }
        else
         if (s2.equals("")) {
            Toast.makeText(getApplicationContext(), "Paasword should not be empty", Toast.LENGTH_SHORT).show();
            t2.setError("Password should not be empty");
        }
        /*if (!t2.getText().toString().trim().matches(passpattern)) {

            Toast.makeText(getApplicationContext(), "must contain atleast one character,uppercase character and lowercase character", Toast.LENGTH_SHORT).show();
        }*/
        else
        if(s2.length()<=6)
        {
            Toast.makeText(getApplicationContext(), "Paasword must be atleast 6 character", Toast.LENGTH_SHORT).show();

        }
        else
        if (s3.equals("")) {
            Toast.makeText(getApplicationContext(), "Paasword should not be empty", Toast.LENGTH_SHORT).show();
            t3.setError("Password should not be empty");
        }
        else {
            String strur1 = "http://192.168.43.121/PMS_db/changepassword.php";
            new change().execute(strur1);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        t1=(EditText)findViewById(R.id.editText3);
        t2=(EditText)findViewById(R.id.editText4);
        t3=(EditText)findViewById(R.id.editText5);

        Bundle bun=getIntent().getExtras();
        user=bun.getString("username");
    }


    private class change extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... strings) {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("s1", s1));
            nameValuePairs.add(new BasicNameValuePair("s2", s2));
            nameValuePairs.add(new BasicNameValuePair("s3", s3));
            nameValuePairs.add(new BasicNameValuePair("s4", user));
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
