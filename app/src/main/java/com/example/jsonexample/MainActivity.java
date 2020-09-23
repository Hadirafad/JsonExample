package com.example.jsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String strJson = "{\"JSON\":{\"status\":\"success\",\"message\":\"Login Success\"," +
            "\"data\":[{\"user_id\":\"354453\",\"user_name\":\"Gilson Gilbert\",\"email_id\":\"gilson @gmail.com\",\"profile_pic\":\"< image_url >\"}," +
            "{\"user_id\":\"3544354\",\"user_name\":\"Arjun\",\"email_id\":\"arjun@gmail.com\",\"profile_pic\":\"< image_url >\"}," +
            "{\"user_id\":\"3544355\",\"user_name\":\"Arun\",\"email_id\":\"arun@gmail.com\",\"profile_pic\":\"< image_url >\"}]}}";
    String status,message,userid,name,mail,imag;
    String jdata[];

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String data = "";

        try {
// Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);
            JSONObject jmain = jsonRootObject.getJSONObject("JSON");

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jmain.optJSONArray("data");


            jdata =getResources().getStringArray(R.array.arr);
            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                status = jmain.getString("status");
                message = jmain.getString("message");
                userid = jsonObject.getString("user_id");
                name = jsonObject.getString("user_name");
                mail = jsonObject.getString("email_id");


                jdata[i] = status + "\n" + message + "\n" + userid + "\n" + name + "\n" + mail + "\n";
            }


            } catch (JSONException e) {e.printStackTrace();}

        recyclerView=findViewById(R.id.recycler);

        MyAdapter myAdapter =new MyAdapter(this,jdata);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
