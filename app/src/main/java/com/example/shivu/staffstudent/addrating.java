package com.example.shivu.staffstudent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class addrating extends AppCompatActivity {

    private RatingBar ratingBar;

    String rating;
    String queryid,replyid,ReturnValue;



    public void addrating(View v)
    {
        rating=String.valueOf(ratingBar.getRating());

        Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();

        String strurl = "http://192.168.43.184/staffstudent/insertrating.php";
        new insertrating().execute(strurl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrating);

        ratingBar=(RatingBar)findViewById(R.id.ratingBar);

        Bundle bun=getIntent().getExtras();
        queryid=bun.getString("queryid");
        replyid=bun.getString("replyid");





    }

    private class insertrating extends AsyncTask<String,Void,Void>{
        @Override
        protected Void doInBackground(String... strings) {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("s1",queryid));
            nameValuePairs.add(new BasicNameValuePair("s2", replyid));
            nameValuePairs.add(new BasicNameValuePair("s3",rating));



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
