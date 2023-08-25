package com.example.masariproject.MyAdabter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.masariproject.Model.tours;
import com.example.masariproject.R;
import com.example.masariproject.tours_info;

import java.util.ArrayList;

public class myFavoriteList extends RecyclerView.Adapter<myFavoriteList.ViewHolder>{
    ArrayList<tours> listBooking;

    public myFavoriteList(ArrayList<tours> listBooking) {
        this.listBooking = listBooking;
    }

    @Override
    public myFavoriteList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_suggested,parent,false);
        return new myFavoriteList.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull myFavoriteList.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(listBooking.get(position).getName());
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(listBooking.get(position).getImage(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.tourImg);
        holder.tourImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), tours_info.class);
                intent.putExtra("object",listBooking.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBooking.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView tourImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.suggested_title);
            tourImg=itemView.findViewById(R.id.suggested_img);
        }
    }

}
