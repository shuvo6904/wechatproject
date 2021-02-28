package com.example.wechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wechat.R;
import com.example.wechat.model.ChatList;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder>{

    private List<ChatList> list;

    private Context context;

    public ChatListAdapter(List<ChatList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_chat_list,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        ChatList chatList = list.get(position);

        holder.tVName.setText(chatList.getUserName());
        holder.tVDesc.setText(chatList.getDescription());
        holder.tVDate.setText(chatList.getDate());

        // for image we need new liabrary

        Glide.with(context).load(chatList.getUrlProfileImage()).into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private CircleImageView profileImage;

        private TextView tVName, tVDesc, tVDate;


        public Holder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.imageProfileID);

            tVName = itemView.findViewById(R.id.tVNameID);

            tVDate = itemView.findViewById(R.id.tVDate);

            tVDesc = itemView.findViewById(R.id.tVDescID);

        }
    }
}
