package com.example.shivu.staffstudent;

import android.content.Intent;
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

public class login extends AppCompatActivity {

    EditText t1,t2;
    String s1,s2,s3,ReturnValue;

    public void send(View v){

        s1=t1.getText().toString();
        s2=t2.getText().toString();

        if(s1.equals(""))
        {
        Toast.makeText(getApplicationContext(),"Username cant be empty",Toast.LENGTH_LONG).show();
        }
        if(s2.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Password cant be empty",Toast.LENGTH_LONG).show();
        }
        if(s2.length()<6)
        {
            Toast.makeText(getApplicationContext(),"Password cant be less than 6 char",Toast.LENGTH_LONG).show();
        }
        else
            {
            String strurl = "http://192.168.43.184/staffstudent/logcheck.php";

            new addlogin().execute(strurl);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        t1=(EditText)findViewById(R.id.editText33);
        t2=(EditText)findViewById(R.id.editText34);



    }

    private class addlogin extends AsyncTask<String,Void,Void> {
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

            String type=ReturnValue;

            if(type.equals("staff"))
            {
                Intent i1=new Intent(getApplicationContext(),staffhome.class);
                Bundle bb=new Bundle();
                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                bb.putString("username",s1);
                i1.putExtras(bb);
                startActivity(i1);

            }
            if(type.equals("principal"))
            {
                Intent i1=new Intent(getApplicationContext(),principlehome.class);

                Bundle bb=new Bundle();
                bb.putString("username",s1);
                i1.putExtras(bb);

                startActivity(i1);

            }
            if(type.equals("student"))
            {
                Intent i1=new Intent(getApplicationContext(),newstudenthome.class);

                Bundle bb=new Bundle();
                bb.putString("username",s1);
                i1.putExtras(bb);

                startActivity(i1);

            }
            if(type.equals("hod"))
            {
                Intent i1=new Intent(getApplicationContext(),hodhome.class);

                Bundle bb=new Bundle();
                bb.putString("username",s1);
                i1.putExtras(bb);

                startActivity(i1);

            }

        }
    }
}
