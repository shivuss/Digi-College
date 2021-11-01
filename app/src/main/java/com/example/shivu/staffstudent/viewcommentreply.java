package com.example.shivu.staffstudent;

import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class viewcommentreply extends AppCompatActivity {
    String data = "";
    TableLayout tl;
    TableRow tr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcommentreply);

        StrictMode.enableDefaults();

        tl = (TableLayout) findViewById(R.id.table);

        String result = null;
        InputStream is = null;

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.43.184/staffstudent/viewcommentreply.php");
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();


            //Log.e(“log_tag”, “connection success“);
            //   Toast.makeText(getApplicationContext(), “pass”, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {


        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                //  Toast.makeText(getApplicationContext(), “Input Reading pass”, Toast.LENGTH_SHORT).show();
            }
            is.close();

            result = sb.toString();
        } catch (Exception e) {
            //Log.e(“log_tag”, “Error converting result“ + e.toString());
            //Toast.makeText(getApplicationContext(), ”Input reading fail”, Toast.LENGTH_SHORT).show();

        }

        try {
            JSONArray jArray = new JSONArray(result);
            TableLayout tv = (TableLayout) findViewById(R.id.table);
            tv.removeAllViewsInLayout();
            int flag = 1;
            for (int i = -1; i < jArray.length(); i++) {
                TableRow tr = new TableRow(viewcommentreply.this);

                if (flag == 1) {
                    TextView b6 = new TextView(viewcommentreply.this);
                    b6.setText("reply_id");
                    b6.setTextColor(Color.BLUE);
                    b6.setTextSize(15);
                    tr.addView(b6);

                    TextView b19 = new TextView(viewcommentreply.this);
                    b19.setPadding(10, 0, 0, 0);
                    b19.setTextSize(15);
                    b19.setText("comment_details");
                    b19.setTextColor(Color.BLUE);
                    tr.addView(b19);

                    TextView b29 = new TextView(viewcommentreply.this);
                    b29.setPadding(10, 0, 0, 0);
                    b29.setText("comment_by");
                    b29.setTextColor(Color.BLUE);
                    b29.setTextSize(15);
                    tr.addView(b29);

                    TextView b24 = new TextView(viewcommentreply.this);
                    b24.setPadding(10, 0, 0, 0);
                    b24.setText("Date");
                    b24.setTextColor(Color.BLUE);
                    b24.setTextSize(15);
                    tr.addView(b24);

                    TextView b25 = new TextView(viewcommentreply.this);
                    b25.setPadding(10, 0, 0, 0);
                    b25.setText("Time");
                    b25.setTextColor(Color.BLUE);
                    b25.setTextSize(15);
                    tr.addView(b25);

                    TextView b26 = new TextView(viewcommentreply.this);
                    b26.setPadding(10, 0, 0, 0);
                    b26.setText("Reply");
                    b26.setTextColor(Color.BLUE);
                    b26.setTextSize(15);
                    tr.addView(b26);

                    tv.addView(tr);
                    final View vline = new View(viewcommentreply.this);
                    vline.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 2));
                    vline.setBackgroundColor(Color.BLUE);
                    tv.addView(vline);
                    flag = 0;
                } else {
                    JSONObject json_data = jArray.getJSONObject(i);
                    //Log.i("log_tag", ”id: “ + json_data.getInt(“Id”) + “, Username: “ + json_data.getString(“username”) + “, No: “ + json_data.getString(“comment”));

                    TextView b1 = new TextView(viewcommentreply.this);
                    b1.setPadding(10, 0, 0, 0);
                    b1.setTextSize(15);
                    final String stime1 = json_data.getString("reply_id");
                    b1.setText(stime1);
                    b1.setTextColor(Color.BLACK);
                    tr.addView(b1);

                    TextView b2 = new TextView(viewcommentreply.this);
                    b2.setPadding(10, 0, 0, 0);
                    final String stime2 = json_data.getString("comment_details");
                    b2.setText(stime2);
                    b2.setTextColor(Color.BLACK);
                    b2.setTextSize(15);
                    tr.addView(b2);

                    TextView b22 = new TextView(viewcommentreply.this);
                    b22.setPadding(10, 0, 0, 0);
                    final String stime3 = json_data.getString("comment_by");
                    b22.setText(stime3);
                    b22.setTextColor(Color.BLACK);
                    b22.setTextSize(15);
                    tr.addView(b22);

                    TextView b23 = new TextView(viewcommentreply.this);
                    b23.setPadding(10, 0, 0, 0);
                    final String stime23 = json_data.getString("date");
                    b23.setText(stime23);
                    b23.setTextColor(Color.BLACK);
                    b23.setTextSize(15);
                    tr.addView(b23);

                    TextView b24 = new TextView(viewcommentreply.this);
                    b24.setPadding(10, 0, 0, 0);
                    final String stime24 = json_data.getString("time");
                    b24.setText(stime24);
                    b24.setTextColor(Color.BLACK);
                    b24.setTextSize(15);
                    tr.addView(b24);

                    TextView b25 = new TextView(viewcommentreply.this);
                    b25.setPadding(10, 0, 0, 0);
                    final String stime25 = json_data.getString("time");
                    b25.setText(stime25);
                    b25.setTextColor(Color.BLACK);
                    b25.setTextSize(15);
                    tr.addView(b25);

                    b25.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i1=new Intent(getApplicationContext(),commentreply.class);
                            Bundle bb=new Bundle();
                            bb.putString("rid",stime1);
                            i1.putExtras(bb);
                            startActivity(i1);
                        }
                    });





                    tv.addView(tr);
                    final View vline1 = new View(viewcommentreply.this);
                    vline1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
                    vline1.setBackgroundColor(Color.WHITE);
                    tv.addView(vline1);
                }
            }
        } catch (JSONException e) {
            //	Log.e(“log_tag”, “Error parsing data“ + e.toString());
            //	Toast.makeText(getApplicationContext(), “JsonArray fail”, Toast.LENGTH_SHORT).show();
        }
    }
}


    