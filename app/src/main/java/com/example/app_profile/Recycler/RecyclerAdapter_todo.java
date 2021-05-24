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
import java.util.Calendar;


public class RecyclerAdapter_todo extends RecyclerView.Adapter<RecyclerAdapter_todo.MyViewHolder> {


    private ArrayList<User_todo> userData = new ArrayList<>();
    // Millisecond 형태의 하루(24 시간)
    private final int ONE_DAY = 24 * 60 * 60 * 1000;

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
        private TextView lec;
        private TextView date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key_to);
            title = itemView.findViewById(R.id.memoTextView1_to);
            lec = itemView.findViewById(R.id.memoTextView2_to);
            date = itemView.findViewById(R.id.memoTextView3_to);
        }

        public void onBind(User_todo user, int position) {
            String s = "" + (position+1);
            key.setText(s);
            title.setText(user.getTitle());
            lec.setText(user.getLec());
            date.setText(getDday(user.getYear(), user.getMonth(), user.getDate()));

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

    private String getDday(int mYear, int mMonthOfYear, int mDayOfMonth) {

        // D-day 설정
        final Calendar ddayCalendar = Calendar.getInstance();
        ddayCalendar.set(mYear, mMonthOfYear, mDayOfMonth);

        // D-day 를 구하기 위해 millisecond 으로 환산하여 d-day 에서 today 의 차를 구한다.
        final long dday = ddayCalendar.getTimeInMillis() / ONE_DAY;
        final long today = Calendar.getInstance().getTimeInMillis() / ONE_DAY;
        long result = dday - today;

        // 출력 시 d-day 에 맞게 표시
        String strFormat;
        if (result > 0) {
            strFormat = "D-%d";
        } else if (result == 0) {
            strFormat = "Today";
        } else {
            result *= -1;
            strFormat = "D+%d";
        }

        final String strCount = (String.format(strFormat, result));


        return strCount;
    }
}
