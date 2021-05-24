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
    @ColumnInfo(name = "user_dyear")
    private int dyear;
    @ColumnInfo(name = "user_dmonth")
    private int dmonth;
    @ColumnInfo(name = "user_ddate")
    private int ddate;




    public User_dday(int dyear, int dmonth, int ddate) {
        this.dyear = dyear;
        this.dmonth = dmonth;
        this.ddate = ddate;
    }

    protected User_dday(Parcel in) {
        id = in.readInt();
        dyear = in.readInt();
        dmonth = in.readInt();
        ddate = in.readInt();


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

    public int getDyear() {
        return dyear;
    }

    public void setDyear(int dyear) {
        this.dyear = dyear;
    }

    public int getDmonth() {
        return dmonth;
    }

    public void setDmonth(int dmonth) {
        this.dmonth = dmonth;
    }

    public int getDdate() {
        return ddate;
    }

    public void setDdate(int ddate) {
        this.ddate= ddate;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeInt(dyear);
        dest.writeInt(dmonth);
        dest.writeInt(ddate);


    }
}
