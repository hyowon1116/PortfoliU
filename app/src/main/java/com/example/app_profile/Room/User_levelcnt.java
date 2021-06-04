package com.example.app_profile.Room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LvCnt")
public class User_levelcnt implements Parcelable {

    //Room에서 자동으로 id를 할당
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_bingo")
    private int bingo;




    public User_levelcnt(int bingo) {
        this.bingo = bingo;
    }

    protected User_levelcnt(Parcel in) {
        id = in.readInt();
        bingo = in.readInt();

    }

    public static final Creator<User_levelcnt> CREATOR = new Creator<User_levelcnt>() {
        @Override
        public User_levelcnt createFromParcel(Parcel in) {
            return new User_levelcnt(in);
        }

        @Override
        public User_levelcnt[] newArray(int size) {
            return new User_levelcnt[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBingo() {
        return bingo;
    }

    public void setBingo(int bingo) {
        this.bingo = bingo;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeInt(bingo);


    }
}
