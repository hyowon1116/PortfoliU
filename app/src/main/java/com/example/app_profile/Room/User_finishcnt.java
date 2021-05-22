package com.example.app_profile.Room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Cnt")
public class User_finishcnt implements Parcelable {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_finish")
    private int title;




    public User_finishcnt(int title) {
        this.title = title;
    }

    protected User_finishcnt(Parcel in) {
        id = in.readInt();
        title = in.readInt();

    }

    public static final Creator<User_finishcnt> CREATOR = new Creator<User_finishcnt>() {
        @Override
        public User_finishcnt createFromParcel(Parcel in) {
            return new User_finishcnt(in);
        }

        @Override
        public User_finishcnt[] newArray(int size) {
            return new User_finishcnt[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeInt(title);


    }
}
