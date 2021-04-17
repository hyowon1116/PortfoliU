package com.example.app_profile.Recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_profile.DetailActivity_school;
import com.example.app_profile.DetailActivity_todo;
import com.example.app_profile.R;
import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.AppDatabase_todo;
import com.example.app_profile.Room.User_school;
import com.example.app_profile.Room.User_todo;

import java.util.ArrayList;


public class RecyclerAdapter_todo extends RecyclerView.Adapter<RecyclerAdapter_todo.MyViewHolder> {


    private ArrayList<User_todo> userData = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memorecycler_itemview_todo,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(userData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public void addItem(User_todo user) {
        userData.add(user);
        notifyDataSetChanged();
    }

    public void addItems(ArrayList<User_todo> users) {
        userData = users;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView key;
        private TextView title;
        private TextView date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key_to);
            title = itemView.findViewById(R.id.memoTextView1_to);
            date = itemView.findViewById(R.id.memoTextView2_to);
        }

        public void onBind(User_todo user, int position) {
            String s = "" + (position+1);
            key.setText(s);
            title.setText(user.getTitle());
            date.setText(user.getDate());

            itemView.setOnLongClickListener(v -> {
                userData.remove(user);
                AppDatabase_todo.getInstance(itemView.getContext()).userDao().delete(user);

                notifyDataSetChanged();
                return false;
            });

            itemView.setOnClickListener(v -> {

                Intent intent = new Intent(itemView.getContext(), DetailActivity_todo.class);
                intent.putExtra("data", user);
                itemView.getContext().startActivity(intent);

            });
        }
    }
}
