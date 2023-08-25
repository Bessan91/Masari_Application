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

public class suggestedAdapter extends RecyclerView.Adapter<suggestedAdapter.ViewHolder> {
    ArrayList<tours> suggestedToursArray;

    public suggestedAdapter(ArrayList<tours> suggestedToursArray) {
        this.suggestedToursArray = suggestedToursArray;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_suggested, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(suggestedToursArray.get(position).getName());
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(suggestedToursArray.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.tourImg);
        holder.tourImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), tours_info.class);
                intent.putExtra("object", suggestedToursArray.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return suggestedToursArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView tourImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.suggested_title);
            tourImg = itemView.findViewById(R.id.suggested_img);
        }
    }
}
