package com.example.app_profile.Room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Dday")
public class User_dday implements Parcelable {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_dday")
    private String title;
    @ColumnInfo(name = "user_date")
    private String date;



    public User_dday(String title, String date) {
        this.title = title;
        this.date = date;
    }

    protected User_dday(Parcel in) {
        id = in.readInt();
        title = in.readString();
        date = in.readString();

    }

    public static final Creator<User_dday> CREATOR = new Creator<User_dday>() {
        @Override
        public User_dday createFromParcel(Parcel in) {
            return new User_dday(in);
        }

        @Override
        public User_dday[] newArray(int size) {
            return new User_dday[size];
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(date);

    }
}
