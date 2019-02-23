package com.example.apple.volleyapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private User[] data;
    private Context context;


    public RecyclerAdapter(User[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_source,null);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        User user=data[i];
        recyclerViewHolder.text.setText(" "+user.getLogin());
        Glide.with(context).load(user.getAvatarUrl()).into(recyclerViewHolder.image);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imgview);
            text=itemView.findViewById(R.id.textview);
        }
    }
}
