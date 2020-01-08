package com.example.myapplication;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private ArrayList<VisitoerTotalData> dataSet;
    Activity context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView id,email,first_name,last_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.avatar = (ImageView) itemView.findViewById(R.id.avatar);
            this.id = (TextView) itemView.findViewById(R.id.id);
            this.email = (TextView) itemView.findViewById(R.id.email);
            this.first_name = (TextView) itemView.findViewById(R.id.first_name);
            this.last_name = (TextView) itemView.findViewById(R.id.last_name);
        }
    }

    public UsersAdapter(Activity activity, ArrayList<VisitoerTotalData> data) {
        this.context = activity;
        this.dataSet = data;
        //Toast.makeText(context,dataSet.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visitor, parent, false);
        //view.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        ImageView avatar = holder.avatar;
        TextView id = holder.id;
        TextView email = holder.email;
        TextView first_name = holder.first_name;
        TextView last_name = holder.last_name;

        Glide.with(context)
                .load(dataSet.get(listPosition).getAvatar())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.avatar);

        id.setText(dataSet.get(listPosition).getId());
        email.setText(dataSet.get(listPosition).getEmail());
        first_name.setText(dataSet.get(listPosition).getFirst_name());
        last_name.setText(dataSet.get(listPosition).getLast_name());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
