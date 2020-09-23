package com.example.jsonexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import android.support.annotation.NonNull;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String status[],message,userid,name,mail;

    Context context;

    public MyAdapter(Context ct,String jstatus[]){//,String jmessage,String juserid,String jtitle,String jname,String  jmail,String jdob,String jphone,String jcontry,String jimg){

        context=ct;
        status=jstatus;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.mytext1.setText(status[i]);
        holder.mytext2.setText(message);
        holder.mytext3.setText(userid);
        holder.mytext5.setText(name);
        holder.mytext6.setText(mail);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytext1,mytext2,mytext3,mytext5,mytext6;
        ImageView myimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mytext1=itemView.findViewById(R.id.textView);
            mytext2=itemView.findViewById(R.id.textView2);
            mytext3=itemView.findViewById(R.id.textView3);
            mytext5=itemView.findViewById(R.id.textView5);
            mytext6=itemView.findViewById(R.id.textView6);
            myimage=itemView.findViewById(R.id.imageView);
        }
    }
}