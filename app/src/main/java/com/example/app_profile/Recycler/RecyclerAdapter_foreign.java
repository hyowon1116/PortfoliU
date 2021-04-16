package com.example.app_profile.Recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_profile.DetailActivity;
import com.example.app_profile.DetailActivity_foreign;
import com.example.app_profile.R;
import com.example.app_profile.Room.AppDatabase;
import com.example.app_profile.Room.AppDatabase_foreign;
import com.example.app_profile.Room.User;
import com.example.app_profile.Room.User_foreign;

import java.util.ArrayList;


public class RecyclerAdapter_foreign extends RecyclerView.Adapter<RecyclerAdapter_foreign.MyViewHolder> {


    private ArrayList<User_foreign> userData = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memorecycler_itemview_foreign,parent,false);
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

    public void addItem(User_foreign user) {
        userData.add(user);
        notifyDataSetChanged();
    }

    public void addItems(ArrayList<User_foreign> users) {
        userData = users;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView key;
        private TextView title;
        private TextView description;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key_for);
            title = itemView.findViewById(R.id.memoTextView1_for);
            description = itemView.findViewById(R.id.memoTextView2_for);
        }

        public void onBind(User_foreign user, int position) {
            String s = "" + (position+1);
            key.setText(s);
            title.setText(user.getTitle());
            description.setText(user.getDes());

            itemView.setOnLongClickListener(v -> {
                userData.remove(user);
                AppDatabase_foreign.getInstance(itemView.getContext()).userDao().delete(user);

                notifyDataSetChanged();
                return false;
            });

            itemView.setOnClickListener(v -> {

                Intent intent = new Intent(itemView.getContext(), DetailActivity_foreign.class);
                intent.putExtra("data", user);
                itemView.getContext().startActivity(intent);

            });
        }
    }
}
