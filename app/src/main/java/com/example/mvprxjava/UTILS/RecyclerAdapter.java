package com.example.mvprxjava.UTILS;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvprxjava.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends   RecyclerView.Adapter<RecyclerAdapter.NewsHolder> {
    List<NEWS> list;
    Context con;
    public RecyclerAdapter(List<NEWS> list, Context con ) {
        this.list = list;
        this.con = con;
    }
    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customcard, parent, false);
        NewsHolder showhold = new NewsHolder(view);
        return showhold;
    }
    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, final int position) {
        final NEWS newsRef = list.get(position);
        holder.title.setText(newsRef.title);
        holder.description.setText(newsRef.description);
        Picasso.get().load(newsRef.urlToImage).placeholder(R.drawable.ic_launcher_background).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(con , newsRef.urlToImage , Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class NewsHolder extends RecyclerView.ViewHolder {
        TextView title , description ;
        ImageView image;

        public NewsHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
        }
    }
}
