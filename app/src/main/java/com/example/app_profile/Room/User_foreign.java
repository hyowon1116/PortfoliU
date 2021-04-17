package com.example.app_profile.Room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "memoTable_foreign")
public class User_foreign implements Parcelable {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_title")
    private String title;
    @ColumnInfo(name = "user_date")
    private String date;
    @ColumnInfo(name = "user_expire")
    private String exp;
    @ColumnInfo(name = "user_des")
    private String des;

    public User_foreign(String title, String date, String exp, String des) {
        this.title = title;
        this.date = date;
        this.exp = exp;
        this.des = des;
    }

    protected User_foreign(Parcel in) {
        id = in.readInt();
        title = in.readString();
        date = in.readString();
        exp = in.readString();
        des = in.readString();
    }

    public static final Creator<User_foreign> CREATOR = new Creator<User_foreign>() {
        @Override
        public User_foreign createFromParcel(Parcel in) {
            return new User_foreign(in);
        }

        @Override
        public User_foreign[] newArray(int size) {
            return new User_foreign[size];
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

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) { this.exp = exp; }

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
        dest.writeString(date);
        dest.writeString(exp);
        dest.writeString(des);
    }
}
