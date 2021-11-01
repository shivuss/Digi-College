package com.example.shivu.staffstudent;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DbHttpResponse {



    public String getResponseString(String url,List<NameValuePair> nameValuePairs){
       // JSONArray array= null;
        String responseText= null;
        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            org.apache.http.HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            responseText = EntityUtils.toString(httpEntity);
         //   array = new JSONArray(responseText);
        }catch (Exception ee){
            // Log.e("GetHttpResponse",ee.toString());
        }
        return responseText;
    }

}
