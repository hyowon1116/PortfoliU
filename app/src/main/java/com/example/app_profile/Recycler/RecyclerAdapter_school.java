package com.example.app_profile.Recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_profile.DetailActivity_foreign;
import com.example.app_profile.DetailActivity_school;
import com.example.app_profile.R;
import com.example.app_profile.Room.AppDatabase_foreign;
import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.User_foreign;
import com.example.app_profile.Room.User_school;

import java.util.ArrayList;


public class RecyclerAdapter_school extends RecyclerView.Adapter<RecyclerAdapter_school.MyViewHolder> {


    private ArrayList<User_school> userData = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memorecycler_itemview_school,parent,false);
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

    public void addItem(User_school user) {
        userData.add(user);
        notifyDataSetChanged();
    }

    public void addItems(ArrayList<User_school> users) {
        userData = users;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView key;
        private TextView title;
        private TextView description;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key_sch);
            title = itemView.findViewById(R.id.memoTextView1_sch);
            description = itemView.findViewById(R.id.memoTextView2_sch);
        }

        public void onBind(User_school user, int position) {
            String s = "" + (position+1);
            key.setText(s);
            title.setText(user.getTitle());
            description.setText(user.getDate());

            itemView.setOnLongClickListener(v -> {
                userData.remove(user);
                AppDatabase_school.getInstance(itemView.getContext()).userDao().delete(user);

                notifyDataSetChanged();
                return false;
            });

            itemView.setOnClickListener(v -> {

                Intent intent = new Intent(itemView.getContext(), DetailActivity_school.class);
                intent.putExtra("data", user);
                itemView.getContext().startActivity(intent);

            });
        }
    }
}
