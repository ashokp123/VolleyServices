package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {

    private ArrayList<StatusTotalData> dataSet;
    Activity context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView status_avatar;
        TextView status_phone,status_email,status_first_name,status_last_name,status_gender,status;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.status_avatar = (ImageView) itemView.findViewById(R.id.status_avatar);
            this.status_phone = (TextView) itemView.findViewById(R.id.status_phone);
            this.status_email = (TextView) itemView.findViewById(R.id.status_email);
            this.status_first_name = (TextView) itemView.findViewById(R.id.status_first_name);
            this.status_last_name = (TextView) itemView.findViewById(R.id.status_last_name);
            this.status_gender = (TextView) itemView.findViewById(R.id.status_gender);
            this.status = (TextView) itemView.findViewById(R.id.status);
        }
    }

    public StatusAdapter(Activity activity, ArrayList<StatusTotalData> data) {
        this.context = activity;
        this.dataSet = data;
        //Toast.makeText(context,dataSet.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_list_item, parent, false);
        //view.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        ImageView status_avatar = holder.status_avatar;
        TextView status_phone = holder.status_phone;
        TextView status_email = holder.status_email;
        TextView status_first_name = holder.status_first_name;
        TextView status_last_name = holder.status_last_name;
        TextView status_gender = holder.status_gender;
        TextView status = holder.status;

        Glide.with(context)
                .load(dataSet.get(listPosition).getHref())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.status_avatar);

        status_phone.setText(dataSet.get(listPosition).getPhone());
        status_email.setText(dataSet.get(listPosition).getEmail());
        status_first_name.setText(dataSet.get(listPosition).getFirst_name());
        status_last_name.setText(dataSet.get(listPosition).getLast_name());
        status_gender.setText(dataSet.get(listPosition).getGender());
        status.setText(dataSet.get(listPosition).getStatus());

        String status_clr = status.getText().toString();

        if (status_clr.equals("active")){
            status.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
