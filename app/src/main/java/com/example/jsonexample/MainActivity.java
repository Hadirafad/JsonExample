package com.example.jsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    RecyclerView recyclerView;
    String strJson = "{\"JSON\":{\"status\":\"success\",\"message\":\"Login Success\"," +
            "\"data\":[{\"user_id\":\"354453\",\"user_name\":\"Gilson Gilbert\",\"email_id\":\"gilson @gmail.com\",\"profile_pic\":\"https://picsum.photos/200/300\"}," +
            "{\"user_id\":\"3544354\",\"user_name\":\"Arjun\",\"email_id\":\"arjun@gmail.com\",\"profile_pic\":\"https://picsum.photos/200/300\"}," +
            "{\"user_id\":\"3544355\",\"user_name\":\"Arun\",\"email_id\":\"arun@gmail.com\",\"profile_pic\":\"https://picsum.photos/200/300\"}]}}";
    String status[],message[],userid[],name[],mail[],imag[];

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     imageView = (ImageView) findViewById(R.id.imageView);


     String data = "";

        try {
// Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);
            JSONObject jmain = jsonRootObject.getJSONObject("JSON");

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jmain.optJSONArray("data");


            status=getResources().getStringArray(R.array.jstatus);
            message=getResources().getStringArray(R.array.jmessage);
            userid = getResources().getStringArray(R.array.juserid);
            name =getResources().getStringArray(R.array.jname);
            mail= getResources().getStringArray(R.array.jmail);
            imag=getResources().getStringArray(R.array.jimag);

            //jdata =getResources().getStringArray(R.array.arr);
            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                status[i]=jmain.getString("status");
                message[i]=jmain.getString("message");
                userid[i] = jsonObject.getString("user_id");
                name[i] = jsonObject.getString("user_name");
                mail[i]= jsonObject.getString("email_id");
                imag[i]=jsonObject.getString("profile_pic");

                //jdata[i] = status + "\n" + message + "\n" + userid + "\n" + name + "\n" + mail + "\n";
            }


        } catch (JSONException e) {e.printStackTrace();}



        recyclerView=findViewById(R.id.recycler);

     MyAdapter myAdapter =new MyAdapter(this,status,message,userid,name,mail,imag);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
