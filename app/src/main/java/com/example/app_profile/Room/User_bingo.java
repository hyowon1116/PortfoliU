package com.example.app_profile.Room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BingoCnt")
public class User_bingo implements Parcelable {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_tag")
    private String tag;



    public User_bingo(String tag) {
        this.tag = tag;

    }

    protected User_bingo(Parcel in) {
        id = in.readInt();
        tag = in.readString();
    }

    public static final Creator<User_bingo> CREATOR = new Creator<User_bingo>() {
        @Override
        public User_bingo createFromParcel(Parcel in) {
            return new User_bingo(in);
        }

        @Override
        public User_bingo[] newArray(int size) {
            return new User_bingo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }





    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(tag);


    }
}
