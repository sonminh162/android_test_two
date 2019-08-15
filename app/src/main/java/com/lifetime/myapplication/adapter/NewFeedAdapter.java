package com.lifetime.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lifetime.myapplication.R;
import com.lifetime.myapplication.model.Info;

import java.util.ArrayList;

public class NewFeedAdapter extends RecyclerView.Adapter<NewFeedAdapter.ViewHolder>{

    ArrayList<Info> infors;
    Context context;

    public NewFeedAdapter(ArrayList<Info> infors, Context context) {
        this.infors = infors;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(infors.get(position));
    }

    @Override
    public int getItemCount() {
        return infors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView name;
        TextView time;
        TextView content;
        ImageView background;
        TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.item_view_avatar);
            name = itemView.findViewById(R.id.item_view_name);
            time = itemView.findViewById(R.id.item_view_time);
            content = itemView.findViewById(R.id.item_view_content);
            background = itemView.findViewById(R.id.item_view_img);
            price = itemView.findViewById(R.id.item_view_price);
        }
        public void bindView(Info info){
            avatar.setImageResource(info.getAvatar());
            name.setText(info.getName());
            time.setText(info.getTime());
            content.setText(info.getContent());
            background.setImageResource(info.getBackground());
            price.setText(info.getPrice());
        }
    }
}
