package com.example.app_profile.Room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Todo")
public class User_todo implements Parcelable {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_title")
    private String title;
    @ColumnInfo(name = "user_lec")
    private String lec;
    @ColumnInfo(name = "user_year")
    private int year;
    @ColumnInfo(name = "user_month")
    private int month;
    @ColumnInfo(name = "user_date")
    private int date;
    @ColumnInfo(name = "user_des")
    private String des;

    public User_todo(String title, String lec, int year, int month, int date, String des) {
        this.title = title;
        this.lec = lec;
        this.year = year;
        this.month = month;
        this.date = date;
        this.des = des;
    }

    protected User_todo(Parcel in) {
        id = in.readInt();
        title = in.readString();
        lec = in.readString();
        year = in.readInt();
        month = in.readInt();
        date = in.readInt();
        des = in.readString();
    }

    public static final Creator<User_todo> CREATOR = new Creator<User_todo>() {
        @Override
        public User_todo createFromParcel(Parcel in) {
            return new User_todo(in);
        }

        @Override
        public User_todo[] newArray(int size) {
            return new User_todo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLec() {
        return lec;
    }

    public void setLec(String lec) {
        this.lec = lec;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(lec);
        dest.writeInt(year);
        dest.writeInt(month);
        dest.writeInt(date);
        dest.writeString(des);
    }
}
